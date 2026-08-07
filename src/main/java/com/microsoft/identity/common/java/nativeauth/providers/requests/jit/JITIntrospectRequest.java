package com.microsoft.identity.common.java.nativeauth.providers.requests.jit;

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

/* JADX INFO: compiled from: JITIntrospectRequest.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0002 !B-\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J5\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\b\u0010\u001e\u001a\u00020\u0006H\u0016J\b\u0010\u001f\u001a\u00020\u0006H\u0016R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\""}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/requests/jit/JITIntrospectRequest;", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/NativeAuthRequest;", "requestUrl", "Ljava/net/URL;", "headers", "", "", "parameters", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/jit/JITIntrospectRequest$NativeAuthJITIntrospectRequestParameters;", "(Ljava/net/URL;Ljava/util/Map;Lcom/microsoft/identity/common/java/nativeauth/providers/requests/jit/JITIntrospectRequest$NativeAuthJITIntrospectRequestParameters;)V", "getHeaders", "()Ljava/util/Map;", "setHeaders", "(Ljava/util/Map;)V", "getParameters", "()Lcom/microsoft/identity/common/java/nativeauth/providers/requests/jit/JITIntrospectRequest$NativeAuthJITIntrospectRequestParameters;", "getRequestUrl", "()Ljava/net/URL;", "setRequestUrl", "(Ljava/net/URL;)V", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "Companion", "NativeAuthJITIntrospectRequestParameters", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class JITIntrospectRequest extends NativeAuthRequest {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Map<String, String> headers;
    private final NativeAuthJITIntrospectRequestParameters parameters;
    private URL requestUrl;

    public /* synthetic */ JITIntrospectRequest(URL url, Map map, NativeAuthJITIntrospectRequestParameters nativeAuthJITIntrospectRequestParameters, DefaultConstructorMarker defaultConstructorMarker) {
        this(url, map, nativeAuthJITIntrospectRequestParameters);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ JITIntrospectRequest copy$default(JITIntrospectRequest jITIntrospectRequest, URL url, Map map, NativeAuthJITIntrospectRequestParameters nativeAuthJITIntrospectRequestParameters, int i, Object obj) {
        if ((i & 1) != 0) {
            url = jITIntrospectRequest.getRequestUrl();
        }
        if ((i & 2) != 0) {
            map = jITIntrospectRequest.getHeaders();
        }
        if ((i & 4) != 0) {
            nativeAuthJITIntrospectRequestParameters = jITIntrospectRequest.getParameters();
        }
        return jITIntrospectRequest.copy(url, map, nativeAuthJITIntrospectRequestParameters);
    }

    public final URL component1() {
        return getRequestUrl();
    }

    public final Map<String, String> component2() {
        return getHeaders();
    }

    public final NativeAuthJITIntrospectRequestParameters component3() {
        return getParameters();
    }

    public final JITIntrospectRequest copy(URL requestUrl, Map<String, String> headers, NativeAuthJITIntrospectRequestParameters parameters) {
        Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        return new JITIntrospectRequest(requestUrl, headers, parameters);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JITIntrospectRequest)) {
            return false;
        }
        JITIntrospectRequest jITIntrospectRequest = (JITIntrospectRequest) other;
        return Intrinsics.areEqual(getRequestUrl(), jITIntrospectRequest.getRequestUrl()) && Intrinsics.areEqual(getHeaders(), jITIntrospectRequest.getHeaders()) && Intrinsics.areEqual(getParameters(), jITIntrospectRequest.getParameters());
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
    public NativeAuthJITIntrospectRequestParameters getParameters() {
        return this.parameters;
    }

    private JITIntrospectRequest(URL url, Map<String, String> map, NativeAuthJITIntrospectRequestParameters nativeAuthJITIntrospectRequestParameters) {
        this.requestUrl = url;
        this.headers = map;
        this.parameters = nativeAuthJITIntrospectRequestParameters;
    }

    /* JADX INFO: compiled from: JITIntrospectRequest.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\n¨\u0006\u000b"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/requests/jit/JITIntrospectRequest$Companion;", "", "()V", PasskeyWebListener.CREATE_UNIQUE_KEY, "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/jit/JITIntrospectRequest;", "clientId", "", "continuationToken", "requestUrl", "headers", "", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final JITIntrospectRequest create(String clientId, String continuationToken, String requestUrl, Map<String, String> headers) throws ClientException {
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
            Intrinsics.checkNotNullParameter(headers, "headers");
            ArgUtils.INSTANCE.validateNonNullArg(clientId, "clientId");
            ArgUtils.INSTANCE.validateNonNullArg(continuationToken, "continuationToken");
            return new JITIntrospectRequest(new URL(requestUrl), headers, new NativeAuthJITIntrospectRequestParameters(clientId, continuationToken), null);
        }
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toUnsanitizedString() {
        return "JITIntrospectRequest(requestUrl=" + getRequestUrl() + ", headers=" + getHeaders() + ", parameters=" + getParameters() + ')';
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toString() {
        return "JITIntrospectRequest()";
    }

    /* JADX INFO: compiled from: JITIntrospectRequest.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/requests/jit/JITIntrospectRequest$NativeAuthJITIntrospectRequestParameters;", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/NativeAuthRequest$NativeAuthRequestParameters;", "clientId", "", "continuationToken", "(Ljava/lang/String;Ljava/lang/String;)V", "getClientId", "()Ljava/lang/String;", "getContinuationToken", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class NativeAuthJITIntrospectRequestParameters extends NativeAuthRequest.NativeAuthRequestParameters {

        @SerializedName("client_id")
        private final String clientId;

        @SerializedName(NativeAuthConstants.GrantType.CONTINUATION_TOKEN)
        private final String continuationToken;

        public static /* synthetic */ NativeAuthJITIntrospectRequestParameters copy$default(NativeAuthJITIntrospectRequestParameters nativeAuthJITIntrospectRequestParameters, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = nativeAuthJITIntrospectRequestParameters.getClientId();
            }
            if ((i & 2) != 0) {
                str2 = nativeAuthJITIntrospectRequestParameters.continuationToken;
            }
            return nativeAuthJITIntrospectRequestParameters.copy(str, str2);
        }

        public final String component1() {
            return getClientId();
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getContinuationToken() {
            return this.continuationToken;
        }

        public final NativeAuthJITIntrospectRequestParameters copy(String clientId, String continuationToken) {
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            return new NativeAuthJITIntrospectRequestParameters(clientId, continuationToken);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NativeAuthJITIntrospectRequestParameters)) {
                return false;
            }
            NativeAuthJITIntrospectRequestParameters nativeAuthJITIntrospectRequestParameters = (NativeAuthJITIntrospectRequestParameters) other;
            return Intrinsics.areEqual(getClientId(), nativeAuthJITIntrospectRequestParameters.getClientId()) && Intrinsics.areEqual(this.continuationToken, nativeAuthJITIntrospectRequestParameters.continuationToken);
        }

        public int hashCode() {
            return (getClientId().hashCode() * 31) + this.continuationToken.hashCode();
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.requests.NativeAuthRequest.NativeAuthRequestParameters
        public String getClientId() {
            return this.clientId;
        }

        public final String getContinuationToken() {
            return this.continuationToken;
        }

        public NativeAuthJITIntrospectRequestParameters(String clientId, String continuationToken) {
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            this.clientId = clientId;
            this.continuationToken = continuationToken;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toUnsanitizedString() {
            return "NativeAuthJITIntrospectRequestParameters(clientId=" + getClientId() + ')';
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toString() {
            return toUnsanitizedString();
        }
    }
}
