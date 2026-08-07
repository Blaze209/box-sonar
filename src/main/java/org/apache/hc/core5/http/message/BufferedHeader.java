package org.apache.hc.core5.http.message;

import java.io.Serializable;
import org.apache.hc.core5.http.FormattedHeader;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.CharArrayBuffer;
import org.apache.hc.core5.util.Tokenizer;

/* JADX INFO: loaded from: classes5.dex */
public class BufferedHeader implements FormattedHeader, Serializable {
    private static final long serialVersionUID = -2768352615787625448L;
    private final CharArrayBuffer buffer;
    private final String name;
    private String value;
    private final int valuePos;

    @Override // org.apache.hc.core5.http.Header
    public boolean isSensitive() {
        return false;
    }

    public static BufferedHeader create(CharArrayBuffer charArrayBuffer) {
        try {
            return new BufferedHeader(charArrayBuffer);
        } catch (ParseException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public BufferedHeader(CharArrayBuffer charArrayBuffer) throws ParseException {
        this(charArrayBuffer, true);
    }

    BufferedHeader(CharArrayBuffer charArrayBuffer, boolean z) throws ParseException {
        Args.notNull(charArrayBuffer, "Char array buffer");
        int iIndexOf = charArrayBuffer.indexOf(58);
        if (iIndexOf <= 0) {
            throw new ParseException("Invalid header", charArrayBuffer, 0, charArrayBuffer.length());
        }
        if (z) {
            int i = iIndexOf - 1;
            if (Tokenizer.isWhitespace(charArrayBuffer.charAt(i))) {
                throw new ParseException("Invalid header", charArrayBuffer, 0, charArrayBuffer.length(), i);
            }
        }
        String strSubstringTrimmed = charArrayBuffer.substringTrimmed(0, iIndexOf);
        if (strSubstringTrimmed.isEmpty()) {
            throw new ParseException("Invalid header", charArrayBuffer, 0, charArrayBuffer.length(), iIndexOf);
        }
        this.buffer = charArrayBuffer;
        this.name = strSubstringTrimmed;
        this.valuePos = iIndexOf + 1;
    }

    @Override // org.apache.hc.core5.http.NameValuePair
    public String getName() {
        return this.name;
    }

    @Override // org.apache.hc.core5.http.NameValuePair
    public String getValue() {
        if (this.value == null) {
            int i = this.valuePos;
            int length = this.buffer.length();
            while (i < this.buffer.length() && Tokenizer.isWhitespace(this.buffer.charAt(i))) {
                i++;
            }
            while (length > i && Tokenizer.isWhitespace(this.buffer.charAt(length - 1))) {
                length--;
            }
            StringBuilder sb = new StringBuilder(length - i);
            while (i < length) {
                char cCharAt = this.buffer.charAt(i);
                if (cCharAt == '\r' || cCharAt == '\n' || cCharAt == 0) {
                    sb.append(' ');
                } else {
                    sb.append(cCharAt);
                }
                i++;
            }
            this.value = sb.toString();
        }
        return this.value;
    }

    @Override // org.apache.hc.core5.http.FormattedHeader
    public int getValuePos() {
        return this.valuePos;
    }

    @Override // org.apache.hc.core5.http.FormattedHeader
    public CharArrayBuffer getBuffer() {
        return this.buffer;
    }

    public String toString() {
        return this.buffer.toString();
    }
}
