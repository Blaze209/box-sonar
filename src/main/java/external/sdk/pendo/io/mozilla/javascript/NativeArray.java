package external.sdk.pendo.io.mozilla.javascript;

import androidx.collection.SieveCacheKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.react.uimanager.ViewProps;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectorySlice;
import com.microsoft.identity.common.java.providers.oauth2.TokenRequest;
import com.pspdfkit.analytics.Analytics;
import external.sdk.pendo.io.mozilla.javascript.regexp.NativeRegExp;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
public class NativeArray extends IdScriptableObject implements List {
    private static final int ConstructorId_concat = -13;
    private static final int ConstructorId_every = -17;
    private static final int ConstructorId_filter = -18;
    private static final int ConstructorId_find = -22;
    private static final int ConstructorId_findIndex = -23;
    private static final int ConstructorId_forEach = -19;
    private static final int ConstructorId_from = -28;
    private static final int ConstructorId_indexOf = -15;
    private static final int ConstructorId_isArray = -26;
    private static final int ConstructorId_join = -5;
    private static final int ConstructorId_lastIndexOf = -16;
    private static final int ConstructorId_map = -20;
    private static final int ConstructorId_of = -27;
    private static final int ConstructorId_pop = -9;
    private static final int ConstructorId_push = -8;
    private static final int ConstructorId_reduce = -24;
    private static final int ConstructorId_reduceRight = -25;
    private static final int ConstructorId_reverse = -6;
    private static final int ConstructorId_shift = -10;
    private static final int ConstructorId_slice = -14;
    private static final int ConstructorId_some = -21;
    private static final int ConstructorId_sort = -7;
    private static final int ConstructorId_splice = -12;
    private static final int ConstructorId_unshift = -11;
    private static final int DEFAULT_INITIAL_CAPACITY = 10;
    private static final double GROW_FACTOR = 1.5d;
    private static final int Id_concat = 13;
    private static final int Id_constructor = 1;
    private static final int Id_copyWithin = 31;
    private static final int Id_entries = 29;
    private static final int Id_every = 17;
    private static final int Id_fill = 26;
    private static final int Id_filter = 18;
    private static final int Id_find = 22;
    private static final int Id_findIndex = 23;
    private static final int Id_forEach = 19;
    private static final int Id_includes = 30;
    private static final int Id_indexOf = 15;
    private static final int Id_join = 5;
    private static final int Id_keys = 27;
    private static final int Id_lastIndexOf = 16;
    private static final int Id_length = 1;
    private static final int Id_map = 20;
    private static final int Id_pop = 9;
    private static final int Id_push = 8;
    private static final int Id_reduce = 24;
    private static final int Id_reduceRight = 25;
    private static final int Id_reverse = 6;
    private static final int Id_shift = 10;
    private static final int Id_slice = 14;
    private static final int Id_some = 21;
    private static final int Id_sort = 7;
    private static final int Id_splice = 12;
    private static final int Id_toLocaleString = 3;
    private static final int Id_toSource = 4;
    private static final int Id_toString = 2;
    private static final int Id_unshift = 11;
    private static final int Id_values = 28;
    private static final int MAX_INSTANCE_ID = 1;
    private static final int MAX_PRE_GROW_SIZE = 1431655764;
    private static final int MAX_PROTOTYPE_ID = 32;
    private static final int SymbolId_iterator = 32;
    private static final long serialVersionUID = 7331366857676127338L;
    private Object[] dense;
    private boolean denseOnly;
    private long length;
    private int lengthAttr;
    private static final Object ARRAY_TAG = "Array";
    private static final Long NEGATIVE_ONE = -1L;
    private static final Comparator<Object> STRING_COMPARATOR = new StringLikeComparator();
    private static final Comparator<Object> DEFAULT_COMPARATOR = new ElementComparator();
    private static int maximumInitialCapacity = 10000;

    public static final class ElementComparator implements Comparator<Object>, Serializable {
        private static final long serialVersionUID = -1189948017688708858L;
        private final Comparator<Object> child;

        public ElementComparator() {
            this.child = NativeArray.STRING_COMPARATOR;
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            Object obj3 = Undefined.instance;
            if (obj == obj3) {
                if (obj2 == obj3) {
                    return 0;
                }
                return obj2 == Scriptable.NOT_FOUND ? -1 : 1;
            }
            Object obj4 = Scriptable.NOT_FOUND;
            if (obj == obj4) {
                return obj2 == obj4 ? 0 : 1;
            }
            if (obj2 == obj4 || obj2 == obj3) {
                return -1;
            }
            return this.child.compare(obj, obj2);
        }

        public ElementComparator(Comparator<Object> comparator) {
            this.child = comparator;
        }
    }

