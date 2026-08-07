package com.microsoft.identity.common.internal.ui.webview.challengehandlers;

import android.net.Uri;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.microsoft.identity.common.internal.ui.webview.switchbrowser.SwitchBrowserUriHelper;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SwitchBrowserChallenge.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/microsoft/identity/common/internal/ui/webview/challengehandlers/SwitchBrowserChallenge;", "", "processUri", "Landroid/net/Uri;", "authorizationUrl", "", "(Landroid/net/Uri;Ljava/lang/String;)V", "getAuthorizationUrl", "()Ljava/lang/String;", "getProcessUri", "()Landroid/net/Uri;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "Companion", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SwitchBrowserChallenge {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String authorizationUrl;
    private final Uri processUri;

    @JvmStatic
    public static final SwitchBrowserChallenge constructFromRedirectUrl(String str, String str2) throws Exception {
        return INSTANCE.constructFromRedirectUrl(str, str2);
    }

    public static /* synthetic */ SwitchBrowserChallenge copy$default(SwitchBrowserChallenge switchBrowserChallenge, Uri uri, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            uri = switchBrowserChallenge.processUri;
        }
        if ((i & 2) != 0) {
            str = switchBrowserChallenge.authorizationUrl;
        }
        return switchBrowserChallenge.copy(uri, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Uri getProcessUri() {
        return this.processUri;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAuthorizationUrl() {
        return this.authorizationUrl;
    }

    public final SwitchBrowserChallenge copy(Uri processUri, String authorizationUrl) {
        Intrinsics.checkNotNullParameter(processUri, "processUri");
        Intrinsics.checkNotNullParameter(authorizationUrl, "authorizationUrl");
        return new SwitchBrowserChallenge(processUri, authorizationUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SwitchBrowserChallenge)) {
            return false;
        }
        SwitchBrowserChallenge switchBrowserChallenge = (SwitchBrowserChallenge) other;
        return Intrinsics.areEqual(this.processUri, switchBrowserChallenge.processUri) && Intrinsics.areEqual(this.authorizationUrl, switchBrowserChallenge.authorizationUrl);
    }

    public int hashCode() {
        return (this.processUri.hashCode() * 31) + this.authorizationUrl.hashCode();
    }

    public String toString() {
        return "SwitchBrowserChallenge(processUri=" + this.processUri + ", authorizationUrl=" + this.authorizationUrl + ')';
    }

    public SwitchBrowserChallenge(Uri processUri, String authorizationUrl) {
        Intrinsics.checkNotNullParameter(processUri, "processUri");
        Intrinsics.checkNotNullParameter(authorizationUrl, "authorizationUrl");
        this.processUri = processUri;
        this.authorizationUrl = authorizationUrl;
    }

    public final Uri getProcessUri() {
        return this.processUri;
    }

    public final String getAuthorizationUrl() {
        return this.authorizationUrl;
    }

    /* JADX INFO: compiled from: SwitchBrowserChallenge.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\b"}, d2 = {"Lcom/microsoft/identity/common/internal/ui/webview/challengehandlers/SwitchBrowserChallenge$Companion;", "", "()V", "constructFromRedirectUrl", "Lcom/microsoft/identity/common/internal/ui/webview/challengehandlers/SwitchBrowserChallenge;", "redirectUrl", "", "authorizationUrl", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SwitchBrowserChallenge constructFromRedirectUrl(String redirectUrl, String authorizationUrl) throws Exception {
            Intrinsics.checkNotNullParameter(redirectUrl, "redirectUrl");
            Intrinsics.checkNotNullParameter(authorizationUrl, "authorizationUrl");
            Uri redirectUri = Uri.parse(redirectUrl);
            SwitchBrowserUriHelper switchBrowserUriHelper = SwitchBrowserUriHelper.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(redirectUri, "redirectUri");
            return new SwitchBrowserChallenge(switchBrowserUriHelper.buildProcessUri(redirectUri), authorizationUrl);
        }
    }
}
