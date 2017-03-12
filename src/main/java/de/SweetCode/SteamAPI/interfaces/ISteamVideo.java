package de.SweetCode.SteamAPI.interfaces;

import de.SweetCode.SteamAPI.SteamAPI;
import de.SweetCode.SteamAPI.method.methods.AddVideo;

public class ISteamVideo extends SteamInterface {

    public ISteamVideo(SteamAPI steam) {

        super(steam, "ISteamVideo");

        this.add(new AddVideo(this));

    }

}
