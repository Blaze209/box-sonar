package external.sdk.pendo.io.mozilla.javascript.optimizer;

import external.sdk.pendo.io.mozilla.javascript.ArrowFunction;
import external.sdk.pendo.io.mozilla.javascript.Callable;
import external.sdk.pendo.io.mozilla.javascript.ConsString;
import external.sdk.pendo.io.mozilla.javascript.Context;
import external.sdk.pendo.io.mozilla.javascript.ContextAction;
import external.sdk.pendo.io.mozilla.javascript.ContextFactory;
import external.sdk.pendo.io.mozilla.javascript.ES6Generator;
import external.sdk.pendo.io.mozilla.javascript.Function;
import external.sdk.pendo.io.mozilla.javascript.JavaScriptException;
import external.sdk.pendo.io.mozilla.javascript.NativeFunction;
import external.sdk.pendo.io.mozilla.javascript.NativeGenerator;
import external.sdk.pendo.io.mozilla.javascript.NativeIterator;
import external.sdk.pendo.io.mozilla.javascript.Script;
import external.sdk.pendo.io.mozilla.javascript.ScriptRuntime;
import external.sdk.pendo.io.mozilla.javascript.Scriptable;
import external.sdk.pendo.io.mozilla.javascript.ScriptableObject;
import external.sdk.pendo.io.mozilla.javascript.Undefined;

/* JADX INFO: loaded from: classes4.dex */
public final class OptRuntime extends ScriptRuntime {
    public static final Double oneObj = Double.valueOf(1.0d);
    public static final Double minusOneObj = Double.valueOf(-1.0d);

    public static class GeneratorState {
        static final String CLASS_NAME = "external/sdk/pendo/io/mozilla/javascript/optimizer/OptRuntime$GeneratorState";
        static final String resumptionPoint_NAME = "resumptionPoint";
        static final String resumptionPoint_TYPE = "I";
        static final String thisObj_NAME = "thisObj";
        static final String thisObj_TYPE = "Lexternal/sdk/pendo/io/mozilla/javascript/Scriptable;";
        Object[] localsState;
        int maxLocals;
        int maxStack;
        public int resumptionPoint;
        Object returnValue;
        Object[] stackState;
        public Scriptable thisObj;

        GeneratorState(Scriptable scriptable, int i, int i2) {
            this.thisObj = scriptable;
            this.maxLocals = i;
            this.maxStack = i2;
        }
    }

    public static Object add(double d, Object obj) {
        if (obj instanceof Scriptable) {
            obj = ((Scriptable) obj).getDefaultValue(null);
        }
        return !(obj instanceof CharSequence) ? wrapDouble(ScriptRuntime.toNumber(obj) + d) : new ConsString(ScriptRuntime.toString(d), (CharSequence) obj);
    }

    public static Function bindThis(NativeFunction nativeFunction, Context context, Scriptable scriptable, Scriptable scriptable2) {
        return new ArrowFunction(context, scriptable, nativeFunction, scriptable2);
    }

    public static Object call0(Callable callable, Scriptable scriptable, Context context, Scriptable scriptable2) {
        return callable.call(context, scriptable2, scriptable, ScriptRuntime.emptyArgs);
    }

    public static Object call1(Callable callable, Scriptable scriptable, Object obj, Context context, Scriptable scriptable2) {
        return callable.call(context, scriptable2, scriptable, new Object[]{obj});
    }

    public static Object call2(Callable callable, Scriptable scriptable, Object obj, Object obj2, Context context, Scriptable scriptable2) {
        return callable.call(context, scriptable2, scriptable, new Object[]{obj, obj2});
    }

    public static Object callN(Callable callable, Scriptable scriptable, Object[] objArr, Context context, Scriptable scriptable2) {
        return callable.call(context, scriptable2, scriptable, objArr);
    }

    public static Object callName(Object[] objArr, String str, Context context, Scriptable scriptable) {
        return ScriptRuntime.getNameFunctionAndThis(str, context, scriptable).call(context, scriptable, ScriptRuntime.lastStoredScriptable(context), objArr);
    }

    public static Object callName0(String str, Context context, Scriptable scriptable) {
        return ScriptRuntime.getNameFunctionAndThis(str, context, scriptable).call(context, scriptable, ScriptRuntime.lastStoredScriptable(context), ScriptRuntime.emptyArgs);
    }

    public static Object callProp0(Object obj, String str, Context context, Scriptable scriptable) {
        return ScriptRuntime.getPropFunctionAndThis(obj, str, context, scriptable).call(context, scriptable, ScriptRuntime.lastStoredScriptable(context), ScriptRuntime.emptyArgs);
    }

    public static Object callSpecial(Context context, Callable callable, Scriptable scriptable, Object[] objArr, Scriptable scriptable2, Scriptable scriptable3, int i, String str, int i2) {
        return ScriptRuntime.callSpecial(context, callable, scriptable, objArr, scriptable2, scriptable3, i, str, i2);
    }

    public static Scriptable createNativeGenerator(NativeFunction nativeFunction, Scriptable scriptable, Scriptable scriptable2, int i, int i2) {
        GeneratorState generatorState = new GeneratorState(scriptable2, i, i2);
        return Context.getCurrentContext().getLanguageVersion() >= 200 ? new ES6Generator(scriptable, nativeFunction, generatorState) : new NativeGenerator(scriptable, nativeFunction, generatorState);
    }

