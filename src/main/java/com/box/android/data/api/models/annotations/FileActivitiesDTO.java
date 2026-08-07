package com.box.android.data.api.models.annotations;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.androidsdk.content.models.BoxIterator;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileActivitiesDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0010\b\u0001\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\nHÆ\u0003JA\u0010\u0018\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0010\b\u0003\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\b\b\u0003\u0010\u0007\u001a\u00020\b2\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\bHÖ\u0001J\t\u0010\u001d\u001a\u00020\nHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/box/android/data/api/models/annotations/FileActivitiesDTO;", "", "entries", "", "Lcom/box/android/data/api/models/annotations/FileActivityDTO;", BoxAnalyticsParams.CATEGORY_ERRORS, "Lcom/box/android/data/api/models/annotations/FileActivityFetchErrorDTO;", BoxIterator.FIELD_LIMIT, "", "nextMarker", "", "<init>", "(Ljava/util/List;Ljava/util/List;ILjava/lang/String;)V", "getEntries", "()Ljava/util/List;", "getErrors", "getLimit", "()I", "getNextMarker", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class FileActivitiesDTO {
    private final List<FileActivityDTO> entries;
    private final List<FileActivityFetchErrorDTO> errors;
    private final int limit;
    private final String nextMarker;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FileActivitiesDTO copy$default(FileActivitiesDTO fileActivitiesDTO, List list, List list2, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = fileActivitiesDTO.entries;
        }
        if ((i2 & 2) != 0) {
            list2 = fileActivitiesDTO.errors;
        }
        if ((i2 & 4) != 0) {
            i = fileActivitiesDTO.limit;
        }
        if ((i2 & 8) != 0) {
            str = fileActivitiesDTO.nextMarker;
        }
        return fileActivitiesDTO.copy(list, list2, i, str);
    }

    public final List<FileActivityDTO> component1() {
        return this.entries;
    }

    public final List<FileActivityFetchErrorDTO> component2() {
        return this.errors;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getLimit() {
        return this.limit;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getNextMarker() {
        return this.nextMarker;
    }

    public final FileActivitiesDTO copy(@Json(name = "entries") List<? extends FileActivityDTO> entries, @Json(name = BoxAnalyticsParams.CATEGORY_ERRORS) List<FileActivityFetchErrorDTO> errors, @Json(name = BoxIterator.FIELD_LIMIT) int limit, @Json(name = BoxIterator.FIELD_NEXT_MARKER) String nextMarker) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        return new FileActivitiesDTO(entries, errors, limit, nextMarker);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileActivitiesDTO)) {
            return false;
        }
        FileActivitiesDTO fileActivitiesDTO = (FileActivitiesDTO) other;
        return Intrinsics.areEqual(this.entries, fileActivitiesDTO.entries) && Intrinsics.areEqual(this.errors, fileActivitiesDTO.errors) && this.limit == fileActivitiesDTO.limit && Intrinsics.areEqual(this.nextMarker, fileActivitiesDTO.nextMarker);
    }

    public int hashCode() {
        int iHashCode = this.entries.hashCode() * 31;
        List<FileActivityFetchErrorDTO> list = this.errors;
        int iHashCode2 = (((iHashCode + (list == null ? 0 : list.hashCode())) * 31) + Integer.hashCode(this.limit)) * 31;
        String str = this.nextMarker;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "FileActivitiesDTO(entries=" + this.entries + ", errors=" + this.errors + ", limit=" + this.limit + ", nextMarker=" + this.nextMarker + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FileActivitiesDTO(@Json(name = "entries") List<? extends FileActivityDTO> entries, @Json(name = BoxAnalyticsParams.CATEGORY_ERRORS) List<FileActivityFetchErrorDTO> list, @Json(name = BoxIterator.FIELD_LIMIT) int i, @Json(name = BoxIterator.FIELD_NEXT_MARKER) String str) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        this.entries = entries;
        this.errors = list;
        this.limit = i;
        this.nextMarker = str;
    }

    public final List<FileActivityDTO> getEntries() {
        return this.entries;
    }

    public final List<FileActivityFetchErrorDTO> getErrors() {
        return this.errors;
    }

    public final int getLimit() {
        return this.limit;
    }

    public final String getNextMarker() {
        return this.nextMarker;
    }
}
