package com.microsoft.identity.common.java.nativeauth.providers.requests.signup;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import com.microsoft.identity.common.java.nativeauth.providers.requests.NativeAuthRequest;
import com.microsoft.identity.common.java.util.ArgUtils;
import com.microsoft.identity.common.java.util.CharArrayJsonAdapter;
import com.microsoft.identity.nativeauth.NativeAuthPublicClientApplicationConfiguration;
import java.net.URL;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SignUpStartRequest.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0002 !B-\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J5\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\b\u0010\u001e\u001a\u00020\u0006H\u0016J\b\u0010\u001f\u001a\u00020\u0006H\u0016R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\""}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signup/SignUpStartRequest;", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/NativeAuthRequest;", "requestUrl", "Ljava/net/URL;", "headers", "", "", "parameters", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signup/SignUpStartRequest$NativeAuthRequestSignUpStartRequestParameters;", "(Ljava/net/URL;Ljava/util/Map;Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signup/SignUpStartRequest$NativeAuthRequestSignUpStartRequestParameters;)V", "getHeaders", "()Ljava/util/Map;", "setHeaders", "(Ljava/util/Map;)V", "getParameters", "()Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signup/SignUpStartRequest$NativeAuthRequestSignUpStartRequestParameters;", "getRequestUrl", "()Ljava/net/URL;", "setRequestUrl", "(Ljava/net/URL;)V", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "Companion", "NativeAuthRequestSignUpStartRequestParameters", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SignUpStartRequest extends NativeAuthRequest {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Map<String, String> headers;
    private final NativeAuthRequestSignUpStartRequestParameters parameters;
    private URL requestUrl;

    public /* synthetic */ SignUpStartRequest(URL url, Map map, NativeAuthRequestSignUpStartRequestParameters nativeAuthRequestSignUpStartRequestParameters, DefaultConstructorMarker defaultConstructorMarker) {
        this(url, map, nativeAuthRequestSignUpStartRequestParameters);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SignUpStartRequest copy$default(SignUpStartRequest signUpStartRequest, URL url, Map map, NativeAuthRequestSignUpStartRequestParameters nativeAuthRequestSignUpStartRequestParameters, int i, Object obj) {
        if ((i & 1) != 0) {
            url = signUpStartRequest.getRequestUrl();
        }
        if ((i & 2) != 0) {
            map = signUpStartRequest.getHeaders();
        }
        if ((i & 4) != 0) {
            nativeAuthRequestSignUpStartRequestParameters = signUpStartRequest.getParameters();
        }
        return signUpStartRequest.copy(url, map, nativeAuthRequestSignUpStartRequestParameters);
    }

    public final URL component1() {
        return getRequestUrl();
    }

    public final Map<String, String> component2() {
        return getHeaders();
    }

    public final NativeAuthRequestSignUpStartRequestParameters component3() {
        return getParameters();
    }

    public final SignUpStartRequest copy(URL requestUrl, Map<String, String> headers, NativeAuthRequestSignUpStartRequestParameters parameters) {
        Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        return new SignUpStartRequest(requestUrl, headers, parameters);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SignUpStartRequest)) {
            return false;
        }
        SignUpStartRequest signUpStartRequest = (SignUpStartRequest) other;
        return Intrinsics.areEqual(getRequestUrl(), signUpStartRequest.getRequestUrl()) && Intrinsics.areEqual(getHeaders(), signUpStartRequest.getHeaders()) && Intrinsics.areEqual(getParameters(), signUpStartRequest.getParameters());
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
    public NativeAuthRequestSignUpStartRequestParameters getParameters() {
        return this.parameters;
    }

    private SignUpStartRequest(URL url, Map<String, String> map, NativeAuthRequestSignUpStartRequestParameters nativeAuthRequestSignUpStartRequestParameters) {
        this.requestUrl = url;
        this.headers = map;
        this.parameters = nativeAuthRequestSignUpStartRequestParameters;
    }

    /* JADX INFO: compiled from: SignUpStartRequest.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jj\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006¨\u0006\u0010"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signup/SignUpStartRequest$Companion;", "", "()V", PasskeyWebListener.CREATE_UNIQUE_KEY, "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signup/SignUpStartRequest;", "username", "", "password", "", NativeAuthConstants.GrantType.ATTRIBUTES, "", "clientId", "challengeType", "requestUrl", "headers", NativeAuthPublicClientApplicationConfiguration.NativeAuthSerializedNames.CAPABILITIES, "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SignUpStartRequest create$default(Companion companion, String str, char[] cArr, Map map, String str2, String str3, String str4, Map map2, String str5, int i, Object obj) {
            if ((i & 2) != 0) {
                cArr = null;
            }
            if ((i & 4) != 0) {
                map = null;
            }
            return companion.create(str, cArr, map, str2, str3, str4, map2, str5);
        }

        public final SignUpStartRequest create(String username, char[] password, Map<String, String> attributes, String clientId, String challengeType, String requestUrl, Map<String, String> headers, String capabilities) throws ClientException {
            Intrinsics.checkNotNullParameter(username, "username");
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            Intrinsics.checkNotNullParameter(challengeType, "challengeType");
            Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
            Intrinsics.checkNotNullParameter(headers, "headers");
            ArgUtils.INSTANCE.validateNonNullArg(clientId, "clientId");
            ArgUtils.INSTANCE.validateNonNullArg(challengeType, "challengeType");
            ArgUtils.INSTANCE.validateNonNullArg(requestUrl, "requestUrl");
            ArgUtils.INSTANCE.validateNonNullArg(headers, "headers");
            return new SignUpStartRequest(new URL(requestUrl), headers, new NativeAuthRequestSignUpStartRequestParameters(username, password, attributes != null ? NativeAuthRequest.INSTANCE.toJsonString(attributes, attributes) : null, clientId, challengeType, capabilities), null);
        }
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toUnsanitizedString() {
        return "SignUpStartRequest(requestUrl=" + getRequestUrl() + ", headers=" + getHeaders() + ", parameters=" + getParameters() + ')';
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toString() {
        return "SignUpStartRequest()";
    }

    /* JADX INFO: compiled from: SignUpStartRequest.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003JK\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\b\u0010 \u001a\u00020\u0003H\u0016J\b\u0010!\u001a\u00020\u0003H\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0007\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\""}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signup/SignUpStartRequest$NativeAuthRequestSignUpStartRequestParameters;", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/NativeAuthRequest$NativeAuthRequestParameters;", "username", "", "password", "", NativeAuthConstants.GrantType.ATTRIBUTES, "clientId", "challengeType", NativeAuthPublicClientApplicationConfiguration.NativeAuthSerializedNames.CAPABILITIES, "(Ljava/lang/String;[CLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAttributes", "()Ljava/lang/String;", "getCapabilities", "getChallengeType", "getClientId", "getPassword", "()[C", "getUsername", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class NativeAuthRequestSignUpStartRequestParameters extends NativeAuthRequest.NativeAuthRequestParameters {
        private final String attributes;

        @SerializedName(NativeAuthPublicClientApplicationConfiguration.NativeAuthSerializedNames.CAPABILITIES)
        private final String capabilities;

        @SerializedName("challenge_type")
        private final String challengeType;

        @SerializedName("client_id")
        private final String clientId;

        @JsonAdapter(CharArrayJsonAdapter.class)
        private final char[] password;
        private final String username;

        public static /* synthetic */ NativeAuthRequestSignUpStartRequestParameters copy$default(NativeAuthRequestSignUpStartRequestParameters nativeAuthRequestSignUpStartRequestParameters, String str, char[] cArr, String str2, String str3, String str4, String str5, int i, Object obj) {
            if ((i & 1) != 0) {
                str = nativeAuthRequestSignUpStartRequestParameters.username;
            }
            if ((i & 2) != 0) {
                cArr = nativeAuthRequestSignUpStartRequestParameters.password;
            }
            if ((i & 4) != 0) {
                str2 = nativeAuthRequestSignUpStartRequestParameters.attributes;
            }
            if ((i & 8) != 0) {
                str3 = nativeAuthRequestSignUpStartRequestParameters.getClientId();
            }
            if ((i & 16) != 0) {
                str4 = nativeAuthRequestSignUpStartRequestParameters.challengeType;
            }
            if ((i & 32) != 0) {
                str5 = nativeAuthRequestSignUpStartRequestParameters.capabilities;
            }
            String str6 = str4;
            String str7 = str5;
            return nativeAuthRequestSignUpStartRequestParameters.copy(str, cArr, str2, str3, str6, str7);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUsername() {
            return this.username;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final char[] getPassword() {
            return this.password;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getAttributes() {
            return this.attributes;
        }

        public final String component4() {
            return getClientId();
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getChallengeType() {
            return this.challengeType;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getCapabilities() {
            return this.capabilities;
        }

        public final NativeAuthRequestSignUpStartRequestParameters copy(String username, char[] password, String attributes, String clientId, String challengeType, String capabilities) {
            Intrinsics.checkNotNullParameter(username, "username");
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            Intrinsics.checkNotNullParameter(challengeType, "challengeType");
            return new NativeAuthRequestSignUpStartRequestParameters(username, password, attributes, clientId, challengeType, capabilities);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NativeAuthRequestSignUpStartRequestParameters)) {
                return false;
            }
            NativeAuthRequestSignUpStartRequestParameters nativeAuthRequestSignUpStartRequestParameters = (NativeAuthRequestSignUpStartRequestParameters) other;
            return Intrinsics.areEqual(this.username, nativeAuthRequestSignUpStartRequestParameters.username) && Intrinsics.areEqual(this.password, nativeAuthRequestSignUpStartRequestParameters.password) && Intrinsics.areEqual(this.attributes, nativeAuthRequestSignUpStartRequestParameters.attributes) && Intrinsics.areEqual(getClientId(), nativeAuthRequestSignUpStartRequestParameters.getClientId()) && Intrinsics.areEqual(this.challengeType, nativeAuthRequestSignUpStartRequestParameters.challengeType) && Intrinsics.areEqual(this.capabilities, nativeAuthRequestSignUpStartRequestParameters.capabilities);
        }

        public int hashCode() {
            int iHashCode = this.username.hashCode() * 31;
            char[] cArr = this.password;
            int iHashCode2 = (iHashCode + (cArr == null ? 0 : Arrays.hashCode(cArr))) * 31;
            String str = this.attributes;
            int iHashCode3 = (((((iHashCode2 + (str == null ? 0 : str.hashCode())) * 31) + getClientId().hashCode()) * 31) + this.challengeType.hashCode()) * 31;
            String str2 = this.capabilities;
            return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
        }

        public /* synthetic */ NativeAuthRequestSignUpStartRequestParameters(String str, char[] cArr, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, cArr, (i & 4) != 0 ? null : str2, str3, str4, str5);
        }

        public final String getUsername() {
            return this.username;
        }

        public final char[] getPassword() {
            return this.password;
        }

        public final String getAttributes() {
            return this.attributes;
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

        public NativeAuthRequestSignUpStartRequestParameters(String username, char[] cArr, String str, String clientId, String challengeType, String str2) {
            Intrinsics.checkNotNullParameter(username, "username");
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            Intrinsics.checkNotNullParameter(challengeType, "challengeType");
            this.username = username;
            this.password = cArr;
            this.attributes = str;
            this.clientId = clientId;
            this.challengeType = challengeType;
            this.capabilities = str2;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toUnsanitizedString() {
            return "NativeAuthRequestSignUpStartRequestParameters(clientId=" + getClientId() + ", challengeType=" + this.challengeType + ", capabilities=" + this.capabilities + ')';
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toString() {
            return "NativeAuthRequestSignUpStartRequestParameters(clientId=" + getClientId() + ')';
        }
    }
}
