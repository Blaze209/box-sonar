package external.sdk.pendo.io.mozilla.javascript;

import androidx.collection.SieveCacheKt;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import com.box.androidsdk.content.requests.BoxRequestsFile;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectorySlice;
import com.pspdfkit.analytics.Analytics;
import external.sdk.pendo.io.mozilla.javascript.regexp.NativeRegExp;
import java.text.Collator;
import java.text.Normalizer;
import java.util.Locale;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes4.dex */
final class NativeString extends IdScriptableObject {
    private static final int ConstructorId_charAt = -5;
    private static final int ConstructorId_charCodeAt = -6;
    private static final int ConstructorId_concat = -14;
    private static final int ConstructorId_equalsIgnoreCase = -30;
    private static final int ConstructorId_fromCharCode = -1;
    private static final int ConstructorId_fromCodePoint = -2;
    private static final int ConstructorId_indexOf = -7;
    private static final int ConstructorId_lastIndexOf = -8;
    private static final int ConstructorId_localeCompare = -34;
    private static final int ConstructorId_match = -31;
    private static final int ConstructorId_replace = -33;
    private static final int ConstructorId_search = -32;
    private static final int ConstructorId_slice = -15;
    private static final int ConstructorId_split = -9;
    private static final int ConstructorId_substr = -13;
    private static final int ConstructorId_substring = -10;
    private static final int ConstructorId_toLocaleLowerCase = -35;
    private static final int ConstructorId_toLowerCase = -11;
    private static final int ConstructorId_toUpperCase = -12;
    private static final int Id_anchor = 28;
    private static final int Id_big = 21;
    private static final int Id_blink = 22;
    private static final int Id_bold = 16;
    private static final int Id_charAt = 5;
    private static final int Id_charCodeAt = 6;
    private static final int Id_codePointAt = 45;
    private static final int Id_concat = 14;
    private static final int Id_constructor = 1;
    private static final int Id_endsWith = 42;
    private static final int Id_equals = 29;
    private static final int Id_equalsIgnoreCase = 30;
    private static final int Id_fixed = 18;
    private static final int Id_fontcolor = 26;
    private static final int Id_fontsize = 25;
    private static final int Id_includes = 40;
    private static final int Id_indexOf = 7;
    private static final int Id_italics = 17;
    private static final int Id_lastIndexOf = 8;
    private static final int Id_length = 1;
    private static final int Id_link = 27;
    private static final int Id_localeCompare = 34;
    private static final int Id_match = 31;
    private static final int Id_normalize = 43;
    private static final int Id_padEnd = 47;
    private static final int Id_padStart = 46;
    private static final int Id_repeat = 44;
    private static final int Id_replace = 33;
    private static final int Id_search = 32;
    private static final int Id_slice = 15;
    private static final int Id_small = 20;
    private static final int Id_split = 9;
    private static final int Id_startsWith = 41;
    private static final int Id_strike = 19;
    private static final int Id_sub = 24;
    private static final int Id_substr = 13;
    private static final int Id_substring = 10;
    private static final int Id_sup = 23;
    private static final int Id_toLocaleLowerCase = 35;
    private static final int Id_toLocaleUpperCase = 36;
    private static final int Id_toLowerCase = 11;
    private static final int Id_toSource = 3;
    private static final int Id_toString = 2;
    private static final int Id_toUpperCase = 12;
    private static final int Id_trim = 37;
    private static final int Id_trimEnd = 50;
    private static final int Id_trimLeft = 38;
    private static final int Id_trimRight = 39;
    private static final int Id_trimStart = 49;
    private static final int Id_valueOf = 4;
    private static final int MAX_INSTANCE_ID = 1;
    private static final int MAX_PROTOTYPE_ID = 50;
    private static final Object STRING_TAG = "String";
    private static final int SymbolId_iterator = 48;
    private static final long serialVersionUID = 920268368584188687L;
    private CharSequence string;

    NativeString(CharSequence charSequence) {
        this.string = charSequence;
    }

    private ScriptableObject defaultIndexPropertyDescriptor(Object obj) {
        Scriptable parentScope = getParentScope();
        if (parentScope != null) {
            this = parentScope;
        }
        NativeObject nativeObject = new NativeObject();
        ScriptRuntime.setBuiltinProtoAndParent(nativeObject, this, TopLevel.Builtins.Object);
        nativeObject.defineProperty("value", obj, 0);
        Boolean bool = Boolean.FALSE;
        nativeObject.defineProperty("writable", bool, 0);
        nativeObject.defineProperty("enumerable", Boolean.TRUE, 0);
        nativeObject.defineProperty("configurable", bool, 0);
        return nativeObject;
    }

    static void init(Scriptable scriptable, boolean z) {
        new NativeString("").exportAsJSClass(50, scriptable, z);
    }

    private static String js_concat(String str, Object[] objArr) {
        int length = objArr.length;
        if (length == 0) {
            return str;
        }
        if (length == 1) {
            return str.concat(ScriptRuntime.toString(objArr[0]));
        }
        int length2 = str.length();
        String[] strArr = new String[length];
        for (int i = 0; i != length; i++) {
            String string = ScriptRuntime.toString(objArr[i]);
            strArr[i] = string;
            length2 += string.length();
        }
        StringBuilder sb = new StringBuilder(length2);
        sb.append(str);
        for (int i2 = 0; i2 != length; i2++) {
            sb.append(strArr[i2]);
        }
        return sb.toString();
    }

