package com.box.android.data.api;

import com.box.android.data.api.models.CollaborationDTO;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemCollaborationsDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/box/android/data/api/ItemCollaborationsDTO;", "", "entries", "", "Lcom/box/android/data/api/models/CollaborationDTO;", "<init>", "(Ljava/util/List;)V", "getEntries", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ItemCollaborationsDTO {
    private final List<CollaborationDTO> entries;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ItemCollaborationsDTO copy$default(ItemCollaborationsDTO itemCollaborationsDTO, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = itemCollaborationsDTO.entries;
        }
        return itemCollaborationsDTO.copy(list);
    }

    public final List<CollaborationDTO> component1() {
        return this.entries;
    }

    public final ItemCollaborationsDTO copy(@Json(name = "entries") List<CollaborationDTO> entries) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        return new ItemCollaborationsDTO(entries);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ItemCollaborationsDTO) && Intrinsics.areEqual(this.entries, ((ItemCollaborationsDTO) other).entries);
    }

    public int hashCode() {
        return this.entries.hashCode();
    }

    public String toString() {
        return "ItemCollaborationsDTO(entries=" + this.entries + ")";
    }

    public ItemCollaborationsDTO(@Json(name = "entries") List<CollaborationDTO> entries) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        this.entries = entries;
    }

    public final List<CollaborationDTO> getEntries() {
        return this.entries;
    }
}
