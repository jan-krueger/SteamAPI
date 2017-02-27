package de.SweetCode.SteamAPI.method.methods;

import de.SweetCode.SteamAPI.SteamHTTPMethod;
import de.SweetCode.SteamAPI.SteamHost;
import de.SweetCode.SteamAPI.SteamVersion;
import de.SweetCode.SteamAPI.SteamVisibility;
import de.SweetCode.SteamAPI.interfaces.IEconService;
import de.SweetCode.SteamAPI.method.SteamMethod;
import de.SweetCode.SteamAPI.method.SteamMethodVersion;
import de.SweetCode.SteamAPI.method.option.Option;
import de.SweetCode.SteamAPI.method.option.OptionTypes;
import de.SweetCode.SteamAPI.method.option.options.AppIDOption;
import de.SweetCode.SteamAPI.method.option.options.KeyOption;
import de.SweetCode.SteamAPI.method.option.options.SteamIDOption;

import java.util.Collections;

public class GetTradeHistory extends SteamMethod {

    public GetTradeHistory(IEconService steamInterface) {
        super(
            steamInterface,
            "GetTradeHistory",
            Collections.singletonList(
                SteamMethodVersion.create()
                    .method(SteamHTTPMethod.GET)
                    .hosts(SteamHost.PUBLIC, SteamHost.PARTNER)
                    .version(SteamVersion.V_1)
                    .visibility(SteamVisibility.ALL)
                    .add(new KeyOption(true))
                    .add(
                        Option.create()
                            .key("max_trades")
                            .description("The number of trades to return information for.")
                            .optionType(OptionTypes.UINT_32)
                            .isRequired(true)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("start_after_time")
                            .description("The time of the last trade shown on the previous page of results, or the time of the first trade if navigating back.")
                            .optionType(OptionTypes.UINT_32)
                            .isRequired(true)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("start_after_tradeid")
                            .description("The tradeid shown on the previous page of results, or the ID of the first trade if navigating back.")
                            .optionType(OptionTypes.UINT_64)
                            .isRequired(true)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("navigating_back")
                            .description("The user wants the previous page of results, so return the previous max_trades trades before the start time and ID.")
                            .optionType(OptionTypes.BOOL)
                            .isRequired(true)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("get_descriptions")
                            .description("If set, the item display data for the items included in the returned trades will also be returned.")
                            .optionType(OptionTypes.BOOL)
                            .isRequired(true)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("language")
                            .description("The language to use when loading item display data.")
                            .optionType(OptionTypes.STRING)
                            .isRequired(true)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("include_failed")
                            .optionType(OptionTypes.BOOL)
                            .isRequired(true)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("include_total")
                            .description("If set, the total number of trades the account has participated in will be included in the response.")
                            .optionType(OptionTypes.BOOL)
                            .isRequired(true)
                        .build()
                    )
                .build()
            )
        );
    }

}
