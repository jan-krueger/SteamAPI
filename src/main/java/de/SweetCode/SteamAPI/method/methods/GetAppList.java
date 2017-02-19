package de.SweetCode.SteamAPI.method.methods;

import de.SweetCode.SteamAPI.SteamHTTPMethod;
import de.SweetCode.SteamAPI.SteamHost;
import de.SweetCode.SteamAPI.SteamVersion;
import de.SweetCode.SteamAPI.SteamVisibility;
import de.SweetCode.SteamAPI.interfaces.ISteamApps;
import de.SweetCode.SteamAPI.method.SteamMethod;
import de.SweetCode.SteamAPI.method.option.SteamMethodVersion;
import de.SweetCode.SteamAPI.method.option.options.KeyOption;

import java.util.Arrays;

public class GetAppList extends SteamMethod {

    public GetAppList(ISteamApps steamInterface) {
        super(
            steamInterface,
            "GetAppList",
            Arrays.asList(
                SteamMethodVersion.create()
                    .method(SteamHTTPMethod.GET)
                    .hosts(SteamHost.PUBLIC, SteamHost.PARTNER)
                    .version(SteamVersion.V_1)
                    .visibility(SteamVisibility.ALL)
                    .add(new KeyOption(false))
                .build(),
                SteamMethodVersion.create()
                    .method(SteamHTTPMethod.GET)
                    .hosts(SteamHost.PUBLIC, SteamHost.PARTNER)
                    .version(SteamVersion.V_2)
                    .visibility(SteamVisibility.ALL)
                    .add(new KeyOption(false))
                .build()
            )
        );
    }

}
