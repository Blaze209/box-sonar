package com.yubico.yubikit.android.transport.usb;

/* JADX INFO: loaded from: classes3.dex */
public class UsbConfiguration {
    private boolean handlePermissions = true;

    boolean isHandlePermissions() {
        return this.handlePermissions;
    }

    public UsbConfiguration handlePermissions(boolean z) {
        this.handlePermissions = z;
        return this;
    }
}
