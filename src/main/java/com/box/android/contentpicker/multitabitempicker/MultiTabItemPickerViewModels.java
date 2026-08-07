package com.box.android.contentpicker.multitabitempicker;

import androidx.compose.runtime.Composer;
import com.box.android.browse.cpl.RecentsItemPickerViewModel;
import com.box.android.browse.cpl.itempicker.FolderItemPickerViewModel;
import com.box.android.collections.itempicker.CollectionItemPickerViewModels;
import com.box.android.hubs.presentation.HubsItemPickerViewModel;
import com.box.android.search.presentation.ui.SearchItemPickerViewModels;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MultiTabItemPickerScreenContent.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001Bf\u0012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005\u0012\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\u0002\b\u0005\u0012\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\t0\u0003¢\u0006\u0002\b\u0005\u0012\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u000b0\u0003¢\u0006\u0002\b\u0005\u0012\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\r0\u0003¢\u0006\u0002\b\u0005¢\u0006\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\u0002\b\u0005¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u001e\u0010\b\u001a\r\u0012\u0004\u0012\u00020\t0\u0003¢\u0006\u0002\b\u0005¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0014\u0010\u0011R\u001e\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u000b0\u0003¢\u0006\u0002\b\u0005¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0015\u0010\u0011R\u001e\u0010\f\u001a\r\u0012\u0004\u0012\u00020\r0\u0003¢\u0006\u0002\b\u0005¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0016\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/box/android/contentpicker/multitabitempicker/MultiTabItemPickerViewModels;", "", "folderItemPickerViewModel", "Lkotlin/Function0;", "Lcom/box/android/browse/cpl/itempicker/FolderItemPickerViewModel;", "Landroidx/compose/runtime/Composable;", "collectionItemPickerViewModels", "Lcom/box/android/collections/itempicker/CollectionItemPickerViewModels;", "hubItemPickerViewModel", "Lcom/box/android/hubs/presentation/HubsItemPickerViewModel;", "recentsItemPickerViewModel", "Lcom/box/android/browse/cpl/RecentsItemPickerViewModel;", "searchItemPickerViewModels", "Lcom/box/android/search/presentation/ui/SearchItemPickerViewModels;", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "getFolderItemPickerViewModel", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "getCollectionItemPickerViewModels", "getHubItemPickerViewModel", "getRecentsItemPickerViewModel", "getSearchItemPickerViewModels", "content-picker_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MultiTabItemPickerViewModels {
    public static final int $stable = 0;
    private final Function2<Composer, Integer, CollectionItemPickerViewModels> collectionItemPickerViewModels;
    private final Function2<Composer, Integer, FolderItemPickerViewModel> folderItemPickerViewModel;
    private final Function2<Composer, Integer, HubsItemPickerViewModel> hubItemPickerViewModel;
    private final Function2<Composer, Integer, RecentsItemPickerViewModel> recentsItemPickerViewModel;
    private final Function2<Composer, Integer, SearchItemPickerViewModels> searchItemPickerViewModels;

    /* JADX WARN: Multi-variable type inference failed */
    public MultiTabItemPickerViewModels(Function2<? super Composer, ? super Integer, FolderItemPickerViewModel> folderItemPickerViewModel, Function2<? super Composer, ? super Integer, CollectionItemPickerViewModels> collectionItemPickerViewModels, Function2<? super Composer, ? super Integer, HubsItemPickerViewModel> hubItemPickerViewModel, Function2<? super Composer, ? super Integer, RecentsItemPickerViewModel> recentsItemPickerViewModel, Function2<? super Composer, ? super Integer, SearchItemPickerViewModels> searchItemPickerViewModels) {
        Intrinsics.checkNotNullParameter(folderItemPickerViewModel, "folderItemPickerViewModel");
        Intrinsics.checkNotNullParameter(collectionItemPickerViewModels, "collectionItemPickerViewModels");
        Intrinsics.checkNotNullParameter(hubItemPickerViewModel, "hubItemPickerViewModel");
        Intrinsics.checkNotNullParameter(recentsItemPickerViewModel, "recentsItemPickerViewModel");
        Intrinsics.checkNotNullParameter(searchItemPickerViewModels, "searchItemPickerViewModels");
        this.folderItemPickerViewModel = folderItemPickerViewModel;
        this.collectionItemPickerViewModels = collectionItemPickerViewModels;
        this.hubItemPickerViewModel = hubItemPickerViewModel;
        this.recentsItemPickerViewModel = recentsItemPickerViewModel;
        this.searchItemPickerViewModels = searchItemPickerViewModels;
    }

    public final Function2<Composer, Integer, FolderItemPickerViewModel> getFolderItemPickerViewModel() {
        return this.folderItemPickerViewModel;
    }

    public final Function2<Composer, Integer, CollectionItemPickerViewModels> getCollectionItemPickerViewModels() {
        return this.collectionItemPickerViewModels;
    }

    public final Function2<Composer, Integer, HubsItemPickerViewModel> getHubItemPickerViewModel() {
        return this.hubItemPickerViewModel;
    }

    public final Function2<Composer, Integer, RecentsItemPickerViewModel> getRecentsItemPickerViewModel() {
        return this.recentsItemPickerViewModel;
    }

    public final Function2<Composer, Integer, SearchItemPickerViewModels> getSearchItemPickerViewModels() {
        return this.searchItemPickerViewModels;
    }
}
