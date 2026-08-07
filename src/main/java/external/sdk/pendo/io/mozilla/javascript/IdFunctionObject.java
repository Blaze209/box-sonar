package external.sdk.pendo.io.mozilla.javascript;

/* JADX INFO: loaded from: classes4.dex */
public class IdFunctionObject extends BaseFunction {
    private static final long serialVersionUID = -5332312783643935019L;
    private int arity;
    private String functionName;
    private final IdFunctionCall idcall;
    private final int methodId;
    private final Object tag;
    private boolean useCallAsConstructor;

    public IdFunctionObject(IdFunctionCall idFunctionCall, Object obj, int i, int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
        this.idcall = idFunctionCall;
        this.tag = obj;
        this.methodId = i;
        this.arity = i2;
    }

    static boolean equalObjectGraphs(IdFunctionObject idFunctionObject, IdFunctionObject idFunctionObject2, EqualObjectGraphs equalObjectGraphs) {
        return idFunctionObject.methodId == idFunctionObject2.methodId && idFunctionObject.hasTag(idFunctionObject2.tag) && equalObjectGraphs.equalGraphs(idFunctionObject.idcall, idFunctionObject2.idcall);
    }

    public final void addAsProperty(Scriptable scriptable) {
        ScriptableObject.defineProperty(scriptable, this.functionName, this, 2);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.BaseFunction, external.sdk.pendo.io.mozilla.javascript.Function, external.sdk.pendo.io.mozilla.javascript.Callable
    public Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        return this.idcall.execIdCall(this, context, scriptable, scriptable2, objArr);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.BaseFunction
    public Scriptable createObject(Context context, Scriptable scriptable) {
        if (this.useCallAsConstructor) {
            return null;
        }
        throw ScriptRuntime.typeError1("msg.not.ctor", this.functionName);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.BaseFunction
    String decompile(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        boolean z = (i2 & 1) != 0;
        if (!z) {
            sb.append("function ");
            sb.append(getFunctionName());
            sb.append("() { ");
        }
        sb.append("[native code for ");
        IdFunctionCall idFunctionCall = this.idcall;
        if (idFunctionCall instanceof Scriptable) {
            sb.append(((Scriptable) idFunctionCall).getClassName());
            sb.append('.');
        }
        sb.append(getFunctionName());
        sb.append(", arity=");
        sb.append(getArity());
        sb.append(z ? "]\n" : "] }\n");
        return sb.toString();
    }

    public void exportAsScopeProperty() {
        addAsProperty(getParentScope());
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.BaseFunction
    public int getArity() {
        return this.arity;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.BaseFunction
    public String getFunctionName() {
        String str = this.functionName;
        return str == null ? "" : str;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.BaseFunction
    public int getLength() {
        return getArity();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public Scriptable getPrototype() {
        Scriptable prototype = super.getPrototype();
        if (prototype != null) {
            return prototype;
        }
        Scriptable functionPrototype = ScriptableObject.getFunctionPrototype(getParentScope());
        setPrototype(functionPrototype);
        return functionPrototype;
    }

    public Object getTag() {
        return this.tag;
    }

    public final boolean hasTag(Object obj) {
        Object obj2 = this.tag;
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public void initFunction(String str, Scriptable scriptable) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        if (scriptable == null) {
            throw new IllegalArgumentException();
        }
        this.functionName = str;
        setParentScope(scriptable);
    }

    public final void markAsConstructor(Scriptable scriptable) {
        this.useCallAsConstructor = true;
        setImmunePrototypeProperty(scriptable);
    }

    public final int methodId() {
        return this.methodId;
    }

    public final RuntimeException unknown() {
        return new IllegalArgumentException("BAD FUNCTION ID=" + this.methodId + " MASTER=" + this.idcall);
    }

    public IdFunctionObject(IdFunctionCall idFunctionCall, Object obj, int i, String str, int i2, Scriptable scriptable) {
        super(scriptable, null);
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.idcall = idFunctionCall;
        this.tag = obj;
        this.methodId = i;
        this.arity = i2;
        this.functionName = str;
    }
}
