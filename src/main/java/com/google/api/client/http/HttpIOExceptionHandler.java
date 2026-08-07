package com.google.api.client.http;

import java.io.IOException;

/* JADX INFO: loaded from: classes10.dex */
public interface HttpIOExceptionHandler {
    boolean handleIOException(HttpRequest httpRequest, boolean z) throws IOException;
}
