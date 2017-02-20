package de.SweetCode.SteamAPI.method.methods;

import de.SweetCode.SteamAPI.SteamHTTPMethod;
import de.SweetCode.SteamAPI.SteamHost;
import de.SweetCode.SteamAPI.SteamVersion;
import de.SweetCode.SteamAPI.SteamVisibility;
import de.SweetCode.SteamAPI.interfaces.IPlayerService;
import de.SweetCode.SteamAPI.method.SteamMethod;
import de.SweetCode.SteamAPI.method.option.Option;
import de.SweetCode.SteamAPI.method.option.OptionTypes;
import de.SweetCode.SteamAPI.method.SteamMethodVersion;
import de.SweetCode.SteamAPI.method.option.options.KeyOption;
import de.SweetCode.SteamAPI.method.option.options.SteamIDOption;

import java.util.Collections;

public class IsPlayingSharedGame extends SteamMethod {

    public IsPlayingSharedGame(IPlayerService steamInterface) {
        super(
            steamInterface,
            "IsPlayingSharedGame",
            Collections.singletonList(
                SteamMethodVersion.create()
                    .method(SteamHTTPMethod.GET)
                    .hosts(SteamHost.PUBLIC, SteamHost.PARTNER)
                    .version(SteamVersion.V_1)
                    .visibility(SteamVisibility.ALL)
                    .add(new KeyOption(true))
                    .add(new SteamIDOption(true))
                    .add(
                        Option.create()
                            .key("appid_playing")
                            .description("The game player is currently playing.")
                            .optionType(OptionTypes.UINT_32)
                            .isRequired(true)
                        .build()
                    )
                .build()
            )
        );
    }

}
