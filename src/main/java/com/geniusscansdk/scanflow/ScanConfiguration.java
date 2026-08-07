package com.geniusscansdk.scanflow;

import androidx.exifinterface.media.ExifInterface;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.facebook.react.uimanager.ViewProps;
import com.geniusscansdk.R;
import com.geniusscansdk.core.FilterConfiguration;
import com.geniusscansdk.core.FilterType;
import com.geniusscansdk.core.ScanProcessor;
import com.geniusscansdk.pdf.PDFSize;
import com.geniusscansdk.structureddata.ReadableCode;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.codec.language.bm.Rule;

/* JADX INFO: compiled from: ScanConfiguration.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001:\u000bSTUVWXYZ[\\]B\u009f\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u0012\b\b\u0003\u0010\u001a\u001a\u00020\u001b\u0012\b\b\u0003\u0010\u001c\u001a\u00020\u001b\u0012\b\b\u0003\u0010\u001d\u001a\u00020\u001b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001b\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001b\u0012\b\b\u0002\u0010 \u001a\u00020!\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u0010\u0012\u000e\b\u0002\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u0010\u0012\b\b\u0002\u0010)\u001a\u00020*\u0012\b\b\u0002\u0010+\u001a\u00020\u0007¢\u0006\u0004\b,\u0010-J\t\u00102\u001a\u00020\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00104\u001a\u00020\u0007HÆ\u0003J\t\u00105\u001a\u00020\tHÆ\u0003J\u000f\u00106\u001a\b\u0012\u0004\u0012\u00020\t0\u000bHÆ\u0003J\t\u00107\u001a\u00020\rHÆ\u0003J\t\u00108\u001a\u00020\u0007HÆ\u0003J\u000f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0003J\t\u0010:\u001a\u00020\u0013HÆ\u0003J\t\u0010;\u001a\u00020\u0015HÆ\u0003J\t\u0010<\u001a\u00020\u0007HÆ\u0003J\t\u0010=\u001a\u00020\u0007HÆ\u0003J\t\u0010>\u001a\u00020\u0019HÆ\u0003J\t\u0010?\u001a\u00020\u001bHÆ\u0003J\t\u0010@\u001a\u00020\u001bHÆ\u0003J\t\u0010A\u001a\u00020\u001bHÆ\u0003J\t\u0010B\u001a\u00020\u001bHÆ\u0003J\t\u0010C\u001a\u00020\u001bHÆ\u0003J\t\u0010D\u001a\u00020!HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010$HÆ\u0003J\u000f\u0010G\u001a\b\u0012\u0004\u0012\u00020&0\u0010HÆ\u0003J\u000f\u0010H\u001a\b\u0012\u0004\u0012\u00020(0\u0010HÆ\u0003J\t\u0010I\u001a\u00020*HÆ\u0003J\u000e\u0010J\u001a\u00020\u0007HÀ\u0003¢\u0006\u0002\bKJ¡\u0002\u0010L\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00072\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0003\u0010\u001a\u001a\u00020\u001b2\b\b\u0003\u0010\u001c\u001a\u00020\u001b2\b\b\u0003\u0010\u001d\u001a\u00020\u001b2\b\b\u0002\u0010\u001e\u001a\u00020\u001b2\b\b\u0002\u0010\u001f\u001a\u00020\u001b2\b\b\u0002\u0010 \u001a\u00020!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u00102\u000e\b\u0002\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u00102\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020\u0007HÆ\u0001J\u0013\u0010M\u001a\u00020\u00072\b\u0010N\u001a\u0004\u0018\u00010OHÖ\u0003J\t\u0010P\u001a\u00020\u001bHÖ\u0001J\t\u0010Q\u001a\u00020RHÖ\u0001R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001f\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010 \u001a\u00020!8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0018\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0018\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010)\u001a\u00020*8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010+\u001a\u00020\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u0006^"}, d2 = {"Lcom/geniusscansdk/scanflow/ScanConfiguration;", "Ljava/io/Serializable;", "source", "Lcom/geniusscansdk/scanflow/ScanConfiguration$Source;", "sourceImage", "Ljava/io/File;", "multiPage", "", "defaultFilter", "Lcom/geniusscansdk/scanflow/ScanConfiguration$Filter;", "availableFilters", "", "pdfPageSize", "Lcom/geniusscansdk/scanflow/ScanConfiguration$PdfPageSize;", "skipPostProcessingScreen", "postProcessingActions", "Ljava/util/EnumSet;", "Lcom/geniusscansdk/scanflow/ScanConfiguration$Action;", "defaultCurvatureCorrection", "Lcom/geniusscansdk/scanflow/ScanConfiguration$CurvatureCorrectionMode;", "defaultScanOrientation", "Lcom/geniusscansdk/scanflow/ScanConfiguration$Orientation;", "photoLibraryButtonHidden", "flashButtonHidden", "defaultFlashMode", "Lcom/geniusscansdk/scanflow/ScanConfiguration$FlashMode;", "backgroundColor", "", ViewProps.FOREGROUND_COLOR, "highlightColor", "jpegQuality", "pdfMaxScanDimension", "multiPageFormat", "Lcom/geniusscansdk/scanflow/ScanConfiguration$MultiPageFormat;", "pdfFontFile", "ocrConfiguration", "Lcom/geniusscansdk/scanflow/ScanConfiguration$OcrConfiguration;", "structuredData", "Lcom/geniusscansdk/scanflow/ScanConfiguration$StructuredData;", "structuredDataReadableCodeTypes", "Lcom/geniusscansdk/structureddata/ReadableCode$Type;", "requiredReadabilityLevel", "Lcom/geniusscansdk/core/ScanProcessor$ReadabilityLevel;", "useLegacyCameraAPI", "<init>", "(Lcom/geniusscansdk/scanflow/ScanConfiguration$Source;Ljava/io/File;ZLcom/geniusscansdk/scanflow/ScanConfiguration$Filter;Ljava/util/List;Lcom/geniusscansdk/scanflow/ScanConfiguration$PdfPageSize;ZLjava/util/EnumSet;Lcom/geniusscansdk/scanflow/ScanConfiguration$CurvatureCorrectionMode;Lcom/geniusscansdk/scanflow/ScanConfiguration$Orientation;ZZLcom/geniusscansdk/scanflow/ScanConfiguration$FlashMode;IIIIILcom/geniusscansdk/scanflow/ScanConfiguration$MultiPageFormat;Ljava/io/File;Lcom/geniusscansdk/scanflow/ScanConfiguration$OcrConfiguration;Ljava/util/EnumSet;Ljava/util/EnumSet;Lcom/geniusscansdk/core/ScanProcessor$ReadabilityLevel;Z)V", "getUseLegacyCameraAPI$gssdk_release", "()Z", "setUseLegacyCameraAPI$gssdk_release", "(Z)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component25$gssdk_release", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "toString", "", "Source", "Filter", ExifInterface.TAG_ORIENTATION, "CurvatureCorrectionMode", "PdfPageSize", "Action", "FlashMode", "MultiPageFormat", "OcrOutputFormat", "StructuredData", "OcrConfiguration", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class ScanConfiguration implements Serializable {
    public List<? extends Filter> availableFilters;
    public int backgroundColor;
    public CurvatureCorrectionMode defaultCurvatureCorrection;
    public Filter defaultFilter;
    public FlashMode defaultFlashMode;
    public Orientation defaultScanOrientation;
    public boolean flashButtonHidden;
    public int foregroundColor;
    public int highlightColor;
    public int jpegQuality;
    public boolean multiPage;
    public MultiPageFormat multiPageFormat;
    public OcrConfiguration ocrConfiguration;
    public File pdfFontFile;
    public int pdfMaxScanDimension;
    public PdfPageSize pdfPageSize;
    public boolean photoLibraryButtonHidden;
    public EnumSet<Action> postProcessingActions;
    public ScanProcessor.ReadabilityLevel requiredReadabilityLevel;
    public boolean skipPostProcessingScreen;
    public Source source;
    public File sourceImage;
    public EnumSet<StructuredData> structuredData;
    public EnumSet<ReadableCode.Type> structuredDataReadableCodeTypes;
    private boolean useLegacyCameraAPI;

    public ScanConfiguration() {
        this(null, null, false, null, null, null, false, null, null, null, false, false, null, 0, 0, 0, 0, 0, null, null, null, null, null, null, false, 33554431, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ScanConfiguration copy$default(ScanConfiguration scanConfiguration, Source source, File file, boolean z, Filter filter, List list, PdfPageSize pdfPageSize, boolean z2, EnumSet enumSet, CurvatureCorrectionMode curvatureCorrectionMode, Orientation orientation, boolean z3, boolean z4, FlashMode flashMode, int i, int i2, int i3, int i4, int i5, MultiPageFormat multiPageFormat, File file2, OcrConfiguration ocrConfiguration, EnumSet enumSet2, EnumSet enumSet3, ScanProcessor.ReadabilityLevel readabilityLevel, boolean z5, int i6, Object obj) {
        boolean z6;
        ScanProcessor.ReadabilityLevel readabilityLevel2;
        Source source2 = (i6 & 1) != 0 ? scanConfiguration.source : source;
        File file3 = (i6 & 2) != 0 ? scanConfiguration.sourceImage : file;
        boolean z7 = (i6 & 4) != 0 ? scanConfiguration.multiPage : z;
        Filter filter2 = (i6 & 8) != 0 ? scanConfiguration.defaultFilter : filter;
        List list2 = (i6 & 16) != 0 ? scanConfiguration.availableFilters : list;
        PdfPageSize pdfPageSize2 = (i6 & 32) != 0 ? scanConfiguration.pdfPageSize : pdfPageSize;
        boolean z8 = (i6 & 64) != 0 ? scanConfiguration.skipPostProcessingScreen : z2;
        EnumSet enumSet4 = (i6 & 128) != 0 ? scanConfiguration.postProcessingActions : enumSet;
        CurvatureCorrectionMode curvatureCorrectionMode2 = (i6 & 256) != 0 ? scanConfiguration.defaultCurvatureCorrection : curvatureCorrectionMode;
        Orientation orientation2 = (i6 & 512) != 0 ? scanConfiguration.defaultScanOrientation : orientation;
        boolean z9 = (i6 & 1024) != 0 ? scanConfiguration.photoLibraryButtonHidden : z3;
        boolean z10 = (i6 & 2048) != 0 ? scanConfiguration.flashButtonHidden : z4;
        FlashMode flashMode2 = (i6 & 4096) != 0 ? scanConfiguration.defaultFlashMode : flashMode;
        int i7 = (i6 & 8192) != 0 ? scanConfiguration.backgroundColor : i;
        Source source3 = source2;
        int i8 = (i6 & 16384) != 0 ? scanConfiguration.foregroundColor : i2;
        int i9 = (i6 & 32768) != 0 ? scanConfiguration.highlightColor : i3;
        int i10 = (i6 & 65536) != 0 ? scanConfiguration.jpegQuality : i4;
        int i11 = (i6 & 131072) != 0 ? scanConfiguration.pdfMaxScanDimension : i5;
        MultiPageFormat multiPageFormat2 = (i6 & 262144) != 0 ? scanConfiguration.multiPageFormat : multiPageFormat;
        File file4 = (i6 & 524288) != 0 ? scanConfiguration.pdfFontFile : file2;
        OcrConfiguration ocrConfiguration2 = (i6 & 1048576) != 0 ? scanConfiguration.ocrConfiguration : ocrConfiguration;
        EnumSet enumSet5 = (i6 & 2097152) != 0 ? scanConfiguration.structuredData : enumSet2;
        EnumSet enumSet6 = (i6 & 4194304) != 0 ? scanConfiguration.structuredDataReadableCodeTypes : enumSet3;
        ScanProcessor.ReadabilityLevel readabilityLevel3 = (i6 & 8388608) != 0 ? scanConfiguration.requiredReadabilityLevel : readabilityLevel;
        if ((i6 & 16777216) != 0) {
            readabilityLevel2 = readabilityLevel3;
            z6 = scanConfiguration.useLegacyCameraAPI;
        } else {
            z6 = z5;
            readabilityLevel2 = readabilityLevel3;
        }
        return scanConfiguration.copy(source3, file3, z7, filter2, list2, pdfPageSize2, z8, enumSet4, curvatureCorrectionMode2, orientation2, z9, z10, flashMode2, i7, i8, i9, i10, i11, multiPageFormat2, file4, ocrConfiguration2, enumSet5, enumSet6, readabilityLevel2, z6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Source getSource() {
        return this.source;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Orientation getDefaultScanOrientation() {
        return this.defaultScanOrientation;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getPhotoLibraryButtonHidden() {
        return this.photoLibraryButtonHidden;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getFlashButtonHidden() {
        return this.flashButtonHidden;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final FlashMode getDefaultFlashMode() {
        return this.defaultFlashMode;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final int getForegroundColor() {
        return this.foregroundColor;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final int getHighlightColor() {
        return this.highlightColor;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final int getJpegQuality() {
        return this.jpegQuality;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final int getPdfMaxScanDimension() {
        return this.pdfMaxScanDimension;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final MultiPageFormat getMultiPageFormat() {
        return this.multiPageFormat;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final File getSourceImage() {
        return this.sourceImage;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final File getPdfFontFile() {
        return this.pdfFontFile;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final OcrConfiguration getOcrConfiguration() {
        return this.ocrConfiguration;
    }

    public final EnumSet<StructuredData> component22() {
        return this.structuredData;
    }

    public final EnumSet<ReadableCode.Type> component23() {
        return this.structuredDataReadableCodeTypes;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final ScanProcessor.ReadabilityLevel getRequiredReadabilityLevel() {
        return this.requiredReadabilityLevel;
    }

    /* JADX INFO: renamed from: component25$gssdk_release, reason: from getter */
    public final boolean getUseLegacyCameraAPI() {
        return this.useLegacyCameraAPI;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getMultiPage() {
        return this.multiPage;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Filter getDefaultFilter() {
        return this.defaultFilter;
    }

    public final List<Filter> component5() {
        return this.availableFilters;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final PdfPageSize getPdfPageSize() {
        return this.pdfPageSize;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getSkipPostProcessingScreen() {
        return this.skipPostProcessingScreen;
    }

    public final EnumSet<Action> component8() {
        return this.postProcessingActions;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final CurvatureCorrectionMode getDefaultCurvatureCorrection() {
        return this.defaultCurvatureCorrection;
    }

    public final ScanConfiguration copy(Source source, File sourceImage, boolean multiPage, Filter defaultFilter, List<? extends Filter> availableFilters, PdfPageSize pdfPageSize, boolean skipPostProcessingScreen, EnumSet<Action> postProcessingActions, CurvatureCorrectionMode defaultCurvatureCorrection, Orientation defaultScanOrientation, boolean photoLibraryButtonHidden, boolean flashButtonHidden, FlashMode defaultFlashMode, int backgroundColor, int foregroundColor, int highlightColor, int jpegQuality, int pdfMaxScanDimension, MultiPageFormat multiPageFormat, File pdfFontFile, OcrConfiguration ocrConfiguration, EnumSet<StructuredData> structuredData, EnumSet<ReadableCode.Type> structuredDataReadableCodeTypes, ScanProcessor.ReadabilityLevel requiredReadabilityLevel, boolean useLegacyCameraAPI) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(defaultFilter, "defaultFilter");
        Intrinsics.checkNotNullParameter(availableFilters, "availableFilters");
        Intrinsics.checkNotNullParameter(pdfPageSize, "pdfPageSize");
        Intrinsics.checkNotNullParameter(postProcessingActions, "postProcessingActions");
        Intrinsics.checkNotNullParameter(defaultCurvatureCorrection, "defaultCurvatureCorrection");
        Intrinsics.checkNotNullParameter(defaultScanOrientation, "defaultScanOrientation");
        Intrinsics.checkNotNullParameter(defaultFlashMode, "defaultFlashMode");
        Intrinsics.checkNotNullParameter(multiPageFormat, "multiPageFormat");
        Intrinsics.checkNotNullParameter(structuredData, "structuredData");
        Intrinsics.checkNotNullParameter(structuredDataReadableCodeTypes, "structuredDataReadableCodeTypes");
        Intrinsics.checkNotNullParameter(requiredReadabilityLevel, "requiredReadabilityLevel");
        return new ScanConfiguration(source, sourceImage, multiPage, defaultFilter, availableFilters, pdfPageSize, skipPostProcessingScreen, postProcessingActions, defaultCurvatureCorrection, defaultScanOrientation, photoLibraryButtonHidden, flashButtonHidden, defaultFlashMode, backgroundColor, foregroundColor, highlightColor, jpegQuality, pdfMaxScanDimension, multiPageFormat, pdfFontFile, ocrConfiguration, structuredData, structuredDataReadableCodeTypes, requiredReadabilityLevel, useLegacyCameraAPI);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScanConfiguration)) {
            return false;
        }
        ScanConfiguration scanConfiguration = (ScanConfiguration) other;
        return this.source == scanConfiguration.source && Intrinsics.areEqual(this.sourceImage, scanConfiguration.sourceImage) && this.multiPage == scanConfiguration.multiPage && this.defaultFilter == scanConfiguration.defaultFilter && Intrinsics.areEqual(this.availableFilters, scanConfiguration.availableFilters) && this.pdfPageSize == scanConfiguration.pdfPageSize && this.skipPostProcessingScreen == scanConfiguration.skipPostProcessingScreen && Intrinsics.areEqual(this.postProcessingActions, scanConfiguration.postProcessingActions) && this.defaultCurvatureCorrection == scanConfiguration.defaultCurvatureCorrection && this.defaultScanOrientation == scanConfiguration.defaultScanOrientation && this.photoLibraryButtonHidden == scanConfiguration.photoLibraryButtonHidden && this.flashButtonHidden == scanConfiguration.flashButtonHidden && this.defaultFlashMode == scanConfiguration.defaultFlashMode && this.backgroundColor == scanConfiguration.backgroundColor && this.foregroundColor == scanConfiguration.foregroundColor && this.highlightColor == scanConfiguration.highlightColor && this.jpegQuality == scanConfiguration.jpegQuality && this.pdfMaxScanDimension == scanConfiguration.pdfMaxScanDimension && this.multiPageFormat == scanConfiguration.multiPageFormat && Intrinsics.areEqual(this.pdfFontFile, scanConfiguration.pdfFontFile) && Intrinsics.areEqual(this.ocrConfiguration, scanConfiguration.ocrConfiguration) && Intrinsics.areEqual(this.structuredData, scanConfiguration.structuredData) && Intrinsics.areEqual(this.structuredDataReadableCodeTypes, scanConfiguration.structuredDataReadableCodeTypes) && this.requiredReadabilityLevel == scanConfiguration.requiredReadabilityLevel && this.useLegacyCameraAPI == scanConfiguration.useLegacyCameraAPI;
    }

    public int hashCode() {
        int iHashCode = this.source.hashCode() * 31;
        File file = this.sourceImage;
        int iHashCode2 = (((((((((((((((((((((((((((((((((((iHashCode + (file == null ? 0 : file.hashCode())) * 31) + Boolean.hashCode(this.multiPage)) * 31) + this.defaultFilter.hashCode()) * 31) + this.availableFilters.hashCode()) * 31) + this.pdfPageSize.hashCode()) * 31) + Boolean.hashCode(this.skipPostProcessingScreen)) * 31) + this.postProcessingActions.hashCode()) * 31) + this.defaultCurvatureCorrection.hashCode()) * 31) + this.defaultScanOrientation.hashCode()) * 31) + Boolean.hashCode(this.photoLibraryButtonHidden)) * 31) + Boolean.hashCode(this.flashButtonHidden)) * 31) + this.defaultFlashMode.hashCode()) * 31) + Integer.hashCode(this.backgroundColor)) * 31) + Integer.hashCode(this.foregroundColor)) * 31) + Integer.hashCode(this.highlightColor)) * 31) + Integer.hashCode(this.jpegQuality)) * 31) + Integer.hashCode(this.pdfMaxScanDimension)) * 31) + this.multiPageFormat.hashCode()) * 31;
        File file2 = this.pdfFontFile;
        int iHashCode3 = (iHashCode2 + (file2 == null ? 0 : file2.hashCode())) * 31;
        OcrConfiguration ocrConfiguration = this.ocrConfiguration;
        return ((((((((iHashCode3 + (ocrConfiguration != null ? ocrConfiguration.hashCode() : 0)) * 31) + this.structuredData.hashCode()) * 31) + this.structuredDataReadableCodeTypes.hashCode()) * 31) + this.requiredReadabilityLevel.hashCode()) * 31) + Boolean.hashCode(this.useLegacyCameraAPI);
    }

    public String toString() {
        return "ScanConfiguration(source=" + this.source + ", sourceImage=" + this.sourceImage + ", multiPage=" + this.multiPage + ", defaultFilter=" + this.defaultFilter + ", availableFilters=" + this.availableFilters + ", pdfPageSize=" + this.pdfPageSize + ", skipPostProcessingScreen=" + this.skipPostProcessingScreen + ", postProcessingActions=" + this.postProcessingActions + ", defaultCurvatureCorrection=" + this.defaultCurvatureCorrection + ", defaultScanOrientation=" + this.defaultScanOrientation + ", photoLibraryButtonHidden=" + this.photoLibraryButtonHidden + ", flashButtonHidden=" + this.flashButtonHidden + ", defaultFlashMode=" + this.defaultFlashMode + ", backgroundColor=" + this.backgroundColor + ", foregroundColor=" + this.foregroundColor + ", highlightColor=" + this.highlightColor + ", jpegQuality=" + this.jpegQuality + ", pdfMaxScanDimension=" + this.pdfMaxScanDimension + ", multiPageFormat=" + this.multiPageFormat + ", pdfFontFile=" + this.pdfFontFile + ", ocrConfiguration=" + this.ocrConfiguration + ", structuredData=" + this.structuredData + ", structuredDataReadableCodeTypes=" + this.structuredDataReadableCodeTypes + ", requiredReadabilityLevel=" + this.requiredReadabilityLevel + ", useLegacyCameraAPI=" + this.useLegacyCameraAPI + ")";
    }

    public ScanConfiguration(Source source, File file, boolean z, Filter defaultFilter, List<? extends Filter> availableFilters, PdfPageSize pdfPageSize, boolean z2, EnumSet<Action> postProcessingActions, CurvatureCorrectionMode defaultCurvatureCorrection, Orientation defaultScanOrientation, boolean z3, boolean z4, FlashMode defaultFlashMode, int i, int i2, int i3, int i4, int i5, MultiPageFormat multiPageFormat, File file2, OcrConfiguration ocrConfiguration, EnumSet<StructuredData> structuredData, EnumSet<ReadableCode.Type> structuredDataReadableCodeTypes, ScanProcessor.ReadabilityLevel requiredReadabilityLevel, boolean z5) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(defaultFilter, "defaultFilter");
        Intrinsics.checkNotNullParameter(availableFilters, "availableFilters");
        Intrinsics.checkNotNullParameter(pdfPageSize, "pdfPageSize");
        Intrinsics.checkNotNullParameter(postProcessingActions, "postProcessingActions");
        Intrinsics.checkNotNullParameter(defaultCurvatureCorrection, "defaultCurvatureCorrection");
        Intrinsics.checkNotNullParameter(defaultScanOrientation, "defaultScanOrientation");
        Intrinsics.checkNotNullParameter(defaultFlashMode, "defaultFlashMode");
        Intrinsics.checkNotNullParameter(multiPageFormat, "multiPageFormat");
        Intrinsics.checkNotNullParameter(structuredData, "structuredData");
        Intrinsics.checkNotNullParameter(structuredDataReadableCodeTypes, "structuredDataReadableCodeTypes");
        Intrinsics.checkNotNullParameter(requiredReadabilityLevel, "requiredReadabilityLevel");
        this.source = source;
        this.sourceImage = file;
        this.multiPage = z;
        this.defaultFilter = defaultFilter;
        this.availableFilters = availableFilters;
        this.pdfPageSize = pdfPageSize;
        this.skipPostProcessingScreen = z2;
        this.postProcessingActions = postProcessingActions;
        this.defaultCurvatureCorrection = defaultCurvatureCorrection;
        this.defaultScanOrientation = defaultScanOrientation;
        this.photoLibraryButtonHidden = z3;
        this.flashButtonHidden = z4;
        this.defaultFlashMode = defaultFlashMode;
        this.backgroundColor = i;
        this.foregroundColor = i2;
        this.highlightColor = i3;
        this.jpegQuality = i4;
        this.pdfMaxScanDimension = i5;
        this.multiPageFormat = multiPageFormat;
        this.pdfFontFile = file2;
        this.ocrConfiguration = ocrConfiguration;
        this.structuredData = structuredData;
        this.structuredDataReadableCodeTypes = structuredDataReadableCodeTypes;
        this.requiredReadabilityLevel = requiredReadabilityLevel;
        this.useLegacyCameraAPI = z5;
    }

    public /* synthetic */ ScanConfiguration(Source source, File file, boolean z, Filter filter, List list, PdfPageSize pdfPageSize, boolean z2, EnumSet enumSet, CurvatureCorrectionMode curvatureCorrectionMode, Orientation orientation, boolean z3, boolean z4, FlashMode flashMode, int i, int i2, int i3, int i4, int i5, MultiPageFormat multiPageFormat, File file2, OcrConfiguration ocrConfiguration, EnumSet enumSet2, EnumSet enumSet3, ScanProcessor.ReadabilityLevel readabilityLevel, boolean z5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? Source.CAMERA : source, (i6 & 2) != 0 ? null : file, (i6 & 4) != 0 ? true : z, (i6 & 8) != 0 ? Filter.AUTOMATIC : filter, (i6 & 16) != 0 ? CollectionsKt.listOf((Object[]) new Filter[]{Filter.NONE, Filter.AUTOMATIC, Filter.AUTOMATIC_MONOCHROME, Filter.AUTOMATIC_BLACK_AND_WHITE, Filter.AUTOMATIC_COLOR, Filter.PHOTO}) : list, (i6 & 32) != 0 ? PdfPageSize.FIT : pdfPageSize, (i6 & 64) != 0 ? false : z2, (i6 & 128) != 0 ? Action.ALL : enumSet, (i6 & 256) != 0 ? CurvatureCorrectionMode.DISABLED : curvatureCorrectionMode, (i6 & 512) != 0 ? Orientation.AUTOMATIC : orientation, (i6 & 1024) != 0 ? false : z3, (i6 & 2048) != 0 ? false : z4, (i6 & 4096) != 0 ? FlashMode.OFF : flashMode, (i6 & 8192) != 0 ? -16777216 : i, (i6 & 16384) != 0 ? -1 : i2, (i6 & 32768) != 0 ? -16776961 : i3, (i6 & 65536) != 0 ? 60 : i4, (i6 & 131072) != 0 ? 0 : i5, (i6 & 262144) != 0 ? MultiPageFormat.PDF : multiPageFormat, (i6 & 524288) != 0 ? null : file2, (i6 & 1048576) != 0 ? null : ocrConfiguration, (i6 & 2097152) != 0 ? EnumSet.noneOf(StructuredData.class) : enumSet2, (i6 & 4194304) != 0 ? EnumSet.allOf(ReadableCode.Type.class) : enumSet3, (i6 & 8388608) != 0 ? ScanProcessor.ReadabilityLevel.Lowest : readabilityLevel, (i6 & 16777216) != 0 ? false : z5);
    }

    public final boolean getUseLegacyCameraAPI$gssdk_release() {
        return this.useLegacyCameraAPI;
    }

    public final void setUseLegacyCameraAPI$gssdk_release(boolean z) {
        this.useLegacyCameraAPI = z;
    }

    /* JADX INFO: compiled from: ScanConfiguration.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/geniusscansdk/scanflow/ScanConfiguration$Source;", "", "code", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "CAMERA", "IMAGE", "GALLERY", "Companion", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public enum Source {
        CAMERA("camera"),
        IMAGE("image"),
        GALLERY("library");

        private final String code;
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        @JvmStatic
        public static final Source fromCode(String str) {
            return INSTANCE.fromCode(str);
        }

        public static EnumEntries<Source> getEntries() {
            return $ENTRIES;
        }

        Source(String str) {
            this.code = str;
        }

        /* JADX INFO: compiled from: ScanConfiguration.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/geniusscansdk/scanflow/ScanConfiguration$Source$Companion;", "", "<init>", "()V", "fromCode", "Lcom/geniusscansdk/scanflow/ScanConfiguration$Source;", "code", "", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Source fromCode(String code) {
                Source next;
                Intrinsics.checkNotNullParameter(code, "code");
                Iterator<Source> it = Source.getEntries().iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!Intrinsics.areEqual(next.code, code));
                Source source = next;
                if (source != null) {
                    return source;
                }
                throw new IllegalArgumentException("Invalid code: " + code);
            }
        }
    }

    /* JADX INFO: compiled from: ScanConfiguration.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001dB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0007J\u0006\u0010\u001b\u001a\u00020\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u001e"}, d2 = {"Lcom/geniusscansdk/scanflow/ScanConfiguration$Filter;", "", "code", "", "labelResId", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "getLabelResId", "()I", "NONE", "AUTOMATIC", "AUTOMATIC_BLACK_AND_WHITE", "BLACK_AND_WHITE", "AUTOMATIC_MONOCHROME", "MONOCHROME", "AUTOMATIC_COLOR", "COLOR", "SOFT_GRAYSCALE", "SOFT_COLOR", "STRONG_MONOCHROME", "STRONG_GRAYSCALE", "STRONG_COLOR", "DARK_BACKGROUND", "PHOTO", "toFilterType", "Lcom/geniusscansdk/core/FilterType;", "toEnhancement", "Lcom/geniusscansdk/core/ScanProcessor$Enhancement;", "Companion", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public enum Filter {
        NONE("none", R.string.gssdk_filter_none),
        AUTOMATIC("automatic", R.string.gssdk_filter_automatic),
        AUTOMATIC_BLACK_AND_WHITE("automaticBlackAndWhite", R.string.gssdk_filter_automatic_black_and_white),
        BLACK_AND_WHITE("blackAndWhite", R.string.gssdk_filter_black_and_white),
        AUTOMATIC_MONOCHROME("automaticMonochrome", R.string.gssdk_filter_automatic_monochrome),
        MONOCHROME("monochrome", R.string.gssdk_filter_monochrome),
        AUTOMATIC_COLOR("automaticColor", R.string.gssdk_filter_automatic_color),
        COLOR("color", R.string.gssdk_filter_color),
        SOFT_GRAYSCALE("softBlackAndWhite", R.string.gssdk_filter_soft_black_and_white),
        SOFT_COLOR("softColor", R.string.gssdk_filter_soft_color),
        STRONG_MONOCHROME("strongMonochrome", R.string.gssdk_filter_strong_monochrome),
        STRONG_GRAYSCALE("strongBlackAndWhite", R.string.gssdk_filter_strong_black_and_white),
        STRONG_COLOR("strongColor", R.string.gssdk_filter_strong_color),
        DARK_BACKGROUND("darkBackground", R.string.gssdk_filter_dark_background),
        PHOTO("photo", R.string.gssdk_filter_photo);

        private final String code;
        private final int labelResId;
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* JADX INFO: compiled from: ScanConfiguration.kt */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Filter.values().length];
                try {
                    iArr[Filter.NONE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Filter.BLACK_AND_WHITE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Filter.MONOCHROME.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[Filter.COLOR.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[Filter.PHOTO.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[Filter.AUTOMATIC.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[Filter.AUTOMATIC_MONOCHROME.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr[Filter.AUTOMATIC_BLACK_AND_WHITE.ordinal()] = 8;
                } catch (NoSuchFieldError unused8) {
                }
                try {
                    iArr[Filter.AUTOMATIC_COLOR.ordinal()] = 9;
                } catch (NoSuchFieldError unused9) {
                }
                try {
                    iArr[Filter.SOFT_GRAYSCALE.ordinal()] = 10;
                } catch (NoSuchFieldError unused10) {
                }
                try {
                    iArr[Filter.SOFT_COLOR.ordinal()] = 11;
                } catch (NoSuchFieldError unused11) {
                }
                try {
                    iArr[Filter.STRONG_MONOCHROME.ordinal()] = 12;
                } catch (NoSuchFieldError unused12) {
                }
                try {
                    iArr[Filter.STRONG_GRAYSCALE.ordinal()] = 13;
                } catch (NoSuchFieldError unused13) {
                }
                try {
                    iArr[Filter.STRONG_COLOR.ordinal()] = 14;
                } catch (NoSuchFieldError unused14) {
                }
                try {
                    iArr[Filter.DARK_BACKGROUND.ordinal()] = 15;
                } catch (NoSuchFieldError unused15) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        @JvmStatic
        public static final Filter fromCode(String str) {
            return INSTANCE.fromCode(str);
        }

        public static EnumEntries<Filter> getEntries() {
            return $ENTRIES;
        }

        Filter(String str, int i) {
            this.code = str;
            this.labelResId = i;
        }

        public final int getLabelResId() {
            return this.labelResId;
        }

        @Deprecated(message = "use toEnhancement()", replaceWith = @ReplaceWith(expression = "toEnhancement()", imports = {}))
        public final FilterType toFilterType() {
            int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
            if (i == 1) {
                return FilterType.NONE;
            }
            if (i == 2) {
                return FilterType.BLACK_WHITE;
            }
            if (i == 3) {
                return FilterType.MONOCHROME;
            }
            if (i == 4) {
                return FilterType.COLOR;
            }
            if (i != 5) {
                return null;
            }
            return FilterType.PHOTO;
        }

        public final ScanProcessor.Enhancement toEnhancement() {
            switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
                case 1:
                    return ScanProcessor.Enhancement.INSTANCE.withFilterConfiguration(FilterConfiguration.INSTANCE.noOp());
                case 2:
                case 8:
                    return ScanProcessor.Enhancement.INSTANCE.automatic(ScanProcessor.FilterStyle.DOCUMENT, FilterConfiguration.Color.Palette.GRAYSCALE);
                case 3:
                case 7:
                    return ScanProcessor.Enhancement.INSTANCE.automatic(ScanProcessor.FilterStyle.DOCUMENT, FilterConfiguration.Color.Palette.MONOCHROME);
                case 4:
                case 9:
                    return ScanProcessor.Enhancement.INSTANCE.automatic(ScanProcessor.FilterStyle.DOCUMENT, FilterConfiguration.Color.Palette.COLOR);
                case 5:
                    return ScanProcessor.Enhancement.INSTANCE.withFilterConfiguration(FilterConfiguration.INSTANCE.photo());
                case 6:
                    return ScanProcessor.Enhancement.Companion.automatic$default(ScanProcessor.Enhancement.INSTANCE, null, 1, null);
                case 10:
                    return ScanProcessor.Enhancement.INSTANCE.withFilterConfiguration(FilterConfiguration.INSTANCE.softGrayscale());
                case 11:
                    return ScanProcessor.Enhancement.INSTANCE.withFilterConfiguration(FilterConfiguration.INSTANCE.softColor());
                case 12:
                    return ScanProcessor.Enhancement.INSTANCE.withFilterConfiguration(FilterConfiguration.INSTANCE.strongMonochrome());
                case 13:
                    return ScanProcessor.Enhancement.INSTANCE.withFilterConfiguration(FilterConfiguration.INSTANCE.strongGrayscale());
                case 14:
                    return ScanProcessor.Enhancement.INSTANCE.withFilterConfiguration(FilterConfiguration.INSTANCE.strongColor());
                case 15:
                    return ScanProcessor.Enhancement.INSTANCE.withFilterConfiguration(FilterConfiguration.INSTANCE.darkBackground());
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }

        /* JADX INFO: compiled from: ScanConfiguration.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/geniusscansdk/scanflow/ScanConfiguration$Filter$Companion;", "", "<init>", "()V", "fromCode", "Lcom/geniusscansdk/scanflow/ScanConfiguration$Filter;", "code", "", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Filter fromCode(String code) {
                Filter next;
                Intrinsics.checkNotNullParameter(code, "code");
                Iterator<Filter> it = Filter.getEntries().iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!Intrinsics.areEqual(next.code, code));
                Filter filter = next;
                if (filter != null) {
                    return filter;
                }
                throw new IllegalArgumentException("Invalid code: " + code);
            }
        }
    }

    /* JADX INFO: compiled from: ScanConfiguration.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007j\u0002\b\u0004j\u0002\b\u0005¨\u0006\b"}, d2 = {"Lcom/geniusscansdk/scanflow/ScanConfiguration$Orientation;", "", "<init>", "(Ljava/lang/String;I)V", "ORIGINAL", "AUTOMATIC", "toRotationConfiguration", "Lcom/geniusscansdk/core/ScanProcessor$Rotation;", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public enum Orientation {
        ORIGINAL,
        AUTOMATIC;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        /* JADX INFO: compiled from: ScanConfiguration.kt */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Orientation.values().length];
                try {
                    iArr[Orientation.ORIGINAL.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Orientation.AUTOMATIC.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public static EnumEntries<Orientation> getEntries() {
            return $ENTRIES;
        }

        public final ScanProcessor.Rotation toRotationConfiguration() {
            int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
            if (i == 1) {
                return ScanProcessor.Rotation.INSTANCE.none();
            }
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            return ScanProcessor.Rotation.INSTANCE.automatic();
        }
    }

    /* JADX INFO: compiled from: ScanConfiguration.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\n\u001a\u00020\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\f"}, d2 = {"Lcom/geniusscansdk/scanflow/ScanConfiguration$CurvatureCorrectionMode;", "", "label", "", "<init>", "(Ljava/lang/String;II)V", "getLabel$gssdk_release", "()I", "ENABLED", "DISABLED", "toCurvatureCorrectionConfiguration", "Lcom/geniusscansdk/core/ScanProcessor$CurvatureCorrection;", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public enum CurvatureCorrectionMode {
        ENABLED(R.string.gssdk_on),
        DISABLED(R.string.gssdk_off);

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
        private final int label;

        /* JADX INFO: compiled from: ScanConfiguration.kt */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[CurvatureCorrectionMode.values().length];
                try {
                    iArr[CurvatureCorrectionMode.DISABLED.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[CurvatureCorrectionMode.ENABLED.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public static EnumEntries<CurvatureCorrectionMode> getEntries() {
            return $ENTRIES;
        }

        CurvatureCorrectionMode(int i) {
            this.label = i;
        }

        /* JADX INFO: renamed from: getLabel$gssdk_release, reason: from getter */
        public final int getLabel() {
            return this.label;
        }

        public final ScanProcessor.CurvatureCorrection toCurvatureCorrectionConfiguration() {
            int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
            if (i == 1) {
                return ScanProcessor.CurvatureCorrection.INSTANCE.none();
            }
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            return ScanProcessor.CurvatureCorrection.INSTANCE.create(true);
        }
    }

    /* JADX INFO: compiled from: ScanConfiguration.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\f"}, d2 = {"Lcom/geniusscansdk/scanflow/ScanConfiguration$PdfPageSize;", "", "code", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "A4", "LETTER", "FIT", "toPDFSize", "Lcom/geniusscansdk/pdf/PDFSize;", "Companion", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public enum PdfPageSize {
        A4("a4"),
        LETTER("letter"),
        FIT("fit");

        private final String code;
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* JADX INFO: compiled from: ScanConfiguration.kt */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[PdfPageSize.values().length];
                try {
                    iArr[PdfPageSize.A4.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[PdfPageSize.LETTER.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[PdfPageSize.FIT.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        @JvmStatic
        public static final PdfPageSize fromCode(String str) {
            return INSTANCE.fromCode(str);
        }

        public static EnumEntries<PdfPageSize> getEntries() {
            return $ENTRIES;
        }

        PdfPageSize(String str) {
            this.code = str;
        }

        public final PDFSize toPDFSize() {
            int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
            if (i == 1) {
                return new PDFSize(8.27d, 11.7d);
            }
            if (i == 2) {
                return new PDFSize(8.5d, 11.0d);
            }
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            return new PDFSize(8.27d, 0.0d);
        }

        /* JADX INFO: compiled from: ScanConfiguration.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/geniusscansdk/scanflow/ScanConfiguration$PdfPageSize$Companion;", "", "<init>", "()V", "fromCode", "Lcom/geniusscansdk/scanflow/ScanConfiguration$PdfPageSize;", "code", "", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final PdfPageSize fromCode(String code) {
                PdfPageSize next;
                Intrinsics.checkNotNullParameter(code, "code");
                Iterator<PdfPageSize> it = PdfPageSize.getEntries().iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!Intrinsics.areEqual(next.code, code));
                PdfPageSize pdfPageSize = next;
                if (pdfPageSize != null) {
                    return pdfPageSize;
                }
                throw new IllegalArgumentException("Invalid code: " + code);
            }
        }
    }

    /* JADX INFO: compiled from: ScanConfiguration.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/geniusscansdk/scanflow/ScanConfiguration$Action;", "", "code", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "ROTATE", "EDIT_FILTER", "CORRECT_DISTORTION", "Companion", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public enum Action {
        ROTATE("rotate"),
        EDIT_FILTER("editFilter"),
        CORRECT_DISTORTION("correctDistortion");

        public static final EnumSet<Action> ALL;
        private final String code;
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        @JvmStatic
        public static final EnumSet<Action> fromCodes(List<String> list) {
            return INSTANCE.fromCodes(list);
        }

        public static EnumEntries<Action> getEntries() {
            return $ENTRIES;
        }

        Action(String str) {
            this.code = str;
        }

        static {
            EnumSet<Action> enumSetAllOf = EnumSet.allOf(Action.class);
            Intrinsics.checkNotNullExpressionValue(enumSetAllOf, "allOf(...)");
            ALL = enumSetAllOf;
        }

        /* JADX INFO: compiled from: ScanConfiguration.kt */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/geniusscansdk/scanflow/ScanConfiguration$Action$Companion;", "", "<init>", "()V", Rule.ALL, "Ljava/util/EnumSet;", "Lcom/geniusscansdk/scanflow/ScanConfiguration$Action;", "fromCodes", "codes", "", "", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final EnumSet<Action> fromCodes(List<String> codes) {
                Action next;
                Intrinsics.checkNotNullParameter(codes, "codes");
                EnumSet<Action> enumSetNoneOf = EnumSet.noneOf(Action.class);
                List<String> list = codes;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                for (String str : list) {
                    Iterator<Action> it = Action.getEntries().iterator();
                    do {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                    } while (!Intrinsics.areEqual(next.code, str));
                    Action action = next;
                    if (action == null) {
                        throw new IllegalArgumentException("Invalid code: " + str);
                    }
                    arrayList.add(action);
                }
                enumSetNoneOf.addAll(arrayList);
                Intrinsics.checkNotNullExpressionValue(enumSetNoneOf, "also(...)");
                return enumSetNoneOf;
            }
        }
    }

    /* JADX INFO: compiled from: ScanConfiguration.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0013B)\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\b\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000ej\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0014"}, d2 = {"Lcom/geniusscansdk/scanflow/ScanConfiguration$FlashMode;", "", "code", "", "internalMode", "Lcom/geniusscansdk/camera/FlashMode;", "iconResId", "", "label", "<init>", "(Ljava/lang/String;ILjava/lang/String;Lcom/geniusscansdk/camera/FlashMode;II)V", "getInternalMode$gssdk_release", "()Lcom/geniusscansdk/camera/FlashMode;", "getIconResId$gssdk_release", "()I", "getLabel$gssdk_release", "AUTO", "ON", "OFF", "Companion", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public enum FlashMode {
        AUTO("auto", com.geniusscansdk.camera.FlashMode.AUTO, R.drawable.ic_flash_auto_white_24dp, R.string.gssdk_flash_mode_auto),
        ON("on", com.geniusscansdk.camera.FlashMode.ON, R.drawable.ic_flash_on_white_24dp, R.string.gssdk_flash_mode_on),
        OFF("off", com.geniusscansdk.camera.FlashMode.OFF, R.drawable.ic_flash_off_white_24dp, R.string.gssdk_flash_mode_off);

        private final String code;
        private final int iconResId;
        private final com.geniusscansdk.camera.FlashMode internalMode;
        private final int label;
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        @JvmStatic
        public static final FlashMode fromCode(String str) {
            return INSTANCE.fromCode(str);
        }

        public static EnumEntries<FlashMode> getEntries() {
            return $ENTRIES;
        }

        FlashMode(String str, com.geniusscansdk.camera.FlashMode flashMode, int i, int i2) {
            this.code = str;
            this.internalMode = flashMode;
            this.iconResId = i;
            this.label = i2;
        }

        /* JADX INFO: renamed from: getInternalMode$gssdk_release, reason: from getter */
        public final com.geniusscansdk.camera.FlashMode getInternalMode() {
            return this.internalMode;
        }

        /* JADX INFO: renamed from: getIconResId$gssdk_release, reason: from getter */
        public final int getIconResId() {
            return this.iconResId;
        }

        /* JADX INFO: renamed from: getLabel$gssdk_release, reason: from getter */
        public final int getLabel() {
            return this.label;
        }

        /* JADX INFO: compiled from: ScanConfiguration.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/geniusscansdk/scanflow/ScanConfiguration$FlashMode$Companion;", "", "<init>", "()V", "fromCode", "Lcom/geniusscansdk/scanflow/ScanConfiguration$FlashMode;", "code", "", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final FlashMode fromCode(String code) {
                FlashMode next;
                Intrinsics.checkNotNullParameter(code, "code");
                Iterator<FlashMode> it = FlashMode.getEntries().iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!Intrinsics.areEqual(next.code, code));
                FlashMode flashMode = next;
                if (flashMode != null) {
                    return flashMode;
                }
                throw new IllegalArgumentException("Invalid code: " + code);
            }
        }
    }

    /* JADX INFO: compiled from: ScanConfiguration.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/geniusscansdk/scanflow/ScanConfiguration$MultiPageFormat;", "", "code", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "NONE", "PDF", "TIFF", "Companion", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public enum MultiPageFormat {
        NONE("none"),
        PDF("pdf"),
        TIFF("tiff");

        private final String code;
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        @JvmStatic
        public static final MultiPageFormat fromCode(String str) {
            return INSTANCE.fromCode(str);
        }

        public static EnumEntries<MultiPageFormat> getEntries() {
            return $ENTRIES;
        }

        MultiPageFormat(String str) {
            this.code = str;
        }

        /* JADX INFO: compiled from: ScanConfiguration.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/geniusscansdk/scanflow/ScanConfiguration$MultiPageFormat$Companion;", "", "<init>", "()V", "fromCode", "Lcom/geniusscansdk/scanflow/ScanConfiguration$MultiPageFormat;", "code", "", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final MultiPageFormat fromCode(String code) {
                MultiPageFormat next;
                Intrinsics.checkNotNullParameter(code, "code");
                Iterator<MultiPageFormat> it = MultiPageFormat.getEntries().iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!Intrinsics.areEqual(next.code, code));
                MultiPageFormat multiPageFormat = next;
                if (multiPageFormat != null) {
                    return multiPageFormat;
                }
                throw new IllegalArgumentException("Invalid code: " + code);
            }
        }
    }

    /* JADX INFO: compiled from: ScanConfiguration.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/geniusscansdk/scanflow/ScanConfiguration$OcrOutputFormat;", "", "code", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "RAW_TEXT", "HOCR", "TEXT_LAYER_IN_PDF", "Companion", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public enum OcrOutputFormat {
        RAW_TEXT("rawText"),
        HOCR("hOCR"),
        TEXT_LAYER_IN_PDF("textLayerInPDF");

        public static final EnumSet<OcrOutputFormat> ALL;
        private final String code;
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        @JvmStatic
        public static final EnumSet<OcrOutputFormat> fromCodes(List<String> list) {
            return INSTANCE.fromCodes(list);
        }

        public static EnumEntries<OcrOutputFormat> getEntries() {
            return $ENTRIES;
        }

        OcrOutputFormat(String str) {
            this.code = str;
        }

        static {
            EnumSet<OcrOutputFormat> enumSetAllOf = EnumSet.allOf(OcrOutputFormat.class);
            Intrinsics.checkNotNullExpressionValue(enumSetAllOf, "allOf(...)");
            ALL = enumSetAllOf;
        }

        /* JADX INFO: compiled from: ScanConfiguration.kt */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/geniusscansdk/scanflow/ScanConfiguration$OcrOutputFormat$Companion;", "", "<init>", "()V", Rule.ALL, "Ljava/util/EnumSet;", "Lcom/geniusscansdk/scanflow/ScanConfiguration$OcrOutputFormat;", "fromCodes", "codes", "", "", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final EnumSet<OcrOutputFormat> fromCodes(List<String> codes) {
                OcrOutputFormat next;
                Intrinsics.checkNotNullParameter(codes, "codes");
                EnumSet<OcrOutputFormat> enumSetNoneOf = EnumSet.noneOf(OcrOutputFormat.class);
                List<String> list = codes;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                for (String str : list) {
                    Iterator<OcrOutputFormat> it = OcrOutputFormat.getEntries().iterator();
                    do {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                    } while (!Intrinsics.areEqual(next.code, str));
                    OcrOutputFormat ocrOutputFormat = next;
                    if (ocrOutputFormat == null) {
                        throw new IllegalArgumentException("Invalid code: " + str);
                    }
                    arrayList.add(ocrOutputFormat);
                }
                enumSetNoneOf.addAll(arrayList);
                Intrinsics.checkNotNullExpressionValue(enumSetNoneOf, "also(...)");
                return enumSetNoneOf;
            }
        }
    }

    /* JADX INFO: compiled from: ScanConfiguration.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/geniusscansdk/scanflow/ScanConfiguration$StructuredData;", "", "code", "", "needsOCR", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Z)V", "getNeedsOCR$gssdk_release", "()Z", "RECEIPT", "READABLE_CODE", "Companion", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public enum StructuredData {
        RECEIPT("receipt", true),
        READABLE_CODE("readableCode", false);

        private final String code;
        private final boolean needsOCR;
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        @JvmStatic
        public static final EnumSet<StructuredData> fromCodes(List<String> list) {
            return INSTANCE.fromCodes(list);
        }

        public static EnumEntries<StructuredData> getEntries() {
            return $ENTRIES;
        }

        StructuredData(String str, boolean z) {
            this.code = str;
            this.needsOCR = z;
        }

        /* JADX INFO: renamed from: getNeedsOCR$gssdk_release, reason: from getter */
        public final boolean getNeedsOCR() {
            return this.needsOCR;
        }

        /* JADX INFO: compiled from: ScanConfiguration.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007¨\u0006\n"}, d2 = {"Lcom/geniusscansdk/scanflow/ScanConfiguration$StructuredData$Companion;", "", "<init>", "()V", "fromCodes", "Ljava/util/EnumSet;", "Lcom/geniusscansdk/scanflow/ScanConfiguration$StructuredData;", "codes", "", "", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final EnumSet<StructuredData> fromCodes(List<String> codes) {
                StructuredData next;
                Intrinsics.checkNotNullParameter(codes, "codes");
                EnumSet<StructuredData> enumSetNoneOf = EnumSet.noneOf(StructuredData.class);
                List<String> list = codes;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                for (String str : list) {
                    Iterator<StructuredData> it = StructuredData.getEntries().iterator();
                    do {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                    } while (!Intrinsics.areEqual(next.code, str));
                    StructuredData structuredData = next;
                    if (structuredData == null) {
                        throw new IllegalArgumentException("Invalid code: " + str);
                    }
                    arrayList.add(structuredData);
                }
                enumSetNoneOf.addAll(arrayList);
                Intrinsics.checkNotNullExpressionValue(enumSetNoneOf, "also(...)");
                return enumSetNoneOf;
            }
        }
    }

    /* JADX INFO: compiled from: ScanConfiguration.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J+\u0010\f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001R\u001a\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/geniusscansdk/scanflow/ScanConfiguration$OcrConfiguration;", "Ljava/io/Serializable;", "languages", "", "", "outputFormats", "Ljava/util/EnumSet;", "Lcom/geniusscansdk/scanflow/ScanConfiguration$OcrOutputFormat;", "<init>", "(Ljava/util/List;Ljava/util/EnumSet;)V", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class OcrConfiguration implements Serializable {
        public List<String> languages;
        public EnumSet<OcrOutputFormat> outputFormats;

        /* JADX WARN: Multi-variable type inference failed */
        public OcrConfiguration() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ OcrConfiguration copy$default(OcrConfiguration ocrConfiguration, List list, EnumSet enumSet, int i, Object obj) {
            if ((i & 1) != 0) {
                list = ocrConfiguration.languages;
            }
            if ((i & 2) != 0) {
                enumSet = ocrConfiguration.outputFormats;
            }
            return ocrConfiguration.copy(list, enumSet);
        }

        public final List<String> component1() {
            return this.languages;
        }

        public final EnumSet<OcrOutputFormat> component2() {
            return this.outputFormats;
        }

        public final OcrConfiguration copy(List<String> languages, EnumSet<OcrOutputFormat> outputFormats) {
            Intrinsics.checkNotNullParameter(outputFormats, "outputFormats");
            return new OcrConfiguration(languages, outputFormats);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OcrConfiguration)) {
                return false;
            }
            OcrConfiguration ocrConfiguration = (OcrConfiguration) other;
            return Intrinsics.areEqual(this.languages, ocrConfiguration.languages) && Intrinsics.areEqual(this.outputFormats, ocrConfiguration.outputFormats);
        }

        public int hashCode() {
            List<String> list = this.languages;
            return ((list == null ? 0 : list.hashCode()) * 31) + this.outputFormats.hashCode();
        }

        public String toString() {
            return "OcrConfiguration(languages=" + this.languages + ", outputFormats=" + this.outputFormats + ")";
        }

        public OcrConfiguration(List<String> list, EnumSet<OcrOutputFormat> outputFormats) {
            Intrinsics.checkNotNullParameter(outputFormats, "outputFormats");
            this.languages = list;
            this.outputFormats = outputFormats;
        }

        public /* synthetic */ OcrConfiguration(List list, EnumSet enumSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : list, (i & 2) != 0 ? OcrOutputFormat.ALL : enumSet);
        }
    }
}
