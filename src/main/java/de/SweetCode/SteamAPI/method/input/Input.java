package de.SweetCode.SteamAPI.method.input;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *    This class keeps just the data which will be passed to the Steam API.
 * </p>
 */
public class Input {

    public Map<String, Object> values = new HashMap<>();

    public Input() {}

    /**
     * <p>
     *    Adds a new value to the input.
     * </p>
     *
     * @param key The key of the input.
     * @param value The value of the input.
     */
    public <T> void add(String key, T value) {
        this.values.put(key, value);
    }

    /**
     * <p>
     *    All currently stored values.
     * </p>
     *
     * @return A map of inputs, never null, can be empty if no values have been added.
     */
    public Map<String, Object> getValues() {
        return this.values;
    }

    /**
     * <p>
     *    Checks if the input contains a specific key.
     * </p>
     *
     * @param key The key to check.
     * @return True, if the input contains the key, ohterwise false.
     */
    public boolean contains(String key) {
        return this.values.containsKey(key);
    }

    /**
     * <p>
     *    Creates an instance of an empty Input.
     * </p>
     *
     * @return The empty Input instance.
     */
    public static Input empty() {
        return Input.create().build();
    }

    public static Builder create() {
        return new Builder();
    }

    public static class Builder {

        public Map<String, Object> values = new HashMap<>();

        public Builder() {}

        public <T> Builder add(String key, T value) {
            this.values.put(key, value);
            return this;
        }

        public Input build() {
            Input input = new Input();
            this.values.forEach(input::add);
            return input;
        }

    }
}
