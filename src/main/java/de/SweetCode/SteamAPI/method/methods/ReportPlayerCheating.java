package de.SweetCode.SteamAPI.method.methods;

import de.SweetCode.SteamAPI.SteamHTTPMethod;
import de.SweetCode.SteamAPI.SteamHost;
import de.SweetCode.SteamAPI.SteamVersion;
import de.SweetCode.SteamAPI.SteamVisibility;
import de.SweetCode.SteamAPI.interfaces.ICheatReportingService;
import de.SweetCode.SteamAPI.method.SteamMethod;
import de.SweetCode.SteamAPI.method.input.Input;
import de.SweetCode.SteamAPI.method.option.Option;
import de.SweetCode.SteamAPI.method.option.OptionTypes;
import de.SweetCode.SteamAPI.method.option.SteamMethodVersion;
import de.SweetCode.SteamAPI.method.option.options.AppIDOption;
import de.SweetCode.SteamAPI.method.option.options.KeyOption;
import de.SweetCode.SteamAPI.method.option.options.SteamIDOption;
import de.SweetCode.SteamAPI.method.result.SteamMethodResult;

import java.util.Collections;

public class ReportPlayerCheating extends SteamMethod {

    public ReportPlayerCheating(ICheatReportingService steamInterface) {
        super(
            steamInterface,
            "ReportPlayerCheating",
            Collections.singletonList(
                SteamMethodVersion.create()
                    .method(SteamHTTPMethod.POST)
                    .hosts(SteamHost.PUBLIC, SteamHost.PARTNER)
                    .version(SteamVersion.V_1)
                    .visibility(SteamVisibility.PUBLISHER)
                    .add(new KeyOption(true))
                    .add(new SteamIDOption(true))
                    .add(new AppIDOption(true))
                    .add(
                        Option.create()
                            .key("steamidreporter")
                            .description("steamid of the user or game server who is reporting the cheating.")
                            .optionType(OptionTypes.UINT_64)
                            .isRequired(false)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("appdata")
                            .description("App specific data about the cheating.")
                            .optionType(OptionTypes.UINT_64)
                            .isRequired(false)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("heuristic")
                            .description("Extra information about the source of the cheating - was it a heuristic.")
                            .optionType(OptionTypes.BOOL)
                            .isRequired(false)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("detection")
                            .description("Extra information about the source of the cheating - was it a detection.")
                            .optionType(OptionTypes.BOOL)
                            .isRequired(false)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("playerreport")
                            .description("Extra information about the source of the cheating - was it a player report.")
                            .optionType(OptionTypes.BOOL)
                            .isRequired(false)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("noreportid")
                            .description("Don't return report id.")
                            .optionType(OptionTypes.BOOL)
                            .isRequired(false)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("gamemode")
                            .description("Extra information about state of game - was it a specific type of game play (0 = generic).")
                            .optionType(OptionTypes.UINT_32)
                            .isRequired(false)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("suspicionstarttime")
                            .description("extra information indicating how far back the game thinks is interesting for this user")
                            .optionType(OptionTypes.UINT_32)
                            .isRequired(false)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("severity")
                            .description("Level of severity of bad action being reported.")
                            .optionType(OptionTypes.UINT_32)
                            .isRequired(false)
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
