package de.SweetCode.SteamAPI.exceptions;

import de.SweetCode.SteamAPI.SteamHost;
import de.SweetCode.SteamAPI.method.SteamMethod;
import org.apache.commons.lang3.StringUtils;

/**
 * <p>
 *    {@link SteamMethod Steam Methods} only support certain version, if an unsupported version of a method gets called
 *    this exception gets thrown.
 * </p>
 */
public class SteamUnsupportedHostException extends RuntimeException {

    public SteamUnsupportedHostException(SteamMethod steamMethod, SteamHost steamHost) {
        super(String.format(
                "The SteamMethod %s DOES NOT support the provided host %s. The method only supports: %s.",
                steamMethod.getName(),
                steamHost.name(),
                StringUtils.join(steamMethod.getSupportedHosts(), ", ")
        ));
    }

}
