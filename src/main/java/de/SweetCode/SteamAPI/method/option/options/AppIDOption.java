package de.SweetCode.SteamAPI.method.option.options;

import de.SweetCode.SteamAPI.method.option.Option;
import de.SweetCode.SteamAPI.method.option.OptionTypes;

public class AppIDOption extends Option {

    public AppIDOption(boolean required) {
        super("appid", null, OptionTypes.UINT_32, required, false);
    }

}
