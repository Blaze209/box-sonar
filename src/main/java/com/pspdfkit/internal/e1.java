package com.pspdfkit.internal;

import com.pspdfkit.annotations.Annotation;

/* JADX INFO: loaded from: classes3.dex */
public class e1 {
    public Annotation a;

    public e1() {
        this.a = null;
    }

    public Annotation a() {
        return this.a;
    }

    public boolean b() {
        return a() != null;
    }

    public void c() {
        d();
    }

    public void d() {
        this.a = null;
    }

    public boolean e() {
        return false;
    }

    public e1(Annotation annotation, int i) {
        this.a = annotation;
    }
}
