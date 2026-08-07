package com.yubico.yubikit.android;

import android.app.Activity;
import android.content.Context;
import com.yubico.yubikit.android.transport.nfc.NfcConfiguration;
import com.yubico.yubikit.android.transport.nfc.NfcNotAvailable;
import com.yubico.yubikit.android.transport.nfc.NfcYubiKeyDevice;
import com.yubico.yubikit.android.transport.nfc.NfcYubiKeyManager;
import com.yubico.yubikit.android.transport.usb.UsbConfiguration;
import com.yubico.yubikit.android.transport.usb.UsbYubiKeyDevice;
import com.yubico.yubikit.android.transport.usb.UsbYubiKeyManager;
import com.yubico.yubikit.core.util.Callback;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class YubiKitManager {

    @Nullable
    private final NfcYubiKeyManager nfcYubiKeyManager;
    private final UsbYubiKeyManager usbYubiKeyManager;

    @Nullable
    private static NfcYubiKeyManager buildNfcDeviceManager(Context context) {
        try {
            return new NfcYubiKeyManager(context, null);
        } catch (NfcNotAvailable unused) {
            return null;
        }
    }

    public YubiKitManager(Context context) {
        this(new UsbYubiKeyManager(context.getApplicationContext()), buildNfcDeviceManager(context.getApplicationContext()));
    }

    public YubiKitManager(UsbYubiKeyManager usbYubiKeyManager, @Nullable NfcYubiKeyManager nfcYubiKeyManager) {
        this.usbYubiKeyManager = usbYubiKeyManager;
        this.nfcYubiKeyManager = nfcYubiKeyManager;
    }

    public void startUsbDiscovery(UsbConfiguration usbConfiguration, Callback<? super UsbYubiKeyDevice> callback) {
        this.usbYubiKeyManager.enable(usbConfiguration, callback);
    }

    public void startNfcDiscovery(NfcConfiguration nfcConfiguration, Activity activity, Callback<? super NfcYubiKeyDevice> callback) throws NfcNotAvailable {
        NfcYubiKeyManager nfcYubiKeyManager = this.nfcYubiKeyManager;
        if (nfcYubiKeyManager == null) {
            throw new NfcNotAvailable("NFC is not available on this device", false);
        }
        nfcYubiKeyManager.enable(activity, nfcConfiguration, callback);
    }

    public void stopUsbDiscovery() {
        this.usbYubiKeyManager.disable();
    }

    public void stopNfcDiscovery(Activity activity) {
        NfcYubiKeyManager nfcYubiKeyManager = this.nfcYubiKeyManager;
        if (nfcYubiKeyManager != null) {
            nfcYubiKeyManager.disable(activity);
        }
    }
}
