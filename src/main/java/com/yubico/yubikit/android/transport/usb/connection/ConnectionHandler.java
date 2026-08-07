package com.yubico.yubikit.android.transport.usb.connection;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import com.yubico.yubikit.core.YubiKeyConnection;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public interface ConnectionHandler<T extends YubiKeyConnection> {
    T createConnection(UsbDevice usbDevice, UsbDeviceConnection usbDeviceConnection) throws IOException;

    boolean isAvailable(UsbDevice usbDevice);
}
