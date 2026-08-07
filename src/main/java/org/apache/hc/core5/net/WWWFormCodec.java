package org.apache.hc.core5.net;

import java.nio.charset.Charset;
import java.util.List;
import org.apache.hc.core5.http.NameValuePair;

/* JADX INFO: loaded from: classes5.dex */
public class WWWFormCodec {
    public static List<NameValuePair> parse(CharSequence charSequence, Charset charset) {
        return URIBuilder.parseQuery(charSequence, charset, true);
    }

    public static void format(StringBuilder sb, Iterable<? extends NameValuePair> iterable, Charset charset) {
        URIBuilder.formatQuery(sb, iterable, charset, true);
    }

    public static String format(Iterable<? extends NameValuePair> iterable, Charset charset) {
        StringBuilder sb = new StringBuilder();
        URIBuilder.formatQuery(sb, iterable, charset, true);
        return sb.toString();
    }
}
