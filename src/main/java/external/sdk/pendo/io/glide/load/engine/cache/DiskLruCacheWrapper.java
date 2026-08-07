package external.sdk.pendo.io.glide.load.engine.cache;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import sdk.pendo.io.e.f;

/* JADX INFO: loaded from: classes4.dex */
public class DiskLruCacheWrapper implements a {
    private static final int APP_VERSION = 1;
    private static final String TAG = "DiskLruCacheWrapper";
    private static final int VALUE_COUNT = 1;
    private static DiskLruCacheWrapper wrapper;
    private final File directory;
    private sdk.pendo.io.d.a diskLruCache;
    private final long maxSize;
    private final b writeLocker = new b();
    private final sdk.pendo.io.j.b safeKeyGenerator = new sdk.pendo.io.j.b();

    @Deprecated
    protected DiskLruCacheWrapper(File file, long j) {
        this.directory = file;
        this.maxSize = j;
    }

    public static a create(File file, long j) {
        return new DiskLruCacheWrapper(file, j);
    }

    @Deprecated
    public static synchronized a get(File file, long j) {
        if (wrapper == null) {
            wrapper = new DiskLruCacheWrapper(file, j);
        }
        return wrapper;
    }

    private synchronized sdk.pendo.io.d.a getDiskCache() {
        if (this.diskLruCache == null) {
            this.diskLruCache = sdk.pendo.io.d.a.a(this.directory, 1, 1, this.maxSize);
        }
        return this.diskLruCache;
    }

    private synchronized void resetDiskCache() {
        this.diskLruCache = null;
    }

    @Override // external.sdk.pendo.io.glide.load.engine.cache.a
    public synchronized void clear() {
        try {
            try {
                getDiskCache().b();
            } catch (IOException e) {
                if (Log.isLoggable(TAG, 5)) {
                    Log.w(TAG, "Unable to clear disk cache or disk cache cleared externally", e);
                }
            }
            resetDiskCache();
        } catch (Throwable th) {
            resetDiskCache();
            throw th;
        }
    }

    public void delete(f fVar) {
        try {
            getDiskCache().d(this.safeKeyGenerator.b(fVar));
        } catch (IOException e) {
            if (Log.isLoggable(TAG, 5)) {
                Log.w(TAG, "Unable to delete from disk cache", e);
            }
        }
    }

    @Override // external.sdk.pendo.io.glide.load.engine.cache.a
    public void put(f fVar, a.b bVar) {
        String strB = this.safeKeyGenerator.b(fVar);
        this.writeLocker.a(strB);
        try {
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "Put: Obtained: " + strB + " for for Key: " + fVar);
            }
            try {
                sdk.pendo.io.d.a diskCache = getDiskCache();
                if (diskCache.b(strB) == null) {
                    sdk.pendo.io.d.a.c cVarA = diskCache.a(strB);
                    if (cVarA == null) {
                        throw new IllegalStateException("Had two simultaneous puts for: " + strB);
                    }
                    try {
                        if (bVar.a(cVarA.a(0))) {
                            cVarA.c();
                        }
                        cVarA.b();
                    } catch (Throwable th) {
                        cVarA.b();
                        throw th;
                    }
                }
            } catch (IOException e) {
                if (Log.isLoggable(TAG, 5)) {
                    Log.w(TAG, "Unable to put to disk cache", e);
                }
            }
            this.writeLocker.b(strB);
        } catch (Throwable th2) {
            this.writeLocker.b(strB);
            throw th2;
        }
    }

    @Override // external.sdk.pendo.io.glide.load.engine.cache.a
    public File get(f fVar) {
        String strB = this.safeKeyGenerator.b(fVar);
        if (Log.isLoggable(TAG, 2)) {
            Log.v(TAG, "Get: Obtained: " + strB + " for for Key: " + fVar);
        }
        try {
            sdk.pendo.io.d.a.e eVarB = getDiskCache().b(strB);
            if (eVarB != null) {
                return eVarB.a(0);
            }
            return null;
        } catch (IOException e) {
            if (!Log.isLoggable(TAG, 5)) {
                return null;
            }
            Log.w(TAG, "Unable to get from disk cache", e);
            return null;
        }
    }
}
