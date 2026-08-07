package com.box.android.domain.models.annotations;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import com.box.androidsdk.content.auth.OAuthActivity;
import com.box.androidsdk.content.models.BoxOrder;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnnotationModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J5\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/box/android/domain/models/annotations/UserEventModel;", "Lcom/box/android/domain/models/DomainModel;", OAuthActivity.USER_ID, "", "userName", "userLogin", BoxOrder.SORT_DATE, "Ljava/util/Date;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;)V", "getUserId", "()Ljava/lang/String;", "getUserName", "getUserLogin", "getDate", "()Ljava/util/Date;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class UserEventModel implements DomainModel {
    private final Date date;
    private final String userId;
    private final String userLogin;
    private final String userName;

    public static /* synthetic */ UserEventModel copy$default(UserEventModel userEventModel, String str, String str2, String str3, Date date, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userEventModel.userId;
        }
        if ((i & 2) != 0) {
            str2 = userEventModel.userName;
        }
        if ((i & 4) != 0) {
            str3 = userEventModel.userLogin;
        }
        if ((i & 8) != 0) {
            date = userEventModel.date;
        }
        return userEventModel.copy(str, str2, str3, date);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUserName() {
        return this.userName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getUserLogin() {
        return this.userLogin;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Date getDate() {
        return this.date;
    }

    public final UserEventModel copy(String userId, String userName, String userLogin, Date date) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(date, "date");
        return new UserEventModel(userId, userName, userLogin, date);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserEventModel)) {
            return false;
        }
        UserEventModel userEventModel = (UserEventModel) other;
        return Intrinsics.areEqual(this.userId, userEventModel.userId) && Intrinsics.areEqual(this.userName, userEventModel.userName) && Intrinsics.areEqual(this.userLogin, userEventModel.userLogin) && Intrinsics.areEqual(this.date, userEventModel.date);
    }

    public int hashCode() {
        int iHashCode = this.userId.hashCode() * 31;
        String str = this.userName;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.userLogin;
        return ((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.date.hashCode();
    }

    public String toString() {
        return "UserEventModel(userId=" + this.userId + ", userName=" + this.userName + ", userLogin=" + this.userLogin + ", date=" + this.date + ")";
    }

    public UserEventModel(String userId, String str, String str2, Date date) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(date, "date");
        this.userId = userId;
        this.userName = str;
        this.userLogin = str2;
        this.date = date;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final String getUserLogin() {
        return this.userLogin;
    }

    public final Date getDate() {
        return this.date;
    }
}
