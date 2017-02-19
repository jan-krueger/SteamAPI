package de.SweetCode.SteamAPI.exceptions;

/**
 * <p>
 *    Will be thrown if somebody provides null as version.
 * </p>
 */
public class SteamVersionNullException extends RuntimeException {

    public SteamVersionNullException() {
        super("The steam version cannot be null.");
    }

}
