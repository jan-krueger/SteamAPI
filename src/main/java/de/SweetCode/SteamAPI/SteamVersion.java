package de.SweetCode.SteamAPI;

/**
 * <p>
 *    The steam API is divided into <b>interfaces</b>, <b>methods</b> and <b>versions</b>. - This class represents the
 *    abstract idea of the <b>Steam Interface</b>. A part of the Steam Web API is that methods which can be called can
 *    have various versions. This enum provides all of them, which allows the developer to specify which version of the
 *    method they wanna access.
 * </p>
 */
public enum SteamVersion {

    /**
     * <p>
     *    Representing the 'v1' version.
     * </p>
     */
    V_1("v1", "Version 1"),

    /**
     * <p>
     *    Representing the 'v2' version.
     * </p>
     */
    V_2("v2", "Version 2"),

    /**
     * <p>
     *    Representing the 'v3' version.
     * </p>
     */
    V_3("v3", "Version 3");

    private final String urlVersion;
    private final String humanReadable;

    /**
     * <p>
     *    A constructor to create a SteamVersion enum entry.
     * </p>
     *
     * @param urlVersion The edition of the version which can be used directly in the URL to access the API.
     * @param humanReadable The human readable edition of the version.
     */
    SteamVersion(String urlVersion, String humanReadable) {
        this.urlVersion = urlVersion;
        this.humanReadable = humanReadable;
    }

    /**
     * <p>
     *     Gives the value which can be used to create requests.
     * </p>
     *
     * @return Always a string, never null.
     */
    public String getUrlVersion() {
        return urlVersion;
    }

    /**
     * <p>
     *     Gives a human readable version of the version name. - The syntax of the string is: <i>Version {number}</i>.
     * </p>
     *
     * @return Always a string, never null.
     */
    public String getHumanReadable() {
        return humanReadable;
    }

}
