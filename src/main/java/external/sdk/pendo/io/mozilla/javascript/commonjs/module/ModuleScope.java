package external.sdk.pendo.io.mozilla.javascript.commonjs.module;

import external.sdk.pendo.io.mozilla.javascript.Scriptable;
import external.sdk.pendo.io.mozilla.javascript.TopLevel;
import java.net.URI;

/* JADX INFO: loaded from: classes4.dex */
public class ModuleScope extends TopLevel {
    private static final long serialVersionUID = 1;
    private final URI base;
    private final URI uri;

    public ModuleScope(Scriptable scriptable, URI uri, URI uri2) {
        this.uri = uri;
        this.base = uri2;
        setPrototype(scriptable);
        cacheBuiltins(scriptable, false);
    }

    public URI getBase() {
        return this.base;
    }

    public URI getUri() {
        return this.uri;
    }
}
