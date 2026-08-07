package com.yubico.yubikit.android.transport.nfc;

/* JADX INFO: loaded from: classes3.dex */
public class NfcConfiguration {
    private boolean disableNfcDiscoverySound = false;
    private boolean skipNdefCheck = false;
    private boolean handleUnavailableNfc = false;
    private int timeout = 1000;

    public boolean isDisableNfcDiscoverySound() {
        return this.disableNfcDiscoverySound;
    }

    public boolean isSkipNdefCheck() {
        return this.skipNdefCheck;
    }

    public boolean isHandleUnavailableNfc() {
        return this.handleUnavailableNfc;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public NfcConfiguration disableNfcDiscoverySound(boolean z) {
        this.disableNfcDiscoverySound = z;
        return this;
    }

    public NfcConfiguration skipNdefCheck(boolean z) {
        this.skipNdefCheck = z;
        return this;
    }

    public NfcConfiguration handleUnavailableNfc(boolean z) {
        this.handleUnavailableNfc = z;
        return this;
    }

    public NfcConfiguration timeout(int i) {
        this.timeout = i;
        return this;
    }
}
