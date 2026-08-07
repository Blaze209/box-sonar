package com.pspdfkit.internal;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes3.dex */
public interface gu {
    void a(Canvas canvas);

    void a(Matrix matrix);

    void a(q30 q30Var);

    default boolean a() {
        return !e();
    }

    boolean a(MotionEvent motionEvent);

    default boolean b() {
        return this instanceof vr;
    }

    boolean c();

    boolean d();

    default boolean e() {
        return this instanceof a3;
    }

    int f();

    void g();
}
