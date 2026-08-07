package com.pspdfkit.internal;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes3.dex */
public final class g00 extends ReentrantReadWriteLock {
    public final String a;
    public final h00 b;

    public g00(String str, h00 h00Var) {
        str.getClass();
        this.a = str;
        this.b = h00Var;
    }

    public final void finalize() {
        h00 h00Var = this.b;
        h00Var.getClass();
        synchronized (h00Var.a) {
            h00Var.a.remove(this.a);
        }
    }
}
