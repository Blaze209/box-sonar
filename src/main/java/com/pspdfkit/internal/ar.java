package com.pspdfkit.internal;

import com.pspdfkit.analytics.AnalyticsClient;
import com.pspdfkit.configuration.policy.ApplicationPolicy;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes3.dex */
public final class ar {
    public static j0 a = null;
    public static tg b = null;
    public static i0 c = null;
    public static ew d = null;
    public static k e = null;
    public static ApplicationPolicy f = null;
    public static e50 g = null;
    public static d1 h = null;
    public static h00 i = null;
    public static k10 j = null;
    public static boolean k = false;

    public static synchronized i0 a() {
        if (c == null) {
            c = new i0();
        }
        return c;
    }

    public static synchronized tg b() {
        if (b == null) {
            b = new tg();
        }
        return b;
    }

    public static synchronized e50 c() {
        if (g == null) {
            g = new e50(Collections.EMPTY_LIST);
        }
        return g;
    }

    public static synchronized g60 d() {
        return q10.c();
    }

    public static synchronized void e() {
        i0 i0Var = c;
        if (i0Var != null) {
            for (AnalyticsClient analyticsClient : i0Var.a.keySet()) {
                uw.a(analyticsClient, "client", null);
                if (i0Var.a.containsKey(analyticsClient)) {
                    ((Disposable) i0Var.a.remove(analyticsClient)).dispose();
                }
            }
        }
        f();
        ut utVar = q10.b;
        if (utVar != null) {
            utVar.a.clear();
            utVar.b.a.evictAll();
        }
        q10.b = null;
        y7 y7Var = q10.c;
        if (y7Var != null) {
            y7Var.a();
        }
        q10.c = null;
        f = null;
        d1 d1Var = h;
        if (d1Var != null) {
            ArrayList arrayList = d1Var.b;
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                ((e1) obj).c();
            }
            d1Var.b.clear();
            d1Var.d = false;
            h = null;
        }
        g = null;
        k = false;
    }

    public static synchronized void f() {
        tg tgVar = b;
        if (tgVar != null) {
            tgVar.c();
            b = null;
        }
        j3.l.set(-1);
        j3.m++;
    }
}
