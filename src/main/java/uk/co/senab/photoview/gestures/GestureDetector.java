package uk.co.senab.photoview.gestures;

import android.view.MotionEvent;

/* JADX INFO: loaded from: classes6.dex */
public interface GestureDetector {
    boolean isScaling();

    boolean onTouchEvent(MotionEvent motionEvent);

    void setOnGestureListener(OnGestureListener onGestureListener);
}
