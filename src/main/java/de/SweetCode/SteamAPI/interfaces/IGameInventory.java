package de.SweetCode.SteamAPI.interfaces;

import de.SweetCode.SteamAPI.SteamAPI;
import de.SweetCode.SteamAPI.method.methods.GetHistoryCommandDetails;
import de.SweetCode.SteamAPI.method.methods.GetUserHistory;
import de.SweetCode.SteamAPI.method.methods.HistoryExecuteCommands;

public class IGameInventory extends SteamInterface {

    public IGameInventory(SteamAPI steam) {
        super(steam, "IGameInventory");

        this.add(new GetHistoryCommandDetails(this));
        this.add(new GetUserHistory(this));
        this.add(new HistoryExecuteCommands(this));
    }

}
