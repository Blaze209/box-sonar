package com.box.android.search.navigation.compose;

import android.os.Bundle;
import androidx.compose.runtime.Composer;
import com.box.android.search.presentation.vm.SearchViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchNavigationCompose.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B \u0012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006¢\u0006\u0004\b\u0007\u0010\bR$\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/box/android/search/navigation/compose/SearchViewModels;", "", "searchViewModel", "Lkotlin/Function1;", "Landroid/os/Bundle;", "Lcom/box/android/search/presentation/vm/SearchViewModel;", "Landroidx/compose/runtime/Composable;", "<init>", "(Lkotlin/jvm/functions/Function3;)V", "getSearchViewModel", "()Lkotlin/jvm/functions/Function3;", "Lkotlin/jvm/functions/Function3;", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SearchViewModels {
    public static final int $stable = 0;
    private final Function3<Bundle, Composer, Integer, SearchViewModel> searchViewModel;

    /* JADX WARN: Multi-variable type inference failed */
    public SearchViewModels(Function3<? super Bundle, ? super Composer, ? super Integer, SearchViewModel> searchViewModel) {
        Intrinsics.checkNotNullParameter(searchViewModel, "searchViewModel");
        this.searchViewModel = searchViewModel;
    }

    public final Function3<Bundle, Composer, Integer, SearchViewModel> getSearchViewModel() {
        return this.searchViewModel;
    }
}
