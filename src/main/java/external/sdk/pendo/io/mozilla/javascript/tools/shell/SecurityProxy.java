package external.sdk.pendo.io.mozilla.javascript.tools.shell;

import external.sdk.pendo.io.mozilla.javascript.Context;
import external.sdk.pendo.io.mozilla.javascript.Scriptable;
import external.sdk.pendo.io.mozilla.javascript.SecurityController;

/* JADX INFO: loaded from: classes4.dex */
public abstract class SecurityProxy extends SecurityController {
    protected abstract void callProcessFileSecure(Context context, Scriptable scriptable, String str);
}
