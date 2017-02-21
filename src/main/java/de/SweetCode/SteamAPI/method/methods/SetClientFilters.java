package de.SweetCode.SteamAPI.method.methods;

import de.SweetCode.SteamAPI.SteamHTTPMethod;
import de.SweetCode.SteamAPI.SteamHost;
import de.SweetCode.SteamAPI.SteamVersion;
import de.SweetCode.SteamAPI.SteamVisibility;
import de.SweetCode.SteamAPI.interfaces.ISteamCDN;
import de.SweetCode.SteamAPI.method.SteamMethod;
import de.SweetCode.SteamAPI.method.SteamMethodVersion;
import de.SweetCode.SteamAPI.method.option.Option;
import de.SweetCode.SteamAPI.method.option.OptionTypes;
import de.SweetCode.SteamAPI.method.option.options.KeyOption;

import java.util.Collections;

public class SetClientFilters extends SteamMethod {

    public SetClientFilters(ISteamCDN steamInterface) {
        super(
            steamInterface,
            "SetClientFilters",
            Collections.singletonList(
                SteamMethodVersion.create()
                    .method(SteamHTTPMethod.POST)
                    .hosts(SteamHost.PUBLIC, SteamHost.PARTNER)
                    .version(SteamVersion.V_1)
                    .visibility(SteamVisibility.ALL)
                    .add(new KeyOption(true))
                    .add(
                        Option.create()
                            .key("cdnname")
                            .description("Steam name of CDN property.")
                            .optionType(OptionTypes.STRING)
                            .isRequired(true)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("allowedipblocks")
                            .description("Ccomma-separated list of allowed IP address blocks in CIDR format - blank for not used.")
                            .optionType(OptionTypes.STRING)
                            .isRequired(false)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("allowedasns")
                            .description("Comma-separated list of allowed client network AS numbers - blank for not used.")
                            .optionType(OptionTypes.STRING)
                            .isRequired(false)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("allowedipcountries")
                            .description("Comma-separated list of allowed client IP country codes in ISO 3166-1 format - blank for not used.")
                            .optionType(OptionTypes.STRING)
                            .isRequired(false)
                        .build()
                    )
                .build()
            )
        );
    }

}
