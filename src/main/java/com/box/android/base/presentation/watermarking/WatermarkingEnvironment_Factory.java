package com.box.android.base.presentation.watermarking;

import com.box.android.domain.metrics.Gen204WatermarkingEventLogger;
import com.box.android.domain.services.IRemoteItemService;
import com.box.android.domain.services.IWatermarkService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class WatermarkingEnvironment_Factory implements Factory<WatermarkingEnvironment> {
    private final Provider<IRemoteItemService> remoteItemServiceProvider;
    private final Provider<IWatermarkService> watermarkServiceProvider;
    private final Provider<Gen204WatermarkingEventLogger> watermarkingEventLoggerProvider;

    private WatermarkingEnvironment_Factory(Provider<IWatermarkService> provider, Provider<IRemoteItemService> provider2, Provider<Gen204WatermarkingEventLogger> provider3) {
        this.watermarkServiceProvider = provider;
        this.remoteItemServiceProvider = provider2;
        this.watermarkingEventLoggerProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public WatermarkingEnvironment get() {
        return newInstance(this.watermarkServiceProvider.get(), this.remoteItemServiceProvider.get(), this.watermarkingEventLoggerProvider.get());
    }

    public static WatermarkingEnvironment_Factory create(Provider<IWatermarkService> provider, Provider<IRemoteItemService> provider2, Provider<Gen204WatermarkingEventLogger> provider3) {
        return new WatermarkingEnvironment_Factory(provider, provider2, provider3);
    }

    public static WatermarkingEnvironment newInstance(IWatermarkService iWatermarkService, IRemoteItemService iRemoteItemService, Gen204WatermarkingEventLogger gen204WatermarkingEventLogger) {
        return new WatermarkingEnvironment(iWatermarkService, iRemoteItemService, gen204WatermarkingEventLogger);
    }
}
