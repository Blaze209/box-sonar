package com.microsoft.identity.common.internal.ui.webview.certbasedauth;

/* JADX INFO: loaded from: classes14.dex */
public abstract class AbstractUsbSmartcardCertBasedAuthManager extends AbstractSmartcardCertBasedAuthManager {
    protected IDisconnectionCallback mDisconnectionCallback;
    protected boolean mUsbDeviceInitiallyPluggedIn;

    public boolean isUsbDeviceInitiallyPluggedIn() {
        return this.mUsbDeviceInitiallyPluggedIn;
    }

    public void setDisconnectionCallback(IDisconnectionCallback iDisconnectionCallback) {
        this.mDisconnectionCallback = iDisconnectionCallback;
    }

    public void clearDisconnectionCallback() {
        this.mDisconnectionCallback = null;
    }
}
