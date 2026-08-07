package com.microsoft.identity.common.java.nativeauth.providers.requests.resetpassword;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.nativeauth.providers.requests.NativeAuthRequest;
import com.microsoft.identity.common.java.util.ArgUtils;
import com.microsoft.identity.nativeauth.NativeAuthPublicClientApplicationConfiguration;
import java.net.URL;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ResetPasswordStartRequest.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 \"2\u00020\u0001:\u0002\"#B-\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J5\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\b\u0010 \u001a\u00020\u0006H\u0016J\b\u0010!\u001a\u00020\u0006H\u0016R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0007\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006$"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/requests/resetpassword/ResetPasswordStartRequest;", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/NativeAuthRequest;", "requestUrl", "Ljava/net/URL;", "headers", "", "", "parameters", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/resetpassword/ResetPasswordStartRequest$NativeAuthRequestResetPasswordStartParameters;", "(Ljava/net/URL;Ljava/util/Map;Lcom/microsoft/identity/common/java/nativeauth/providers/requests/resetpassword/ResetPasswordStartRequest$NativeAuthRequestResetPasswordStartParameters;)V", "getHeaders", "()Ljava/util/Map;", "setHeaders", "(Ljava/util/Map;)V", "getParameters", "()Lcom/microsoft/identity/common/java/nativeauth/providers/requests/resetpassword/ResetPasswordStartRequest$NativeAuthRequestResetPasswordStartParameters;", "setParameters", "(Lcom/microsoft/identity/common/java/nativeauth/providers/requests/resetpassword/ResetPasswordStartRequest$NativeAuthRequestResetPasswordStartParameters;)V", "getRequestUrl", "()Ljava/net/URL;", "setRequestUrl", "(Ljava/net/URL;)V", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "Companion", "NativeAuthRequestResetPasswordStartParameters", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ResetPasswordStartRequest extends NativeAuthRequest {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Map<String, String> headers;
    private NativeAuthRequestResetPasswordStartParameters parameters;
    private URL requestUrl;

    public /* synthetic */ ResetPasswordStartRequest(URL url, Map map, NativeAuthRequestResetPasswordStartParameters nativeAuthRequestResetPasswordStartParameters, DefaultConstructorMarker defaultConstructorMarker) {
        this(url, map, nativeAuthRequestResetPasswordStartParameters);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ResetPasswordStartRequest copy$default(ResetPasswordStartRequest resetPasswordStartRequest, URL url, Map map, NativeAuthRequestResetPasswordStartParameters nativeAuthRequestResetPasswordStartParameters, int i, Object obj) {
        if ((i & 1) != 0) {
            url = resetPasswordStartRequest.getRequestUrl();
        }
        if ((i & 2) != 0) {
            map = resetPasswordStartRequest.getHeaders();
        }
        if ((i & 4) != 0) {
            nativeAuthRequestResetPasswordStartParameters = resetPasswordStartRequest.getParameters();
        }
        return resetPasswordStartRequest.copy(url, map, nativeAuthRequestResetPasswordStartParameters);
    }

    public final URL component1() {
        return getRequestUrl();
    }

    public final Map<String, String> component2() {
        return getHeaders();
    }

    public final NativeAuthRequestResetPasswordStartParameters component3() {
        return getParameters();
    }

    public final ResetPasswordStartRequest copy(URL requestUrl, Map<String, String> headers, NativeAuthRequestResetPasswordStartParameters parameters) {
        Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        return new ResetPasswordStartRequest(requestUrl, headers, parameters);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ResetPasswordStartRequest)) {
            return false;
        }
        ResetPasswordStartRequest resetPasswordStartRequest = (ResetPasswordStartRequest) other;
        return Intrinsics.areEqual(getRequestUrl(), resetPasswordStartRequest.getRequestUrl()) && Intrinsics.areEqual(getHeaders(), resetPasswordStartRequest.getHeaders()) && Intrinsics.areEqual(getParameters(), resetPasswordStartRequest.getParameters());
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
    public NativeAuthRequestResetPasswordStartParameters getParameters() {
        return this.parameters;
    }

    public void setParameters(NativeAuthRequestResetPasswordStartParameters nativeAuthRequestResetPasswordStartParameters) {
        Intrinsics.checkNotNullParameter(nativeAuthRequestResetPasswordStartParameters, "<set-?>");
        this.parameters = nativeAuthRequestResetPasswordStartParameters;
    }

    private ResetPasswordStartRequest(URL url, Map<String, String> map, NativeAuthRequestResetPasswordStartParameters nativeAuthRequestResetPasswordStartParameters) {
        this.requestUrl = url;
        this.headers = map;
        this.parameters = nativeAuthRequestResetPasswordStartParameters;
    }

    /* JADX INFO: compiled from: ResetPasswordStartRequest.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JF\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0006¨\u0006\r"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/requests/resetpassword/ResetPasswordStartRequest$Companion;", "", "()V", PasskeyWebListener.CREATE_UNIQUE_KEY, "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/resetpassword/ResetPasswordStartRequest;", "clientId", "", "username", "challengeType", "requestUrl", "headers", "", NativeAuthPublicClientApplicationConfiguration.NativeAuthSerializedNames.CAPABILITIES, "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ResetPasswordStartRequest create(String clientId, String username, String challengeType, String requestUrl, Map<String, String> headers, String capabilities) throws ClientException {
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            Intrinsics.checkNotNullParameter(username, "username");
            Intrinsics.checkNotNullParameter(challengeType, "challengeType");
            Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
            Intrinsics.checkNotNullParameter(headers, "headers");
            ArgUtils.INSTANCE.validateNonNullArg(clientId, "clientId");
            ArgUtils.INSTANCE.validateNonNullArg(challengeType, "challengeType");
            ArgUtils.INSTANCE.validateNonNullArg(requestUrl, "requestUrl");
            ArgUtils.INSTANCE.validateNonNullArg(headers, "headers");
            return new ResetPasswordStartRequest(new URL(requestUrl), headers, new NativeAuthRequestResetPasswordStartParameters(username, clientId, challengeType, capabilities), null);
        }
    }

    /* JADX INFO: compiled from: ResetPasswordStartRequest.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J5\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/requests/resetpassword/ResetPasswordStartRequest$NativeAuthRequestResetPasswordStartParameters;", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/NativeAuthRequest$NativeAuthRequestParameters;", "username", "", "clientId", "challengeType", NativeAuthPublicClientApplicationConfiguration.NativeAuthSerializedNames.CAPABILITIES, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCapabilities", "()Ljava/lang/String;", "getChallengeType", "getClientId", "getUsername", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class NativeAuthRequestResetPasswordStartParameters extends NativeAuthRequest.NativeAuthRequestParameters {

        @SerializedName(NativeAuthPublicClientApplicationConfiguration.NativeAuthSerializedNames.CAPABILITIES)
        private final String capabilities;

        @SerializedName("challenge_type")
        private final String challengeType;

        @SerializedName("client_id")
        private final String clientId;
        private final String username;

        public static /* synthetic */ NativeAuthRequestResetPasswordStartParameters copy$default(NativeAuthRequestResetPasswordStartParameters nativeAuthRequestResetPasswordStartParameters, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = nativeAuthRequestResetPasswordStartParameters.username;
            }
            if ((i & 2) != 0) {
                str2 = nativeAuthRequestResetPasswordStartParameters.getClientId();
            }
            if ((i & 4) != 0) {
                str3 = nativeAuthRequestResetPasswordStartParameters.challengeType;
            }
            if ((i & 8) != 0) {
                str4 = nativeAuthRequestResetPasswordStartParameters.capabilities;
            }
            return nativeAuthRequestResetPasswordStartParameters.copy(str, str2, str3, str4);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUsername() {
            return this.username;
        }

        public final String component2() {
            return getClientId();
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getChallengeType() {
            return this.challengeType;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getCapabilities() {
            return this.capabilities;
        }

        public final NativeAuthRequestResetPasswordStartParameters copy(String username, String clientId, String challengeType, String capabilities) {
            Intrinsics.checkNotNullParameter(username, "username");
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            return new NativeAuthRequestResetPasswordStartParameters(username, clientId, challengeType, capabilities);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NativeAuthRequestResetPasswordStartParameters)) {
                return false;
            }
            NativeAuthRequestResetPasswordStartParameters nativeAuthRequestResetPasswordStartParameters = (NativeAuthRequestResetPasswordStartParameters) other;
            return Intrinsics.areEqual(this.username, nativeAuthRequestResetPasswordStartParameters.username) && Intrinsics.areEqual(getClientId(), nativeAuthRequestResetPasswordStartParameters.getClientId()) && Intrinsics.areEqual(this.challengeType, nativeAuthRequestResetPasswordStartParameters.challengeType) && Intrinsics.areEqual(this.capabilities, nativeAuthRequestResetPasswordStartParameters.capabilities);
        }

        public int hashCode() {
            int iHashCode = ((this.username.hashCode() * 31) + getClientId().hashCode()) * 31;
            String str = this.challengeType;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.capabilities;
            return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public final String getUsername() {
            return this.username;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.requests.NativeAuthRequest.NativeAuthRequestParameters
        public String getClientId() {
            return this.clientId;
        }

        public final String getChallengeType() {
            return this.challengeType;
        }

        public final String getCapabilities() {
            return this.capabilities;
        }

        public NativeAuthRequestResetPasswordStartParameters(String username, String clientId, String str, String str2) {
            Intrinsics.checkNotNullParameter(username, "username");
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            this.username = username;
            this.clientId = clientId;
            this.challengeType = str;
            this.capabilities = str2;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toUnsanitizedString() {
            return "ResetPasswordStartRequest(clientId=" + getClientId() + ", challengeType=" + this.challengeType + ", capabilities=" + this.capabilities + ')';
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toString() {
            return "ResetPasswordStartRequest(clientId=" + getClientId() + ')';
        }
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toUnsanitizedString() {
        return "ResetPasswordStartRequest(requestUrl=" + getRequestUrl() + ", headers=" + getHeaders() + ", parameters=" + getParameters() + ')';
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toString() {
        return "ResetPasswordStartRequest()";
    }
}
