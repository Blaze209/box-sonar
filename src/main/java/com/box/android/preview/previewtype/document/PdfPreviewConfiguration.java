package com.box.android.preview.previewtype.document;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.pspdfkit.configuration.page.PageFitMode;
import com.pspdfkit.configuration.page.PageScrollDirection;
import com.pspdfkit.configuration.page.PageScrollMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PdfPreviewConfiguration.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\r¨\u0006 "}, d2 = {"Lcom/box/android/preview/previewtype/document/PdfPreviewConfiguration;", "", "isMobileCopyPasteEnabled", "", "pageFitMode", "Lcom/pspdfkit/configuration/page/PageFitMode;", "pageScrollDirection", "Lcom/pspdfkit/configuration/page/PageScrollDirection;", "pageScrollMode", "Lcom/pspdfkit/configuration/page/PageScrollMode;", "isScrollEnabled", "<init>", "(ZLcom/pspdfkit/configuration/page/PageFitMode;Lcom/pspdfkit/configuration/page/PageScrollDirection;Lcom/pspdfkit/configuration/page/PageScrollMode;Z)V", "()Z", "getPageFitMode", "()Lcom/pspdfkit/configuration/page/PageFitMode;", "getPageScrollDirection", "()Lcom/pspdfkit/configuration/page/PageScrollDirection;", "getPageScrollMode", "()Lcom/pspdfkit/configuration/page/PageScrollMode;", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class PdfPreviewConfiguration {
    public static final int $stable = 0;
    private final boolean isMobileCopyPasteEnabled;
    private final boolean isScrollEnabled;
    private final PageFitMode pageFitMode;
    private final PageScrollDirection pageScrollDirection;
    private final PageScrollMode pageScrollMode;

    public PdfPreviewConfiguration() {
        this(false, null, null, null, false, 31, null);
    }

    public static /* synthetic */ PdfPreviewConfiguration copy$default(PdfPreviewConfiguration pdfPreviewConfiguration, boolean z, PageFitMode pageFitMode, PageScrollDirection pageScrollDirection, PageScrollMode pageScrollMode, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = pdfPreviewConfiguration.isMobileCopyPasteEnabled;
        }
        if ((i & 2) != 0) {
            pageFitMode = pdfPreviewConfiguration.pageFitMode;
        }
        if ((i & 4) != 0) {
            pageScrollDirection = pdfPreviewConfiguration.pageScrollDirection;
        }
        if ((i & 8) != 0) {
            pageScrollMode = pdfPreviewConfiguration.pageScrollMode;
        }
        if ((i & 16) != 0) {
            z2 = pdfPreviewConfiguration.isScrollEnabled;
        }
        boolean z3 = z2;
        PageScrollDirection pageScrollDirection2 = pageScrollDirection;
        return pdfPreviewConfiguration.copy(z, pageFitMode, pageScrollDirection2, pageScrollMode, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsMobileCopyPasteEnabled() {
        return this.isMobileCopyPasteEnabled;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final PageFitMode getPageFitMode() {
        return this.pageFitMode;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final PageScrollDirection getPageScrollDirection() {
        return this.pageScrollDirection;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final PageScrollMode getPageScrollMode() {
        return this.pageScrollMode;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsScrollEnabled() {
        return this.isScrollEnabled;
    }

    public final PdfPreviewConfiguration copy(boolean isMobileCopyPasteEnabled, PageFitMode pageFitMode, PageScrollDirection pageScrollDirection, PageScrollMode pageScrollMode, boolean isScrollEnabled) {
        Intrinsics.checkNotNullParameter(pageFitMode, "pageFitMode");
        Intrinsics.checkNotNullParameter(pageScrollDirection, "pageScrollDirection");
        Intrinsics.checkNotNullParameter(pageScrollMode, "pageScrollMode");
        return new PdfPreviewConfiguration(isMobileCopyPasteEnabled, pageFitMode, pageScrollDirection, pageScrollMode, isScrollEnabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PdfPreviewConfiguration)) {
            return false;
        }
        PdfPreviewConfiguration pdfPreviewConfiguration = (PdfPreviewConfiguration) other;
        return this.isMobileCopyPasteEnabled == pdfPreviewConfiguration.isMobileCopyPasteEnabled && this.pageFitMode == pdfPreviewConfiguration.pageFitMode && this.pageScrollDirection == pdfPreviewConfiguration.pageScrollDirection && this.pageScrollMode == pdfPreviewConfiguration.pageScrollMode && this.isScrollEnabled == pdfPreviewConfiguration.isScrollEnabled;
    }

    public int hashCode() {
        return (((((((Boolean.hashCode(this.isMobileCopyPasteEnabled) * 31) + this.pageFitMode.hashCode()) * 31) + this.pageScrollDirection.hashCode()) * 31) + this.pageScrollMode.hashCode()) * 31) + Boolean.hashCode(this.isScrollEnabled);
    }

    public String toString() {
        return "PdfPreviewConfiguration(isMobileCopyPasteEnabled=" + this.isMobileCopyPasteEnabled + ", pageFitMode=" + this.pageFitMode + ", pageScrollDirection=" + this.pageScrollDirection + ", pageScrollMode=" + this.pageScrollMode + ", isScrollEnabled=" + this.isScrollEnabled + ")";
    }

    public PdfPreviewConfiguration(boolean z, PageFitMode pageFitMode, PageScrollDirection pageScrollDirection, PageScrollMode pageScrollMode, boolean z2) {
        Intrinsics.checkNotNullParameter(pageFitMode, "pageFitMode");
        Intrinsics.checkNotNullParameter(pageScrollDirection, "pageScrollDirection");
        Intrinsics.checkNotNullParameter(pageScrollMode, "pageScrollMode");
        this.isMobileCopyPasteEnabled = z;
        this.pageFitMode = pageFitMode;
        this.pageScrollDirection = pageScrollDirection;
        this.pageScrollMode = pageScrollMode;
        this.isScrollEnabled = z2;
    }

    public final boolean isMobileCopyPasteEnabled() {
        return this.isMobileCopyPasteEnabled;
    }

    public /* synthetic */ PdfPreviewConfiguration(boolean z, PageFitMode pageFitMode, PageScrollDirection pageScrollDirection, PageScrollMode pageScrollMode, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? PageFitMode.FIT_TO_WIDTH : pageFitMode, (i & 4) != 0 ? PageScrollDirection.VERTICAL : pageScrollDirection, (i & 8) != 0 ? PageScrollMode.PER_PAGE : pageScrollMode, (i & 16) != 0 ? true : z2);
    }

    public final PageFitMode getPageFitMode() {
        return this.pageFitMode;
    }

    public final PageScrollDirection getPageScrollDirection() {
        return this.pageScrollDirection;
    }

    public final PageScrollMode getPageScrollMode() {
        return this.pageScrollMode;
    }

    public final boolean isScrollEnabled() {
        return this.isScrollEnabled;
    }
}
