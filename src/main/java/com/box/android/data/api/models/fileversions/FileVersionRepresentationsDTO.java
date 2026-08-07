package com.box.android.data.api.models.fileversions;

import com.box.android.data.api.models.RepresentationsDTO;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.androidsdk.content.BoxApiPreview;
import com.box.androidsdk.content.models.BoxFile;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileVersionRepresentationsDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/box/android/data/api/models/fileversions/FileVersionRepresentationsDTO;", "", "id", "", "name", "downloadUrl", BoxFile.FIELD_REPRESENTATIONS, "Lcom/box/android/data/api/models/RepresentationsDTO;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/box/android/data/api/models/RepresentationsDTO;)V", "getId", "()Ljava/lang/String;", "getName", "getDownloadUrl", "getRepresentations", "()Lcom/box/android/data/api/models/RepresentationsDTO;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class FileVersionRepresentationsDTO {
    private final String downloadUrl;
    private final String id;
    private final String name;
    private final RepresentationsDTO representations;

    public static /* synthetic */ FileVersionRepresentationsDTO copy$default(FileVersionRepresentationsDTO fileVersionRepresentationsDTO, String str, String str2, String str3, RepresentationsDTO representationsDTO, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fileVersionRepresentationsDTO.id;
        }
        if ((i & 2) != 0) {
            str2 = fileVersionRepresentationsDTO.name;
        }
        if ((i & 4) != 0) {
            str3 = fileVersionRepresentationsDTO.downloadUrl;
        }
        if ((i & 8) != 0) {
            representationsDTO = fileVersionRepresentationsDTO.representations;
        }
        return fileVersionRepresentationsDTO.copy(str, str2, str3, representationsDTO);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDownloadUrl() {
        return this.downloadUrl;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final RepresentationsDTO getRepresentations() {
        return this.representations;
    }

    public final FileVersionRepresentationsDTO copy(@Json(name = "id") String id, @Json(name = "name") String name, @Json(name = BoxApiPreview.FIELD_AUTHENTICATED_DOWNLOAD_URL) String downloadUrl, @Json(name = BoxFile.FIELD_REPRESENTATIONS) RepresentationsDTO representations) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(downloadUrl, "downloadUrl");
        Intrinsics.checkNotNullParameter(representations, "representations");
        return new FileVersionRepresentationsDTO(id, name, downloadUrl, representations);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileVersionRepresentationsDTO)) {
            return false;
        }
        FileVersionRepresentationsDTO fileVersionRepresentationsDTO = (FileVersionRepresentationsDTO) other;
        return Intrinsics.areEqual(this.id, fileVersionRepresentationsDTO.id) && Intrinsics.areEqual(this.name, fileVersionRepresentationsDTO.name) && Intrinsics.areEqual(this.downloadUrl, fileVersionRepresentationsDTO.downloadUrl) && Intrinsics.areEqual(this.representations, fileVersionRepresentationsDTO.representations);
    }

    public int hashCode() {
        return (((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.downloadUrl.hashCode()) * 31) + this.representations.hashCode();
    }

    public String toString() {
        return "FileVersionRepresentationsDTO(id=" + this.id + ", name=" + this.name + ", downloadUrl=" + this.downloadUrl + ", representations=" + this.representations + ")";
    }

    public FileVersionRepresentationsDTO(@Json(name = "id") String id, @Json(name = "name") String name, @Json(name = BoxApiPreview.FIELD_AUTHENTICATED_DOWNLOAD_URL) String downloadUrl, @Json(name = BoxFile.FIELD_REPRESENTATIONS) RepresentationsDTO representations) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(downloadUrl, "downloadUrl");
        Intrinsics.checkNotNullParameter(representations, "representations");
        this.id = id;
        this.name = name;
        this.downloadUrl = downloadUrl;
        this.representations = representations;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getDownloadUrl() {
        return this.downloadUrl;
    }

    public final RepresentationsDTO getRepresentations() {
        return this.representations;
    }
}
