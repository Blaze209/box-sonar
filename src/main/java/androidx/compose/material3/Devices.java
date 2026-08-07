package androidx.compose.material3;

import androidx.collection.IntSet;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PrecisionPointer.android.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0083\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Landroidx/compose/material3/Devices;", "", "keyboards", "Landroidx/collection/IntSet;", "mice", "<init>", "(Landroidx/collection/IntSet;Landroidx/collection/IntSet;)V", "getKeyboards", "()Landroidx/collection/IntSet;", "getMice", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final /* data */ class Devices {
    private final IntSet keyboards;
    private final IntSet mice;

    public static /* synthetic */ Devices copy$default(Devices devices, IntSet intSet, IntSet intSet2, int i, Object obj) {
        if ((i & 1) != 0) {
            intSet = devices.keyboards;
        }
        if ((i & 2) != 0) {
            intSet2 = devices.mice;
        }
        return devices.copy(intSet, intSet2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final IntSet getKeyboards() {
        return this.keyboards;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final IntSet getMice() {
        return this.mice;
    }

    public final Devices copy(IntSet keyboards, IntSet mice) {
        return new Devices(keyboards, mice);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Devices)) {
            return false;
        }
        Devices devices = (Devices) other;
        return Intrinsics.areEqual(this.keyboards, devices.keyboards) && Intrinsics.areEqual(this.mice, devices.mice);
    }

    public int hashCode() {
        return (this.keyboards.hashCode() * 31) + this.mice.hashCode();
    }

    public String toString() {
        return "Devices(keyboards=" + this.keyboards + ", mice=" + this.mice + ')';
    }

    public Devices(IntSet intSet, IntSet intSet2) {
        this.keyboards = intSet;
        this.mice = intSet2;
    }

    public final IntSet getKeyboards() {
        return this.keyboards;
    }

    public final IntSet getMice() {
        return this.mice;
    }
}
