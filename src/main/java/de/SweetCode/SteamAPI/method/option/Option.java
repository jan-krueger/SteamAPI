package de.SweetCode.SteamAPI.method.option;

import de.SweetCode.SteamAPI.method.SteamMethod;

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

    /**
     * <p>
     *     Constructor to create a option.
     * </p>
     *
     * @param key The unique key of the option.
     * @param description The description of the option, can be null.
     * @param optionType The type of the option.
     * @param required If the option is required or not.
     */
    public Option(String key, String description, OptionType optionType, boolean required) {
        this.key = key;
        this.description = Optional.ofNullable(description);
        this.optionType = optionType;
        this.required = required;
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
     *    A builder pattern class to build easier a Option.
     * </p>
     */
    public static class Builder {

        private String key;
        private String description;

        private OptionType optionType;
        private boolean isRequired;

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
         *    Builds a new instance of {@link Option} with all provided values.
         * </p>
         *
         * @return the new instance of the option, never null.
         */
        public Option build() {
            return new Option(this.key, this.description, this.optionType, this.isRequired);
        }

    }

}
