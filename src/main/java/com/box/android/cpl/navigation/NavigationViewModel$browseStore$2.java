package com.box.android.cpl.navigation;

import com.box.android.browse.cpl.browse.BrowseReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NavigationViewModel.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class NavigationViewModel$browseStore$2 extends FunctionReferenceImpl implements Function1<BrowseReducer.Action, NavigationReducer.Action.NavigationBrowseAction> {
    public static final NavigationViewModel$browseStore$2 INSTANCE = new NavigationViewModel$browseStore$2();

    NavigationViewModel$browseStore$2() {
        super(1, NavigationReducer.Action.NavigationBrowseAction.class, "<init>", "<init>(Lcom/box/android/browse/cpl/browse/BrowseReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final NavigationReducer.Action.NavigationBrowseAction invoke(BrowseReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new NavigationReducer.Action.NavigationBrowseAction(p0);
    }
}
