package com.pspdfkit.internal;

import android.view.MotionEvent;

/* JADX INFO: loaded from: classes3.dex */
public interface xi {
    boolean a(MotionEvent motionEvent);

    boolean a(vi viVar, MotionEvent motionEvent);

    void b(MotionEvent motionEvent);

    void c(MotionEvent motionEvent);

    boolean d(MotionEvent motionEvent);

    boolean onDoubleTap(MotionEvent motionEvent);

    void onDown(MotionEvent motionEvent);

    boolean onLongPress(MotionEvent motionEvent);

    boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2);
}
