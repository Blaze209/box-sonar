package external.sdk.pendo.io.mozilla.javascript.commonjs.module;

import external.sdk.pendo.io.mozilla.javascript.Script;
import java.io.Serializable;
import java.net.URI;

/* JADX INFO: loaded from: classes4.dex */
public class ModuleScript implements Serializable {
    private static final long serialVersionUID = 1;
    private final URI base;
    private final Script script;
    private final URI uri;

    public ModuleScript(Script script, URI uri, URI uri2) {
        this.script = script;
        this.uri = uri;
        this.base = uri2;
    }

    public URI getBase() {
        return this.base;
    }

    public Script getScript() {
        return this.script;
    }

    public URI getUri() {
        return this.uri;
    }

    public boolean isSandboxed() {
        URI uri;
        URI uri2 = this.base;
        return (uri2 == null || (uri = this.uri) == null || uri2.relativize(uri).isAbsolute()) ? false : true;
    }
}
