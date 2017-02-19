package de.SweetCode.SteamAPI.exceptions;

import de.SweetCode.SteamAPI.SteamHost;
import de.SweetCode.SteamAPI.SteamVersion;
import de.SweetCode.SteamAPI.method.SteamMethod;

public class SteamCombinationException extends RuntimeException {

    public SteamCombinationException(SteamMethod steamMethod, SteamHost host, SteamVersion version) {
        super(String.format(
            "The %s method DOES NOT support the host %s in combination with the version %s.",
                steamMethod.getName(),
                host.name(),
                version.getHumanReadable()
        ));
    }

}