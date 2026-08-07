package com.box.android.domain.mappers;

import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.ItemType;
import com.box.android.domain.models.item.RecentFileModel;
import com.box.android.domain.models.item.UnknownItemModel;
import com.box.android.domain.models.item.WebLinkModel;
import com.box.androidsdk.content.models.BoxBookmark;
import com.box.androidsdk.content.models.BoxEntity;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.box.boxandroidlibv2private.model.BoxRecentBoxFile;
import com.eclipsesource.json.JsonObject;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemModelMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u0006J\u0016\u0010\u0007\u001a\u00020\u0006*\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/box/android/domain/mappers/ItemModelMapper;", "", "<init>", "()V", "toItemModel", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/androidsdk/content/models/BoxItem;", "toBoxItem", "supportLegacy", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ItemModelMapper {
    public static final ItemModelMapper INSTANCE = new ItemModelMapper();

    /* JADX INFO: compiled from: ItemModelMapper.kt */
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

    private ItemModelMapper() {
    }

    public final ItemModel toItemModel(BoxItem boxItem) {
        RecentFileModel recentFileModel$default;
        Intrinsics.checkNotNullParameter(boxItem, "<this>");
        ItemId.Remote itemIdRemoteId = ItemIdRemoteIdMapper.INSTANCE.toItemIdRemoteId(boxItem);
        ItemType type = itemIdRemoteId != null ? itemIdRemoteId.getType() : null;
        int i = type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i == 1) {
            BoxRecentBoxFile boxRecentBoxFile = boxItem instanceof BoxRecentBoxFile ? (BoxRecentBoxFile) boxItem : null;
            return (boxRecentBoxFile == null || (recentFileModel$default = RecentFileModelMapper.toRecentFileModel$default(RecentFileModelMapper.INSTANCE, boxRecentBoxFile, false, 1, null)) == null) ? FileModelMapper.toFileModel$default(FileModelMapper.INSTANCE, (BoxFile) boxItem, false, 1, null) : recentFileModel$default;
        }
        if (i == 2) {
            return FolderModelMapper.toFolderModel$default(FolderModelMapper.INSTANCE, (BoxFolder) boxItem, false, 1, null);
        }
        if (i != 3) {
            return null;
        }
        return WebLinkModelMapper.toWebLinkModel$default(WebLinkModelMapper.INSTANCE, (BoxBookmark) boxItem, false, 1, null);
    }

    public static /* synthetic */ BoxItem toBoxItem$default(ItemModelMapper itemModelMapper, ItemModel itemModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return itemModelMapper.toBoxItem(itemModel, z);
    }

    @Deprecated(message = "Refactor legacy code to use ItemModel instead")
    public final BoxItem toBoxItem(ItemModel itemModel, boolean z) {
        Intrinsics.checkNotNullParameter(itemModel, "<this>");
        if (itemModel instanceof FileModel) {
            return FileModelMapper.INSTANCE.toBoxFile((FileModel) itemModel, z);
        }
        if (itemModel instanceof FolderModel) {
            return FolderModelMapper.INSTANCE.toBoxFolder((FolderModel) itemModel, z);
        }
        if (itemModel instanceof WebLinkModel) {
            return WebLinkModelMapper.INSTANCE.toBoxBookmark((WebLinkModel) itemModel, z);
        }
        if (itemModel instanceof RecentFileModel) {
            return RecentFileModelMapper.INSTANCE.toBoxRecentFile((RecentFileModel) itemModel);
        }
        if (!(itemModel instanceof UnknownItemModel)) {
            throw new NoWhenBranchMatchedException();
        }
        BoxEntity boxEntityCreateEntityFromJson = BoxItem.createEntityFromJson(new JsonObject().add("id", ItemModelMapperKt.toBoxItemId(itemModel)));
        Intrinsics.checkNotNull(boxEntityCreateEntityFromJson, "null cannot be cast to non-null type com.box.androidsdk.content.models.BoxItem");
        return (BoxItem) boxEntityCreateEntityFromJson;
    }
}
