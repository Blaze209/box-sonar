package external.sdk.pendo.io.mozilla.javascript;

import external.sdk.pendo.io.mozilla.javascript.debug.DebuggableScript;

/* JADX INFO: loaded from: classes4.dex */
final class InterpretedFunction extends NativeFunction implements Script {
    private static final long serialVersionUID = 541475680333911468L;
    InterpreterData idata;
    SecurityController securityController;
    Object securityDomain;

    private InterpretedFunction(InterpretedFunction interpretedFunction, int i) {
        this.idata = interpretedFunction.idata.itsNestedFunctions[i];
        this.securityController = interpretedFunction.securityController;
        this.securityDomain = interpretedFunction.securityDomain;
    }

    static InterpretedFunction createFunction(Context context, Scriptable scriptable, InterpretedFunction interpretedFunction, int i) {
        InterpretedFunction interpretedFunction2 = new InterpretedFunction(interpretedFunction, i);
        interpretedFunction2.initScriptFunction(context, scriptable, interpretedFunction2.idata.isES6Generator);
        return interpretedFunction2;
    }

    static InterpretedFunction createScript(InterpreterData interpreterData, Object obj) {
        return new InterpretedFunction(interpreterData, obj);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.BaseFunction, external.sdk.pendo.io.mozilla.javascript.Function, external.sdk.pendo.io.mozilla.javascript.Callable
    public Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        return !ScriptRuntime.hasTopCall(context) ? ScriptRuntime.doTopCall(this, context, scriptable, scriptable2, objArr, this.idata.isStrict) : Interpreter.interpret(this, context, scriptable, scriptable2, objArr);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.Script
    public Object exec(Context context, Scriptable scriptable) {
        if (isScript()) {
            return !ScriptRuntime.hasTopCall(context) ? ScriptRuntime.doTopCall(this, context, scriptable, scriptable, ScriptRuntime.emptyArgs, this.idata.isStrict) : Interpreter.interpret(this, context, scriptable, scriptable, ScriptRuntime.emptyArgs);
        }
        throw new IllegalStateException();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.NativeFunction
    public DebuggableScript getDebuggableView() {
        return this.idata;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.NativeFunction
    public String getEncodedSource() {
        return Interpreter.getEncodedSource(this.idata);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.BaseFunction
    public String getFunctionName() {
        String str = this.idata.itsName;
        return str == null ? "" : str;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.NativeFunction
    protected int getLanguageVersion() {
        return this.idata.languageVersion;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.NativeFunction
    protected int getParamAndVarCount() {
        return this.idata.argNames.length;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.NativeFunction
    protected int getParamCount() {
        return this.idata.argCount;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.NativeFunction
    protected boolean getParamOrVarConst(int i) {
        return this.idata.argIsConst[i];
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.NativeFunction
    protected String getParamOrVarName(int i) {
        return this.idata.argNames[i];
    }

    boolean hasFunctionNamed(String str) {
        for (int i = 0; i < this.idata.getFunctionCount(); i++) {
            InterpreterData interpreterData = (InterpreterData) this.idata.getFunction(i);
            if (!interpreterData.declaredAsFunctionExpression && str.equals(interpreterData.getFunctionName())) {
                return false;
            }
        }
        return true;
    }

    public boolean isScript() {
        return this.idata.itsFunctionType == 0;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.NativeFunction
    public Object resumeGenerator(Context context, Scriptable scriptable, int i, Object obj, Object obj2) {
        return Interpreter.resumeGenerator(context, scriptable, i, obj, obj2);
    }

    private InterpretedFunction(InterpreterData interpreterData, Object obj) {
        Object dynamicSecurityDomain;
        this.idata = interpreterData;
        SecurityController securityController = Context.getContext().getSecurityController();
        if (securityController != null) {
            dynamicSecurityDomain = securityController.getDynamicSecurityDomain(obj);
        } else {
            if (obj != null) {
                throw new IllegalArgumentException();
            }
            dynamicSecurityDomain = null;
        }
        this.securityController = securityController;
        this.securityDomain = dynamicSecurityDomain;
    }

    static InterpretedFunction createFunction(Context context, Scriptable scriptable, InterpreterData interpreterData, Object obj) {
        InterpretedFunction interpretedFunction = new InterpretedFunction(interpreterData, obj);
        interpretedFunction.initScriptFunction(context, scriptable, interpretedFunction.idata.isES6Generator);
        return interpretedFunction;
    }
}
