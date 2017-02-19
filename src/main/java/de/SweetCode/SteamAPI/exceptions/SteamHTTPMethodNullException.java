package de.SweetCode.SteamAPI.exceptions;

/**
 * <p>
 *    Will be thrown if somebody provides null as HTTP request method.
 * </p>
 */
public class SteamHTTPMethodNullException extends RuntimeException {

    public SteamHTTPMethodNullException() {
        super("The HTTP request method cannot be null.");
    }

}
