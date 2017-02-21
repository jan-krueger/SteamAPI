package de.SweetCode.SteamAPI.interfaces;

import de.SweetCode.SteamAPI.method.methods.ReportAbuse;

public class ISteamCommunity extends SteamInterface {

    public ISteamCommunity() {
        super("ISteamCommunity");

        this.add(new ReportAbuse(this));
    }

}
