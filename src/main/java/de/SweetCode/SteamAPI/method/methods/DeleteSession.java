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
import de.SweetCode.SteamAPI.method.option.options.SessionIDOption;
import de.SweetCode.SteamAPI.method.option.options.SteamIDOption;

import java.util.Collections;

public class DeleteSession extends SteamMethod {

    public DeleteSession(IGameNotificationsService steamInterface) {
        super(
            steamInterface,
            "DeleteSession",
            Collections.singletonList(
                SteamMethodVersion.create()
                    .method(SteamHTTPMethod.POST)
                    .hosts(SteamHost.PUBLIC, SteamHost.PARTNER)
                    .version(SteamVersion.V_1)
                    .visibility(SteamVisibility.PUBLISHER)
                    .add(new KeyOption(true))
                    .add(new AppIDOption(true))
                    .add(new SessionIDOption(true))
                    .add(
                        Option.create()
                            .key("steamid")
                            .description("steamid to make the request on behalf of -- if specified, the user must be in the session.")
                            .optionType(OptionTypes.UINT_64)
                            .isRequired(false)
                        .build()
                    )
                .build()
            )
        );
    }

}
