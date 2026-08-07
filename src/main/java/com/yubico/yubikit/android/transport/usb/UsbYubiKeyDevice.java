package com.yubico.yubikit.android.transport.usb;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import com.yubico.yubikit.android.transport.usb.connection.ConnectionManager;
import com.yubico.yubikit.core.Transport;
import com.yubico.yubikit.core.UsbPid;
import com.yubico.yubikit.core.YubiKeyConnection;
import com.yubico.yubikit.core.YubiKeyDevice;
import com.yubico.yubikit.core.otp.OtpConnection;
import com.yubico.yubikit.core.util.Callback;
import com.yubico.yubikit.core.util.Result;
import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes3.dex */
public class UsbYubiKeyDevice implements YubiKeyDevice, Closeable {
    private final ConnectionManager connectionManager;
    private final UsbDevice usbDevice;
    private final UsbManager usbManager;
    private final UsbPid usbPid;
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) UsbYubiKeyDevice.class);
    private static final Callback<Result<OtpConnection, IOException>> CLOSE_OTP = new Callback() { // from class: com.yubico.yubikit.android.transport.usb.UsbYubiKeyDevice$$ExternalSyntheticLambda0
        @Override // com.yubico.yubikit.core.util.Callback
        public final void invoke(Object obj) {
            UsbYubiKeyDevice.lambda$static$2((Result) obj);
        }
    };
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    @Nullable
    private CachedOtpConnection otpConnection = null;

    @Nullable
    private Runnable onClosed = null;

    static /* synthetic */ void lambda$static$2(Result result) {
    }

    public UsbYubiKeyDevice(UsbManager usbManager, UsbDevice usbDevice) throws IllegalArgumentException {
        if (usbDevice.getVendorId() != 4176) {
            throw new IllegalArgumentException("Invalid vendor id");
        }
        this.usbPid = UsbPid.fromValue(usbDevice.getProductId());
        this.connectionManager = new ConnectionManager(usbManager, usbDevice);
        this.usbDevice = usbDevice;
        this.usbManager = usbManager;
    }

    public boolean hasPermission() {
        return this.usbManager.hasPermission(this.usbDevice);
    }

    public UsbDevice getUsbDevice() {
        return this.usbDevice;
    }

    public UsbPid getPid() {
        return this.usbPid;
    }

    @Override // com.yubico.yubikit.core.YubiKeyDevice
    public Transport getTransport() {
        return Transport.USB;
    }

    @Override // com.yubico.yubikit.core.YubiKeyDevice
    public boolean supportsConnection(Class<? extends YubiKeyConnection> cls) {
        return this.connectionManager.supportsConnection(cls);
    }

    @Override // com.yubico.yubikit.core.YubiKeyDevice
    public <T extends YubiKeyConnection> void requestConnection(final Class<T> cls, final Callback<Result<T, IOException>> callback) {
        verifyAccess(cls);
        if (OtpConnection.class.isAssignableFrom(cls)) {
            Callback callback2 = new Callback() { // from class: com.yubico.yubikit.android.transport.usb.UsbYubiKeyDevice$$ExternalSyntheticLambda1
                @Override // com.yubico.yubikit.core.util.Callback
                public final void invoke(Object obj) {
                    callback.invoke((Result) obj);
                }
            };
            CachedOtpConnection cachedOtpConnection = this.otpConnection;
            if (cachedOtpConnection == null) {
                this.otpConnection = new CachedOtpConnection(callback2);
                return;
            } else {
                cachedOtpConnection.queue.offer(callback2);
                return;
            }
        }
        CachedOtpConnection cachedOtpConnection2 = this.otpConnection;
        if (cachedOtpConnection2 != null) {
            cachedOtpConnection2.close();
            this.otpConnection = null;
        }
        this.executorService.submit(new Runnable() { // from class: com.yubico.yubikit.android.transport.usb.UsbYubiKeyDevice$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m14399xa3bb7d5e(cls, callback);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$requestConnection$1$com-yubico-yubikit-android-transport-usb-UsbYubiKeyDevice, reason: not valid java name */
    /* synthetic */ void m14399xa3bb7d5e(Class cls, Callback callback) {
        try {
            YubiKeyConnection yubiKeyConnectionOpenConnection = this.connectionManager.openConnection(cls);
            try {
                callback.invoke(Result.success(yubiKeyConnectionOpenConnection));
                if (yubiKeyConnectionOpenConnection != null) {
                    yubiKeyConnectionOpenConnection.close();
                }
            } catch (Throwable th) {
                if (yubiKeyConnectionOpenConnection != null) {
                    try {
                        yubiKeyConnectionOpenConnection.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (IOException e) {
            callback.invoke(Result.failure(e));
        }
    }

    @Override // com.yubico.yubikit.core.YubiKeyDevice
    public <T extends YubiKeyConnection> T openConnection(Class<T> cls) throws IOException {
        verifyAccess(cls);
        return (T) this.connectionManager.openConnection(cls);
    }

    public void setOnClosed(Runnable runnable) {
        if (this.executorService.isTerminated()) {
            runnable.run();
        } else {
            this.onClosed = runnable;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.yubico.yubikit.core.internal.Logger.debug(logger, "Closing YubiKey device");
        CachedOtpConnection cachedOtpConnection = this.otpConnection;
        if (cachedOtpConnection != null) {
            cachedOtpConnection.close();
            this.otpConnection = null;
        }
        Runnable runnable = this.onClosed;
        if (runnable != null) {
            this.executorService.submit(runnable);
        }
        this.executorService.shutdown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    class CachedOtpConnection implements Closeable {
        private final LinkedBlockingQueue<Callback<Result<OtpConnection, IOException>>> queue;

        private CachedOtpConnection(final Callback<Result<OtpConnection, IOException>> callback) {
            LinkedBlockingQueue<Callback<Result<OtpConnection, IOException>>> linkedBlockingQueue = new LinkedBlockingQueue<>();
            this.queue = linkedBlockingQueue;
            com.yubico.yubikit.core.internal.Logger.debug(UsbYubiKeyDevice.logger, "Creating new CachedOtpConnection");
            linkedBlockingQueue.offer(callback);
            UsbYubiKeyDevice.this.executorService.submit(new Runnable() { // from class: com.yubico.yubikit.android.transport.usb.UsbYubiKeyDevice$CachedOtpConnection$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m14400xb87e51d3(callback);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$new$0$com-yubico-yubikit-android-transport-usb-UsbYubiKeyDevice$CachedOtpConnection, reason: not valid java name */
        /* synthetic */ void m14400xb87e51d3(Callback callback) {
            try {
                OtpConnection otpConnection = (OtpConnection) UsbYubiKeyDevice.this.connectionManager.openConnection(OtpConnection.class);
                while (true) {
                    try {
                        try {
                            Callback<Result<OtpConnection, IOException>> callbackTake = this.queue.take();
                            if (callbackTake == UsbYubiKeyDevice.CLOSE_OTP) {
                                com.yubico.yubikit.core.internal.Logger.debug(UsbYubiKeyDevice.logger, "Closing CachedOtpConnection");
                                break;
                            } else {
                                try {
                                    callbackTake.invoke(Result.success(otpConnection));
                                } catch (Exception e) {
                                    com.yubico.yubikit.core.internal.Logger.error(UsbYubiKeyDevice.logger, "OtpConnection callback threw an exception", e);
                                }
                            }
                        } catch (InterruptedException e2) {
                            com.yubico.yubikit.core.internal.Logger.error(UsbYubiKeyDevice.logger, "InterruptedException when processing OtpConnection: ", e2);
                        }
                    } catch (Throwable th) {
                        if (otpConnection != null) {
                            try {
                                otpConnection.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                }
                if (otpConnection != null) {
                    otpConnection.close();
                }
            } catch (IOException e3) {
                callback.invoke(Result.failure(e3));
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.queue.offer(UsbYubiKeyDevice.CLOSE_OTP);
        }
    }

    private <T extends YubiKeyConnection> void verifyAccess(Class<T> cls) {
        if (!hasPermission()) {
            throw new IllegalStateException("Device access not permitted");
        }
        if (!supportsConnection(cls)) {
            throw new IllegalStateException("Unsupported connection type");
        }
    }

    @Nonnull
    public String toString() {
        return "UsbYubiKeyDevice{usbDevice=" + this.usbDevice + ", usbPid=" + this.usbPid + AbstractJsonLexerKt.END_OBJ;
    }
}
