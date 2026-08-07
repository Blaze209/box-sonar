package com.microsoft.identity.common.java.nativeauth.providers;

import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.nativeauth.BuildValues;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsOAuth2Configuration;
import com.microsoft.identity.common.java.util.UrlUtil;
import com.microsoft.identity.nativeauth.NativeAuthPublicClientApplicationConfiguration;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NativeAuthOAuth2Configuration.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001f\u0018\u0000 '2\u00020\u0001:\u0001'B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bJ\b\u0010\u0014\u001a\u00020\u0003H\u0016J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J\u0006\u0010\u0018\u001a\u00020\u0003J\u0006\u0010\u0019\u001a\u00020\u0003J\u0006\u0010\u001a\u001a\u00020\u0003J\u0006\u0010\u001b\u001a\u00020\u0003J\u0006\u0010\u001c\u001a\u00020\u0003J\u0006\u0010\u001d\u001a\u00020\u0003J\u0006\u0010\u001e\u001a\u00020\u0003J\u0006\u0010\u001f\u001a\u00020\u0003J\u0006\u0010 \u001a\u00020\u0003J\u0006\u0010!\u001a\u00020\u0003J\u0006\u0010\"\u001a\u00020\u0003J\u0006\u0010#\u001a\u00020\u0003J\u0006\u0010$\u001a\u00020\u0003J\u0006\u0010%\u001a\u00020\u0003J\u0006\u0010&\u001a\u00020\u0003R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \r*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006("}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthOAuth2Configuration;", "Lcom/microsoft/identity/common/java/providers/microsoft/microsoftsts/MicrosoftStsOAuth2Configuration;", "authorityUrl", "Ljava/net/URL;", "clientId", "", "challengeType", NativeAuthPublicClientApplicationConfiguration.NativeAuthSerializedNames.CAPABILITIES, "useMockApiForNativeAuth", "", "MOCK_API_URL_WITH_NATIVE_AUTH_TENANT", "(Ljava/net/URL;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "TAG", "kotlin.jvm.PlatformType", "getCapabilities", "()Ljava/lang/String;", "getChallengeType", "getClientId", "getUseMockApiForNativeAuth", "()Z", "getAuthorityUrl", "getEndpointUrlFromRootAndTenantAndSuffix", "root", "endpointSuffix", "getJITChallengeEndpoint", "getJITContinueEndpoint", "getJITIntrospectEndpoint", "getResetPasswordChallengeEndpoint", "getResetPasswordContinueEndpoint", "getResetPasswordPollCompletionEndpoint", "getResetPasswordStartEndpoint", "getResetPasswordSubmitEndpoint", "getSignInChallengeEndpoint", "getSignInInitiateEndpoint", "getSignInIntrospectEndpoint", "getSignInTokenEndpoint", "getSignUpChallengeEndpoint", "getSignUpContinueEndpoint", "getSignUpStartEndpoint", "Companion", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NativeAuthOAuth2Configuration extends MicrosoftStsOAuth2Configuration {
    private static final String JIT_CHALLENGE_ENDPOINT_SUFFIX = "/register/v1.0/challenge";
    private static final String JIT_CONTINUE_ENDPOINT_SUFFIX = "/register/v1.0/continue";
    private static final String JIT_INTROSPECT_ENDPOINT_SUFFIX = "/register/v1.0/introspect";
    private static final String RESET_PASSWORD_CHALLENGE_ENDPOINT_SUFFIX = "/resetpassword/v1.0/challenge";
    private static final String RESET_PASSWORD_COMPLETE_ENDPOINT_SUFFIX = "/resetpassword/v1.0/poll_completion";
    private static final String RESET_PASSWORD_CONTINUE_ENDPOINT_SUFFIX = "/resetpassword/v1.0/continue";
    private static final String RESET_PASSWORD_START_ENDPOINT_SUFFIX = "/resetpassword/v1.0/start";
    private static final String RESET_PASSWORD_SUBMIT_ENDPOINT_SUFFIX = "/resetpassword/v1.0/submit";
    private static final String SIGNUP_CHALLENGE_ENDPOINT_SUFFIX = "/signup/v1.0/challenge";
    private static final String SIGNUP_CONTINUE_ENDPOINT_SUFFIX = "/signup/v1.0/continue";
    private static final String SIGNUP_START_ENDPOINT_SUFFIX = "/signup/v1.0/start";
    private static final String SIGN_IN_CHALLENGE_ENDPOINT_SUFFIX = "/oauth2/v2.0/challenge";
    private static final String SIGN_IN_INITIATE_ENDPOINT_SUFFIX = "/oauth2/v2.0/initiate";
    private static final String SIGN_IN_INTROSPECT_ENDPOINT_SUFFIX = "/oauth2/v2.0/introspect";
    private static final String SIGN_IN_TOKEN_ENDPOINT_SUFFIX = "/oauth2/v2.0/token";
    private final String MOCK_API_URL_WITH_NATIVE_AUTH_TENANT;
    private final String TAG;
    private final URL authorityUrl;
    private final String capabilities;
    private final String challengeType;
    private final String clientId;
    private final boolean useMockApiForNativeAuth;

    public final String getClientId() {
        return this.clientId;
    }

    public final String getChallengeType() {
        return this.challengeType;
    }

    public final String getCapabilities() {
        return this.capabilities;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ NativeAuthOAuth2Configuration(URL url, String str, String str2, String str3, boolean z, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 16) != 0) {
            Boolean boolShouldUseMockApiForNativeAuth = BuildValues.shouldUseMockApiForNativeAuth();
            Intrinsics.checkNotNullExpressionValue(boolShouldUseMockApiForNativeAuth, "shouldUseMockApiForNativeAuth()");
            z = boolShouldUseMockApiForNativeAuth.booleanValue();
        }
        this(url, str, str2, str3, z, (i & 32) != 0 ? BuildValues.getMockApiUrl() + "lumonconvergedps.onmicrosoft.com" : str4);
    }

    public final boolean getUseMockApiForNativeAuth() {
        return this.useMockApiForNativeAuth;
    }

    public NativeAuthOAuth2Configuration(URL authorityUrl, String clientId, String challengeType, String str, boolean z, String MOCK_API_URL_WITH_NATIVE_AUTH_TENANT) {
        Intrinsics.checkNotNullParameter(authorityUrl, "authorityUrl");
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(challengeType, "challengeType");
        Intrinsics.checkNotNullParameter(MOCK_API_URL_WITH_NATIVE_AUTH_TENANT, "MOCK_API_URL_WITH_NATIVE_AUTH_TENANT");
        this.authorityUrl = authorityUrl;
        this.clientId = clientId;
        this.challengeType = challengeType;
        this.capabilities = str;
        this.useMockApiForNativeAuth = z;
        this.MOCK_API_URL_WITH_NATIVE_AUTH_TENANT = MOCK_API_URL_WITH_NATIVE_AUTH_TENANT;
        this.TAG = "NativeAuthOAuth2Configuration";
    }

    @Override // com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectoryOAuth2Configuration
    public URL getAuthorityUrl() {
        if (this.useMockApiForNativeAuth) {
            return new URL(this.MOCK_API_URL_WITH_NATIVE_AUTH_TENANT);
        }
        return this.authorityUrl;
    }

    public final URL getSignUpStartEndpoint() {
        return getEndpointUrlFromRootAndTenantAndSuffix(getAuthorityUrl(), SIGNUP_START_ENDPOINT_SUFFIX);
    }

    public final URL getSignUpChallengeEndpoint() {
        return getEndpointUrlFromRootAndTenantAndSuffix(getAuthorityUrl(), SIGNUP_CHALLENGE_ENDPOINT_SUFFIX);
    }

    public final URL getSignUpContinueEndpoint() {
        return getEndpointUrlFromRootAndTenantAndSuffix(getAuthorityUrl(), SIGNUP_CONTINUE_ENDPOINT_SUFFIX);
    }

    public final URL getResetPasswordStartEndpoint() {
        return getEndpointUrlFromRootAndTenantAndSuffix(getAuthorityUrl(), RESET_PASSWORD_START_ENDPOINT_SUFFIX);
    }

    public final URL getResetPasswordChallengeEndpoint() {
        return getEndpointUrlFromRootAndTenantAndSuffix(getAuthorityUrl(), RESET_PASSWORD_CHALLENGE_ENDPOINT_SUFFIX);
    }

    public final URL getResetPasswordContinueEndpoint() {
        return getEndpointUrlFromRootAndTenantAndSuffix(getAuthorityUrl(), RESET_PASSWORD_CONTINUE_ENDPOINT_SUFFIX);
    }

    public final URL getResetPasswordSubmitEndpoint() {
        return getEndpointUrlFromRootAndTenantAndSuffix(getAuthorityUrl(), RESET_PASSWORD_SUBMIT_ENDPOINT_SUFFIX);
    }

    public final URL getResetPasswordPollCompletionEndpoint() {
        return getEndpointUrlFromRootAndTenantAndSuffix(getAuthorityUrl(), RESET_PASSWORD_COMPLETE_ENDPOINT_SUFFIX);
    }

    public final URL getSignInInitiateEndpoint() {
        return getEndpointUrlFromRootAndTenantAndSuffix(getAuthorityUrl(), SIGN_IN_INITIATE_ENDPOINT_SUFFIX);
    }

    public final URL getSignInChallengeEndpoint() {
        return getEndpointUrlFromRootAndTenantAndSuffix(getAuthorityUrl(), SIGN_IN_CHALLENGE_ENDPOINT_SUFFIX);
    }

    public final URL getSignInIntrospectEndpoint() {
        return getEndpointUrlFromRootAndTenantAndSuffix(getAuthorityUrl(), SIGN_IN_INTROSPECT_ENDPOINT_SUFFIX);
    }

    public final URL getSignInTokenEndpoint() {
        return getEndpointUrlFromRootAndTenantAndSuffix(getAuthorityUrl(), SIGN_IN_TOKEN_ENDPOINT_SUFFIX);
    }

    public final URL getJITIntrospectEndpoint() {
        return getEndpointUrlFromRootAndTenantAndSuffix(getAuthorityUrl(), JIT_INTROSPECT_ENDPOINT_SUFFIX);
    }

    public final URL getJITChallengeEndpoint() {
        return getEndpointUrlFromRootAndTenantAndSuffix(getAuthorityUrl(), JIT_CHALLENGE_ENDPOINT_SUFFIX);
    }

    public final URL getJITContinueEndpoint() {
        return getEndpointUrlFromRootAndTenantAndSuffix(getAuthorityUrl(), JIT_CONTINUE_ENDPOINT_SUFFIX);
    }

    private final URL getEndpointUrlFromRootAndTenantAndSuffix(URL root, String endpointSuffix) throws MalformedURLException, URISyntaxException {
        URL urlAppendPathToURL;
        try {
            String dc = BuildValues.getDC();
            Intrinsics.checkNotNullExpressionValue(dc, "getDC()");
            if (dc.length() > 0) {
                urlAppendPathToURL = UrlUtil.appendPathAndQueryToURL(root, endpointSuffix, MapsKt.mapOf(TuplesKt.to("dc", BuildValues.getDC())));
            } else {
                urlAppendPathToURL = UrlUtil.appendPathToURL(root, endpointSuffix);
            }
            Intrinsics.checkNotNullExpressionValue(urlAppendPathToURL, "{\n            if (BuildV…)\n            }\n        }");
            return urlAppendPathToURL;
        } catch (MalformedURLException e) {
            Logger.error(this.TAG, "appendPathToURL failed", e);
            throw e;
        } catch (URISyntaxException e2) {
            Logger.error(this.TAG, "appendPathToURL failed", e2);
            throw e2;
        }
    }
}
