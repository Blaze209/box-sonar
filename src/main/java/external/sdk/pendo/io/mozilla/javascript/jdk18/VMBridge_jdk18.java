package external.sdk.pendo.io.mozilla.javascript.jdk18;

import external.sdk.pendo.io.mozilla.javascript.Context;
import external.sdk.pendo.io.mozilla.javascript.ContextFactory;
import external.sdk.pendo.io.mozilla.javascript.InterfaceAdapter;
import external.sdk.pendo.io.mozilla.javascript.Scriptable;
import external.sdk.pendo.io.mozilla.javascript.VMBridge;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes4.dex */
public class VMBridge_jdk18 extends VMBridge {
    private static final ThreadLocal<Object[]> contextLocal = new ThreadLocal<>();

    @Override // external.sdk.pendo.io.mozilla.javascript.VMBridge
    protected Context getContext(Object obj) {
        return (Context) ((Object[]) obj)[0];
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.VMBridge
    protected Object getInterfaceProxyHelper(ContextFactory contextFactory, Class<?>[] clsArr) {
        try {
            return Proxy.getProxyClass(clsArr[0].getClassLoader(), clsArr).getConstructor(InvocationHandler.class);
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.VMBridge
    protected Object getThreadContextHelper() {
        ThreadLocal<Object[]> threadLocal = contextLocal;
        Object[] objArr = threadLocal.get();
        if (objArr != null) {
            return objArr;
        }
        Object[] objArr2 = new Object[1];
        threadLocal.set(objArr2);
        return objArr2;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.VMBridge
    protected Object newInterfaceProxy(Object obj, final ContextFactory contextFactory, final InterfaceAdapter interfaceAdapter, final Object obj2, final Scriptable scriptable) {
        try {
            return ((Constructor) obj).newInstance(new InvocationHandler() { // from class: external.sdk.pendo.io.mozilla.javascript.jdk18.VMBridge_jdk18.1
                @Override // java.lang.reflect.InvocationHandler
                public Object invoke(Object obj3, Method method, Object[] objArr) {
                    if (method.getDeclaringClass() == Object.class) {
                        String name = method.getName();
                        if (name.equals("equals")) {
                            return Boolean.valueOf(obj3 == objArr[0]);
                        }
                        if (name.equals("hashCode")) {
                            return Integer.valueOf(obj2.hashCode());
                        }
                        if (name.equals("toString")) {
                            return "Proxy[" + obj2.toString() + "]";
                        }
                    }
                    return interfaceAdapter.invoke(contextFactory, obj2, scriptable, obj3, method, objArr);
                }
            });
        } catch (IllegalAccessException e) {
            throw new IllegalStateException(e);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        } catch (InvocationTargetException e3) {
            throw Context.throwAsScriptRuntimeEx(e3);
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.VMBridge
    protected void setContext(Object obj, Context context) {
        ((Object[]) obj)[0] = context;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.VMBridge
    protected boolean tryToMakeAccessible(AccessibleObject accessibleObject) {
        if (accessibleObject.isAccessible()) {
            return true;
        }
        try {
            accessibleObject.setAccessible(true);
        } catch (Exception unused) {
        }
        return accessibleObject.isAccessible();
    }
}
