package com.box.android.data.api.models;

import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.data.api.models.items.mini.FolderMiniDTO;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CreateFolderDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/box/android/data/api/models/CreateFolderDTO;", "", BoxCommonConstants.EXTRA_FOLDER_NAME, "", "parentFolder", "Lcom/box/android/data/api/models/items/mini/FolderMiniDTO;", "<init>", "(Ljava/lang/String;Lcom/box/android/data/api/models/items/mini/FolderMiniDTO;)V", "getFolderName", "()Ljava/lang/String;", "getParentFolder", "()Lcom/box/android/data/api/models/items/mini/FolderMiniDTO;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CreateFolderDTO {
    private final String folderName;
    private final FolderMiniDTO parentFolder;

    public static /* synthetic */ CreateFolderDTO copy$default(CreateFolderDTO createFolderDTO, String str, FolderMiniDTO folderMiniDTO, int i, Object obj) {
        if ((i & 1) != 0) {
            str = createFolderDTO.folderName;
        }
        if ((i & 2) != 0) {
            folderMiniDTO = createFolderDTO.parentFolder;
        }
        return createFolderDTO.copy(str, folderMiniDTO);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFolderName() {
        return this.folderName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final FolderMiniDTO getParentFolder() {
        return this.parentFolder;
    }

    public final CreateFolderDTO copy(@Json(name = "name") String folderName, @Json(name = "parent") FolderMiniDTO parentFolder) {
        Intrinsics.checkNotNullParameter(folderName, "folderName");
        Intrinsics.checkNotNullParameter(parentFolder, "parentFolder");
        return new CreateFolderDTO(folderName, parentFolder);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreateFolderDTO)) {
            return false;
        }
        CreateFolderDTO createFolderDTO = (CreateFolderDTO) other;
        return Intrinsics.areEqual(this.folderName, createFolderDTO.folderName) && Intrinsics.areEqual(this.parentFolder, createFolderDTO.parentFolder);
    }

    public int hashCode() {
        return (this.folderName.hashCode() * 31) + this.parentFolder.hashCode();
    }

    public String toString() {
        return "CreateFolderDTO(folderName=" + this.folderName + ", parentFolder=" + this.parentFolder + ")";
    }

    public CreateFolderDTO(@Json(name = "name") String folderName, @Json(name = "parent") FolderMiniDTO parentFolder) {
        Intrinsics.checkNotNullParameter(folderName, "folderName");
        Intrinsics.checkNotNullParameter(parentFolder, "parentFolder");
        this.folderName = folderName;
        this.parentFolder = parentFolder;
    }

    public final String getFolderName() {
        return this.folderName;
    }

    public final FolderMiniDTO getParentFolder() {
        return this.parentFolder;
    }
}
