package com.yubico.yubikit.android.ui;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.view.InputDevice;
import android.view.KeyEvent;

/* JADX INFO: loaded from: classes3.dex */
public class OtpKeyListener {
    private static final int OTP_DELAY_MS = 1000;
    private static final int YUBICO_VID = 4176;
    private final OtpListener listener;
    private final SparseArray<StringBuilder> inputBuffers = new SparseArray<>();
    private final Handler handler = new Handler(Looper.getMainLooper());

    public interface OtpListener {
        void onCaptureComplete(String str);

        void onCaptureStarted();
    }

    public OtpKeyListener(OtpListener otpListener) {
        this.listener = otpListener;
    }

    public boolean onKeyEvent(KeyEvent keyEvent) {
        InputDevice device = keyEvent.getDevice();
        if (device == null || device.getVendorId() != 4176) {
            return false;
        }
        if (keyEvent.getAction() == 1) {
            final int deviceId = keyEvent.getDeviceId();
            StringBuilder sb = this.inputBuffers.get(deviceId, new StringBuilder());
            if (keyEvent.getKeyCode() == 66 || keyEvent.getKeyCode() == 160) {
                this.listener.onCaptureComplete(sb.toString());
                this.inputBuffers.delete(deviceId);
            } else {
                if (sb.length() == 0) {
                    this.handler.postDelayed(new Runnable() { // from class: com.yubico.yubikit.android.ui.OtpKeyListener$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.m14406lambda$onKeyEvent$0$comyubicoyubikitandroiduiOtpKeyListener(deviceId);
                        }
                    }, 1000L);
                    this.listener.onCaptureStarted();
                }
                sb.append((char) keyEvent.getUnicodeChar());
                this.inputBuffers.put(deviceId, sb);
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: lambda$onKeyEvent$0$com-yubico-yubikit-android-ui-OtpKeyListener, reason: not valid java name */
    /* synthetic */ void m14406lambda$onKeyEvent$0$comyubicoyubikitandroiduiOtpKeyListener(int i) {
        StringBuilder sb = this.inputBuffers.get(i, new StringBuilder());
        if (sb.length() > 0) {
            this.listener.onCaptureComplete(sb.toString());
            this.inputBuffers.delete(i);
        }
    }
}
