package sdk.pendo.io.utilities.script;

import external.sdk.pendo.io.mozilla.javascript.BaseFunction;
import external.sdk.pendo.io.mozilla.javascript.Context;
import external.sdk.pendo.io.mozilla.javascript.NativeJavaClass;
import external.sdk.pendo.io.mozilla.javascript.NativeJavaObject;
import external.sdk.pendo.io.mozilla.javascript.Scriptable;
import external.sdk.pendo.io.mozilla.javascript.ScriptableObject;
import external.sdk.pendo.io.mozilla.javascript.WrapFactory;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import sdk.pendo.io.logging.PendoLogger;

/* JADX INFO: loaded from: classes5.dex */
class JavascriptSandboxWrapFactory extends WrapFactory {
    private final Set<Class<?>> mReplacedClasses = new HashSet();
    private final ScriptSandbox mShutter;

    JavascriptSandboxWrapFactory(ScriptSandbox scriptSandbox) {
        this.mShutter = scriptSandbox;
    }

    private Class<?> ensureReplacedClass(Scriptable scriptable, Object obj, Class<?> cls) {
        if (cls == null && obj != null) {
            cls = obj.getClass();
        }
        if (cls != null && !cls.isPrimitive() && !cls.getName().startsWith("java.") && this.mReplacedClasses.add(cls)) {
            replaceJavaNativeClass(cls, scriptable);
        }
        return cls;
    }

    private void replaceJavaNativeClass(final Class<?> cls, Scriptable scriptable) {
        Object property = ScriptableObject.getProperty(scriptable, "Packages");
        String[] strArrSplit = cls.getName().split("\\.");
        int length = strArrSplit.length;
        Object obj = null;
        int i = 0;
        while (i < length) {
            String str = strArrSplit[i];
            if (!(property instanceof Scriptable)) {
                PendoLogger.d("Expected Scriptable while resolving '" + str + "' for type '" + cls.getName() + "', but got: " + (property == null ? AbstractJsonLexerKt.NULL : property.getClass().getName()), new Object[0]);
                return;
            }
            Object property2 = ScriptableObject.getProperty((Scriptable) property, str);
            if (property2 == Scriptable.NOT_FOUND || property2 == null) {
                PendoLogger.d("Property '" + str + "' not found while resolving type '" + cls.getName() + "'", new Object[0]);
                return;
            } else {
                i++;
                obj = property;
                property = property2;
            }
        }
        NativeJavaClass nativeJavaClass = new NativeJavaClass(scriptable, cls) { // from class: sdk.pendo.io.utilities.script.JavascriptSandboxWrapFactory.2
            @Override // external.sdk.pendo.io.mozilla.javascript.NativeJavaClass, external.sdk.pendo.io.mozilla.javascript.NativeJavaObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
            public Object get(String str2, Scriptable scriptable2) {
                Object obj2 = super.get(str2, scriptable2);
                if (obj2 instanceof BaseFunction) {
                    if (!JavascriptSandboxWrapFactory.this.mShutter.allowStaticMethodAccess(cls, str2)) {
                        return Scriptable.NOT_FOUND;
                    }
                } else if (!JavascriptSandboxWrapFactory.this.mShutter.allowStaticFieldAccess(cls, str2)) {
                    return Scriptable.NOT_FOUND;
                }
                return obj2;
            }
        };
        if (obj == null) {
            PendoLogger.d("Holder is null for type '" + cls.getName() + "'", new Object[0]);
        } else {
            ScriptableObject.putProperty((Scriptable) obj, cls.getSimpleName(), nativeJavaClass);
            ScriptableObject.putProperty(scriptable, cls.getSimpleName(), nativeJavaClass);
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.WrapFactory
    public Object wrap(Context context, Scriptable scriptable, Object obj, Class<?> cls) {
        ensureReplacedClass(scriptable, obj, cls);
        return super.wrap(context, scriptable, obj, cls);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.WrapFactory
    public Scriptable wrapAsJavaObject(Context context, Scriptable scriptable, Object obj, Class<?> cls) {
        final Class<?> clsEnsureReplacedClass = ensureReplacedClass(scriptable, obj, cls);
        return new NativeJavaObject(scriptable, obj, cls) { // from class: sdk.pendo.io.utilities.script.JavascriptSandboxWrapFactory.1
            private final Map<String, Boolean> mInstanceMethodToAllowed = new HashMap();

            @Override // external.sdk.pendo.io.mozilla.javascript.NativeJavaObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
            public Object get(String str, Scriptable scriptable2) {
                Object obj2 = super.get(str, scriptable2);
                if (obj2 instanceof BaseFunction) {
                    String str2 = clsEnsureReplacedClass.getName() + "." + str;
                    Boolean boolValueOf = this.mInstanceMethodToAllowed.get(str2);
                    if (boolValueOf == null) {
                        boolValueOf = Boolean.valueOf(JavascriptSandboxWrapFactory.this.mShutter.allowMethodAccess(clsEnsureReplacedClass, this.javaObject, str));
                        this.mInstanceMethodToAllowed.put(str2, boolValueOf);
                    }
                    if (!boolValueOf.booleanValue()) {
                        return Scriptable.NOT_FOUND;
                    }
                } else if (!JavascriptSandboxWrapFactory.this.mShutter.allowFieldAccess(clsEnsureReplacedClass, this.javaObject, str)) {
                    return Scriptable.NOT_FOUND;
                }
                return obj2;
            }
        };
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.WrapFactory
    public Scriptable wrapNewObject(Context context, Scriptable scriptable, Object obj) {
        ensureReplacedClass(scriptable, obj, null);
        return super.wrapNewObject(context, scriptable, obj);
    }
}
