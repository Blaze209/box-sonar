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
import java.net.URL;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SignUpContinueRequest.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0002 !B-\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J5\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\b\u0010\u001e\u001a\u00020\u0006H\u0016J\b\u0010\u001f\u001a\u00020\u0006H\u0016R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\""}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signup/SignUpContinueRequest;", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/NativeAuthRequest;", "requestUrl", "Ljava/net/URL;", "headers", "", "", "parameters", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signup/SignUpContinueRequest$NativeAuthRequestSignUpContinueRequestParameters;", "(Ljava/net/URL;Ljava/util/Map;Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signup/SignUpContinueRequest$NativeAuthRequestSignUpContinueRequestParameters;)V", "getHeaders", "()Ljava/util/Map;", "setHeaders", "(Ljava/util/Map;)V", "getParameters", "()Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signup/SignUpContinueRequest$NativeAuthRequestSignUpContinueRequestParameters;", "getRequestUrl", "()Ljava/net/URL;", "setRequestUrl", "(Ljava/net/URL;)V", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "Companion", "NativeAuthRequestSignUpContinueRequestParameters", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SignUpContinueRequest extends NativeAuthRequest {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Map<String, String> headers;
    private final NativeAuthRequestSignUpContinueRequestParameters parameters;
    private URL requestUrl;

    public /* synthetic */ SignUpContinueRequest(URL url, Map map, NativeAuthRequestSignUpContinueRequestParameters nativeAuthRequestSignUpContinueRequestParameters, DefaultConstructorMarker defaultConstructorMarker) {
        this(url, map, nativeAuthRequestSignUpContinueRequestParameters);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SignUpContinueRequest copy$default(SignUpContinueRequest signUpContinueRequest, URL url, Map map, NativeAuthRequestSignUpContinueRequestParameters nativeAuthRequestSignUpContinueRequestParameters, int i, Object obj) {
        if ((i & 1) != 0) {
            url = signUpContinueRequest.getRequestUrl();
        }
        if ((i & 2) != 0) {
            map = signUpContinueRequest.getHeaders();
        }
        if ((i & 4) != 0) {
            nativeAuthRequestSignUpContinueRequestParameters = signUpContinueRequest.getParameters();
        }
        return signUpContinueRequest.copy(url, map, nativeAuthRequestSignUpContinueRequestParameters);
    }

    public final URL component1() {
        return getRequestUrl();
    }

    public final Map<String, String> component2() {
        return getHeaders();
    }

    public final NativeAuthRequestSignUpContinueRequestParameters component3() {
        return getParameters();
    }

    public final SignUpContinueRequest copy(URL requestUrl, Map<String, String> headers, NativeAuthRequestSignUpContinueRequestParameters parameters) {
        Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        return new SignUpContinueRequest(requestUrl, headers, parameters);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SignUpContinueRequest)) {
            return false;
        }
        SignUpContinueRequest signUpContinueRequest = (SignUpContinueRequest) other;
        return Intrinsics.areEqual(getRequestUrl(), signUpContinueRequest.getRequestUrl()) && Intrinsics.areEqual(getHeaders(), signUpContinueRequest.getHeaders()) && Intrinsics.areEqual(getParameters(), signUpContinueRequest.getParameters());
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
    public NativeAuthRequestSignUpContinueRequestParameters getParameters() {
        return this.parameters;
    }

    private SignUpContinueRequest(URL url, Map<String, String> map, NativeAuthRequestSignUpContinueRequestParameters nativeAuthRequestSignUpContinueRequestParameters) {
        this.requestUrl = url;
        this.headers = map;
        this.parameters = nativeAuthRequestSignUpContinueRequestParameters;
    }

    /* JADX INFO: compiled from: SignUpContinueRequest.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jl\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t0\b¨\u0006\u0010"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signup/SignUpContinueRequest$Companion;", "", "()V", PasskeyWebListener.CREATE_UNIQUE_KEY, "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signup/SignUpContinueRequest;", "password", "", NativeAuthConstants.GrantType.ATTRIBUTES, "", "", "oob", "clientId", "continuationToken", "grantType", "requestUrl", "headers", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SignUpContinueRequest create$default(Companion companion, char[] cArr, Map map, String str, String str2, String str3, String str4, String str5, Map map2, int i, Object obj) {
            if ((i & 1) != 0) {
                cArr = null;
            }
            if ((i & 2) != 0) {
                map = null;
            }
            if ((i & 4) != 0) {
                str = null;
            }
            return companion.create(cArr, map, str, str2, str3, str4, str5, map2);
        }

        public final SignUpContinueRequest create(char[] password, Map<String, String> attributes, String oob, String clientId, String continuationToken, String grantType, String requestUrl, Map<String, String> headers) throws ClientException {
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            Intrinsics.checkNotNullParameter(grantType, "grantType");
            Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
            Intrinsics.checkNotNullParameter(headers, "headers");
            ArgUtils.INSTANCE.validateNonNullArg(clientId, "clientId");
            ArgUtils.INSTANCE.validateNonNullArg(continuationToken, "continuationToken");
            ArgUtils.INSTANCE.validateNonNullArg(grantType, "grantType");
            ArgUtils.INSTANCE.validateNonNullArg(requestUrl, "requestUrl");
            ArgUtils.INSTANCE.validateNonNullArg(headers, "headers");
            if (Intrinsics.areEqual(grantType, "oob")) {
                ArgUtils.INSTANCE.validateNonNullArg(oob, "oob");
            }
            if (Intrinsics.areEqual(grantType, "password")) {
                ArgUtils.INSTANCE.validateNonNullArg(password, "password");
            }
            if (Intrinsics.areEqual(grantType, NativeAuthConstants.GrantType.ATTRIBUTES)) {
                ArgUtils.INSTANCE.validateNonNullArg(attributes, NativeAuthConstants.GrantType.ATTRIBUTES);
            }
            return new SignUpContinueRequest(new URL(requestUrl), headers, new NativeAuthRequestSignUpContinueRequestParameters(password, attributes != null ? NativeAuthRequest.INSTANCE.toJsonString(attributes, attributes) : null, oob, clientId, continuationToken, grantType), null);
        }
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toUnsanitizedString() {
        return "SignUpContinueRequest(requestUrl=" + getRequestUrl() + ", headers=" + getHeaders() + ", parameters=" + getParameters() + ')';
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toString() {
        return "SignUpContinueRequest()";
    }

    /* JADX INFO: compiled from: SignUpContinueRequest.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003JK\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\b\u0010 \u001a\u00020\u0005H\u0016J\b\u0010!\u001a\u00020\u0005H\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0007\u001a\u00020\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\""}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signup/SignUpContinueRequest$NativeAuthRequestSignUpContinueRequestParameters;", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/NativeAuthRequest$NativeAuthRequestParameters;", "password", "", NativeAuthConstants.GrantType.ATTRIBUTES, "", "oob", "clientId", "continuationToken", "grantType", "([CLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAttributes", "()Ljava/lang/String;", "getClientId", "getContinuationToken", "getGrantType", "getOob", "getPassword", "()[C", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class NativeAuthRequestSignUpContinueRequestParameters extends NativeAuthRequest.NativeAuthRequestParameters {
        private final String attributes;

        @SerializedName("client_id")
        private final String clientId;

        @SerializedName(NativeAuthConstants.GrantType.CONTINUATION_TOKEN)
        private final String continuationToken;

        @SerializedName("grant_type")
        private final String grantType;
        private final String oob;

        @JsonAdapter(CharArrayJsonAdapter.class)
        private final char[] password;

        public static /* synthetic */ NativeAuthRequestSignUpContinueRequestParameters copy$default(NativeAuthRequestSignUpContinueRequestParameters nativeAuthRequestSignUpContinueRequestParameters, char[] cArr, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
            if ((i & 1) != 0) {
                cArr = nativeAuthRequestSignUpContinueRequestParameters.password;
            }
            if ((i & 2) != 0) {
                str = nativeAuthRequestSignUpContinueRequestParameters.attributes;
            }
            if ((i & 4) != 0) {
                str2 = nativeAuthRequestSignUpContinueRequestParameters.oob;
            }
            if ((i & 8) != 0) {
                str3 = nativeAuthRequestSignUpContinueRequestParameters.getClientId();
            }
            if ((i & 16) != 0) {
                str4 = nativeAuthRequestSignUpContinueRequestParameters.continuationToken;
            }
            if ((i & 32) != 0) {
                str5 = nativeAuthRequestSignUpContinueRequestParameters.grantType;
            }
            String str6 = str4;
            String str7 = str5;
            return nativeAuthRequestSignUpContinueRequestParameters.copy(cArr, str, str2, str3, str6, str7);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final char[] getPassword() {
            return this.password;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getAttributes() {
            return this.attributes;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getOob() {
            return this.oob;
        }

        public final String component4() {
            return getClientId();
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getContinuationToken() {
            return this.continuationToken;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getGrantType() {
            return this.grantType;
        }

        public final NativeAuthRequestSignUpContinueRequestParameters copy(char[] password, String attributes, String oob, String clientId, String continuationToken, String grantType) {
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            Intrinsics.checkNotNullParameter(grantType, "grantType");
            return new NativeAuthRequestSignUpContinueRequestParameters(password, attributes, oob, clientId, continuationToken, grantType);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NativeAuthRequestSignUpContinueRequestParameters)) {
                return false;
            }
            NativeAuthRequestSignUpContinueRequestParameters nativeAuthRequestSignUpContinueRequestParameters = (NativeAuthRequestSignUpContinueRequestParameters) other;
            return Intrinsics.areEqual(this.password, nativeAuthRequestSignUpContinueRequestParameters.password) && Intrinsics.areEqual(this.attributes, nativeAuthRequestSignUpContinueRequestParameters.attributes) && Intrinsics.areEqual(this.oob, nativeAuthRequestSignUpContinueRequestParameters.oob) && Intrinsics.areEqual(getClientId(), nativeAuthRequestSignUpContinueRequestParameters.getClientId()) && Intrinsics.areEqual(this.continuationToken, nativeAuthRequestSignUpContinueRequestParameters.continuationToken) && Intrinsics.areEqual(this.grantType, nativeAuthRequestSignUpContinueRequestParameters.grantType);
        }

        public int hashCode() {
            char[] cArr = this.password;
            int iHashCode = (cArr == null ? 0 : Arrays.hashCode(cArr)) * 31;
            String str = this.attributes;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.oob;
            return ((((((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + getClientId().hashCode()) * 31) + this.continuationToken.hashCode()) * 31) + this.grantType.hashCode();
        }

        public /* synthetic */ NativeAuthRequestSignUpContinueRequestParameters(char[] cArr, String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(cArr, (i & 2) != 0 ? null : str, str2, str3, str4, str5);
        }

        public final char[] getPassword() {
            return this.password;
        }

        public final String getAttributes() {
            return this.attributes;
        }

        public final String getOob() {
            return this.oob;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.requests.NativeAuthRequest.NativeAuthRequestParameters
        public String getClientId() {
            return this.clientId;
        }

        public final String getContinuationToken() {
            return this.continuationToken;
        }

        public final String getGrantType() {
            return this.grantType;
        }

        public NativeAuthRequestSignUpContinueRequestParameters(char[] cArr, String str, String str2, String clientId, String continuationToken, String grantType) {
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            Intrinsics.checkNotNullParameter(grantType, "grantType");
            this.password = cArr;
            this.attributes = str;
            this.oob = str2;
            this.clientId = clientId;
            this.continuationToken = continuationToken;
            this.grantType = grantType;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toUnsanitizedString() {
            return "NativeAuthRequestSignUpContinueRequestParameters(clientId=" + getClientId() + ", grantType=" + this.grantType + ')';
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toString() {
            return "NativeAuthRequestSignUpContinueRequestParameters(clientId=" + getClientId() + ')';
        }
    }
}
