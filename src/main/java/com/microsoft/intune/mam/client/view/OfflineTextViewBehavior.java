package com.microsoft.intune.mam.client.view;

import android.view.ActionMode;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

/* JADX INFO: loaded from: classes3.dex */
public class OfflineTextViewBehavior implements TextViewBehavior {
    HookedTextView mView;

    @Override // com.microsoft.intune.mam.client.view.TextViewBehavior
    public boolean onDragEvent(DragEvent dragEvent) {
        return false;
    }

    @Override // com.microsoft.intune.mam.client.view.TextViewBehavior
    public boolean onTextContextMenuItem(int i) {
        return false;
    }

    @Override // com.microsoft.intune.mam.client.view.TextViewBehavior
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.microsoft.intune.mam.client.view.TextViewBehavior
    public boolean performLongClick() {
        return false;
    }

    @Override // com.microsoft.intune.mam.client.view.TextViewBehavior
    public void init(HookedTextView hookedTextView) {
        this.mView = hookedTextView;
    }

    @Override // com.microsoft.intune.mam.client.view.ViewBehavior
    public ActionMode startActionMode(ActionMode.Callback callback, int i) {
        return this.mView.startActionModeMAM(callback, i);
    }

    @Override // com.microsoft.intune.mam.client.view.ViewBehavior
    public ActionMode startActionModeMAM(ActionMode.Callback callback, int i) {
        return this.mView.realStartActionMode(callback, i);
    }

    @Override // com.microsoft.intune.mam.client.view.TextViewBehavior
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mView.realSetOnLongClickListener(onLongClickListener);
    }

    @Override // com.microsoft.intune.mam.client.view.ViewBehavior
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return this.mView.onMAMCreateInputConnection(editorInfo);
    }

    @Override // com.microsoft.intune.mam.client.view.ViewBehavior
    public InputConnection onMAMCreateInputConnection(EditorInfo editorInfo) {
        return this.mView.realOnCreateInputConnection(editorInfo);
    }
}
