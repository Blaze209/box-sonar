package org.apache.hc.core5.http.ssl;

import java.util.ArrayList;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.ProtocolVersion;
import org.apache.hc.core5.http.ProtocolVersionParser;
import org.apache.hc.core5.util.Tokenizer;

/* JADX INFO: loaded from: classes5.dex */
public enum TLS {
    V_1_0("TLSv1", new ProtocolVersion("TLS", 1, 0)),
    V_1_1("TLSv1.1", new ProtocolVersion("TLS", 1, 1)),
    V_1_2("TLSv1.2", new ProtocolVersion("TLS", 1, 2)),
    V_1_3("TLSv1.3", new ProtocolVersion("TLS", 1, 3));

    public final String id;
    public final ProtocolVersion version;

    TLS(String str, ProtocolVersion protocolVersion) {
        this.id = str;
        this.version = protocolVersion;
    }

    public boolean isSame(ProtocolVersion protocolVersion) {
        return this.version.equals(protocolVersion);
    }

    public boolean isComparable(ProtocolVersion protocolVersion) {
        return this.version.isComparable(protocolVersion);
    }

    public String getId() {
        return this.id;
    }

    public ProtocolVersion getVersion() {
        return this.version;
    }

    public boolean greaterEquals(ProtocolVersion protocolVersion) {
        return this.version.greaterEquals(protocolVersion);
    }

    public boolean lessEquals(ProtocolVersion protocolVersion) {
        return this.version.lessEquals(protocolVersion);
    }

    public static ProtocolVersion parse(CharSequence charSequence, Tokenizer.Cursor cursor, Tokenizer.Delimiter delimiter) throws ParseException {
        int lowerBound = cursor.getLowerBound();
        int upperBound = cursor.getUpperBound();
        int pos = cursor.getPos();
        int i = pos + 4;
        if (i > cursor.getUpperBound()) {
            throw new ParseException("Invalid TLS protocol version", charSequence, lowerBound, upperBound, pos);
        }
        if (charSequence.charAt(pos) != 'T' || charSequence.charAt(pos + 1) != 'L' || charSequence.charAt(pos + 2) != 'S' || charSequence.charAt(pos + 3) != 'v') {
            throw new ParseException("Invalid TLS protocol version", charSequence, lowerBound, upperBound, pos);
        }
        cursor.updatePos(i);
        if (cursor.atEnd()) {
            throw new ParseException("Invalid TLS version", charSequence, lowerBound, upperBound, i);
        }
        return ProtocolVersionParser.INSTANCE.parse("TLS", null, charSequence, cursor, delimiter);
    }

    public static ProtocolVersion parse(String str) throws ParseException {
        if (str == null) {
            return null;
        }
        Tokenizer.Cursor cursor = new Tokenizer.Cursor(0, str.length());
        ProtocolVersion protocolVersion = parse(str, cursor, null);
        Tokenizer.INSTANCE.skipWhiteSpace(str, cursor);
        if (cursor.atEnd()) {
            return protocolVersion;
        }
        throw new ParseException("Invalid TLS protocol version; trailing content");
    }

    public static String[] excludeWeak(String... strArr) {
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (isSecure(str)) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(V_1_2.id);
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static boolean isSecure(String str) {
        return (str.startsWith("SSL") || str.equals(V_1_0.id) || str.equals(V_1_1.id)) ? false : true;
    }
}
