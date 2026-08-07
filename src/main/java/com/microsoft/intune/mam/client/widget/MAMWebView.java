package com.microsoft.intune.mam.client.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.webkit.WebView;
import com.microsoft.intune.mam.client.InterfaceComponentsAccess;
import com.microsoft.intune.mam.client.view.HookedWebView;
import com.microsoft.intune.mam.client.view.WebViewBehavior;

/* JADX INFO: loaded from: classes3.dex */
public class MAMWebView extends WebView implements HookedWebView {
    private WebViewBehavior mBehavior;

    @Override // com.microsoft.intune.mam.client.view.HookedWebView
    public WebView asWebView() {
        return this;
    }

    public MAMWebView(Context context) {
        super(context);
        WebViewBehavior webViewBehavior = (WebViewBehavior) InterfaceComponentsAccess.get(WebViewBehavior.class);
        this.mBehavior = webViewBehavior;
        webViewBehavior.init(this);
    }

    public MAMWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        WebViewBehavior webViewBehavior = (WebViewBehavior) InterfaceComponentsAccess.get(WebViewBehavior.class);
        this.mBehavior = webViewBehavior;
        webViewBehavior.init(this);
    }

    public MAMWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        WebViewBehavior webViewBehavior = (WebViewBehavior) InterfaceComponentsAccess.get(WebViewBehavior.class);
        this.mBehavior = webViewBehavior;
        webViewBehavior.init(this);
    }

    public MAMWebView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        WebViewBehavior webViewBehavior = (WebViewBehavior) InterfaceComponentsAccess.get(WebViewBehavior.class);
        this.mBehavior = webViewBehavior;
        webViewBehavior.init(this);
    }

    @Deprecated
    public MAMWebView(Context context, AttributeSet attributeSet, int i, boolean z) {
        super(context, attributeSet, i, z);
        this.mBehavior = (WebViewBehavior) InterfaceComponentsAccess.get(WebViewBehavior.class);
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

    @Override // android.webkit.WebView, android.view.View
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
