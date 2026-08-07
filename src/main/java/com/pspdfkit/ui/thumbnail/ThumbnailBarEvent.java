package com.pspdfkit.ui.thumbnail;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.google.common.net.HttpHeaders;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.ui.drawable.PdfDrawableProvider;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0014\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0082\u0001\u0014\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()¨\u0006*À\u0006\u0003"}, d2 = {"Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent;", "", "ThumbnailClicked", "ThumbnailScrolled", "DocumentSet", "PageChanged", "PageUpdated", "LayoutStyleChanged", "ThemeChanged", "BackgroundColorChanged", "ThumbnailBorderColorChanged", "ThumbnailSizeChanged", "UsePageAspectRatioChanged", "RedactionPreviewChanged", "DrawableProvidersChanged", "AvailableWidthChanged", "ThumbnailRendered", "ThumbnailRenderFailed", "ClearDocument", HttpHeaders.REFRESH, "ScrollableVisiblePagesChanged", "ScrollableModeChanged", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent$AvailableWidthChanged;", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent$BackgroundColorChanged;", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent$ClearDocument;", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent$DocumentSet;", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent$DrawableProvidersChanged;", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent$LayoutStyleChanged;", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent$PageChanged;", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent$PageUpdated;", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent$RedactionPreviewChanged;", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent$Refresh;", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent$ScrollableModeChanged;", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent$ScrollableVisiblePagesChanged;", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent$ThemeChanged;", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent$ThumbnailBorderColorChanged;", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent$ThumbnailClicked;", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent$ThumbnailRenderFailed;", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent$ThumbnailRendered;", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent$ThumbnailScrolled;", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent$ThumbnailSizeChanged;", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent$UsePageAspectRatioChanged;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface ThumbnailBarEvent {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent$AvailableWidthChanged;", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent;", "width", "", "<init>", "(I)V", "getWidth", "()I", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class AvailableWidthChanged implements ThumbnailBarEvent {
        public static final int $stable = 0;
        private final int width;

        public AvailableWidthChanged(int i) {
            this.width = i;
        }

        public static /* synthetic */ AvailableWidthChanged copy$default(AvailableWidthChanged availableWidthChanged, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = availableWidthChanged.width;
            }
            return availableWidthChanged.copy(i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getWidth() {
            return this.width;
        }

        public final AvailableWidthChanged copy(int width) {
            return new AvailableWidthChanged(width);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof AvailableWidthChanged) && this.width == ((AvailableWidthChanged) other).width;
        }

        public final int getWidth() {
            return this.width;
        }

        public int hashCode() {
            return Integer.hashCode(this.width);
        }

        public String toString() {
            return "AvailableWidthChanged(width=" + this.width + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent$BackgroundColorChanged;", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent;", "color", "", "<init>", "(I)V", "getColor", "()I", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class BackgroundColorChanged implements ThumbnailBarEvent {
        public static final int $stable = 0;
        private final int color;

        public BackgroundColorChanged(int i) {
            this.color = i;
        }

        public static /* synthetic */ BackgroundColorChanged copy$default(BackgroundColorChanged backgroundColorChanged, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = backgroundColorChanged.color;
            }
            return backgroundColorChanged.copy(i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getColor() {
            return this.color;
        }

        public final BackgroundColorChanged copy(int color) {
            return new BackgroundColorChanged(color);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof BackgroundColorChanged) && this.color == ((BackgroundColorChanged) other).color;
        }

        public final int getColor() {
            return this.color;
        }

        public int hashCode() {
            return Integer.hashCode(this.color);
        }

        public String toString() {
            return "BackgroundColorChanged(color=" + this.color + ")";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent$ClearDocument;", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class ClearDocument implements ThumbnailBarEvent {
        public static final int $stable = 0;
        public static final ClearDocument INSTANCE = new ClearDocument();

        private ClearDocument() {
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof ClearDocument);
        }

        public int hashCode() {
            return -1978664821;
        }

        public String toString() {
            return "ClearDocument";
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent$DocumentSet;", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent;", "document", "Lcom/pspdfkit/document/PdfDocument;", "configuration", "Lcom/pspdfkit/configuration/PdfConfiguration;", "<init>", "(Lcom/pspdfkit/document/PdfDocument;Lcom/pspdfkit/configuration/PdfConfiguration;)V", "getDocument", "()Lcom/pspdfkit/document/PdfDocument;", "getConfiguration", "()Lcom/pspdfkit/configuration/PdfConfiguration;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class DocumentSet implements ThumbnailBarEvent {
        public static final int $stable = 8;
        private final PdfConfiguration configuration;
        private final PdfDocument document;

        public DocumentSet(PdfDocument pdfDocument, PdfConfiguration pdfConfiguration) {
            pdfDocument.getClass();
            pdfConfiguration.getClass();
            this.document = pdfDocument;
            this.configuration = pdfConfiguration;
        }

        public static /* synthetic */ DocumentSet copy$default(DocumentSet documentSet, PdfDocument pdfDocument, PdfConfiguration pdfConfiguration, int i, Object obj) {
            if ((i & 1) != 0) {
                pdfDocument = documentSet.document;
            }
            if ((i & 2) != 0) {
                pdfConfiguration = documentSet.configuration;
            }
            return documentSet.copy(pdfDocument, pdfConfiguration);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final PdfDocument getDocument() {
            return this.document;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final PdfConfiguration getConfiguration() {
            return this.configuration;
        }

        public final DocumentSet copy(PdfDocument document, PdfConfiguration configuration) {
            document.getClass();
            configuration.getClass();
            return new DocumentSet(document, configuration);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DocumentSet)) {
                return false;
            }
            DocumentSet documentSet = (DocumentSet) other;
            return Intrinsics.areEqual(this.document, documentSet.document) && Intrinsics.areEqual(this.configuration, documentSet.configuration);
        }

        public final PdfConfiguration getConfiguration() {
            return this.configuration;
        }

        public final PdfDocument getDocument() {
            return this.document;
        }

        public int hashCode() {
            return this.configuration.hashCode() + (this.document.hashCode() * 31);
        }

        public String toString() {
            return "DocumentSet(document=" + this.document + ", configuration=" + this.configuration + ")";
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent$DrawableProvidersChanged;", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent;", "providers", "", "Lcom/pspdfkit/ui/drawable/PdfDrawableProvider;", "<init>", "(Ljava/util/List;)V", "getProviders", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class DrawableProvidersChanged implements ThumbnailBarEvent {
        public static final int $stable = 8;
        private final List<PdfDrawableProvider> providers;

        /* JADX WARN: Multi-variable type inference failed */
        public DrawableProvidersChanged(List<? extends PdfDrawableProvider> list) {
            list.getClass();
            this.providers = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DrawableProvidersChanged copy$default(DrawableProvidersChanged drawableProvidersChanged, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = drawableProvidersChanged.providers;
            }
            return drawableProvidersChanged.copy(list);
        }

        public final List<PdfDrawableProvider> component1() {
            return this.providers;
        }

        public final DrawableProvidersChanged copy(List<? extends PdfDrawableProvider> providers) {
            providers.getClass();
            return new DrawableProvidersChanged(providers);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DrawableProvidersChanged) && Intrinsics.areEqual(this.providers, ((DrawableProvidersChanged) other).providers);
        }

        public final List<PdfDrawableProvider> getProviders() {
            return this.providers;
        }

        public int hashCode() {
            return this.providers.hashCode();
        }

        public String toString() {
            return "DrawableProvidersChanged(providers=" + this.providers + ")";
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent$LayoutStyleChanged;", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent;", "style", "Lcom/pspdfkit/ui/thumbnail/LayoutStyle;", "<init>", "(Lcom/pspdfkit/ui/thumbnail/LayoutStyle;)V", "getStyle", "()Lcom/pspdfkit/ui/thumbnail/LayoutStyle;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class LayoutStyleChanged implements ThumbnailBarEvent {
        public static final int $stable = 0;
        private final LayoutStyle style;

        public LayoutStyleChanged(LayoutStyle layoutStyle) {
            layoutStyle.getClass();
            this.style = layoutStyle;
        }

        public static /* synthetic */ LayoutStyleChanged copy$default(LayoutStyleChanged layoutStyleChanged, LayoutStyle layoutStyle, int i, Object obj) {
            if ((i & 1) != 0) {
                layoutStyle = layoutStyleChanged.style;
            }
            return layoutStyleChanged.copy(layoutStyle);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final LayoutStyle getStyle() {
            return this.style;
        }

        public final LayoutStyleChanged copy(LayoutStyle style) {
            style.getClass();
            return new LayoutStyleChanged(style);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof LayoutStyleChanged) && this.style == ((LayoutStyleChanged) other).style;
        }

        public final LayoutStyle getStyle() {
            return this.style;
        }

        public int hashCode() {
            return this.style.hashCode();
        }

        public String toString() {
            return "LayoutStyleChanged(style=" + this.style + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent$PageChanged;", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent;", "pageIndex", "", "<init>", "(I)V", "getPageIndex", "()I", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class PageChanged implements ThumbnailBarEvent {
        public static final int $stable = 0;
        private final int pageIndex;

        public PageChanged(int i) {
            this.pageIndex = i;
        }

        public static /* synthetic */ PageChanged copy$default(PageChanged pageChanged, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = pageChanged.pageIndex;
            }
            return pageChanged.copy(i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getPageIndex() {
            return this.pageIndex;
        }

        public final PageChanged copy(int pageIndex) {
            return new PageChanged(pageIndex);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof PageChanged) && this.pageIndex == ((PageChanged) other).pageIndex;
        }

        public final int getPageIndex() {
            return this.pageIndex;
        }

        public int hashCode() {
            return Integer.hashCode(this.pageIndex);
        }

        public String toString() {
            return "PageChanged(pageIndex=" + this.pageIndex + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent$PageUpdated;", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent;", "pageIndex", "", "<init>", "(I)V", "getPageIndex", "()I", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class PageUpdated implements ThumbnailBarEvent {
        public static final int $stable = 0;
        private final int pageIndex;

        public PageUpdated(int i) {
            this.pageIndex = i;
        }

        public static /* synthetic */ PageUpdated copy$default(PageUpdated pageUpdated, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = pageUpdated.pageIndex;
            }
            return pageUpdated.copy(i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getPageIndex() {
            return this.pageIndex;
        }

        public final PageUpdated copy(int pageIndex) {
            return new PageUpdated(pageIndex);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof PageUpdated) && this.pageIndex == ((PageUpdated) other).pageIndex;
        }

        public final int getPageIndex() {
            return this.pageIndex;
        }

        public int hashCode() {
            return Integer.hashCode(this.pageIndex);
        }

        public String toString() {
            return "PageUpdated(pageIndex=" + this.pageIndex + ")";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent$RedactionPreviewChanged;", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent;", "enabled", "", "<init>", "(Z)V", "getEnabled", "()Z", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class RedactionPreviewChanged implements ThumbnailBarEvent {
        public static final int $stable = 0;
        private final boolean enabled;

        public RedactionPreviewChanged(boolean z) {
            this.enabled = z;
        }

        public static /* synthetic */ RedactionPreviewChanged copy$default(RedactionPreviewChanged redactionPreviewChanged, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = redactionPreviewChanged.enabled;
            }
            return redactionPreviewChanged.copy(z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getEnabled() {
            return this.enabled;
        }

        public final RedactionPreviewChanged copy(boolean enabled) {
            return new RedactionPreviewChanged(enabled);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof RedactionPreviewChanged) && this.enabled == ((RedactionPreviewChanged) other).enabled;
        }

        public final boolean getEnabled() {
            return this.enabled;
        }

        public int hashCode() {
            return Boolean.hashCode(this.enabled);
        }

        public String toString() {
            return "RedactionPreviewChanged(enabled=" + this.enabled + ")";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent$Refresh;", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Refresh implements ThumbnailBarEvent {
        public static final int $stable = 0;
        public static final Refresh INSTANCE = new Refresh();

        private Refresh() {
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof Refresh);
        }

        public int hashCode() {
            return -1780303074;
        }

        public String toString() {
            return HttpHeaders.REFRESH;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0083\u0004J\n\u0010\f\u001a\u00020\rHÖ\u0081\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent$ScrollableModeChanged;", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent;", "isScrollable", "", "<init>", "(Z)V", "()Z", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class ScrollableModeChanged implements ThumbnailBarEvent {
        public static final int $stable = 0;
        private final boolean isScrollable;

        public ScrollableModeChanged(boolean z) {
            this.isScrollable = z;
        }

        public static /* synthetic */ ScrollableModeChanged copy$default(ScrollableModeChanged scrollableModeChanged, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = scrollableModeChanged.isScrollable;
            }
            return scrollableModeChanged.copy(z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsScrollable() {
            return this.isScrollable;
        }

        public final ScrollableModeChanged copy(boolean isScrollable) {
            return new ScrollableModeChanged(isScrollable);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ScrollableModeChanged) && this.isScrollable == ((ScrollableModeChanged) other).isScrollable;
        }

        public int hashCode() {
            return Boolean.hashCode(this.isScrollable);
        }

        public final boolean isScrollable() {
            return this.isScrollable;
        }

        public String toString() {
            return "ScrollableModeChanged(isScrollable=" + this.isScrollable + ")";
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0004HÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent$ScrollableVisiblePagesChanged;", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent;", "visiblePages", "", "", "<init>", "(Ljava/util/Set;)V", "getVisiblePages", "()Ljava/util/Set;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class ScrollableVisiblePagesChanged implements ThumbnailBarEvent {
        public static final int $stable = 8;
        private final Set<Integer> visiblePages;

        public ScrollableVisiblePagesChanged(Set<Integer> set) {
            set.getClass();
            this.visiblePages = set;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ScrollableVisiblePagesChanged copy$default(ScrollableVisiblePagesChanged scrollableVisiblePagesChanged, Set set, int i, Object obj) {
            if ((i & 1) != 0) {
                set = scrollableVisiblePagesChanged.visiblePages;
            }
            return scrollableVisiblePagesChanged.copy(set);
        }

        public final Set<Integer> component1() {
            return this.visiblePages;
        }

        public final ScrollableVisiblePagesChanged copy(Set<Integer> visiblePages) {
            visiblePages.getClass();
            return new ScrollableVisiblePagesChanged(visiblePages);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ScrollableVisiblePagesChanged) && Intrinsics.areEqual(this.visiblePages, ((ScrollableVisiblePagesChanged) other).visiblePages);
        }

        public final Set<Integer> getVisiblePages() {
            return this.visiblePages;
        }

        public int hashCode() {
            return this.visiblePages.hashCode();
        }

        public String toString() {
            return "ScrollableVisiblePagesChanged(visiblePages=" + this.visiblePages + ")";
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent$ThemeChanged;", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent;", "theme", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarTheme;", "<init>", "(Lcom/pspdfkit/ui/thumbnail/ThumbnailBarTheme;)V", "getTheme", "()Lcom/pspdfkit/ui/thumbnail/ThumbnailBarTheme;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class ThemeChanged implements ThumbnailBarEvent {
        public static final int $stable = 0;
        private final ThumbnailBarTheme theme;

        public ThemeChanged(ThumbnailBarTheme thumbnailBarTheme) {
            thumbnailBarTheme.getClass();
            this.theme = thumbnailBarTheme;
        }

        public static /* synthetic */ ThemeChanged copy$default(ThemeChanged themeChanged, ThumbnailBarTheme thumbnailBarTheme, int i, Object obj) {
            if ((i & 1) != 0) {
                thumbnailBarTheme = themeChanged.theme;
            }
            return themeChanged.copy(thumbnailBarTheme);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ThumbnailBarTheme getTheme() {
            return this.theme;
        }

        public final ThemeChanged copy(ThumbnailBarTheme theme) {
            theme.getClass();
            return new ThemeChanged(theme);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ThemeChanged) && Intrinsics.areEqual(this.theme, ((ThemeChanged) other).theme);
        }

        public final ThumbnailBarTheme getTheme() {
            return this.theme;
        }

        public int hashCode() {
            return this.theme.hashCode();
        }

        public String toString() {
            return "ThemeChanged(theme=" + this.theme + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent$ThumbnailBorderColorChanged;", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent;", "color", "", "<init>", "(I)V", "getColor", "()I", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class ThumbnailBorderColorChanged implements ThumbnailBarEvent {
        public static final int $stable = 0;
        private final int color;

        public ThumbnailBorderColorChanged(int i) {
            this.color = i;
        }

        public static /* synthetic */ ThumbnailBorderColorChanged copy$default(ThumbnailBorderColorChanged thumbnailBorderColorChanged, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = thumbnailBorderColorChanged.color;
            }
            return thumbnailBorderColorChanged.copy(i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getColor() {
            return this.color;
        }

        public final ThumbnailBorderColorChanged copy(int color) {
            return new ThumbnailBorderColorChanged(color);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ThumbnailBorderColorChanged) && this.color == ((ThumbnailBorderColorChanged) other).color;
        }

        public final int getColor() {
            return this.color;
        }

        public int hashCode() {
            return Integer.hashCode(this.color);
        }

        public String toString() {
            return "ThumbnailBorderColorChanged(color=" + this.color + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent$ThumbnailClicked;", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent;", "pageIndex", "", "<init>", "(I)V", "getPageIndex", "()I", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class ThumbnailClicked implements ThumbnailBarEvent {
        public static final int $stable = 0;
        private final int pageIndex;

        public ThumbnailClicked(int i) {
            this.pageIndex = i;
        }

        public static /* synthetic */ ThumbnailClicked copy$default(ThumbnailClicked thumbnailClicked, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = thumbnailClicked.pageIndex;
            }
            return thumbnailClicked.copy(i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getPageIndex() {
            return this.pageIndex;
        }

        public final ThumbnailClicked copy(int pageIndex) {
            return new ThumbnailClicked(pageIndex);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ThumbnailClicked) && this.pageIndex == ((ThumbnailClicked) other).pageIndex;
        }

        public final int getPageIndex() {
            return this.pageIndex;
        }

        public int hashCode() {
            return Integer.hashCode(this.pageIndex);
        }

        public String toString() {
            return "ThumbnailClicked(pageIndex=" + this.pageIndex + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent$ThumbnailRenderFailed;", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent;", "pageIndex", "", "error", "", "<init>", "(ILjava/lang/String;)V", "getPageIndex", "()I", "getError", "()Ljava/lang/String;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class ThumbnailRenderFailed implements ThumbnailBarEvent {
        public static final int $stable = 0;
        private final String error;
        private final int pageIndex;

        public ThumbnailRenderFailed(int i, String str) {
            str.getClass();
            this.pageIndex = i;
            this.error = str;
        }

        public static /* synthetic */ ThumbnailRenderFailed copy$default(ThumbnailRenderFailed thumbnailRenderFailed, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = thumbnailRenderFailed.pageIndex;
            }
            if ((i2 & 2) != 0) {
                str = thumbnailRenderFailed.error;
            }
            return thumbnailRenderFailed.copy(i, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getPageIndex() {
            return this.pageIndex;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getError() {
            return this.error;
        }

        public final ThumbnailRenderFailed copy(int pageIndex, String error) {
            error.getClass();
            return new ThumbnailRenderFailed(pageIndex, error);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ThumbnailRenderFailed)) {
                return false;
            }
            ThumbnailRenderFailed thumbnailRenderFailed = (ThumbnailRenderFailed) other;
            return this.pageIndex == thumbnailRenderFailed.pageIndex && Intrinsics.areEqual(this.error, thumbnailRenderFailed.error);
        }

        public final String getError() {
            return this.error;
        }

        public final int getPageIndex() {
            return this.pageIndex;
        }

        public int hashCode() {
            return this.error.hashCode() + (Integer.hashCode(this.pageIndex) * 31);
        }

        public String toString() {
            return "ThumbnailRenderFailed(pageIndex=" + this.pageIndex + ", error=" + this.error + ")";
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent$ThumbnailRendered;", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent;", "pageIndex", "", "bitmap", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBitmap;", "<init>", "(ILcom/pspdfkit/ui/thumbnail/ThumbnailBitmap;)V", "getPageIndex", "()I", "getBitmap", "()Lcom/pspdfkit/ui/thumbnail/ThumbnailBitmap;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class ThumbnailRendered implements ThumbnailBarEvent {
        public static final int $stable = 8;
        private final ThumbnailBitmap bitmap;
        private final int pageIndex;

        public ThumbnailRendered(int i, ThumbnailBitmap thumbnailBitmap) {
            thumbnailBitmap.getClass();
            this.pageIndex = i;
            this.bitmap = thumbnailBitmap;
        }

        public static /* synthetic */ ThumbnailRendered copy$default(ThumbnailRendered thumbnailRendered, int i, ThumbnailBitmap thumbnailBitmap, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = thumbnailRendered.pageIndex;
            }
            if ((i2 & 2) != 0) {
                thumbnailBitmap = thumbnailRendered.bitmap;
            }
            return thumbnailRendered.copy(i, thumbnailBitmap);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getPageIndex() {
            return this.pageIndex;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ThumbnailBitmap getBitmap() {
            return this.bitmap;
        }

        public final ThumbnailRendered copy(int pageIndex, ThumbnailBitmap bitmap) {
            bitmap.getClass();
            return new ThumbnailRendered(pageIndex, bitmap);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ThumbnailRendered)) {
                return false;
            }
            ThumbnailRendered thumbnailRendered = (ThumbnailRendered) other;
            return this.pageIndex == thumbnailRendered.pageIndex && Intrinsics.areEqual(this.bitmap, thumbnailRendered.bitmap);
        }

        public final ThumbnailBitmap getBitmap() {
            return this.bitmap;
        }

        public final int getPageIndex() {
            return this.pageIndex;
        }

        public int hashCode() {
            return this.bitmap.hashCode() + (Integer.hashCode(this.pageIndex) * 31);
        }

        public String toString() {
            return "ThumbnailRendered(pageIndex=" + this.pageIndex + ", bitmap=" + this.bitmap + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent$ThumbnailScrolled;", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent;", "touchX", "", "touchY", "<init>", "(II)V", "getTouchX", "()I", "getTouchY", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class ThumbnailScrolled implements ThumbnailBarEvent {
        public static final int $stable = 0;
        private final int touchX;
        private final int touchY;

        public ThumbnailScrolled(int i, int i2) {
            this.touchX = i;
            this.touchY = i2;
        }

        public static /* synthetic */ ThumbnailScrolled copy$default(ThumbnailScrolled thumbnailScrolled, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = thumbnailScrolled.touchX;
            }
            if ((i3 & 2) != 0) {
                i2 = thumbnailScrolled.touchY;
            }
            return thumbnailScrolled.copy(i, i2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getTouchX() {
            return this.touchX;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getTouchY() {
            return this.touchY;
        }

        public final ThumbnailScrolled copy(int touchX, int touchY) {
            return new ThumbnailScrolled(touchX, touchY);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ThumbnailScrolled)) {
                return false;
            }
            ThumbnailScrolled thumbnailScrolled = (ThumbnailScrolled) other;
            return this.touchX == thumbnailScrolled.touchX && this.touchY == thumbnailScrolled.touchY;
        }

        public final int getTouchX() {
            return this.touchX;
        }

        public final int getTouchY() {
            return this.touchY;
        }

        public int hashCode() {
            return Integer.hashCode(this.touchY) + (Integer.hashCode(this.touchX) * 31);
        }

        public String toString() {
            return "ThumbnailScrolled(touchX=" + this.touchX + ", touchY=" + this.touchY + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent$ThumbnailSizeChanged;", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent;", "width", "", "height", "<init>", "(II)V", "getWidth", "()I", "getHeight", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class ThumbnailSizeChanged implements ThumbnailBarEvent {
        public static final int $stable = 0;
        private final int height;
        private final int width;

        public ThumbnailSizeChanged(int i, int i2) {
            this.width = i;
            this.height = i2;
        }

        public static /* synthetic */ ThumbnailSizeChanged copy$default(ThumbnailSizeChanged thumbnailSizeChanged, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = thumbnailSizeChanged.width;
            }
            if ((i3 & 2) != 0) {
                i2 = thumbnailSizeChanged.height;
            }
            return thumbnailSizeChanged.copy(i, i2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getWidth() {
            return this.width;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getHeight() {
            return this.height;
        }

        public final ThumbnailSizeChanged copy(int width, int height) {
            return new ThumbnailSizeChanged(width, height);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ThumbnailSizeChanged)) {
                return false;
            }
            ThumbnailSizeChanged thumbnailSizeChanged = (ThumbnailSizeChanged) other;
            return this.width == thumbnailSizeChanged.width && this.height == thumbnailSizeChanged.height;
        }

        public final int getHeight() {
            return this.height;
        }

        public final int getWidth() {
            return this.width;
        }

        public int hashCode() {
            return Integer.hashCode(this.height) + (Integer.hashCode(this.width) * 31);
        }

        public String toString() {
            return "ThumbnailSizeChanged(width=" + this.width + ", height=" + this.height + ")";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent$UsePageAspectRatioChanged;", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent;", "useAspectRatio", "", "<init>", "(Z)V", "getUseAspectRatio", "()Z", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class UsePageAspectRatioChanged implements ThumbnailBarEvent {
        public static final int $stable = 0;
        private final boolean useAspectRatio;

        public UsePageAspectRatioChanged(boolean z) {
            this.useAspectRatio = z;
        }

        public static /* synthetic */ UsePageAspectRatioChanged copy$default(UsePageAspectRatioChanged usePageAspectRatioChanged, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = usePageAspectRatioChanged.useAspectRatio;
            }
            return usePageAspectRatioChanged.copy(z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getUseAspectRatio() {
            return this.useAspectRatio;
        }

        public final UsePageAspectRatioChanged copy(boolean useAspectRatio) {
            return new UsePageAspectRatioChanged(useAspectRatio);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof UsePageAspectRatioChanged) && this.useAspectRatio == ((UsePageAspectRatioChanged) other).useAspectRatio;
        }

        public final boolean getUseAspectRatio() {
            return this.useAspectRatio;
        }

        public int hashCode() {
            return Boolean.hashCode(this.useAspectRatio);
        }

        public String toString() {
            return "UsePageAspectRatioChanged(useAspectRatio=" + this.useAspectRatio + ")";
        }
    }
}
