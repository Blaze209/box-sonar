package external.sdk.pendo.io.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import external.sdk.pendo.io.glide.load.engine.Engine;
import external.sdk.pendo.io.glide.manager.j;
import external.sdk.pendo.io.glide.module.AppGlideModule;
import external.sdk.pendo.io.glide.module.GlideModule;
import external.sdk.pendo.io.glide.request.RequestOptions;
import external.sdk.pendo.io.glide.request.target.Target;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import sdk.pendo.io.y.k;
import sdk.pendo.io.y.l;

/* JADX INFO: loaded from: classes4.dex */
public class a implements ComponentCallbacks2 {
    private static volatile a k;
    private static volatile boolean l;
    private final Engine a;
    private final sdk.pendo.io.i.b b;
    private final external.sdk.pendo.io.glide.load.engine.cache.c c;
    private final b d;
    private final sdk.pendo.io.i.a e;
    private final j f;
    private final external.sdk.pendo.io.glide.manager.b g;
    private final InterfaceC0304a i;
    private final List<RequestManager> h = new ArrayList();
    private sdk.pendo.io.c.a j = sdk.pendo.io.c.a.NORMAL;

    /* JADX INFO: renamed from: external.sdk.pendo.io.glide.a$a, reason: collision with other inner class name */
    public interface InterfaceC0304a {
        RequestOptions build();
    }

    a(Context context, Engine engine, external.sdk.pendo.io.glide.load.engine.cache.c cVar, sdk.pendo.io.i.b bVar, sdk.pendo.io.i.a aVar, j jVar, external.sdk.pendo.io.glide.manager.b bVar2, int i, InterfaceC0304a interfaceC0304a, Map<Class<?>, e<?, ?>> map, List<sdk.pendo.io.u.b<Object>> list, List<GlideModule> list2, AppGlideModule appGlideModule, c cVar2) {
        this.a = engine;
        this.b = bVar;
        this.e = aVar;
        this.c = cVar;
        this.f = jVar;
        this.g = bVar2;
        this.i = interfaceC0304a;
        this.d = new b(context, aVar, d.b(this, list2, appGlideModule), new sdk.pendo.io.v.b(), interfaceC0304a, map, list, engine, cVar2, i);
    }

    static void a(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        if (l) {
            throw new IllegalStateException("Glide has been called recursively, this is probably an internal library error!");
        }
        l = true;
        try {
            b(context, generatedAppGlideModule);
        } finally {
            l = false;
        }
    }

    private static GeneratedAppGlideModule b(Context context) {
        try {
            return (GeneratedAppGlideModule) GeneratedAppGlideModuleImpl.class.getDeclaredConstructor(Context.class).newInstance(context.getApplicationContext());
        } catch (ClassNotFoundException unused) {
            if (!Log.isLoggable("Glide", 5)) {
                return null;
            }
            Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
            return null;
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            a(e);
            return null;
        }
    }

    public sdk.pendo.io.i.b c() {
        return this.b;
    }

    external.sdk.pendo.io.glide.manager.b d() {
        return this.g;
    }

    public Context e() {
        return this.d.getBaseContext();
    }

    b f() {
        return this.d;
    }

    public Registry g() {
        return this.d.g();
    }

    public j h() {
        return this.f;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        a();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        a(i);
    }

    private static j c(Context context) {
        k.a(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return a(context).h();
    }

    public static RequestManager d(Context context) {
        return c(context).b(context);
    }

    public void a() {
        l.b();
        this.c.clearMemory();
        this.b.clearMemory();
        this.e.clearMemory();
    }

    public sdk.pendo.io.i.a b() {
        return this.e;
    }

    public static a a(Context context) {
        if (k == null) {
            GeneratedAppGlideModule generatedAppGlideModuleB = b(context.getApplicationContext());
            synchronized (a.class) {
                if (k == null) {
                    a(context, generatedAppGlideModuleB);
                }
            }
        }
        return k;
    }

    private static void b(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        a(context, new GlideBuilder(), generatedAppGlideModule);
    }

    private static void a(Context context, GlideBuilder glideBuilder, GeneratedAppGlideModule generatedAppGlideModule) {
        Context applicationContext = context.getApplicationContext();
        List<GlideModule> listEmptyList = Collections.emptyList();
        if (generatedAppGlideModule == null || generatedAppGlideModule.isManifestParsingEnabled()) {
            listEmptyList = new sdk.pendo.io.s.a(applicationContext).b();
        }
        if (generatedAppGlideModule != null && !generatedAppGlideModule.getExcludedModuleClasses().isEmpty()) {
            Set<Class<?>> excludedModuleClasses = generatedAppGlideModule.getExcludedModuleClasses();
            Iterator<GlideModule> it = listEmptyList.iterator();
            while (it.hasNext()) {
                GlideModule next = it.next();
                if (excludedModuleClasses.contains(next.getClass())) {
                    if (Log.isLoggable("Glide", 3)) {
                        Log.d("Glide", "AppGlideModule excludes manifest GlideModule: " + next);
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable("Glide", 3)) {
            Iterator<GlideModule> it2 = listEmptyList.iterator();
            while (it2.hasNext()) {
                Log.d("Glide", "Discovered GlideModule from manifest: " + it2.next().getClass());
            }
        }
        glideBuilder.a(generatedAppGlideModule != null ? generatedAppGlideModule.getRequestManagerFactory() : null);
        Iterator<GlideModule> it3 = listEmptyList.iterator();
        while (it3.hasNext()) {
            it3.next().applyOptions(applicationContext, glideBuilder);
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.applyOptions(applicationContext, glideBuilder);
        }
        a aVarA = glideBuilder.a(applicationContext, listEmptyList, generatedAppGlideModule);
        applicationContext.registerComponentCallbacks(aVarA);
        k = aVarA;
    }

    void b(RequestManager requestManager) {
        synchronized (this.h) {
            if (!this.h.contains(requestManager)) {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
            this.h.remove(requestManager);
        }
    }

    void a(RequestManager requestManager) {
        synchronized (this.h) {
            if (this.h.contains(requestManager)) {
                throw new IllegalStateException("Cannot register already registered manager");
            }
            this.h.add(requestManager);
        }
    }

    boolean a(Target<?> target) {
        synchronized (this.h) {
            Iterator<RequestManager> it = this.h.iterator();
            while (it.hasNext()) {
                if (it.next().untrack(target)) {
                    return true;
                }
            }
            return false;
        }
    }

    private static void a(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    public void a(int i) {
        l.b();
        synchronized (this.h) {
            Iterator<RequestManager> it = this.h.iterator();
            while (it.hasNext()) {
                it.next().onTrimMemory(i);
            }
        }
        this.c.trimMemory(i);
        this.b.trimMemory(i);
        this.e.trimMemory(i);
    }
}
