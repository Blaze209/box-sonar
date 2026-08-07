package com.microsoft.identity.common.java.nativeauth.providers.requests.signin;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import com.microsoft.identity.common.java.nativeauth.providers.requests.NativeAuthRequest;
import com.microsoft.identity.common.java.util.ArgUtils;
import com.microsoft.identity.common.java.util.CharArrayJsonAdapter;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SignInTokenRequest.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0002 !B-\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J5\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\b\u0010\u001e\u001a\u00020\u0006H\u0016J\b\u0010\u001f\u001a\u00020\u0006H\u0016R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\""}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signin/SignInTokenRequest;", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/NativeAuthRequest;", "requestUrl", "Ljava/net/URL;", "headers", "", "", "parameters", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signin/SignInTokenRequest$NativeAuthRequestSignInTokenRequestParameters;", "(Ljava/net/URL;Ljava/util/Map;Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signin/SignInTokenRequest$NativeAuthRequestSignInTokenRequestParameters;)V", "getHeaders", "()Ljava/util/Map;", "setHeaders", "(Ljava/util/Map;)V", "getParameters", "()Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signin/SignInTokenRequest$NativeAuthRequestSignInTokenRequestParameters;", "getRequestUrl", "()Ljava/net/URL;", "setRequestUrl", "(Ljava/net/URL;)V", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "Companion", "NativeAuthRequestSignInTokenRequestParameters", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SignInTokenRequest extends NativeAuthRequest {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Map<String, String> headers;
    private final NativeAuthRequestSignInTokenRequestParameters parameters;
    private URL requestUrl;

    public /* synthetic */ SignInTokenRequest(URL url, Map map, NativeAuthRequestSignInTokenRequestParameters nativeAuthRequestSignInTokenRequestParameters, DefaultConstructorMarker defaultConstructorMarker) {
        this(url, map, nativeAuthRequestSignInTokenRequestParameters);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SignInTokenRequest copy$default(SignInTokenRequest signInTokenRequest, URL url, Map map, NativeAuthRequestSignInTokenRequestParameters nativeAuthRequestSignInTokenRequestParameters, int i, Object obj) {
        if ((i & 1) != 0) {
            url = signInTokenRequest.getRequestUrl();
        }
        if ((i & 2) != 0) {
            map = signInTokenRequest.getHeaders();
        }
        if ((i & 4) != 0) {
            nativeAuthRequestSignInTokenRequestParameters = signInTokenRequest.getParameters();
        }
        return signInTokenRequest.copy(url, map, nativeAuthRequestSignInTokenRequestParameters);
    }

    public final URL component1() {
        return getRequestUrl();
    }

    public final Map<String, String> component2() {
        return getHeaders();
    }

    public final NativeAuthRequestSignInTokenRequestParameters component3() {
        return getParameters();
    }

    public final SignInTokenRequest copy(URL requestUrl, Map<String, String> headers, NativeAuthRequestSignInTokenRequestParameters parameters) {
        Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        return new SignInTokenRequest(requestUrl, headers, parameters);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SignInTokenRequest)) {
            return false;
        }
        SignInTokenRequest signInTokenRequest = (SignInTokenRequest) other;
        return Intrinsics.areEqual(getRequestUrl(), signInTokenRequest.getRequestUrl()) && Intrinsics.areEqual(getHeaders(), signInTokenRequest.getHeaders()) && Intrinsics.areEqual(getParameters(), signInTokenRequest.getParameters());
    }

    public int hashCode() {
        return (((getRequestUrl().hashCode() * 31) + getHeaders().hashCode()) * 31) + getParameters().hashCode();
    }

    @Override // com.microsoft.identity.common.java.nativeauth.providers.requests.NativeAuthRequest
    public URL getRequestUrl() {
        return this.requestUrl;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.providers.requests.NativeAuthRequest
    public void setRequestUrl(URL url) {
        Intrinsics.checkNotNullParameter(url, "<set-?>");
        this.requestUrl = url;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.providers.requests.NativeAuthRequest
    public Map<String, String> getHeaders() {
        return this.headers;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.providers.requests.NativeAuthRequest
    public void setHeaders(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.headers = map;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.providers.requests.NativeAuthRequest
    public NativeAuthRequestSignInTokenRequestParameters getParameters() {
        return this.parameters;
    }

    private SignInTokenRequest(URL url, Map<String, String> map, NativeAuthRequestSignInTokenRequestParameters nativeAuthRequestSignInTokenRequestParameters) {
        this.requestUrl = url;
        this.headers = map;
        this.parameters = nativeAuthRequestSignInTokenRequestParameters;
    }

    /* JADX INFO: compiled from: SignInTokenRequest.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jf\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u00062\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006Jl\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u00062\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u0013Jd\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u00062\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006¨\u0006\u0017"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signin/SignInTokenRequest$Companion;", "", "()V", "createContinuationTokenRequest", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signin/SignInTokenRequest;", "continuationToken", "", "clientId", "username", "scopes", "", "challengeType", "requestUrl", "headers", "", "claimsRequestJson", "createOOBTokenRequest", "oob", "isMFAGrantType", "", "createPasswordTokenRequest", "password", "", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SignInTokenRequest createOOBTokenRequest$default(Companion companion, String str, String str2, String str3, List list, String str4, String str5, Map map, String str6, boolean z, int i, Object obj) {
            if ((i & 8) != 0) {
                list = null;
            }
            if ((i & 16) != 0) {
                str4 = null;
            }
            return companion.createOOBTokenRequest(str, str2, str3, list, str4, str5, map, str6, z);
        }

        public final SignInTokenRequest createOOBTokenRequest(String oob, String continuationToken, String clientId, List<String> scopes, String challengeType, String requestUrl, Map<String, String> headers, String claimsRequestJson, boolean isMFAGrantType) throws ClientException {
            Object obj;
            String strJoinToString$default;
            Intrinsics.checkNotNullParameter(oob, "oob");
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
            Intrinsics.checkNotNullParameter(headers, "headers");
            ArgUtils.INSTANCE.validateNonNullArg(oob, "oob");
            ArgUtils.INSTANCE.validateNonNullArg(continuationToken, "continuationToken");
            ArgUtils.INSTANCE.validateNonNullArg(clientId, "clientId");
            ArgUtils.INSTANCE.validateNonNullArg(challengeType, "challengeType");
            ArgUtils.INSTANCE.validateNonNullArg(requestUrl, "requestUrl");
            ArgUtils.INSTANCE.validateNonNullArg(headers, "headers");
            String str = isMFAGrantType ? NativeAuthConstants.GrantType.MFA_OOB : "oob";
            if (scopes != null) {
                strJoinToString$default = CollectionsKt.joinToString$default(scopes, " ", null, null, 0, null, null, 62, null);
                obj = null;
            } else {
                obj = null;
                strJoinToString$default = null;
            }
            return new SignInTokenRequest(new URL(requestUrl), headers, new NativeAuthRequestSignInTokenRequestParameters(null, null, oob, null, false, clientId, str, continuationToken, strJoinToString$default, challengeType, claimsRequestJson, 27, null), null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SignInTokenRequest createPasswordTokenRequest$default(Companion companion, char[] cArr, String str, String str2, List list, String str3, String str4, Map map, String str5, int i, Object obj) {
            if ((i & 8) != 0) {
                list = null;
            }
            if ((i & 16) != 0) {
                str3 = null;
            }
            return companion.createPasswordTokenRequest(cArr, str, str2, list, str3, str4, map, str5);
        }

        public final SignInTokenRequest createPasswordTokenRequest(char[] password, String continuationToken, String clientId, List<String> scopes, String challengeType, String requestUrl, Map<String, String> headers, String claimsRequestJson) throws ClientException {
            Object obj;
            String strJoinToString$default;
            Intrinsics.checkNotNullParameter(password, "password");
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
            Intrinsics.checkNotNullParameter(headers, "headers");
            ArgUtils.INSTANCE.validateNonNullArg(password, "password");
            ArgUtils.INSTANCE.validateNonNullArg(continuationToken, "continuationToken");
            ArgUtils.INSTANCE.validateNonNullArg(clientId, "clientId");
            ArgUtils.INSTANCE.validateNonNullArg(challengeType, "challengeType");
            ArgUtils.INSTANCE.validateNonNullArg(requestUrl, "requestUrl");
            ArgUtils.INSTANCE.validateNonNullArg(headers, "headers");
            if (scopes != null) {
                strJoinToString$default = CollectionsKt.joinToString$default(scopes, " ", null, null, 0, null, null, 62, null);
                obj = null;
            } else {
                obj = null;
                strJoinToString$default = null;
            }
            return new SignInTokenRequest(new URL(requestUrl), headers, new NativeAuthRequestSignInTokenRequestParameters(null, password, null, null, false, clientId, "password", continuationToken, strJoinToString$default, challengeType, claimsRequestJson, 29, null), null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SignInTokenRequest createContinuationTokenRequest$default(Companion companion, String str, String str2, String str3, List list, String str4, String str5, Map map, String str6, int i, Object obj) {
            if ((i & 8) != 0) {
                list = null;
            }
            if ((i & 16) != 0) {
                str4 = null;
            }
            return companion.createContinuationTokenRequest(str, str2, str3, list, str4, str5, map, str6);
        }

        public final SignInTokenRequest createContinuationTokenRequest(String continuationToken, String clientId, String username, List<String> scopes, String challengeType, String requestUrl, Map<String, String> headers, String claimsRequestJson) throws ClientException {
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
            Intrinsics.checkNotNullParameter(headers, "headers");
            ArgUtils.INSTANCE.validateNonNullArg(continuationToken, "continuationToken");
            ArgUtils.INSTANCE.validateNonNullArg(clientId, "clientId");
            ArgUtils.INSTANCE.validateNonNullArg(challengeType, "challengeType");
            ArgUtils.INSTANCE.validateNonNullArg(requestUrl, "requestUrl");
            ArgUtils.INSTANCE.validateNonNullArg(headers, "headers");
            return new SignInTokenRequest(new URL(requestUrl), headers, new NativeAuthRequestSignInTokenRequestParameters(username, null, null, null, false, clientId, NativeAuthConstants.GrantType.CONTINUATION_TOKEN, continuationToken, scopes != null ? CollectionsKt.joinToString$default(scopes, " ", null, null, 0, null, null, 62, null) : null, challengeType, claimsRequestJson, 30, null), null);
        }
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toUnsanitizedString() {
        return "SignInTokenRequest(requestUrl=" + getRequestUrl() + ", headers=" + getHeaders() + ", parameters=" + getParameters() + ')';
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toString() {
        return "SignInTokenRequest()";
    }

    /* JADX INFO: compiled from: SignInTokenRequest.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b$\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001By\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0019J\t\u0010&\u001a\u00020\nHÂ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u008c\u0001\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020\n2\b\u0010.\u001a\u0004\u0018\u00010/HÖ\u0003J\t\u00100\u001a\u00020\bHÖ\u0001J\b\u00101\u001a\u00020\u0003H\u0016J\b\u00102\u001a\u00020\u0003H\u0016R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0016\u0010\u000b\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0010\u0010\t\u001a\u00020\n8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013¨\u00063"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signin/SignInTokenRequest$NativeAuthRequestSignInTokenRequestParameters;", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/NativeAuthRequest$NativeAuthRequestParameters;", "username", "", "password", "", "oob", "nca", "", "clientInfo", "", "clientId", "grantType", "continuationToken", "scope", "challengeType", "claimsRequestJson", "(Ljava/lang/String;[CLjava/lang/String;Ljava/lang/Integer;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChallengeType", "()Ljava/lang/String;", "getClaimsRequestJson", "getClientId", "getContinuationToken", "getGrantType", "getNca", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getOob", "getPassword", "()[C", "getScope", "getUsername", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;[CLjava/lang/String;Ljava/lang/Integer;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signin/SignInTokenRequest$NativeAuthRequestSignInTokenRequestParameters;", "equals", "other", "", "hashCode", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class NativeAuthRequestSignInTokenRequestParameters extends NativeAuthRequest.NativeAuthRequestParameters {

        @SerializedName("challenge_type")
        private final String challengeType;

        @SerializedName("claims")
        private final String claimsRequestJson;

        @SerializedName("client_id")
        private final String clientId;

        @SerializedName("client_info")
        private final boolean clientInfo;

        @SerializedName(NativeAuthConstants.GrantType.CONTINUATION_TOKEN)
        private final String continuationToken;

        @SerializedName("grant_type")
        private final String grantType;

        @SerializedName("nca")
        private final Integer nca;
        private final String oob;

        @JsonAdapter(CharArrayJsonAdapter.class)
        private final char[] password;

        @SerializedName("scope")
        private final String scope;
        private final String username;

        /* JADX INFO: renamed from: component5, reason: from getter */
        private final boolean getClientInfo() {
            return this.clientInfo;
        }

        public static /* synthetic */ NativeAuthRequestSignInTokenRequestParameters copy$default(NativeAuthRequestSignInTokenRequestParameters nativeAuthRequestSignInTokenRequestParameters, String str, char[] cArr, String str2, Integer num, boolean z, String str3, String str4, String str5, String str6, String str7, String str8, int i, Object obj) {
            if ((i & 1) != 0) {
                str = nativeAuthRequestSignInTokenRequestParameters.username;
            }
            if ((i & 2) != 0) {
                cArr = nativeAuthRequestSignInTokenRequestParameters.password;
            }
            if ((i & 4) != 0) {
                str2 = nativeAuthRequestSignInTokenRequestParameters.oob;
            }
            if ((i & 8) != 0) {
                num = nativeAuthRequestSignInTokenRequestParameters.nca;
            }
            if ((i & 16) != 0) {
                z = nativeAuthRequestSignInTokenRequestParameters.clientInfo;
            }
            if ((i & 32) != 0) {
                str3 = nativeAuthRequestSignInTokenRequestParameters.getClientId();
            }
            if ((i & 64) != 0) {
                str4 = nativeAuthRequestSignInTokenRequestParameters.grantType;
            }
            if ((i & 128) != 0) {
                str5 = nativeAuthRequestSignInTokenRequestParameters.continuationToken;
            }
            if ((i & 256) != 0) {
                str6 = nativeAuthRequestSignInTokenRequestParameters.scope;
            }
            if ((i & 512) != 0) {
                str7 = nativeAuthRequestSignInTokenRequestParameters.challengeType;
            }
            if ((i & 1024) != 0) {
                str8 = nativeAuthRequestSignInTokenRequestParameters.claimsRequestJson;
            }
            String str9 = str7;
            String str10 = str8;
            String str11 = str5;
            String str12 = str6;
            String str13 = str3;
            String str14 = str4;
            boolean z2 = z;
            String str15 = str2;
            return nativeAuthRequestSignInTokenRequestParameters.copy(str, cArr, str15, num, z2, str13, str14, str11, str12, str9, str10);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUsername() {
            return this.username;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final String getChallengeType() {
            return this.challengeType;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final String getClaimsRequestJson() {
            return this.claimsRequestJson;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final char[] getPassword() {
            return this.password;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getOob() {
            return this.oob;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Integer getNca() {
            return this.nca;
        }

        public final String component6() {
            return getClientId();
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getGrantType() {
            return this.grantType;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getContinuationToken() {
            return this.continuationToken;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getScope() {
            return this.scope;
        }

        public final NativeAuthRequestSignInTokenRequestParameters copy(String username, char[] password, String oob, Integer nca, boolean clientInfo, String clientId, String grantType, String continuationToken, String scope, String challengeType, String claimsRequestJson) {
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            Intrinsics.checkNotNullParameter(grantType, "grantType");
            return new NativeAuthRequestSignInTokenRequestParameters(username, password, oob, nca, clientInfo, clientId, grantType, continuationToken, scope, challengeType, claimsRequestJson);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NativeAuthRequestSignInTokenRequestParameters)) {
                return false;
            }
            NativeAuthRequestSignInTokenRequestParameters nativeAuthRequestSignInTokenRequestParameters = (NativeAuthRequestSignInTokenRequestParameters) other;
            return Intrinsics.areEqual(this.username, nativeAuthRequestSignInTokenRequestParameters.username) && Intrinsics.areEqual(this.password, nativeAuthRequestSignInTokenRequestParameters.password) && Intrinsics.areEqual(this.oob, nativeAuthRequestSignInTokenRequestParameters.oob) && Intrinsics.areEqual(this.nca, nativeAuthRequestSignInTokenRequestParameters.nca) && this.clientInfo == nativeAuthRequestSignInTokenRequestParameters.clientInfo && Intrinsics.areEqual(getClientId(), nativeAuthRequestSignInTokenRequestParameters.getClientId()) && Intrinsics.areEqual(this.grantType, nativeAuthRequestSignInTokenRequestParameters.grantType) && Intrinsics.areEqual(this.continuationToken, nativeAuthRequestSignInTokenRequestParameters.continuationToken) && Intrinsics.areEqual(this.scope, nativeAuthRequestSignInTokenRequestParameters.scope) && Intrinsics.areEqual(this.challengeType, nativeAuthRequestSignInTokenRequestParameters.challengeType) && Intrinsics.areEqual(this.claimsRequestJson, nativeAuthRequestSignInTokenRequestParameters.claimsRequestJson);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v10, types: [int] */
        /* JADX WARN: Type inference failed for: r2v27 */
        /* JADX WARN: Type inference failed for: r2v31 */
        public int hashCode() {
            String str = this.username;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            char[] cArr = this.password;
            int iHashCode2 = (iHashCode + (cArr == null ? 0 : Arrays.hashCode(cArr))) * 31;
            String str2 = this.oob;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            Integer num = this.nca;
            int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
            boolean z = this.clientInfo;
            ?? r2 = z;
            if (z) {
                r2 = 1;
            }
            int iHashCode5 = (((((iHashCode4 + r2) * 31) + getClientId().hashCode()) * 31) + this.grantType.hashCode()) * 31;
            String str3 = this.continuationToken;
            int iHashCode6 = (iHashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.scope;
            int iHashCode7 = (iHashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.challengeType;
            int iHashCode8 = (iHashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.claimsRequestJson;
            return iHashCode8 + (str6 != null ? str6.hashCode() : 0);
        }

        public /* synthetic */ NativeAuthRequestSignInTokenRequestParameters(String str, char[] cArr, String str2, Integer num, boolean z, String str3, String str4, String str5, String str6, String str7, String str8, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : cArr, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : num, (i & 16) != 0 ? true : z, str3, str4, (i & 128) != 0 ? null : str5, str6, str7, str8);
        }

        public final String getUsername() {
            return this.username;
        }

        public final char[] getPassword() {
            return this.password;
        }

        public final String getOob() {
            return this.oob;
        }

        public final Integer getNca() {
            return this.nca;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.requests.NativeAuthRequest.NativeAuthRequestParameters
        public String getClientId() {
            return this.clientId;
        }

        public final String getGrantType() {
            return this.grantType;
        }

        public final String getContinuationToken() {
            return this.continuationToken;
        }

        public final String getScope() {
            return this.scope;
        }

        public final String getChallengeType() {
            return this.challengeType;
        }

        public final String getClaimsRequestJson() {
            return this.claimsRequestJson;
        }

        public NativeAuthRequestSignInTokenRequestParameters(String str, char[] cArr, String str2, Integer num, boolean z, String clientId, String grantType, String str3, String str4, String str5, String str6) {
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            Intrinsics.checkNotNullParameter(grantType, "grantType");
            this.username = str;
            this.password = cArr;
            this.oob = str2;
            this.nca = num;
            this.clientInfo = z;
            this.clientId = clientId;
            this.grantType = grantType;
            this.continuationToken = str3;
            this.scope = str4;
            this.challengeType = str5;
            this.claimsRequestJson = str6;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toUnsanitizedString() {
            return "NativeAuthRequestSignInTokenRequestParameters(nca=" + this.nca + ", clientInfo=" + this.clientInfo + ", clientId=" + getClientId() + ", grantType=" + this.grantType + ", scope=" + this.scope + ", challengeType=" + this.challengeType + ')';
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toString() {
            return "NativeAuthRequestSignInTokenRequestParameters(nca=" + this.nca + ", clientInfo=" + this.clientInfo + ", clientId=" + getClientId() + ')';
        }
    }
}
