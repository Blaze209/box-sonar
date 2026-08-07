package org.apache.hc.core5.http.message;

import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes5.dex */
public interface LineParser {
    Header parseHeader(CharArrayBuffer charArrayBuffer) throws ParseException;

    RequestLine parseRequestLine(CharArrayBuffer charArrayBuffer) throws ParseException;

    StatusLine parseStatusLine(CharArrayBuffer charArrayBuffer) throws ParseException;
}
