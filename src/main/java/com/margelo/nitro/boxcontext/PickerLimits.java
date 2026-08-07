package com.margelo.nitro.boxcontext;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PickerLimits.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ2\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/margelo/nitro/boxcontext/PickerLimits;", "", "file", "", "folder", "hubs", "<init>", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)V", "getFile", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getFolder", "getHubs", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)Lcom/margelo/nitro/boxcontext/PickerLimits;", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "cirrus_box-context_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class PickerLimits {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Double file;
    private final Double folder;
    private final Double hubs;

    public static /* synthetic */ PickerLimits copy$default(PickerLimits pickerLimits, Double d, Double d2, Double d3, int i, Object obj) {
        if ((i & 1) != 0) {
            d = pickerLimits.file;
        }
        if ((i & 2) != 0) {
            d2 = pickerLimits.folder;
        }
        if ((i & 4) != 0) {
            d3 = pickerLimits.hubs;
        }
        return pickerLimits.copy(d, d2, d3);
    }

    @JvmStatic
    private static final PickerLimits fromCpp(Double d, Double d2, Double d3) {
        return INSTANCE.fromCpp(d, d2, d3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Double getFile() {
        return this.file;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Double getFolder() {
        return this.folder;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Double getHubs() {
        return this.hubs;
    }

    public final PickerLimits copy(Double file, Double folder, Double hubs) {
        return new PickerLimits(file, folder, hubs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PickerLimits)) {
            return false;
        }
        PickerLimits pickerLimits = (PickerLimits) other;
        return Intrinsics.areEqual((Object) this.file, (Object) pickerLimits.file) && Intrinsics.areEqual((Object) this.folder, (Object) pickerLimits.folder) && Intrinsics.areEqual((Object) this.hubs, (Object) pickerLimits.hubs);
    }

    public int hashCode() {
        Double d = this.file;
        int iHashCode = (d == null ? 0 : d.hashCode()) * 31;
        Double d2 = this.folder;
        int iHashCode2 = (iHashCode + (d2 == null ? 0 : d2.hashCode())) * 31;
        Double d3 = this.hubs;
        return iHashCode2 + (d3 != null ? d3.hashCode() : 0);
    }

    public String toString() {
        return "PickerLimits(file=" + this.file + ", folder=" + this.folder + ", hubs=" + this.hubs + ")";
    }

    public PickerLimits(Double d, Double d2, Double d3) {
        this.file = d;
        this.folder = d2;
        this.hubs = d3;
    }

    public final Double getFile() {
        return this.file;
    }

    public final Double getFolder() {
        return this.folder;
    }

    public final Double getHubs() {
        return this.hubs;
    }

    /* JADX INFO: compiled from: PickerLimits.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0003¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/margelo/nitro/boxcontext/PickerLimits$Companion;", "", "<init>", "()V", "fromCpp", "Lcom/margelo/nitro/boxcontext/PickerLimits;", "file", "", "folder", "hubs", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)Lcom/margelo/nitro/boxcontext/PickerLimits;", "cirrus_box-context_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final PickerLimits fromCpp(Double file, Double folder, Double hubs) {
            return new PickerLimits(file, folder, hubs);
        }
    }
}
