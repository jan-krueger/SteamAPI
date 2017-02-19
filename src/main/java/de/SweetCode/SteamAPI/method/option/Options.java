package de.SweetCode.SteamAPI.method.option;

import de.SweetCode.SteamAPI.SteamVersion;
import de.SweetCode.SteamAPI.exceptions.SteamInvalidOptionTypeException;
import de.SweetCode.SteamAPI.exceptions.SteamMissingInputException;
import de.SweetCode.SteamAPI.method.SteamMethod;
import de.SweetCode.SteamAPI.method.input.Input;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Options {

    private final SteamVersion version;
    private final Map<String, Option> options = new TreeMap<>();

    /**
     * <p>
     *    Creates a new Options instance.
     * </p>
     *
     * @param version The version the options belong to.
     */
    public Options(SteamVersion version) {

        //@TODO Verify version
        assert !(version == null);

        this.version = version;
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
     *     Verifies if the input fits these Options.
     * </p>
     *
     * @param steamMethod The SteamMethod calling the verify function.
     * @param input The provided input.
     *
     * @return True, if the input fits, otherwise it throws exception.
     */
    public boolean verify(SteamMethod steamMethod, Input input) {

        //@TODO Verify input
        assert !(steamMethod == null);
        assert !(input == null);
        assert !(input.getValues().size() == this.options.size());

        Map<String, Object> data = input.getValues();

        for(Map.Entry<String, Option> e : this.options.entrySet()) {

            String key = e.getKey();
            Option option = e.getValue();

            //--- If the option is required & DOES NOT exist -> error
            if(option.isRequired() && !(data.containsKey(key))) {
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
     *    A builder pattern class to build easier Options.
     * </p>
     */
    public static class Builder {

        private SteamVersion version;
        private List<Option> collection = new ArrayList<>();

        public Builder() {}

        /**
         * <p>
         *     The version the options belong to.
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
         *    Builds a new instance of {@link Options} with all added {@link Option options}.
         * </p>
         *
         * @return a new instance of Options.
         */
        public Options build() {
            Options options = new Options(this.version);
            this.collection.forEach(options::add);
            return options;
        }

    }

}
