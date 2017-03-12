package de.SweetCode.SteamAPI.interfaces;

import de.SweetCode.SteamAPI.SteamAPI;
import de.SweetCode.SteamAPI.method.methods.*;

public class ISteamRemoteStorage extends SteamInterface {

    public ISteamRemoteStorage(SteamAPI steam) {

        super(steam, "ISteamRemoteStorage");

        this.add(new EnumerateUserPublishedFiles(this));
        this.add(new EnumerateUserSubscribedFiles(this));
        this.add(new GetCollectionDetails(this));
        this.add(new GetPublishedFileDetails(this));
        this.add(new GetUGCFileDetails(this));
        this.add(new SetUGCUsedByGC(this));
        this.add(new SubscribePublishedFile(this));
        this.add(new UnsubscribePublishedFile(this));

    }

}
