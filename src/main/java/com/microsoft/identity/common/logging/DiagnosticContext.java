package com.microsoft.identity.common.logging;

import com.microsoft.identity.common.java.logging.IRequestContext;

/* JADX INFO: loaded from: classes14.dex */
public class DiagnosticContext {
    public static void setRequestContext(IRequestContext iRequestContext) {
        com.microsoft.identity.common.java.logging.DiagnosticContext.INSTANCE.setRequestContext(iRequestContext);
    }

    public static IRequestContext getRequestContext() {
        return com.microsoft.identity.common.java.logging.DiagnosticContext.INSTANCE.getRequestContext();
    }

    public static void clear() {
        com.microsoft.identity.common.java.logging.DiagnosticContext.INSTANCE.clear();
    }
}
