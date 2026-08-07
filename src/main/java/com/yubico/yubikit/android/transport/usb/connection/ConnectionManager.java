package com.yubico.yubikit.android.transport.usb.connection;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbManager;
import com.yubico.yubikit.android.transport.usb.NoPermissionsException;
import com.yubico.yubikit.core.YubiKeyConnection;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class ConnectionManager {
    private static final Map<Class<? extends YubiKeyConnection>, ConnectionHandler<?>> handlers = new HashMap();
    private final UsbDevice usbDevice;
    private final UsbManager usbManager;

    public static <T extends YubiKeyConnection> void registerConnectionHandler(Class<T> cls, ConnectionHandler<? extends T> connectionHandler) {
        Map<Class<? extends YubiKeyConnection>, ConnectionHandler<?>> map = handlers;
        synchronized (map) {
            map.put(cls, connectionHandler);
        }
    }

    public ConnectionManager(UsbManager usbManager, UsbDevice usbDevice) {
        this.usbManager = usbManager;
        this.usbDevice = usbDevice;
    }

    public boolean supportsConnection(Class<? extends YubiKeyConnection> cls) {
        ConnectionHandler handler = getHandler(cls);
        return handler != null && handler.isAvailable(this.usbDevice);
    }

    public <T extends YubiKeyConnection> T openConnection(Class<T> cls) throws IOException {
        ConnectionHandler<T> handler = getHandler(cls);
        if (handler != null) {
            UsbDeviceConnection usbDeviceConnectionOpenDeviceConnection = openDeviceConnection(this.usbDevice);
            try {
                return (T) handler.createConnection(this.usbDevice, usbDeviceConnectionOpenDeviceConnection);
            } catch (IOException e) {
                usbDeviceConnectionOpenDeviceConnection.close();
                throw e;
            }
        }
        throw new IllegalStateException("The connection type is not available via this transport");
    }

    @Nullable
    private <T extends YubiKeyConnection> ConnectionHandler<T> getHandler(Class<T> cls) {
        Map<Class<? extends YubiKeyConnection>, ConnectionHandler<?>> map = handlers;
        synchronized (map) {
            for (Map.Entry<Class<? extends YubiKeyConnection>, ConnectionHandler<?>> entry : map.entrySet()) {
                if (cls.isAssignableFrom(entry.getKey())) {
                    return (ConnectionHandler) entry.getValue();
                }
            }
            return null;
        }
    }

    private UsbDeviceConnection openDeviceConnection(UsbDevice usbDevice) throws IOException {
        if (!this.usbManager.hasPermission(usbDevice)) {
            throw new NoPermissionsException(usbDevice);
        }
        return this.usbManager.openDevice(usbDevice);
    }
}
