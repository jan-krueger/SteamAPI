package de.SweetCode.SteamAPI.interfaces;

import de.SweetCode.SteamAPI.SteamAPI;
import de.SweetCode.SteamAPI.method.methods.ReportAbuse;

public class ISteamCommunity extends SteamInterface {

    public ISteamCommunity(SteamAPI steam) {
        super(steam, "ISteamCommunity");

        this.add(new ReportAbuse(this));
    }

}
