package sdk.pendo.io.utilities.script;

/* JADX INFO: loaded from: classes5.dex */
interface ScriptSandbox {
    boolean allowClassAccess(Class<?> cls);

    boolean allowFieldAccess(Class<?> cls, Object obj, String str);

    boolean allowMethodAccess(Class<?> cls, Object obj, String str);

    boolean allowStaticFieldAccess(Class<?> cls, String str);

    boolean allowStaticMethodAccess(Class<?> cls, String str);
}
