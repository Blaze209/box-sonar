package com.box.android.base.presentation.shake;

import com.box.android.base.utilities.ScreenshotCapture;
import com.box.android.coreservices.services.IntentServices;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class BetaFeedbackManager_Factory implements Factory<BetaFeedbackManager> {
    private final Provider<IntentServices> intentServicesProvider;
    private final Provider<ScreenshotCapture> screenshotCaptureProvider;

    private BetaFeedbackManager_Factory(Provider<IntentServices> provider, Provider<ScreenshotCapture> provider2) {
        this.intentServicesProvider = provider;
        this.screenshotCaptureProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BetaFeedbackManager get() {
        return newInstance(this.intentServicesProvider.get(), this.screenshotCaptureProvider.get());
    }

    public static BetaFeedbackManager_Factory create(Provider<IntentServices> provider, Provider<ScreenshotCapture> provider2) {
        return new BetaFeedbackManager_Factory(provider, provider2);
    }

    public static BetaFeedbackManager newInstance(IntentServices intentServices, ScreenshotCapture screenshotCapture) {
        return new BetaFeedbackManager(intentServices, screenshotCapture);
    }
}
