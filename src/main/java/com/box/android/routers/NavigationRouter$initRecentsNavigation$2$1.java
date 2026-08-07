package com.box.android.routers;

import com.box.android.browse.cpl.recents.RecentsReducer;
import com.box.android.utilities.DataClassUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NavigationRouter.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class NavigationRouter$initRecentsNavigation$2$1 extends FunctionReferenceImpl implements Function1<RecentsReducer.Action, RecentsReducer.Action> {
    public static final NavigationRouter$initRecentsNavigation$2$1 INSTANCE = new NavigationRouter$initRecentsNavigation$2$1();

    NavigationRouter$initRecentsNavigation$2$1() {
        super(1, DataClassUtilsKt.class, "self", "self(Ljava/lang/Object;)Ljava/lang/Object;", 1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final RecentsReducer.Action invoke(RecentsReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return (RecentsReducer.Action) DataClassUtilsKt.self(p0);
    }
}
