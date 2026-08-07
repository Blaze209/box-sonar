package com.box.android.data.persistence.capture;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.ItemId;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CaptureHistoryItemEntity.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/box/android/data/persistence/capture/CaptureHistoryItemEntity;", "", "localItemId", "Lcom/box/android/domain/models/ItemId$Local;", "contentCreatedAt", "Ljava/util/Date;", "lastUpdated", "<init>", "(Lcom/box/android/domain/models/ItemId$Local;Ljava/util/Date;Ljava/util/Date;)V", "getLocalItemId", "()Lcom/box/android/domain/models/ItemId$Local;", "getContentCreatedAt", "()Ljava/util/Date;", "getLastUpdated", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CaptureHistoryItemEntity {
    private final Date contentCreatedAt;
    private final Date lastUpdated;
    private final ItemId.Local localItemId;

    public static /* synthetic */ CaptureHistoryItemEntity copy$default(CaptureHistoryItemEntity captureHistoryItemEntity, ItemId.Local local, Date date, Date date2, int i, Object obj) {
        if ((i & 1) != 0) {
            local = captureHistoryItemEntity.localItemId;
        }
        if ((i & 2) != 0) {
            date = captureHistoryItemEntity.contentCreatedAt;
        }
        if ((i & 4) != 0) {
            date2 = captureHistoryItemEntity.lastUpdated;
        }
        return captureHistoryItemEntity.copy(local, date, date2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ItemId.Local getLocalItemId() {
        return this.localItemId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Date getContentCreatedAt() {
        return this.contentCreatedAt;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Date getLastUpdated() {
        return this.lastUpdated;
    }

    public final CaptureHistoryItemEntity copy(ItemId.Local localItemId, Date contentCreatedAt, Date lastUpdated) {
        Intrinsics.checkNotNullParameter(localItemId, "localItemId");
        Intrinsics.checkNotNullParameter(contentCreatedAt, "contentCreatedAt");
        Intrinsics.checkNotNullParameter(lastUpdated, "lastUpdated");
        return new CaptureHistoryItemEntity(localItemId, contentCreatedAt, lastUpdated);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CaptureHistoryItemEntity)) {
            return false;
        }
        CaptureHistoryItemEntity captureHistoryItemEntity = (CaptureHistoryItemEntity) other;
        return Intrinsics.areEqual(this.localItemId, captureHistoryItemEntity.localItemId) && Intrinsics.areEqual(this.contentCreatedAt, captureHistoryItemEntity.contentCreatedAt) && Intrinsics.areEqual(this.lastUpdated, captureHistoryItemEntity.lastUpdated);
    }

    public int hashCode() {
        return (((this.localItemId.hashCode() * 31) + this.contentCreatedAt.hashCode()) * 31) + this.lastUpdated.hashCode();
    }

    public String toString() {
        return "CaptureHistoryItemEntity(localItemId=" + this.localItemId + ", contentCreatedAt=" + this.contentCreatedAt + ", lastUpdated=" + this.lastUpdated + ")";
    }

    public CaptureHistoryItemEntity(ItemId.Local localItemId, Date contentCreatedAt, Date lastUpdated) {
        Intrinsics.checkNotNullParameter(localItemId, "localItemId");
        Intrinsics.checkNotNullParameter(contentCreatedAt, "contentCreatedAt");
        Intrinsics.checkNotNullParameter(lastUpdated, "lastUpdated");
        this.localItemId = localItemId;
        this.contentCreatedAt = contentCreatedAt;
        this.lastUpdated = lastUpdated;
    }

    public final ItemId.Local getLocalItemId() {
        return this.localItemId;
    }

    public /* synthetic */ CaptureHistoryItemEntity(ItemId.Local local, Date date, Date date2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(local, (i & 2) != 0 ? new Date() : date, (i & 4) != 0 ? new Date() : date2);
    }

    public final Date getContentCreatedAt() {
        return this.contentCreatedAt;
    }

    public final Date getLastUpdated() {
        return this.lastUpdated;
    }
}
