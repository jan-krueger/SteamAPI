package de.SweetCode.SteamAPI.interfaces;

import de.SweetCode.SteamAPI.SteamAPI;
import de.SweetCode.SteamAPI.method.methods.PollStatus;

public class ISteamWebUserPresenceOAuth extends SteamInterface {

    public ISteamWebUserPresenceOAuth(SteamAPI steam) {
        super(steam, "ISteamWebUserPresenceOAuth");

        this.add(new PollStatus(this));
    }

}
