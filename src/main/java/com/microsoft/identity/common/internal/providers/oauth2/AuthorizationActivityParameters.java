package com.microsoft.identity.common.internal.providers.oauth2;

import android.content.Context;
import android.content.Intent;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.microsoft.identity.common.java.AuthenticationConstants;
import com.microsoft.identity.common.java.ui.AuthorizationAgent;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AuthorizationActivityParameters.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b(\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B§\u0001\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012&\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\nj\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000f¢\u0006\u0002\u0010\u0017J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u0010(J\t\u00100\u001a\u00020\u000fHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00102\u001a\u00020\u0007HÆ\u0003J\t\u00103\u001a\u00020\u0007HÆ\u0003J)\u00104\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\nj\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u000bHÆ\u0003J\t\u00105\u001a\u00020\rHÆ\u0003J\t\u00106\u001a\u00020\u000fHÆ\u0003J\t\u00107\u001a\u00020\u000fHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0007HÆ\u0003Jº\u0001\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072(\b\u0002\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\nj\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u000fHÆ\u0001¢\u0006\u0002\u0010:J\u0013\u0010;\u001a\u00020\u000f2\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010=\u001a\u00020>HÖ\u0001J\t\u0010?\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0016\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u001eR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R1\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\nj\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u000b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b#\u0010 R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010 R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010 R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b&\u0010 R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010)\u001a\u0004\b'\u0010(R\u0011\u0010\u0010\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001eR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001e¨\u0006@"}, d2 = {"Lcom/microsoft/identity/common/internal/providers/oauth2/AuthorizationActivityParameters;", "", "context", "Landroid/content/Context;", "authIntent", "Landroid/content/Intent;", "requestUrl", "", "redirectUri", "requestHeader", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "authorizationAgent", "Lcom/microsoft/identity/common/java/ui/AuthorizationAgent;", "webViewZoomEnabled", "", "webViewZoomControlsEnabled", "sourceLibraryName", "sourceLibraryVersion", AuthenticationConstants.OAuth2.UTID, "webViewEnableSilentAuthorizationFlowTimeOutMs", "", "isWebViewWebCpEnabled", "(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;Lcom/microsoft/identity/common/java/ui/AuthorizationAgent;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Z)V", "getAuthIntent", "()Landroid/content/Intent;", "getAuthorizationAgent", "()Lcom/microsoft/identity/common/java/ui/AuthorizationAgent;", "getContext", "()Landroid/content/Context;", "()Z", "getRedirectUri", "()Ljava/lang/String;", "getRequestHeader", "()Ljava/util/HashMap;", "getRequestUrl", "getSourceLibraryName", "getSourceLibraryVersion", "getUtid", "getWebViewEnableSilentAuthorizationFlowTimeOutMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getWebViewZoomControlsEnabled", "getWebViewZoomEnabled", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;Lcom/microsoft/identity/common/java/ui/AuthorizationAgent;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Z)Lcom/microsoft/identity/common/internal/providers/oauth2/AuthorizationActivityParameters;", "equals", "other", "hashCode", "", "toString", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AuthorizationActivityParameters {
    private final Intent authIntent;
    private final AuthorizationAgent authorizationAgent;
    private final Context context;
    private final boolean isWebViewWebCpEnabled;
    private final String redirectUri;
    private final HashMap<String, String> requestHeader;
    private final String requestUrl;
    private final String sourceLibraryName;
    private final String sourceLibraryVersion;
    private final String utid;
    private final Long webViewEnableSilentAuthorizationFlowTimeOutMs;
    private final boolean webViewZoomControlsEnabled;
    private final boolean webViewZoomEnabled;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AuthorizationActivityParameters(Context context, Intent intent, String requestUrl, String redirectUri, HashMap<String, String> map, AuthorizationAgent authorizationAgent) {
        this(context, intent, requestUrl, redirectUri, map, authorizationAgent, false, false, null, null, null, null, false, 8128, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
        Intrinsics.checkNotNullParameter(redirectUri, "redirectUri");
        Intrinsics.checkNotNullParameter(authorizationAgent, "authorizationAgent");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AuthorizationActivityParameters(Context context, Intent intent, String requestUrl, String redirectUri, HashMap<String, String> map, AuthorizationAgent authorizationAgent, boolean z) {
        this(context, intent, requestUrl, redirectUri, map, authorizationAgent, z, false, null, null, null, null, false, 8064, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
        Intrinsics.checkNotNullParameter(redirectUri, "redirectUri");
        Intrinsics.checkNotNullParameter(authorizationAgent, "authorizationAgent");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AuthorizationActivityParameters(Context context, Intent intent, String requestUrl, String redirectUri, HashMap<String, String> map, AuthorizationAgent authorizationAgent, boolean z, boolean z2) {
        this(context, intent, requestUrl, redirectUri, map, authorizationAgent, z, z2, null, null, null, null, false, 7936, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
        Intrinsics.checkNotNullParameter(redirectUri, "redirectUri");
        Intrinsics.checkNotNullParameter(authorizationAgent, "authorizationAgent");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AuthorizationActivityParameters(Context context, Intent intent, String requestUrl, String redirectUri, HashMap<String, String> map, AuthorizationAgent authorizationAgent, boolean z, boolean z2, String str) {
        this(context, intent, requestUrl, redirectUri, map, authorizationAgent, z, z2, str, null, null, null, false, 7680, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
        Intrinsics.checkNotNullParameter(redirectUri, "redirectUri");
        Intrinsics.checkNotNullParameter(authorizationAgent, "authorizationAgent");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AuthorizationActivityParameters(Context context, Intent intent, String requestUrl, String redirectUri, HashMap<String, String> map, AuthorizationAgent authorizationAgent, boolean z, boolean z2, String str, String str2) {
        this(context, intent, requestUrl, redirectUri, map, authorizationAgent, z, z2, str, str2, null, null, false, 7168, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
        Intrinsics.checkNotNullParameter(redirectUri, "redirectUri");
        Intrinsics.checkNotNullParameter(authorizationAgent, "authorizationAgent");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AuthorizationActivityParameters(Context context, Intent intent, String requestUrl, String redirectUri, HashMap<String, String> map, AuthorizationAgent authorizationAgent, boolean z, boolean z2, String str, String str2, String str3) {
        this(context, intent, requestUrl, redirectUri, map, authorizationAgent, z, z2, str, str2, str3, null, false, 6144, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
        Intrinsics.checkNotNullParameter(redirectUri, "redirectUri");
        Intrinsics.checkNotNullParameter(authorizationAgent, "authorizationAgent");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AuthorizationActivityParameters(Context context, Intent intent, String requestUrl, String redirectUri, HashMap<String, String> map, AuthorizationAgent authorizationAgent, boolean z, boolean z2, String str, String str2, String str3, Long l) {
        this(context, intent, requestUrl, redirectUri, map, authorizationAgent, z, z2, str, str2, str3, l, false, 4096, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
        Intrinsics.checkNotNullParameter(redirectUri, "redirectUri");
        Intrinsics.checkNotNullParameter(authorizationAgent, "authorizationAgent");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AuthorizationActivityParameters copy$default(AuthorizationActivityParameters authorizationActivityParameters, Context context, Intent intent, String str, String str2, HashMap map, AuthorizationAgent authorizationAgent, boolean z, boolean z2, String str3, String str4, String str5, Long l, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            context = authorizationActivityParameters.context;
        }
        return authorizationActivityParameters.copy(context, (i & 2) != 0 ? authorizationActivityParameters.authIntent : intent, (i & 4) != 0 ? authorizationActivityParameters.requestUrl : str, (i & 8) != 0 ? authorizationActivityParameters.redirectUri : str2, (i & 16) != 0 ? authorizationActivityParameters.requestHeader : map, (i & 32) != 0 ? authorizationActivityParameters.authorizationAgent : authorizationAgent, (i & 64) != 0 ? authorizationActivityParameters.webViewZoomEnabled : z, (i & 128) != 0 ? authorizationActivityParameters.webViewZoomControlsEnabled : z2, (i & 256) != 0 ? authorizationActivityParameters.sourceLibraryName : str3, (i & 512) != 0 ? authorizationActivityParameters.sourceLibraryVersion : str4, (i & 1024) != 0 ? authorizationActivityParameters.utid : str5, (i & 2048) != 0 ? authorizationActivityParameters.webViewEnableSilentAuthorizationFlowTimeOutMs : l, (i & 4096) != 0 ? authorizationActivityParameters.isWebViewWebCpEnabled : z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getSourceLibraryVersion() {
        return this.sourceLibraryVersion;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getUtid() {
        return this.utid;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Long getWebViewEnableSilentAuthorizationFlowTimeOutMs() {
        return this.webViewEnableSilentAuthorizationFlowTimeOutMs;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final boolean getIsWebViewWebCpEnabled() {
        return this.isWebViewWebCpEnabled;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Intent getAuthIntent() {
        return this.authIntent;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getRequestUrl() {
        return this.requestUrl;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getRedirectUri() {
        return this.redirectUri;
    }

    public final HashMap<String, String> component5() {
        return this.requestHeader;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final AuthorizationAgent getAuthorizationAgent() {
        return this.authorizationAgent;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getWebViewZoomEnabled() {
        return this.webViewZoomEnabled;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getWebViewZoomControlsEnabled() {
        return this.webViewZoomControlsEnabled;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getSourceLibraryName() {
        return this.sourceLibraryName;
    }

    public final AuthorizationActivityParameters copy(Context context, Intent authIntent, String requestUrl, String redirectUri, HashMap<String, String> requestHeader, AuthorizationAgent authorizationAgent, boolean webViewZoomEnabled, boolean webViewZoomControlsEnabled, String sourceLibraryName, String sourceLibraryVersion, String utid, Long webViewEnableSilentAuthorizationFlowTimeOutMs, boolean isWebViewWebCpEnabled) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
        Intrinsics.checkNotNullParameter(redirectUri, "redirectUri");
        Intrinsics.checkNotNullParameter(authorizationAgent, "authorizationAgent");
        return new AuthorizationActivityParameters(context, authIntent, requestUrl, redirectUri, requestHeader, authorizationAgent, webViewZoomEnabled, webViewZoomControlsEnabled, sourceLibraryName, sourceLibraryVersion, utid, webViewEnableSilentAuthorizationFlowTimeOutMs, isWebViewWebCpEnabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AuthorizationActivityParameters)) {
            return false;
        }
        AuthorizationActivityParameters authorizationActivityParameters = (AuthorizationActivityParameters) other;
        return Intrinsics.areEqual(this.context, authorizationActivityParameters.context) && Intrinsics.areEqual(this.authIntent, authorizationActivityParameters.authIntent) && Intrinsics.areEqual(this.requestUrl, authorizationActivityParameters.requestUrl) && Intrinsics.areEqual(this.redirectUri, authorizationActivityParameters.redirectUri) && Intrinsics.areEqual(this.requestHeader, authorizationActivityParameters.requestHeader) && this.authorizationAgent == authorizationActivityParameters.authorizationAgent && this.webViewZoomEnabled == authorizationActivityParameters.webViewZoomEnabled && this.webViewZoomControlsEnabled == authorizationActivityParameters.webViewZoomControlsEnabled && Intrinsics.areEqual(this.sourceLibraryName, authorizationActivityParameters.sourceLibraryName) && Intrinsics.areEqual(this.sourceLibraryVersion, authorizationActivityParameters.sourceLibraryVersion) && Intrinsics.areEqual(this.utid, authorizationActivityParameters.utid) && Intrinsics.areEqual(this.webViewEnableSilentAuthorizationFlowTimeOutMs, authorizationActivityParameters.webViewEnableSilentAuthorizationFlowTimeOutMs) && this.isWebViewWebCpEnabled == authorizationActivityParameters.isWebViewWebCpEnabled;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v25, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15, types: [int] */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        int iHashCode = this.context.hashCode() * 31;
        Intent intent = this.authIntent;
        int iHashCode2 = (((((iHashCode + (intent == null ? 0 : intent.hashCode())) * 31) + this.requestUrl.hashCode()) * 31) + this.redirectUri.hashCode()) * 31;
        HashMap<String, String> map = this.requestHeader;
        int iHashCode3 = (((iHashCode2 + (map == null ? 0 : map.hashCode())) * 31) + this.authorizationAgent.hashCode()) * 31;
        boolean z = this.webViewZoomEnabled;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode3 + r1) * 31;
        boolean z2 = this.webViewZoomControlsEnabled;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        String str = this.sourceLibraryName;
        int iHashCode4 = (i2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.sourceLibraryVersion;
        int iHashCode5 = (iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.utid;
        int iHashCode6 = (iHashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Long l = this.webViewEnableSilentAuthorizationFlowTimeOutMs;
        int iHashCode7 = (iHashCode6 + (l != null ? l.hashCode() : 0)) * 31;
        boolean z3 = this.isWebViewWebCpEnabled;
        return iHashCode7 + (z3 ? 1 : z3);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AuthorizationActivityParameters(context=");
        sb.append(this.context).append(", authIntent=").append(this.authIntent).append(", requestUrl=").append(this.requestUrl).append(", redirectUri=").append(this.redirectUri).append(", requestHeader=").append(this.requestHeader).append(", authorizationAgent=").append(this.authorizationAgent).append(", webViewZoomEnabled=").append(this.webViewZoomEnabled).append(", webViewZoomControlsEnabled=").append(this.webViewZoomControlsEnabled).append(", sourceLibraryName=").append(this.sourceLibraryName).append(", sourceLibraryVersion=").append(this.sourceLibraryVersion).append(", utid=").append(this.utid).append(", webViewEnableSilentAuthorizationFlowTimeOutMs=");
        sb.append(this.webViewEnableSilentAuthorizationFlowTimeOutMs).append(", isWebViewWebCpEnabled=").append(this.isWebViewWebCpEnabled).append(')');
        return sb.toString();
    }

    public AuthorizationActivityParameters(Context context, Intent intent, String requestUrl, String redirectUri, HashMap<String, String> map, AuthorizationAgent authorizationAgent, boolean z, boolean z2, String str, String str2, String str3, Long l, boolean z3) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
        Intrinsics.checkNotNullParameter(redirectUri, "redirectUri");
        Intrinsics.checkNotNullParameter(authorizationAgent, "authorizationAgent");
        this.context = context;
        this.authIntent = intent;
        this.requestUrl = requestUrl;
        this.redirectUri = redirectUri;
        this.requestHeader = map;
        this.authorizationAgent = authorizationAgent;
        this.webViewZoomEnabled = z;
        this.webViewZoomControlsEnabled = z2;
        this.sourceLibraryName = str;
        this.sourceLibraryVersion = str2;
        this.utid = str3;
        this.webViewEnableSilentAuthorizationFlowTimeOutMs = l;
        this.isWebViewWebCpEnabled = z3;
    }

    public /* synthetic */ AuthorizationActivityParameters(Context context, Intent intent, String str, String str2, HashMap map, AuthorizationAgent authorizationAgent, boolean z, boolean z2, String str3, String str4, String str5, Long l, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, intent, str, str2, map, authorizationAgent, (i & 64) != 0 ? true : z, (i & 128) != 0 ? true : z2, (i & 256) != 0 ? null : str3, (i & 512) != 0 ? null : str4, (i & 1024) != 0 ? null : str5, (i & 2048) != 0 ? null : l, (i & 4096) != 0 ? false : z3);
    }

    public final Context getContext() {
        return this.context;
    }

    public final Intent getAuthIntent() {
        return this.authIntent;
    }

    public final String getRequestUrl() {
        return this.requestUrl;
    }

    public final String getRedirectUri() {
        return this.redirectUri;
    }

    public final HashMap<String, String> getRequestHeader() {
        return this.requestHeader;
    }

    public final AuthorizationAgent getAuthorizationAgent() {
        return this.authorizationAgent;
    }

    public final boolean getWebViewZoomEnabled() {
        return this.webViewZoomEnabled;
    }

    public final boolean getWebViewZoomControlsEnabled() {
        return this.webViewZoomControlsEnabled;
    }

    public final String getSourceLibraryName() {
        return this.sourceLibraryName;
    }

    public final String getSourceLibraryVersion() {
        return this.sourceLibraryVersion;
    }

    public final String getUtid() {
        return this.utid;
    }

    public final Long getWebViewEnableSilentAuthorizationFlowTimeOutMs() {
        return this.webViewEnableSilentAuthorizationFlowTimeOutMs;
    }

    public final boolean isWebViewWebCpEnabled() {
        return this.isWebViewWebCpEnabled;
    }
}
