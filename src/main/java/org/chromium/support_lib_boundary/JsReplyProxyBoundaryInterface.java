package org.chromium.support_lib_boundary;

import java.lang.reflect.InvocationHandler;
import org.jspecify.annotations.NullMarked;

/* JADX INFO: loaded from: classes5.dex */
@NullMarked
public interface JsReplyProxyBoundaryInterface extends IsomorphicObjectBoundaryInterface {
    void executeJavaScript(String str, InvocationHandler invocationHandler);

    void postMessage(String str);

    void postMessageWithPayload(InvocationHandler invocationHandler);
}
