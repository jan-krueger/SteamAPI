package de.SweetCode.SteamAPI.interfaces;

import de.SweetCode.SteamAPI.SteamAPI;
import de.SweetCode.SteamAPI.method.methods.ReportAccountRecoveryData;
import de.SweetCode.SteamAPI.method.methods.RetrieveAccountRecoveryData;

public class IAccountRecoveryService extends SteamInterface {

    public IAccountRecoveryService(SteamAPI steam) {
        super(steam, "IAccountRecoveryService");

        this.add(new ReportAccountRecoveryData(this));
        this.add(new RetrieveAccountRecoveryData(this));
    }

}
