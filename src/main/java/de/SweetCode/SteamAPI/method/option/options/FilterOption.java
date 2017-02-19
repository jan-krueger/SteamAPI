package de.SweetCode.SteamAPI.method.option.options;

import de.SweetCode.SteamAPI.method.option.Option;
import de.SweetCode.SteamAPI.method.option.OptionTypes;

public class FilterOption extends Option {

    public FilterOption(boolean required) {
        super("filter", "Query filter string.", OptionTypes.STRING, required, false);
    }

}
