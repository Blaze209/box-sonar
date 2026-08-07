package com.box.android.search.presentation.cpl;

import com.box.android.hubs.presentation.HubReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchItemReducer.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class SearchItemReducer$build$4 extends FunctionReferenceImpl implements Function1<HubReducer.Action, SearchItemReducer.Action.HubAction> {
    public static final SearchItemReducer$build$4 INSTANCE = new SearchItemReducer$build$4();

    SearchItemReducer$build$4() {
        super(1, SearchItemReducer.Action.HubAction.class, "<init>", "<init>(Lcom/box/android/hubs/presentation/HubReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final SearchItemReducer.Action.HubAction invoke(HubReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new SearchItemReducer.Action.HubAction(p0);
    }
}
