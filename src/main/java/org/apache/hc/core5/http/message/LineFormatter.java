package org.apache.hc.core5.http.message;

import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes5.dex */
public interface LineFormatter {
    void formatHeader(CharArrayBuffer charArrayBuffer, Header header);

    void formatRequestLine(CharArrayBuffer charArrayBuffer, RequestLine requestLine);

    void formatStatusLine(CharArrayBuffer charArrayBuffer, StatusLine statusLine);
}
