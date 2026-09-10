package com.myproject.coc;

public record Equipment(
        String name,
        Hero hero,
        Rarity rarity,
        int currentLevel,
        double usageWeight,
        double strategicValue,
        int nextLevelValue
) {

    public int maxLevel() {
        return rarity.maxLevel();
    }

    public boolean isMaxed() {
        return currentLevel >= maxLevel();
    }

    public boolean canUpgrade() {
        return currentLevel < maxLevel();
    }
}
