package com.box.android.domain.models;

import com.box.android.domain.models.item.ItemType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemId.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0004*\u00020\u0001\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\b\u001a\n\u0010\t\u001a\u00020\u0007*\u00020\b\u001a\n\u0010\n\u001a\u00020\u0007*\u00020\b\u001a\n\u0010\u000b\u001a\u00020\b*\u00020\u0004\u001a\n\u0010\f\u001a\u00020\b*\u00020\u0004¨\u0006\r"}, d2 = {"fromPrefix", "Lcom/box/android/domain/models/item/ItemType;", "Lcom/box/android/domain/models/item/ItemType$Companion;", "prefix", "", "getPrefix", "isFolder", "", "Lcom/box/android/domain/models/ItemId$Remote;", "isFile", "isNotFolder", "toFolderRemoteId", "toFileRemoteId", "domain_prodRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ItemIdKt {

    /* JADX INFO: compiled from: ItemId.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ItemType.values().length];
            try {
                iArr[ItemType.FILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ItemType.FOLDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ItemType.WEBLINK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final ItemType fromPrefix(ItemType.Companion companion, String prefix) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        int iHashCode = prefix.hashCode();
        if (iHashCode != 100) {
            if (iHashCode != 102) {
                if (iHashCode == 119 && prefix.equals("w")) {
                    return ItemType.WEBLINK;
                }
            } else if (prefix.equals("f")) {
                return ItemType.FILE;
            }
        } else if (prefix.equals("d")) {
            return ItemType.FOLDER;
        }
        throw new IllegalStateException("No ItemType associated with prefix " + prefix);
    }

    public static final String getPrefix(ItemType itemType) {
        Intrinsics.checkNotNullParameter(itemType, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[itemType.ordinal()];
        if (i == 1) {
            return "f";
        }
        if (i == 2) {
            return "d";
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return "w";
    }

    public static final boolean isFolder(ItemId.Remote remote) {
        Intrinsics.checkNotNullParameter(remote, "<this>");
        return remote.getType() == ItemType.FOLDER;
    }

    public static final boolean isFile(ItemId.Remote remote) {
        Intrinsics.checkNotNullParameter(remote, "<this>");
        return remote.getType() == ItemType.FILE;
    }

    public static final boolean isNotFolder(ItemId.Remote remote) {
        Intrinsics.checkNotNullParameter(remote, "<this>");
        return !isFolder(remote);
    }

    public static final ItemId.Remote toFolderRemoteId(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new ItemId.Remote(str, ItemType.FOLDER);
    }

    public static final ItemId.Remote toFileRemoteId(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new ItemId.Remote(str, ItemType.FILE);
    }
}
