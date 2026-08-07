package com.box.android.routers;

import com.box.android.browse.cpl.offlined.OfflinedReducer;
import com.box.android.utilities.DataClassUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NavigationRouter.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class NavigationRouter$initOfflinedNavigation$2$3 extends FunctionReferenceImpl implements Function1<OfflinedReducer.Action, OfflinedReducer.Action> {
    public static final NavigationRouter$initOfflinedNavigation$2$3 INSTANCE = new NavigationRouter$initOfflinedNavigation$2$3();

    NavigationRouter$initOfflinedNavigation$2$3() {
        super(1, DataClassUtilsKt.class, "self", "self(Ljava/lang/Object;)Ljava/lang/Object;", 1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final OfflinedReducer.Action invoke(OfflinedReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return (OfflinedReducer.Action) DataClassUtilsKt.self(p0);
    }
}
