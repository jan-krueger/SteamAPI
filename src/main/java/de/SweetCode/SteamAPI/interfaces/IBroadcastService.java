package de.SweetCode.SteamAPI.interfaces;

import de.SweetCode.SteamAPI.method.methods.PostGameDataFrame;

public class IBroadcastService extends SteamInterface {

    public IBroadcastService() {
        super("IBroadcastService");

        this.add(new PostGameDataFrame(this));
    }

}
