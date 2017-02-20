import de.SweetCode.SteamAPI.*;
import de.SweetCode.SteamAPI.method.SteamMethod;
import de.SweetCode.SteamAPI.method.input.Input;
import de.SweetCode.SteamAPI.method.methods.*;

public class Test {

    public static void main(String[] args) {

        SteamAPI api = new SteamAPI();
        SteamMethod method = api.getPlayerService().get(GetOwnedGames.class);
        method.execute(SteamHTTPMethod.GET, SteamHost.PUBLIC, SteamVersion.V_1, SteamVisibility.ALL, Input.create()
                    .add("steamid", 76561198063882350L)
                    .add("key", "<steam-api-key>")
                    .add("include_appinfo", false)
                    .add("include_played_free_games", false)
                .build());

    }

}