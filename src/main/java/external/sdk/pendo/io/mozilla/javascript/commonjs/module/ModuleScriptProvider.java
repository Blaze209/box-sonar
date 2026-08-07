package external.sdk.pendo.io.mozilla.javascript.commonjs.module;

import external.sdk.pendo.io.mozilla.javascript.Context;
import external.sdk.pendo.io.mozilla.javascript.Scriptable;
import java.net.URI;

/* JADX INFO: loaded from: classes4.dex */
public interface ModuleScriptProvider {
    ModuleScript getModuleScript(Context context, String str, URI uri, URI uri2, Scriptable scriptable);
}
