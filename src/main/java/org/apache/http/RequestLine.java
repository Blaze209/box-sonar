package org.apache.http;

/* JADX INFO: loaded from: classes5.dex */
public interface RequestLine {
    String getMethod();

    ProtocolVersion getProtocolVersion();

    String getUri();
}
