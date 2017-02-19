package de.SweetCode.SteamAPI.method.input;

import java.util.HashMap;
import java.util.Map;

public class Input {

    public Map<String, Object> values = new HashMap<>();

    public Input() {}

    public <T> void add(String key, T value) {
        this.values.put(key, value);
    }

    public Map<String, Object> getValues() {
        return this.values;
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
