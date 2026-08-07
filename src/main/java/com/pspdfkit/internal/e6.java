package com.pspdfkit.internal;

import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes3.dex */
public final class e6<T> implements Consumer {
    public final /* synthetic */ i6 a;
    public final /* synthetic */ Function0<Unit> b;

    public e6(i6 i6Var, Function0<Unit> function0) {
        this.a = i6Var;
        this.b = function0;
    }

    @Override // io.reactivex.rxjava3.functions.Consumer
    public final void accept(Object obj) {
        j6 j6Var = (j6) obj;
        j6Var.getClass();
        i6 i6Var = this.a;
        if (i6Var.c == null) {
            return;
        }
        i6Var.e = j6Var;
        j6Var.d = i6Var;
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new c6(i6Var, null), 3, null);
        Function0<Unit> function0 = this.b;
        if (function0 != null) {
            function0.invoke();
        }
    }
}
