package com.margelo.nitro.boxcontext;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemInfo.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0001#B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\nHÆ\u0003JM\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006$"}, d2 = {"Lcom/margelo/nitro/boxcontext/ItemInfo;", "", "id", "Lcom/margelo/nitro/boxcontext/ItemIdentifier;", "name", "", "boxId", BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, "itemSource", "error", "Lcom/margelo/nitro/boxcontext/PendingItemError;", "<init>", "(Lcom/margelo/nitro/boxcontext/ItemIdentifier;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/margelo/nitro/boxcontext/PendingItemError;)V", "getId", "()Lcom/margelo/nitro/boxcontext/ItemIdentifier;", "getName", "()Ljava/lang/String;", "getBoxId", "getSharedLink", "getItemSource", "getError", "()Lcom/margelo/nitro/boxcontext/PendingItemError;", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "Companion", "cirrus_box-context_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class ItemInfo {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String boxId;
    private final PendingItemError error;
    private final ItemIdentifier id;
    private final String itemSource;
    private final String name;
    private final String sharedLink;

    public static /* synthetic */ ItemInfo copy$default(ItemInfo itemInfo, ItemIdentifier itemIdentifier, String str, String str2, String str3, String str4, PendingItemError pendingItemError, int i, Object obj) {
        if ((i & 1) != 0) {
            itemIdentifier = itemInfo.id;
        }
        if ((i & 2) != 0) {
            str = itemInfo.name;
        }
        if ((i & 4) != 0) {
            str2 = itemInfo.boxId;
        }
        if ((i & 8) != 0) {
            str3 = itemInfo.sharedLink;
        }
        if ((i & 16) != 0) {
            str4 = itemInfo.itemSource;
        }
        if ((i & 32) != 0) {
            pendingItemError = itemInfo.error;
        }
        String str5 = str4;
        PendingItemError pendingItemError2 = pendingItemError;
        return itemInfo.copy(itemIdentifier, str, str2, str3, str5, pendingItemError2);
    }

    @JvmStatic
    private static final ItemInfo fromCpp(ItemIdentifier itemIdentifier, String str, String str2, String str3, String str4, PendingItemError pendingItemError) {
        return INSTANCE.fromCpp(itemIdentifier, str, str2, str3, str4, pendingItemError);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ItemIdentifier getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getBoxId() {
        return this.boxId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSharedLink() {
        return this.sharedLink;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getItemSource() {
        return this.itemSource;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final PendingItemError getError() {
        return this.error;
    }

    public final ItemInfo copy(ItemIdentifier id, String name, String boxId, String sharedLink, String itemSource, PendingItemError error) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        return new ItemInfo(id, name, boxId, sharedLink, itemSource, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ItemInfo)) {
            return false;
        }
        ItemInfo itemInfo = (ItemInfo) other;
        return Intrinsics.areEqual(this.id, itemInfo.id) && Intrinsics.areEqual(this.name, itemInfo.name) && Intrinsics.areEqual(this.boxId, itemInfo.boxId) && Intrinsics.areEqual(this.sharedLink, itemInfo.sharedLink) && Intrinsics.areEqual(this.itemSource, itemInfo.itemSource) && Intrinsics.areEqual(this.error, itemInfo.error);
    }

    public int hashCode() {
        int iHashCode = ((this.id.hashCode() * 31) + this.name.hashCode()) * 31;
        String str = this.boxId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.sharedLink;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.itemSource;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        PendingItemError pendingItemError = this.error;
        return iHashCode4 + (pendingItemError != null ? pendingItemError.hashCode() : 0);
    }

    public String toString() {
        return "ItemInfo(id=" + this.id + ", name=" + this.name + ", boxId=" + this.boxId + ", sharedLink=" + this.sharedLink + ", itemSource=" + this.itemSource + ", error=" + this.error + ")";
    }

    public ItemInfo(ItemIdentifier id, String name, String str, String str2, String str3, PendingItemError pendingItemError) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = id;
        this.name = name;
        this.boxId = str;
        this.sharedLink = str2;
        this.itemSource = str3;
        this.error = pendingItemError;
    }

    public final ItemIdentifier getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getBoxId() {
        return this.boxId;
    }

    public final String getSharedLink() {
        return this.sharedLink;
    }

    public final String getItemSource() {
        return this.itemSource;
    }

    public final PendingItemError getError() {
        return this.error;
    }

    /* JADX INFO: compiled from: ItemInfo.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J@\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0003¨\u0006\u000f"}, d2 = {"Lcom/margelo/nitro/boxcontext/ItemInfo$Companion;", "", "<init>", "()V", "fromCpp", "Lcom/margelo/nitro/boxcontext/ItemInfo;", "id", "Lcom/margelo/nitro/boxcontext/ItemIdentifier;", "name", "", "boxId", BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, "itemSource", "error", "Lcom/margelo/nitro/boxcontext/PendingItemError;", "cirrus_box-context_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final ItemInfo fromCpp(ItemIdentifier id, String name, String boxId, String sharedLink, String itemSource, PendingItemError error) {
            return new ItemInfo(id, name, boxId, sharedLink, itemSource, error);
        }
    }
}
