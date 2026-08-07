package com.yubico.yubikit.android.transport.usb.connection;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class OtpConnectionHandler extends InterfaceConnectionHandler<UsbOtpConnection> {
    @Override // com.yubico.yubikit.android.transport.usb.connection.InterfaceConnectionHandler, com.yubico.yubikit.android.transport.usb.connection.ConnectionHandler
    public /* bridge */ /* synthetic */ boolean isAvailable(UsbDevice usbDevice) {
        return super.isAvailable(usbDevice);
    }

    public OtpConnectionHandler() {
        super(3, 1);
    }

    @Override // com.yubico.yubikit.android.transport.usb.connection.ConnectionHandler
    public UsbOtpConnection createConnection(UsbDevice usbDevice, UsbDeviceConnection usbDeviceConnection) throws IOException {
        return new UsbOtpConnection(usbDeviceConnection, getClaimedInterface(usbDevice, usbDeviceConnection));
    }
}
