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

public class UpdateSession extends SteamMethod {

    public UpdateSession(IGameNotificationsService steamInterface) {
        super(
            steamInterface,
            "UpdateSession",
            Collections.singletonList(
                SteamMethodVersion.create()
                    .method(SteamHTTPMethod.POST)
                    .hosts(SteamHost.PUBLIC, SteamHost.PARTNER)
                    .version(SteamVersion.V_1)
                    .visibility(SteamVisibility.PUBLISHER)
                    .add(new KeyOption(true))
                    .add(new AppIDOption(true))
                    .add(
                        Option.create()
                            .key("sessionid")
                            .description("The sessionid to update.")
                            .optionType(OptionTypes.UINT_64)
                            .isRequired(true)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("title")
                            .description("The new title of the session. If not specified, the title will not be changed.")
                            .optionType(OptionTypes.STRING)
                            .isRequired(false)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("users")
                            .description("A list of users whose state will be updated to reflect the given state. If the users are not already in the session, they will be added to it.")
                            .optionType(OptionTypes.STRING)
                            .isRequired(false)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("steamid")
                            .description("steamid to make the request on behalf of -- if specified, the user must be in the session and all users being added to the session must be friends with the user.")
                            .optionType(OptionTypes.UINT_64)
                            .isRequired(false)
                        .build()
                    )
                .build()
            )
        );
    }

}
