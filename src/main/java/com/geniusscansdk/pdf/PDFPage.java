package com.geniusscansdk.pdf;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.geniusscansdk.core.TextLayout;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PDFDocument.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0012J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/geniusscansdk/pdf/PDFPage;", "", "imageFile", "Ljava/io/File;", "inchesSize", "Lcom/geniusscansdk/pdf/PDFSize;", "textLayout", "Lcom/geniusscansdk/core/TextLayout;", "<init>", "(Ljava/io/File;Lcom/geniusscansdk/pdf/PDFSize;Lcom/geniusscansdk/core/TextLayout;)V", "getImageFile", "()Ljava/io/File;", "getInchesSize", "()Lcom/geniusscansdk/pdf/PDFSize;", "getTextLayout", "()Lcom/geniusscansdk/core/TextLayout;", "toJNI", "Lcom/geniusscansdk/pdf/JNIPDFPage;", "toJNI$gssdk_release", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class PDFPage {
    private final File imageFile;
    private final PDFSize inchesSize;
    private final TextLayout textLayout;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PDFPage(File imageFile, PDFSize inchesSize) {
        this(imageFile, inchesSize, null, 4, null);
        Intrinsics.checkNotNullParameter(imageFile, "imageFile");
        Intrinsics.checkNotNullParameter(inchesSize, "inchesSize");
    }

    public static /* synthetic */ PDFPage copy$default(PDFPage pDFPage, File file, PDFSize pDFSize, TextLayout textLayout, int i, Object obj) {
        if ((i & 1) != 0) {
            file = pDFPage.imageFile;
        }
        if ((i & 2) != 0) {
            pDFSize = pDFPage.inchesSize;
        }
        if ((i & 4) != 0) {
            textLayout = pDFPage.textLayout;
        }
        return pDFPage.copy(file, pDFSize, textLayout);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final File getImageFile() {
        return this.imageFile;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final PDFSize getInchesSize() {
        return this.inchesSize;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final TextLayout getTextLayout() {
        return this.textLayout;
    }

    public final PDFPage copy(File imageFile, PDFSize inchesSize, TextLayout textLayout) {
        Intrinsics.checkNotNullParameter(imageFile, "imageFile");
        Intrinsics.checkNotNullParameter(inchesSize, "inchesSize");
        return new PDFPage(imageFile, inchesSize, textLayout);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PDFPage)) {
            return false;
        }
        PDFPage pDFPage = (PDFPage) other;
        return Intrinsics.areEqual(this.imageFile, pDFPage.imageFile) && Intrinsics.areEqual(this.inchesSize, pDFPage.inchesSize) && Intrinsics.areEqual(this.textLayout, pDFPage.textLayout);
    }

    public int hashCode() {
        int iHashCode = ((this.imageFile.hashCode() * 31) + this.inchesSize.hashCode()) * 31;
        TextLayout textLayout = this.textLayout;
        return iHashCode + (textLayout == null ? 0 : textLayout.hashCode());
    }

    public String toString() {
        return "PDFPage(imageFile=" + this.imageFile + ", inchesSize=" + this.inchesSize + ", textLayout=" + this.textLayout + ")";
    }

    public PDFPage(File imageFile, PDFSize inchesSize, TextLayout textLayout) {
        Intrinsics.checkNotNullParameter(imageFile, "imageFile");
        Intrinsics.checkNotNullParameter(inchesSize, "inchesSize");
        this.imageFile = imageFile;
        this.inchesSize = inchesSize;
        this.textLayout = textLayout;
    }

    public /* synthetic */ PDFPage(File file, PDFSize pDFSize, TextLayout textLayout, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, pDFSize, (i & 4) != 0 ? null : textLayout);
    }

    public final File getImageFile() {
        return this.imageFile;
    }

    public final PDFSize getInchesSize() {
        return this.inchesSize;
    }

    public final TextLayout getTextLayout() {
        return this.textLayout;
    }

    public final JNIPDFPage toJNI$gssdk_release() {
        String path = this.imageFile.getPath();
        JNIPDFSize jNI$gssdk_release = this.inchesSize.toJNI$gssdk_release();
        TextLayout textLayout = this.textLayout;
        return new JNIPDFPage(path, null, jNI$gssdk_release, textLayout != null ? textLayout.toJNI$gssdk_release() : null);
    }
}
