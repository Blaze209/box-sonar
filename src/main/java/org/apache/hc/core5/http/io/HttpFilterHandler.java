package org.apache.hc.core5.http.io;

import java.io.IOException;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.protocol.HttpContext;

/* JADX INFO: loaded from: classes5.dex */
public interface HttpFilterHandler {
    void handle(ClassicHttpRequest classicHttpRequest, HttpFilterChain.ResponseTrigger responseTrigger, HttpContext httpContext, HttpFilterChain httpFilterChain) throws HttpException, IOException;
}
