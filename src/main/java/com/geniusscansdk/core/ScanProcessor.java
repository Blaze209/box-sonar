package com.geniusscansdk.core;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.exifinterface.media.ExifInterface;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.io.File;
import java.util.UUID;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScanProcessor.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \u001e2\u00020\u0001:\f\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001eB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nJ\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u0010J\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00110\f2\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/geniusscansdk/core/ScanProcessor;", "", "documentDetector", "Lcom/geniusscansdk/core/DocumentDetector;", "orientationDetector", "Lcom/geniusscansdk/core/OrientationDetector;", "<init>", "(Lcom/geniusscansdk/core/DocumentDetector;Lcom/geniusscansdk/core/OrientationDetector;)V", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", SemanticAttributes.MessagingOperationValues.PROCESS, "Lcom/geniusscansdk/core/ScanProcessor$Result;", "Ljava/io/File;", "inputImage", "configuration", "Lcom/geniusscansdk/core/ScanProcessor$Configuration;", "Landroid/graphics/Bitmap;", "inBitmap", "PerspectiveCorrection", "CurvatureCorrection", "FilterStyle", "Enhancement", "ReadabilityLevel", "Readability", "Rotation", "OutputFileFormat", "OutputConfiguration", "Configuration", "Result", "Companion", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScanProcessor {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final DocumentDetector documentDetector;
    private final OrientationDetector orientationDetector;

    /* JADX INFO: compiled from: ScanProcessor.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/geniusscansdk/core/ScanProcessor$FilterStyle;", "", "<init>", "(Ljava/lang/String;I)V", "DOCUMENT", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public enum FilterStyle {
        DOCUMENT;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<FilterStyle> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: compiled from: ScanProcessor.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/geniusscansdk/core/ScanProcessor$OutputFileFormat;", "", "<init>", "(Ljava/lang/String;I)V", "AUTO", "JPEG", "PNG", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public enum OutputFileFormat {
        AUTO,
        JPEG,
        PNG;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<OutputFileFormat> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: compiled from: ScanProcessor.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/geniusscansdk/core/ScanProcessor$ReadabilityLevel;", "", "<init>", "(Ljava/lang/String;I)V", "Lowest", "Low", "Medium", "High", "Highest", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public enum ReadabilityLevel {
        Lowest,
        Low,
        Medium,
        High,
        Highest;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<ReadabilityLevel> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native Result<File> GSLProcess(long j, long j2, String str, Configuration<File> configuration) throws LicenseException, ProcessingException;

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native Result<Bitmap> GSLProcessBitmap(long j, long j2, Bitmap bitmap, Configuration<Bitmap> configuration) throws LicenseException, ProcessingException;

    public ScanProcessor(DocumentDetector documentDetector, OrientationDetector orientationDetector) {
        Intrinsics.checkNotNullParameter(documentDetector, "documentDetector");
        Intrinsics.checkNotNullParameter(orientationDetector, "orientationDetector");
        this.documentDetector = documentDetector;
        this.orientationDetector = orientationDetector;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ScanProcessor(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DocumentDetector documentDetectorCreate = DocumentDetector.create(context);
        Intrinsics.checkNotNullExpressionValue(documentDetectorCreate, "create(...)");
        this(documentDetectorCreate, new OrientationDetector(context));
    }

    /* JADX INFO: compiled from: ScanProcessor.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/geniusscansdk/core/ScanProcessor$PerspectiveCorrection;", "", "detectDocument", "", "quadrangle", "Lcom/geniusscansdk/core/Quadrangle;", "<init>", "(ZLcom/geniusscansdk/core/Quadrangle;)V", "Companion", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PerspectiveCorrection {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean detectDocument;
        private final Quadrangle quadrangle;

        public /* synthetic */ PerspectiveCorrection(boolean z, Quadrangle quadrangle, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, quadrangle);
        }

        @JvmStatic
        public static final PerspectiveCorrection automatic() {
            return INSTANCE.automatic();
        }

        @JvmStatic
        public static final PerspectiveCorrection none() {
            return INSTANCE.none();
        }

        @JvmStatic
        public static final PerspectiveCorrection withQuadrangle(Quadrangle quadrangle) {
            return INSTANCE.withQuadrangle(quadrangle);
        }

        private PerspectiveCorrection(boolean z, Quadrangle quadrangle) {
            this.detectDocument = z;
            this.quadrangle = quadrangle;
        }

        /* JADX INFO: compiled from: ScanProcessor.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007J\b\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/geniusscansdk/core/ScanProcessor$PerspectiveCorrection$Companion;", "", "<init>", "()V", "automatic", "Lcom/geniusscansdk/core/ScanProcessor$PerspectiveCorrection;", "none", "withQuadrangle", "quadrangle", "Lcom/geniusscansdk/core/Quadrangle;", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @JvmStatic
            public final PerspectiveCorrection automatic() {
                return new PerspectiveCorrection(true, null, 0 == true ? 1 : 0);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @JvmStatic
            public final PerspectiveCorrection none() {
                return new PerspectiveCorrection(false, null, 0 == true ? 1 : 0);
            }

            @JvmStatic
            public final PerspectiveCorrection withQuadrangle(Quadrangle quadrangle) {
                Intrinsics.checkNotNullParameter(quadrangle, "quadrangle");
                return new PerspectiveCorrection(false, quadrangle, null);
            }
        }
    }

    /* JADX INFO: compiled from: ScanProcessor.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/geniusscansdk/core/ScanProcessor$CurvatureCorrection;", "", "correctCurvature", "", "<init>", "(Z)V", "Companion", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CurvatureCorrection {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean correctCurvature;

        public /* synthetic */ CurvatureCorrection(boolean z, DefaultConstructorMarker defaultConstructorMarker) {
            this(z);
        }

        @JvmStatic
        public static final CurvatureCorrection automatic() {
            return INSTANCE.automatic();
        }

        @JvmStatic
        public static final CurvatureCorrection create(boolean z) {
            return INSTANCE.create(z);
        }

        @JvmStatic
        public static final CurvatureCorrection none() {
            return INSTANCE.none();
        }

        /* JADX INFO: compiled from: ScanProcessor.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007J\b\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/geniusscansdk/core/ScanProcessor$CurvatureCorrection$Companion;", "", "<init>", "()V", "none", "Lcom/geniusscansdk/core/ScanProcessor$CurvatureCorrection;", "automatic", PasskeyWebListener.CREATE_UNIQUE_KEY, "correctCurvature", "", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final CurvatureCorrection none() {
                return new CurvatureCorrection(false, null);
            }

            @JvmStatic
            public final CurvatureCorrection automatic() {
                return new CurvatureCorrection(false, null);
            }

            @JvmStatic
            public final CurvatureCorrection create(boolean correctCurvature) {
                return new CurvatureCorrection(correctCurvature, null);
            }
        }

        private CurvatureCorrection(boolean z) {
            this.correctCurvature = z;
        }
    }

    /* JADX INFO: compiled from: ScanProcessor.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eBC\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/geniusscansdk/core/ScanProcessor$Enhancement;", "", "detectBestFilter", "", "filterStyle", "Lcom/geniusscansdk/core/ScanProcessor$FilterStyle;", "colorPalette", "Lcom/geniusscansdk/core/FilterConfiguration$Color$Palette;", "filterConfiguration", "Lcom/geniusscansdk/core/FilterConfiguration;", "legacyFilter", "Lcom/geniusscansdk/core/FilterType;", "<init>", "(ZLcom/geniusscansdk/core/ScanProcessor$FilterStyle;Lcom/geniusscansdk/core/FilterConfiguration$Color$Palette;Lcom/geniusscansdk/core/FilterConfiguration;Lcom/geniusscansdk/core/FilterType;)V", "Companion", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Enhancement {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final FilterConfiguration.Color.Palette colorPalette;
        private final boolean detectBestFilter;
        private final FilterConfiguration filterConfiguration;
        private final FilterStyle filterStyle;
        private final FilterType legacyFilter;

        @JvmStatic
        public static final Enhancement automatic() {
            return INSTANCE.automatic();
        }

        @JvmStatic
        public static final Enhancement automatic(FilterConfiguration.Color.Palette palette) {
            return INSTANCE.automatic(palette);
        }

        @JvmStatic
        public static final Enhancement automatic(FilterStyle filterStyle) {
            return INSTANCE.automatic(filterStyle);
        }

        @JvmStatic
        public static final Enhancement automatic(FilterStyle filterStyle, FilterConfiguration.Color.Palette palette) {
            return INSTANCE.automatic(filterStyle, palette);
        }

        @JvmStatic
        public static final Enhancement none() {
            return INSTANCE.none();
        }

        @Deprecated(message = "Use withFilterConfiguration(FilterConfiguration)")
        @JvmStatic
        public static final Enhancement withFilter(FilterType filterType) {
            return INSTANCE.withFilter(filterType);
        }

        @Deprecated(message = "Use withFilterConfiguration(FilterConfiguration)")
        @JvmStatic
        public static final Enhancement withFilter(FilterType filterType, boolean z) {
            return INSTANCE.withFilter(filterType, z);
        }

        @JvmStatic
        public static final Enhancement withFilterConfiguration(FilterConfiguration filterConfiguration) {
            return INSTANCE.withFilterConfiguration(filterConfiguration);
        }

        private Enhancement(boolean z, FilterStyle filterStyle, FilterConfiguration.Color.Palette palette, FilterConfiguration filterConfiguration, FilterType filterType) {
            this.detectBestFilter = z;
            this.filterStyle = filterStyle;
            this.colorPalette = palette;
            this.filterConfiguration = filterConfiguration;
            this.legacyFilter = filterType;
        }

        /* synthetic */ Enhancement(boolean z, FilterStyle filterStyle, FilterConfiguration.Color.Palette palette, FilterConfiguration filterConfiguration, FilterType filterType, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : filterStyle, (i & 4) != 0 ? null : palette, (i & 8) != 0 ? null : filterConfiguration, (i & 16) != 0 ? null : filterType);
        }

        /* JADX INFO: compiled from: ScanProcessor.kt */
        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\u0014\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\b\u0010\n\u001a\u00020\u0005H\u0007J\u001a\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0007¨\u0006\u0013"}, d2 = {"Lcom/geniusscansdk/core/ScanProcessor$Enhancement$Companion;", "", "<init>", "()V", "automatic", "Lcom/geniusscansdk/core/ScanProcessor$Enhancement;", "filterStyle", "Lcom/geniusscansdk/core/ScanProcessor$FilterStyle;", "colorPalette", "Lcom/geniusscansdk/core/FilterConfiguration$Color$Palette;", "none", "withFilter", "filterType", "Lcom/geniusscansdk/core/FilterType;", "cleanEdges", "", "withFilterConfiguration", "filterConfiguration", "Lcom/geniusscansdk/core/FilterConfiguration;", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            public final Enhancement automatic() {
                return automatic$default(this, null, null, 3, null);
            }

            @JvmStatic
            public final Enhancement automatic(FilterStyle filterStyle) {
                return automatic$default(this, filterStyle, null, 2, null);
            }

            @Deprecated(message = "Use withFilterConfiguration(FilterConfiguration)")
            @JvmStatic
            public final Enhancement withFilter(FilterType filterType) {
                Intrinsics.checkNotNullParameter(filterType, "filterType");
                return withFilter$default(this, filterType, false, 2, null);
            }

            private Companion() {
            }

            public static /* synthetic */ Enhancement automatic$default(Companion companion, FilterStyle filterStyle, FilterConfiguration.Color.Palette palette, int i, Object obj) {
                if ((i & 1) != 0) {
                    filterStyle = null;
                }
                if ((i & 2) != 0) {
                    palette = null;
                }
                return companion.automatic(filterStyle, palette);
            }

            @JvmStatic
            public final Enhancement automatic(FilterStyle filterStyle, FilterConfiguration.Color.Palette colorPalette) {
                return new Enhancement(true, filterStyle, colorPalette, null, null, 24, null);
            }

            public static /* synthetic */ Enhancement automatic$default(Companion companion, FilterConfiguration.Color.Palette palette, int i, Object obj) {
                if ((i & 1) != 0) {
                    palette = null;
                }
                return companion.automatic(palette);
            }

            @JvmStatic
            public final Enhancement automatic(FilterConfiguration.Color.Palette colorPalette) {
                return automatic(null, colorPalette);
            }

            @JvmStatic
            public final Enhancement none() {
                return new Enhancement(false, null, null, null, null, 31, null);
            }

            public static /* synthetic */ Enhancement withFilter$default(Companion companion, FilterType filterType, boolean z, int i, Object obj) {
                if ((i & 2) != 0) {
                    z = true;
                }
                return companion.withFilter(filterType, z);
            }

            @Deprecated(message = "Use withFilterConfiguration(FilterConfiguration)")
            @JvmStatic
            public final Enhancement withFilter(FilterType filterType, boolean cleanEdges) {
                Intrinsics.checkNotNullParameter(filterType, "filterType");
                return new Enhancement(false, null, null, null, filterType, 15, null);
            }

            @JvmStatic
            public final Enhancement withFilterConfiguration(FilterConfiguration filterConfiguration) {
                Intrinsics.checkNotNullParameter(filterConfiguration, "filterConfiguration");
                return new Enhancement(false, null, null, filterConfiguration, null, 23, null);
            }
        }
    }

    /* JADX INFO: compiled from: ScanProcessor.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/geniusscansdk/core/ScanProcessor$Readability;", "", "enabled", "", "<init>", "(Z)V", "Companion", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Readability {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean enabled;

        public /* synthetic */ Readability(boolean z, DefaultConstructorMarker defaultConstructorMarker) {
            this(z);
        }

        @JvmStatic
        public static final Readability disabled() {
            return INSTANCE.disabled();
        }

        @JvmStatic
        public static final Readability enabled() {
            return INSTANCE.enabled();
        }

        private Readability(boolean z) {
            this.enabled = z;
        }

        /* JADX INFO: compiled from: ScanProcessor.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007J\b\u0010\u0006\u001a\u00020\u0005H\u0007¨\u0006\u0007"}, d2 = {"Lcom/geniusscansdk/core/ScanProcessor$Readability$Companion;", "", "<init>", "()V", "disabled", "Lcom/geniusscansdk/core/ScanProcessor$Readability;", "enabled", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Readability disabled() {
                return new Readability(false, null);
            }

            @JvmStatic
            public final Readability enabled() {
                return new Readability(true, null);
            }
        }
    }

    /* JADX INFO: compiled from: ScanProcessor.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/geniusscansdk/core/ScanProcessor$Rotation;", "", "detectOrientation", "", "rotationAngle", "Lcom/geniusscansdk/core/RotationAngle;", "<init>", "(ZLcom/geniusscansdk/core/RotationAngle;)V", "Companion", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Rotation {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean detectOrientation;
        private final RotationAngle rotationAngle;

        public /* synthetic */ Rotation(boolean z, RotationAngle rotationAngle, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, rotationAngle);
        }

        @JvmStatic
        public static final Rotation automatic() {
            return INSTANCE.automatic();
        }

        @JvmStatic
        public static final Rotation none() {
            return INSTANCE.none();
        }

        @JvmStatic
        public static final Rotation withAngle(RotationAngle rotationAngle) {
            return INSTANCE.withAngle(rotationAngle);
        }

        private Rotation(boolean z, RotationAngle rotationAngle) {
            this.detectOrientation = z;
            this.rotationAngle = rotationAngle;
        }

        /* synthetic */ Rotation(boolean z, RotationAngle rotationAngle, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, (i & 2) != 0 ? RotationAngle.ROTATION_0 : rotationAngle);
        }

        /* JADX INFO: compiled from: ScanProcessor.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007J\b\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/geniusscansdk/core/ScanProcessor$Rotation$Companion;", "", "<init>", "()V", "none", "Lcom/geniusscansdk/core/ScanProcessor$Rotation;", "automatic", "withAngle", "angle", "Lcom/geniusscansdk/core/RotationAngle;", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @JvmStatic
            public final Rotation none() {
                return new Rotation(false, null, 2, 0 == true ? 1 : 0);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @JvmStatic
            public final Rotation automatic() {
                return new Rotation(true, null, 2, 0 == true ? 1 : 0);
            }

            @JvmStatic
            public final Rotation withAngle(RotationAngle angle) {
                Intrinsics.checkNotNullParameter(angle, "angle");
                return new Rotation(false, angle, null);
            }
        }
    }

    /* JADX INFO: compiled from: ScanProcessor.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u000b*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u000bB!\b\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/geniusscansdk/core/ScanProcessor$OutputConfiguration;", "O", "", "fileFormat", "Lcom/geniusscansdk/core/ScanProcessor$OutputFileFormat;", "outputFolder", "Ljava/io/File;", "<init>", "(Lcom/geniusscansdk/core/ScanProcessor$OutputFileFormat;Ljava/io/File;)V", "filePathWithoutExtension", "", "Companion", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class OutputConfiguration<O> {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final OutputFileFormat fileFormat;
        private final String filePathWithoutExtension;

        public /* synthetic */ OutputConfiguration(OutputFileFormat outputFileFormat, File file, DefaultConstructorMarker defaultConstructorMarker) {
            this(outputFileFormat, file);
        }

        @JvmStatic
        public static final OutputConfiguration<Bitmap> bitmap() {
            return INSTANCE.bitmap();
        }

        @JvmStatic
        public static final OutputConfiguration<File> file(OutputFileFormat outputFileFormat, File file) {
            return INSTANCE.file(outputFileFormat, file);
        }

        @JvmStatic
        public static final OutputConfiguration<File> file(File file) {
            return INSTANCE.file(file);
        }

        private OutputConfiguration(OutputFileFormat outputFileFormat, File file) {
            this.fileFormat = outputFileFormat;
            this.filePathWithoutExtension = file != null ? new File(file, UUID.randomUUID().toString()).getAbsolutePath() : null;
        }

        /* synthetic */ OutputConfiguration(OutputFileFormat outputFileFormat, File file, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : outputFileFormat, (i & 2) != 0 ? null : file);
        }

        /* JADX INFO: compiled from: ScanProcessor.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0007J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\t\u001a\u00020\u0006H\u0007J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005H\u0007¨\u0006\f"}, d2 = {"Lcom/geniusscansdk/core/ScanProcessor$OutputConfiguration$Companion;", "", "<init>", "()V", "file", "Lcom/geniusscansdk/core/ScanProcessor$OutputConfiguration;", "Ljava/io/File;", "format", "Lcom/geniusscansdk/core/ScanProcessor$OutputFileFormat;", "outputFolder", "bitmap", "Landroid/graphics/Bitmap;", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public static /* synthetic */ OutputConfiguration file$default(Companion companion, OutputFileFormat outputFileFormat, File file, int i, Object obj) {
                if ((i & 1) != 0) {
                    outputFileFormat = OutputFileFormat.AUTO;
                }
                return companion.file(outputFileFormat, file);
            }

            @JvmStatic
            public final OutputConfiguration<File> file(OutputFileFormat format, File outputFolder) {
                Intrinsics.checkNotNullParameter(format, "format");
                Intrinsics.checkNotNullParameter(outputFolder, "outputFolder");
                return new OutputConfiguration<>(format, outputFolder, null);
            }

            @JvmStatic
            public final OutputConfiguration<File> file(File outputFolder) {
                Intrinsics.checkNotNullParameter(outputFolder, "outputFolder");
                return file(OutputFileFormat.AUTO, outputFolder);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @JvmStatic
            public final OutputConfiguration<Bitmap> bitmap() {
                return new OutputConfiguration<>(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
            }
        }
    }

    /* JADX INFO: compiled from: ScanProcessor.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B?\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/geniusscansdk/core/ScanProcessor$Configuration;", "O", "", "perspectiveCorrection", "Lcom/geniusscansdk/core/ScanProcessor$PerspectiveCorrection;", "curvatureCorrection", "Lcom/geniusscansdk/core/ScanProcessor$CurvatureCorrection;", "enhancement", "Lcom/geniusscansdk/core/ScanProcessor$Enhancement;", "rotation", "Lcom/geniusscansdk/core/ScanProcessor$Rotation;", "readability", "Lcom/geniusscansdk/core/ScanProcessor$Readability;", "outputConfiguration", "Lcom/geniusscansdk/core/ScanProcessor$OutputConfiguration;", "<init>", "(Lcom/geniusscansdk/core/ScanProcessor$PerspectiveCorrection;Lcom/geniusscansdk/core/ScanProcessor$CurvatureCorrection;Lcom/geniusscansdk/core/ScanProcessor$Enhancement;Lcom/geniusscansdk/core/ScanProcessor$Rotation;Lcom/geniusscansdk/core/ScanProcessor$Readability;Lcom/geniusscansdk/core/ScanProcessor$OutputConfiguration;)V", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Configuration<O> {
        private final CurvatureCorrection curvatureCorrection;
        private final Enhancement enhancement;
        private final OutputConfiguration<O> outputConfiguration;
        private final PerspectiveCorrection perspectiveCorrection;
        private final Readability readability;
        private final Rotation rotation;

        public Configuration(PerspectiveCorrection perspectiveCorrection, CurvatureCorrection curvatureCorrection, Enhancement enhancement, Rotation rotation, Readability readability, OutputConfiguration<O> outputConfiguration) {
            Intrinsics.checkNotNullParameter(perspectiveCorrection, "perspectiveCorrection");
            Intrinsics.checkNotNullParameter(curvatureCorrection, "curvatureCorrection");
            Intrinsics.checkNotNullParameter(enhancement, "enhancement");
            Intrinsics.checkNotNullParameter(rotation, "rotation");
            Intrinsics.checkNotNullParameter(readability, "readability");
            Intrinsics.checkNotNullParameter(outputConfiguration, "outputConfiguration");
            this.perspectiveCorrection = perspectiveCorrection;
            this.curvatureCorrection = curvatureCorrection;
            this.enhancement = enhancement;
            this.rotation = rotation;
            this.readability = readability;
            this.outputConfiguration = outputConfiguration;
        }

        public /* synthetic */ Configuration(PerspectiveCorrection perspectiveCorrection, CurvatureCorrection curvatureCorrection, Enhancement enhancement, Rotation rotation, Readability readability, OutputConfiguration outputConfiguration, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(perspectiveCorrection, curvatureCorrection, enhancement, rotation, (i & 16) != 0 ? Readability.INSTANCE.disabled() : readability, outputConfiguration);
        }
    }

    /* JADX INFO: compiled from: ScanProcessor.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B;\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00028\u00008\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/geniusscansdk/core/ScanProcessor$Result;", ExifInterface.GPS_DIRECTION_TRUE, "", "appliedQuadrangle", "Lcom/geniusscansdk/core/Quadrangle;", "appliedFilter", "Lcom/geniusscansdk/core/FilterType;", "appliedFilterConfiguration", "Lcom/geniusscansdk/core/FilterConfiguration;", "appliedRotation", "Lcom/geniusscansdk/core/RotationAngle;", "readabilityLevel", "Lcom/geniusscansdk/core/ScanProcessor$ReadabilityLevel;", "output", "<init>", "(Lcom/geniusscansdk/core/Quadrangle;Lcom/geniusscansdk/core/FilterType;Lcom/geniusscansdk/core/FilterConfiguration;Lcom/geniusscansdk/core/RotationAngle;Lcom/geniusscansdk/core/ScanProcessor$ReadabilityLevel;Ljava/lang/Object;)V", "getAppliedFilter$annotations", "()V", "Ljava/lang/Object;", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Result<T> {
        public final FilterType appliedFilter;
        public final FilterConfiguration appliedFilterConfiguration;
        public final Quadrangle appliedQuadrangle;
        public final RotationAngle appliedRotation;
        public final T output;
        public final ReadabilityLevel readabilityLevel;

        @Deprecated(message = "Use appliedFilterConfiguration")
        public static /* synthetic */ void getAppliedFilter$annotations() {
        }

        public Result(Quadrangle appliedQuadrangle, FilterType filterType, FilterConfiguration appliedFilterConfiguration, RotationAngle appliedRotation, ReadabilityLevel readabilityLevel, T t) {
            Intrinsics.checkNotNullParameter(appliedQuadrangle, "appliedQuadrangle");
            Intrinsics.checkNotNullParameter(appliedFilterConfiguration, "appliedFilterConfiguration");
            Intrinsics.checkNotNullParameter(appliedRotation, "appliedRotation");
            this.appliedQuadrangle = appliedQuadrangle;
            this.appliedFilter = filterType;
            this.appliedFilterConfiguration = appliedFilterConfiguration;
            this.appliedRotation = appliedRotation;
            this.readabilityLevel = readabilityLevel;
            this.output = t;
        }
    }

    public final Result<File> process(File inputImage, Configuration<File> configuration) throws LicenseException, ProcessingException {
        Intrinsics.checkNotNullParameter(inputImage, "inputImage");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Companion companion = INSTANCE;
        long nativeHandle = this.documentDetector.getNativeHandle();
        long nativeHandle2 = this.orientationDetector.getNativeHandle();
        String absolutePath = inputImage.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        Result<File> resultGSLProcess = companion.GSLProcess(nativeHandle, nativeHandle2, absolutePath, configuration);
        if (resultGSLProcess != null) {
            return resultGSLProcess;
        }
        throw new ProcessingException();
    }

    public final Result<Bitmap> process(Bitmap inBitmap, Configuration<Bitmap> configuration) throws LicenseException, ProcessingException {
        Intrinsics.checkNotNullParameter(inBitmap, "inBitmap");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Result<Bitmap> resultGSLProcessBitmap = INSTANCE.GSLProcessBitmap(this.documentDetector.getNativeHandle(), this.orientationDetector.getNativeHandle(), inBitmap, configuration);
        if (resultGSLProcessBitmap != null) {
            return resultGSLProcessBitmap;
        }
        throw new ProcessingException();
    }

    /* JADX INFO: compiled from: ScanProcessor.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\rH\u0083 J7\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000f0\rH\u0083 ¨\u0006\u0011"}, d2 = {"Lcom/geniusscansdk/core/ScanProcessor$Companion;", "", "<init>", "()V", "GSLProcess", "Lcom/geniusscansdk/core/ScanProcessor$Result;", "Ljava/io/File;", "documentDetectionHandle", "", "orientationDetectionHandle", "inputImagePath", "", "configuration", "Lcom/geniusscansdk/core/ScanProcessor$Configuration;", "GSLProcessBitmap", "Landroid/graphics/Bitmap;", "in", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final Result<File> GSLProcess(long documentDetectionHandle, long orientationDetectionHandle, String inputImagePath, Configuration<File> configuration) throws LicenseException, ProcessingException {
            return ScanProcessor.GSLProcess(documentDetectionHandle, orientationDetectionHandle, inputImagePath, configuration);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final Result<Bitmap> GSLProcessBitmap(long documentDetectionHandle, long orientationDetectionHandle, Bitmap in, Configuration<Bitmap> configuration) throws LicenseException, ProcessingException {
            return ScanProcessor.GSLProcessBitmap(documentDetectionHandle, orientationDetectionHandle, in, configuration);
        }

        private Companion() {
        }
    }
}
