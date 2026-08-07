package com.microsoft.identity.common.internal.ui.webview.certbasedauth;

import android.content.Context;
import com.microsoft.identity.common.logging.Logger;
import com.yubico.yubikit.android.transport.nfc.NfcNotAvailable;

/* JADX INFO: loaded from: classes14.dex */
public class SmartcardCertBasedAuthManagerFactory {
    private static final String TAG = "SmartcardCertBasedAuthManagerFactory";

    static AbstractUsbSmartcardCertBasedAuthManager createUsbSmartcardCertBasedAuthManager(Context context) {
        String str = TAG + ":createUsbSmartcardCertBasedAuthManager";
        if (context.getSystemService("usb") == null) {
            Logger.info(str, "Certificate Based Authentication via YubiKey not enabled due to device not supporting the USB_SERVICE system service.");
            return null;
        }
        return new YubiKitUsbSmartcardCertBasedAuthManager(context);
    }

    static AbstractNfcSmartcardCertBasedAuthManager createNfcSmartcardCertBasedAuthManager(Context context) {
        try {
            return new YubiKitNfcSmartcardCertBasedAuthManager(context);
        } catch (NfcNotAvailable unused) {
            Logger.info(TAG + ":createNfcSmartcardCertBasedAuthManager", "Device does not support NFC capabilities.");
            return null;
        }
    }
}
