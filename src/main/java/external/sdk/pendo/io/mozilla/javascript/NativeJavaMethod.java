package external.sdk.pendo.io.mozilla.javascript;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
public class NativeJavaMethod extends BaseFunction {
    private static final int PREFERENCE_AMBIGUOUS = 3;
    private static final int PREFERENCE_EQUAL = 0;
    private static final int PREFERENCE_FIRST_ARG = 1;
    private static final int PREFERENCE_SECOND_ARG = 2;
    private static final boolean debug = false;
    private static final long serialVersionUID = -3440381785576412928L;
    private String functionName;
    MemberBox[] methods;
    private final transient CopyOnWriteArrayList<ResolvedOverload> overloadCache;

    NativeJavaMethod(MemberBox memberBox, String str) {
        this.overloadCache = new CopyOnWriteArrayList<>();
        this.functionName = str;
        this.methods = new MemberBox[]{memberBox};
    }

    /* JADX WARN: Code duplicated, block: B:58:0x00a6  */
    static int findFunction(Context context, MemberBox[] memberBoxArr, Object[] objArr) {
        int i;
        boolean z;
        int i2 = -1;
        if (memberBoxArr.length == 0) {
            return -1;
        }
        int i3 = 0;
        if (memberBoxArr.length == 1) {
            MemberBox memberBox = memberBoxArr[0];
            Class<?>[] clsArr = memberBox.argTypes;
            int length = clsArr.length;
            if (memberBox.vararg) {
                length--;
                if (length > objArr.length) {
                    return -1;
                }
            } else if (length != objArr.length) {
                return -1;
            }
            for (int i4 = 0; i4 != length; i4++) {
                if (!NativeJavaObject.canConvert(objArr[i4], clsArr[i4])) {
                    return -1;
                }
            }
            return 0;
        }
        int[] iArr = null;
        int i5 = -1;
        int i6 = 0;
        int i7 = 0;
        while (i6 < memberBoxArr.length) {
            MemberBox memberBox2 = memberBoxArr[i6];
            Class<?>[] clsArr2 = memberBox2.argTypes;
            int length2 = clsArr2.length;
            if (!memberBox2.vararg ? length2 == objArr.length : (length2 = length2 - 1) <= objArr.length) {
                int i8 = i3;
                while (true) {
                    if (i8 >= length2) {
                        if (i5 < 0) {
                            i = i3;
                        } else {
                            int i9 = i2;
                            int i10 = i3;
                            int i11 = i10;
                            while (true) {
                                if (i9 != i7) {
                                    MemberBox memberBox3 = memberBoxArr[i9 == i2 ? i5 : iArr[i9]];
                                    i = i3;
                                    if (!context.hasFeature(13) || memberBox3.isPublic() == memberBox2.isPublic()) {
                                        int iPreferSignature = preferSignature(objArr, clsArr2, memberBox2.vararg, memberBox3.argTypes, memberBox3.vararg);
                                        if (iPreferSignature != 3) {
                                            if (iPreferSignature == 1) {
                                                i10++;
                                            } else {
                                                if (iPreferSignature != 2) {
                                                    if (iPreferSignature != 0) {
                                                        Kit.codeBug();
                                                    }
                                                    if (memberBox3.isStatic() && memberBox3.getDeclaringClass().isAssignableFrom(memberBox2.getDeclaringClass())) {
                                                        if (i9 != -1) {
                                                            iArr[i9] = i6;
                                                        }
                                                    }
                                                }
                                                i11++;
                                            }
                                        }
                                        z = true;
                                    } else if (memberBox3.isPublic()) {
                                        i11++;
                                    } else {
                                        i10++;
                                    }
                                    i9++;
                                    i3 = i;
                                    i2 = -1;
                                } else {
                                    i = i3;
                                }
                                int i12 = i7 + 1;
                                if (i10 == i12) {
                                    i5 = i6;
                                    i7 = i;
                                } else if (i11 != i12) {
                                    if (iArr == null) {
                                        z = true;
                                        iArr = new int[memberBoxArr.length - 1];
                                    } else {
                                        z = true;
                                    }
                                    iArr[i7] = i6;
                                    i7 = i12;
                                }
                                z = true;
                            }
                        }
                        i5 = i6;
                        z = true;
                    } else if (NativeJavaObject.canConvert(objArr[i8], clsArr2[i8])) {
                        i8++;
                    } else {
                        i = i3;
                        z = true;
                    }
                }
            } else {
                i = i3;
                z = true;
            }
            i6++;
            i3 = i;
            i2 = -1;
        }
        int i13 = i3;
        if (i5 < 0) {
            return -1;
        }
        if (i7 == 0) {
            return i5;
        }
        StringBuilder sb = new StringBuilder();
        int i14 = -1;
        while (i14 != i7) {
            int i15 = i14 == -1 ? i5 : iArr[i14];
            sb.append("\n    ");
            sb.append(memberBoxArr[i15].toJavaDeclaration());
            i14++;
        }
        MemberBox memberBox4 = memberBoxArr[i5];
        String name = memberBox4.getName();
        String name2 = memberBox4.getDeclaringClass().getName();
        if (memberBoxArr[i13].isCtor()) {
            throw Context.reportRuntimeError3("msg.constructor.ambiguous", name, scriptSignature(objArr), sb.toString());
        }
        throw Context.reportRuntimeError4("msg.method.ambiguous", name2, name, scriptSignature(objArr), sb.toString());
    }

