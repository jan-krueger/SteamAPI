package de.SweetCode.SteamAPI.interfaces;

import de.SweetCode.SteamAPI.SteamAPI;
import de.SweetCode.SteamAPI.method.methods.*;

public class ISteamLeaderboards extends SteamInterface {

    public ISteamLeaderboards(SteamAPI steam) {
        super(steam, "ISteamLeaderboards");

        this.add(new DeleteLeaderboard(this));
        this.add(new FindOrCreateLeaderboard(this));
        this.add(new GetLeaderboardEntries(this));
        this.add(new GetLeaderboardsForGame(this));
        this.add(new ResetLeaderboard(this));
        this.add(new SetLeaderboardScore(this));
    }

}
