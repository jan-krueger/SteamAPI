package de.SweetCode.SteamAPI.interfaces;

import de.SweetCode.SteamAPI.SteamAPI;
import de.SweetCode.SteamAPI.method.methods.CheckUserStatus;
import de.SweetCode.SteamAPI.method.methods.SetUserFinished;

public class ISteamSpecialSurvey extends SteamInterface {

    public ISteamSpecialSurvey(SteamAPI steam) {

        super(steam, "ISteamSpecialSurvey");

        this.add(new CheckUserStatus(this));
        this.add(new SetUserFinished(this));

    }

}
