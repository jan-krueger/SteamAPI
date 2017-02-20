package de.SweetCode.SteamAPI.method.methods;

import de.SweetCode.SteamAPI.SteamHTTPMethod;
import de.SweetCode.SteamAPI.SteamHost;
import de.SweetCode.SteamAPI.SteamVersion;
import de.SweetCode.SteamAPI.SteamVisibility;
import de.SweetCode.SteamAPI.interfaces.IInventoryService;
import de.SweetCode.SteamAPI.method.SteamMethod;
import de.SweetCode.SteamAPI.method.option.Option;
import de.SweetCode.SteamAPI.method.option.OptionTypes;
import de.SweetCode.SteamAPI.method.SteamMethodVersion;
import de.SweetCode.SteamAPI.method.option.options.AppIDOption;
import de.SweetCode.SteamAPI.method.option.options.KeyOption;
import de.SweetCode.SteamAPI.method.option.options.SteamIDOption;

import java.util.Collections;

public class AddItem extends SteamMethod {

    public AddItem(IInventoryService steamInterface) {
        super(
            steamInterface,
            "AddItem",
            Collections.singletonList(
                SteamMethodVersion.create()
                    .method(SteamHTTPMethod.POST)
                    .hosts(SteamHost.PUBLIC, SteamHost.PARTNER)
                    .version(SteamVersion.V_1)
                    .visibility(SteamVisibility.PUBLISHER)
                    .add(new KeyOption(true))
                    .add(new AppIDOption(true))
                    .add(new SteamIDOption(true))
                    .add(
                        Option.create()
                            .key("itemdefid")
                            .optionType(OptionTypes.UINT_64)
                            .isRequired(true)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("itempropsjson")
                            .optionType(OptionTypes.STRING)
                           .isRequired(true)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("notify")
                            .description("Should notify the user that the item was added to their Steam Inventory.")
                            .optionType(OptionTypes.BOOL)
                            .isRequired(true)
                        .build()
                    )
                .build()
            )
        );
    }

}
