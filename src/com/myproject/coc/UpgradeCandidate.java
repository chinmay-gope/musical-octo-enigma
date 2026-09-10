package com.myproject.coc;

public record UpgradeCandidate(
        int equipmentIndex,
        Equipment equipment,
        UpgradeCost cost,
        double score,
        boolean affordable,
        boolean blockedByReserve,
        String reason
) {

    public int nextLevel() {
        return equipment.currentLevel() + 1;
    }
}
