package de.SweetCode.SteamAPI.interfaces;

import de.SweetCode.SteamAPI.SteamAPI;
import de.SweetCode.SteamAPI.method.methods.*;

public class ISteamUser extends SteamInterface {

    public ISteamUser(SteamAPI steam) {
        super(steam, "ISteamUser");

        this.add(new CheckAppOwnership(this));
        this.add(new GetAppPriceInfo(this));
        this.add(new GetFriendList(this));
        this.add(new GetPlayerBans(this));
        this.add(new GetPlayerSummaries(this));
        this.add(new GetPublisherAppOwnership(this));
        this.add(new GetUserGroupList(this));
        this.add(new GrantPackage(this));
        this.add(new ResolveVanityURL(this));
    }

}
