package com.box.android.data.api.models;

import com.box.android.data.api.models.items.mini.FolderMiniDTO;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UpdateItemDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003J9\u0010\u0016\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/box/android/data/api/models/UpdateItemDTO;", "", "parentFolder", "Lcom/box/android/data/api/models/items/mini/FolderMiniDTO;", "newItemName", "", "newDescription", BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, "Lcom/box/android/data/api/models/SharedLinkDTO;", "<init>", "(Lcom/box/android/data/api/models/items/mini/FolderMiniDTO;Ljava/lang/String;Ljava/lang/String;Lcom/box/android/data/api/models/SharedLinkDTO;)V", "getParentFolder", "()Lcom/box/android/data/api/models/items/mini/FolderMiniDTO;", "getNewItemName", "()Ljava/lang/String;", "getNewDescription", "getSharedLink", "()Lcom/box/android/data/api/models/SharedLinkDTO;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class UpdateItemDTO {
    private final String newDescription;
    private final String newItemName;
    private final FolderMiniDTO parentFolder;
    private final SharedLinkDTO sharedLink;

    public UpdateItemDTO() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ UpdateItemDTO copy$default(UpdateItemDTO updateItemDTO, FolderMiniDTO folderMiniDTO, String str, String str2, SharedLinkDTO sharedLinkDTO, int i, Object obj) {
        if ((i & 1) != 0) {
            folderMiniDTO = updateItemDTO.parentFolder;
        }
        if ((i & 2) != 0) {
            str = updateItemDTO.newItemName;
        }
        if ((i & 4) != 0) {
            str2 = updateItemDTO.newDescription;
        }
        if ((i & 8) != 0) {
            sharedLinkDTO = updateItemDTO.sharedLink;
        }
        return updateItemDTO.copy(folderMiniDTO, str, str2, sharedLinkDTO);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final FolderMiniDTO getParentFolder() {
        return this.parentFolder;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getNewItemName() {
        return this.newItemName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getNewDescription() {
        return this.newDescription;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final SharedLinkDTO getSharedLink() {
        return this.sharedLink;
    }

    public final UpdateItemDTO copy(@Json(name = "parent") FolderMiniDTO parentFolder, @Json(name = "name") String newItemName, @Json(name = "description") String newDescription, @Json(name = "shared_link") SharedLinkDTO sharedLink) {
        return new UpdateItemDTO(parentFolder, newItemName, newDescription, sharedLink);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UpdateItemDTO)) {
            return false;
        }
        UpdateItemDTO updateItemDTO = (UpdateItemDTO) other;
        return Intrinsics.areEqual(this.parentFolder, updateItemDTO.parentFolder) && Intrinsics.areEqual(this.newItemName, updateItemDTO.newItemName) && Intrinsics.areEqual(this.newDescription, updateItemDTO.newDescription) && Intrinsics.areEqual(this.sharedLink, updateItemDTO.sharedLink);
    }

    public int hashCode() {
        FolderMiniDTO folderMiniDTO = this.parentFolder;
        int iHashCode = (folderMiniDTO == null ? 0 : folderMiniDTO.hashCode()) * 31;
        String str = this.newItemName;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.newDescription;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        SharedLinkDTO sharedLinkDTO = this.sharedLink;
        return iHashCode3 + (sharedLinkDTO != null ? sharedLinkDTO.hashCode() : 0);
    }

    public String toString() {
        return "UpdateItemDTO(parentFolder=" + this.parentFolder + ", newItemName=" + this.newItemName + ", newDescription=" + this.newDescription + ", sharedLink=" + this.sharedLink + ")";
    }

    public UpdateItemDTO(@Json(name = "parent") FolderMiniDTO folderMiniDTO, @Json(name = "name") String str, @Json(name = "description") String str2, @Json(name = "shared_link") SharedLinkDTO sharedLinkDTO) {
        this.parentFolder = folderMiniDTO;
        this.newItemName = str;
        this.newDescription = str2;
        this.sharedLink = sharedLinkDTO;
    }

    public /* synthetic */ UpdateItemDTO(FolderMiniDTO folderMiniDTO, String str, String str2, SharedLinkDTO sharedLinkDTO, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : folderMiniDTO, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : sharedLinkDTO);
    }

    public final FolderMiniDTO getParentFolder() {
        return this.parentFolder;
    }

    public final String getNewItemName() {
        return this.newItemName;
    }

    public final String getNewDescription() {
        return this.newDescription;
    }

    public final SharedLinkDTO getSharedLink() {
        return this.sharedLink;
    }
}
