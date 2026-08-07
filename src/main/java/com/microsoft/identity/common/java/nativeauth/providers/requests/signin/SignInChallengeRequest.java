package com.microsoft.identity.common.java.nativeauth.providers.requests.signin;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import com.microsoft.identity.common.java.nativeauth.providers.requests.NativeAuthRequest;
import com.microsoft.identity.common.java.util.ArgUtils;
import java.net.URL;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SignInChallengeRequest.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0002 !B-\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J5\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\b\u0010\u001e\u001a\u00020\u0006H\u0016J\b\u0010\u001f\u001a\u00020\u0006H\u0016R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\""}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signin/SignInChallengeRequest;", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/NativeAuthRequest;", "requestUrl", "Ljava/net/URL;", "headers", "", "", "parameters", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signin/SignInChallengeRequest$NativeAuthRequestSignInChallengeRequestParameters;", "(Ljava/net/URL;Ljava/util/Map;Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signin/SignInChallengeRequest$NativeAuthRequestSignInChallengeRequestParameters;)V", "getHeaders", "()Ljava/util/Map;", "setHeaders", "(Ljava/util/Map;)V", "getParameters", "()Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signin/SignInChallengeRequest$NativeAuthRequestSignInChallengeRequestParameters;", "getRequestUrl", "()Ljava/net/URL;", "setRequestUrl", "(Ljava/net/URL;)V", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "Companion", "NativeAuthRequestSignInChallengeRequestParameters", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SignInChallengeRequest extends NativeAuthRequest {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Map<String, String> headers;
    private final NativeAuthRequestSignInChallengeRequestParameters parameters;
    private URL requestUrl;

    public /* synthetic */ SignInChallengeRequest(URL url, Map map, NativeAuthRequestSignInChallengeRequestParameters nativeAuthRequestSignInChallengeRequestParameters, DefaultConstructorMarker defaultConstructorMarker) {
        this(url, map, nativeAuthRequestSignInChallengeRequestParameters);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SignInChallengeRequest copy$default(SignInChallengeRequest signInChallengeRequest, URL url, Map map, NativeAuthRequestSignInChallengeRequestParameters nativeAuthRequestSignInChallengeRequestParameters, int i, Object obj) {
        if ((i & 1) != 0) {
            url = signInChallengeRequest.getRequestUrl();
        }
        if ((i & 2) != 0) {
            map = signInChallengeRequest.getHeaders();
        }
        if ((i & 4) != 0) {
            nativeAuthRequestSignInChallengeRequestParameters = signInChallengeRequest.getParameters();
        }
        return signInChallengeRequest.copy(url, map, nativeAuthRequestSignInChallengeRequestParameters);
    }

    public final URL component1() {
        return getRequestUrl();
    }

    public final Map<String, String> component2() {
        return getHeaders();
    }

    public final NativeAuthRequestSignInChallengeRequestParameters component3() {
        return getParameters();
    }

    public final SignInChallengeRequest copy(URL requestUrl, Map<String, String> headers, NativeAuthRequestSignInChallengeRequestParameters parameters) {
        Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        return new SignInChallengeRequest(requestUrl, headers, parameters);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SignInChallengeRequest)) {
            return false;
        }
        SignInChallengeRequest signInChallengeRequest = (SignInChallengeRequest) other;
        return Intrinsics.areEqual(getRequestUrl(), signInChallengeRequest.getRequestUrl()) && Intrinsics.areEqual(getHeaders(), signInChallengeRequest.getHeaders()) && Intrinsics.areEqual(getParameters(), signInChallengeRequest.getParameters());
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
    public NativeAuthRequestSignInChallengeRequestParameters getParameters() {
        return this.parameters;
    }

    private SignInChallengeRequest(URL url, Map<String, String> map, NativeAuthRequestSignInChallengeRequestParameters nativeAuthRequestSignInChallengeRequestParameters) {
        this.requestUrl = url;
        this.headers = map;
        this.parameters = nativeAuthRequestSignInChallengeRequestParameters;
    }

    /* JADX INFO: compiled from: SignInChallengeRequest.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J<\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000bJ<\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000b¨\u0006\u000e"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signin/SignInChallengeRequest$Companion;", "", "()V", "createDefaultChallengeRequest", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signin/SignInChallengeRequest;", "clientId", "", "continuationToken", "challengeType", "requestUrl", "headers", "", "createSelectedChallengeRequest", "challengeId", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SignInChallengeRequest createDefaultChallengeRequest(String clientId, String continuationToken, String challengeType, String requestUrl, Map<String, String> headers) throws ClientException {
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            Intrinsics.checkNotNullParameter(challengeType, "challengeType");
            Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
            Intrinsics.checkNotNullParameter(headers, "headers");
            ArgUtils.INSTANCE.validateNonNullArg(clientId, "clientId");
            ArgUtils.INSTANCE.validateNonNullArg(continuationToken, "continuationToken");
            ArgUtils.INSTANCE.validateNonNullArg(requestUrl, "requestUrl");
            ArgUtils.INSTANCE.validateNonNullArg(challengeType, "challengeType");
            ArgUtils.INSTANCE.validateNonNullArg(headers, "headers");
            NativeAuthRequestSignInChallengeRequestParameters nativeAuthRequestSignInChallengeRequestParameters = new NativeAuthRequestSignInChallengeRequestParameters(clientId, continuationToken, challengeType, null);
            return new SignInChallengeRequest(new URL(requestUrl), headers, nativeAuthRequestSignInChallengeRequestParameters, null);
        }

        public final SignInChallengeRequest createSelectedChallengeRequest(String clientId, String continuationToken, String challengeId, String requestUrl, Map<String, String> headers) throws ClientException {
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            Intrinsics.checkNotNullParameter(challengeId, "challengeId");
            Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
            Intrinsics.checkNotNullParameter(headers, "headers");
            ArgUtils.INSTANCE.validateNonNullArg(clientId, "clientId");
            ArgUtils.INSTANCE.validateNonNullArg(continuationToken, "continuationToken");
            ArgUtils.INSTANCE.validateNonNullArg(requestUrl, "requestUrl");
            ArgUtils.INSTANCE.validateNonNullArg(challengeId, "challengeId");
            ArgUtils.INSTANCE.validateNonNullArg(headers, "headers");
            NativeAuthRequestSignInChallengeRequestParameters nativeAuthRequestSignInChallengeRequestParameters = new NativeAuthRequestSignInChallengeRequestParameters(clientId, continuationToken, null, challengeId);
            return new SignInChallengeRequest(new URL(requestUrl), headers, nativeAuthRequestSignInChallengeRequestParameters, null);
        }
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toUnsanitizedString() {
        return "SignInChallengeRequest(requestUrl=" + getRequestUrl() + ", headers=" + getHeaders() + ", parameters=" + getParameters() + ')';
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toString() {
        return "SignInChallengeRequest()";
    }

    /* JADX INFO: compiled from: SignInChallengeRequest.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J5\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signin/SignInChallengeRequest$NativeAuthRequestSignInChallengeRequestParameters;", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/NativeAuthRequest$NativeAuthRequestParameters;", "clientId", "", "continuationToken", "challengeType", "id", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChallengeType", "()Ljava/lang/String;", "getClientId", "getContinuationToken", "getId", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class NativeAuthRequestSignInChallengeRequestParameters extends NativeAuthRequest.NativeAuthRequestParameters {

        @SerializedName("challenge_type")
        private final String challengeType;

        @SerializedName("client_id")
        private final String clientId;

        @SerializedName(NativeAuthConstants.GrantType.CONTINUATION_TOKEN)
        private final String continuationToken;

        @SerializedName("id")
        private final String id;

        public static /* synthetic */ NativeAuthRequestSignInChallengeRequestParameters copy$default(NativeAuthRequestSignInChallengeRequestParameters nativeAuthRequestSignInChallengeRequestParameters, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = nativeAuthRequestSignInChallengeRequestParameters.getClientId();
            }
            if ((i & 2) != 0) {
                str2 = nativeAuthRequestSignInChallengeRequestParameters.continuationToken;
            }
            if ((i & 4) != 0) {
                str3 = nativeAuthRequestSignInChallengeRequestParameters.challengeType;
            }
            if ((i & 8) != 0) {
                str4 = nativeAuthRequestSignInChallengeRequestParameters.id;
            }
            return nativeAuthRequestSignInChallengeRequestParameters.copy(str, str2, str3, str4);
        }

        public final String component1() {
            return getClientId();
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getContinuationToken() {
            return this.continuationToken;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getChallengeType() {
            return this.challengeType;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getId() {
            return this.id;
        }

        public final NativeAuthRequestSignInChallengeRequestParameters copy(String clientId, String continuationToken, String challengeType, String id) {
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            return new NativeAuthRequestSignInChallengeRequestParameters(clientId, continuationToken, challengeType, id);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NativeAuthRequestSignInChallengeRequestParameters)) {
                return false;
            }
            NativeAuthRequestSignInChallengeRequestParameters nativeAuthRequestSignInChallengeRequestParameters = (NativeAuthRequestSignInChallengeRequestParameters) other;
            return Intrinsics.areEqual(getClientId(), nativeAuthRequestSignInChallengeRequestParameters.getClientId()) && Intrinsics.areEqual(this.continuationToken, nativeAuthRequestSignInChallengeRequestParameters.continuationToken) && Intrinsics.areEqual(this.challengeType, nativeAuthRequestSignInChallengeRequestParameters.challengeType) && Intrinsics.areEqual(this.id, nativeAuthRequestSignInChallengeRequestParameters.id);
        }

        public int hashCode() {
            int iHashCode = ((getClientId().hashCode() * 31) + this.continuationToken.hashCode()) * 31;
            String str = this.challengeType;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.id;
            return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.requests.NativeAuthRequest.NativeAuthRequestParameters
        public String getClientId() {
            return this.clientId;
        }

        public final String getContinuationToken() {
            return this.continuationToken;
        }

        public final String getChallengeType() {
            return this.challengeType;
        }

        public final String getId() {
            return this.id;
        }

        public NativeAuthRequestSignInChallengeRequestParameters(String clientId, String continuationToken, String str, String str2) {
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            this.clientId = clientId;
            this.continuationToken = continuationToken;
            this.challengeType = str;
            this.id = str2;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toUnsanitizedString() {
            return "NativeAuthRequestSignInChallengeRequestParameters(clientId=" + getClientId() + ", challengeType=" + this.challengeType + ", id=" + this.id + ')';
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toString() {
            return "NativeAuthRequestSignInChallengeRequestParameters(clientId=" + getClientId() + ", id=" + this.id + ')';
        }
    }
}
