package de.SweetCode.SteamAPI;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import de.SweetCode.SteamAPI.collection.SteamBadge;
import de.SweetCode.SteamAPI.collection.SteamUser;
import de.SweetCode.SteamAPI.collection.SteamUserAvatar;
import de.SweetCode.SteamAPI.interfaces.*;
import de.SweetCode.SteamAPI.method.input.Input;
import de.SweetCode.SteamAPI.method.methods.GetBadges;
import de.SweetCode.SteamAPI.method.methods.GetOwnedGames;
import de.SweetCode.SteamAPI.method.methods.GetPlayerSummaries;
import de.SweetCode.SteamAPI.utils.Assert;
import okhttp3.OkHttpClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class SteamAPI {

    private final String key;
    private Map<Class<? extends SteamInterface>, SteamInterface> interfaces = new HashMap<>();

    private final static Logger logger = LogManager.getLogger(SteamAPI.class);

    static {
        System.setProperty("org.apache.logging.log4j.simplelog.StatusLogger.level", "TRACE");
    }

    /**
     * <p>
     *    The OkHttp Client to perform the requests.
     * </p>
     */
    private final OkHttpClient client;

    public SteamAPI(OkHttpClient client, String key) {

        Assert.isNonEmpty(client, "The client cannot be null.");

        this.client = client;
        this.key = key;

        //--- All interfaces
        this.interfaces.put(IAccountRecoveryService.class, new IAccountRecoveryService(this));
        this.interfaces.put(IBroadcastService.class, new IBroadcastService(this));
        this.interfaces.put(ICheatReportingService.class, new ICheatReportingService(this));
        this.interfaces.put(IEconMarketService.class, new IEconMarketService(this));
        this.interfaces.put(IEconService.class, new IEconService(this));
        this.interfaces.put(IGameNotificationsService.class, new IGameNotificationsService(this));
        this.interfaces.put(IGameServersService.class, new IGameServersService(this));
        this.interfaces.put(IGameInventory.class, new IGameInventory(this));
        this.interfaces.put(IInventoryService.class, new IInventoryService(this));
        this.interfaces.put(IPlayerService.class, new IPlayerService(this));
        this.interfaces.put(ISteamApps.class, new ISteamApps(this));
        this.interfaces.put(ISteamCDN.class, new ISteamCDN(this));
        this.interfaces.put(ISteamCommunity.class, new ISteamCommunity(this));
        this.interfaces.put(ISteamDirectory.class, new ISteamDirectory(this));
        this.interfaces.put(ISteamGameServerStats.class, new ISteamGameServerStats(this));
        this.interfaces.put(ISteamLeaderboards.class, new ISteamLeaderboards(this));
        this.interfaces.put(ISteamNews.class, new ISteamNews(this));
        this.interfaces.put(ISteamRemoteStorage.class, new ISteamRemoteStorage(this));
        this.interfaces.put(ISteamSpecialSurvey.class, new ISteamSpecialSurvey(this));
        this.interfaces.put(ISteamUser.class, new ISteamUser(this));
        this.interfaces.put(ISteamUserAuth.class, new ISteamUserAuth(this));
        this.interfaces.put(ISteamUserOAuth.class, new ISteamUserOAuth(this));
        this.interfaces.put(ISteamVideo.class, new ISteamVideo(this));
        this.interfaces.put(ISteamWebAPIUtil.class, new ISteamWebAPIUtil(this));
        this.interfaces.put(ISteamWebUserPresenceOAuth.class, new ISteamWebUserPresenceOAuth(this));
        this.interfaces.put(ISteamWorkshop.class, new ISteamWorkshop(this));

        if(this.interfaces.isEmpty());
    }

    public SteamAPI(String key) {
        this(new OkHttpClient(), key);
    }

    public static Logger logger() {
        return logger;
    }

    /**
     * <p>
     *    The Steam API key assigned to this instance.
     * </p>
     *
     * @return The key, can be null.
     */
    public String getKey() {
        return this.key;
    }

    public OkHttpClient getClient() {
        return this.client;
    }

    /**
     * <p>
     *     Gives the internally used instance of the requested {@link SteamInterface}.
     * </p>
     *
     * @param steamInterface The steam interface.
     * @param <T> the type of the Steam Interface
     *
     * @return Returns an instance of the interface.
     */
    public <T extends SteamInterface> T get(Class<T> steamInterface) {

        Assert.isNonEmpty(steamInterface, "The SteamInterface cannot be null.");
        Assert.is(this.interfaces.containsKey(steamInterface), true, "This interface %s does not exist.", steamInterface.getName());

        return (T) this.interfaces.get(steamInterface);
    }

    public SteamUser createSteamUser(long steamid) {

        IPlayerService playerService = this.get(IPlayerService.class);
        ISteamUser steamUser = this.get(ISteamUser.class);
        SteamUser.Builder builder = SteamUser.builder(steamid);

        //--- Summary
        GetPlayerSummaries getPlayerSummaries = steamUser.get(GetPlayerSummaries.class);
        getPlayerSummaries.execute(
            SteamHTTPMethod.GET, SteamHost.PUBLIC, SteamVersion.V_1, SteamVisibility.ALL,
            Input.create().add("steamids", String.valueOf(steamid)).build(),
                (request, response, body) -> {

                    body.ifPresent(e -> {

                        JsonArray root = e.getAsJsonObject("response").getAsJsonObject("players").getAsJsonArray("player");

                        if(!(root.size() == 1)) {
                            return;
                        }

                        JsonObject player = root.get(0).getAsJsonObject();

                        //--- Set Avatar
                        builder.avatar(
                            SteamUserAvatar.builder()
                                .avatar(player.get("avatar").getAsString())
                                .medium(player.get("avatarmedium").getAsString())
                                .full(player.get("avatarfull").getAsString())
                            .build()
                        );

                        //--- States
                        builder.communityVisibilityState(player.get("communityvisibilitystate").getAsInt());
                        builder.profileState(player.get("profilestate").getAsInt());

                        //--- Last Log Off
                        builder.lastLogOff(player.get("lastlogoff").getAsLong());

                    });

                },
            false
        );


        //--- Steam Level & Badges
        GetBadges getBadges = playerService.get(GetBadges.class);
        getBadges.execute(
                SteamHTTPMethod.GET, SteamHost.PUBLIC, SteamVersion.V_1, SteamVisibility.ALL,
                Input.create().add("steamid", steamid).build(),
                (request, response, body) -> {

                    body.ifPresent(e -> {

                        JsonObject root = e.getAsJsonObject("response");

                        //--- set level
                        builder.steamLevel(root.get("player_level").getAsInt())
                                .xp(root.get("player_xp").getAsInt())
                                .xpToLevelUp(root.get("player_xp_needed_to_level_up").getAsInt())
                                .xpCurrentLevel(root.get("player_xp_needed_current_level").getAsInt());

                        //--- add bages
                        JsonArray badges = root.getAsJsonArray("badges");
                        badges.forEach(b -> {

                            JsonObject badge = b.getAsJsonObject();

                            builder.addBadge(
                                SteamBadge.builder(badge.get("badgeid").getAsInt())
                                    .level(badge.get("level").getAsInt())
                                    .completionTime(badge.get("completion_time").getAsLong())
                                    .xp(badge.get("xp").getAsInt())
                                    .scarcity(badge.get("scarcity").getAsInt())
                                .build()
                            );
                        });

                    });

                },
            false
        );

        //--- Get Owned Games
        GetOwnedGames getOwnedGames = playerService.get(GetOwnedGames.class);
        getOwnedGames.execute(
            SteamHTTPMethod.GET, SteamHost.PUBLIC, SteamVersion.V_1, SteamVisibility.ALL,
            Input.create().add("steamid", steamid).add("include_appinfo", true).add("include_played_free_games", true).build(),
            (request, response, body) -> {

                body.ifPresent(e -> {
                    //System.out.println();
                });

            },
            false
        );



        return builder.build();
    }

    /**
     * <p>
     *    This method should be called at the end of your program. It cancels all calls currently enqueued or executing
     *    requests. It also shuts down the {@link java.util.concurrent.ExecutorService} responsible for the client making
     *    all requests by calling {@link ExecutorService#shutdown()}.
     * </p>
     */
    public void close() {
        this.client.dispatcher().executorService().shutdown();
        this.client.dispatcher().cancelAll();
    }

}
