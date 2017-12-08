package de.SweetCode.SteamAPI.collection;

public class SteamBadge {

    private final int id;

    private final int level;
    private final long completionTime;
    private final int xp;
    private final int scarcity;

    public SteamBadge(int id, int level, long completionTime, int xp, int scarcity) {
        this.id = id;
        this.level = level;
        this.completionTime = completionTime;
        this.xp = xp;
        this.scarcity = scarcity;
    }

    public int getId() {
        return this.id;
    }

    public int getLevel() {
        return this.level;
    }

    public long getCompletionTime() {
        return this.completionTime;
    }

    public int getXp() {
        return this.xp;
    }

    public int getScarcity() {
        return this.scarcity;
    }

    public static Builder builder(int badgeid) {
        return new Builder(badgeid);
    }

    public static class Builder {

        private final int badgeid;

        private int level;
        private long completionTime;
        private int xp;
        private int scarcity;

        public Builder(int badgeid) {
            this.badgeid = badgeid;
        }

        public Builder level(int level) {
            this.level = level;
            return this;
        }

        public Builder completionTime(long completionTime) {
            this.completionTime = completionTime;
            return this;
        }

        public Builder xp(int xp) {
            this.xp = xp;
            return this;
        }

        public Builder scarcity(int scarcity) {
            this.scarcity = scarcity;
            return this;
        }

        public SteamBadge build() {
            return new SteamBadge(this.badgeid, this.level, this.completionTime, this.xp, this.scarcity);
        }

    }

}
