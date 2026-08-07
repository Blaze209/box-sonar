package org.apache.hc.core5.http;

/* JADX INFO: loaded from: classes5.dex */
public class UnsupportedHttpVersionException extends ProtocolException {
    private static final long serialVersionUID = -1348448090193107031L;

    public UnsupportedHttpVersionException() {
    }

    public UnsupportedHttpVersionException(ProtocolVersion protocolVersion) {
        super("Unsupported version: " + protocolVersion);
    }

    public UnsupportedHttpVersionException(String str) {
        super(str);
    }
}
