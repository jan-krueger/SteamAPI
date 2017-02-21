package de.SweetCode.SteamAPI.interfaces;

import de.SweetCode.SteamAPI.method.methods.GetCMList;

public class ISteamDirectory extends SteamInterface {

    public ISteamDirectory() {
        super("ISteamDirectory");

        this.add(new GetCMList(this));
    }

}
