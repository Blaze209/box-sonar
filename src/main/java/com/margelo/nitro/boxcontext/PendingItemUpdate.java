package com.margelo.nitro.boxcontext;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PendingItemUpdate.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\tHÆ\u0003J<\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006#"}, d2 = {"Lcom/margelo/nitro/boxcontext/PendingItemUpdate;", "", "type", "Lcom/margelo/nitro/boxcontext/PendingItemUpdateType;", "progress", "", "itemInfo", "Lcom/margelo/nitro/boxcontext/ItemInfo;", "error", "Lcom/margelo/nitro/boxcontext/PendingItemError;", "<init>", "(Lcom/margelo/nitro/boxcontext/PendingItemUpdateType;Ljava/lang/Double;Lcom/margelo/nitro/boxcontext/ItemInfo;Lcom/margelo/nitro/boxcontext/PendingItemError;)V", "getType", "()Lcom/margelo/nitro/boxcontext/PendingItemUpdateType;", "getProgress", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getItemInfo", "()Lcom/margelo/nitro/boxcontext/ItemInfo;", "getError", "()Lcom/margelo/nitro/boxcontext/PendingItemError;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Lcom/margelo/nitro/boxcontext/PendingItemUpdateType;Ljava/lang/Double;Lcom/margelo/nitro/boxcontext/ItemInfo;Lcom/margelo/nitro/boxcontext/PendingItemError;)Lcom/margelo/nitro/boxcontext/PendingItemUpdate;", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "cirrus_box-context_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class PendingItemUpdate {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PendingItemError error;
    private final ItemInfo itemInfo;
    private final Double progress;
    private final PendingItemUpdateType type;

    public static /* synthetic */ PendingItemUpdate copy$default(PendingItemUpdate pendingItemUpdate, PendingItemUpdateType pendingItemUpdateType, Double d, ItemInfo itemInfo, PendingItemError pendingItemError, int i, Object obj) {
        if ((i & 1) != 0) {
            pendingItemUpdateType = pendingItemUpdate.type;
        }
        if ((i & 2) != 0) {
            d = pendingItemUpdate.progress;
        }
        if ((i & 4) != 0) {
            itemInfo = pendingItemUpdate.itemInfo;
        }
        if ((i & 8) != 0) {
            pendingItemError = pendingItemUpdate.error;
        }
        return pendingItemUpdate.copy(pendingItemUpdateType, d, itemInfo, pendingItemError);
    }

    @JvmStatic
    private static final PendingItemUpdate fromCpp(PendingItemUpdateType pendingItemUpdateType, Double d, ItemInfo itemInfo, PendingItemError pendingItemError) {
        return INSTANCE.fromCpp(pendingItemUpdateType, d, itemInfo, pendingItemError);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final PendingItemUpdateType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Double getProgress() {
        return this.progress;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ItemInfo getItemInfo() {
        return this.itemInfo;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final PendingItemError getError() {
        return this.error;
    }

    public final PendingItemUpdate copy(PendingItemUpdateType type, Double progress, ItemInfo itemInfo, PendingItemError error) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new PendingItemUpdate(type, progress, itemInfo, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PendingItemUpdate)) {
            return false;
        }
        PendingItemUpdate pendingItemUpdate = (PendingItemUpdate) other;
        return this.type == pendingItemUpdate.type && Intrinsics.areEqual((Object) this.progress, (Object) pendingItemUpdate.progress) && Intrinsics.areEqual(this.itemInfo, pendingItemUpdate.itemInfo) && Intrinsics.areEqual(this.error, pendingItemUpdate.error);
    }

    public int hashCode() {
        int iHashCode = this.type.hashCode() * 31;
        Double d = this.progress;
        int iHashCode2 = (iHashCode + (d == null ? 0 : d.hashCode())) * 31;
        ItemInfo itemInfo = this.itemInfo;
        int iHashCode3 = (iHashCode2 + (itemInfo == null ? 0 : itemInfo.hashCode())) * 31;
        PendingItemError pendingItemError = this.error;
        return iHashCode3 + (pendingItemError != null ? pendingItemError.hashCode() : 0);
    }

    public String toString() {
        return "PendingItemUpdate(type=" + this.type + ", progress=" + this.progress + ", itemInfo=" + this.itemInfo + ", error=" + this.error + ")";
    }

    public PendingItemUpdate(PendingItemUpdateType type, Double d, ItemInfo itemInfo, PendingItemError pendingItemError) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.progress = d;
        this.itemInfo = itemInfo;
        this.error = pendingItemError;
    }

    public final PendingItemUpdateType getType() {
        return this.type;
    }

    public final Double getProgress() {
        return this.progress;
    }

    public final ItemInfo getItemInfo() {
        return this.itemInfo;
    }

    public final PendingItemError getError() {
        return this.error;
    }

    /* JADX INFO: compiled from: PendingItemUpdate.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J3\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0003¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/margelo/nitro/boxcontext/PendingItemUpdate$Companion;", "", "<init>", "()V", "fromCpp", "Lcom/margelo/nitro/boxcontext/PendingItemUpdate;", "type", "Lcom/margelo/nitro/boxcontext/PendingItemUpdateType;", "progress", "", "itemInfo", "Lcom/margelo/nitro/boxcontext/ItemInfo;", "error", "Lcom/margelo/nitro/boxcontext/PendingItemError;", "(Lcom/margelo/nitro/boxcontext/PendingItemUpdateType;Ljava/lang/Double;Lcom/margelo/nitro/boxcontext/ItemInfo;Lcom/margelo/nitro/boxcontext/PendingItemError;)Lcom/margelo/nitro/boxcontext/PendingItemUpdate;", "cirrus_box-context_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final PendingItemUpdate fromCpp(PendingItemUpdateType type, Double progress, ItemInfo itemInfo, PendingItemError error) {
            return new PendingItemUpdate(type, progress, itemInfo, error);
        }
    }
}
