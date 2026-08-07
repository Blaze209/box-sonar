package com.box.android.preview.di;

import android.content.Context;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.preview.integration.media3.Media3DataSourceFactory;
import com.box.android.preview.integration.media3.WatermarkResolvingDataSourceFactory;
import com.box.android.preview.previewtype.video.VideoMediaSourceFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class PreviewModule_Companion_ProvideVideoMediaSourceFactoryFactory implements Factory<VideoMediaSourceFactory> {
    private final Provider<Context> contextProvider;
    private final Provider<FeatureFlips> featureFlipsProvider;
    private final Provider<Media3DataSourceFactory> media3DataSourceFactoryProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;
    private final Provider<WatermarkResolvingDataSourceFactory> watermarkDataSourceFactoryProvider;

    private PreviewModule_Companion_ProvideVideoMediaSourceFactoryFactory(Provider<Context> provider, Provider<IUserContextManager> provider2, Provider<Media3DataSourceFactory> provider3, Provider<WatermarkResolvingDataSourceFactory> provider4, Provider<FeatureFlips> provider5) {
        this.contextProvider = provider;
        this.userContextManagerProvider = provider2;
        this.media3DataSourceFactoryProvider = provider3;
        this.watermarkDataSourceFactoryProvider = provider4;
        this.featureFlipsProvider = provider5;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public VideoMediaSourceFactory get() {
        return provideVideoMediaSourceFactory(this.contextProvider.get(), this.userContextManagerProvider.get(), this.media3DataSourceFactoryProvider.get(), this.watermarkDataSourceFactoryProvider.get(), this.featureFlipsProvider.get());
    }

    public static PreviewModule_Companion_ProvideVideoMediaSourceFactoryFactory create(Provider<Context> provider, Provider<IUserContextManager> provider2, Provider<Media3DataSourceFactory> provider3, Provider<WatermarkResolvingDataSourceFactory> provider4, Provider<FeatureFlips> provider5) {
        return new PreviewModule_Companion_ProvideVideoMediaSourceFactoryFactory(provider, provider2, provider3, provider4, provider5);
    }

    public static VideoMediaSourceFactory provideVideoMediaSourceFactory(Context context, IUserContextManager iUserContextManager, Media3DataSourceFactory media3DataSourceFactory, WatermarkResolvingDataSourceFactory watermarkResolvingDataSourceFactory, FeatureFlips featureFlips) {
        return (VideoMediaSourceFactory) Preconditions.checkNotNullFromProvides(PreviewModule.INSTANCE.provideVideoMediaSourceFactory(context, iUserContextManager, media3DataSourceFactory, watermarkResolvingDataSourceFactory, featureFlips));
    }
}
