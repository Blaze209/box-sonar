package external.sdk.pendo.io.mozilla.javascript;

import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes4.dex */
class JavaMembers {
    private Class<?> cl;
    NativeJavaMethod ctors;
    private Map<String, FieldAndMethods> fieldAndMethods;
    private Map<String, Object> members;
    private Map<String, FieldAndMethods> staticFieldAndMethods;
    private Map<String, Object> staticMembers;

    private static final class MethodSignature {
        private final Class<?>[] args;
        private final String name;

        private MethodSignature(String str, Class<?>[] clsArr) {
            this.name = str;
            this.args = clsArr;
        }

        public boolean equals(Object obj) {
            if (obj instanceof MethodSignature) {
                MethodSignature methodSignature = (MethodSignature) obj;
                if (methodSignature.name.equals(this.name) && Arrays.equals(this.args, methodSignature.args)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return this.args.length ^ this.name.hashCode();
        }

        MethodSignature(Method method) {
            this(method.getName(), method.getParameterTypes());
        }
    }

    JavaMembers(Scriptable scriptable, Class<?> cls) {
        this(scriptable, cls, false);
    }

    private static void discoverAccessibleMethods(Class<?> cls, Map<MethodSignature, Method> map, boolean z, boolean z2) {
        if (Modifier.isPublic(cls.getModifiers()) || z2) {
            try {
                if (!z && !z2) {
                    for (Method method : cls.getMethods()) {
                        MethodSignature methodSignature = new MethodSignature(method);
                        if (!map.containsKey(methodSignature)) {
                            map.put(methodSignature, method);
                        }
                    }
                    return;
                }
                while (cls != null) {
                    try {
                        for (Method method2 : cls.getDeclaredMethods()) {
                            int modifiers = method2.getModifiers();
                            if (Modifier.isPublic(modifiers) || Modifier.isProtected(modifiers) || z2) {
                                MethodSignature methodSignature2 = new MethodSignature(method2);
                                if (!map.containsKey(methodSignature2)) {
                                    if (z2 && !method2.isAccessible()) {
                                        method2.setAccessible(true);
                                    }
                                    map.put(methodSignature2, method2);
                                }
                            }
                        }
                        for (Class<?> cls2 : cls.getInterfaces()) {
                            discoverAccessibleMethods(cls2, map, z, z2);
                        }
                        cls = cls.getSuperclass();
                    } catch (SecurityException unused) {
                        for (Method method3 : cls.getMethods()) {
                            MethodSignature methodSignature3 = new MethodSignature(method3);
                            if (!map.containsKey(methodSignature3)) {
                                map.put(methodSignature3, method3);
                            }
                        }
                        return;
                    }
                }
                return;
            } catch (SecurityException unused2) {
                Context.reportWarning("Could not discover accessible methods of class " + cls.getName() + " due to lack of privileges, attemping superclasses/interfaces.");
            }
        }
        for (Class<?> cls3 : cls.getInterfaces()) {
            discoverAccessibleMethods(cls3, map, z, z2);
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null) {
            discoverAccessibleMethods(superclass, map, z, z2);
        }
    }

    private static MemberBox extractGetMethod(MemberBox[] memberBoxArr, boolean z) {
        for (MemberBox memberBox : memberBoxArr) {
            if (memberBox.argTypes.length == 0 && (!z || memberBox.isStatic())) {
                if (memberBox.method().getReturnType() != Void.TYPE) {
                    return memberBox;
                }
                return null;
            }
        }
        return null;
    }

    private static MemberBox extractSetMethod(Class<?> cls, MemberBox[] memberBoxArr, boolean z) {
        for (int i = 1; i <= 2; i++) {
            for (MemberBox memberBox : memberBoxArr) {
                if (!z || memberBox.isStatic()) {
                    Class<?>[] clsArr = memberBox.argTypes;
                    if (clsArr.length != 1) {
                        continue;
                    } else if (i != 1) {
                        if (i != 2) {
                            Kit.codeBug();
                        }
                        if (clsArr[0].isAssignableFrom(cls)) {
                            return memberBox;
                        }
                    } else if (clsArr[0] == cls) {
                        return memberBox;
                    }
                }
            }
        }
        return null;
    }

    private MemberBox findExplicitFunction(String str, boolean z) {
        MemberBox[] memberBoxArr;
        int iIndexOf = str.indexOf(40);
        if (iIndexOf < 0) {
            return null;
        }
        Map<String, Object> map = z ? this.staticMembers : this.members;
        if (z && iIndexOf == 0) {
            memberBoxArr = this.ctors.methods;
        } else {
            String strSubstring = str.substring(0, iIndexOf);
            Object obj = map.get(strSubstring);
            if (!z && obj == null) {
                obj = this.staticMembers.get(strSubstring);
            }
            memberBoxArr = obj instanceof NativeJavaMethod ? ((NativeJavaMethod) obj).methods : null;
        }
        if (memberBoxArr != null) {
            for (MemberBox memberBox : memberBoxArr) {
                String strLiveConnectSignature = liveConnectSignature(memberBox.argTypes);
                if (strLiveConnectSignature.length() + iIndexOf == str.length() && str.regionMatches(iIndexOf, strLiveConnectSignature, 0, strLiveConnectSignature.length())) {
                    return memberBox;
                }
            }
        }
        return null;
    }

    private static MemberBox findGetter(boolean z, Map<String, Object> map, String str, String str2) {
        String strConcat = str.concat(str2);
        if (!map.containsKey(strConcat)) {
            return null;
        }
        Object obj = map.get(strConcat);
        if (obj instanceof NativeJavaMethod) {
            return extractGetMethod(((NativeJavaMethod) obj).methods, z);
        }
        return null;
    }

    private Constructor<?>[] getAccessibleConstructors(boolean z) {
        Class<?> cls;
        if (z && (cls = this.cl) != ScriptRuntime.ClassClass) {
            try {
                Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
                AccessibleObject.setAccessible(declaredConstructors, true);
                return declaredConstructors;
            } catch (SecurityException unused) {
                Context.reportWarning("Could not access constructor  of class " + this.cl.getName() + " due to lack of privileges.");
            }
        }
        return this.cl.getConstructors();
    }

    private Field[] getAccessibleFields(boolean z, boolean z2) {
        if (z2 || z) {
            try {
                ArrayList arrayList = new ArrayList();
                for (Class<?> superclass = this.cl; superclass != null; superclass = superclass.getSuperclass()) {
                    for (Field field : superclass.getDeclaredFields()) {
                        int modifiers = field.getModifiers();
                        if (z2 || Modifier.isPublic(modifiers) || Modifier.isProtected(modifiers)) {
                            if (!field.isAccessible()) {
                                field.setAccessible(true);
                            }
                            arrayList.add(field);
                        }
                    }
                }
                return (Field[]) arrayList.toArray(new Field[arrayList.size()]);
            } catch (SecurityException unused) {
            }
        }
        return this.cl.getFields();
    }

    private Object getExplicitFunction(Scriptable scriptable, String str, Object obj, boolean z) {
        Scriptable nativeJavaMethod;
        Map<String, Object> map = z ? this.staticMembers : this.members;
        MemberBox memberBoxFindExplicitFunction = findExplicitFunction(str, z);
        if (memberBoxFindExplicitFunction == null) {
            return null;
        }
        Scriptable functionPrototype = ScriptableObject.getFunctionPrototype(scriptable);
        if (memberBoxFindExplicitFunction.isCtor()) {
            nativeJavaMethod = new NativeJavaConstructor(memberBoxFindExplicitFunction);
        } else {
            Object obj2 = map.get(memberBoxFindExplicitFunction.getName());
            if (!(obj2 instanceof NativeJavaMethod) || ((NativeJavaMethod) obj2).methods.length <= 1) {
                return obj2;
            }
            nativeJavaMethod = new NativeJavaMethod(memberBoxFindExplicitFunction, str);
        }
        nativeJavaMethod.setPrototype(functionPrototype);
        map.put(str, nativeJavaMethod);
        return nativeJavaMethod;
    }

    static String javaSignature(Class<?> cls) {
        if (!cls.isArray()) {
            return cls.getName();
        }
        int i = 0;
        do {
            i++;
            cls = cls.getComponentType();
        } while (cls.isArray());
        String name = cls.getName();
        if (i == 1) {
            return name.concat(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        }
        StringBuilder sb = new StringBuilder(name.length() + (i * 2));
        sb.append(name);
        while (i != 0) {
            i--;
            sb.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        }
        return sb.toString();
    }

    static String liveConnectSignature(Class<?>[] clsArr) {
        int length = clsArr.length;
        if (length == 0) {
            return "()";
        }
        StringBuilder sb = new StringBuilder("(");
        for (int i = 0; i != length; i++) {
            if (i != 0) {
                sb.append(AbstractJsonLexerKt.COMMA);
            }
            sb.append(javaSignature(clsArr[i]));
        }
        sb.append(')');
        return sb.toString();
    }

    static JavaMembers lookupClass(Scriptable scriptable, Class<?> cls, Class<?> cls2, boolean z) {
        ClassCache classCache = ClassCache.get(scriptable);
        Map<Class<?>, JavaMembers> classCacheMap = classCache.getClassCacheMap();
        Class<?> cls3 = cls;
        while (true) {
            JavaMembers javaMembers = classCacheMap.get(cls3);
            if (javaMembers != null) {
                if (cls3 != cls) {
                    classCacheMap.put(cls, javaMembers);
                }
                return javaMembers;
            }
            try {
                JavaMembers javaMembers2 = new JavaMembers(classCache.getAssociatedScope(), cls3, z);
                if (classCache.isCachingEnabled()) {
                    classCacheMap.put(cls3, javaMembers2);
                    if (cls3 != cls) {
                        classCacheMap.put(cls, javaMembers2);
                    }
                }
                return javaMembers2;
            } catch (SecurityException e) {
                if (cls2 == null || !cls2.isInterface()) {
                    Class<? super Object> superclass = cls3.getSuperclass();
                    if (superclass != null) {
                        cls3 = superclass;
                    } else {
                        if (!cls3.isInterface()) {
                            throw e;
                        }
                        cls3 = ScriptRuntime.ObjectClass;
                    }
                } else {
                    cls3 = cls2;
                    cls2 = null;
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:104:0x01de  */
    /* JADX WARN: Code duplicated, block: B:132:0x0240  */
    private void reflect(Scriptable scriptable, boolean z, boolean z2) {
        String lowerCase;
        Object obj;
        NativeJavaMethod nativeJavaMethod;
        MemberBox[] memberBoxArr;
        ObjArray objArray;
        for (Method method : discoverAccessibleMethods(this.cl, z, z2)) {
            Map<String, Object> map = Modifier.isStatic(method.getModifiers()) ? this.staticMembers : this.members;
            String name = method.getName();
            Object obj2 = map.get(name);
            if (obj2 == null) {
                map.put(name, method);
            } else {
                if (obj2 instanceof ObjArray) {
                    objArray = (ObjArray) obj2;
                } else {
                    if (!(obj2 instanceof Method)) {
                        Kit.codeBug();
                    }
                    ObjArray objArray2 = new ObjArray();
                    objArray2.add(obj2);
                    map.put(name, objArray2);
                    objArray = objArray2;
                }
                objArray.add(method);
            }
        }
        int i = 0;
        while (true) {
            int i2 = 1;
            if (i == 2) {
                break;
            }
            Map<String, Object> map2 = i == 0 ? this.staticMembers : this.members;
            for (Map.Entry<String, Object> entry : map2.entrySet()) {
                Object value = entry.getValue();
                if (value instanceof Method) {
                    memberBoxArr = new MemberBox[i2];
                    memberBoxArr[0] = new MemberBox((Method) value);
                } else {
                    ObjArray objArray3 = (ObjArray) value;
                    int size = objArray3.size();
                    if (size < 2) {
                        Kit.codeBug();
                    }
                    MemberBox[] memberBoxArr2 = new MemberBox[size];
                    for (int i3 = 0; i3 != size; i3++) {
                        memberBoxArr2[i3] = new MemberBox((Method) objArray3.get(i3));
                    }
                    memberBoxArr = memberBoxArr2;
                }
                NativeJavaMethod nativeJavaMethod2 = new NativeJavaMethod(memberBoxArr);
                if (scriptable != null) {
                    ScriptRuntime.setFunctionProtoAndParent(nativeJavaMethod2, scriptable);
                }
                map2.put(entry.getKey(), nativeJavaMethod2);
                i2 = 1;
            }
            i++;
        }
        for (Field field : getAccessibleFields(z, z2)) {
            String name2 = field.getName();
            try {
                boolean zIsStatic = Modifier.isStatic(field.getModifiers());
                Map<String, Object> map3 = zIsStatic ? this.staticMembers : this.members;
                Object obj3 = map3.get(name2);
                if (obj3 != null) {
                    if (obj3 instanceof NativeJavaMethod) {
                        FieldAndMethods fieldAndMethods = new FieldAndMethods(scriptable, ((NativeJavaMethod) obj3).methods, field);
                        Map<String, FieldAndMethods> map4 = zIsStatic ? this.staticFieldAndMethods : this.fieldAndMethods;
                        if (map4 == null) {
                            map4 = new HashMap<>();
                            if (zIsStatic) {
                                this.staticFieldAndMethods = map4;
                            } else {
                                this.fieldAndMethods = map4;
                            }
                        }
                        map4.put(name2, fieldAndMethods);
                        map3.put(name2, fieldAndMethods);
                    } else if (!(obj3 instanceof Field)) {
                        Kit.codeBug();
                    } else if (((Field) obj3).getDeclaringClass().isAssignableFrom(field.getDeclaringClass())) {
                    }
                }
                map3.put(name2, field);
            } catch (SecurityException unused) {
                Context.reportWarning("Could not access field " + name2 + " of class " + this.cl.getName() + " due to lack of privileges.");
            }
        }
        int i4 = 0;
        while (i4 != 2) {
            boolean z3 = i4 == 0;
            Map<String, Object> map5 = z3 ? this.staticMembers : this.members;
            Map<? extends String, ? extends Object> map6 = new HashMap<>();
            for (String str : map5.keySet()) {
                boolean zStartsWith = str.startsWith(PasskeyWebListener.GET_UNIQUE_KEY);
                boolean zStartsWith2 = str.startsWith("set");
                boolean zStartsWith3 = str.startsWith("is");
                if (zStartsWith || zStartsWith3 || zStartsWith2) {
                    String strSubstring = str.substring(zStartsWith3 ? 2 : 3);
                    if (strSubstring.length() != 0) {
                        char cCharAt = strSubstring.charAt(0);
                        if (!Character.isUpperCase(cCharAt)) {
                            lowerCase = strSubstring;
                        } else if (strSubstring.length() == 1) {
                            lowerCase = strSubstring.toLowerCase();
                        } else if (Character.isUpperCase(strSubstring.charAt(1))) {
                            lowerCase = strSubstring;
                        } else {
                            lowerCase = Character.toLowerCase(cCharAt) + strSubstring.substring(1);
                        }
                        if (!map6.containsKey(lowerCase) && ((obj = map5.get(lowerCase)) == null || (z2 && (obj instanceof Member) && Modifier.isPrivate(((Member) obj).getModifiers())))) {
                            MemberBox memberBoxFindGetter = findGetter(z3, map5, PasskeyWebListener.GET_UNIQUE_KEY, strSubstring);
                            if (memberBoxFindGetter == null) {
                                memberBoxFindGetter = findGetter(z3, map5, "is", strSubstring);
                            }
                            String strConcat = "set".concat(strSubstring);
                            MemberBox memberBox = null;
                            if (map5.containsKey(strConcat)) {
                                Object obj4 = map5.get(strConcat);
                                if (obj4 instanceof NativeJavaMethod) {
                                    nativeJavaMethod = (NativeJavaMethod) obj4;
                                    MemberBox memberBoxExtractSetMethod = memberBoxFindGetter != null ? extractSetMethod(memberBoxFindGetter.method().getReturnType(), nativeJavaMethod.methods, z3) : extractSetMethod(nativeJavaMethod.methods, z3);
                                    if (nativeJavaMethod.methods.length <= 1) {
                                        nativeJavaMethod = null;
                                    }
                                    memberBox = memberBoxExtractSetMethod;
                                } else {
                                    nativeJavaMethod = null;
                                }
                            } else {
                                nativeJavaMethod = null;
                            }
                            map6.put(lowerCase, new BeanProperty(memberBoxFindGetter, memberBox, nativeJavaMethod));
                        }
                    }
                }
            }
            map5.putAll(map6);
            i4++;
        }
        Constructor<?>[] accessibleConstructors = getAccessibleConstructors(z2);
        MemberBox[] memberBoxArr3 = new MemberBox[accessibleConstructors.length];
        for (int i5 = 0; i5 != accessibleConstructors.length; i5++) {
            memberBoxArr3[i5] = new MemberBox(accessibleConstructors[i5]);
        }
        this.ctors = new NativeJavaMethod(memberBoxArr3, this.cl.getSimpleName());
    }

    Object get(Scriptable scriptable, String str, Object obj, boolean z) {
        Object objInvoke;
        Class<?> type;
        Object explicitFunction = (z ? this.staticMembers : this.members).get(str);
        if (!z && explicitFunction == null) {
            explicitFunction = this.staticMembers.get(str);
        }
        if (explicitFunction == null && (explicitFunction = getExplicitFunction(scriptable, str, obj, z)) == null) {
            return Scriptable.NOT_FOUND;
        }
        if (explicitFunction instanceof Scriptable) {
            return explicitFunction;
        }
        Context context = Context.getContext();
        try {
            if (explicitFunction instanceof BeanProperty) {
                BeanProperty beanProperty = (BeanProperty) explicitFunction;
                MemberBox memberBox = beanProperty.getter;
                if (memberBox == null) {
                    return Scriptable.NOT_FOUND;
                }
                objInvoke = memberBox.invoke(obj, Context.emptyArgs);
                type = beanProperty.getter.method().getReturnType();
            } else {
                Field field = (Field) explicitFunction;
                if (z) {
                    obj = null;
                }
                objInvoke = field.get(obj);
                type = field.getType();
            }
            return context.getWrapFactory().wrap(context, ScriptableObject.getTopLevelScope(scriptable), objInvoke, type);
        } catch (Exception e) {
            throw Context.throwAsScriptRuntimeEx(e);
        }
    }

    Map<String, FieldAndMethods> getFieldAndMethodsObjects(Scriptable scriptable, Object obj, boolean z) {
        Map<String, FieldAndMethods> map = z ? this.staticFieldAndMethods : this.fieldAndMethods;
        if (map == null) {
            return null;
        }
        HashMap map2 = new HashMap(map.size());
        for (FieldAndMethods fieldAndMethods : map.values()) {
            FieldAndMethods fieldAndMethods2 = new FieldAndMethods(scriptable, fieldAndMethods.methods, fieldAndMethods.field);
            fieldAndMethods2.javaObject = obj;
            map2.put(fieldAndMethods.field.getName(), fieldAndMethods2);
        }
        return map2;
    }

    Object[] getIds(boolean z) {
        Map<String, Object> map = z ? this.staticMembers : this.members;
        return map.keySet().toArray(new Object[map.size()]);
    }

    boolean has(String str, boolean z) {
        return ((z ? this.staticMembers : this.members).get(str) == null && findExplicitFunction(str, z) == null) ? false : true;
    }

    void put(Scriptable scriptable, String str, Object obj, Object obj2, boolean z) {
        Map<String, Object> map = z ? this.staticMembers : this.members;
        Object obj3 = map.get(str);
        if (!z && obj3 == null) {
            obj3 = this.staticMembers.get(str);
        }
        if (obj3 == null) {
            throw reportMemberNotFound(str);
        }
        if (obj3 instanceof FieldAndMethods) {
            obj3 = ((FieldAndMethods) map.get(str)).field;
        }
        if (!(obj3 instanceof BeanProperty)) {
            if (!(obj3 instanceof Field)) {
                throw Context.reportRuntimeError1(obj3 == null ? "msg.java.internal.private" : "msg.java.method.assign", str);
            }
            Field field = (Field) obj3;
            try {
                field.set(obj, Context.jsToJava(obj2, field.getType()));
                return;
            } catch (IllegalAccessException e) {
                if ((field.getModifiers() & 16) == 0) {
                    throw Context.throwAsScriptRuntimeEx(e);
                }
                return;
            } catch (IllegalArgumentException unused) {
                throw Context.reportRuntimeError3("msg.java.internal.field.type", obj2.getClass().getName(), field, obj.getClass().getName());
            }
        }
        BeanProperty beanProperty = (BeanProperty) obj3;
        MemberBox memberBox = beanProperty.setter;
        if (memberBox == null) {
            throw reportMemberNotFound(str);
        }
        NativeJavaMethod nativeJavaMethod = beanProperty.setters;
        if (nativeJavaMethod != null && obj2 != null) {
            nativeJavaMethod.call(Context.getContext(), ScriptableObject.getTopLevelScope(scriptable), scriptable, new Object[]{obj2});
            return;
        }
        try {
            beanProperty.setter.invoke(obj, new Object[]{Context.jsToJava(obj2, memberBox.argTypes[0])});
        } catch (Exception e2) {
            throw Context.throwAsScriptRuntimeEx(e2);
        }
    }

    RuntimeException reportMemberNotFound(String str) {
        return Context.reportRuntimeError2("msg.java.member.not.found", this.cl.getName(), str);
    }

    JavaMembers(Scriptable scriptable, Class<?> cls, boolean z) {
        try {
            Context contextEnterContext = ContextFactory.getGlobal().enterContext();
            ClassShutter classShutter = contextEnterContext.getClassShutter();
            if (classShutter != null && !classShutter.visibleToScripts(cls.getName())) {
                throw Context.reportRuntimeError1("msg.access.prohibited", cls.getName());
            }
            this.members = new HashMap();
            this.staticMembers = new HashMap();
            this.cl = cls;
            reflect(scriptable, z, contextEnterContext.hasFeature(13));
            Context.exit();
        } catch (Throwable th) {
            Context.exit();
            throw th;
        }
    }

    private static Method[] discoverAccessibleMethods(Class<?> cls, boolean z, boolean z2) {
        HashMap map = new HashMap();
        discoverAccessibleMethods(cls, map, z, z2);
        return (Method[]) map.values().toArray(new Method[map.size()]);
    }

    private static MemberBox extractSetMethod(MemberBox[] memberBoxArr, boolean z) {
        for (MemberBox memberBox : memberBoxArr) {
            if ((!z || memberBox.isStatic()) && memberBox.method().getReturnType() == Void.TYPE && memberBox.argTypes.length == 1) {
                return memberBox;
            }
        }
        return null;
    }
}
