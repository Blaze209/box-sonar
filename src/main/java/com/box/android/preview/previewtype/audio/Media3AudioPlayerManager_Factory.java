package com.box.android.preview.previewtype.audio;

import com.box.android.domain.identity.IUserContextManager;
import com.box.android.preview.integration.media3.Media3DataSourceFactory;
import com.box.android.preview.previewtype.audio.helper.AudioMediaItemCreator;
import com.box.android.preview.previewtype.audio.helper.CoverArtExtractor;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class Media3AudioPlayerManager_Factory implements Factory<Media3AudioPlayerManager> {
    private final Provider<CoverArtExtractor> coverArtExtractorProvider;
    private final Provider<Media3DataSourceFactory> media3DataSourceFactoryProvider;
    private final Provider<AudioMediaItemCreator> mediaItemCreatorProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private Media3AudioPlayerManager_Factory(Provider<IUserContextManager> provider, Provider<Media3DataSourceFactory> provider2, Provider<AudioMediaItemCreator> provider3, Provider<CoverArtExtractor> provider4) {
        this.userContextManagerProvider = provider;
        this.media3DataSourceFactoryProvider = provider2;
        this.mediaItemCreatorProvider = provider3;
        this.coverArtExtractorProvider = provider4;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Media3AudioPlayerManager get() {
        return newInstance(this.userContextManagerProvider.get(), this.media3DataSourceFactoryProvider.get(), this.mediaItemCreatorProvider.get(), this.coverArtExtractorProvider.get());
    }

    public static Media3AudioPlayerManager_Factory create(Provider<IUserContextManager> provider, Provider<Media3DataSourceFactory> provider2, Provider<AudioMediaItemCreator> provider3, Provider<CoverArtExtractor> provider4) {
        return new Media3AudioPlayerManager_Factory(provider, provider2, provider3, provider4);
    }

    public static Media3AudioPlayerManager newInstance(IUserContextManager iUserContextManager, Media3DataSourceFactory media3DataSourceFactory, AudioMediaItemCreator audioMediaItemCreator, CoverArtExtractor coverArtExtractor) {
        return new Media3AudioPlayerManager(iUserContextManager, media3DataSourceFactory, audioMediaItemCreator, coverArtExtractor);
    }
}
