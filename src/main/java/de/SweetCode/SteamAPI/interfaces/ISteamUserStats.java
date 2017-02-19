package de.SweetCode.SteamAPI.interfaces;

import de.SweetCode.SteamAPI.method.methods.GetGlobalAchievementPercentagesForApp;

public class ISteamUserStats extends SteamInterface {

    public ISteamUserStats() {
        super("ISteamUserStats");
        this.add(new GetGlobalAchievementPercentagesForApp(this));
    }


}
