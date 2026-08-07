package com.box.android.data.persistence;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DocumentPageFilterType;
import com.box.android.domain.models.DocumentPosition;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScannedDocumentPageEntity.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b \b\u0087\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\bHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010'\u001a\u00020\fHÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0010HÆ\u0003Je\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001J\u0013\u0010,\u001a\u00020\f2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\u0003HÖ\u0001J\t\u0010/\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u0016\u0010\u000f\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u00060"}, d2 = {"Lcom/box/android/data/persistence/ScannedDocumentPageEntity;", "", "id", "", "originalImagePath", "", "enhancedImagePath", "filterType", "Lcom/box/android/domain/models/DocumentPageFilterType;", "quadrangle", "Lcom/box/android/domain/models/DocumentPosition;", "distortionCorrectionEnabled", "", "rotationAngle", "version", "createdAt", "Ljava/util/Date;", "<init>", "(ILjava/lang/String;Ljava/lang/String;Lcom/box/android/domain/models/DocumentPageFilterType;Lcom/box/android/domain/models/DocumentPosition;ZIILjava/util/Date;)V", "getId", "()I", "getOriginalImagePath", "()Ljava/lang/String;", "getEnhancedImagePath", "getFilterType", "()Lcom/box/android/domain/models/DocumentPageFilterType;", "getQuadrangle", "()Lcom/box/android/domain/models/DocumentPosition;", "getDistortionCorrectionEnabled", "()Z", "getRotationAngle", "getVersion", "getCreatedAt", "()Ljava/util/Date;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ScannedDocumentPageEntity {
    private final Date createdAt;
    private final boolean distortionCorrectionEnabled;
    private final String enhancedImagePath;
    private final DocumentPageFilterType filterType;
    private final int id;
    private final String originalImagePath;
    private final DocumentPosition quadrangle;
    private final int rotationAngle;
    private final int version;

    public static /* synthetic */ ScannedDocumentPageEntity copy$default(ScannedDocumentPageEntity scannedDocumentPageEntity, int i, String str, String str2, DocumentPageFilterType documentPageFilterType, DocumentPosition documentPosition, boolean z, int i2, int i3, Date date, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = scannedDocumentPageEntity.id;
        }
        if ((i4 & 2) != 0) {
            str = scannedDocumentPageEntity.originalImagePath;
        }
        if ((i4 & 4) != 0) {
            str2 = scannedDocumentPageEntity.enhancedImagePath;
        }
        if ((i4 & 8) != 0) {
            documentPageFilterType = scannedDocumentPageEntity.filterType;
        }
        if ((i4 & 16) != 0) {
            documentPosition = scannedDocumentPageEntity.quadrangle;
        }
        if ((i4 & 32) != 0) {
            z = scannedDocumentPageEntity.distortionCorrectionEnabled;
        }
        if ((i4 & 64) != 0) {
            i2 = scannedDocumentPageEntity.rotationAngle;
        }
        if ((i4 & 128) != 0) {
            i3 = scannedDocumentPageEntity.version;
        }
        if ((i4 & 256) != 0) {
            date = scannedDocumentPageEntity.createdAt;
        }
        int i5 = i3;
        Date date2 = date;
        boolean z2 = z;
        int i6 = i2;
        DocumentPosition documentPosition2 = documentPosition;
        String str3 = str2;
        return scannedDocumentPageEntity.copy(i, str, str3, documentPageFilterType, documentPosition2, z2, i6, i5, date2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getOriginalImagePath() {
        return this.originalImagePath;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getEnhancedImagePath() {
        return this.enhancedImagePath;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final DocumentPageFilterType getFilterType() {
        return this.filterType;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final DocumentPosition getQuadrangle() {
        return this.quadrangle;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getDistortionCorrectionEnabled() {
        return this.distortionCorrectionEnabled;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getRotationAngle() {
        return this.rotationAngle;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Date getCreatedAt() {
        return this.createdAt;
    }

    public final ScannedDocumentPageEntity copy(int id, String originalImagePath, String enhancedImagePath, DocumentPageFilterType filterType, DocumentPosition quadrangle, boolean distortionCorrectionEnabled, int rotationAngle, int version, Date createdAt) {
        Intrinsics.checkNotNullParameter(originalImagePath, "originalImagePath");
        Intrinsics.checkNotNullParameter(enhancedImagePath, "enhancedImagePath");
        Intrinsics.checkNotNullParameter(filterType, "filterType");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        return new ScannedDocumentPageEntity(id, originalImagePath, enhancedImagePath, filterType, quadrangle, distortionCorrectionEnabled, rotationAngle, version, createdAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScannedDocumentPageEntity)) {
            return false;
        }
        ScannedDocumentPageEntity scannedDocumentPageEntity = (ScannedDocumentPageEntity) other;
        return this.id == scannedDocumentPageEntity.id && Intrinsics.areEqual(this.originalImagePath, scannedDocumentPageEntity.originalImagePath) && Intrinsics.areEqual(this.enhancedImagePath, scannedDocumentPageEntity.enhancedImagePath) && this.filterType == scannedDocumentPageEntity.filterType && Intrinsics.areEqual(this.quadrangle, scannedDocumentPageEntity.quadrangle) && this.distortionCorrectionEnabled == scannedDocumentPageEntity.distortionCorrectionEnabled && this.rotationAngle == scannedDocumentPageEntity.rotationAngle && this.version == scannedDocumentPageEntity.version && Intrinsics.areEqual(this.createdAt, scannedDocumentPageEntity.createdAt);
    }

    public int hashCode() {
        int iHashCode = ((((((Integer.hashCode(this.id) * 31) + this.originalImagePath.hashCode()) * 31) + this.enhancedImagePath.hashCode()) * 31) + this.filterType.hashCode()) * 31;
        DocumentPosition documentPosition = this.quadrangle;
        return ((((((((iHashCode + (documentPosition == null ? 0 : documentPosition.hashCode())) * 31) + Boolean.hashCode(this.distortionCorrectionEnabled)) * 31) + Integer.hashCode(this.rotationAngle)) * 31) + Integer.hashCode(this.version)) * 31) + this.createdAt.hashCode();
    }

    public String toString() {
        return "ScannedDocumentPageEntity(id=" + this.id + ", originalImagePath=" + this.originalImagePath + ", enhancedImagePath=" + this.enhancedImagePath + ", filterType=" + this.filterType + ", quadrangle=" + this.quadrangle + ", distortionCorrectionEnabled=" + this.distortionCorrectionEnabled + ", rotationAngle=" + this.rotationAngle + ", version=" + this.version + ", createdAt=" + this.createdAt + ")";
    }

    public ScannedDocumentPageEntity(int i, String originalImagePath, String enhancedImagePath, DocumentPageFilterType filterType, DocumentPosition documentPosition, boolean z, int i2, int i3, Date createdAt) {
        Intrinsics.checkNotNullParameter(originalImagePath, "originalImagePath");
        Intrinsics.checkNotNullParameter(enhancedImagePath, "enhancedImagePath");
        Intrinsics.checkNotNullParameter(filterType, "filterType");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        this.id = i;
        this.originalImagePath = originalImagePath;
        this.enhancedImagePath = enhancedImagePath;
        this.filterType = filterType;
        this.quadrangle = documentPosition;
        this.distortionCorrectionEnabled = z;
        this.rotationAngle = i2;
        this.version = i3;
        this.createdAt = createdAt;
    }

    public final int getId() {
        return this.id;
    }

    public final String getOriginalImagePath() {
        return this.originalImagePath;
    }

    public final String getEnhancedImagePath() {
        return this.enhancedImagePath;
    }

    public final DocumentPageFilterType getFilterType() {
        return this.filterType;
    }

    public final DocumentPosition getQuadrangle() {
        return this.quadrangle;
    }

    public final boolean getDistortionCorrectionEnabled() {
        return this.distortionCorrectionEnabled;
    }

    public final int getRotationAngle() {
        return this.rotationAngle;
    }

    public final int getVersion() {
        return this.version;
    }

    public /* synthetic */ ScannedDocumentPageEntity(int i, String str, String str2, DocumentPageFilterType documentPageFilterType, DocumentPosition documentPosition, boolean z, int i2, int i3, Date date, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, str2, documentPageFilterType, documentPosition, z, i2, i3, (i4 & 256) != 0 ? new Date() : date);
    }

    public final Date getCreatedAt() {
        return this.createdAt;
    }
}
