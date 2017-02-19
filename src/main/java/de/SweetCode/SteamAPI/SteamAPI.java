package de.SweetCode.SteamAPI;

import de.SweetCode.SteamAPI.interfaces.ISteamApps;

public class SteamAPI {

    public SteamAPI() {}

    public ISteamApps getISteamApps() {
        return new ISteamApps();
    }

}
