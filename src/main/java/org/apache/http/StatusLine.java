package org.apache.http;

/* JADX INFO: loaded from: classes5.dex */
public interface StatusLine {
    ProtocolVersion getProtocolVersion();

    String getReasonPhrase();

    int getStatusCode();
}
