package de.SweetCode.SteamAPI.method.methods;

import de.SweetCode.SteamAPI.SteamHTTPMethod;
import de.SweetCode.SteamAPI.SteamHost;
import de.SweetCode.SteamAPI.SteamVersion;
import de.SweetCode.SteamAPI.SteamVisibility;
import de.SweetCode.SteamAPI.interfaces.ISteamCDN;
import de.SweetCode.SteamAPI.method.SteamMethod;
import de.SweetCode.SteamAPI.method.SteamMethodVersion;
import de.SweetCode.SteamAPI.method.option.Option;
import de.SweetCode.SteamAPI.method.option.OptionTypes;
import de.SweetCode.SteamAPI.method.option.options.KeyOption;

import java.util.Collections;

public class SetPerformanceStats extends SteamMethod {

    public SetPerformanceStats(ISteamCDN steamInterface) {
        super(
            steamInterface,
            "SetPerformanceStats",
            Collections.singletonList(
                SteamMethodVersion.create()
                    .method(SteamHTTPMethod.POST)
                    .hosts(SteamHost.PUBLIC, SteamHost.PARTNER)
                    .version(SteamVersion.V_1)
                    .visibility(SteamVisibility.ALL)
                    .add(new KeyOption(true))
                    .add(
                        Option.create()
                            .key("cdnname")
                            .description("Steam name of CDN property.")
                            .optionType(OptionTypes.STRING)
                                .isRequired(true)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("mbps_sent")
                            .description("Outgoing network traffic in Mbps.")
                            .optionType(OptionTypes.UINT_32)
                            .isRequired(false)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("mbps_recv")
                            .description("Incoming network traffic in Mbps.")
                            .optionType(OptionTypes.UINT_32)
                            .isRequired(false)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("cpu_percent")
                            .description("Percent CPU load.")
                            .optionType(OptionTypes.UINT_32)
                            .isRequired(false)
                        .build()
                    )
                    .add(
                        Option.create()
                            .key("cache_hit_percent")
                            .description("Percent cache hits.")
                            .optionType(OptionTypes.UINT_32)
                            .isRequired(false)
                        .build()
                    )
                .build()
            )
        );
    }

}
