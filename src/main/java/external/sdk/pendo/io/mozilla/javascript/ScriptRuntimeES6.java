package external.sdk.pendo.io.mozilla.javascript;

/* JADX INFO: loaded from: classes4.dex */
public class ScriptRuntimeES6 {
    public static Object requireObjectCoercible(Context context, Object obj, IdFunctionObject idFunctionObject) {
        if (obj == null || Undefined.isUndefined(obj)) {
            throw ScriptRuntime.typeError2("msg.called.null.or.undefined", idFunctionObject.getTag(), idFunctionObject.getFunctionName());
        }
        return obj;
    }
}
