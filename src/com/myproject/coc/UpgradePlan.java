package com.myproject.coc;

import java.util.List;

public record UpgradePlan(

        UpgradeCandidate bestUpgrade,

        List<UpgradeCandidate> immediateAlternatives,

        List<UpgradeCandidate> allCandidates,

        OreInventory startingInventory,

        OreReserve reserve,

        List<UpgradeCandidate> futureSequence,

        OreInventory inventoryAfterPlan,

        double futurePlanScore

) {

    public boolean hasRecommendation() {
        return bestUpgrade != null;
    }

    public List<UpgradeCandidate> topThree() {

        return immediateAlternatives.stream()
                .limit(3)
                .toList();
    }
}
