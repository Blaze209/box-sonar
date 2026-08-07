package external.sdk.pendo.io.mozilla.javascript;

import androidx.collection.SieveCacheKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.box.android.data.service.impl.UploadFileService;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.pspdfkit.analytics.Analytics;
import com.pspdfkit.contentediting.models.serializer.ColorSerializer;
import external.sdk.pendo.io.mozilla.javascript.typedarrays.NativeArrayBuffer;
import external.sdk.pendo.io.mozilla.javascript.typedarrays.NativeDataView;
import external.sdk.pendo.io.mozilla.javascript.v8dtoa.DoubleConversion;
import external.sdk.pendo.io.mozilla.javascript.v8dtoa.FastDtoa;
import external.sdk.pendo.io.mozilla.javascript.xml.XMLLib;
import external.sdk.pendo.io.mozilla.javascript.xml.XMLObject;
import io.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
public class ScriptRuntime {
    private static final String DEFAULT_NS_TAG = "__default_namespace__";
    public static final int ENUMERATE_ARRAY = 2;
    public static final int ENUMERATE_ARRAY_NO_ITERATOR = 5;
    public static final int ENUMERATE_KEYS = 0;
    public static final int ENUMERATE_KEYS_NO_ITERATOR = 3;
    public static final int ENUMERATE_VALUES = 1;
    public static final int ENUMERATE_VALUES_IN_ORDER = 6;
    public static final int ENUMERATE_VALUES_NO_ITERATOR = 4;
    public static final double NaN = Double.NaN;
    public static final Class<?> BooleanClass = Kit.classOrNull("java.lang.Boolean");
    public static final Class<?> ByteClass = Kit.classOrNull("java.lang.Byte");
    public static final Class<?> CharacterClass = Kit.classOrNull("java.lang.Character");
    public static final Class<?> ClassClass = Kit.classOrNull("java.lang.Class");
    public static final Class<?> DoubleClass = Kit.classOrNull("java.lang.Double");
    public static final Class<?> FloatClass = Kit.classOrNull("java.lang.Float");
    public static final Class<?> IntegerClass = Kit.classOrNull("java.lang.Integer");
    public static final Class<?> LongClass = Kit.classOrNull("java.lang.Long");
    public static final Class<?> NumberClass = Kit.classOrNull("java.lang.Number");
    public static final Class<?> ObjectClass = Kit.classOrNull("java.lang.Object");
    public static final Class<?> ShortClass = Kit.classOrNull("java.lang.Short");
    public static final Class<?> StringClass = Kit.classOrNull("java.lang.String");
    public static final Class<?> DateClass = Kit.classOrNull("java.util.Date");
    public static final Class<?> ContextClass = Kit.classOrNull("external.sdk.pendo.io.mozilla.javascript.Context");
    public static final Class<?> ContextFactoryClass = Kit.classOrNull("external.sdk.pendo.io.mozilla.javascript.ContextFactory");
    public static final Class<?> FunctionClass = Kit.classOrNull("external.sdk.pendo.io.mozilla.javascript.Function");
    public static final Class<?> ScriptableObjectClass = Kit.classOrNull("external.sdk.pendo.io.mozilla.javascript.ScriptableObject");
    public static final Class<Scriptable> ScriptableClass = Scriptable.class;
    private static final Object LIBRARY_SCOPE_KEY = "LIBRARY_SCOPE";
    public static final Double NaNobj = Double.valueOf(Double.NaN);
    public static final double negativeZero = Double.longBitsToDouble(Long.MIN_VALUE);
    public static final Double zeroObj = Double.valueOf(0.0d);
    public static final Double negativeZeroObj = Double.valueOf(-0.0d);
    public static final MessageProvider messageProvider = new DefaultMessageProvider();
    public static final Object[] emptyArgs = new Object[0];
    public static final String[] emptyStrings = new String[0];

    private static class DefaultMessageProvider implements MessageProvider {
        private DefaultMessageProvider() {
        }

        @Override // external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.MessageProvider
        public String getMessage(String str, Object[] objArr) {
            Context currentContext = Context.getCurrentContext();
            try {
                return new MessageFormat(ResourceBundle.getBundle("external.sdk.pendo.io.mozilla.javascript.resources.Messages", currentContext != null ? currentContext.getLocale() : Locale.getDefault()).getString(str)).format(objArr);
            } catch (MissingResourceException unused) {
                throw new RuntimeException("no message resource found for message property " + str);
            }
        }
    }

    private static class IdEnumeration implements Serializable {
        private static final long serialVersionUID = 1;
        Object currentId;
        boolean enumNumbers;
        int enumType;
        Object[] ids;
        int index;
        Scriptable iterator;
        Scriptable obj;
        ObjToIntMap used;

        private IdEnumeration() {
        }
    }

    public interface MessageProvider {
        String getMessage(String str, Object[] objArr);
    }

    static class NoSuchMethodShim implements Callable {
        String methodName;
        Callable noSuchMethodMethod;

        NoSuchMethodShim(Callable callable, String str) {
            this.noSuchMethodMethod = callable;
            this.methodName = str;
        }

