package de.SweetCode.SteamAPI.exceptions;

/**
 * <p>
 *    Will be thrown if somebody provides null as host.
 * </p>
 */
public class SteamHostNullException extends RuntimeException {

    public SteamHostNullException() {
        super("The steam host cannot be null.");
    }

}
