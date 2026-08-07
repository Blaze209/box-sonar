package com.box.android.coreservices.models;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.preview.PreviewContentType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviewFile.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/box/android/coreservices/models/PreviewFileAttributes;", "", "previewFileOrigin", "Lcom/box/android/domain/preview/PreviewContentType;", "fileVersionId", "", "<init>", "(Lcom/box/android/domain/preview/PreviewContentType;Ljava/lang/String;)V", "getPreviewFileOrigin", "()Lcom/box/android/domain/preview/PreviewContentType;", "getFileVersionId", "()Ljava/lang/String;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "coreservices_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class PreviewFileAttributes {
    private final String fileVersionId;
    private final PreviewContentType previewFileOrigin;

    public static /* synthetic */ PreviewFileAttributes copy$default(PreviewFileAttributes previewFileAttributes, PreviewContentType previewContentType, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            previewContentType = previewFileAttributes.previewFileOrigin;
        }
        if ((i & 2) != 0) {
            str = previewFileAttributes.fileVersionId;
        }
        return previewFileAttributes.copy(previewContentType, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final PreviewContentType getPreviewFileOrigin() {
        return this.previewFileOrigin;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFileVersionId() {
        return this.fileVersionId;
    }

    public final PreviewFileAttributes copy(PreviewContentType previewFileOrigin, String fileVersionId) {
        return new PreviewFileAttributes(previewFileOrigin, fileVersionId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PreviewFileAttributes)) {
            return false;
        }
        PreviewFileAttributes previewFileAttributes = (PreviewFileAttributes) other;
        return Intrinsics.areEqual(this.previewFileOrigin, previewFileAttributes.previewFileOrigin) && Intrinsics.areEqual(this.fileVersionId, previewFileAttributes.fileVersionId);
    }

    public int hashCode() {
        PreviewContentType previewContentType = this.previewFileOrigin;
        int iHashCode = (previewContentType == null ? 0 : previewContentType.hashCode()) * 31;
        String str = this.fileVersionId;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "PreviewFileAttributes(previewFileOrigin=" + this.previewFileOrigin + ", fileVersionId=" + this.fileVersionId + ")";
    }

    public PreviewFileAttributes(PreviewContentType previewContentType, String str) {
        this.previewFileOrigin = previewContentType;
        this.fileVersionId = str;
    }

    public /* synthetic */ PreviewFileAttributes(PreviewContentType previewContentType, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(previewContentType, (i & 2) != 0 ? null : str);
    }

    public final String getFileVersionId() {
        return this.fileVersionId;
    }

    public final PreviewContentType getPreviewFileOrigin() {
        return this.previewFileOrigin;
    }
}
