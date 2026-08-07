package com.microsoft.identity.common.java.nativeauth.providers.requests.resetpassword;

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

/* JADX INFO: compiled from: ResetPasswordChallengeRequest.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 \u00162\u00020\u0001:\u0002\u0016\u0017B-\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0016R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/requests/resetpassword/ResetPasswordChallengeRequest;", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/NativeAuthRequest;", "requestUrl", "Ljava/net/URL;", "headers", "", "", "parameters", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/NativeAuthRequest$NativeAuthRequestParameters;", "(Ljava/net/URL;Ljava/util/Map;Lcom/microsoft/identity/common/java/nativeauth/providers/requests/NativeAuthRequest$NativeAuthRequestParameters;)V", "getHeaders", "()Ljava/util/Map;", "setHeaders", "(Ljava/util/Map;)V", "getParameters", "()Lcom/microsoft/identity/common/java/nativeauth/providers/requests/NativeAuthRequest$NativeAuthRequestParameters;", "getRequestUrl", "()Ljava/net/URL;", "setRequestUrl", "(Ljava/net/URL;)V", "toString", "toUnsanitizedString", "Companion", "NativeAuthResetPasswordChallengeRequestParameters", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ResetPasswordChallengeRequest extends NativeAuthRequest {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Map<String, String> headers;
    private final NativeAuthRequest.NativeAuthRequestParameters parameters;
    private URL requestUrl;

    public /* synthetic */ ResetPasswordChallengeRequest(URL url, Map map, NativeAuthRequest.NativeAuthRequestParameters nativeAuthRequestParameters, DefaultConstructorMarker defaultConstructorMarker) {
        this(url, map, nativeAuthRequestParameters);
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
    public NativeAuthRequest.NativeAuthRequestParameters getParameters() {
        return this.parameters;
    }

    private ResetPasswordChallengeRequest(URL url, Map<String, String> map, NativeAuthRequest.NativeAuthRequestParameters nativeAuthRequestParameters) {
        this.requestUrl = url;
        this.headers = map;
        this.parameters = nativeAuthRequestParameters;
    }

    /* JADX INFO: compiled from: ResetPasswordChallengeRequest.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J>\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u00062\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000b¨\u0006\f"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/requests/resetpassword/ResetPasswordChallengeRequest$Companion;", "", "()V", PasskeyWebListener.CREATE_UNIQUE_KEY, "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/resetpassword/ResetPasswordChallengeRequest;", "clientId", "", "continuationToken", "challengeType", "requestUrl", "headers", "", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ResetPasswordChallengeRequest create(String clientId, String continuationToken, String challengeType, String requestUrl, Map<String, String> headers) throws ClientException {
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
            Intrinsics.checkNotNullParameter(headers, "headers");
            ArgUtils.INSTANCE.validateNonNullArg(clientId, "clientId");
            ArgUtils.INSTANCE.validateNonNullArg(continuationToken, "continuationToken");
            ArgUtils.INSTANCE.validateNonNullArg(challengeType, "challengeType");
            ArgUtils.INSTANCE.validateNonNullArg(requestUrl, "requestUrl");
            ArgUtils.INSTANCE.validateNonNullArg(headers, "headers");
            return new ResetPasswordChallengeRequest(new URL(requestUrl), headers, new NativeAuthResetPasswordChallengeRequestParameters(clientId, continuationToken, challengeType), null);
        }
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toUnsanitizedString() {
        return "ResetPasswordChallengeRequest(requestUrl=" + getRequestUrl() + ", headers=" + getHeaders() + ", parameters=" + getParameters() + ')';
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toString() {
        return "ResetPasswordChallengeRequest()";
    }

    /* JADX INFO: compiled from: ResetPasswordChallengeRequest.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/requests/resetpassword/ResetPasswordChallengeRequest$NativeAuthResetPasswordChallengeRequestParameters;", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/NativeAuthRequest$NativeAuthRequestParameters;", "clientId", "", "continuationToken", "challengeType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChallengeType", "()Ljava/lang/String;", "getClientId", "getContinuationToken", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class NativeAuthResetPasswordChallengeRequestParameters extends NativeAuthRequest.NativeAuthRequestParameters {

        @SerializedName("challenge_type")
        private final String challengeType;

        @SerializedName("client_id")
        private final String clientId;

        @SerializedName(NativeAuthConstants.GrantType.CONTINUATION_TOKEN)
        private final String continuationToken;

        public static /* synthetic */ NativeAuthResetPasswordChallengeRequestParameters copy$default(NativeAuthResetPasswordChallengeRequestParameters nativeAuthResetPasswordChallengeRequestParameters, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = nativeAuthResetPasswordChallengeRequestParameters.getClientId();
            }
            if ((i & 2) != 0) {
                str2 = nativeAuthResetPasswordChallengeRequestParameters.continuationToken;
            }
            if ((i & 4) != 0) {
                str3 = nativeAuthResetPasswordChallengeRequestParameters.challengeType;
            }
            return nativeAuthResetPasswordChallengeRequestParameters.copy(str, str2, str3);
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

        public final NativeAuthResetPasswordChallengeRequestParameters copy(String clientId, String continuationToken, String challengeType) {
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            return new NativeAuthResetPasswordChallengeRequestParameters(clientId, continuationToken, challengeType);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NativeAuthResetPasswordChallengeRequestParameters)) {
                return false;
            }
            NativeAuthResetPasswordChallengeRequestParameters nativeAuthResetPasswordChallengeRequestParameters = (NativeAuthResetPasswordChallengeRequestParameters) other;
            return Intrinsics.areEqual(getClientId(), nativeAuthResetPasswordChallengeRequestParameters.getClientId()) && Intrinsics.areEqual(this.continuationToken, nativeAuthResetPasswordChallengeRequestParameters.continuationToken) && Intrinsics.areEqual(this.challengeType, nativeAuthResetPasswordChallengeRequestParameters.challengeType);
        }

        public int hashCode() {
            int iHashCode = ((getClientId().hashCode() * 31) + this.continuationToken.hashCode()) * 31;
            String str = this.challengeType;
            return iHashCode + (str == null ? 0 : str.hashCode());
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

        public NativeAuthResetPasswordChallengeRequestParameters(String clientId, String continuationToken, String str) {
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            this.clientId = clientId;
            this.continuationToken = continuationToken;
            this.challengeType = str;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toUnsanitizedString() {
            return "NativeAuthResetPasswordChallengeRequestParameters(clientId=" + getClientId() + ", challengeType=" + this.challengeType + ')';
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toString() {
            return "NativeAuthResetPasswordChallengeRequestParameters(clientId=" + getClientId() + ')';
        }
    }
}
