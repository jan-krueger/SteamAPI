package de.SweetCode.SteamAPI.exceptions;

import de.SweetCode.SteamAPI.method.SteamMethod;
import de.SweetCode.SteamAPI.method.option.Option;

public class SteamInvalidOptionTypeException extends RuntimeException {

    public SteamInvalidOptionTypeException(SteamMethod steamMethod, Option option, Object value) {
        super(String.format(
            "The method %s expected a %s for the key %s. The value %s doesn't fit the OptionType.",
                steamMethod.getName(),
                option.getOptionType().getName(),
                option.getKey(),
                String.valueOf(value)
        ));
    }

}
