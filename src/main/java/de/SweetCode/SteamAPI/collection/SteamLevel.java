package de.SweetCode.SteamAPI.collection;

public class SteamLevel {

    private final int level;
    private final int xp;
    private final int xpToLevelUp;
    private final int xpCurrentLevel;

    public SteamLevel(int level, int xp, int xpToLevelUp, int xpCurrentLevel) {
        this.level = level;
        this.xp = xp;
        this.xpToLevelUp = xpToLevelUp;
        this.xpCurrentLevel = xpCurrentLevel;
    }

    public int getLevel() {
        return this.level;
    }

    public int getXp() {
        return this.xp;
    }

    public int getXpCurrentLevel() {
        return this.xpCurrentLevel;
    }

    public int getXpToLevelUp() {
        return this.xpToLevelUp;
    }

}
