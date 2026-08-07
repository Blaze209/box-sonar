package com.box.android.preview.annotations.model;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;

/* JADX INFO: compiled from: DocumentSize.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/box/android/preview/annotations/model/DocumentSize;", "", "width", "", "height", "<init>", "(FF)V", "getWidth", "()F", "getHeight", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class DocumentSize {
    public static final int $stable = 0;
    private final float height;
    private final float width;

    public static /* synthetic */ DocumentSize copy$default(DocumentSize documentSize, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = documentSize.width;
        }
        if ((i & 2) != 0) {
            f2 = documentSize.height;
        }
        return documentSize.copy(f, f2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getHeight() {
        return this.height;
    }

    public final DocumentSize copy(float width, float height) {
        return new DocumentSize(width, height);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DocumentSize)) {
            return false;
        }
        DocumentSize documentSize = (DocumentSize) other;
        return Float.compare(this.width, documentSize.width) == 0 && Float.compare(this.height, documentSize.height) == 0;
    }

    public int hashCode() {
        return (Float.hashCode(this.width) * 31) + Float.hashCode(this.height);
    }

    public String toString() {
        return "DocumentSize(width=" + this.width + ", height=" + this.height + ")";
    }

    public DocumentSize(float f, float f2) {
        this.width = f;
        this.height = f2;
    }

    public final float getHeight() {
        return this.height;
    }

    public final float getWidth() {
        return this.width;
    }
}
