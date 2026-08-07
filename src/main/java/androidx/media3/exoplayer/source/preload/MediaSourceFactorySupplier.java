package androidx.media3.exoplayer.source.preload;

import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.cache.Cache;
import androidx.media3.exoplayer.source.MediaSource;
import com.google.common.base.Supplier;

/* JADX INFO: loaded from: classes8.dex */
public interface MediaSourceFactorySupplier extends Supplier<MediaSource.Factory> {
    MediaSourceFactorySupplier setCache(Cache cache);

    MediaSourceFactorySupplier setDataSourceFactory(DataSource.Factory factory);
}
