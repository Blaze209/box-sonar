package com.microsoft.intune.mam.client.view;

import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

/* JADX INFO: loaded from: classes3.dex */
public class OfflineWebViewBehavior implements WebViewBehavior {
    private HookedView mView;

    @Override // com.microsoft.intune.mam.client.view.WebViewBehavior
    public void init(HookedWebView hookedWebView) {
        this.mView = hookedWebView;
    }

    @Override // com.microsoft.intune.mam.client.view.ViewBehavior
    public ActionMode startActionMode(ActionMode.Callback callback, int i) {
        return this.mView.startActionModeMAM(callback, i);
    }

    @Override // com.microsoft.intune.mam.client.view.ViewBehavior
    public ActionMode startActionModeMAM(ActionMode.Callback callback, int i) {
        return this.mView.realStartActionMode(callback, i);
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