        @Override // external.sdk.pendo.io.mozilla.javascript.Callable
        public Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
            return this.noSuchMethodMethod.call(context, scriptable, scriptable2, new Object[]{this.methodName, ScriptRuntime.newArrayLiteral(objArr, null, context, scriptable)});
        }
    }

    static final class StringIdOrIndex {
        final int index;
        final String stringId;

        StringIdOrIndex(int i) {
            this.stringId = null;
            this.index = i;
        }

        StringIdOrIndex(String str) {
            this.stringId = str;
            this.index = -1;
        }
    }

    protected ScriptRuntime() {
    }

    public static CharSequence add(CharSequence charSequence, Object obj) {
        return new ConsString(charSequence, toCharSequence(obj));
    }

    public static void addInstructionCount(Context context, int i) {
        int i2 = context.instructionCount + i;
        context.instructionCount = i2;
        if (i2 > context.instructionThreshold) {
            context.observeInstructionCount(i2);
            context.instructionCount = 0;
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x003c  */
    public static Object applyOrCall(boolean z, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Scriptable topCallScope;
        Object[] applyArguments;
        Object obj;
        int length = objArr.length;
        Callable callable = getCallable(scriptable2);
        if (length != 0) {
            if (context.hasFeature(15)) {
                obj = objArr[0];
            } else {
                obj = objArr[0];
                if (obj == Undefined.instance) {
                    topCallScope = Undefined.SCRIPTABLE_UNDEFINED;
                }
            }
            topCallScope = toObjectOrNull(context, obj, scriptable);
        } else {
            topCallScope = null;
        }
        if (topCallScope == null && context.hasFeature(15)) {
            topCallScope = getTopCallScope(context);
        }
        if (z) {
            if (length <= 1) {
                applyArguments = emptyArgs;
            } else {
                applyArguments = getApplyArguments(context, objArr[1]);
            }
        } else if (length <= 1) {
            applyArguments = emptyArgs;
        } else {
            int i = length - 1;
            applyArguments = new Object[i];
            System.arraycopy(objArr, 1, applyArguments, 0, i);
        }
        return callable.call(context, scriptable, topCallScope, applyArguments);
    }

    public static Scriptable bind(Context context, Scriptable scriptable, String str) {
        Scriptable parentScope = scriptable.getParentScope();
        XMLObject xMLObject = null;
        if (parentScope != null) {
            XMLObject xMLObject2 = null;
            while (true) {
                if (!(scriptable instanceof NativeWith)) {
                    while (!ScriptableObject.hasProperty(scriptable, str)) {
                        Scriptable parentScope2 = parentScope.getParentScope();
                        if (parentScope2 == null) {
                            break;
                        }
                        Scriptable scriptable2 = parentScope;
                        parentScope = parentScope2;
                        scriptable = scriptable2;
                    }
                    return scriptable;
                }
                Scriptable prototype = scriptable.getPrototype();
                if (prototype instanceof XMLObject) {
                    XMLObject xMLObject3 = (XMLObject) prototype;
                    if (xMLObject3.has(context, str)) {
                        return xMLObject3;
                    }
                    if (xMLObject2 == null) {
                        xMLObject2 = xMLObject3;
                    }
                } else if (ScriptableObject.hasProperty(prototype, str)) {
                    return prototype;
                }
                Scriptable parentScope3 = parentScope.getParentScope();
                if (parentScope3 == null) {
                    break;
                }
                Scriptable scriptable3 = parentScope;
                parentScope = parentScope3;
                scriptable = scriptable3;
            }
            scriptable = parentScope;
            xMLObject = xMLObject2;
        }
        if (context.useDynamicScope) {
            scriptable = checkDynamicScope(context.topCallScope, scriptable);
        }
        return ScriptableObject.hasProperty(scriptable, str) ? scriptable : xMLObject;
    }

    @Deprecated
    public static Object call(Context context, Object obj, Object obj2, Object[] objArr, Scriptable scriptable) {
        if (!(obj instanceof Function)) {
            throw notFunctionError(toString(obj));
        }
        Function function = (Function) obj;
        Scriptable objectOrNull = toObjectOrNull(context, obj2, scriptable);
        if (objectOrNull != null) {
            return function.call(context, scriptable, objectOrNull, objArr);
        }
        throw undefCallError(null, "function");
    }

    public static Object callIterator(Object obj, Context context, Scriptable scriptable) {
        return getElemFunctionAndThis(obj, SymbolKey.ITERATOR, context, scriptable).call(context, scriptable, lastStoredScriptable(context), emptyArgs);
    }

    public static Ref callRef(Callable callable, Scriptable scriptable, Object[] objArr, Context context) {
        if (!(callable instanceof RefCallable)) {
            throw constructError("ReferenceError", getMessage1("msg.no.ref.from.function", toString(callable)));
        }
        RefCallable refCallable = (RefCallable) callable;
        Ref refRefCall = refCallable.refCall(context, scriptable, objArr);
        if (refRefCall != null) {
            return refRefCall;
        }
        throw new IllegalStateException(refCallable.getClass().getName() + ".refCall() returned null");
    }

    public static Object callSpecial(Context context, Callable callable, Scriptable scriptable, Object[] objArr, Scriptable scriptable2, Scriptable scriptable3, int i, String str, int i2) {
        if (i == 1) {
            if (scriptable.getParentScope() == null && NativeGlobal.isEvalFunction(callable)) {
                return evalSpecial(context, scriptable2, scriptable3, objArr, str, i2);
            }
        } else {
            if (i != 2) {
                throw Kit.codeBug();
            }
            if (NativeWith.isWithFunction(callable)) {
                throw Context.reportRuntimeError1("msg.only.from.new", "With");
            }
        }
        return callable.call(context, scriptable2, scriptable, objArr);
    }

    static void checkDeprecated(Context context, String str) {
        int languageVersion = context.getLanguageVersion();
        if (languageVersion >= 140 || languageVersion == 0) {
            String message1 = getMessage1("msg.deprec.ctor", str);
            if (languageVersion != 0) {
                throw Context.reportRuntimeError(message1);
            }
            Context.reportWarning(message1);
        }
    }

    static Scriptable checkDynamicScope(Scriptable scriptable, Scriptable scriptable2) {
        if (scriptable != scriptable2) {
            Scriptable prototype = scriptable;
            do {
                prototype = prototype.getPrototype();
                if (prototype == scriptable2) {
                }
            } while (prototype != null);
            return scriptable2;
        }
        return scriptable;
    }

    public static RegExpProxy checkRegExpProxy(Context context) {
        RegExpProxy regExpProxy = getRegExpProxy(context);
        if (regExpProxy != null) {
            return regExpProxy;
        }
        throw Context.reportRuntimeError0("msg.no.regexp");
    }

    public static boolean cmp_LE(Object obj, Object obj2) {
        double number;
        double number2;
        if ((obj instanceof Number) && (obj2 instanceof Number)) {
            number = ((Number) obj).doubleValue();
            number2 = ((Number) obj2).doubleValue();
        } else {
            if ((obj instanceof Symbol) || (obj2 instanceof Symbol)) {
                throw typeError0("msg.compare.symbol");
            }
            if (obj instanceof Scriptable) {
                obj = ((Scriptable) obj).getDefaultValue(NumberClass);
            }
            if (obj2 instanceof Scriptable) {
                obj2 = ((Scriptable) obj2).getDefaultValue(NumberClass);
            }
            if ((obj instanceof CharSequence) && (obj2 instanceof CharSequence)) {
                return obj.toString().compareTo(obj2.toString()) <= 0;
            }
            number = toNumber(obj);
            number2 = toNumber(obj2);
        }
        return number <= number2;
    }

    public static boolean cmp_LT(Object obj, Object obj2) {
        double number;
        double number2;
        if ((obj instanceof Number) && (obj2 instanceof Number)) {
            number = ((Number) obj).doubleValue();
            number2 = ((Number) obj2).doubleValue();
        } else {
            if ((obj instanceof Symbol) || (obj2 instanceof Symbol)) {
                throw typeError0("msg.compare.symbol");
            }
            if (obj instanceof Scriptable) {
                obj = ((Scriptable) obj).getDefaultValue(NumberClass);
            }
            if (obj2 instanceof Scriptable) {
                obj2 = ((Scriptable) obj2).getDefaultValue(NumberClass);
            }
            if ((obj instanceof CharSequence) && (obj2 instanceof CharSequence)) {
                return obj.toString().compareTo(obj2.toString()) < 0;
            }
            number = toNumber(obj);
            number2 = toNumber(obj2);
        }
        return number < number2;
    }

    public static EcmaError constructError(String str, String str2) {
        int[] iArr = new int[1];
        return constructError(str, str2, Context.getSourcePositionFromStack(iArr), iArr[0], null, 0);
    }

    public static Scriptable createArrowFunctionActivation(NativeFunction nativeFunction, Scriptable scriptable, Object[] objArr, boolean z) {
        return new NativeCall(nativeFunction, scriptable, objArr, true, z);
    }

    @Deprecated
    public static Scriptable createFunctionActivation(NativeFunction nativeFunction, Scriptable scriptable, Object[] objArr) {
        return createFunctionActivation(nativeFunction, scriptable, objArr, false);
    }

    private static XMLLib currentXMLLib(Context context) {
        Scriptable scriptable = context.topCallScope;
        if (scriptable == null) {
            throw new IllegalStateException();
        }
        XMLLib xMLLib = context.cachedXMLLib;
        if (xMLLib != null) {
            return xMLLib;
        }
        XMLLib xMLLibExtractFromScope = XMLLib.extractFromScope(scriptable);
        if (xMLLibExtractFromScope == null) {
            throw new IllegalStateException();
        }
        context.cachedXMLLib = xMLLibExtractFromScope;
        return xMLLibExtractFromScope;
    }

    static String defaultObjectToSource(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        boolean zHas;
        boolean z;
        Object obj;
        ObjToIntMap objToIntMap = context.iterating;
        if (objToIntMap == null) {
            context.iterating = new ObjToIntMap(31);
            z = true;
            zHas = false;
        } else {
            zHas = objToIntMap.has(scriptable2);
            z = false;
        }
        StringBuilder sb = new StringBuilder(128);
        if (z) {
            sb.append("(");
        }
        sb.append(AbstractJsonLexerKt.BEGIN_OBJ);
        if (!zHas) {
            try {
                context.iterating.intern(scriptable2);
                Object[] ids = scriptable2.getIds();
                for (int i = 0; i < ids.length; i++) {
                    Object obj2 = ids[i];
                    if (obj2 instanceof Integer) {
                        int iIntValue = ((Integer) obj2).intValue();
                        obj = scriptable2.get(iIntValue, scriptable2);
                        if (obj != Scriptable.NOT_FOUND) {
                            if (i > 0) {
                                sb.append(", ");
                            }
                            sb.append(iIntValue);
                            sb.append(AbstractJsonLexerKt.COLON);
                            sb.append(uneval(context, scriptable, obj));
                        }
                    } else {
                        String str = (String) obj2;
                        obj = scriptable2.get(str, scriptable2);
                        if (obj != Scriptable.NOT_FOUND) {
                            if (i > 0) {
                                sb.append(", ");
                            }
                            if (isValidIdentifierName(str, context, context.isStrictMode())) {
                                sb.append(str);
                            } else {
                                sb.append('\'');
                                sb.append(escapeString(str, '\''));
                                sb.append('\'');
                            }
                            sb.append(AbstractJsonLexerKt.COLON);
                            sb.append(uneval(context, scriptable, obj));
                        }
                    }
                }
            } catch (Throwable th) {
                if (z) {
                    context.iterating = null;
                }
                throw th;
            }
        }
        if (z) {
            context.iterating = null;
        }
        sb.append(AbstractJsonLexerKt.END_OBJ);
        if (z) {
            sb.append(')');
        }
        return sb.toString();
    }

    static String defaultObjectToString(Scriptable scriptable) {
        if (scriptable == null) {
            return "[object Null]";
        }
        return Undefined.isUndefined(scriptable) ? "[object Undefined]" : "[object " + scriptable.getClassName() + AbstractJsonLexerKt.END_LIST;
    }

    @Deprecated
    public static Object delete(Object obj, Object obj2, Context context) {
        return delete(obj, obj2, context, false);
    }

    public static boolean deleteObjectElem(Scriptable scriptable, Object obj, Context context) {
        boolean zHas;
        if (isSymbol(obj)) {
            SymbolScriptable symbolScriptableEnsureSymbolScriptable = ScriptableObject.ensureSymbolScriptable(scriptable);
            Symbol symbol = (Symbol) obj;
            symbolScriptableEnsureSymbolScriptable.delete(symbol);
            zHas = symbolScriptableEnsureSymbolScriptable.has(symbol, scriptable);
        } else {
            StringIdOrIndex stringIdOrIndex = toStringIdOrIndex(context, obj);
            String str = stringIdOrIndex.stringId;
            if (str == null) {
                scriptable.delete(stringIdOrIndex.index);
                zHas = scriptable.has(stringIdOrIndex.index, scriptable);
            } else {
                scriptable.delete(str);
                zHas = scriptable.has(stringIdOrIndex.stringId, scriptable);
            }
        }
        return !zHas;
    }

    private static Object doScriptableIncrDecr(Scriptable scriptable, String str, Scriptable scriptable2, Object obj, int i) {
        double number;
        boolean z = (i & 2) != 0;
        if (obj instanceof Number) {
            number = ((Number) obj).doubleValue();
        } else {
            number = toNumber(obj);
            if (z) {
                obj = wrapNumber(number);
            }
        }
        Number numberWrapNumber = wrapNumber((i & 1) == 0 ? number + 1.0d : number - 1.0d);
        scriptable.put(str, scriptable2, numberWrapNumber);
        return z ? obj : numberWrapNumber;
    }

    @Deprecated
    public static Object doTopCall(Callable callable, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        return doTopCall(callable, context, scriptable, scriptable2, objArr, context.isTopLevelStrict);
    }

    @Deprecated
    public static Object elemIncrDecr(Object obj, Object obj2, Context context, int i) {
        return elemIncrDecr(obj, obj2, context, getTopCallScope(context), i);
    }

    public static void enterActivationFunction(Context context, Scriptable scriptable) {
        if (context.topCallScope == null) {
            throw new IllegalStateException();
        }
        NativeCall nativeCall = (NativeCall) scriptable;
        nativeCall.parentActivationCall = context.currentActivationCall;
        context.currentActivationCall = nativeCall;
        nativeCall.defineAttributesForArguments();
    }

    public static Scriptable enterDotQuery(Object obj, Scriptable scriptable) {
        if (obj instanceof XMLObject) {
            return ((XMLObject) obj).enterDotQuery(scriptable);
        }
        throw notXmlError(obj);
    }

    public static Scriptable enterWith(Object obj, Context context, Scriptable scriptable) {
        Scriptable objectOrNull = toObjectOrNull(context, obj, scriptable);
        if (objectOrNull != null) {
            return objectOrNull instanceof XMLObject ? ((XMLObject) objectOrNull).enterWith(scriptable) : new NativeWith(scriptable, objectOrNull);
        }
        throw typeError1("msg.undef.with", toString(obj));
    }

    private static void enumChangeObject(IdEnumeration idEnumeration) {
        Object[] objArr;
        Object[] ids = null;
        while (true) {
            Scriptable scriptable = idEnumeration.obj;
            if (scriptable == null) {
                break;
            }
            ids = scriptable.getIds();
            if (ids.length != 0) {
                break;
            } else {
                idEnumeration.obj = idEnumeration.obj.getPrototype();
            }
        }
        if (idEnumeration.obj != null && (objArr = idEnumeration.ids) != null) {
            int length = objArr.length;
            if (idEnumeration.used == null) {
                idEnumeration.used = new ObjToIntMap(length);
            }
            for (int i = 0; i != length; i++) {
                idEnumeration.used.intern(objArr[i]);
            }
        }
        idEnumeration.ids = ids;
        idEnumeration.index = 0;
    }

    public static Object enumId(Object obj, Context context) {
        IdEnumeration idEnumeration = (IdEnumeration) obj;
        if (idEnumeration.iterator != null) {
            return idEnumeration.currentId;
        }
        int i = idEnumeration.enumType;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                throw Kit.codeBug();
                            }
                        }
                    }
                }
                return context.newArray(ScriptableObject.getTopLevelScope(idEnumeration.obj), new Object[]{idEnumeration.currentId, enumValue(obj, context)});
            }
            return enumValue(obj, context);
        }
        return idEnumeration.currentId;
    }

    @Deprecated
    public static Object enumInit(Object obj, Context context, int i) {
        return enumInit(obj, context, getTopCallScope(context), i);
    }

    private static Object enumInitInOrder(Context context, IdEnumeration idEnumeration) {
        Scriptable scriptable = idEnumeration.obj;
        if (scriptable instanceof SymbolScriptable) {
            SymbolKey symbolKey = SymbolKey.ITERATOR;
            if (ScriptableObject.hasProperty(scriptable, symbolKey)) {
                Object property = ScriptableObject.getProperty(idEnumeration.obj, symbolKey);
                if (!(property instanceof Callable)) {
                    throw typeError1("msg.not.iterable", toString(idEnumeration.obj));
                }
                Object objCall = ((Callable) property).call(context, idEnumeration.obj.getParentScope(), idEnumeration.obj, new Object[0]);
                if (!(objCall instanceof Scriptable)) {
                    throw typeError1("msg.not.iterable", toString(idEnumeration.obj));
                }
                idEnumeration.iterator = (Scriptable) objCall;
                return idEnumeration;
            }
        }
        throw typeError1("msg.not.iterable", toString(idEnumeration.obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.lang.String] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static Boolean enumNext(Object obj) {
        Object objValueOf;
        IdEnumeration idEnumeration = (IdEnumeration) obj;
        Scriptable scriptable = idEnumeration.iterator;
        if (scriptable != null) {
            if (idEnumeration.enumType == 6) {
                return enumNextInOrder(idEnumeration);
            }
            Object property = ScriptableObject.getProperty(scriptable, ES6Iterator.NEXT_METHOD);
            if (!(property instanceof Callable)) {
                return Boolean.FALSE;
            }
            try {
                idEnumeration.currentId = ((Callable) property).call(Context.getContext(), idEnumeration.iterator.getParentScope(), idEnumeration.iterator, emptyArgs);
                return Boolean.TRUE;
            } catch (JavaScriptException e) {
                if (e.getValue() instanceof NativeIterator.StopIteration) {
                    return Boolean.FALSE;
                }
                throw e;
            }
        }
        while (true) {
            Scriptable scriptable2 = idEnumeration.obj;
            if (scriptable2 == null) {
                return Boolean.FALSE;
            }
            int i = idEnumeration.index;
            Object[] objArr = idEnumeration.ids;
            if (i == objArr.length) {
                idEnumeration.obj = scriptable2.getPrototype();
                enumChangeObject(idEnumeration);
            } else {
                idEnumeration.index = i + 1;
                Object obj2 = objArr[i];
                ObjToIntMap objToIntMap = idEnumeration.used;
                if (objToIntMap == null || !objToIntMap.has(obj2)) {
                    if (obj2 instanceof Symbol) {
                        continue;
                    } else if (obj2 instanceof String) {
                        objValueOf = (String) obj2;
                        Scriptable scriptable3 = idEnumeration.obj;
                        if (scriptable3.has((String) objValueOf, scriptable3)) {
                            idEnumeration.currentId = objValueOf;
                            return Boolean.TRUE;
                        }
                    } else {
                        int iIntValue = ((Number) obj2).intValue();
                        Scriptable scriptable4 = idEnumeration.obj;
                        if (scriptable4.has(iIntValue, scriptable4)) {
                            objValueOf = idEnumeration.enumNumbers ? Integer.valueOf(iIntValue) : String.valueOf(iIntValue);
                            idEnumeration.currentId = objValueOf;
                            return Boolean.TRUE;
                        }
                    }
                }
            }
        }
    }

    private static Boolean enumNextInOrder(IdEnumeration idEnumeration) {
        Object property = ScriptableObject.getProperty(idEnumeration.iterator, ES6Iterator.NEXT_METHOD);
        if (!(property instanceof Callable)) {
            throw notFunctionError(idEnumeration.iterator, ES6Iterator.NEXT_METHOD);
        }
        Context context = Context.getContext();
        Scriptable parentScope = idEnumeration.iterator.getParentScope();
        Scriptable object = toObject(context, parentScope, ((Callable) property).call(context, parentScope, idEnumeration.iterator, emptyArgs));
        Object property2 = ScriptableObject.getProperty(object, ES6Iterator.DONE_PROPERTY);
        if (property2 != Scriptable.NOT_FOUND && toBoolean(property2)) {
            return Boolean.FALSE;
        }
        idEnumeration.currentId = ScriptableObject.getProperty(object, "value");
        return Boolean.TRUE;
    }

    public static Object enumValue(Object obj, Context context) {
        IdEnumeration idEnumeration = (IdEnumeration) obj;
        if (isSymbol(idEnumeration.currentId)) {
            return ScriptableObject.ensureSymbolScriptable(idEnumeration.obj).get((Symbol) idEnumeration.currentId, idEnumeration.obj);
        }
        StringIdOrIndex stringIdOrIndex = toStringIdOrIndex(context, idEnumeration.currentId);
        String str = stringIdOrIndex.stringId;
        Scriptable scriptable = idEnumeration.obj;
        return str == null ? scriptable.get(stringIdOrIndex.index, scriptable) : scriptable.get(str, scriptable);
    }

    public static boolean eq(Object obj, Object obj2) {
        Object objEquivalentValues;
        Object objEquivalentValues2;
        Object objEquivalentValues3;
        Object objEquivalentValues4;
        Object objEquivalentValues5;
        if (obj == null || obj == Undefined.instance) {
            if (obj2 == null || obj2 == Undefined.instance) {
                return true;
            }
            if (!(obj2 instanceof ScriptableObject) || (objEquivalentValues = ((ScriptableObject) obj2).equivalentValues(obj)) == Scriptable.NOT_FOUND) {
                return false;
            }
            return ((Boolean) objEquivalentValues).booleanValue();
        }
        if (obj instanceof Number) {
            return eqNumber(((Number) obj).doubleValue(), obj2);
        }
        if (obj == obj2) {
            return true;
        }
        if (obj instanceof CharSequence) {
            return eqString((CharSequence) obj, obj2);
        }
        if (obj instanceof Boolean) {
            boolean zBooleanValue = ((Boolean) obj).booleanValue();
            if (obj2 instanceof Boolean) {
                return zBooleanValue == ((Boolean) obj2).booleanValue();
            }
            if (!(obj2 instanceof ScriptableObject) || (objEquivalentValues5 = ((ScriptableObject) obj2).equivalentValues(obj)) == Scriptable.NOT_FOUND) {
                return eqNumber(zBooleanValue ? 1.0d : 0.0d, obj2);
            }
            return ((Boolean) objEquivalentValues5).booleanValue();
        }
        if (!(obj instanceof Scriptable)) {
            warnAboutNonJSObject(obj);
            return obj == obj2;
        }
        if (!(obj2 instanceof Scriptable)) {
            if (obj2 instanceof Boolean) {
                if (!(obj instanceof ScriptableObject) || (objEquivalentValues2 = ((ScriptableObject) obj).equivalentValues(obj2)) == Scriptable.NOT_FOUND) {
                    return eqNumber(((Boolean) obj2).booleanValue() ? 1.0d : 0.0d, obj);
                }
                return ((Boolean) objEquivalentValues2).booleanValue();
            }
            if (obj2 instanceof Number) {
                return eqNumber(((Number) obj2).doubleValue(), obj);
            }
            if (obj2 instanceof CharSequence) {
                return eqString((CharSequence) obj2, obj);
            }
            return false;
        }
        if ((obj instanceof ScriptableObject) && (objEquivalentValues4 = ((ScriptableObject) obj).equivalentValues(obj2)) != Scriptable.NOT_FOUND) {
            return ((Boolean) objEquivalentValues4).booleanValue();
        }
        if ((obj2 instanceof ScriptableObject) && (objEquivalentValues3 = ((ScriptableObject) obj2).equivalentValues(obj)) != Scriptable.NOT_FOUND) {
            return ((Boolean) objEquivalentValues3).booleanValue();
        }
        if (!(obj instanceof Wrapper) || !(obj2 instanceof Wrapper)) {
            return false;
        }
        Object objUnwrap = ((Wrapper) obj).unwrap();
        Object objUnwrap2 = ((Wrapper) obj2).unwrap();
        return objUnwrap == objUnwrap2 || (isPrimitive(objUnwrap) && isPrimitive(objUnwrap2) && eq(objUnwrap, objUnwrap2));
    }

    static boolean eqNumber(double d, Object obj) {
        while (obj != null && obj != Undefined.instance) {
            if (!(obj instanceof Number)) {
                if (!(obj instanceof CharSequence)) {
                    if (!(obj instanceof Boolean)) {
                        if (!isSymbol(obj)) {
                            if (!(obj instanceof Scriptable)) {
                                warnAboutNonJSObject(obj);
                                break;
                            }
                            if (obj instanceof ScriptableObject) {
                                Object objEquivalentValues = ((ScriptableObject) obj).equivalentValues(wrapNumber(d));
                                if (objEquivalentValues != Scriptable.NOT_FOUND) {
                                    return ((Boolean) objEquivalentValues).booleanValue();
                                }
                            }
                            obj = toPrimitive(obj);
                        } else {
                            return false;
                        }
                    } else {
                        return d == (((Boolean) obj).booleanValue() ? 1.0d : 0.0d);
                    }
                } else {
                    return d == toNumber(obj);
                }
            } else {
                return d == ((Number) obj).doubleValue();
            }
        }
        return false;
    }

    private static boolean eqString(CharSequence charSequence, Object obj) {
        Object objEquivalentValues;
        while (obj != null && obj != Undefined.instance) {
            if (!(obj instanceof CharSequence)) {
                if (!(obj instanceof Number)) {
                    if (!(obj instanceof Boolean)) {
                        if (!isSymbol(obj)) {
                            if (!(obj instanceof Scriptable)) {
                                warnAboutNonJSObject(obj);
                                break;
                            }
                            if ((obj instanceof ScriptableObject) && (objEquivalentValues = ((ScriptableObject) obj).equivalentValues(charSequence.toString())) != Scriptable.NOT_FOUND) {
                                return ((Boolean) objEquivalentValues).booleanValue();
                            }
                            obj = toPrimitive(obj);
                        } else {
                            return false;
                        }
                    } else {
                        return toNumber(charSequence.toString()) == (((Boolean) obj).booleanValue() ? 1.0d : 0.0d);
                    }
                } else {
                    return toNumber(charSequence.toString()) == ((Number) obj).doubleValue();
                }
            } else {
                CharSequence charSequence2 = (CharSequence) obj;
                return charSequence.length() == charSequence2.length() && charSequence.toString().equals(charSequence2.toString());
            }
        }
        return false;
    }

    private static RuntimeException errorWithClassName(String str, Object obj) {
        return Context.reportRuntimeError1(str, obj.getClass().getName());
    }

    public static String escapeAttributeValue(Object obj, Context context) {
        return currentXMLLib(context).escapeAttributeValue(obj);
    }

    public static String escapeString(String str) {
        return escapeString(str, '\"');
    }

    public static String escapeTextValue(Object obj, Context context) {
        return currentXMLLib(context).escapeTextValue(obj);
    }

    public static Object evalSpecial(Context context, Scriptable scriptable, Object obj, Object[] objArr, String str, int i) {
        if (objArr.length < 1) {
            return Undefined.instance;
        }
        Object obj2 = objArr[0];
        if (!(obj2 instanceof CharSequence)) {
            if (context.hasFeature(11) || context.hasFeature(9)) {
                throw Context.reportRuntimeError0("msg.eval.nonstring.strict");
            }
            Context.reportWarning(getMessage0("msg.eval.nonstring"));
            return obj2;
        }
        if (str == null) {
            int[] iArr = new int[1];
            String sourcePositionFromStack = Context.getSourcePositionFromStack(iArr);
            if (sourcePositionFromStack != null) {
                i = iArr[0];
                str = sourcePositionFromStack;
            } else {
                str = "";
            }
        }
        String strMakeUrlForGeneratedScript = makeUrlForGeneratedScript(true, str, i);
        ErrorReporter errorReporterForEval = DefaultErrorReporter.forEval(context.getErrorReporter());
        Evaluator evaluatorCreateInterpreter = Context.createInterpreter();
        if (evaluatorCreateInterpreter == null) {
            throw new JavaScriptException("Interpreter not present", str, i);
        }
        Script scriptCompileString = context.compileString(obj2.toString(), evaluatorCreateInterpreter, errorReporterForEval, strMakeUrlForGeneratedScript, 1, null);
        evaluatorCreateInterpreter.setEvalScriptFlag(scriptCompileString);
        return ((Callable) scriptCompileString).call(context, scriptable, (Scriptable) obj, emptyArgs);
    }

    public static void exitActivationFunction(Context context) {
        NativeCall nativeCall = context.currentActivationCall;
        context.currentActivationCall = nativeCall.parentActivationCall;
        nativeCall.parentActivationCall = null;
    }

    static NativeCall findFunctionActivation(Context context, Function function) {
        for (NativeCall nativeCall = context.currentActivationCall; nativeCall != null; nativeCall = nativeCall.parentActivationCall) {
            if (nativeCall.function == function) {
                return nativeCall;
            }
        }
        return null;
    }

    static Object[] getApplyArguments(Context context, Object obj) {
        if (obj == null || obj == Undefined.instance) {
            return emptyArgs;
        }
        if (obj instanceof Scriptable) {
            Scriptable scriptable = (Scriptable) obj;
            if (isArrayLike(scriptable)) {
                return context.getElements(scriptable);
            }
        }
        if (obj instanceof ScriptableObject) {
            return emptyArgs;
        }
        throw typeError0("msg.arg.isnt.array");
    }

    public static Object[] getArrayElements(Scriptable scriptable) {
        long lengthProperty = NativeArray.getLengthProperty(Context.getContext(), scriptable, false);
        if (lengthProperty > SieveCacheKt.NodeLinkMask) {
            throw new IllegalArgumentException();
        }
        int i = (int) lengthProperty;
        if (i == 0) {
            return emptyArgs;
        }
        Object[] objArr = new Object[i];
        for (int i2 = 0; i2 < i; i2++) {
            Object property = ScriptableObject.getProperty(scriptable, i2);
            if (property == Scriptable.NOT_FOUND) {
                property = Undefined.instance;
            }
            objArr[i2] = property;
        }
        return objArr;
    }

    static Callable getCallable(Scriptable scriptable) {
        if (scriptable instanceof Callable) {
            return (Callable) scriptable;
        }
        Object defaultValue = scriptable.getDefaultValue(FunctionClass);
        if (defaultValue instanceof Callable) {
            return (Callable) defaultValue;
        }
        throw notFunctionError(defaultValue, scriptable);
    }

    @Deprecated
    public static Callable getElemFunctionAndThis(Object obj, Object obj2, Context context) {
        return getElemFunctionAndThis(obj, obj2, context, getTopCallScope(context));
    }

    static Function getExistingCtor(Context context, Scriptable scriptable, String str) {
        Object property = ScriptableObject.getProperty(scriptable, str);
        if (property instanceof Function) {
            return (Function) property;
        }
        if (property == Scriptable.NOT_FOUND) {
            throw Context.reportRuntimeError1("msg.ctor.not.found", str);
        }
        throw Context.reportRuntimeError1("msg.not.ctor", str);
    }

    public static ScriptableObject getGlobal(Context context) {
        Class<?> clsClassOrNull = Kit.classOrNull("external.sdk.pendo.io.mozilla.javascript.tools.shell.Global");
        if (clsClassOrNull != null) {
            try {
                return (ScriptableObject) clsClassOrNull.getConstructor(ContextClass).newInstance(context);
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
        return new ImporterTopLevel(context);
    }

    static Object getIndexObject(double d) {
        int i = (int) d;
        return ((double) i) == d ? Integer.valueOf(i) : toString(d);
    }

    public static ScriptableObject getLibraryScopeOrNull(Scriptable scriptable) {
        return (ScriptableObject) ScriptableObject.getTopScopeValue(scriptable, LIBRARY_SCOPE_KEY);
    }

    public static String getMessage(String str, Object[] objArr) {
        return messageProvider.getMessage(str, objArr);
    }

    public static String getMessage0(String str) {
        return getMessage(str, null);
    }

    public static String getMessage1(String str, Object obj) {
        return getMessage(str, new Object[]{obj});
    }

    public static String getMessage2(String str, Object obj, Object obj2) {
        return getMessage(str, new Object[]{obj, obj2});
    }

    public static String getMessage3(String str, Object obj, Object obj2, Object obj3) {
        return getMessage(str, new Object[]{obj, obj2, obj3});
    }

    public static String getMessage4(String str, Object obj, Object obj2, Object obj3, Object obj4) {
        return getMessage(str, new Object[]{obj, obj2, obj3, obj4});
    }

    public static Callable getNameFunctionAndThis(String str, Context context, Scriptable scriptable) {
        Scriptable parentScope = scriptable.getParentScope();
        if (parentScope != null) {
            return (Callable) nameOrFunction(context, scriptable, parentScope, str, true);
        }
        Object obj = topScopeName(context, scriptable, str);
        if (obj instanceof Callable) {
            storeScriptable(context, scriptable);
            return (Callable) obj;
        }
        if (obj == Scriptable.NOT_FOUND) {
            throw notFoundError(scriptable, str);
        }
        throw notFunctionError(obj, str);
    }

    public static Object getObjectElem(Scriptable scriptable, Object obj, Context context) {
        Object property;
        if (scriptable instanceof XMLObject) {
            property = ((XMLObject) scriptable).get(context, obj);
        } else if (isSymbol(obj)) {
            property = ScriptableObject.getProperty(scriptable, (Symbol) obj);
        } else {
            StringIdOrIndex stringIdOrIndex = toStringIdOrIndex(context, obj);
            String str = stringIdOrIndex.stringId;
            property = str == null ? ScriptableObject.getProperty(scriptable, stringIdOrIndex.index) : ScriptableObject.getProperty(scriptable, str);
        }
        return property == Scriptable.NOT_FOUND ? Undefined.instance : property;
    }

    public static Object getObjectIndex(Scriptable scriptable, int i, Context context) {
        Object property = ScriptableObject.getProperty(scriptable, i);
        return property == Scriptable.NOT_FOUND ? Undefined.instance : property;
    }

    public static Object getObjectProp(Scriptable scriptable, String str, Context context) {
        Object property = ScriptableObject.getProperty(scriptable, str);
        if (property != Scriptable.NOT_FOUND) {
            return property;
        }
        if (context.hasFeature(11)) {
            Context.reportWarning(getMessage1("msg.ref.undefined.prop", str));
        }
        return Undefined.instance;
    }

    @Deprecated
    public static Object getObjectPropNoWarn(Object obj, String str, Context context) {
        return getObjectPropNoWarn(obj, str, context, getTopCallScope(context));
    }

    @Deprecated
    public static Callable getPropFunctionAndThis(Object obj, String str, Context context) {
        return getPropFunctionAndThis(obj, str, context, getTopCallScope(context));
    }

    private static Callable getPropFunctionAndThisHelper(Object obj, String str, Context context, Scriptable scriptable) {
        if (scriptable == null) {
            throw undefCallError(obj, str);
        }
        Object property = ScriptableObject.getProperty(scriptable, str);
        if (!(property instanceof Callable)) {
            Object property2 = ScriptableObject.getProperty(scriptable, "__noSuchMethod__");
            if (property2 instanceof Callable) {
                property = new NoSuchMethodShim((Callable) property2, str);
            }
        }
        if (!(property instanceof Callable)) {
            throw notFunctionError(scriptable, property, str);
        }
        storeScriptable(context, scriptable);
        return (Callable) property;
    }

    public static RegExpProxy getRegExpProxy(Context context) {
        return context.getRegExpProxy();
    }

    public static Scriptable getTopCallScope(Context context) {
        Scriptable scriptable = context.topCallScope;
        if (scriptable != null) {
            return scriptable;
        }
        throw new IllegalStateException();
    }

    public static Object getTopLevelProp(Scriptable scriptable, String str) {
        return ScriptableObject.getProperty(ScriptableObject.getTopLevelScope(scriptable), str);
    }

    static String[] getTopPackageNames() {
        return "Dalvik".equals(System.getProperty("java.vm.name")) ? new String[]{ResourceAttributes.TelemetrySdkLanguageValues.JAVA, "javax", "org", "com", "edu", "net", "android"} : new String[]{ResourceAttributes.TelemetrySdkLanguageValues.JAVA, "javax", "org", "com", "edu", "net"};
    }

    public static Callable getValueFunctionAndThis(Object obj, Context context) {
        if (!(obj instanceof Callable)) {
            throw notFunctionError(obj);
        }
        Callable callable = (Callable) obj;
        Scriptable parentScope = callable instanceof Scriptable ? ((Scriptable) callable).getParentScope() : null;
        if (parentScope == null && (parentScope = context.topCallScope) == null) {
            throw new IllegalStateException();
        }
        if (parentScope.getParentScope() != null && !(parentScope instanceof NativeWith) && (parentScope instanceof NativeCall)) {
            parentScope = ScriptableObject.getTopLevelScope(parentScope);
        }
        storeScriptable(context, parentScope);
        return callable;
    }

    public static boolean hasObjectElem(Scriptable scriptable, Object obj, Context context) {
        if (isSymbol(obj)) {
            return ScriptableObject.hasProperty(scriptable, (Symbol) obj);
        }
        StringIdOrIndex stringIdOrIndex = toStringIdOrIndex(context, obj);
        String str = stringIdOrIndex.stringId;
        return str == null ? ScriptableObject.hasProperty(scriptable, stringIdOrIndex.index) : ScriptableObject.hasProperty(scriptable, str);
    }

    public static boolean hasTopCall(Context context) {
        return context.topCallScope != null;
    }

    public static boolean in(Object obj, Object obj2, Context context) {
        if (obj2 instanceof Scriptable) {
            return hasObjectElem((Scriptable) obj2, obj, context);
        }
        throw typeError0("msg.in.not.object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0059, code lost:
    
        if (r4 <= (r5 != 0 ? 8 : 7)) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static long indexFromString(java.lang.String r12) {
        /*
            int r0 = r12.length()
            r1 = -1
            if (r0 <= 0) goto L67
            r3 = 0
            char r4 = r12.charAt(r3)
            r5 = 45
            r6 = 48
            r7 = 1
            if (r4 != r5) goto L1f
            if (r0 <= r7) goto L1f
            char r4 = r12.charAt(r7)
            if (r4 != r6) goto L1d
            return r1
        L1d:
            r5 = r7
            goto L20
        L1f:
            r5 = r3
        L20:
            r8 = r5
            int r4 = r4 + (-48)
            if (r4 < 0) goto L67
            r9 = 9
            if (r4 > r9) goto L67
            if (r5 == 0) goto L2e
            r10 = 11
            goto L30
        L2e:
            r10 = 10
        L30:
            if (r0 > r10) goto L67
            int r10 = -r4
            int r8 = r8 + r7
            if (r10 == 0) goto L4a
        L36:
            if (r8 == r0) goto L4a
            char r4 = r12.charAt(r8)
            int r4 = r4 - r6
            if (r4 < 0) goto L4a
            if (r4 > r9) goto L4a
            int r3 = r10 * 10
            int r3 = r3 - r4
            int r8 = r8 + 1
            r11 = r10
            r10 = r3
            r3 = r11
            goto L36
        L4a:
            if (r8 != r0) goto L67
            r12 = -214748364(0xfffffffff3333334, float:-1.4197688E31)
            if (r3 > r12) goto L5b
            if (r3 != r12) goto L67
            if (r5 == 0) goto L58
            r12 = 8
            goto L59
        L58:
            r12 = 7
        L59:
            if (r4 > r12) goto L67
        L5b:
            if (r5 == 0) goto L5e
            goto L5f
        L5e:
            int r10 = -r10
        L5f:
            long r0 = (long) r10
            r2 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r0 = r0 & r2
            return r0
        L67:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.indexFromString(java.lang.String):long");
    }

    public static void initFunction(Context context, Scriptable scriptable, NativeFunction nativeFunction, int i, boolean z) {
        String functionName;
        if (i == 1) {
            functionName = nativeFunction.getFunctionName();
            if (functionName == null || functionName.length() == 0) {
                return;
            }
            if (!z) {
                ScriptableObject.defineProperty(scriptable, functionName, nativeFunction, 4);
                return;
            }
        } else {
            if (i != 3) {
                throw Kit.codeBug();
            }
            functionName = nativeFunction.getFunctionName();
            if (functionName == null || functionName.length() == 0) {
                return;
            }
            while (scriptable instanceof NativeWith) {
                scriptable = scriptable.getParentScope();
            }
        }
        scriptable.put(functionName, scriptable, nativeFunction);
    }

    public static ScriptableObject initSafeStandardObjects(Context context, ScriptableObject scriptableObject, boolean z) {
        if (scriptableObject == null) {
            scriptableObject = new NativeObject();
        }
        ScriptableObject scriptableObject2 = scriptableObject;
        scriptableObject2.associateValue(LIBRARY_SCOPE_KEY, scriptableObject2);
        new ClassCache().associate(scriptableObject2);
        BaseFunction.init(scriptableObject2, z);
        NativeObject.init(scriptableObject2, z);
        Scriptable objectPrototype = ScriptableObject.getObjectPrototype(scriptableObject2);
        ScriptableObject.getClassPrototype(scriptableObject2, "Function").setPrototype(objectPrototype);
        if (scriptableObject2.getPrototype() == null) {
            scriptableObject2.setPrototype(objectPrototype);
        }
        NativeError.init(scriptableObject2, z);
        NativeGlobal.init(context, scriptableObject2, z);
        NativeArray.init(scriptableObject2, z);
        if (context.getOptimizationLevel() > 0) {
            NativeArray.setMaximumInitialCapacity(UploadFileService.MINIMUM_BYTES_FOR_PREFLIGHT_CHECK);
        }
        NativeString.init(scriptableObject2, z);
        NativeBoolean.init(scriptableObject2, z);
        NativeNumber.init(scriptableObject2, z);
        NativeDate.init(scriptableObject2, z);
        NativeMath.init(scriptableObject2, z);
        NativeJSON.init(scriptableObject2, z);
        NativeWith.init(scriptableObject2, z);
        NativeCall.init(scriptableObject2, z);
        NativeScript.init(scriptableObject2, z);
        NativeIterator.init(context, scriptableObject2, z);
        NativeArrayIterator.init(scriptableObject2, z);
        NativeStringIterator.init(scriptableObject2, z);
        boolean z2 = context.hasFeature(6) && context.getE4xImplementationFactory() != null;
        new LazilyLoadedCtor(scriptableObject2, "RegExp", "external.sdk.pendo.io.mozilla.javascript.regexp.NativeRegExp", z, true);
        new LazilyLoadedCtor(scriptableObject2, "Continuation", "external.sdk.pendo.io.mozilla.javascript.NativeContinuation", z, true);
        if (z2) {
            String implementationClassName = context.getE4xImplementationFactory().getImplementationClassName();
            new LazilyLoadedCtor(scriptableObject2, "XML", implementationClassName, z, true);
            new LazilyLoadedCtor(scriptableObject2, "XMLList", implementationClassName, z, true);
            new LazilyLoadedCtor(scriptableObject2, "Namespace", implementationClassName, z, true);
            new LazilyLoadedCtor(scriptableObject2, "QName", implementationClassName, z, true);
        }
        if ((context.getLanguageVersion() >= 180 && context.hasFeature(14)) || context.getLanguageVersion() >= 200) {
            new LazilyLoadedCtor(scriptableObject2, NativeArrayBuffer.CLASS_NAME, "external.sdk.pendo.io.mozilla.javascript.typedarrays.NativeArrayBuffer", z, true);
            new LazilyLoadedCtor(scriptableObject2, "Int8Array", "external.sdk.pendo.io.mozilla.javascript.typedarrays.NativeInt8Array", z, true);
            new LazilyLoadedCtor(scriptableObject2, "Uint8Array", "external.sdk.pendo.io.mozilla.javascript.typedarrays.NativeUint8Array", z, true);
            new LazilyLoadedCtor(scriptableObject2, "Uint8ClampedArray", "external.sdk.pendo.io.mozilla.javascript.typedarrays.NativeUint8ClampedArray", z, true);
            new LazilyLoadedCtor(scriptableObject2, "Int16Array", "external.sdk.pendo.io.mozilla.javascript.typedarrays.NativeInt16Array", z, true);
            new LazilyLoadedCtor(scriptableObject2, "Uint16Array", "external.sdk.pendo.io.mozilla.javascript.typedarrays.NativeUint16Array", z, true);
            new LazilyLoadedCtor(scriptableObject2, "Int32Array", "external.sdk.pendo.io.mozilla.javascript.typedarrays.NativeInt32Array", z, true);
            new LazilyLoadedCtor(scriptableObject2, "Uint32Array", "external.sdk.pendo.io.mozilla.javascript.typedarrays.NativeUint32Array", z, true);
            new LazilyLoadedCtor(scriptableObject2, "Float32Array", "external.sdk.pendo.io.mozilla.javascript.typedarrays.NativeFloat32Array", z, true);
            new LazilyLoadedCtor(scriptableObject2, "Float64Array", "external.sdk.pendo.io.mozilla.javascript.typedarrays.NativeFloat64Array", z, true);
            new LazilyLoadedCtor(scriptableObject2, NativeDataView.CLASS_NAME, "external.sdk.pendo.io.mozilla.javascript.typedarrays.NativeDataView", z, true);
        }
        if (context.getLanguageVersion() >= 200) {
            NativeSymbol.init(context, scriptableObject2, z);
            NativeCollectionIterator.init(scriptableObject2, "Set Iterator", z);
            NativeCollectionIterator.init(scriptableObject2, "Map Iterator", z);
            NativeMap.init(context, scriptableObject2, z);
            NativeSet.init(context, scriptableObject2, z);
            NativeWeakMap.init(scriptableObject2, z);
            NativeWeakSet.init(scriptableObject2, z);
        }
        if (scriptableObject2 instanceof TopLevel) {
            ((TopLevel) scriptableObject2).cacheBuiltins(scriptableObject2, z);
        }
        return scriptableObject2;
    }

    public static void initScript(NativeFunction nativeFunction, Scriptable scriptable, Context context, Scriptable scriptable2, boolean z) {
        if (context.topCallScope == null) {
            throw new IllegalStateException();
        }
        int paramAndVarCount = nativeFunction.getParamAndVarCount();
        if (paramAndVarCount == 0) {
            return;
        }
        Scriptable parentScope = scriptable2;
        while (parentScope instanceof NativeWith) {
            parentScope = parentScope.getParentScope();
        }
        while (true) {
            int i = paramAndVarCount - 1;
            if (paramAndVarCount == 0) {
                return;
            }
            String paramOrVarName = nativeFunction.getParamOrVarName(i);
            boolean paramOrVarConst = nativeFunction.getParamOrVarConst(i);
            if (ScriptableObject.hasProperty(scriptable2, paramOrVarName)) {
                ScriptableObject.redefineProperty(scriptable2, paramOrVarName, paramOrVarConst);
            } else if (paramOrVarConst) {
                ScriptableObject.defineConstProperty(parentScope, paramOrVarName);
            } else if (z) {
                parentScope.put(paramOrVarName, parentScope, Undefined.instance);
            } else if (!(nativeFunction instanceof InterpretedFunction) || ((InterpretedFunction) nativeFunction).hasFunctionNamed(paramOrVarName)) {
                ScriptableObject.defineProperty(parentScope, paramOrVarName, Undefined.instance, 4);
            }
            paramAndVarCount = i;
        }
    }

    public static ScriptableObject initStandardObjects(Context context, ScriptableObject scriptableObject, boolean z) {
        ScriptableObject scriptableObjectInitSafeStandardObjects = initSafeStandardObjects(context, scriptableObject, z);
        new LazilyLoadedCtor(scriptableObjectInitSafeStandardObjects, "Packages", "external.sdk.pendo.io.mozilla.javascript.NativeJavaTopPackage", z, true);
        new LazilyLoadedCtor(scriptableObjectInitSafeStandardObjects, "getClass", "external.sdk.pendo.io.mozilla.javascript.NativeJavaTopPackage", z, true);
        new LazilyLoadedCtor(scriptableObjectInitSafeStandardObjects, "JavaAdapter", "external.sdk.pendo.io.mozilla.javascript.JavaAdapter", z, true);
        new LazilyLoadedCtor(scriptableObjectInitSafeStandardObjects, "JavaImporter", "external.sdk.pendo.io.mozilla.javascript.ImporterTopLevel", z, true);
        for (String str : getTopPackageNames()) {
            new LazilyLoadedCtor(scriptableObjectInitSafeStandardObjects, str, "external.sdk.pendo.io.mozilla.javascript.NativeJavaTopPackage", z, true);
        }
        return scriptableObjectInitSafeStandardObjects;
    }

    public static boolean instanceOf(Object obj, Object obj2, Context context) {
        if (!(obj2 instanceof Scriptable)) {
            throw typeError0("msg.instanceof.not.object");
        }
        if (obj instanceof Scriptable) {
            return ((Scriptable) obj2).hasInstance((Scriptable) obj);
        }
        return false;
    }

    private static boolean isArrayLike(Scriptable scriptable) {
        if (scriptable != null) {
            return (scriptable instanceof NativeArray) || (scriptable instanceof Arguments) || ScriptableObject.hasProperty(scriptable, Analytics.Data.LENGTH);
        }
        return false;
    }

    public static boolean isArrayObject(Object obj) {
        return (obj instanceof NativeArray) || (obj instanceof Arguments);
    }

    static boolean isGeneratedScript(String str) {
        return str.indexOf("(eval)") >= 0 || str.indexOf("(Function)") >= 0;
    }

    public static boolean isIteratorDone(Context context, Object obj) {
        if (obj instanceof Scriptable) {
            return toBoolean(getObjectProp((Scriptable) obj, ES6Iterator.DONE_PROPERTY, context));
        }
        return false;
    }

    public static boolean isJSLineTerminator(int i) {
        if ((57296 & i) != 0) {
            return false;
        }
        return i == 10 || i == 13 || i == 8232 || i == 8233;
    }

    public static boolean isJSWhitespaceOrLineTerminator(int i) {
        return isStrWhiteSpaceChar(i) || isJSLineTerminator(i);
    }

    public static boolean isNaN(Object obj) {
        if (obj instanceof Double) {
            return ((Double) obj).isNaN();
        }
        if (obj instanceof Float) {
            return ((Float) obj).isNaN();
        }
        return false;
    }

    public static boolean isObject(Object obj) {
        if (obj == null || Undefined.instance.equals(obj)) {
            return false;
        }
        if (obj instanceof ScriptableObject) {
            String typeOf = ((ScriptableObject) obj).getTypeOf();
            return "object".equals(typeOf) || "function".equals(typeOf);
        }
        if (obj instanceof Scriptable) {
            return !(obj instanceof Callable);
        }
        return false;
    }

    public static boolean isPrimitive(Object obj) {
        return obj == null || obj == Undefined.instance || (obj instanceof Number) || (obj instanceof String) || (obj instanceof Boolean);
    }

    public static boolean isRhinoRuntimeType(Class<?> cls) {
        if (cls.isPrimitive()) {
            return cls != Character.TYPE;
        }
        return cls == StringClass || cls == BooleanClass || NumberClass.isAssignableFrom(cls) || ScriptableClass.isAssignableFrom(cls);
    }

    static boolean isSpecialProperty(String str) {
        return str.equals("__proto__") || str.equals("__parent__");
    }

    static boolean isStrWhiteSpaceChar(int i) {
        if (i != 32 && i != 160 && i != 65279 && i != 8232 && i != 8233) {
            switch (i) {
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                    break;
                default:
                    return Character.getType(i) == 12;
            }
        }
        return true;
    }

    static boolean isSymbol(Object obj) {
        return ((obj instanceof NativeSymbol) && ((NativeSymbol) obj).isSymbol()) || (obj instanceof SymbolKey);
    }

    static boolean isValidIdentifierName(String str, Context context, boolean z) {
        int length = str.length();
        if (length == 0 || !Character.isJavaIdentifierStart(str.charAt(0))) {
            return false;
        }
        for (int i = 1; i != length; i++) {
            if (!Character.isJavaIdentifierPart(str.charAt(i))) {
                return false;
            }
        }
        return !TokenStream.isKeyword(str, context.getLanguageVersion(), z);
    }

    private static boolean isVisible(Context context, Object obj) {
        ClassShutter classShutter = context.getClassShutter();
        return classShutter == null || classShutter.visibleToScripts(obj.getClass().getName());
    }

    public static boolean jsDelegatesTo(Scriptable scriptable, Scriptable scriptable2) {
        do {
            scriptable = scriptable.getPrototype();
            if (scriptable == null) {
                return false;
            }
        } while (!scriptable.equals(scriptable2));
        return true;
    }

    public static Scriptable lastStoredScriptable(Context context) {
        Scriptable scriptable = context.scratchScriptable;
        context.scratchScriptable = null;
        return scriptable;
    }

    public static long lastUint32Result(Context context) {
        long j = context.scratchUint32;
        if ((j >>> 32) == 0) {
            return j;
        }
        throw new IllegalStateException();
    }

    public static Scriptable leaveDotQuery(Scriptable scriptable) {
        return ((NativeWith) scriptable).getParentScope();
    }

    public static Scriptable leaveWith(Scriptable scriptable) {
        return ((NativeWith) scriptable).getParentScope();
    }

    static String makeUrlForGeneratedScript(boolean z, String str, int i) {
        StringBuilder sbAppend;
        String str2;
        if (z) {
            sbAppend = new StringBuilder().append(str).append(ColorSerializer.PREFIX).append(i);
            str2 = "(eval)";
        } else {
            sbAppend = new StringBuilder().append(str).append(ColorSerializer.PREFIX).append(i);
            str2 = "(Function)";
        }
        return sbAppend.append(str2).toString();
    }

    public static Ref memberRef(Object obj, Object obj2, Context context, int i) {
        if (obj instanceof XMLObject) {
            return ((XMLObject) obj).memberRef(context, obj2, i);
        }
        throw notXmlError(obj);
    }

    public static Object name(Context context, Scriptable scriptable, String str) {
        Scriptable parentScope = scriptable.getParentScope();
        if (parentScope != null) {
            return nameOrFunction(context, scriptable, parentScope, str, false);
        }
        Object obj = topScopeName(context, scriptable, str);
        if (obj != Scriptable.NOT_FOUND) {
            return obj;
        }
        throw notFoundError(scriptable, str);
    }

    @Deprecated
    public static Object nameIncrDecr(Scriptable scriptable, String str, int i) {
        return nameIncrDecr(scriptable, str, Context.getContext(), i);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0056  */
    /* JADX WARN: Code duplicated, block: B:43:0x0074 A[LOOP:0: B:3:0x0002->B:43:0x0074, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:48:0x004e A[SYNTHETIC] */
    private static Object nameOrFunction(Context context, Scriptable scriptable, Scriptable scriptable2, String str, boolean z) {
        Object property;
        Object obj;
        Scriptable parentScope;
        Scriptable scriptable3 = null;
        Scriptable prototype = scriptable;
        while (true) {
            if (prototype instanceof NativeWith) {
                prototype = prototype.getPrototype();
                if (prototype instanceof XMLObject) {
                    prototype = (XMLObject) prototype;
                    if (prototype.has(str, prototype)) {
                        obj = prototype.get(str, prototype);
                        scriptable2 = prototype;
                    } else if (scriptable3 == null) {
                        scriptable3 = prototype;
                    }
                } else {
                    property = ScriptableObject.getProperty(prototype, str);
                    if (property != Scriptable.NOT_FOUND) {
                        obj = property;
                        scriptable2 = prototype;
                    }
                }
                parentScope = scriptable2.getParentScope();
                if (parentScope == null) {
                    obj = topScopeName(context, scriptable2, str);
                    if (obj == Scriptable.NOT_FOUND) {
                        if (scriptable3 != null || z) {
                            throw notFoundError(scriptable2, str);
                        }
                        obj = scriptable3.get(str, scriptable3);
                    }
                } else {
                    prototype = scriptable2;
                    scriptable2 = parentScope;
                }
            } else {
                if (prototype instanceof NativeCall) {
                    Object obj2 = prototype.get(str, prototype);
                    if (obj2 != Scriptable.NOT_FOUND) {
                        if (z) {
                            scriptable = ScriptableObject.getTopLevelScope(scriptable2);
                        }
                        scriptable2 = scriptable;
                        obj = obj2;
                    }
                } else {
                    property = ScriptableObject.getProperty(prototype, str);
                    if (property != Scriptable.NOT_FOUND) {
                        obj = property;
                        scriptable2 = prototype;
                    }
                }
                parentScope = scriptable2.getParentScope();
                if (parentScope == null) {
                    obj = topScopeName(context, scriptable2, str);
                    if (obj == Scriptable.NOT_FOUND) {
                        if (scriptable3 != null) {
                        }
                        throw notFoundError(scriptable2, str);
                    }
                } else {
                    prototype = scriptable2;
                    scriptable2 = parentScope;
                }
            }
            if (!z) {
                return obj;
            }
            if (!(obj instanceof Callable)) {
                throw notFunctionError(obj, str);
            }
            storeScriptable(context, scriptable2);
            return obj;
        }
    }

    public static Ref nameRef(Object obj, Context context, Scriptable scriptable, int i) {
        return currentXMLLib(context).nameRef(context, obj, scriptable, i);
    }

    public static Scriptable newArrayLiteral(Object[] objArr, int[] iArr, Context context, Scriptable scriptable) {
        int length = objArr.length;
        int i = 0;
        int length2 = iArr != null ? iArr.length : 0;
        int i2 = length + length2;
        if (i2 <= 1 || length2 * 2 >= i2) {
            Scriptable scriptableNewArray = context.newArray(scriptable, i2);
            int i3 = 0;
            int i4 = 0;
            while (i != i2) {
                if (i3 == length2 || iArr[i3] != i) {
                    scriptableNewArray.put(i, scriptableNewArray, objArr[i4]);
                    i4++;
                } else {
                    i3++;
                }
                i++;
            }
            return scriptableNewArray;
        }
        if (length2 != 0) {
            Object[] objArr2 = new Object[i2];
            int i5 = 0;
            int i6 = 0;
            while (i != i2) {
                if (i5 == length2 || iArr[i5] != i) {
                    objArr2[i] = objArr[i6];
                    i6++;
                } else {
                    objArr2[i] = Scriptable.NOT_FOUND;
                    i5++;
                }
                i++;
            }
            objArr = objArr2;
        }
        return context.newArray(scriptable, objArr);
    }

    public static Scriptable newBuiltinObject(Context context, Scriptable scriptable, TopLevel.Builtins builtins, Object[] objArr) {
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        Function builtinCtor = TopLevel.getBuiltinCtor(context, topLevelScope, builtins);
        if (objArr == null) {
            objArr = emptyArgs;
        }
        return builtinCtor.construct(context, topLevelScope, objArr);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0092  */
    /* JADX WARN: Code duplicated, block: B:29:0x009b  */
    /* JADX WARN: Code duplicated, block: B:30:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:33:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:41:0x00da  */
    public static Scriptable newCatchScope(Throwable th, Scriptable scriptable, String str, Context context, Scriptable scriptable2) {
        TopLevel.NativeErrors nativeErrorsValueOf;
        String string;
        String str2;
        Throwable th2;
        RhinoException rhinoException;
        String strSourceName;
        int iLineNumber;
        Object[] objArr;
        Scriptable scriptableNewNativeError;
        Object associatedValue;
        RhinoException rhinoException2;
        boolean z = false;
        if (th instanceof JavaScriptException) {
            associatedValue = ((JavaScriptException) th).getValue();
        } else {
            if (scriptable != null) {
                associatedValue = ((NativeObject) scriptable).getAssociatedValue(th);
                if (associatedValue == null) {
                    Kit.codeBug();
                }
            } else {
                if (th instanceof EcmaError) {
                    EcmaError ecmaError = (EcmaError) th;
                    nativeErrorsValueOf = TopLevel.NativeErrors.valueOf(ecmaError.getName());
                    string = ecmaError.getErrorMessage();
                    rhinoException2 = ecmaError;
                } else {
                    if (th instanceof WrappedException) {
                        WrappedException wrappedException = (WrappedException) th;
                        Throwable wrappedException2 = wrappedException.getWrappedException();
                        TopLevel.NativeErrors nativeErrors = TopLevel.NativeErrors.JavaException;
                        str2 = wrappedException2.getClass().getName() + ": " + wrappedException2.getMessage();
                        th2 = wrappedException2;
                        nativeErrorsValueOf = nativeErrors;
                        rhinoException = wrappedException;
                    } else if (th instanceof EvaluatorException) {
                        EvaluatorException evaluatorException = (EvaluatorException) th;
                        nativeErrorsValueOf = TopLevel.NativeErrors.InternalError;
                        string = evaluatorException.getMessage();
                        rhinoException2 = evaluatorException;
                    } else {
                        if (!context.hasFeature(13)) {
                            throw Kit.codeBug();
                        }
                        WrappedException wrappedException3 = new WrappedException(th);
                        nativeErrorsValueOf = TopLevel.NativeErrors.JavaException;
                        string = th.toString();
                        rhinoException2 = wrappedException3;
                    }
                    strSourceName = rhinoException.sourceName();
                    if (strSourceName == null) {
                        strSourceName = "";
                    }
                    iLineNumber = rhinoException.lineNumber();
                    if (iLineNumber > 0) {
                        objArr = new Object[]{str2, strSourceName, Integer.valueOf(iLineNumber)};
                    } else {
                        objArr = new Object[]{str2, strSourceName};
                    }
                    scriptableNewNativeError = newNativeError(context, scriptable2, nativeErrorsValueOf, objArr);
                    if (scriptableNewNativeError instanceof NativeError) {
                        ((NativeError) scriptableNewNativeError).setStackProvider(rhinoException);
                    }
                    if (th2 != null && isVisible(context, th2)) {
                        ScriptableObject.defineProperty(scriptableNewNativeError, "javaException", context.getWrapFactory().wrap(context, scriptable2, th2, null), 7);
                    }
                    if (isVisible(context, rhinoException)) {
                        ScriptableObject.defineProperty(scriptableNewNativeError, "rhinoException", context.getWrapFactory().wrap(context, scriptable2, rhinoException, null), 7);
                    }
                    associatedValue = scriptableNewNativeError;
                }
                str2 = string;
                th2 = null;
                rhinoException = rhinoException2;
                strSourceName = rhinoException.sourceName();
                if (strSourceName == null) {
                    strSourceName = "";
                }
                iLineNumber = rhinoException.lineNumber();
                if (iLineNumber > 0) {
                    objArr = new Object[]{str2, strSourceName, Integer.valueOf(iLineNumber)};
                } else {
                    objArr = new Object[]{str2, strSourceName};
                }
                scriptableNewNativeError = newNativeError(context, scriptable2, nativeErrorsValueOf, objArr);
                if (scriptableNewNativeError instanceof NativeError) {
                    ((NativeError) scriptableNewNativeError).setStackProvider(rhinoException);
                }
                if (th2 != null) {
                    ScriptableObject.defineProperty(scriptableNewNativeError, "javaException", context.getWrapFactory().wrap(context, scriptable2, th2, null), 7);
                }
                if (isVisible(context, rhinoException)) {
                    ScriptableObject.defineProperty(scriptableNewNativeError, "rhinoException", context.getWrapFactory().wrap(context, scriptable2, rhinoException, null), 7);
                }
                associatedValue = scriptableNewNativeError;
            }
            z = true;
        }
        NativeObject nativeObject = new NativeObject();
        nativeObject.defineProperty(str, associatedValue, 4);
        if (isVisible(context, th)) {
            nativeObject.defineProperty("__exception__", Context.javaToJS(th, scriptable2), 6);
        }
        if (z) {
            nativeObject.associateValue(th, associatedValue);
        }
        return nativeObject;
    }

    static Scriptable newNativeError(Context context, Scriptable scriptable, TopLevel.NativeErrors nativeErrors, Object[] objArr) {
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        Function nativeErrorCtor = TopLevel.getNativeErrorCtor(context, topLevelScope, nativeErrors);
        if (objArr == null) {
            objArr = emptyArgs;
        }
        return nativeErrorCtor.construct(context, topLevelScope, objArr);
    }

    public static Scriptable newObject(Context context, Scriptable scriptable, String str, Object[] objArr) {
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        Function existingCtor = getExistingCtor(context, topLevelScope, str);
        if (objArr == null) {
            objArr = emptyArgs;
        }
        return existingCtor.construct(context, topLevelScope, objArr);
    }

    @Deprecated
    public static Scriptable newObjectLiteral(Object[] objArr, Object[] objArr2, Context context, Scriptable scriptable) {
        return newObjectLiteral(objArr, objArr2, null, context, scriptable);
    }

    public static Object newSpecial(Context context, Object obj, Object[] objArr, Scriptable scriptable, int i) {
        if (i == 1) {
            if (NativeGlobal.isEvalFunction(obj)) {
                throw typeError1("msg.not.ctor", "eval");
            }
        } else {
            if (i != 2) {
                throw Kit.codeBug();
            }
            if (NativeWith.isWithFunction(obj)) {
                return NativeWith.newWithSpecial(context, scriptable, objArr);
            }
        }
        return newObject(obj, context, scriptable, objArr);
    }

    public static RuntimeException notFoundError(Scriptable scriptable, String str) {
        throw constructError("ReferenceError", getMessage1("msg.is.not.defined", str));
    }

    public static RuntimeException notFunctionError(Object obj) {
        return notFunctionError(obj, obj);
    }

    private static RuntimeException notXmlError(Object obj) {
        throw typeError1("msg.isnt.xml.object", toString(obj));
    }

    public static String numberToString(double d, int i) {
        if (i < 2 || i > 36) {
            throw Context.reportRuntimeError1("msg.bad.radix", Integer.toString(i));
        }
        if (Double.isNaN(d)) {
            return "NaN";
        }
        if (d == Double.POSITIVE_INFINITY) {
            return "Infinity";
        }
        if (d == Double.NEGATIVE_INFINITY) {
            return "-Infinity";
        }
        if (d == 0.0d) {
            return "0";
        }
        if (i != 10) {
            return DToA.JS_dtobasestr(i, d);
        }
        String strNumberToString = FastDtoa.numberToString(d);
        if (strNumberToString != null) {
            return strNumberToString;
        }
        StringBuilder sb = new StringBuilder();
        DToA.JS_dtostr(sb, 0, 0, d);
        return sb.toString();
    }

    public static Object[] padArguments(Object[] objArr, int i) {
        if (i < objArr.length) {
            return objArr;
        }
        Object[] objArr2 = new Object[i];
        System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
        if (objArr.length < i) {
            Arrays.fill(objArr2, objArr.length, i, Undefined.instance);
        }
        return objArr2;
    }

    @Deprecated
    public static Object propIncrDecr(Object obj, String str, Context context, int i) {
        return propIncrDecr(obj, str, context, getTopCallScope(context), i);
    }

    public static EcmaError rangeError(String str) {
        return constructError("RangeError", str);
    }

    public static Object refDel(Ref ref, Context context) {
        return wrapBoolean(ref.delete(context));
    }

    public static Object refGet(Ref ref, Context context) {
        return ref.get(context);
    }

    @Deprecated
    public static Object refIncrDecr(Ref ref, Context context, int i) {
        return refIncrDecr(ref, context, getTopCallScope(context), i);
    }

    @Deprecated
    public static Object refSet(Ref ref, Object obj, Context context) {
        return refSet(ref, obj, context, getTopCallScope(context));
    }

    public static boolean same(Object obj, Object obj2) {
        if (!typeof(obj).equals(typeof(obj2))) {
            return false;
        }
        if (!(obj instanceof Number)) {
            return eq(obj, obj2);
        }
        if (isNaN(obj) && isNaN(obj2)) {
            return true;
        }
        return obj.equals(obj2);
    }

    public static boolean sameZero(Object obj, Object obj2) {
        if (!typeof(obj).equals(typeof(obj2))) {
            return false;
        }
        if (!(obj instanceof Number)) {
            return eq(obj, obj2);
        }
        if (isNaN(obj) && isNaN(obj2)) {
            return true;
        }
        double dDoubleValue = ((Number) obj).doubleValue();
        if (obj2 instanceof Number) {
            double dDoubleValue2 = ((Number) obj2).doubleValue();
            double d = negativeZero;
            if ((dDoubleValue == d && dDoubleValue2 == 0.0d) || (dDoubleValue == 0.0d && dDoubleValue2 == d)) {
                return true;
            }
        }
        return eqNumber(dDoubleValue, obj2);
    }

    public static Object searchDefaultNamespace(Context context) {
        Scriptable topCallScope = context.currentActivationCall;
        if (topCallScope == null) {
            topCallScope = getTopCallScope(context);
        }
        while (true) {
            Scriptable parentScope = topCallScope.getParentScope();
            if (parentScope == null) {
                Object property = ScriptableObject.getProperty(topCallScope, DEFAULT_NS_TAG);
                if (property == Scriptable.NOT_FOUND) {
                    return null;
                }
                return property;
            }
            Object obj = topCallScope.get(DEFAULT_NS_TAG, topCallScope);
            if (obj != Scriptable.NOT_FOUND) {
                return obj;
            }
            topCallScope = parentScope;
        }
    }

    public static void setBuiltinProtoAndParent(ScriptableObject scriptableObject, Scriptable scriptable, TopLevel.Builtins builtins) {
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        scriptableObject.setParentScope(topLevelScope);
        scriptableObject.setPrototype(TopLevel.getBuiltinPrototype(topLevelScope, builtins));
    }

    public static Object setConst(Scriptable scriptable, Object obj, Context context, String str) {
        if (scriptable instanceof XMLObject) {
            scriptable.put(str, scriptable, obj);
            return obj;
        }
        ScriptableObject.putConstProperty(scriptable, str, obj);
        return obj;
    }

    public static Object setDefaultNamespace(Object obj, Context context) {
        Scriptable topCallScope = context.currentActivationCall;
        if (topCallScope == null) {
            topCallScope = getTopCallScope(context);
        }
        Object defaultXmlNamespace = currentXMLLib(context).toDefaultXmlNamespace(context, obj);
        if (topCallScope.has(DEFAULT_NS_TAG, topCallScope)) {
            topCallScope.put(DEFAULT_NS_TAG, topCallScope, defaultXmlNamespace);
        } else {
            ScriptableObject.defineProperty(topCallScope, DEFAULT_NS_TAG, defaultXmlNamespace, 6);
        }
        return Undefined.instance;
    }

    public static void setEnumNumbers(Object obj, boolean z) {
        ((IdEnumeration) obj).enumNumbers = z;
    }

    public static void setFunctionProtoAndParent(BaseFunction baseFunction, Scriptable scriptable) {
        setFunctionProtoAndParent(baseFunction, scriptable, false);
    }

    public static Object setName(Scriptable scriptable, Object obj, Context context, Scriptable scriptable2, String str) {
        if (scriptable != null) {
            ScriptableObject.putProperty(scriptable, str, obj);
            return obj;
        }
        if (context.hasFeature(11) || context.hasFeature(8)) {
            Context.reportWarning(getMessage1("msg.assn.create.strict", str));
        }
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable2);
        if (context.useDynamicScope) {
            topLevelScope = checkDynamicScope(context.topCallScope, topLevelScope);
        }
        topLevelScope.put(str, topLevelScope, obj);
        return obj;
    }

    public static Object setObjectElem(Scriptable scriptable, Object obj, Object obj2, Context context) {
        if (scriptable instanceof XMLObject) {
            ((XMLObject) scriptable).put(context, obj, obj2);
            return obj2;
        }
        if (isSymbol(obj)) {
            ScriptableObject.putProperty(scriptable, (Symbol) obj, obj2);
            return obj2;
        }
        StringIdOrIndex stringIdOrIndex = toStringIdOrIndex(context, obj);
        String str = stringIdOrIndex.stringId;
        if (str == null) {
            ScriptableObject.putProperty(scriptable, stringIdOrIndex.index, obj2);
            return obj2;
        }
        ScriptableObject.putProperty(scriptable, str, obj2);
        return obj2;
    }

    public static Object setObjectIndex(Scriptable scriptable, int i, Object obj, Context context) {
        ScriptableObject.putProperty(scriptable, i, obj);
        return obj;
    }

    public static Object setObjectProp(Scriptable scriptable, String str, Object obj, Context context) {
        ScriptableObject.putProperty(scriptable, str, obj);
        return obj;
    }

    public static void setObjectProtoAndParent(ScriptableObject scriptableObject, Scriptable scriptable) {
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        scriptableObject.setParentScope(topLevelScope);
        scriptableObject.setPrototype(ScriptableObject.getClassPrototype(topLevelScope, scriptableObject.getClassName()));
    }

    public static void setRegExpProxy(Context context, RegExpProxy regExpProxy) {
        if (regExpProxy == null) {
            throw new IllegalArgumentException();
        }
        context.regExpProxy = regExpProxy;
    }

    public static boolean shallowEq(Object obj, Object obj2) {
        if (obj == obj2) {
            if (obj instanceof Number) {
                return !Double.isNaN(((Number) obj).doubleValue());
            }
            return true;
        }
        if (obj == null || obj == Undefined.instance || obj == Undefined.SCRIPTABLE_UNDEFINED) {
            Object obj3 = Undefined.instance;
            return (obj == obj3 && obj2 == Undefined.SCRIPTABLE_UNDEFINED) || (obj == Undefined.SCRIPTABLE_UNDEFINED && obj2 == obj3);
        }
        if (obj instanceof Number) {
            return (obj2 instanceof Number) && ((Number) obj).doubleValue() == ((Number) obj2).doubleValue();
        }
        if (obj instanceof CharSequence) {
            if (obj2 instanceof CharSequence) {
                return obj.toString().equals(obj2.toString());
            }
        } else if (obj instanceof Boolean) {
            if (obj2 instanceof Boolean) {
                return obj.equals(obj2);
            }
        } else {
            if (!(obj instanceof Scriptable)) {
                warnAboutNonJSObject(obj);
                return obj == obj2;
            }
            if ((obj instanceof Wrapper) && (obj2 instanceof Wrapper) && ((Wrapper) obj).unwrap() == ((Wrapper) obj2).unwrap()) {
                return true;
            }
        }
        return false;
    }

    @Deprecated
    public static Ref specialRef(Object obj, String str, Context context) {
        return specialRef(obj, str, context, getTopCallScope(context));
    }

    private static void storeScriptable(Context context, Scriptable scriptable) {
        if (context.scratchScriptable != null) {
            throw new IllegalStateException();
        }
        context.scratchScriptable = scriptable;
    }

    public static void storeUint32Result(Context context, long j) {
        if ((j >>> 32) != 0) {
            throw new IllegalArgumentException();
        }
        context.scratchUint32 = j;
    }

    public static Object strictSetName(Scriptable scriptable, Object obj, Context context, Scriptable scriptable2, String str) {
        if (scriptable == null) {
            throw constructError("ReferenceError", "Assignment to undefined \"" + str + "\" in strict mode");
        }
        ScriptableObject.putProperty(scriptable, str, obj);
        return obj;
    }

    static double stringPrefixToNumber(String str, int i, int i2) {
        return stringToNumber(str, i, str.length() - 1, i2, true);
    }

    static double stringToNumber(String str, int i, int i2, int i3) {
        return stringToNumber(str, i, i2, i3, false);
    }

    public static long testUint32String(String str) {
        int length = str.length();
        if (1 <= length && length <= 10) {
            int iCharAt = str.charAt(0) - '0';
            if (iCharAt == 0) {
                return length == 1 ? 0L : -1L;
            }
            if (1 <= iCharAt && iCharAt <= 9) {
                long j = iCharAt;
                for (int i = 1; i != length; i++) {
                    int iCharAt2 = str.charAt(i) - '0';
                    if (iCharAt2 < 0 || iCharAt2 > 9) {
                        return -1L;
                    }
                    j = (j * 10) + ((long) iCharAt2);
                }
                if ((j >>> 32) == 0) {
                    return j;
                }
            }
        }
        return -1L;
    }

    public static JavaScriptException throwCustomError(Context context, Scriptable scriptable, String str, String str2) {
        int[] iArr = {0};
        String sourcePositionFromStack = Context.getSourcePositionFromStack(iArr);
        return new JavaScriptException(context.newObject(scriptable, str, new Object[]{str2, sourcePositionFromStack, Integer.valueOf(iArr[0])}), sourcePositionFromStack, iArr[0]);
    }

    public static JavaScriptException throwError(Context context, Scriptable scriptable, String str) {
        int[] iArr = {0};
        String sourcePositionFromStack = Context.getSourcePositionFromStack(iArr);
        return new JavaScriptException(newBuiltinObject(context, scriptable, TopLevel.Builtins.Error, new Object[]{str, sourcePositionFromStack, Integer.valueOf(iArr[0])}), sourcePositionFromStack, iArr[0]);
    }

    public static boolean toBoolean(Object obj) {
        while (!(obj instanceof Boolean)) {
            if (obj == null || obj == Undefined.instance) {
                return false;
            }
            if (obj instanceof CharSequence) {
                return ((CharSequence) obj).length() != 0;
            }
            if (obj instanceof Number) {
                double dDoubleValue = ((Number) obj).doubleValue();
                return (Double.isNaN(dDoubleValue) || dDoubleValue == 0.0d) ? false : true;
            }
            if (!(obj instanceof Scriptable)) {
                warnAboutNonJSObject(obj);
                return true;
            }
            if ((obj instanceof ScriptableObject) && ((ScriptableObject) obj).avoidObjectDetection()) {
                return false;
            }
            if (Context.getContext().isVersionECMA1()) {
                return true;
            }
            obj = ((Scriptable) obj).getDefaultValue(BooleanClass);
            if ((obj instanceof Scriptable) && !isSymbol(obj)) {
                throw errorWithClassName("msg.primitive.expected", obj);
            }
        }
        return ((Boolean) obj).booleanValue();
    }

    public static CharSequence toCharSequence(Object obj) {
        if (obj instanceof NativeString) {
            return ((NativeString) obj).toCharSequence();
        }
        return obj instanceof CharSequence ? (CharSequence) obj : toString(obj);
    }

    public static int toInt32(double d) {
        return DoubleConversion.doubleToInt32(d);
    }

    public static double toInteger(double d) {
        if (Double.isNaN(d)) {
            return 0.0d;
        }
        if (d == 0.0d || Double.isInfinite(d)) {
            return d;
        }
        return d > 0.0d ? Math.floor(d) : Math.ceil(d);
    }

    public static Scriptable toIterator(Context context, Scriptable scriptable, Scriptable scriptable2, boolean z) {
        if (!ScriptableObject.hasProperty(scriptable2, NativeIterator.ITERATOR_PROPERTY_NAME)) {
            return null;
        }
        Object property = ScriptableObject.getProperty(scriptable2, NativeIterator.ITERATOR_PROPERTY_NAME);
        if (!(property instanceof Callable)) {
            throw typeError0("msg.invalid.iterator");
        }
        Object objCall = ((Callable) property).call(context, scriptable, scriptable2, new Object[]{z ? Boolean.TRUE : Boolean.FALSE});
        if (objCall instanceof Scriptable) {
            return (Scriptable) objCall;
        }
        throw typeError0("msg.iterator.primitive");
    }

    public static long toLength(Object[] objArr, int i) {
        double integer = toInteger(objArr, i);
        if (integer <= 0.0d) {
            return 0L;
        }
        return (long) Math.min(integer, 9.007199254740991E15d);
    }

    public static double toNumber(Object obj) {
        while (!(obj instanceof Number)) {
            if (obj == null) {
                return 0.0d;
            }
            if (obj == Undefined.instance) {
                return Double.NaN;
            }
            if (obj instanceof String) {
                return toNumber((String) obj);
            }
            if (obj instanceof CharSequence) {
                return toNumber(obj.toString());
            }
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue() ? 1.0d : 0.0d;
            }
            if (obj instanceof Symbol) {
                throw typeError0("msg.not.a.number");
            }
            if (!(obj instanceof Scriptable)) {
                warnAboutNonJSObject(obj);
                return Double.NaN;
            }
            obj = ((Scriptable) obj).getDefaultValue(NumberClass);
            if ((obj instanceof Scriptable) && !isSymbol(obj)) {
                throw errorWithClassName("msg.primitive.expected", obj);
            }
        }
        return ((Number) obj).doubleValue();
    }

    public static Scriptable toObject(Context context, Scriptable scriptable, Object obj) {
        ScriptableObject nativeBoolean;
        TopLevel.Builtins builtins;
        if (obj == null) {
            throw typeError0("msg.null.to.object");
        }
        if (Undefined.isUndefined(obj)) {
            throw typeError0("msg.undef.to.object");
        }
        if (isSymbol(obj)) {
            nativeBoolean = new NativeSymbol((NativeSymbol) obj);
            builtins = TopLevel.Builtins.Symbol;
        } else {
            if (obj instanceof Scriptable) {
                return (Scriptable) obj;
            }
            if (obj instanceof CharSequence) {
                nativeBoolean = new NativeString((CharSequence) obj);
                builtins = TopLevel.Builtins.String;
            } else if (obj instanceof Number) {
                nativeBoolean = new NativeNumber(((Number) obj).doubleValue());
                builtins = TopLevel.Builtins.Number;
            } else {
                if (!(obj instanceof Boolean)) {
                    Object objWrap = context.getWrapFactory().wrap(context, scriptable, obj, null);
                    if (objWrap instanceof Scriptable) {
                        return (Scriptable) objWrap;
                    }
                    throw errorWithClassName("msg.invalid.type", obj);
                }
                nativeBoolean = new NativeBoolean(((Boolean) obj).booleanValue());
                builtins = TopLevel.Builtins.Boolean;
            }
        }
        setBuiltinProtoAndParent(nativeBoolean, scriptable, builtins);
        return nativeBoolean;
    }

    @Deprecated
    public static Scriptable toObjectOrNull(Context context, Object obj) {
        if (obj instanceof Scriptable) {
            return (Scriptable) obj;
        }
        if (obj == null || obj == Undefined.instance) {
            return null;
        }
        return toObject(context, getTopCallScope(context), obj);
    }

    public static Object toPrimitive(Object obj) {
        return toPrimitive(obj, null);
    }

    public static String toString(double d) {
        return numberToString(d, 10);
    }

    static StringIdOrIndex toStringIdOrIndex(Context context, Object obj) {
        if (obj instanceof Number) {
            double dDoubleValue = ((Number) obj).doubleValue();
            int i = (int) dDoubleValue;
            return ((double) i) == dDoubleValue ? new StringIdOrIndex(i) : new StringIdOrIndex(toString(obj));
        }
        String string = obj instanceof String ? (String) obj : toString(obj);
        long jIndexFromString = indexFromString(string);
        return jIndexFromString >= 0 ? new StringIdOrIndex((int) jIndexFromString) : new StringIdOrIndex(string);
    }

    public static char toUint16(Object obj) {
        return (char) DoubleConversion.doubleToInt32(toNumber(obj));
    }

    public static long toUint32(double d) {
        return ((long) DoubleConversion.doubleToInt32(d)) & 4294967295L;
    }

    private static Object topScopeName(Context context, Scriptable scriptable, String str) {
        if (context.useDynamicScope) {
            scriptable = checkDynamicScope(context.topCallScope, scriptable);
        }
        return ScriptableObject.getProperty(scriptable, str);
    }

    public static EcmaError typeError(String str) {
        return constructError("TypeError", str);
    }

    public static EcmaError typeError0(String str) {
        return typeError(getMessage0(str));
    }

    public static EcmaError typeError1(String str, Object obj) {
        return typeError(getMessage1(str, obj));
    }

    public static EcmaError typeError2(String str, Object obj, Object obj2) {
        return typeError(getMessage2(str, obj, obj2));
    }

    public static EcmaError typeError3(String str, String str2, String str3, String str4) {
        return typeError(getMessage3(str, str2, str3, str4));
    }

    @Deprecated
    public static BaseFunction typeErrorThrower() {
        return typeErrorThrower(Context.getCurrentContext());
    }

    public static String typeof(Object obj) {
        if (obj == null) {
            return "object";
        }
        if (obj == Undefined.instance) {
            return "undefined";
        }
        if (obj instanceof ScriptableObject) {
            return ((ScriptableObject) obj).getTypeOf();
        }
        if (obj instanceof Scriptable) {
            return obj instanceof Callable ? "function" : "object";
        }
        if (obj instanceof CharSequence) {
            return "string";
        }
        if (obj instanceof Number) {
            return "number";
        }
        if (obj instanceof Boolean) {
            return TypedValues.Custom.S_BOOLEAN;
        }
        throw errorWithClassName("msg.invalid.type", obj);
    }

    public static String typeofName(Scriptable scriptable, String str) {
        Context context = Context.getContext();
        Scriptable scriptableBind = bind(context, scriptable, str);
        return scriptableBind == null ? "undefined" : typeof(getObjectProp(scriptableBind, str, context));
    }

    public static RuntimeException undefCallError(Object obj, Object obj2) {
        return typeError2("msg.undef.method.call", toString(obj), toString(obj2));
    }

    private static RuntimeException undefDeleteError(Object obj, Object obj2) {
        throw typeError2("msg.undef.prop.delete", toString(obj), toString(obj2));
    }

    public static RuntimeException undefReadError(Object obj, Object obj2) {
        return typeError2("msg.undef.prop.read", toString(obj), toString(obj2));
    }

    public static RuntimeException undefWriteError(Object obj, Object obj2, Object obj3) {
        return typeError3("msg.undef.prop.write", toString(obj), toString(obj2), toString(obj3));
    }

    static String uneval(Context context, Scriptable scriptable, Object obj) {
        if (obj == null) {
            return AbstractJsonLexerKt.NULL;
        }
        if (obj == Undefined.instance) {
            return "undefined";
        }
        if (obj instanceof CharSequence) {
            String strEscapeString = escapeString(obj.toString());
            StringBuilder sb = new StringBuilder(strEscapeString.length() + 2);
            sb.append('\"');
            sb.append(strEscapeString);
            sb.append('\"');
            return sb.toString();
        }
        if (obj instanceof Number) {
            double dDoubleValue = ((Number) obj).doubleValue();
            return (dDoubleValue != 0.0d || 1.0d / dDoubleValue >= 0.0d) ? toString(dDoubleValue) : "-0";
        }
        if (obj instanceof Boolean) {
            return toString(obj);
        }
        if (!(obj instanceof Scriptable)) {
            warnAboutNonJSObject(obj);
            return obj.toString();
        }
        Scriptable scriptable2 = (Scriptable) obj;
        if (ScriptableObject.hasProperty(scriptable2, "toSource")) {
            Object property = ScriptableObject.getProperty(scriptable2, "toSource");
            if (property instanceof Function) {
                return toString(((Function) property).call(context, scriptable, scriptable2, emptyArgs));
            }
        }
        return toString(obj);
    }

    public static Object updateDotQuery(boolean z, Scriptable scriptable) {
        return ((NativeWith) scriptable).updateDotQuery(z);
    }

    private static void warnAboutNonJSObject(Object obj) {
        if (TelemetryEventStrings.Value.TRUE.equals(getMessage0("params.omit.non.js.object.warning"))) {
            return;
        }
        String message2 = getMessage2("msg.non.js.object.warning", obj, obj.getClass().getName());
        Context.reportWarning(message2);
        System.err.println(message2);
    }

    public static Boolean wrapBoolean(boolean z) {
        return Boolean.valueOf(z);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x006d  */
    /* JADX WARN: Code duplicated, block: B:21:0x0078  */
    /* JADX WARN: Code duplicated, block: B:22:0x0086  */
    /* JADX WARN: Code duplicated, block: B:25:0x009a  */
    /* JADX WARN: Code duplicated, block: B:33:0x00bd  */
    public static Scriptable wrapException(Throwable th, Scriptable scriptable, Context context) {
        String string;
        RhinoException rhinoException;
        String name;
        String message;
        Throwable th2;
        RhinoException rhinoException2;
        String strSourceName;
        int iLineNumber;
        Object[] objArr;
        Scriptable scriptableNewObject;
        RhinoException rhinoException3;
        if (!(th instanceof EcmaError)) {
            if (th instanceof WrappedException) {
                WrappedException wrappedException = (WrappedException) th;
                Throwable wrappedException2 = wrappedException.getWrappedException();
                string = wrappedException2.getClass().getName() + ": " + wrappedException2.getMessage();
                th2 = wrappedException2;
                name = "JavaException";
                rhinoException2 = wrappedException;
            } else {
                if (th instanceof EvaluatorException) {
                    EvaluatorException evaluatorException = (EvaluatorException) th;
                    message = evaluatorException.getMessage();
                    name = "InternalError";
                    rhinoException3 = evaluatorException;
                } else {
                    if (!context.hasFeature(13)) {
                        throw Kit.codeBug();
                    }
                    WrappedException wrappedException3 = new WrappedException(th);
                    string = th.toString();
                    rhinoException = wrappedException3;
                    name = "JavaException";
                }
                th2 = null;
                rhinoException2 = rhinoException;
            }
            strSourceName = rhinoException2.sourceName();
            if (strSourceName == null) {
                strSourceName = "";
            }
            iLineNumber = rhinoException2.lineNumber();
            if (iLineNumber > 0) {
                objArr = new Object[]{string, strSourceName, Integer.valueOf(iLineNumber)};
            } else {
                objArr = new Object[]{string, strSourceName};
            }
            scriptableNewObject = context.newObject(scriptable, name, objArr);
            ScriptableObject.putProperty(scriptableNewObject, "name", name);
            if (scriptableNewObject instanceof NativeError) {
                ((NativeError) scriptableNewObject).setStackProvider(rhinoException2);
            }
            if (th2 != null && isVisible(context, th2)) {
                ScriptableObject.defineProperty(scriptableNewObject, "javaException", context.getWrapFactory().wrap(context, scriptable, th2, null), 7);
            }
            if (isVisible(context, rhinoException2)) {
                ScriptableObject.defineProperty(scriptableNewObject, "rhinoException", context.getWrapFactory().wrap(context, scriptable, rhinoException2, null), 7);
            }
            return scriptableNewObject;
        }
        EcmaError ecmaError = (EcmaError) th;
        name = ecmaError.getName();
        message = ecmaError.getErrorMessage();
        rhinoException3 = ecmaError;
        string = message;
        rhinoException = rhinoException3;
        th2 = null;
        rhinoException2 = rhinoException;
        strSourceName = rhinoException2.sourceName();
        if (strSourceName == null) {
            strSourceName = "";
        }
        iLineNumber = rhinoException2.lineNumber();
        if (iLineNumber > 0) {
            objArr = new Object[]{string, strSourceName, Integer.valueOf(iLineNumber)};
        } else {
            objArr = new Object[]{string, strSourceName};
        }
        scriptableNewObject = context.newObject(scriptable, name, objArr);
        ScriptableObject.putProperty(scriptableNewObject, "name", name);
        if (scriptableNewObject instanceof NativeError) {
            ((NativeError) scriptableNewObject).setStackProvider(rhinoException2);
        }
        if (th2 != null) {
            ScriptableObject.defineProperty(scriptableNewObject, "javaException", context.getWrapFactory().wrap(context, scriptable, th2, null), 7);
        }
        if (isVisible(context, rhinoException2)) {
            ScriptableObject.defineProperty(scriptableNewObject, "rhinoException", context.getWrapFactory().wrap(context, scriptable, rhinoException2, null), 7);
        }
        return scriptableNewObject;
    }

    public static Integer wrapInt(int i) {
        return Integer.valueOf(i);
    }

    public static Number wrapNumber(double d) {
        return Double.isNaN(d) ? NaNobj : Double.valueOf(d);
    }

    public static Scriptable wrapRegExp(Context context, Scriptable scriptable, Object obj) {
        return context.getRegExpProxy().wrapRegExp(context, scriptable, obj);
    }

    public static CharSequence add(Object obj, CharSequence charSequence) {
        return new ConsString(toCharSequence(obj), charSequence);
    }

    public static EcmaError constructError(String str, String str2, int i) {
        int[] iArr = new int[1];
        String sourcePositionFromStack = Context.getSourcePositionFromStack(iArr);
        int i2 = iArr[0];
        if (i2 != 0) {
            iArr[0] = i2 + i;
        }
        return constructError(str, str2, sourcePositionFromStack, iArr[0], null, 0);
    }

    public static Scriptable createFunctionActivation(NativeFunction nativeFunction, Scriptable scriptable, Object[] objArr, boolean z) {
        return new NativeCall(nativeFunction, scriptable, objArr, false, z);
    }

    public static Object delete(Object obj, Object obj2, Context context, Scriptable scriptable, boolean z) {
        Scriptable objectOrNull = toObjectOrNull(context, obj, scriptable);
        if (objectOrNull != null) {
            return wrapBoolean(deleteObjectElem(objectOrNull, obj2, context));
        }
        if (z) {
            return Boolean.TRUE;
        }
        throw undefDeleteError(obj, obj2);
    }

    public static Object doTopCall(Callable callable, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr, boolean z) {
        if (scriptable == null) {
            throw new IllegalArgumentException();
        }
        if (context.topCallScope != null) {
            throw new IllegalStateException();
        }
        context.topCallScope = ScriptableObject.getTopLevelScope(scriptable);
        context.useDynamicScope = context.hasFeature(7);
        boolean z2 = context.isTopLevelStrict;
        context.isTopLevelStrict = z;
        try {
            Object objDoTopCall = context.getFactory().doTopCall(callable, context, scriptable, scriptable2, objArr);
            context.topCallScope = null;
            context.cachedXMLLib = null;
            context.isTopLevelStrict = z2;
            if (context.currentActivationCall == null) {
                return objDoTopCall;
            }
            throw new IllegalStateException();
        } catch (Throwable th) {
            context.topCallScope = null;
            context.cachedXMLLib = null;
            context.isTopLevelStrict = z2;
            if (context.currentActivationCall != null) {
                throw new IllegalStateException();
            }
            throw th;
        }
    }

    public static Object elemIncrDecr(Object obj, Object obj2, Context context, Scriptable scriptable, int i) {
        double number;
        Object objectElem = getObjectElem(obj, obj2, context, scriptable);
        boolean z = (i & 2) != 0;
        if (objectElem instanceof Number) {
            number = ((Number) objectElem).doubleValue();
        } else {
            number = toNumber(objectElem);
            if (z) {
                objectElem = wrapNumber(number);
            }
        }
        Number numberWrapNumber = wrapNumber((i & 1) == 0 ? number + 1.0d : number - 1.0d);
        setObjectElem(obj, obj2, numberWrapNumber, context, scriptable);
        return z ? objectElem : numberWrapNumber;
    }

    public static Object enumInit(Object obj, Context context, Scriptable scriptable, int i) {
        IdEnumeration idEnumeration = new IdEnumeration();
        Scriptable objectOrNull = toObjectOrNull(context, obj, scriptable);
        idEnumeration.obj = objectOrNull;
        if (i == 6) {
            idEnumeration.enumType = i;
            idEnumeration.iterator = null;
            return enumInitInOrder(context, idEnumeration);
        }
        if (objectOrNull != null) {
            idEnumeration.enumType = i;
            idEnumeration.iterator = null;
            if (i != 3 && i != 4 && i != 5) {
                idEnumeration.iterator = toIterator(context, objectOrNull.getParentScope(), idEnumeration.obj, i == 0);
            }
            if (idEnumeration.iterator == null) {
                enumChangeObject(idEnumeration);
            }
        }
        return idEnumeration;
    }

    public static String escapeString(String str, char c) {
        int i;
        char c2;
        if (c != '\"' && c != '\'' && c != '`') {
            Kit.codeBug();
        }
        int length = str.length();
        StringBuilder sb = null;
        for (int i2 = 0; i2 != length; i2++) {
            char cCharAt = str.charAt(i2);
            int i3 = 32;
            if (' ' > cCharAt || cCharAt > '~' || cCharAt == c || cCharAt == '\\') {
                if (sb == null) {
                    sb = new StringBuilder(length + 3);
                    sb.append(str);
                    sb.setLength(i2);
                }
                if (cCharAt != ' ') {
                    if (cCharAt != '\\') {
                        switch (cCharAt) {
                            case '\b':
                                i3 = 98;
                                break;
                            case '\t':
                                i3 = 116;
                                break;
                            case '\n':
                                i3 = 110;
                                break;
                            case 11:
                                i3 = 118;
                                break;
                            case '\f':
                                i3 = 102;
                                break;
                            case '\r':
                                i3 = 114;
                                break;
                            default:
                                i3 = -1;
                                break;
                        }
                    } else {
                        i3 = 92;
                    }
                }
                if (i3 >= 0) {
                    sb.append('\\');
                    c2 = (char) i3;
                    sb.append(c2);
                } else if (cCharAt == c) {
                    sb.append('\\');
                    sb.append(c);
                } else {
                    if (cCharAt < 256) {
                        sb.append("\\x");
                        i = 2;
                    } else {
                        sb.append("\\u");
                        i = 4;
                    }
                    for (int i4 = (i - 1) * 4; i4 >= 0; i4 -= 4) {
                        int i5 = (cCharAt >> i4) & 15;
                        sb.append((char) (i5 < 10 ? i5 + 48 : i5 + 87));
                    }
                }
            } else if (sb != null) {
                c2 = cCharAt;
                sb.append(c2);
            }
        }
        return sb == null ? str : sb.toString();
    }

    public static Callable getElemFunctionAndThis(Object obj, Object obj2, Context context, Scriptable scriptable) {
        Scriptable objectOrNull;
        Object property;
        if (isSymbol(obj2)) {
            objectOrNull = toObjectOrNull(context, obj, scriptable);
            if (objectOrNull == null) {
                throw undefCallError(obj, String.valueOf(obj2));
            }
            property = ScriptableObject.getProperty(objectOrNull, (Symbol) obj2);
        } else {
            StringIdOrIndex stringIdOrIndex = toStringIdOrIndex(context, obj2);
            String str = stringIdOrIndex.stringId;
            if (str != null) {
                return getPropFunctionAndThis(obj, str, context, scriptable);
            }
            objectOrNull = toObjectOrNull(context, obj, scriptable);
            if (objectOrNull == null) {
                throw undefCallError(obj, String.valueOf(obj2));
            }
            property = ScriptableObject.getProperty(objectOrNull, stringIdOrIndex.index);
        }
        if (!(property instanceof Callable)) {
            throw notFunctionError(property, obj2);
        }
        storeScriptable(context, objectOrNull);
        return (Callable) property;
    }

    static Object getIndexObject(String str) {
        long jIndexFromString = indexFromString(str);
        return jIndexFromString >= 0 ? Integer.valueOf((int) jIndexFromString) : str;
    }

    @Deprecated
    public static Object getObjectElem(Object obj, Object obj2, Context context) {
        return getObjectElem(obj, obj2, context, getTopCallScope(context));
    }

    @Deprecated
    public static Object getObjectIndex(Object obj, double d, Context context) {
        return getObjectIndex(obj, d, context, getTopCallScope(context));
    }

    @Deprecated
    public static Object getObjectProp(Object obj, String str, Context context) {
        return getObjectProp(obj, str, context, getTopCallScope(context));
    }

    public static Object getObjectPropNoWarn(Object obj, String str, Context context, Scriptable scriptable) {
        Scriptable objectOrNull = toObjectOrNull(context, obj, scriptable);
        if (objectOrNull == null) {
            throw undefReadError(obj, str);
        }
        Object property = ScriptableObject.getProperty(objectOrNull, str);
        return property == Scriptable.NOT_FOUND ? Undefined.instance : property;
    }

    public static Callable getPropFunctionAndThis(Object obj, String str, Context context, Scriptable scriptable) {
        return getPropFunctionAndThisHelper(obj, str, context, toObjectOrNull(context, obj, scriptable));
    }

    public static Ref memberRef(Object obj, Object obj2, Object obj3, Context context, int i) {
        if (obj instanceof XMLObject) {
            return ((XMLObject) obj).memberRef(context, obj2, obj3, i);
        }
        throw notXmlError(obj);
    }

    public static Object nameIncrDecr(Scriptable scriptable, String str, Context context, int i) {
        do {
            if (context.useDynamicScope && scriptable.getParentScope() == null) {
                scriptable = checkDynamicScope(context.topCallScope, scriptable);
            }
            Scriptable prototype = scriptable;
            do {
                if ((prototype instanceof NativeWith) && (prototype.getPrototype() instanceof XMLObject)) {
                    break;
                }
                Object obj = prototype.get(str, scriptable);
                if (obj != Scriptable.NOT_FOUND) {
                    return doScriptableIncrDecr(prototype, str, scriptable, obj, i);
                }
                prototype = prototype.getPrototype();
            } while (prototype != null);
            scriptable = scriptable.getParentScope();
        } while (scriptable != null);
        throw notFoundError(null, str);
    }

    public static Ref nameRef(Object obj, Object obj2, Context context, Scriptable scriptable, int i) {
        return currentXMLLib(context).nameRef(context, obj, obj2, scriptable, i);
    }

    public static Scriptable newObject(Object obj, Context context, Scriptable scriptable, Object[] objArr) {
        if (obj instanceof Function) {
            return ((Function) obj).construct(context, scriptable, objArr);
        }
        throw notFunctionError(obj);
    }

    public static Scriptable newObjectLiteral(Object[] objArr, Object[] objArr2, int[] iArr, Context context, Scriptable scriptable) {
        Scriptable scriptableNewObject = context.newObject(scriptable);
        int length = objArr.length;
        for (int i = 0; i != length; i++) {
            Object obj = objArr[i];
            int i2 = iArr == null ? 0 : iArr[i];
            Object obj2 = objArr2[i];
            if (!(obj instanceof String)) {
                scriptableNewObject.put(((Integer) obj).intValue(), scriptableNewObject, obj2);
            } else if (i2 == 0) {
                String str = (String) obj;
                if (isSpecialProperty(str)) {
                    specialRef(scriptableNewObject, str, context, scriptable).set(context, scriptable, obj2);
                } else {
                    scriptableNewObject.put(str, scriptableNewObject, obj2);
                }
            } else {
                ((ScriptableObject) scriptableNewObject).setGetterOrSetter((String) obj, 0, (Callable) obj2, i2 == 1);
            }
        }
        return scriptableNewObject;
    }

    public static RuntimeException notFunctionError(Object obj, Object obj2) {
        String string = obj2 == null ? AbstractJsonLexerKt.NULL : obj2.toString();
        return obj == Scriptable.NOT_FOUND ? typeError1("msg.function.not.found", string) : typeError2("msg.isnt.function", string, typeof(obj));
    }

    public static Object propIncrDecr(Object obj, String str, Context context, Scriptable scriptable, int i) {
        Scriptable objectOrNull = toObjectOrNull(context, obj, scriptable);
        if (objectOrNull == null) {
            throw undefReadError(obj, str);
        }
        Scriptable prototype = objectOrNull;
        do {
            Object obj2 = prototype.get(str, objectOrNull);
            if (obj2 != Scriptable.NOT_FOUND) {
                return doScriptableIncrDecr(prototype, str, objectOrNull, obj2, i);
            }
            prototype = prototype.getPrototype();
        } while (prototype != null);
        Double d = NaNobj;
        objectOrNull.put(str, objectOrNull, d);
        return d;
    }

    public static Object refIncrDecr(Ref ref, Context context, Scriptable scriptable, int i) {
        double number;
        Object objWrapNumber = ref.get(context);
        boolean z = (i & 2) != 0;
        if (objWrapNumber instanceof Number) {
            number = ((Number) objWrapNumber).doubleValue();
        } else {
            number = toNumber(objWrapNumber);
            if (z) {
                objWrapNumber = wrapNumber(number);
            }
        }
        Number numberWrapNumber = wrapNumber((i & 1) == 0 ? number + 1.0d : number - 1.0d);
        ref.set(context, scriptable, numberWrapNumber);
        return z ? objWrapNumber : numberWrapNumber;
    }

    public static Object refSet(Ref ref, Object obj, Context context, Scriptable scriptable) {
        return ref.set(context, scriptable, obj);
    }

    public static void setFunctionProtoAndParent(BaseFunction baseFunction, Scriptable scriptable, boolean z) {
        baseFunction.setParentScope(scriptable);
        baseFunction.setPrototype(z ? ScriptableObject.getGeneratorFunctionPrototype(scriptable) : ScriptableObject.getFunctionPrototype(scriptable));
    }

    @Deprecated
    public static Object setObjectElem(Object obj, Object obj2, Object obj3, Context context) {
        return setObjectElem(obj, obj2, obj3, context, getTopCallScope(context));
    }

    @Deprecated
    public static Object setObjectIndex(Object obj, double d, Object obj2, Context context) {
        return setObjectIndex(obj, d, obj2, context, getTopCallScope(context));
    }

    @Deprecated
    public static Object setObjectProp(Object obj, String str, Object obj2, Context context) {
        return setObjectProp(obj, str, obj2, context, getTopCallScope(context));
    }

    public static Ref specialRef(Object obj, String str, Context context, Scriptable scriptable) {
        return SpecialRef.createSpecial(context, scriptable, obj, str);
    }

    /* JADX WARN: Code duplicated, block: B:56:0x00a2  */
    private static double stringToNumber(String str, int i, int i2, int i3, boolean z) {
        char c;
        char c2;
        int i4;
        int i5;
        int i6 = i;
        char c3 = '9';
        char c4 = i3 < 10 ? (char) (i3 + 47) : '9';
        char c5 = 'A';
        if (i3 > 10) {
            c = (char) (i3 + 87);
            c2 = (char) (i3 + 55);
        } else {
            c = 'a';
            c2 = 'A';
        }
        int i7 = i6;
        double d = 0.0d;
        while (i7 <= i2) {
            char cCharAt = str.charAt(i7);
            if ('0' <= cCharAt && cCharAt <= c4) {
                i5 = cCharAt - '0';
            } else if ('a' <= cCharAt && cCharAt < c) {
                i5 = cCharAt - 'W';
            } else {
                if (c5 > cCharAt || cCharAt >= c2) {
                    if (z) {
                        break;
                    }
                    return Double.NaN;
                }
                i5 = cCharAt - '7';
            }
            d = (d * ((double) i3)) + ((double) i5);
            i7++;
            c = c;
            c5 = 'A';
        }
        if (i6 == i7) {
            return Double.NaN;
        }
        if (d > 9.007199254740991E15d) {
            if (i3 == 10) {
                try {
                    return Double.parseDouble(str.substring(i6, i7));
                } catch (NumberFormatException unused) {
                    return Double.NaN;
                }
            }
            if (i3 == 2 || i3 == 4 || i3 == 8 || i3 == 16 || i3 == 32) {
                int i8 = 53;
                int i9 = 1;
                double d2 = 0.0d;
                char c6 = 0;
                boolean z2 = false;
                boolean z3 = false;
                int i10 = 0;
                while (true) {
                    if (i9 == 1) {
                        if (i6 == i7) {
                            break;
                        }
                        int i11 = i6 + 1;
                        char cCharAt2 = str.charAt(i6);
                        if ('0' > cCharAt2 || cCharAt2 > c3) {
                            i4 = ('a' > cCharAt2 || cCharAt2 > 'z') ? cCharAt2 - '7' : cCharAt2 - 'W';
                        } else {
                            i4 = cCharAt2 - '0';
                        }
                        i10 = i4;
                        i6 = i11;
                        i9 = i3;
                    }
                    i9 >>= 1;
                    boolean z4 = (i10 & i9) != 0;
                    if (c6 != 0) {
                        if (c6 == 1) {
                            d *= 2.0d;
                            if (z4) {
                                d += 1.0d;
                            }
                            i8--;
                            if (i8 == 0) {
                                z3 = z4;
                                c6 = 2;
                            }
                        } else if (c6 != 2) {
                            if (c6 != 3) {
                                if (c6 != 4) {
                                }
                            } else if (z4) {
                                c6 = 4;
                            }
                            d2 *= 2.0d;
                        } else {
                            z2 = z4;
                            c6 = 3;
                            d2 = 2.0d;
                        }
                    } else if (z4) {
                        i8--;
                        c6 = 1;
                        d = 1.0d;
                    }
                    c3 = '9';
                }
                if (c6 == 0) {
                    return 0.0d;
                }
                if (c6 != 3) {
                    if (c6 != 4) {
                        return d;
                    }
                    if (z2) {
                        d += 1.0d;
                    }
                } else if (z2 & z3) {
                    d += 1.0d;
                }
                return d * d2;
            }
        }
        return d;
    }

    public static int toInt32(Object obj) {
        return obj instanceof Integer ? ((Integer) obj).intValue() : toInt32(toNumber(obj));
    }

    public static double toInteger(Object obj) {
        return toInteger(toNumber(obj));
    }

    public static double toNumber(String str) {
        char cCharAt;
        int i;
        char cCharAt2;
        int length = str.length();
        int i2 = 0;
        while (i2 != length) {
            char cCharAt3 = str.charAt(i2);
            if (!isStrWhiteSpaceChar(cCharAt3)) {
                int i3 = length - 1;
                while (true) {
                    cCharAt = str.charAt(i3);
                    if (!isStrWhiteSpaceChar(cCharAt)) {
                        break;
                    }
                    i3--;
                }
                Context currentContext = Context.getCurrentContext();
                boolean z = currentContext == null || currentContext.getLanguageVersion() < 200;
                int i4 = 16;
                if (cCharAt3 == '0') {
                    int i5 = i2 + 2;
                    if (i5 <= i3) {
                        char cCharAt4 = str.charAt(i2 + 1);
                        if (cCharAt4 != 'x' && cCharAt4 != 'X') {
                            i4 = (z || !(cCharAt4 == 'o' || cCharAt4 == 'O')) ? (z || !(cCharAt4 == 'b' || cCharAt4 == 'B')) ? -1 : 2 : 8;
                        }
                        if (i4 != -1) {
                            return z ? stringPrefixToNumber(str, i5, i4) : stringToNumber(str, i5, i3, i4);
                        }
                    }
                } else if (z && ((cCharAt3 == '+' || cCharAt3 == '-') && (i = i2 + 3) <= i3 && str.charAt(i2 + 1) == '0' && ((cCharAt2 = str.charAt(i2 + 2)) == 'x' || cCharAt2 == 'X'))) {
                    double dStringPrefixToNumber = stringPrefixToNumber(str, i, 16);
                    return cCharAt3 == '-' ? -dStringPrefixToNumber : dStringPrefixToNumber;
                }
                if (cCharAt == 'y') {
                    if (cCharAt3 == '+' || cCharAt3 == '-') {
                        i2++;
                    }
                    if (i2 + 7 == i3 && str.regionMatches(i2, "Infinity", 0, 8)) {
                        return cCharAt3 == '-' ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
                    }
                    return Double.NaN;
                }
                String strSubstring = str.substring(i2, i3 + 1);
                for (int length2 = strSubstring.length() - 1; length2 >= 0; length2--) {
                    char cCharAt5 = strSubstring.charAt(length2);
                    if (('0' > cCharAt5 || cCharAt5 > '9') && cCharAt5 != '.' && cCharAt5 != 'e' && cCharAt5 != 'E' && cCharAt5 != '+' && cCharAt5 != '-') {
                        return Double.NaN;
                    }
                }
                try {
                    return Double.parseDouble(strSubstring);
                } catch (NumberFormatException unused) {
                    return Double.NaN;
                }
            }
            i2++;
        }
        return 0.0d;
    }

    @Deprecated
    public static Scriptable toObject(Context context, Scriptable scriptable, Object obj, Class<?> cls) {
        return toObject(context, scriptable, obj);
    }

    public static Scriptable toObjectOrNull(Context context, Object obj, Scriptable scriptable) {
        if (obj instanceof Scriptable) {
            return (Scriptable) obj;
        }
        if (obj == null || obj == Undefined.instance) {
            return null;
        }
        return toObject(context, scriptable, obj);
    }

    public static Object toPrimitive(Object obj, Class<?> cls) {
        if (!(obj instanceof Scriptable)) {
            return obj;
        }
        Object defaultValue = ((Scriptable) obj).getDefaultValue(cls);
        if (!(defaultValue instanceof Scriptable) || isSymbol(defaultValue)) {
            return defaultValue;
        }
        throw typeError0("msg.bad.default.value");
    }

    public static String toString(Object obj) {
        while (obj != null) {
            if (obj == Undefined.instance || obj == Undefined.SCRIPTABLE_UNDEFINED) {
                return "undefined";
            }
            if (obj instanceof String) {
                return (String) obj;
            }
            if (obj instanceof CharSequence) {
                return obj.toString();
            }
            if (obj instanceof Number) {
                return numberToString(((Number) obj).doubleValue(), 10);
            }
            if (obj instanceof Symbol) {
                throw typeError0("msg.not.a.string");
            }
            if (!(obj instanceof Scriptable)) {
                return obj.toString();
            }
            obj = ((Scriptable) obj).getDefaultValue(StringClass);
            if ((obj instanceof Scriptable) && !isSymbol(obj)) {
                throw errorWithClassName("msg.primitive.expected", obj);
            }
        }
        return AbstractJsonLexerKt.NULL;
    }

    public static long toUint32(Object obj) {
        return toUint32(toNumber(obj));
    }

    public static BaseFunction typeErrorThrower(Context context) {
        if (context.typeErrorThrower == null) {
            BaseFunction baseFunction = new BaseFunction() { // from class: external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.1
                private static final long serialVersionUID = -5891740962154902286L;

                @Override // external.sdk.pendo.io.mozilla.javascript.BaseFunction, external.sdk.pendo.io.mozilla.javascript.Function, external.sdk.pendo.io.mozilla.javascript.Callable
                public Object call(Context context2, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
                    throw ScriptRuntime.typeError0("msg.op.not.allowed");
                }

                @Override // external.sdk.pendo.io.mozilla.javascript.BaseFunction
                public int getLength() {
                    return 0;
                }
            };
            setFunctionProtoAndParent(baseFunction, context.topCallScope);
            baseFunction.preventExtensions();
            context.typeErrorThrower = baseFunction;
        }
        return context.typeErrorThrower;
    }

    /* JADX WARN: Code duplicated, block: B:6:0x0008 A[PHI: r2 r3
      0x0008: PHI (r2v10 java.lang.Object) = (r2v3 java.lang.Object), (r2v0 java.lang.Object) binds: [B:36:0x0067, B:5:0x0006] A[DONT_GENERATE, DONT_INLINE]
      0x0008: PHI (r3v5 java.lang.Object) = (r3v1 java.lang.Object), (r3v0 java.lang.Object) binds: [B:36:0x0067, B:5:0x0006] A[DONT_GENERATE, DONT_INLINE]] */
    public static Object add(Object obj, Object obj2, Context context) {
        double number;
        double number2;
        Object objAddValues;
        Object objAddValues2;
        if ((obj instanceof Number) && (obj2 instanceof Number)) {
            number = ((Number) obj).doubleValue();
            number2 = ((Number) obj2).doubleValue();
        } else {
            if ((obj instanceof XMLObject) && (objAddValues2 = ((XMLObject) obj).addValues(context, true, obj2)) != Scriptable.NOT_FOUND) {
                return objAddValues2;
            }
            if ((obj2 instanceof XMLObject) && (objAddValues = ((XMLObject) obj2).addValues(context, false, obj)) != Scriptable.NOT_FOUND) {
                return objAddValues;
            }
            if ((obj instanceof Symbol) || (obj2 instanceof Symbol)) {
                throw typeError0("msg.not.a.number");
            }
            if (obj instanceof Scriptable) {
                obj = ((Scriptable) obj).getDefaultValue(null);
            }
            if (obj2 instanceof Scriptable) {
                obj2 = ((Scriptable) obj2).getDefaultValue(null);
            }
            if ((obj instanceof CharSequence) || (obj2 instanceof CharSequence)) {
                return new ConsString(toCharSequence(obj), toCharSequence(obj2));
            }
            if ((obj instanceof Number) && (obj2 instanceof Number)) {
                number = ((Number) obj).doubleValue();
                number2 = ((Number) obj2).doubleValue();
            } else {
                number = toNumber(obj);
                number2 = toNumber(obj2);
            }
        }
        return wrapNumber(number + number2);
    }

    public static EcmaError constructError(String str, String str2, String str3, int i, String str4, int i2) {
        return new EcmaError(str, str2, str3, i, str4, i2);
    }

    @Deprecated
    public static Object delete(Object obj, Object obj2, Context context, boolean z) {
        return delete(obj, obj2, context, getTopCallScope(context), z);
    }

    @Deprecated
    public static Object enumInit(Object obj, Context context, boolean z) {
        return enumInit(obj, context, z ? 1 : 0);
    }

    public static Object getObjectElem(Object obj, Object obj2, Context context, Scriptable scriptable) {
        Scriptable objectOrNull = toObjectOrNull(context, obj, scriptable);
        if (objectOrNull != null) {
            return getObjectElem(objectOrNull, obj2, context);
        }
        throw undefReadError(obj, obj2);
    }

    public static Object getObjectIndex(Object obj, double d, Context context, Scriptable scriptable) {
        Scriptable objectOrNull = toObjectOrNull(context, obj, scriptable);
        if (objectOrNull == null) {
            throw undefReadError(obj, toString(d));
        }
        int i = (int) d;
        return ((double) i) == d ? getObjectIndex(objectOrNull, i, context) : getObjectProp(objectOrNull, toString(d), context);
    }

    public static Object getObjectProp(Object obj, String str, Context context, Scriptable scriptable) {
        Scriptable objectOrNull = toObjectOrNull(context, obj, scriptable);
        if (objectOrNull != null) {
            return getObjectProp(objectOrNull, str, context);
        }
        throw undefReadError(obj, str);
    }

    public static RuntimeException notFunctionError(Object obj, Object obj2, String str) {
        int iIndexOf;
        String string = toString(obj);
        if ((obj instanceof NativeFunction) && (iIndexOf = string.indexOf(123, string.indexOf(41))) > -1) {
            string = string.substring(0, iIndexOf + 1) + "...}";
        }
        return obj2 == Scriptable.NOT_FOUND ? typeError2("msg.function.not.found.in", str, string) : typeError3("msg.isnt.function.in", str, string, typeof(obj2));
    }

    public static Object setObjectElem(Object obj, Object obj2, Object obj3, Context context, Scriptable scriptable) {
        Scriptable objectOrNull = toObjectOrNull(context, obj, scriptable);
        if (objectOrNull != null) {
            return setObjectElem(objectOrNull, obj2, obj3, context);
        }
        throw undefWriteError(obj, obj2, obj3);
    }

    public static Object setObjectIndex(Object obj, double d, Object obj2, Context context, Scriptable scriptable) {
        Scriptable objectOrNull = toObjectOrNull(context, obj, scriptable);
        if (objectOrNull == null) {
            throw undefWriteError(obj, String.valueOf(d), obj2);
        }
        int i = (int) d;
        return ((double) i) == d ? setObjectIndex(objectOrNull, i, obj2, context) : setObjectProp(objectOrNull, toString(d), obj2, context);
    }

    public static Object setObjectProp(Object obj, String str, Object obj2, Context context, Scriptable scriptable) {
        if (!(obj instanceof Scriptable) && context.isStrictMode() && context.getLanguageVersion() >= 180) {
            throw undefWriteError(obj, str, obj2);
        }
        Scriptable objectOrNull = toObjectOrNull(context, obj, scriptable);
        if (objectOrNull != null) {
            return setObjectProp(objectOrNull, str, obj2, context);
        }
        throw undefWriteError(obj, str, obj2);
    }

    public static int toInt32(Object[] objArr, int i) {
        if (i < objArr.length) {
            return toInt32(objArr[i]);
        }
        return 0;
    }

    public static double toInteger(Object[] objArr, int i) {
        if (i < objArr.length) {
            return toInteger(objArr[i]);
        }
        return 0.0d;
    }

    public static double toNumber(Object[] objArr, int i) {
        if (i < objArr.length) {
            return toNumber(objArr[i]);
        }
        return Double.NaN;
    }

    public static Scriptable toObject(Scriptable scriptable, Object obj) {
        return obj instanceof Scriptable ? (Scriptable) obj : toObject(Context.getContext(), scriptable, obj);
    }

    public static String toString(Object[] objArr, int i) {
        return i < objArr.length ? toString(objArr[i]) : "undefined";
    }

    @Deprecated
    public static Scriptable toObject(Scriptable scriptable, Object obj, Class<?> cls) {
        return obj instanceof Scriptable ? (Scriptable) obj : toObject(Context.getContext(), scriptable, obj);
    }
}
