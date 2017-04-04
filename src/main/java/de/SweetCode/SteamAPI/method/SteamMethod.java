package de.SweetCode.SteamAPI.method;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import de.SweetCode.SteamAPI.SteamHTTPMethod;
import de.SweetCode.SteamAPI.SteamHost;
import de.SweetCode.SteamAPI.SteamVersion;
import de.SweetCode.SteamAPI.SteamVisibility;
import de.SweetCode.SteamAPI.exceptions.SteamCombinationException;
import de.SweetCode.SteamAPI.interfaces.SteamInterface;
import de.SweetCode.SteamAPI.method.input.Input;
import okhttp3.*;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * <p>
 *    The steam API is divided into <b>interfaces</b>, <b>methods</b> and <b>versions</b>. - This class represents the
 *    abstract idea of the <b>Steam Method</b>.
 * </p>
 */
public abstract class SteamMethod {

    private final static Gson GSON = new Gson();
    private final static MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");

    private SteamInterface steamInterface;

    private final String name;
    private final List<SteamMethodVersion> versions;

    /**
     * <p>
     *    A constructor to create a SteamMethod.
     * </p>
     *
     * @param steamInterface The SteamInterface the method belongs to.
     * @param name The name of the method which can be directly used in URLs to access the API.
     * @param versions A list with all various method versions the method supports.
     */
    public SteamMethod(SteamInterface steamInterface, String name, List<SteamMethodVersion> versions) {
        this.steamInterface = steamInterface;
        this.name = name;
        this.versions = versions;
    }

    /**
     * <p>
     *    Gives the name of the method which can be directly used in URLs to access the API.
     * </p>
     *
     * @return Always string, never null.
     */
    public String getName() {
        return this.name;
    }

    /**
     * <p>
     *     Gives the related {@link SteamInterface}.
     * </p>
     *
     * @return the interface, never null.
     */
    public SteamInterface getInterface() {
        return this.steamInterface;
    }

    /**
     * <p>
     *    Gives a set of all supported {@link SteamHost hosts}.
     * </p>
     *
     * @return A set of all supported hosts. Is never null.
     */
    public Set<SteamHTTPMethod> getSupportedMethods() {
        HashSet<SteamHTTPMethod> values = new HashSet<>();
        this.versions.forEach(e -> values.add(e.getMethod()));
        return values;
    }

    /**
     * <p>
     *    Gives a set of all supported {@link SteamHost hosts}.
     * </p>
     *
     * @return A set of all supported hosts. Is never null.
     */
    public Set<SteamHost> getSupportedHosts() {
        HashSet<SteamHost> values = new HashSet<>();
        this.versions.forEach(e -> values.addAll(e.getHosts()));
        return values;
    }

    /**
     * <p>
     *    Gives a set of all supported {@link SteamVersion versions}.
     * </p>
     *
     * @return A set of all supported versions. Is never null.
     */
    public Set<SteamVersion> getSupportedVersions() {
        HashSet<SteamVersion> values = new HashSet<>();
        this.versions.forEach(e -> values.add(e.getVersion()));
        return values;
    }

    /**
     * <p>
     *    Gives a set of all supported {@link SteamVisibility visibilities}.
     * </p>
     *
     * @return A set of all supported visibilities. Is never null.
     */
    public Set<SteamVisibility> getSupportedVisibilities() {
        HashSet<SteamVisibility> values = new HashSet<>();
        this.versions.forEach(e -> values.add(e.getVisibility()));
        return values;
    }

    /**
     * <p>
     *    Gives a list of all supported {@link SteamMethodVersion method versions}.
     * </p>
     *
     * @return a list of all supported method variations.
     */
    public List<SteamMethodVersion> getVersions() {
        return this.versions;
    }

    /**
     * <p>
     *     Gives the {@link SteamMethodVersion} belonging to the provided configuration of host and version.
     * </p>
     *
     * @param method The HTTP request of the method.
     * @param host The SteamHost the method can access.
     * @param version The version of the Steam method.
     * @param visibility The visibility of the method.
     *
     * @return an Optional containing the SteamMethodVersion if they exist for the provided configuration.
     */
    public Optional<SteamMethodVersion> get(SteamHTTPMethod method, SteamHost host, SteamVersion version, SteamVisibility visibility) {
        return this.versions
                .stream()
                .filter(e ->
                    e.getMethod() == method &&
                    e.getHosts().contains(host) &&
                    e.getVersion() == version &&
                    (e.getVisibility() == SteamVisibility.ALL || e.getVisibility() == visibility)
                )
                .findAny();
    }

