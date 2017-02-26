package de.SweetCode.SteamAPI.interfaces;

import de.SweetCode.SteamAPI.SteamAPI;
import de.SweetCode.SteamAPI.method.methods.CancelAppListingsForUser;
import de.SweetCode.SteamAPI.method.methods.GetAssetID;
import de.SweetCode.SteamAPI.method.methods.GetMarketEligibility;
import de.SweetCode.SteamAPI.method.methods.GetPopular;

public class IEconMarketService extends SteamInterface {

    public IEconMarketService(SteamAPI steam) {
        super(steam, "IEconMarketService");

        this.add(new GetMarketEligibility(this));
        this.add(new CancelAppListingsForUser(this));
        this.add(new GetAssetID(this));
        this.add(new GetPopular(this));

    }

}
