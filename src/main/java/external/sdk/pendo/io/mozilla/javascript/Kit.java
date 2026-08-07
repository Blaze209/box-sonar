package external.sdk.pendo.io.mozilla.javascript;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class Kit {

    private static final class ComplexKey {
        private int hash;
        private Object key1;
        private Object key2;

        ComplexKey(Object obj, Object obj2) {
            this.key1 = obj;
            this.key2 = obj2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ComplexKey)) {
                return false;
            }
            ComplexKey complexKey = (ComplexKey) obj;
            return this.key1.equals(complexKey.key1) && this.key2.equals(complexKey.key2);
        }

        public int hashCode() {
            if (this.hash == 0) {
                this.hash = this.key1.hashCode() ^ this.key2.hashCode();
            }
            return this.hash;
        }
    }

    public static Object addListener(Object obj, Object obj2) {
        if (obj2 == null) {
            throw new IllegalArgumentException();
        }
        if (obj2 instanceof Object[]) {
            throw new IllegalArgumentException();
        }
        if (obj == null) {
            return obj2;
        }
        if (!(obj instanceof Object[])) {
            return new Object[]{obj, obj2};
        }
        Object[] objArr = (Object[]) obj;
        int length = objArr.length;
        if (length < 2) {
            throw new IllegalArgumentException();
        }
        Object[] objArr2 = new Object[length + 1];
        System.arraycopy(objArr, 0, objArr2, 0, length);
        objArr2[length] = obj2;
        return objArr2;
    }

    public static Class<?> classOrNull(ClassLoader classLoader, String str) {
        try {
            return classLoader.loadClass(str);
        } catch (ClassNotFoundException | IllegalArgumentException | LinkageError | SecurityException unused) {
            return null;
        }
    }

    public static RuntimeException codeBug() {
        IllegalStateException illegalStateException = new IllegalStateException("FAILED ASSERTION");
        illegalStateException.printStackTrace(System.err);
        throw illegalStateException;
    }

    public static Object getListener(Object obj, int i) {
        if (i == 0) {
            if (obj == null) {
                return null;
            }
            if (!(obj instanceof Object[])) {
                return obj;
            }
            Object[] objArr = (Object[]) obj;
            if (objArr.length >= 2) {
                return objArr[0];
            }
            throw new IllegalArgumentException();
        }
        if (i == 1) {
            if (obj instanceof Object[]) {
                return ((Object[]) obj)[1];
            }
            if (obj != null) {
                return null;
            }
            throw new IllegalArgumentException();
        }
        Object[] objArr2 = (Object[]) obj;
        int length = objArr2.length;
        if (length < 2) {
            throw new IllegalArgumentException();
        }
        if (i == length) {
            return null;
        }
        return objArr2[i];
    }

    static Object initHash(Map<Object, Object> map, Object obj, Object obj2) {
        synchronized (map) {
            Object obj3 = map.get(obj);
            if (obj3 == null) {
                map.put(obj, obj2);
            } else {
                obj2 = obj3;
            }
        }
        return obj2;
    }

    public static Object makeHashKeyFromPair(Object obj, Object obj2) {
        if (obj == null) {
            throw new IllegalArgumentException();
        }
        if (obj2 != null) {
            return new ComplexKey(obj, obj2);
        }
        throw new IllegalArgumentException();
    }

    static Object newInstanceOrNull(Class<?> cls) {
        try {
            return cls.newInstance();
        } catch (IllegalAccessException | InstantiationException | LinkageError | SecurityException unused) {
            return null;
        }
    }

    public static String readReader(Reader reader) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(reader);
        try {
            char[] cArr = new char[1024];
            StringBuilder sb = new StringBuilder(1024);
            while (true) {
                int i = bufferedReader.read(cArr, 0, 1024);
                if (i == -1) {
                    String string = sb.toString();
                    bufferedReader.close();
                    return string;
                }
                sb.append(cArr, 0, i);
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    bufferedReader.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public static byte[] readStream(InputStream inputStream, int i) throws IOException {
        if (i <= 0) {
            throw new IllegalArgumentException("Bad initialBufferCapacity: " + i);
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (true) {
            int i3 = inputStream.read(bArr, i2, bArr.length - i2);
            if (i3 < 0) {
                break;
            }
            i2 += i3;
            if (i2 == bArr.length) {
                byte[] bArr2 = new byte[bArr.length * 2];
                System.arraycopy(bArr, 0, bArr2, 0, i2);
                bArr = bArr2;
            }
        }
        if (i2 == bArr.length) {
            return bArr;
        }
        byte[] bArr3 = new byte[i2];
        System.arraycopy(bArr, 0, bArr3, 0, i2);
        return bArr3;
    }

    public static Object removeListener(Object obj, Object obj2) {
        if (obj2 == null) {
            throw new IllegalArgumentException();
        }
        if (obj2 instanceof Object[]) {
            throw new IllegalArgumentException();
        }
        if (obj == obj2) {
            return null;
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            int length = objArr.length;
            if (length < 2) {
                throw new IllegalArgumentException();
            }
            if (length == 2) {
                Object obj3 = objArr[1];
                if (obj3 == obj2) {
                    return objArr[0];
                }
                if (objArr[0] == obj2) {
                    return obj3;
                }
            } else {
                int i = length;
                while (true) {
                    int i2 = i - 1;
                    if (objArr[i2] == obj2) {
                        Object[] objArr2 = new Object[length - 1];
                        System.arraycopy(objArr, 0, objArr2, 0, i2);
                        System.arraycopy(objArr, i, objArr2, i2, length - i);
                        return objArr2;
                    }
                    if (i2 != 0) {
                        i = i2;
                    }
                }
            }
        }
        return obj;
    }

    static boolean testIfCanLoadRhinoClasses(ClassLoader classLoader) {
        Class<?> cls = ScriptRuntime.ContextFactoryClass;
        return classOrNull(classLoader, cls.getName()) == cls;
    }

    public static int xDigitToInt(int i, int i2) {
        int i3;
        if (i <= 57) {
            i3 = i - 48;
            if (i3 < 0) {
                return -1;
            }
        } else if (i <= 70) {
            if (65 > i) {
                return -1;
            }
            i3 = i - 55;
        } else {
            if (i > 102 || 97 > i) {
                return -1;
            }
            i3 = i - 87;
        }
        return i3 | (i2 << 4);
    }

    public static Class<?> classOrNull(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException | IllegalArgumentException | LinkageError | SecurityException unused) {
            return null;
        }
    }

    public static RuntimeException codeBug(String str) {
        IllegalStateException illegalStateException = new IllegalStateException("FAILED ASSERTION: " + str);
        illegalStateException.printStackTrace(System.err);
        throw illegalStateException;
    }
}
