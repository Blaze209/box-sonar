package com.box.android.domain.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScannedDocumentPage.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BU\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010%\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0015J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003J\t\u0010(\u001a\u00020\tHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010*\u001a\u00020\rHÆ\u0003J\t\u0010+\u001a\u00020\u0004HÆ\u0003J\t\u0010,\u001a\u00020\u0004HÆ\u0003J\t\u0010-\u001a\u00020\u0011HÆ\u0003Jl\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u0011HÆ\u0001¢\u0006\u0002\u0010/J\u0006\u00100\u001a\u00020\u0004J\u0013\u00101\u001a\u00020\r2\b\u00102\u001a\u0004\u0018\u000103HÖ\u0003J\t\u00104\u001a\u00020\u0004HÖ\u0001J\t\u00105\u001a\u00020\u0006HÖ\u0001J\u0016\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u0004R\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u000e\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u0006;"}, d2 = {"Lcom/box/android/domain/models/ScannedDocumentPage;", "Lcom/box/android/domain/models/DomainModel;", "Landroid/os/Parcelable;", "id", "", "originalImagePath", "", "enhancedImagePath", "filterType", "Lcom/box/android/domain/models/DocumentPageFilterType;", "quadrangle", "Lcom/box/android/domain/models/DocumentPosition;", "distortionCorrectionEnabled", "", "rotationAngle", "version", "createdAt", "Ljava/util/Date;", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/box/android/domain/models/DocumentPageFilterType;Lcom/box/android/domain/models/DocumentPosition;ZIILjava/util/Date;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getOriginalImagePath", "()Ljava/lang/String;", "getEnhancedImagePath", "getFilterType", "()Lcom/box/android/domain/models/DocumentPageFilterType;", "getQuadrangle", "()Lcom/box/android/domain/models/DocumentPosition;", "getDistortionCorrectionEnabled", "()Z", "getRotationAngle", "()I", "getVersion", "getCreatedAt", "()Ljava/util/Date;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/box/android/domain/models/DocumentPageFilterType;Lcom/box/android/domain/models/DocumentPosition;ZIILjava/util/Date;)Lcom/box/android/domain/models/ScannedDocumentPage;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ScannedDocumentPage implements DomainModel, Parcelable {
    public static final Parcelable.Creator<ScannedDocumentPage> CREATOR = new Creator();
    private final Date createdAt;
    private final boolean distortionCorrectionEnabled;
    private final String enhancedImagePath;
    private final DocumentPageFilterType filterType;
    private final Integer id;
    private final String originalImagePath;
    private final DocumentPosition quadrangle;
    private final int rotationAngle;
    private final int version;

    /* JADX INFO: compiled from: ScannedDocumentPage.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ScannedDocumentPage> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ScannedDocumentPage createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ScannedDocumentPage(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), DocumentPageFilterType.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? DocumentPosition.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0, parcel.readInt(), parcel.readInt(), (Date) parcel.readSerializable());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ScannedDocumentPage[] newArray(int i) {
            return new ScannedDocumentPage[i];
        }
    }

    public static /* synthetic */ ScannedDocumentPage copy$default(ScannedDocumentPage scannedDocumentPage, Integer num, String str, String str2, DocumentPageFilterType documentPageFilterType, DocumentPosition documentPosition, boolean z, int i, int i2, Date date, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            num = scannedDocumentPage.id;
        }
        if ((i3 & 2) != 0) {
            str = scannedDocumentPage.originalImagePath;
        }
        if ((i3 & 4) != 0) {
            str2 = scannedDocumentPage.enhancedImagePath;
        }
        if ((i3 & 8) != 0) {
            documentPageFilterType = scannedDocumentPage.filterType;
        }
        if ((i3 & 16) != 0) {
            documentPosition = scannedDocumentPage.quadrangle;
        }
        if ((i3 & 32) != 0) {
            z = scannedDocumentPage.distortionCorrectionEnabled;
        }
        if ((i3 & 64) != 0) {
            i = scannedDocumentPage.rotationAngle;
        }
        if ((i3 & 128) != 0) {
            i2 = scannedDocumentPage.version;
        }
        if ((i3 & 256) != 0) {
            date = scannedDocumentPage.createdAt;
        }
        int i4 = i2;
        Date date2 = date;
        boolean z2 = z;
        int i5 = i;
        DocumentPosition documentPosition2 = documentPosition;
        String str3 = str2;
        return scannedDocumentPage.copy(num, str, str3, documentPageFilterType, documentPosition2, z2, i5, i4, date2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getId() {
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

    public final ScannedDocumentPage copy(Integer id, String originalImagePath, String enhancedImagePath, DocumentPageFilterType filterType, DocumentPosition quadrangle, boolean distortionCorrectionEnabled, int rotationAngle, int version, Date createdAt) {
        Intrinsics.checkNotNullParameter(originalImagePath, "originalImagePath");
        Intrinsics.checkNotNullParameter(enhancedImagePath, "enhancedImagePath");
        Intrinsics.checkNotNullParameter(filterType, "filterType");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        return new ScannedDocumentPage(id, originalImagePath, enhancedImagePath, filterType, quadrangle, distortionCorrectionEnabled, rotationAngle, version, createdAt);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScannedDocumentPage)) {
            return false;
        }
        ScannedDocumentPage scannedDocumentPage = (ScannedDocumentPage) other;
        return Intrinsics.areEqual(this.id, scannedDocumentPage.id) && Intrinsics.areEqual(this.originalImagePath, scannedDocumentPage.originalImagePath) && Intrinsics.areEqual(this.enhancedImagePath, scannedDocumentPage.enhancedImagePath) && this.filterType == scannedDocumentPage.filterType && Intrinsics.areEqual(this.quadrangle, scannedDocumentPage.quadrangle) && this.distortionCorrectionEnabled == scannedDocumentPage.distortionCorrectionEnabled && this.rotationAngle == scannedDocumentPage.rotationAngle && this.version == scannedDocumentPage.version && Intrinsics.areEqual(this.createdAt, scannedDocumentPage.createdAt);
    }

    public int hashCode() {
        Integer num = this.id;
        int iHashCode = (((((((num == null ? 0 : num.hashCode()) * 31) + this.originalImagePath.hashCode()) * 31) + this.enhancedImagePath.hashCode()) * 31) + this.filterType.hashCode()) * 31;
        DocumentPosition documentPosition = this.quadrangle;
        return ((((((((iHashCode + (documentPosition != null ? documentPosition.hashCode() : 0)) * 31) + Boolean.hashCode(this.distortionCorrectionEnabled)) * 31) + Integer.hashCode(this.rotationAngle)) * 31) + Integer.hashCode(this.version)) * 31) + this.createdAt.hashCode();
    }

    public String toString() {
        return "ScannedDocumentPage(id=" + this.id + ", originalImagePath=" + this.originalImagePath + ", enhancedImagePath=" + this.enhancedImagePath + ", filterType=" + this.filterType + ", quadrangle=" + this.quadrangle + ", distortionCorrectionEnabled=" + this.distortionCorrectionEnabled + ", rotationAngle=" + this.rotationAngle + ", version=" + this.version + ", createdAt=" + this.createdAt + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        Integer num = this.id;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        dest.writeString(this.originalImagePath);
        dest.writeString(this.enhancedImagePath);
        this.filterType.writeToParcel(dest, flags);
        DocumentPosition documentPosition = this.quadrangle;
        if (documentPosition == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            documentPosition.writeToParcel(dest, flags);
        }
        dest.writeInt(this.distortionCorrectionEnabled ? 1 : 0);
        dest.writeInt(this.rotationAngle);
        dest.writeInt(this.version);
        dest.writeSerializable(this.createdAt);
    }

    public ScannedDocumentPage(Integer num, String originalImagePath, String enhancedImagePath, DocumentPageFilterType filterType, DocumentPosition documentPosition, boolean z, int i, int i2, Date createdAt) {
        Intrinsics.checkNotNullParameter(originalImagePath, "originalImagePath");
        Intrinsics.checkNotNullParameter(enhancedImagePath, "enhancedImagePath");
        Intrinsics.checkNotNullParameter(filterType, "filterType");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        this.id = num;
        this.originalImagePath = originalImagePath;
        this.enhancedImagePath = enhancedImagePath;
        this.filterType = filterType;
        this.quadrangle = documentPosition;
        this.distortionCorrectionEnabled = z;
        this.rotationAngle = i;
        this.version = i2;
        this.createdAt = createdAt;
    }

    public final Integer getId() {
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

    public /* synthetic */ ScannedDocumentPage(Integer num, String str, String str2, DocumentPageFilterType documentPageFilterType, DocumentPosition documentPosition, boolean z, int i, int i2, Date date, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(num, str, str2, documentPageFilterType, documentPosition, z, i, i2, (i3 & 256) != 0 ? new Date() : date);
    }

    public final Date getCreatedAt() {
        return this.createdAt;
    }
}
