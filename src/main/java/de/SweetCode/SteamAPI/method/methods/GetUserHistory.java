package de.SweetCode.SteamAPI.method.methods;

import de.SweetCode.SteamAPI.SteamHTTPMethod;
import de.SweetCode.SteamAPI.SteamHost;
import de.SweetCode.SteamAPI.SteamVersion;
import de.SweetCode.SteamAPI.SteamVisibility;
import de.SweetCode.SteamAPI.interfaces.IGameInventory;
import de.SweetCode.SteamAPI.method.SteamMethod;
import de.SweetCode.SteamAPI.method.SteamMethodVersion;
import de.SweetCode.SteamAPI.method.option.Option;
import de.SweetCode.SteamAPI.method.option.OptionTypes;
import de.SweetCode.SteamAPI.method.option.options.AppIDOption;
import de.SweetCode.SteamAPI.method.option.options.KeyOption;
import de.SweetCode.SteamAPI.method.option.options.SteamIDOption;

import java.util.Collections;

public class GetUserHistory extends SteamMethod {

    public GetUserHistory(IGameInventory steamInterface) {
        super(
            steamInterface,
            "GetUserHistory",
            Collections.singletonList(
                SteamMethodVersion.create()
                    .method(SteamHTTPMethod.GET)
                    .hosts(SteamHost.PUBLIC, SteamHost.PARTNER)
                    .version(SteamVersion.V_1)
                    .visibility(SteamVisibility.PUBLISHER)
                    .add(new KeyOption(false))
                    .add(new AppIDOption(true))
                    .add(new SteamIDOption(true))
                    .add(
                        Option.create()
                            .key("contextid")
                            .description("The context to fetch history for.")
                            .optionType(OptionTypes.UINT_64)
                           .isRequired(true)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("starttime")
                            .description("Start time of the history range to collect.")
                            .optionType(OptionTypes.UINT_32)
                            .isRequired(true)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("endtime")
                            .description("End time of the history range to collect.")
                            .optionType(OptionTypes.UINT_32)
                            .isRequired(true)
                        .build()
                    )
                .build()
            )
        );
    }

}
