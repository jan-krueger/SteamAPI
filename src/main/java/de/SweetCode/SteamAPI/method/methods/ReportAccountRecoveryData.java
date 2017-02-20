package de.SweetCode.SteamAPI.method.methods;

import de.SweetCode.SteamAPI.SteamHTTPMethod;
import de.SweetCode.SteamAPI.SteamHost;
import de.SweetCode.SteamAPI.SteamVersion;
import de.SweetCode.SteamAPI.SteamVisibility;
import de.SweetCode.SteamAPI.interfaces.IAccountRecoveryService;
import de.SweetCode.SteamAPI.method.SteamMethod;
import de.SweetCode.SteamAPI.method.option.Option;
import de.SweetCode.SteamAPI.method.option.OptionTypes;
import de.SweetCode.SteamAPI.method.SteamMethodVersion;
import de.SweetCode.SteamAPI.method.option.options.KeyOption;

import java.util.Arrays;

public class ReportAccountRecoveryData extends SteamMethod {

    public ReportAccountRecoveryData(IAccountRecoveryService steamInterface) {
        super(
            steamInterface,
            "ReportAccountRecoveryData",
            Arrays.asList(
                SteamMethodVersion.create()
                    .method(SteamHTTPMethod.POST)
                    .hosts(SteamHost.PUBLIC, SteamHost.PARTNER)
                    .version(SteamVersion.V_1)
                    .visibility(SteamVisibility.ALL)
                    .add(new KeyOption(false))
                    .add(
                        Option.create()
                            .key("loginuser_list")
                            .isRequired(true)
                            .optionType(OptionTypes.STRING)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("install_config")
                            .isRequired(true)
                            .optionType(OptionTypes.STRING)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("shasentryfile")
                            .isRequired(true)
                            .optionType(OptionTypes.STRING)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("machineid")
                            .isRequired(true)
                            .optionType(OptionTypes.STRING)
                        .build()
                    )
                .build()

            )
        );
    }

}
