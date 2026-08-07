package com.geniusscansdk.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.androidsdk.content.models.BoxIterator;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: Quadrangle.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 42\u00020\u0001:\u00014B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005BI\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\u000fJ\u001e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007J\u0016\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007J\u0006\u0010\u001b\u001a\u00020\u0013J\u001c\u0010\u001c\u001a\u00020\u0013*\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0015H\u0002J\u0006\u0010\u001f\u001a\u00020\u0013J\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020!J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%J\b\u0010&\u001a\u00020\u0000H\u0002J\u0013\u0010'\u001a\u00020!2\b\u0010(\u001a\u0004\u0018\u00010)H\u0096\u0002J\b\u0010*\u001a\u00020\u0015H\u0016J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\u0013\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010-\u001a\u00020\u0015J\t\u0010.\u001a\u00020/HÖ\u0001J\u0016\u00100\u001a\u00020\u00132\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u00065"}, d2 = {"Lcom/geniusscansdk/core/Quadrangle;", "Landroid/os/Parcelable;", "points", "", "<init>", "([F)V", "x1", "", "y1", "x2", "y2", "x3", "y3", "x4", "y4", "(FFFFFFFF)V", "getPoints", "()[F", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_MOVE_JOB, "", "cornerIndex", "", "dx", "dy", "getClosestCorner", "x", "y", BoxIterator.FIELD_ORDER, "swap", "i1", "i2", "setToFullImage", "isFullImage", "", "isEmpty", "rotate", "angle", "Lcom/geniusscansdk/core/RotationAngle;", "rotateClockWise", "equals", "other", "", "hashCode", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "toString", "", "writeToParcel", "dest", "Landroid/os/Parcel;", "flags", "Companion", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class Quadrangle implements Parcelable {
    private final float[] points;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<Quadrangle> CREATOR = new Creator();

    /* JADX INFO: compiled from: Quadrangle.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<Quadrangle> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Quadrangle createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new Quadrangle(parcel.createFloatArray());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Quadrangle[] newArray(int i) {
            return new Quadrangle[i];
        }
    }

    /* JADX INFO: compiled from: Quadrangle.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RotationAngle.values().length];
            try {
                iArr[RotationAngle.ROTATION_0.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RotationAngle.ROTATION_90_CW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RotationAngle.ROTATION_180.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[RotationAngle.ROTATION_90_CCW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Quadrangle() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ Quadrangle copy$default(Quadrangle quadrangle, float[] fArr, int i, Object obj) {
        if ((i & 1) != 0) {
            fArr = quadrangle.points;
        }
        return quadrangle.copy(fArr);
    }

    @JvmStatic
    public static final Quadrangle createFullQuadrangle() {
        return INSTANCE.createFullQuadrangle();
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float[] getPoints() {
        return this.points;
    }

    public final Quadrangle copy(float[] points) {
        Intrinsics.checkNotNullParameter(points, "points");
        return new Quadrangle(points);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public String toString() {
        return "Quadrangle(points=" + Arrays.toString(this.points) + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeFloatArray(this.points);
    }

    public Quadrangle(float[] points) {
        Intrinsics.checkNotNullParameter(points, "points");
        this.points = points;
        if (points.length != 8) {
            throw new IllegalArgumentException("A quadrangle must have 8 coordinates".toString());
        }
    }

    public /* synthetic */ Quadrangle(float[] fArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new float[8] : fArr);
    }

    public final float[] getPoints() {
        return this.points;
    }

    public Quadrangle(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        this(new float[]{f, f2, f3, f4, f5, f6, f7, f8});
    }

    public final void move(int cornerIndex, float dx, float dy) {
        float[] fArr = this.points;
        int i = cornerIndex * 2;
        fArr[i] = fArr[i] + dx;
        int i2 = i + 1;
        fArr[i2] = fArr[i2] + dy;
    }

    public final int getClosestCorner(float x, float y) {
        Iterator<Integer> it = new IntRange(0, 3).iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        IntIterator intIterator = (IntIterator) it;
        int iNextInt = intIterator.nextInt();
        if (!it.hasNext()) {
            return iNextInt;
        }
        int i = iNextInt * 2;
        double d = 2;
        float fPow = ((float) Math.pow(this.points[i] - x, d)) + ((float) Math.pow(this.points[i + 1] - y, d));
        do {
            int iNextInt2 = intIterator.nextInt();
            int i2 = iNextInt2 * 2;
            float fPow2 = ((float) Math.pow(this.points[i2] - x, d)) + ((float) Math.pow(this.points[i2 + 1] - y, d));
            if (Float.compare(fPow, fPow2) > 0) {
                iNextInt = iNextInt2;
                fPow = fPow2;
            }
        } while (it.hasNext());
        return iNextInt;
    }

    public final void order() {
        float[] fArr = this.points;
        if (fArr[0] > fArr[2]) {
            swap(fArr, 0, 2);
            swap(this.points, 1, 3);
            swap(this.points, 4, 6);
            swap(this.points, 5, 7);
        }
        float[] fArr2 = this.points;
        if (fArr2[1] > fArr2[5]) {
            swap(fArr2, 0, 4);
            swap(this.points, 1, 5);
            swap(this.points, 2, 6);
            swap(this.points, 3, 7);
        }
    }

    private final void swap(float[] fArr, int i, int i2) {
        float f = fArr[i2];
        fArr[i2] = fArr[i];
        Unit unit = Unit.INSTANCE;
        fArr[i] = f;
    }

    public final void setToFullImage() {
        float[] fArr = this.points;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 1.0f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = 1.0f;
        fArr[6] = 1.0f;
        fArr[7] = 1.0f;
    }

    public final boolean isFullImage() {
        double d = 2;
        float f = 1;
        return ((double) ((((((float) Math.pow((double) this.points[0], d)) + ((float) Math.pow((double) this.points[1], d))) + (((float) Math.pow((double) (this.points[2] - f), d)) + ((float) Math.pow((double) this.points[3], d)))) + (((float) Math.pow((double) this.points[4], d)) + ((float) Math.pow((double) (this.points[5] - f), d)))) + (((float) Math.pow((double) (this.points[6] - f), d)) + ((float) Math.pow((double) (this.points[7] - f), d))))) < Math.pow(0.01d, 2.0d);
    }

    public final boolean isEmpty() {
        for (float f : this.points) {
            if (f != 0.0f) {
                return false;
            }
        }
        return true;
    }

    public final Quadrangle rotate(RotationAngle angle) {
        int i;
        Intrinsics.checkNotNullParameter(angle, "angle");
        if (isEmpty() || (i = WhenMappings.$EnumSwitchMapping$0[angle.ordinal()]) == 1) {
            return this;
        }
        if (i == 2) {
            return rotateClockWise();
        }
        if (i == 3) {
            return rotateClockWise().rotateClockWise();
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        return rotateClockWise().rotateClockWise().rotateClockWise();
    }

    private final Quadrangle rotateClockWise() {
        float f = 1;
        float[] fArr = this.points;
        return new Quadrangle(f - fArr[5], fArr[4], f - fArr[1], fArr[0], f - fArr[7], fArr[6], f - fArr[3], fArr[2]);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.geniusscansdk.core.Quadrangle");
        return Arrays.equals(this.points, ((Quadrangle) other).points);
    }

    public int hashCode() {
        return Arrays.hashCode(this.points);
    }

    /* JADX INFO: compiled from: Quadrangle.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/geniusscansdk/core/Quadrangle$Companion;", "", "<init>", "()V", "createFullQuadrangle", "Lcom/geniusscansdk/core/Quadrangle;", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @JvmStatic
        public final Quadrangle createFullQuadrangle() {
            Quadrangle quadrangle = new Quadrangle(null, 1, 0 == true ? 1 : 0);
            quadrangle.setToFullImage();
            return quadrangle;
        }
    }
}
