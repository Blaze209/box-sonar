package com.box.android.domain.models.observability;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.androidsdk.content.auth.OAuthActivity;
import com.box.androidsdk.content.models.BoxEnterprise;
import com.box.androidsdk.content.models.BoxUser;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MetricsModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/observability/UserMetric;", "", OAuthActivity.USER_ID, "", "username", "enterpriseId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUserId", "()Ljava/lang/String;", "getUsername", "getEnterpriseId", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "Factory", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class UserMetric {

    /* JADX INFO: renamed from: Factory, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String enterpriseId;
    private final String userId;
    private final String username;

    public static /* synthetic */ UserMetric copy$default(UserMetric userMetric, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userMetric.userId;
        }
        if ((i & 2) != 0) {
            str2 = userMetric.username;
        }
        if ((i & 4) != 0) {
            str3 = userMetric.enterpriseId;
        }
        return userMetric.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUsername() {
        return this.username;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getEnterpriseId() {
        return this.enterpriseId;
    }

    public final UserMetric copy(String userId, String username, String enterpriseId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(username, "username");
        return new UserMetric(userId, username, enterpriseId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserMetric)) {
            return false;
        }
        UserMetric userMetric = (UserMetric) other;
        return Intrinsics.areEqual(this.userId, userMetric.userId) && Intrinsics.areEqual(this.username, userMetric.username) && Intrinsics.areEqual(this.enterpriseId, userMetric.enterpriseId);
    }

    public int hashCode() {
        int iHashCode = ((this.userId.hashCode() * 31) + this.username.hashCode()) * 31;
        String str = this.enterpriseId;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "UserMetric(userId=" + this.userId + ", username=" + this.username + ", enterpriseId=" + this.enterpriseId + ")";
    }

    /* JADX INFO: renamed from: com.box.android.domain.models.observability.UserMetric$Factory, reason: from kotlin metadata */
    /* JADX INFO: compiled from: MetricsModel.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/domain/models/observability/UserMetric$Factory;", "", "<init>", "()V", TypedValues.TransitionType.S_FROM, "Lcom/box/android/domain/models/observability/UserMetric;", "user", "Lcom/box/androidsdk/content/models/BoxUser;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UserMetric from(BoxUser user) {
            if (user == null) {
                return null;
            }
            String id = user.getUserId();
            Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
            String login = user.getLogin();
            Intrinsics.checkNotNullExpressionValue(login, "getLogin(...)");
            BoxEnterprise enterprise = user.getEnterprise();
            return new UserMetric(id, login, enterprise != null ? enterprise.getUserId() : null);
        }
    }

    public UserMetric(String userId, String username, String str) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(username, "username");
        this.userId = userId;
        this.username = username;
        this.enterpriseId = str;
    }

    public final String getEnterpriseId() {
        return this.enterpriseId;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUsername() {
        return this.username;
    }
}
