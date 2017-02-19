package de.SweetCode.SteamAPI.exceptions;

import de.SweetCode.SteamAPI.method.SteamMethod;
import de.SweetCode.SteamAPI.method.option.Option;

public class SteamMissingInputException extends RuntimeException {

    public SteamMissingInputException(SteamMethod steamMethod, Option option) {
        super(String.format(
            "The method %s is missing a required input with the key %s and type of %s.",
                steamMethod.getName(),
                option.getKey(),
                option.getOptionType().getName()
        ));
    }

}
