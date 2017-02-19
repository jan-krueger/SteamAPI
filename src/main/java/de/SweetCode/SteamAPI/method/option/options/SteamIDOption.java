package de.SweetCode.SteamAPI.method.option.options;

import de.SweetCode.SteamAPI.method.option.Option;
import de.SweetCode.SteamAPI.method.option.OptionTypes;

public class SteamIDOption extends Option {

    public SteamIDOption(boolean required) {
        super("steamid", null, OptionTypes.UINT_64, required, false);
    }

}
