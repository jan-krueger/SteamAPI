package de.SweetCode.SteamAPI.exceptions;

import de.SweetCode.SteamAPI.SteamHTTPMethod;
import de.SweetCode.SteamAPI.method.SteamMethod;
import org.apache.commons.lang3.StringUtils;

/**
 * <p>
 *    {@link SteamMethod Steam Methods} only support certain HTTP request methods, if an unsupported method gets called
 *    this exception gets thrown.
 * </p>
 */
public class SteamUnsupportedHTTPMethodException extends RuntimeException {

    public SteamUnsupportedHTTPMethodException(SteamMethod steamMethod, SteamHTTPMethod method) {
        super(String.format(
                "The SteamMethod %s DOES NOT support the provided HTTP request method %s. The method only supports: %s.",
                steamMethod.getName(),
                method.name(),
                StringUtils.join(steamMethod.getSupportedMethods(), ", ")
        ));
    }

}
