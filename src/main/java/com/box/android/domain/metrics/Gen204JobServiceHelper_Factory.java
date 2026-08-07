package com.box.android.domain.metrics;

import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class Gen204JobServiceHelper_Factory implements Factory<Gen204JobServiceHelper> {
    private final Provider<Gen204DownloadEventLogger> gen204DownloadEventLoggerProvider;
    private final Provider<Gen204MoveCopyEventLogger> gen204MoveCopyEventLoggerProvider;
    private final Provider<Gen204OfflineEventLogger> gen204OfflineEventLoggerProvider;
    private final Provider<Gen204UploadEventLogger> gen204UploadEventLoggerProvider;

    private Gen204JobServiceHelper_Factory(Provider<Gen204UploadEventLogger> provider, Provider<Gen204DownloadEventLogger> provider2, Provider<Gen204MoveCopyEventLogger> provider3, Provider<Gen204OfflineEventLogger> provider4) {
        this.gen204UploadEventLoggerProvider = provider;
        this.gen204DownloadEventLoggerProvider = provider2;
        this.gen204MoveCopyEventLoggerProvider = provider3;
        this.gen204OfflineEventLoggerProvider = provider4;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Gen204JobServiceHelper get() {
        return newInstance(this.gen204UploadEventLoggerProvider.get(), this.gen204DownloadEventLoggerProvider.get(), this.gen204MoveCopyEventLoggerProvider.get(), this.gen204OfflineEventLoggerProvider.get());
    }

    public static Gen204JobServiceHelper_Factory create(Provider<Gen204UploadEventLogger> provider, Provider<Gen204DownloadEventLogger> provider2, Provider<Gen204MoveCopyEventLogger> provider3, Provider<Gen204OfflineEventLogger> provider4) {
        return new Gen204JobServiceHelper_Factory(provider, provider2, provider3, provider4);
    }

    public static Gen204JobServiceHelper newInstance(Gen204UploadEventLogger gen204UploadEventLogger, Gen204DownloadEventLogger gen204DownloadEventLogger, Gen204MoveCopyEventLogger gen204MoveCopyEventLogger, Gen204OfflineEventLogger gen204OfflineEventLogger) {
        return new Gen204JobServiceHelper(gen204UploadEventLogger, gen204DownloadEventLogger, gen204MoveCopyEventLogger, gen204OfflineEventLogger);
    }
}
