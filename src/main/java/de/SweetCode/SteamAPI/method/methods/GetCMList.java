package de.SweetCode.SteamAPI.method.methods;

import de.SweetCode.SteamAPI.SteamHTTPMethod;
import de.SweetCode.SteamAPI.SteamHost;
import de.SweetCode.SteamAPI.SteamVersion;
import de.SweetCode.SteamAPI.SteamVisibility;
import de.SweetCode.SteamAPI.interfaces.ISteamDirectory;
import de.SweetCode.SteamAPI.method.SteamMethod;
import de.SweetCode.SteamAPI.method.SteamMethodVersion;
import de.SweetCode.SteamAPI.method.option.Option;
import de.SweetCode.SteamAPI.method.option.OptionTypes;
import de.SweetCode.SteamAPI.method.option.options.KeyOption;

import java.util.Collections;

public class GetCMList extends SteamMethod {

    public GetCMList(ISteamDirectory steamInterface) {
        super(
            steamInterface,
            "GetCMList",
            Collections.singletonList(
                SteamMethodVersion.create()
                    .method(SteamHTTPMethod.GET)
                    .hosts(SteamHost.PUBLIC, SteamHost.PARTNER)
                    .version(SteamVersion.V_1)
                    .visibility(SteamVisibility.ALL)
                    .add(new KeyOption(false))
                    .add(
                        Option.create()
                            .key("cellid")
                            .description("Client's Steam cell ID.")
                            .optionType(OptionTypes.UINT_32)
                            .isRequired(true)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("maxcount")
                            .description("Max number of servers to return.")
                            .optionType(OptionTypes.UINT_32)
                            .isRequired(false)
                        .build()
                    )
                .build()
            )
        );
    }

}
