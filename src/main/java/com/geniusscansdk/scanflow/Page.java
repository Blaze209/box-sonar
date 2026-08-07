package com.geniusscansdk.scanflow;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.uimanager.ViewProps;
import com.geniusscansdk.core.Quadrangle;
import com.geniusscansdk.core.ScanProcessor;
import com.geniusscansdk.ocr.OcrResult;
import com.geniusscansdk.structureddata.StructuredDataResult;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Page.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0004\b\u0011\u0010\u0015J\b\u00100\u001a\u0004\u0018\u00010\u0003J\u000e\u00101\u001a\u0002022\u0006\u0010\u0004\u001a\u00020\u0003J\u0006\u00103\u001a\u000202J\u0006\u00104\u001a\u000205J\u0016\u00106\u001a\u0002022\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u000205R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u0006:"}, d2 = {"Lcom/geniusscansdk/scanflow/Page;", "Landroid/os/Parcelable;", "originalImage", "Ljava/io/File;", "enhancedImage", "quadrangle", "Lcom/geniusscansdk/core/Quadrangle;", ViewProps.FILTER, "Lcom/geniusscansdk/scanflow/ScanConfiguration$Filter;", "curvatureCorrectionMode", "Lcom/geniusscansdk/scanflow/ScanConfiguration$CurvatureCorrectionMode;", "ocrResult", "Lcom/geniusscansdk/ocr/OcrResult;", "structuredDataResult", "Lcom/geniusscansdk/structureddata/StructuredDataResult;", "readabilityLevel", "Lcom/geniusscansdk/core/ScanProcessor$ReadabilityLevel;", "<init>", "(Ljava/io/File;Ljava/io/File;Lcom/geniusscansdk/core/Quadrangle;Lcom/geniusscansdk/scanflow/ScanConfiguration$Filter;Lcom/geniusscansdk/scanflow/ScanConfiguration$CurvatureCorrectionMode;Lcom/geniusscansdk/ocr/OcrResult;Lcom/geniusscansdk/structureddata/StructuredDataResult;Lcom/geniusscansdk/core/ScanProcessor$ReadabilityLevel;)V", "scanConfiguration", "Lcom/geniusscansdk/scanflow/ScanConfiguration;", "(Ljava/io/File;Lcom/geniusscansdk/scanflow/ScanConfiguration;)V", "getOriginalImage", "()Ljava/io/File;", "getQuadrangle", "()Lcom/geniusscansdk/core/Quadrangle;", "setQuadrangle", "(Lcom/geniusscansdk/core/Quadrangle;)V", "getFilter", "()Lcom/geniusscansdk/scanflow/ScanConfiguration$Filter;", "setFilter", "(Lcom/geniusscansdk/scanflow/ScanConfiguration$Filter;)V", "getCurvatureCorrectionMode", "()Lcom/geniusscansdk/scanflow/ScanConfiguration$CurvatureCorrectionMode;", "setCurvatureCorrectionMode", "(Lcom/geniusscansdk/scanflow/ScanConfiguration$CurvatureCorrectionMode;)V", "getOcrResult", "()Lcom/geniusscansdk/ocr/OcrResult;", "setOcrResult", "(Lcom/geniusscansdk/ocr/OcrResult;)V", "getStructuredDataResult", "()Lcom/geniusscansdk/structureddata/StructuredDataResult;", "setStructuredDataResult", "(Lcom/geniusscansdk/structureddata/StructuredDataResult;)V", "getReadabilityLevel", "()Lcom/geniusscansdk/core/ScanProcessor$ReadabilityLevel;", "setReadabilityLevel", "(Lcom/geniusscansdk/core/ScanProcessor$ReadabilityLevel;)V", "getEnhancedImage", "setEnhancedImage", "", "deleteImages", "describeContents", "", "writeToParcel", "dest", "Landroid/os/Parcel;", "flags", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Page implements Parcelable {
    public static final Parcelable.Creator<Page> CREATOR = new Creator();
    private ScanConfiguration.CurvatureCorrectionMode curvatureCorrectionMode;
    private File enhancedImage;
    private ScanConfiguration.Filter filter;
    private OcrResult ocrResult;
    private final File originalImage;
    private Quadrangle quadrangle;
    private ScanProcessor.ReadabilityLevel readabilityLevel;
    private StructuredDataResult structuredDataResult;

    /* JADX INFO: compiled from: Page.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<Page> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Page createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new Page((File) parcel.readSerializable(), (File) parcel.readSerializable(), parcel.readInt() == 0 ? null : Quadrangle.CREATOR.createFromParcel(parcel), ScanConfiguration.Filter.valueOf(parcel.readString()), ScanConfiguration.CurvatureCorrectionMode.valueOf(parcel.readString()), parcel.readInt() == 0 ? null : OcrResult.CREATOR.createFromParcel(parcel), (StructuredDataResult) parcel.readSerializable(), parcel.readInt() != 0 ? ScanProcessor.ReadabilityLevel.valueOf(parcel.readString()) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Page[] newArray(int i) {
            return new Page[i];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeSerializable(this.originalImage);
        dest.writeSerializable(this.enhancedImage);
        Quadrangle quadrangle = this.quadrangle;
        if (quadrangle == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            quadrangle.writeToParcel(dest, flags);
        }
        dest.writeString(this.filter.name());
        dest.writeString(this.curvatureCorrectionMode.name());
        OcrResult ocrResult = this.ocrResult;
        if (ocrResult == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            ocrResult.writeToParcel(dest, flags);
        }
        dest.writeSerializable(this.structuredDataResult);
        ScanProcessor.ReadabilityLevel readabilityLevel = this.readabilityLevel;
        if (readabilityLevel == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeString(readabilityLevel.name());
        }
    }

    public Page(File originalImage, File file, Quadrangle quadrangle, ScanConfiguration.Filter filter, ScanConfiguration.CurvatureCorrectionMode curvatureCorrectionMode, OcrResult ocrResult, StructuredDataResult structuredDataResult, ScanProcessor.ReadabilityLevel readabilityLevel) {
        Intrinsics.checkNotNullParameter(originalImage, "originalImage");
        Intrinsics.checkNotNullParameter(filter, "filter");
        Intrinsics.checkNotNullParameter(curvatureCorrectionMode, "curvatureCorrectionMode");
        this.originalImage = originalImage;
        this.enhancedImage = file;
        this.quadrangle = quadrangle;
        this.filter = filter;
        this.curvatureCorrectionMode = curvatureCorrectionMode;
        this.ocrResult = ocrResult;
        this.structuredDataResult = structuredDataResult;
        this.readabilityLevel = readabilityLevel;
    }

    public final File getOriginalImage() {
        return this.originalImage;
    }

    public final Quadrangle getQuadrangle() {
        return this.quadrangle;
    }

    public final void setQuadrangle(Quadrangle quadrangle) {
        this.quadrangle = quadrangle;
    }

    public /* synthetic */ Page(File file, File file2, Quadrangle quadrangle, ScanConfiguration.Filter filter, ScanConfiguration.CurvatureCorrectionMode curvatureCorrectionMode, OcrResult ocrResult, StructuredDataResult structuredDataResult, ScanProcessor.ReadabilityLevel readabilityLevel, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, (i & 2) != 0 ? null : file2, (i & 4) != 0 ? null : quadrangle, (i & 8) != 0 ? ScanConfiguration.Filter.AUTOMATIC : filter, (i & 16) != 0 ? ScanConfiguration.CurvatureCorrectionMode.DISABLED : curvatureCorrectionMode, (i & 32) != 0 ? null : ocrResult, (i & 64) != 0 ? null : structuredDataResult, (i & 128) != 0 ? null : readabilityLevel);
    }

    public final ScanConfiguration.Filter getFilter() {
        return this.filter;
    }

    public final void setFilter(ScanConfiguration.Filter filter) {
        Intrinsics.checkNotNullParameter(filter, "<set-?>");
        this.filter = filter;
    }

    public final ScanConfiguration.CurvatureCorrectionMode getCurvatureCorrectionMode() {
        return this.curvatureCorrectionMode;
    }

    public final void setCurvatureCorrectionMode(ScanConfiguration.CurvatureCorrectionMode curvatureCorrectionMode) {
        Intrinsics.checkNotNullParameter(curvatureCorrectionMode, "<set-?>");
        this.curvatureCorrectionMode = curvatureCorrectionMode;
    }

    public final OcrResult getOcrResult() {
        return this.ocrResult;
    }

    public final void setOcrResult(OcrResult ocrResult) {
        this.ocrResult = ocrResult;
    }

    public final StructuredDataResult getStructuredDataResult() {
        return this.structuredDataResult;
    }

    public final void setStructuredDataResult(StructuredDataResult structuredDataResult) {
        this.structuredDataResult = structuredDataResult;
    }

    public final ScanProcessor.ReadabilityLevel getReadabilityLevel() {
        return this.readabilityLevel;
    }

    public final void setReadabilityLevel(ScanProcessor.ReadabilityLevel readabilityLevel) {
        this.readabilityLevel = readabilityLevel;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Page(File originalImage, ScanConfiguration scanConfiguration) {
        this(originalImage, null, null, scanConfiguration.defaultFilter, scanConfiguration.defaultCurvatureCorrection, null, null, null, 230, null);
        Intrinsics.checkNotNullParameter(originalImage, "originalImage");
        Intrinsics.checkNotNullParameter(scanConfiguration, "scanConfiguration");
    }

    public final File getEnhancedImage() {
        return this.enhancedImage;
    }

    public final void setEnhancedImage(File enhancedImage) {
        Intrinsics.checkNotNullParameter(enhancedImage, "enhancedImage");
        File file = this.enhancedImage;
        if (file != null) {
            file.delete();
        }
        this.enhancedImage = enhancedImage;
    }

    public final void deleteImages() {
        this.originalImage.delete();
        File file = this.enhancedImage;
        if (file != null) {
            file.delete();
        }
    }
}
