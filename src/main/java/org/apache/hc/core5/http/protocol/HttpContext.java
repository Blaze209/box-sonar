package org.apache.hc.core5.http.protocol;

import org.apache.hc.core5.http.ProtocolVersion;

/* JADX INFO: loaded from: classes5.dex */
public interface HttpContext {
    public static final String RESERVED_PREFIX = "http.";

    Object getAttribute(String str);

    ProtocolVersion getProtocolVersion();

    Object removeAttribute(String str);

    Object setAttribute(String str, Object obj);

    void setProtocolVersion(ProtocolVersion protocolVersion);
}
