import de.SweetCode.SteamAPI.*;
import de.SweetCode.SteamAPI.method.SteamMethod;
import de.SweetCode.SteamAPI.method.input.Input;
import de.SweetCode.SteamAPI.method.methods.UpToDateCheck;

public class Test {

    public static void main(String[] args) {

        SteamAPI api = new SteamAPI();
        SteamMethod method = api.getISteamApps().get(UpToDateCheck.class);
        method.execute(SteamHTTPMethod.GET, SteamHost.PUBLIC, SteamVersion.V_1, SteamVisibility.ALL, Input.create()
                    .add("appid", 730L)
                    .add("version", 13568L)
                .build());

    }

}