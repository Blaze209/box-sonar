package com.box.android.search.presentation.cpl;

import com.box.android.base.presentation.multiselect.MultiselectReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchReducer.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class SearchReducer$build$4 extends FunctionReferenceImpl implements Function1<MultiselectReducer.Action, SearchReducer.Action.Multiselect> {
    public static final SearchReducer$build$4 INSTANCE = new SearchReducer$build$4();

    SearchReducer$build$4() {
        super(1, SearchReducer.Action.Multiselect.class, "<init>", "<init>(Lcom/box/android/base/presentation/multiselect/MultiselectReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final SearchReducer.Action.Multiselect invoke(MultiselectReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new SearchReducer.Action.Multiselect(p0);
    }
}
