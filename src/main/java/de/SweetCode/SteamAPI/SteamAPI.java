package de.SweetCode.SteamAPI;

import de.SweetCode.SteamAPI.interfaces.IPlayerService;

public class SteamAPI {

    public SteamAPI() {}

    public IPlayerService getPlayerService() {
        return new IPlayerService();
    }

}
