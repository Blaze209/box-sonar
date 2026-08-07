package com.microsoft.identity.common.internal.ui.webview.certbasedauth;

import android.app.Activity;
import android.content.Context;
import com.microsoft.identity.common.java.opentelemetry.ICertBasedAuthTelemetryHelper;
import com.microsoft.identity.common.logging.Logger;
import com.yubico.yubikit.android.transport.nfc.NfcConfiguration;
import com.yubico.yubikit.android.transport.nfc.NfcNotAvailable;
import com.yubico.yubikit.android.transport.nfc.NfcSmartCardConnection;
import com.yubico.yubikit.android.transport.nfc.NfcYubiKeyDevice;
import com.yubico.yubikit.android.transport.nfc.NfcYubiKeyManager;
import com.yubico.yubikit.core.smartcard.SmartCardConnection;
import com.yubico.yubikit.core.util.Callback;
import com.yubico.yubikit.core.util.Result;
import com.yubico.yubikit.piv.PivSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes14.dex */
public class YubiKitNfcSmartcardCertBasedAuthManager extends AbstractNfcSmartcardCertBasedAuthManager {
    private static final String DEVICE_ERROR_MESSAGE = "No NFC device is currently connected.";
    private static final int NFC_TIMEOUT = 5000;
    private static final String TAG = "YubiKitNfcSmartcardCertBasedAuthManager";
    private static final Object sDeviceLock = new Object();
    private NfcYubiKeyDevice mNfcDevice;
    private final NfcYubiKeyManager mNfcYubiKitManager;
    private byte[] mTagId;

