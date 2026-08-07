package com.microsoft.intune.mam.client.view;

import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

/* JADX INFO: loaded from: classes3.dex */
public class OfflineViewGroupBehavior implements ViewGroupBehavior {
    private HookedViewGroup mViewGroup;

    @Override // com.microsoft.intune.mam.client.view.ViewGroupBehavior
    public void init(HookedViewGroup hookedViewGroup) {
        this.mViewGroup = hookedViewGroup;
    }

    @Override // com.microsoft.intune.mam.client.view.ViewBehavior
    public ActionMode startActionMode(ActionMode.Callback callback, int i) {
        return this.mViewGroup.startActionModeMAM(callback, i);
    }

    @Override // com.microsoft.intune.mam.client.view.ViewBehavior
    public ActionMode startActionModeMAM(ActionMode.Callback callback, int i) {
        return this.mViewGroup.realStartActionMode(callback, i);
    }

    @Override // com.microsoft.intune.mam.client.view.ViewBehavior
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return this.mViewGroup.onMAMCreateInputConnection(editorInfo);
    }

    @Override // com.microsoft.intune.mam.client.view.ViewBehavior
    public InputConnection onMAMCreateInputConnection(EditorInfo editorInfo) {
        return this.mViewGroup.realOnCreateInputConnection(editorInfo);
    }
}
