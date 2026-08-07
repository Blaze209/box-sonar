package com.box.android.data.persistence.recentnotes;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RecentNoteEntity.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J<\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/box/android/data/persistence/recentnotes/RecentNoteEntity;", "", "itemId", "", "interactedAt", "", "interactionType", "interactionSharedLink", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "getItemId", "()Ljava/lang/String;", "getInteractedAt", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getInteractionType", "getInteractionSharedLink", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lcom/box/android/data/persistence/recentnotes/RecentNoteEntity;", "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class RecentNoteEntity {
    private final Long interactedAt;
    private final String interactionSharedLink;
    private final String interactionType;
    private final String itemId;

    public static /* synthetic */ RecentNoteEntity copy$default(RecentNoteEntity recentNoteEntity, String str, Long l, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = recentNoteEntity.itemId;
        }
        if ((i & 2) != 0) {
            l = recentNoteEntity.interactedAt;
        }
        if ((i & 4) != 0) {
            str2 = recentNoteEntity.interactionType;
        }
        if ((i & 8) != 0) {
            str3 = recentNoteEntity.interactionSharedLink;
        }
        return recentNoteEntity.copy(str, l, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getItemId() {
        return this.itemId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getInteractedAt() {
        return this.interactedAt;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getInteractionType() {
        return this.interactionType;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getInteractionSharedLink() {
        return this.interactionSharedLink;
    }

    public final RecentNoteEntity copy(String itemId, Long interactedAt, String interactionType, String interactionSharedLink) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        return new RecentNoteEntity(itemId, interactedAt, interactionType, interactionSharedLink);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RecentNoteEntity)) {
            return false;
        }
        RecentNoteEntity recentNoteEntity = (RecentNoteEntity) other;
        return Intrinsics.areEqual(this.itemId, recentNoteEntity.itemId) && Intrinsics.areEqual(this.interactedAt, recentNoteEntity.interactedAt) && Intrinsics.areEqual(this.interactionType, recentNoteEntity.interactionType) && Intrinsics.areEqual(this.interactionSharedLink, recentNoteEntity.interactionSharedLink);
    }

    public int hashCode() {
        int iHashCode = this.itemId.hashCode() * 31;
        Long l = this.interactedAt;
        int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str = this.interactionType;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.interactionSharedLink;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "RecentNoteEntity(itemId=" + this.itemId + ", interactedAt=" + this.interactedAt + ", interactionType=" + this.interactionType + ", interactionSharedLink=" + this.interactionSharedLink + ")";
    }

    public RecentNoteEntity(String itemId, Long l, String str, String str2) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        this.itemId = itemId;
        this.interactedAt = l;
        this.interactionType = str;
        this.interactionSharedLink = str2;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final Long getInteractedAt() {
        return this.interactedAt;
    }

    public final String getInteractionType() {
        return this.interactionType;
    }

    public final String getInteractionSharedLink() {
        return this.interactionSharedLink;
    }
}
