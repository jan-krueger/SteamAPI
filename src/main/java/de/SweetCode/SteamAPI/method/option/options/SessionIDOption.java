package de.SweetCode.SteamAPI.method.option.options;

import de.SweetCode.SteamAPI.method.option.Option;
import de.SweetCode.SteamAPI.method.option.OptionTypes;

public class SessionIDOption extends Option {

    public SessionIDOption(boolean required) {
        super("session_id", "The session id.", OptionTypes.UINT_64, required, false);
    }

}
