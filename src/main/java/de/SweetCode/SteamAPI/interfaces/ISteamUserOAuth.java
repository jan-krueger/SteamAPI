package de.SweetCode.SteamAPI.interfaces;

import de.SweetCode.SteamAPI.SteamAPI;
import de.SweetCode.SteamAPI.method.methods.GetTokenDetails;

public class ISteamUserOAuth extends SteamInterface {

    public ISteamUserOAuth(SteamAPI steam) {
        super(steam, "ISteamUserOAuth");

        this.add(new GetTokenDetails(this));
    }

}
