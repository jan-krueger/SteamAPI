package de.SweetCode.SteamAPI.method.methods;

import de.SweetCode.SteamAPI.SteamHTTPMethod;
import de.SweetCode.SteamAPI.SteamHost;
import de.SweetCode.SteamAPI.SteamVersion;
import de.SweetCode.SteamAPI.SteamVisibility;
import de.SweetCode.SteamAPI.interfaces.ISteamUser;
import de.SweetCode.SteamAPI.method.SteamMethod;
import de.SweetCode.SteamAPI.method.SteamMethodVersion;
import de.SweetCode.SteamAPI.method.option.Option;
import de.SweetCode.SteamAPI.method.option.OptionTypes;
import de.SweetCode.SteamAPI.method.option.options.KeyOption;

import java.util.Arrays;

public class GetPlayerSummaries extends SteamMethod {

    public GetPlayerSummaries(ISteamUser steamInterface) {
        super(
            steamInterface,
            "GetPlayerSummaries",
            Arrays.asList(
                SteamMethodVersion.create()
                    .method(SteamHTTPMethod.GET)
                    .hosts(SteamHost.PUBLIC, SteamHost.PARTNER)
                    .version(SteamVersion.V_1)
                    .visibility(SteamVisibility.ALL)
                    .add(new KeyOption(true))
                    .add(
                        Option.create()
                            .key("steamids")
                            .description("Comma-delimited list of SteamIDs (max: 100).")
                            .optionType(OptionTypes.STRING)
                            .isRequired(true)
                        .build()
                    )
                .build(),
                SteamMethodVersion.create()
                    .method(SteamHTTPMethod.GET)
                    .hosts(SteamHost.PUBLIC, SteamHost.PARTNER)
                    .version(SteamVersion.V_2)
                    .visibility(SteamVisibility.ALL)
                    .add(new KeyOption(true))
                    .add(
                        Option.create()
                            .key("steamids")
                            .description("Comma-delimited list of SteamIDs (max: 100).")
                            .optionType(OptionTypes.STRING)
                            .isRequired(true)
                        .build()
                    )
                .build()
            )
        );
    }

}
