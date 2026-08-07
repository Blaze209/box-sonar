package com.microsoft.intune.mam.client.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.RelativeLayout;
import com.microsoft.intune.mam.client.InterfaceComponentsAccess;
import com.microsoft.intune.mam.client.view.HookedViewGroup;
import com.microsoft.intune.mam.client.view.ViewGroupBehavior;

/* JADX INFO: loaded from: classes3.dex */
public class MAMRelativeLayout extends RelativeLayout implements HookedViewGroup {
    private ViewGroupBehavior mBehavior;

    @Override // com.microsoft.intune.mam.client.view.HookedViewGroup
    public ViewGroup asViewGroup() {
        return this;
    }

    public MAMRelativeLayout(Context context) {
        super(context);
        ViewGroupBehavior viewGroupBehavior = (ViewGroupBehavior) InterfaceComponentsAccess.get(ViewGroupBehavior.class);
        this.mBehavior = viewGroupBehavior;
        viewGroupBehavior.init(this);
    }

    public MAMRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ViewGroupBehavior viewGroupBehavior = (ViewGroupBehavior) InterfaceComponentsAccess.get(ViewGroupBehavior.class);
        this.mBehavior = viewGroupBehavior;
        viewGroupBehavior.init(this);
    }

    public MAMRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ViewGroupBehavior viewGroupBehavior = (ViewGroupBehavior) InterfaceComponentsAccess.get(ViewGroupBehavior.class);
        this.mBehavior = viewGroupBehavior;
        viewGroupBehavior.init(this);
    }

    public MAMRelativeLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        ViewGroupBehavior viewGroupBehavior = (ViewGroupBehavior) InterfaceComponentsAccess.get(ViewGroupBehavior.class);
        this.mBehavior = viewGroupBehavior;
        viewGroupBehavior.init(this);
    }

    @Override // android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return this.mBehavior.onCreateInputConnection(editorInfo);
    }

    @Override // com.microsoft.intune.mam.client.view.HookedView
    public final InputConnection realOnCreateInputConnection(EditorInfo editorInfo) {
        return super.onCreateInputConnection(editorInfo);
    }

    @Override // com.microsoft.intune.mam.client.view.HookedView
    public InputConnection onMAMCreateInputConnection(EditorInfo editorInfo) {
        return this.mBehavior.onMAMCreateInputConnection(editorInfo);
    }

    @Override // android.view.View
    public final ActionMode startActionMode(ActionMode.Callback callback, int i) {
        return this.mBehavior.startActionMode(callback, i);
    }

    @Override // com.microsoft.intune.mam.client.view.HookedView
    public final ActionMode realStartActionMode(ActionMode.Callback callback, int i) {
        return super.startActionMode(callback, i);
    }

    @Override // com.microsoft.intune.mam.client.view.HookedView
    public ActionMode startActionModeMAM(ActionMode.Callback callback, int i) {
        return this.mBehavior.startActionModeMAM(callback, i);
    }
}