    private static int[] decodeIntArray(String str, int i) {
        if (i == 0) {
            if (str == null) {
                return null;
            }
            throw new IllegalArgumentException();
        }
        if (str.length() != (i * 2) + 1 && str.charAt(0) != 1) {
            throw new IllegalArgumentException();
        }
        int[] iArr = new int[i];
        for (int i2 = 0; i2 != i; i2++) {
            int i3 = i2 * 2;
            iArr[i2] = str.charAt(i3 + 2) | (str.charAt(i3 + 1) << 16);
        }
        return iArr;
    }

    @Deprecated
    public static Object elemIncrDecr(Object obj, double d, Context context, int i) {
        return elemIncrDecr(obj, d, context, ScriptRuntime.getTopCallScope(context), i);
    }

    static String encodeIntArray(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        int length = iArr.length;
        char[] cArr = new char[(length * 2) + 1];
        cArr[0] = 1;
        for (int i = 0; i != length; i++) {
            int i2 = iArr[i];
            int i3 = i * 2;
            cArr[i3 + 1] = (char) (i2 >>> 16);
            cArr[i3 + 2] = (char) i2;
        }
        return new String(cArr);
    }

    public static Object[] getGeneratorLocalsState(Object obj) {
        GeneratorState generatorState = (GeneratorState) obj;
        if (generatorState.localsState == null) {
            generatorState.localsState = new Object[generatorState.maxLocals];
        }
        return generatorState.localsState;
    }

    public static Object getGeneratorReturnValue(Object obj) {
        Object obj2 = ((GeneratorState) obj).returnValue;
        return obj2 == null ? Undefined.instance : obj2;
    }

    public static Object[] getGeneratorStackState(Object obj) {
        GeneratorState generatorState = (GeneratorState) obj;
        if (generatorState.stackState == null) {
            generatorState.stackState = new Object[generatorState.maxStack];
        }
        return generatorState.stackState;
    }

    public static void initFunction(NativeFunction nativeFunction, int i, Scriptable scriptable, Context context) {
        ScriptRuntime.initFunction(context, scriptable, nativeFunction, i, false);
    }

    static /* synthetic */ Object lambda$main$0(String[] strArr, Script script, Context context) {
        ScriptableObject global = ScriptRuntime.getGlobal(context);
        Object[] objArr = new Object[strArr.length];
        System.arraycopy(strArr, 0, objArr, 0, strArr.length);
        global.defineProperty("arguments", context.newArray(global, objArr), 2);
        script.exec(context, global);
        return null;
    }

    public static void main(final Script script, final String[] strArr) {
        ContextFactory.getGlobal().call(new ContextAction() { // from class: external.sdk.pendo.io.mozilla.javascript.optimizer.OptRuntime$$ExternalSyntheticLambda0
            @Override // external.sdk.pendo.io.mozilla.javascript.ContextAction
            public final Object run(Context context) {
                return OptRuntime.lambda$main$0(strArr, script, context);
            }
        });
    }

    public static Scriptable newArrayLiteral(Object[] objArr, String str, int i, Context context, Scriptable scriptable) {
        return ScriptRuntime.newArrayLiteral(objArr, decodeIntArray(str, i), context, scriptable);
    }

    public static Object newObjectSpecial(Context context, Object obj, Object[] objArr, Scriptable scriptable, Scriptable scriptable2, int i) {
        return ScriptRuntime.newSpecial(context, obj, objArr, scriptable, i);
    }

    public static Object[] padStart(Object[] objArr, int i) {
        Object[] objArr2 = new Object[objArr.length + i];
        System.arraycopy(objArr, 0, objArr2, i, objArr.length);
        return objArr2;
    }

    public static void setGeneratorReturnValue(Object obj, Object obj2) {
        ((GeneratorState) obj).returnValue = obj2;
    }

    public static void throwStopIteration(Object obj, Object obj2) {
        Object generatorReturnValue = getGeneratorReturnValue(obj2);
        throw new JavaScriptException(generatorReturnValue == Undefined.instance ? NativeIterator.getStopIterationObject((Scriptable) obj) : new NativeIterator.StopIteration(generatorReturnValue), "", 0);
    }

    public static Double wrapDouble(double d) {
        if (d == 0.0d) {
            if (1.0d / d > 0.0d) {
                return ScriptRuntime.zeroObj;
            }
        } else {
            if (d == 1.0d) {
                return oneObj;
            }
            if (d == -1.0d) {
                return minusOneObj;
            }
            if (Double.isNaN(d)) {
                return ScriptRuntime.NaNobj;
            }
        }
        return Double.valueOf(d);
    }

    public static Object add(Object obj, double d) {
        if (obj instanceof Scriptable) {
            obj = ((Scriptable) obj).getDefaultValue(null);
        }
        return !(obj instanceof CharSequence) ? wrapDouble(ScriptRuntime.toNumber(obj) + d) : new ConsString((CharSequence) obj, ScriptRuntime.toString(d));
    }

    public static Object elemIncrDecr(Object obj, double d, Context context, Scriptable scriptable, int i) {
        return ScriptRuntime.elemIncrDecr(obj, Double.valueOf(d), context, scriptable, i);
    }
}
