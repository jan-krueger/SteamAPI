package de.SweetCode.SteamAPI.method.methods;

import de.SweetCode.SteamAPI.SteamHTTPMethod;
import de.SweetCode.SteamAPI.SteamHost;
import de.SweetCode.SteamAPI.SteamVersion;
import de.SweetCode.SteamAPI.SteamVisibility;
import de.SweetCode.SteamAPI.interfaces.IGameNotificationsService;
import de.SweetCode.SteamAPI.method.SteamMethod;
import de.SweetCode.SteamAPI.method.SteamMethodVersion;
import de.SweetCode.SteamAPI.method.option.Option;
import de.SweetCode.SteamAPI.method.option.OptionTypes;
import de.SweetCode.SteamAPI.method.option.options.AppIDOption;
import de.SweetCode.SteamAPI.method.option.options.KeyOption;

import java.util.Collections;

public class EnumerateSessionsForApp extends SteamMethod {

    public EnumerateSessionsForApp(IGameNotificationsService steamInterface) {
        super(
            steamInterface,
            "EnumerateSessionsForApp",
            Collections.singletonList(
                SteamMethodVersion.create()
                    .method(SteamHTTPMethod.GET)
                    .hosts(SteamHost.PUBLIC, SteamHost.PARTNER)
                    .version(SteamVersion.V_1)
                    .visibility(SteamVisibility.PUBLISHER)
                    .add(new KeyOption(true))
                    .add(new AppIDOption(true))
                    .add(
                        Option.create()
                            .key("steamid")
                            .description("The user whose sessions are to be enumerated.")
                            .optionType(OptionTypes.UINT_64)
                            .isRequired(true)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("include_all_user_messages")
                            .description("Boolean determining whether the message for all users should be included. Defaults to false.")
                            .optionType(OptionTypes.BOOL)
                            .isRequired(false)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("include_auth_user_message")
                            .description("Boolean determining whether the message for the authenticated user should be included. Defaults to false.")
                            .optionType(OptionTypes.BOOL)
                            .isRequired(false)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("language")
                            .description("Language to localize the text in.")
                            .optionType(OptionTypes.STRING)
                            .isRequired(false)
                        .build()
                    )
                .build()
            )
        );
    }

}
