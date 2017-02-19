package de.SweetCode.SteamAPI.method;

import de.SweetCode.SteamAPI.SteamHost;
import de.SweetCode.SteamAPI.SteamVersion;
import de.SweetCode.SteamAPI.exceptions.SteamCombinationException;
import de.SweetCode.SteamAPI.exceptions.SteamUnsupportedHostException;
import de.SweetCode.SteamAPI.exceptions.SteamUnsupportedVersionException;
import de.SweetCode.SteamAPI.exceptions.SteamVersionNullException;
import de.SweetCode.SteamAPI.interfaces.SteamInterface;
import de.SweetCode.SteamAPI.method.input.Input;
import de.SweetCode.SteamAPI.method.option.MethodVersion;
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
    private final List<MethodVersion> versions;

    /**
     * <p>
     *    A constructor to create a SteamMethod.
     * </p>
     *
     * @param steamInterface The SteamInterface the method belongs to.
     * @param name The name of the method which can be directly used in URLs to access the API.
     * @param versions A list with all various method versions the method supports.
     */
    public SteamMethod(SteamInterface steamInterface, String name, List<MethodVersion> versions) {
        this.steamInterface = steamInterface;
        this.name = name;
        this.versions = versions;
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
        HashSet<SteamHost> values = new HashSet<>();
        this.versions.forEach(e -> values.addAll(e.getHosts()));
        return values;
    }

    /**
     * <p>
     *    Gives a set of all supported {@link SteamVersion versions}.
     * </p>
     *
     * @return A set of all supported versions. Is never null.
     */
    public Set<SteamVersion> getSupportedVersions() {
        HashSet<SteamVersion> values = new HashSet<>();
        this.versions.forEach(e -> values.add(e.getVersion()));
        return values;
    }

    /**
     * <p>
     *    Gives a list of all supported {@link MethodVersion method versions}.
     * </p>
     *
     * @return a list of all supported method variations.
     */
    public List<MethodVersion> getVersions() {
        return this.versions;
    }

    /**
     * <p>
     *     Gives the {@link MethodVersion} belonging to the provided configuration of host and version.
     * </p>
     *
     * @param host The host.
     * @param version The version.
     *
     * @return an Optional containing the MethodVersion if they exist for the provided configuration.
     */
    public Optional<MethodVersion> get(SteamHost host, SteamVersion version) {
        return this.versions.stream().filter(e -> e.getHosts().contains(host) && e.getVersion() == version).findAny();
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
        return this.versions.stream().anyMatch(e -> e.getHosts().contains(host));
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
        return this.versions.stream().anyMatch(e -> e.getVersion() == version);
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
