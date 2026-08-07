package com.microsoft.identity.common.internal.ui.webview.certbasedauth;

/* JADX INFO: loaded from: classes14.dex */
public abstract class AbstractNfcSmartcardCertBasedAuthManager extends AbstractSmartcardCertBasedAuthManager {
    protected boolean isDeviceChanged;

    abstract void disconnect(IDisconnectionCallback iDisconnectionCallback);

    public boolean isDeviceChanged() {
        return this.isDeviceChanged;
    }
}
