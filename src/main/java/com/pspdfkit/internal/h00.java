package com.pspdfkit.internal;

import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class h00 {
    public final HashMap<String, WeakReference<g00>> a = new HashMap<>();

    public final g00 a(String str) {
        g00 g00Var;
        str.getClass();
        synchronized (this.a) {
            WeakReference<g00> weakReference = this.a.get(str);
            g00Var = weakReference != null ? weakReference.get() : null;
            if (g00Var == null) {
                g00Var = new g00(str, this);
                this.a.put(str, new WeakReference<>(g00Var));
            }
        }
        return g00Var;
    }
}
