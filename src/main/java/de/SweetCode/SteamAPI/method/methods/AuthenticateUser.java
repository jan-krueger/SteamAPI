package de.SweetCode.SteamAPI.method.methods;

import de.SweetCode.SteamAPI.SteamHTTPMethod;
import de.SweetCode.SteamAPI.SteamHost;
import de.SweetCode.SteamAPI.SteamVersion;
import de.SweetCode.SteamAPI.SteamVisibility;
import de.SweetCode.SteamAPI.interfaces.ISteamUserAuth;
import de.SweetCode.SteamAPI.method.SteamMethod;
import de.SweetCode.SteamAPI.method.SteamMethodVersion;
import de.SweetCode.SteamAPI.method.option.Option;
import de.SweetCode.SteamAPI.method.option.OptionTypes;
import de.SweetCode.SteamAPI.method.option.options.KeyOption;
import de.SweetCode.SteamAPI.method.option.options.SteamIDOption;

import java.util.Collections;

public class AuthenticateUser extends SteamMethod {

    public AuthenticateUser(ISteamUserAuth steamInterface) {
        super(
            steamInterface,
            "AuthenticateUser",
            Collections.singletonList(
                SteamMethodVersion.create()
                    .method(SteamHTTPMethod.POST)
                    .hosts(SteamHost.PUBLIC, SteamHost.PARTNER)
                    .version(SteamVersion.V_1)
                    .visibility(SteamVisibility.ALL)
                    .add(new KeyOption(false))
                    .add(new SteamIDOption(true))
                    .add(
                        Option.create()
                            .key("sessionkey")
                            .description("Should be a 32 byte random blob of data, which is then encrypted with RSA using the Steam system's public key. Randomness is important here for security.")
                            .optionType(OptionTypes.RAW_BINARY)
                            .isRequired(true)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("encrypted_loginkey")
                            .description("Should be the users hashed loginkey, AES encrypted with the sessionkey.")
                            .optionType(OptionTypes.RAW_BINARY)
                            .isRequired(true)
                        .build()
                    )
                .build()
            )
        );
    }

}
