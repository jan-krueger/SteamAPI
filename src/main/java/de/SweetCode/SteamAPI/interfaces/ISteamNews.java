package de.SweetCode.SteamAPI.interfaces;

import de.SweetCode.SteamAPI.SteamAPI;
import de.SweetCode.SteamAPI.method.methods.GetNewsForApp;
import de.SweetCode.SteamAPI.method.methods.GetNewsForAppAuthed;

public class ISteamNews extends SteamInterface {

    public ISteamNews(SteamAPI steam) {
        super(steam, "ISteamNews");

        this.add(new GetNewsForApp(this));
        this.add(new GetNewsForAppAuthed(this));
    }

}
