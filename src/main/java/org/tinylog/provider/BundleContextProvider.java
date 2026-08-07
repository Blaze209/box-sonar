package org.tinylog.provider;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class BundleContextProvider implements ContextProvider {
    private final ContextProvider[] providers;

    BundleContextProvider(Collection<ContextProvider> collection) {
        this.providers = (ContextProvider[]) collection.toArray(new ContextProvider[0]);
    }

    @Override // org.tinylog.provider.ContextProvider
    public Map<String, String> getMapping() {
        HashMap map = new HashMap();
        int i = 0;
        while (true) {
            ContextProvider[] contextProviderArr = this.providers;
            if (i >= contextProviderArr.length) {
                return map;
            }
            map.putAll(contextProviderArr[i].getMapping());
            i++;
        }
    }

    @Override // org.tinylog.provider.ContextProvider
    public String get(String str) {
        int i = 0;
        while (true) {
            ContextProvider[] contextProviderArr = this.providers;
            if (i >= contextProviderArr.length) {
                return null;
            }
            String str2 = contextProviderArr[i].get(str);
            if (str2 != null) {
                return str2;
            }
            i++;
        }
    }

    @Override // org.tinylog.provider.ContextProvider
    public void put(String str, Object obj) {
        int i = 0;
        while (true) {
            ContextProvider[] contextProviderArr = this.providers;
            if (i >= contextProviderArr.length) {
                return;
            }
            contextProviderArr[i].put(str, obj);
            i++;
        }
    }

    @Override // org.tinylog.provider.ContextProvider
    public void remove(String str) {
        int i = 0;
        while (true) {
            ContextProvider[] contextProviderArr = this.providers;
            if (i >= contextProviderArr.length) {
                return;
            }
            contextProviderArr[i].remove(str);
            i++;
        }
    }

    @Override // org.tinylog.provider.ContextProvider
    public void clear() {
        int i = 0;
        while (true) {
            ContextProvider[] contextProviderArr = this.providers;
            if (i >= contextProviderArr.length) {
                return;
            }
            contextProviderArr[i].clear();
            i++;
        }
    }
}
