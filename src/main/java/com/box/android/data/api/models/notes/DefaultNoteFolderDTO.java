package com.box.android.data.api.models.notes;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DefaultNoteFolderDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/box/android/data/api/models/notes/DefaultNoteFolderDTO;", "", "folderId", "", "<init>", "(Ljava/lang/String;)V", "getFolderId", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class DefaultNoteFolderDTO {
    private final String folderId;

    public static /* synthetic */ DefaultNoteFolderDTO copy$default(DefaultNoteFolderDTO defaultNoteFolderDTO, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = defaultNoteFolderDTO.folderId;
        }
        return defaultNoteFolderDTO.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFolderId() {
        return this.folderId;
    }

    public final DefaultNoteFolderDTO copy(@Json(name = "folderId") String folderId) {
        return new DefaultNoteFolderDTO(folderId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof DefaultNoteFolderDTO) && Intrinsics.areEqual(this.folderId, ((DefaultNoteFolderDTO) other).folderId);
    }

    public int hashCode() {
        String str = this.folderId;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "DefaultNoteFolderDTO(folderId=" + this.folderId + ")";
    }

    public DefaultNoteFolderDTO(@Json(name = "folderId") String str) {
        this.folderId = str;
    }

    public final String getFolderId() {
        return this.folderId;
    }
}
