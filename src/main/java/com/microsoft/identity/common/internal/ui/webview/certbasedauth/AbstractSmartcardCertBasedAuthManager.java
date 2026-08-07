package com.microsoft.identity.common.internal.ui.webview.certbasedauth;

import android.app.Activity;
import com.microsoft.identity.common.java.opentelemetry.ICertBasedAuthTelemetryHelper;

/* JADX INFO: loaded from: classes14.dex */
public abstract class AbstractSmartcardCertBasedAuthManager {
    protected IConnectionCallback mConnectionCallback;

    interface ISessionCallback {
        void onException(Exception exc);

        void onGetSession(ISmartcardSession iSmartcardSession) throws Exception;
    }

    abstract void initBeforeProceedingWithRequest(ICertBasedAuthTelemetryHelper iCertBasedAuthTelemetryHelper);

    abstract boolean isDeviceConnected();

    abstract void onDestroy(Activity activity);

    abstract void requestDeviceSession(ISessionCallback iSessionCallback);

    abstract boolean startDiscovery(Activity activity);

    abstract void stopDiscovery(Activity activity);

    public void setConnectionCallback(IConnectionCallback iConnectionCallback) {
        this.mConnectionCallback = iConnectionCallback;
    }

    public void clearConnectionCallback() {
        this.mConnectionCallback = null;
    }
}
