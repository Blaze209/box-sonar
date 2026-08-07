package external.sdk.pendo.io.mozilla.javascript;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: classes4.dex */
public class InterfaceAdapter {
    private final Object proxyHelper;

    private InterfaceAdapter(ContextFactory contextFactory, Class<?> cls) {
        this.proxyHelper = VMBridge.instance.getInterfaceProxyHelper(contextFactory, new Class[]{cls});
    }

    static Object create(Context context, Class<?> cls, ScriptableObject scriptableObject) {
        if (!cls.isInterface()) {
            throw new IllegalArgumentException();
        }
        Scriptable topCallScope = ScriptRuntime.getTopCallScope(context);
        ClassCache classCache = ClassCache.get(topCallScope);
        InterfaceAdapter interfaceAdapter = (InterfaceAdapter) classCache.getInterfaceAdapter(cls);
        ContextFactory factory = context.getFactory();
        if (interfaceAdapter == null) {
            Method[] methods = cls.getMethods();
            if (scriptableObject instanceof Callable) {
                int length = methods.length;
                if (length == 0) {
                    throw Context.reportRuntimeError1("msg.no.empty.interface.conversion", cls.getName());
                }
                if (length > 1) {
                    String name = null;
                    for (Method method : methods) {
                        if (isFunctionalMethodCandidate(method)) {
                            if (name == null) {
                                name = method.getName();
                            } else if (!name.equals(method.getName())) {
                                throw Context.reportRuntimeError1("msg.no.function.interface.conversion", cls.getName());
                            }
                        }
                    }
                }
            }
            interfaceAdapter = new InterfaceAdapter(factory, cls);
            classCache.cacheInterfaceAdapter(cls, interfaceAdapter);
        }
        InterfaceAdapter interfaceAdapter2 = interfaceAdapter;
        return VMBridge.instance.newInterfaceProxy(interfaceAdapter2.proxyHelper, factory, interfaceAdapter2, scriptableObject, topCallScope);
    }

    private static boolean isFunctionalMethodCandidate(Method method) {
        if (method.getName().equals("equals") || method.getName().equals("hashCode") || method.getName().equals("toString")) {
            return false;
        }
        return Modifier.isAbstract(method.getModifiers());
    }

    public Object invoke(ContextFactory contextFactory, final Object obj, final Scriptable scriptable, final Object obj2, final Method method, final Object[] objArr) {
        return contextFactory.call(new ContextAction() { // from class: external.sdk.pendo.io.mozilla.javascript.InterfaceAdapter$$ExternalSyntheticLambda0
            @Override // external.sdk.pendo.io.mozilla.javascript.ContextAction
            public final Object run(Context context) {
                return this.f$0.m14714xa81a632d(obj, scriptable, obj2, method, objArr, context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: invokeImpl, reason: merged with bridge method [inline-methods] */
    public Object m14714xa81a632d(Context context, Object obj, Scriptable scriptable, Object obj2, Method method, Object[] objArr) {
        if (!(obj instanceof Callable)) {
            String name = method.getName();
            obj = ScriptableObject.getProperty((Scriptable) obj, name);
            if (obj == Scriptable.NOT_FOUND) {
                Context.reportWarning(ScriptRuntime.getMessage1("msg.undefined.function.interface", name));
                Class<?> returnType = method.getReturnType();
                if (returnType == Void.TYPE) {
                    return null;
                }
                return Context.jsToJava(null, returnType);
            }
            if (!(obj instanceof Callable)) {
                throw Context.reportRuntimeError1("msg.not.function.interface", name);
            }
        }
        Callable callable = (Callable) obj;
        WrapFactory wrapFactory = context.getWrapFactory();
        if (objArr == null) {
            objArr = ScriptRuntime.emptyArgs;
        } else {
            int length = objArr.length;
            for (int i = 0; i != length; i++) {
                Object obj3 = objArr[i];
                if (!(obj3 instanceof String) && !(obj3 instanceof Number) && !(obj3 instanceof Boolean)) {
                    objArr[i] = wrapFactory.wrap(context, scriptable, obj3, null);
                }
            }
        }
        Object objCall = callable.call(context, scriptable, wrapFactory.wrapAsJavaObject(context, scriptable, obj2, null), objArr);
        Class<?> returnType2 = method.getReturnType();
        if (returnType2 == Void.TYPE) {
            return null;
        }
        return Context.jsToJava(objCall, returnType2);
    }
}
