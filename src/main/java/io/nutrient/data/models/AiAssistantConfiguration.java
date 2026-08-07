package io.nutrient.data.models;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.androidsdk.content.auth.OAuthActivity;
import com.pspdfkit.internal.z40;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J3\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lio/nutrient/data/models/AiAssistantConfiguration;", "", "serverUrl", "", "jwt", "sessionId", OAuthActivity.USER_ID, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getServerUrl", "()Ljava/lang/String;", "getJwt", "getSessionId", "getUserId", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class AiAssistantConfiguration {
    public static final int $stable = 0;
    private final String jwt;
    private final String serverUrl;
    private final String sessionId;
    private final String userId;

    public AiAssistantConfiguration(String str, String str2, String str3, String str4) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        this.serverUrl = str;
        this.jwt = str2;
        this.sessionId = str3;
        this.userId = str4;
    }

    public static /* synthetic */ AiAssistantConfiguration copy$default(AiAssistantConfiguration aiAssistantConfiguration, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = aiAssistantConfiguration.serverUrl;
        }
        if ((i & 2) != 0) {
            str2 = aiAssistantConfiguration.jwt;
        }
        if ((i & 4) != 0) {
            str3 = aiAssistantConfiguration.sessionId;
        }
        if ((i & 8) != 0) {
            str4 = aiAssistantConfiguration.userId;
        }
        return aiAssistantConfiguration.copy(str, str2, str3, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getServerUrl() {
        return this.serverUrl;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getJwt() {
        return this.jwt;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    public final AiAssistantConfiguration copy(String serverUrl, String jwt, String sessionId, String userId) {
        serverUrl.getClass();
        jwt.getClass();
        sessionId.getClass();
        return new AiAssistantConfiguration(serverUrl, jwt, sessionId, userId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AiAssistantConfiguration)) {
            return false;
        }
        AiAssistantConfiguration aiAssistantConfiguration = (AiAssistantConfiguration) other;
        return Intrinsics.areEqual(this.serverUrl, aiAssistantConfiguration.serverUrl) && Intrinsics.areEqual(this.jwt, aiAssistantConfiguration.jwt) && Intrinsics.areEqual(this.sessionId, aiAssistantConfiguration.sessionId) && Intrinsics.areEqual(this.userId, aiAssistantConfiguration.userId);
    }

    public final String getJwt() {
        return this.jwt;
    }

    public final String getServerUrl() {
        return this.serverUrl;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        int iA = z40.a(this.sessionId, z40.a(this.jwt, this.serverUrl.hashCode() * 31, 31), 31);
        String str = this.userId;
        return iA + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "AiAssistantConfiguration(serverUrl=" + this.serverUrl + ", jwt=" + this.jwt + ", sessionId=" + this.sessionId + ", userId=" + this.userId + ")";
    }

    public /* synthetic */ AiAssistantConfiguration(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i & 8) != 0 ? null : str4);
    }
}
