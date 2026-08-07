package com.pspdfkit.internal;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public final class v70<T extends ViewModel> implements ViewModelProvider.Factory {
    public final Function0<T> a;

    /* JADX WARN: Multi-variable type inference failed */
    public v70(Function0<? extends T> function0) {
        function0.getClass();
        this.a = function0;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final <T extends ViewModel> T create(Class<T> cls, CreationExtras creationExtras) {
        cls.getClass();
        creationExtras.getClass();
        T tInvoke = this.a.invoke();
        tInvoke.getClass();
        return tInvoke;
    }
}
