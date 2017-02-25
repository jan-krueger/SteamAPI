package de.SweetCode.SteamAPI.method;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import de.SweetCode.SteamAPI.SteamHTTPMethod;
import de.SweetCode.SteamAPI.SteamHost;
import de.SweetCode.SteamAPI.SteamVersion;
import de.SweetCode.SteamAPI.SteamVisibility;
import de.SweetCode.SteamAPI.method.input.Input;
import okhttp3.Request;
import okhttp3.Response;

import java.util.Optional;

public interface SteamResponse {

    /**
     * <p>
     *    Called within {@link SteamMethod#execute(SteamHTTPMethod, SteamHost, SteamVersion, SteamVisibility, Input, SteamResponse, boolean)} to
     *    return the response from the Steam API.
     * </p>
     *
     * @param request The original request send to Steam's web server.
     * @param response The original response we received.
     * @param body The parsed body, if possible.
     */
    void onResponse(Request request, Response response, Optional<JsonObject> body);

    /**
     * <p>
     *     Called when something bad happened with the request.
     * </p>
     * <ul>
     *    <li>Invalid input.</li>
     * </ul>
     *
     * @param message The message describing the onError.
     */
    void onError(String message);

}
