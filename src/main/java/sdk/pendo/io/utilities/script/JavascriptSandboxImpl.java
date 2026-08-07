package sdk.pendo.io.utilities.script;

import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.logging.PendoLogger;

/* JADX INFO: loaded from: classes5.dex */
final class JavascriptSandboxImpl implements ScriptSandbox {
    private static volatile JavascriptSandboxImpl INSTANCE = null;
    private static final String TAG = "JavascriptSandboxImpl";

    private JavascriptSandboxImpl() {
    }

    public static synchronized JavascriptSandboxImpl getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new JavascriptSandboxImpl();
        }
        return INSTANCE;
    }

    @Override // sdk.pendo.io.utilities.script.ScriptSandbox
    public boolean allowClassAccess(Class<?> cls) {
        if (cls.equals(PendoInternal.o().getClass()) || cls.equals(PendoInternal.class.getClassLoader().getClass())) {
            return true;
        }
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            return false;
        }
        if (canonicalName.startsWith("sdk.pendo.io.") || canonicalName.startsWith("external.sdk.pendo.io.") || canonicalName.equals("java.lang.String") || canonicalName.startsWith("org.json.")) {
            return true;
        }
        PendoLogger.d(TAG, "Trying to access an unauthorized class: '" + canonicalName + "'");
        return false;
    }

    @Override // sdk.pendo.io.utilities.script.ScriptSandbox
    public boolean allowFieldAccess(Class<?> cls, Object obj, String str) {
        return true;
    }

    @Override // sdk.pendo.io.utilities.script.ScriptSandbox
    public boolean allowMethodAccess(Class<?> cls, Object obj, String str) {
        return true;
    }

    @Override // sdk.pendo.io.utilities.script.ScriptSandbox
    public boolean allowStaticFieldAccess(Class<?> cls, String str) {
        return true;
    }

    @Override // sdk.pendo.io.utilities.script.ScriptSandbox
    public boolean allowStaticMethodAccess(Class<?> cls, String str) {
        return true;
    }
}
