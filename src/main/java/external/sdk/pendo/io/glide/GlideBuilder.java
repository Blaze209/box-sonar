package external.sdk.pendo.io.glide;

import android.content.Context;
import androidx.collection.ArrayMap;
import external.sdk.pendo.io.glide.load.engine.Engine;
import external.sdk.pendo.io.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import external.sdk.pendo.io.glide.load.engine.bitmap_recycle.LruArrayPool;
import external.sdk.pendo.io.glide.load.engine.bitmap_recycle.LruBitmapPool;
import external.sdk.pendo.io.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import external.sdk.pendo.io.glide.load.engine.cache.LruResourceCache;
import external.sdk.pendo.io.glide.manager.DefaultConnectivityMonitorFactory;
import external.sdk.pendo.io.glide.manager.j;
import external.sdk.pendo.io.glide.module.AppGlideModule;
import external.sdk.pendo.io.glide.module.GlideModule;
import external.sdk.pendo.io.glide.request.RequestOptions;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class GlideBuilder {
    private Engine c;
    private sdk.pendo.io.i.b d;
    private sdk.pendo.io.i.a e;
    private external.sdk.pendo.io.glide.load.engine.cache.c f;
    private sdk.pendo.io.k.a g;
    private sdk.pendo.io.k.a h;
    private external.sdk.pendo.io.glide.load.engine.cache.a.InterfaceC0311a i;
    private sdk.pendo.io.j.a j;
    private external.sdk.pendo.io.glide.manager.b k;
    private j.b n;
    private sdk.pendo.io.k.a o;
    private boolean p;
    private List<sdk.pendo.io.u.b<Object>> q;
    private final Map<Class<?>, e<?, ?>> a = new ArrayMap();
    private final c.a b = new c.a();
    private int l = 4;
    private external.sdk.pendo.io.glide.a.InterfaceC0304a m = new a();

    public static final class LogRequestOrigins {
    }

    public static final class OverrideGlideThreadPriority {
    }

    public static final class UseMediaStoreOpenFileApisIfPossible {
    }

    class a implements external.sdk.pendo.io.glide.a.InterfaceC0304a {
        a() {
        }

        @Override // external.sdk.pendo.io.glide.a.InterfaceC0304a
        public RequestOptions build() {
            return new RequestOptions();
        }
    }

    static final class b {
        b() {
        }
    }

    external.sdk.pendo.io.glide.a a(Context context, List<GlideModule> list, AppGlideModule appGlideModule) {
        if (this.g == null) {
            this.g = sdk.pendo.io.k.a.h();
        }
        if (this.h == null) {
            this.h = sdk.pendo.io.k.a.f();
        }
        if (this.o == null) {
            this.o = sdk.pendo.io.k.a.d();
        }
        if (this.j == null) {
            this.j = new sdk.pendo.io.j.a.C0399a(context).a();
        }
        if (this.k == null) {
            this.k = new DefaultConnectivityMonitorFactory();
        }
        if (this.d == null) {
            int iB = this.j.b();
            if (iB > 0) {
                this.d = new LruBitmapPool(iB);
            } else {
                this.d = new BitmapPoolAdapter();
            }
        }
        if (this.e == null) {
            this.e = new LruArrayPool(this.j.a());
        }
        if (this.f == null) {
            this.f = new LruResourceCache(this.j.c());
        }
        if (this.i == null) {
            this.i = new InternalCacheDiskCacheFactory(context);
        }
        if (this.c == null) {
            this.c = new Engine(this.f, this.i, this.h, this.g, sdk.pendo.io.k.a.i(), this.o, this.p);
        }
        List<sdk.pendo.io.u.b<Object>> list2 = this.q;
        this.q = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        return new external.sdk.pendo.io.glide.a(context, this.c, this.f, this.d, this.e, new j(this.n), this.k, this.l, this.m, this.a, this.q, list, appGlideModule, this.b.a());
    }

    void a(j.b bVar) {
        this.n = bVar;
    }
}
