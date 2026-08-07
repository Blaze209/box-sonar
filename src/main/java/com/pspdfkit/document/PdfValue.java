package com.pspdfkit.document;

import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public final class PdfValue {
    private final PdfValueType type;
    private final Object value;

    public enum PdfValueType {
        BOOLEAN,
        INTEGER,
        DOUBLE,
        STRING,
        NAME,
        ARRAY,
        DICTIONARY,
        STREAM,
        NULLOBJ
    }

    public PdfValue(long j) {
        this.type = PdfValueType.INTEGER;
        this.value = Long.valueOf(j);
    }

    public List<PdfValue> getArray() {
        Object obj = this.value;
        if (obj instanceof List) {
            return (List) obj;
        }
        return null;
    }

    public boolean getBoolean() {
        Object obj = this.value;
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    public Map<String, PdfValue> getDictionary() {
        Object obj = this.value;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    public double getDouble() {
        Object obj = this.value;
        if (obj instanceof Double) {
            return ((Double) obj).doubleValue();
        }
        return 0.0d;
    }

    public long getLong() {
        Object obj = this.value;
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        return 0L;
    }

    public String getString() {
        Object obj = this.value;
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public PdfValueType getType() {
        return this.type;
    }

    public String toString() {
        return "PdfValue{type=" + this.type + ", value=" + this.value + AbstractJsonLexerKt.END_OBJ;
    }

    public PdfValue(double d) {
        this.type = PdfValueType.DOUBLE;
        this.value = Double.valueOf(d);
    }

    public PdfValue(boolean z) {
        this.type = PdfValueType.BOOLEAN;
        this.value = Boolean.valueOf(z);
    }

    public PdfValue(String str) {
        if (str != null) {
            this.type = PdfValueType.STRING;
            this.value = str;
            return;
        }
        throw new IllegalArgumentException("String constructor shouldn't be null - pass null instead of whole PdfValue!");
    }

    public PdfValue(List<PdfValue> list) {
        if (list != null) {
            this.type = PdfValueType.ARRAY;
            this.value = list;
            return;
        }
        throw new IllegalArgumentException("List constructor shouldn't be null - pass null instead of whole PdfValue!");
    }

    public PdfValue(Map<String, PdfValue> map) {
        if (map != null) {
            this.type = PdfValueType.DICTIONARY;
            this.value = map;
            return;
        }
        throw new IllegalArgumentException("Map constructor shouldn't be null - pass null instead of whole PdfValue!");
    }

    public PdfValue() {
        this.type = PdfValueType.NULLOBJ;
        this.value = null;
    }
}
