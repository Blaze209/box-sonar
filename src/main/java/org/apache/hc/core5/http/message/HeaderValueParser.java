package org.apache.hc.core5.http.message;

import org.apache.hc.core5.http.HeaderElement;
import org.apache.hc.core5.http.NameValuePair;

/* JADX INFO: loaded from: classes5.dex */
public interface HeaderValueParser {
    HeaderElement[] parseElements(CharSequence charSequence, ParserCursor parserCursor);

    HeaderElement parseHeaderElement(CharSequence charSequence, ParserCursor parserCursor);

    NameValuePair parseNameValuePair(CharSequence charSequence, ParserCursor parserCursor);

    NameValuePair[] parseParameters(CharSequence charSequence, ParserCursor parserCursor);
}
