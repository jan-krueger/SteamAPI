package de.SweetCode.SteamAPI.interfaces;

import de.SweetCode.SteamAPI.SteamAPI;
import de.SweetCode.SteamAPI.method.SteamMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *    The steam API is divided into <b>interfaces</b>, <b>methods</b> and <b>versions</b>. - This class represents the
 *    abstract idea of the <b>Steam Interface</b>.
 * </p>
 */
public abstract class SteamInterface {

    private final SteamAPI steam;
    private final String name;

    private final Map<Class<? extends SteamMethod>, SteamMethod> steamMethods = new HashMap<>();

    /**
     * <p>
     *    A constructor to create a SteamInterface.
     * </p>
     *
     * @param steam The instance of the Steam API the interface belongs to.
     * @param name The name of the interface which can be directly used in URLs to access the API.
     */
    public SteamInterface(SteamAPI steam, String name) {

        //@TODO Verify input
        assert !(steam == null);
        assert !(name == null);

        this.steam = steam;
        this.name = name;
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
     *    Gives the Steam API instance this interface belongs to.
     * </p>
     *
     * @return The Steam API instance, never null.
     */
    public SteamAPI getSteam() {
        return this.steam;
    }

    /**
     * <p>
     *    Gives a list of all related {@link SteamMethod methods.}
     * </p>
     *
     * @return A list of all supported methods. Is never null. Can be empty.
     */
    public Map<Class<? extends SteamMethod>, SteamMethod> getMethods() {
        return this.steamMethods;
    }

    /**
     * <p>
     *    Gives a method according to the provided class IF the method belongs to this interface.
     * </p>
     *
     * @param method The method to search for.
     * @param <T> the Steam Method type
     *
     * @return The SteamMethod instance.
     */
    public <T extends SteamMethod> T get(Class<T> method) {
        //TODO Verify input
        assert !(method == null);
        assert this.steamMethods.containsKey(method);

        return (T) this.steamMethods.get(method);
    }

    /**
     * <p>
     *    Adds a method to the interface.
     * </p>
     *
     * @param method The method to add.
     */
    public void add(SteamMethod method) {
        //@TODO Verify input
        assert !(method == null);
        assert !(this.steamMethods.containsKey(method.getClass()));

        this.steamMethods.put(method.getClass(), method);
    }

}
