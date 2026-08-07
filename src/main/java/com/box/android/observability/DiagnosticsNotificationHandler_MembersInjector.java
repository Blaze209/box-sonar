package com.box.android.observability;

import com.box.android.domain.usecases.observability.CreateLogArchiveInteractor;
import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class DiagnosticsNotificationHandler_MembersInjector implements MembersInjector<DiagnosticsNotificationHandler> {
    private final Provider<CreateLogArchiveInteractor> createLogArchiveInteractorProvider;
    private final Provider<ObservabilitySettingsManager> observabilitySettingsManagerProvider;

    private DiagnosticsNotificationHandler_MembersInjector(Provider<ObservabilitySettingsManager> provider, Provider<CreateLogArchiveInteractor> provider2) {
        this.observabilitySettingsManagerProvider = provider;
        this.createLogArchiveInteractorProvider = provider2;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(DiagnosticsNotificationHandler diagnosticsNotificationHandler) {
        injectObservabilitySettingsManager(diagnosticsNotificationHandler, this.observabilitySettingsManagerProvider.get());
        injectCreateLogArchiveInteractor(diagnosticsNotificationHandler, this.createLogArchiveInteractorProvider.get());
    }

    public static MembersInjector<DiagnosticsNotificationHandler> create(Provider<ObservabilitySettingsManager> provider, Provider<CreateLogArchiveInteractor> provider2) {
        return new DiagnosticsNotificationHandler_MembersInjector(provider, provider2);
    }

    public static void injectObservabilitySettingsManager(DiagnosticsNotificationHandler diagnosticsNotificationHandler, ObservabilitySettingsManager observabilitySettingsManager) {
        diagnosticsNotificationHandler.observabilitySettingsManager = observabilitySettingsManager;
    }

    public static void injectCreateLogArchiveInteractor(DiagnosticsNotificationHandler diagnosticsNotificationHandler, CreateLogArchiveInteractor createLogArchiveInteractor) {
        diagnosticsNotificationHandler.createLogArchiveInteractor = createLogArchiveInteractor;
    }
}
