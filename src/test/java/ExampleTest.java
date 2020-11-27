import com.google.gson.JsonObject;
import de.SweetCode.SteamAPI.*;
import de.SweetCode.SteamAPI.interfaces.ISteamUser;
import de.SweetCode.SteamAPI.interfaces.SteamInterface;
import de.SweetCode.SteamAPI.method.SteamMethod;
import de.SweetCode.SteamAPI.method.SteamResponse;
import de.SweetCode.SteamAPI.method.input.Input;
import de.SweetCode.SteamAPI.method.methods.GetFriendList;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.function.Consumer;

public class ExampleTest {

    @Test
    public void getFriendListTest() {

        //1. Create an instance with your Steam API Key.
        SteamAPI steamAPI = new SteamAPI(System.getenv("STEAM_API_KEY"));

        //2. Get the interface you wanna use.
        SteamInterface steamInterface = steamAPI.get(ISteamUser.class);

        //3. Get the method you wanna use.
        SteamMethod getFriendList = steamInterface.get(GetFriendList.class);

        //4. Execute the method with the appropriate values. I have no documentation yet, so you can just lookup the values
        //   on xpaw's page. The method we wanna use is here: https://lab.xpaw.me/steam_api_documentation.html#ISteamUser_GetFriendList_v1
        //   Notice: The "key" attribute is autofilled by the API if required.
        getFriendList.execute(
                SteamHTTPMethod.GET,
                SteamHost.PUBLIC,
                SteamVersion.V_1,
                SteamVisibility.ALL,
                Input.create()
                        .add("steamid", 76561198063882350L) //5. Input, we only need a steamid of some example user.
                        .build(),
                new SteamResponse() {
                    @Override
                    public void onResponse(Request request, Response response, Optional<JsonObject> body) {
                        body.ifPresent(new Consumer<JsonObject>() {
                            @Override
                            public void accept(JsonObject object) {
                                //--- Do Stuff
                                System.out.println(object);
                            }
                        });
                    }
                },
                false //6. Should we execute the request async?
        );

        //--- When you are done then don't forget to shut everything down, might be a bit more tricky when you are sending
        // async requests.
        steamAPI.close();
    }


}
