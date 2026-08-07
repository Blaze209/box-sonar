package com.amplitude.api;

/* JADX INFO: loaded from: classes9.dex */
public interface Middleware {
    void run(MiddlewarePayload middlewarePayload, MiddlewareNext middlewareNext);
}