    /* JADX WARN: Code duplicated, block: B:26:0x003a  */
    /* JADX WARN: Code duplicated, block: B:30:0x0043  */
    private static int preferSignature(Object[] objArr, Class<?>[] clsArr, boolean z, Class<?>[] clsArr2, boolean z2) {
        int i = 0;
        int i2 = 0;
        while (i < objArr.length) {
            int i3 = 1;
            Class<?> cls = (!z || i < clsArr.length) ? clsArr[i] : clsArr[clsArr.length - 1];
            Class<?> cls2 = (!z2 || i < clsArr2.length) ? clsArr2[i] : clsArr2[clsArr2.length - 1];
            if (cls != cls2) {
                Object obj = objArr[i];
                int conversionWeight = NativeJavaObject.getConversionWeight(obj, cls);
                int conversionWeight2 = NativeJavaObject.getConversionWeight(obj, cls2);
                if (conversionWeight >= conversionWeight2) {
                    if (conversionWeight > conversionWeight2) {
                        i3 = 2;
                    } else if (conversionWeight != 0) {
                        i3 = 3;
                    } else if (cls.isAssignableFrom(cls2)) {
                        i3 = 2;
                    } else if (!cls2.isAssignableFrom(cls)) {
                        i3 = 3;
                    }
                }
                i2 |= i3;
                if (i2 == 3) {
                    return i2;
                }
            }
            i++;
        }
        return i2;
    }

    private static void printDebug(String str, MemberBox memberBox, Object[] objArr) {
    }

