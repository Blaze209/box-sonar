package com.yubico.yubikit.android.transport.usb;

import android.hardware.usb.UsbDevice;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class NoPermissionsException extends IOException {
    static final long serialVersionUID = 1;

    public NoPermissionsException(UsbDevice usbDevice) {
        super("No permission granted to communicate with device " + usbDevice.getProductName());
    }
}
