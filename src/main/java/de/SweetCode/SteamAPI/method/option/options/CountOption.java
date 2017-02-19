package de.SweetCode.SteamAPI.method.option.options;

import de.SweetCode.SteamAPI.method.option.Option;
import de.SweetCode.SteamAPI.method.option.OptionTypes;

public class CountOption extends Option {

    public CountOption(boolean required) {
        super("count", null, OptionTypes.UINT_32, required, false);
    }

}

