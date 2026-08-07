package com.pspdfkit.internal;

import io.reactivex.rxjava3.functions.Consumer;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes3.dex */
public final class f6<T> implements Consumer {
    public final /* synthetic */ i6 a;

    public f6(i6 i6Var) {
        this.a = i6Var;
    }

    @Override // io.reactivex.rxjava3.functions.Consumer
    public final void accept(Object obj) {
        Throwable th = (Throwable) obj;
        th.getClass();
        i6 i6Var = this.a;
        i6Var.getClass();
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new z5(i6Var, th, null), 3, null);
    }
}
