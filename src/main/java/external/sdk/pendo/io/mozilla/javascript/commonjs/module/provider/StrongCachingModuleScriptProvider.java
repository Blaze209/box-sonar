package external.sdk.pendo.io.mozilla.javascript.commonjs.module.provider;

import external.sdk.pendo.io.mozilla.javascript.commonjs.module.ModuleScript;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public class StrongCachingModuleScriptProvider extends CachingModuleScriptProviderBase {
    private static final long serialVersionUID = 1;
    private final Map<String, CachingModuleScriptProviderBase.CachedModuleScript> modules;

    public StrongCachingModuleScriptProvider(ModuleSourceProvider moduleSourceProvider) {
        super(moduleSourceProvider);
        this.modules = new ConcurrentHashMap(16, 0.75f, CachingModuleScriptProviderBase.getConcurrencyLevel());
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.commonjs.module.provider.CachingModuleScriptProviderBase
    protected CachingModuleScriptProviderBase.CachedModuleScript getLoadedModule(String str) {
        return this.modules.get(str);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.commonjs.module.provider.CachingModuleScriptProviderBase
    protected void putLoadedModule(String str, ModuleScript moduleScript, Object obj) {
        this.modules.put(str, new CachingModuleScriptProviderBase.CachedModuleScript(moduleScript, obj));
    }
}
