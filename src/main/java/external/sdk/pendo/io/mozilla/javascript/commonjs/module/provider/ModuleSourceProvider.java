package external.sdk.pendo.io.mozilla.javascript.commonjs.module.provider;

import external.sdk.pendo.io.mozilla.javascript.Scriptable;
import java.net.URI;

/* JADX INFO: loaded from: classes4.dex */
public interface ModuleSourceProvider {
    public static final ModuleSource NOT_MODIFIED = new ModuleSource(null, null, null, null, null);

    ModuleSource loadSource(String str, Scriptable scriptable, Object obj);

    ModuleSource loadSource(URI uri, URI uri2, Object obj);
}
