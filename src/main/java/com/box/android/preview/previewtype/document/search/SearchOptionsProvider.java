package com.box.android.preview.previewtype.document.search;

import com.pspdfkit.datastructures.Range;
import com.pspdfkit.document.search.SearchOptions;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchOptionsProvider.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¨\u0006\t"}, d2 = {"Lcom/box/android/preview/previewtype/document/search/SearchOptionsProvider;", "", "<init>", "()V", "getSearchOptions", "Lcom/pspdfkit/document/search/SearchOptions;", "priorityPages", "", "Lcom/pspdfkit/datastructures/Range;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SearchOptionsProvider {
    public static final int $stable = 0;

    @Inject
    public SearchOptionsProvider() {
    }

    public final SearchOptions getSearchOptions(List<? extends Range> priorityPages) {
        Intrinsics.checkNotNullParameter(priorityPages, "priorityPages");
        SearchOptions searchOptionsBuild = new SearchOptions.Builder().priorityPages(priorityPages).build();
        Intrinsics.checkNotNullExpressionValue(searchOptionsBuild, "build(...)");
        return searchOptionsBuild;
    }
}
