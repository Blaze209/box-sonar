package external.sdk.pendo.io.mozilla.javascript.commonjs.module.provider;

import external.sdk.pendo.io.mozilla.javascript.Context;
import external.sdk.pendo.io.mozilla.javascript.Scriptable;
import external.sdk.pendo.io.mozilla.javascript.commonjs.module.ModuleScript;
import external.sdk.pendo.io.mozilla.javascript.commonjs.module.ModuleScriptProvider;
import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.net.URI;

/* JADX INFO: loaded from: classes4.dex */
public abstract class CachingModuleScriptProviderBase implements ModuleScriptProvider, Serializable {
    private static final int loadConcurrencyLevel = Runtime.getRuntime().availableProcessors() * 8;
    private static final int loadLockCount;
    private static final int loadLockMask;
    private static final int loadLockShift;
    private static final long serialVersionUID = -1;
    private final Object[] loadLocks = new Object[loadLockCount];
    private final ModuleSourceProvider moduleSourceProvider;

    public static class CachedModuleScript {
        private final ModuleScript moduleScript;
        private final Object validator;

        public CachedModuleScript(ModuleScript moduleScript, Object obj) {
            this.moduleScript = moduleScript;
            this.validator = obj;
        }

        ModuleScript getModule() {
            return this.moduleScript;
        }

        Object getValidator() {
            return this.validator;
        }
    }

    static {
        int i = 0;
        int i2 = 1;
        while (i2 < loadConcurrencyLevel) {
            i++;
            i2 <<= 1;
        }
        loadLockShift = 32 - i;
        loadLockMask = i2 - 1;
        loadLockCount = i2;
    }

    protected CachingModuleScriptProviderBase(ModuleSourceProvider moduleSourceProvider) {
        int i = 0;
        while (true) {
            Object[] objArr = this.loadLocks;
            if (i >= objArr.length) {
                this.moduleSourceProvider = moduleSourceProvider;
                return;
            } else {
                objArr[i] = new Object();
                i++;
            }
        }
    }

    private static boolean equal(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    protected static int getConcurrencyLevel() {
        return loadLockCount;
    }

    private static Object getValidator(CachedModuleScript cachedModuleScript) {
        if (cachedModuleScript == null) {
            return null;
        }
        return cachedModuleScript.getValidator();
    }

    protected abstract CachedModuleScript getLoadedModule(String str);

    @Override // external.sdk.pendo.io.mozilla.javascript.commonjs.module.ModuleScriptProvider
    public ModuleScript getModuleScript(Context context, String str, URI uri, URI uri2, Scriptable scriptable) throws IOException {
        CachedModuleScript loadedModule = getLoadedModule(str);
        Object validator = getValidator(loadedModule);
        ModuleSource moduleSourceLoadSource = uri == null ? this.moduleSourceProvider.loadSource(str, scriptable, validator) : this.moduleSourceProvider.loadSource(uri, uri2, validator);
        if (moduleSourceLoadSource == ModuleSourceProvider.NOT_MODIFIED) {
            return loadedModule.getModule();
        }
        if (moduleSourceLoadSource == null) {
            return null;
        }
        Reader reader = moduleSourceLoadSource.getReader();
        try {
            synchronized (this.loadLocks[(str.hashCode() >>> loadLockShift) & loadLockMask]) {
                CachedModuleScript loadedModule2 = getLoadedModule(str);
                if (loadedModule2 != null && !equal(validator, getValidator(loadedModule2))) {
                    ModuleScript module = loadedModule2.getModule();
                    if (reader != null) {
                        reader.close();
                    }
                    return module;
                }
                URI uri3 = moduleSourceLoadSource.getUri();
                ModuleScript moduleScript = new ModuleScript(context.compileReader(reader, uri3.toString(), 1, moduleSourceLoadSource.getSecurityDomain()), uri3, moduleSourceLoadSource.getBase());
                putLoadedModule(str, moduleScript, moduleSourceLoadSource.getValidator());
                if (reader != null) {
                    reader.close();
                }
                return moduleScript;
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    protected abstract void putLoadedModule(String str, ModuleScript moduleScript, Object obj);
}
