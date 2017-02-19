package de.SweetCode.SteamAPI.method.methods;

import de.SweetCode.SteamAPI.SteamHTTPMethod;
import de.SweetCode.SteamAPI.SteamHost;
import de.SweetCode.SteamAPI.SteamVersion;
import de.SweetCode.SteamAPI.SteamVisibility;
import de.SweetCode.SteamAPI.exceptions.ICheatReportingService;
import de.SweetCode.SteamAPI.method.SteamMethod;
import de.SweetCode.SteamAPI.method.input.Input;
import de.SweetCode.SteamAPI.method.option.Option;
import de.SweetCode.SteamAPI.method.option.OptionTypes;
import de.SweetCode.SteamAPI.method.option.SteamMethodVersion;
import de.SweetCode.SteamAPI.method.option.options.*;
import de.SweetCode.SteamAPI.method.result.SteamMethodResult;

import java.util.Collections;

public class GetCheatingReports extends SteamMethod {

    public GetCheatingReports(ICheatReportingService steamInterface) {
        super(
            steamInterface,
            "GetCheatingReports",
            Collections.singletonList(
                SteamMethodVersion.create()
                    .method(SteamHTTPMethod.GET)
                    .hosts(SteamHost.PUBLIC, SteamHost.PARTNER)
                    .version(SteamVersion.V_1)
                    .visibility(SteamVisibility.PUBLISHER)
                    .add(new KeyOption(true))
                    .add(new AppIDOption(true))
                    .add(new TimeBeginOption(true))
                    .add(new TimeEndOption(true))
                    .add(new SteamIDOption(false))
                    .add(
                        Option.create()
                            .key("reportidmin")
                            .description("Minimum reportID to include.")
                            .optionType(OptionTypes.UINT_64)
                            .isRequired(true)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("includereports")
                            .description("Include reports.")
                            .optionType(OptionTypes.BOOL)
                            .isRequired(false)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("includebans")
                            .description("Include ban requests.")
                            .optionType(OptionTypes.UINT_64)
                            .isRequired(true)
                        .build()
                    )
                .build()
            )
        );
    }

    @Override
    public SteamMethodResult execute(SteamHTTPMethod method, SteamHost host, SteamVersion version, Input input) {
        return null;
    }

}