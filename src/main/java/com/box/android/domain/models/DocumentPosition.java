package com.box.android.domain.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScannedDocumentPage.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003JY\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0006\u0010#\u001a\u00020$J\t\u0010%\u001a\u00020$HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001J\u0016\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020$R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006-"}, d2 = {"Lcom/box/android/domain/models/DocumentPosition;", "Landroid/os/Parcelable;", "x1", "", "y1", "x2", "y2", "x3", "y3", "x4", "y4", "<init>", "(FFFFFFFF)V", "getX1", "()F", "getY1", "getX2", "getY2", "getX3", "getY3", "getX4", "getY4", "equals", "", "other", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class DocumentPosition implements Parcelable {
    public static final Parcelable.Creator<DocumentPosition> CREATOR = new Creator();
    private final float x1;
    private final float x2;
    private final float x3;
    private final float x4;
    private final float y1;
    private final float y2;
    private final float y3;
    private final float y4;

    /* JADX INFO: compiled from: ScannedDocumentPage.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DocumentPosition> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DocumentPosition createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DocumentPosition(parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DocumentPosition[] newArray(int i) {
            return new DocumentPosition[i];
        }
    }

    public static /* synthetic */ DocumentPosition copy$default(DocumentPosition documentPosition, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int i, Object obj) {
        if ((i & 1) != 0) {
            f = documentPosition.x1;
        }
        if ((i & 2) != 0) {
            f2 = documentPosition.y1;
        }
        if ((i & 4) != 0) {
            f3 = documentPosition.x2;
        }
        if ((i & 8) != 0) {
            f4 = documentPosition.y2;
        }
        if ((i & 16) != 0) {
            f5 = documentPosition.x3;
        }
        if ((i & 32) != 0) {
            f6 = documentPosition.y3;
        }
        if ((i & 64) != 0) {
            f7 = documentPosition.x4;
        }
        if ((i & 128) != 0) {
            f8 = documentPosition.y4;
        }
        float f9 = f7;
        float f10 = f8;
        float f11 = f5;
        float f12 = f6;
        return documentPosition.copy(f, f2, f3, f4, f11, f12, f9, f10);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float getX1() {
        return this.x1;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getY1() {
        return this.y1;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final float getX2() {
        return this.x2;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final float getY2() {
        return this.y2;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final float getX3() {
        return this.x3;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final float getY3() {
        return this.y3;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final float getX4() {
        return this.x4;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final float getY4() {
        return this.y4;
    }

    public final DocumentPosition copy(float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4) {
        return new DocumentPosition(x1, y1, x2, y2, x3, y3, x4, y4);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public int hashCode() {
        return (((((((((((((Float.hashCode(this.x1) * 31) + Float.hashCode(this.y1)) * 31) + Float.hashCode(this.x2)) * 31) + Float.hashCode(this.y2)) * 31) + Float.hashCode(this.x3)) * 31) + Float.hashCode(this.y3)) * 31) + Float.hashCode(this.x4)) * 31) + Float.hashCode(this.y4);
    }

    public String toString() {
        return "DocumentPosition(x1=" + this.x1 + ", y1=" + this.y1 + ", x2=" + this.x2 + ", y2=" + this.y2 + ", x3=" + this.x3 + ", y3=" + this.y3 + ", x4=" + this.x4 + ", y4=" + this.y4 + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeFloat(this.x1);
        dest.writeFloat(this.y1);
        dest.writeFloat(this.x2);
        dest.writeFloat(this.y2);
        dest.writeFloat(this.x3);
        dest.writeFloat(this.y3);
        dest.writeFloat(this.x4);
        dest.writeFloat(this.y4);
    }

    public DocumentPosition(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        this.x1 = f;
        this.y1 = f2;
        this.x2 = f3;
        this.y2 = f4;
        this.x3 = f5;
        this.y3 = f6;
        this.x4 = f7;
        this.y4 = f8;
    }

    public final float getX1() {
        return this.x1;
    }

    public final float getY1() {
        return this.y1;
    }

    public final float getX2() {
        return this.x2;
    }

    public final float getY2() {
        return this.y2;
    }

    public final float getX3() {
        return this.x3;
    }

    public final float getY3() {
        return this.y3;
    }

    public final float getX4() {
        return this.x4;
    }

    public final float getY4() {
        return this.y4;
    }

    public boolean equals(Object other) {
        if (!(other instanceof DocumentPosition)) {
            return false;
        }
        DocumentPosition documentPosition = (DocumentPosition) other;
        return ((Math.abs(this.x1 - documentPosition.x1) > 1.0E-4f ? 1 : (Math.abs(this.x1 - documentPosition.x1) == 1.0E-4f ? 0 : -1)) < 0 && (Math.abs(this.x2 - documentPosition.x2) > 1.0E-4f ? 1 : (Math.abs(this.x2 - documentPosition.x2) == 1.0E-4f ? 0 : -1)) < 0 && (Math.abs(this.x3 - documentPosition.x3) > 1.0E-4f ? 1 : (Math.abs(this.x3 - documentPosition.x3) == 1.0E-4f ? 0 : -1)) < 0 && (Math.abs(this.x4 - documentPosition.x4) > 1.0E-4f ? 1 : (Math.abs(this.x4 - documentPosition.x4) == 1.0E-4f ? 0 : -1)) < 0) && ((Math.abs(this.y1 - documentPosition.y1) > 1.0E-4f ? 1 : (Math.abs(this.y1 - documentPosition.y1) == 1.0E-4f ? 0 : -1)) < 0 && (Math.abs(this.y2 - documentPosition.y2) > 1.0E-4f ? 1 : (Math.abs(this.y2 - documentPosition.y2) == 1.0E-4f ? 0 : -1)) < 0 && (Math.abs(this.y3 - documentPosition.y3) > 1.0E-4f ? 1 : (Math.abs(this.y3 - documentPosition.y3) == 1.0E-4f ? 0 : -1)) < 0 && (Math.abs(this.y4 - documentPosition.y4) > 1.0E-4f ? 1 : (Math.abs(this.y4 - documentPosition.y4) == 1.0E-4f ? 0 : -1)) < 0);
    }
}
