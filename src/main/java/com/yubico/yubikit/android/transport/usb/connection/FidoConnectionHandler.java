package com.yubico.yubikit.android.transport.usb.connection;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.util.Pair;
import java.io.IOException;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class FidoConnectionHandler extends InterfaceConnectionHandler<UsbFidoConnection> {
    @Override // com.yubico.yubikit.android.transport.usb.connection.InterfaceConnectionHandler, com.yubico.yubikit.android.transport.usb.connection.ConnectionHandler
    public /* bridge */ /* synthetic */ boolean isAvailable(UsbDevice usbDevice) {
        return super.isAvailable(usbDevice);
    }

    public FidoConnectionHandler() {
        super(3, 0);
    }

    @Override // com.yubico.yubikit.android.transport.usb.connection.ConnectionHandler
    public UsbFidoConnection createConnection(UsbDevice usbDevice, UsbDeviceConnection usbDeviceConnection) throws IOException {
        UsbInterface claimedInterface = getClaimedInterface(usbDevice, usbDeviceConnection);
        Pair<UsbEndpoint, UsbEndpoint> pairFindEndpoints = findEndpoints(claimedInterface);
        return new UsbFidoConnection(usbDeviceConnection, claimedInterface, (UsbEndpoint) pairFindEndpoints.first, (UsbEndpoint) pairFindEndpoints.second);
    }

    @Override // com.yubico.yubikit.android.transport.usb.connection.InterfaceConnectionHandler
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
            if (usbInterface.getInterfaceClass() == 3 && usbInterface.getInterfaceSubclass() == 0) {
                return usbInterface;
            }
        }
        return null;
    }

    private static Pair<UsbEndpoint, UsbEndpoint> findEndpoints(UsbInterface usbInterface) {
        UsbEndpoint usbEndpoint = null;
        UsbEndpoint usbEndpoint2 = null;
        for (int i = 0; i < usbInterface.getEndpointCount(); i++) {
            UsbEndpoint endpoint = usbInterface.getEndpoint(i);
            if (endpoint.getType() == 3) {
                if (endpoint.getDirection() == 128) {
                    usbEndpoint = endpoint;
                } else {
                    usbEndpoint2 = endpoint;
                }
            }
        }
        return new Pair<>((UsbEndpoint) Objects.requireNonNull(usbEndpoint), (UsbEndpoint) Objects.requireNonNull(usbEndpoint2));
    }
}
