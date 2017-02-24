package de.SweetCode.SteamAPI.interfaces;

import de.SweetCode.SteamAPI.SteamAPI;
import de.SweetCode.SteamAPI.method.methods.GetServerInfo;
import de.SweetCode.SteamAPI.method.methods.GetSupportedAPIList;

public class ISteamWebAPIUtil extends SteamInterface {

    public ISteamWebAPIUtil(SteamAPI steam) {
        super(steam, "ISteamWebAPIUtil");

        this.add(new GetServerInfo(this));
        this.add(new GetSupportedAPIList(this));
    }

}
