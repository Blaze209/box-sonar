package external.sdk.pendo.io.mozilla.javascript.commonjs.module;

import external.sdk.pendo.io.mozilla.javascript.Context;
import external.sdk.pendo.io.mozilla.javascript.Script;
import external.sdk.pendo.io.mozilla.javascript.Scriptable;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class RequireBuilder implements Serializable {
    private static final long serialVersionUID = 1;
    private ModuleScriptProvider moduleScriptProvider;
    private Script postExec;
    private Script preExec;
    private boolean sandboxed = true;

    public Require createRequire(Context context, Scriptable scriptable) {
        return new Require(context, scriptable, this.moduleScriptProvider, this.preExec, this.postExec, this.sandboxed);
    }

    public RequireBuilder setModuleScriptProvider(ModuleScriptProvider moduleScriptProvider) {
        this.moduleScriptProvider = moduleScriptProvider;
        return this;
    }

    public RequireBuilder setPostExec(Script script) {
        this.postExec = script;
        return this;
    }

    public RequireBuilder setPreExec(Script script) {
        this.preExec = script;
        return this;
    }

    public RequireBuilder setSandboxed(boolean z) {
        this.sandboxed = z;
        return this;
    }
}
