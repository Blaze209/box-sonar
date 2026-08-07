package com.box.android.search.presentation.cpl;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchReducer.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class SearchReducer$build$10 extends FunctionReferenceImpl implements Function1<FilesSearchReducer.Action, SearchReducer.Action.FilesSearch> {
    public static final SearchReducer$build$10 INSTANCE = new SearchReducer$build$10();

    SearchReducer$build$10() {
        super(1, SearchReducer.Action.FilesSearch.class, "<init>", "<init>(Lcom/box/android/search/presentation/cpl/FilesSearchReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final SearchReducer.Action.FilesSearch invoke(FilesSearchReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new SearchReducer.Action.FilesSearch(p0);
    }
}
