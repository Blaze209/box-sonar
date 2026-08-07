package com.margelo.nitro.boxcontext;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemStatus.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/margelo/nitro/boxcontext/ItemStatus;", "", "id", "Lcom/margelo/nitro/boxcontext/ItemIdentifier;", "canSelect", "", "enabled", "<init>", "(Lcom/margelo/nitro/boxcontext/ItemIdentifier;ZZ)V", "getId", "()Lcom/margelo/nitro/boxcontext/ItemIdentifier;", "getCanSelect", "()Z", "getEnabled", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "", "Companion", "cirrus_box-context_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class ItemStatus {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean canSelect;
    private final boolean enabled;
    private final ItemIdentifier id;

    public static /* synthetic */ ItemStatus copy$default(ItemStatus itemStatus, ItemIdentifier itemIdentifier, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            itemIdentifier = itemStatus.id;
        }
        if ((i & 2) != 0) {
            z = itemStatus.canSelect;
        }
        if ((i & 4) != 0) {
            z2 = itemStatus.enabled;
        }
        return itemStatus.copy(itemIdentifier, z, z2);
    }

    @JvmStatic
    private static final ItemStatus fromCpp(ItemIdentifier itemIdentifier, boolean z, boolean z2) {
        return INSTANCE.fromCpp(itemIdentifier, z, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ItemIdentifier getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getCanSelect() {
        return this.canSelect;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    public final ItemStatus copy(ItemIdentifier id, boolean canSelect, boolean enabled) {
        Intrinsics.checkNotNullParameter(id, "id");
        return new ItemStatus(id, canSelect, enabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ItemStatus)) {
            return false;
        }
        ItemStatus itemStatus = (ItemStatus) other;
        return Intrinsics.areEqual(this.id, itemStatus.id) && this.canSelect == itemStatus.canSelect && this.enabled == itemStatus.enabled;
    }

    public int hashCode() {
        return (((this.id.hashCode() * 31) + Boolean.hashCode(this.canSelect)) * 31) + Boolean.hashCode(this.enabled);
    }

    public String toString() {
        return "ItemStatus(id=" + this.id + ", canSelect=" + this.canSelect + ", enabled=" + this.enabled + ")";
    }

    public ItemStatus(ItemIdentifier id, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.id = id;
        this.canSelect = z;
        this.enabled = z2;
    }

    public final ItemIdentifier getId() {
        return this.id;
    }

    public final boolean getCanSelect() {
        return this.canSelect;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    /* JADX INFO: compiled from: ItemStatus.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0003¨\u0006\u000b"}, d2 = {"Lcom/margelo/nitro/boxcontext/ItemStatus$Companion;", "", "<init>", "()V", "fromCpp", "Lcom/margelo/nitro/boxcontext/ItemStatus;", "id", "Lcom/margelo/nitro/boxcontext/ItemIdentifier;", "canSelect", "", "enabled", "cirrus_box-context_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final ItemStatus fromCpp(ItemIdentifier id, boolean canSelect, boolean enabled) {
            return new ItemStatus(id, canSelect, enabled);
        }
    }
}
