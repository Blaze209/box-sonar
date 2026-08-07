package com.box.android.browse.cpl;

import com.box.android.browse.cpl.browse.BrowseReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollectionReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class CollectionReducer$build$4 extends FunctionReferenceImpl implements Function1<BrowseReducer.Action, CollectionReducer.Action.ChildBrowseAction> {
    public static final CollectionReducer$build$4 INSTANCE = new CollectionReducer$build$4();

    CollectionReducer$build$4() {
        super(1, CollectionReducer.Action.ChildBrowseAction.class, "<init>", "<init>(Lcom/box/android/browse/cpl/browse/BrowseReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final CollectionReducer.Action.ChildBrowseAction invoke(BrowseReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new CollectionReducer.Action.ChildBrowseAction(p0);
    }
}
