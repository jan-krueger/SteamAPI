package de.SweetCode.SteamAPI.interfaces;

import de.SweetCode.SteamAPI.SteamAPI;
import de.SweetCode.SteamAPI.method.methods.*;

public class IPlayerService extends SteamInterface {

    public IPlayerService(SteamAPI steam) {
        super(steam, "IPlayerService");

        this.add(new RecordOfflinePlaytime(this));
        this.add(new GetRecentlyPlayedGames(this));
        this.add(new GetOwnedGames(this));
        this.add(new GetSteamLevel(this));
        this.add(new GetBadges(this));
        this.add(new GetCommunityBadgeProgress(this));
        this.add(new IsPlayingSharedGame(this));
    }

}
