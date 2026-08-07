package com.box.android.search.presentation.cpl;

import com.box.android.hubs.presentation.HubReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchItemReducer.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class SearchItemReducer$build$3 extends FunctionReferenceImpl implements Function1<HubReducer.State, SearchItemReducer.SearchItem.HubItem> {
    public static final SearchItemReducer$build$3 INSTANCE = new SearchItemReducer$build$3();

    SearchItemReducer$build$3() {
        super(1, SearchItemReducer.SearchItem.HubItem.class, "<init>", "<init>(Lcom/box/android/hubs/presentation/HubReducer$State;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final SearchItemReducer.SearchItem.HubItem invoke(HubReducer.State p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new SearchItemReducer.SearchItem.HubItem(p0);
    }
}
