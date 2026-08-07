package com.box.android.preview.previewtype.boxnote;

import com.box.android.domain.preview.IFileCanBePreviewedChecker;
import com.box.android.domain.services.IRemoteItemService;
import com.box.android.domain.services.ISessionManager;
import com.box.android.preview.preview.PreviewAnalytics;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class BoxNotesEnvironment_Factory implements Factory<BoxNotesEnvironment> {
    private final Provider<BoxNoteEditModeEnvironment> editModeEnvironmentProvider;
    private final Provider<IFileCanBePreviewedChecker> fileCanBePreviewedCheckerProvider;
    private final Provider<IRemoteItemService> itemServiceProvider;
    private final Provider<PreviewAnalytics> previewAnalyticsProvider;
    private final Provider<ISessionManager> sessionManagerProvider;
    private final Provider<BoxNotesUrlBuilder> urlBuilderProvider;

    private BoxNotesEnvironment_Factory(Provider<ISessionManager> provider, Provider<BoxNotesUrlBuilder> provider2, Provider<BoxNoteEditModeEnvironment> provider3, Provider<IRemoteItemService> provider4, Provider<IFileCanBePreviewedChecker> provider5, Provider<PreviewAnalytics> provider6) {
        this.sessionManagerProvider = provider;
        this.urlBuilderProvider = provider2;
        this.editModeEnvironmentProvider = provider3;
        this.itemServiceProvider = provider4;
        this.fileCanBePreviewedCheckerProvider = provider5;
        this.previewAnalyticsProvider = provider6;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxNotesEnvironment get() {
        return newInstance(this.sessionManagerProvider.get(), this.urlBuilderProvider.get(), this.editModeEnvironmentProvider.get(), this.itemServiceProvider.get(), this.fileCanBePreviewedCheckerProvider.get(), this.previewAnalyticsProvider.get());
    }

    public static BoxNotesEnvironment_Factory create(Provider<ISessionManager> provider, Provider<BoxNotesUrlBuilder> provider2, Provider<BoxNoteEditModeEnvironment> provider3, Provider<IRemoteItemService> provider4, Provider<IFileCanBePreviewedChecker> provider5, Provider<PreviewAnalytics> provider6) {
        return new BoxNotesEnvironment_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static BoxNotesEnvironment newInstance(ISessionManager iSessionManager, BoxNotesUrlBuilder boxNotesUrlBuilder, BoxNoteEditModeEnvironment boxNoteEditModeEnvironment, IRemoteItemService iRemoteItemService, IFileCanBePreviewedChecker iFileCanBePreviewedChecker, PreviewAnalytics previewAnalytics) {
        return new BoxNotesEnvironment(iSessionManager, boxNotesUrlBuilder, boxNoteEditModeEnvironment, iRemoteItemService, iFileCanBePreviewedChecker, previewAnalytics);
    }
}
