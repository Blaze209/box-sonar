package org.apache.hc.core5.http;

/* JADX INFO: loaded from: classes5.dex */
public class LengthRequiredException extends ProtocolException {
    private static final long serialVersionUID = 1049109801075840707L;

    public LengthRequiredException() {
        super("Length required");
    }

    public LengthRequiredException(String str) {
        super(str);
    }
}
