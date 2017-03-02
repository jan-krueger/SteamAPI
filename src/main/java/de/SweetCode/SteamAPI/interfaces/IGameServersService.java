package de.SweetCode.SteamAPI.interfaces;

import de.SweetCode.SteamAPI.SteamAPI;
import de.SweetCode.SteamAPI.method.methods.*;

public class IGameServersService extends SteamInterface {

    public IGameServersService(SteamAPI steam) {

        super(steam, "IGameServersService");

        this.add(new GetAccountList(this));
        this.add(new CreateAccount(this));
        this.add(new SetMemo(this));
        this.add(new ResetLoginToken(this));
        this.add(new DeleteAccount(this));
        this.add(new GetAccountPublicInfo(this));
        this.add(new QueryLoginToken(this));
        this.add(new SetBanStatus(this));
        this.add(new GetServerSteamIDsByIP(this));
        this.add(new GetServerIPsBySteamID(this));

    }

}
