package org.apache.hc.core5.http.message;

import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes5.dex */
public class LazyLaxLineParser extends BasicLineParser {
    public static final LazyLaxLineParser INSTANCE = new LazyLaxLineParser();

    @Override // org.apache.hc.core5.http.message.BasicLineParser, org.apache.hc.core5.http.message.LineParser
    public Header parseHeader(CharArrayBuffer charArrayBuffer) throws ParseException {
        Args.notNull(charArrayBuffer, "Char array buffer");
        return new BufferedHeader(charArrayBuffer, false);
    }
}
