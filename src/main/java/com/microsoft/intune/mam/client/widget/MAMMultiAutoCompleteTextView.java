package com.microsoft.intune.mam.client.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import com.microsoft.intune.mam.client.InterfaceComponentsAccess;
import com.microsoft.intune.mam.client.view.HookedTextView;
import com.microsoft.intune.mam.client.view.TextViewBehavior;

/* JADX INFO: loaded from: classes3.dex */
public class MAMMultiAutoCompleteTextView extends MultiAutoCompleteTextView implements HookedTextView {
    private static final PopupStaticBehavior POPUP_BEHAVIOR = (PopupStaticBehavior) InterfaceComponentsAccess.get(PopupStaticBehavior.class);
    private TextViewBehavior mBehavior;

    @Override // com.microsoft.intune.mam.client.view.HookedTextView
    public TextView asTextView() {
        return this;
    }

    public MAMMultiAutoCompleteTextView(Context context) {
        super(POPUP_BEHAVIOR.wrapContext(context));
        TextViewBehavior textViewBehavior = (TextViewBehavior) InterfaceComponentsAccess.get(TextViewBehavior.class);
        this.mBehavior = textViewBehavior;
        textViewBehavior.init(this);
    }

    public MAMMultiAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        super(POPUP_BEHAVIOR.wrapContext(context), attributeSet);
        TextViewBehavior textViewBehavior = (TextViewBehavior) InterfaceComponentsAccess.get(TextViewBehavior.class);
        this.mBehavior = textViewBehavior;
        textViewBehavior.init(this);
    }

    public MAMMultiAutoCompleteTextView(Context context, AttributeSet attributeSet, int i) {
        super(POPUP_BEHAVIOR.wrapContext(context), attributeSet, i);
        TextViewBehavior textViewBehavior = (TextViewBehavior) InterfaceComponentsAccess.get(TextViewBehavior.class);
        this.mBehavior = textViewBehavior;
        textViewBehavior.init(this);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mBehavior.setOnLongClickListener(onLongClickListener);
    }

    public MAMMultiAutoCompleteTextView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(POPUP_BEHAVIOR.wrapContext(context), attributeSet, i, i2);
        TextViewBehavior textViewBehavior = (TextViewBehavior) InterfaceComponentsAccess.get(TextViewBehavior.class);
        this.mBehavior = textViewBehavior;
        textViewBehavior.init(this);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int i) {
        if (this.mBehavior.onTextContextMenuItem(i)) {
            return true;
        }
        return super.onTextContextMenuItem(i);
    }

    @Override // android.view.View
    public ActionMode startActionMode(ActionMode.Callback callback, int i) {
        return this.mBehavior.startActionMode(callback, i);
    }

    @Override // com.microsoft.intune.mam.client.view.HookedView
    public ActionMode realStartActionMode(ActionMode.Callback callback, int i) {
        return super.startActionMode(callback, i);
    }

    @Override // com.microsoft.intune.mam.client.view.HookedView
    public ActionMode startActionModeMAM(ActionMode.Callback callback, int i) {
        return this.mBehavior.startActionModeMAM(callback, i);
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return this.mBehavior.onCreateInputConnection(editorInfo);
    }

    @Override // com.microsoft.intune.mam.client.view.HookedView
    public InputConnection realOnCreateInputConnection(EditorInfo editorInfo) {
        return super.onCreateInputConnection(editorInfo);
    }

    public InputConnection onMAMCreateInputConnection(EditorInfo editorInfo) {
        return this.mBehavior.onMAMCreateInputConnection(editorInfo);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean performLongClick() {
        if (this.mBehavior.performLongClick()) {
            return true;
        }
        return super.performLongClick();
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mBehavior.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onDragEvent(DragEvent dragEvent) {
        if (this.mBehavior.onDragEvent(dragEvent)) {
            return true;
        }
        return super.onDragEvent(dragEvent);
    }

    @Override // com.microsoft.intune.mam.client.view.HookedTextView
    public void realSetOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        super.setOnLongClickListener(onLongClickListener);
    }
}
