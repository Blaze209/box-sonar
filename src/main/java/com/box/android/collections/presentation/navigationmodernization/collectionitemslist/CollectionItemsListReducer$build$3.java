package com.box.android.collections.presentation.navigationmodernization.collectionitemslist;

import com.box.android.base.presentation.multiselect.MultiselectReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollectionItemsListReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class CollectionItemsListReducer$build$3 extends FunctionReferenceImpl implements Function1<MultiselectReducer.Action, CollectionItemsListReducer.Action.Multiselect> {
    public static final CollectionItemsListReducer$build$3 INSTANCE = new CollectionItemsListReducer$build$3();

    CollectionItemsListReducer$build$3() {
        super(1, CollectionItemsListReducer.Action.Multiselect.class, "<init>", "<init>(Lcom/box/android/base/presentation/multiselect/MultiselectReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final CollectionItemsListReducer.Action.Multiselect invoke(MultiselectReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new CollectionItemsListReducer.Action.Multiselect(p0);
    }
}
