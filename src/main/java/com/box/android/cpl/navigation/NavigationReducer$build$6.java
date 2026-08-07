package com.box.android.cpl.navigation;

import com.box.android.browse.cpl.recents.RecentsReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NavigationReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class NavigationReducer$build$6 extends FunctionReferenceImpl implements Function1<RecentsReducer.Action, NavigationReducer.Action.NavigationRecentsAction> {
    public static final NavigationReducer$build$6 INSTANCE = new NavigationReducer$build$6();

    NavigationReducer$build$6() {
        super(1, NavigationReducer.Action.NavigationRecentsAction.class, "<init>", "<init>(Lcom/box/android/browse/cpl/recents/RecentsReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final NavigationReducer.Action.NavigationRecentsAction invoke(RecentsReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new NavigationReducer.Action.NavigationRecentsAction(p0);
    }
}
