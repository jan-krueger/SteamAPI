package de.SweetCode.SteamAPI.method.option.options;

import de.SweetCode.SteamAPI.method.option.Option;
import de.SweetCode.SteamAPI.method.option.OptionTypes;

public class KeyOption extends Option {

    public KeyOption(boolean required) {
        super("key", "The access key to authenticate", OptionTypes.STRING, required, true);
    }

}
