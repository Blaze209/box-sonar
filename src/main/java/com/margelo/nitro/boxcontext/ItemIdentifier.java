package com.margelo.nitro.boxcontext;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemIdentifier.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/margelo/nitro/boxcontext/ItemIdentifier;", "", "id", "", "type", "Lcom/margelo/nitro/boxcontext/ItemType;", "<init>", "(Ljava/lang/String;Lcom/margelo/nitro/boxcontext/ItemType;)V", "getId", "()Ljava/lang/String;", "getType", "()Lcom/margelo/nitro/boxcontext/ItemType;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "Companion", "cirrus_box-context_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class ItemIdentifier {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String id;
    private final ItemType type;

    public static /* synthetic */ ItemIdentifier copy$default(ItemIdentifier itemIdentifier, String str, ItemType itemType, int i, Object obj) {
        if ((i & 1) != 0) {
            str = itemIdentifier.id;
        }
        if ((i & 2) != 0) {
            itemType = itemIdentifier.type;
        }
        return itemIdentifier.copy(str, itemType);
    }

    @JvmStatic
    private static final ItemIdentifier fromCpp(String str, ItemType itemType) {
        return INSTANCE.fromCpp(str, itemType);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ItemType getType() {
        return this.type;
    }

    public final ItemIdentifier copy(String id, ItemType type) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        return new ItemIdentifier(id, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ItemIdentifier)) {
            return false;
        }
        ItemIdentifier itemIdentifier = (ItemIdentifier) other;
        return Intrinsics.areEqual(this.id, itemIdentifier.id) && this.type == itemIdentifier.type;
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + this.type.hashCode();
    }

    public String toString() {
        return "ItemIdentifier(id=" + this.id + ", type=" + this.type + ")";
    }

    public ItemIdentifier(String id, ItemType type) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        this.id = id;
        this.type = type;
    }

    public final String getId() {
        return this.id;
    }

    public final ItemType getType() {
        return this.type;
    }

    /* JADX INFO: compiled from: ItemIdentifier.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0003¨\u0006\n"}, d2 = {"Lcom/margelo/nitro/boxcontext/ItemIdentifier$Companion;", "", "<init>", "()V", "fromCpp", "Lcom/margelo/nitro/boxcontext/ItemIdentifier;", "id", "", "type", "Lcom/margelo/nitro/boxcontext/ItemType;", "cirrus_box-context_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final ItemIdentifier fromCpp(String id, ItemType type) {
            return new ItemIdentifier(id, type);
        }
    }
}
