package com.box.android.data.api.models;

import com.box.android.data.api.models.items.mini.FolderIdDTO;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.events.IdentificationData;

/* JADX INFO: compiled from: PreflightCheckDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/box/android/data/api/models/PreflightCheckDTO;", "", "name", "", IdentificationData.FIELD_PARENT_ID, "Lcom/box/android/data/api/models/items/mini/FolderIdDTO;", "size", "", "<init>", "(Ljava/lang/String;Lcom/box/android/data/api/models/items/mini/FolderIdDTO;J)V", "getName", "()Ljava/lang/String;", "getParentId", "()Lcom/box/android/data/api/models/items/mini/FolderIdDTO;", "getSize", "()J", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class PreflightCheckDTO {
    private final String name;
    private final FolderIdDTO parentId;
    private final long size;

    public static /* synthetic */ PreflightCheckDTO copy$default(PreflightCheckDTO preflightCheckDTO, String str, FolderIdDTO folderIdDTO, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = preflightCheckDTO.name;
        }
        if ((i & 2) != 0) {
            folderIdDTO = preflightCheckDTO.parentId;
        }
        if ((i & 4) != 0) {
            j = preflightCheckDTO.size;
        }
        return preflightCheckDTO.copy(str, folderIdDTO, j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final FolderIdDTO getParentId() {
        return this.parentId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getSize() {
        return this.size;
    }

    public final PreflightCheckDTO copy(@Json(name = "name") String name, @Json(name = "parent") FolderIdDTO parentId, @Json(name = "size") long size) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(parentId, "parentId");
        return new PreflightCheckDTO(name, parentId, size);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PreflightCheckDTO)) {
            return false;
        }
        PreflightCheckDTO preflightCheckDTO = (PreflightCheckDTO) other;
        return Intrinsics.areEqual(this.name, preflightCheckDTO.name) && Intrinsics.areEqual(this.parentId, preflightCheckDTO.parentId) && this.size == preflightCheckDTO.size;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.parentId.hashCode()) * 31) + Long.hashCode(this.size);
    }

    public String toString() {
        return "PreflightCheckDTO(name=" + this.name + ", parentId=" + this.parentId + ", size=" + this.size + ")";
    }

    public PreflightCheckDTO(@Json(name = "name") String name, @Json(name = "parent") FolderIdDTO parentId, @Json(name = "size") long j) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(parentId, "parentId");
        this.name = name;
        this.parentId = parentId;
        this.size = j;
    }

    public final String getName() {
        return this.name;
    }

    public final FolderIdDTO getParentId() {
        return this.parentId;
    }

    public final long getSize() {
        return this.size;
    }
}
