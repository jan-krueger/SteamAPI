package de.SweetCode.SteamAPI;

import de.SweetCode.SteamAPI.interfaces.*;
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
