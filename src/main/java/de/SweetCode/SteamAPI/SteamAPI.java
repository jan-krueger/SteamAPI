package de.SweetCode.SteamAPI;

import de.SweetCode.SteamAPI.interfaces.*;
import okhttp3.OkHttpClient;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class SteamAPI {

    private final String key;
    private Map<Class<? extends SteamInterface>, SteamInterface> interfaces = new HashMap<>();

    /**
     * <p>
     *    The OkHttp Client to perform the requests.
     * </p>
     */
    private final OkHttpClient client;

    public SteamAPI(OkHttpClient client, String key) {

        //@TODO Verify input
        assert !(client == null);

        this.client = client;
        this.key = key;

        //--- All interfaces
        this.interfaces.put(IAccountRecoveryService.class, new IAccountRecoveryService(this));
        this.interfaces.put(IBroadcastService.class, new IBroadcastService(this));
        this.interfaces.put(ICheatReportingService.class, new ICheatReportingService(this));
        this.interfaces.put(IInventoryService.class, new IInventoryService(this));
        this.interfaces.put(IPlayerService.class, new IPlayerService(this));
        this.interfaces.put(ISteamApps.class, new ISteamApps(this));
        this.interfaces.put(ISteamCDN.class, new ISteamCDN(this));
        this.interfaces.put(ISteamCommunity.class, new ISteamCommunity(this));
        this.interfaces.put(ISteamDirectory.class, new ISteamDirectory(this));
        this.interfaces.put(ISteamGameServerStats.class, new ISteamGameServerStats(this));
        this.interfaces.put(ISteamNews.class, new ISteamNews(this));
        this.interfaces.put(ISteamUser.class, new ISteamUser(this));
        this.interfaces.put(ISteamWebAPIUtil.class, new ISteamWebAPIUtil(this));
    }

    public SteamAPI(String key) {
        this(new OkHttpClient(), key);
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

        //@TODO Verify input
        assert this.interfaces.containsKey(steamInterface);

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
