package de.SweetCode.SteamAPI.interfaces;

import de.SweetCode.SteamAPI.SteamAPI;
import de.SweetCode.SteamAPI.method.methods.*;

public class IEconService extends SteamInterface {

    public IEconService(SteamAPI steam) {
        super(steam, "IEconService");

        this.add(new FlushInventoryCache(this));
        this.add(new FlushAssetAppearanceCache(this));
        this.add(new FlushContextCache(this));
        this.add(new GetTradeHistory(this));
        this.add(new GetTradeOffers(this));
        this.add(new GetTradeOffer(this));
        this.add(new GetTradeOffersSummary(this));
        this.add(new DeclineTradeOffer(this));
        this.add(new CancelTradeOffer(this));

    }

}