    private static int js_indexOf(int i, String str, Object[] objArr) {
        String string = ScriptRuntime.toString(objArr, 0);
        double integer = ScriptRuntime.toInteger(objArr, 1);
        if (i != 41 && i != 42 && string.length() == 0) {
            return integer > ((double) str.length()) ? str.length() : (int) integer;
        }
        if (i != 41 && i != 42 && integer > str.length()) {
            return -1;
        }
        if (integer < 0.0d) {
            integer = 0.0d;
        } else if (integer > str.length() || (i == 42 && (Double.isNaN(integer) || integer > str.length()))) {
            integer = str.length();
        }
        if (42 != i) {
            if (i == 41) {
                return str.startsWith(string, (int) integer) ? 0 : -1;
            }
            return str.indexOf(string, (int) integer);
        }
        if (objArr.length == 0 || objArr.length == 1 || (objArr.length == 2 && objArr[1] == Undefined.instance)) {
            integer = str.length();
        }
        return str.substring(0, (int) integer).endsWith(string) ? 0 : -1;
    }

    private static int js_lastIndexOf(String str, Object[] objArr) {
        String string = ScriptRuntime.toString(objArr, 0);
        double number = ScriptRuntime.toNumber(objArr, 1);
        if (Double.isNaN(number) || number > str.length()) {
            number = str.length();
        } else if (number < 0.0d) {
            number = 0.0d;
        }
        return str.lastIndexOf(string, (int) number);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r7v4 java.lang.String, still in use, count: 2, list:
          (r7v4 java.lang.String) from 0x002a: INVOKE (r7v4 java.lang.String) VIRTUAL call: java.lang.String.length():int A[MD:():int (c), WRAPPED]
          (r7v4 java.lang.String) from 0x0033: PHI (r7 I:??) = (r7v4 java.lang.String) binds: [B:10:0x002e] A[DONT_GENERATE, DONT_INLINE]
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:133)
        	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:67)
        	at jadx.core.dex.visitors.regions.TernaryMod.enterRegion(TernaryMod.java:50)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:96)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.TernaryMod.process(TernaryMod.java:36)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.process(IfRegionVisitor.java:44)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:30)
        */
    private static java.lang.String js_pad(external.sdk.pendo.io.mozilla.javascript.Context r4, external.sdk.pendo.io.mozilla.javascript.Scriptable r5, external.sdk.pendo.io.mozilla.javascript.IdFunctionObject r6, java.lang.Object[] r7, boolean r8) {
        /*
            java.lang.Object r4 = external.sdk.pendo.io.mozilla.javascript.ScriptRuntimeES6.requireObjectCoercible(r4, r5, r6)
            java.lang.String r4 = external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.toString(r4)
            r5 = 0
            long r0 = external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.toLength(r7, r5)
            int r6 = r4.length()
            long r2 = (long) r6
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 > 0) goto L17
            goto L30
        L17:
            int r6 = r7.length
            r2 = 2
            if (r6 < r2) goto L31
            r6 = 1
            r2 = r7[r6]
            boolean r2 = external.sdk.pendo.io.mozilla.javascript.Undefined.isUndefined(r2)
            if (r2 != 0) goto L31
            r7 = r7[r6]
            java.lang.String r7 = external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.toString(r7)
            int r2 = r7.length()
            if (r2 >= r6) goto L33
        L30:
            return r4
        L31:
            java.lang.String r7 = " "
        L33:
            int r6 = r4.length()
            long r2 = (long) r6
            long r0 = r0 - r2
            int r6 = (int) r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
        L3f:
            r0.append(r7)
            int r1 = r0.length()
            if (r1 < r6) goto L3f
            r0.setLength(r6)
            if (r8 == 0) goto L56
            java.lang.StringBuilder r4 = r0.append(r4)
        L51:
            java.lang.String r4 = r4.toString()
            return r4
        L56:
            java.lang.StringBuilder r4 = r0.insert(r5, r4)
            goto L51
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.NativeString.js_pad(external.sdk.pendo.io.mozilla.javascript.Context, external.sdk.pendo.io.mozilla.javascript.Scriptable, external.sdk.pendo.io.mozilla.javascript.IdFunctionObject, java.lang.Object[], boolean):java.lang.String");
    }

    private static String js_repeat(Context context, Scriptable scriptable, IdFunctionObject idFunctionObject, Object[] objArr) {
        String string = ScriptRuntime.toString(ScriptRuntimeES6.requireObjectCoercible(context, scriptable, idFunctionObject));
        double integer = ScriptRuntime.toInteger(objArr, 0);
        if (integer < 0.0d || integer == Double.POSITIVE_INFINITY) {
            throw ScriptRuntime.rangeError("Invalid count value");
        }
        if (integer == 0.0d || string.length() == 0) {
            return "";
        }
        long length = ((long) string.length()) * ((long) integer);
        if (integer > 2.147483647E9d || length > SieveCacheKt.NodeLinkMask) {
            throw ScriptRuntime.rangeError("Invalid size or count value");
        }
        StringBuilder sb = new StringBuilder((int) length);
        sb.append(string);
        int i = (int) integer;
        int i2 = 1;
        while (i2 <= i / 2) {
            sb.append((CharSequence) sb);
            i2 *= 2;
        }
        if (i2 < i) {
            sb.append(sb.substring(0, string.length() * (i - i2)));
        }
        return sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0045 A[PHI: r6
      0x0045: PHI (r6v4 double) = (r6v3 double), (r6v5 double) binds: [B:25:0x0042, B:22:0x003c] A[DONT_GENERATE, DONT_INLINE]] */
    private static CharSequence js_slice(CharSequence charSequence, Object[] objArr) {
        Object obj;
        double d = 0.0d;
        double integer = objArr.length < 1 ? 0.0d : ScriptRuntime.toInteger(objArr[0]);
        int length = charSequence.length();
        if (integer < 0.0d) {
            integer += (double) length;
            if (integer < 0.0d) {
                integer = 0.0d;
            }
        } else {
            double d2 = length;
            if (integer > d2) {
                integer = d2;
            }
        }
        if (objArr.length < 2 || (obj = objArr[1]) == Undefined.instance) {
            d = length;
        } else {
            double integer2 = ScriptRuntime.toInteger(obj);
            if (integer2 < 0.0d) {
                integer2 += (double) length;
                if (integer2 >= 0.0d) {
                    d = integer2;
                }
            } else {
                d = length;
                if (integer2 <= d) {
                    d = integer2;
                }
            }
            if (d < integer) {
                d = integer;
            }
        }
        return charSequence.subSequence((int) integer, (int) d);
    }

    private static CharSequence js_substr(CharSequence charSequence, Object[] objArr) {
        if (objArr.length < 1) {
            return charSequence;
        }
        double integer = ScriptRuntime.toInteger(objArr[0]);
        int length = charSequence.length();
        if (integer < 0.0d) {
            integer += (double) length;
            if (integer < 0.0d) {
                integer = 0.0d;
            }
        } else {
            double d = length;
            if (integer > d) {
                integer = d;
            }
        }
        double d2 = length;
        if (objArr.length > 1) {
            Object obj = objArr[1];
            if (!Undefined.isUndefined(obj)) {
                double integer2 = ScriptRuntime.toInteger(obj);
                double d3 = (integer2 >= 0.0d ? integer2 : 0.0d) + integer;
                if (d3 <= d2) {
                    d2 = d3;
                }
            }
        }
        return charSequence.subSequence((int) integer, (int) d2);
    }

    private static CharSequence js_substring(Context context, CharSequence charSequence, Object[] objArr) {
        Object obj;
        int length = charSequence.length();
        double integer = ScriptRuntime.toInteger(objArr, 0);
        double d = 0.0d;
        if (integer < 0.0d) {
            integer = 0.0d;
        } else {
            double d2 = length;
            if (integer > d2) {
                integer = d2;
            }
        }
        if (objArr.length > 1 && (obj = objArr[1]) != Undefined.instance) {
            double integer2 = ScriptRuntime.toInteger(obj);
            if (integer2 >= 0.0d) {
                d = length;
                if (integer2 <= d) {
                    d = integer2;
                }
            }
            if (d < integer) {
                if (context.getLanguageVersion() == 120) {
                    d = integer;
                }
            }
            return charSequence.subSequence((int) d, (int) integer);
        }
        d = length;
        double d3 = d;
        d = integer;
        integer = d3;
        return charSequence.subSequence((int) d, (int) integer);
    }

    private static NativeString realThis(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (scriptable instanceof NativeString) {
            return (NativeString) scriptable;
        }
        throw IdScriptableObject.incompatibleCallError(idFunctionObject);
    }

    private static String tagify(Scriptable scriptable, String str, String str2, Object[] objArr) {
        String string = ScriptRuntime.toString(scriptable);
        StringBuilder sb = new StringBuilder(SimpleComparison.LESS_THAN_OPERATION);
        sb.append(str);
        if (str2 != null) {
            sb.append(' ').append(str2).append("=\"").append(ScriptRuntime.toString(objArr, 0)).append('\"');
        }
        sb.append(Typography.greater).append(string).append("</").append(str).append(Typography.greater);
        return sb.toString();
    }

    /* JADX WARN: Switch 'out' block B:7:0x0011 for B:12:0x001e already processed. Defaulting to fallback option. */
    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject, external.sdk.pendo.io.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Normalizer.Form form;
        if (!idFunctionObject.hasTag(STRING_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int iMethodId = idFunctionObject.methodId();
        while (true) {
            int i = 0;
            if (iMethodId == -2) {
                Object[] objArr2 = objArr;
                int length = objArr2.length;
                if (length < 1) {
                    return "";
                }
                int[] iArr = new int[length];
                for (int i2 = 0; i2 != length; i2++) {
                    Object obj = objArr2[i2];
                    int int32 = ScriptRuntime.toInt32(obj);
                    if (!ScriptRuntime.eqNumber(ScriptRuntime.toNumber(obj), Integer.valueOf(int32)) || !Character.isValidCodePoint(int32)) {
                        throw ScriptRuntime.rangeError("Invalid code point " + ScriptRuntime.toString(obj));
                    }
                    iArr[i2] = int32;
                }
                return new String(iArr, 0, length);
            }
            if (iMethodId == -1) {
                Object[] objArr3 = objArr;
                int length2 = objArr3.length;
                if (length2 < 1) {
                    return "";
                }
                char[] cArr = new char[length2];
                while (i != length2) {
                    cArr[i] = ScriptRuntime.toUint16(objArr3[i]);
                    i++;
                }
                return new String(cArr);
            }
            switch (iMethodId) {
                case ConstructorId_toLocaleLowerCase /* -35 */:
                case ConstructorId_localeCompare /* -34 */:
                case ConstructorId_replace /* -33 */:
                case ConstructorId_search /* -32 */:
                case ConstructorId_match /* -31 */:
                case ConstructorId_equalsIgnoreCase /* -30 */:
                    break;
                default:
                    switch (iMethodId) {
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
                            break;
                        default:
                            switch (iMethodId) {
                                case 1:
                                    Scriptable scriptable3 = scriptable2;
                                    Object[] objArr4 = objArr;
                                    CharSequence charSequence = objArr4.length != 0 ? (!ScriptRuntime.isSymbol(objArr4[0]) || scriptable3 == null) ? ScriptRuntime.toCharSequence(objArr4[0]) : objArr4[0].toString() : "";
                                    if (scriptable3 == null) {
                                        return new NativeString(charSequence);
                                    }
                                    return charSequence instanceof String ? charSequence : charSequence.toString();
                                case 2:
                                case 4:
                                    CharSequence charSequence2 = realThis(scriptable2, idFunctionObject).string;
                                    return charSequence2 instanceof String ? charSequence2 : charSequence2.toString();
                                case 3:
                                    return "(new String(\"" + ScriptRuntime.escapeString(realThis(scriptable2, idFunctionObject).string.toString()) + "\"))";
                                case 5:
                                case 6:
                                    CharSequence charSequence3 = ScriptRuntime.toCharSequence(ScriptRuntimeES6.requireObjectCoercible(context, scriptable2, idFunctionObject));
                                    double integer = ScriptRuntime.toInteger(objArr, 0);
                                    if (integer < 0.0d || integer >= charSequence3.length()) {
                                        return iMethodId == 5 ? "" : ScriptRuntime.NaNobj;
                                    }
                                    char cCharAt = charSequence3.charAt((int) integer);
                                    return iMethodId == 5 ? String.valueOf(cCharAt) : ScriptRuntime.wrapInt(cCharAt);
                                case 7:
                                    return ScriptRuntime.wrapInt(js_indexOf(7, ScriptRuntime.toString(ScriptRuntimeES6.requireObjectCoercible(context, scriptable2, idFunctionObject)), objArr));
                                case 8:
                                    return ScriptRuntime.wrapInt(js_lastIndexOf(ScriptRuntime.toString(ScriptRuntimeES6.requireObjectCoercible(context, scriptable2, idFunctionObject)), objArr));
                                case 9:
                                    return ScriptRuntime.checkRegExpProxy(context).js_split(context, scriptable, ScriptRuntime.toString(ScriptRuntimeES6.requireObjectCoercible(context, scriptable2, idFunctionObject)), objArr);
                                case 10:
                                    return js_substring(context, ScriptRuntime.toCharSequence(ScriptRuntimeES6.requireObjectCoercible(context, scriptable2, idFunctionObject)), objArr);
                                case 11:
                                    return ScriptRuntime.toString(ScriptRuntimeES6.requireObjectCoercible(context, scriptable2, idFunctionObject)).toLowerCase(Locale.ROOT);
                                case 12:
                                    return ScriptRuntime.toString(ScriptRuntimeES6.requireObjectCoercible(context, scriptable2, idFunctionObject)).toUpperCase(Locale.ROOT);
                                case 13:
                                    return js_substr(ScriptRuntime.toCharSequence(ScriptRuntimeES6.requireObjectCoercible(context, scriptable2, idFunctionObject)), objArr);
                                case 14:
                                    return js_concat(ScriptRuntime.toString(ScriptRuntimeES6.requireObjectCoercible(context, scriptable2, idFunctionObject)), objArr);
                                case 15:
                                    return js_slice(ScriptRuntime.toCharSequence(ScriptRuntimeES6.requireObjectCoercible(context, scriptable2, idFunctionObject)), objArr);
                                case 16:
                                    return tagify(scriptable2, "b", null, null);
                                case 17:
                                    return tagify(scriptable2, "i", null, null);
                                case 18:
                                    return tagify(scriptable2, TtmlNode.TAG_TT, null, null);
                                case 19:
                                    return tagify(scriptable2, "strike", null, null);
                                case 20:
                                    return tagify(scriptable2, BoxRequestsFile.DownloadAvatar.SMALL, null, null);
                                case 21:
                                    return tagify(scriptable2, "big", null, null);
                                case 22:
                                    return tagify(scriptable2, "blink", null, null);
                                case 23:
                                    return tagify(scriptable2, "sup", null, null);
                                case 24:
                                    return tagify(scriptable2, "sub", null, null);
                                case 25:
                                    return tagify(scriptable2, "font", "size", objArr);
                                case 26:
                                    return tagify(scriptable2, "font", "color", objArr);
                                case 27:
                                    return tagify(scriptable2, CmcdData.OBJECT_TYPE_AUDIO_ONLY, "href", objArr);
                                case 28:
                                    return tagify(scriptable2, CmcdData.OBJECT_TYPE_AUDIO_ONLY, "name", objArr);
                                case 29:
                                case 30:
                                    String string = ScriptRuntime.toString(scriptable2);
                                    String string2 = ScriptRuntime.toString(objArr, 0);
                                    return ScriptRuntime.wrapBoolean(iMethodId == 29 ? string.equals(string2) : string.equalsIgnoreCase(string2));
                                case 31:
                                case 32:
                                case 33:
                                    int i3 = iMethodId != 31 ? iMethodId == 32 ? 3 : 2 : 1;
                                    ScriptRuntimeES6.requireObjectCoercible(context, scriptable2, idFunctionObject);
                                    return ScriptRuntime.checkRegExpProxy(context).action(context, scriptable, scriptable2, objArr, i3);
                                case 34:
                                    String string3 = ScriptRuntime.toString(ScriptRuntimeES6.requireObjectCoercible(context, scriptable2, idFunctionObject));
                                    Collator collator = Collator.getInstance(context.getLocale());
                                    collator.setStrength(3);
                                    collator.setDecomposition(1);
                                    return ScriptRuntime.wrapNumber(collator.compare(string3, ScriptRuntime.toString(objArr, 0)));
                                case 35:
                                    return ScriptRuntime.toString(ScriptRuntimeES6.requireObjectCoercible(context, scriptable2, idFunctionObject)).toLowerCase(context.getLocale());
                                case 36:
                                    return ScriptRuntime.toString(ScriptRuntimeES6.requireObjectCoercible(context, scriptable2, idFunctionObject)).toUpperCase(context.getLocale());
                                case 37:
                                    String string4 = ScriptRuntime.toString(ScriptRuntimeES6.requireObjectCoercible(context, scriptable2, idFunctionObject));
                                    char[] charArray = string4.toCharArray();
                                    while (i < charArray.length && ScriptRuntime.isJSWhitespaceOrLineTerminator(charArray[i])) {
                                        i++;
                                    }
                                    int length3 = charArray.length;
                                    while (length3 > i && ScriptRuntime.isJSWhitespaceOrLineTerminator(charArray[length3 - 1])) {
                                        length3--;
                                    }
                                    return string4.substring(i, length3);
                                case 38:
                                case 49:
                                    String string5 = ScriptRuntime.toString(ScriptRuntimeES6.requireObjectCoercible(context, scriptable2, idFunctionObject));
                                    char[] charArray2 = string5.toCharArray();
                                    while (i < charArray2.length && ScriptRuntime.isJSWhitespaceOrLineTerminator(charArray2[i])) {
                                        i++;
                                    }
                                    return string5.substring(i, charArray2.length);
                                case 39:
                                case 50:
                                    String string6 = ScriptRuntime.toString(ScriptRuntimeES6.requireObjectCoercible(context, scriptable2, idFunctionObject));
                                    char[] charArray3 = string6.toCharArray();
                                    int length4 = charArray3.length;
                                    while (length4 > 0 && ScriptRuntime.isJSWhitespaceOrLineTerminator(charArray3[length4 - 1])) {
                                        length4--;
                                    }
                                    return string6.substring(0, length4);
                                case 40:
                                case 41:
                                case 42:
                                    String string7 = ScriptRuntime.toString(ScriptRuntimeES6.requireObjectCoercible(context, scriptable2, idFunctionObject));
                                    if (objArr.length > 0 && (objArr[0] instanceof NativeRegExp)) {
                                        throw ScriptRuntime.typeError2("msg.first.arg.not.regexp", String.class.getSimpleName(), idFunctionObject.getFunctionName());
                                    }
                                    int iJs_indexOf = js_indexOf(iMethodId, string7, objArr);
                                    if (iMethodId == 40) {
                                        return Boolean.valueOf(iJs_indexOf != -1);
                                    }
                                    if (iMethodId == 41) {
                                        return Boolean.valueOf(iJs_indexOf == 0);
                                    }
                                    if (iMethodId == 42) {
                                        return Boolean.valueOf(iJs_indexOf != -1);
                                    }
                                    break;
                                case 43:
                                    if (objArr.length == 0 || Undefined.isUndefined(objArr[0])) {
                                        return Normalizer.normalize(ScriptRuntime.toString(ScriptRuntimeES6.requireObjectCoercible(context, scriptable2, idFunctionObject)), Normalizer.Form.NFC);
                                    }
                                    String string8 = ScriptRuntime.toString(objArr, 0);
                                    if (Normalizer.Form.NFD.name().equals(string8)) {
                                        form = Normalizer.Form.NFD;
                                    } else if (Normalizer.Form.NFKC.name().equals(string8)) {
                                        form = Normalizer.Form.NFKC;
                                    } else if (Normalizer.Form.NFKD.name().equals(string8)) {
                                        form = Normalizer.Form.NFKD;
                                    } else {
                                        if (!Normalizer.Form.NFC.name().equals(string8)) {
                                            throw ScriptRuntime.rangeError("The normalization form should be one of 'NFC', 'NFD', 'NFKC', 'NFKD'.");
                                        }
                                        form = Normalizer.Form.NFC;
                                    }
                                    return Normalizer.normalize(ScriptRuntime.toString(ScriptRuntimeES6.requireObjectCoercible(context, scriptable2, idFunctionObject)), form);
                                case 44:
                                    return js_repeat(context, scriptable2, idFunctionObject, objArr);
                                case 45:
                                    String string9 = ScriptRuntime.toString(ScriptRuntimeES6.requireObjectCoercible(context, scriptable2, idFunctionObject));
                                    double integer2 = ScriptRuntime.toInteger(objArr, 0);
                                    return (integer2 < 0.0d || integer2 >= ((double) string9.length())) ? Undefined.instance : Integer.valueOf(string9.codePointAt((int) integer2));
                                case 46:
                                case 47:
                                    break;
                                case 48:
                                    return new NativeStringIterator(scriptable, ScriptRuntimeES6.requireObjectCoercible(context, scriptable2, idFunctionObject));
                                default:
                                    throw new IllegalArgumentException("String.prototype has no method: " + idFunctionObject.getFunctionName());
                            }
                            return js_pad(context, scriptable2, idFunctionObject, objArr, iMethodId == 46);
                    }
                    break;
            }
            if (objArr.length > 0) {
                scriptable2 = ScriptRuntime.toObject(context, scriptable, ScriptRuntime.toCharSequence(objArr[0]));
                int length5 = objArr.length - 1;
                Object[] objArr5 = new Object[length5];
                while (i < length5) {
                    int i4 = i + 1;
                    objArr5[i] = objArr[i4];
                    i = i4;
                }
                objArr = objArr5;
            } else {
                scriptable2 = ScriptRuntime.toObject(context, scriptable, ScriptRuntime.toCharSequence(scriptable2));
            }
            iMethodId = -iMethodId;
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected void fillConstructorProperties(IdFunctionObject idFunctionObject) {
        Object obj = STRING_TAG;
        addIdFunctionProperty(idFunctionObject, obj, -1, "fromCharCode", 1);
        addIdFunctionProperty(idFunctionObject, obj, -2, "fromCodePoint", 1);
        addIdFunctionProperty(idFunctionObject, obj, -5, "charAt", 2);
        addIdFunctionProperty(idFunctionObject, obj, -6, "charCodeAt", 2);
        addIdFunctionProperty(idFunctionObject, obj, -7, "indexOf", 2);
        addIdFunctionProperty(idFunctionObject, obj, -8, "lastIndexOf", 2);
        addIdFunctionProperty(idFunctionObject, obj, -9, "split", 3);
        addIdFunctionProperty(idFunctionObject, obj, -10, "substring", 3);
        addIdFunctionProperty(idFunctionObject, obj, -11, "toLowerCase", 1);
        addIdFunctionProperty(idFunctionObject, obj, -12, "toUpperCase", 1);
        addIdFunctionProperty(idFunctionObject, obj, -13, "substr", 3);
        addIdFunctionProperty(idFunctionObject, obj, -14, "concat", 2);
        addIdFunctionProperty(idFunctionObject, obj, -15, AzureActiveDirectorySlice.SLICE_PARAMETER, 3);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_equalsIgnoreCase, "equalsIgnoreCase", 2);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_match, "match", 2);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_search, "search", 2);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_replace, "replace", 2);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_localeCompare, "localeCompare", 2);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_toLocaleLowerCase, "toLocaleLowerCase", 1);
        super.fillConstructorProperties(idFunctionObject);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected int findInstanceIdInfo(String str) {
        return str.equals(Analytics.Data.LENGTH) ? IdScriptableObject.instanceIdInfo(7, 1) : super.findInstanceIdInfo(str);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected int findPrototypeId(Symbol symbol) {
        return SymbolKey.ITERATOR.equals(symbol) ? 48 : 0;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public Object get(int i, Scriptable scriptable) {
        return (i < 0 || i >= this.string.length()) ? super.get(i, scriptable) : String.valueOf(this.string.charAt(i));
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject
    public int getAttributes(int i) {
        if (i < 0 || i >= this.string.length()) {
            return super.getAttributes(i);
        }
        return Context.getContext().getLanguageVersion() < 200 ? 7 : 5;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public String getClassName() {
        return "String";
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject, external.sdk.pendo.io.mozilla.javascript.ScriptableObject
    protected Object[] getIds(boolean z, boolean z2) {
        Context currentContext = Context.getCurrentContext();
        if (currentContext == null || currentContext.getLanguageVersion() < 200) {
            return super.getIds(z, z2);
        }
        Object[] ids = super.getIds(z, z2);
        Object[] objArr = new Object[ids.length + this.string.length()];
        int i = 0;
        while (i < this.string.length()) {
            objArr[i] = Integer.valueOf(i);
            i++;
        }
        System.arraycopy(ids, 0, objArr, i, ids.length);
        return objArr;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected String getInstanceIdName(int i) {
        return i == 1 ? Analytics.Data.LENGTH : super.getInstanceIdName(i);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected Object getInstanceIdValue(int i) {
        return i == 1 ? ScriptRuntime.wrapInt(this.string.length()) : super.getInstanceIdValue(i);
    }

    int getLength() {
        return this.string.length();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected int getMaxInstanceId() {
        return 1;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject, external.sdk.pendo.io.mozilla.javascript.ScriptableObject
    protected ScriptableObject getOwnPropertyDescriptor(Context context, Object obj) {
        int i;
        if (!(obj instanceof Symbol) && context != null && context.getLanguageVersion() >= 200) {
            ScriptRuntime.StringIdOrIndex stringIdOrIndex = ScriptRuntime.toStringIdOrIndex(context, obj);
            if (stringIdOrIndex.stringId == null && (i = stringIdOrIndex.index) >= 0 && i < this.string.length()) {
                return defaultIndexPropertyDescriptor(String.valueOf(this.string.charAt(stringIdOrIndex.index)));
            }
        }
        return super.getOwnPropertyDescriptor(context, obj);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public boolean has(int i, Scriptable scriptable) {
        if (i < 0 || i >= this.string.length()) {
            return super.has(i, scriptable);
        }
        return true;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected void initPrototypeId(int i) {
        String str;
        String str2;
        String str3;
        int i2;
        String str4;
        if (i == 48) {
            initPrototypeMethod(STRING_TAG, i, SymbolKey.ITERATOR, "[Symbol.iterator]", 0);
            return;
        }
        switch (i) {
            case 1:
                str = "constructor";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 2:
                str2 = "toString";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 3:
                str2 = "toSource";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 4:
                str2 = "valueOf";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 5:
                str = "charAt";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 6:
                str = "charCodeAt";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 7:
                str = "indexOf";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 8:
                str = "lastIndexOf";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 9:
                str3 = "split";
                i2 = 2;
                str4 = str3;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 10:
                str3 = "substring";
                i2 = 2;
                str4 = str3;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 11:
                str2 = "toLowerCase";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 12:
                str2 = "toUpperCase";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 13:
                str3 = "substr";
                i2 = 2;
                str4 = str3;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 14:
                str = "concat";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 15:
                str3 = AzureActiveDirectorySlice.SLICE_PARAMETER;
                i2 = 2;
                str4 = str3;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 16:
                str2 = "bold";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 17:
                str2 = "italics";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 18:
                str2 = "fixed";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 19:
                str2 = "strike";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 20:
                str2 = BoxRequestsFile.DownloadAvatar.SMALL;
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 21:
                str2 = "big";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 22:
                str2 = "blink";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 23:
                str2 = "sup";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 24:
                str2 = "sub";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 25:
                str2 = "fontsize";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 26:
                str2 = "fontcolor";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 27:
                str2 = BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_LINK;
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 28:
                str2 = "anchor";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 29:
                str = "equals";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 30:
                str = "equalsIgnoreCase";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 31:
                str = "match";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 32:
                str = "search";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 33:
                str3 = "replace";
                i2 = 2;
                str4 = str3;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 34:
                str = "localeCompare";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 35:
                str2 = "toLocaleLowerCase";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 36:
                str2 = "toLocaleUpperCase";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 37:
                str2 = "trim";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 38:
                str2 = "trimLeft";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 39:
                str2 = "trimRight";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 40:
                str = "includes";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 41:
                str = "startsWith";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 42:
                str = "endsWith";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 43:
                str2 = "normalize";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 44:
                str = "repeat";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 45:
                str = "codePointAt";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 46:
                str = "padStart";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 47:
                str = "padEnd";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 48:
            default:
                throw new IllegalArgumentException(String.valueOf(i));
            case 49:
                str2 = "trimStart";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 50:
                str2 = "trimEnd";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public void put(int i, Scriptable scriptable, Object obj) {
        if (i < 0 || i >= this.string.length()) {
            super.put(i, scriptable, obj);
        }
    }

    public CharSequence toCharSequence() {
        return this.string;
    }

    public String toString() {
        CharSequence charSequence = this.string;
        return charSequence instanceof String ? (String) charSequence : charSequence.toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:151:0x0241  */
    /* JADX WARN: Code duplicated, block: B:153:0x0245 A[ADDED_TO_REGION] */
    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected int findPrototypeId(String str) {
        String str2;
        int i = 8;
        switch (str.length()) {
            case 3:
                char cCharAt = str.charAt(2);
                if (cCharAt == 'b') {
                    if (str.charAt(0) == 's' && str.charAt(1) == 'u') {
                        return 24;
                    }
                } else if (cCharAt == 'g') {
                    if (str.charAt(0) == 'b' && str.charAt(1) == 'i') {
                        return 21;
                    }
                } else if (cCharAt == 'p' && str.charAt(0) == 's' && str.charAt(1) == 'u') {
                    return 23;
                }
                str2 = null;
                i = 0;
                if (str2 != null || str2 == str || str2.equals(str)) {
                    return i;
                }
                return 0;
            case 4:
                char cCharAt2 = str.charAt(0);
                if (cCharAt2 == 'b') {
                    str2 = "bold";
                    i = 16;
                } else if (cCharAt2 == 'l') {
                    str2 = BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_LINK;
                    i = 27;
                } else if (cCharAt2 == 't') {
                    str2 = "trim";
                    i = 37;
                } else {
                    str2 = null;
                    i = 0;
                }
                if (str2 != null) {
                }
                return i;
            case 5:
                char cCharAt3 = str.charAt(4);
                if (cCharAt3 == 'd') {
                    str2 = "fixed";
                    i = 18;
                } else if (cCharAt3 == 'e') {
                    str2 = AzureActiveDirectorySlice.SLICE_PARAMETER;
                    i = 15;
                } else if (cCharAt3 == 'h') {
                    str2 = "match";
                    i = 31;
                } else if (cCharAt3 == 't') {
                    str2 = "split";
                    i = 9;
                } else if (cCharAt3 == 'k') {
                    str2 = "blink";
                    i = 22;
                } else if (cCharAt3 != 'l') {
                    str2 = null;
                    i = 0;
                } else {
                    str2 = BoxRequestsFile.DownloadAvatar.SMALL;
                    i = 20;
                }
                if (str2 != null) {
                }
                return i;
            case 6:
                char cCharAt4 = str.charAt(1);
                if (cCharAt4 == 'a') {
                    str2 = "padEnd";
                    i = 47;
                } else if (cCharAt4 == 'e') {
                    char cCharAt5 = str.charAt(0);
                    if (cCharAt5 == 'r') {
                        str2 = "repeat";
                        i = 44;
                    } else if (cCharAt5 == 's') {
                        str2 = "search";
                        i = 32;
                    } else {
                        str2 = null;
                        i = 0;
                    }
                } else if (cCharAt4 == 'h') {
                    str2 = "charAt";
                    i = 5;
                } else if (cCharAt4 == 'q') {
                    str2 = "equals";
                    i = 29;
                } else if (cCharAt4 == 'n') {
                    str2 = "anchor";
                    i = 28;
                } else if (cCharAt4 == 'o') {
                    str2 = "concat";
                    i = 14;
                } else if (cCharAt4 == 't') {
                    str2 = "strike";
                    i = 19;
                } else if (cCharAt4 != 'u') {
                    str2 = null;
                    i = 0;
                } else {
                    str2 = "substr";
                    i = 13;
                }
                if (str2 != null) {
                }
                return i;
            case 7:
                char cCharAt6 = str.charAt(1);
                if (cCharAt6 == 'a') {
                    str2 = "valueOf";
                    i = 4;
                } else if (cCharAt6 == 'e') {
                    str2 = "replace";
                    i = 33;
                } else if (cCharAt6 == 'n') {
                    str2 = "indexOf";
                    i = 7;
                } else if (cCharAt6 == 'r') {
                    str2 = "trimEnd";
                    i = 50;
                } else if (cCharAt6 != 't') {
                    str2 = null;
                    i = 0;
                } else {
                    str2 = "italics";
                    i = 17;
                }
                if (str2 != null) {
                }
                return i;
            case 8:
                char cCharAt7 = str.charAt(6);
                if (cCharAt7 == 'c') {
                    str2 = "toSource";
                    i = 3;
                } else if (cCharAt7 == 'n') {
                    str2 = "toString";
                    i = 2;
                } else if (cCharAt7 == 'r') {
                    str2 = "padStart";
                    i = 46;
                } else if (cCharAt7 == 't') {
                    str2 = "endsWith";
                    i = 42;
                } else if (cCharAt7 == 'z') {
                    str2 = "fontsize";
                    i = 25;
                } else if (cCharAt7 == 'e') {
                    str2 = "includes";
                    i = 40;
                } else if (cCharAt7 != 'f') {
                    str2 = null;
                    i = 0;
                } else {
                    str2 = "trimLeft";
                    i = 38;
                }
                if (str2 != null) {
                }
                return i;
            case 9:
                char cCharAt8 = str.charAt(4);
                if (cCharAt8 == 'R') {
                    str2 = "trimRight";
                    i = 39;
                } else if (cCharAt8 == 'S') {
                    str2 = "trimStart";
                    i = 49;
                } else if (cCharAt8 == 'a') {
                    str2 = "normalize";
                    i = 43;
                } else if (cCharAt8 == 'c') {
                    str2 = "fontcolor";
                    i = 26;
                } else if (cCharAt8 != 't') {
                    str2 = null;
                    i = 0;
                } else {
                    str2 = "substring";
                    i = 10;
                }
                if (str2 != null) {
                }
                return i;
            case 10:
                char cCharAt9 = str.charAt(0);
                if (cCharAt9 == 'c') {
                    str2 = "charCodeAt";
                    i = 6;
                } else if (cCharAt9 == 's') {
                    str2 = "startsWith";
                    i = 41;
                } else {
                    str2 = null;
                    i = 0;
                }
                if (str2 != null) {
                }
                return i;
            case 11:
                char cCharAt10 = str.charAt(2);
                if (cCharAt10 == 'L') {
                    str2 = "toLowerCase";
                    i = 11;
                } else if (cCharAt10 == 'U') {
                    str2 = "toUpperCase";
                    i = 12;
                } else if (cCharAt10 == 'd') {
                    str2 = "codePointAt";
                    i = 45;
                } else if (cCharAt10 == 'n') {
                    str2 = "constructor";
                    i = 1;
                } else if (cCharAt10 != 's') {
                    str2 = null;
                    i = 0;
                } else {
                    str2 = "lastIndexOf";
                }
                if (str2 != null) {
                }
                return i;
            case 12:
            case 14:
            case 15:
            default:
                str2 = null;
                i = 0;
                if (str2 != null) {
                }
                return i;
            case 13:
                str2 = "localeCompare";
                i = 34;
                if (str2 != null) {
                }
                return i;
            case 16:
                str2 = "equalsIgnoreCase";
                i = 30;
                if (str2 != null) {
                }
                return i;
            case 17:
                char cCharAt11 = str.charAt(8);
                if (cCharAt11 == 'L') {
                    str2 = "toLocaleLowerCase";
                    i = 35;
                } else if (cCharAt11 == 'U') {
                    str2 = "toLocaleUpperCase";
                    i = 36;
                } else {
                    str2 = null;
                    i = 0;
                }
                if (str2 != null) {
                }
                return i;
        }
    }
}
