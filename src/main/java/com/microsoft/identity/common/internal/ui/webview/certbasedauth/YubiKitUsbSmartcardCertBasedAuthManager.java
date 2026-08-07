package com.microsoft.identity.common.internal.ui.webview.certbasedauth;

import android.app.Activity;
import android.content.Context;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import com.microsoft.identity.common.java.opentelemetry.ICertBasedAuthTelemetryHelper;
import com.microsoft.identity.common.logging.Logger;
import com.yubico.yubikit.android.transport.usb.UsbConfiguration;
import com.yubico.yubikit.android.transport.usb.UsbYubiKeyDevice;
import com.yubico.yubikit.android.transport.usb.UsbYubiKeyManager;
import com.yubico.yubikit.android.transport.usb.connection.UsbSmartCardConnection;
import com.yubico.yubikit.core.smartcard.SmartCardConnection;
import com.yubico.yubikit.core.util.Callback;
import com.yubico.yubikit.core.util.Result;
import com.yubico.yubikit.piv.PivSession;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes14.dex */
public class YubiKitUsbSmartcardCertBasedAuthManager extends AbstractUsbSmartcardCertBasedAuthManager {
    private static final String DEVICE_ERROR_MESSAGE = "No USB device is currently connected.";
    private static final String TAG = "YubiKitUsbSmartcardCertBasedAuthManager";
    public static final int YUBICO_VENDOR_ID = 4176;
    private static final Object sDeviceLock = new Object();
    private UsbYubiKeyDevice mUsbDevice;
    private final UsbYubiKeyManager mUsbYubiKeyManager;

    public YubiKitUsbSmartcardCertBasedAuthManager(Context context) {
        this.mUsbYubiKeyManager = new UsbYubiKeyManager(context.getApplicationContext());
        Iterator<UsbDevice> it = ((UsbManager) context.getSystemService("usb")).getDeviceList().values().iterator();
        while (it.hasNext()) {
            if (it.next().getVendorId() == 4176) {
                Logger.verbose(TAG, "A YubiKey device is plugged-in upon manager start-up.");
                this.mUsbDeviceInitiallyPluggedIn = true;
                return;
            }
        }
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthManager
    boolean startDiscovery(Activity activity) {
        final String str = TAG + ":startDiscovery";
        Logger.info(str, "Starting YubiKey discovery for USB");
        this.mUsbYubiKeyManager.enable(new UsbConfiguration(), new Callback<UsbYubiKeyDevice>() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.YubiKitUsbSmartcardCertBasedAuthManager.1
            @Override // com.yubico.yubikit.core.util.Callback
            public void invoke(UsbYubiKeyDevice usbYubiKeyDevice) {
                Logger.info(str, "A YubiKey device was connected via USB.");
                synchronized (YubiKitUsbSmartcardCertBasedAuthManager.sDeviceLock) {
                    YubiKitUsbSmartcardCertBasedAuthManager.this.mUsbDevice = usbYubiKeyDevice;
                    if (YubiKitUsbSmartcardCertBasedAuthManager.this.mConnectionCallback != null) {
                        YubiKitUsbSmartcardCertBasedAuthManager.this.mConnectionCallback.onCreateConnection();
                    }
                    YubiKitUsbSmartcardCertBasedAuthManager.this.mUsbDevice.setOnClosed(new Runnable() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.YubiKitUsbSmartcardCertBasedAuthManager.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Logger.info(str, "A YubiKey device was disconnected via USB.");
                            synchronized (YubiKitUsbSmartcardCertBasedAuthManager.sDeviceLock) {
                                YubiKitUsbSmartcardCertBasedAuthManager.this.mUsbDevice = null;
                            }
                            YubiKeyPivProviderManager.removePivProvider();
                            if (YubiKitUsbSmartcardCertBasedAuthManager.this.mDisconnectionCallback != null) {
                                YubiKitUsbSmartcardCertBasedAuthManager.this.mDisconnectionCallback.onClosedConnection();
                            }
                        }
                    });
                }
            }
        });
        return true;
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthManager
    void stopDiscovery(Activity activity) {
        Logger.info(TAG + ":stopDiscovery", "Stopping YubiKey discovery for USB");
        synchronized (sDeviceLock) {
            this.mUsbDevice = null;
            this.mUsbYubiKeyManager.disable();
        }
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthManager
    void requestDeviceSession(final AbstractSmartcardCertBasedAuthManager.ISessionCallback iSessionCallback) {
        String str = TAG + "requestDeviceSession:";
        synchronized (sDeviceLock) {
            if (isDeviceConnected()) {
                this.mUsbDevice.requestConnection(UsbSmartCardConnection.class, new Callback<Result<UsbSmartCardConnection, IOException>>() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.YubiKitUsbSmartcardCertBasedAuthManager.2
                    @Override // com.yubico.yubikit.core.util.Callback
                    public void invoke(Result<UsbSmartCardConnection, IOException> result) {
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
            z = this.mUsbDevice != null;
        }
        return z;
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthManager
    void initBeforeProceedingWithRequest(ICertBasedAuthTelemetryHelper iCertBasedAuthTelemetryHelper) {
        YubiKeyPivProviderManager.addPivProvider(iCertBasedAuthTelemetryHelper, getPivProviderCallback());
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthManager
    void onDestroy(Activity activity) {
        stopDiscovery(activity);
    }

    Callback<Callback<Result<PivSession, Exception>>> getPivProviderCallback() {
        final String str = TAG + "getPivProviderCallback:";
        return new Callback<Callback<Result<PivSession, Exception>>>() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.YubiKitUsbSmartcardCertBasedAuthManager.3
            @Override // com.yubico.yubikit.core.util.Callback
            public void invoke(final Callback<Result<PivSession, Exception>> callback) {
                synchronized (YubiKitUsbSmartcardCertBasedAuthManager.sDeviceLock) {
                    if (YubiKitUsbSmartcardCertBasedAuthManager.this.isDeviceConnected()) {
                        YubiKitUsbSmartcardCertBasedAuthManager.this.mUsbDevice.requestConnection(UsbSmartCardConnection.class, new Callback<Result<UsbSmartCardConnection, IOException>>() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.YubiKitUsbSmartcardCertBasedAuthManager.3.1
                            @Override // com.yubico.yubikit.core.util.Callback
                            public void invoke(final Result<UsbSmartCardConnection, IOException> result) {
                                callback.invoke(Result.of(new Callable<PivSession>() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.YubiKitUsbSmartcardCertBasedAuthManager.3.1.1
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // java.util.concurrent.Callable
                                    public PivSession call() throws Exception {
                                        return new PivSession((SmartCardConnection) result.getValue());
                                    }
                                }));
                            }
                        });
                    } else {
                        Logger.error(str, YubiKitUsbSmartcardCertBasedAuthManager.DEVICE_ERROR_MESSAGE, null);
                        callback.invoke(Result.failure(new Exception(YubiKitUsbSmartcardCertBasedAuthManager.DEVICE_ERROR_MESSAGE)));
                    }
                }
            }
        };
    }
}
