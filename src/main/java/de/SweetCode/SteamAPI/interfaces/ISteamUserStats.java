package de.SweetCode.SteamAPI.interfaces;

import de.SweetCode.SteamAPI.method.methods.GetGlobalAchievementPercentagesForApp;

import java.util.Arrays;

public class ISteamUserStats extends SteamInterface {

    public ISteamUserStats() {
        super("ISteamUserStats", Arrays.asList(
                new GetGlobalAchievementPercentagesForApp()
        ));
    }


}
