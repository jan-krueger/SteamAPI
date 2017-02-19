package de.SweetCode.SteamAPI.method.option.options;

import de.SweetCode.SteamAPI.method.option.Option;
import de.SweetCode.SteamAPI.method.option.OptionTypes;

public class LimitOption extends Option {

    public LimitOption(boolean required) {
        super("limit", null, OptionTypes.UINT_32, required, false);
    }

}
