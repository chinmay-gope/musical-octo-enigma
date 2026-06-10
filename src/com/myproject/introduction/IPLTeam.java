package com.myproject.introduction;

public class IPLTeam {
    static String color = "yellow";

    String playerName;
    int jerseyNo;

    void playerInfo(String playerName, int jerseyNo) {
        System.out.printf("playerName: %s, JerseyNo: %s%n", playerName, jerseyNo);
    }

    void main() {
        IPLTeam csk = new IPLTeam();

        playerName   = "MSD";
        jerseyNo = 7;

        csk.playerInfo("Ritu Raj", 1);
        csk.playerInfo("Sanju Samson", 2);
        csk.playerInfo("Kuldeep", 3);
        csk.playerInfo(playerName, jerseyNo);

        System.out.println("Team Color: " + color);

    }
}
