package com.microsoft.identity.common.java.nativeauth.providers.requests.signup;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import com.microsoft.identity.common.java.nativeauth.providers.requests.NativeAuthRequest;
import com.microsoft.identity.common.java.util.ArgUtils;
import java.net.URL;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SignUpChallengeRequest.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0002 !B-\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J5\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\b\u0010\u001e\u001a\u00020\u0006H\u0016J\b\u0010\u001f\u001a\u00020\u0006H\u0016R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\""}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signup/SignUpChallengeRequest;", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/NativeAuthRequest;", "requestUrl", "Ljava/net/URL;", "headers", "", "", "parameters", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signup/SignUpChallengeRequest$NativeAuthRequestSignUpChallengeRequestParameters;", "(Ljava/net/URL;Ljava/util/Map;Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signup/SignUpChallengeRequest$NativeAuthRequestSignUpChallengeRequestParameters;)V", "getHeaders", "()Ljava/util/Map;", "setHeaders", "(Ljava/util/Map;)V", "getParameters", "()Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signup/SignUpChallengeRequest$NativeAuthRequestSignUpChallengeRequestParameters;", "getRequestUrl", "()Ljava/net/URL;", "setRequestUrl", "(Ljava/net/URL;)V", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "Companion", "NativeAuthRequestSignUpChallengeRequestParameters", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SignUpChallengeRequest extends NativeAuthRequest {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Map<String, String> headers;
    private final NativeAuthRequestSignUpChallengeRequestParameters parameters;
    private URL requestUrl;

    public /* synthetic */ SignUpChallengeRequest(URL url, Map map, NativeAuthRequestSignUpChallengeRequestParameters nativeAuthRequestSignUpChallengeRequestParameters, DefaultConstructorMarker defaultConstructorMarker) {
        this(url, map, nativeAuthRequestSignUpChallengeRequestParameters);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SignUpChallengeRequest copy$default(SignUpChallengeRequest signUpChallengeRequest, URL url, Map map, NativeAuthRequestSignUpChallengeRequestParameters nativeAuthRequestSignUpChallengeRequestParameters, int i, Object obj) {
        if ((i & 1) != 0) {
            url = signUpChallengeRequest.getRequestUrl();
        }
        if ((i & 2) != 0) {
            map = signUpChallengeRequest.getHeaders();
        }
        if ((i & 4) != 0) {
            nativeAuthRequestSignUpChallengeRequestParameters = signUpChallengeRequest.getParameters();
        }
        return signUpChallengeRequest.copy(url, map, nativeAuthRequestSignUpChallengeRequestParameters);
    }

    public final URL component1() {
        return getRequestUrl();
    }

    public final Map<String, String> component2() {
        return getHeaders();
    }

    public final NativeAuthRequestSignUpChallengeRequestParameters component3() {
        return getParameters();
    }

    public final SignUpChallengeRequest copy(URL requestUrl, Map<String, String> headers, NativeAuthRequestSignUpChallengeRequestParameters parameters) {
        Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        return new SignUpChallengeRequest(requestUrl, headers, parameters);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SignUpChallengeRequest)) {
            return false;
        }
        SignUpChallengeRequest signUpChallengeRequest = (SignUpChallengeRequest) other;
        return Intrinsics.areEqual(getRequestUrl(), signUpChallengeRequest.getRequestUrl()) && Intrinsics.areEqual(getHeaders(), signUpChallengeRequest.getHeaders()) && Intrinsics.areEqual(getParameters(), signUpChallengeRequest.getParameters());
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
    public NativeAuthRequestSignUpChallengeRequestParameters getParameters() {
        return this.parameters;
    }

    private SignUpChallengeRequest(URL url, Map<String, String> map, NativeAuthRequestSignUpChallengeRequestParameters nativeAuthRequestSignUpChallengeRequestParameters) {
        this.requestUrl = url;
        this.headers = map;
        this.parameters = nativeAuthRequestSignUpChallengeRequestParameters;
    }

    /* JADX INFO: compiled from: SignUpChallengeRequest.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J<\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000b¨\u0006\f"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signup/SignUpChallengeRequest$Companion;", "", "()V", PasskeyWebListener.CREATE_UNIQUE_KEY, "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signup/SignUpChallengeRequest;", "continuationToken", "", "clientId", "challengeType", "requestUrl", "headers", "", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SignUpChallengeRequest create(String continuationToken, String clientId, String challengeType, String requestUrl, Map<String, String> headers) throws ClientException {
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            Intrinsics.checkNotNullParameter(challengeType, "challengeType");
            Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
            Intrinsics.checkNotNullParameter(headers, "headers");
            ArgUtils.INSTANCE.validateNonNullArg(continuationToken, "continuationToken");
            ArgUtils.INSTANCE.validateNonNullArg(clientId, "clientId");
            ArgUtils.INSTANCE.validateNonNullArg(challengeType, "challengeTypes");
            ArgUtils.INSTANCE.validateNonNullArg(requestUrl, "requestUrl");
            ArgUtils.INSTANCE.validateNonNullArg(headers, "headers");
            return new SignUpChallengeRequest(new URL(requestUrl), headers, new NativeAuthRequestSignUpChallengeRequestParameters(continuationToken, clientId, challengeType), null);
        }
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toUnsanitizedString() {
        return "SignUpChallengeRequest(requestUrl=" + getRequestUrl() + ", headers=" + getHeaders() + ", parameters=" + getParameters() + ')';
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toString() {
        return "SignUpChallengeRequest()";
    }

    /* JADX INFO: compiled from: SignUpChallengeRequest.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signup/SignUpChallengeRequest$NativeAuthRequestSignUpChallengeRequestParameters;", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/NativeAuthRequest$NativeAuthRequestParameters;", "continuationToken", "", "clientId", "challengeType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChallengeType", "()Ljava/lang/String;", "getClientId", "getContinuationToken", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class NativeAuthRequestSignUpChallengeRequestParameters extends NativeAuthRequest.NativeAuthRequestParameters {

        @SerializedName("challenge_type")
        private final String challengeType;

        @SerializedName("client_id")
        private final String clientId;

        @SerializedName(NativeAuthConstants.GrantType.CONTINUATION_TOKEN)
        private final String continuationToken;

        public static /* synthetic */ NativeAuthRequestSignUpChallengeRequestParameters copy$default(NativeAuthRequestSignUpChallengeRequestParameters nativeAuthRequestSignUpChallengeRequestParameters, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = nativeAuthRequestSignUpChallengeRequestParameters.continuationToken;
            }
            if ((i & 2) != 0) {
                str2 = nativeAuthRequestSignUpChallengeRequestParameters.getClientId();
            }
            if ((i & 4) != 0) {
                str3 = nativeAuthRequestSignUpChallengeRequestParameters.challengeType;
            }
            return nativeAuthRequestSignUpChallengeRequestParameters.copy(str, str2, str3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getContinuationToken() {
            return this.continuationToken;
        }

        public final String component2() {
            return getClientId();
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getChallengeType() {
            return this.challengeType;
        }

        public final NativeAuthRequestSignUpChallengeRequestParameters copy(String continuationToken, String clientId, String challengeType) {
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            Intrinsics.checkNotNullParameter(challengeType, "challengeType");
            return new NativeAuthRequestSignUpChallengeRequestParameters(continuationToken, clientId, challengeType);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NativeAuthRequestSignUpChallengeRequestParameters)) {
                return false;
            }
            NativeAuthRequestSignUpChallengeRequestParameters nativeAuthRequestSignUpChallengeRequestParameters = (NativeAuthRequestSignUpChallengeRequestParameters) other;
            return Intrinsics.areEqual(this.continuationToken, nativeAuthRequestSignUpChallengeRequestParameters.continuationToken) && Intrinsics.areEqual(getClientId(), nativeAuthRequestSignUpChallengeRequestParameters.getClientId()) && Intrinsics.areEqual(this.challengeType, nativeAuthRequestSignUpChallengeRequestParameters.challengeType);
        }

        public int hashCode() {
            return (((this.continuationToken.hashCode() * 31) + getClientId().hashCode()) * 31) + this.challengeType.hashCode();
        }

        public final String getContinuationToken() {
            return this.continuationToken;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.requests.NativeAuthRequest.NativeAuthRequestParameters
        public String getClientId() {
            return this.clientId;
        }

        public final String getChallengeType() {
            return this.challengeType;
        }

        public NativeAuthRequestSignUpChallengeRequestParameters(String continuationToken, String clientId, String challengeType) {
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            Intrinsics.checkNotNullParameter(challengeType, "challengeType");
            this.continuationToken = continuationToken;
            this.clientId = clientId;
            this.challengeType = challengeType;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toUnsanitizedString() {
            return "NativeAuthRequestSignUpChallengeRequestParameters(clientId=" + getClientId() + ", challengeType=" + this.challengeType + ')';
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toString() {
            return "NativeAuthRequestSignUpChallengeRequestParameters(clientId=" + getClientId() + ')';
        }
    }
}
