package de.SweetCode.SteamAPI.method.option;

import de.SweetCode.SteamAPI.method.SteamMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 *    {@link SteamMethod Metods} require you to provide data along with your calls to them. This class represents
 *    these options.
 * </p>
 */
public class Option {

    private final String key;
    private final Optional<String> description;

    private final OptionType optionType;
    private final boolean required;
    private final boolean partnerRequired;

    private final List<String> dependencies;

    /**
     * <p>
     *     Constructor to create an option with dependencies.
     * </p>
     *
     * @param key The unique key of the option.
     * @param dependencies The keys of the options this option is depending on.
     * @param description The description of the option, can be null.
     * @param optionType The type of the option.
     * @param required If the option is required or not.
     * @param partnerRequired If the option is required if the {@link de.SweetCode.SteamAPI.SteamHost#PARTNER} is used.
     */
    public Option(String key, List<String> dependencies, String description, OptionType optionType, boolean required, boolean partnerRequired) {

        //@TODO Verify input
        assert !(key == null);
        assert !(dependencies == null);
        assert !(optionType == null);

        this.key = key;
        this.dependencies = dependencies;
        this.description = Optional.ofNullable(description);
        this.optionType = optionType;
        this.required = required;
        this.partnerRequired = partnerRequired;
    }

    /**
     * <p>
     *     Constructor to create an option without dependencies.
     * </p>
     *
     * @param key The unique key of the option.
     * @param description The description of the option, can be null.
     * @param optionType The type of the option.
     * @param required If the option is required or not.
     * @param partnerRequired If the option is required if the {@link de.SweetCode.SteamAPI.SteamHost#PARTNER} is used.
     */
    public Option(String key, String description, OptionType optionType, boolean required, boolean partnerRequired) {
        this(key, new ArrayList<String>(), description, optionType, required, partnerRequired);
    }

    /**
     * <p>
     *     The key of the option.
     * </p>
     *
     * @return the key of the option, never null.
     */
    public String getKey() {
        return this.key;
    }

    /**
     * <p>
     *     A list of keys describing dependencies between options.
     * </p>
     *
     * @return
     */
    public List<String> getDependencies() {
        return this.dependencies;
    }

    /**
     * <p>
     *     The description of the option.
     * </p>
     *
     * @return the description, if one is available, otherwise {@link Optional#empty()}.
     */
    public Optional<String> getDescription() {
        return this.description;
    }

    /**
     * <p>
     *     The type of the option.
     * </p>
     *
     * @return the option type, never null.
     */
    public OptionType getOptionType() {
        return this.optionType;
    }

    /**
     * <p>
     *     If the option is required or not.
     * </p>
     *
     * @return true, if the option is required, otherwise false.
     */
    public boolean isRequired() {
        return this.required;
    }

    /**
     * <p>
     *    If the option is required if it is in the {@link de.SweetCode.SteamAPI.SteamHost#PARTNER} mode.
     * </p>
     *
     * @return true, if required in PARTNER mode, ohterwise false.
     */
    public boolean isPartnerRequired() {
        return this.partnerRequired;
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
     *    A builder pattern class to buildRequest easier a Option.
     * </p>
     */
    public static class Builder {

        private String key = null;
        private String description = null;

        private OptionType optionType = null;
        private boolean isRequired = false;
        private boolean isPartnerRequired = false;

        private final List<String> dependencies = new ArrayList<>();

        public Builder() {}

        /**
         * <p>
         *     Sets the key of the option.
         * </p>
         *
         * @param key The key of the option.
         *
         * @return the current builder instance.
         */
        public Builder key(String key) {
            this.key = key;
            return this;
        }

        /**
         * <p>
         *    Adds a key dependency to the option.
         * </p>
         *
         * @param key They key of the option dependency.
         *
         * @return the current builder instance.
         */
        public Builder addDependecy(String key) {
            this.dependencies.add(key);
            return this;
        }

        /**
         * <p>
         *     Sets the description of the option.
         * </p>
         *
         * @param description The description of the option.
         *
         * @return the current builder instance.
         */
        public Builder description(String description) {
            this.description = description;
            return this;
        }

        /**
         * <p>
         *     Sets the key of the option.
         * </p>
         *
         * @param optionType The optionType of the option.
         *
         * @return the current builder instance.
         */
        public Builder optionType(OptionType optionType) {
            this.optionType = optionType;
            return this;
        }

        /**
         * <p>
         *     Sets if the option is required.
         * </p>
         *
         * @param isRequired If the option is required or not.
         *
         * @return the current builder instance.
         */
        public Builder isRequired(boolean isRequired) {
            this.isRequired = isRequired;
            return this;
        }

        /**
         * <p>
         *     Sets if the option is required in {@link de.SweetCode.SteamAPI.SteamHost#PARTNER} mode.
         * </p>
         *
         * @param isPartnerRequired If the option is required in PARTNER mode.
         *
         * @return the current builder instance.
         */
        public Builder isPartnerRequired(boolean isPartnerRequired) {
            this.isPartnerRequired = isPartnerRequired;
            return this;
        }

        /**
         * <p>
         *    Builds a new instance of {@link Option} with all provided values.
         * </p>
         *
         * @return the new instance of the option, never null.
         */
        public Option build() {
            return new Option(this.key, this.dependencies, this.description, this.optionType, this.isRequired, this.isPartnerRequired);
        }

    }

}
