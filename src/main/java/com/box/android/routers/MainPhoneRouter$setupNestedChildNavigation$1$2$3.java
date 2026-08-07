package com.box.android.routers;

import com.box.android.browse.cpl.CollectionReducer;
import com.box.android.cpl.mainphone.MainPhoneReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MainPhoneRouter.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class MainPhoneRouter$setupNestedChildNavigation$1$2$3 extends FunctionReferenceImpl implements Function1<CollectionReducer.Action, MainPhoneReducer.Action.CollectionAction> {
    public static final MainPhoneRouter$setupNestedChildNavigation$1$2$3 INSTANCE = new MainPhoneRouter$setupNestedChildNavigation$1$2$3();

    MainPhoneRouter$setupNestedChildNavigation$1$2$3() {
        super(1, MainPhoneReducer.Action.CollectionAction.class, "<init>", "<init>(Lcom/box/android/browse/cpl/CollectionReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final MainPhoneReducer.Action.CollectionAction invoke(CollectionReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new MainPhoneReducer.Action.CollectionAction(p0);
    }
}
