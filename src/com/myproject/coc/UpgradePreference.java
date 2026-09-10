package com.myproject.coc;

public record UpgradePreference(

        /*
         * How important is preserving rare ore?
         */
        double starryConservation,

        /*
         * How important is preserving Glowy Ore?
         */
        double glowyConservation,

        /*
         * How important is preserving Shiny Ore?
         */
        double shinyConservation,

        /*
         * Extra priority for equipment you actively use.
         */
        double usageImportance,

        /*
         * Extra priority for strategic equipment.
         */
        double strategicImportance
) {

    public static UpgradePreference balanced() {

        return new UpgradePreference(
                2.0,
                1.5,
                0.5,
                1.5,
                1.5
        );
    }

    public static UpgradePreference saveRareOre() {

        return new UpgradePreference(
                4.0,
                3.0,
                0.5,
                1.5,
                1.5
        );
    }

    public static UpgradePreference aggressive() {

        return new UpgradePreference(
                0.5,
                0.5,
                0.1,
                2.5,
                2.5
        );
    }
}
