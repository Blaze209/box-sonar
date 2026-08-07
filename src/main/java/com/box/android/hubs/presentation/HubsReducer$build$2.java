package com.box.android.hubs.presentation;

import com.box.android.cpl.ReducerResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HubsReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class HubsReducer$build$2 extends FunctionReferenceImpl implements Function2<HubsReducer.State, HubsReducer.Action, ReducerResult<HubsReducer.State, HubsReducer.Action>> {
    HubsReducer$build$2(Object obj) {
        super(2, obj, HubsReducer.class, "reduceHubs", "reduceHubs(Lcom/box/android/hubs/presentation/HubsReducer$State;Lcom/box/android/hubs/presentation/HubsReducer$Action;)Lcom/box/android/cpl/ReducerResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final ReducerResult<HubsReducer.State, HubsReducer.Action> invoke(HubsReducer.State p0, HubsReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return ((HubsReducer) this.receiver).reduceHubs(p0, p1);
    }
}
