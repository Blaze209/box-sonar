package com.box.android.routers;

import com.box.android.browse.cpl.browse.BrowseReducer;
import com.box.android.utilities.DataClassUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NavigationRouter.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class NavigationRouter$initBrowseNavigation$2$10 extends FunctionReferenceImpl implements Function1<BrowseReducer.Action, BrowseReducer.Action> {
    public static final NavigationRouter$initBrowseNavigation$2$10 INSTANCE = new NavigationRouter$initBrowseNavigation$2$10();

    NavigationRouter$initBrowseNavigation$2$10() {
        super(1, DataClassUtilsKt.class, "self", "self(Ljava/lang/Object;)Ljava/lang/Object;", 1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final BrowseReducer.Action invoke(BrowseReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return (BrowseReducer.Action) DataClassUtilsKt.self(p0);
    }
}
