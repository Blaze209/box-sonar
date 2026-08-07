package sdk.pendo.io.utilities.script;

import external.sdk.pendo.io.mozilla.javascript.Callable;
import external.sdk.pendo.io.mozilla.javascript.ClassShutter;
import external.sdk.pendo.io.mozilla.javascript.Context;
import external.sdk.pendo.io.mozilla.javascript.ContextFactory;
import external.sdk.pendo.io.mozilla.javascript.Scriptable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
class JavascriptSandboxContextFactory extends ContextFactory {
    private static final int INSTRUCTION_OBSERVER_THRESHOLD = 10000;
    private final ScriptSandbox mShutter;

    static class PendoIoJSContext extends Context {
        private long mStartTime;

        PendoIoJSContext(ContextFactory contextFactory) {
            super(contextFactory);
        }

        long getStartTime() {
            return this.mStartTime;
        }

        void setStartTime(long j) {
            this.mStartTime = j;
        }
    }

    JavascriptSandboxContextFactory(ScriptSandbox scriptSandbox) {
        this.mShutter = scriptSandbox;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ContextFactory
    protected Object doTopCall(Callable callable, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        ((PendoIoJSContext) context).setStartTime(System.currentTimeMillis());
        return super.doTopCall(callable, context, scriptable, scriptable2, objArr);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ContextFactory
    protected final Context makeContext() {
        PendoIoJSContext pendoIoJSContext = new PendoIoJSContext(this);
        pendoIoJSContext.setWrapFactory(new JavascriptSandboxWrapFactory(this.mShutter));
        pendoIoJSContext.setClassShutter(new ClassShutter() { // from class: sdk.pendo.io.utilities.script.JavascriptSandboxContextFactory.1
            private final Map<String, Boolean> mNameToAccepted = new HashMap();

            @Override // external.sdk.pendo.io.mozilla.javascript.ClassShutter
            public boolean visibleToScripts(String str) {
                Boolean bool = this.mNameToAccepted.get(str);
                if (bool != null) {
                    return bool.booleanValue();
                }
                try {
                    boolean zAllowClassAccess = JavascriptSandboxContextFactory.this.mShutter.allowClassAccess(Class.forName(str));
                    this.mNameToAccepted.put(str, Boolean.valueOf(zAllowClassAccess));
                    return zAllowClassAccess;
                } catch (Exception unused) {
                    this.mNameToAccepted.put(str, Boolean.FALSE);
                    return false;
                }
            }
        });
        pendoIoJSContext.setInstructionObserverThreshold(10000);
        return pendoIoJSContext;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ContextFactory
    protected final void observeInstructionCount(Context context, int i) {
        if (System.currentTimeMillis() - ((PendoIoJSContext) context).getStartTime() > 10000) {
            throw new Error();
        }
    }
}