    /**
     * <p>
     *     Checks if the method supports the HTTP request method.
     * </p>
     *
     * @param method The HTTP request method to check.
     *
     * @return True, if the method supports the HTTP request method, otherwise false.
     */
    public boolean supports(SteamHTTPMethod method) {
        return this.versions.stream().anyMatch(e -> e.getMethod() == method);
    }

    /**
     * <p>
     *     Checks if the method supports the host.
     * </p>
     *
     * @param host The host to check.
     *
     * @return True, if the method supports the host, otherwise false.
     */
    public boolean supports(SteamHost host) {
        return this.versions.stream().anyMatch(e -> e.getHosts().contains(host));
    }

    /**
     * <p>
     *     Checks if the method supports the version.
     * </p>
     *
     * @param version The version to check.
     *
     * @return True, if the method supports the version, otherwise false.
     */
    public boolean supports(SteamVersion version) {
        return this.versions.stream().anyMatch(e -> e.getVersion() == version);
    }

    /**
     * <p>
     *     Checks if the method supports the visibility.
     * </p>
     *
     * @param visibility The visibility to check.
     *
     * @return True, if the method supports the visibility, otherwise false.
     */
    public boolean supports(SteamVisibility visibility) {
        return this.versions.stream().anyMatch(e -> e.getVisibility() == visibility);
    }

    /**
     * <p>
     *    Can be used to verify that the host and version are not null and that that both of them are supported by the method. -
     *    The method throws a {@link RuntimeException} if one of the requirements is not met.
     * </p>
     *
     * @param method The HTTP request method to check.
     * @param host The host to check.
     * @param version The version to check.
     * @param visibility The visibility to check.
     */
    private void verify(SteamHTTPMethod method, SteamHost host, SteamVersion version, SteamVisibility visibility) {

        //--- Check if the method is null OR not supported
        if(method == null) {
            throw new IllegalArgumentException("The SteamHTTPMethod cannot be null.");
        }

        if(!(this.supports(method))) {
            throw new IllegalArgumentException(String.format(
                "The SteamMethod %s DOES NOT support the provided HTTP request method %s. The method only supports: %s.",
                this.getName(),
                method.name(),
                StringUtils.join(this.getSupportedMethods(), ", ")
            ));
        }

        //--- Check if the host is null OR not supported
        if(host == null) {
            throw new IllegalArgumentException("The SteamHost cannot be null.");
        }

        if(!(this.supports(host))) {
            throw new IllegalArgumentException(String.format(
                "The SteamMethod %s DOES NOT support the provided host %s. The method only supports: %s.",
                this.getName(),
                host.name(),
                StringUtils.join(this.getSupportedHosts(), ", ")
            ));
        }

        //--- Check version is null OR not supported
        if(version == null) {
            throw new IllegalArgumentException("The SteamVersion cannot be null.");
        }

        if(!(this.supports(version))) {
            throw new IllegalArgumentException(String.format(
                "The SteamMethod %s DOES NOT support the provided version %s. The method only supports: %s.",
                this.getName(),
                version.name(),
                StringUtils.join(this.getSupportedVersions(), ", ")
            ));
        }

        //--- Check if visibility is null OR not supported
        if(visibility == null) {
            throw new IllegalArgumentException("The SteamHTTPMethod cannot be null.");
        }

        if(!(this.supports(visibility))) {
            throw new IllegalArgumentException(String.format(
                "The SteamMethod %s DOES NOT support the provided visibility %s. The method only supports: %s.",
                visibility.name(),
                this.getSupportedVisibilities()
            ));
        }

        //--- Check if the method supports the host in combination WITH the version AND HTTP request method
        if(!(this.get(method, host, version, visibility).isPresent())) {
            throw new SteamCombinationException(this, method, host, version, visibility);
        }

    }

