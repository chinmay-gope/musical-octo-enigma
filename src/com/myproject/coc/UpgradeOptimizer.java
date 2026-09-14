package com.myproject.coc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class UpgradeOptimizer {

    /*
     * Number of future upgrades to consider.
     */
    private static final int DEFAULT_LOOK_AHEAD = 5;
    /*
     * Number of possible states we keep at each level.
     *
     * Higher = more accurate
     * Lower  = faster
     */
    private static final int DEFAULT_BEAM_WIDTH = 25;

    private UpgradeOptimizer() {
    }

    public static UpgradePlan recommend(
            List<Equipment> equipment,
            OreInventory inventory,
            OreReserve reserve,
            UpgradePreference preference,
            int lookAhead,
            int beamWidth
    ) {

        validateInput(
                equipment,
                inventory,
                reserve,
                preference,
                lookAhead,
                beamWidth
        );

        /*
         * -----------------------------------------------------
         * Build initial state
         * -----------------------------------------------------
         */

        SearchState initialState =
                new SearchState(
                        equipment,
                        inventory,
                        0,
                        0,
                        new ArrayList<>()
                );

        /*
         * -----------------------------------------------------
         * Beam search
         * -----------------------------------------------------
         */

        List<SearchState> states =
                List.of(initialState);

        for (int depth = 0; depth < lookAhead; depth++) {

            List<SearchState> nextStates =
                    new ArrayList<>();

            for (SearchState state : states) {

                List<UpgradeCandidate> upgrades =
                        generateCandidates(
                                state,
                                reserve,
                                preference
                        );

                for (UpgradeCandidate candidate :
                        upgrades) {

                    SearchState next =
                            applyUpgrade(
                                    state,
                                    candidate
                            );

                    nextStates.add(next);
                }
            }

            if (nextStates.isEmpty()) {
                break;
            }

            /*
             * Keep only the strongest states.
             */
            nextStates.sort(
                    Comparator.comparingDouble(
                            SearchState::score
                    ).reversed()
            );

            states =
                    nextStates.stream()
                            .limit(beamWidth)
                            .toList();
        }

        /*
         * -----------------------------------------------------
         * Find best future sequence
         * -----------------------------------------------------
         */

        SearchState bestState =
                states.stream()
                        .max(
                                Comparator.comparingDouble(
                                        SearchState::score
                                )
                        )
                        .orElse(initialState);

        /*
         * The FIRST upgrade in the winning sequence
         * is our actual recommendation.
         */

        UpgradeCandidate bestUpgrade =
                bestState.upgrades().isEmpty()
                        ? null
                        : bestState.upgrades().getFirst();

        /*
         * -----------------------------------------------------
         * Generate immediate alternatives
         * -----------------------------------------------------
         */

        List<UpgradeCandidate> immediateCandidates =
                generateCandidates(
                        initialState,
                        reserve,
                        preference
                );

        immediateCandidates =
                immediateCandidates.stream()
                        .sorted(
                                Comparator.comparingDouble(
                                        UpgradeCandidate::score
                                ).reversed()
                        )
                        .toList();

        /*
         * -----------------------------------------------------
         * All candidates, including blocked
         * -----------------------------------------------------
         */

        List<UpgradeCandidate> allCandidates =
                generateAllCandidates(
                        initialState,
                        reserve,
                        preference
                );

        return new UpgradePlan(
                bestUpgrade,
                immediateCandidates,
                allCandidates,
                inventory,
                reserve,
                bestState.upgrades(),
                bestState.inventory(),
                bestState.score()
        );
    }


    /*
     * =========================================================
     * GENERATE CANDIDATES
     * =========================================================
     */

    private static List<UpgradeCandidate> generateCandidates(
            SearchState state,
            OreReserve reserve,
            UpgradePreference preference
    ) {

        List<UpgradeCandidate> candidates =
                new ArrayList<>();

        for (int index = 0;
             index < state.equipment().size();
             index++) {

            Equipment equipment =
                    state.equipment().get(index);

            if (equipment.isMaxed()) {
                continue;
            }

            UpgradeCost cost =
                    getUpgradeCost(equipment);

            /*
             * Check actual inventory.
             */
            if (!state.inventory().canAfford(cost)) {
                continue;
            }

            /*
             * Check reserve.
             */
            if (wouldBreakReserve(
                    state.inventory(),
                    reserve,
                    cost
            )) {
                continue;
            }

            double score =
                    calculateImmediateScore(
                            equipment,
                            cost,
                            state.inventory(),
                            preference
                    );

            /*
             * Opportunity cost.
             */
            score -= calculateOpportunityCost(
                    equipment,
                    cost,
                    state.equipment(),
                    state.inventory(),
                    reserve
            );

            candidates.add(
                    new UpgradeCandidate(
                            index,
                            equipment,
                            cost,
                            score,
                            true,
                            false,
                            "Affordable"
                    )
            );
        }

        return candidates;
    }


    /*
     * =========================================================
     * ALL CANDIDATES
     * =========================================================
     */

    private static List<UpgradeCandidate> generateAllCandidates(
            SearchState state,
            OreReserve reserve,
            UpgradePreference preference
    ) {

        List<UpgradeCandidate> result =
                new ArrayList<>();

        for (int index = 0;
             index < state.equipment().size();
             index++) {

            Equipment equipment =
                    state.equipment().get(index);

            if (equipment.isMaxed()) {

                result.add(
                        new UpgradeCandidate(
                                index,
                                equipment,
                                new UpgradeCost(0, 0, 0),
                                0,
                                false,
                                false,
                                "Already maxed"
                        )
                );

                continue;
            }

            UpgradeCost cost =
                    getUpgradeCost(equipment);

            boolean affordable =
                    state.inventory()
                            .canAfford(cost);

            boolean reserveViolation =
                    affordable
                            && wouldBreakReserve(
                            state.inventory(),
                            reserve,
                            cost
                    );

            if (!affordable) {

                result.add(
                        new UpgradeCandidate(
                                index,
                                equipment,
                                cost,
                                0,
                                false,
                                false,
                                buildUnaffordableReason(
                                        state.inventory(),
                                        cost
                                )
                        )
                );

                continue;
            }

            if (reserveViolation) {

                result.add(
                        new UpgradeCandidate(
                                index,
                                equipment,
                                cost,
                                0,
                                true,
                                true,
                                "Would break ore reserve"
                        )
                );

                continue;
            }

            double score =
                    calculateImmediateScore(
                            equipment,
                            cost,
                            state.inventory(),
                            preference
                    );

            result.add(
                    new UpgradeCandidate(
                            index,
                            equipment,
                            cost,
                            score,
                            true,
                            false,
                            "Available"
                    )
            );
        }

        return result;
    }


    /*
     * =========================================================
     * APPLY UPGRADE
     * =========================================================
     */

    private static SearchState applyUpgrade(
            SearchState state,
            UpgradeCandidate candidate
    ) {

        List<Equipment> newEquipment =
                new ArrayList<>(
                        state.equipment()
                );

        Equipment old =
                newEquipment.get(
                        candidate.equipmentIndex()
                );

        Equipment upgraded =
                new Equipment(
                        old.name(),
                        old.hero(),
                        old.rarity(),
                        old.currentLevel() + 1,
                        old.maxLevel(),
                        old.usageWeight(),
                        calculateNextLevelValue(old)
                );

        newEquipment.set(
                candidate.equipmentIndex(),
                upgraded
        );

        OreInventory newInventory =
                state.inventory()
                        .after(candidate.cost());

        List<UpgradeCandidate> upgrades =
                new ArrayList<>(
                        state.upgrades()
                );

        upgrades.add(candidate);

        /*
         * The candidate's score is accumulated.
         */
        double newScore =
                state.score()
                        + candidate.score();

        return new SearchState(
                newEquipment,
                newInventory,
                state.depth() + 1,
                newScore,
                upgrades
        );
    }


    /*
     * =========================================================
     * IMMEDIATE SCORE
     * =========================================================
     */

    private static double calculateImmediateScore(
            Equipment equipment,
            UpgradeCost cost,
            OreInventory inventory,
            UpgradePreference preference
    ) {

        /*
         * -----------------------------------------------------
         * Equipment value
         * -----------------------------------------------------
         */

        double score =
                equipment.strategicValue()
                        * preference.strategicImportance();

        /*
         * -----------------------------------------------------
         * Usage
         * -----------------------------------------------------
         */

        score +=
                equipment.usageWeight()
                        * preference.usageImportance();

        /*
         * -----------------------------------------------------
         * Upgrade strength
         * -----------------------------------------------------
         */

        score +=
                equipment.nextLevelValue()
                        * 2.0;

        /*
         * -----------------------------------------------------
         * Ore efficiency
         * -----------------------------------------------------
         */

        score +=
                oreEfficiency(
                        cost,
                        inventory
                );

        /*
         * -----------------------------------------------------
         * Breakpoint
         * -----------------------------------------------------
         */

        if (isImportantBreakpoint(equipment)) {
            score *= 1.25;
        }

        /*
         * -----------------------------------------------------
         * Epic bonus
         * -----------------------------------------------------
         */

        if (equipment.rarity() == Rarity.EPIC) {
            score *= 1.10;
        }

        /*
         * -----------------------------------------------------
         * Rare ore conservation
         * -----------------------------------------------------
         */

        score -= rarityPenalty(
                cost.starry(),
                inventory.starry(),
                preference.starryConservation()
        );

        score -= rarityPenalty(
                cost.glowy(),
                inventory.glowy(),
                preference.glowyConservation()
        );

        score -= rarityPenalty(
                cost.shiny(),
                inventory.shiny(),
                preference.shinyConservation()
        );

        return Math.max(
                0,
                score
        );
    }


    /*
     * =========================================================
     * OPPORTUNITY COST
     * =========================================================
     */

    private static double calculateOpportunityCost(
            Equipment selected,
            UpgradeCost selectedCost,
            List<Equipment> equipment,
            OreInventory inventory,
            OreReserve reserve
    ) {

        double opportunityCost = 0;

        for (Equipment other : equipment) {

            if (other == selected) {
                continue;
            }

            if (other.isMaxed()) {
                continue;
            }

            UpgradeCost otherCost =
                    getUpgradeCost(other);

            /*
             * If spending this ore prevents another
             * important upgrade, penalize it.
             */

            boolean selectedConsumesScarceOre =
                    selectedCost.starry() > 0
                            || selectedCost.glowy() > 0;

            boolean otherUsesScarceOre =
                    otherCost.starry() > 0
                            || otherCost.glowy() > 0;

            if (selectedConsumesScarceOre
                    && otherUsesScarceOre) {

                double otherValue =
                        other.strategicValue()
                                + other.usageWeight()
                                + other.nextLevelValue();

                opportunityCost +=
                        otherValue * 0.15;
            }
        }

        return opportunityCost;
    }


    /*
     * =========================================================
     * ORE EFFICIENCY
     * =========================================================
     */

    private static double oreEfficiency(
            UpgradeCost cost,
            OreInventory inventory
    ) {

        double shiny =
                resourceEfficiency(
                        cost.shiny(),
                        inventory.shiny()
                );

        double glowy =
                resourceEfficiency(
                        cost.glowy(),
                        inventory.glowy()
                );

        double starry =
                resourceEfficiency(
                        cost.starry(),
                        inventory.starry()
                );

        /*
         * Starry is rarest, so give it the
         * greatest influence.
         */

        return
                shiny * 10
                        + glowy * 25
                        + starry * 40;
    }


    private static double resourceEfficiency(
            int cost,
            int available
    ) {

        if (cost == 0) {
            return 1;
        }

        if (available <= 0) {
            return 0;
        }

        double consumed =
                (double) cost / available;

        return Math.max(
                0,
                1 - consumed
        );
    }


    /*
     * =========================================================
     * RARE ORE PENALTY
     * =========================================================
     */

    private static double rarityPenalty(
            int cost,
            int available,
            double conservationWeight
    ) {

        if (cost <= 0 || available <= 0) {
            return 0;
        }

        double percentage =
                (double) cost / available;

        return
                Math.pow(
                        percentage,
                        2
                )
                        * 100
                        * conservationWeight;
    }


    /*
     * =========================================================
     * RESERVE
     * =========================================================
     */

    private static boolean wouldBreakReserve(
            OreInventory inventory,
            OreReserve reserve,
            UpgradeCost cost
    ) {

        return
                inventory.shiny()
                        - cost.shiny()
                        < reserve.shiny()

                        ||

                        inventory.glowy()
                                - cost.glowy()
                                < reserve.glowy()

                        ||

                        inventory.starry()
                                - cost.starry()
                                < reserve.starry();
    }


    /*
     * =========================================================
     * BREAKPOINT
     * =========================================================
     */

    private static boolean isImportantBreakpoint(
            Equipment equipment
    ) {

        int nextLevel =
                equipment.currentLevel() + 1;

        return
                nextLevel % 5 == 0
                        || nextLevel == equipment.maxLevel();
    }


    /*
     * =========================================================
     * LEVEL VALUE
     * =========================================================
     */

    private static int calculateNextLevelValue(
            Equipment equipment
    ) {

        /*
         * Placeholder.
         *
         * In the real implementation this should come
         * from actual equipment stat data.
         */

        return Math.max(
                1,
                equipment.nextLevelValue()
        );
    }


    /*
     * =========================================================
     * COST TABLE
     * =========================================================
     *
     * IMPORTANT:
     *
     * Replace this with the real CoC equipment data.
     */

    private static UpgradeCost getUpgradeCost(
            Equipment equipment
    ) {

        int level =
                equipment.currentLevel();

        if (equipment.rarity()
                == Rarity.COMMON) {

            int shiny =
                    1000 + level * 500;

            int glowy =
                    level % 3 == 0
                            ? 100 + level * 25
                            : 0;

            return new UpgradeCost(
                    shiny,
                    glowy,
                    0
            );
        }

        /*
         * Epic
         */

        int shiny =
                1500 + level * 700;

        int glowy =
                150 + level * 50;

        int starry =
                level >= 10
                        ? 10 + level * 2
                        : 0;

        return new UpgradeCost(
                shiny,
                glowy,
                starry
        );
    }


    /*
     * =========================================================
     * REASON
     * =========================================================
     */

    private static String buildUnaffordableReason(
            OreInventory inventory,
            UpgradeCost cost
    ) {

        List<String> missing =
                new ArrayList<>();

        if (inventory.shiny() < cost.shiny()) {

            missing.add(
                    "Shiny missing: "
                            + (cost.shiny()
                            - inventory.shiny())
            );
        }

        if (inventory.glowy() < cost.glowy()) {

            missing.add(
                    "Glowy missing: "
                            + (cost.glowy()
                            - inventory.glowy())
            );
        }

        if (inventory.starry() < cost.starry()) {

            missing.add(
                    "Starry missing: "
                            + (cost.starry()
                            - inventory.starry())
            );
        }

        return String.join(
                ", ",
                missing
        );
    }


    /*
     * =========================================================
     * VALIDATION
     * =========================================================
     */

    private static void validateInput(
            List<Equipment> equipment,
            OreInventory inventory,
            OreReserve reserve,
            UpgradePreference preference,
            int lookAhead,
            int beamWidth
    ) {

        if (equipment == null
                || equipment.isEmpty()) {

            throw new IllegalArgumentException(
                    "Equipment list cannot be empty"
            );
        }

        if (inventory == null) {
            throw new IllegalArgumentException(
                    "Inventory cannot be null"
            );
        }

        if (reserve == null) {
            throw new IllegalArgumentException(
                    "Reserve cannot be null"
            );
        }

        if (preference == null) {
            throw new IllegalArgumentException(
                    "Preference cannot be null"
            );
        }

        if (lookAhead <= 0) {
            throw new IllegalArgumentException(
                    "Look-ahead must be > 0"
            );
        }

        if (beamWidth <= 0) {
            throw new IllegalArgumentException(
                    "Beam width must be > 0"
            );
        }
    }


    /*
     * =========================================================
     * INTERNAL SEARCH STATE
     * =========================================================
     */

    private record SearchState(
            List<Equipment> equipment,
            OreInventory inventory,
            int depth,
            double score,
            List<UpgradeCandidate> upgrades
    ) {
    }
}
