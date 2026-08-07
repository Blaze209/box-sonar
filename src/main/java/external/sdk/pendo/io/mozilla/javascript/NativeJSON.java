package external.sdk.pendo.io.mozilla.javascript;

import androidx.collection.SieveCacheKt;
import com.fasterxml.jackson.core.JsonFactory;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import external.sdk.pendo.io.mozilla.javascript.json.JsonParser;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes4.dex */
public final class NativeJSON extends IdScriptableObject {
    private static final int Id_parse = 2;
    private static final int Id_stringify = 3;
    private static final int Id_toSource = 1;
    private static final Object JSON_TAG = JsonFactory.FORMAT_NAME_JSON;
    private static final int LAST_METHOD_ID = 3;
    private static final int MAX_ID = 3;
    private static final int MAX_STRINGIFY_GAP_LENGTH = 10;
    private static final long serialVersionUID = -4567599697595654984L;

    private static class StringifyState {
        Context cx;
        String gap;
        String indent;
        List<Object> propertyList;
        Callable replacer;
        Scriptable scope;
        Stack<Scriptable> stack = new Stack<>();

        StringifyState(Context context, Scriptable scriptable, String str, String str2, Callable callable, List<Object> list) {
            this.cx = context;
            this.scope = scriptable;
            this.indent = str;
            this.gap = str2;
            this.replacer = callable;
            this.propertyList = list;
        }
    }

    private NativeJSON() {
    }

    static void init(Scriptable scriptable, boolean z) {
        NativeJSON nativeJSON = new NativeJSON();
        nativeJSON.activatePrototypeMap(3);
        nativeJSON.setPrototype(ScriptableObject.getObjectPrototype(scriptable));
        nativeJSON.setParentScope(scriptable);
        if (z) {
            nativeJSON.sealObject();
        }
        ScriptableObject.defineProperty(scriptable, JsonFactory.FORMAT_NAME_JSON, nativeJSON, 2);
    }

    private static String ja(NativeArray nativeArray, StringifyState stringifyState) {
        StringBuilder sbAppend;
        String string;
        if (stringifyState.stack.search(nativeArray) != -1) {
            throw ScriptRuntime.typeError0("msg.cyclic.value");
        }
        stringifyState.stack.push(nativeArray);
        String str = stringifyState.indent;
        stringifyState.indent += stringifyState.gap;
        LinkedList linkedList = new LinkedList();
        long length = nativeArray.getLength();
        long j = 0;
        while (j < length) {
            Object objStr = str(j > SieveCacheKt.NodeLinkMask ? Long.toString(j) : Integer.valueOf((int) j), nativeArray, stringifyState);
            if (objStr == Undefined.instance) {
                objStr = AbstractJsonLexerKt.NULL;
            }
            linkedList.add(objStr);
            j++;
        }
        if (linkedList.isEmpty()) {
            string = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        } else {
            if (stringifyState.gap.length() == 0) {
                sbAppend = new StringBuilder("[").append(join(linkedList, ","));
            } else {
                sbAppend = new StringBuilder("[\n").append(stringifyState.indent).append(join(linkedList, ",\n" + stringifyState.indent)).append('\n').append(str);
            }
            string = sbAppend.append(AbstractJsonLexerKt.END_LIST).toString();
        }
        stringifyState.stack.pop();
        stringifyState.indent = str;
        return string;
    }

