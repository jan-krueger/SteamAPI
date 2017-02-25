package de.SweetCode.SteamAPI.method.methods;

import de.SweetCode.SteamAPI.SteamHTTPMethod;
import de.SweetCode.SteamAPI.SteamHost;
import de.SweetCode.SteamAPI.SteamVersion;
import de.SweetCode.SteamAPI.SteamVisibility;
import de.SweetCode.SteamAPI.interfaces.ISteamLeaderboards;
import de.SweetCode.SteamAPI.method.SteamMethod;
import de.SweetCode.SteamAPI.method.SteamMethodVersion;
import de.SweetCode.SteamAPI.method.option.Option;
import de.SweetCode.SteamAPI.method.option.OptionTypes;
import de.SweetCode.SteamAPI.method.option.options.AppIDOption;
import de.SweetCode.SteamAPI.method.option.options.KeyOption;
import de.SweetCode.SteamAPI.method.option.options.SteamIDOption;

import java.util.Collections;

public class SetLeaderboardScore extends SteamMethod {

    public SetLeaderboardScore(ISteamLeaderboards steamInterface) {
        super(
            steamInterface,
            "SetLeaderboardScore",
            Collections.singletonList(
                SteamMethodVersion.create()
                    .method(SteamHTTPMethod.POST)
                    .hosts(SteamHost.PUBLIC, SteamHost.PARTNER)
                    .version(SteamVersion.V_1)
                    .visibility(SteamVisibility.PUBLISHER)
                    .add(new KeyOption(false))
                    .add(new AppIDOption(true))
                    .add(new SteamIDOption(true))
                    .add(
                        Option.create()
                            .key("leaderboardid")
                            .description("Numeric ID of the target leaderboard. Can be retrieved from GetLeaderboardsForGame.")
                            .optionType(OptionTypes.UINT_32)
                            .isRequired(true)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("score")
                            .description("The score to set for this user.")
                            .optionType(OptionTypes.INT_32)
                            .isRequired(true)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("scoremethod")
                            .description("Uupdate method to use. Can be \"KeepBest\" or \"ForceUpdate\".")
                            .optionType(OptionTypes.STRING)
                            .isRequired(true)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("details")
                            .description("Game-specific details for how the score was earned. Up to 256 bytes.")
                            .optionType(OptionTypes.RAW_BINARY)
                            .isRequired(false)
                        .build()
                    )
                .build()
            )
        );
    }

}
