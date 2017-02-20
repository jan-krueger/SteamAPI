package de.SweetCode.SteamAPI.method.methods;

import de.SweetCode.SteamAPI.SteamHTTPMethod;
import de.SweetCode.SteamAPI.SteamHost;
import de.SweetCode.SteamAPI.SteamVersion;
import de.SweetCode.SteamAPI.SteamVisibility;
import de.SweetCode.SteamAPI.interfaces.IInventoryService;
import de.SweetCode.SteamAPI.method.SteamMethod;
import de.SweetCode.SteamAPI.method.option.Option;
import de.SweetCode.SteamAPI.method.option.OptionTypes;
import de.SweetCode.SteamAPI.method.option.SteamMethodVersion;
import de.SweetCode.SteamAPI.method.option.options.AppIDOption;
import de.SweetCode.SteamAPI.method.option.options.KeyOption;

import java.util.Collections;

public class GetItemDefs extends SteamMethod {

    public GetItemDefs(IInventoryService steamInterface) {
        super(
            steamInterface,
            "GetItemDefs",
            Collections.singletonList(
                SteamMethodVersion.create()
                    .method(SteamHTTPMethod.POST)
                    .hosts(SteamHost.PUBLIC, SteamHost.PARTNER)
                    .version(SteamVersion.V_1)
                    .visibility(SteamVisibility.ALL)
                    .add(new KeyOption(true))
                    .add(new AppIDOption(true))
                    .add(
                        Option.create()
                            .key("modifiedsince")
                            .optionType(OptionTypes.STRING)
                            .isRequired(true)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("itemdefids")
                            .optionType(OptionTypes.UINT_64)
                            .isRequired(true)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("workshopids")
                            .optionType(OptionTypes.UINT_64)
                            .isRequired(true)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("cache_max_age_seconds")
                            .description("Allow stale data to be returned for the specified number of seconds.")
                            .optionType(OptionTypes.UINT_32)
                            .isRequired(false)
                        .build()
                    )
                .build()
            )
        );
    }

}
