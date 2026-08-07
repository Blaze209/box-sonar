package com.pspdfkit.internal;

import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/pspdfkit/internal/k5;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class k5 extends ViewModel {
    public final MutableStateFlow<i5> a;
    public final StateFlow<i5> b;

    public k5() {
        MutableStateFlow<i5> MutableStateFlow = StateFlowKt.MutableStateFlow(new i5(0));
        this.a = MutableStateFlow;
        this.b = FlowKt.asStateFlow(MutableStateFlow);
    }
}
