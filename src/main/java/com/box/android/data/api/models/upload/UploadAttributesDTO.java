package com.box.android.data.api.models.upload;

import com.box.android.data.api.models.items.mini.FolderIdDTO;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UploadAttributesDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/box/android/data/api/models/upload/UploadAttributesDTO;", "", "contentCreatedAt", "", "contentModifiedAt", "name", "parent", "Lcom/box/android/data/api/models/items/mini/FolderIdDTO;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/box/android/data/api/models/items/mini/FolderIdDTO;)V", "getContentCreatedAt", "()Ljava/lang/String;", "getContentModifiedAt", "getName", "getParent", "()Lcom/box/android/data/api/models/items/mini/FolderIdDTO;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class UploadAttributesDTO {
    private final String contentCreatedAt;
    private final String contentModifiedAt;
    private final String name;
    private final FolderIdDTO parent;

    public static /* synthetic */ UploadAttributesDTO copy$default(UploadAttributesDTO uploadAttributesDTO, String str, String str2, String str3, FolderIdDTO folderIdDTO, int i, Object obj) {
        if ((i & 1) != 0) {
            str = uploadAttributesDTO.contentCreatedAt;
        }
        if ((i & 2) != 0) {
            str2 = uploadAttributesDTO.contentModifiedAt;
        }
        if ((i & 4) != 0) {
            str3 = uploadAttributesDTO.name;
        }
        if ((i & 8) != 0) {
            folderIdDTO = uploadAttributesDTO.parent;
        }
        return uploadAttributesDTO.copy(str, str2, str3, folderIdDTO);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getContentCreatedAt() {
        return this.contentCreatedAt;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getContentModifiedAt() {
        return this.contentModifiedAt;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final FolderIdDTO getParent() {
        return this.parent;
    }

    public final UploadAttributesDTO copy(@Json(name = "content_created_at") String contentCreatedAt, @Json(name = "content_modified_at") String contentModifiedAt, @Json(name = "name") String name, @Json(name = "parent") FolderIdDTO parent) {
        Intrinsics.checkNotNullParameter(contentCreatedAt, "contentCreatedAt");
        Intrinsics.checkNotNullParameter(contentModifiedAt, "contentModifiedAt");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(parent, "parent");
        return new UploadAttributesDTO(contentCreatedAt, contentModifiedAt, name, parent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UploadAttributesDTO)) {
            return false;
        }
        UploadAttributesDTO uploadAttributesDTO = (UploadAttributesDTO) other;
        return Intrinsics.areEqual(this.contentCreatedAt, uploadAttributesDTO.contentCreatedAt) && Intrinsics.areEqual(this.contentModifiedAt, uploadAttributesDTO.contentModifiedAt) && Intrinsics.areEqual(this.name, uploadAttributesDTO.name) && Intrinsics.areEqual(this.parent, uploadAttributesDTO.parent);
    }

    public int hashCode() {
        return (((((this.contentCreatedAt.hashCode() * 31) + this.contentModifiedAt.hashCode()) * 31) + this.name.hashCode()) * 31) + this.parent.hashCode();
    }

    public String toString() {
        return "UploadAttributesDTO(contentCreatedAt=" + this.contentCreatedAt + ", contentModifiedAt=" + this.contentModifiedAt + ", name=" + this.name + ", parent=" + this.parent + ")";
    }

    public UploadAttributesDTO(@Json(name = "content_created_at") String contentCreatedAt, @Json(name = "content_modified_at") String contentModifiedAt, @Json(name = "name") String name, @Json(name = "parent") FolderIdDTO parent) {
        Intrinsics.checkNotNullParameter(contentCreatedAt, "contentCreatedAt");
        Intrinsics.checkNotNullParameter(contentModifiedAt, "contentModifiedAt");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(parent, "parent");
        this.contentCreatedAt = contentCreatedAt;
        this.contentModifiedAt = contentModifiedAt;
        this.name = name;
        this.parent = parent;
    }

    public final String getContentCreatedAt() {
        return this.contentCreatedAt;
    }

    public final String getContentModifiedAt() {
        return this.contentModifiedAt;
    }

    public final String getName() {
        return this.name;
    }

    public final FolderIdDTO getParent() {
        return this.parent;
    }
}