    /**
     * <p>
     *     Executes the method with the provided parameters.
     * </p>
     *
     * @param method The HTTP request method.
     * @param host The host used to perform the request.
     * @param version The version of the method.
     * @param visibility The visibility of the method.
     * @param input The required input.
     * @param callback The callback to onResponse when done.
     * @param async True, if the API should run an async onResponse, otherwise false.
     */
    public void execute(SteamHTTPMethod method, SteamHost host, SteamVersion version, SteamVisibility visibility, Input input, SteamResponse callback, boolean async) {

        //--- if required append Steam API key
        if(!(input.contains("key")) && !(this.getInterface().getSteam().getKey() == null)) {
            input.add("key", this.getInterface().getSteam().getKey());
        }

        //--- Verify input & grab correct version
        this.verify(method, host, version, visibility);

        SteamMethodVersion methodVersion = this.get(method, host, version, visibility).get();

        //--- Verify input
        if(methodVersion.verify(this, host, input)) {

            Request request = SteamMethod.buildRequest(this, method, host, version, input);
            try {

                //--- sending the request

                if(async) {
                    this.getInterface().getSteam().getClient().newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            callback.onError(e.getMessage());
                        }

                        @Override
                        public void onResponse(Call call, Response response) {
                            //--- parse the body if possible
                            Optional<JsonObject> parsedBody = Optional.empty();

                            try {
                                parsedBody = Optional.ofNullable(GSON.fromJson(response.body().string(), JsonObject.class));
                            } catch (JsonSyntaxException e) {
                                callback.onResponse(request, response, Optional.empty());
                                return;
                            } catch (IOException e) {
                                callback.onError(e.getMessage());
                                return;
                            }

                            //--- calling the provided callback
                            callback.onResponse(request, response, parsedBody);
                            response.close();

                        }
                    });
                }
                //--- sync request
                else {
                    Response response = this.getInterface().getSteam().getClient().newCall(request).execute();

                    //--- parse the body if possible
                    Optional<JsonObject> parsedBody = Optional.empty();

                    if(!(response == null)) {
                        try {
                            parsedBody = Optional.ofNullable(GSON.fromJson(response.body().string(), JsonObject.class));
                        } catch (JsonSyntaxException e) {
                            callback.onResponse(request, response, Optional.empty());
                            return;
                        } catch (IOException e) {
                            callback.onError(e.getMessage());
                            return;
                        }

                        //--- calling the provided callback
                        callback.onResponse(request, response, parsedBody);
                        return;
                    }

                    callback.onError("Invalid response.");
                }

            } catch (IOException e) {
                callback.onError(e.getMessage());
            }

            return;
        }

        throw new IllegalStateException("We never should hit this point. Please open a new issue on github.com/sweetcode/SteamAPI with" +
                " details about the request. DO NOT forget to exclude your Steam API Key if you used one or one is visible in the code" +
                " or information you are providing on GitHub.");

    }

    /**
     * <p>
     *    Builds a {@link Request}.
     * </p>
     * @param steamMethod The steam method calling the buildRequest method.
     * @param method The HTTP request method to use.
     * @param host The host to send the request to.
     * @param version The version of the method.
     * @param input The input.
     *
     * @return a ready-to-use request, never null.
     */
    private static Request buildRequest(SteamMethod steamMethod, SteamHTTPMethod method, SteamHost host, SteamVersion version, Input input) {

        //--- Build URL
        HttpUrl.Builder url = HttpUrl.parse(String.format(
            "https://%s/%s/%s/%s/",
            host.getHost(),
            steamMethod.getInterface().getName(),
            steamMethod.getName(),
            version.getUrlVersion()
        )).newBuilder();
        url.addQueryParameter("format", "json");

        //--- Build Request
        Request.Builder builder = new Request.Builder();

        switch (method) {

            case GET: {
                //--- Append all parameters to the url
                builder.get();
                input.getValues().entrySet().forEach(e -> url.addQueryParameter(e.getKey(), String.valueOf(e.getValue())));
            }
            break;

            case POST: {
                //--- Build a JSON payload and set it as request body
                JsonObject payload = new JsonObject();
                input.getValues().entrySet().forEach(e -> payload.addProperty(e.getKey(), String.valueOf(e.getValue())));

                builder.post(RequestBody.create(MEDIA_TYPE_JSON, GSON.toJson(payload)));
            }
            break;

        }

        //--- Append url
        builder.url(url.build());

        return builder.build();

    }


}
