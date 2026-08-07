package external.sdk.pendo.io.mozilla.javascript.commonjs.module.provider;

import androidx.collection.SieveCacheKt;
import com.pspdfkit.analytics.Analytics;
import external.sdk.pendo.io.mozilla.javascript.ScriptRuntime;
import external.sdk.pendo.io.mozilla.javascript.Scriptable;
import external.sdk.pendo.io.mozilla.javascript.ScriptableObject;
import java.io.File;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ModuleSourceProviderBase implements ModuleSourceProvider, Serializable {
    private static final long serialVersionUID = 1;

    private static String ensureTrailingSlash(String str) {
        return str.endsWith("/") ? str : str.concat("/");
    }

    private ModuleSource loadFromPathArray(String str, Scriptable scriptable, Object obj) throws MalformedURLException {
        long uint32 = ScriptRuntime.toUint32(ScriptableObject.getProperty(scriptable, Analytics.Data.LENGTH));
        int i = uint32 > SieveCacheKt.NodeLinkMask ? Integer.MAX_VALUE : (int) uint32;
        for (int i2 = 0; i2 < i; i2++) {
            String strEnsureTrailingSlash = ensureTrailingSlash((String) ScriptableObject.getTypedProperty(scriptable, i2, String.class));
            try {
                URI uri = new URI(strEnsureTrailingSlash);
                if (!uri.isAbsolute()) {
                    uri = new File(strEnsureTrailingSlash).toURI().resolve("");
                }
                ModuleSource moduleSourceLoadFromUri = loadFromUri(uri.resolve(str), uri, obj);
                if (moduleSourceLoadFromUri != null) {
                    return moduleSourceLoadFromUri;
                }
            } catch (URISyntaxException e) {
                throw new MalformedURLException(e.getMessage());
            }
        }
        return null;
    }

    protected boolean entityNeedsRevalidation(Object obj) {
        return true;
    }

    protected ModuleSource loadFromFallbackLocations(String str, Object obj) {
        return null;
    }

    protected ModuleSource loadFromPrivilegedLocations(String str, Object obj) {
        return null;
    }

    protected abstract ModuleSource loadFromUri(URI uri, URI uri2, Object obj);

    @Override // external.sdk.pendo.io.mozilla.javascript.commonjs.module.provider.ModuleSourceProvider
    public ModuleSource loadSource(String str, Scriptable scriptable, Object obj) {
        ModuleSource moduleSourceLoadFromPathArray;
        if (!entityNeedsRevalidation(obj)) {
            return ModuleSourceProvider.NOT_MODIFIED;
        }
        ModuleSource moduleSourceLoadFromPrivilegedLocations = loadFromPrivilegedLocations(str, obj);
        if (moduleSourceLoadFromPrivilegedLocations != null) {
            return moduleSourceLoadFromPrivilegedLocations;
        }
        return (scriptable == null || (moduleSourceLoadFromPathArray = loadFromPathArray(str, scriptable, obj)) == null) ? loadFromFallbackLocations(str, obj) : moduleSourceLoadFromPathArray;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.commonjs.module.provider.ModuleSourceProvider
    public ModuleSource loadSource(URI uri, URI uri2, Object obj) {
        return loadFromUri(uri, uri2, obj);
    }
}
