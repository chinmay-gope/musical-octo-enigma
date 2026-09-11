package com.myproject.coc;

import java.util.List;

public class Main {

    static void main() {

        /*
         * ==============================================
         * YOUR REAL ORE INVENTORY
         * ==============================================
         */

        OreInventory inventory = new OreInventory(48097, 3822, 33);

        /*
         * ==============================================
         * ORE RESERVE
         * ==============================================
         *
         * Keep some rare ore untouched.
         *
         */

        OreReserve reserve = new OreReserve(5000, 1000, 0);

        /*
         * ==============================================
         * YOUR REAL EQUIPMENT
         * ==============================================
         *
         * Levels taken from my coc account.
         *
         */

        List<Equipment> equipment = List.of(

                // ==========================
                // BARBARIAN KING
                // ==========================

                new Equipment("Giant Gauntlet", Hero.BARBARIAN_KING, Rarity.EPIC, 15, 1.00, 10.0, 10),

                new Equipment("Rage Vial", Hero.BARBARIAN_KING, Rarity.COMMON, 18, 0.90, 8.5, 8),

                // ==========================
                // ARCHER QUEEN
                // ==========================

                new Equipment("Healer Puppet", Hero.ARCHER_QUEEN, Rarity.COMMON, 21, 0.70, 7.5, 7),

                new Equipment("Frozen Arrow", Hero.ARCHER_QUEEN, Rarity.EPIC, 10, 1.00, 9.5, 10),

                // ==========================
                // GRAND WARDEN
                // ==========================

                new Equipment("Eternal Tome", Hero.GRAND_WARDEN, Rarity.EPIC, 17, 1.00, 10.0, 10),

                /*
                 * The second Grand Warden equipment is level 8
                 * in the screenshot.
                 *
                 * Name can be corrected once we identify the icon.
                 */
                new Equipment("Grand Warden Equipment 2", Hero.GRAND_WARDEN, Rarity.EPIC, 8, 0.60, 7.0, 8),

                // ==========================
                // ROYAL CHAMPION
                // ==========================

                new Equipment("Royal Gem", Hero.ROYAL_CHAMPION, Rarity.COMMON, 21, 0.70, 7.5, 7),

                new Equipment("Royal Champion Equipment 2", Hero.ROYAL_CHAMPION, Rarity.EPIC, 8, 0.60, 7.0, 8),

                // ==========================
                // MINION PRINCE
                // ==========================

                new Equipment("Minion Prince Equipment 1", Hero.MINION_PRINCE, Rarity.EPIC, 8, 0.60, 7.0, 8),

                new Equipment("Minion Prince Equipment 2", Hero.MINION_PRINCE, Rarity.COMMON, 23, 0.60, 7.0, 7));

        /*
         * ==============================================
         * UPGRADE STRATEGY
         * ==============================================
         */

        UpgradePreference preference = UpgradePreference.saveRareOre();

        /*
         * ==============================================
         * RUN OPTIMIZER
         * ==============================================
         *
         * Look ahead 5 upgrades.
         * Beam width = 25 possible upgrade paths.
         */

        UpgradePlan plan = UpgradeOptimizer.recommend(equipment, inventory, reserve, preference, 5, 25);

        /*
         * ==============================================
         * RESULT
         * ==============================================
         */

        System.out.println();
        System.out.println("==============================================");
        System.out.println("       COC EQUIPMENT UPGRADE OPTIMIZER");
        System.out.println("==============================================");

        System.out.println();

        System.out.println("YOUR ORE:");
        System.out.println("----------------------------------------------");
        System.out.println("Shiny : " + inventory.shiny());
        System.out.println("Glowy : " + inventory.glowy());
        System.out.println("Starry: " + inventory.starry());

        System.out.println();

        System.out.println("==============================================");
        System.out.println("BEST NEXT UPGRADE");
        System.out.println("==============================================");

        if (!plan.hasRecommendation()) {

            System.out.println("No upgrade is currently possible.");

        } else {

            UpgradeCandidate best = plan.bestUpgrade();

            System.out.println("Equipment : " + best.equipment().name());

            System.out.println("Hero      : " + best.equipment().hero());

            System.out.println("Level     : " + best.equipment().currentLevel() + " -> " + best.nextLevel());

            System.out.println("Cost      : " + best.cost());

            System.out.println("Score     : " + String.format("%.2f", best.score()));

            System.out.println("Reason    : " + best.reason());
        }

        /*
         * ==============================================
         * TOP 3 IMMEDIATE OPTIONS
         * ==============================================
         */

        System.out.println();

        System.out.println("==============================================");
        System.out.println("TOP 3 NEXT-UPGRADE OPTIONS");
        System.out.println("==============================================");

        int rank = 1;

        for (UpgradeCandidate candidate : plan.topThree()) {

            System.out.println();

            System.out.println("#" + rank + " " + candidate.equipment().name());

            System.out.println("Hero  : " + candidate.equipment().hero());

            System.out.println("Level : " + candidate.equipment().currentLevel() + " -> " + candidate.nextLevel());

            System.out.println("Cost  : " + candidate.cost());

            System.out.println("Score : " + String.format("%.2f", candidate.score()));

            System.out.println("Why   : " + candidate.reason());

            rank++;
        }

        /*
         * ==============================================
         * OPTIMIZED 5-UPGRADE SEQUENCE
         * ==============================================
         */

        System.out.println();

        System.out.println("==============================================");
        System.out.println("OPTIMIZED 5-UPGRADE SEQUENCE");
        System.out.println("==============================================");

        int step = 1;

        for (UpgradeCandidate candidate : plan.futureSequence()) {

            System.out.println();

            System.out.println("Step " + step);

            System.out.println("  " + candidate.equipment().name());

            System.out.println("  Hero: " + candidate.equipment().hero());

            System.out.println("  Level: " + candidate.equipment().currentLevel() + " -> " + candidate.nextLevel());

            System.out.println("  Cost: " + candidate.cost());

            System.out.println("  Score: " + String.format("%.2f", candidate.score()));

            step++;
        }

        /*
         * ==============================================
         * ORE AFTER THE PLAN
         * ==============================================
         */

        System.out.println();

        System.out.println("==============================================");
        System.out.println("ORE AFTER OPTIMIZED PLAN");
        System.out.println("==============================================");

        OreInventory after = plan.inventoryAfterPlan();

        System.out.println("Shiny : " + after.shiny());

        System.out.println("Glowy : " + after.glowy());

        System.out.println("Starry: " + after.starry());

        /*
         * ==============================================
         * SCORE
         * ==============================================
         */

        System.out.println();

        System.out.println("Future Plan Score: " + String.format("%.2f", plan.futurePlanScore()));

        /*
         * ==============================================
         * BLOCKED / UNAFFORDABLE UPGRADES
         * ==============================================
         */

        System.out.println();

        System.out.println("==============================================");
        System.out.println("BLOCKED / UNAFFORDABLE UPGRADES");
        System.out.println("==============================================");

        for (UpgradeCandidate candidate : plan.allCandidates()) {

            if (!candidate.affordable() || candidate.blockedByReserve() || !candidate.equipment().canUpgrade()) {

                System.out.println();

                System.out.println(candidate.equipment().name());

                System.out.println("Level : " + candidate.equipment().currentLevel() + " -> " + candidate.nextLevel());

                System.out.println("Reason: " + candidate.reason());
            }
        }

        System.out.println();
        System.out.println("==============================================");
    }
}
