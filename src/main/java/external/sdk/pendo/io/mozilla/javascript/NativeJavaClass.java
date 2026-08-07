package external.sdk.pendo.io.mozilla.javascript;

import java.lang.reflect.Array;
import java.lang.reflect.Modifier;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class NativeJavaClass extends NativeJavaObject implements Function {
    static final String javaClassPropertyName = "__javaObject__";
    private static final long serialVersionUID = -6460763940409461664L;
    private Map<String, FieldAndMethods> staticFieldAndMethods;

    public NativeJavaClass() {
    }

    public NativeJavaClass(Scriptable scriptable, Class<?> cls) {
        this(scriptable, cls, false);
    }

    static Object constructInternal(Object[] objArr, MemberBox memberBox) {
        Object[] objArr2;
        Object objJsToJava;
        Class<?>[] clsArr = memberBox.argTypes;
        int i = 0;
        if (memberBox.vararg) {
            objArr2 = new Object[clsArr.length];
            for (int i2 = 0; i2 < clsArr.length - 1; i2++) {
                objArr2[i2] = Context.jsToJava(objArr[i2], clsArr[i2]);
            }
            if (objArr.length == clsArr.length && (objArr[objArr.length - 1] == null || (objArr[objArr.length - 1] instanceof NativeArray) || (objArr[objArr.length - 1] instanceof NativeJavaArray))) {
                objJsToJava = Context.jsToJava(objArr[objArr.length - 1], clsArr[clsArr.length - 1]);
            } else {
                Class<?> componentType = clsArr[clsArr.length - 1].getComponentType();
                Object objNewInstance = Array.newInstance(componentType, (objArr.length - clsArr.length) + 1);
                while (i < Array.getLength(objNewInstance)) {
                    Array.set(objNewInstance, i, Context.jsToJava(objArr[(clsArr.length - 1) + i], componentType));
                    i++;
                }
                objJsToJava = objNewInstance;
            }
            objArr2[clsArr.length - 1] = objJsToJava;
        } else {
            objArr2 = objArr;
            while (i < objArr2.length) {
                Object obj = objArr2[i];
                Object objJsToJava2 = Context.jsToJava(obj, clsArr[i]);
                if (objJsToJava2 != obj) {
                    if (objArr2 == objArr) {
                        objArr2 = (Object[]) objArr.clone();
                    }
                    objArr2[i] = objJsToJava2;
                }
                i++;
            }
        }
        return memberBox.newInstance(objArr2);
    }

    static Scriptable constructSpecific(Context context, Scriptable scriptable, Object[] objArr, MemberBox memberBox) {
        Object objConstructInternal = constructInternal(objArr, memberBox);
        return context.getWrapFactory().wrapNewObject(context, ScriptableObject.getTopLevelScope(scriptable), objConstructInternal);
    }

    private static Class<?> findNestedClass(Class<?> cls, String str) {
        String str2 = cls.getName() + '$' + str;
        ClassLoader classLoader = cls.getClassLoader();
        return classLoader == null ? Kit.classOrNull(str2) : Kit.classOrNull(classLoader, str2);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.Function, external.sdk.pendo.io.mozilla.javascript.Callable
    public Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (objArr.length == 1 && (objArr[0] instanceof Scriptable)) {
            Class<?> classObject = getClassObject();
            Scriptable prototype = (Scriptable) objArr[0];
            do {
                if ((prototype instanceof Wrapper) && classObject.isInstance(((Wrapper) prototype).unwrap())) {
                    return prototype;
                }
                prototype = prototype.getPrototype();
            } while (prototype != null);
        }
        return construct(context, scriptable, objArr);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.Function
    public Scriptable construct(Context context, Scriptable scriptable, Object[] objArr) {
        String message;
        Class<?> classObject = getClassObject();
        int modifiers = classObject.getModifiers();
        if (!Modifier.isInterface(modifiers) && !Modifier.isAbstract(modifiers)) {
            NativeJavaMethod nativeJavaMethod = this.members.ctors;
            int iFindCachedFunction = nativeJavaMethod.findCachedFunction(context, objArr);
            if (iFindCachedFunction >= 0) {
                return constructSpecific(context, scriptable, objArr, nativeJavaMethod.methods[iFindCachedFunction]);
            }
            throw Context.reportRuntimeError2("msg.no.java.ctor", classObject.getName(), NativeJavaMethod.scriptSignature(objArr));
        }
        if (objArr.length == 0) {
            throw Context.reportRuntimeError0("msg.adapter.zero.args");
        }
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(this);
        try {
            if ("Dalvik".equals(System.getProperty("java.vm.name")) && classObject.isInterface()) {
                return context.getWrapFactory().wrapAsJavaObject(context, scriptable, NativeJavaObject.createInterfaceAdapter(classObject, ScriptableObject.ensureScriptableObject(objArr[0])), null);
            }
            Object obj = topLevelScope.get("JavaAdapter", topLevelScope);
            if (obj != Scriptable.NOT_FOUND) {
                return ((Function) obj).construct(context, topLevelScope, new Object[]{this, objArr[0]});
            }
            message = "";
            throw Context.reportRuntimeError2("msg.cant.instantiate", message, classObject.getName());
        } catch (Exception e) {
            message = e.getMessage();
            if (message == null) {
            }
            throw Context.reportRuntimeError2("msg.cant.instantiate", message, classObject.getName());
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.NativeJavaObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public Object get(String str, Scriptable scriptable) {
        FieldAndMethods fieldAndMethods;
        if (str.equals("prototype")) {
            return null;
        }
        Map<String, FieldAndMethods> map = this.staticFieldAndMethods;
        if (map != null && (fieldAndMethods = map.get(str)) != null) {
            return fieldAndMethods;
        }
        if (this.members.has(str, true)) {
            return this.members.get(this, str, this.javaObject, true);
        }
        Context context = Context.getContext();
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        WrapFactory wrapFactory = context.getWrapFactory();
        if (javaClassPropertyName.equals(str)) {
            return wrapFactory.wrap(context, topLevelScope, this.javaObject, ScriptRuntime.ClassClass);
        }
        Class<?> clsFindNestedClass = findNestedClass(getClassObject(), str);
        if (clsFindNestedClass == null) {
            throw this.members.reportMemberNotFound(str);
        }
        Scriptable scriptableWrapJavaClass = wrapFactory.wrapJavaClass(context, topLevelScope, clsFindNestedClass);
        scriptableWrapJavaClass.setParentScope(this);
        return scriptableWrapJavaClass;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.NativeJavaObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public String getClassName() {
        return "JavaClass";
    }

    public Class<?> getClassObject() {
        return (Class) super.unwrap();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.NativeJavaObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public Object getDefaultValue(Class<?> cls) {
        if (cls == null || cls == ScriptRuntime.StringClass) {
            return toString();
        }
        if (cls == ScriptRuntime.BooleanClass) {
            return Boolean.TRUE;
        }
        return cls == ScriptRuntime.NumberClass ? ScriptRuntime.NaNobj : this;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.NativeJavaObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public Object[] getIds() {
        return this.members.getIds(true);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.NativeJavaObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public boolean has(String str, Scriptable scriptable) {
        return this.members.has(str, true) || javaClassPropertyName.equals(str);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.NativeJavaObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public boolean hasInstance(Scriptable scriptable) {
        if (!(scriptable instanceof Wrapper) || (scriptable instanceof NativeJavaClass)) {
            return false;
        }
        return getClassObject().isInstance(((Wrapper) scriptable).unwrap());
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.NativeJavaObject
    protected void initMembers() {
        Class cls = (Class) this.javaObject;
        JavaMembers javaMembersLookupClass = JavaMembers.lookupClass(this.parent, cls, cls, this.isAdapter);
        this.members = javaMembersLookupClass;
        this.staticFieldAndMethods = javaMembersLookupClass.getFieldAndMethodsObjects(this, cls, true);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.NativeJavaObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public void put(String str, Scriptable scriptable, Object obj) {
        this.members.put(this, str, this.javaObject, obj, true);
    }

    public String toString() {
        return "[JavaClass " + getClassObject().getName() + "]";
    }

    public NativeJavaClass(Scriptable scriptable, Class<?> cls, boolean z) {
        super(scriptable, cls, null, z);
    }
}
