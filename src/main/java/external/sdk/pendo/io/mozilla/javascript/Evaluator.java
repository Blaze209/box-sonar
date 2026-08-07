package external.sdk.pendo.io.mozilla.javascript;

import external.sdk.pendo.io.mozilla.javascript.ast.ScriptNode;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface Evaluator {
    void captureStackInfo(RhinoException rhinoException);

    Object compile(CompilerEnvirons compilerEnvirons, ScriptNode scriptNode, String str, boolean z);

    Function createFunctionObject(Context context, Scriptable scriptable, Object obj, Object obj2);

    Script createScriptObject(Object obj, Object obj2);

    String getPatchedStack(RhinoException rhinoException, String str);

    List<String> getScriptStack(RhinoException rhinoException);

    String getSourcePositionFromStack(Context context, int[] iArr);

    void setEvalScriptFlag(Script script);
}
