package com.google.androidbrowserhelper.trusted.splashscreens;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.browser.customtabs.CustomTabsSession;
import androidx.browser.customtabs.TrustedWebUtils;
import androidx.browser.trusted.TrustedWebActivityIntentBuilder;
import androidx.browser.trusted.splashscreens.SplashScreenParamKey;
import androidx.browser.trusted.splashscreens.SplashScreenVersion;
import com.google.androidbrowserhelper.trusted.Utils;

/* JADX INFO: loaded from: classes13.dex */
public class PwaWrapperSplashScreenStrategy implements SplashScreenStrategy {
    private static final String TAG = "SplashScreenStrategy";
    private static SystemBarColorPredictor sSystemBarColorPredictor = new SystemBarColorPredictor();
    private final Activity mActivity;
    private final int mBackgroundColor;
    private final int mDrawableId;
    private boolean mEnterAnimationComplete = false;
    private final int mFadeOutDurationMillis;
    private final String mFileProviderAuthority;
    private Runnable mOnEnterAnimationCompleteRunnable;
    private String mProviderPackage;
    private boolean mProviderSupportsSplashScreens;
    private final ImageView.ScaleType mScaleType;
    private Bitmap mSplashImage;
    private SplashImageTransferTask mSplashImageTransferTask;
    private final Matrix mTransformationMatrix;

    public PwaWrapperSplashScreenStrategy(Activity activity, int i, int i2, ImageView.ScaleType scaleType, Matrix matrix, int i3, String str) {
        this.mDrawableId = i;
        this.mBackgroundColor = i2;
        this.mScaleType = scaleType;
        this.mTransformationMatrix = matrix;
        this.mActivity = activity;
        this.mFileProviderAuthority = str;
        this.mFadeOutDurationMillis = i3;
    }

    @Override // com.google.androidbrowserhelper.trusted.splashscreens.SplashScreenStrategy
    public void onTwaLaunchInitiated(String str, TrustedWebActivityIntentBuilder trustedWebActivityIntentBuilder) {
        this.mProviderPackage = str;
        boolean zAreSplashScreensSupported = TrustedWebUtils.areSplashScreensSupported(this.mActivity, str, SplashScreenVersion.V1);
        this.mProviderSupportsSplashScreens = zAreSplashScreensSupported;
        if (!zAreSplashScreensSupported) {
            Log.w(TAG, "Provider " + str + " doesn't support splash screens");
            return;
        }
        showSplashScreen();
        if (this.mSplashImage != null) {
            customizeStatusAndNavBarDuringSplashScreen(str, trustedWebActivityIntentBuilder);
        }
    }

    private void showSplashScreen() {
        Bitmap bitmapConvertDrawableToBitmap = Utils.convertDrawableToBitmap(this.mActivity, this.mDrawableId);
        this.mSplashImage = bitmapConvertDrawableToBitmap;
        if (bitmapConvertDrawableToBitmap == null) {
            Log.w(TAG, "Failed to retrieve splash image from provided drawable id");
            return;
        }
        ImageView imageView = new ImageView(this.mActivity);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        imageView.setImageBitmap(this.mSplashImage);
        imageView.setBackgroundColor(this.mBackgroundColor);
        imageView.setScaleType(this.mScaleType);
        if (this.mScaleType == ImageView.ScaleType.MATRIX) {
            imageView.setImageMatrix(this.mTransformationMatrix);
        }
        this.mActivity.setContentView(imageView);
    }

    private void customizeStatusAndNavBarDuringSplashScreen(String str, TrustedWebActivityIntentBuilder trustedWebActivityIntentBuilder) {
        Integer expectedNavbarColor = sSystemBarColorPredictor.getExpectedNavbarColor(this.mActivity, str, trustedWebActivityIntentBuilder);
        if (expectedNavbarColor != null) {
            Utils.setNavigationBarColor(this.mActivity, expectedNavbarColor.intValue());
        }
        Integer expectedStatusBarColor = sSystemBarColorPredictor.getExpectedStatusBarColor(this.mActivity, str, trustedWebActivityIntentBuilder);
        if (expectedStatusBarColor != null) {
            Utils.setStatusBarColor(this.mActivity, expectedStatusBarColor.intValue());
        }
    }

