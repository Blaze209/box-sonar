package com.pspdfkit.ui.thumbnail;

import androidx.core.view.ViewCompat;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.configuration.rendering.PageRenderConfiguration;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.internal.lv;
import com.pspdfkit.internal.mv;
import com.pspdfkit.internal.nd;
import com.pspdfkit.ui.drawable.PdfDrawableProvider;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b;\b\u0087\b\u0018\u0000 ]2\u00020\u0001:\u0001]B\u0089\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0012\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\t\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0012\u0012\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\t\u0012\b\b\u0003\u0010\u001a\u001a\u00020\u001b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001b0 \u0012\u0014\b\u0002\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020#0\"\u0012\b\b\u0002\u0010$\u001a\u00020\u0012\u0012\b\b\u0002\u0010%\u001a\u00020\u001b¢\u0006\u0004\b&\u0010'J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000f\u0010F\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010I\u001a\u00020\u000eHÆ\u0003J\t\u0010J\u001a\u00020\u0010HÆ\u0003J\t\u0010K\u001a\u00020\u0012HÆ\u0003J\t\u0010L\u001a\u00020\u0012HÆ\u0003J\t\u0010M\u001a\u00020\u0012HÆ\u0003J\u000f\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00160\tHÆ\u0003J\t\u0010O\u001a\u00020\u0012HÆ\u0003J\u000f\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00190\tHÆ\u0003J\t\u0010Q\u001a\u00020\u001bHÆ\u0003J\t\u0010R\u001a\u00020\u0012HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\u000f\u0010T\u001a\b\u0012\u0004\u0012\u00020\u001b0 HÆ\u0003J\u0015\u0010U\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020#0\"HÆ\u0003J\t\u0010V\u001a\u00020\u0012HÆ\u0003J\t\u0010W\u001a\u00020\u001bHÆ\u0003J\u008b\u0002\u0010X\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00122\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\t2\b\b\u0002\u0010\u0017\u001a\u00020\u00122\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\t2\b\b\u0003\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00122\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001b0 2\u0014\b\u0002\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020#0\"2\b\b\u0002\u0010$\u001a\u00020\u00122\b\b\u0002\u0010%\u001a\u00020\u001bHÆ\u0001J\u0014\u0010Y\u001a\u00020\u00122\b\u0010Z\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010[\u001a\u00020\u001bHÖ\u0081\u0004J\n\u0010\\\u001a\u00020\u001eHÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0013\u0010\f\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b2\u00101R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u00107R\u0011\u0010\u0013\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u00107R\u0011\u0010\u0014\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u00107R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\t¢\u0006\b\n\u0000\u001a\u0004\b8\u0010/R\u0011\u0010\u0017\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u00107R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\t¢\u0006\b\n\u0000\u001a\u0004\b9\u0010/R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0011\u0010\u001c\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u00107R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001b0 ¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u001d\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020#0\"¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0011\u0010$\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b$\u00107R\u0011\u0010%\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\bB\u0010;¨\u0006^"}, d2 = {"Lcom/pspdfkit/ui/thumbnail/ThumbnailBarUiState;", "", "document", "Lcom/pspdfkit/document/PdfDocument;", "configuration", "Lcom/pspdfkit/configuration/PdfConfiguration;", "pageRenderConfiguration", "Lcom/pspdfkit/configuration/rendering/PageRenderConfiguration;", "thumbnails", "", "Lcom/pspdfkit/ui/thumbnail/ThumbnailItem;", "selectedPageThumbnail", "selectedSiblingThumbnail", "layoutStyle", "Lcom/pspdfkit/ui/thumbnail/LayoutStyle;", "theme", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarTheme;", "isDoublePageMode", "", "isFirstPageSingle", "isRTL", "excludedAnnotationTypes", "Lcom/pspdfkit/annotations/AnnotationType;", "isRedactionPreviewEnabled", "drawableProviders", "Lcom/pspdfkit/ui/drawable/PdfDrawableProvider;", "availableWidth", "", "isLoading", "error", "", "dirtyPages", "", "scrollableThumbnails", "", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBitmap;", "isScrollableMode", "scrollableSelectedPageIndex", "<init>", "(Lcom/pspdfkit/document/PdfDocument;Lcom/pspdfkit/configuration/PdfConfiguration;Lcom/pspdfkit/configuration/rendering/PageRenderConfiguration;Ljava/util/List;Lcom/pspdfkit/ui/thumbnail/ThumbnailItem;Lcom/pspdfkit/ui/thumbnail/ThumbnailItem;Lcom/pspdfkit/ui/thumbnail/LayoutStyle;Lcom/pspdfkit/ui/thumbnail/ThumbnailBarTheme;ZZZLjava/util/List;ZLjava/util/List;IZLjava/lang/String;Ljava/util/Set;Ljava/util/Map;ZI)V", "getDocument", "()Lcom/pspdfkit/document/PdfDocument;", "getConfiguration", "()Lcom/pspdfkit/configuration/PdfConfiguration;", "getPageRenderConfiguration", "()Lcom/pspdfkit/configuration/rendering/PageRenderConfiguration;", "getThumbnails", "()Ljava/util/List;", "getSelectedPageThumbnail", "()Lcom/pspdfkit/ui/thumbnail/ThumbnailItem;", "getSelectedSiblingThumbnail", "getLayoutStyle", "()Lcom/pspdfkit/ui/thumbnail/LayoutStyle;", "getTheme", "()Lcom/pspdfkit/ui/thumbnail/ThumbnailBarTheme;", "()Z", "getExcludedAnnotationTypes", "getDrawableProviders", "getAvailableWidth", "()I", "getError", "()Ljava/lang/String;", "getDirtyPages", "()Ljava/util/Set;", "getScrollableThumbnails", "()Ljava/util/Map;", "getScrollableSelectedPageIndex", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "toString", "Companion", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class ThumbnailBarUiState {
    public static final int PAGE_INDEX_NONE = -1;
    private final int availableWidth;
    private final PdfConfiguration configuration;
    private final Set<Integer> dirtyPages;
    private final PdfDocument document;
    private final List<PdfDrawableProvider> drawableProviders;
    private final String error;
    private final List<AnnotationType> excludedAnnotationTypes;
    private final boolean isDoublePageMode;
    private final boolean isFirstPageSingle;
    private final boolean isLoading;
    private final boolean isRTL;
    private final boolean isRedactionPreviewEnabled;
    private final boolean isScrollableMode;
    private final LayoutStyle layoutStyle;
    private final PageRenderConfiguration pageRenderConfiguration;
    private final int scrollableSelectedPageIndex;
    private final Map<Integer, ThumbnailBitmap> scrollableThumbnails;
    private final ThumbnailItem selectedPageThumbnail;
    private final ThumbnailItem selectedSiblingThumbnail;
    private final ThumbnailBarTheme theme;
    private final List<ThumbnailItem> thumbnails;
    public static final int $stable = 8;

    public ThumbnailBarUiState() {
        this(null, null, null, null, null, null, null, null, false, false, false, null, false, null, 0, false, null, null, null, false, 0, 2097151, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ThumbnailBarUiState copy$default(ThumbnailBarUiState thumbnailBarUiState, PdfDocument pdfDocument, PdfConfiguration pdfConfiguration, PageRenderConfiguration pageRenderConfiguration, List list, ThumbnailItem thumbnailItem, ThumbnailItem thumbnailItem2, LayoutStyle layoutStyle, ThumbnailBarTheme thumbnailBarTheme, boolean z, boolean z2, boolean z3, List list2, boolean z4, List list3, int i, boolean z5, String str, Set set, Map map, boolean z6, int i2, int i3, Object obj) {
        int i4;
        boolean z7;
        PdfDocument pdfDocument2 = (i3 & 1) != 0 ? thumbnailBarUiState.document : pdfDocument;
        PdfConfiguration pdfConfiguration2 = (i3 & 2) != 0 ? thumbnailBarUiState.configuration : pdfConfiguration;
        PageRenderConfiguration pageRenderConfiguration2 = (i3 & 4) != 0 ? thumbnailBarUiState.pageRenderConfiguration : pageRenderConfiguration;
        List list4 = (i3 & 8) != 0 ? thumbnailBarUiState.thumbnails : list;
        ThumbnailItem thumbnailItem3 = (i3 & 16) != 0 ? thumbnailBarUiState.selectedPageThumbnail : thumbnailItem;
        ThumbnailItem thumbnailItem4 = (i3 & 32) != 0 ? thumbnailBarUiState.selectedSiblingThumbnail : thumbnailItem2;
        LayoutStyle layoutStyle2 = (i3 & 64) != 0 ? thumbnailBarUiState.layoutStyle : layoutStyle;
        ThumbnailBarTheme thumbnailBarTheme2 = (i3 & 128) != 0 ? thumbnailBarUiState.theme : thumbnailBarTheme;
        boolean z8 = (i3 & 256) != 0 ? thumbnailBarUiState.isDoublePageMode : z;
        boolean z9 = (i3 & 512) != 0 ? thumbnailBarUiState.isFirstPageSingle : z2;
        boolean z10 = (i3 & 1024) != 0 ? thumbnailBarUiState.isRTL : z3;
        List list5 = (i3 & 2048) != 0 ? thumbnailBarUiState.excludedAnnotationTypes : list2;
        boolean z11 = (i3 & 4096) != 0 ? thumbnailBarUiState.isRedactionPreviewEnabled : z4;
        List list6 = (i3 & 8192) != 0 ? thumbnailBarUiState.drawableProviders : list3;
        PdfDocument pdfDocument3 = pdfDocument2;
        int i5 = (i3 & 16384) != 0 ? thumbnailBarUiState.availableWidth : i;
        boolean z12 = (i3 & 32768) != 0 ? thumbnailBarUiState.isLoading : z5;
        String str2 = (i3 & 65536) != 0 ? thumbnailBarUiState.error : str;
        Set set2 = (i3 & 131072) != 0 ? thumbnailBarUiState.dirtyPages : set;
        Map map2 = (i3 & 262144) != 0 ? thumbnailBarUiState.scrollableThumbnails : map;
        boolean z13 = (i3 & 524288) != 0 ? thumbnailBarUiState.isScrollableMode : z6;
        if ((i3 & 1048576) != 0) {
            z7 = z13;
            i4 = thumbnailBarUiState.scrollableSelectedPageIndex;
        } else {
            i4 = i2;
            z7 = z13;
        }
        return thumbnailBarUiState.copy(pdfDocument3, pdfConfiguration2, pageRenderConfiguration2, list4, thumbnailItem3, thumbnailItem4, layoutStyle2, thumbnailBarTheme2, z8, z9, z10, list5, z11, list6, i5, z12, str2, set2, map2, z7, i4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final PdfDocument getDocument() {
        return this.document;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getIsFirstPageSingle() {
        return this.isFirstPageSingle;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getIsRTL() {
        return this.isRTL;
    }

    public final List<AnnotationType> component12() {
        return this.excludedAnnotationTypes;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final boolean getIsRedactionPreviewEnabled() {
        return this.isRedactionPreviewEnabled;
    }

    public final List<PdfDrawableProvider> component14() {
        return this.drawableProviders;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final int getAvailableWidth() {
        return this.availableWidth;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final boolean getIsLoading() {
        return this.isLoading;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getError() {
        return this.error;
    }

    public final Set<Integer> component18() {
        return this.dirtyPages;
    }

    public final Map<Integer, ThumbnailBitmap> component19() {
        return this.scrollableThumbnails;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final PdfConfiguration getConfiguration() {
        return this.configuration;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final boolean getIsScrollableMode() {
        return this.isScrollableMode;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final int getScrollableSelectedPageIndex() {
        return this.scrollableSelectedPageIndex;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final PageRenderConfiguration getPageRenderConfiguration() {
        return this.pageRenderConfiguration;
    }

    public final List<ThumbnailItem> component4() {
        return this.thumbnails;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final ThumbnailItem getSelectedPageThumbnail() {
        return this.selectedPageThumbnail;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final ThumbnailItem getSelectedSiblingThumbnail() {
        return this.selectedSiblingThumbnail;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final LayoutStyle getLayoutStyle() {
        return this.layoutStyle;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final ThumbnailBarTheme getTheme() {
        return this.theme;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getIsDoublePageMode() {
        return this.isDoublePageMode;
    }

    public final ThumbnailBarUiState copy(PdfDocument document, PdfConfiguration configuration, PageRenderConfiguration pageRenderConfiguration, List<ThumbnailItem> thumbnails, ThumbnailItem selectedPageThumbnail, ThumbnailItem selectedSiblingThumbnail, LayoutStyle layoutStyle, ThumbnailBarTheme theme, boolean isDoublePageMode, boolean isFirstPageSingle, boolean isRTL, List<? extends AnnotationType> excludedAnnotationTypes, boolean isRedactionPreviewEnabled, List<? extends PdfDrawableProvider> drawableProviders, int availableWidth, boolean isLoading, String error, Set<Integer> dirtyPages, Map<Integer, ThumbnailBitmap> scrollableThumbnails, boolean isScrollableMode, int scrollableSelectedPageIndex) {
        thumbnails.getClass();
        layoutStyle.getClass();
        theme.getClass();
        excludedAnnotationTypes.getClass();
        drawableProviders.getClass();
        dirtyPages.getClass();
        scrollableThumbnails.getClass();
        return new ThumbnailBarUiState(document, configuration, pageRenderConfiguration, thumbnails, selectedPageThumbnail, selectedSiblingThumbnail, layoutStyle, theme, isDoublePageMode, isFirstPageSingle, isRTL, excludedAnnotationTypes, isRedactionPreviewEnabled, drawableProviders, availableWidth, isLoading, error, dirtyPages, scrollableThumbnails, isScrollableMode, scrollableSelectedPageIndex);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThumbnailBarUiState)) {
            return false;
        }
        ThumbnailBarUiState thumbnailBarUiState = (ThumbnailBarUiState) other;
        return Intrinsics.areEqual(this.document, thumbnailBarUiState.document) && Intrinsics.areEqual(this.configuration, thumbnailBarUiState.configuration) && Intrinsics.areEqual(this.pageRenderConfiguration, thumbnailBarUiState.pageRenderConfiguration) && Intrinsics.areEqual(this.thumbnails, thumbnailBarUiState.thumbnails) && Intrinsics.areEqual(this.selectedPageThumbnail, thumbnailBarUiState.selectedPageThumbnail) && Intrinsics.areEqual(this.selectedSiblingThumbnail, thumbnailBarUiState.selectedSiblingThumbnail) && this.layoutStyle == thumbnailBarUiState.layoutStyle && Intrinsics.areEqual(this.theme, thumbnailBarUiState.theme) && this.isDoublePageMode == thumbnailBarUiState.isDoublePageMode && this.isFirstPageSingle == thumbnailBarUiState.isFirstPageSingle && this.isRTL == thumbnailBarUiState.isRTL && Intrinsics.areEqual(this.excludedAnnotationTypes, thumbnailBarUiState.excludedAnnotationTypes) && this.isRedactionPreviewEnabled == thumbnailBarUiState.isRedactionPreviewEnabled && Intrinsics.areEqual(this.drawableProviders, thumbnailBarUiState.drawableProviders) && this.availableWidth == thumbnailBarUiState.availableWidth && this.isLoading == thumbnailBarUiState.isLoading && Intrinsics.areEqual(this.error, thumbnailBarUiState.error) && Intrinsics.areEqual(this.dirtyPages, thumbnailBarUiState.dirtyPages) && Intrinsics.areEqual(this.scrollableThumbnails, thumbnailBarUiState.scrollableThumbnails) && this.isScrollableMode == thumbnailBarUiState.isScrollableMode && this.scrollableSelectedPageIndex == thumbnailBarUiState.scrollableSelectedPageIndex;
    }

    public final int getAvailableWidth() {
        return this.availableWidth;
    }

    public final PdfConfiguration getConfiguration() {
        return this.configuration;
    }

    public final Set<Integer> getDirtyPages() {
        return this.dirtyPages;
    }

    public final PdfDocument getDocument() {
        return this.document;
    }

    public final List<PdfDrawableProvider> getDrawableProviders() {
        return this.drawableProviders;
    }

    public final String getError() {
        return this.error;
    }

    public final List<AnnotationType> getExcludedAnnotationTypes() {
        return this.excludedAnnotationTypes;
    }

    public final LayoutStyle getLayoutStyle() {
        return this.layoutStyle;
    }

    public final PageRenderConfiguration getPageRenderConfiguration() {
        return this.pageRenderConfiguration;
    }

    public final int getScrollableSelectedPageIndex() {
        return this.scrollableSelectedPageIndex;
    }

    public final Map<Integer, ThumbnailBitmap> getScrollableThumbnails() {
        return this.scrollableThumbnails;
    }

    public final ThumbnailItem getSelectedPageThumbnail() {
        return this.selectedPageThumbnail;
    }

    public final ThumbnailItem getSelectedSiblingThumbnail() {
        return this.selectedSiblingThumbnail;
    }

    public final ThumbnailBarTheme getTheme() {
        return this.theme;
    }

    public final List<ThumbnailItem> getThumbnails() {
        return this.thumbnails;
    }

    public int hashCode() {
        PdfDocument pdfDocument = this.document;
        int iHashCode = (pdfDocument == null ? 0 : pdfDocument.hashCode()) * 31;
        PdfConfiguration pdfConfiguration = this.configuration;
        int iHashCode2 = (iHashCode + (pdfConfiguration == null ? 0 : pdfConfiguration.hashCode())) * 31;
        PageRenderConfiguration pageRenderConfiguration = this.pageRenderConfiguration;
        int iA = lv.a(this.thumbnails, (iHashCode2 + (pageRenderConfiguration == null ? 0 : pageRenderConfiguration.hashCode())) * 31, 31);
        ThumbnailItem thumbnailItem = this.selectedPageThumbnail;
        int iHashCode3 = (iA + (thumbnailItem == null ? 0 : thumbnailItem.hashCode())) * 31;
        ThumbnailItem thumbnailItem2 = this.selectedSiblingThumbnail;
        int iA2 = mv.a(this.isLoading, nd.a(this.availableWidth, lv.a(this.drawableProviders, mv.a(this.isRedactionPreviewEnabled, lv.a(this.excludedAnnotationTypes, mv.a(this.isRTL, mv.a(this.isFirstPageSingle, mv.a(this.isDoublePageMode, (this.theme.hashCode() + ((this.layoutStyle.hashCode() + ((iHashCode3 + (thumbnailItem2 == null ? 0 : thumbnailItem2.hashCode())) * 31)) * 31)) * 31, 31), 31), 31), 31), 31), 31), 31), 31);
        String str = this.error;
        return Integer.hashCode(this.scrollableSelectedPageIndex) + mv.a(this.isScrollableMode, (this.scrollableThumbnails.hashCode() + ((this.dirtyPages.hashCode() + ((iA2 + (str != null ? str.hashCode() : 0)) * 31)) * 31)) * 31, 31);
    }

    public final boolean isDoublePageMode() {
        return this.isDoublePageMode;
    }

    public final boolean isFirstPageSingle() {
        return this.isFirstPageSingle;
    }

    public final boolean isLoading() {
        return this.isLoading;
    }

    public final boolean isRTL() {
        return this.isRTL;
    }

    public final boolean isRedactionPreviewEnabled() {
        return this.isRedactionPreviewEnabled;
    }

    public final boolean isScrollableMode() {
        return this.isScrollableMode;
    }

    public String toString() {
        return "ThumbnailBarUiState(document=" + this.document + ", configuration=" + this.configuration + ", pageRenderConfiguration=" + this.pageRenderConfiguration + ", thumbnails=" + this.thumbnails + ", selectedPageThumbnail=" + this.selectedPageThumbnail + ", selectedSiblingThumbnail=" + this.selectedSiblingThumbnail + ", layoutStyle=" + this.layoutStyle + ", theme=" + this.theme + ", isDoublePageMode=" + this.isDoublePageMode + ", isFirstPageSingle=" + this.isFirstPageSingle + ", isRTL=" + this.isRTL + ", excludedAnnotationTypes=" + this.excludedAnnotationTypes + ", isRedactionPreviewEnabled=" + this.isRedactionPreviewEnabled + ", drawableProviders=" + this.drawableProviders + ", availableWidth=" + this.availableWidth + ", isLoading=" + this.isLoading + ", error=" + this.error + ", dirtyPages=" + this.dirtyPages + ", scrollableThumbnails=" + this.scrollableThumbnails + ", isScrollableMode=" + this.isScrollableMode + ", scrollableSelectedPageIndex=" + this.scrollableSelectedPageIndex + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ThumbnailBarUiState(PdfDocument pdfDocument, PdfConfiguration pdfConfiguration, PageRenderConfiguration pageRenderConfiguration, List<ThumbnailItem> list, ThumbnailItem thumbnailItem, ThumbnailItem thumbnailItem2, LayoutStyle layoutStyle, ThumbnailBarTheme thumbnailBarTheme, boolean z, boolean z2, boolean z3, List<? extends AnnotationType> list2, boolean z4, List<? extends PdfDrawableProvider> list3, int i, boolean z5, String str, Set<Integer> set, Map<Integer, ThumbnailBitmap> map, boolean z6, int i2) {
        list.getClass();
        layoutStyle.getClass();
        thumbnailBarTheme.getClass();
        list2.getClass();
        list3.getClass();
        set.getClass();
        map.getClass();
        this.document = pdfDocument;
        this.configuration = pdfConfiguration;
        this.pageRenderConfiguration = pageRenderConfiguration;
        this.thumbnails = list;
        this.selectedPageThumbnail = thumbnailItem;
        this.selectedSiblingThumbnail = thumbnailItem2;
        this.layoutStyle = layoutStyle;
        this.theme = thumbnailBarTheme;
        this.isDoublePageMode = z;
        this.isFirstPageSingle = z2;
        this.isRTL = z3;
        this.excludedAnnotationTypes = list2;
        this.isRedactionPreviewEnabled = z4;
        this.drawableProviders = list3;
        this.availableWidth = i;
        this.isLoading = z5;
        this.error = str;
        this.dirtyPages = set;
        this.scrollableThumbnails = map;
        this.isScrollableMode = z6;
        this.scrollableSelectedPageIndex = i2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ThumbnailBarUiState(PdfDocument pdfDocument, PdfConfiguration pdfConfiguration, PageRenderConfiguration pageRenderConfiguration, List list, ThumbnailItem thumbnailItem, ThumbnailItem thumbnailItem2, LayoutStyle layoutStyle, ThumbnailBarTheme thumbnailBarTheme, boolean z, boolean z2, boolean z3, List list2, boolean z4, List list3, int i, boolean z5, String str, Set set, Map map, boolean z6, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        PdfDocument pdfDocument2 = (i3 & 1) != 0 ? null : pdfDocument;
        PdfConfiguration pdfConfiguration2 = (i3 & 2) != 0 ? null : pdfConfiguration;
        PageRenderConfiguration pageRenderConfiguration2 = (i3 & 4) != 0 ? null : pageRenderConfiguration;
        List listEmptyList = (i3 & 8) != 0 ? CollectionsKt.emptyList() : list;
        ThumbnailItem thumbnailItem3 = (i3 & 16) != 0 ? null : thumbnailItem;
        ThumbnailItem thumbnailItem4 = (i3 & 32) != 0 ? null : thumbnailItem2;
        LayoutStyle layoutStyle2 = (i3 & 64) != 0 ? LayoutStyle.FLOATING : layoutStyle;
        ThumbnailBarTheme thumbnailBarTheme2 = (i3 & 128) != 0 ? new ThumbnailBarTheme(0, 0, 0, 0, 0, 0, false, 0, 0, 0, 0, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, ViewCompat.MEASURED_SIZE_MASK, null) : thumbnailBarTheme;
        boolean z7 = (i3 & 256) != 0 ? false : z;
        this(pdfDocument2, pdfConfiguration2, pageRenderConfiguration2, listEmptyList, thumbnailItem3, thumbnailItem4, layoutStyle2, thumbnailBarTheme2, z7, (i3 & 512) != 0 ? false : z2, (i3 & 1024) != 0 ? false : z3, (i3 & 2048) != 0 ? CollectionsKt.emptyList() : list2, (i3 & 4096) != 0 ? false : z4, (i3 & 8192) != 0 ? CollectionsKt.emptyList() : list3, (i3 & 16384) != 0 ? 0 : i, (i3 & 32768) != 0 ? false : z5, (i3 & 65536) != 0 ? null : str, (i3 & 131072) != 0 ? SetsKt.emptySet() : set, (i3 & 262144) != 0 ? MapsKt.emptyMap() : map, (i3 & 524288) != 0 ? false : z6, (i3 & 1048576) != 0 ? 0 : i2);
    }
}
