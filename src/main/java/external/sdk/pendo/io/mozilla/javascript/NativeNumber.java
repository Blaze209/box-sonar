package external.sdk.pendo.io.mozilla.javascript;

/* JADX INFO: loaded from: classes4.dex */
final class NativeNumber extends IdScriptableObject {
    private static final int ConstructorId_isFinite = -1;
    private static final int ConstructorId_isInteger = -3;
    private static final int ConstructorId_isNaN = -2;
    private static final int ConstructorId_isSafeInteger = -4;
    private static final int ConstructorId_parseFloat = -5;
    private static final int ConstructorId_parseInt = -6;
    private static final int Id_constructor = 1;
    private static final int Id_toExponential = 7;
    private static final int Id_toFixed = 6;
    private static final int Id_toLocaleString = 3;
    private static final int Id_toPrecision = 8;
    private static final int Id_toSource = 4;
    private static final int Id_toString = 2;
    private static final int Id_valueOf = 5;
    private static final int MAX_PRECISION = 100;
    private static final int MAX_PROTOTYPE_ID = 8;
    public static final double MAX_SAFE_INTEGER = 9.007199254740991E15d;
    private static final double MIN_SAFE_INTEGER = -9.007199254740991E15d;
    private static final Object NUMBER_TAG = "Number";
    private static final long serialVersionUID = 3504516769741512101L;
    private double doubleValue;

    NativeNumber(double d) {
        this.doubleValue = d;
    }

