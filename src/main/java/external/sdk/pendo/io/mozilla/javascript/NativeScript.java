package external.sdk.pendo.io.mozilla.javascript;

/* JADX INFO: loaded from: classes4.dex */
class NativeScript extends BaseFunction {
    private static final int Id_compile = 3;
    private static final int Id_constructor = 1;
    private static final int Id_exec = 4;
    private static final int Id_toString = 2;
    private static final int MAX_PROTOTYPE_ID = 4;
    private static final Object SCRIPT_TAG = "Script";
    private static final long serialVersionUID = -6795101161980121700L;
    private Script script;

    private NativeScript(Script script) {
        this.script = script;
    }

    private static Script compile(Context context, String str) {
        int[] iArr = {0};
        String sourcePositionFromStack = Context.getSourcePositionFromStack(iArr);
        if (sourcePositionFromStack == null) {
            iArr[0] = 1;
            sourcePositionFromStack = "<Script object>";
        }
        return context.compileString(str, null, DefaultErrorReporter.forEval(context.getErrorReporter()), sourcePositionFromStack, iArr[0], null);
    }

    static void init(Scriptable scriptable, boolean z) {
        new NativeScript(null).exportAsJSClass(4, scriptable, z);
    }

    private static NativeScript realThis(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (scriptable instanceof NativeScript) {
            return (NativeScript) scriptable;
        }
        throw IdScriptableObject.incompatibleCallError(idFunctionObject);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.BaseFunction, external.sdk.pendo.io.mozilla.javascript.Function, external.sdk.pendo.io.mozilla.javascript.Callable
    public Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Script script = this.script;
        return script != null ? script.exec(context, scriptable) : Undefined.instance;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.BaseFunction, external.sdk.pendo.io.mozilla.javascript.Function
    public Scriptable construct(Context context, Scriptable scriptable, Object[] objArr) {
        throw Context.reportRuntimeError0("msg.script.is.not.constructor");
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.BaseFunction
    String decompile(int i, int i2) {
        Object obj = this.script;
        return obj instanceof NativeFunction ? ((NativeFunction) obj).decompile(i, i2) : super.decompile(i, i2);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.BaseFunction, external.sdk.pendo.io.mozilla.javascript.IdScriptableObject, external.sdk.pendo.io.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(SCRIPT_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int iMethodId = idFunctionObject.methodId();
        if (iMethodId == 1) {
            NativeScript nativeScript = new NativeScript(compile(context, objArr.length != 0 ? ScriptRuntime.toString(objArr[0]) : ""));
            ScriptRuntime.setObjectProtoAndParent(nativeScript, scriptable);
            return nativeScript;
        }
        if (iMethodId == 2) {
            Script script = realThis(scriptable2, idFunctionObject).script;
            return script == null ? "" : context.decompileScript(script, 0);
        }
        if (iMethodId != 3) {
            if (iMethodId != 4) {
                throw new IllegalArgumentException(String.valueOf(iMethodId));
            }
            throw Context.reportRuntimeError1("msg.cant.call.indirect", "exec");
        }
        NativeScript nativeScriptRealThis = realThis(scriptable2, idFunctionObject);
        nativeScriptRealThis.script = compile(context, ScriptRuntime.toString(objArr, 0));
        return nativeScriptRealThis;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.BaseFunction, external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected int findPrototypeId(String str) {
        String str2;
        int length = str.length();
        int i = 4;
        if (length == 4) {
            str2 = "exec";
        } else if (length == 11) {
            str2 = "constructor";
            i = 1;
        } else if (length == 7) {
            str2 = "compile";
            i = 3;
        } else if (length != 8) {
            str2 = null;
            i = 0;
        } else {
            str2 = "toString";
            i = 2;
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i;
        }
        return 0;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.BaseFunction
    public int getArity() {
        return 0;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.BaseFunction, external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Script";
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.BaseFunction
    public int getLength() {
        return 0;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.BaseFunction, external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected void initPrototypeId(int i) {
        String str;
        int i2;
        String str2;
        if (i != 1) {
            i2 = 0;
            if (i == 2) {
                str2 = "toString";
            } else if (i == 3) {
                str = "compile";
            } else {
                if (i != 4) {
                    throw new IllegalArgumentException(String.valueOf(i));
                }
                str2 = "exec";
            }
            initPrototypeMethod(SCRIPT_TAG, i, str2, i2);
        }
        str = "constructor";
        i2 = 1;
        str2 = str;
        initPrototypeMethod(SCRIPT_TAG, i, str2, i2);
    }
}
