package de.SweetCode.SteamAPI.interfaces;

import de.SweetCode.SteamAPI.SteamAPI;
import de.SweetCode.SteamAPI.method.methods.AuthenticateUser;
import de.SweetCode.SteamAPI.method.methods.AuthenticateUserTicket;

public class ISteamUserAuth extends SteamInterface {

    public ISteamUserAuth(SteamAPI steam) {
        super(steam, "ISteamUserAuth");

        this.add(new AuthenticateUser(this));
        this.add(new AuthenticateUserTicket(this));
    }

}