    static String scriptSignature(Object[] objArr) {
        String strJavaSignature;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i != objArr.length; i++) {
            Object obj = objArr[i];
            if (obj == null) {
                strJavaSignature = AbstractJsonLexerKt.NULL;
            } else if (obj instanceof Boolean) {
                strJavaSignature = TypedValues.Custom.S_BOOLEAN;
            } else if (obj instanceof String) {
                strJavaSignature = "string";
            } else if (obj instanceof Number) {
                strJavaSignature = "number";
            } else if (!(obj instanceof Scriptable)) {
                strJavaSignature = JavaMembers.javaSignature(obj.getClass());
            } else if (obj instanceof Undefined) {
                strJavaSignature = "undefined";
            } else if (obj instanceof Wrapper) {
                strJavaSignature = ((Wrapper) obj).unwrap().getClass().getName();
            } else {
                strJavaSignature = obj instanceof Function ? "function" : "object";
            }
            if (i != 0) {
                sb.append(AbstractJsonLexerKt.COMMA);
            }
            sb.append(strJavaSignature);
        }
        return sb.toString();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.BaseFunction, external.sdk.pendo.io.mozilla.javascript.Function, external.sdk.pendo.io.mozilla.javascript.Callable
    public Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Object[] objArr2;
        Object obj;
        Object objJsToJava;
        if (this.methods.length == 0) {
            throw new RuntimeException("No methods defined for call");
        }
        int iFindCachedFunction = findCachedFunction(context, objArr);
        int i = 0;
        if (iFindCachedFunction < 0) {
            throw Context.reportRuntimeError1("msg.java.no_such_method", this.methods[0].method().getDeclaringClass().getName() + '.' + getFunctionName() + '(' + scriptSignature(objArr) + ')');
        }
        MemberBox memberBox = this.methods[iFindCachedFunction];
        Class<?>[] clsArr = memberBox.argTypes;
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
                Object obj2 = objArr2[i];
                Object objJsToJava2 = Context.jsToJava(obj2, clsArr[i]);
                if (objJsToJava2 != obj2) {
                    if (objArr == objArr2) {
                        objArr2 = (Object[]) objArr2.clone();
                    }
                    objArr2[i] = objJsToJava2;
                }
                i++;
            }
        }
        if (memberBox.isStatic()) {
            obj = null;
        } else {
            Class<?> declaringClass = memberBox.getDeclaringClass();
            Scriptable prototype = scriptable2;
            while (true) {
                if (prototype == null) {
                    throw Context.reportRuntimeError3("msg.nonjava.method", getFunctionName(), ScriptRuntime.toString(scriptable2), declaringClass.getName());
                }
                if (prototype instanceof Wrapper) {
                    Object objUnwrap = ((Wrapper) prototype).unwrap();
                    if (declaringClass.isInstance(objUnwrap)) {
                        obj = objUnwrap;
                        break;
                    }
                }
                prototype = prototype.getPrototype();
            }
        }
        Object objInvoke = memberBox.invoke(obj, objArr2);
        Class<?> returnType = memberBox.method().getReturnType();
        Object objWrap = context.getWrapFactory().wrap(context, scriptable, objInvoke, returnType);
        return (objWrap == null && returnType == Void.TYPE) ? Undefined.instance : objWrap;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.BaseFunction
    String decompile(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        boolean z = (i2 & 1) != 0;
        if (!z) {
            sb.append("function ");
            sb.append(getFunctionName());
            sb.append("() {");
        }
        sb.append("/*\n");
        sb.append(toString());
        sb.append(z ? "*/\n" : "*/}\n");
        return sb.toString();
    }

    int findCachedFunction(Context context, Object[] objArr) {
        MemberBox[] memberBoxArr = this.methods;
        if (memberBoxArr.length <= 1) {
            return findFunction(context, memberBoxArr, objArr);
        }
        for (ResolvedOverload resolvedOverload : this.overloadCache) {
            if (resolvedOverload.matches(objArr)) {
                return resolvedOverload.index;
            }
        }
        int iFindFunction = findFunction(context, this.methods, objArr);
        if (this.overloadCache.size() < this.methods.length * 2) {
            this.overloadCache.addIfAbsent(new ResolvedOverload(objArr, iFindFunction));
        }
        return iFindFunction;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.BaseFunction
    public String getFunctionName() {
        return this.functionName;
    }

    public String toString() {
        String name;
        StringBuilder sb = new StringBuilder();
        int length = this.methods.length;
        for (int i = 0; i != length; i++) {
            if (this.methods[i].isMethod()) {
                Method method = this.methods[i].method();
                sb.append(JavaMembers.javaSignature(method.getReturnType()));
                sb.append(' ');
                name = method.getName();
            } else {
                name = this.methods[i].getName();
            }
            sb.append(name);
            sb.append(JavaMembers.liveConnectSignature(this.methods[i].argTypes));
            sb.append('\n');
        }
        return sb.toString();
    }

    public NativeJavaMethod(Method method, String str) {
        this(new MemberBox(method), str);
    }

    NativeJavaMethod(MemberBox[] memberBoxArr) {
        this.overloadCache = new CopyOnWriteArrayList<>();
        this.functionName = memberBoxArr[0].getName();
        this.methods = memberBoxArr;
    }

    NativeJavaMethod(MemberBox[] memberBoxArr, String str) {
        this.overloadCache = new CopyOnWriteArrayList<>();
        this.functionName = str;
        this.methods = memberBoxArr;
    }
}
