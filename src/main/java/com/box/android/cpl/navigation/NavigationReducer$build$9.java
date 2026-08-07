package com.box.android.cpl.navigation;

import com.box.android.browse.cpl.offlined.OfflinedReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NavigationReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class NavigationReducer$build$9 extends FunctionReferenceImpl implements Function1<OfflinedReducer.Action, NavigationReducer.Action.NavigationOfflinedAction> {
    public static final NavigationReducer$build$9 INSTANCE = new NavigationReducer$build$9();

    NavigationReducer$build$9() {
        super(1, NavigationReducer.Action.NavigationOfflinedAction.class, "<init>", "<init>(Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final NavigationReducer.Action.NavigationOfflinedAction invoke(OfflinedReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new NavigationReducer.Action.NavigationOfflinedAction(p0);
    }
}
