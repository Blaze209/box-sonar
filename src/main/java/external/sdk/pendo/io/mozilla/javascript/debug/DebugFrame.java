package external.sdk.pendo.io.mozilla.javascript.debug;

import external.sdk.pendo.io.mozilla.javascript.Context;
import external.sdk.pendo.io.mozilla.javascript.Scriptable;

/* JADX INFO: loaded from: classes4.dex */
public interface DebugFrame {
    void onDebuggerStatement(Context context);

    void onEnter(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr);

    void onExceptionThrown(Context context, Throwable th);

    void onExit(Context context, boolean z, Object obj);

    void onLineChange(Context context, int i);
}
