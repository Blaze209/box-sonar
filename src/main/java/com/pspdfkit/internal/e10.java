package com.pspdfkit.internal;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import io.nutrient.ui.settings.SettingsOptions;
import kotlin.Metadata;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/pspdfkit/internal/e10;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class e10 extends ViewModel {
    public static final a d = new a();
    public final MutableStateFlow<z00> a;
    public final StateFlow<z00> b;
    public SettingsOptions c;

    public static final class a implements ViewModelProvider.Factory {
        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public final <T extends ViewModel> T create(Class<T> cls, CreationExtras creationExtras) {
            cls.getClass();
            creationExtras.getClass();
            return new e10();
        }
    }

    public e10() {
        MutableStateFlow<z00> MutableStateFlow = StateFlowKt.MutableStateFlow(new z00(0));
        this.a = MutableStateFlow;
        StateFlow<z00> stateFlowAsStateFlow = FlowKt.asStateFlow(MutableStateFlow);
        this.b = stateFlowAsStateFlow;
        this.c = stateFlowAsStateFlow.getValue().a;
    }
}
