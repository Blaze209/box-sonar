package com.microsoft.intune.mam.client.widget;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.SurfaceView;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.microsoft.intune.mam.client.InterfaceComponentsAccess;
import com.microsoft.intune.mam.client.view.HookedSurfaceView;
import com.microsoft.intune.mam.client.view.SurfaceViewBehavior;

/* JADX INFO: loaded from: classes3.dex */
public class MAMGLSurfaceView extends GLSurfaceView implements HookedSurfaceView {
    private SurfaceViewBehavior mBehavior;

    @Override // com.microsoft.intune.mam.client.view.HookedSurfaceView
    public SurfaceView asSurfaceView() {
        return this;
    }

    public MAMGLSurfaceView(Context context) {
        super(context);
        SurfaceViewBehavior surfaceViewBehavior = (SurfaceViewBehavior) InterfaceComponentsAccess.get(SurfaceViewBehavior.class);
        this.mBehavior = surfaceViewBehavior;
        surfaceViewBehavior.init(this);
    }

    public MAMGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        SurfaceViewBehavior surfaceViewBehavior = (SurfaceViewBehavior) InterfaceComponentsAccess.get(SurfaceViewBehavior.class);
        this.mBehavior = surfaceViewBehavior;
        surfaceViewBehavior.init(this);
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

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return this.mBehavior.onCreateInputConnection(editorInfo);
    }

    @Override // com.microsoft.intune.mam.client.view.HookedView
    public InputConnection realOnCreateInputConnection(EditorInfo editorInfo) {
        return super.onCreateInputConnection(editorInfo);
    }

    @Override // com.microsoft.intune.mam.client.view.HookedView
    public InputConnection onMAMCreateInputConnection(EditorInfo editorInfo) {
        return this.mBehavior.onMAMCreateInputConnection(editorInfo);
    }
}
