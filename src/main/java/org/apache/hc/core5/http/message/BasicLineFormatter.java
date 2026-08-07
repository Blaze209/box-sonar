package org.apache.hc.core5.http.message;

import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.ProtocolVersion;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes5.dex */
public class BasicLineFormatter implements LineFormatter {
    public static final BasicLineFormatter INSTANCE = new BasicLineFormatter();

    void formatProtocolVersion(CharArrayBuffer charArrayBuffer, ProtocolVersion protocolVersion) {
        charArrayBuffer.append(protocolVersion.format());
    }

    @Override // org.apache.hc.core5.http.message.LineFormatter
    public void formatRequestLine(CharArrayBuffer charArrayBuffer, RequestLine requestLine) {
        Args.notNull(charArrayBuffer, "Char array buffer");
        Args.notNull(requestLine, "Request line");
        charArrayBuffer.append(requestLine.getMethod());
        charArrayBuffer.append(' ');
        charArrayBuffer.append(requestLine.getUri());
        charArrayBuffer.append(' ');
        formatProtocolVersion(charArrayBuffer, requestLine.getProtocolVersion());
    }

    @Override // org.apache.hc.core5.http.message.LineFormatter
    public void formatStatusLine(CharArrayBuffer charArrayBuffer, StatusLine statusLine) {
        Args.notNull(charArrayBuffer, "Char array buffer");
        Args.notNull(statusLine, "Status line");
        formatProtocolVersion(charArrayBuffer, statusLine.getProtocolVersion());
        charArrayBuffer.append(' ');
        charArrayBuffer.append(Integer.toString(statusLine.getStatusCode()));
        charArrayBuffer.append(' ');
        String reasonPhrase = statusLine.getReasonPhrase();
        if (reasonPhrase != null) {
            charArrayBuffer.append(reasonPhrase);
        }
    }

    @Override // org.apache.hc.core5.http.message.LineFormatter
    public void formatHeader(CharArrayBuffer charArrayBuffer, Header header) {
        Args.notNull(charArrayBuffer, "Char array buffer");
        Args.notNull(header, "Header");
        charArrayBuffer.append(header.getName());
        charArrayBuffer.append(": ");
        String value = header.getValue();
        if (value != null) {
            charArrayBuffer.ensureCapacity(charArrayBuffer.length() + value.length());
            for (int i = 0; i < value.length(); i++) {
                char cCharAt = value.charAt(i);
                if (cCharAt == '\r' || cCharAt == '\n' || cCharAt == '\f' || cCharAt == 11) {
                    cCharAt = ' ';
                }
                charArrayBuffer.append(cCharAt);
            }
        }
    }
}
