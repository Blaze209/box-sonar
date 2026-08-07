package com.microsoft.identity.common.internal.logging;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes14.dex */
@Deprecated
public final class DiagnosticContext extends com.microsoft.identity.common.logging.DiagnosticContext {
    private static final String TAG = "DiagnosticContext";
    private static boolean sLogDeprecationWarning = true;

    public static void setRequestContext(IRequestContext iRequestContext) {
        com.microsoft.identity.common.logging.DiagnosticContext.setRequestContext(iRequestContext);
        logDeprecationWarning();
    }

    private static void logDeprecationWarning() {
        String str = TAG + ":logDeprecationWarning";
        if (sLogDeprecationWarning) {
            sLogDeprecationWarning = false;
            com.microsoft.identity.common.logging.Logger.warn(str, "This class is deprecated. Migrate usage to: com.microsoft.identity.common.logging.DiagnosticContext");
        }
    }

    public static IRequestContext getRequestContext() {
        logDeprecationWarning();
        final com.microsoft.identity.common.java.logging.IRequestContext requestContext = com.microsoft.identity.common.java.logging.DiagnosticContext.INSTANCE.getRequestContext();
        return new IRequestContext() { // from class: com.microsoft.identity.common.internal.logging.DiagnosticContext.1
            @Override // com.microsoft.identity.common.java.logging.IRequestContext
            public String toJsonString() {
                return requestContext.toJsonString();
            }

            @Override // java.util.Map
            public int size() {
                return requestContext.size();
            }

            @Override // java.util.Map
            public boolean isEmpty() {
                return requestContext.isEmpty();
            }

            @Override // java.util.Map
            public boolean containsKey(Object obj) {
                return requestContext.containsKey(obj);
            }

            @Override // java.util.Map
            public boolean containsValue(Object obj) {
                return requestContext.containsValue(obj);
            }

            @Override // java.util.Map
            public String get(Object obj) {
                return requestContext.get(obj);
            }

            @Override // java.util.Map
            public String put(String str, String str2) {
                return requestContext.put(str, str2);
            }

            @Override // java.util.Map
            public String remove(Object obj) {
                return requestContext.remove(obj);
            }

            @Override // java.util.Map
            public void putAll(Map<? extends String, ? extends String> map) {
                requestContext.putAll(map);
            }

            @Override // java.util.Map
            public void clear() {
                requestContext.clear();
            }

            @Override // java.util.Map
            public Set<String> keySet() {
                return requestContext.keySet();
            }

            @Override // java.util.Map
            public Collection<String> values() {
                return requestContext.values();
            }

            @Override // java.util.Map
            public Set<Map.Entry<String, String>> entrySet() {
                return requestContext.entrySet();
            }
        };
    }

    public static void clear() {
        logDeprecationWarning();
        com.microsoft.identity.common.logging.DiagnosticContext.clear();
    }
}
