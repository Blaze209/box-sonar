package com.box.android.routers;

import com.box.android.browse.cpl.CollectionReducer;
import com.box.android.browse.cpl.browse.BrowseReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MainPhoneRouter.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class MainPhoneRouter$setupCollectionsChildNavigation$1$2$1 extends FunctionReferenceImpl implements Function1<BrowseReducer.Action, CollectionReducer.Action.ChildBrowseAction> {
    public static final MainPhoneRouter$setupCollectionsChildNavigation$1$2$1 INSTANCE = new MainPhoneRouter$setupCollectionsChildNavigation$1$2$1();

    MainPhoneRouter$setupCollectionsChildNavigation$1$2$1() {
        super(1, CollectionReducer.Action.ChildBrowseAction.class, "<init>", "<init>(Lcom/box/android/browse/cpl/browse/BrowseReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final CollectionReducer.Action.ChildBrowseAction invoke(BrowseReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new CollectionReducer.Action.ChildBrowseAction(p0);
    }
}
