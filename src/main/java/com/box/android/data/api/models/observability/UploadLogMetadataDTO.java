package com.box.android.data.api.models.observability;

import com.box.android.data.api.models.UserMiniDTO;
import com.box.android.data.api.models.items.FileDTO;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UploadLogSiblingDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/box/android/data/api/models/observability/UploadLogMetadataDTO;", "", "clientLogMetadata", "Lcom/box/android/data/api/models/observability/ClientLogMetadata;", "user", "Lcom/box/android/data/api/models/UserMiniDTO;", "file", "Lcom/box/android/data/api/models/items/FileDTO;", "<init>", "(Lcom/box/android/data/api/models/observability/ClientLogMetadata;Lcom/box/android/data/api/models/UserMiniDTO;Lcom/box/android/data/api/models/items/FileDTO;)V", "getClientLogMetadata", "()Lcom/box/android/data/api/models/observability/ClientLogMetadata;", "getUser", "()Lcom/box/android/data/api/models/UserMiniDTO;", "getFile", "()Lcom/box/android/data/api/models/items/FileDTO;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class UploadLogMetadataDTO {
    private final ClientLogMetadata clientLogMetadata;
    private final FileDTO file;
    private final UserMiniDTO user;

    public static /* synthetic */ UploadLogMetadataDTO copy$default(UploadLogMetadataDTO uploadLogMetadataDTO, ClientLogMetadata clientLogMetadata, UserMiniDTO userMiniDTO, FileDTO fileDTO, int i, Object obj) {
        if ((i & 1) != 0) {
            clientLogMetadata = uploadLogMetadataDTO.clientLogMetadata;
        }
        if ((i & 2) != 0) {
            userMiniDTO = uploadLogMetadataDTO.user;
        }
        if ((i & 4) != 0) {
            fileDTO = uploadLogMetadataDTO.file;
        }
        return uploadLogMetadataDTO.copy(clientLogMetadata, userMiniDTO, fileDTO);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ClientLogMetadata getClientLogMetadata() {
        return this.clientLogMetadata;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final UserMiniDTO getUser() {
        return this.user;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final FileDTO getFile() {
        return this.file;
    }

    public final UploadLogMetadataDTO copy(@Json(name = "client_log_metadata") ClientLogMetadata clientLogMetadata, @Json(name = "user") UserMiniDTO user, @Json(name = "file") FileDTO file) {
        Intrinsics.checkNotNullParameter(clientLogMetadata, "clientLogMetadata");
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(file, "file");
        return new UploadLogMetadataDTO(clientLogMetadata, user, file);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UploadLogMetadataDTO)) {
            return false;
        }
        UploadLogMetadataDTO uploadLogMetadataDTO = (UploadLogMetadataDTO) other;
        return Intrinsics.areEqual(this.clientLogMetadata, uploadLogMetadataDTO.clientLogMetadata) && Intrinsics.areEqual(this.user, uploadLogMetadataDTO.user) && Intrinsics.areEqual(this.file, uploadLogMetadataDTO.file);
    }

    public int hashCode() {
        return (((this.clientLogMetadata.hashCode() * 31) + this.user.hashCode()) * 31) + this.file.hashCode();
    }

    public String toString() {
        return "UploadLogMetadataDTO(clientLogMetadata=" + this.clientLogMetadata + ", user=" + this.user + ", file=" + this.file + ")";
    }

    public UploadLogMetadataDTO(@Json(name = "client_log_metadata") ClientLogMetadata clientLogMetadata, @Json(name = "user") UserMiniDTO user, @Json(name = "file") FileDTO file) {
        Intrinsics.checkNotNullParameter(clientLogMetadata, "clientLogMetadata");
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(file, "file");
        this.clientLogMetadata = clientLogMetadata;
        this.user = user;
        this.file = file;
    }

    public final ClientLogMetadata getClientLogMetadata() {
        return this.clientLogMetadata;
    }

    public final UserMiniDTO getUser() {
        return this.user;
    }

    public final FileDTO getFile() {
        return this.file;
    }
}
