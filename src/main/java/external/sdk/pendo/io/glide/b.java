package external.sdk.pendo.io.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import external.sdk.pendo.io.glide.load.engine.Engine;
import external.sdk.pendo.io.glide.request.RequestOptions;
import external.sdk.pendo.io.glide.request.target.ViewTarget;
import java.util.List;
import java.util.Map;
import sdk.pendo.io.y.f;

/* JADX INFO: loaded from: classes4.dex */
public class b extends ContextWrapper {
    static final e<?, ?> k = new GenericTransitionOptions();
    private final sdk.pendo.io.i.a a;
    private final f.b<Registry> b;
    private final sdk.pendo.io.v.b c;
    private final a.InterfaceC0304a d;
    private final List<sdk.pendo.io.u.b<Object>> e;
    private final Map<Class<?>, e<?, ?>> f;
    private final Engine g;
    private final c h;
    private final int i;
    private RequestOptions j;

    public b(Context context, sdk.pendo.io.i.a aVar, f.b<Registry> bVar, sdk.pendo.io.v.b bVar2, a.InterfaceC0304a interfaceC0304a, Map<Class<?>, e<?, ?>> map, List<sdk.pendo.io.u.b<Object>> list, Engine engine, c cVar, int i) {
        super(context.getApplicationContext());
        this.a = aVar;
        this.c = bVar2;
        this.d = interfaceC0304a;
        this.e = list;
        this.f = map;
        this.g = engine;
        this.h = cVar;
        this.i = i;
        this.b = f.a(bVar);
    }

    public <X> ViewTarget<ImageView, X> a(ImageView imageView, Class<X> cls) {
        return this.c.a(imageView, cls);
    }

    public List<sdk.pendo.io.u.b<Object>> b() {
        return this.e;
    }

    public synchronized RequestOptions c() {
        if (this.j == null) {
            this.j = this.d.build().lock();
        }
        return this.j;
    }

    public Engine d() {
        return this.g;
    }

    public c e() {
        return this.h;
    }

    public int f() {
        return this.i;
    }

    public Registry g() {
        return this.b.get();
    }

    public sdk.pendo.io.i.a a() {
        return this.a;
    }

    public <T> e<?, T> a(Class<T> cls) {
        e<?, T> eVar = (e) this.f.get(cls);
        if (eVar == null) {
            for (Map.Entry<Class<?>, e<?, ?>> entry : this.f.entrySet()) {
                if (entry.getKey().isAssignableFrom(cls)) {
                    eVar = (e) entry.getValue();
                }
            }
        }
        return eVar == null ? (e<?, T>) k : eVar;
    }
}
