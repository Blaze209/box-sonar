package com.microsoft.identity.common.java.logging;

import java.util.UUID;

/* JADX INFO: loaded from: classes14.dex */
public enum DiagnosticContext {
    INSTANCE;

    public static final String CORRELATION_ID = "correlation_id";
    public static final String THREAD_ID = "thread_id";
    private static final String UNSET = "UNSET";
    private final transient ThreadLocal<IRequestContext> REQUEST_CONTEXT_THREAD_LOCAL = new ThreadLocal<IRequestContext>() { // from class: com.microsoft.identity.common.java.logging.DiagnosticContext.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: initialValue, reason: merged with bridge method [inline-methods] */
        public IRequestContext initialValue2() {
            RequestContext requestContext = new RequestContext();
            requestContext.put(DiagnosticContext.THREAD_ID, String.valueOf(Thread.currentThread().getId()));
            requestContext.put("correlation_id", "UNSET");
            return requestContext;
        }
    };

    DiagnosticContext() {
    }

    public void setRequestContext(IRequestContext iRequestContext) {
        if (iRequestContext == null) {
            clear();
        } else {
            iRequestContext.put(THREAD_ID, String.valueOf(Thread.currentThread().getId()));
            this.REQUEST_CONTEXT_THREAD_LOCAL.set(iRequestContext);
        }
    }

    public IRequestContext getRequestContext() {
        return this.REQUEST_CONTEXT_THREAD_LOCAL.get();
    }

    public String getThreadCorrelationId() {
        String str = getRequestContext().get("correlation_id");
        return (str == null || str.equals("UNSET")) ? UUID.randomUUID().toString() : str;
    }

    public void clear() {
        this.REQUEST_CONTEXT_THREAD_LOCAL.remove();
    }
}
