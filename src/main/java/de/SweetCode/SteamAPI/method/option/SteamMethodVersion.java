package de.SweetCode.SteamAPI.method.option;

import de.SweetCode.SteamAPI.SteamHTTPMethod;
import de.SweetCode.SteamAPI.SteamHost;
import de.SweetCode.SteamAPI.SteamVersion;
import de.SweetCode.SteamAPI.exceptions.SteamInvalidOptionTypeException;
import de.SweetCode.SteamAPI.exceptions.SteamMissingInputException;
import de.SweetCode.SteamAPI.method.SteamMethod;
import de.SweetCode.SteamAPI.method.input.Input;

import java.util.*;

/**
 * <p>
 *    A {@link SteamMethod} can have various versions supporting different {@link Option Options}, {@link SteamVersion Steam Versions}
 *    and/or {@link SteamHost Steam Hosts}.
 * </p>
 */
public class SteamMethodVersion {

    private final SteamHTTPMethod httpMethod;

    private final List<SteamHost> hosts;
    private final SteamVersion version;

    private final Map<String, Option> options = new TreeMap<>();

    /**
     * <p>
     *    Creates a new SteamMethodVersion instance.
     * </p>
     *
     * @param method The supported HTTP request method.
     * @param hosts All supported hosts.
     * @param version The version the options belong to.
     */
    public SteamMethodVersion(SteamHTTPMethod method, List<SteamHost> hosts, SteamVersion version) {

        //@TODO Verify version
        assert !(method == null);
        assert !(hosts == null);
        assert !(hosts.isEmpty());
        assert !(version == null);

        this.httpMethod = method;
        this.hosts = hosts;
        this.version = version;
    }

    /**
     * <p>
     *    The supported HTTP request method.
     * </p>
     *
     * @return the supported HTTP request method, never null.
     */
    public SteamHTTPMethod getMethod() {
        return this.httpMethod;
    }

    /**
     * <p>
     *     All supported hosts.
     * </p>
     *
     * @return a list of supported hosts.
     */
    public List<SteamHost> getHosts() {
        return this.hosts;
    }

    /**
     * <p>
     *     The version these options belong to.
     * </p>
     *
     * @return the version, never null.
     */
    public SteamVersion getVersion() {
        return this.version;
    }

    /**
     * <p>
     *    Gives the option related to the key.
     * </p>
     *
     * @param key The key of the option.
     *
     * @return the related option, never null.
     */
    public Option get(String key) {

        //@TODO Verify input
        assert !(key == null);
        assert this.options.containsKey(key);

        return this.options.get(key);

    }

    /**
     * <p>
     *    Adds a option if the option does not exist yet.
     * </p>
     *
     * @param option The option to add.
     */
    public void add(Option option) {

        //@TODO Verify input
        assert !(option == null);
        assert !(this.options.containsKey(option.getKey()));

        this.options.put(option.getKey(), option);

    }

    /**
     * <p>
     *     Verifies if the input fits these SteamMethodVersion.
     * </p>
     *
     * @param steamMethod The SteamMethod calling the verify function.
     * @param input The provided input.
     *
     * @return True, if the input fits, otherwise it throws exception.
     */
    public boolean verify(SteamMethod steamMethod, SteamHost host, Input input) {

        //@TODO Verify input
        assert !(steamMethod == null);
        assert !(input == null);
        assert !(input.getValues().size() == this.options.size());

        Map<String, Object> data = input.getValues();

        for(Map.Entry<String, Option> e : this.options.entrySet()) {

            String key = e.getKey();
            Option option = e.getValue();

            //--- If the option is required & DOES NOT exist -> error
            if(
                (option.isRequired() || (host == SteamHost.PARTNER && option.isPartnerRequired()))
                && !(data.containsKey(key))
            ) {
                throw new SteamMissingInputException(steamMethod, option);
            }

            //--- If the key does exist in the input & the value is of the wrong type -> error
            if(data.containsKey(key) && !(option.getOptionType().check(data.get(key)))) {
                throw new SteamInvalidOptionTypeException(steamMethod, option, data.get(key));
            }

        }

        return false;

    }

    /**
     *  <p>
     *     Creates a new instance of {@link Builder}.
     *  </p>
     *
     * @return the builder instance.
     */
    public static Builder create() {
        return new Builder();
    }

    /**
     * <p>
     *    A builder pattern class to build easier SteamMethodVersion.
     * </p>
     */
    public static class Builder {

        private SteamHTTPMethod method = null;

        private List<SteamHost> hosts = null;
        private SteamVersion version = null;

        private List<Option> collection = new ArrayList<>();

        public Builder() {}

        /**
         * <p>
         *    The supported HTTP request method.
         * </p>
         *
         * @param method The request method.
         *
         * @return the current builder instance.
         */
        public Builder method(SteamHTTPMethod method) {
            this.method = method;
            return this;
        }

        /**
         * <p>
         *     The host the SteamMethodVersion belong to.
         * </p>
         *
         * @param hosts An array of supported hosts.
         *
         * @return the current builder instance.
         */
        public Builder hosts(SteamHost... hosts) {
            this.hosts = Arrays.asList(hosts);
            return this;
        }

        /**
         * <p>
         *     The version the SteamMethodVersion belong to.
         * </p>
         *
         * @param version The option.
         *
         * @return the current builder instance.
         */
        public Builder version(SteamVersion version) {
            this.version = version;
            return this;
        }

        /**
         * <p>
         *    Adds the provided Option.
         * </p>
         *
         * @param option The option to add.
         *
         * @return the current builder instance.
         */
        public Builder add(Option option) {
            this.collection.add(option);
            return this;
        }

        /**
         * <p>
         *    Builds a new instance of {@link SteamMethodVersion} with all added {@link Option options}.
         * </p>
         *
         * @return a new instance of SteamMethodVersion.
         */
        public SteamMethodVersion build() {
            SteamMethodVersion steamMethodVersion = new SteamMethodVersion(this.method, this.hosts, this.version);
            this.collection.forEach(steamMethodVersion::add);
            return steamMethodVersion;
        }

    }

}
