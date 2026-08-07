package sdk.pendo.io.o0;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
public class c extends HashMap implements Map, b, d {
    public static String a(String str) {
        return e.a(str);
    }

    @Override // java.util.AbstractMap
    public String toString() {
        return a();
    }

    @Override // sdk.pendo.io.o0.b
    public String a() {
        return a(this);
    }

    public static String a(Map map) {
        StringWriter stringWriter = new StringWriter();
        try {
            a(map, stringWriter);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // sdk.pendo.io.o0.d
    public void a(Writer writer) {
        a(this, writer);
    }

    public static void a(Map map, Writer writer) {
        if (map == null) {
            writer.write(AbstractJsonLexerKt.NULL);
            return;
        }
        writer.write(123);
        boolean z = true;
        for (Map.Entry entry : map.entrySet()) {
            if (z) {
                z = false;
            } else {
                writer.write(44);
            }
            writer.write(34);
            writer.write(a(String.valueOf(entry.getKey())));
            writer.write(34);
            writer.write(58);
            e.a(entry.getValue(), writer);
        }
        writer.write(125);
    }
}
