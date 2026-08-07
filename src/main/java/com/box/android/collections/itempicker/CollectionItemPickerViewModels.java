package com.box.android.collections.itempicker;

import androidx.compose.runtime.Composer;
import com.box.android.browse.cpl.itempicker.FolderItemPickerViewModel;
import com.box.android.collections.presentation.navigationmodernization.CollectionsViewModel;
import com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollectionItemPickerScreen.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B@\u0012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005\u0012\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\u0002\b\u0005\u0012\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\t0\u0003¢\u0006\u0002\b\u0005¢\u0006\u0004\b\n\u0010\u000bR\u001e\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\u0002\b\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u001e\u0010\b\u001a\r\u0012\u0004\u0012\u00020\t0\u0003¢\u0006\u0002\b\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0010\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/box/android/collections/itempicker/CollectionItemPickerViewModels;", "", "collectionsViewModel", "Lkotlin/Function0;", "Lcom/box/android/collections/presentation/navigationmodernization/CollectionsViewModel;", "Landroidx/compose/runtime/Composable;", "collectionItemsListViewModel", "Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListViewModel;", "folderItemPickerViewModel", "Lcom/box/android/browse/cpl/itempicker/FolderItemPickerViewModel;", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "getCollectionsViewModel", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "getCollectionItemsListViewModel", "getFolderItemPickerViewModel", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CollectionItemPickerViewModels {
    public static final int $stable = 0;
    private final Function2<Composer, Integer, CollectionItemsListViewModel> collectionItemsListViewModel;
    private final Function2<Composer, Integer, CollectionsViewModel> collectionsViewModel;
    private final Function2<Composer, Integer, FolderItemPickerViewModel> folderItemPickerViewModel;

    /* JADX WARN: Multi-variable type inference failed */
    public CollectionItemPickerViewModels(Function2<? super Composer, ? super Integer, CollectionsViewModel> collectionsViewModel, Function2<? super Composer, ? super Integer, CollectionItemsListViewModel> collectionItemsListViewModel, Function2<? super Composer, ? super Integer, FolderItemPickerViewModel> folderItemPickerViewModel) {
        Intrinsics.checkNotNullParameter(collectionsViewModel, "collectionsViewModel");
        Intrinsics.checkNotNullParameter(collectionItemsListViewModel, "collectionItemsListViewModel");
        Intrinsics.checkNotNullParameter(folderItemPickerViewModel, "folderItemPickerViewModel");
        this.collectionsViewModel = collectionsViewModel;
        this.collectionItemsListViewModel = collectionItemsListViewModel;
        this.folderItemPickerViewModel = folderItemPickerViewModel;
    }

    public final Function2<Composer, Integer, CollectionsViewModel> getCollectionsViewModel() {
        return this.collectionsViewModel;
    }

    public final Function2<Composer, Integer, CollectionItemsListViewModel> getCollectionItemsListViewModel() {
        return this.collectionItemsListViewModel;
    }

    public final Function2<Composer, Integer, FolderItemPickerViewModel> getFolderItemPickerViewModel() {
        return this.folderItemPickerViewModel;
    }
}