    private static Object execConstructorCall(int i, Object[] objArr) {
        switch (i) {
            case -6:
                return NativeGlobal.js_parseInt(objArr);
            case -5:
                return NativeGlobal.js_parseFloat(objArr);
            case -4:
                if (objArr.length != 0) {
                    Object obj = Undefined.instance;
                    Object obj2 = objArr[0];
                    if (obj != obj2) {
                        return obj2 instanceof Number ? Boolean.valueOf(isSafeInteger((Number) obj2)) : Boolean.FALSE;
                    }
                }
                return Boolean.FALSE;
            case -3:
                if (objArr.length != 0) {
                    Object obj3 = Undefined.instance;
                    Object obj4 = objArr[0];
                    if (obj3 != obj4) {
                        return obj4 instanceof Number ? Boolean.valueOf(isInteger((Number) obj4)) : Boolean.FALSE;
                    }
                }
                return Boolean.FALSE;
            case -2:
                if (objArr.length != 0) {
                    Object obj5 = Undefined.instance;
                    Object obj6 = objArr[0];
                    if (obj5 != obj6) {
                        return obj6 instanceof Number ? isNaN((Number) obj6) : Boolean.FALSE;
                    }
                }
                return Boolean.FALSE;
            case -1:
                if (objArr.length != 0) {
                    Object obj7 = Undefined.instance;
                    Object obj8 = objArr[0];
                    if (obj7 != obj8) {
                        return obj8 instanceof Number ? isFinite(obj8) : Boolean.FALSE;
                    }
                }
                return Boolean.FALSE;
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
    }

    static void init(Scriptable scriptable, boolean z) {
        new NativeNumber(0.0d).exportAsJSClass(8, scriptable, z);
    }

    private static boolean isDoubleInteger(double d) {
        return (Double.isInfinite(d) || Double.isNaN(d) || Math.floor(d) != d) ? false : true;
    }

    private static boolean isDoubleSafeInteger(double d) {
        return isDoubleInteger(d) && d <= 9.007199254740991E15d && d >= MIN_SAFE_INTEGER;
    }

    static Object isFinite(Object obj) {
        Double dValueOf = Double.valueOf(ScriptRuntime.toNumber(obj));
        return ScriptRuntime.wrapBoolean((dValueOf.isInfinite() || dValueOf.isNaN()) ? false : true);
    }

    private static boolean isInteger(Number number) {
        return number instanceof Double ? isDoubleInteger((Double) number) : isDoubleInteger(number.doubleValue());
    }

    private static Boolean isNaN(Number number) {
        return Boolean.valueOf(number instanceof Double ? ((Double) number).isNaN() : Double.isNaN(number.doubleValue()));
    }

    private static boolean isSafeInteger(Number number) {
        return number instanceof Double ? isDoubleSafeInteger((Double) number) : isDoubleSafeInteger(number.doubleValue());
    }

    private static String num_to(double d, Object[] objArr, int i, int i2, int i3, int i4) {
        int int32 = 0;
        if (objArr.length != 0) {
            double integer = ScriptRuntime.toInteger(objArr[0]);
            if (integer < i3 || integer > 100.0d) {
                throw ScriptRuntime.rangeError(ScriptRuntime.getMessage1("msg.bad.precision", ScriptRuntime.toString(objArr[0])));
            }
            int32 = ScriptRuntime.toInt32(integer);
            i = i2;
        }
        StringBuilder sb = new StringBuilder();
        DToA.JS_dtostr(sb, i, int32 + i4, d);
        return sb.toString();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject, external.sdk.pendo.io.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Object obj;
        if (!idFunctionObject.hasTag(NUMBER_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int iMethodId = idFunctionObject.methodId();
        if (iMethodId == 1) {
            double number = objArr.length >= 1 ? ScriptRuntime.toNumber(objArr[0]) : 0.0d;
            return scriptable2 == null ? new NativeNumber(number) : ScriptRuntime.wrapNumber(number);
        }
        if (iMethodId < 1) {
            return execConstructorCall(iMethodId, objArr);
        }
        if (!(scriptable2 instanceof NativeNumber)) {
            throw IdScriptableObject.incompatibleCallError(idFunctionObject);
        }
        double d = ((NativeNumber) scriptable2).doubleValue;
        int int32 = 10;
        switch (iMethodId) {
            case 2:
            case 3:
                if (objArr.length != 0 && (obj = objArr[0]) != Undefined.instance) {
                    int32 = ScriptRuntime.toInt32(obj);
                }
                return ScriptRuntime.numberToString(d, int32);
            case 4:
                return "(new Number(" + ScriptRuntime.toString(d) + "))";
            case 5:
                return ScriptRuntime.wrapNumber(d);
            case 6:
                return num_to(d, objArr, 2, 2, context.version < 200 ? -20 : 0, 0);
            case 7:
                if (Double.isNaN(d)) {
                    return "NaN";
                }
                if (Double.isInfinite(d)) {
                    return d >= 0.0d ? "Infinity" : "-Infinity";
                }
                return num_to(d, objArr, 1, 3, 0, 1);
            case 8:
                if (objArr.length == 0 || objArr[0] == Undefined.instance) {
                    return ScriptRuntime.numberToString(d, 10);
                }
                if (Double.isNaN(d)) {
                    return "NaN";
                }
                if (Double.isInfinite(d)) {
                    return d >= 0.0d ? "Infinity" : "-Infinity";
                }
                return num_to(d, objArr, 0, 4, 1, 0);
            default:
                throw new IllegalArgumentException(String.valueOf(iMethodId));
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected void fillConstructorProperties(IdFunctionObject idFunctionObject) {
        idFunctionObject.defineProperty("NaN", ScriptRuntime.NaNobj, 7);
        idFunctionObject.defineProperty("POSITIVE_INFINITY", ScriptRuntime.wrapNumber(Double.POSITIVE_INFINITY), 7);
        idFunctionObject.defineProperty("NEGATIVE_INFINITY", ScriptRuntime.wrapNumber(Double.NEGATIVE_INFINITY), 7);
        idFunctionObject.defineProperty("MAX_VALUE", ScriptRuntime.wrapNumber(Double.MAX_VALUE), 7);
        idFunctionObject.defineProperty("MIN_VALUE", ScriptRuntime.wrapNumber(Double.MIN_VALUE), 7);
        idFunctionObject.defineProperty("MAX_SAFE_INTEGER", ScriptRuntime.wrapNumber(9.007199254740991E15d), 7);
        idFunctionObject.defineProperty("MIN_SAFE_INTEGER", ScriptRuntime.wrapNumber(MIN_SAFE_INTEGER), 7);
        Object obj = NUMBER_TAG;
        addIdFunctionProperty(idFunctionObject, obj, -1, "isFinite", 1);
        addIdFunctionProperty(idFunctionObject, obj, -2, "isNaN", 1);
        addIdFunctionProperty(idFunctionObject, obj, -3, "isInteger", 1);
        addIdFunctionProperty(idFunctionObject, obj, -4, "isSafeInteger", 1);
        addIdFunctionProperty(idFunctionObject, obj, -5, "parseFloat", 1);
        addIdFunctionProperty(idFunctionObject, obj, -6, "parseInt", 1);
        super.fillConstructorProperties(idFunctionObject);
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0060  */
    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected int findPrototypeId(String str) {
        String str2;
        int length = str.length();
        int i = 7;
        if (length == 7) {
            char cCharAt = str.charAt(0);
            if (cCharAt == 't') {
                str2 = "toFixed";
                i = 6;
            } else if (cCharAt == 'v') {
                str2 = "valueOf";
                i = 5;
            } else {
                str2 = null;
                i = 0;
            }
        } else if (length == 8) {
            char cCharAt2 = str.charAt(3);
            if (cCharAt2 == 'o') {
                str2 = "toSource";
                i = 4;
            } else if (cCharAt2 == 't') {
                str2 = "toString";
                i = 2;
            } else {
                str2 = null;
                i = 0;
            }
        } else if (length == 11) {
            char cCharAt3 = str.charAt(0);
            if (cCharAt3 == 'c') {
                str2 = "constructor";
                i = 1;
            } else if (cCharAt3 == 't') {
                str2 = "toPrecision";
                i = 8;
            } else {
                str2 = null;
                i = 0;
            }
        } else if (length == 13) {
            str2 = "toExponential";
        } else if (length != 14) {
            str2 = null;
            i = 0;
        } else {
            str2 = "toLocaleString";
            i = 3;
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i;
        }
        return 0;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Number";
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected void initPrototypeId(int i) {
        String str;
        String str2;
        int i2 = 1;
        switch (i) {
            case 1:
                str = "constructor";
                initPrototypeMethod(NUMBER_TAG, i, str, i2);
                return;
            case 2:
                str = "toString";
                initPrototypeMethod(NUMBER_TAG, i, str, i2);
                return;
            case 3:
                str = "toLocaleString";
                initPrototypeMethod(NUMBER_TAG, i, str, i2);
                return;
            case 4:
                str2 = "toSource";
                String str3 = str2;
                i2 = 0;
                str = str3;
                initPrototypeMethod(NUMBER_TAG, i, str, i2);
                return;
            case 5:
                str2 = "valueOf";
                String str4 = str2;
                i2 = 0;
                str = str4;
                initPrototypeMethod(NUMBER_TAG, i, str, i2);
                return;
            case 6:
                str = "toFixed";
                initPrototypeMethod(NUMBER_TAG, i, str, i2);
                return;
            case 7:
                str = "toExponential";
                initPrototypeMethod(NUMBER_TAG, i, str, i2);
                return;
            case 8:
                str = "toPrecision";
                initPrototypeMethod(NUMBER_TAG, i, str, i2);
                return;
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
    }

    public String toString() {
        return ScriptRuntime.numberToString(this.doubleValue, 10);
    }

    private static boolean isDoubleInteger(Double d) {
        return (d.isInfinite() || d.isNaN() || Math.floor(d.doubleValue()) != d.doubleValue()) ? false : true;
    }

    private static boolean isDoubleSafeInteger(Double d) {
        return isDoubleInteger(d) && d.doubleValue() <= 9.007199254740991E15d && d.doubleValue() >= MIN_SAFE_INTEGER;
    }
}
