package com.geniusscansdk.core;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FilterConfiguration.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0004\u0016\u0017\u0018\u0019B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J-\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/geniusscansdk/core/FilterConfiguration;", "Ljava/io/Serializable;", "lightingCorrection", "Lcom/geniusscansdk/core/FilterConfiguration$LightingCorrection;", "backgroundCleaning", "Lcom/geniusscansdk/core/FilterConfiguration$BackgroundCleaning;", "color", "Lcom/geniusscansdk/core/FilterConfiguration$Color;", "<init>", "(Lcom/geniusscansdk/core/FilterConfiguration$LightingCorrection;Lcom/geniusscansdk/core/FilterConfiguration$BackgroundCleaning;Lcom/geniusscansdk/core/FilterConfiguration$Color;)V", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "LightingCorrection", "BackgroundCleaning", "Color", "Companion", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class FilterConfiguration implements Serializable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public final BackgroundCleaning backgroundCleaning;
    public final Color color;
    public final LightingCorrection lightingCorrection;

    public static /* synthetic */ FilterConfiguration copy$default(FilterConfiguration filterConfiguration, LightingCorrection lightingCorrection, BackgroundCleaning backgroundCleaning, Color color, int i, Object obj) {
        if ((i & 1) != 0) {
            lightingCorrection = filterConfiguration.lightingCorrection;
        }
        if ((i & 2) != 0) {
            backgroundCleaning = filterConfiguration.backgroundCleaning;
        }
        if ((i & 4) != 0) {
            color = filterConfiguration.color;
        }
        return filterConfiguration.copy(lightingCorrection, backgroundCleaning, color);
    }

    @JvmStatic
    public static final FilterConfiguration darkBackground() {
        return INSTANCE.darkBackground();
    }

    @JvmStatic
    public static final FilterConfiguration noOp() {
        return INSTANCE.noOp();
    }

    @JvmStatic
    public static final FilterConfiguration photo() {
        return INSTANCE.photo();
    }

    @JvmStatic
    public static final FilterConfiguration softColor() {
        return INSTANCE.softColor();
    }

    @JvmStatic
    public static final FilterConfiguration softGrayscale() {
        return INSTANCE.softGrayscale();
    }

    @JvmStatic
    public static final FilterConfiguration strongColor() {
        return INSTANCE.strongColor();
    }

    @JvmStatic
    public static final FilterConfiguration strongGrayscale() {
        return INSTANCE.strongGrayscale();
    }

    @JvmStatic
    public static final FilterConfiguration strongMonochrome() {
        return INSTANCE.strongMonochrome();
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final LightingCorrection getLightingCorrection() {
        return this.lightingCorrection;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final BackgroundCleaning getBackgroundCleaning() {
        return this.backgroundCleaning;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Color getColor() {
        return this.color;
    }

    public final FilterConfiguration copy(LightingCorrection lightingCorrection, BackgroundCleaning backgroundCleaning, Color color) {
        return new FilterConfiguration(lightingCorrection, backgroundCleaning, color);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FilterConfiguration)) {
            return false;
        }
        FilterConfiguration filterConfiguration = (FilterConfiguration) other;
        return Intrinsics.areEqual(this.lightingCorrection, filterConfiguration.lightingCorrection) && Intrinsics.areEqual(this.backgroundCleaning, filterConfiguration.backgroundCleaning) && Intrinsics.areEqual(this.color, filterConfiguration.color);
    }

    public int hashCode() {
        LightingCorrection lightingCorrection = this.lightingCorrection;
        int iHashCode = (lightingCorrection == null ? 0 : lightingCorrection.hashCode()) * 31;
        BackgroundCleaning backgroundCleaning = this.backgroundCleaning;
        int iHashCode2 = (iHashCode + (backgroundCleaning == null ? 0 : backgroundCleaning.hashCode())) * 31;
        Color color = this.color;
        return iHashCode2 + (color != null ? color.hashCode() : 0);
    }

    public String toString() {
        return "FilterConfiguration(lightingCorrection=" + this.lightingCorrection + ", backgroundCleaning=" + this.backgroundCleaning + ", color=" + this.color + ")";
    }

    public FilterConfiguration(LightingCorrection lightingCorrection, BackgroundCleaning backgroundCleaning, Color color) {
        this.lightingCorrection = lightingCorrection;
        this.backgroundCleaning = backgroundCleaning;
        this.color = color;
    }

    /* JADX INFO: compiled from: FilterConfiguration.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/geniusscansdk/core/FilterConfiguration$LightingCorrection;", "Ljava/io/Serializable;", "minThreshold", "", "maxThreshold", "<init>", "(FF)V", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class LightingCorrection implements Serializable {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public final float maxThreshold;
        public final float minThreshold;

        public static /* synthetic */ LightingCorrection copy$default(LightingCorrection lightingCorrection, float f, float f2, int i, Object obj) {
            if ((i & 1) != 0) {
                f = lightingCorrection.minThreshold;
            }
            if ((i & 2) != 0) {
                f2 = lightingCorrection.maxThreshold;
            }
            return lightingCorrection.copy(f, f2);
        }

        @JvmStatic
        public static final LightingCorrection document() {
            return INSTANCE.document();
        }

        @JvmStatic
        public static final LightingCorrection photo() {
            return INSTANCE.photo();
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final float getMinThreshold() {
            return this.minThreshold;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final float getMaxThreshold() {
            return this.maxThreshold;
        }

        public final LightingCorrection copy(float minThreshold, float maxThreshold) {
            return new LightingCorrection(minThreshold, maxThreshold);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LightingCorrection)) {
                return false;
            }
            LightingCorrection lightingCorrection = (LightingCorrection) other;
            return Float.compare(this.minThreshold, lightingCorrection.minThreshold) == 0 && Float.compare(this.maxThreshold, lightingCorrection.maxThreshold) == 0;
        }

        public int hashCode() {
            return (Float.hashCode(this.minThreshold) * 31) + Float.hashCode(this.maxThreshold);
        }

        public String toString() {
            return "LightingCorrection(minThreshold=" + this.minThreshold + ", maxThreshold=" + this.maxThreshold + ")";
        }

        public LightingCorrection(float f, float f2) {
            this.minThreshold = f;
            this.maxThreshold = f2;
        }

        /* JADX INFO: compiled from: FilterConfiguration.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007J\b\u0010\u0006\u001a\u00020\u0005H\u0007¨\u0006\u0007"}, d2 = {"Lcom/geniusscansdk/core/FilterConfiguration$LightingCorrection$Companion;", "", "<init>", "()V", "photo", "Lcom/geniusscansdk/core/FilterConfiguration$LightingCorrection;", "document", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final LightingCorrection photo() {
                return new LightingCorrection(0.01f, 0.99f);
            }

            @JvmStatic
            public final LightingCorrection document() {
                return new LightingCorrection(0.01f, 0.8f);
            }
        }
    }

    /* JADX INFO: compiled from: FilterConfiguration.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001:\u0003\u0019\u001a\u001bB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u000f\u001a\u00020\tHÆ\u0003J1\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/geniusscansdk/core/FilterConfiguration$BackgroundCleaning;", "Ljava/io/Serializable;", "documentComposition", "Lcom/geniusscansdk/core/FilterConfiguration$BackgroundCleaning$DocumentComposition;", "edgeCleaning", "Lcom/geniusscansdk/core/FilterConfiguration$BackgroundCleaning$EdgeCleaning;", "backgroundKind", "Lcom/geniusscansdk/core/FilterConfiguration$BackgroundCleaning$BackgroundKind;", "strength", "", "<init>", "(Lcom/geniusscansdk/core/FilterConfiguration$BackgroundCleaning$DocumentComposition;Lcom/geniusscansdk/core/FilterConfiguration$BackgroundCleaning$EdgeCleaning;Lcom/geniusscansdk/core/FilterConfiguration$BackgroundCleaning$BackgroundKind;F)V", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "DocumentComposition", "EdgeCleaning", "BackgroundKind", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class BackgroundCleaning implements Serializable {
        public final BackgroundKind backgroundKind;
        public final DocumentComposition documentComposition;
        public final EdgeCleaning edgeCleaning;
        public final float strength;

        /* JADX INFO: compiled from: FilterConfiguration.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/geniusscansdk/core/FilterConfiguration$BackgroundCleaning$BackgroundKind;", "", "<init>", "(Ljava/lang/String;I)V", "LIGHT", "DARK", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public enum BackgroundKind {
            LIGHT,
            DARK;

            private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

            public static EnumEntries<BackgroundKind> getEntries() {
                return $ENTRIES;
            }
        }

        /* JADX INFO: compiled from: FilterConfiguration.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/geniusscansdk/core/FilterConfiguration$BackgroundCleaning$DocumentComposition;", "", "<init>", "(Ljava/lang/String;I)V", "TEXT", "TEXT_AND_PHOTO", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public enum DocumentComposition {
            TEXT,
            TEXT_AND_PHOTO;

            private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

            public static EnumEntries<DocumentComposition> getEntries() {
                return $ENTRIES;
            }
        }

        /* JADX INFO: compiled from: FilterConfiguration.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/geniusscansdk/core/FilterConfiguration$BackgroundCleaning$EdgeCleaning;", "", "<init>", "(Ljava/lang/String;I)V", "ENABLED", "DISABLED", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public enum EdgeCleaning {
            ENABLED,
            DISABLED;

            private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

            public static EnumEntries<EdgeCleaning> getEntries() {
                return $ENTRIES;
            }
        }

        public static /* synthetic */ BackgroundCleaning copy$default(BackgroundCleaning backgroundCleaning, DocumentComposition documentComposition, EdgeCleaning edgeCleaning, BackgroundKind backgroundKind, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                documentComposition = backgroundCleaning.documentComposition;
            }
            if ((i & 2) != 0) {
                edgeCleaning = backgroundCleaning.edgeCleaning;
            }
            if ((i & 4) != 0) {
                backgroundKind = backgroundCleaning.backgroundKind;
            }
            if ((i & 8) != 0) {
                f = backgroundCleaning.strength;
            }
            return backgroundCleaning.copy(documentComposition, edgeCleaning, backgroundKind, f);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final DocumentComposition getDocumentComposition() {
            return this.documentComposition;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final EdgeCleaning getEdgeCleaning() {
            return this.edgeCleaning;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final BackgroundKind getBackgroundKind() {
            return this.backgroundKind;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final float getStrength() {
            return this.strength;
        }

        public final BackgroundCleaning copy(DocumentComposition documentComposition, EdgeCleaning edgeCleaning, BackgroundKind backgroundKind, float strength) {
            Intrinsics.checkNotNullParameter(documentComposition, "documentComposition");
            Intrinsics.checkNotNullParameter(edgeCleaning, "edgeCleaning");
            Intrinsics.checkNotNullParameter(backgroundKind, "backgroundKind");
            return new BackgroundCleaning(documentComposition, edgeCleaning, backgroundKind, strength);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BackgroundCleaning)) {
                return false;
            }
            BackgroundCleaning backgroundCleaning = (BackgroundCleaning) other;
            return this.documentComposition == backgroundCleaning.documentComposition && this.edgeCleaning == backgroundCleaning.edgeCleaning && this.backgroundKind == backgroundCleaning.backgroundKind && Float.compare(this.strength, backgroundCleaning.strength) == 0;
        }

        public int hashCode() {
            return (((((this.documentComposition.hashCode() * 31) + this.edgeCleaning.hashCode()) * 31) + this.backgroundKind.hashCode()) * 31) + Float.hashCode(this.strength);
        }

        public String toString() {
            return "BackgroundCleaning(documentComposition=" + this.documentComposition + ", edgeCleaning=" + this.edgeCleaning + ", backgroundKind=" + this.backgroundKind + ", strength=" + this.strength + ")";
        }

        public BackgroundCleaning(DocumentComposition documentComposition, EdgeCleaning edgeCleaning, BackgroundKind backgroundKind, float f) {
            Intrinsics.checkNotNullParameter(documentComposition, "documentComposition");
            Intrinsics.checkNotNullParameter(edgeCleaning, "edgeCleaning");
            Intrinsics.checkNotNullParameter(backgroundKind, "backgroundKind");
            this.documentComposition = documentComposition;
            this.edgeCleaning = edgeCleaning;
            this.backgroundKind = backgroundKind;
            this.strength = f;
        }
    }

    /* JADX INFO: compiled from: FilterConfiguration.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/geniusscansdk/core/FilterConfiguration$Color;", "Ljava/io/Serializable;", "palette", "Lcom/geniusscansdk/core/FilterConfiguration$Color$Palette;", "<init>", "(Lcom/geniusscansdk/core/FilterConfiguration$Color$Palette;)V", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "Palette", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class Color implements Serializable {
        public final Palette palette;

        /* JADX INFO: compiled from: FilterConfiguration.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/geniusscansdk/core/FilterConfiguration$Color$Palette;", "", "<init>", "(Ljava/lang/String;I)V", "MONOCHROME", "GRAYSCALE", "COLOR", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public enum Palette {
            MONOCHROME,
            GRAYSCALE,
            COLOR;

            private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

            public static EnumEntries<Palette> getEntries() {
                return $ENTRIES;
            }
        }

        public static /* synthetic */ Color copy$default(Color color, Palette palette, int i, Object obj) {
            if ((i & 1) != 0) {
                palette = color.palette;
            }
            return color.copy(palette);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Palette getPalette() {
            return this.palette;
        }

        public final Color copy(Palette palette) {
            Intrinsics.checkNotNullParameter(palette, "palette");
            return new Color(palette);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Color) && this.palette == ((Color) other).palette;
        }

        public int hashCode() {
            return this.palette.hashCode();
        }

        public String toString() {
            return "Color(palette=" + this.palette + ")";
        }

        public Color(Palette palette) {
            Intrinsics.checkNotNullParameter(palette, "palette");
            this.palette = palette;
        }
    }

    /* JADX INFO: compiled from: FilterConfiguration.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007J\b\u0010\u0006\u001a\u00020\u0005H\u0007J\b\u0010\u0007\u001a\u00020\u0005H\u0007J\b\u0010\b\u001a\u00020\u0005H\u0007J\b\u0010\t\u001a\u00020\u0005H\u0007J\b\u0010\n\u001a\u00020\u0005H\u0007J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0007J\b\u0010\u0010\u001a\u00020\u0005H\u0007¨\u0006\u0011"}, d2 = {"Lcom/geniusscansdk/core/FilterConfiguration$Companion;", "", "<init>", "()V", "noOp", "Lcom/geniusscansdk/core/FilterConfiguration;", "softGrayscale", "softColor", "strongGrayscale", "strongColor", "strongMonochrome", "strongFilter", "palette", "Lcom/geniusscansdk/core/FilterConfiguration$Color$Palette;", "softFilter", "photo", "darkBackground", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final FilterConfiguration noOp() {
            return new FilterConfiguration(null, null, null);
        }

        @JvmStatic
        public final FilterConfiguration softGrayscale() {
            return softFilter(Color.Palette.GRAYSCALE);
        }

        @JvmStatic
        public final FilterConfiguration softColor() {
            return softFilter(Color.Palette.COLOR);
        }

        @JvmStatic
        public final FilterConfiguration strongGrayscale() {
            return strongFilter(Color.Palette.GRAYSCALE);
        }

        @JvmStatic
        public final FilterConfiguration strongColor() {
            return strongFilter(Color.Palette.COLOR);
        }

        @JvmStatic
        public final FilterConfiguration strongMonochrome() {
            return strongFilter(Color.Palette.MONOCHROME);
        }

        private final FilterConfiguration strongFilter(Color.Palette palette) {
            return new FilterConfiguration(LightingCorrection.INSTANCE.document(), new BackgroundCleaning(BackgroundCleaning.DocumentComposition.TEXT, BackgroundCleaning.EdgeCleaning.ENABLED, BackgroundCleaning.BackgroundKind.LIGHT, 1.0f), new Color(palette));
        }

        private final FilterConfiguration softFilter(Color.Palette palette) {
            return new FilterConfiguration(LightingCorrection.INSTANCE.document(), new BackgroundCleaning(BackgroundCleaning.DocumentComposition.TEXT_AND_PHOTO, BackgroundCleaning.EdgeCleaning.ENABLED, BackgroundCleaning.BackgroundKind.LIGHT, 0.0f), new Color(palette));
        }

        @JvmStatic
        public final FilterConfiguration photo() {
            return new FilterConfiguration(LightingCorrection.INSTANCE.photo(), null, new Color(Color.Palette.COLOR));
        }

        @JvmStatic
        public final FilterConfiguration darkBackground() {
            return new FilterConfiguration(LightingCorrection.INSTANCE.document(), new BackgroundCleaning(BackgroundCleaning.DocumentComposition.TEXT_AND_PHOTO, BackgroundCleaning.EdgeCleaning.ENABLED, BackgroundCleaning.BackgroundKind.DARK, 0.0f), new Color(Color.Palette.COLOR));
        }
    }
}
