package com.pspdfkit.internal;

import androidx.fragment.app.FragmentActivity;
import com.pspdfkit.internal.jni.NativePageCache;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes3.dex */
public final class q10 {
    public static final q10 a = new q10();
    public static ut b;
    public static y7 c;
    public static m0 d;
    public static da e;

    @JvmStatic
    public static final synchronized g60 c() {
        m0 m0Var = d;
        if (m0Var != null) {
            return m0Var;
        }
        m0 m0Var2 = new m0();
        d = m0Var2;
        return m0Var2;
    }

    public final synchronized ut a() {
        ut utVar = b;
        if (utVar != null) {
            return utVar;
        }
        ut utVar2 = new ut(NativePageCache.create(15728640));
        b = utVar2;
        return utVar2;
    }

    public final synchronized y7 b() {
        y7 y7Var = c;
        if (y7Var != null) {
            return y7Var;
        }
        y7 y7Var2 = new y7();
        c = y7Var2;
        return y7Var2;
    }

    @JvmStatic
    public static final synchronized da a(FragmentActivity fragmentActivity) {
        da daVar;
        fragmentActivity.getClass();
        daVar = new da(fragmentActivity);
        e = daVar;
        return daVar;
    }
}
