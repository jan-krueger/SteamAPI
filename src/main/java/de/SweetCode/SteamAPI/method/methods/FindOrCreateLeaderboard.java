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

import java.util.Arrays;

public class FindOrCreateLeaderboard extends SteamMethod {

    public FindOrCreateLeaderboard(ISteamLeaderboards steamInterface) {
        super(
            steamInterface,
            "FindOrCreateLeaderboard",
            Arrays.asList(
                SteamMethodVersion.create()
                    .method(SteamHTTPMethod.POST)
                    .hosts(SteamHost.PUBLIC, SteamHost.PARTNER)
                    .version(SteamVersion.V_1)
                    .visibility(SteamVisibility.PUBLISHER)
                    .add(new KeyOption(false))
                    .add(new AppIDOption(true))
                    .add(
                        Option.create()
                            .key("name")
                            .description("Name of the leaderboard to delete.")
                            .optionType(OptionTypes.STRING)
                            .isRequired(true)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("sortmethod")
                            .description("Sort method to use for this leaderboard (defaults to Ascending).")
                            .optionType(OptionTypes.STRING)
                            .isRequired(false)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("displaytype")
                            .description("Display type for this leaderboard (defaults to Numeric).")
                            .optionType(OptionTypes.STRING)
                            .isRequired(false)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("createifnotfound")
                            .description("If this is true the leaderboard will be created if it doesn't exist. Defaults to true.")
                            .optionType(OptionTypes.BOOL)
                            .isRequired(false)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("onlytrustedwrites")
                            .description("If this is true the leaderboard scores cannot be set by clients, and can only be set by publisher via SetLeaderboardScore WebAPI. Defaults to false.")
                            .optionType(OptionTypes.BOOL)
                            .isRequired(false)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("onlyfriendsreads")
                            .description("If this is true the leaderboard scores can only be read for friends by clients, scores can always be read by publisher. Defaults to false.")
                            .optionType(OptionTypes.BOOL)
                            .isRequired(false)
                        .build()
                    )
                .build(),
                SteamMethodVersion.create()
                    .method(SteamHTTPMethod.POST)
                    .hosts(SteamHost.PUBLIC, SteamHost.PARTNER)
                    .version(SteamVersion.V_2)
                    .visibility(SteamVisibility.PUBLISHER)
                    .add(new KeyOption(false))
                    .add(new AppIDOption(true))
                    .add(
                        Option.create()
                            .key("name")
                            .description("Name of the leaderboard to delete.")
                            .optionType(OptionTypes.STRING)
                            .isRequired(true)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("sortmethod")
                            .description("Sort method to use for this leaderboard (defaults to Ascending).")
                            .optionType(OptionTypes.STRING)
                            .isRequired(false)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("displaytype")
                            .description("Display type for this leaderboard (defaults to Numeric).")
                            .optionType(OptionTypes.STRING)
                            .isRequired(false)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("createifnotfound")
                            .description("If this is true the leaderboard will be created if it doesn't exist. Defaults to true.")
                            .optionType(OptionTypes.BOOL)
                            .isRequired(false)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("onlytrustedwrites")
                            .description("If this is true the leaderboard scores cannot be set by clients, and can only be set by publisher via SetLeaderboardScore WebAPI. Defaults to false.")
                            .optionType(OptionTypes.BOOL)
                            .isRequired(false)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("onlyfriendsreads")
                            .description("If this is true the leaderboard scores can only be read for friends by clients, scores can always be read by publisher. Defaults to false.")
                            .optionType(OptionTypes.BOOL)
                            .isRequired(false)
                        .build()
                    )
                .build()
            )
        );
    }

}
