package de.SweetCode.SteamAPI;

/**
 * <p>
 *    Steam offers to different hosts to access their API.
 * </p>
 * <ul>
 *     <li>
 *         PUBLIC (api.steampowered.com) can be accessed either through HTTP or HTTPS since this API strictly enforces
 *         HTTPS should this not make a difference to you, however
 *     </li>
 *     <li>
 *         PARTNER (partner.steam-api.com) is a host only for Steam partners. It has a higher availability, it is not
 *         cached and you always need your partner API key, even for requests that normally do not require you to provide
 *         a key.
 *     </li>
 * </ul>
 */
public enum SteamHost {

    /**
     * <p>
     *    The host to access the public API (api.steampowered.com).
     * </p>
     */
    PUBLIC("api.steampowered.com"),

    /**
     * <p>
     *    The host to access the partner API (partner.steam-api.com).
     * </p>
     */
    PARTNER("partner.steam-api.com");

    private final String host;

    /**
     * <p>
     *    A constructor for a SteamHost enum.
     * </p>
     *
     * @param host The host as string without any protocol related information.
     */
    SteamHost(String host) {
        this.host = host;
    }

    /**
     * <p>
     *    Gives the according host.
     * </p>
     *
     * @return Always a string without any protocol related information, never null.
     */
    public String getHost() {
        return host;
    }
}
