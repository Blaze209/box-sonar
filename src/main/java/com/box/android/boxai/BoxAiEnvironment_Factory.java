package com.box.android.boxai;

import com.box.android.base.cpl.IClipboardService;
import com.box.android.base.presentation.utilities.IPermissionsHandler;
import com.box.android.boxai.voice.VoiceInputEnvironment;
import com.box.android.coreservices.models.BoxAccountSettings;
import com.box.android.coreservices.utilities.FileActionsManager;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.metrics.boxai.BoxAiObservability;
import com.box.android.domain.services.IBoxAiService;
import com.box.android.domain.usecases.boxai.GetBoxAiAvailabilityUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class BoxAiEnvironment_Factory implements Factory<BoxAiEnvironment> {
    private final Provider<BoxAccountSettings> boxAccountSettingsProvider;
    private final Provider<BoxAiAnalytics> boxAiAnalyticsProvider;
    private final Provider<BoxAiObservability> boxAiObservabilityProvider;
    private final Provider<IBoxAiService> boxAiServiceProvider;
    private final Provider<IClipboardService> clipboardServiceProvider;
    private final Provider<FeatureFlips> featureFlipsProvider;
    private final Provider<FileActionsManager> fileActionsManagerProvider;
    private final Provider<GetBoxAiAvailabilityUseCase> getBoxAiAvailabilityUseCaseProvider;
    private final Provider<IPermissionsHandler> permissionsHandlerProvider;
    private final Provider<VoiceInputEnvironment> voiceInputEnvironmentProvider;

    private BoxAiEnvironment_Factory(Provider<IBoxAiService> provider, Provider<IClipboardService> provider2, Provider<BoxAiAnalytics> provider3, Provider<BoxAiObservability> provider4, Provider<FeatureFlips> provider5, Provider<BoxAccountSettings> provider6, Provider<VoiceInputEnvironment> provider7, Provider<IPermissionsHandler> provider8, Provider<FileActionsManager> provider9, Provider<GetBoxAiAvailabilityUseCase> provider10) {
        this.boxAiServiceProvider = provider;
        this.clipboardServiceProvider = provider2;
        this.boxAiAnalyticsProvider = provider3;
        this.boxAiObservabilityProvider = provider4;
        this.featureFlipsProvider = provider5;
        this.boxAccountSettingsProvider = provider6;
        this.voiceInputEnvironmentProvider = provider7;
        this.permissionsHandlerProvider = provider8;
        this.fileActionsManagerProvider = provider9;
        this.getBoxAiAvailabilityUseCaseProvider = provider10;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxAiEnvironment get() {
        return newInstance(this.boxAiServiceProvider.get(), this.clipboardServiceProvider.get(), this.boxAiAnalyticsProvider.get(), this.boxAiObservabilityProvider.get(), this.featureFlipsProvider.get(), this.boxAccountSettingsProvider.get(), this.voiceInputEnvironmentProvider.get(), this.permissionsHandlerProvider.get(), this.fileActionsManagerProvider.get(), this.getBoxAiAvailabilityUseCaseProvider.get());
    }

    public static BoxAiEnvironment_Factory create(Provider<IBoxAiService> provider, Provider<IClipboardService> provider2, Provider<BoxAiAnalytics> provider3, Provider<BoxAiObservability> provider4, Provider<FeatureFlips> provider5, Provider<BoxAccountSettings> provider6, Provider<VoiceInputEnvironment> provider7, Provider<IPermissionsHandler> provider8, Provider<FileActionsManager> provider9, Provider<GetBoxAiAvailabilityUseCase> provider10) {
        return new BoxAiEnvironment_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    public static BoxAiEnvironment newInstance(IBoxAiService iBoxAiService, IClipboardService iClipboardService, BoxAiAnalytics boxAiAnalytics, BoxAiObservability boxAiObservability, FeatureFlips featureFlips, BoxAccountSettings boxAccountSettings, VoiceInputEnvironment voiceInputEnvironment, IPermissionsHandler iPermissionsHandler, FileActionsManager fileActionsManager, GetBoxAiAvailabilityUseCase getBoxAiAvailabilityUseCase) {
        return new BoxAiEnvironment(iBoxAiService, iClipboardService, boxAiAnalytics, boxAiObservability, featureFlips, boxAccountSettings, voiceInputEnvironment, iPermissionsHandler, fileActionsManager, getBoxAiAvailabilityUseCase);
    }
}
