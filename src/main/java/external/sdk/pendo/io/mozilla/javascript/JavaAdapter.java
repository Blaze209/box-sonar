package external.sdk.pendo.io.mozilla.javascript;

import androidx.media3.extractor.ts.PsExtractor;
import androidx.media3.extractor.ts.TsExtractor;
import com.pspdfkit.analytics.Analytics;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import sdk.pendo.io.d2.c;

/* JADX INFO: loaded from: classes4.dex */
public final class JavaAdapter implements IdFunctionCall {
    private static final Object FTAG = "JavaAdapter";
    private static final int Id_JavaAdapter = 1;

    static class JavaAdapterSignature {
        Class<?>[] interfaces;
        ObjToIntMap names;
        Class<?> superClass;

        JavaAdapterSignature(Class<?> cls, Class<?>[] clsArr, ObjToIntMap objToIntMap) {
            this.superClass = cls;
            this.interfaces = clsArr;
            this.names = objToIntMap;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof JavaAdapterSignature)) {
                return false;
            }
            JavaAdapterSignature javaAdapterSignature = (JavaAdapterSignature) obj;
            if (this.superClass != javaAdapterSignature.superClass) {
                return false;
            }
            Class<?>[] clsArr = this.interfaces;
            Class<?>[] clsArr2 = javaAdapterSignature.interfaces;
            if (clsArr != clsArr2) {
                if (clsArr.length == clsArr2.length) {
                    int i = 0;
                    while (true) {
                        Class<?>[] clsArr3 = this.interfaces;
                        if (i >= clsArr3.length) {
                            break;
                        }
                        if (clsArr3[i] != javaAdapterSignature.interfaces[i]) {
                            return false;
                        }
                        i++;
                    }
                } else {
                    return false;
                }
            }
            if (this.names.size() != javaAdapterSignature.names.size()) {
                return false;
            }
            ObjToIntMap.Iterator iterator = new ObjToIntMap.Iterator(this.names);
            iterator.start();
            while (!iterator.done()) {
                String str = (String) iterator.getKey();
                int value = iterator.getValue();
                if (value != javaAdapterSignature.names.get(str, value + 1)) {
                    return false;
                }
                iterator.next();
            }
            return true;
        }

        public int hashCode() {
            return this.names.size() ^ (this.superClass.hashCode() + Arrays.hashCode(this.interfaces));
        }
    }

    static int appendMethodSignature(Class<?>[] clsArr, Class<?> cls, StringBuilder sb) {
        sb.append('(');
        int length = clsArr.length + 1;
        for (Class<?> cls2 : clsArr) {
            appendTypeString(sb, cls2);
            if (cls2 == Long.TYPE || cls2 == Double.TYPE) {
                length++;
            }
        }
        sb.append(')');
        appendTypeString(sb, cls);
        return length;
    }

    private static void appendOverridableMethods(Class<?> cls, ArrayList<Method> arrayList, HashSet<String> hashSet) {
        Method[] declaredMethods = cls.getDeclaredMethods();
        for (int i = 0; i < declaredMethods.length; i++) {
            StringBuilder sbAppend = new StringBuilder().append(declaredMethods[i].getName());
            Method method = declaredMethods[i];
            String string = sbAppend.append(getMethodSignature(method, method.getParameterTypes())).toString();
            if (!hashSet.contains(string)) {
                int modifiers = declaredMethods[i].getModifiers();
                if (!Modifier.isStatic(modifiers)) {
                    if (Modifier.isFinal(modifiers)) {
                        hashSet.add(string);
                    } else if (Modifier.isPublic(modifiers) || Modifier.isProtected(modifiers)) {
                        arrayList.add(declaredMethods[i]);
                        hashSet.add(string);
                    }
                }
            }
        }
    }

    private static StringBuilder appendTypeString(StringBuilder sb, Class<?> cls) {
        char upperCase;
        while (cls.isArray()) {
            sb.append(AbstractJsonLexerKt.BEGIN_LIST);
            cls = cls.getComponentType();
        }
        if (!cls.isPrimitive()) {
            sb.append('L');
            sb.append(cls.getName().replace('.', '/'));
            sb.append(';');
            return sb;
        }
        if (cls == Boolean.TYPE) {
            upperCase = 'Z';
        } else {
            upperCase = cls == Long.TYPE ? 'J' : Character.toUpperCase(cls.getName().charAt(0));
        }
        sb.append(upperCase);
        return sb;
    }

    public static Object callMethod(ContextFactory contextFactory, final Scriptable scriptable, final Function function, final Object[] objArr, final long j) {
        if (function == null) {
            return null;
        }
        if (contextFactory == null) {
            contextFactory = ContextFactory.getGlobal();
        }
        final Scriptable parentScope = function.getParentScope();
        if (j == 0) {
            return Context.call(contextFactory, function, parentScope, scriptable, objArr);
        }
        Context currentContext = Context.getCurrentContext();
        return currentContext != null ? doCall(currentContext, parentScope, scriptable, function, objArr, j) : contextFactory.call(new ContextAction() { // from class: external.sdk.pendo.io.mozilla.javascript.JavaAdapter$$ExternalSyntheticLambda1
            @Override // external.sdk.pendo.io.mozilla.javascript.ContextAction
            public final Object run(Context context) {
                return JavaAdapter.doCall(context, parentScope, scriptable, function, objArr, j);
            }
        });
    }

    public static Object convertResult(Object obj, Class<?> cls) {
        if (obj != Undefined.instance || cls == ScriptRuntime.ObjectClass || cls == ScriptRuntime.StringClass) {
            return Context.jsToJava(obj, cls);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:61:0x0165  */
    public static byte[] createAdapterCode(ObjToIntMap objToIntMap, String str, Class<?> cls, Class<?>[] clsArr, String str2) {
        String str3;
        c cVar;
        String str4;
        String str5 = str;
        c cVar2 = new c(str5, cls.getName(), "<adapter>");
        cVar2.a("factory", "Lexternal/sdk/pendo/io/mozilla/javascript/ContextFactory;", (short) 17);
        cVar2.a("delegee", "Lexternal/sdk/pendo/io/mozilla/javascript/Scriptable;", (short) 17);
        cVar2.a("self", "Lexternal/sdk/pendo/io/mozilla/javascript/Scriptable;", (short) 17);
        int length = clsArr == null ? 0 : clsArr.length;
        for (int i = 0; i < length; i++) {
            Class<?> cls2 = clsArr[i];
            if (cls2 != null) {
                cVar2.c(cls2.getName());
            }
        }
        String strReplace = cls.getName().replace('.', '/');
        for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
            int modifiers = constructor.getModifiers();
            if (Modifier.isPublic(modifiers) || Modifier.isProtected(modifiers)) {
                generateCtor(cVar2, str5, strReplace, constructor);
            }
        }
        generateSerialCtor(cVar2, str5, strReplace);
        if (str2 != null) {
            generateEmptyCtor(cVar2, str5, strReplace, str2);
        }
        ObjToIntMap objToIntMap2 = new ObjToIntMap();
        ObjToIntMap objToIntMap3 = new ObjToIntMap();
        int i2 = 0;
        while (i2 < length) {
            Method[] methods = clsArr[i2].getMethods();
            int i3 = 0;
            while (i3 < methods.length) {
                Method method = methods[i3];
                int modifiers2 = method.getModifiers();
                if (Modifier.isStatic(modifiers2) || Modifier.isFinal(modifiers2) || method.isDefault()) {
                    cVar = cVar2;
                } else {
                    c cVar3 = cVar2;
                    String name = method.getName();
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (!objToIntMap.has(name)) {
                        try {
                            cls.getMethod(name, parameterTypes);
                        } catch (NoSuchMethodException unused) {
                            str4 = name + getMethodSignature(method, parameterTypes);
                            if (objToIntMap2.has(str4)) {
                                Class<?> returnType = method.getReturnType();
                                cVar = cVar3;
                                generateMethod(cVar, str5, name, parameterTypes, returnType, true);
                                objToIntMap2.put(str4, 0);
                                objToIntMap3.put(name, 0);
                            }
                            i3++;
                            str5 = str;
                            cVar2 = cVar;
                        }
                        cVar = cVar3;
                    }
                    str4 = name + getMethodSignature(method, parameterTypes);
                    if (objToIntMap2.has(str4)) {
                        cVar = cVar3;
                    } else {
                        Class<?> returnType2 = method.getReturnType();
                        cVar = cVar3;
                        generateMethod(cVar, str5, name, parameterTypes, returnType2, true);
                        objToIntMap2.put(str4, 0);
                        objToIntMap3.put(name, 0);
                    }
                }
                i3++;
                str5 = str;
                cVar2 = cVar;
            }
            i2++;
            str5 = str;
        }
        c cVar4 = cVar2;
        Method[] overridableMethods = getOverridableMethods(cls);
        int i4 = 0;
        while (i4 < overridableMethods.length) {
            Method method2 = overridableMethods[i4];
            boolean zIsAbstract = Modifier.isAbstract(method2.getModifiers());
            String name2 = method2.getName();
            if (zIsAbstract || objToIntMap.has(name2)) {
                Class<?>[] parameterTypes2 = method2.getParameterTypes();
                String methodSignature = getMethodSignature(method2, parameterTypes2);
                String str6 = name2 + methodSignature;
                if (objToIntMap2.has(str6)) {
                    str3 = strReplace;
                } else {
                    generateMethod(cVar4, str, name2, parameterTypes2, method2.getReturnType(), true);
                    c cVar5 = cVar4;
                    objToIntMap2.put(str6, 0);
                    objToIntMap3.put(name2, 0);
                    if (zIsAbstract) {
                        cVar4 = cVar5;
                        str3 = strReplace;
                    } else {
                        cVar4 = cVar5;
                        str3 = strReplace;
                        generateSuper(cVar4, str, str3, name2, methodSignature, parameterTypes2, method2.getReturnType());
                    }
                }
            } else {
                str3 = strReplace;
            }
            i4++;
            strReplace = str3;
        }
        ObjToIntMap.Iterator iterator = new ObjToIntMap.Iterator(objToIntMap);
        iterator.start();
        while (!iterator.done()) {
            String str7 = (String) iterator.getKey();
            if (!objToIntMap3.has(str7)) {
                int value = iterator.getValue();
                Class[] clsArr2 = new Class[value];
                for (int i5 = 0; i5 < value; i5++) {
                    clsArr2[i5] = ScriptRuntime.ObjectClass;
                }
                c cVar6 = cVar4;
                generateMethod(cVar6, str, str7, clsArr2, ScriptRuntime.ObjectClass, false);
                cVar4 = cVar6;
            }
            iterator.next();
        }
        return cVar4.j();
    }

    public static Scriptable createAdapterWrapper(Scriptable scriptable, Object obj) {
        NativeJavaObject nativeJavaObject = new NativeJavaObject(ScriptableObject.getTopLevelScope(scriptable), obj, null, true);
        nativeJavaObject.setPrototype(scriptable);
        return nativeJavaObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object doCall(Context context, Scriptable scriptable, Scriptable scriptable2, Function function, Object[] objArr, long j) {
        for (int i = 0; i != objArr.length; i++) {
            if (0 != (((long) (1 << i)) & j)) {
                Object obj = objArr[i];
                if (!(obj instanceof Scriptable)) {
                    objArr[i] = context.getWrapFactory().wrap(context, scriptable, obj, null);
                }
            }
        }
        return function.call(context, scriptable, scriptable2, objArr);
    }

    private static void generateCtor(c cVar, String str, String str2, Constructor<?> constructor) {
        String string;
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        short sGeneratePushParam = 3;
        if (parameterTypes.length == 0) {
            cVar.b("<init>", "(Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/ContextFactory;)V", (short) 1);
            cVar.b(42);
            string = "()V";
        } else {
            StringBuilder sb = new StringBuilder("(Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/ContextFactory;");
            int length = sb.length();
            for (Class<?> cls : parameterTypes) {
                appendTypeString(sb, cls);
            }
            sb.append(")V");
            cVar.b("<init>", sb.toString(), (short) 1);
            cVar.b(42);
            for (Class<?> cls2 : parameterTypes) {
                sGeneratePushParam = (short) (sGeneratePushParam + generatePushParam(cVar, sGeneratePushParam, cls2));
            }
            sb.delete(1, length);
            string = sb.toString();
        }
        cVar.b(183, str2, "<init>", string);
        cVar.b(42);
        cVar.b(43);
        cVar.a(181, str, "delegee", "Lexternal/sdk/pendo/io/mozilla/javascript/Scriptable;");
        cVar.b(42);
        cVar.b(44);
        cVar.a(181, str, "factory", "Lexternal/sdk/pendo/io/mozilla/javascript/ContextFactory;");
        cVar.b(42);
        cVar.b(43);
        cVar.b(42);
        cVar.b(184, "external/sdk/pendo/io/mozilla/javascript/JavaAdapter", "createAdapterWrapper", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;");
        cVar.a(181, str, "self", "Lexternal/sdk/pendo/io/mozilla/javascript/Scriptable;");
        cVar.b(177);
        cVar.c(sGeneratePushParam);
    }

    private static void generateEmptyCtor(c cVar, String str, String str2, String str3) {
        cVar.b("<init>", "()V", (short) 1);
        cVar.b(42);
        cVar.b(183, str2, "<init>", "()V");
        cVar.b(42);
        cVar.b(1);
        cVar.a(181, str, "factory", "Lexternal/sdk/pendo/io/mozilla/javascript/ContextFactory;");
        cVar.a(187, str3);
        cVar.b(89);
        cVar.b(183, str3, "<init>", "()V");
        cVar.b(184, "external/sdk/pendo/io/mozilla/javascript/JavaAdapter", "runScript", "(Lorg/mozilla/javascript/Script;)Lorg/mozilla/javascript/Scriptable;");
        cVar.b(76);
        cVar.b(42);
        cVar.b(43);
        cVar.a(181, str, "delegee", "Lexternal/sdk/pendo/io/mozilla/javascript/Scriptable;");
        cVar.b(42);
        cVar.b(43);
        cVar.b(42);
        cVar.b(184, "external/sdk/pendo/io/mozilla/javascript/JavaAdapter", "createAdapterWrapper", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;");
        cVar.a(181, str, "self", "Lexternal/sdk/pendo/io/mozilla/javascript/Scriptable;");
        cVar.b(177);
        cVar.c((short) 2);
    }

    private static void generateMethod(c cVar, String str, String str2, Class<?>[] clsArr, Class<?> cls, boolean z) {
        StringBuilder sb = new StringBuilder();
        int iAppendMethodSignature = appendMethodSignature(clsArr, cls, sb);
        cVar.b(str2, sb.toString(), (short) 1);
        cVar.b(42);
        cVar.a(180, str, "factory", "Lexternal/sdk/pendo/io/mozilla/javascript/ContextFactory;");
        cVar.b(42);
        cVar.a(180, str, "self", "Lexternal/sdk/pendo/io/mozilla/javascript/Scriptable;");
        cVar.b(42);
        cVar.a(180, str, "delegee", "Lexternal/sdk/pendo/io/mozilla/javascript/Scriptable;");
        cVar.e(str2);
        cVar.b(184, "external/sdk/pendo/io/mozilla/javascript/JavaAdapter", "getFunction", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/String;)Lorg/mozilla/javascript/Function;");
        generatePushWrappedArgs(cVar, clsArr, clsArr.length);
        if (clsArr.length > 64) {
            throw Context.reportRuntimeError0("JavaAdapter can not subclass methods with more then 64 arguments.");
        }
        long j = 0;
        for (int i = 0; i != clsArr.length; i++) {
            if (!clsArr[i].isPrimitive()) {
                j |= (long) (1 << i);
            }
        }
        cVar.b(j);
        cVar.b(184, "external/sdk/pendo/io/mozilla/javascript/JavaAdapter", "callMethod", "(Lorg/mozilla/javascript/ContextFactory;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Function;[Ljava/lang/Object;J)Ljava/lang/Object;");
        generateReturnResult(cVar, cls, z);
        cVar.c((short) iAppendMethodSignature);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0030  */
    private static void generatePopResult(c cVar, Class<?> cls) {
        int i;
        if (cls.isPrimitive()) {
            char cCharAt = cls.getName().charAt(0);
            if (cCharAt == 'f') {
                i = 174;
            } else if (cCharAt == 'i') {
                i = TsExtractor.TS_STREAM_TYPE_AC4;
            } else if (cCharAt == 'l') {
                i = 173;
            } else if (cCharAt == 's' || cCharAt == 'z') {
                i = TsExtractor.TS_STREAM_TYPE_AC4;
            } else {
                switch (cCharAt) {
                    case 'b':
                    case 'c':
                        i = TsExtractor.TS_STREAM_TYPE_AC4;
                        break;
                    case 'd':
                        i = 175;
                        break;
                    default:
                        return;
                }
            }
        } else {
            i = 176;
        }
        cVar.b(i);
    }

    private static int generatePushParam(c cVar, int i, Class<?> cls) {
        if (!cls.isPrimitive()) {
            cVar.c(i);
            return 1;
        }
        char cCharAt = cls.getName().charAt(0);
        if (cCharAt == 'f') {
            cVar.g(i);
            return 1;
        }
        if (cCharAt != 'i') {
            if (cCharAt == 'l') {
                cVar.j(i);
                return 2;
            }
            if (cCharAt != 's' && cCharAt != 'z') {
                switch (cCharAt) {
                    case 'b':
                    case 'c':
                        break;
                    case 'd':
                        cVar.e(i);
                        return 2;
                    default:
                        throw Kit.codeBug();
                }
            }
        }
        cVar.h(i);
        return 1;
    }

    static void generatePushWrappedArgs(c cVar, Class<?>[] clsArr, int i) {
        cVar.l(i);
        cVar.a(PsExtractor.PRIVATE_STREAM_1, "java/lang/Object");
        int iGenerateWrapArg = 1;
        for (int i2 = 0; i2 != clsArr.length; i2++) {
            cVar.b(89);
            cVar.l(i2);
            iGenerateWrapArg += generateWrapArg(cVar, iGenerateWrapArg, clsArr[i2]);
            cVar.b(83);
        }
    }

    static void generateReturnResult(c cVar, Class<?> cls, boolean z) {
        if (cls == Void.TYPE) {
            cVar.b(87);
            cVar.b(177);
            return;
        }
        if (cls == Boolean.TYPE) {
            cVar.b(184, "external/sdk/pendo/io/mozilla/javascript/Context", "toBoolean", "(Ljava/lang/Object;)Z");
            cVar.b(TsExtractor.TS_STREAM_TYPE_AC4);
            return;
        }
        if (cls == Character.TYPE) {
            cVar.b(184, "external/sdk/pendo/io/mozilla/javascript/Context", "toString", "(Ljava/lang/Object;)Ljava/lang/String;");
            cVar.b(3);
            cVar.b(182, "java/lang/String", "charAt", "(I)C");
            cVar.b(TsExtractor.TS_STREAM_TYPE_AC4);
            return;
        }
        if (!cls.isPrimitive()) {
            String name = cls.getName();
            if (z) {
                cVar.d(name);
                cVar.b(184, "java/lang/Class", "forName", "(Ljava/lang/String;)Ljava/lang/Class;");
                cVar.b(184, "external/sdk/pendo/io/mozilla/javascript/JavaAdapter", "convertResult", "(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;");
            }
            cVar.a(192, name);
            cVar.b(176);
            return;
        }
        cVar.b(184, "external/sdk/pendo/io/mozilla/javascript/Context", "toNumber", "(Ljava/lang/Object;)D");
        char cCharAt = cls.getName().charAt(0);
        if (cCharAt != 'b') {
            if (cCharAt == 'd') {
                cVar.b(175);
                return;
            }
            if (cCharAt == 'f') {
                cVar.b(Token.DOTDOT);
                cVar.b(174);
                return;
            } else if (cCharAt != 'i') {
                if (cCharAt == 'l') {
                    cVar.b(Token.SET_REF_OP);
                    cVar.b(173);
                    return;
                } else if (cCharAt != 's') {
                    throw new RuntimeException("Unexpected return type " + cls);
                }
            }
        }
        cVar.b(Token.LOCAL_BLOCK);
        cVar.b(TsExtractor.TS_STREAM_TYPE_AC4);
    }

    private static void generateSerialCtor(c cVar, String str, String str2) {
        cVar.b("<init>", "(Lorg/mozilla/javascript/ContextFactory;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;)V", (short) 1);
        cVar.b(42);
        cVar.b(183, str2, "<init>", "()V");
        cVar.b(42);
        cVar.b(43);
        cVar.a(181, str, "factory", "Lexternal/sdk/pendo/io/mozilla/javascript/ContextFactory;");
        cVar.b(42);
        cVar.b(44);
        cVar.a(181, str, "delegee", "Lexternal/sdk/pendo/io/mozilla/javascript/Scriptable;");
        cVar.b(42);
        cVar.b(45);
        cVar.a(181, str, "self", "Lexternal/sdk/pendo/io/mozilla/javascript/Scriptable;");
        cVar.b(177);
        cVar.c((short) 4);
    }

    private static void generateSuper(c cVar, String str, String str2, String str3, String str4, Class<?>[] clsArr, Class<?> cls) {
        cVar.b("super$" + str3, str4, (short) 1);
        cVar.a(25, 0);
        int iGeneratePushParam = 1;
        for (Class<?> cls2 : clsArr) {
            iGeneratePushParam += generatePushParam(cVar, iGeneratePushParam, cls2);
        }
        cVar.b(183, str2, str3, str4);
        if (cls.equals(Void.TYPE)) {
            cVar.b(177);
        } else {
            generatePopResult(cVar, cls);
        }
        cVar.c((short) (iGeneratePushParam + 1));
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x006b, code lost:
    
        if (r9 != 's') goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int generateWrapArg(sdk.pendo.io.d2.c r7, int r8, java.lang.Class<?> r9) {
        /*
            boolean r0 = r9.isPrimitive()
            r1 = 1
            if (r0 != 0) goto Ld
            r9 = 25
            r7.a(r9, r8)
            return r1
        Ld:
            java.lang.Class r0 = java.lang.Boolean.TYPE
            java.lang.String r2 = "<init>"
            r3 = 183(0xb7, float:2.56E-43)
            r4 = 89
            r5 = 187(0xbb, float:2.62E-43)
            r6 = 21
            if (r9 != r0) goto L2d
            java.lang.String r9 = "java/lang/Boolean"
            r7.a(r5, r9)
            r7.b(r4)
            r7.a(r6, r8)
            java.lang.String r8 = "(Z)V"
            r7.b(r3, r9, r2, r8)
            return r1
        L2d:
            java.lang.Class r0 = java.lang.Character.TYPE
            if (r9 != r0) goto L42
            r7.a(r6, r8)
            java.lang.String r8 = "valueOf"
            java.lang.String r9 = "(C)Ljava/lang/String;"
            r0 = 184(0xb8, float:2.58E-43)
            java.lang.String r2 = "java/lang/String"
            r7.b(r0, r2, r8, r9)
            return r1
        L42:
            java.lang.String r0 = "java/lang/Double"
            r7.a(r5, r0)
            r7.b(r4)
            java.lang.String r9 = r9.getName()
            r4 = 0
            char r9 = r9.charAt(r4)
            r4 = 98
            if (r9 == r4) goto L88
            r4 = 100
            r5 = 2
            if (r9 == r4) goto L81
            r4 = 102(0x66, float:1.43E-43)
            if (r9 == r4) goto L79
            r4 = 105(0x69, float:1.47E-43)
            if (r9 == r4) goto L88
            r4 = 108(0x6c, float:1.51E-43)
            if (r9 == r4) goto L6e
            r4 = 115(0x73, float:1.61E-43)
            if (r9 == r4) goto L88
            goto L90
        L6e:
            r9 = 22
            r7.a(r9, r8)
            r8 = 138(0x8a, float:1.93E-43)
            r7.b(r8)
            goto L86
        L79:
            r9 = 23
            r7.a(r9, r8)
            r8 = 141(0x8d, float:1.98E-43)
            goto L8d
        L81:
            r9 = 24
            r7.a(r9, r8)
        L86:
            r1 = r5
            goto L90
        L88:
            r7.a(r6, r8)
            r8 = 135(0x87, float:1.89E-43)
        L8d:
            r7.b(r8)
        L90:
            java.lang.String r8 = "(D)V"
            r7.b(r3, r0, r2, r8)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.JavaAdapter.generateWrapArg(sdk.pendo.io.d2.c, int, java.lang.Class):int");
    }

    private static Class<?> getAdapterClass(Scriptable scriptable, Class<?> cls, Class<?>[] clsArr, Scriptable scriptable2) {
        ClassCache classCache = ClassCache.get(scriptable);
        Map<JavaAdapterSignature, Class<?>> interfaceAdapterCacheMap = classCache.getInterfaceAdapterCacheMap();
        ObjToIntMap objectFunctionNames = getObjectFunctionNames(scriptable2);
        JavaAdapterSignature javaAdapterSignature = new JavaAdapterSignature(cls, clsArr, objectFunctionNames);
        Class<?> cls2 = interfaceAdapterCacheMap.get(javaAdapterSignature);
        if (cls2 != null) {
            return cls2;
        }
        String str = "adapter" + classCache.newClassSerialNumber();
        Class<?> clsLoadAdapterClass = loadAdapterClass(str, createAdapterCode(objectFunctionNames, str, cls, clsArr, null));
        if (classCache.isCachingEnabled()) {
            interfaceAdapterCacheMap.put(javaAdapterSignature, clsLoadAdapterClass);
        }
        return clsLoadAdapterClass;
    }

    public static Object getAdapterSelf(Class<?> cls, Object obj) {
        return cls.getDeclaredField("self").get(obj);
    }

    static int[] getArgsToConvert(Class<?>[] clsArr) {
        int i = 0;
        for (int i2 = 0; i2 != clsArr.length; i2++) {
            if (!clsArr[i2].isPrimitive()) {
                i++;
            }
        }
        if (i == 0) {
            return null;
        }
        int[] iArr = new int[i];
        int i3 = 0;
        for (int i4 = 0; i4 != clsArr.length; i4++) {
            if (!clsArr[i4].isPrimitive()) {
                iArr[i3] = i4;
                i3++;
            }
        }
        return iArr;
    }

    public static Function getFunction(Scriptable scriptable, String str) {
        Object property = ScriptableObject.getProperty(scriptable, str);
        if (property == Scriptable.NOT_FOUND) {
            return null;
        }
        if (property instanceof Function) {
            return (Function) property;
        }
        throw ScriptRuntime.notFunctionError(property, str);
    }

    private static String getMethodSignature(Method method, Class<?>[] clsArr) {
        StringBuilder sb = new StringBuilder();
        appendMethodSignature(clsArr, method.getReturnType(), sb);
        return sb.toString();
    }

    private static ObjToIntMap getObjectFunctionNames(Scriptable scriptable) {
        Object[] propertyIds = ScriptableObject.getPropertyIds(scriptable);
        ObjToIntMap objToIntMap = new ObjToIntMap(propertyIds.length);
        for (int i = 0; i != propertyIds.length; i++) {
            Object obj = propertyIds[i];
            if (obj instanceof String) {
                String str = (String) obj;
                Object property = ScriptableObject.getProperty(scriptable, str);
                if (property instanceof Function) {
                    int int32 = ScriptRuntime.toInt32(ScriptableObject.getProperty((Function) property, Analytics.Data.LENGTH));
                    if (int32 < 0) {
                        int32 = 0;
                    }
                    objToIntMap.put(str, int32);
                }
            }
        }
        return objToIntMap;
    }

    static Method[] getOverridableMethods(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        for (Class<?> superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
            appendOverridableMethods(superclass, arrayList, hashSet);
        }
        while (cls != null) {
            for (Class<?> cls2 : cls.getInterfaces()) {
                appendOverridableMethods(cls2, arrayList, hashSet);
            }
            cls = cls.getSuperclass();
        }
        return (Method[]) arrayList.toArray(new Method[arrayList.size()]);
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        IdFunctionObject idFunctionObject = new IdFunctionObject(new JavaAdapter(), FTAG, 1, "JavaAdapter", 1, scriptable);
        idFunctionObject.markAsConstructor(null);
        if (z) {
            idFunctionObject.sealObject();
        }
        idFunctionObject.exportAsScopeProperty();
    }

    static Object js_createAdapter(Context context, Scriptable scriptable, Object[] objArr) {
        Object objNewInstance;
        int length = objArr.length;
        if (length == 0) {
            throw ScriptRuntime.typeError0("msg.adapter.zero.args");
        }
        int i = 0;
        while (i < length - 1) {
            Object obj = objArr[i];
            if (obj instanceof NativeObject) {
                break;
            }
            if (!(obj instanceof NativeJavaClass)) {
                throw ScriptRuntime.typeError2("msg.not.java.class.arg", String.valueOf(i), ScriptRuntime.toString(obj));
            }
            i++;
        }
        Class[] clsArr = new Class[i];
        Class<?> cls = null;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Class<?> classObject = ((NativeJavaClass) objArr[i3]).getClassObject();
            if (classObject.isInterface()) {
                clsArr[i2] = classObject;
                i2++;
            } else {
                if (cls != null) {
                    throw ScriptRuntime.typeError2("msg.only.one.super", cls.getName(), classObject.getName());
                }
                cls = classObject;
            }
        }
        if (cls == null) {
            cls = ScriptRuntime.ObjectClass;
        }
        Class[] clsArr2 = new Class[i2];
        System.arraycopy(clsArr, 0, clsArr2, 0, i2);
        Scriptable scriptableEnsureScriptable = ScriptableObject.ensureScriptable(objArr[i]);
        Class<?> adapterClass = getAdapterClass(scriptable, cls, clsArr2, scriptableEnsureScriptable);
        int i4 = length - i;
        int i5 = i4 - 1;
        try {
            if (i5 > 0) {
                Object[] objArr2 = new Object[i4 + 1];
                objArr2[0] = scriptableEnsureScriptable;
                objArr2[1] = context.getFactory();
                System.arraycopy(objArr, i + 1, objArr2, 2, i5);
                NativeJavaMethod nativeJavaMethod = new NativeJavaClass(scriptable, adapterClass, true).members.ctors;
                int iFindCachedFunction = nativeJavaMethod.findCachedFunction(context, objArr2);
                if (iFindCachedFunction < 0) {
                    throw Context.reportRuntimeError2("msg.no.java.ctor", adapterClass.getName(), NativeJavaMethod.scriptSignature(objArr));
                }
                objNewInstance = NativeJavaClass.constructInternal(objArr2, nativeJavaMethod.methods[iFindCachedFunction]);
            } else {
                objNewInstance = adapterClass.getConstructor(ScriptRuntime.ScriptableClass, ScriptRuntime.ContextFactoryClass).newInstance(scriptableEnsureScriptable, context.getFactory());
            }
            Object adapterSelf = getAdapterSelf(adapterClass, objNewInstance);
            if (adapterSelf instanceof Wrapper) {
                Object objUnwrap = ((Wrapper) adapterSelf).unwrap();
                if (objUnwrap instanceof Scriptable) {
                    if (objUnwrap instanceof ScriptableObject) {
                        ScriptRuntime.setObjectProtoAndParent((ScriptableObject) objUnwrap, scriptable);
                    }
                    return objUnwrap;
                }
            }
            return adapterSelf;
        } catch (Exception e) {
            throw Context.throwAsScriptRuntimeEx(e);
        }
    }

    static /* synthetic */ ScriptableObject lambda$runScript$1(Script script, Context context) {
        ScriptableObject global = ScriptRuntime.getGlobal(context);
        script.exec(context, global);
        return global;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x001f  */
    static Class<?> loadAdapterClass(String str, byte[] bArr) {
        ProtectionDomain codeSource;
        Class<?> staticSecurityDomainClass = SecurityController.getStaticSecurityDomainClass();
        if (staticSecurityDomainClass == CodeSource.class || staticSecurityDomainClass == ProtectionDomain.class) {
            ProtectionDomain scriptProtectionDomain = SecurityUtilities.getScriptProtectionDomain();
            ProtectionDomain protectionDomain = scriptProtectionDomain;
            if (scriptProtectionDomain == null) {
                protectionDomain = JavaAdapter.class.getProtectionDomain();
            }
            codeSource = protectionDomain;
            if (staticSecurityDomainClass == CodeSource.class) {
                if (protectionDomain == null) {
                    codeSource = null;
                } else {
                    codeSource = protectionDomain.getCodeSource();
                }
            }
        } else {
            codeSource = null;
        }
        GeneratedClassLoader generatedClassLoaderCreateLoader = SecurityController.createLoader(null, codeSource);
        Class<?> clsDefineClass = generatedClassLoaderCreateLoader.defineClass(str, bArr);
        generatedClassLoaderCreateLoader.linkClass(clsDefineClass);
        return clsDefineClass;
    }

    public static Object readAdapterObject(Scriptable scriptable, ObjectInputStream objectInputStream) throws ClassNotFoundException {
        Context currentContext = Context.getCurrentContext();
        ContextFactory factory = currentContext != null ? currentContext.getFactory() : null;
        Class<?> cls = Class.forName((String) objectInputStream.readObject());
        String[] strArr = (String[]) objectInputStream.readObject();
        Class[] clsArr = new Class[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            clsArr[i] = Class.forName(strArr[i]);
        }
        Scriptable scriptable2 = (Scriptable) objectInputStream.readObject();
        Class<?> adapterClass = getAdapterClass(scriptable, cls, clsArr, scriptable2);
        Class<Scriptable> cls2 = ScriptRuntime.ScriptableClass;
        try {
            return adapterClass.getConstructor(ScriptRuntime.ContextFactoryClass, cls2, cls2).newInstance(factory, scriptable2, scriptable);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
            throw new ClassNotFoundException("adapter");
        }
    }

    public static Scriptable runScript(final Script script) {
        return (Scriptable) ContextFactory.getGlobal().call(new ContextAction() { // from class: external.sdk.pendo.io.mozilla.javascript.JavaAdapter$$ExternalSyntheticLambda0
            @Override // external.sdk.pendo.io.mozilla.javascript.ContextAction
            public final Object run(Context context) {
                return JavaAdapter.lambda$runScript$1(script, context);
            }
        });
    }

    public static void writeAdapterObject(Object obj, ObjectOutputStream objectOutputStream) throws IOException {
        Class<?> cls = obj.getClass();
        objectOutputStream.writeObject(cls.getSuperclass().getName());
        Class<?>[] interfaces = cls.getInterfaces();
        String[] strArr = new String[interfaces.length];
        for (int i = 0; i < interfaces.length; i++) {
            strArr[i] = interfaces[i].getName();
        }
        objectOutputStream.writeObject(strArr);
        try {
            objectOutputStream.writeObject(cls.getField("delegee").get(obj));
        } catch (IllegalAccessException | NoSuchFieldException unused) {
            throw new IOException();
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (idFunctionObject.hasTag(FTAG) && idFunctionObject.methodId() == 1) {
            return js_createAdapter(context, scriptable, objArr);
        }
        throw idFunctionObject.unknown();
    }
}
