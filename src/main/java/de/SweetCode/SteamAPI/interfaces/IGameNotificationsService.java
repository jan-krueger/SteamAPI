package de.SweetCode.SteamAPI.interfaces;

import de.SweetCode.SteamAPI.SteamAPI;
import de.SweetCode.SteamAPI.method.methods.*;

public class IGameNotificationsService extends SteamInterface {

    public IGameNotificationsService(SteamAPI steam) {
        super(steam, "IGameNotificationsService");

        this.add(new CreateSession(this));
        this.add(new UpdateSession(this));
        this.add(new EnumerateSessionsForApp(this));
        this.add(new GetSessionDetailsForApp(this));
        this.add(new RequestNotifications(this));
        this.add(new DeleteSession(this));
        this.add(new DeleteSessionBatch(this));

    }

}
