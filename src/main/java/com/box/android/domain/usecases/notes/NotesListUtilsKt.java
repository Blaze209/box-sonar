package com.box.android.domain.usecases.notes;

import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.domain.models.CollectionModel;
import com.box.android.domain.models.CollectionType;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.ItemModelKt;
import com.box.android.domain.models.item.RecentFileModel;
import com.box.android.domain.models.item.UnknownItemModel;
import com.box.android.domain.models.item.WebLinkModel;
import com.box.android.domain.utils.SupportedFileExtensions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NotesListUtils.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0018\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0000\u001a\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0000\u001a&\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0000\u001a\u0014\u0010\u0004\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0002¨\u0006\n"}, d2 = {"filterByBoxNote", "", "Lcom/box/android/domain/models/item/ItemModel;", "withAllMarkedAsFavorite", "withIdsMarkedAsFavorite", "favoriteIds", "", "Lcom/box/android/domain/models/ItemId$Remote;", "addToFavorites", "", "domain_prodRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class NotesListUtilsKt {
    public static final List<ItemModel> filterByBoxNote(List<? extends ItemModel> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (SupportedFileExtensions.INSTANCE.isBoxNoteExtension(CommonBoxUtil.getFileExtension(((ItemModel) obj).getName(), ""))) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final List<ItemModel> withAllMarkedAsFavorite(List<? extends ItemModel> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        List<? extends ItemModel> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(withIdsMarkedAsFavorite((ItemModel) it.next(), true));
        }
        return arrayList;
    }

    public static final List<ItemModel> withIdsMarkedAsFavorite(List<? extends ItemModel> list, Set<ItemId.Remote> favoriteIds) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(favoriteIds, "favoriteIds");
        List<? extends ItemModel> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (ItemModel itemModel : list2) {
            arrayList.add(withIdsMarkedAsFavorite(itemModel, CollectionsKt.contains(favoriteIds, itemModel.getItemId())));
        }
        return arrayList;
    }

    private static final ItemModel withIdsMarkedAsFavorite(ItemModel itemModel, boolean z) {
        ArrayList arrayListPlus;
        boolean zIsInFavorites = ItemModelKt.isInFavorites(itemModel);
        if (z && !zIsInFavorites) {
            List<CollectionModel> collections = itemModel.getCollections();
            if (collections == null) {
                collections = CollectionsKt.emptyList();
            }
            arrayListPlus = CollectionsKt.plus((Collection<? extends CollectionModel>) collections, CollectionModel.INSTANCE.createFavorites(""));
        } else {
            if (z || !zIsInFavorites) {
                return itemModel;
            }
            List<CollectionModel> collections2 = itemModel.getCollections();
            if (collections2 != null) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : collections2) {
                    if (((CollectionModel) obj).getType() != CollectionType.FAVORITES) {
                        arrayList.add(obj);
                    }
                }
                arrayListPlus = arrayList;
            } else {
                arrayListPlus = null;
            }
        }
        List list = arrayListPlus;
        if (itemModel instanceof FileModel) {
            return FileModel.copy$default((FileModel) itemModel, null, null, false, false, null, null, null, null, null, null, null, false, 0L, null, null, list, null, null, null, null, null, null, null, null, null, null, null, 134184959, null);
        }
        if (itemModel instanceof RecentFileModel) {
            return RecentFileModel.copy$default((RecentFileModel) itemModel, null, null, false, false, null, null, null, null, null, null, null, false, 0L, null, null, list, null, null, null, null, null, null, null, null, null, null, null, 134184959, null);
        }
        if (itemModel instanceof FolderModel) {
            return FolderModel.copy$default((FolderModel) itemModel, null, null, false, false, null, null, null, null, null, null, null, false, null, null, null, list, null, null, null, 491519, null);
        }
        if (itemModel instanceof UnknownItemModel) {
            return UnknownItemModel.copy$default((UnknownItemModel) itemModel, null, null, false, false, null, null, null, null, null, null, null, false, 0L, null, null, list, null, null, 229375, null);
        }
        if (itemModel instanceof WebLinkModel) {
            return WebLinkModel.copy$default((WebLinkModel) itemModel, null, null, false, false, null, null, null, null, null, null, null, false, null, null, null, null, list, null, 196607, null);
        }
        throw new NoWhenBranchMatchedException();
    }
}
