package sdk.pendo.io.c0;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: classes4.dex */
public abstract class l {

    class a extends l {
        final /* synthetic */ Method a;
        final /* synthetic */ Object b;

        a(Method method, Object obj) {
            this.a = method;
            this.b = obj;
        }

        @Override // sdk.pendo.io.c0.l
        public <T> T b(Class<T> cls) {
            l.a(cls);
            return (T) this.a.invoke(this.b, cls);
        }
    }

    class b extends l {
        final /* synthetic */ Method a;
        final /* synthetic */ int b;

        b(Method method, int i) {
            this.a = method;
            this.b = i;
        }

        @Override // sdk.pendo.io.c0.l
        public <T> T b(Class<T> cls) {
            l.a(cls);
            return (T) this.a.invoke(null, cls, Integer.valueOf(this.b));
        }
    }

    class c extends l {
        final /* synthetic */ Method a;

        c(Method method) {
            this.a = method;
        }

        @Override // sdk.pendo.io.c0.l
        public <T> T b(Class<T> cls) {
            l.a(cls);
            return (T) this.a.invoke(null, cls, Object.class);
        }
    }

    class d extends l {
        d() {
        }

        @Override // sdk.pendo.io.c0.l
        public <T> T b(Class<T> cls) {
            throw new UnsupportedOperationException("Cannot allocate " + cls + ". Usage of JDK sun.misc.Unsafe is enabled, but it could not be used. Make sure your runtime is configured correctly.");
        }
    }

    static void a(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            throw new UnsupportedOperationException("Interface can't be instantiated! Interface name: " + cls.getName());
        }
        if (Modifier.isAbstract(modifiers)) {
            throw new UnsupportedOperationException("Abstract class can't be instantiated! Class name: " + cls.getName());
        }
    }

    public abstract <T> T b(Class<T> cls);

    public static l a() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return new a(cls.getMethod("allocateInstance", Class.class), declaredField.get(null));
        } catch (Exception unused) {
            try {
                try {
                    Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                    declaredMethod.setAccessible(true);
                    int iIntValue = ((Integer) declaredMethod.invoke(null, Object.class)).intValue();
                    Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                    declaredMethod2.setAccessible(true);
                    return new b(declaredMethod2, iIntValue);
                } catch (Exception unused2) {
                    return new d();
                }
            } catch (Exception unused3) {
                Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                declaredMethod3.setAccessible(true);
                return new c(declaredMethod3);
            }
        }
    }
}
