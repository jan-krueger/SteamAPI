package de.SweetCode.SteamAPI.interfaces;

import de.SweetCode.SteamAPI.method.methods.GetGameServerPlayerStatsForGame;

public class ISteamGameServerStats extends SteamInterface {

    public ISteamGameServerStats() {
        super("ISteamGameServerStats");

        this.add(new GetGameServerPlayerStatsForGame(this));
    }

}
