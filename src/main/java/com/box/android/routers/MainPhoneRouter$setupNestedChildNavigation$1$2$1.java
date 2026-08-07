package com.box.android.routers;

import com.box.android.browse.cpl.browse.BrowseReducer;
import com.box.android.cpl.mainphone.MainPhoneReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MainPhoneRouter.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class MainPhoneRouter$setupNestedChildNavigation$1$2$1 extends FunctionReferenceImpl implements Function1<BrowseReducer.Action, MainPhoneReducer.Action.BrowseNestedAction> {
    public static final MainPhoneRouter$setupNestedChildNavigation$1$2$1 INSTANCE = new MainPhoneRouter$setupNestedChildNavigation$1$2$1();

    MainPhoneRouter$setupNestedChildNavigation$1$2$1() {
        super(1, MainPhoneReducer.Action.BrowseNestedAction.class, "<init>", "<init>(Lcom/box/android/browse/cpl/browse/BrowseReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final MainPhoneReducer.Action.BrowseNestedAction invoke(BrowseReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new MainPhoneReducer.Action.BrowseNestedAction(p0);
    }
}
