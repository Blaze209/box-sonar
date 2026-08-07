package external.sdk.pendo.io.mozilla.javascript.tools.shell;

import external.sdk.pendo.io.mozilla.javascript.Context;
import external.sdk.pendo.io.mozilla.javascript.ContextAction;
import external.sdk.pendo.io.mozilla.javascript.ContextFactory;
import external.sdk.pendo.io.mozilla.javascript.Function;
import external.sdk.pendo.io.mozilla.javascript.Script;
import external.sdk.pendo.io.mozilla.javascript.Scriptable;

/* JADX INFO: loaded from: classes4.dex */
class Runner implements Runnable, ContextAction<Object> {
    private Object[] args;
    private Function f;
    ContextFactory factory;
    private Script s;
    private Scriptable scope;

    Runner(Scriptable scriptable, Function function, Object[] objArr) {
        this.scope = scriptable;
        this.f = function;
        this.args = objArr;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ContextAction
    public Object run(Context context) {
        Function function = this.f;
        if (function == null) {
            return this.s.exec(context, this.scope);
        }
        Scriptable scriptable = this.scope;
        return function.call(context, scriptable, scriptable, this.args);
    }

    Runner(Scriptable scriptable, Script script) {
        this.scope = scriptable;
        this.s = script;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.factory.call(this);
    }
}
