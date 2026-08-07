package com.box.android.data.api.models.upload;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.androidsdk.content.models.BoxOrder;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ChunkedFileUploadDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/data/api/models/upload/FileChunkOrder;", "", BoxOrder.FIELD_BY, "", "direction", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getBy", "()Ljava/lang/String;", "getDirection", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class FileChunkOrder {
    private final String by;
    private final String direction;

    public static /* synthetic */ FileChunkOrder copy$default(FileChunkOrder fileChunkOrder, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fileChunkOrder.by;
        }
        if ((i & 2) != 0) {
            str2 = fileChunkOrder.direction;
        }
        return fileChunkOrder.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getBy() {
        return this.by;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDirection() {
        return this.direction;
    }

    public final FileChunkOrder copy(@Json(name = BoxOrder.FIELD_BY) String by, @Json(name = "direction") String direction) {
        return new FileChunkOrder(by, direction);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileChunkOrder)) {
            return false;
        }
        FileChunkOrder fileChunkOrder = (FileChunkOrder) other;
        return Intrinsics.areEqual(this.by, fileChunkOrder.by) && Intrinsics.areEqual(this.direction, fileChunkOrder.direction);
    }

    public int hashCode() {
        String str = this.by;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.direction;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "FileChunkOrder(by=" + this.by + ", direction=" + this.direction + ")";
    }

    public FileChunkOrder(@Json(name = BoxOrder.FIELD_BY) String str, @Json(name = "direction") String str2) {
        this.by = str;
        this.direction = str2;
    }

    public final String getBy() {
        return this.by;
    }

    public final String getDirection() {
        return this.direction;
    }
}
