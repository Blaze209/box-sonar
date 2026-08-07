package com.box.android.hubs.hubDetails.presentation;

import com.box.android.cpl.ReducerResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HubDetailsReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class HubDetailsReducer$build$1 extends FunctionReferenceImpl implements Function2<HubDetailsReducer.State, HubDetailsReducer.Action, ReducerResult<HubDetailsReducer.State, HubDetailsReducer.Action>> {
    HubDetailsReducer$build$1(Object obj) {
        super(2, obj, HubDetailsReducer.class, "reduceHubDetails", "reduceHubDetails(Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$State;Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$Action;)Lcom/box/android/cpl/ReducerResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final ReducerResult<HubDetailsReducer.State, HubDetailsReducer.Action> invoke(HubDetailsReducer.State p0, HubDetailsReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return ((HubDetailsReducer) this.receiver).reduceHubDetails(p0, p1);
    }
}
