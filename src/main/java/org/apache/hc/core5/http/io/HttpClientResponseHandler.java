package org.apache.hc.core5.http.io;

import java.io.IOException;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpException;

/* JADX INFO: loaded from: classes5.dex */
@FunctionalInterface
public interface HttpClientResponseHandler<T> {
    T handleResponse(ClassicHttpResponse classicHttpResponse) throws HttpException, IOException;
}
