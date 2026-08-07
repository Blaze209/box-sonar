package com.yubico.yubikit.android.transport.usb;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.os.Build;
import com.microsoft.intune.mam.client.app.MAMPendingIntent;
import com.microsoft.intune.mam.client.content.MAMBroadcastReceiver;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.WeakHashMap;
import javax.annotation.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes3.dex */
final class UsbDeviceManager {
    private static final String ACTION_USB_PERMISSION = "com.yubico.yubikey.USB_PERMISSION";
    public static final int YUBICO_VENDOR_ID = 4176;

    @Nullable
    private static UsbDeviceManager instance;
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) UsbDeviceManager.class);
    private final DeviceBroadcastReceiver broadcastReceiver;
    private final PermissionBroadcastReceiver permissionReceiver;
    private final Set<UsbDeviceListener> deviceListeners = new HashSet();
    private final WeakHashMap<UsbDevice, Set<PermissionResultListener>> contexts = new WeakHashMap<>();
    private final Set<UsbDevice> awaitingPermissions = new HashSet();

    interface PermissionResultListener {
        void onPermissionResult(UsbDevice usbDevice, boolean z);
    }

    interface UsbDeviceListener {
        void deviceAttached(UsbDevice usbDevice);

        void deviceRemoved(UsbDevice usbDevice);
    }

    UsbDeviceManager() {
        this.broadcastReceiver = new DeviceBroadcastReceiver();
        this.permissionReceiver = new PermissionBroadcastReceiver();
    }

    private static synchronized UsbDeviceManager getInstance() {
        if (instance == null) {
            instance = new UsbDeviceManager();
        }
        return instance;
    }

    static void registerUsbListener(Context context, UsbDeviceListener usbDeviceListener) {
        getInstance().addUsbListener(context, usbDeviceListener);
    }

    static void unregisterUsbListener(Context context, UsbDeviceListener usbDeviceListener) {
        getInstance().removeUsbListener(context, usbDeviceListener);
    }

    static void requestPermission(Context context, UsbDevice usbDevice, PermissionResultListener permissionResultListener) {
        getInstance().requestDevicePermission(context, usbDevice, permissionResultListener);
    }

    private synchronized void addUsbListener(Context context, UsbDeviceListener usbDeviceListener) {
        if (this.deviceListeners.isEmpty()) {
            Collection<UsbDevice> collectionValues = ((UsbManager) context.getSystemService("usb")).getDeviceList().values();
            IntentFilter intentFilter = new IntentFilter("android.hardware.usb.action.USB_DEVICE_ATTACHED");
            intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
            context.registerReceiver(this.broadcastReceiver, intentFilter);
            for (UsbDevice usbDevice : collectionValues) {
                if (usbDevice.getVendorId() == 4176) {
                    onDeviceAttach(usbDevice);
                }
            }
        }
        this.deviceListeners.add(usbDeviceListener);
        Iterator<UsbDevice> it = this.contexts.keySet().iterator();
        while (it.hasNext()) {
            usbDeviceListener.deviceAttached(it.next());
        }
    }

    private synchronized void removeUsbListener(Context context, UsbDeviceListener usbDeviceListener) {
        this.deviceListeners.remove(usbDeviceListener);
        Iterator<UsbDevice> it = this.contexts.keySet().iterator();
        while (it.hasNext()) {
            usbDeviceListener.deviceRemoved(it.next());
        }
        if (this.deviceListeners.isEmpty()) {
            context.unregisterReceiver(this.broadcastReceiver);
            this.contexts.clear();
        }
    }

    private synchronized void requestDevicePermission(Context context, UsbDevice usbDevice, PermissionResultListener permissionResultListener) {
        Set set = (Set) Objects.requireNonNull(this.contexts.get(usbDevice));
        synchronized (set) {
            set.add(permissionResultListener);
        }
        synchronized (this.awaitingPermissions) {
            if (!this.awaitingPermissions.contains(usbDevice)) {
                if (this.awaitingPermissions.isEmpty()) {
                    registerPermissionsReceiver(context, this.permissionReceiver);
                }
                com.yubico.yubikit.core.internal.Logger.debug(logger, "Requesting permission for UsbDevice: {}", usbDevice.getDeviceName());
                int i = Build.VERSION.SDK_INT >= 31 ? 33554432 : 0;
                Intent intent = new Intent(ACTION_USB_PERMISSION);
                intent.setPackage(context.getPackageName());
                ((UsbManager) context.getSystemService("usb")).requestPermission(usbDevice, MAMPendingIntent.getBroadcast(context, 0, intent, i));
                this.awaitingPermissions.add(usbDevice);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDeviceAttach(UsbDevice usbDevice) {
        com.yubico.yubikit.core.internal.Logger.debug(logger, "UsbDevice attached: {}", usbDevice.getDeviceName());
        this.contexts.put(usbDevice, new HashSet());
        Iterator<UsbDeviceListener> it = this.deviceListeners.iterator();
        while (it.hasNext()) {
            it.next().deviceAttached(usbDevice);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPermission(Context context, UsbDevice usbDevice, boolean z) {
        com.yubico.yubikit.core.internal.Logger.debug(logger, "Permission result for {}, permitted: {}", usbDevice.getDeviceName(), Boolean.valueOf(z));
        Set<PermissionResultListener> set = this.contexts.get(usbDevice);
        if (set != null) {
            synchronized (set) {
                Iterator<PermissionResultListener> it = set.iterator();
                while (it.hasNext()) {
                    it.next().onPermissionResult(usbDevice, z);
                }
                set.clear();
            }
        }
        synchronized (this.awaitingPermissions) {
            if (this.awaitingPermissions.remove(usbDevice) && this.awaitingPermissions.isEmpty()) {
                context.unregisterReceiver(this.permissionReceiver);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDeviceDetach(Context context, UsbDevice usbDevice) {
        com.yubico.yubikit.core.internal.Logger.debug(logger, "UsbDevice detached: {}", usbDevice.getDeviceName());
        if (this.contexts.remove(usbDevice) != null) {
            Iterator<UsbDeviceListener> it = this.deviceListeners.iterator();
            while (it.hasNext()) {
                it.next().deviceRemoved(usbDevice);
            }
        }
        synchronized (this.awaitingPermissions) {
            if (this.awaitingPermissions.remove(usbDevice) && this.awaitingPermissions.isEmpty()) {
                context.unregisterReceiver(this.permissionReceiver);
            }
        }
    }

    private class DeviceBroadcastReceiver extends MAMBroadcastReceiver {
        private DeviceBroadcastReceiver() {
        }

        @Override // com.microsoft.intune.mam.client.content.HookedBroadcastReceiver
        public void onMAMReceive(Context context, Intent intent) {
            String action = intent.getAction();
            UsbDevice usbManagerExtraDevice = UsbDeviceManager.getUsbManagerExtraDevice(intent);
            if (usbManagerExtraDevice == null || usbManagerExtraDevice.getVendorId() != 4176) {
                return;
            }
            if ("android.hardware.usb.action.USB_DEVICE_ATTACHED".equals(action)) {
                UsbDeviceManager.this.onDeviceAttach(usbManagerExtraDevice);
            } else if ("android.hardware.usb.action.USB_DEVICE_DETACHED".equals(action)) {
                UsbDeviceManager.this.onDeviceDetach(context, usbManagerExtraDevice);
            }
        }
    }

    private class PermissionBroadcastReceiver extends MAMBroadcastReceiver {
        private PermissionBroadcastReceiver() {
        }

        @Override // com.microsoft.intune.mam.client.content.HookedBroadcastReceiver
        public void onMAMReceive(Context context, Intent intent) {
            if (UsbDeviceManager.ACTION_USB_PERMISSION.equals(intent.getAction())) {
                UsbDevice usbManagerExtraDevice = UsbDeviceManager.getUsbManagerExtraDevice(intent);
                UsbManager usbManager = (UsbManager) context.getSystemService("usb");
                if (usbManagerExtraDevice != null) {
                    UsbDeviceManager.this.onPermission(context, usbManagerExtraDevice, usbManager.hasPermission(usbManagerExtraDevice));
                }
            }
        }
    }

    private static void registerPermissionsReceiver(Context context, PermissionBroadcastReceiver permissionBroadcastReceiver) {
        if (Build.VERSION.SDK_INT >= 33) {
            context.registerReceiver(permissionBroadcastReceiver, new IntentFilter(ACTION_USB_PERMISSION), 4);
        } else {
            context.registerReceiver(permissionBroadcastReceiver, new IntentFilter(ACTION_USB_PERMISSION));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static UsbDevice getUsbManagerExtraDevice(Intent intent) {
        if (Build.VERSION.SDK_INT > 33) {
            return (UsbDevice) intent.getParcelableExtra(SemanticAttributes.EventDomainValues.DEVICE, UsbDevice.class);
        }
        return (UsbDevice) intent.getParcelableExtra(SemanticAttributes.EventDomainValues.DEVICE);
    }
}
