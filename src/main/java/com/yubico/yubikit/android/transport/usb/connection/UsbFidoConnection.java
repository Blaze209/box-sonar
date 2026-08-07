package com.yubico.yubikit.android.transport.usb.connection;

import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import com.yubico.yubikit.core.fido.FidoConnection;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class UsbFidoConnection extends UsbYubiKeyConnection implements FidoConnection {
    private static final int TIMEOUT = 1000;
    private final UsbEndpoint bulkIn;
    private final UsbEndpoint bulkOut;
    private final UsbDeviceConnection connection;

    @Override // com.yubico.yubikit.android.transport.usb.connection.UsbYubiKeyConnection, java.io.Closeable, java.lang.AutoCloseable
    public /* bridge */ /* synthetic */ void close() {
        super.close();
    }

    UsbFidoConnection(UsbDeviceConnection usbDeviceConnection, UsbInterface usbInterface, UsbEndpoint usbEndpoint, UsbEndpoint usbEndpoint2) {
        super(usbDeviceConnection, usbInterface);
        this.connection = usbDeviceConnection;
        this.bulkIn = usbEndpoint;
        this.bulkOut = usbEndpoint2;
    }

    @Override // com.yubico.yubikit.core.fido.FidoConnection
    public void send(byte[] bArr) throws IOException {
        if (this.connection.bulkTransfer(this.bulkOut, bArr, bArr.length, 1000) != 64) {
            throw new IOException("Failed to send full packed");
        }
    }

    @Override // com.yubico.yubikit.core.fido.FidoConnection
    public void receive(byte[] bArr) throws IOException {
        if (this.connection.bulkTransfer(this.bulkIn, bArr, bArr.length, 1000) != 64) {
            throw new IOException("Failed to read full packed");
        }
    }
}
