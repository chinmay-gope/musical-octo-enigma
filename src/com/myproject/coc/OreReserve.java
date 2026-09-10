package com.myproject.coc;

public record OreReserve(
        int shiny,
        int glowy,
        int starry
) {

    public OreReserve {
        if (shiny < 0 || glowy < 0 || starry < 0) {
            throw new IllegalArgumentException("Reserve cannot be negative");
        }
    }
}
