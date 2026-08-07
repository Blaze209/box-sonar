package com.box.android.data.api.models.recentnotes;

import com.box.android.data.api.models.items.IItemDTO;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RecentNoteDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/box/android/data/api/models/recentnotes/RecentNoteDTO;", "", "item", "Lcom/box/android/data/api/models/items/IItemDTO;", "interactedAt", "", "interactionType", "interactionSharedLink", "<init>", "(Lcom/box/android/data/api/models/items/IItemDTO;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getItem", "()Lcom/box/android/data/api/models/items/IItemDTO;", "getInteractedAt", "()Ljava/lang/String;", "getInteractionType", "getInteractionSharedLink", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class RecentNoteDTO {
    private final String interactedAt;
    private final String interactionSharedLink;
    private final String interactionType;
    private final IItemDTO item;

    public static /* synthetic */ RecentNoteDTO copy$default(RecentNoteDTO recentNoteDTO, IItemDTO iItemDTO, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            iItemDTO = recentNoteDTO.item;
        }
        if ((i & 2) != 0) {
            str = recentNoteDTO.interactedAt;
        }
        if ((i & 4) != 0) {
            str2 = recentNoteDTO.interactionType;
        }
        if ((i & 8) != 0) {
            str3 = recentNoteDTO.interactionSharedLink;
        }
        return recentNoteDTO.copy(iItemDTO, str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final IItemDTO getItem() {
        return this.item;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getInteractedAt() {
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

    public final RecentNoteDTO copy(@Json(name = "item") IItemDTO item, @Json(name = "interacted_at") String interactedAt, @Json(name = "interaction_type") String interactionType, @Json(name = "interaction_shared_link") String interactionSharedLink) {
        Intrinsics.checkNotNullParameter(item, "item");
        return new RecentNoteDTO(item, interactedAt, interactionType, interactionSharedLink);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RecentNoteDTO)) {
            return false;
        }
        RecentNoteDTO recentNoteDTO = (RecentNoteDTO) other;
        return Intrinsics.areEqual(this.item, recentNoteDTO.item) && Intrinsics.areEqual(this.interactedAt, recentNoteDTO.interactedAt) && Intrinsics.areEqual(this.interactionType, recentNoteDTO.interactionType) && Intrinsics.areEqual(this.interactionSharedLink, recentNoteDTO.interactionSharedLink);
    }

    public int hashCode() {
        int iHashCode = this.item.hashCode() * 31;
        String str = this.interactedAt;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.interactionType;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.interactionSharedLink;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "RecentNoteDTO(item=" + this.item + ", interactedAt=" + this.interactedAt + ", interactionType=" + this.interactionType + ", interactionSharedLink=" + this.interactionSharedLink + ")";
    }

    public RecentNoteDTO(@Json(name = "item") IItemDTO item, @Json(name = "interacted_at") String str, @Json(name = "interaction_type") String str2, @Json(name = "interaction_shared_link") String str3) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.item = item;
        this.interactedAt = str;
        this.interactionType = str2;
        this.interactionSharedLink = str3;
    }

    public final IItemDTO getItem() {
        return this.item;
    }

    public final String getInteractedAt() {
        return this.interactedAt;
    }

    public final String getInteractionType() {
        return this.interactionType;
    }

    public final String getInteractionSharedLink() {
        return this.interactionSharedLink;
    }
}
