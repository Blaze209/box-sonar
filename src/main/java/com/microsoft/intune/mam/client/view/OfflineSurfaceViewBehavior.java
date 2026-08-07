package com.microsoft.intune.mam.client.view;

import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

/* JADX INFO: loaded from: classes3.dex */
public class OfflineSurfaceViewBehavior implements SurfaceViewBehavior {
    private HookedSurfaceView mSurfaceView;

    @Override // com.microsoft.intune.mam.client.view.SurfaceViewBehavior
    public void init(HookedSurfaceView hookedSurfaceView) {
        this.mSurfaceView = hookedSurfaceView;
    }

    @Override // com.microsoft.intune.mam.client.view.ViewBehavior
    public ActionMode startActionMode(ActionMode.Callback callback, int i) {
        return this.mSurfaceView.startActionModeMAM(callback, i);
    }

    @Override // com.microsoft.intune.mam.client.view.ViewBehavior
    public ActionMode startActionModeMAM(ActionMode.Callback callback, int i) {
        return this.mSurfaceView.realStartActionMode(callback, i);
    }

    @Override // com.microsoft.intune.mam.client.view.ViewBehavior
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return this.mSurfaceView.onMAMCreateInputConnection(editorInfo);
    }

    @Override // com.microsoft.intune.mam.client.view.ViewBehavior
    public InputConnection onMAMCreateInputConnection(EditorInfo editorInfo) {
        return this.mSurfaceView.realOnCreateInputConnection(editorInfo);
    }
}
