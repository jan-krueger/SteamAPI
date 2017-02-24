package de.SweetCode.SteamAPI.interfaces;

import de.SweetCode.SteamAPI.SteamAPI;
import de.SweetCode.SteamAPI.method.methods.SetClientFilters;
import de.SweetCode.SteamAPI.method.methods.SetPerformanceStats;

public class ISteamCDN extends SteamInterface {

    public ISteamCDN(SteamAPI steam) {
        super(steam, "ISteamCDN");

        this.add(new SetClientFilters(this));
        this.add(new SetPerformanceStats(this));
    }

}
