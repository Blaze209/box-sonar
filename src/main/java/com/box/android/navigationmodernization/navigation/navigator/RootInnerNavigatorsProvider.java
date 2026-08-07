package com.box.android.navigationmodernization.navigation.navigator;

import com.box.android.browse.search.navigation.FilesSearchNavigator;
import com.box.android.search.navigation.SearchNavigator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RootInnerNavigatorsProvider.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/navigationmodernization/navigation/navigator/RootInnerNavigatorsProvider;", "", "filesSearchNavigator", "Lcom/box/android/browse/search/navigation/FilesSearchNavigator;", "searchNavigator", "Lcom/box/android/search/navigation/SearchNavigator;", "<init>", "(Lcom/box/android/browse/search/navigation/FilesSearchNavigator;Lcom/box/android/search/navigation/SearchNavigator;)V", "getFilesSearchNavigator", "()Lcom/box/android/browse/search/navigation/FilesSearchNavigator;", "getSearchNavigator", "()Lcom/box/android/search/navigation/SearchNavigator;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RootInnerNavigatorsProvider {
    public static final int $stable = SearchNavigator.$stable | FilesSearchNavigator.$stable;
    private final FilesSearchNavigator filesSearchNavigator;
    private final SearchNavigator searchNavigator;

    public RootInnerNavigatorsProvider(FilesSearchNavigator filesSearchNavigator, SearchNavigator searchNavigator) {
        Intrinsics.checkNotNullParameter(filesSearchNavigator, "filesSearchNavigator");
        Intrinsics.checkNotNullParameter(searchNavigator, "searchNavigator");
        this.filesSearchNavigator = filesSearchNavigator;
        this.searchNavigator = searchNavigator;
    }

    public final FilesSearchNavigator getFilesSearchNavigator() {
        return this.filesSearchNavigator;
    }

    public final SearchNavigator getSearchNavigator() {
        return this.searchNavigator;
    }
}
