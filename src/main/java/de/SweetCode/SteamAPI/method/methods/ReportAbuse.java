package de.SweetCode.SteamAPI.method.methods;

import de.SweetCode.SteamAPI.SteamHTTPMethod;
import de.SweetCode.SteamAPI.SteamHost;
import de.SweetCode.SteamAPI.SteamVersion;
import de.SweetCode.SteamAPI.SteamVisibility;
import de.SweetCode.SteamAPI.interfaces.ISteamCommunity;
import de.SweetCode.SteamAPI.method.SteamMethod;
import de.SweetCode.SteamAPI.method.SteamMethodVersion;
import de.SweetCode.SteamAPI.method.option.Option;
import de.SweetCode.SteamAPI.method.option.OptionTypes;
import de.SweetCode.SteamAPI.method.option.options.AppIDOption;
import de.SweetCode.SteamAPI.method.option.options.KeyOption;

import java.util.Collections;

public class ReportAbuse extends SteamMethod {

    public ReportAbuse(ISteamCommunity steamInterface) {
        super(
            steamInterface,
            "ReportAbuse",
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
                            .key("steamidActor")
                            .description("SteamID of user doing the reporting.")
                            .optionType(OptionTypes.UINT_64)
                            .isRequired(true)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("steamidTarget")
                            .description("SteamID of the entity being accused of abuse.")
                            .optionType(OptionTypes.UINT_64)
                            .isRequired(true)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("abuseType")
                            .description("Abuse type code (see EAbuseReportType enum).")
                            .optionType(OptionTypes.UINT_32)
                            .isRequired(true)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("contentType")
                            .description("Content type code (see ECommunityContentType enum).")
                            .optionType(OptionTypes.UINT_32)
                            .isRequired(true)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("description")
                            .description("Narrative from user.")
                            .optionType(OptionTypes.STRING)
                            .isRequired(true)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("gid")
                            .description("GID of related record (depends on content type).")
                            .optionType(OptionTypes.UINT_64)
                            .isRequired(false)
                        .build()
                    )
                .build()
            )
        );
    }

}
