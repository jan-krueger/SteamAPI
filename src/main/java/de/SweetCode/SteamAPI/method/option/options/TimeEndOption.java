package de.SweetCode.SteamAPI.method.option.options;

import de.SweetCode.SteamAPI.method.option.Option;
import de.SweetCode.SteamAPI.method.option.OptionTypes;

public class TimeEndOption extends Option {

    public TimeEndOption(boolean required) {
        super("timeend", "The end of the time range .", OptionTypes.UINT_32, required, false);
    }

}
