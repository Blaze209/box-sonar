package sdk.pendo.io.p1;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes4.dex */
class i extends ClassLoader {
    private static final String a = d.class.getName();
    private static final Class<?>[] b;

    static {
        Class<?> cls = Integer.TYPE;
        b = new Class[]{String.class, byte[].class, cls, cls};
    }

    i(ClassLoader classLoader) {
        super(classLoader);
    }

    Class<?> a(String str, byte[] bArr) {
        try {
            Method declaredMethod = ClassLoader.class.getDeclaredMethod("defineClass", b);
            declaredMethod.setAccessible(true);
            return (Class) declaredMethod.invoke(getParent(), str, bArr, 0, Integer.valueOf(bArr.length));
        } catch (Exception unused) {
            return defineClass(str, bArr, 0, bArr.length);
        }
    }

    @Override // java.lang.ClassLoader
    protected synchronized Class<?> loadClass(String str, boolean z) {
        if (str.equals(a)) {
            return d.class;
        }
        return super.loadClass(str, z);
    }
}
