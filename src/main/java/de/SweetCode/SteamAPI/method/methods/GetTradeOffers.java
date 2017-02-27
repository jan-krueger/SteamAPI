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
import de.SweetCode.SteamAPI.method.option.options.KeyOption;

import java.util.Collections;

public class GetTradeOffers extends SteamMethod {

    public GetTradeOffers(IEconService steamInterface) {
        super(
            steamInterface,
            "GetTradeOffers",
            Collections.singletonList(
                SteamMethodVersion.create()
                    .method(SteamHTTPMethod.GET)
                    .hosts(SteamHost.PUBLIC, SteamHost.PARTNER)
                    .version(SteamVersion.V_1)
                    .visibility(SteamVisibility.ALL)
                    .add(new KeyOption(true))
                    .add(
                        Option.create()
                            .key("get_sent_offers")
                            .description("Request the list of sent offers..")
                            .optionType(OptionTypes.BOOL)
                            .isRequired(true)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("get_received_offers")
                            .description("Request the list of received offers.")
                            .optionType(OptionTypes.BOOL)
                            .isRequired(true)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("get_descriptions")
                            .description("If set, the item display data for the items included in the returned trade offers will also be returned.")
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
                            .key("active_only")
                            .description("Indicates we should only return offers which are still active, or offers that have changed in state since the time_historical_cutoff.")
                            .optionType(OptionTypes.BOOL)
                            .isRequired(true)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("historical_only")
                            .description("Indicates we should only return offers which are not active.")
                            .optionType(OptionTypes.BOOL)
                            .isRequired(true)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("time_historical_cutoff")
                            .description("When active_only is set, offers updated since this time will also be returned.")
                            .optionType(OptionTypes.UINT_32)
                            .isRequired(true)
                        .build()
                    )
                .build()
            )
        );
    }

}
