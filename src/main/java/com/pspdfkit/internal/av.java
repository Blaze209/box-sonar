package com.pspdfkit.internal;

import com.pspdfkit.listeners.OnMenuItemsGenerateListener;

/* JADX INFO: loaded from: classes3.dex */
public final class av {
    public final bv a;
    public final OnMenuItemsGenerateListener b;
    public final a c;
    public boolean d;

    public interface a {
        int onGetShowAsAction(int i, int i2);
    }

    public av(bv bvVar, OnMenuItemsGenerateListener onMenuItemsGenerateListener, a aVar) {
        onMenuItemsGenerateListener.getClass();
        aVar.getClass();
        this.a = bvVar;
        this.b = onMenuItemsGenerateListener;
        this.c = aVar;
        this.d = true;
    }
}
