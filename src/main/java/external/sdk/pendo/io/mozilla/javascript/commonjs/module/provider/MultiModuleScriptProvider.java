package external.sdk.pendo.io.mozilla.javascript.commonjs.module.provider;

import external.sdk.pendo.io.mozilla.javascript.Context;
import external.sdk.pendo.io.mozilla.javascript.Scriptable;
import external.sdk.pendo.io.mozilla.javascript.commonjs.module.ModuleScript;
import external.sdk.pendo.io.mozilla.javascript.commonjs.module.ModuleScriptProvider;
import java.net.URI;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes4.dex */
public class MultiModuleScriptProvider implements ModuleScriptProvider {
    private final ModuleScriptProvider[] providers;

    public MultiModuleScriptProvider(Iterable<? extends ModuleScriptProvider> iterable) {
        LinkedList linkedList = new LinkedList();
        Iterator<? extends ModuleScriptProvider> it = iterable.iterator();
        while (it.hasNext()) {
            linkedList.add(it.next());
        }
        this.providers = (ModuleScriptProvider[]) linkedList.toArray(new ModuleScriptProvider[linkedList.size()]);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.commonjs.module.ModuleScriptProvider
    public ModuleScript getModuleScript(Context context, String str, URI uri, URI uri2, Scriptable scriptable) {
        ModuleScriptProvider[] moduleScriptProviderArr = this.providers;
        int length = moduleScriptProviderArr.length;
        int i = 0;
        while (i < length) {
            Context context2 = context;
            String str2 = str;
            URI uri3 = uri;
            URI uri4 = uri2;
            Scriptable scriptable2 = scriptable;
            ModuleScript moduleScript = moduleScriptProviderArr[i].getModuleScript(context2, str2, uri3, uri4, scriptable2);
            if (moduleScript != null) {
                return moduleScript;
            }
            i++;
            context = context2;
            str = str2;
            uri = uri3;
            uri2 = uri4;
            scriptable = scriptable2;
        }
        return null;
    }
}
