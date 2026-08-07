package com.microsoft.identity.common.internal.ui.webview.certbasedauth;

import com.microsoft.identity.common.java.opentelemetry.ICertBasedAuthTelemetryHelper;
import com.microsoft.identity.common.logging.Logger;
import com.yubico.yubikit.core.util.Callback;
import com.yubico.yubikit.core.util.Result;
import com.yubico.yubikit.piv.PivSession;
import com.yubico.yubikit.piv.jca.PivProvider;
import java.security.Security;

/* JADX INFO: loaded from: classes14.dex */
public class YubiKeyPivProviderManager {
    private static final String TAG = "YubiKeyPivProviderManager";
    protected static final String YUBIKEY_PROVIDER = "YKPiv";

    public static void addPivProvider(ICertBasedAuthTelemetryHelper iCertBasedAuthTelemetryHelper, Callback<Callback<Result<PivSession, Exception>>> callback) {
        String str = TAG + ":addPivProvider";
        if (Security.getProvider(YUBIKEY_PROVIDER) != null) {
            Security.removeProvider(YUBIKEY_PROVIDER);
            iCertBasedAuthTelemetryHelper.setExistingPivProviderPresent(true);
            Logger.info(str, "Existing PivProvider was present in Security static list.");
        } else {
            iCertBasedAuthTelemetryHelper.setExistingPivProviderPresent(false);
            Logger.info(str, "Security static list does not have existing PivProvider.");
        }
        Security.insertProviderAt(new PivProvider(callback), 1);
        Logger.info(str, "An instance of PivProvider was added to Security static list.");
    }

    public static void removePivProvider() {
        if (Security.getProvider(YUBIKEY_PROVIDER) == null) {
            return;
        }
        Security.removeProvider(YUBIKEY_PROVIDER);
        Logger.info(TAG, "An instance of PivProvider was removed from Security static list.");
    }
}
