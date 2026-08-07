package org.tinylog;

import java.util.Map;
import org.tinylog.provider.ContextProvider;
import org.tinylog.provider.ProviderRegistry;

/* JADX INFO: loaded from: classes5.dex */
public final class ThreadContext {
    private static final ContextProvider provider = ProviderRegistry.getLoggingProvider().getContextProvider();

    private ThreadContext() {
    }

    public static Map<String, String> getMapping() {
        return provider.getMapping();
    }

    public static String get(String str) {
        return provider.get(str);
    }

    public static void put(String str, Object obj) {
        provider.put(str, obj);
    }

    public static void remove(String str) {
        provider.remove(str);
    }

    public static void clear() {
        provider.clear();
    }
}
