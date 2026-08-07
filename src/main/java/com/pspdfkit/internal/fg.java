package com.pspdfkit.internal;

import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/pspdfkit/internal/fg;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class fg extends ViewModel {
    public static final /* synthetic */ int g = 0;
    public final MutableStateFlow<ag> a;
    public final StateFlow<ag> b;
    public boolean c;
    public final ArrayList d;
    public lm e;
    public eg f;

    public fg() {
        MutableStateFlow<ag> MutableStateFlow = StateFlowKt.MutableStateFlow(new ag(0));
        this.a = MutableStateFlow;
        this.b = FlowKt.asStateFlow(MutableStateFlow);
        this.d = new ArrayList();
    }

    public static final void a(fg fgVar) {
        ag value;
        ArrayList arrayList = fgVar.d;
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            CollectionsKt.addAll(arrayList2, ((vf) obj).b);
        }
        MutableStateFlow<ag> mutableStateFlow = fgVar.a;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ag.a(value, arrayList2, CollectionsKt.toList(fgVar.d), false, 0, 0, null, null, 124)));
    }

    @Override // androidx.lifecycle.ViewModel
    public final void onCleared() {
        ag value;
        lm lmVar;
        o3 annotationProvider;
        this.c = true;
        MutableStateFlow<ag> mutableStateFlow = this.a;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ag.a(value, null, null, false, 0, 0, null, null, 123)));
        eg egVar = this.f;
        if (egVar != null && (lmVar = this.e) != null && (annotationProvider = lmVar.getAnnotationProvider()) != null) {
            annotationProvider.h.b(egVar);
        }
        this.f = null;
    }
}
