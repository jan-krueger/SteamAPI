package de.SweetCode.SteamAPI.interfaces;

import de.SweetCode.SteamAPI.SteamAPI;
import de.SweetCode.SteamAPI.method.methods.GetGameServerPlayerStatsForGame;

public class ISteamGameServerStats extends SteamInterface {

    public ISteamGameServerStats(SteamAPI steam) {
        super(steam, "ISteamGameServerStats");

        this.add(new GetGameServerPlayerStatsForGame(this));
    }

}
