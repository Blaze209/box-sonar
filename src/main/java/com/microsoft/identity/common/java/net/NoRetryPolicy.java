package com.microsoft.identity.common.java.net;

import com.microsoft.identity.common.java.exception.ClientException;
import java.util.concurrent.Callable;
import net.jcip.annotations.Immutable;
import net.jcip.annotations.ThreadSafe;

/* JADX INFO: loaded from: classes14.dex */
@Immutable
@ThreadSafe
public class NoRetryPolicy implements IRetryPolicy<HttpResponse> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.identity.common.java.net.IRetryPolicy
    public HttpResponse attempt(Callable<HttpResponse> callable) throws ClientException {
        return callable.call();
    }
}
