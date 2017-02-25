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
import de.SweetCode.SteamAPI.method.option.options.SteamIDOption;

import java.util.Collections;

public class GrantPackage extends SteamMethod {

    public GrantPackage(ISteamUser steamInterface) {
        super(
            steamInterface,
            "GrantPackage",
            Collections.singletonList(
                SteamMethodVersion.create()
                    .method(SteamHTTPMethod.POST)
                    .hosts(SteamHost.PUBLIC, SteamHost.PARTNER)
                    .version(SteamVersion.V_1)
                    .visibility(SteamVisibility.PUBLISHER)
                    .add(new KeyOption(true))
                    .add(new SteamIDOption(true))
                    .add(
                        Option.create()
                            .key("packageid")
                            .description("PackageID to grant.")
                            .optionType(OptionTypes.UINT_32)
                            .isRequired(true)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("ipaddress")
                            .description("IP address of user in string format (xxx.xxx.xxx.xxx).")
                            .optionType(OptionTypes.STRING)
                            .isRequired(false)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("thirdpartykey")
                            .description("Optionally associate third party key during grant. 'thirdpartyappid' will have to be set.")
                            .optionType(OptionTypes.STRING)
                            .isRequired(false)
                            .addDependecy("thirdpartyappid")
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("thirdpartyappid")
                            .description("Has to be set if 'thirdpartykey' is set. The appid associated with the 'thirdpartykey'.")
                            .optionType(OptionTypes.UINT_32)
                            .isRequired(false)
                        .build()
                    )
                .build()
            )
        );
    }

}
