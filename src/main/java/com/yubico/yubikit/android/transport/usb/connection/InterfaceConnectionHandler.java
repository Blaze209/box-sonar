package com.yubico.yubikit.android.transport.usb.connection;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbInterface;
import com.yubico.yubikit.core.YubiKeyConnection;
import java.io.IOException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
abstract class InterfaceConnectionHandler<T extends YubiKeyConnection> implements ConnectionHandler<T> {
    private final int interfaceClass;
    private final int interfaceSubclass;

    protected InterfaceConnectionHandler(int i, int i2) {
        this.interfaceClass = i;
        this.interfaceSubclass = i2;
    }

    @Override // com.yubico.yubikit.android.transport.usb.connection.ConnectionHandler
    public boolean isAvailable(UsbDevice usbDevice) {
        return getInterface(usbDevice) != null;
    }

    protected UsbInterface getClaimedInterface(UsbDevice usbDevice, UsbDeviceConnection usbDeviceConnection) throws IOException {
        UsbInterface usbInterface = getInterface(usbDevice);
        if (usbInterface != null) {
            if (usbDeviceConnection.claimInterface(usbInterface, true)) {
                return usbInterface;
            }
            throw new IOException("Unable to claim interface");
        }
        throw new IllegalStateException("The connection type is not available via this transport");
    }

    @Nullable
    private UsbInterface getInterface(UsbDevice usbDevice) {
        for (int i = 0; i < usbDevice.getInterfaceCount(); i++) {
            UsbInterface usbInterface = usbDevice.getInterface(i);
            if (usbInterface.getInterfaceClass() == this.interfaceClass && usbInterface.getInterfaceSubclass() == this.interfaceSubclass) {
                return usbInterface;
            }
        }
        return null;
    }
}
