package external.sdk.pendo.io.mozilla.javascript;

/* JADX INFO: loaded from: classes4.dex */
public class NativeCallSite extends IdScriptableObject {
    private static final String CALLSITE_TAG = "CallSite";
    private static final int Id_constructor = 1;
    private static final int Id_getColumnNumber = 9;
    private static final int Id_getEvalOrigin = 10;
    private static final int Id_getFileName = 7;
    private static final int Id_getFunction = 4;
    private static final int Id_getFunctionName = 5;
    private static final int Id_getLineNumber = 8;
    private static final int Id_getMethodName = 6;
    private static final int Id_getThis = 2;
    private static final int Id_getTypeName = 3;
    private static final int Id_isConstructor = 14;
    private static final int Id_isEval = 12;
    private static final int Id_isNative = 13;
    private static final int Id_isToplevel = 11;
    private static final int Id_toString = 15;
    private static final int MAX_PROTOTYPE_ID = 15;
    private static final long serialVersionUID = 2688372752566593594L;
    private ScriptStackElement element;

    private NativeCallSite() {
    }

    private static Object getFileName(Scriptable scriptable) {
        while (scriptable != null && !(scriptable instanceof NativeCallSite)) {
            scriptable = scriptable.getPrototype();
        }
        if (scriptable == null) {
            return Scriptable.NOT_FOUND;
        }
        ScriptStackElement scriptStackElement = ((NativeCallSite) scriptable).element;
        if (scriptStackElement == null) {
            return null;
        }
        return scriptStackElement.fileName;
    }

    private static Object getFunctionName(Scriptable scriptable) {
        while (scriptable != null && !(scriptable instanceof NativeCallSite)) {
            scriptable = scriptable.getPrototype();
        }
        if (scriptable == null) {
            return Scriptable.NOT_FOUND;
        }
        ScriptStackElement scriptStackElement = ((NativeCallSite) scriptable).element;
        if (scriptStackElement == null) {
            return null;
        }
        return scriptStackElement.functionName;
    }

    private static Object getLineNumber(Scriptable scriptable) {
        int i;
        while (scriptable != null && !(scriptable instanceof NativeCallSite)) {
            scriptable = scriptable.getPrototype();
        }
        if (scriptable == null) {
            return Scriptable.NOT_FOUND;
        }
        ScriptStackElement scriptStackElement = ((NativeCallSite) scriptable).element;
        return (scriptStackElement == null || (i = scriptStackElement.lineNumber) < 0) ? Undefined.instance : Integer.valueOf(i);
    }

    static void init(Scriptable scriptable, boolean z) {
        new NativeCallSite().exportAsJSClass(15, scriptable, z);
    }

    private static Object js_toString(Scriptable scriptable) {
        while (scriptable != null && !(scriptable instanceof NativeCallSite)) {
            scriptable = scriptable.getPrototype();
        }
        if (scriptable == null) {
            return Scriptable.NOT_FOUND;
        }
        StringBuilder sb = new StringBuilder();
        ((NativeCallSite) scriptable).element.renderJavaStyle(sb);
        return sb.toString();
    }

    static NativeCallSite make(Scriptable scriptable, Scriptable scriptable2) {
        NativeCallSite nativeCallSite = new NativeCallSite();
        Scriptable scriptable3 = (Scriptable) scriptable2.get("prototype", scriptable2);
        nativeCallSite.setParentScope(scriptable);
        nativeCallSite.setPrototype(scriptable3);
        return nativeCallSite;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject, external.sdk.pendo.io.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(CALLSITE_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int iMethodId = idFunctionObject.methodId();
        switch (iMethodId) {
            case 1:
                return make(scriptable, idFunctionObject);
            case 2:
            case 3:
            case 4:
            case 9:
                return Undefined.instance;
            case 5:
                return getFunctionName(scriptable2);
            case 6:
                return null;
            case 7:
                return getFileName(scriptable2);
            case 8:
                return getLineNumber(scriptable2);
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
                return Boolean.FALSE;
            case 15:
                return js_toString(scriptable2);
            default:
                throw new IllegalArgumentException(String.valueOf(iMethodId));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:44:0x0091  */
    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected int findPrototypeId(String str) {
        String str2;
        int i = 3;
        switch (str.length()) {
            case 6:
                str2 = "isEval";
                i = 12;
                break;
            case 7:
                str2 = "getThis";
                i = 2;
                break;
            case 8:
                char cCharAt = str.charAt(0);
                if (cCharAt == 'i') {
                    str2 = "isNative";
                    i = 13;
                } else if (cCharAt != 't') {
                    str2 = null;
                    i = 0;
                } else {
                    str2 = "toString";
                    i = 15;
                }
                break;
            case 9:
            case 12:
            case 14:
            default:
                str2 = null;
                i = 0;
                break;
            case 10:
                str2 = "isToplevel";
                i = 11;
                break;
            case 11:
                char cCharAt2 = str.charAt(4);
                if (cCharAt2 == 'i') {
                    str2 = "getFileName";
                    i = 7;
                } else if (cCharAt2 == 'y') {
                    str2 = "getTypeName";
                } else if (cCharAt2 == 't') {
                    str2 = "constructor";
                    i = 1;
                } else if (cCharAt2 == 'u') {
                    i = 4;
                    str2 = "getFunction";
                } else {
                    str2 = null;
                    i = 0;
                }
                break;
            case 13:
                char cCharAt3 = str.charAt(3);
                if (cCharAt3 == 'E') {
                    str2 = "getEvalOrigin";
                    i = 10;
                } else if (cCharAt3 == 'o') {
                    str2 = "isConstructor";
                    i = 14;
                } else if (cCharAt3 == 'L') {
                    str2 = "getLineNumber";
                    i = 8;
                } else if (cCharAt3 == 'M') {
                    str2 = "getMethodName";
                    i = 6;
                } else {
                    str2 = null;
                    i = 0;
                }
                break;
            case 15:
                char cCharAt4 = str.charAt(3);
                if (cCharAt4 == 'C') {
                    str2 = "getColumnNumber";
                    i = 9;
                } else if (cCharAt4 != 'F') {
                    str2 = null;
                    i = 0;
                } else {
                    str2 = "getFunctionName";
                    i = 5;
                }
                break;
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i;
        }
        return 0;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public String getClassName() {
        return CALLSITE_TAG;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected void initPrototypeId(int i) {
        String str;
        switch (i) {
            case 1:
                str = "constructor";
                break;
            case 2:
                str = "getThis";
                break;
            case 3:
                str = "getTypeName";
                break;
            case 4:
                str = "getFunction";
                break;
            case 5:
                str = "getFunctionName";
                break;
            case 6:
                str = "getMethodName";
                break;
            case 7:
                str = "getFileName";
                break;
            case 8:
                str = "getLineNumber";
                break;
            case 9:
                str = "getColumnNumber";
                break;
            case 10:
                str = "getEvalOrigin";
                break;
            case 11:
                str = "isToplevel";
                break;
            case 12:
                str = "isEval";
                break;
            case 13:
                str = "isNative";
                break;
            case 14:
                str = "isConstructor";
                break;
            case 15:
                str = "toString";
                break;
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
        initPrototypeMethod(CALLSITE_TAG, i, str, 0);
    }

    void setElement(ScriptStackElement scriptStackElement) {
        this.element = scriptStackElement;
    }

    public String toString() {
        ScriptStackElement scriptStackElement = this.element;
        return scriptStackElement == null ? "" : scriptStackElement.toString();
    }
}
