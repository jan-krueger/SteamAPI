package de.SweetCode.SteamAPI.method.methods;

import de.SweetCode.SteamAPI.SteamHost;
import de.SweetCode.SteamAPI.SteamVersion;
import de.SweetCode.SteamAPI.interfaces.ISteamUserStats;
import de.SweetCode.SteamAPI.method.SteamMethod;
import de.SweetCode.SteamAPI.method.input.Input;
import de.SweetCode.SteamAPI.method.option.MethodVersion;
import de.SweetCode.SteamAPI.method.option.Option;
import de.SweetCode.SteamAPI.method.option.OptionTypes;
import de.SweetCode.SteamAPI.method.result.SteamMethodResult;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;

public class GetGlobalAchievementPercentagesForApp extends SteamMethod {

    public GetGlobalAchievementPercentagesForApp() {
        super(
            new ISteamUserStats(),
            "GetGlobalAchievementPercentagesForApp",
            new ArrayList<MethodVersion>() {{

                this.add(
                    MethodVersion.create()
                        .hosts(SteamHost.PUBLIC, SteamHost.PARTNER)
                        .version(SteamVersion.V_2)
                        .add(
                            Option.create()
                                .key("gameid")
                                .description("GameID to retrieve the achievement percentage for.")
                                .optionType(OptionTypes.UINT_64)
                            .build()
                        )
                    .build()
                );

            }}
        );
    }

    @Override
    public SteamMethodResult execute(SteamHost host, SteamVersion version, Input input) {

        //--- Verify host & version
        this.verify(host, version);

        //Note: We don't need to check if the option is present, because this is what SteamMethod#verify() already does,
        // so if we pass the call above, it is fine.
        MethodVersion methodVersion = this.get(host, version).get();

        if(methodVersion.verify(this, input)) {
            return new SteamMethodResult();
        }

        //--- Build URL
        HttpUrl.Builder url = HttpUrl.parse(String.format(
                "https://%s/%s/%s/%s/",
                host.getHost(),
                this.getInterface().getName(),
                this.getName(),
                version.getUrlVersion()
        )).newBuilder();
        input.getValues().entrySet().forEach(e -> url.addQueryParameter(e.getKey(), String.valueOf(e.getValue())));

        //--- Send the request
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .get()
                .url(url.build())
                .build();

        try {
            Response response = client.newCall(request).execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new SteamMethodResult();

    }


}
