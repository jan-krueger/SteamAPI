package de.SweetCode.SteamAPI.interfaces;

import de.SweetCode.SteamAPI.method.methods.*;

public class ISteamApps extends SteamInterface {

    public ISteamApps() {
        super("ISteamApps");

        this.add(new GetAppBetas(this));
        this.add(new GetAppBuilds(this));
        this.add(new GetAppDepotVersions(this));
        this.add(new GetAppList(this));
        this.add(new ISteamAppsGetCheatingReports(this));
        this.add(new GetPlayersBanned(this));
        this.add(new GetServerList(this));
        this.add(new GetServersAtAddress(this));
        this.add(new SetAppBuildLive(this));
        this.add(new UpToDateCheck(this));
    }

}
