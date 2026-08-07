package com.microsoft.intune.mam.client.view;

import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public interface TextViewBehavior extends ViewBehavior {
    void init(HookedTextView hookedTextView);

    boolean onDragEvent(DragEvent dragEvent);

    boolean onTextContextMenuItem(int i);

    boolean onTouchEvent(MotionEvent motionEvent);

    boolean performLongClick();

    void setOnLongClickListener(View.OnLongClickListener onLongClickListener);
}
