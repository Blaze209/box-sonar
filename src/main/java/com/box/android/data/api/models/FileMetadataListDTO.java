package com.box.android.data.api.models;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.androidsdk.content.models.BoxIterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileMetadataListDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\fJ*\u0010\u0010\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/box/android/data/api/models/FileMetadataListDTO;", "", "entries", "", "Lcom/box/android/data/api/models/FileMetadataInstanceDTO;", BoxIterator.FIELD_LIMIT, "", "<init>", "(Ljava/util/List;Ljava/lang/Integer;)V", "getEntries", "()Ljava/util/List;", "getLimit", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/util/List;Ljava/lang/Integer;)Lcom/box/android/data/api/models/FileMetadataListDTO;", "equals", "", "other", "hashCode", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class FileMetadataListDTO {
    private final List<FileMetadataInstanceDTO> entries;
    private final Integer limit;

    /* JADX WARN: Multi-variable type inference failed */
    public FileMetadataListDTO() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FileMetadataListDTO copy$default(FileMetadataListDTO fileMetadataListDTO, List list, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            list = fileMetadataListDTO.entries;
        }
        if ((i & 2) != 0) {
            num = fileMetadataListDTO.limit;
        }
        return fileMetadataListDTO.copy(list, num);
    }

    public final List<FileMetadataInstanceDTO> component1() {
        return this.entries;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getLimit() {
        return this.limit;
    }

    public final FileMetadataListDTO copy(List<FileMetadataInstanceDTO> entries, Integer limit) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        return new FileMetadataListDTO(entries, limit);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileMetadataListDTO)) {
            return false;
        }
        FileMetadataListDTO fileMetadataListDTO = (FileMetadataListDTO) other;
        return Intrinsics.areEqual(this.entries, fileMetadataListDTO.entries) && Intrinsics.areEqual(this.limit, fileMetadataListDTO.limit);
    }

    public int hashCode() {
        int iHashCode = this.entries.hashCode() * 31;
        Integer num = this.limit;
        return iHashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "FileMetadataListDTO(entries=" + this.entries + ", limit=" + this.limit + ")";
    }

    public FileMetadataListDTO(List<FileMetadataInstanceDTO> entries, Integer num) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        this.entries = entries;
        this.limit = num;
    }

    public /* synthetic */ FileMetadataListDTO(List list, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? null : num);
    }

    public final List<FileMetadataInstanceDTO> getEntries() {
        return this.entries;
    }

    public final Integer getLimit() {
        return this.limit;
    }
}
