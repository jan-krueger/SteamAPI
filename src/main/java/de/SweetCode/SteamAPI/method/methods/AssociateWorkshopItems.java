package de.SweetCode.SteamAPI.method.methods;

import de.SweetCode.SteamAPI.SteamHTTPMethod;
import de.SweetCode.SteamAPI.SteamHost;
import de.SweetCode.SteamAPI.SteamVersion;
import de.SweetCode.SteamAPI.SteamVisibility;
import de.SweetCode.SteamAPI.interfaces.ISteamWorkshop;
import de.SweetCode.SteamAPI.method.SteamMethod;
import de.SweetCode.SteamAPI.method.SteamMethodVersion;
import de.SweetCode.SteamAPI.method.option.Option;
import de.SweetCode.SteamAPI.method.option.OptionTypes;
import de.SweetCode.SteamAPI.method.option.options.AppIDOption;
import de.SweetCode.SteamAPI.method.option.options.KeyOption;

import java.util.Collections;

public class AssociateWorkshopItems extends SteamMethod {

    public AssociateWorkshopItems(ISteamWorkshop steamInterface) {
        super(
            steamInterface,
            "AssociateWorkshopItems",
            Collections.singletonList(
                SteamMethodVersion.create()
                    .method(SteamHTTPMethod.POST)
                    .hosts(SteamHost.PUBLIC, SteamHost.PARTNER)
                    .version(SteamVersion.V_1)
                    .visibility(SteamVisibility.PUBLISHER)
                    .add(new KeyOption(false))
                    .add(new AppIDOption(true))
                    .add(
                        Option.create()
                            .key("itemcount")
                            .description("Number of items to associate.")
                            .optionType(OptionTypes.UINT_32)
                           .isRequired(true)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("publishedfileid[0]")
                            .description("The workshop published file id.")
                            .optionType(OptionTypes.UINT_64)
                            .isRequired(false)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("gameitemid[0]")
                            .description("3rd party ID for item.")
                            .optionType(OptionTypes.UINT_32)
                            .isRequired(false)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("revenuepercentage[0]")
                            .description("Percentage of revenue the owners of the workshop item will get from the sale of " +
                                    "the item [0.0, 100.0]. For bundle-like items, send over an entry for each item in the bundle" +
                                    " (gameitemid = bundle id) with different publishedfileids and with the revenue percentage" +
                                    " pre-split amongst the items in the bundle (i.e. 30% / 10 items in the bundle).")
                            .optionType(OptionTypes.FLOAT)
                            .isRequired(false)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("gameitemdescription[0]]")
                            .description("Game's description of the game item.")
                            .optionType(OptionTypes.STRING)
                            .isRequired(false)
                        .build()
                    )
                .build()
            )
        );
    }

}
