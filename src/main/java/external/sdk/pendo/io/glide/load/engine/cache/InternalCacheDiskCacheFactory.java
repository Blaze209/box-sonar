package external.sdk.pendo.io.glide.load.engine.cache;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
public final class InternalCacheDiskCacheFactory extends DiskLruCacheFactory {

    class a implements DiskLruCacheFactory.c {
        final /* synthetic */ Context a;
        final /* synthetic */ String b;

        a(Context context, String str) {
            this.a = context;
            this.b = str;
        }

        @Override // external.sdk.pendo.io.glide.load.engine.cache.DiskLruCacheFactory.c
        public File a() {
            File cacheDir = this.a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            return this.b != null ? new File(cacheDir, this.b) : cacheDir;
        }
    }

    public InternalCacheDiskCacheFactory(Context context) {
        this(context, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR, 262144000L);
    }

    public InternalCacheDiskCacheFactory(Context context, long j) {
        this(context, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR, j);
    }

    public InternalCacheDiskCacheFactory(Context context, String str, long j) {
        super(new a(context, str), j);
    }
}