    private static String jo(Scriptable scriptable, StringifyState stringifyState) {
        String string;
        if (stringifyState.stack.search(scriptable) != -1) {
            throw ScriptRuntime.typeError0("msg.cyclic.value");
        }
        stringifyState.stack.push(scriptable);
        String str = stringifyState.indent;
        stringifyState.indent += stringifyState.gap;
        List<Object> list = stringifyState.propertyList;
        Object[] array = list != null ? list.toArray() : scriptable.getIds();
        LinkedList linkedList = new LinkedList();
        for (Object obj : array) {
            Object objStr = str(obj, scriptable, stringifyState);
            if (objStr != Undefined.instance) {
                String str2 = quote(obj.toString()) + ":";
                if (stringifyState.gap.length() > 0) {
                    str2 = str2 + " ";
                }
                linkedList.add(str2 + objStr);
            }
        }
        if (linkedList.isEmpty()) {
            string = "{}";
        } else {
            string = (stringifyState.gap.length() == 0 ? new StringBuilder("{").append(join(linkedList, ",")) : new StringBuilder("{\n").append(stringifyState.indent).append(join(linkedList, ",\n" + stringifyState.indent)).append('\n').append(str)).append(AbstractJsonLexerKt.END_OBJ).toString();
        }
        stringifyState.stack.pop();
        stringifyState.indent = str;
        return string;
    }

    private static String join(Collection<Object> collection, String str) {
        if (collection == null || collection.isEmpty()) {
            return "";
        }
        Iterator<Object> it = collection.iterator();
        if (!it.hasNext()) {
            return "";
        }
        StringBuilder sb = new StringBuilder(it.next().toString());
        while (it.hasNext()) {
            sb.append(str).append(it.next());
        }
        return sb.toString();
    }

    private static Object parse(Context context, Scriptable scriptable, String str) {
        try {
            return new JsonParser(context, scriptable).parseValue(str);
        } catch (JsonParser.ParseException e) {
            throw ScriptRuntime.constructError("SyntaxError", e.getMessage());
        }
    }

