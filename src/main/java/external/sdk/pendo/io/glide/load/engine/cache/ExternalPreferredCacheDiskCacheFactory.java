package external.sdk.pendo.io.glide.load.engine.cache;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
public final class ExternalPreferredCacheDiskCacheFactory extends DiskLruCacheFactory {

    class a implements DiskLruCacheFactory.c {
        final /* synthetic */ Context a;
        final /* synthetic */ String b;

        a(Context context, String str) {
            this.a = context;
            this.b = str;
        }

        private File b() {
            File cacheDir = this.a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            return this.b != null ? new File(cacheDir, this.b) : cacheDir;
        }

        @Override // external.sdk.pendo.io.glide.load.engine.cache.DiskLruCacheFactory.c
        public File a() {
            File externalCacheDir;
            File fileB = b();
            if ((fileB == null || !fileB.exists()) && (externalCacheDir = this.a.getExternalCacheDir()) != null && externalCacheDir.canWrite()) {
                return this.b != null ? new File(externalCacheDir, this.b) : externalCacheDir;
            }
            return fileB;
        }
    }

    public ExternalPreferredCacheDiskCacheFactory(Context context) {
        this(context, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR, 262144000L);
    }

    public ExternalPreferredCacheDiskCacheFactory(Context context, long j) {
        this(context, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR, j);
    }

    public ExternalPreferredCacheDiskCacheFactory(Context context, String str, long j) {
        super(new a(context, str), j);
    }
}
