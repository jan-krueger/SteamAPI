package de.SweetCode.SteamAPI.method.methods;

import de.SweetCode.SteamAPI.SteamHTTPMethod;
import de.SweetCode.SteamAPI.SteamHost;
import de.SweetCode.SteamAPI.SteamVersion;
import de.SweetCode.SteamAPI.SteamVisibility;
import de.SweetCode.SteamAPI.interfaces.ISteamNews;
import de.SweetCode.SteamAPI.method.SteamMethod;
import de.SweetCode.SteamAPI.method.SteamMethodVersion;
import de.SweetCode.SteamAPI.method.option.Option;
import de.SweetCode.SteamAPI.method.option.OptionTypes;
import de.SweetCode.SteamAPI.method.option.options.AppIDOption;
import de.SweetCode.SteamAPI.method.option.options.CountOption;
import de.SweetCode.SteamAPI.method.option.options.KeyOption;

import java.util.Arrays;

public class GetNewsForAppAuthed extends SteamMethod {

    public GetNewsForAppAuthed(ISteamNews steamInterface) {
        super(
            steamInterface,
            "GetNewsForAppAuthed",
            Arrays.asList(
                SteamMethodVersion.create()
                    .method(SteamHTTPMethod.GET)
                    .hosts(SteamHost.PUBLIC, SteamHost.PARTNER)
                    .version(SteamVersion.V_1)
                    .visibility(SteamVisibility.ALL)
                    .add(new KeyOption(false))
                    .add(new AppIDOption(true))
                    .add(new CountOption(false))
                    .add(
                        Option.create()
                            .key("maxlength")
                            .description("Maximum length for the content to return, if this is 0 the full content is returned, if it's less then a blurb is generated to fit.")
                            .optionType(OptionTypes.UINT_32)
                            .isRequired(false)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("enddate")
                            .description("Retrieve posts earlier than this date (unix epoch timestamp).")
                            .optionType(OptionTypes.UINT_32)
                            .isRequired(false)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("feeds")
                            .description("Comma-separated list of feed names to return news for.")
                            .isRequired(false)
                            .optionType(OptionTypes.STRING)
                        .build()
                    )
                .build(),
                SteamMethodVersion.create()
                    .method(SteamHTTPMethod.GET)
                    .hosts(SteamHost.PUBLIC, SteamHost.PARTNER)
                    .version(SteamVersion.V_2)
                    .visibility(SteamVisibility.ALL)
                    .add(new KeyOption(false))
                    .add(new AppIDOption(true))
                    .add(new CountOption(false))
                    .add(
                        Option.create()
                            .key("maxlength")
                            .description("Maximum length for the content to return, if this is 0 the full content is returned, if it's less then a blurb is generated to fit.")
                            .optionType(OptionTypes.UINT_32)
                            .isRequired(false)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("enddate")
                            .description("Retrieve posts earlier than this date (unix epoch timestamp).")
                            .optionType(OptionTypes.UINT_32)
                            .isRequired(false)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("feeds")
                            .description("Comma-separated list of feed names to return news for.")
                            .isRequired(false)
                            .optionType(OptionTypes.STRING)
                        .build()
                    )
                .build()
            )
        );
    }

}
