package io.split.android.client.utils;

import io.split.android.client.utils.logger.Logger;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class StringHelper {
    public static Charset defaultCharset() {
        Charset charsetDefaultCharset = Charset.defaultCharset();
        try {
            return Charset.forName("UTF-8");
        } catch (Exception unused) {
            Logger.e("UTF-8 charset not available");
            return charsetDefaultCharset;
        }
    }

    public static String stringFromBytes(byte[] bytes) {
        return new String(bytes, 0, bytes.length, defaultCharset());
    }

    public String join(String connector, List<String> list) {
        if (list == null || list.size() == 0 || connector == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            sb.append(connector).append(list.get(i));
        }
        return sb.toString();
    }

    public String join(String connector, Iterable<String> values) {
        if (values == null || connector == null) {
            return "";
        }
        Iterator<String> it = values.iterator();
        if (!it.hasNext()) {
            return "";
        }
        StringBuilder sb = new StringBuilder(it.next().toString());
        while (it.hasNext()) {
            sb.append(connector).append(it.next().toString());
        }
        return sb.toString();
    }
}
