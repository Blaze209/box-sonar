package com.pspdfkit.internal;

import com.pspdfkit.contentediting.models.Alignment;
import com.pspdfkit.contentediting.models.StyleInfo;

/* JADX INFO: loaded from: classes3.dex */
public interface mb {
    ya<g70> a(i50 i50Var, Alignment alignment);

    ya<g70> a(i50 i50Var, StyleInfo styleInfo);

    default ya<g70> a(i50 i50Var, b9 b9Var) {
        i50Var.getClass();
        int i = b9Var.a;
        return i == b9Var.b ? a(i50Var, Integer.valueOf(i), (b9) null) : a(i50Var, (Integer) null, b9Var);
    }

    ya<g70> a(i50 i50Var, Float f);

    ya<g70> a(i50 i50Var, Integer num, b9 b9Var);

    ya<g70> a(i50 i50Var, String str, Integer num);

    default ya<g70> b(i50 i50Var, String str, int i, int i2) {
        i50Var.getClass();
        str.getClass();
        i50Var.a(a(i50Var, new b9(i, i2)).a);
        return a(i50Var, str, (Integer) null);
    }

    ya<g70> c(i50 i50Var, int i, int i2);

    default ya<g70> b(i50 i50Var, int i, int i2) {
        i50Var.getClass();
        return c(i50Var, i50Var.a(i), i50Var.a(i2));
    }

    default ya<g70> a(i50 i50Var, int i, int i2) {
        i50Var.getClass();
        return a(i50Var, new b9(i50Var.a(i), i50Var.a(i2)));
    }

    default ya<g70> a(i50 i50Var, String str, int i) {
        i50Var.getClass();
        str.getClass();
        return a(i50Var, str, Integer.valueOf(i50Var.a(i)));
    }

    default ya<g70> a(i50 i50Var, String str, int i, int i2) {
        i50Var.getClass();
        str.getClass();
        return b(i50Var, str, i50Var.a(i), i50Var.a(i2));
    }
}
