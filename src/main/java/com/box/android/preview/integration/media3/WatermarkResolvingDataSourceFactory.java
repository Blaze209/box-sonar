package com.box.android.preview.integration.media3;

import android.net.Uri;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.ResolvingDataSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WatermarkResolvingDataSourceFactory.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/box/android/preview/integration/media3/WatermarkResolvingDataSourceFactory;", "", "<init>", "()V", "timeProvider", "Lkotlin/Function0;", "", "createFactory", "Landroidx/media3/datasource/DataSource$Factory;", "upstreamFactory", "isWatermarked", "", "resolveUri", "Landroid/net/Uri;", "uri", "Companion", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class WatermarkResolvingDataSourceFactory {
    public static final int $stable = 0;
    public static final String WATERMARK_CONTENT_PARAM = "watermark_content";
    private final Function0<Long> timeProvider = new Function0() { // from class: com.box.android.preview.integration.media3.WatermarkResolvingDataSourceFactory$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Long.valueOf(System.currentTimeMillis());
        }
    };

    @Inject
    public WatermarkResolvingDataSourceFactory() {
    }

    public final DataSource.Factory createFactory(DataSource.Factory upstreamFactory, final boolean isWatermarked) {
        Intrinsics.checkNotNullParameter(upstreamFactory, "upstreamFactory");
        return new ResolvingDataSource.Factory(upstreamFactory, new ResolvingDataSource.Resolver() { // from class: com.box.android.preview.integration.media3.WatermarkResolvingDataSourceFactory$$ExternalSyntheticLambda1
            @Override // androidx.media3.datasource.ResolvingDataSource.Resolver
            public final DataSpec resolveDataSpec(DataSpec dataSpec) {
                return WatermarkResolvingDataSourceFactory.createFactory$lambda$0(this.f$0, isWatermarked, dataSpec);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DataSpec createFactory$lambda$0(WatermarkResolvingDataSourceFactory watermarkResolvingDataSourceFactory, boolean z, DataSpec dataSpec) {
        Intrinsics.checkNotNullParameter(dataSpec, "dataSpec");
        Uri uri = dataSpec.uri;
        Intrinsics.checkNotNullExpressionValue(uri, "uri");
        return dataSpec.withUri(watermarkResolvingDataSourceFactory.resolveUri(uri, z));
    }

    private final Uri resolveUri(Uri uri, boolean isWatermarked) {
        if (!isWatermarked || Intrinsics.areEqual(uri.getScheme(), "file") || uri.getQueryParameterNames().contains(WATERMARK_CONTENT_PARAM)) {
            return uri;
        }
        Uri uriBuild = uri.buildUpon().appendQueryParameter(WATERMARK_CONTENT_PARAM, String.valueOf(this.timeProvider.invoke().longValue())).build();
        Intrinsics.checkNotNullExpressionValue(uriBuild, "build(...)");
        return uriBuild;
    }
}
