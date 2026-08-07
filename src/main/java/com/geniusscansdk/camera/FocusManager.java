package com.geniusscansdk.camera;

import android.graphics.Rect;
import android.hardware.Camera;
import android.os.CountDownTimer;
import java.util.Collections;

/* JADX INFO: loaded from: classes13.dex */
class FocusManager {
    private static final int FOCUS_RETRY_COUNT = 3;
    public static final int FOCUS_TIMER_DURATION = 3000;
    private static final int HALF_FOCUS_AREA_SIZE = 200;
    private AutoFocusCallback autoFocusCallback;
    private Camera camera;
    private Callback cameraTriggerFocusCallback;
    private FocusIndicator currentFocusIndicator;
    private FocusAreaRotator focusAreaRotator;
    private FocusState focusState;
    private CountDownTimer userFocusTimer;

    public interface Callback {
        void onAutofocusFinished(boolean z);
    }

    private enum FocusState {
        DEFAULT,
        USER_FOCUS,
        CAMERA_TRIGGER
    }

    public FocusManager(Callback callback) {
        this(callback, new FocusAreaRotator());
    }

    FocusManager(Callback callback, FocusAreaRotator focusAreaRotator) {
        this.autoFocusCallback = new AutoFocusCallback();
        this.cameraTriggerFocusCallback = callback;
        this.focusAreaRotator = focusAreaRotator;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public void initialize() {
        this.focusState = FocusState.DEFAULT;
        setFocusMode("continuous-picture");
    }

    public void autofocusBeforeTrigger() {
        setFocusMode("auto");
        this.focusState = FocusState.CAMERA_TRIGGER;
        autofocus();
    }

    public void localizedAutofocus(float f, float f2, float f3, FocusIndicator focusIndicator) {
        if (this.camera == null) {
            return;
        }
        this.currentFocusIndicator = focusIndicator;
        if (focusIndicator != null) {
            focusIndicator.showStart();
        }
        Camera.Parameters parameters = this.camera.getParameters();
        setFocusMode(parameters, "auto");
        if (parameters.getMaxNumFocusAreas() > 0) {
            parameters.setFocusAreas(Collections.singletonList(new Camera.Area(calculateFocusArea(f, f2, f3), 1000)));
        }
        this.camera.setParameters(parameters);
        this.focusState = FocusState.USER_FOCUS;
        autofocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.geniusscansdk.camera.FocusManager$1] */
    public void startTimerToSwitchToDefaultFocusState() {
        CountDownTimer countDownTimer = this.userFocusTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.userFocusTimer = new CountDownTimer(3000L, 3000L) { // from class: com.geniusscansdk.camera.FocusManager.1
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (FocusManager.this.currentFocusIndicator != null) {
                    FocusManager.this.currentFocusIndicator.hide();
                    FocusManager.this.currentFocusIndicator = null;
                }
                if (FocusManager.this.focusState == FocusState.USER_FOCUS) {
                    FocusManager.this.initialize();
                }
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void autofocus() {
        Camera camera = this.camera;
        if (camera == null) {
            return;
        }
        try {
            camera.autoFocus(this.autoFocusCallback);
        } catch (RuntimeException e) {
            e.printStackTrace();
            AutoFocusCallback autoFocusCallback = this.autoFocusCallback;
            if (autoFocusCallback != null) {
                autoFocusCallback.onAutoFocus(false, this.camera);
            }
        }
    }

    private void setFocusMode(String str) {
        Camera camera = this.camera;
        if (camera == null) {
            return;
        }
        Camera.Parameters parameters = camera.getParameters();
        if (setFocusMode(parameters, str)) {
            this.camera.setParameters(parameters);
        }
    }

    private boolean setFocusMode(Camera.Parameters parameters, String str) {
        if (str.equals(parameters.getFocusMode()) || !parameters.getSupportedFocusModes().contains(str)) {
            return false;
        }
        parameters.setFocusMode(str);
        if (!str.equals("continuous-picture")) {
            return true;
        }
        parameters.setFocusAreas(null);
        return true;
    }

    private Rect calculateFocusArea(float f, float f2, float f3) {
        int iClamp = clamp((int) (f * 2000.0f), 200, 1800);
        int iClamp2 = clamp((int) (f2 * 2000.0f), 200, 1800);
        return this.focusAreaRotator.rotate(new Rect(iClamp - 1200, iClamp2 - 1200, iClamp - 800, iClamp2 - 800), -f3);
    }

    private static int clamp(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i3, i));
    }

    private class AutoFocusCallback implements Camera.AutoFocusCallback {
        private int retryCount;

        private AutoFocusCallback() {
            this.retryCount = 0;
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z, Camera camera) {
            int i;
            int i2 = AnonymousClass2.$SwitchMap$com$geniusscansdk$camera$FocusManager$FocusState[FocusManager.this.focusState.ordinal()];
            if (i2 == 2) {
                if (FocusManager.this.currentFocusIndicator != null) {
                    FocusManager.this.currentFocusIndicator.showFinished(z);
                }
                FocusManager.this.startTimerToSwitchToDefaultFocusState();
            } else {
                if (i2 != 3) {
                    return;
                }
                if (z || (i = this.retryCount) >= 3) {
                    FocusManager.this.cameraTriggerFocusCallback.onAutofocusFinished(z);
                    this.retryCount = 0;
                } else {
                    this.retryCount = i + 1;
                    FocusManager.this.autofocus();
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.geniusscansdk.camera.FocusManager$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$geniusscansdk$camera$FocusManager$FocusState;

        static {
            int[] iArr = new int[FocusState.values().length];
            $SwitchMap$com$geniusscansdk$camera$FocusManager$FocusState = iArr;
            try {
                iArr[FocusState.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$geniusscansdk$camera$FocusManager$FocusState[FocusState.USER_FOCUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$geniusscansdk$camera$FocusManager$FocusState[FocusState.CAMERA_TRIGGER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
