package com.box.android.cpl.mainphone;

import com.box.android.cpl.ReducerResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MainPhoneReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class MainPhoneReducer$build$1 extends FunctionReferenceImpl implements Function2<MainPhoneReducer.State, MainPhoneReducer.Action, ReducerResult<MainPhoneReducer.State, MainPhoneReducer.Action>> {
    MainPhoneReducer$build$1(Object obj) {
        super(2, obj, MainPhoneReducer.class, "reduceMainPhone", "reduceMainPhone(Lcom/box/android/cpl/mainphone/MainPhoneReducer$State;Lcom/box/android/cpl/mainphone/MainPhoneReducer$Action;)Lcom/box/android/cpl/ReducerResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final ReducerResult<MainPhoneReducer.State, MainPhoneReducer.Action> invoke(MainPhoneReducer.State p0, MainPhoneReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return ((MainPhoneReducer) this.receiver).reduceMainPhone(p0, p1);
    }
}
