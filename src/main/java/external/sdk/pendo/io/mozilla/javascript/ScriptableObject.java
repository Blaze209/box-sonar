package external.sdk.pendo.io.mozilla.javascript;

import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import com.pspdfkit.analytics.Analytics;
import external.sdk.pendo.io.mozilla.javascript.annotations.JSConstructor;
import external.sdk.pendo.io.mozilla.javascript.annotations.JSFunction;
import external.sdk.pendo.io.mozilla.javascript.annotations.JSGetter;
import external.sdk.pendo.io.mozilla.javascript.annotations.JSSetter;
import external.sdk.pendo.io.mozilla.javascript.annotations.JSStaticFunction;
import external.sdk.pendo.io.mozilla.javascript.debug.DebuggableObject;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ScriptableObject implements Scriptable, SymbolScriptable, Serializable, DebuggableObject, ConstProperties {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int CONST = 13;
    public static final int DONTENUM = 2;
    public static final int EMPTY = 0;
    private static final Method GET_ARRAY_LENGTH;
    private static final Comparator<Object> KEY_COMPARATOR;
    public static final int PERMANENT = 4;
    public static final int READONLY = 1;
    public static final int UNINITIALIZED_CONST = 8;
    private static final long serialVersionUID = 2829861078851942586L;
    private volatile Map<Object, Object> associatedValues;
    private transient ExternalArrayData externalData;
    private boolean isExtensible;
    private boolean isSealed;
    private Scriptable parentScopeObject;
    private Scriptable prototypeObject;
    private transient SlotMapContainer slotMap;

    static final class GetterSlot extends Slot {
        private static final long serialVersionUID = -4900574849788797588L;
        Object getter;
        Object setter;

        GetterSlot(Object obj, int i, int i2) {
            super(obj, i, i2);
        }

        @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject.Slot
        ScriptableObject getPropertyDescriptor(Context context, Scriptable scriptable) {
            FunctionObject functionObject;
            int attributes = getAttributes();
            NativeObject nativeObject = new NativeObject();
            ScriptRuntime.setBuiltinProtoAndParent(nativeObject, scriptable, TopLevel.Builtins.Object);
            nativeObject.defineProperty("enumerable", Boolean.valueOf((attributes & 2) == 0), 0);
            nativeObject.defineProperty("configurable", Boolean.valueOf((attributes & 4) == 0), 0);
            if (this.getter == null && this.setter == null) {
                nativeObject.defineProperty("writable", Boolean.valueOf((attributes & 1) == 0), 0);
            }
            Object obj = this.name;
            String string = obj == null ? "f" : obj.toString();
            Object functionObject2 = this.getter;
            if (functionObject2 != null) {
                if (functionObject2 instanceof MemberBox) {
                    functionObject2 = new FunctionObject(string, ((MemberBox) this.getter).member(), scriptable);
                } else if (functionObject2 instanceof Member) {
                    functionObject2 = new FunctionObject(string, (Member) this.getter, scriptable);
                }
                nativeObject.defineProperty(PasskeyWebListener.GET_UNIQUE_KEY, functionObject2, 0);
            }
            Object obj2 = this.setter;
            if (obj2 != null) {
                if (obj2 instanceof MemberBox) {
                    functionObject = new FunctionObject(string, ((MemberBox) this.setter).member(), scriptable);
                } else if (obj2 instanceof Member) {
                    functionObject = new FunctionObject(string, (Member) this.setter, scriptable);
                } else {
                    nativeObject.defineProperty("set", obj2, 0);
                }
                nativeObject.defineProperty("set", functionObject, 0);
                return nativeObject;
            }
            return nativeObject;
        }

        @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject.Slot
        Object getValue(Scriptable scriptable) {
            Object obj;
            Object[] objArr;
            Object obj2 = this.getter;
            if (obj2 != null) {
                if (obj2 instanceof MemberBox) {
                    MemberBox memberBox = (MemberBox) obj2;
                    Object obj3 = memberBox.delegateTo;
                    if (obj3 == null) {
                        objArr = ScriptRuntime.emptyArgs;
                        obj = scriptable;
                    } else {
                        Object[] objArr2 = {scriptable};
                        obj = obj3;
                        objArr = objArr2;
                    }
                    return memberBox.invoke(obj, objArr);
                }
                if (obj2 instanceof Function) {
                    Function function = (Function) obj2;
                    return function.call(Context.getContext(), function.getParentScope(), scriptable, ScriptRuntime.emptyArgs);
                }
            }
            Object obj4 = this.value;
            if (!(obj4 instanceof LazilyLoadedCtor)) {
                return obj4;
            }
            LazilyLoadedCtor lazilyLoadedCtor = (LazilyLoadedCtor) obj4;
            try {
                lazilyLoadedCtor.init();
                return lazilyLoadedCtor.getValue();
            } finally {
                this.value = lazilyLoadedCtor.getValue();
            }
        }

        @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject.Slot
        boolean setValue(Object obj, Scriptable scriptable, Scriptable scriptable2) {
            Object obj2;
            Object[] objArr;
            if (this.setter == null) {
                if (this.getter == null) {
                    return super.setValue(obj, scriptable, scriptable2);
                }
                Context context = Context.getContext();
                if (context.isStrictMode() || context.hasFeature(11)) {
                    throw ScriptRuntime.typeError2("msg.set.prop.no.setter", this.name != null ? "[" + scriptable2.getClassName() + "]." + this.name : "", Context.toString(obj));
                }
                return true;
            }
            Context context2 = Context.getContext();
            Object obj3 = this.setter;
            if (obj3 instanceof MemberBox) {
                MemberBox memberBox = (MemberBox) obj3;
                Class<?>[] clsArr = memberBox.argTypes;
                Object objConvertArg = FunctionObject.convertArg(context2, scriptable2, obj, FunctionObject.getTypeTag(clsArr[clsArr.length - 1]));
                Object obj4 = memberBox.delegateTo;
                if (obj4 == null) {
                    objArr = new Object[]{objConvertArg};
                    obj2 = scriptable2;
                } else {
                    Object[] objArr2 = {scriptable2, objConvertArg};
                    obj2 = obj4;
                    objArr = objArr2;
                }
                memberBox.invoke(obj2, objArr);
            } else if (obj3 instanceof Function) {
                Function function = (Function) obj3;
                function.call(context2, function.getParentScope(), scriptable2, new Object[]{obj});
            }
            return true;
        }
    }

    public static final class KeyComparator implements Comparator<Object>, Serializable {
        private static final long serialVersionUID = 6411335891523988149L;

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            int iIntValue;
            int iIntValue2;
            if (!(obj instanceof Integer)) {
                return obj2 instanceof Integer ? 1 : 0;
            }
            if (!(obj2 instanceof Integer) || (iIntValue = ((Integer) obj).intValue()) < (iIntValue2 = ((Integer) obj2).intValue())) {
                return -1;
            }
            return iIntValue > iIntValue2 ? 1 : 0;
        }
    }

    static class Slot implements Serializable {
        private static final long serialVersionUID = -6090581677123995491L;
        private short attributes;
        int indexOrHash;
        Object name;
        transient Slot next;
        transient Slot orderedNext;
        Object value;

        Slot(Object obj, int i, int i2) {
            this.name = obj;
            this.indexOrHash = i;
            this.attributes = (short) i2;
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            Object obj = this.name;
            if (obj != null) {
                this.indexOrHash = obj.hashCode();
            }
        }

        int getAttributes() {
            return this.attributes;
        }

        ScriptableObject getPropertyDescriptor(Context context, Scriptable scriptable) {
            return ScriptableObject.buildDataDescriptor(scriptable, this.value, this.attributes);
        }

        Object getValue(Scriptable scriptable) {
            return this.value;
        }

        synchronized void setAttributes(int i) {
            ScriptableObject.checkValidAttributes(i);
            this.attributes = (short) i;
        }

        boolean setValue(Object obj, Scriptable scriptable, Scriptable scriptable2) {
            if ((this.attributes & 1) != 0) {
                if (Context.getContext().isStrictMode()) {
                    throw ScriptRuntime.typeError1("msg.modify.readonly", this.name);
                }
                return true;
            }
            if (scriptable != scriptable2) {
                return false;
            }
            this.value = obj;
            return true;
        }
    }

    enum SlotAccess {
        QUERY,
        MODIFY,
        MODIFY_CONST,
        MODIFY_GETTER_SETTER,
        CONVERT_ACCESSOR_TO_DATA
    }

    static {
        try {
            GET_ARRAY_LENGTH = ScriptableObject.class.getMethod("getExternalArrayLength", new Class[0]);
            KEY_COMPARATOR = new KeyComparator();
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public ScriptableObject() {
        this.isExtensible = true;
        this.isSealed = false;
        this.slotMap = createSlotMap(0);
    }

    /* JADX WARN: Code duplicated, block: B:104:0x019b  */
    /* JADX WARN: Code duplicated, block: B:108:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:113:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:115:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:117:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:118:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:120:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:121:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:124:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:127:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:130:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:132:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:133:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:135:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:136:0x0201  */
    /* JADX WARN: Code duplicated, block: B:139:0x0208 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:142:0x020e  */
    /* JADX WARN: Code duplicated, block: B:144:0x0212  */
    /* JADX WARN: Code duplicated, block: B:145:0x0215  */
    /* JADX WARN: Code duplicated, block: B:148:0x0222  */
    /* JADX WARN: Code duplicated, block: B:150:0x0229 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:168:0x0268  */
    /* JADX WARN: Code duplicated, block: B:170:0x026e  */
    /* JADX WARN: Code duplicated, block: B:172:0x0277  */
    /* JADX WARN: Code duplicated, block: B:173:0x027a  */
    /* JADX WARN: Code duplicated, block: B:200:0x02aa A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:203:0x0299 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:58:0x00e6  */
    static <T extends Scriptable> BaseFunction buildClassCtor(Scriptable scriptable, Class<T> cls, boolean z, boolean z2) throws IllegalAccessException, InvocationTargetException {
        Constructor<?> constructor;
        Class<T> cls2;
        Scriptable objectPrototype;
        Member member;
        Member member2;
        Annotation annotation;
        GenericDeclaration genericDeclaration;
        String str;
        int i;
        HashSet hashSet;
        String propertyName;
        Method methodFindSetterMethod;
        int i2;
        Member member3;
        Constructor<?> constructor2;
        Method methodFindSingleMethod;
        String strDefineClass;
        BaseFunction baseFunction;
        Object prototypeProperty;
        Method[] methodList = FunctionObject.getMethodList(cls);
        int i3 = 0;
        while (true) {
            int i4 = 3;
            int i5 = 2;
            int i6 = 1;
            if (i3 >= methodList.length) {
                Constructor<?>[] constructors = cls.getConstructors();
                int i7 = 0;
                while (true) {
                    if (i7 >= constructors.length) {
                        constructor = null;
                        break;
                    }
                    if (constructors[i7].getParameterTypes().length == 0) {
                        constructor = constructors[i7];
                        break;
                    }
                    i7++;
                }
                if (constructor == null) {
                    throw Context.reportRuntimeError1("msg.zero.arg.ctor", cls.getName());
                }
                Scriptable scriptable2 = (Scriptable) constructor.newInstance(ScriptRuntime.emptyArgs);
                String className = scriptable2.getClassName();
                Object property = getProperty(getTopLevelScope(scriptable), className);
                if (!(property instanceof BaseFunction) || (prototypeProperty = (baseFunction = (BaseFunction) property).getPrototypeProperty()) == null) {
                    cls2 = cls;
                } else {
                    cls2 = cls;
                    if (cls2.equals(prototypeProperty.getClass())) {
                        return baseFunction;
                    }
                }
                if (z2) {
                    Class<? super T> superclass = cls2.getSuperclass();
                    if (!ScriptRuntime.ScriptableClass.isAssignableFrom(superclass) || Modifier.isAbstract(superclass.getModifiers()) || (strDefineClass = defineClass(scriptable, extendsScriptable(superclass), z, z2)) == null) {
                        objectPrototype = null;
                    } else {
                        objectPrototype = getClassPrototype(scriptable, strDefineClass);
                    }
                } else {
                    objectPrototype = null;
                }
                if (objectPrototype == null) {
                    objectPrototype = getObjectPrototype(scriptable);
                }
                scriptable2.setPrototype(objectPrototype);
                Member memberFindAnnotatedMember = findAnnotatedMember(methodList, JSConstructor.class);
                Member memberFindAnnotatedMember2 = memberFindAnnotatedMember;
                if (memberFindAnnotatedMember == null) {
                    memberFindAnnotatedMember2 = findAnnotatedMember(constructors, JSConstructor.class);
                }
                Member member4 = memberFindAnnotatedMember2;
                if (memberFindAnnotatedMember2 == null) {
                    methodFindSingleMethod = FunctionObject.findSingleMethod(methodList, "jsConstructor");
                }
                if (member4 == null) {
                    if (constructors.length == 1) {
                        constructor2 = constructors[0];
                    } else if (constructors.length == 2) {
                        if (constructors[0].getParameterTypes().length == 0) {
                            member4 = methodFindSingleMethod;
                            member4 = member4;
                            member4 = constructors[1];
                        } else if (constructors[1].getParameterTypes().length == 0) {
                            member4 = methodFindSingleMethod;
                            member4 = member4;
                            member4 = member4;
                            member4 = constructors[0];
                        }
                    }
                    if (member4 == null) {
                        member4 = methodFindSingleMethod;
                        member4 = constructor2;
                        throw Context.reportRuntimeError1("msg.ctor.multiple.parms", cls2.getName());
                    }
                }
                member4 = methodFindSingleMethod;
                member4 = constructor2;
                member4 = methodFindSingleMethod;
                FunctionObject functionObject = new FunctionObject(className, member4, scriptable);
                if (functionObject.isVarArgsMethod()) {
                    throw Context.reportRuntimeError1("msg.varargs.ctor", member4.getName());
                }
                functionObject.initAsConstructor(scriptable, scriptable2);
                HashSet hashSet2 = new HashSet();
                HashSet hashSet3 = new HashSet();
                int length = methodList.length;
                int i8 = 0;
                Method method = null;
                while (i8 < length) {
                    int i9 = i6;
                    Method method2 = methodList[i8];
                    if (method2 == member) {
                        member = member4;
                        member2 = member;
                        hashSet2 = hashSet2;
                    } else {
                        String name = method2.getName();
                        int i10 = i5;
                        if (name.equals("finishInit")) {
                            Class<?>[] parameterTypes = method2.getParameterTypes();
                            if (parameterTypes.length == i4) {
                                Class<?> cls3 = parameterTypes[0];
                                Class<Scriptable> cls4 = ScriptRuntime.ScriptableClass;
                                if (cls3 == cls4) {
                                    member3 = member;
                                    if (parameterTypes[i9] == FunctionObject.class && parameterTypes[i10] == cls4 && Modifier.isStatic(method2.getModifiers())) {
                                        member = member4;
                                        member2 = member3;
                                        member2 = member3;
                                        member2 = member3;
                                        method = method2;
                                        member2 = member3;
                                    }
                                } else {
                                    member = member4;
                                    member = member4;
                                    member = member4;
                                    member2 = member;
                                }
                                member = member4;
                                member2 = member3;
                                member2 = member3;
                                member2 = member3;
                                member = member4;
                                member2 = member3;
                                member2 = member3;
                                member = member4;
                                member2 = member3;
                                member2 = member2;
                                if (name.indexOf(36) != -1 && !name.equals("jsConstructor")) {
                                    if (method2.isAnnotationPresent(JSFunction.class)) {
                                        member2 = member2;
                                        genericDeclaration = JSFunction.class;
                                    } else if (method2.isAnnotationPresent(JSStaticFunction.class)) {
                                        member2 = member2;
                                        genericDeclaration = JSStaticFunction.class;
                                    } else if (method2.isAnnotationPresent(JSGetter.class)) {
                                        member2 = member2;
                                        genericDeclaration = JSGetter.class;
                                    } else if (!method2.isAnnotationPresent(JSSetter.class)) {
                                        member2 = member2;
                                        member2 = member2;
                                        annotation = null;
                                        if (annotation == null) {
                                            str = "jsFunction_";
                                            if (!name.startsWith("jsFunction_")) {
                                                if (name.startsWith("jsStaticFunction_")) {
                                                    str = "jsStaticFunction_";
                                                } else if (name.startsWith("jsGet_")) {
                                                    member2 = member2;
                                                    str = "jsGet_";
                                                }
                                            }
                                        } else {
                                            str = null;
                                        }
                                        if (!(annotation instanceof JSStaticFunction) || str == "jsStaticFunction_") {
                                            i = i9;
                                        } else {
                                            i = 0;
                                        }
                                        if (i != 0) {
                                            hashSet = hashSet2;
                                        } else {
                                            hashSet = hashSet3;
                                        }
                                        int i11 = i;
                                        propertyName = getPropertyName(name, str, annotation);
                                        if (!hashSet.contains(propertyName)) {
                                            throw Context.reportRuntimeError2("duplicate.defineClass.name", name, propertyName);
                                        }
                                        hashSet.add(propertyName);
                                        if (!(annotation instanceof JSGetter) || str == "jsGet_") {
                                            i5 = i10;
                                            if (!(scriptable2 instanceof ScriptableObject)) {
                                                throw Context.reportRuntimeError2("msg.extend.scriptable", scriptable2.getClass().toString(), propertyName);
                                            }
                                            methodFindSetterMethod = findSetterMethod(methodList, propertyName, "jsSet_");
                                            if (methodFindSetterMethod != null) {
                                                i2 = 0;
                                            } else {
                                                i2 = i9;
                                            }
                                            ((ScriptableObject) scriptable2).defineProperty(propertyName, null, method2, methodFindSetterMethod, i2 | 6);
                                        } else {
                                            if (i11 != 0 && !Modifier.isStatic(method2.getModifiers())) {
                                                throw Context.reportRuntimeError("jsStaticFunction must be used with static method.");
                                            }
                                            FunctionObject functionObject2 = new FunctionObject(propertyName, method2, scriptable2);
                                            if (functionObject2.isVarArgsConstructor()) {
                                                throw Context.reportRuntimeError1("msg.varargs.fun", member2.getName());
                                            }
                                            i5 = i10;
                                            defineProperty(i11 != 0 ? functionObject : scriptable2, propertyName, functionObject2, i5);
                                            if (z) {
                                                functionObject2.sealObject();
                                            }
                                        }
                                    }
                                    annotation = method2.getAnnotation(genericDeclaration);
                                    if (annotation == null) {
                                        str = "jsFunction_";
                                        if (!name.startsWith("jsFunction_")) {
                                            if (name.startsWith("jsStaticFunction_")) {
                                                str = "jsStaticFunction_";
                                            } else if (name.startsWith("jsGet_")) {
                                                member2 = member2;
                                                str = "jsGet_";
                                            }
                                        }
                                    } else {
                                        str = null;
                                    }
                                    if (annotation instanceof JSStaticFunction) {
                                        i = i9;
                                    } else {
                                        i = i9;
                                    }
                                    if (i != 0) {
                                        hashSet = hashSet2;
                                    } else {
                                        hashSet = hashSet3;
                                    }
                                    int i12 = i;
                                    propertyName = getPropertyName(name, str, annotation);
                                    if (!hashSet.contains(propertyName)) {
                                        throw Context.reportRuntimeError2("duplicate.defineClass.name", name, propertyName);
                                    }
                                    hashSet.add(propertyName);
                                    if (annotation instanceof JSGetter) {
                                        i5 = i10;
                                        if (!(scriptable2 instanceof ScriptableObject)) {
                                            throw Context.reportRuntimeError2("msg.extend.scriptable", scriptable2.getClass().toString(), propertyName);
                                        }
                                        methodFindSetterMethod = findSetterMethod(methodList, propertyName, "jsSet_");
                                        if (methodFindSetterMethod != null) {
                                            i2 = 0;
                                        } else {
                                            i2 = i9;
                                        }
                                        ((ScriptableObject) scriptable2).defineProperty(propertyName, null, method2, methodFindSetterMethod, i2 | 6);
                                    } else {
                                        i5 = i10;
                                        if (!(scriptable2 instanceof ScriptableObject)) {
                                            throw Context.reportRuntimeError2("msg.extend.scriptable", scriptable2.getClass().toString(), propertyName);
                                        }
                                        methodFindSetterMethod = findSetterMethod(methodList, propertyName, "jsSet_");
                                        if (methodFindSetterMethod != null) {
                                            i2 = 0;
                                        } else {
                                            i2 = i9;
                                        }
                                        ((ScriptableObject) scriptable2).defineProperty(propertyName, null, method2, methodFindSetterMethod, i2 | 6);
                                    }
                                }
                            } else {
                                member = member4;
                                member = member4;
                                member = member4;
                                member2 = member;
                                member = member4;
                                member2 = member3;
                                member2 = member3;
                                member2 = member3;
                                member = member4;
                                member2 = member3;
                                member2 = member3;
                                member = member4;
                                member2 = member3;
                                member2 = member2;
                                if (name.indexOf(36) != -1) {
                                    if (method2.isAnnotationPresent(JSFunction.class)) {
                                        member2 = member2;
                                        genericDeclaration = JSFunction.class;
                                    } else if (method2.isAnnotationPresent(JSStaticFunction.class)) {
                                        member2 = member2;
                                        genericDeclaration = JSStaticFunction.class;
                                    } else if (method2.isAnnotationPresent(JSGetter.class)) {
                                        member2 = member2;
                                        genericDeclaration = JSGetter.class;
                                    } else if (!method2.isAnnotationPresent(JSSetter.class)) {
                                        member2 = member2;
                                        member2 = member2;
                                        annotation = null;
                                        if (annotation == null) {
                                            str = "jsFunction_";
                                            if (!name.startsWith("jsFunction_")) {
                                                if (name.startsWith("jsStaticFunction_")) {
                                                    str = "jsStaticFunction_";
                                                } else if (name.startsWith("jsGet_")) {
                                                    member2 = member2;
                                                    str = "jsGet_";
                                                }
                                            }
                                        } else {
                                            str = null;
                                        }
                                        if (annotation instanceof JSStaticFunction) {
                                            i = i9;
                                        } else {
                                            i = i9;
                                        }
                                        if (i != 0) {
                                            hashSet = hashSet2;
                                        } else {
                                            hashSet = hashSet3;
                                        }
                                        int i13 = i;
                                        propertyName = getPropertyName(name, str, annotation);
                                        if (!hashSet.contains(propertyName)) {
                                            throw Context.reportRuntimeError2("duplicate.defineClass.name", name, propertyName);
                                        }
                                        hashSet.add(propertyName);
                                        if (annotation instanceof JSGetter) {
                                            i5 = i10;
                                            if (!(scriptable2 instanceof ScriptableObject)) {
                                                throw Context.reportRuntimeError2("msg.extend.scriptable", scriptable2.getClass().toString(), propertyName);
                                            }
                                            methodFindSetterMethod = findSetterMethod(methodList, propertyName, "jsSet_");
                                            if (methodFindSetterMethod != null) {
                                                i2 = 0;
                                            } else {
                                                i2 = i9;
                                            }
                                            ((ScriptableObject) scriptable2).defineProperty(propertyName, null, method2, methodFindSetterMethod, i2 | 6);
                                        } else {
                                            i5 = i10;
                                            if (!(scriptable2 instanceof ScriptableObject)) {
                                                throw Context.reportRuntimeError2("msg.extend.scriptable", scriptable2.getClass().toString(), propertyName);
                                            }
                                            methodFindSetterMethod = findSetterMethod(methodList, propertyName, "jsSet_");
                                            if (methodFindSetterMethod != null) {
                                                i2 = 0;
                                            } else {
                                                i2 = i9;
                                            }
                                            ((ScriptableObject) scriptable2).defineProperty(propertyName, null, method2, methodFindSetterMethod, i2 | 6);
                                        }
                                    }
                                    annotation = method2.getAnnotation(genericDeclaration);
                                    if (annotation == null) {
                                        str = "jsFunction_";
                                        if (!name.startsWith("jsFunction_")) {
                                            if (name.startsWith("jsStaticFunction_")) {
                                                str = "jsStaticFunction_";
                                            } else if (name.startsWith("jsGet_")) {
                                                member2 = member2;
                                                str = "jsGet_";
                                            }
                                        }
                                    } else {
                                        str = null;
                                    }
                                    if (annotation instanceof JSStaticFunction) {
                                        i = i9;
                                    } else {
                                        i = i9;
                                    }
                                    if (i != 0) {
                                        hashSet = hashSet2;
                                    } else {
                                        hashSet = hashSet3;
                                    }
                                    int i14 = i;
                                    propertyName = getPropertyName(name, str, annotation);
                                    if (!hashSet.contains(propertyName)) {
                                        throw Context.reportRuntimeError2("duplicate.defineClass.name", name, propertyName);
                                    }
                                    hashSet.add(propertyName);
                                    if (annotation instanceof JSGetter) {
                                        i5 = i10;
                                        if (!(scriptable2 instanceof ScriptableObject)) {
                                            throw Context.reportRuntimeError2("msg.extend.scriptable", scriptable2.getClass().toString(), propertyName);
                                        }
                                        methodFindSetterMethod = findSetterMethod(methodList, propertyName, "jsSet_");
                                        if (methodFindSetterMethod != null) {
                                            i2 = 0;
                                        } else {
                                            i2 = i9;
                                        }
                                        ((ScriptableObject) scriptable2).defineProperty(propertyName, null, method2, methodFindSetterMethod, i2 | 6);
                                    } else {
                                        i5 = i10;
                                        if (!(scriptable2 instanceof ScriptableObject)) {
                                            throw Context.reportRuntimeError2("msg.extend.scriptable", scriptable2.getClass().toString(), propertyName);
                                        }
                                        methodFindSetterMethod = findSetterMethod(methodList, propertyName, "jsSet_");
                                        if (methodFindSetterMethod != null) {
                                            i2 = 0;
                                        } else {
                                            i2 = i9;
                                        }
                                        ((ScriptableObject) scriptable2).defineProperty(propertyName, null, method2, methodFindSetterMethod, i2 | 6);
                                    }
                                }
                            }
                        } else {
                            member = member4;
                            member = member4;
                            member = member4;
                            member2 = member;
                            member = member4;
                            member2 = member3;
                            member2 = member3;
                            member2 = member3;
                            member = member4;
                            member2 = member3;
                            member2 = member3;
                            member = member4;
                            member2 = member3;
                            member2 = member2;
                            if (name.indexOf(36) != -1) {
                                if (method2.isAnnotationPresent(JSFunction.class)) {
                                    member2 = member2;
                                    genericDeclaration = JSFunction.class;
                                } else if (method2.isAnnotationPresent(JSStaticFunction.class)) {
                                    member2 = member2;
                                    genericDeclaration = JSStaticFunction.class;
                                } else if (method2.isAnnotationPresent(JSGetter.class)) {
                                    member2 = member2;
                                    genericDeclaration = JSGetter.class;
                                } else if (!method2.isAnnotationPresent(JSSetter.class)) {
                                    member2 = member2;
                                    member2 = member2;
                                    annotation = null;
                                    if (annotation == null) {
                                        str = "jsFunction_";
                                        if (!name.startsWith("jsFunction_")) {
                                            if (name.startsWith("jsStaticFunction_")) {
                                                str = "jsStaticFunction_";
                                            } else if (name.startsWith("jsGet_")) {
                                                member2 = member2;
                                                str = "jsGet_";
                                            }
                                        }
                                    } else {
                                        str = null;
                                    }
                                    if (annotation instanceof JSStaticFunction) {
                                        i = i9;
                                    } else {
                                        i = i9;
                                    }
                                    if (i != 0) {
                                        hashSet = hashSet2;
                                    } else {
                                        hashSet = hashSet3;
                                    }
                                    int i15 = i;
                                    propertyName = getPropertyName(name, str, annotation);
                                    if (!hashSet.contains(propertyName)) {
                                        throw Context.reportRuntimeError2("duplicate.defineClass.name", name, propertyName);
                                    }
                                    hashSet.add(propertyName);
                                    if (annotation instanceof JSGetter) {
                                        i5 = i10;
                                        if (!(scriptable2 instanceof ScriptableObject)) {
                                            throw Context.reportRuntimeError2("msg.extend.scriptable", scriptable2.getClass().toString(), propertyName);
                                        }
                                        methodFindSetterMethod = findSetterMethod(methodList, propertyName, "jsSet_");
                                        if (methodFindSetterMethod != null) {
                                            i2 = 0;
                                        } else {
                                            i2 = i9;
                                        }
                                        ((ScriptableObject) scriptable2).defineProperty(propertyName, null, method2, methodFindSetterMethod, i2 | 6);
                                    } else {
                                        i5 = i10;
                                        if (!(scriptable2 instanceof ScriptableObject)) {
                                            throw Context.reportRuntimeError2("msg.extend.scriptable", scriptable2.getClass().toString(), propertyName);
                                        }
                                        methodFindSetterMethod = findSetterMethod(methodList, propertyName, "jsSet_");
                                        if (methodFindSetterMethod != null) {
                                            i2 = 0;
                                        } else {
                                            i2 = i9;
                                        }
                                        ((ScriptableObject) scriptable2).defineProperty(propertyName, null, method2, methodFindSetterMethod, i2 | 6);
                                    }
                                }
                                annotation = method2.getAnnotation(genericDeclaration);
                                if (annotation == null) {
                                    str = "jsFunction_";
                                    if (!name.startsWith("jsFunction_")) {
                                        if (name.startsWith("jsStaticFunction_")) {
                                            str = "jsStaticFunction_";
                                        } else if (name.startsWith("jsGet_")) {
                                            member2 = member2;
                                            str = "jsGet_";
                                        }
                                    }
                                } else {
                                    str = null;
                                }
                                if (annotation instanceof JSStaticFunction) {
                                    i = i9;
                                } else {
                                    i = i9;
                                }
                                if (i != 0) {
                                    hashSet = hashSet2;
                                } else {
                                    hashSet = hashSet3;
                                }
                                int i16 = i;
                                propertyName = getPropertyName(name, str, annotation);
                                if (!hashSet.contains(propertyName)) {
                                    throw Context.reportRuntimeError2("duplicate.defineClass.name", name, propertyName);
                                }
                                hashSet.add(propertyName);
                                if (annotation instanceof JSGetter) {
                                    i5 = i10;
                                    if (!(scriptable2 instanceof ScriptableObject)) {
                                        throw Context.reportRuntimeError2("msg.extend.scriptable", scriptable2.getClass().toString(), propertyName);
                                    }
                                    methodFindSetterMethod = findSetterMethod(methodList, propertyName, "jsSet_");
                                    if (methodFindSetterMethod != null) {
                                        i2 = 0;
                                    } else {
                                        i2 = i9;
                                    }
                                    ((ScriptableObject) scriptable2).defineProperty(propertyName, null, method2, methodFindSetterMethod, i2 | 6);
                                } else {
                                    i5 = i10;
                                    if (!(scriptable2 instanceof ScriptableObject)) {
                                        throw Context.reportRuntimeError2("msg.extend.scriptable", scriptable2.getClass().toString(), propertyName);
                                    }
                                    methodFindSetterMethod = findSetterMethod(methodList, propertyName, "jsSet_");
                                    if (methodFindSetterMethod != null) {
                                        i2 = 0;
                                    } else {
                                        i2 = i9;
                                    }
                                    ((ScriptableObject) scriptable2).defineProperty(propertyName, null, method2, methodFindSetterMethod, i2 | 6);
                                }
                            }
                        }
                        member2 = member2;
                        member2 = member2;
                        member2 = member2;
                        member2 = member2;
                        hashSet2 = hashSet2;
                        i5 = i10;
                    }
                    i8++;
                    member = member2;
                    hashSet2 = hashSet2;
                    i6 = i9;
                    i4 = 3;
                }
                if (method != null) {
                    member = member4;
                    method.invoke(null, scriptable, functionObject, scriptable2);
                }
                if (z) {
                    functionObject.sealObject();
                    if (scriptable2 instanceof ScriptableObject) {
                        ((ScriptableObject) scriptable2).sealObject();
                    }
                }
                return functionObject;
            }
            Method method3 = methodList[i3];
            if (method3.getName().equals("init")) {
                Class<?>[] parameterTypes2 = method3.getParameterTypes();
                if (parameterTypes2.length == 3 && parameterTypes2[0] == ScriptRuntime.ContextClass && parameterTypes2[1] == ScriptRuntime.ScriptableClass && parameterTypes2[2] == Boolean.TYPE && Modifier.isStatic(method3.getModifiers())) {
                    method3.invoke(null, Context.getContext(), scriptable, z ? Boolean.TRUE : Boolean.FALSE);
                    return null;
                }
                if (parameterTypes2.length == 1 && parameterTypes2[0] == ScriptRuntime.ScriptableClass && Modifier.isStatic(method3.getModifiers())) {
                    method3.invoke(null, scriptable);
                    return null;
                }
            }
            i3++;
        }
    }

    protected static ScriptableObject buildDataDescriptor(Scriptable scriptable, Object obj, int i) {
        NativeObject nativeObject = new NativeObject();
        ScriptRuntime.setBuiltinProtoAndParent(nativeObject, scriptable, TopLevel.Builtins.Object);
        nativeObject.defineProperty("value", obj, 0);
        nativeObject.defineProperty("writable", Boolean.valueOf((i & 1) == 0), 0);
        nativeObject.defineProperty("enumerable", Boolean.valueOf((i & 2) == 0), 0);
        nativeObject.defineProperty("configurable", Boolean.valueOf((i & 4) == 0), 0);
        return nativeObject;
    }

    public static Object callMethod(Context context, Scriptable scriptable, String str, Object[] objArr) {
        Object property = getProperty(scriptable, str);
        if (!(property instanceof Function)) {
            throw ScriptRuntime.notFunctionError(scriptable, str);
        }
        Function function = (Function) property;
        Scriptable topLevelScope = getTopLevelScope(scriptable);
        return context != null ? function.call(context, topLevelScope, scriptable, objArr) : Context.call(null, function, topLevelScope, scriptable, objArr);
    }

    private void checkNotSealed(Object obj, int i) {
        if (isSealed()) {
            throw Context.reportRuntimeError1("msg.modify.sealed", obj != null ? obj.toString() : Integer.toString(i));
        }
    }

    static void checkValidAttributes(int i) {
        if ((i & (-16)) != 0) {
            throw new IllegalArgumentException(String.valueOf(i));
        }
    }

    private static SlotMapContainer createSlotMap(int i) {
        Context currentContext = Context.getCurrentContext();
        return (currentContext == null || !currentContext.hasFeature(17)) ? new SlotMapContainer(i) : new ThreadSafeSlotMapContainer(i);
    }

    public static <T extends Scriptable> String defineClass(Scriptable scriptable, Class<T> cls, boolean z, boolean z2) throws IllegalAccessException, InvocationTargetException {
        BaseFunction baseFunctionBuildClassCtor = buildClassCtor(scriptable, cls, z, z2);
        if (baseFunctionBuildClassCtor == null) {
            return null;
        }
        String className = baseFunctionBuildClassCtor.getClassPrototype().getClassName();
        defineProperty(scriptable, className, baseFunctionBuildClassCtor, 2);
        return className;
    }

    public static void defineConstProperty(Scriptable scriptable, String str) {
        if (scriptable instanceof ConstProperties) {
            ((ConstProperties) scriptable).defineConst(str, scriptable);
        } else {
            defineProperty(scriptable, str, Undefined.instance, 13);
        }
    }

    public static void defineProperty(Scriptable scriptable, String str, Object obj, int i) {
        if (scriptable instanceof ScriptableObject) {
            ((ScriptableObject) scriptable).defineProperty(str, obj, i);
        } else {
            scriptable.put(str, scriptable, obj);
        }
    }

    public static boolean deleteProperty(Scriptable scriptable, int i) {
        Scriptable base = getBase(scriptable, i);
        if (base == null) {
            return true;
        }
        base.delete(i);
        return !base.has(i, scriptable);
    }

    protected static Scriptable ensureScriptable(Object obj) {
        if (obj instanceof Scriptable) {
            return (Scriptable) obj;
        }
        throw ScriptRuntime.typeError1("msg.arg.not.object", ScriptRuntime.typeof(obj));
    }

    protected static ScriptableObject ensureScriptableObject(Object obj) {
        if (obj instanceof ScriptableObject) {
            return (ScriptableObject) obj;
        }
        throw ScriptRuntime.typeError1("msg.arg.not.object", ScriptRuntime.typeof(obj));
    }

    protected static SymbolScriptable ensureSymbolScriptable(Object obj) {
        if (obj instanceof SymbolScriptable) {
            return (SymbolScriptable) obj;
        }
        throw ScriptRuntime.typeError1("msg.object.not.symbolscriptable", ScriptRuntime.typeof(obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T extends Scriptable> Class<T> extendsScriptable(Class<?> cls) {
        if (ScriptRuntime.ScriptableClass.isAssignableFrom(cls)) {
            return cls;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Member findAnnotatedMember(AccessibleObject[] accessibleObjectArr, Class<? extends Annotation> cls) {
        for (Method method : accessibleObjectArr) {
            if (method.isAnnotationPresent(cls)) {
                return method;
            }
        }
        return null;
    }

    private Slot findAttributeSlot(Symbol symbol, SlotAccess slotAccess) {
        Slot slot = this.slotMap.get(symbol, 0, slotAccess);
        if (slot != null) {
            return slot;
        }
        throw Context.reportRuntimeError1("msg.prop.not.found", symbol);
    }

    private static Method findSetterMethod(Method[] methodArr, String str, String str2) {
        String str3 = "set" + Character.toUpperCase(str.charAt(0)) + str.substring(1);
        for (Method method : methodArr) {
            JSSetter jSSetter = (JSSetter) method.getAnnotation(JSSetter.class);
            if (jSSetter != null && (str.equals(jSSetter.value()) || ("".equals(jSSetter.value()) && str3.equals(method.getName())))) {
                return method;
            }
        }
        String str4 = str2 + str;
        for (Method method2 : methodArr) {
            if (str4.equals(method2.getName())) {
                return method2;
            }
        }
        return null;
    }

    public static Scriptable getArrayPrototype(Scriptable scriptable) {
        return TopLevel.getBuiltinPrototype(getTopLevelScope(scriptable), TopLevel.Builtins.Array);
    }

    private static Scriptable getBase(Scriptable scriptable, int i) {
        while (!scriptable.has(i, scriptable)) {
            scriptable = scriptable.getPrototype();
            if (scriptable == null) {
                return scriptable;
            }
        }
        return scriptable;
    }

    public static Scriptable getClassPrototype(Scriptable scriptable, String str) {
        Object prototypeProperty;
        Object property = getProperty(getTopLevelScope(scriptable), str);
        if (!(property instanceof BaseFunction)) {
            if (property instanceof Scriptable) {
                Scriptable scriptable2 = (Scriptable) property;
                prototypeProperty = scriptable2.get("prototype", scriptable2);
            }
            return null;
        }
        prototypeProperty = ((BaseFunction) property).getPrototypeProperty();
        if (prototypeProperty instanceof Scriptable) {
            return (Scriptable) prototypeProperty;
        }
        return null;
    }

    public static Object getDefaultValue(Scriptable scriptable, Class<?> cls) {
        Context context = null;
        for (int i = 0; i < 2; i++) {
            boolean z = true;
            if (cls != ScriptRuntime.StringClass ? i != 1 : i != 0) {
                z = false;
            }
            Object property = getProperty(scriptable, z ? "toString" : "valueOf");
            if (property instanceof Function) {
                Function function = (Function) property;
                if (context == null) {
                    context = Context.getContext();
                }
                Object objCall = function.call(context, function.getParentScope(), scriptable, ScriptRuntime.emptyArgs);
                if (objCall != null) {
                    if ((objCall instanceof Scriptable) && cls != ScriptRuntime.ScriptableClass && cls != ScriptRuntime.FunctionClass) {
                        if (z && (objCall instanceof Wrapper)) {
                            objCall = ((Wrapper) objCall).unwrap();
                            if (objCall instanceof String) {
                            }
                        }
                    }
                    return objCall;
                }
                continue;
            }
        }
        throw ScriptRuntime.typeError1("msg.default.value", cls == null ? "undefined" : cls.getName());
    }

    public static Scriptable getFunctionPrototype(Scriptable scriptable) {
        return TopLevel.getBuiltinPrototype(getTopLevelScope(scriptable), TopLevel.Builtins.Function);
    }

    public static Scriptable getGeneratorFunctionPrototype(Scriptable scriptable) {
        return TopLevel.getBuiltinPrototype(getTopLevelScope(scriptable), TopLevel.Builtins.GeneratorFunction);
    }

    public static Scriptable getObjectPrototype(Scriptable scriptable) {
        return TopLevel.getBuiltinPrototype(getTopLevelScope(scriptable), TopLevel.Builtins.Object);
    }

    public static Object getProperty(Scriptable scriptable, int i) {
        Object obj;
        Scriptable prototype = scriptable;
        do {
            obj = prototype.get(i, scriptable);
            if (obj != Scriptable.NOT_FOUND) {
                break;
            }
            prototype = prototype.getPrototype();
        } while (prototype != null);
        return obj;
    }

    public static Object[] getPropertyIds(Scriptable scriptable) {
        if (scriptable == null) {
            return ScriptRuntime.emptyArgs;
        }
        Object[] ids = scriptable.getIds();
        ObjToIntMap objToIntMap = null;
        while (true) {
            scriptable = scriptable.getPrototype();
            if (scriptable == null) {
                break;
            }
            Object[] ids2 = scriptable.getIds();
            if (ids2.length != 0) {
                if (objToIntMap == null) {
                    if (ids.length == 0) {
                        ids = ids2;
                    } else {
                        objToIntMap = new ObjToIntMap(ids.length + ids2.length);
                        for (int i = 0; i != ids.length; i++) {
                            objToIntMap.intern(ids[i]);
                        }
                        ids = null;
                    }
                }
                for (int i2 = 0; i2 != ids2.length; i2++) {
                    objToIntMap.intern(ids2[i2]);
                }
            }
        }
        return objToIntMap != null ? objToIntMap.getKeys() : ids;
    }

    private static String getPropertyName(String str, String str2, Annotation annotation) {
        String strValue;
        if (str2 != null) {
            return str.substring(str2.length());
        }
        if (annotation instanceof JSGetter) {
            strValue = ((JSGetter) annotation).value();
            if ((strValue == null || strValue.length() == 0) && str.length() > 3 && str.startsWith(PasskeyWebListener.GET_UNIQUE_KEY)) {
                strValue = str.substring(3);
                if (Character.isUpperCase(strValue.charAt(0))) {
                    if (strValue.length() == 1) {
                        strValue = strValue.toLowerCase();
                    } else if (!Character.isUpperCase(strValue.charAt(1))) {
                        strValue = Character.toLowerCase(strValue.charAt(0)) + strValue.substring(1);
                    }
                }
            }
        } else if (annotation instanceof JSFunction) {
            strValue = ((JSFunction) annotation).value();
        } else {
            strValue = annotation instanceof JSStaticFunction ? ((JSStaticFunction) annotation).value() : null;
        }
        return (strValue == null || strValue.length() == 0) ? str : strValue;
    }

    public static Scriptable getTopLevelScope(Scriptable scriptable) {
        while (true) {
            Scriptable parentScope = scriptable.getParentScope();
            if (parentScope == null) {
                return scriptable;
            }
            scriptable = parentScope;
        }
    }

    public static Object getTopScopeValue(Scriptable scriptable, Object obj) {
        Object associatedValue;
        Scriptable topLevelScope = getTopLevelScope(scriptable);
        do {
            if ((topLevelScope instanceof ScriptableObject) && (associatedValue = ((ScriptableObject) topLevelScope).getAssociatedValue(obj)) != null) {
                return associatedValue;
            }
            topLevelScope = topLevelScope.getPrototype();
        } while (topLevelScope != null);
        return null;
    }

    public static <T> T getTypedProperty(Scriptable scriptable, int i, Class<T> cls) {
        Object property = getProperty(scriptable, i);
        if (property == Scriptable.NOT_FOUND) {
            property = null;
        }
        return cls.cast(Context.jsToJava(property, cls));
    }

    public static boolean hasProperty(Scriptable scriptable, int i) {
        return getBase(scriptable, i) != null;
    }

    protected static boolean isFalse(Object obj) {
        return !isTrue(obj);
    }

    protected static boolean isTrue(Object obj) {
        return obj != Scriptable.NOT_FOUND && ScriptRuntime.toBoolean(obj);
    }

    private boolean putConstImpl(String str, int i, Scriptable scriptable, Object obj, int i2) {
        Slot slotQuery;
        if (!this.isExtensible && Context.getContext().isStrictMode()) {
            throw ScriptRuntime.typeError0("msg.not.extensible");
        }
        if (this != scriptable) {
            slotQuery = this.slotMap.query(str, i);
            if (slotQuery == null) {
                return false;
            }
        } else {
            if (isExtensible()) {
                checkNotSealed(str, i);
                Slot slot = this.slotMap.get(str, i, SlotAccess.MODIFY_CONST);
                int attributes = slot.getAttributes();
                if ((attributes & 1) == 0) {
                    throw Context.reportRuntimeError1("msg.var.redecl", str);
                }
                if ((attributes & 8) != 0) {
                    slot.value = obj;
                    if (i2 != 8) {
                        slot.setAttributes(attributes & (-9));
                    }
                }
                return true;
            }
            slotQuery = this.slotMap.query(str, i);
            if (slotQuery == null) {
                return true;
            }
        }
        return slotQuery.setValue(obj, this, scriptable);
    }

    public static void putConstProperty(Scriptable scriptable, String str, Object obj) {
        Scriptable base = getBase(scriptable, str);
        if (base == null) {
            base = scriptable;
        }
        if (base instanceof ConstProperties) {
            ((ConstProperties) base).putConst(str, scriptable, obj);
        }
    }

    private boolean putImpl(Object obj, int i, Scriptable scriptable, Object obj2) {
        Slot slotQuery;
        if (this != scriptable) {
            slotQuery = this.slotMap.query(obj, i);
            if (!this.isExtensible && ((slotQuery == null || (!(slotQuery instanceof GetterSlot) && (slotQuery.getAttributes() & 1) != 0)) && Context.getContext().isStrictMode())) {
                throw ScriptRuntime.typeError0("msg.not.extensible");
            }
            if (slotQuery == null) {
                return false;
            }
        } else if (this.isExtensible) {
            if (this.isSealed) {
                checkNotSealed(obj, i);
            }
            slotQuery = this.slotMap.get(obj, i, SlotAccess.MODIFY);
        } else {
            slotQuery = this.slotMap.query(obj, i);
            if ((slotQuery == null || !((slotQuery instanceof GetterSlot) || (slotQuery.getAttributes() & 1) == 0)) && Context.getContext().isStrictMode()) {
                throw ScriptRuntime.typeError0("msg.not.extensible");
            }
            if (slotQuery == null) {
                return true;
            }
        }
        return slotQuery.setValue(obj2, this, scriptable);
    }

    public static void putProperty(Scriptable scriptable, int i, Object obj) {
        Scriptable base = getBase(scriptable, i);
        if (base == null) {
            base = scriptable;
        }
        base.put(i, scriptable, obj);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int i = objectInputStream.readInt();
        this.slotMap = createSlotMap(i);
        for (int i2 = 0; i2 < i; i2++) {
            this.slotMap.addSlot((Slot) objectInputStream.readObject());
        }
    }

    public static void redefineProperty(Scriptable scriptable, String str, boolean z) {
        Scriptable base = getBase(scriptable, str);
        if (base == null) {
            return;
        }
        if ((base instanceof ConstProperties) && ((ConstProperties) base).isConst(str)) {
            throw ScriptRuntime.typeError1("msg.const.redecl", str);
        }
        if (z) {
            throw ScriptRuntime.typeError1("msg.var.redecl", str);
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        long lock = this.slotMap.readLock();
        try {
            int iDirtySize = this.slotMap.dirtySize();
            if (iDirtySize == 0) {
                objectOutputStream.writeInt(0);
            } else {
                objectOutputStream.writeInt(iDirtySize);
                Iterator<Slot> it = this.slotMap.iterator();
                while (it.hasNext()) {
                    objectOutputStream.writeObject(it.next());
                }
            }
        } finally {
            this.slotMap.unlockRead(lock);
        }
    }

    void addLazilyInitializedValue(String str, int i, LazilyLoadedCtor lazilyLoadedCtor, int i2) {
        if (str != null && i != 0) {
            throw new IllegalArgumentException(str);
        }
        checkNotSealed(str, i);
        GetterSlot getterSlot = (GetterSlot) this.slotMap.get(str, i, SlotAccess.MODIFY_GETTER_SETTER);
        getterSlot.setAttributes(i2);
        getterSlot.getter = null;
        getterSlot.setter = null;
        getterSlot.value = lazilyLoadedCtor;
    }

    protected int applyDescriptorToAttributeBitset(int i, ScriptableObject scriptableObject) {
        Object property = getProperty(scriptableObject, "enumerable");
        Object obj = Scriptable.NOT_FOUND;
        if (property != obj) {
            i = ScriptRuntime.toBoolean(property) ? i & (-3) : i | 2;
        }
        Object property2 = getProperty(scriptableObject, "writable");
        if (property2 != obj) {
            i = ScriptRuntime.toBoolean(property2) ? i & (-2) : i | 1;
        }
        Object property3 = getProperty(scriptableObject, "configurable");
        if (property3 != obj) {
            return ScriptRuntime.toBoolean(property3) ? i & (-5) : i | 4;
        }
        return i;
    }

    public final synchronized Object associateValue(Object obj, Object obj2) {
        Map map;
        try {
            if (obj2 == null) {
                throw new IllegalArgumentException();
            }
            map = this.associatedValues;
            if (map == null) {
                map = new HashMap();
                this.associatedValues = map;
            }
        } catch (Throwable th) {
            throw th;
        }
        return Kit.initHash(map, obj, obj2);
    }

    public boolean avoidObjectDetection() {
        return false;
    }

    protected void checkPropertyChange(Object obj, ScriptableObject scriptableObject, ScriptableObject scriptableObject2) {
        if (scriptableObject == null) {
            if (!isExtensible()) {
                throw ScriptRuntime.typeError0("msg.not.extensible");
            }
            return;
        }
        if (isFalse(scriptableObject.get("configurable", scriptableObject))) {
            if (isTrue(getProperty(scriptableObject2, "configurable"))) {
                throw ScriptRuntime.typeError1("msg.change.configurable.false.to.true", obj);
            }
            if (isTrue(scriptableObject.get("enumerable", scriptableObject)) != isTrue(getProperty(scriptableObject2, "enumerable"))) {
                throw ScriptRuntime.typeError1("msg.change.enumerable.with.configurable.false", obj);
            }
            boolean zIsDataDescriptor = isDataDescriptor(scriptableObject2);
            boolean zIsAccessorDescriptor = isAccessorDescriptor(scriptableObject2);
            if (zIsDataDescriptor || zIsAccessorDescriptor) {
                if (zIsDataDescriptor && isDataDescriptor(scriptableObject)) {
                    if (isFalse(scriptableObject.get("writable", scriptableObject))) {
                        if (isTrue(getProperty(scriptableObject2, "writable"))) {
                            throw ScriptRuntime.typeError1("msg.change.writable.false.to.true.with.configurable.false", obj);
                        }
                        if (!sameValue(getProperty(scriptableObject2, "value"), scriptableObject.get("value", scriptableObject))) {
                            throw ScriptRuntime.typeError1("msg.change.value.with.writable.false", obj);
                        }
                        return;
                    }
                    return;
                }
                if (!zIsAccessorDescriptor || !isAccessorDescriptor(scriptableObject)) {
                    if (!isDataDescriptor(scriptableObject)) {
                        throw ScriptRuntime.typeError1("msg.change.property.accessor.to.data.with.configurable.false", obj);
                    }
                    throw ScriptRuntime.typeError1("msg.change.property.data.to.accessor.with.configurable.false", obj);
                }
                if (!sameValue(getProperty(scriptableObject2, "set"), scriptableObject.get("set", scriptableObject))) {
                    throw ScriptRuntime.typeError1("msg.change.setter.with.configurable.false", obj);
                }
                if (!sameValue(getProperty(scriptableObject2, PasskeyWebListener.GET_UNIQUE_KEY), scriptableObject.get(PasskeyWebListener.GET_UNIQUE_KEY, scriptableObject))) {
                    throw ScriptRuntime.typeError1("msg.change.getter.with.configurable.false", obj);
                }
            }
        }
    }

    protected void checkPropertyDefinition(ScriptableObject scriptableObject) {
        Object property = getProperty(scriptableObject, PasskeyWebListener.GET_UNIQUE_KEY);
        Object obj = Scriptable.NOT_FOUND;
        if (property != obj && property != Undefined.instance && !(property instanceof Callable)) {
            throw ScriptRuntime.notFunctionError(property);
        }
        Object property2 = getProperty(scriptableObject, "set");
        if (property2 != obj && property2 != Undefined.instance && !(property2 instanceof Callable)) {
            throw ScriptRuntime.notFunctionError(property2);
        }
        if (isDataDescriptor(scriptableObject) && isAccessorDescriptor(scriptableObject)) {
            throw ScriptRuntime.typeError0("msg.both.data.and.accessor.desc");
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ConstProperties
    public void defineConst(String str, Scriptable scriptable) {
        if (putConstImpl(str, 0, scriptable, Undefined.instance, 8)) {
            return;
        }
        if (scriptable == this) {
            throw Kit.codeBug();
        }
        if (scriptable instanceof ConstProperties) {
            ((ConstProperties) scriptable).defineConst(str, scriptable);
        }
    }

    public void defineFunctionProperties(String[] strArr, Class<?> cls, int i) {
        Method[] methodList = FunctionObject.getMethodList(cls);
        for (String str : strArr) {
            Method methodFindSingleMethod = FunctionObject.findSingleMethod(methodList, str);
            if (methodFindSingleMethod == null) {
                throw Context.reportRuntimeError2("msg.method.not.found", str, cls.getName());
            }
            defineProperty(str, new FunctionObject(str, methodFindSingleMethod, this), i);
        }
    }

    public void defineOwnProperties(Context context, ScriptableObject scriptableObject) {
        Object[] ids = scriptableObject.getIds(false, true);
        ScriptableObject[] scriptableObjectArr = new ScriptableObject[ids.length];
        int length = ids.length;
        for (int i = 0; i < length; i++) {
            ScriptableObject scriptableObjectEnsureScriptableObject = ensureScriptableObject(ScriptRuntime.getObjectElem((Scriptable) scriptableObject, ids[i], context));
            checkPropertyDefinition(scriptableObjectEnsureScriptableObject);
            scriptableObjectArr[i] = scriptableObjectEnsureScriptableObject;
        }
        int length2 = ids.length;
        for (int i2 = 0; i2 < length2; i2++) {
            defineOwnProperty(context, ids[i2], scriptableObjectArr[i2]);
        }
    }

    public void defineOwnProperty(Context context, Object obj, ScriptableObject scriptableObject) {
        checkPropertyDefinition(scriptableObject);
        defineOwnProperty(context, obj, scriptableObject, true);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.Scriptable
    public void delete(int i) {
        checkNotSealed(null, i);
        this.slotMap.remove(null, i);
    }

    protected Object equivalentValues(Object obj) {
        return this == obj ? Boolean.TRUE : Scriptable.NOT_FOUND;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.Scriptable
    public Object get(int i, Scriptable scriptable) {
        ExternalArrayData externalArrayData = this.externalData;
        if (externalArrayData != null) {
            return i < externalArrayData.getArrayLength() ? this.externalData.getArrayElement(i) : Scriptable.NOT_FOUND;
        }
        Slot slotQuery = this.slotMap.query(null, i);
        return slotQuery == null ? Scriptable.NOT_FOUND : slotQuery.getValue(scriptable);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.debug.DebuggableObject
    public Object[] getAllIds() {
        return getIds(true, false);
    }

    public final Object getAssociatedValue(Object obj) {
        Map<Object, Object> map = this.associatedValues;
        if (map == null) {
            return null;
        }
        return map.get(obj);
    }

    public int getAttributes(int i) {
        return findAttributeSlot(null, i, SlotAccess.QUERY).getAttributes();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.Scriptable
    public abstract String getClassName();

    public ExternalArrayData getExternalArrayData() {
        return this.externalData;
    }

    public Object getExternalArrayLength() {
        ExternalArrayData externalArrayData = this.externalData;
        return Integer.valueOf(externalArrayData == null ? 0 : externalArrayData.getArrayLength());
    }

    public Object getGetterOrSetter(String str, int i, boolean z) {
        if (str != null && i != 0) {
            throw new IllegalArgumentException(str);
        }
        Slot slotQuery = this.slotMap.query(str, i);
        if (slotQuery == null) {
            return null;
        }
        if (!(slotQuery instanceof GetterSlot)) {
            return Undefined.instance;
        }
        GetterSlot getterSlot = (GetterSlot) slotQuery;
        Object obj = z ? getterSlot.setter : getterSlot.getter;
        return obj != null ? obj : Undefined.instance;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.Scriptable
    public Object[] getIds() {
        return getIds(false, false);
    }

    protected ScriptableObject getOwnPropertyDescriptor(Context context, Object obj) {
        Slot slot = getSlot(context, obj, SlotAccess.QUERY);
        if (slot == null) {
            return null;
        }
        Scriptable parentScope = getParentScope();
        if (parentScope != null) {
            this = parentScope;
        }
        return slot.getPropertyDescriptor(context, this);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.Scriptable
    public Scriptable getParentScope() {
        return this.parentScopeObject;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.Scriptable
    public Scriptable getPrototype() {
        return this.prototypeObject;
    }

    protected Slot getSlot(Context context, Object obj, SlotAccess slotAccess) {
        if (obj instanceof Symbol) {
            return this.slotMap.get(obj, 0, slotAccess);
        }
        ScriptRuntime.StringIdOrIndex stringIdOrIndex = ScriptRuntime.toStringIdOrIndex(context, obj);
        String str = stringIdOrIndex.stringId;
        SlotMapContainer slotMapContainer = this.slotMap;
        return str == null ? slotMapContainer.get(null, stringIdOrIndex.index, slotAccess) : slotMapContainer.get(str, 0, slotAccess);
    }

    public String getTypeOf() {
        return avoidObjectDetection() ? "undefined" : "object";
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.Scriptable
    public boolean has(int i, Scriptable scriptable) {
        ExternalArrayData externalArrayData = this.externalData;
        if (externalArrayData != null) {
            return i < externalArrayData.getArrayLength();
        }
        return this.slotMap.query(null, i) != null;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.Scriptable
    public boolean hasInstance(Scriptable scriptable) {
        return ScriptRuntime.jsDelegatesTo(scriptable, this);
    }

    protected boolean isAccessorDescriptor(ScriptableObject scriptableObject) {
        return hasProperty(scriptableObject, PasskeyWebListener.GET_UNIQUE_KEY) || hasProperty(scriptableObject, "set");
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ConstProperties
    public boolean isConst(String str) {
        Slot slotQuery = this.slotMap.query(str, 0);
        return slotQuery != null && (slotQuery.getAttributes() & 5) == 5;
    }

    protected boolean isDataDescriptor(ScriptableObject scriptableObject) {
        return hasProperty(scriptableObject, "value") || hasProperty(scriptableObject, "writable");
    }

    public boolean isEmpty() {
        return this.slotMap.isEmpty();
    }

    public boolean isExtensible() {
        return this.isExtensible;
    }

    protected boolean isGenericDescriptor(ScriptableObject scriptableObject) {
        return (isDataDescriptor(scriptableObject) || isAccessorDescriptor(scriptableObject)) ? false : true;
    }

    protected boolean isGetterOrSetter(String str, int i, boolean z) {
        Slot slotQuery = this.slotMap.query(str, i);
        if (!(slotQuery instanceof GetterSlot)) {
            return false;
        }
        if (!z || ((GetterSlot) slotQuery).setter == null) {
            return (z || ((GetterSlot) slotQuery).getter == null) ? false : true;
        }
        return true;
    }

    public final boolean isSealed() {
        return this.isSealed;
    }

    public void preventExtensions() {
        this.isExtensible = false;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.Scriptable
    public void put(int i, Scriptable scriptable, Object obj) {
        ExternalArrayData externalArrayData = this.externalData;
        if (externalArrayData != null) {
            if (i >= externalArrayData.getArrayLength()) {
                throw new JavaScriptException(ScriptRuntime.newNativeError(Context.getCurrentContext(), this, TopLevel.NativeErrors.RangeError, new Object[]{"External array index out of bounds "}), null, 0);
            }
            this.externalData.setArrayElement(i, obj);
        } else {
            if (putImpl(null, i, scriptable, obj)) {
                return;
            }
            if (scriptable == this) {
                throw Kit.codeBug();
            }
            scriptable.put(i, scriptable, obj);
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ConstProperties
    public void putConst(String str, Scriptable scriptable, Object obj) {
        if (putConstImpl(str, 0, scriptable, obj, 1)) {
            return;
        }
        if (scriptable == this) {
            throw Kit.codeBug();
        }
        if (scriptable instanceof ConstProperties) {
            ((ConstProperties) scriptable).putConst(str, scriptable, obj);
        } else {
            scriptable.put(str, scriptable, obj);
        }
    }

    protected boolean sameValue(Object obj, Object obj2) {
        Object obj3 = Scriptable.NOT_FOUND;
        if (obj == obj3) {
            return true;
        }
        if (obj2 == obj3) {
            obj2 = Undefined.instance;
        }
        if ((obj2 instanceof Number) && (obj instanceof Number)) {
            double dDoubleValue = ((Number) obj2).doubleValue();
            double dDoubleValue2 = ((Number) obj).doubleValue();
            if (Double.isNaN(dDoubleValue) && Double.isNaN(dDoubleValue2)) {
                return true;
            }
            if (dDoubleValue == 0.0d && Double.doubleToLongBits(dDoubleValue) != Double.doubleToLongBits(dDoubleValue2)) {
                return false;
            }
        }
        return ScriptRuntime.shallowEq(obj2, obj);
    }

    public void sealObject() {
        if (this.isSealed) {
            return;
        }
        long lock = this.slotMap.readLock();
        try {
            for (Slot slot : this.slotMap) {
                Object obj = slot.value;
                if (obj instanceof LazilyLoadedCtor) {
                    LazilyLoadedCtor lazilyLoadedCtor = (LazilyLoadedCtor) obj;
                    try {
                        lazilyLoadedCtor.init();
                        slot.value = lazilyLoadedCtor.getValue();
                    } catch (Throwable th) {
                        slot.value = lazilyLoadedCtor.getValue();
                        throw th;
                    }
                }
            }
            this.isSealed = true;
            this.slotMap.unlockRead(lock);
        } catch (Throwable th2) {
            this.slotMap.unlockRead(lock);
            throw th2;
        }
    }

    public void setAttributes(int i, int i2) {
        checkNotSealed(null, i);
        findAttributeSlot(null, i, SlotAccess.MODIFY).setAttributes(i2);
    }

    public void setExternalArrayData(ExternalArrayData externalArrayData) {
        this.externalData = externalArrayData;
        if (externalArrayData == null) {
            delete(Analytics.Data.LENGTH);
        } else {
            defineProperty(Analytics.Data.LENGTH, null, GET_ARRAY_LENGTH, null, 3);
        }
    }

    public void setGetterOrSetter(String str, int i, Callable callable, boolean z) {
        setGetterOrSetter(str, i, callable, z, false);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.Scriptable
    public void setParentScope(Scriptable scriptable) {
        this.parentScopeObject = scriptable;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.Scriptable
    public void setPrototype(Scriptable scriptable) {
        if (!isExtensible() && Context.getContext().getLanguageVersion() >= 180) {
            throw ScriptRuntime.typeError0("msg.not.extensible");
        }
        this.prototypeObject = scriptable;
    }

    public int size() {
        return this.slotMap.size();
    }

    public ScriptableObject(Scriptable scriptable, Scriptable scriptable2) {
        this.isExtensible = true;
        this.isSealed = false;
        if (scriptable == null) {
            throw new IllegalArgumentException();
        }
        this.parentScopeObject = scriptable;
        this.prototypeObject = scriptable2;
        this.slotMap = createSlotMap(0);
    }

    public static Object callMethod(Scriptable scriptable, String str, Object[] objArr) {
        return callMethod(null, scriptable, str, objArr);
    }

    public static <T extends Scriptable> void defineClass(Scriptable scriptable, Class<T> cls) throws IllegalAccessException, InvocationTargetException {
        defineClass(scriptable, cls, false, false);
    }

    public static boolean deleteProperty(Scriptable scriptable, String str) {
        Scriptable base = getBase(scriptable, str);
        if (base == null) {
            return true;
        }
        base.delete(str);
        return !base.has(str, scriptable);
    }

    private Slot findAttributeSlot(String str, int i, SlotAccess slotAccess) {
        Slot slot = this.slotMap.get(str, i, slotAccess);
        if (slot != null) {
            return slot;
        }
        if (str == null) {
            str = Integer.toString(i);
        }
        throw Context.reportRuntimeError1("msg.prop.not.found", str);
    }

    private static Scriptable getBase(Scriptable scriptable, Symbol symbol) {
        while (!ensureSymbolScriptable(scriptable).has(symbol, scriptable)) {
            scriptable = scriptable.getPrototype();
            if (scriptable == null) {
                return scriptable;
            }
        }
        return scriptable;
    }

    public static Object getProperty(Scriptable scriptable, Symbol symbol) {
        Object obj;
        Scriptable prototype = scriptable;
        do {
            obj = ensureSymbolScriptable(prototype).get(symbol, scriptable);
            if (obj != Scriptable.NOT_FOUND) {
                break;
            }
            prototype = prototype.getPrototype();
        } while (prototype != null);
        return obj;
    }

    public static <T> T getTypedProperty(Scriptable scriptable, String str, Class<T> cls) {
        Object property = getProperty(scriptable, str);
        if (property == Scriptable.NOT_FOUND) {
            property = null;
        }
        return cls.cast(Context.jsToJava(property, cls));
    }

    public static boolean hasProperty(Scriptable scriptable, Symbol symbol) {
        return getBase(scriptable, symbol) != null;
    }

    public static void putProperty(Scriptable scriptable, Symbol symbol, Object obj) {
        Scriptable base = getBase(scriptable, symbol);
        if (base == null) {
            base = scriptable;
        }
        ensureSymbolScriptable(base).put(symbol, scriptable, obj);
    }

    private void setGetterOrSetter(String str, int i, Callable callable, boolean z, boolean z2) {
        Slot slotQuery;
        if (str != null && i != 0) {
            throw new IllegalArgumentException(str);
        }
        if (!z2) {
            checkNotSealed(str, i);
        }
        boolean zIsExtensible = isExtensible();
        SlotMapContainer slotMapContainer = this.slotMap;
        if (zIsExtensible) {
            slotQuery = slotMapContainer.get(str, i, SlotAccess.MODIFY_GETTER_SETTER);
        } else {
            slotQuery = slotMapContainer.query(str, i);
            if (!(slotQuery instanceof GetterSlot)) {
                return;
            }
        }
        GetterSlot getterSlot = (GetterSlot) slotQuery;
        if (!z2 && (getterSlot.getAttributes() & 1) != 0) {
            throw Context.reportRuntimeError1("msg.modify.readonly", str);
        }
        if (z) {
            getterSlot.setter = callable;
        } else {
            getterSlot.getter = callable;
        }
        getterSlot.value = Undefined.instance;
    }

    protected void defineOwnProperty(Context context, Object obj, ScriptableObject scriptableObject, boolean z) {
        int attributes;
        Slot slot = getSlot(context, obj, SlotAccess.QUERY);
        boolean z2 = slot == null;
        if (z) {
            checkPropertyChange(obj, slot == null ? null : slot.getPropertyDescriptor(context, this), scriptableObject);
        }
        boolean zIsAccessorDescriptor = isAccessorDescriptor(scriptableObject);
        if (slot == null) {
            slot = getSlot(context, obj, zIsAccessorDescriptor ? SlotAccess.MODIFY_GETTER_SETTER : SlotAccess.MODIFY);
            attributes = 7;
        } else {
            attributes = slot.getAttributes();
        }
        int iApplyDescriptorToAttributeBitset = applyDescriptorToAttributeBitset(attributes, scriptableObject);
        if (!zIsAccessorDescriptor) {
            if ((slot instanceof GetterSlot) && isDataDescriptor(scriptableObject)) {
                slot = getSlot(context, obj, SlotAccess.CONVERT_ACCESSOR_TO_DATA);
            }
            Object property = getProperty(scriptableObject, "value");
            if (property != Scriptable.NOT_FOUND) {
                slot.value = property;
            } else if (z2) {
                property = Undefined.instance;
                slot.value = property;
            }
            slot.setAttributes(iApplyDescriptorToAttributeBitset);
            return;
        }
        if (!(slot instanceof GetterSlot)) {
            slot = getSlot(context, obj, SlotAccess.MODIFY_GETTER_SETTER);
        }
        GetterSlot getterSlot = (GetterSlot) slot;
        Object property2 = getProperty(scriptableObject, PasskeyWebListener.GET_UNIQUE_KEY);
        Object obj2 = Scriptable.NOT_FOUND;
        if (property2 != obj2) {
            getterSlot.getter = property2;
        }
        Object property3 = getProperty(scriptableObject, "set");
        if (property3 != obj2) {
            getterSlot.setter = property3;
        }
        getterSlot.value = Undefined.instance;
        getterSlot.setAttributes(iApplyDescriptorToAttributeBitset);
    }

    public void defineProperty(Symbol symbol, Object obj, int i) {
        checkNotSealed(symbol, 0);
        put(symbol, this, obj);
        setAttributes(symbol, i);
    }

    public void delete(Symbol symbol) {
        checkNotSealed(symbol, 0);
        this.slotMap.remove(symbol, 0);
    }

    public Object get(Symbol symbol, Scriptable scriptable) {
        Slot slotQuery = this.slotMap.query(symbol, 0);
        return slotQuery == null ? Scriptable.NOT_FOUND : slotQuery.getValue(scriptable);
    }

    @Deprecated
    public final int getAttributes(int i, Scriptable scriptable) {
        return getAttributes(i);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.Scriptable
    public Object getDefaultValue(Class<?> cls) {
        return getDefaultValue(this, cls);
    }

    Object[] getIds(boolean z, boolean z2) {
        Object[] objArr;
        ExternalArrayData externalArrayData = this.externalData;
        int arrayLength = externalArrayData == null ? 0 : externalArrayData.getArrayLength();
        if (arrayLength == 0) {
            objArr = ScriptRuntime.emptyArgs;
        } else {
            objArr = new Object[arrayLength];
            for (int i = 0; i < arrayLength; i++) {
                objArr[i] = Integer.valueOf(i);
            }
        }
        if (this.slotMap.isEmpty()) {
            return objArr;
        }
        long lock = this.slotMap.readLock();
        try {
            int i2 = arrayLength;
            for (Slot slot : this.slotMap) {
                if (z || (slot.getAttributes() & 2) == 0) {
                    if (z2 || !(slot.name instanceof Symbol)) {
                        if (i2 == arrayLength) {
                            Object[] objArr2 = new Object[this.slotMap.dirtySize() + arrayLength];
                            if (objArr != null) {
                                System.arraycopy(objArr, 0, objArr2, 0, arrayLength);
                            }
                            objArr = objArr2;
                        }
                        int i3 = i2 + 1;
                        Object objValueOf = slot.name;
                        if (objValueOf == null) {
                            objValueOf = Integer.valueOf(slot.indexOrHash);
                        }
                        objArr[i2] = objValueOf;
                        i2 = i3;
                    }
                }
            }
            this.slotMap.unlockRead(lock);
            if (i2 != objArr.length + arrayLength) {
                Object[] objArr3 = new Object[i2];
                System.arraycopy(objArr, 0, objArr3, 0, i2);
                objArr = objArr3;
            }
            Context currentContext = Context.getCurrentContext();
            if (currentContext != null && currentContext.hasFeature(16)) {
                Arrays.sort(objArr, KEY_COMPARATOR);
            }
            return objArr;
        } catch (Throwable th) {
            this.slotMap.unlockRead(lock);
            throw th;
        }
    }

    public boolean has(Symbol symbol, Scriptable scriptable) {
        return this.slotMap.query(symbol, 0) != null;
    }

    public void put(Symbol symbol, Scriptable scriptable, Object obj) {
        if (putImpl(symbol, 0, scriptable, obj)) {
            return;
        }
        if (scriptable == this) {
            throw Kit.codeBug();
        }
        ensureSymbolScriptable(scriptable).put(symbol, scriptable, obj);
    }

    @Deprecated
    public void setAttributes(int i, Scriptable scriptable, int i2) {
        setAttributes(i, i2);
    }

    public static <T extends Scriptable> void defineClass(Scriptable scriptable, Class<T> cls, boolean z) throws IllegalAccessException, InvocationTargetException {
        defineClass(scriptable, cls, z, false);
    }

    private static Scriptable getBase(Scriptable scriptable, String str) {
        while (!scriptable.has(str, scriptable)) {
            scriptable = scriptable.getPrototype();
            if (scriptable == null) {
                return scriptable;
            }
        }
        return scriptable;
    }

    public static Object getProperty(Scriptable scriptable, String str) {
        Object obj;
        Scriptable prototype = scriptable;
        do {
            obj = prototype.get(str, scriptable);
            if (obj != Scriptable.NOT_FOUND) {
                break;
            }
            prototype = prototype.getPrototype();
        } while (prototype != null);
        return obj;
    }

    public static boolean hasProperty(Scriptable scriptable, String str) {
        return getBase(scriptable, str) != null;
    }

    public static void putProperty(Scriptable scriptable, String str, Object obj) {
        Scriptable base = getBase(scriptable, str);
        if (base == null) {
            base = scriptable;
        }
        base.put(str, scriptable, obj);
    }

    public void defineProperty(String str, Class<?> cls, int i) {
        int length = str.length();
        if (length == 0) {
            throw new IllegalArgumentException();
        }
        char[] cArr = new char[length + 3];
        str.getChars(0, length, cArr, 3);
        cArr[3] = Character.toUpperCase(cArr[3]);
        cArr[0] = 'g';
        cArr[1] = 'e';
        cArr[2] = 't';
        String str2 = new String(cArr);
        cArr[0] = 's';
        String str3 = new String(cArr);
        Method[] methodList = FunctionObject.getMethodList(cls);
        Method methodFindSingleMethod = FunctionObject.findSingleMethod(methodList, str2);
        Method methodFindSingleMethod2 = FunctionObject.findSingleMethod(methodList, str3);
        if (methodFindSingleMethod2 == null) {
            i |= 1;
        }
        int i2 = i;
        if (methodFindSingleMethod2 == null) {
            methodFindSingleMethod2 = null;
        }
        defineProperty(str, null, methodFindSingleMethod, methodFindSingleMethod2, i2);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.Scriptable
    public void delete(String str) {
        checkNotSealed(str, 0);
        this.slotMap.remove(str, 0);
    }

    public Object get(Object obj) {
        Object obj2;
        if (obj instanceof String) {
            obj2 = get((String) obj, this);
        } else if (obj instanceof Symbol) {
            obj2 = get((Symbol) obj, this);
        } else {
            obj2 = obj instanceof Number ? get(((Number) obj).intValue(), this) : null;
        }
        if (obj2 == Scriptable.NOT_FOUND || obj2 == Undefined.instance) {
            return null;
        }
        return obj2 instanceof Wrapper ? ((Wrapper) obj2).unwrap() : obj2;
    }

    public int getAttributes(Symbol symbol) {
        return findAttributeSlot(symbol, SlotAccess.QUERY).getAttributes();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.Scriptable
    public boolean has(String str, Scriptable scriptable) {
        return this.slotMap.query(str, 0) != null;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.Scriptable
    public void put(String str, Scriptable scriptable, Object obj) {
        if (putImpl(str, 0, scriptable, obj)) {
            return;
        }
        if (scriptable == this) {
            throw Kit.codeBug();
        }
        scriptable.put(str, scriptable, obj);
    }

    public void setAttributes(Symbol symbol, int i) {
        checkNotSealed(symbol, 0);
        findAttributeSlot(symbol, SlotAccess.MODIFY).setAttributes(i);
    }

    public void defineProperty(String str, Object obj, int i) {
        checkNotSealed(str, 0);
        put(str, this, obj);
        setAttributes(str, i);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.Scriptable
    public Object get(String str, Scriptable scriptable) {
        Slot slotQuery = this.slotMap.query(str, 0);
        return slotQuery == null ? Scriptable.NOT_FOUND : slotQuery.getValue(scriptable);
    }

    public int getAttributes(String str) {
        return findAttributeSlot(str, 0, SlotAccess.QUERY).getAttributes();
    }

    public void setAttributes(String str, int i) {
        checkNotSealed(str, 0);
        findAttributeSlot(str, 0, SlotAccess.MODIFY).setAttributes(i);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0042  */
    public void defineProperty(String str, Object obj, Method method, Method method2, int i) {
        MemberBox memberBox;
        boolean z;
        boolean z2;
        String str2;
        Class<?> cls;
        MemberBox memberBox2 = null;
        str = null;
        String str3 = null;
        if (method != null) {
            memberBox = new MemberBox(method);
            if (Modifier.isStatic(method.getModifiers())) {
                memberBox.delegateTo = Void.TYPE;
                z2 = true;
            } else {
                boolean z3 = obj != null;
                memberBox.delegateTo = obj;
                z2 = z3;
            }
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length == 0) {
                if (z2) {
                    str2 = "msg.obj.getter.parms";
                } else {
                    str2 = null;
                }
            } else if (parameterTypes.length == 1 && (((cls = parameterTypes[0]) == ScriptRuntime.ScriptableClass || cls == ScriptRuntime.ScriptableObjectClass) && z2)) {
                str2 = null;
            } else {
                str2 = "msg.bad.getter.parms";
            }
            if (str2 != null) {
                throw Context.reportRuntimeError1(str2, method.toString());
            }
        } else {
            memberBox = null;
        }
        if (method2 != null) {
            if (method2.getReturnType() != Void.TYPE) {
                throw Context.reportRuntimeError1("msg.setter.return", method2.toString());
            }
            MemberBox memberBox3 = new MemberBox(method2);
            if (Modifier.isStatic(method2.getModifiers())) {
                memberBox3.delegateTo = Void.TYPE;
                z = true;
            } else {
                boolean z4 = obj != null;
                memberBox3.delegateTo = obj;
                z = z4;
            }
            Class<?>[] parameterTypes2 = method2.getParameterTypes();
            if (parameterTypes2.length == 1) {
                if (z) {
                    str3 = "msg.setter2.expected";
                }
            } else if (parameterTypes2.length == 2) {
                Class<?> cls2 = parameterTypes2[0];
                if (cls2 != ScriptRuntime.ScriptableClass && cls2 != ScriptRuntime.ScriptableObjectClass) {
                    str3 = "msg.setter2.parms";
                } else if (!z) {
                    str3 = "msg.setter1.parms";
                }
            } else {
                str3 = "msg.setter.parms";
            }
            if (str3 != null) {
                throw Context.reportRuntimeError1(str3, method2.toString());
            }
            memberBox2 = memberBox3;
        }
        GetterSlot getterSlot = (GetterSlot) this.slotMap.get(str, 0, SlotAccess.MODIFY_GETTER_SETTER);
        getterSlot.setAttributes(i);
        getterSlot.getter = memberBox;
        getterSlot.setter = memberBox2;
    }

    @Deprecated
    public final int getAttributes(String str, Scriptable scriptable) {
        return getAttributes(str);
    }

    @Deprecated
    public final void setAttributes(String str, Scriptable scriptable, int i) {
        setAttributes(str, i);
    }
}
