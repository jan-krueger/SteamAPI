package de.SweetCode.SteamAPI.exceptions;

import de.SweetCode.SteamAPI.method.SteamMethod;
import de.SweetCode.SteamAPI.method.option.Option;

public class SteamDependencyException extends RuntimeException {

    public SteamDependencyException(SteamMethod method, Option depending, String dependencyKey) {
        super(String.format(
                "The method %s is missing a dependency input, because if %s is given you also have to provde %s in the" +
                        " input.",
                method.getName(),
                depending.getKey(),
                dependencyKey
        ));
    }

}
