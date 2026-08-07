package com.geniusscansdk.pdf;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;

/* JADX INFO: compiled from: PDFDocument.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\fJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/geniusscansdk/pdf/PDFSize;", "", "width", "", "height", "<init>", "(DD)V", "getWidth", "()D", "getHeight", "toJNI", "Lcom/geniusscansdk/pdf/JNIPDFSize;", "toJNI$gssdk_release", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class PDFSize {
    private final double height;
    private final double width;

    public static /* synthetic */ PDFSize copy$default(PDFSize pDFSize, double d, double d2, int i, Object obj) {
        if ((i & 1) != 0) {
            d = pDFSize.width;
        }
        if ((i & 2) != 0) {
            d2 = pDFSize.height;
        }
        return pDFSize.copy(d, d2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final double getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final double getHeight() {
        return this.height;
    }

    public final PDFSize copy(double width, double height) {
        return new PDFSize(width, height);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PDFSize)) {
            return false;
        }
        PDFSize pDFSize = (PDFSize) other;
        return Double.compare(this.width, pDFSize.width) == 0 && Double.compare(this.height, pDFSize.height) == 0;
    }

    public int hashCode() {
        return (Double.hashCode(this.width) * 31) + Double.hashCode(this.height);
    }

    public String toString() {
        return "PDFSize(width=" + this.width + ", height=" + this.height + ")";
    }

    public PDFSize(double d, double d2) {
        this.width = d;
        this.height = d2;
    }

    public final double getHeight() {
        return this.height;
    }

    public final double getWidth() {
        return this.width;
    }

    public final JNIPDFSize toJNI$gssdk_release() {
        return new JNIPDFSize(this.width, this.height);
    }
}
