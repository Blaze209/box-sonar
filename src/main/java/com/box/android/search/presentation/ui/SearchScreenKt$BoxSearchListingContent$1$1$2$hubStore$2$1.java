package com.box.android.search.presentation.ui;

import com.box.android.hubs.presentation.HubReducer;
import com.box.android.search.presentation.cpl.SearchItemReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchScreen.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class SearchScreenKt$BoxSearchListingContent$1$1$2$hubStore$2$1 extends FunctionReferenceImpl implements Function1<HubReducer.Action, SearchItemReducer.Action.HubAction> {
    public static final SearchScreenKt$BoxSearchListingContent$1$1$2$hubStore$2$1 INSTANCE = new SearchScreenKt$BoxSearchListingContent$1$1$2$hubStore$2$1();

    SearchScreenKt$BoxSearchListingContent$1$1$2$hubStore$2$1() {
        super(1, SearchItemReducer.Action.HubAction.class, "<init>", "<init>(Lcom/box/android/hubs/presentation/HubReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final SearchItemReducer.Action.HubAction invoke(HubReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new SearchItemReducer.Action.HubAction(p0);
    }
}
