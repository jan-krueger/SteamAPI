package de.SweetCode.SteamAPI.exceptions;

import de.SweetCode.SteamAPI.SteamVersion;
import de.SweetCode.SteamAPI.method.SteamMethod;
import org.apache.commons.lang3.StringUtils;

/**
 * <p>
 *    {@link SteamMethod Steam Methods} only support certain version, if an unsupported version of a method gets called
 *    this exception gets thrown.
 * </p>
 */
public class SteamUnsupportedVersionException extends RuntimeException {

    public SteamUnsupportedVersionException(SteamMethod steamMethod, SteamVersion steamVersion) {
        super(String.format(
                "The SteamMethod %s DOES NOT support the provided version %s. The method only supports: %s.",
                steamMethod.getName(),
                steamVersion.getHumanReadable(),
                StringUtils.join(steamMethod.getSupportedVersions(), ", ")
        ));
    }

}
