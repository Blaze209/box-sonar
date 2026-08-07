package org.apache.hc.core5.http.message;

import org.apache.hc.core5.http.HeaderElement;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes5.dex */
public class BasicHeaderValueFormatter implements HeaderValueFormatter {
    public static final BasicHeaderValueFormatter INSTANCE = new BasicHeaderValueFormatter();
    private static final String SEPARATORS = " ;,:@()<>\\\"/[]?={}\t";
    private static final String UNSAFE_CHARS = "\"\\";

    @Override // org.apache.hc.core5.http.message.HeaderValueFormatter
    public void formatElements(CharArrayBuffer charArrayBuffer, HeaderElement[] headerElementArr, boolean z) {
        Args.notNull(charArrayBuffer, "Char array buffer");
        Args.notNull(headerElementArr, "Header element array");
        for (int i = 0; i < headerElementArr.length; i++) {
            if (i > 0) {
                charArrayBuffer.append(", ");
            }
            formatHeaderElement(charArrayBuffer, headerElementArr[i], z);
        }
    }

    @Override // org.apache.hc.core5.http.message.HeaderValueFormatter
    public void formatHeaderElement(CharArrayBuffer charArrayBuffer, HeaderElement headerElement, boolean z) {
        Args.notNull(charArrayBuffer, "Char array buffer");
        Args.notNull(headerElement, "Header element");
        charArrayBuffer.append(headerElement.getName());
        String value = headerElement.getValue();
        if (value != null) {
            charArrayBuffer.append('=');
            formatValue(charArrayBuffer, value, z);
        }
        int parameterCount = headerElement.getParameterCount();
        if (parameterCount > 0) {
            for (int i = 0; i < parameterCount; i++) {
                charArrayBuffer.append("; ");
                formatNameValuePair(charArrayBuffer, headerElement.getParameter(i), z);
            }
        }
    }

    @Override // org.apache.hc.core5.http.message.HeaderValueFormatter
    public void formatParameters(CharArrayBuffer charArrayBuffer, NameValuePair[] nameValuePairArr, boolean z) {
        Args.notNull(charArrayBuffer, "Char array buffer");
        Args.notNull(nameValuePairArr, "Header parameter array");
        for (int i = 0; i < nameValuePairArr.length; i++) {
            if (i > 0) {
                charArrayBuffer.append("; ");
            }
            formatNameValuePair(charArrayBuffer, nameValuePairArr[i], z);
        }
    }

    @Override // org.apache.hc.core5.http.message.HeaderValueFormatter
    public void formatNameValuePair(CharArrayBuffer charArrayBuffer, NameValuePair nameValuePair, boolean z) {
        Args.notNull(charArrayBuffer, "Char array buffer");
        Args.notNull(nameValuePair, "Name / value pair");
        charArrayBuffer.append(nameValuePair.getName());
        String value = nameValuePair.getValue();
        if (value != null) {
            charArrayBuffer.append('=');
            formatValue(charArrayBuffer, value, z);
        }
    }

    void formatValue(CharArrayBuffer charArrayBuffer, String str, boolean z) {
        if (!z) {
            for (int i = 0; i < str.length() && !z; i++) {
                z = isSeparator(str.charAt(i));
            }
        }
        if (z) {
            charArrayBuffer.append('\"');
        }
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (isUnsafe(cCharAt)) {
                charArrayBuffer.append('\\');
            }
            charArrayBuffer.append(cCharAt);
        }
        if (z) {
            charArrayBuffer.append('\"');
        }
    }

    boolean isSeparator(char c) {
        return " ;,:@()<>\\\"/[]?={}\t".indexOf(c) >= 0;
    }

    boolean isUnsafe(char c) {
        return "\"\\".indexOf(c) >= 0;
    }
}
