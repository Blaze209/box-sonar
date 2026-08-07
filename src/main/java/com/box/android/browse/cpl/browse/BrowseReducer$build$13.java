package com.box.android.browse.cpl.browse;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BrowseReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class BrowseReducer$build$13 extends FunctionReferenceImpl implements Function1<BrowseReducer.Action, BrowseReducer.Action.ChildBrowseAction> {
    public static final BrowseReducer$build$13 INSTANCE = new BrowseReducer$build$13();

    BrowseReducer$build$13() {
        super(1, BrowseReducer.Action.ChildBrowseAction.class, "<init>", "<init>(Lcom/box/android/browse/cpl/browse/BrowseReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final BrowseReducer.Action.ChildBrowseAction invoke(BrowseReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new BrowseReducer.Action.ChildBrowseAction(p0);
    }
}
