package com.pspdfkit.signatures;

import android.os.Parcel;
import android.os.Parcelable;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0002()BC\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003JJ\u0010\u0018\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0014\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0083\u0004J\n\u0010 \u001a\u00020\u001bHÖ\u0081\u0004J\n\u0010!\u001a\u00020\"HÖ\u0081\u0004J\u0016\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001bR\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006*"}, d2 = {"Lcom/pspdfkit/signatures/BiometricSignatureData;", "Landroid/os/Parcelable;", "pressurePoints", "", "", "timePoints", "", "touchRadius", "inputMethod", "Lcom/pspdfkit/signatures/BiometricSignatureData$InputMethod;", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/lang/Float;Lcom/pspdfkit/signatures/BiometricSignatureData$InputMethod;)V", "getPressurePoints", "()Ljava/util/List;", "getTimePoints", "getTouchRadius", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getInputMethod", "()Lcom/pspdfkit/signatures/BiometricSignatureData$InputMethod;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/util/List;Ljava/util/List;Ljava/lang/Float;Lcom/pspdfkit/signatures/BiometricSignatureData$InputMethod;)Lcom/pspdfkit/signatures/BiometricSignatureData;", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "InputMethod", "Companion", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class BiometricSignatureData implements Parcelable {
    private final InputMethod inputMethod;
    private final List<Float> pressurePoints;
    private final List<Long> timePoints;
    private final Float touchRadius;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<BiometricSignatureData> CREATOR = new Creator();
    public static final int $stable = 8;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\b"}, d2 = {"Lcom/pspdfkit/signatures/BiometricSignatureData$Companion;", "", "<init>", "()V", "normalizeTimePoints", "", "", "timePoints", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List<Long> normalizeTimePoints(List<Long> timePoints) {
            ArrayList arrayList;
            timePoints.getClass();
            if (timePoints == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(timePoints.size());
                if (!timePoints.isEmpty()) {
                    Long l = timePoints.get(0);
                    for (int i = 0; i < timePoints.size(); i++) {
                        arrayList.add(Long.valueOf(timePoints.get(i).longValue() - l.longValue()));
                    }
                }
            }
            arrayList.getClass();
            return arrayList;
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<BiometricSignatureData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BiometricSignatureData createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            ArrayList arrayList2;
            parcel.getClass();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i = parcel.readInt();
                arrayList = new ArrayList(i);
                for (int i2 = 0; i2 != i; i2++) {
                    arrayList.add(Float.valueOf(parcel.readFloat()));
                }
            }
            if (parcel.readInt() == 0) {
                arrayList2 = null;
            } else {
                int i3 = parcel.readInt();
                arrayList2 = new ArrayList(i3);
                for (int i4 = 0; i4 != i3; i4++) {
                    arrayList2.add(Long.valueOf(parcel.readLong()));
                }
            }
            return new BiometricSignatureData(arrayList, arrayList2, parcel.readInt() == 0 ? null : Float.valueOf(parcel.readFloat()), parcel.readInt() != 0 ? InputMethod.valueOf(parcel.readString()) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BiometricSignatureData[] newArray(int i) {
            return new BiometricSignatureData[i];
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/pspdfkit/signatures/BiometricSignatureData$InputMethod;", "", "<init>", "(Ljava/lang/String;I)V", "FINGER", "STYLUS", "MOUSE", "APPLE_PENCIL", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public enum InputMethod {
        FINGER,
        STYLUS,
        MOUSE,
        APPLE_PENCIL;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<InputMethod> getEntries() {
            return $ENTRIES;
        }
    }

    public BiometricSignatureData() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BiometricSignatureData copy$default(BiometricSignatureData biometricSignatureData, List list, List list2, Float f, InputMethod inputMethod, int i, Object obj) {
        if ((i & 1) != 0) {
            list = biometricSignatureData.pressurePoints;
        }
        if ((i & 2) != 0) {
            list2 = biometricSignatureData.timePoints;
        }
        if ((i & 4) != 0) {
            f = biometricSignatureData.touchRadius;
        }
        if ((i & 8) != 0) {
            inputMethod = biometricSignatureData.inputMethod;
        }
        return biometricSignatureData.copy(list, list2, f, inputMethod);
    }

    public final List<Float> component1() {
        return this.pressurePoints;
    }

    public final List<Long> component2() {
        return this.timePoints;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Float getTouchRadius() {
        return this.touchRadius;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final InputMethod getInputMethod() {
        return this.inputMethod;
    }

    public final BiometricSignatureData copy(List<Float> pressurePoints, List<Long> timePoints, Float touchRadius, InputMethod inputMethod) {
        return new BiometricSignatureData(pressurePoints, timePoints, touchRadius, inputMethod);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BiometricSignatureData)) {
            return false;
        }
        BiometricSignatureData biometricSignatureData = (BiometricSignatureData) other;
        return Intrinsics.areEqual(this.pressurePoints, biometricSignatureData.pressurePoints) && Intrinsics.areEqual(this.timePoints, biometricSignatureData.timePoints) && Intrinsics.areEqual((Object) this.touchRadius, (Object) biometricSignatureData.touchRadius) && this.inputMethod == biometricSignatureData.inputMethod;
    }

    public final InputMethod getInputMethod() {
        return this.inputMethod;
    }

    public final List<Float> getPressurePoints() {
        return this.pressurePoints;
    }

    public final List<Long> getTimePoints() {
        return this.timePoints;
    }

    public final Float getTouchRadius() {
        return this.touchRadius;
    }

    public int hashCode() {
        List<Float> list = this.pressurePoints;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<Long> list2 = this.timePoints;
        int iHashCode2 = (iHashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        Float f = this.touchRadius;
        int iHashCode3 = (iHashCode2 + (f == null ? 0 : f.hashCode())) * 31;
        InputMethod inputMethod = this.inputMethod;
        return iHashCode3 + (inputMethod != null ? inputMethod.hashCode() : 0);
    }

    public String toString() {
        return "BiometricSignatureData(pressurePoints=" + this.pressurePoints + ", timePoints=" + this.timePoints + ", touchRadius=" + this.touchRadius + ", inputMethod=" + this.inputMethod + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        dest.getClass();
        List<Float> list = this.pressurePoints;
        if (list == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(list.size());
            Iterator<Float> it = list.iterator();
            while (it.hasNext()) {
                dest.writeFloat(it.next().floatValue());
            }
        }
        List<Long> list2 = this.timePoints;
        if (list2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(list2.size());
            Iterator<Long> it2 = list2.iterator();
            while (it2.hasNext()) {
                dest.writeLong(it2.next().longValue());
            }
        }
        Float f = this.touchRadius;
        if (f == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeFloat(f.floatValue());
        }
        InputMethod inputMethod = this.inputMethod;
        if (inputMethod == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeString(inputMethod.name());
        }
    }

    public BiometricSignatureData(List<Float> list, List<Long> list2, Float f, InputMethod inputMethod) {
        this.pressurePoints = list;
        this.timePoints = list2;
        this.touchRadius = f;
        this.inputMethod = inputMethod;
    }

    public /* synthetic */ BiometricSignatureData(List list, List list2, Float f, InputMethod inputMethod, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2, (i & 4) != 0 ? null : f, (i & 8) != 0 ? null : inputMethod);
    }
}
