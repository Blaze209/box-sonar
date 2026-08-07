package com.pspdfkit.internal;

import io.reactivex.rxjava3.functions.Consumer;

/* JADX INFO: loaded from: classes3.dex */
public final class mi<T> implements Consumer {
    public final /* synthetic */ li a;

    public mi(li liVar) {
        this.a = liVar;
    }

    @Override // io.reactivex.rxjava3.functions.Consumer
    public final void accept(Object obj) {
        ((Long) obj).getClass();
        li liVar = this.a;
        liVar.r = null;
        i3 i3Var = liVar.q;
        if (i3Var != null) {
            i3Var.c();
        }
        liVar.q = null;
    }
}
