package com.box.android.domain.usecases.boxai;

import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.configuration.IBoxAccountSettings;
import com.box.android.domain.services.IBoxAiService;
import com.box.android.domain.services.IdMappingService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class GetBoxAiAvailabilityInteractor_Factory implements Factory<GetBoxAiAvailabilityInteractor> {
    private final Provider<IBoxAccountSettings> boxAccountSettingsProvider;
    private final Provider<IBoxAiService> boxAiServiceProvider;
    private final Provider<FeatureFlips> featureFlipsProvider;
    private final Provider<IdMappingService> idMappingServiceProvider;

    private GetBoxAiAvailabilityInteractor_Factory(Provider<IBoxAiService> provider, Provider<IdMappingService> provider2, Provider<IBoxAccountSettings> provider3, Provider<FeatureFlips> provider4) {
        this.boxAiServiceProvider = provider;
        this.idMappingServiceProvider = provider2;
        this.boxAccountSettingsProvider = provider3;
        this.featureFlipsProvider = provider4;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GetBoxAiAvailabilityInteractor get() {
        return newInstance(this.boxAiServiceProvider.get(), this.idMappingServiceProvider.get(), this.boxAccountSettingsProvider.get(), this.featureFlipsProvider.get());
    }

    public static GetBoxAiAvailabilityInteractor_Factory create(Provider<IBoxAiService> provider, Provider<IdMappingService> provider2, Provider<IBoxAccountSettings> provider3, Provider<FeatureFlips> provider4) {
        return new GetBoxAiAvailabilityInteractor_Factory(provider, provider2, provider3, provider4);
    }

    public static GetBoxAiAvailabilityInteractor newInstance(IBoxAiService iBoxAiService, IdMappingService idMappingService, IBoxAccountSettings iBoxAccountSettings, FeatureFlips featureFlips) {
        return new GetBoxAiAvailabilityInteractor(iBoxAiService, idMappingService, iBoxAccountSettings, featureFlips);
    }
}
