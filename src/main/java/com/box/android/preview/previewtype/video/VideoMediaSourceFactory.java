package com.box.android.preview.previewtype.video;

import android.net.Uri;
import androidx.media3.common.MediaItem;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DefaultDataSource;
import androidx.media3.exoplayer.dash.DashMediaSource;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.ProgressiveMediaSource;
import com.box.android.coreservices.models.CustomBoxSession;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.preview.integration.media3.Media3DataSourceFactory;
import com.box.android.preview.integration.media3.WatermarkResolvingDataSourceFactory;
import com.box.androidsdk.content.utils.BoxLogUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VideoMediaSourceFactory.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/previewtype/video/VideoMediaSourceFactory;", "", "session", "Lcom/box/android/coreservices/models/CustomBoxSession;", "media3DataSourceFactory", "Lcom/box/android/preview/integration/media3/Media3DataSourceFactory;", "watermarkDataSourceFactory", "Lcom/box/android/preview/integration/media3/WatermarkResolvingDataSourceFactory;", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "<init>", "(Lcom/box/android/coreservices/models/CustomBoxSession;Lcom/box/android/preview/integration/media3/Media3DataSourceFactory;Lcom/box/android/preview/integration/media3/WatermarkResolvingDataSourceFactory;Lcom/box/android/domain/configuration/FeatureFlips;)V", "createMediaSourceFactory", "Landroidx/media3/exoplayer/source/MediaSource$Factory;", "mediaItem", "Landroidx/media3/common/MediaItem;", "isWatermarked", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class VideoMediaSourceFactory {
    public static final int $stable = 8;
    private final FeatureFlips featureFlips;
    private final Media3DataSourceFactory media3DataSourceFactory;
    private final CustomBoxSession session;
    private final WatermarkResolvingDataSourceFactory watermarkDataSourceFactory;

    public VideoMediaSourceFactory(CustomBoxSession session, Media3DataSourceFactory media3DataSourceFactory, WatermarkResolvingDataSourceFactory watermarkDataSourceFactory, FeatureFlips featureFlips) {
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(media3DataSourceFactory, "media3DataSourceFactory");
        Intrinsics.checkNotNullParameter(watermarkDataSourceFactory, "watermarkDataSourceFactory");
        Intrinsics.checkNotNullParameter(featureFlips, "featureFlips");
        this.session = session;
        this.media3DataSourceFactory = media3DataSourceFactory;
        this.watermarkDataSourceFactory = watermarkDataSourceFactory;
        this.featureFlips = featureFlips;
    }

    public final MediaSource.Factory createMediaSourceFactory(MediaItem mediaItem, boolean isWatermarked) {
        Intrinsics.checkNotNullParameter(mediaItem, "mediaItem");
        DefaultDataSource.Factory factoryCreateFactory = this.media3DataSourceFactory.createFactory(this.session);
        DataSource.Factory factoryCreateFactory2 = this.watermarkDataSourceFactory.createFactory(factoryCreateFactory, isWatermarked);
        MediaItem.LocalConfiguration localConfiguration = mediaItem.localConfiguration;
        Uri uri = localConfiguration != null ? localConfiguration.uri : null;
        if (Intrinsics.areEqual(uri != null ? uri.getScheme() : null, "file")) {
            return new ProgressiveMediaSource.Factory(factoryCreateFactory);
        }
        if (this.featureFlips.getVideoWatermarkingModernization().getEnabled()) {
            BoxLogUtils.v("Using DashMediaSource with WatermarkResolvingDataSourceFactory");
            factoryCreateFactory = factoryCreateFactory2;
        } else {
            BoxLogUtils.v("Using DashMediaSource with Media3DataSourceFactory");
        }
        return new DashMediaSource.Factory(factoryCreateFactory);
    }
}
