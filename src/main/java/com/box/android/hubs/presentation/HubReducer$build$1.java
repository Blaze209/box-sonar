package com.box.android.hubs.presentation;

import com.box.android.cpl.ReducerResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HubReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class HubReducer$build$1 extends FunctionReferenceImpl implements Function2<HubReducer.State, HubReducer.Action, ReducerResult<HubReducer.State, HubReducer.Action>> {
    HubReducer$build$1(Object obj) {
        super(2, obj, HubReducer.class, "reduceObservability", "reduceObservability(Lcom/box/android/hubs/presentation/HubReducer$State;Lcom/box/android/hubs/presentation/HubReducer$Action;)Lcom/box/android/cpl/ReducerResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final ReducerResult<HubReducer.State, HubReducer.Action> invoke(HubReducer.State p0, HubReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return ((HubReducer) this.receiver).reduceObservability(p0, p1);
    }
}
