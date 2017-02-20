package de.SweetCode.SteamAPI.method.methods;

import de.SweetCode.SteamAPI.SteamHTTPMethod;
import de.SweetCode.SteamAPI.SteamHost;
import de.SweetCode.SteamAPI.SteamVersion;
import de.SweetCode.SteamAPI.SteamVisibility;
import de.SweetCode.SteamAPI.interfaces.ICheatReportingService;
import de.SweetCode.SteamAPI.method.SteamMethod;
import de.SweetCode.SteamAPI.method.option.Option;
import de.SweetCode.SteamAPI.method.option.OptionTypes;
import de.SweetCode.SteamAPI.method.SteamMethodVersion;
import de.SweetCode.SteamAPI.method.option.options.AppIDOption;
import de.SweetCode.SteamAPI.method.option.options.KeyOption;
import de.SweetCode.SteamAPI.method.option.options.SteamIDOption;

import java.util.Collections;

/**
 * Created by Yonas on 19.02.2017.
 */
public class ReportCheatData extends SteamMethod {

    public ReportCheatData(ICheatReportingService steamInterface) {
        super(
            steamInterface,
            "ReportCheatData",
            Collections.singletonList(
                SteamMethodVersion.create()
                    .method(SteamHTTPMethod.POST)
                    .hosts(SteamHost.PUBLIC, SteamHost.PARTNER)
                    .version(SteamVersion.V_1)
                    .visibility(SteamVisibility.ALL)
                    .add(new KeyOption(true))
                    .add(new SteamIDOption(true))
                    .add(new AppIDOption(true))
                    .add(
                        Option.create()
                            .key("pathandfilename")
                            .description("Path and file name of the cheat executable.")
                            .optionType(OptionTypes.STRING)
                            .isRequired(true)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("webcheaturl")
                            .description("Web url where the cheat was found and downloaded.")
                            .optionType(OptionTypes.STRING)
                           .isRequired(true)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("time_now")
                            .description("Local system time now.")
                            .optionType(OptionTypes.UINT_64)
                            .isRequired(true)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("time_started")
                            .description("Local system time when cheat process started. (0 if not yet run)")
                            .optionType(OptionTypes.UINT_64)
                           .isRequired(true)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("time_stopped")
                            .description("Local system time when cheat process stopped. (0 if still running)")
                            .optionType(OptionTypes.UINT_64)
                           .isRequired(true)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("cheatname")
                            .description("Descriptive name for the cheat.")
                            .optionType(OptionTypes.STRING)
                            .isRequired(true)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("game_process_id")
                            .description("Process ID of the running game.")
                            .optionType(OptionTypes.UINT_32)
                           .isRequired(true)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("cheat_process_id")
                            .description("Process ID of the cheat process that ran.")
                            .optionType(OptionTypes.UINT_32)
                            .isRequired(true)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("cheat_param_1")
                            .optionType(OptionTypes.UINT_64)
                            .isRequired(true)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("cheat_param_2")
                            .optionType(OptionTypes.UINT_64)
                            .isRequired(true)
                        .build()
                    )
                .build()
            )
        );
    }

}
