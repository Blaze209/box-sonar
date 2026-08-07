package com.box.android.collections.presentation.navigationmodernization;

import com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollectionsReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class CollectionsReducer$build$3 extends FunctionReferenceImpl implements Function1<CollectionsListReducer.Action, CollectionsReducer.Action.CollectionsListAction> {
    public static final CollectionsReducer$build$3 INSTANCE = new CollectionsReducer$build$3();

    CollectionsReducer$build$3() {
        super(1, CollectionsReducer.Action.CollectionsListAction.class, "<init>", "<init>(Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final CollectionsReducer.Action.CollectionsListAction invoke(CollectionsListReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new CollectionsReducer.Action.CollectionsListAction(p0);
    }
}
