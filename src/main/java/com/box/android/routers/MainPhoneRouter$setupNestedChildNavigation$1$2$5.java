package com.box.android.routers;

import com.box.android.cpl.mainphone.MainPhoneReducer;
import com.box.android.utilities.DataClassUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MainPhoneRouter.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class MainPhoneRouter$setupNestedChildNavigation$1$2$5 extends FunctionReferenceImpl implements Function1<MainPhoneReducer.Action, MainPhoneReducer.Action> {
    public static final MainPhoneRouter$setupNestedChildNavigation$1$2$5 INSTANCE = new MainPhoneRouter$setupNestedChildNavigation$1$2$5();

    MainPhoneRouter$setupNestedChildNavigation$1$2$5() {
        super(1, DataClassUtilsKt.class, "self", "self(Ljava/lang/Object;)Ljava/lang/Object;", 1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final MainPhoneReducer.Action invoke(MainPhoneReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return (MainPhoneReducer.Action) DataClassUtilsKt.self(p0);
    }
}
