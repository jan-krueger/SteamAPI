import de.SweetCode.SteamAPI.SteamHTTPMethod;
import de.SweetCode.SteamAPI.SteamHost;
import de.SweetCode.SteamAPI.SteamVersion;
import de.SweetCode.SteamAPI.method.input.Input;
import de.SweetCode.SteamAPI.method.methods.GetGlobalAchievementPercentagesForApp;

public class Test {

    public static void main(String[] args) {

        GetGlobalAchievementPercentagesForApp method = new GetGlobalAchievementPercentagesForApp();
        method.execute(SteamHTTPMethod.GET, SteamHost.PUBLIC, SteamVersion.V_2, Input.create()
                    .add("gameid", 41L)
                .build());

    }

}
