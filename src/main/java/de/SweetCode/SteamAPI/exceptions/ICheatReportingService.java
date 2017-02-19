package de.SweetCode.SteamAPI.exceptions;

import de.SweetCode.SteamAPI.interfaces.SteamInterface;
import de.SweetCode.SteamAPI.method.methods.*;

public class ICheatReportingService extends SteamInterface {

    public ICheatReportingService() {
        super("ICheatReportingService");

        this.add(new ReportPlayerCheating(this));
        this.add(new RequestPlayerGameBan(this));
        this.add(new RemovePlayerGameBan(this));
        this.add(new GetCheatingReports(this));
        this.add(new RequestVacStatusForUser(this));
        this.add(new StartSecureMultiplayerSession(this));
    }

}