    private static String quote(String str) {
        String str2;
        StringBuilder sb = new StringBuilder(str.length() + 2);
        sb.append('\"');
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\f') {
                str2 = "\\f";
            } else if (cCharAt == '\r') {
                str2 = "\\r";
            } else if (cCharAt == '\"') {
                str2 = "\\\"";
            } else if (cCharAt != '\\') {
                switch (cCharAt) {
                    case '\b':
                        str2 = "\\b";
                        break;
                    case '\t':
                        str2 = "\\t";
                        break;
                    case '\n':
                        str2 = "\\n";
                        break;
                    default:
                        if (cCharAt < ' ') {
                            sb.append("\\u");
                            str2 = String.format("%04x", Integer.valueOf(cCharAt));
                        } else {
                            sb.append(cCharAt);
                        }
                        break;
                }
            } else {
                str2 = "\\\\";
            }
            sb.append(str2);
        }
        sb.append('\"');
        return sb.toString();
    }

    private static String repeat(char c, int i) {
        char[] cArr = new char[i];
        Arrays.fill(cArr, c);
        return new String(cArr);
    }

    private static Object str(Object obj, Scriptable scriptable, StringifyState stringifyState) {
        Object property = obj instanceof String ? ScriptableObject.getProperty(scriptable, (String) obj) : ScriptableObject.getProperty(scriptable, ((Number) obj).intValue());
        if (property instanceof Scriptable) {
            Scriptable scriptable2 = (Scriptable) property;
            if (ScriptableObject.hasProperty(scriptable2, "toJSON") && (ScriptableObject.getProperty(scriptable2, "toJSON") instanceof Callable)) {
                property = ScriptableObject.callMethod(stringifyState.cx, scriptable2, "toJSON", new Object[]{obj});
            }
        }
        Callable callable = stringifyState.replacer;
        if (callable != null) {
            property = callable.call(stringifyState.cx, stringifyState.scope, scriptable, new Object[]{obj, property});
        }
        if (property instanceof NativeNumber) {
            property = Double.valueOf(ScriptRuntime.toNumber(property));
        } else if (property instanceof NativeString) {
            property = ScriptRuntime.toString(property);
        } else if (property instanceof NativeBoolean) {
            property = ((NativeBoolean) property).getDefaultValue(ScriptRuntime.BooleanClass);
        }
        if (property == null) {
            return AbstractJsonLexerKt.NULL;
        }
        if (property.equals(Boolean.TRUE)) {
            return TelemetryEventStrings.Value.TRUE;
        }
        if (property.equals(Boolean.FALSE)) {
            return "false";
        }
        if (property instanceof CharSequence) {
            return quote(property.toString());
        }
        if (property instanceof Number) {
            double dDoubleValue = ((Number) property).doubleValue();
            return (Double.isNaN(dDoubleValue) || dDoubleValue == Double.POSITIVE_INFINITY || dDoubleValue == Double.NEGATIVE_INFINITY) ? AbstractJsonLexerKt.NULL : ScriptRuntime.toString(property);
        }
        if (!(property instanceof Scriptable) || (property instanceof Callable)) {
            return Undefined.instance;
        }
        return property instanceof NativeArray ? ja((NativeArray) property, stringifyState) : jo((Scriptable) property, stringifyState);
    }

    /* JADX WARN: Code duplicated, block: B:40:0x0092  */
    public static Object stringify(Context context, Scriptable scriptable, Object obj, Object obj2, Object obj3) {
        Callable callable;
        LinkedList linkedList;
        String strSubstring;
        String str;
        if (obj2 instanceof Callable) {
            callable = (Callable) obj2;
            linkedList = null;
        } else if (obj2 instanceof NativeArray) {
            LinkedList linkedList2 = new LinkedList();
            NativeArray nativeArray = (NativeArray) obj2;
            Iterator<Integer> it = nativeArray.getIndexIds().iterator();
            while (it.hasNext()) {
                Object string = nativeArray.get(it.next().intValue(), nativeArray);
                if (!(string instanceof String) && !(string instanceof Number)) {
                    if ((string instanceof NativeString) || (string instanceof NativeNumber)) {
                        string = ScriptRuntime.toString(string);
                    }
                }
                linkedList2.add(string);
            }
            linkedList = linkedList2;
            callable = null;
        } else {
            callable = null;
            linkedList = null;
        }
        if (obj3 instanceof NativeNumber) {
            obj3 = Double.valueOf(ScriptRuntime.toNumber(obj3));
        } else if (obj3 instanceof NativeString) {
            obj3 = ScriptRuntime.toString(obj3);
        }
        if (obj3 instanceof Number) {
            int iMin = Math.min(10, (int) ScriptRuntime.toInteger(obj3));
            if (iMin > 0) {
                strSubstring = repeat(' ', iMin);
                str = strSubstring;
            } else {
                str = "";
            }
        } else if (obj3 instanceof String) {
            strSubstring = (String) obj3;
            if (strSubstring.length() > 10) {
                strSubstring = strSubstring.substring(0, 10);
            }
            str = strSubstring;
        } else {
            str = "";
        }
        StringifyState stringifyState = new StringifyState(context, scriptable, "", str, callable, linkedList);
        NativeObject nativeObject = new NativeObject();
        nativeObject.setParentScope(scriptable);
        nativeObject.setPrototype(ScriptableObject.getObjectPrototype(scriptable));
        nativeObject.defineProperty("", obj, 0);
        return str("", nativeObject, stringifyState);
    }

    private static Object walk(Context context, Scriptable scriptable, Callable callable, Scriptable scriptable2, Object obj) {
        Object obj2 = obj instanceof Number ? scriptable2.get(((Number) obj).intValue(), scriptable2) : scriptable2.get((String) obj, scriptable2);
        if (obj2 instanceof Scriptable) {
            Scriptable scriptable3 = (Scriptable) obj2;
            if (scriptable3 instanceof NativeArray) {
                long length = ((NativeArray) scriptable3).getLength();
                for (long j = 0; j < length; j++) {
                    if (j > SieveCacheKt.NodeLinkMask) {
                        String string = Long.toString(j);
                        Object objWalk = walk(context, scriptable, callable, scriptable3, string);
                        if (objWalk == Undefined.instance) {
                            scriptable3.delete(string);
                        } else {
                            scriptable3.put(string, scriptable3, objWalk);
                        }
                    } else {
                        int i = (int) j;
                        Object objWalk2 = walk(context, scriptable, callable, scriptable3, Integer.valueOf(i));
                        if (objWalk2 == Undefined.instance) {
                            scriptable3.delete(i);
                        } else {
                            scriptable3.put(i, scriptable3, objWalk2);
                        }
                    }
                }
            } else {
                for (Object obj3 : scriptable3.getIds()) {
                    Object objWalk3 = walk(context, scriptable, callable, scriptable3, obj3);
                    if (objWalk3 == Undefined.instance) {
                        if (obj3 instanceof Number) {
                            scriptable3.delete(((Number) obj3).intValue());
                        } else {
                            scriptable3.delete((String) obj3);
                        }
                    } else if (obj3 instanceof Number) {
                        scriptable3.put(((Number) obj3).intValue(), scriptable3, objWalk3);
                    } else {
                        scriptable3.put((String) obj3, scriptable3, objWalk3);
                    }
                }
            }
        }
        return callable.call(context, scriptable, scriptable2, new Object[]{obj, obj2});
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject, external.sdk.pendo.io.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Object obj;
        Object obj2;
        Object obj3;
        if (!idFunctionObject.hasTag(JSON_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int iMethodId = idFunctionObject.methodId();
        if (iMethodId == 1) {
            return JsonFactory.FORMAT_NAME_JSON;
        }
        Object obj4 = null;
        if (iMethodId == 2) {
            String string = ScriptRuntime.toString(objArr, 0);
            obj4 = objArr.length > 1 ? objArr[1] : null;
            return obj4 instanceof Callable ? parse(context, scriptable, string, (Callable) obj4) : parse(context, scriptable, string);
        }
        if (iMethodId != 3) {
            throw new IllegalStateException(String.valueOf(iMethodId));
        }
        int length = objArr.length;
        if (length != 1) {
            if (length != 2) {
                if (length != 3) {
                    obj3 = null;
                    obj2 = null;
                } else {
                    obj4 = objArr[2];
                }
                return stringify(context, scriptable, obj4, obj3, obj2);
            }
            Object obj5 = obj4;
            obj4 = objArr[1];
            obj = obj5;
        } else {
            obj = null;
        }
        obj2 = obj;
        obj3 = obj4;
        obj4 = objArr[0];
        return stringify(context, scriptable, obj4, obj3, obj2);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected int findPrototypeId(String str) {
        String str2;
        int i;
        int length = str.length();
        if (length == 5) {
            str2 = "parse";
            i = 2;
        } else if (length == 8) {
            str2 = "toSource";
            i = 1;
        } else if (length != 9) {
            str2 = null;
            i = 0;
        } else {
            str2 = "stringify";
            i = 3;
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i;
        }
        return 0;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public String getClassName() {
        return JsonFactory.FORMAT_NAME_JSON;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected void initPrototypeId(int i) {
        String str;
        int i2 = 3;
        if (i > 3) {
            throw new IllegalStateException(String.valueOf(i));
        }
        if (i == 1) {
            i2 = 0;
            str = "toSource";
        } else if (i == 2) {
            str = "parse";
            i2 = 2;
        } else {
            if (i != 3) {
                throw new IllegalStateException(String.valueOf(i));
            }
            str = "stringify";
        }
        initPrototypeMethod(JSON_TAG, i, str, i2);
    }

    public static Object parse(Context context, Scriptable scriptable, String str, Callable callable) {
        Object obj = parse(context, scriptable, str);
        Scriptable scriptableNewObject = context.newObject(scriptable);
        scriptableNewObject.put("", scriptableNewObject, obj);
        return walk(context, scriptable, callable, scriptableNewObject, "");
    }
}
