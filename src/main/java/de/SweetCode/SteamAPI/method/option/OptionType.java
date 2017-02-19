package de.SweetCode.SteamAPI.method.option;

public interface OptionType<T> {

    /**
     * <p>
     *    The name of the option type.
     * </p>
     *
     * @return The name, never null.
     */
    String getName();

    /**
     * <p>
     *    Check if the provided value fits into the required data type.
     * </p>
     *
     * @param value The value to check.
     *
     * @return True, if the value fits into the required data type, otherwise false.
     */
    boolean check(Object value);

    /**
     * <p>
     *    Parses the provided value without checking its type. The method {@link OptionType#check(Object)} should be called
     *    and checked if it returns true for the value before calling this method.
     * </p>
     *
     * @param value The value to parse.
     *
     * @return Returns the parsed value.
     */
    T parse(Object value);

}
