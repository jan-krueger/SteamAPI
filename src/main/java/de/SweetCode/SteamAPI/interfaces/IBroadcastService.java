package de.SweetCode.SteamAPI.interfaces;

import de.SweetCode.SteamAPI.SteamAPI;
import de.SweetCode.SteamAPI.method.methods.PostGameDataFrame;

public class IBroadcastService extends SteamInterface {

    public IBroadcastService(SteamAPI steam) {
        super(steam, "IBroadcastService");

        this.add(new PostGameDataFrame(this));
    }

}
