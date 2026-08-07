package external.sdk.pendo.io.glide.load.engine.cache;

import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
public class DiskLruCacheFactory implements external.sdk.pendo.io.glide.load.engine.cache.a.InterfaceC0311a {
    private final c cacheDirectoryGetter;
    private final long diskCacheSize;

    class a implements c {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // external.sdk.pendo.io.glide.load.engine.cache.DiskLruCacheFactory.c
        public File a() {
            return new File(this.a);
        }
    }

    class b implements c {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        b(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // external.sdk.pendo.io.glide.load.engine.cache.DiskLruCacheFactory.c
        public File a() {
            return new File(this.a, this.b);
        }
    }

    public interface c {
        File a();
    }

    public DiskLruCacheFactory(c cVar, long j) {
        this.diskCacheSize = j;
        this.cacheDirectoryGetter = cVar;
    }

    @Override // external.sdk.pendo.io.glide.load.engine.cache.a.InterfaceC0311a
    public external.sdk.pendo.io.glide.load.engine.cache.a build() {
        File fileA = this.cacheDirectoryGetter.a();
        if (fileA == null) {
            return null;
        }
        if (fileA.isDirectory() || fileA.mkdirs()) {
            return DiskLruCacheWrapper.create(fileA, this.diskCacheSize);
        }
        return null;
    }

    public DiskLruCacheFactory(String str, long j) {
        this(new a(str), j);
    }

    public DiskLruCacheFactory(String str, String str2, long j) {
        this(new b(str, str2), j);
    }
}
