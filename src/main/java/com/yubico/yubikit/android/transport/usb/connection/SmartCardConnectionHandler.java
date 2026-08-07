package com.yubico.yubikit.android.transport.usb.connection;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.util.Pair;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class SmartCardConnectionHandler extends InterfaceConnectionHandler<UsbSmartCardConnection> {
    @Override // com.yubico.yubikit.android.transport.usb.connection.InterfaceConnectionHandler, com.yubico.yubikit.android.transport.usb.connection.ConnectionHandler
    public /* bridge */ /* synthetic */ boolean isAvailable(UsbDevice usbDevice) {
        return super.isAvailable(usbDevice);
    }

    public SmartCardConnectionHandler() {
        super(11, 0);
    }

    @Override // com.yubico.yubikit.android.transport.usb.connection.ConnectionHandler
    public UsbSmartCardConnection createConnection(UsbDevice usbDevice, UsbDeviceConnection usbDeviceConnection) throws IOException {
        UsbInterface claimedInterface = getClaimedInterface(usbDevice, usbDeviceConnection);
        Pair<UsbEndpoint, UsbEndpoint> pairFindEndpoints = findEndpoints(claimedInterface);
        return new UsbSmartCardConnection(usbDeviceConnection, claimedInterface, (UsbEndpoint) pairFindEndpoints.first, (UsbEndpoint) pairFindEndpoints.second);
    }

    private Pair<UsbEndpoint, UsbEndpoint> findEndpoints(UsbInterface usbInterface) {
        UsbEndpoint usbEndpoint = null;
        UsbEndpoint usbEndpoint2 = null;
        for (int i = 0; i < usbInterface.getEndpointCount(); i++) {
            UsbEndpoint endpoint = usbInterface.getEndpoint(i);
            if (endpoint.getType() == 2) {
                if (endpoint.getDirection() == 128) {
                    usbEndpoint = endpoint;
                } else {
                    usbEndpoint2 = endpoint;
                }
            }
        }
        if (usbEndpoint != null && usbEndpoint2 != null) {
            return new Pair<>(usbEndpoint, usbEndpoint2);
        }
        throw new IllegalStateException("Missing CCID bulk endpoints");
    }
}
