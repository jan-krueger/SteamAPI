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
import de.SweetCode.SteamAPI.method.option.options.AppIDOption;
import de.SweetCode.SteamAPI.method.option.options.KeyOption;
import de.SweetCode.SteamAPI.method.option.options.TimeBeginOption;
import de.SweetCode.SteamAPI.method.option.options.TimeEndOption;

import java.util.Collections;

public class ISteamAppsGetCheatingReports extends SteamMethod {

    public ISteamAppsGetCheatingReports(ISteamApps steamInterface) {
        super(
            steamInterface,
            "GetCheatingReports",
            Collections.singletonList(
                SteamMethodVersion.create()
                    .method(SteamHTTPMethod.GET)
                    .hosts(SteamHost.PUBLIC, SteamHost.PARTNER)
                    .version(SteamVersion.V_1)
                    .visibility(SteamVisibility.PUBLISHER)
                    .add(new KeyOption(false))
                    .add(new AppIDOption(true))
                    .add(new TimeBeginOption(true))
                    .add(new TimeEndOption(true))
                    .add(
                        Option.create()
                            .key("reportidmin")
                            .description("Minimum report id..")
                            .optionType(OptionTypes.UINT_64)
                            .isRequired(false)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("includereports")
                            .description("Include reports that were not bans.")
                            .optionType(OptionTypes.BOOL)
                            .isRequired(true)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("includebans")
                            .description("Include reports that were bans.")
                            .optionType(OptionTypes.BOOL)
                            .isRequired(true)
                        .build()
                    )
                .build()
            )
        );
    }
}
