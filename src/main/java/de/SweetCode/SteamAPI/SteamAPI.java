package de.SweetCode.SteamAPI;

import de.SweetCode.SteamAPI.interfaces.ISteamNews;

public class SteamAPI {

    public SteamAPI() {}

    public ISteamNews getNews() {
        return new ISteamNews();
    }

}
