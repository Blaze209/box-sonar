package com.yubico.yubikit.android.transport.nfc;

/* JADX INFO: loaded from: classes3.dex */
public class NfcNotAvailable extends Exception {
    static final long serialVersionUID = 1;
    private final boolean disabled;

    public NfcNotAvailable(String str, boolean z) {
        super(str);
        this.disabled = z;
    }

    public boolean isDisabled() {
        return this.disabled;
    }
}
