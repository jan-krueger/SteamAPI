import de.SweetCode.SteamAPI.*;
import de.SweetCode.SteamAPI.method.SteamMethod;
import de.SweetCode.SteamAPI.method.input.Input;
import de.SweetCode.SteamAPI.method.methods.*;

public class Test {

    public static void main(String[] args) {

        SteamAPI api = new SteamAPI();
        SteamMethod method = api.getNews().get(GetNewsForApp.class);
        method.execute(SteamHTTPMethod.GET, SteamHost.PUBLIC, SteamVersion.V_2, SteamVisibility.ALL, Input.create()
                    .add("appid", 730)
                    .add("enddate", 1487366763)
                    .add("count", 1)
                    .add("maxlength", 20)
                .build());

    }

}