package com.yubico.yubikit.android.transport.usb;

import android.content.Context;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import com.yubico.yubikit.android.transport.usb.connection.ConnectionManager;
import com.yubico.yubikit.android.transport.usb.connection.FidoConnectionHandler;
import com.yubico.yubikit.android.transport.usb.connection.OtpConnectionHandler;
import com.yubico.yubikit.android.transport.usb.connection.SmartCardConnectionHandler;
import com.yubico.yubikit.android.transport.usb.connection.UsbFidoConnection;
import com.yubico.yubikit.android.transport.usb.connection.UsbOtpConnection;
import com.yubico.yubikit.android.transport.usb.connection.UsbSmartCardConnection;
import com.yubico.yubikit.core.util.Callback;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes3.dex */
public class UsbYubiKeyManager {
    private static final Logger logger;
    private final Context context;

    @Nullable
    private MyDeviceListener internalListener = null;
    private final UsbManager usbManager;

    static {
        ConnectionManager.registerConnectionHandler(UsbSmartCardConnection.class, new SmartCardConnectionHandler());
        ConnectionManager.registerConnectionHandler(UsbOtpConnection.class, new OtpConnectionHandler());
        ConnectionManager.registerConnectionHandler(UsbFidoConnection.class, new FidoConnectionHandler());
        logger = LoggerFactory.getLogger((Class<?>) UsbYubiKeyManager.class);
    }

    public UsbYubiKeyManager(Context context) {
        this.context = context;
        this.usbManager = (UsbManager) context.getSystemService("usb");
    }

    public synchronized void enable(UsbConfiguration usbConfiguration, Callback<? super UsbYubiKeyDevice> callback) {
        disable();
        MyDeviceListener myDeviceListener = new MyDeviceListener(usbConfiguration, callback);
        this.internalListener = myDeviceListener;
        UsbDeviceManager.registerUsbListener(this.context, myDeviceListener);
    }

    public synchronized void disable() {
        MyDeviceListener myDeviceListener = this.internalListener;
        if (myDeviceListener != null) {
            UsbDeviceManager.unregisterUsbListener(this.context, myDeviceListener);
            this.internalListener = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class MyDeviceListener implements UsbDeviceManager.UsbDeviceListener {
        private final Map<UsbDevice, UsbYubiKeyDevice> devices;
        private final Callback<? super UsbYubiKeyDevice> listener;
        private final UsbConfiguration usbConfiguration;

        private MyDeviceListener(UsbConfiguration usbConfiguration, Callback<? super UsbYubiKeyDevice> callback) {
            this.devices = new HashMap();
            this.usbConfiguration = usbConfiguration;
            this.listener = callback;
        }

        @Override // com.yubico.yubikit.android.transport.usb.UsbDeviceManager.UsbDeviceListener
        public void deviceAttached(UsbDevice usbDevice) {
            try {
                final UsbYubiKeyDevice usbYubiKeyDevice = new UsbYubiKeyDevice(UsbYubiKeyManager.this.usbManager, usbDevice);
                this.devices.put(usbDevice, usbYubiKeyDevice);
                if (this.usbConfiguration.isHandlePermissions() && !usbYubiKeyDevice.hasPermission()) {
                    com.yubico.yubikit.core.internal.Logger.debug(UsbYubiKeyManager.logger, "request permission");
                    UsbDeviceManager.requestPermission(UsbYubiKeyManager.this.context, usbDevice, new UsbDeviceManager.PermissionResultListener() { // from class: com.yubico.yubikit.android.transport.usb.UsbYubiKeyManager$MyDeviceListener$$ExternalSyntheticLambda0
                        @Override // com.yubico.yubikit.android.transport.usb.UsbDeviceManager.PermissionResultListener
                        public final void onPermissionResult(UsbDevice usbDevice2, boolean z) {
                            this.f$0.m14401xc1d39ddb(usbYubiKeyDevice, usbDevice2, z);
                        }
                    });
                } else {
                    this.listener.invoke(usbYubiKeyDevice);
                }
            } catch (IllegalArgumentException unused) {
                com.yubico.yubikit.core.internal.Logger.debug(UsbYubiKeyManager.logger, "Attached usbDevice(vid={},pid={}) is not recognized as a valid YubiKey", Integer.valueOf(usbDevice.getVendorId()), Integer.valueOf(usbDevice.getProductId()));
            }
        }

        /* JADX INFO: renamed from: lambda$deviceAttached$0$com-yubico-yubikit-android-transport-usb-UsbYubiKeyManager$MyDeviceListener, reason: not valid java name */
        /* synthetic */ void m14401xc1d39ddb(UsbYubiKeyDevice usbYubiKeyDevice, UsbDevice usbDevice, boolean z) {
            com.yubico.yubikit.core.internal.Logger.debug(UsbYubiKeyManager.logger, "permission result {}", Boolean.valueOf(z));
            if (z) {
                synchronized (UsbYubiKeyManager.this) {
                    if (UsbYubiKeyManager.this.internalListener == this) {
                        this.listener.invoke(usbYubiKeyDevice);
                    }
                }
            }
        }

        @Override // com.yubico.yubikit.android.transport.usb.UsbDeviceManager.UsbDeviceListener
        public void deviceRemoved(UsbDevice usbDevice) {
            UsbYubiKeyDevice usbYubiKeyDeviceRemove = this.devices.remove(usbDevice);
            if (usbYubiKeyDeviceRemove != null) {
                usbYubiKeyDeviceRemove.close();
            }
        }
    }
}
