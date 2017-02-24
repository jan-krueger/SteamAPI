package de.SweetCode.SteamAPI.interfaces;

import de.SweetCode.SteamAPI.SteamAPI;
import de.SweetCode.SteamAPI.method.methods.GetCMList;

public class ISteamDirectory extends SteamInterface {

    public ISteamDirectory(SteamAPI steam) {
        super(steam, "ISteamDirectory");

        this.add(new GetCMList(this));
    }

}
