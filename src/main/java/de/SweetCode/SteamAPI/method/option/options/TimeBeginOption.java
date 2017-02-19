package de.SweetCode.SteamAPI.method.option.options;

import de.SweetCode.SteamAPI.method.option.Option;
import de.SweetCode.SteamAPI.method.option.OptionTypes;

public class TimeBeginOption extends Option {

    public TimeBeginOption(boolean required) {
        super("timebegin", "The beginning of the time range .", OptionTypes.UINT_32, required, false);
    }

}
