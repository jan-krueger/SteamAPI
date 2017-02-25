import com.google.gson.JsonObject;
import de.SweetCode.SteamAPI.*;
import de.SweetCode.SteamAPI.interfaces.ISteamUser;
import de.SweetCode.SteamAPI.interfaces.ISteamWebAPIUtil;
import de.SweetCode.SteamAPI.interfaces.SteamInterface;
import de.SweetCode.SteamAPI.method.SteamMethod;
import de.SweetCode.SteamAPI.method.SteamResponse;
import de.SweetCode.SteamAPI.method.input.Input;
import de.SweetCode.SteamAPI.method.methods.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.util.Optional;

public class Test {

    public static void main(String[] args) {

        SteamAPI steam = new SteamAPI("dasd");
        SteamInterface steamInterface = steam.get(ISteamUser.class);
        SteamMethod method = steamInterface.get(GrantPackage.class);
        method.execute(SteamHTTPMethod.POST, SteamHost.PUBLIC, SteamVersion.V_1, SteamVisibility.PUBLISHER, Input.create()
                    .add("packageid", 20)
                    .add("steamid", 89L)
                    .add("thirdpartykey", "FOO")
                    .add("thirdpartyappid", 8)
                .build(), new SteamResponse() {
            @Override
            public void onResponse(Request request, Response response, Optional<JsonObject> body) {
                System.out.println(body.get());
            }

            @Override
            public void onError(String message) {
                System.out.println(message);
            }
        }, false);

    }

}