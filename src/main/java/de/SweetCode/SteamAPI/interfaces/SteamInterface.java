package de.SweetCode.SteamAPI.interfaces;

import de.SweetCode.SteamAPI.method.SteamMethod;

import java.util.List;

/**
 * <p>
 *    The steam API is divided into <b>interfaces</b>, <b>methods</b> and <b>versions</b>. - This class represents the
 *    abstract idea of the <b>Steam Interface</b>.
 * </p>
 */
public abstract class SteamInterface {

    private final String name;

    private final List<SteamMethod> steamMethods;

    /**
     * <p>
     *    A constructor to create a SteamInterface.
     * </p>
     *
     * @param name The name of the interface which can be directly used in URLs to access the API.
     * @param steamMethods A list of all related steam methods.
     */
    public SteamInterface(String name, List<SteamMethod> steamMethods) {
        this.name = name;
        this.steamMethods = steamMethods;
    }

    /**
     * <p>
     *    Gives the name of the interface which can be directly used in URLs to access the API.
     * </p>
     *
     * @return Always string, never null.
     */
    public String getName() {
        return this.name;
    }

    /**
     * <p>
     *    Gives a list of all related {@link SteamMethod methods.}
     * </p>
     *
     * @return A list of all supported methods. Is never null. Can be empty.
     */
    public List<SteamMethod> getSteamMethods() {
        return this.steamMethods;
    }

}
