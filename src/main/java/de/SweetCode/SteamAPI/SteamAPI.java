package de.SweetCode.SteamAPI;

import de.SweetCode.SteamAPI.interfaces.ISteamUserStats;

public class SteamAPI {

    public SteamAPI() {}

    public ISteamUserStats getISteamUserStats() {
        return new ISteamUserStats();
    }

}
