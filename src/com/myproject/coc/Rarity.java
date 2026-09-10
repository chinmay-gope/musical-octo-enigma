package com.myproject.coc;

public enum Rarity {
    COMMON(18), EPIC(27);

    private final int maxLevel;

    Rarity(int maxLevel) {
        this.maxLevel = maxLevel;
    }

    public int maxLevel() {
        return maxLevel;
    }
}