    @Override // com.google.androidbrowserhelper.trusted.splashscreens.SplashScreenStrategy
    public void configureTwaBuilder(final TrustedWebActivityIntentBuilder trustedWebActivityIntentBuilder, CustomTabsSession customTabsSession, final Runnable runnable) {
        if (!this.mProviderSupportsSplashScreens || this.mSplashImage == null) {
            runnable.run();
            return;
        }
        if (TextUtils.isEmpty(this.mFileProviderAuthority)) {
            Log.w(TAG, "FileProvider authority not specified, can't transfer splash image.");
            runnable.run();
        } else {
            SplashImageTransferTask splashImageTransferTask = new SplashImageTransferTask(this.mActivity, this.mSplashImage, this.mFileProviderAuthority, customTabsSession, this.mProviderPackage);
            this.mSplashImageTransferTask = splashImageTransferTask;
            splashImageTransferTask.execute(new SplashImageTransferTask.Callback() { // from class: com.google.androidbrowserhelper.trusted.splashscreens.PwaWrapperSplashScreenStrategy$$ExternalSyntheticLambda1
                @Override // com.google.androidbrowserhelper.trusted.splashscreens.SplashImageTransferTask.Callback
                public final void onFinished(boolean z) {
                    this.f$0.m13729xc529da72(trustedWebActivityIntentBuilder, runnable, z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onSplashImageTransferred, reason: merged with bridge method [inline-methods] */
    public void m13729xc529da72(TrustedWebActivityIntentBuilder trustedWebActivityIntentBuilder, boolean z, final Runnable runnable) {
        if (!z) {
            Log.w(TAG, "Failed to transfer splash image.");
            runnable.run();
        } else {
            trustedWebActivityIntentBuilder.setSplashScreenParams(makeSplashScreenParamsBundle());
            runWhenEnterAnimationComplete(new Runnable() { // from class: com.google.androidbrowserhelper.trusted.splashscreens.PwaWrapperSplashScreenStrategy$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m13730x81baa2c9(runnable);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$onSplashImageTransferred$1$com-google-androidbrowserhelper-trusted-splashscreens-PwaWrapperSplashScreenStrategy, reason: not valid java name */
    /* synthetic */ void m13730x81baa2c9(Runnable runnable) {
        runnable.run();
        this.mActivity.overridePendingTransition(0, 0);
    }

    private void runWhenEnterAnimationComplete(Runnable runnable) {
        if (this.mEnterAnimationComplete) {
            runnable.run();
        } else {
            this.mOnEnterAnimationCompleteRunnable = runnable;
        }
    }

    private Bundle makeSplashScreenParamsBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(SplashScreenParamKey.KEY_VERSION, SplashScreenVersion.V1);
        bundle.putInt(SplashScreenParamKey.KEY_FADE_OUT_DURATION_MS, this.mFadeOutDurationMillis);
        bundle.putInt(SplashScreenParamKey.KEY_BACKGROUND_COLOR, this.mBackgroundColor);
        bundle.putInt(SplashScreenParamKey.KEY_SCALE_TYPE, this.mScaleType.ordinal());
        Matrix matrix = this.mTransformationMatrix;
        if (matrix != null) {
            float[] fArr = new float[9];
            matrix.getValues(fArr);
            bundle.putFloatArray(SplashScreenParamKey.KEY_IMAGE_TRANSFORMATION_MATRIX, fArr);
        }
        return bundle;
    }

    public void onActivityEnterAnimationComplete() {
        this.mEnterAnimationComplete = true;
        Runnable runnable = this.mOnEnterAnimationCompleteRunnable;
        if (runnable != null) {
            runnable.run();
            this.mOnEnterAnimationCompleteRunnable = null;
        }
    }

    public void destroy() {
        SplashImageTransferTask splashImageTransferTask = this.mSplashImageTransferTask;
        if (splashImageTransferTask != null) {
            splashImageTransferTask.cancel();
        }
    }
}
