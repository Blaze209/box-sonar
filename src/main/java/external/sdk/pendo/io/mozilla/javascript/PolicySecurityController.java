package external.sdk.pendo.io.mozilla.javascript;

import androidx.core.app.NotificationCompat;
import java.lang.ref.SoftReference;
import java.lang.reflect.UndeclaredThrowableException;
import java.security.AccessController;
import java.security.CodeSource;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.security.SecureClassLoader;
import java.util.Map;
import java.util.WeakHashMap;
import sdk.pendo.io.d2.c;

/* JADX INFO: loaded from: classes4.dex */
public class PolicySecurityController extends SecurityController {
    private static final byte[] secureCallerImplBytecode = loadBytecode();
    private static final Map<CodeSource, Map<ClassLoader, SoftReference<SecureCaller>>> callers = new WeakHashMap();

    private static class Loader extends SecureClassLoader implements GeneratedClassLoader {
        private final CodeSource codeSource;

        Loader(ClassLoader classLoader, CodeSource codeSource) {
            super(classLoader);
            this.codeSource = codeSource;
        }

        @Override // external.sdk.pendo.io.mozilla.javascript.GeneratedClassLoader
        public Class<?> defineClass(String str, byte[] bArr) {
            return defineClass(str, bArr, 0, bArr.length, this.codeSource);
        }

        @Override // external.sdk.pendo.io.mozilla.javascript.GeneratedClassLoader
        public void linkClass(Class<?> cls) {
            resolveClass(cls);
        }
    }

    public static abstract class SecureCaller {
        public abstract Object call(Callable callable, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr);
    }

    private static byte[] loadBytecode() {
        String name = SecureCaller.class.getName();
        c cVar = new c(name + "Impl", name, "<generated>");
        cVar.b("<init>", "()V", (short) 1);
        cVar.c(0);
        cVar.b(183, name, "<init>", "()V");
        cVar.b(177);
        cVar.c((short) 1);
        cVar.b(NotificationCompat.CATEGORY_CALL, "(Lorg/mozilla/javascript/Callable;Lexternal/sdk/pendo/io/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Ljava/lang/Object;", (short) 17);
        for (int i = 1; i < 6; i++) {
            cVar.c(i);
        }
        cVar.b(185, "external/sdk/pendo/io/mozilla/javascript/Callable", NotificationCompat.CATEGORY_CALL, "(Lexternal/sdk/pendo/io/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Ljava/lang/Object;");
        cVar.b(176);
        cVar.c((short) 6);
        return cVar.j();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.SecurityController
    public Object callWithDomain(Object obj, final Context context, Callable callable, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Map<ClassLoader, SoftReference<SecureCaller>> weakHashMap;
        SecureCaller secureCaller;
        final ClassLoader classLoader = (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: external.sdk.pendo.io.mozilla.javascript.PolicySecurityController.2
            @Override // java.security.PrivilegedAction
            public Object run() {
                return context.getApplicationClassLoader();
            }
        });
        final CodeSource codeSource = (CodeSource) obj;
        Map<CodeSource, Map<ClassLoader, SoftReference<SecureCaller>>> map = callers;
        synchronized (map) {
            weakHashMap = map.get(codeSource);
            if (weakHashMap == null) {
                weakHashMap = new WeakHashMap<>();
                map.put(codeSource, weakHashMap);
            }
        }
        synchronized (weakHashMap) {
            SoftReference<SecureCaller> softReference = weakHashMap.get(classLoader);
            SecureCaller secureCaller2 = softReference != null ? softReference.get() : null;
            if (secureCaller2 == null) {
                try {
                    secureCaller2 = (SecureCaller) AccessController.doPrivileged(new PrivilegedExceptionAction<Object>() { // from class: external.sdk.pendo.io.mozilla.javascript.PolicySecurityController.3
                        @Override // java.security.PrivilegedExceptionAction
                        public Object run() {
                            return new Loader(classLoader, codeSource).defineClass(SecureCaller.class.getName() + "Impl", PolicySecurityController.secureCallerImplBytecode).newInstance();
                        }
                    });
                    weakHashMap.put(classLoader, new SoftReference<>(secureCaller2));
                } catch (PrivilegedActionException e) {
                    throw new UndeclaredThrowableException(e.getCause());
                }
            }
            secureCaller = secureCaller2;
        }
        return secureCaller.call(callable, context, scriptable, scriptable2, objArr);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.SecurityController
    public GeneratedClassLoader createClassLoader(final ClassLoader classLoader, final Object obj) {
        return (Loader) AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: external.sdk.pendo.io.mozilla.javascript.PolicySecurityController.1
            @Override // java.security.PrivilegedAction
            public Object run() {
                return new Loader(classLoader, (CodeSource) obj);
            }
        });
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.SecurityController
    public Object getDynamicSecurityDomain(Object obj) {
        return obj;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.SecurityController
    public Class<?> getStaticSecurityDomainClassInternal() {
        return CodeSource.class;
    }
}
