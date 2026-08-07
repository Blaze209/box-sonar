package com.box.android.capture;

import com.box.android.base.presentation.ThumbnailManager;
import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class CaptureHistoryButtonView_MembersInjector implements MembersInjector<CaptureHistoryButtonView> {
    private final Provider<ThumbnailManager> thumbnailManagerProvider;

    private CaptureHistoryButtonView_MembersInjector(Provider<ThumbnailManager> provider) {
        this.thumbnailManagerProvider = provider;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(CaptureHistoryButtonView captureHistoryButtonView) {
        injectThumbnailManager(captureHistoryButtonView, this.thumbnailManagerProvider.get());
    }

    public static MembersInjector<CaptureHistoryButtonView> create(Provider<ThumbnailManager> provider) {
        return new CaptureHistoryButtonView_MembersInjector(provider);
    }

    public static void injectThumbnailManager(CaptureHistoryButtonView captureHistoryButtonView, ThumbnailManager thumbnailManager) {
        captureHistoryButtonView.thumbnailManager = thumbnailManager;
    }
}
