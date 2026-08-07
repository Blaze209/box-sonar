package com.yubico.yubikit.android.transport.usb.connection;

import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbInterface;
import com.google.android.material.internal.ViewUtils;
import com.yubico.yubikit.core.otp.OtpConnection;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class UsbOtpConnection extends UsbYubiKeyConnection implements OtpConnection {
    private static final int HID_GET_REPORT = 1;
    private static final int HID_SET_REPORT = 9;
    private static final int RECIPIENT_INTERFACE = 1;
    private static final int REPORT_TYPE_FEATURE = 3;
    private static final int TIMEOUT = 1000;
    private static final int TYPE_CLASS = 32;
    private boolean closed;
    private final UsbDeviceConnection connection;
    private final UsbInterface hidInterface;

    UsbOtpConnection(UsbDeviceConnection usbDeviceConnection, UsbInterface usbInterface) {
        super(usbDeviceConnection, usbInterface);
        this.closed = false;
        this.connection = usbDeviceConnection;
        this.hidInterface = usbInterface;
    }

    @Override // com.yubico.yubikit.core.otp.OtpConnection
    public void receive(byte[] bArr) throws IOException {
        int iControlTransfer = this.connection.controlTransfer(Token.DEBUGGER, 1, ViewUtils.EDGE_TO_EDGE_FLAGS, this.hidInterface.getId(), bArr, bArr.length, 1000);
        if (iControlTransfer != 8) {
            throw new IOException("Unexpected amount of data read: " + iControlTransfer);
        }
    }

    @Override // com.yubico.yubikit.core.otp.OtpConnection
    public void send(byte[] bArr) throws IOException {
        int iControlTransfer = this.connection.controlTransfer(33, 9, ViewUtils.EDGE_TO_EDGE_FLAGS, this.hidInterface.getId(), bArr, bArr.length, 1000);
        if (iControlTransfer != 8) {
            throw new IOException("Unexpected amount of data sent: " + iControlTransfer);
        }
    }

    @Override // com.yubico.yubikit.android.transport.usb.connection.UsbYubiKeyConnection, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.closed = true;
        super.close();
    }

    public boolean isClosed() {
        return this.closed;
    }
}