    public static final class StringLikeComparator implements Comparator<Object>, Serializable {
        private static final long serialVersionUID = 5299017659728190979L;

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ScriptRuntime.toString(obj).compareTo(ScriptRuntime.toString(obj2));
        }
    }

    public NativeArray(long j) {
        this.lengthAttr = 6;
        boolean z = j <= ((long) maximumInitialCapacity);
        this.denseOnly = z;
        if (z) {
            int i = (int) j;
            Object[] objArr = new Object[i < 10 ? 10 : i];
            this.dense = objArr;
            Arrays.fill(objArr, Scriptable.NOT_FOUND);
        }
        this.length = j;
    }

    private static Scriptable callConstructorOrCreateArray(Context context, Scriptable scriptable, Scriptable scriptable2, long j, boolean z) {
        Scriptable scriptableConstruct;
        if (scriptable2 instanceof Function) {
            try {
                scriptableConstruct = ((Function) scriptable2).construct(context, scriptable, (z || j > 0) ? new Object[]{Long.valueOf(j)} : ScriptRuntime.emptyArgs);
            } catch (EcmaError e) {
                if (!"TypeError".equals(e.getName())) {
                    throw e;
                }
                scriptableConstruct = null;
            }
        } else {
            scriptableConstruct = null;
        }
        if (scriptableConstruct == null) {
            return context.newArray(scriptable, j > SieveCacheKt.NodeLinkMask ? 0 : (int) j);
        }
        return scriptableConstruct;
    }

    private static long concatSpreadArg(Context context, Scriptable scriptable, Scriptable scriptable2, long j) {
        long lengthProperty = getLengthProperty(context, scriptable2, false);
        long j2 = lengthProperty + j;
        if (j2 <= SieveCacheKt.NodeLinkMask && (scriptable instanceof NativeArray)) {
            NativeArray nativeArray = (NativeArray) scriptable;
            if (nativeArray.denseOnly && (scriptable2 instanceof NativeArray)) {
                NativeArray nativeArray2 = (NativeArray) scriptable2;
                if (nativeArray2.denseOnly) {
                    nativeArray.ensureCapacity((int) j2);
                    System.arraycopy(nativeArray2.dense, 0, nativeArray.dense, (int) j, (int) lengthProperty);
                    return j2;
                }
            }
        }
        long j3 = 0;
        while (j3 < lengthProperty) {
            Object rawElem = getRawElem(scriptable2, j3);
            if (rawElem != Scriptable.NOT_FOUND) {
                defineElem(context, scriptable, j, rawElem);
            }
            j3++;
            j++;
        }
        return j2;
    }

    private ScriptableObject defaultIndexPropertyDescriptor(Object obj) {
        Scriptable parentScope = getParentScope();
        if (parentScope != null) {
            this = parentScope;
        }
        NativeObject nativeObject = new NativeObject();
        ScriptRuntime.setBuiltinProtoAndParent(nativeObject, this, TopLevel.Builtins.Object);
        nativeObject.defineProperty("value", obj, 0);
        Boolean bool = Boolean.TRUE;
        nativeObject.defineProperty("writable", bool, 0);
        nativeObject.defineProperty("enumerable", bool, 0);
        nativeObject.defineProperty("configurable", bool, 0);
        return nativeObject;
    }

    private static void defineElem(Context context, Scriptable scriptable, long j, Object obj) {
        if (j > SieveCacheKt.NodeLinkMask) {
            scriptable.put(Long.toString(j), scriptable, obj);
        } else {
            scriptable.put((int) j, scriptable, obj);
        }
    }

    private static void deleteElem(Scriptable scriptable, long j) {
        int i = (int) j;
        if (i == j) {
            scriptable.delete(i);
        } else {
            scriptable.delete(Long.toString(j));
        }
    }

    private static long doConcat(Context context, Scriptable scriptable, Scriptable scriptable2, Object obj, long j) {
        if (isConcatSpreadable(context, scriptable, obj)) {
            return concatSpreadArg(context, scriptable2, (Scriptable) obj, j);
        }
        defineElem(context, scriptable2, j, obj);
        return j + 1;
    }

    private boolean ensureCapacity(int i) {
        Object[] objArr = this.dense;
        if (i <= objArr.length) {
            return true;
        }
        if (i > MAX_PRE_GROW_SIZE) {
            this.denseOnly = false;
            return false;
        }
        int iMax = Math.max(i, (int) (((double) objArr.length) * 1.5d));
        Object[] objArr2 = new Object[iMax];
        Object[] objArr3 = this.dense;
        System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
        Arrays.fill(objArr2, this.dense.length, iMax, Scriptable.NOT_FOUND);
        this.dense = objArr2;
        return true;
    }

    private static Object getElem(Context context, Scriptable scriptable, long j) {
        Object rawElem = getRawElem(scriptable, j);
        return rawElem != Scriptable.NOT_FOUND ? rawElem : Undefined.instance;
    }

    static long getLengthProperty(Context context, Scriptable scriptable, boolean z) {
        if (scriptable instanceof NativeString) {
            return ((NativeString) scriptable).getLength();
        }
        if (scriptable instanceof NativeArray) {
            return ((NativeArray) scriptable).getLength();
        }
        Object property = ScriptableObject.getProperty(scriptable, Analytics.Data.LENGTH);
        if (property == Scriptable.NOT_FOUND) {
            return 0L;
        }
        double number = ScriptRuntime.toNumber(property);
        if (number > 9.007199254740991E15d) {
            if (z) {
                throw ScriptRuntime.rangeError(ScriptRuntime.getMessage0("msg.arraylength.bad"));
            }
            return SieveCacheKt.NodeLinkMask;
        }
        if (number < 0.0d) {
            return 0L;
        }
        return ScriptRuntime.toUint32(property);
    }

    static int getMaximumInitialCapacity() {
        return maximumInitialCapacity;
    }

    private static Object getRawElem(Scriptable scriptable, long j) {
        return j > SieveCacheKt.NodeLinkMask ? ScriptableObject.getProperty(scriptable, Long.toString(j)) : ScriptableObject.getProperty(scriptable, (int) j);
    }

    static void init(Scriptable scriptable, boolean z) {
        new NativeArray(0L).exportAsJSClass(32, scriptable, z);
    }

    private static boolean isConcatSpreadable(Context context, Scriptable scriptable, Object obj) {
        Object property;
        if ((obj instanceof Scriptable) && (property = ScriptableObject.getProperty((Scriptable) obj, SymbolKey.IS_CONCAT_SPREADABLE)) != Scriptable.NOT_FOUND && !Undefined.isUndefined(property)) {
            return ScriptRuntime.toBoolean(property);
        }
        if (context.getLanguageVersion() >= 200 || !ScriptRuntime.instanceOf(obj, ScriptRuntime.getExistingCtor(context, scriptable, "Array"), context)) {
            return js_isArray(obj);
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:54:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:59:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:66:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:69:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:70:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:86:0x00da A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:88:0x00aa A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:89:0x00b6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:0x00bd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:92:0x00dd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:93:0x00dd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:94:0x00dd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:96:0x00dd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:98:0x00dd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:99:0x00dd A[SYNTHETIC] */
    private static Object iterativeMethod(Context context, IdFunctionObject idFunctionObject, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        double d;
        Object[] objArr2;
        Object objCall;
        Object obj;
        Scriptable object = ScriptRuntime.toObject(context, scriptable, scriptable2);
        int iAbs = Math.abs(idFunctionObject.methodId());
        int i = 22;
        if (22 == iAbs || 23 == iAbs) {
            ScriptRuntimeES6.requireObjectCoercible(context, object, idFunctionObject);
        }
        char c = 0;
        long lengthProperty = getLengthProperty(context, object, iAbs == 20);
        Object obj2 = objArr.length > 0 ? objArr[0] : Undefined.instance;
        if (obj2 == null || !(obj2 instanceof Function)) {
            throw ScriptRuntime.notFunctionError(obj2);
        }
        if (context.getLanguageVersion() >= 200 && (obj2 instanceof NativeRegExp)) {
            throw ScriptRuntime.notFunctionError(obj2);
        }
        Function function = (Function) obj2;
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(function);
        Scriptable object2 = (objArr.length < 2 || (obj = objArr[1]) == null || obj == Undefined.instance) ? topLevelScope : ScriptRuntime.toObject(context, scriptable, obj);
        Scriptable scriptableNewArray = (iAbs == 18 || iAbs == 20) ? context.newArray(scriptable, iAbs == 20 ? (int) lengthProperty : 0) : null;
        long j = 0;
        long j2 = 0;
        while (j < lengthProperty) {
            char c2 = c;
            Object rawElem = getRawElem(object, j);
            if (rawElem != Scriptable.NOT_FOUND) {
                objArr2 = new Object[]{rawElem, Long.valueOf(j), object};
                objCall = function.call(context, topLevelScope, object2, objArr2);
                switch (iAbs) {
                    case 17:
                        if (!ScriptRuntime.toBoolean(objCall)) {
                            return Boolean.FALSE;
                        }
                        continue;
                        continue;
                        break;
                    case 18:
                        if (ScriptRuntime.toBoolean(objCall)) {
                            continue;
                            continue;
                        } else {
                            defineElem(context, scriptableNewArray, j2, objArr2[c2]);
                            j2++;
                        }
                        break;
                    case 19:
                    default:
                        continue;
                        continue;
                    case 20:
                        defineElem(context, scriptableNewArray, j, objCall);
                        continue;
                        continue;
                    case 21:
                        if (ScriptRuntime.toBoolean(objCall)) {
                            return Boolean.TRUE;
                        }
                        continue;
                        continue;
                        break;
                    case 22:
                        if (ScriptRuntime.toBoolean(objCall)) {
                            return rawElem;
                        }
                        continue;
                        continue;
                        break;
                    case 23:
                        if (ScriptRuntime.toBoolean(objCall)) {
                            d = j;
                        }
                        break;
                }
                return ScriptRuntime.wrapNumber(d);
            }
            if (iAbs == i || iAbs == 23) {
                rawElem = Undefined.instance;
                objArr2 = new Object[]{rawElem, Long.valueOf(j), object};
                objCall = function.call(context, topLevelScope, object2, objArr2);
                switch (iAbs) {
                    case 17:
                        if (!ScriptRuntime.toBoolean(objCall)) {
                            return Boolean.FALSE;
                        }
                        continue;
                        continue;
                        break;
                    case 18:
                        if (ScriptRuntime.toBoolean(objCall)) {
                            continue;
                            continue;
                        } else {
                            defineElem(context, scriptableNewArray, j2, objArr2[c2]);
                            j2++;
                        }
                        break;
                    case 19:
                    default:
                        continue;
                        continue;
                    case 20:
                        defineElem(context, scriptableNewArray, j, objCall);
                        continue;
                        continue;
                    case 21:
                        if (ScriptRuntime.toBoolean(objCall)) {
                            return Boolean.TRUE;
                        }
                        continue;
                        continue;
                        break;
                    case 22:
                        if (ScriptRuntime.toBoolean(objCall)) {
                            return rawElem;
                        }
                        continue;
                        continue;
                        break;
                    case 23:
                        if (ScriptRuntime.toBoolean(objCall)) {
                            d = j;
                        }
                        break;
                }
                return ScriptRuntime.wrapNumber(d);
            }
            j++;
            c = c2;
            i = 22;
        }
        switch (iAbs) {
            case 17:
                return Boolean.TRUE;
            case 18:
            case 20:
                return scriptableNewArray;
            case 19:
            case 22:
            default:
                return Undefined.instance;
            case 21:
                return Boolean.FALSE;
            case 23:
                d = -1.0d;
                break;
        }
        return ScriptRuntime.wrapNumber(d);
    }

    private static Object jsConstructor(Context context, Scriptable scriptable, Object[] objArr) {
        if (objArr.length == 0) {
            return new NativeArray(0L);
        }
        if (context.getLanguageVersion() == 120) {
            return new NativeArray(objArr);
        }
        Object obj = objArr[0];
        if (objArr.length > 1 || !(obj instanceof Number)) {
            return new NativeArray(objArr);
        }
        long uint32 = ScriptRuntime.toUint32(obj);
        if (uint32 == ((Number) obj).doubleValue()) {
            return new NativeArray(uint32);
        }
        throw ScriptRuntime.rangeError(ScriptRuntime.getMessage0("msg.arraylength.bad"));
    }

    private static Scriptable js_concat(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Scriptable object = ScriptRuntime.toObject(context, scriptable, scriptable2);
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        Scriptable scriptableNewArray = context.newArray(topLevelScope, 0);
        long jDoConcat = doConcat(context, topLevelScope, scriptableNewArray, object, 0L);
        for (Object obj : objArr) {
            jDoConcat = doConcat(context, topLevelScope, scriptableNewArray, obj, jDoConcat);
        }
        setLengthProperty(context, scriptableNewArray, jDoConcat);
        return scriptableNewArray;
    }

    /* JADX WARN: Code duplicated, block: B:44:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:50:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:57:? A[SYNTHETIC] */
    private static Object js_copyWithin(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Object rawElem;
        Scriptable object = ScriptRuntime.toObject(context, scriptable, scriptable2);
        long lengthProperty = getLengthProperty(context, object, false);
        int i = 1;
        long integer = (long) ScriptRuntime.toInteger(objArr.length >= 1 ? objArr[0] : Undefined.instance);
        long jMax = integer < 0 ? Math.max(integer + lengthProperty, 0L) : Math.min(integer, lengthProperty);
        long integer2 = (long) ScriptRuntime.toInteger(objArr.length >= 2 ? objArr[1] : Undefined.instance);
        long jMax2 = integer2 < 0 ? Math.max(integer2 + lengthProperty, 0L) : Math.min(integer2, lengthProperty);
        long integer3 = (objArr.length < 3 || Undefined.isUndefined(objArr[2])) ? lengthProperty : (long) ScriptRuntime.toInteger(objArr[2]);
        long jMin = Math.min((integer3 < 0 ? Math.max(integer3 + lengthProperty, 0L) : Math.min(integer3, lengthProperty)) - jMax2, lengthProperty - jMax);
        if (jMax2 < jMax) {
            long j = jMax2 + jMin;
            if (jMax < j) {
                jMax2 = j - 1;
                jMax = (jMax + jMin) - 1;
                i = -1;
            }
        }
        if (!(object instanceof NativeArray) || jMin > SieveCacheKt.NodeLinkMask) {
            while (jMin > 0) {
                rawElem = getRawElem(object, jMax2);
                if (rawElem != Scriptable.NOT_FOUND || Undefined.isUndefined(rawElem)) {
                    deleteElem(object, jMax);
                } else {
                    setElem(context, object, jMax, rawElem);
                }
                long j2 = i;
                jMax2 += j2;
                jMax += j2;
                jMin--;
            }
        } else {
            NativeArray nativeArray = (NativeArray) object;
            if (nativeArray.denseOnly) {
                while (jMin > 0) {
                    Object[] objArr2 = nativeArray.dense;
                    objArr2[(int) jMax] = objArr2[(int) jMax2];
                    long j3 = i;
                    jMax2 += j3;
                    jMax += j3;
                    jMin--;
                }
            } else {
                while (jMin > 0) {
                    rawElem = getRawElem(object, jMax2);
                    if (rawElem != Scriptable.NOT_FOUND) {
                        deleteElem(object, jMax);
                    } else {
                        deleteElem(object, jMax);
                    }
                    long j4 = i;
                    jMax2 += j4;
                    jMax += j4;
                    jMin--;
                }
            }
        }
        return scriptable2;
    }

    private static Object js_fill(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        long lengthProperty = getLengthProperty(context, ScriptRuntime.toObject(context, scriptable, scriptable2), false);
        long integer = objArr.length >= 2 ? (long) ScriptRuntime.toInteger(objArr[1]) : 0L;
        long integer2 = (objArr.length < 3 || Undefined.isUndefined(objArr[2])) ? lengthProperty : (long) ScriptRuntime.toInteger(objArr[2]);
        long jMax = integer2 < 0 ? Math.max(lengthProperty + integer2, 0L) : Math.min(integer2, lengthProperty);
        Object obj = objArr.length > 0 ? objArr[0] : Undefined.instance;
        for (long jMax2 = integer < 0 ? Math.max(integer + lengthProperty, 0L) : Math.min(integer, lengthProperty); jMax2 < jMax; jMax2++) {
            setRawElem(context, scriptable2, jMax2, obj);
        }
        return scriptable2;
    }

    private static Object js_from(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Function function;
        Scriptable object = ScriptRuntime.toObject(scriptable, objArr.length >= 1 ? objArr[0] : Undefined.instance);
        Object obj = objArr.length >= 2 ? objArr[1] : Undefined.instance;
        Scriptable scriptableEnsureScriptable = Undefined.SCRIPTABLE_UNDEFINED;
        boolean zIsUndefined = Undefined.isUndefined(obj);
        if (zIsUndefined) {
            function = null;
        } else {
            if (!(obj instanceof Function)) {
                throw ScriptRuntime.typeError0("msg.map.function.not");
            }
            function = (Function) obj;
            if (objArr.length >= 3) {
                scriptableEnsureScriptable = ScriptableObject.ensureScriptable(objArr[2]);
            }
        }
        Function function2 = function;
        Scriptable scriptable3 = scriptableEnsureScriptable;
        Object property = ScriptableObject.getProperty(object, SymbolKey.ITERATOR);
        long j = 0;
        if (!(object instanceof NativeArray) && property != Scriptable.NOT_FOUND && !Undefined.isUndefined(property)) {
            Object objCallIterator = ScriptRuntime.callIterator(object, context, scriptable);
            if (!Undefined.isUndefined(objCallIterator)) {
                Scriptable scriptableCallConstructorOrCreateArray = callConstructorOrCreateArray(context, scriptable, scriptable2, 0L, false);
                IteratorLikeIterable iteratorLikeIterable = new IteratorLikeIterable(context, scriptable, objCallIterator);
                try {
                    Iterator<Object> it = iteratorLikeIterable.iterator2();
                    while (it.hasNext()) {
                        Object next = it.next();
                        if (!zIsUndefined) {
                            next = function2.call(context, scriptable, scriptable3, new Object[]{next, Long.valueOf(j)});
                        }
                        defineElem(context, scriptableCallConstructorOrCreateArray, j, next);
                        j++;
                    }
                    iteratorLikeIterable.close();
                    setLengthProperty(context, scriptableCallConstructorOrCreateArray, j);
                    return scriptableCallConstructorOrCreateArray;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            iteratorLikeIterable.close();
                            throw th2;
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                            throw th2;
                        }
                    }
                }
            }
        }
        long lengthProperty = getLengthProperty(context, object, false);
        Scriptable scriptableCallConstructorOrCreateArray2 = callConstructorOrCreateArray(context, scriptable, scriptable2, lengthProperty, true);
        while (j < lengthProperty) {
            Object rawElem = getRawElem(object, j);
            if (rawElem != Scriptable.NOT_FOUND) {
                if (!zIsUndefined) {
                    rawElem = function2.call(context, scriptable, scriptable3, new Object[]{rawElem, Long.valueOf(j)});
                }
                defineElem(context, scriptableCallConstructorOrCreateArray2, j, rawElem);
            }
            j++;
        }
        setLengthProperty(context, scriptableCallConstructorOrCreateArray2, lengthProperty);
        return scriptableCallConstructorOrCreateArray2;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x003e A[PHI: r3
      0x003e: PHI (r3v8 long) = (r3v7 long), (r3v10 long) binds: [B:14:0x0036, B:16:0x003b] A[DONT_GENERATE, DONT_INLINE]] */
    private static Boolean js_includes(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Object obj = objArr.length > 0 ? objArr[0] : Undefined.instance;
        Scriptable object = ScriptRuntime.toObject(context, scriptable, scriptable2);
        long length = ScriptRuntime.toLength(new Object[]{ScriptableObject.getProperty(scriptable2, Analytics.Data.LENGTH)}, 0);
        long j = 0;
        if (length == 0) {
            return Boolean.FALSE;
        }
        if (objArr.length >= 2) {
            long integer = (long) ScriptRuntime.toInteger(objArr[1]);
            if (integer < 0) {
                integer += length;
                j = integer >= 0 ? integer : 0L;
            }
            if (j > length - 1) {
                return Boolean.FALSE;
            }
        }
        if (object instanceof NativeArray) {
            NativeArray nativeArray = (NativeArray) object;
            if (nativeArray.denseOnly) {
                Scriptable prototype = nativeArray.getPrototype();
                for (int i = (int) j; i < length; i++) {
                    Object property = nativeArray.dense[i];
                    Object obj2 = Scriptable.NOT_FOUND;
                    if (property == obj2 && prototype != null) {
                        property = ScriptableObject.getProperty(prototype, i);
                    }
                    if (property == obj2) {
                        property = Undefined.instance;
                    }
                    if (ScriptRuntime.sameZero(property, obj)) {
                        return Boolean.TRUE;
                    }
                }
                return Boolean.FALSE;
            }
        }
        while (j < length) {
            Object rawElem = getRawElem(object, j);
            if (rawElem == Scriptable.NOT_FOUND) {
                rawElem = Undefined.instance;
            }
            if (ScriptRuntime.sameZero(rawElem, obj)) {
                return Boolean.TRUE;
            }
            j++;
        }
        return Boolean.FALSE;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002c A[PHI: r9
      0x002c: PHI (r9v9 long) = (r9v8 long), (r9v11 long) binds: [B:10:0x0024, B:12:0x0029] A[DONT_GENERATE, DONT_INLINE]] */
    private static Object js_indexOf(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Object obj = objArr.length > 0 ? objArr[0] : Undefined.instance;
        Scriptable object = ScriptRuntime.toObject(context, scriptable, scriptable2);
        long lengthProperty = getLengthProperty(context, object, false);
        long j = 0;
        if (objArr.length >= 2) {
            long integer = (long) ScriptRuntime.toInteger(objArr[1]);
            if (integer < 0) {
                integer += lengthProperty;
                j = integer >= 0 ? integer : 0L;
            }
            if (j > lengthProperty - 1) {
                return NEGATIVE_ONE;
            }
        }
        if (object instanceof NativeArray) {
            NativeArray nativeArray = (NativeArray) object;
            if (nativeArray.denseOnly) {
                Scriptable prototype = nativeArray.getPrototype();
                int i = (int) j;
                while (true) {
                    long j2 = i;
                    if (j2 >= lengthProperty) {
                        return NEGATIVE_ONE;
                    }
                    Object property = nativeArray.dense[i];
                    Object obj2 = Scriptable.NOT_FOUND;
                    if (property == obj2 && prototype != null) {
                        property = ScriptableObject.getProperty(prototype, i);
                    }
                    if (property != obj2 && ScriptRuntime.shallowEq(property, obj)) {
                        return Long.valueOf(j2);
                    }
                    i++;
                }
            }
        }
        while (j < lengthProperty) {
            Object rawElem = getRawElem(object, j);
            if (rawElem != Scriptable.NOT_FOUND && ScriptRuntime.shallowEq(rawElem, obj)) {
                return Long.valueOf(j);
            }
            j++;
        }
        return NEGATIVE_ONE;
    }

    private static boolean js_isArray(Object obj) {
        if (obj instanceof Scriptable) {
            return "Array".equals(((Scriptable) obj).getClassName());
        }
        return false;
    }

    private static String js_join(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Object obj;
        Object obj2;
        Scriptable object = ScriptRuntime.toObject(context, scriptable, scriptable2);
        int i = 0;
        long lengthProperty = getLengthProperty(context, object, false);
        int i2 = (int) lengthProperty;
        if (lengthProperty != i2) {
            throw Context.reportRuntimeError1("msg.arraylength.too.big", String.valueOf(lengthProperty));
        }
        String string = (objArr.length < 1 || (obj2 = objArr[0]) == Undefined.instance) ? "," : ScriptRuntime.toString(obj2);
        if (object instanceof NativeArray) {
            NativeArray nativeArray = (NativeArray) object;
            if (nativeArray.denseOnly) {
                StringBuilder sb = new StringBuilder();
                while (i < i2) {
                    if (i != 0) {
                        sb.append(string);
                    }
                    Object[] objArr2 = nativeArray.dense;
                    if (i < objArr2.length && (obj = objArr2[i]) != null && obj != Undefined.instance && obj != Scriptable.NOT_FOUND) {
                        sb.append(ScriptRuntime.toString(obj));
                    }
                    i++;
                }
                return sb.toString();
            }
        }
        if (i2 == 0) {
            return "";
        }
        String[] strArr = new String[i2];
        int length = 0;
        for (int i3 = 0; i3 != i2; i3++) {
            Object elem = getElem(context, object, i3);
            if (elem != null && elem != Undefined.instance) {
                String string2 = ScriptRuntime.toString(elem);
                length += string2.length();
                strArr[i3] = string2;
            }
        }
        StringBuilder sb2 = new StringBuilder(length + ((i2 - 1) * string.length()));
        while (i != i2) {
            if (i != 0) {
                sb2.append(string);
            }
            String str = strArr[i];
            if (str != null) {
                sb2.append(str);
            }
            i++;
        }
        return sb2.toString();
    }

    private static Object js_lastIndexOf(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        long j;
        Object obj = objArr.length > 0 ? objArr[0] : Undefined.instance;
        Scriptable object = ScriptRuntime.toObject(context, scriptable, scriptable2);
        long lengthProperty = getLengthProperty(context, object, false);
        if (objArr.length < 2) {
            j = lengthProperty - 1;
        } else {
            long integer = (long) ScriptRuntime.toInteger(objArr[1]);
            if (integer >= lengthProperty) {
                j = lengthProperty - 1;
            } else {
                if (integer < 0) {
                    integer += lengthProperty;
                }
                j = integer;
            }
            if (j < 0) {
                return NEGATIVE_ONE;
            }
        }
        if (object instanceof NativeArray) {
            NativeArray nativeArray = (NativeArray) object;
            if (nativeArray.denseOnly) {
                Scriptable prototype = nativeArray.getPrototype();
                for (int i = (int) j; i >= 0; i--) {
                    Object property = nativeArray.dense[i];
                    Object obj2 = Scriptable.NOT_FOUND;
                    if (property == obj2 && prototype != null) {
                        property = ScriptableObject.getProperty(prototype, i);
                    }
                    if (property != obj2 && ScriptRuntime.shallowEq(property, obj)) {
                        return Long.valueOf(i);
                    }
                }
                return NEGATIVE_ONE;
            }
        }
        while (j >= 0) {
            Object rawElem = getRawElem(object, j);
            if (rawElem != Scriptable.NOT_FOUND && ScriptRuntime.shallowEq(rawElem, obj)) {
                return Long.valueOf(j);
            }
            j--;
        }
        return NEGATIVE_ONE;
    }

    private static Object js_of(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Scriptable scriptableCallConstructorOrCreateArray = callConstructorOrCreateArray(context, scriptable, scriptable2, objArr.length, true);
        for (int i = 0; i < objArr.length; i++) {
            defineElem(context, scriptableCallConstructorOrCreateArray, i, objArr[i]);
        }
        setLengthProperty(context, scriptableCallConstructorOrCreateArray, objArr.length);
        return scriptableCallConstructorOrCreateArray;
    }

    private static Object js_pop(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Object elem;
        Scriptable object = ScriptRuntime.toObject(context, scriptable, scriptable2);
        if (object instanceof NativeArray) {
            NativeArray nativeArray = (NativeArray) object;
            if (nativeArray.denseOnly) {
                long j = nativeArray.length;
                if (j > 0) {
                    long j2 = j - 1;
                    nativeArray.length = j2;
                    Object[] objArr2 = nativeArray.dense;
                    int i = (int) j2;
                    Object obj = objArr2[i];
                    objArr2[i] = Scriptable.NOT_FOUND;
                    return obj;
                }
            }
        }
        long lengthProperty = getLengthProperty(context, object, false);
        if (lengthProperty > 0) {
            lengthProperty--;
            elem = getElem(context, object, lengthProperty);
            deleteElem(object, lengthProperty);
        } else {
            elem = Undefined.instance;
        }
        setLengthProperty(context, object, lengthProperty);
        return elem;
    }

    private static Object js_push(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Scriptable object = ScriptRuntime.toObject(context, scriptable, scriptable2);
        int i = 0;
        if (object instanceof NativeArray) {
            NativeArray nativeArray = (NativeArray) object;
            if (nativeArray.denseOnly && nativeArray.ensureCapacity(((int) nativeArray.length) + objArr.length)) {
                while (i < objArr.length) {
                    Object[] objArr2 = nativeArray.dense;
                    long j = nativeArray.length;
                    nativeArray.length = 1 + j;
                    objArr2[(int) j] = objArr[i];
                    i++;
                }
                return ScriptRuntime.wrapNumber(nativeArray.length);
            }
        }
        long lengthProperty = getLengthProperty(context, object, false);
        while (i < objArr.length) {
            setElem(context, object, ((long) i) + lengthProperty, objArr[i]);
            i++;
        }
        Object lengthProperty2 = setLengthProperty(context, object, lengthProperty + ((long) objArr.length));
        if (context.getLanguageVersion() == 120) {
            return objArr.length == 0 ? Undefined.instance : objArr[objArr.length - 1];
        }
        return lengthProperty2;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0034 A[LOOP:1: B:10:0x0030->B:12:0x0034, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:9:0x0026  */
    private static Scriptable js_reverse(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        long lengthProperty;
        long j;
        long j2;
        Scriptable object = ScriptRuntime.toObject(context, scriptable, scriptable2);
        int i = 0;
        if (object instanceof NativeArray) {
            NativeArray nativeArray = (NativeArray) object;
            if (nativeArray.denseOnly) {
                for (int i2 = ((int) nativeArray.length) - 1; i < i2; i2--) {
                    Object[] objArr2 = nativeArray.dense;
                    Object obj = objArr2[i];
                    objArr2[i] = objArr2[i2];
                    objArr2[i2] = obj;
                    i++;
                }
            } else {
                lengthProperty = getLengthProperty(context, object, false);
                j = lengthProperty / 2;
                for (j2 = 0; j2 < j; j2++) {
                    long j3 = (lengthProperty - j2) - 1;
                    Object rawElem = getRawElem(object, j2);
                    setRawElem(context, object, j2, getRawElem(object, j3));
                    setRawElem(context, object, j3, rawElem);
                }
            }
        } else {
            lengthProperty = getLengthProperty(context, object, false);
            j = lengthProperty / 2;
            while (j2 < j) {
                long j4 = (lengthProperty - j2) - 1;
                Object rawElem2 = getRawElem(object, j2);
                setRawElem(context, object, j2, getRawElem(object, j4));
                setRawElem(context, object, j4, rawElem2);
            }
        }
        return object;
    }

    private static Object js_shift(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Object elem;
        Scriptable object = ScriptRuntime.toObject(context, scriptable, scriptable2);
        if (object instanceof NativeArray) {
            NativeArray nativeArray = (NativeArray) object;
            if (nativeArray.denseOnly) {
                long j = nativeArray.length;
                if (j > 0) {
                    long j2 = j - 1;
                    nativeArray.length = j2;
                    Object[] objArr2 = nativeArray.dense;
                    Object obj = objArr2[0];
                    System.arraycopy(objArr2, 1, objArr2, 0, (int) j2);
                    Object[] objArr3 = nativeArray.dense;
                    int i = (int) nativeArray.length;
                    Object obj2 = Scriptable.NOT_FOUND;
                    objArr3[i] = obj2;
                    return obj == obj2 ? Undefined.instance : obj;
                }
            }
        }
        long lengthProperty = getLengthProperty(context, object, false);
        if (lengthProperty > 0) {
            lengthProperty--;
            elem = getElem(context, object, 0L);
            if (lengthProperty > 0) {
                for (long j3 = 1; j3 <= lengthProperty; j3++) {
                    setRawElem(context, object, j3 - 1, getRawElem(object, j3));
                }
            }
            deleteElem(object, lengthProperty);
        } else {
            elem = Undefined.instance;
        }
        setLengthProperty(context, object, lengthProperty);
        return elem;
    }

    private static Scriptable js_slice(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        long sliceIndex;
        Object obj;
        Scriptable object = ScriptRuntime.toObject(context, scriptable, scriptable2);
        Scriptable scriptableNewArray = context.newArray(scriptable, 0);
        long lengthProperty = getLengthProperty(context, object, false);
        if (objArr.length == 0) {
            sliceIndex = 0;
        } else {
            sliceIndex = toSliceIndex(ScriptRuntime.toInteger(objArr[0]), lengthProperty);
            if (objArr.length != 1 && (obj = objArr[1]) != Undefined.instance) {
                lengthProperty = toSliceIndex(ScriptRuntime.toInteger(obj), lengthProperty);
            }
        }
        for (long j = sliceIndex; j < lengthProperty; j++) {
            Object rawElem = getRawElem(object, j);
            if (rawElem != Scriptable.NOT_FOUND) {
                defineElem(context, scriptableNewArray, j - sliceIndex, rawElem);
            }
        }
        setLengthProperty(context, scriptableNewArray, Math.max(0L, lengthProperty - sliceIndex));
        return scriptableNewArray;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0026  */
    private static Scriptable js_sort(Context context, final Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        final Context context2;
        Comparator<Object> elementComparator;
        Scriptable object = ScriptRuntime.toObject(context, scriptable, scriptable2);
        if (objArr.length > 0) {
            Object obj = Undefined.instance;
            Object obj2 = objArr[0];
            if (obj != obj2) {
                final Callable valueFunctionAndThis = ScriptRuntime.getValueFunctionAndThis(obj2, context);
                final Scriptable scriptableLastStoredScriptable = ScriptRuntime.lastStoredScriptable(context);
                final Object[] objArr2 = new Object[2];
                context2 = context;
                elementComparator = new ElementComparator(new Comparator<Object>() { // from class: external.sdk.pendo.io.mozilla.javascript.NativeArray.1
                    @Override // java.util.Comparator
                    public int compare(Object obj3, Object obj4) {
                        Object[] objArr3 = objArr2;
                        objArr3[0] = obj3;
                        objArr3[1] = obj4;
                        int iCompare = Double.compare(ScriptRuntime.toNumber(valueFunctionAndThis.call(context2, scriptable, scriptableLastStoredScriptable, objArr3)), 0.0d);
                        if (iCompare < 0) {
                            return -1;
                        }
                        return iCompare > 0 ? 1 : 0;
                    }
                });
            } else {
                context2 = context;
                elementComparator = DEFAULT_COMPARATOR;
            }
        } else {
            context2 = context;
            elementComparator = DEFAULT_COMPARATOR;
        }
        long lengthProperty = getLengthProperty(context2, object, false);
        int i = (int) lengthProperty;
        if (lengthProperty != i) {
            throw Context.reportRuntimeError1("msg.arraylength.too.big", String.valueOf(lengthProperty));
        }
        Object[] objArr3 = new Object[i];
        for (int i2 = 0; i2 != i; i2++) {
            objArr3[i2] = getRawElem(object, i2);
        }
        Sorting.get().hybridSort(objArr3, elementComparator);
        for (int i3 = 0; i3 < i; i3++) {
            setRawElem(context2, object, i3, objArr3[i3]);
        }
        return object;
    }

    private static Object js_splice(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        NativeArray nativeArray;
        boolean z;
        boolean z2;
        long j;
        long j2;
        long j3;
        long j4;
        Object objNewArray;
        Object elem;
        Scriptable object = ScriptRuntime.toObject(context, scriptable, scriptable2);
        if (object instanceof NativeArray) {
            nativeArray = (NativeArray) object;
            z = nativeArray.denseOnly;
        } else {
            nativeArray = null;
            z = false;
        }
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        int length = objArr.length;
        if (length == 0) {
            return context.newArray(topLevelScope, 0);
        }
        long lengthProperty = getLengthProperty(context, object, false);
        long sliceIndex = toSliceIndex(ScriptRuntime.toInteger(objArr[0]), lengthProperty);
        int i = length - 1;
        if (objArr.length == 1) {
            j2 = lengthProperty - sliceIndex;
            z2 = z;
            j = 0;
        } else {
            double integer = ScriptRuntime.toInteger(objArr[1]);
            if (integer < 0.0d) {
                z2 = z;
                j2 = 0;
                j = 0;
            } else {
                long j5 = lengthProperty - sliceIndex;
                z2 = z;
                j = 0;
                if (integer <= j5) {
                    j5 = (long) integer;
                }
                j2 = j5;
            }
            i = length - 2;
        }
        long j6 = sliceIndex + j2;
        if (j2 != j) {
            if (j2 == 1 && context.getLanguageVersion() == 120) {
                j3 = lengthProperty;
                j4 = j2;
                elem = getElem(context, object, sliceIndex);
            } else if (z2) {
                j4 = j2;
                int i2 = (int) (j6 - sliceIndex);
                Object[] objArr2 = new Object[i2];
                j3 = lengthProperty;
                System.arraycopy(nativeArray.dense, (int) sliceIndex, objArr2, 0, i2);
                objNewArray = context.newArray(topLevelScope, objArr2);
            } else {
                j3 = lengthProperty;
                j4 = j2;
                Scriptable scriptableNewArray = context.newArray(topLevelScope, 0);
                for (long j7 = sliceIndex; j7 != j6; j7++) {
                    Object rawElem = getRawElem(object, j7);
                    if (rawElem != Scriptable.NOT_FOUND) {
                        setElem(context, scriptableNewArray, j7 - sliceIndex, rawElem);
                    }
                }
                setLengthProperty(context, scriptableNewArray, j6 - sliceIndex);
                elem = scriptableNewArray;
            }
            objNewArray = elem;
        } else {
            j3 = lengthProperty;
            j4 = j2;
            if (context.getLanguageVersion() == 120) {
                elem = Undefined.instance;
                objNewArray = elem;
            } else {
                objNewArray = context.newArray(topLevelScope, 0);
            }
        }
        long j8 = i;
        long j9 = j8 - j4;
        if (z2) {
            long j10 = j3 + j9;
            if (j10 < SieveCacheKt.NodeLinkMask) {
                int i3 = (int) j10;
                if (nativeArray.ensureCapacity(i3)) {
                    Object[] objArr3 = nativeArray.dense;
                    System.arraycopy(objArr3, (int) j6, objArr3, (int) (j8 + sliceIndex), (int) (j3 - j6));
                    if (i > 0) {
                        System.arraycopy(objArr, 2, nativeArray.dense, (int) sliceIndex, i);
                    }
                    if (j9 < j) {
                        Arrays.fill(nativeArray.dense, i3, (int) j3, Scriptable.NOT_FOUND);
                    }
                    nativeArray.length = j10;
                    return objNewArray;
                }
            }
        }
        long j11 = j3;
        if (j9 > j) {
            long j12 = j11 - 1;
            while (j12 >= j6) {
                setRawElem(context, object, j12 + j9, getRawElem(object, j12));
                j12--;
                j6 = j6;
            }
        } else if (j9 < j) {
            for (long j13 = j6; j13 < j11; j13++) {
                setRawElem(context, object, j13 + j9, getRawElem(object, j13));
            }
            for (long j14 = j11 - 1; j14 >= j11 + j9; j14--) {
                deleteElem(object, j14);
            }
        }
        int length2 = objArr.length - i;
        for (int i4 = 0; i4 < i; i4++) {
            setElem(context, object, ((long) i4) + sliceIndex, objArr[i4 + length2]);
        }
        setLengthProperty(context, object, j11 + j9);
        return objNewArray;
    }

    private static Object js_unshift(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Scriptable object = ScriptRuntime.toObject(context, scriptable, scriptable2);
        int i = 0;
        if (object instanceof NativeArray) {
            NativeArray nativeArray = (NativeArray) object;
            if (nativeArray.denseOnly && nativeArray.ensureCapacity(((int) nativeArray.length) + objArr.length)) {
                Object[] objArr2 = nativeArray.dense;
                System.arraycopy(objArr2, 0, objArr2, objArr.length, (int) nativeArray.length);
                while (i < objArr.length) {
                    nativeArray.dense[i] = objArr[i];
                    i++;
                }
                long length = nativeArray.length + ((long) objArr.length);
                nativeArray.length = length;
                return ScriptRuntime.wrapNumber(length);
            }
        }
        long lengthProperty = getLengthProperty(context, object, false);
        int length2 = objArr.length;
        if (objArr.length > 0) {
            if (lengthProperty > 0) {
                for (long j = lengthProperty - 1; j >= 0; j--) {
                    setRawElem(context, object, ((long) length2) + j, getRawElem(object, j));
                }
            }
            while (i < objArr.length) {
                setElem(context, object, i, objArr[i]);
                i++;
            }
        }
        return setLengthProperty(context, object, lengthProperty + ((long) objArr.length));
    }

    private static Object reduceMethod(Context context, int i, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Scriptable object = ScriptRuntime.toObject(context, scriptable, scriptable2);
        long lengthProperty = getLengthProperty(context, object, false);
        Object obj = objArr.length > 0 ? objArr[0] : Undefined.instance;
        if (obj == null || !(obj instanceof Function)) {
            throw ScriptRuntime.notFunctionError(obj);
        }
        Function function = (Function) obj;
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(function);
        boolean z = i == 24;
        Object objCall = objArr.length > 1 ? objArr[1] : Scriptable.NOT_FOUND;
        for (long j = 0; j < lengthProperty; j++) {
            long j2 = z ? j : (lengthProperty - 1) - j;
            Object rawElem = getRawElem(object, j2);
            Object obj2 = Scriptable.NOT_FOUND;
            if (rawElem != obj2) {
                objCall = objCall == obj2 ? rawElem : function.call(context, topLevelScope, topLevelScope, new Object[]{objCall, rawElem, Long.valueOf(j2), object});
            }
        }
        if (objCall != Scriptable.NOT_FOUND) {
            return objCall;
        }
        throw ScriptRuntime.typeError0("msg.empty.array.reduce");
    }

    private static void setElem(Context context, Scriptable scriptable, long j, Object obj) {
        if (j > SieveCacheKt.NodeLinkMask) {
            ScriptableObject.putProperty(scriptable, Long.toString(j), obj);
        } else {
            ScriptableObject.putProperty(scriptable, (int) j, obj);
        }
    }

    private void setLength(Object obj) {
        if ((this.lengthAttr & 1) != 0) {
            return;
        }
        double number = ScriptRuntime.toNumber(obj);
        long uint32 = ScriptRuntime.toUint32(number);
        double d = uint32;
        if (d != number) {
            throw ScriptRuntime.rangeError(ScriptRuntime.getMessage0("msg.arraylength.bad"));
        }
        if (this.denseOnly) {
            long j = this.length;
            if (uint32 < j) {
                Object[] objArr = this.dense;
                Arrays.fill(objArr, (int) uint32, objArr.length, Scriptable.NOT_FOUND);
                this.length = uint32;
                return;
            } else {
                if (uint32 < 1431655764 && d < j * 1.5d && ensureCapacity((int) uint32)) {
                    this.length = uint32;
                    return;
                }
                this.denseOnly = false;
            }
        }
        long j2 = this.length;
        if (uint32 < j2) {
            if (j2 - uint32 > 4096) {
                for (Object obj2 : getIds()) {
                    if (obj2 instanceof String) {
                        String str = (String) obj2;
                        if (toArrayIndex(str) >= uint32) {
                            delete(str);
                        }
                    } else {
                        int iIntValue = ((Integer) obj2).intValue();
                        if (iIntValue >= uint32) {
                            delete(iIntValue);
                        }
                    }
                }
            } else {
                for (long j3 = uint32; j3 < this.length; j3++) {
                    deleteElem(this, j3);
                }
            }
        }
        this.length = uint32;
    }

    private static Object setLengthProperty(Context context, Scriptable scriptable, long j) {
        Number numberWrapNumber = ScriptRuntime.wrapNumber(j);
        ScriptableObject.putProperty(scriptable, Analytics.Data.LENGTH, numberWrapNumber);
        return numberWrapNumber;
    }

    static void setMaximumInitialCapacity(int i) {
        maximumInitialCapacity = i;
    }

    private static void setRawElem(Context context, Scriptable scriptable, long j, Object obj) {
        if (obj == Scriptable.NOT_FOUND) {
            deleteElem(scriptable, j);
        } else {
            setElem(context, scriptable, j, obj);
        }
    }

    private static long toArrayIndex(double d) {
        if (Double.isNaN(d)) {
            return -1L;
        }
        long uint32 = ScriptRuntime.toUint32(d);
        if (uint32 != d || uint32 == 4294967295L) {
            return -1L;
        }
        return uint32;
    }

    private static int toDenseIndex(Object obj) {
        long arrayIndex = toArrayIndex(obj);
        if (0 > arrayIndex || arrayIndex >= SieveCacheKt.NodeLinkMask) {
            return -1;
        }
        return (int) arrayIndex;
    }

    private static long toSliceIndex(double d, long j) {
        if (d < 0.0d) {
            d += j;
            if (d < 0.0d) {
                return 0L;
            }
        } else if (d > j) {
            return j;
        }
        return (long) d;
    }

    private static String toStringHelper(Context context, Scriptable scriptable, Scriptable scriptable2, boolean z, boolean z2) {
        String str;
        boolean zHas;
        boolean z3;
        long j;
        long j2;
        boolean z4;
        String string;
        Scriptable object = ScriptRuntime.toObject(context, scriptable, scriptable2);
        long lengthProperty = getLengthProperty(context, object, false);
        StringBuilder sb = new StringBuilder(256);
        if (z) {
            sb.append(AbstractJsonLexerKt.BEGIN_LIST);
            str = ", ";
        } else {
            str = ",";
        }
        ObjToIntMap objToIntMap = context.iterating;
        if (objToIntMap == null) {
            context.iterating = new ObjToIntMap(31);
            zHas = false;
            z3 = true;
        } else {
            zHas = objToIntMap.has(object);
            z3 = false;
        }
        long j3 = 0;
        if (zHas) {
            j2 = 0;
            j = 0;
            z4 = false;
        } else {
            try {
                context.iterating.put(object, 0);
                boolean z5 = !z || context.getLanguageVersion() < 150;
                boolean z6 = false;
                j = 0;
                while (j < lengthProperty) {
                    if (j > j3) {
                        sb.append(str);
                    }
                    Object rawElem = getRawElem(object, j);
                    if (rawElem == Scriptable.NOT_FOUND || (z5 && (rawElem == null || rawElem == Undefined.instance))) {
                        j3 = j3;
                        z6 = false;
                    } else {
                        if (z) {
                            string = ScriptRuntime.uneval(context, scriptable, rawElem);
                        } else {
                            if (rawElem instanceof String) {
                                string = (String) rawElem;
                            } else {
                                if (z2) {
                                    rawElem = ScriptRuntime.getPropFunctionAndThis(rawElem, "toLocaleString", context, scriptable).call(context, scriptable, ScriptRuntime.lastStoredScriptable(context), ScriptRuntime.emptyArgs);
                                }
                                string = ScriptRuntime.toString(rawElem);
                            }
                            sb.append(string);
                            z6 = true;
                        }
                        j3 = j3;
                        sb.append(string);
                        z6 = true;
                    }
                    j++;
                    j3 = j3;
                }
                j2 = j3;
                context.iterating.remove(object);
                z4 = z6;
            } catch (Throwable th) {
                if (z3) {
                    context.iterating = null;
                }
                throw th;
            }
        }
        if (z3) {
            context.iterating = null;
        }
        if (z) {
            if (z4 || j <= j2) {
                sb.append(AbstractJsonLexerKt.END_LIST);
            } else {
                sb.append(", ]");
            }
        }
        return sb.toString();
    }

    @Override // java.util.List
    public void add(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return indexOf(obj) > -1;
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject
    protected void defineOwnProperty(Context context, Object obj, ScriptableObject scriptableObject, boolean z) {
        Object[] objArr = this.dense;
        if (objArr != null) {
            this.dense = null;
            this.denseOnly = false;
            for (int i = 0; i < objArr.length; i++) {
                Object obj2 = objArr[i];
                if (obj2 != Scriptable.NOT_FOUND) {
                    put(i, this, obj2);
                }
            }
        }
        long arrayIndex = toArrayIndex(obj);
        if (arrayIndex >= this.length) {
            this.length = arrayIndex + 1;
        }
        super.defineOwnProperty(context, obj, scriptableObject, z);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public void delete(int i) {
        Object[] objArr = this.dense;
        if (objArr == null || i < 0 || i >= objArr.length || isSealed() || (!this.denseOnly && isGetterOrSetter(null, i, true))) {
            super.delete(i);
        } else {
            this.dense[i] = Scriptable.NOT_FOUND;
        }
    }

    /* JADX WARN: Switch 'out' block B:7:0x0011 for B:8:0x0013 already processed. Defaulting to fallback option. */
    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject, external.sdk.pendo.io.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(ARRAY_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int iMethodId = idFunctionObject.methodId();
        while (true) {
            int i = 0;
            switch (iMethodId) {
                case ConstructorId_from /* -28 */:
                    return js_from(context, scriptable, scriptable2, objArr);
                case ConstructorId_of /* -27 */:
                    return js_of(context, scriptable, scriptable2, objArr);
                case ConstructorId_isArray /* -26 */:
                    return Boolean.valueOf(objArr.length > 0 && js_isArray(objArr[0]));
                case ConstructorId_reduceRight /* -25 */:
                case ConstructorId_reduce /* -24 */:
                case ConstructorId_findIndex /* -23 */:
                case ConstructorId_find /* -22 */:
                case ConstructorId_some /* -21 */:
                case ConstructorId_map /* -20 */:
                case ConstructorId_forEach /* -19 */:
                case ConstructorId_filter /* -18 */:
                case -17:
                case -16:
                case -15:
                case -14:
                case -13:
                case -12:
                case -11:
                case -10:
                case -9:
                case -8:
                case -7:
                case -6:
                case -5:
                    if (objArr.length > 0) {
                        scriptable2 = ScriptRuntime.toObject(context, scriptable, objArr[0]);
                        int length = objArr.length - 1;
                        Object[] objArr2 = new Object[length];
                        while (i < length) {
                            int i2 = i + 1;
                            objArr2[i] = objArr[i2];
                            i = i2;
                        }
                        objArr = objArr2;
                    }
                    iMethodId = -iMethodId;
                    break;
                default:
                    switch (iMethodId) {
                        case 1:
                            return scriptable2 == null ? jsConstructor(context, scriptable, objArr) : idFunctionObject.construct(context, scriptable, objArr);
                        case 2:
                            return toStringHelper(context, scriptable, scriptable2, context.hasFeature(4), false);
                        case 3:
                            return toStringHelper(context, scriptable, scriptable2, false, true);
                        case 4:
                            return toStringHelper(context, scriptable, scriptable2, true, false);
                        case 5:
                            return js_join(context, scriptable, scriptable2, objArr);
                        case 6:
                            return js_reverse(context, scriptable, scriptable2, objArr);
                        case 7:
                            return js_sort(context, scriptable, scriptable2, objArr);
                        case 8:
                            return js_push(context, scriptable, scriptable2, objArr);
                        case 9:
                            return js_pop(context, scriptable, scriptable2, objArr);
                        case 10:
                            return js_shift(context, scriptable, scriptable2, objArr);
                        case 11:
                            return js_unshift(context, scriptable, scriptable2, objArr);
                        case 12:
                            return js_splice(context, scriptable, scriptable2, objArr);
                        case 13:
                            return js_concat(context, scriptable, scriptable2, objArr);
                        case 14:
                            return js_slice(context, scriptable, scriptable2, objArr);
                        case 15:
                            return js_indexOf(context, scriptable, scriptable2, objArr);
                        case 16:
                            return js_lastIndexOf(context, scriptable, scriptable2, objArr);
                        case 17:
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                            return iterativeMethod(context, idFunctionObject, scriptable, scriptable2, objArr);
                        case 24:
                        case 25:
                            return reduceMethod(context, iMethodId, scriptable, scriptable2, objArr);
                        case 26:
                            return js_fill(context, scriptable, scriptable2, objArr);
                        case 27:
                            return new NativeArrayIterator(scriptable, ScriptRuntime.toObject(context, scriptable, scriptable2), NativeArrayIterator.ARRAY_ITERATOR_TYPE.KEYS);
                        case 28:
                        case 32:
                            return new NativeArrayIterator(scriptable, ScriptRuntime.toObject(context, scriptable, scriptable2), NativeArrayIterator.ARRAY_ITERATOR_TYPE.VALUES);
                        case 29:
                            return new NativeArrayIterator(scriptable, ScriptRuntime.toObject(context, scriptable, scriptable2), NativeArrayIterator.ARRAY_ITERATOR_TYPE.ENTRIES);
                        case 30:
                            return js_includes(context, scriptable, scriptable2, objArr);
                        case 31:
                            return js_copyWithin(context, scriptable, scriptable2, objArr);
                        default:
                            throw new IllegalArgumentException("Array.prototype has no method: " + idFunctionObject.getFunctionName());
                    }
            }
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected void fillConstructorProperties(IdFunctionObject idFunctionObject) {
        Object obj = ARRAY_TAG;
        addIdFunctionProperty(idFunctionObject, obj, -5, "join", 1);
        addIdFunctionProperty(idFunctionObject, obj, -6, "reverse", 0);
        addIdFunctionProperty(idFunctionObject, obj, -7, "sort", 1);
        addIdFunctionProperty(idFunctionObject, obj, -8, "push", 1);
        addIdFunctionProperty(idFunctionObject, obj, -9, TokenRequest.TokenType.POP, 0);
        addIdFunctionProperty(idFunctionObject, obj, -10, "shift", 0);
        addIdFunctionProperty(idFunctionObject, obj, -11, "unshift", 1);
        addIdFunctionProperty(idFunctionObject, obj, -12, "splice", 2);
        addIdFunctionProperty(idFunctionObject, obj, -13, "concat", 1);
        addIdFunctionProperty(idFunctionObject, obj, -14, AzureActiveDirectorySlice.SLICE_PARAMETER, 2);
        addIdFunctionProperty(idFunctionObject, obj, -15, "indexOf", 1);
        addIdFunctionProperty(idFunctionObject, obj, -16, "lastIndexOf", 1);
        addIdFunctionProperty(idFunctionObject, obj, -17, "every", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_filter, ViewProps.FILTER, 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_forEach, "forEach", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_map, "map", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_some, "some", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_find, "find", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_findIndex, "findIndex", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_reduce, "reduce", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_reduceRight, "reduceRight", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_isArray, "isArray", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_of, "of", 0);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_from, TypedValues.TransitionType.S_FROM, 1);
        super.fillConstructorProperties(idFunctionObject);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected int findInstanceIdInfo(String str) {
        return str.equals(Analytics.Data.LENGTH) ? IdScriptableObject.instanceIdInfo(this.lengthAttr, 1) : super.findInstanceIdInfo(str);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected int findPrototypeId(Symbol symbol) {
        return SymbolKey.ITERATOR.equals(symbol) ? 32 : 0;
    }

    @Override // java.util.List
    public Object get(int i) {
        return get(i);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject
    public int getAttributes(int i) {
        Object[] objArr = this.dense;
        if (objArr == null || i < 0 || i >= objArr.length || objArr[i] == Scriptable.NOT_FOUND) {
            return super.getAttributes(i);
        }
        return 0;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Array";
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public Object getDefaultValue(Class<?> cls) {
        return (cls == ScriptRuntime.NumberClass && Context.getContext().getLanguageVersion() == 120) ? Long.valueOf(this.length) : super.getDefaultValue(cls);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject, external.sdk.pendo.io.mozilla.javascript.ScriptableObject
    public Object[] getIds(boolean z, boolean z2) {
        Object[] ids = super.getIds(z, z2);
        Object[] objArr = this.dense;
        if (objArr != null) {
            int length = objArr.length;
            long j = this.length;
            if (length > j) {
                length = (int) j;
            }
            if (length != 0) {
                int length2 = ids.length;
                Object[] objArr2 = new Object[length + length2];
                int i = 0;
                for (int i2 = 0; i2 != length; i2++) {
                    if (this.dense[i2] != Scriptable.NOT_FOUND) {
                        objArr2[i] = Integer.valueOf(i2);
                        i++;
                    }
                }
                if (i != length) {
                    Object[] objArr3 = new Object[i + length2];
                    System.arraycopy(objArr2, 0, objArr3, 0, i);
                    objArr2 = objArr3;
                }
                System.arraycopy(ids, 0, objArr2, i, length2);
                return objArr2;
            }
        }
        return ids;
    }

    public List<Integer> getIndexIds() {
        Object[] ids = getIds();
        ArrayList arrayList = new ArrayList(ids.length);
        for (Object obj : ids) {
            int int32 = ScriptRuntime.toInt32(obj);
            if (int32 >= 0 && ScriptRuntime.toString(int32).equals(ScriptRuntime.toString(obj))) {
                arrayList.add(Integer.valueOf(int32));
            }
        }
        return arrayList;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected String getInstanceIdName(int i) {
        return i == 1 ? Analytics.Data.LENGTH : super.getInstanceIdName(i);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected Object getInstanceIdValue(int i) {
        return i == 1 ? ScriptRuntime.wrapNumber(this.length) : super.getInstanceIdValue(i);
    }

    public long getLength() {
        return this.length;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected int getMaxInstanceId() {
        return 1;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject, external.sdk.pendo.io.mozilla.javascript.ScriptableObject
    protected ScriptableObject getOwnPropertyDescriptor(Context context, Object obj) {
        int denseIndex;
        Object obj2;
        if (this.dense != null && (denseIndex = toDenseIndex(obj)) >= 0) {
            Object[] objArr = this.dense;
            if (denseIndex < objArr.length && (obj2 = objArr[denseIndex]) != Scriptable.NOT_FOUND) {
                return defaultIndexPropertyDescriptor(obj2);
            }
        }
        return super.getOwnPropertyDescriptor(context, obj);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public boolean has(int i, Scriptable scriptable) {
        if (!this.denseOnly && isGetterOrSetter(null, i, false)) {
            return super.has(i, scriptable);
        }
        Object[] objArr = this.dense;
        if (objArr == null || i < 0 || i >= objArr.length) {
            return super.has(i, scriptable);
        }
        return objArr[i] != Scriptable.NOT_FOUND;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        long j = this.length;
        if (j > SieveCacheKt.NodeLinkMask) {
            throw new IllegalStateException();
        }
        int i = (int) j;
        int i2 = 0;
        if (obj == null) {
            while (i2 < i) {
                if (get(i2) == null) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        while (i2 < i) {
            if (obj.equals(get(i2))) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected void initPrototypeId(int i) {
        String str;
        String str2;
        String str3;
        String str4;
        int i2;
        if (i == 32) {
            initPrototypeMethod(ARRAY_TAG, i, SymbolKey.ITERATOR, "[Symbol.iterator]", 0);
            return;
        }
        switch (i) {
            case 1:
                str = "constructor";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 2:
                str2 = "toString";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 3:
                str2 = "toLocaleString";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 4:
                str2 = "toSource";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 5:
                str = "join";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 6:
                str2 = "reverse";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 7:
                str = "sort";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 8:
                str = "push";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 9:
                str2 = TokenRequest.TokenType.POP;
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 10:
                str2 = "shift";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 11:
                str = "unshift";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 12:
                str3 = "splice";
                i2 = 2;
                str4 = str3;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 13:
                str = "concat";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 14:
                str3 = AzureActiveDirectorySlice.SLICE_PARAMETER;
                i2 = 2;
                str4 = str3;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 15:
                str = "indexOf";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 16:
                str = "lastIndexOf";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 17:
                str = "every";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 18:
                str = ViewProps.FILTER;
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 19:
                str = "forEach";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 20:
                str = "map";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 21:
                str = "some";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 22:
                str = "find";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 23:
                str = "findIndex";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 24:
                str = "reduce";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 25:
                str = "reduceRight";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 26:
                str = "fill";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 27:
                str2 = "keys";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 28:
                str2 = "values";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 29:
                str2 = "entries";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 30:
                str = "includes";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 31:
                str3 = "copyWithin";
                i2 = 2;
                str4 = str3;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return listIterator(0);
    }

    @Deprecated
    public long jsGet_length() {
        return getLength();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        long j = this.length;
        if (j > SieveCacheKt.NodeLinkMask) {
            throw new IllegalStateException();
        }
        int i = ((int) j) - 1;
        if (obj == null) {
            while (i >= 0) {
                if (get(i) == null) {
                    return i;
                }
                i--;
            }
            return -1;
        }
        while (i >= 0) {
            if (obj.equals(get(i))) {
                return i;
            }
            i--;
        }
        return -1;
    }

    @Override // java.util.List
    public ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public void put(int i, Scriptable scriptable, Object obj) {
        if (scriptable == this && !isSealed() && this.dense != null && i >= 0 && (this.denseOnly || !isGetterOrSetter(null, i, true))) {
            if (!isExtensible() && this.length <= i) {
                return;
            }
            Object[] objArr = this.dense;
            if (i < objArr.length) {
                objArr[i] = obj;
                long j = i;
                if (this.length <= j) {
                    this.length = j + 1;
                    return;
                }
                return;
            }
            if (this.denseOnly && i < ((double) objArr.length) * 1.5d && ensureCapacity(i + 1)) {
                this.dense[i] = obj;
                this.length = ((long) i) + 1;
                return;
            }
            this.denseOnly = false;
        }
        super.put(i, scriptable, obj);
        if (scriptable == this && (this.lengthAttr & 1) == 0) {
            long j2 = i;
            if (this.length <= j2) {
                this.length = j2 + 1;
            }
        }
    }

    @Override // java.util.List
    public Object remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public Object set(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    void setDenseOnly(boolean z) {
        if (z && !this.denseOnly) {
            throw new IllegalArgumentException();
        }
        this.denseOnly = z;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected void setInstanceIdAttributes(int i, int i2) {
        if (i == 1) {
            this.lengthAttr = i2;
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected void setInstanceIdValue(int i, Object obj) {
        if (i == 1) {
            setLength(obj);
        } else {
            super.setInstanceIdValue(i, obj);
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, java.util.List, java.util.Collection
    public int size() {
        long j = this.length;
        if (j <= SieveCacheKt.NodeLinkMask) {
            return (int) j;
        }
        throw new IllegalStateException();
    }

    @Override // java.util.List
    public List subList(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return toArray(ScriptRuntime.emptyArgs);
    }

    public NativeArray(Object[] objArr) {
        this.lengthAttr = 6;
        this.denseOnly = true;
        this.dense = objArr;
        this.length = objArr.length;
    }

    private static long toArrayIndex(Object obj) {
        if (obj instanceof String) {
            return toArrayIndex((String) obj);
        }
        if (obj instanceof Number) {
            return toArrayIndex(((Number) obj).doubleValue());
        }
        return -1L;
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:86:0x014f  */
    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected int findPrototypeId(String str) {
        String str2;
        int length = str.length();
        int i = 3;
        if (length != 14) {
            switch (length) {
                case 3:
                    char cCharAt = str.charAt(0);
                    if (cCharAt == 'm') {
                        if (str.charAt(2) == 'p' && str.charAt(1) == 'a') {
                            return 20;
                        }
                    } else if (cCharAt == 'p' && str.charAt(2) == 'p' && str.charAt(1) == 'o') {
                        return 9;
                    }
                    str2 = null;
                    i = 0;
                case 4:
                    char cCharAt2 = str.charAt(2);
                    if (cCharAt2 != 'i') {
                        if (cCharAt2 != 'y') {
                            if (cCharAt2 != 'r') {
                                if (cCharAt2 != 's') {
                                    switch (cCharAt2) {
                                        case 'l':
                                            str2 = "fill";
                                            i = 26;
                                            break;
                                        case 'm':
                                            str2 = "some";
                                            i = 21;
                                            break;
                                        case 'n':
                                            str2 = "find";
                                            i = 22;
                                            break;
                                        default:
                                            str2 = null;
                                            i = 0;
                                            break;
                                    }
                                } else {
                                    str2 = "push";
                                    i = 8;
                                    break;
                                }
                            } else {
                                str2 = "sort";
                                i = 7;
                                break;
                            }
                        } else {
                            str2 = "keys";
                            i = 27;
                            break;
                        }
                    } else {
                        str2 = "join";
                        i = 5;
                        break;
                    }
                    break;
                case 5:
                    char cCharAt3 = str.charAt(1);
                    if (cCharAt3 == 'h') {
                        str2 = "shift";
                        i = 10;
                    } else if (cCharAt3 == 'l') {
                        str2 = AzureActiveDirectorySlice.SLICE_PARAMETER;
                        i = 14;
                    } else if (cCharAt3 != 'v') {
                        str2 = null;
                        i = 0;
                    } else {
                        str2 = "every";
                        i = 17;
                    }
                    break;
                case 6:
                    char cCharAt4 = str.charAt(0);
                    if (cCharAt4 == 'c') {
                        str2 = "concat";
                        i = 13;
                    } else if (cCharAt4 == 'f') {
                        str2 = ViewProps.FILTER;
                        i = 18;
                    } else if (cCharAt4 == 'v') {
                        str2 = "values";
                        i = 28;
                    } else if (cCharAt4 == 'r') {
                        str2 = "reduce";
                        i = 24;
                    } else if (cCharAt4 == 's') {
                        str2 = "splice";
                        i = 12;
                    } else {
                        str2 = null;
                        i = 0;
                    }
                    break;
                case 7:
                    char cCharAt5 = str.charAt(0);
                    if (cCharAt5 == 'e') {
                        str2 = "entries";
                        i = 29;
                    } else if (cCharAt5 == 'f') {
                        str2 = "forEach";
                        i = 19;
                    } else if (cCharAt5 == 'i') {
                        str2 = "indexOf";
                        i = 15;
                    } else if (cCharAt5 == 'r') {
                        str2 = "reverse";
                        i = 6;
                    } else if (cCharAt5 == 'u') {
                        str2 = "unshift";
                        i = 11;
                    } else {
                        str2 = null;
                        i = 0;
                    }
                    break;
                case 8:
                    char cCharAt6 = str.charAt(3);
                    if (cCharAt6 == 'l') {
                        str2 = "includes";
                        i = 30;
                    } else if (cCharAt6 == 'o') {
                        str2 = "toSource";
                        i = 4;
                    } else if (cCharAt6 != 't') {
                        str2 = null;
                        i = 0;
                    } else {
                        str2 = "toString";
                        i = 2;
                    }
                    break;
                case 9:
                    str2 = "findIndex";
                    i = 23;
                    break;
                case 10:
                    str2 = "copyWithin";
                    i = 31;
                    break;
                case 11:
                    char cCharAt7 = str.charAt(0);
                    if (cCharAt7 == 'c') {
                        str2 = "constructor";
                        i = 1;
                    } else if (cCharAt7 == 'l') {
                        str2 = "lastIndexOf";
                        i = 16;
                    } else if (cCharAt7 != 'r') {
                        str2 = null;
                        i = 0;
                    } else {
                        str2 = "reduceRight";
                        i = 25;
                    }
                    break;
                default:
                    str2 = null;
                    i = 0;
                    break;
            }
        } else {
            str2 = "toLocaleString";
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i;
        }
        return 0;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public Object get(int i, Scriptable scriptable) {
        if (!this.denseOnly && isGetterOrSetter(null, i, false)) {
            return super.get(i, scriptable);
        }
        Object[] objArr = this.dense;
        return (objArr == null || i < 0 || i >= objArr.length) ? super.get(i, scriptable) : objArr[i];
    }

    @Override // java.util.List
    public ListIterator listIterator(int i) {
        long j = this.length;
        if (j > SieveCacheKt.NodeLinkMask) {
            throw new IllegalStateException();
        }
        int i2 = (int) j;
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException("Index: " + i);
        }
        return new ListIterator(i, i2) { // from class: external.sdk.pendo.io.mozilla.javascript.NativeArray.2
            int cursor;
            final /* synthetic */ int val$len;
            final /* synthetic */ int val$start;

            {
                this.val$start = i;
                this.val$len = i2;
                this.cursor = i;
            }

            @Override // java.util.ListIterator
            public void add(Object obj) {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public boolean hasNext() {
                return this.cursor < this.val$len;
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return this.cursor > 0;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public Object next() {
                int i3 = this.cursor;
                if (i3 == this.val$len) {
                    throw new NoSuchElementException();
                }
                NativeArray nativeArray = NativeArray.this;
                this.cursor = i3 + 1;
                return nativeArray.get(i3);
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.cursor;
            }

            @Override // java.util.ListIterator
            public Object previous() {
                int i3 = this.cursor;
                if (i3 == 0) {
                    throw new NoSuchElementException();
                }
                NativeArray nativeArray = NativeArray.this;
                int i4 = i3 - 1;
                this.cursor = i4;
                return nativeArray.get(i4);
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.cursor - 1;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.ListIterator
            public void set(Object obj) {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject, external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public void put(String str, Scriptable scriptable, Object obj) {
        super.put(str, scriptable, obj);
        if (scriptable == this) {
            long arrayIndex = toArrayIndex(str);
            if (arrayIndex >= this.length) {
                this.length = arrayIndex + 1;
                this.denseOnly = false;
            }
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray(Object[] objArr) {
        long j = this.length;
        if (j > SieveCacheKt.NodeLinkMask) {
            throw new IllegalStateException();
        }
        int i = (int) j;
        if (objArr.length < i) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
        }
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = get(i2);
        }
        return objArr;
    }

    private static long toArrayIndex(String str) {
        long arrayIndex = toArrayIndex(ScriptRuntime.toNumber(str));
        if (Long.toString(arrayIndex).equals(str)) {
            return arrayIndex;
        }
        return -1L;
    }

    public Object get(long j) {
        if (j < 0 || j >= this.length) {
            throw new IndexOutOfBoundsException();
        }
        Object rawElem = getRawElem(this, j);
        if (rawElem == Scriptable.NOT_FOUND || rawElem == Undefined.instance) {
            return null;
        }
        return rawElem instanceof Wrapper ? ((Wrapper) rawElem).unwrap() : rawElem;
    }
}
