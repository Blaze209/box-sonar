package com.pspdfkit.internal;

import android.os.Bundle;
import android.os.Looper;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class d00 {
    public final FragmentManager a;
    public final String b;
    public final Object c;

    public d00(FragmentManager fragmentManager, String str, tk tkVar) {
        this.a = fragmentManager;
        this.b = str;
        this.c = tkVar;
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [com.pspdfkit.internal.tk, java.lang.Object] */
    public final sk a() {
        FragmentManager fragmentManager = this.a;
        String str = this.b;
        int i = sk.c;
        sk skVar = (sk) fragmentManager.findFragmentByTag(str);
        if (skVar == null) {
            skVar = new sk();
            str.getClass();
            if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                throw new IllegalStateException("addFragment() may only be called from the main thread.");
            }
            if (!skVar.isAdded()) {
                FragmentTransaction fragmentTransactionAdd = fragmentManager.beginTransaction().add(skVar, str);
                fragmentTransactionAdd.getClass();
                fragmentTransactionAdd.commitAllowingStateLoss();
            }
        }
        ?? r5 = this.c;
        skVar.a = r5;
        Bundle bundle = skVar.b;
        if (bundle != null) {
            skVar.b = bundle;
            if (r5.onRestoreInstanceState(bundle)) {
                skVar.b = null;
            }
        }
        return skVar;
    }
}
