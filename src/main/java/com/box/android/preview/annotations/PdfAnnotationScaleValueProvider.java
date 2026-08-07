package com.box.android.preview.annotations;

import com.box.android.data.datasource.hubs.HubAssetRemoteDataSource;
import com.pspdfkit.document.PdfDocument;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: PdfAnnotationScaleValueProvider.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/box/android/preview/annotations/PdfAnnotationScaleValueProvider;", "", "<init>", "()V", "pdfDocument", "Lcom/pspdfkit/document/PdfDocument;", "getPdfDocument", "()Lcom/pspdfkit/document/PdfDocument;", "setPdfDocument", "(Lcom/pspdfkit/document/PdfDocument;)V", "getWidthScalingFactorForPage", "", "pageIndex", "", "(I)Ljava/lang/Float;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PdfAnnotationScaleValueProvider {
    public static final int $stable = 8;
    public PdfDocument pdfDocument;

    @Inject
    public PdfAnnotationScaleValueProvider() {
    }

    public final PdfDocument getPdfDocument() {
        PdfDocument pdfDocument = this.pdfDocument;
        if (pdfDocument != null) {
            return pdfDocument;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pdfDocument");
        return null;
    }

    public final void setPdfDocument(PdfDocument pdfDocument) {
        Intrinsics.checkNotNullParameter(pdfDocument, "<set-?>");
        this.pdfDocument = pdfDocument;
    }

    public final Float getWidthScalingFactorForPage(int pageIndex) {
        if (this.pdfDocument == null) {
            return null;
        }
        return Float.valueOf(RangesKt.coerceAtLeast(getPdfDocument().getPageSize(pageIndex).height, getPdfDocument().getPageSize(pageIndex).width) / HubAssetRemoteDataSource.HUB_BANNER_SCALED_SIZE);
    }
}
