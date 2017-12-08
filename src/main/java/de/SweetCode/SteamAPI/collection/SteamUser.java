package de.SweetCode.SteamAPI.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SteamUser {

    private final long steamid;

    private final List<SteamBadge> steamBadges;
    private final SteamLevel steamLevel;
    private final SteamUserAvatar avatar;

    private final int communityVisibilityState;
    private final int profileState;
    private final long lastLogOff;


    public SteamUser(long steamid, int communityVisibilityState, int profileState, long lastLogOff, List<SteamBadge> steamBadges,
                     SteamLevel steamLevel, SteamUserAvatar avatar) {
        this.steamid = steamid;
        this.steamBadges = steamBadges;
        this.steamLevel = steamLevel;
        this.avatar = avatar;
        this.communityVisibilityState = communityVisibilityState;
        this.profileState = profileState;
        this.lastLogOff = lastLogOff;
    }

    public long getSteamID() {
        return this.steamid;
    }

    public  List<SteamBadge> getSteamBadges() {
        return this.steamBadges;
    }

    public SteamLevel getSteamLevel() {
        return this.steamLevel;
    }

    public SteamUserAvatar getAvatar() {
        return this.avatar;
    }

    public int getCommunityVisibilityState() {
        return this.communityVisibilityState;
    }

    public int getProfileState() {
        return this.profileState;
    }

    public long getLastLogOff() {
        return this.lastLogOff;
    }

    public static Builder builder(long steamid) {
        return new Builder(steamid);
    }

    public static class Builder {

        private final long steamid;

        private SteamUserAvatar avatar = new SteamUserAvatar(null, null, null);
        private List<SteamBadge> steamBadges = new ArrayList<>();

        private int communityVisibilityState = -1;
        private int profileState = -1;
        private long lastLogOff = -1;

        private int steamLevel = -1;
        private int xp = -1;
        private int xpToLevelUp = -1;
        private int xpCurrentLevel = -1;

        public Builder(long steamid) {
            this.steamid = steamid;
        }

        public Builder steamLevel(int steamLevel) {
            this.steamLevel = steamLevel;
            return this;
        }

        public Builder xp(int xp) {
            this.xp = xp;
            return this;
        }

        public Builder xpToLevelUp(int xpToLevelUp) {
            this.xpToLevelUp = xpToLevelUp;
            return this;
        }

        public Builder xpCurrentLevel(int xpCurrentLevel) {
            this.xpCurrentLevel = xpCurrentLevel;
            return this;
        }

        public Builder communityVisibilityState(int communityVisibilityState) {
            this.communityVisibilityState = communityVisibilityState;
            return this;
        }

        public Builder profileState(int profileState) {
            this.profileState = profileState;
            return this;
        }

        public Builder lastLogOff(long lastLogOff) {
            this.lastLogOff = lastLogOff;
            return this;
        }

        public Builder avatar(SteamUserAvatar avatar) {
            this.avatar = avatar;
            return this;
        }

        public Builder addBadge(SteamBadge badge) {
            this.steamBadges.add(badge);
            return this;
        }

        public SteamUser build() {
            return new SteamUser(
                this.steamid,
                this.communityVisibilityState,
                this.profileState,
                this.lastLogOff,
                Collections.unmodifiableList(this.steamBadges),
                new SteamLevel(this.steamLevel, this.xp, this.xpToLevelUp, this.xpCurrentLevel),
                this.avatar
            );
        }

    }

}
