import com.google.gson.JsonObject;
import de.SweetCode.SteamAPI.*;
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
        SteamInterface steamInterface = steam.get(ISteamWebAPIUtil.class);
        SteamMethod method = steamInterface.get(GetSupportedAPIList.class);
        method.execute(SteamHTTPMethod.GET, SteamHost.PUBLIC, SteamVersion.V_1, SteamVisibility.ALL, Input.empty(), new SteamResponse() {
            @Override
            public void onResponse(Request request, Response response, Optional<JsonObject> body) {
                System.out.println(body.get());
            }

            @Override
            public void onError(String message) {
                System.out.println(message);
            }
        }, true);

    }

}