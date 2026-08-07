package com.geniusscansdk.scanflow;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.geniusscansdk.structureddata.StructuredDataResult;
import java.io.File;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScanResult.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0002\u0014\u0015B'\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/geniusscansdk/scanflow/ScanResult;", "Ljava/io/Serializable;", "multiPageDocument", "Ljava/io/File;", "scans", "", "Lcom/geniusscansdk/scanflow/ScanResult$Scan;", "<init>", "(Ljava/io/File;Ljava/util/List;)V", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "Scan", "OcrResult", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class ScanResult implements Serializable {
    public File multiPageDocument;
    public List<Scan> scans;

    /* JADX WARN: Multi-variable type inference failed */
    public ScanResult() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ScanResult(File file) {
        this(file, null, 2, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ScanResult copy$default(ScanResult scanResult, File file, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            file = scanResult.multiPageDocument;
        }
        if ((i & 2) != 0) {
            list = scanResult.scans;
        }
        return scanResult.copy(file, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final File getMultiPageDocument() {
        return this.multiPageDocument;
    }

    public final List<Scan> component2() {
        return this.scans;
    }

    public final ScanResult copy(File multiPageDocument, List<Scan> scans) {
        return new ScanResult(multiPageDocument, scans);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScanResult)) {
            return false;
        }
        ScanResult scanResult = (ScanResult) other;
        return Intrinsics.areEqual(this.multiPageDocument, scanResult.multiPageDocument) && Intrinsics.areEqual(this.scans, scanResult.scans);
    }

    public int hashCode() {
        File file = this.multiPageDocument;
        int iHashCode = (file == null ? 0 : file.hashCode()) * 31;
        List<Scan> list = this.scans;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "ScanResult(multiPageDocument=" + this.multiPageDocument + ", scans=" + this.scans + ")";
    }

    public ScanResult(File file, List<Scan> list) {
        this.multiPageDocument = file;
        this.scans = list;
    }

    public /* synthetic */ ScanResult(File file, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : file, (i & 2) != 0 ? null : list);
    }

    /* JADX INFO: compiled from: ScanResult.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\bHÆ\u0003J5\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/geniusscansdk/scanflow/ScanResult$Scan;", "Ljava/io/Serializable;", "originalImageFile", "Ljava/io/File;", "enhancedImageFile", "ocrResult", "Lcom/geniusscansdk/scanflow/ScanResult$OcrResult;", "structuredDataResult", "Lcom/geniusscansdk/structureddata/StructuredDataResult;", "<init>", "(Ljava/io/File;Ljava/io/File;Lcom/geniusscansdk/scanflow/ScanResult$OcrResult;Lcom/geniusscansdk/structureddata/StructuredDataResult;)V", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class Scan implements Serializable {
        public final File enhancedImageFile;
        public final OcrResult ocrResult;
        public final File originalImageFile;
        public final StructuredDataResult structuredDataResult;

        public static /* synthetic */ Scan copy$default(Scan scan, File file, File file2, OcrResult ocrResult, StructuredDataResult structuredDataResult, int i, Object obj) {
            if ((i & 1) != 0) {
                file = scan.originalImageFile;
            }
            if ((i & 2) != 0) {
                file2 = scan.enhancedImageFile;
            }
            if ((i & 4) != 0) {
                ocrResult = scan.ocrResult;
            }
            if ((i & 8) != 0) {
                structuredDataResult = scan.structuredDataResult;
            }
            return scan.copy(file, file2, ocrResult, structuredDataResult);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final File getOriginalImageFile() {
            return this.originalImageFile;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final File getEnhancedImageFile() {
            return this.enhancedImageFile;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final OcrResult getOcrResult() {
            return this.ocrResult;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final StructuredDataResult getStructuredDataResult() {
            return this.structuredDataResult;
        }

        public final Scan copy(File originalImageFile, File enhancedImageFile, OcrResult ocrResult, StructuredDataResult structuredDataResult) {
            Intrinsics.checkNotNullParameter(originalImageFile, "originalImageFile");
            Intrinsics.checkNotNullParameter(enhancedImageFile, "enhancedImageFile");
            return new Scan(originalImageFile, enhancedImageFile, ocrResult, structuredDataResult);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Scan)) {
                return false;
            }
            Scan scan = (Scan) other;
            return Intrinsics.areEqual(this.originalImageFile, scan.originalImageFile) && Intrinsics.areEqual(this.enhancedImageFile, scan.enhancedImageFile) && Intrinsics.areEqual(this.ocrResult, scan.ocrResult) && Intrinsics.areEqual(this.structuredDataResult, scan.structuredDataResult);
        }

        public int hashCode() {
            int iHashCode = ((this.originalImageFile.hashCode() * 31) + this.enhancedImageFile.hashCode()) * 31;
            OcrResult ocrResult = this.ocrResult;
            int iHashCode2 = (iHashCode + (ocrResult == null ? 0 : ocrResult.hashCode())) * 31;
            StructuredDataResult structuredDataResult = this.structuredDataResult;
            return iHashCode2 + (structuredDataResult != null ? structuredDataResult.hashCode() : 0);
        }

        public String toString() {
            return "Scan(originalImageFile=" + this.originalImageFile + ", enhancedImageFile=" + this.enhancedImageFile + ", ocrResult=" + this.ocrResult + ", structuredDataResult=" + this.structuredDataResult + ")";
        }

        public Scan(File originalImageFile, File enhancedImageFile, OcrResult ocrResult, StructuredDataResult structuredDataResult) {
            Intrinsics.checkNotNullParameter(originalImageFile, "originalImageFile");
            Intrinsics.checkNotNullParameter(enhancedImageFile, "enhancedImageFile");
            this.originalImageFile = originalImageFile;
            this.enhancedImageFile = enhancedImageFile;
            this.ocrResult = ocrResult;
            this.structuredDataResult = structuredDataResult;
        }

        public /* synthetic */ Scan(File file, File file2, OcrResult ocrResult, StructuredDataResult structuredDataResult, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(file, file2, (i & 4) != 0 ? null : ocrResult, (i & 8) != 0 ? null : structuredDataResult);
        }
    }

    /* JADX INFO: compiled from: ScanResult.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/geniusscansdk/scanflow/ScanResult$OcrResult;", "Ljava/io/Serializable;", "text", "", "hocrTextLayout", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class OcrResult implements Serializable {
        public final String hocrTextLayout;
        public final String text;

        public static /* synthetic */ OcrResult copy$default(OcrResult ocrResult, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = ocrResult.text;
            }
            if ((i & 2) != 0) {
                str2 = ocrResult.hocrTextLayout;
            }
            return ocrResult.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getText() {
            return this.text;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getHocrTextLayout() {
            return this.hocrTextLayout;
        }

        public final OcrResult copy(String text, String hocrTextLayout) {
            return new OcrResult(text, hocrTextLayout);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OcrResult)) {
                return false;
            }
            OcrResult ocrResult = (OcrResult) other;
            return Intrinsics.areEqual(this.text, ocrResult.text) && Intrinsics.areEqual(this.hocrTextLayout, ocrResult.hocrTextLayout);
        }

        public int hashCode() {
            String str = this.text;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.hocrTextLayout;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "OcrResult(text=" + this.text + ", hocrTextLayout=" + this.hocrTextLayout + ")";
        }

        public OcrResult(String str, String str2) {
            this.text = str;
            this.hocrTextLayout = str2;
        }
    }
}
