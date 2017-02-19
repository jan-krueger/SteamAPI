package de.SweetCode.SteamAPI.method;

import de.SweetCode.SteamAPI.SteamHost;
import de.SweetCode.SteamAPI.SteamVersion;
import de.SweetCode.SteamAPI.exceptions.SteamCombinationException;
import de.SweetCode.SteamAPI.exceptions.SteamUnsupportedHostException;
import de.SweetCode.SteamAPI.exceptions.SteamUnsupportedVersionException;
import de.SweetCode.SteamAPI.exceptions.SteamVersionNullException;
import de.SweetCode.SteamAPI.interfaces.SteamInterface;
import de.SweetCode.SteamAPI.method.input.Input;
import de.SweetCode.SteamAPI.method.option.Options;
import de.SweetCode.SteamAPI.method.result.SteamMethodResult;

import java.util.*;

/**
 * <p>
 *    The steam API is divided into <b>interfaces</b>, <b>methods</b> and <b>versions</b>. - This class represents the
 *    abstract idea of the <b>Steam Method</b>.
 * </p>
 */
public abstract class SteamMethod {

    private SteamInterface steamInterface;

    private final String name;
    private final Map<SteamHost, List<Options>> options;

    /**
     * <p>
     *    A constructor to create a SteamMethod.
     * </p>
     *
     * @param steamInterface The SteamInterface the method belongs to.
     * @param name The name of the method which can be directly used in URLs to access the API.
     * @param options A list with all various option types the method supports.
     */
    public SteamMethod(SteamInterface steamInterface, String name, Map<SteamHost, List<Options>> options) {
        this.steamInterface = steamInterface;
        this.name = name;
        this.options = options;
    }

    /**
     * <p>
     *    Gives the name of the method which can be directly used in URLs to access the API.
     * </p>
     *
     * @return Always string, never null.
     */
    public String getName() {
        return this.name;
    }

    /**
     * <p>
     *     Gives the related {@link SteamInterface}.
     * </p>
     *
     * @return the interface, never null.
     */
    public SteamInterface getInterface() {
        return this.steamInterface;
    }

    /**
     * <p>
     *    Gives a set of all supported {@link SteamHost hosts}.
     * </p>
     *
     * @return A set of all supported hosts. Is never null.
     */
    public Set<SteamHost> getSupportedHosts() {
        return this.options.keySet();
    }

    /**
     * <p>
     *    Gives a set of all supported {@link SteamVersion versions}.
     * </p>
     *
     * @return A set of all supported versions. Is never null.
     */
    public Set<SteamVersion> getSupportedVersions() {
        HashSet<SteamVersion> versions = new HashSet<>();
        this.options.values().forEach(l -> l.forEach(e -> versions.add(e.getVersion())));
        return versions;
    }

    /**
     * <p>
     *    Gives a map of all supported {@link SteamHost hots} with their related required {@link Options}.
     * </p>
     *
     * @return A list of all supported hosts and their options. Is never null.
     */
    public Map<SteamHost, List<Options>> getOptions() {
        return this.options;
    }

    /**
     * <p>
     *     Gives the {@link Options} belonging to the provided configuration of host and version.
     * </p>
     *
     * @param host The host.
     * @param version The version.
     *
     * @return an Optional containing the Options if they exist for the provided configuration.
     */
    public Optional<Options> get(SteamHost host, SteamVersion version) {
        return this.options.get(host).stream().filter(e -> e.getVersion() == version).findAny();
    }

    /**
     * <p>
     *     Checks if the method supports the host.
     * </p>
     *
     * @param host The host to check.
     *
     * @return True, if the method supports the host, otherwise false.
     */
    public boolean supports(SteamHost host) {
        return this.options.keySet().contains(host);
    }

    /**
     * <p>
     *     Checks if the method supports the version.
     * </p>
     *
     * @param version The version to check.
     *
     * @return True, if the method supports the version, otherwise false.
     */
    public boolean supports(SteamVersion version) {
        return this.options.values().stream().anyMatch(e -> e.stream().anyMatch(x -> x.getVersion() == version));
    }

    /**
     * <p>
     *    Can be used to verify that the host & version are not null and that that both of them are supported by the method. -
     *    The method throws automatically a {@link RuntimeException} if one of the requirements is not met.
     * </p>
     *
     * @param host The host to check.
     * @param version The version to check.
     */
    protected void verify(SteamHost host, SteamVersion version) {

        //--- Check if
        if(host == null) {
            throw new SteamVersionNullException();
        }

        if(!(this.supports(host))) {
            throw new SteamUnsupportedHostException(this, host);
        }

        //--- Check version is not null & supported
        if(version == null) {
            throw new SteamVersionNullException();
        }

        if(!(this.supports(version))) {
            throw new SteamUnsupportedVersionException(this, version);
        }

        //--- Check if the method supports the HOST in combination with the version
        if(!(this.get(host, version).isPresent())) {
            throw new SteamCombinationException(this, host, version);
        }

    }

    /**
     * <p>
     *     Executes the method with the provided parameters.
     * </p>
     *
     * @param host The host used to perform the request.
     * @param version The version of the method.
     * @param input The required input.
     *
     * @return Never null. Gives the result of the execution.
     */
    public abstract SteamMethodResult execute(SteamHost host, SteamVersion version, Input input);

}
