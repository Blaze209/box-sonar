package sdk.pendo.io.l4;

import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
class o {
    private static final o c = d();
    private final boolean a;

    @Nullable
    private final Constructor<MethodHandles.Lookup> b;

    static final class a extends o {

        /* JADX INFO: renamed from: sdk.pendo.io.l4.o$a$a, reason: collision with other inner class name */
        static final class ExecutorC0414a implements Executor {
            private final Handler a = new Handler(Looper.getMainLooper());

            ExecutorC0414a() {
            }

            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                this.a.post(runnable);
            }
        }

        a() {
            super(true);
        }

        @Override // sdk.pendo.io.l4.o
        public Executor a() {
            return new ExecutorC0414a();
        }

        @Override // sdk.pendo.io.l4.o
        @Nullable
        Object a(Method method, Class<?> cls, Object obj, Object... objArr) {
            return super.a(method, cls, obj, objArr);
        }
    }

    o(boolean z) {
        this.a = z;
        Constructor<MethodHandles.Lookup> declaredConstructor = null;
        if (z) {
            try {
                declaredConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
                declaredConstructor.setAccessible(true);
            } catch (NoClassDefFoundError | NoSuchMethodException unused) {
            }
        }
        this.b = declaredConstructor;
    }

    private static o d() {
        return "Dalvik".equals(System.getProperty("java.vm.name")) ? new a() : new o(true);
    }

    static o e() {
        return c;
    }

    List<? extends c.a> a(@Nullable Executor executor) {
        g gVar = new g(executor);
        return this.a ? Arrays.asList(e.a, gVar) : Collections.singletonList(gVar);
    }

    @Nullable
    Executor a() {
        return null;
    }

    List<? extends f.a> b() {
        return this.a ? Collections.singletonList(m.a) : Collections.emptyList();
    }

    int c() {
        return this.a ? 1 : 0;
    }

    @Nullable
    Object a(Method method, Class<?> cls, Object obj, Object... objArr) {
        Constructor<MethodHandles.Lookup> constructor = this.b;
        return (constructor != null ? constructor.newInstance(cls, -1) : MethodHandles.lookup()).unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
    }

    boolean a(Method method) {
        return this.a && method.isDefault();
    }
}