    public YubiKitNfcSmartcardCertBasedAuthManager(Context context) throws NfcNotAvailable {
        this.mNfcYubiKitManager = new NfcYubiKeyManager(context.getApplicationContext(), null);
        this.isDeviceChanged = false;
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthManager
    boolean startDiscovery(Activity activity) {
        final String str = TAG + ":startDiscovery";
        Logger.info(str, "Starting YubiKey discovery for NFC");
        try {
            this.mNfcYubiKitManager.enable(activity, new NfcConfiguration().timeout(5000), new Callback<NfcYubiKeyDevice>() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.YubiKitNfcSmartcardCertBasedAuthManager.1
                @Override // com.yubico.yubikit.core.util.Callback
                public void invoke(NfcYubiKeyDevice nfcYubiKeyDevice) {
                    Logger.info(str, "A YubiKey device was connected via NFC.");
                    YubiKitNfcSmartcardCertBasedAuthManager.this.mNfcDevice = nfcYubiKeyDevice;
                    byte[] id = YubiKitNfcSmartcardCertBasedAuthManager.this.mNfcDevice.getTag().getId();
                    YubiKitNfcSmartcardCertBasedAuthManager yubiKitNfcSmartcardCertBasedAuthManager = YubiKitNfcSmartcardCertBasedAuthManager.this;
                    yubiKitNfcSmartcardCertBasedAuthManager.isDeviceChanged = (yubiKitNfcSmartcardCertBasedAuthManager.mTagId == null || Arrays.equals(YubiKitNfcSmartcardCertBasedAuthManager.this.mTagId, id)) ? false : true;
                    YubiKitNfcSmartcardCertBasedAuthManager.this.mTagId = id;
                    if (YubiKitNfcSmartcardCertBasedAuthManager.this.mConnectionCallback != null) {
                        YubiKitNfcSmartcardCertBasedAuthManager.this.mConnectionCallback.onCreateConnection();
                    }
                }
            });
            return false;
        } catch (NfcNotAvailable unused) {
            Logger.info(str, "Device has NFC functionality turned off.");
            return true;
        }
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthManager
    void stopDiscovery(Activity activity) {
        Logger.info(TAG + ":stopDiscovery", "Stopping YubiKey discovery for NFC");
        synchronized (sDeviceLock) {
            this.mNfcDevice = null;
            this.mNfcYubiKitManager.disable(activity);
        }
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthManager
    void requestDeviceSession(final AbstractSmartcardCertBasedAuthManager.ISessionCallback iSessionCallback) {
        String str = TAG + "requestDeviceSession:";
        synchronized (sDeviceLock) {
            if (isDeviceConnected()) {
                this.mNfcDevice.requestConnection(NfcSmartCardConnection.class, new Callback<Result<NfcSmartCardConnection, IOException>>() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.YubiKitNfcSmartcardCertBasedAuthManager.2
                    @Override // com.yubico.yubikit.core.util.Callback
                    public void invoke(Result<NfcSmartCardConnection, IOException> result) {
                        try {
                            iSessionCallback.onGetSession(new YubiKitSmartcardSession(new PivSession(result.getValue())));
                        } catch (Exception e) {
                            iSessionCallback.onException(e);
                        }
                    }
                });
            } else {
                Logger.error(str, DEVICE_ERROR_MESSAGE, null);
                iSessionCallback.onException(new Exception());
            }
        }
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthManager
    boolean isDeviceConnected() {
        boolean z;
        synchronized (sDeviceLock) {
            z = this.mNfcDevice != null;
        }
        return z;
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthManager
    void initBeforeProceedingWithRequest(ICertBasedAuthTelemetryHelper iCertBasedAuthTelemetryHelper) {
        YubiKeyPivProviderManager.addPivProvider(iCertBasedAuthTelemetryHelper, getPivProviderCallback());
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthManager
    void onDestroy(Activity activity) {
        YubiKeyPivProviderManager.removePivProvider();
    }

    Callback<Callback<Result<PivSession, Exception>>> getPivProviderCallback() {
        final String str = TAG + "getPivProviderCallback:";
        return new Callback<Callback<Result<PivSession, Exception>>>() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.YubiKitNfcSmartcardCertBasedAuthManager.3
            @Override // com.yubico.yubikit.core.util.Callback
            public void invoke(final Callback<Result<PivSession, Exception>> callback) {
                synchronized (YubiKitNfcSmartcardCertBasedAuthManager.sDeviceLock) {
                    if (YubiKitNfcSmartcardCertBasedAuthManager.this.isDeviceConnected()) {
                        YubiKitNfcSmartcardCertBasedAuthManager.this.mNfcDevice.requestConnection(NfcSmartCardConnection.class, new Callback<Result<NfcSmartCardConnection, IOException>>() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.YubiKitNfcSmartcardCertBasedAuthManager.3.1
                            @Override // com.yubico.yubikit.core.util.Callback
                            public void invoke(final Result<NfcSmartCardConnection, IOException> result) {
                                callback.invoke(Result.of(new Callable<PivSession>() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.YubiKitNfcSmartcardCertBasedAuthManager.3.1.1
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // java.util.concurrent.Callable
                                    public PivSession call() throws Exception {
                                        return new PivSession((SmartCardConnection) result.getValue());
                                    }
                                }));
                            }
                        });
                    } else {
                        Logger.error(str, YubiKitNfcSmartcardCertBasedAuthManager.DEVICE_ERROR_MESSAGE, null);
                        callback.invoke(Result.failure(new Exception(YubiKitNfcSmartcardCertBasedAuthManager.DEVICE_ERROR_MESSAGE)));
                    }
                }
            }
        };
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.AbstractNfcSmartcardCertBasedAuthManager
    void disconnect(final IDisconnectionCallback iDisconnectionCallback) {
        final String str = TAG + ":disconnect";
        synchronized (sDeviceLock) {
            NfcYubiKeyDevice nfcYubiKeyDevice = this.mNfcDevice;
            if (nfcYubiKeyDevice != null) {
                nfcYubiKeyDevice.remove(new Runnable() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.YubiKitNfcSmartcardCertBasedAuthManager.4
                    @Override // java.lang.Runnable
                    public void run() {
                        Logger.info(str, "YubiKey connected via NFC has been disconnected");
                        YubiKitNfcSmartcardCertBasedAuthManager.this.mNfcDevice = null;
                        iDisconnectionCallback.onClosedConnection();
                    }
                });
            }
        }
    }
}
