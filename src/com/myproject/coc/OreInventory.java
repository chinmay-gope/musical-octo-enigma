package com.myproject.coc;

public record OreInventory(
        int shiny,
        int glowy,
        int starry
) {

    public OreInventory {
        if (shiny < 0 || glowy < 0 || starry < 0) {
            throw new IllegalArgumentException("Ore cannot be negative");
        }
    }

    public boolean canAfford(UpgradeCost cost) {

        return shiny >= cost.shiny()
                && glowy >= cost.glowy()
                && starry >= cost.starry();
    }

    public OreInventory after(UpgradeCost cost) {

        return new OreInventory(
                shiny - cost.shiny(),
                glowy - cost.glowy(),
                starry - cost.starry()
        );
    }
}
