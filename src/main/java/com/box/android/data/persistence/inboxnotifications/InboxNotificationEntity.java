package com.box.android.data.persistence.inboxnotifications;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.util.Arrays;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationEntity.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u001c\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\t\u0010#\u001a\u00020\bHÆ\u0003J\t\u0010$\u001a\u00020\bHÆ\u0003J\t\u0010%\u001a\u00020\u000bHÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\t\u0010'\u001a\u00020\u000eHÆ\u0003JY\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0016R\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0016R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0016\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006*"}, d2 = {"Lcom/box/android/data/persistence/inboxnotifications/InboxNotificationEntity;", "", "notificationId", "", "type", "createdAt", "Ljava/util/Date;", "isSeen", "", "isRead", "jsonData", "", "networkFetchedAt", "source", "Lcom/box/android/data/persistence/inboxnotifications/NotificationSource;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;ZZ[BLjava/util/Date;Lcom/box/android/data/persistence/inboxnotifications/NotificationSource;)V", "getNotificationId", "()Ljava/lang/String;", "getType", "getCreatedAt", "()Ljava/util/Date;", "()Z", "getJsonData", "()[B", "getNetworkFetchedAt", "getSource", "()Lcom/box/android/data/persistence/inboxnotifications/NotificationSource;", "equals", "other", "hashCode", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class InboxNotificationEntity {
    private final Date createdAt;
    private final boolean isRead;
    private final boolean isSeen;
    private final byte[] jsonData;
    private final Date networkFetchedAt;
    private final String notificationId;
    private final NotificationSource source;
    private final String type;

    public static /* synthetic */ InboxNotificationEntity copy$default(InboxNotificationEntity inboxNotificationEntity, String str, String str2, Date date, boolean z, boolean z2, byte[] bArr, Date date2, NotificationSource notificationSource, int i, Object obj) {
        if ((i & 1) != 0) {
            str = inboxNotificationEntity.notificationId;
        }
        if ((i & 2) != 0) {
            str2 = inboxNotificationEntity.type;
        }
        if ((i & 4) != 0) {
            date = inboxNotificationEntity.createdAt;
        }
        if ((i & 8) != 0) {
            z = inboxNotificationEntity.isSeen;
        }
        if ((i & 16) != 0) {
            z2 = inboxNotificationEntity.isRead;
        }
        if ((i & 32) != 0) {
            bArr = inboxNotificationEntity.jsonData;
        }
        if ((i & 64) != 0) {
            date2 = inboxNotificationEntity.networkFetchedAt;
        }
        if ((i & 128) != 0) {
            notificationSource = inboxNotificationEntity.source;
        }
        Date date3 = date2;
        NotificationSource notificationSource2 = notificationSource;
        boolean z3 = z2;
        byte[] bArr2 = bArr;
        return inboxNotificationEntity.copy(str, str2, date, z, z3, bArr2, date3, notificationSource2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getNotificationId() {
        return this.notificationId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Date getCreatedAt() {
        return this.createdAt;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsSeen() {
        return this.isSeen;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsRead() {
        return this.isRead;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final byte[] getJsonData() {
        return this.jsonData;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Date getNetworkFetchedAt() {
        return this.networkFetchedAt;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final NotificationSource getSource() {
        return this.source;
    }

    public final InboxNotificationEntity copy(String notificationId, String type, Date createdAt, boolean isSeen, boolean isRead, byte[] jsonData, Date networkFetchedAt, NotificationSource source) {
        Intrinsics.checkNotNullParameter(notificationId, "notificationId");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(jsonData, "jsonData");
        Intrinsics.checkNotNullParameter(networkFetchedAt, "networkFetchedAt");
        Intrinsics.checkNotNullParameter(source, "source");
        return new InboxNotificationEntity(notificationId, type, createdAt, isSeen, isRead, jsonData, networkFetchedAt, source);
    }

    public String toString() {
        return "InboxNotificationEntity(notificationId=" + this.notificationId + ", type=" + this.type + ", createdAt=" + this.createdAt + ", isSeen=" + this.isSeen + ", isRead=" + this.isRead + ", jsonData=" + Arrays.toString(this.jsonData) + ", networkFetchedAt=" + this.networkFetchedAt + ", source=" + this.source + ")";
    }

    public InboxNotificationEntity(String notificationId, String type, Date createdAt, boolean z, boolean z2, byte[] jsonData, Date networkFetchedAt, NotificationSource source) {
        Intrinsics.checkNotNullParameter(notificationId, "notificationId");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(jsonData, "jsonData");
        Intrinsics.checkNotNullParameter(networkFetchedAt, "networkFetchedAt");
        Intrinsics.checkNotNullParameter(source, "source");
        this.notificationId = notificationId;
        this.type = type;
        this.createdAt = createdAt;
        this.isSeen = z;
        this.isRead = z2;
        this.jsonData = jsonData;
        this.networkFetchedAt = networkFetchedAt;
        this.source = source;
    }

    public final String getNotificationId() {
        return this.notificationId;
    }

    public final String getType() {
        return this.type;
    }

    public final Date getCreatedAt() {
        return this.createdAt;
    }

    public final boolean isSeen() {
        return this.isSeen;
    }

    public final boolean isRead() {
        return this.isRead;
    }

    public final byte[] getJsonData() {
        return this.jsonData;
    }

    public /* synthetic */ InboxNotificationEntity(String str, String str2, Date date, boolean z, boolean z2, byte[] bArr, Date date2, NotificationSource notificationSource, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, date, z, z2, bArr, (i & 64) != 0 ? new Date() : date2, (i & 128) != 0 ? NotificationSource.API : notificationSource);
    }

    public final Date getNetworkFetchedAt() {
        return this.networkFetchedAt;
    }

    public final NotificationSource getSource() {
        return this.source;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.box.android.data.persistence.inboxnotifications.InboxNotificationEntity");
        InboxNotificationEntity inboxNotificationEntity = (InboxNotificationEntity) other;
        return Intrinsics.areEqual(this.notificationId, inboxNotificationEntity.notificationId) && Intrinsics.areEqual(this.type, inboxNotificationEntity.type) && Intrinsics.areEqual(this.createdAt, inboxNotificationEntity.createdAt) && this.isSeen == inboxNotificationEntity.isSeen && this.isRead == inboxNotificationEntity.isRead && Arrays.equals(this.jsonData, inboxNotificationEntity.jsonData) && Intrinsics.areEqual(this.networkFetchedAt, inboxNotificationEntity.networkFetchedAt) && this.source == inboxNotificationEntity.source;
    }

    public int hashCode() {
        return (((((((((((((this.notificationId.hashCode() * 31) + this.type.hashCode()) * 31) + this.createdAt.hashCode()) * 31) + Boolean.hashCode(this.isSeen)) * 31) + Boolean.hashCode(this.isRead)) * 31) + Arrays.hashCode(this.jsonData)) * 31) + this.networkFetchedAt.hashCode()) * 31) + this.source.hashCode();
    }
}
