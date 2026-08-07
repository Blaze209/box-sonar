package org.apache.hc.core5.net;

import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.Tokenizer;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class URLEncodedUtils {
    private static final char QP_SEP_A = '&';
    private static final char QP_SEP_S = ';';
    private static final BitSet URL_ENCODER = new BitSet(256);

    public static List<NameValuePair> parse(URI uri, Charset charset) {
        Args.notNull(uri, "URI");
        String rawQuery = uri.getRawQuery();
        if (rawQuery != null && !rawQuery.isEmpty()) {
            return parse(rawQuery, charset);
        }
        return new ArrayList(0);
    }

    public static List<NameValuePair> parse(CharSequence charSequence, Charset charset) {
        if (charSequence == null) {
            return new ArrayList(0);
        }
        return parse(charSequence, charset, '&', QP_SEP_S);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0065  */
    public static List<NameValuePair> parse(CharSequence charSequence, Charset charset, char... cArr) {
        String token;
        Args.notNull(charSequence, "Char sequence");
        Tokenizer tokenizer = Tokenizer.INSTANCE;
        BitSet bitSet = new BitSet();
        for (char c : cArr) {
            bitSet.set(c);
        }
        Tokenizer.Cursor cursor = new Tokenizer.Cursor(0, charSequence.length());
        ArrayList arrayList = new ArrayList();
        while (!cursor.atEnd()) {
            bitSet.set(61);
            String token2 = tokenizer.parseToken(charSequence, cursor, bitSet);
            if (cursor.atEnd()) {
                token = null;
            } else {
                char cCharAt = charSequence.charAt(cursor.getPos());
                cursor.updatePos(cursor.getPos() + 1);
                if (cCharAt == '=') {
                    bitSet.clear(61);
                    token = tokenizer.parseToken(charSequence, cursor, bitSet);
                    if (!cursor.atEnd()) {
                        cursor.updatePos(cursor.getPos() + 1);
                    }
                } else {
                    token = null;
                }
            }
            if (!token2.isEmpty()) {
                arrayList.add(new BasicNameValuePair(PercentCodec.decode(token2, charset, true), PercentCodec.decode(token, charset, true)));
            }
        }
        return arrayList;
    }

    public static List<String> parsePathSegments(CharSequence charSequence, Charset charset) {
        return URIBuilder.parsePath(charSequence, charset);
    }

    public static List<String> parsePathSegments(CharSequence charSequence) {
        return parsePathSegments(charSequence, StandardCharsets.UTF_8);
    }

    public static String formatSegments(Iterable<String> iterable, Charset charset) {
        Args.notNull(iterable, "Segments");
        StringBuilder sb = new StringBuilder();
        URIBuilder.formatPath(sb, iterable, false, charset);
        return sb.toString();
    }

    public static String formatSegments(String... strArr) {
        return formatSegments(Arrays.asList(strArr), StandardCharsets.UTF_8);
    }

    public static String format(Iterable<? extends NameValuePair> iterable, char c, Charset charset) {
        Args.notNull(iterable, "Parameters");
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (NameValuePair nameValuePair : iterable) {
            if (i > 0) {
                sb.append(c);
            }
            String name = nameValuePair.getName();
            BitSet bitSet = URL_ENCODER;
            PercentCodec.encode(sb, name, charset, bitSet, true);
            if (nameValuePair.getValue() != null) {
                sb.append('=');
                PercentCodec.encode(sb, nameValuePair.getValue(), charset, bitSet, true);
            }
            i++;
        }
        return sb.toString();
    }

    public static String format(Iterable<? extends NameValuePair> iterable, Charset charset) {
        return format(iterable, '&', charset);
    }

    static {
        for (int i = 97; i <= 122; i++) {
            URL_ENCODER.set(i);
        }
        for (int i2 = 65; i2 <= 90; i2++) {
            URL_ENCODER.set(i2);
        }
        for (int i3 = 48; i3 <= 57; i3++) {
            URL_ENCODER.set(i3);
        }
        BitSet bitSet = URL_ENCODER;
        bitSet.set(95);
        bitSet.set(45);
        bitSet.set(46);
        bitSet.set(42);
    }
}
