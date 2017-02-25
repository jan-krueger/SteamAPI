package de.SweetCode.SteamAPI.method.methods;

import de.SweetCode.SteamAPI.SteamHTTPMethod;
import de.SweetCode.SteamAPI.SteamHost;
import de.SweetCode.SteamAPI.SteamVersion;
import de.SweetCode.SteamAPI.SteamVisibility;
import de.SweetCode.SteamAPI.interfaces.ISteamApps;
import de.SweetCode.SteamAPI.method.SteamMethod;
import de.SweetCode.SteamAPI.method.SteamMethodVersion;
import de.SweetCode.SteamAPI.method.option.Option;
import de.SweetCode.SteamAPI.method.option.OptionTypes;
import de.SweetCode.SteamAPI.method.option.options.KeyOption;

import java.util.Collections;

public class GetServersAtAddress extends SteamMethod {

    public GetServersAtAddress(ISteamApps steamInterface) {
        super(
            steamInterface,
            "GetServersAtAddress",
            Collections.singletonList(
                SteamMethodVersion.create()
                    .method(SteamHTTPMethod.GET)
                    .hosts(SteamHost.PUBLIC, SteamHost.PARTNER)
                    .version(SteamVersion.V_1)
                    .visibility(SteamVisibility.ALL)
                    .add(new KeyOption(false))
                    .add(
                        Option.create()
                            .key("addr")
                            .description("IP or IP:queryport to list.")
                            .optionType(OptionTypes.STRING)
                            .isRequired(true)
                        .build()
                    )
                .build()
            )
        );
    }

}
