package de.SweetCode.SteamAPI.collection;

public class SteamUserAvatar {

    private final String avatar;
    private final String medium;
    private final String full;

    public SteamUserAvatar(String avatar, String medium, String full) {
        this.avatar = avatar;
        this.medium = medium;
        this.full = full;
    }

    public String get(Size size) {

        switch (size) {

            case DEFAULT: return this.avatar;
            case MEDIUM: return this.medium;
            case FULL: return this.full;

        }

        return null;

    }

    public static Builder builder() {
        return new Builder();
    }

    public enum Size {

        DEFAULT,
        MEDIUM,
        FULL

    }

    public static class Builder {

        private String avatar;
        private String medium;
        private String full;

        public Builder() {}

        public Builder avatar(String avatar) {
            this.avatar = avatar;
            return this;
        }

        public Builder medium(String medium) {
            this.medium = medium;
            return this;
        }

        public Builder full(String full) {
            this.full = full;
            return this;
        }

        public SteamUserAvatar build() {
            return new SteamUserAvatar(this.avatar, this.medium, this.full);
        }

    }

}
