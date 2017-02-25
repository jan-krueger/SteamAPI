package de.SweetCode.SteamAPI.interfaces;

import de.SweetCode.SteamAPI.SteamAPI;
import de.SweetCode.SteamAPI.method.methods.AssociateWorkshopItems;
import de.SweetCode.SteamAPI.method.methods.GetContributors;

public class ISteamWorkshop extends SteamInterface {

    public ISteamWorkshop(SteamAPI steam) {
        super(steam, "ISteamWorkshop");

        this.add(new AssociateWorkshopItems(this));
        this.add(new GetContributors(this));
    }

}
