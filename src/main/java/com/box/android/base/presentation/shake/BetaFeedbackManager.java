package com.box.android.base.presentation.shake;

import android.content.Context;
import android.graphics.Bitmap;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.os.VibratorManager;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import com.box.android.base.R;
import com.box.android.base.utilities.ScreenshotCapture;
import com.box.android.common.utilities.BuildConfigProvider;
import com.box.android.coreservices.services.IntentServices;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BetaFeedbackManager.kt */
/* JADX INFO: loaded from: classes9.dex */
@Singleton
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u000fJ\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0003J\u001a\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u0006\u0010\u001b\u001a\u00020\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/box/android/base/presentation/shake/BetaFeedbackManager;", "", "intentServices", "Lcom/box/android/coreservices/services/IntentServices;", "screenshotCapture", "Lcom/box/android/base/utilities/ScreenshotCapture;", "<init>", "(Lcom/box/android/coreservices/services/IntentServices;Lcom/box/android/base/utilities/ScreenshotCapture;)V", "shakeDetector", "Lcom/box/android/base/presentation/shake/ShakeDetector;", "sensorManager", "Landroid/hardware/SensorManager;", "isDialogShowing", "", "registerShakeDetectionIfNeeded", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "unregisterShakeDetectionIfNeeded", "handleShakeDetected", "captureScreenshotAndShowDialog", "vibrateOnShake", "context", "Landroid/content/Context;", "showFeedbackDialog", "screenshotUri", "Landroid/net/Uri;", "onDialogDismissed", "Companion", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BetaFeedbackManager {
    private static final String FEEDBACK_SCREENSHOT_FILENAME = "beta_feedback_screenshot.png";
    private final IntentServices intentServices;
    private boolean isDialogShowing;
    private final ScreenshotCapture screenshotCapture;
    private SensorManager sensorManager;
    private ShakeDetector shakeDetector;
    public static final int $stable = 8;

    @Inject
    public BetaFeedbackManager(IntentServices intentServices, ScreenshotCapture screenshotCapture) {
        Intrinsics.checkNotNullParameter(intentServices, "intentServices");
        Intrinsics.checkNotNullParameter(screenshotCapture, "screenshotCapture");
        this.intentServices = intentServices;
        this.screenshotCapture = screenshotCapture;
    }

    public final void registerShakeDetectionIfNeeded(final AppCompatActivity activity) {
        Sensor defaultSensor;
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (BuildConfigProvider.INSTANCE.isBetaTrack()) {
            if (this.shakeDetector == null || this.sensorManager == null) {
                Object systemService = activity.getSystemService("sensor");
                SensorManager sensorManager = systemService instanceof SensorManager ? (SensorManager) systemService : null;
                this.sensorManager = sensorManager;
                if (sensorManager == null || (defaultSensor = sensorManager.getDefaultSensor(1)) == null) {
                    return;
                }
                ShakeDetector shakeDetector = new ShakeDetector(new Function0() { // from class: com.box.android.base.presentation.shake.BetaFeedbackManager$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BetaFeedbackManager.registerShakeDetectionIfNeeded$lambda$0(this.f$0, activity);
                    }
                });
                this.shakeDetector = shakeDetector;
                SensorManager sensorManager2 = this.sensorManager;
                if (sensorManager2 != null) {
                    sensorManager2.registerListener(shakeDetector, defaultSensor, 2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit registerShakeDetectionIfNeeded$lambda$0(BetaFeedbackManager betaFeedbackManager, AppCompatActivity appCompatActivity) {
        if (!betaFeedbackManager.isDialogShowing) {
            betaFeedbackManager.handleShakeDetected(appCompatActivity);
        }
        return Unit.INSTANCE;
    }

    public final void unregisterShakeDetectionIfNeeded() {
        if (BuildConfigProvider.INSTANCE.isBetaTrack()) {
            SensorManager sensorManager = this.sensorManager;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this.shakeDetector);
            }
            this.sensorManager = null;
            this.shakeDetector = null;
        }
    }

    public final void handleShakeDetected(AppCompatActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.isDialogShowing = true;
        vibrateOnShake(activity);
        captureScreenshotAndShowDialog(activity);
    }

    private final void captureScreenshotAndShowDialog(final AppCompatActivity activity) {
        final String string = activity.getString(R.string.fileProviderAuthority);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        ScreenshotCapture screenshotCapture = this.screenshotCapture;
        Window window = activity.getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
        screenshotCapture.capture(window, new Function1() { // from class: com.box.android.base.presentation.shake.BetaFeedbackManager$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BetaFeedbackManager.captureScreenshotAndShowDialog$lambda$0(this.f$0, activity, string, (Bitmap) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit captureScreenshotAndShowDialog$lambda$0(BetaFeedbackManager betaFeedbackManager, AppCompatActivity appCompatActivity, String str, Bitmap bitmap) {
        betaFeedbackManager.showFeedbackDialog(appCompatActivity, bitmap != null ? ScreenshotCapture.saveToCacheAndGetUri$default(betaFeedbackManager.screenshotCapture, appCompatActivity, bitmap, str, FEEDBACK_SCREENSHOT_FILENAME, 0, 16, null) : null);
        return Unit.INSTANCE;
    }

    private final void vibrateOnShake(Context context) {
        Vibrator defaultVibrator;
        if (Build.VERSION.SDK_INT < 31) {
            return;
        }
        Object systemService = context.getSystemService("vibrator_manager");
        VibratorManager vibratorManager = systemService instanceof VibratorManager ? (VibratorManager) systemService : null;
        if (vibratorManager == null || (defaultVibrator = vibratorManager.getDefaultVibrator()) == null || !defaultVibrator.hasVibrator()) {
            return;
        }
        defaultVibrator.vibrate(VibrationEffect.createOneShot(50L, -1));
    }

    private final void showFeedbackDialog(AppCompatActivity activity, Uri screenshotUri) {
        activity.startActivity(this.intentServices.betaFeedbackActivityIntent(activity, screenshotUri));
    }

    public final void onDialogDismissed() {
        this.isDialogShowing = false;
    }
}
