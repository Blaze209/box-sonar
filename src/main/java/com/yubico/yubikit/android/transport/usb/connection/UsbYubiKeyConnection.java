package com.yubico.yubikit.android.transport.usb.connection;

import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbInterface;
import com.yubico.yubikit.core.YubiKeyConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes3.dex */
abstract class UsbYubiKeyConnection implements YubiKeyConnection {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) UsbYubiKeyConnection.class);
    private final UsbDeviceConnection usbDeviceConnection;
    private final UsbInterface usbInterface;

    protected UsbYubiKeyConnection(UsbDeviceConnection usbDeviceConnection, UsbInterface usbInterface) {
        this.usbDeviceConnection = usbDeviceConnection;
        this.usbInterface = usbInterface;
        com.yubico.yubikit.core.internal.Logger.debug(logger, "USB connection opened: {}", this);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.usbDeviceConnection.releaseInterface(this.usbInterface);
        this.usbDeviceConnection.close();
        com.yubico.yubikit.core.internal.Logger.debug(logger, "USB connection closed: {}", this);
    }
}
