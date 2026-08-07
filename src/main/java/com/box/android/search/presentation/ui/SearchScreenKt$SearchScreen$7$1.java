package com.box.android.search.presentation.ui;

import com.box.android.search.presentation.cpl.SearchReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchScreen.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class SearchScreenKt$SearchScreen$7$1 extends FunctionReferenceImpl implements Function1<String, Boolean> {
    SearchScreenKt$SearchScreen$7$1(Object obj) {
        super(1, obj, SearchReducer.State.class, "isHubSelected", "isHubSelected(Ljava/lang/String;)Z", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(String p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return Boolean.valueOf(((SearchReducer.State) this.receiver).isHubSelected(p0));
    }
}
