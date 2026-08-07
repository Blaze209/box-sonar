package com.eclipsesource.json;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public class JsonArray extends JsonValue implements Iterable<JsonValue> {
    private final List<JsonValue> values;

    @Override // com.eclipsesource.json.JsonValue
    public JsonArray asArray() {
        return this;
    }

    @Override // com.eclipsesource.json.JsonValue
    public boolean isArray() {
        return true;
    }

    public JsonArray() {
        this.values = new ArrayList();
    }

    public JsonArray(JsonArray jsonArray) {
        this(jsonArray, false);
    }

    private JsonArray(JsonArray jsonArray, boolean z) {
        if (jsonArray == null) {
            throw new NullPointerException("array is null");
        }
        if (z) {
            this.values = Collections.unmodifiableList(jsonArray.values);
        } else {
            this.values = new ArrayList(jsonArray.values);
        }
    }

    @Deprecated
    public static JsonArray readFrom(Reader reader) throws IOException {
        return JsonValue.readFrom(reader).asArray();
    }

    @Deprecated
    public static JsonArray readFrom(String str) {
        return JsonValue.readFrom(str).asArray();
    }

    public static JsonArray unmodifiableArray(JsonArray jsonArray) {
        return new JsonArray(jsonArray, true);
    }

    public JsonArray add(int i) {
        this.values.add(Json.value(i));
        return this;
    }

    public JsonArray add(long j) {
        this.values.add(Json.value(j));
        return this;
    }

    public JsonArray add(float f) {
        this.values.add(Json.value(f));
        return this;
    }

    public JsonArray add(double d) {
        this.values.add(Json.value(d));
        return this;
    }

    public JsonArray add(boolean z) {
        this.values.add(Json.value(z));
        return this;
    }

    public JsonArray add(String str) {
        this.values.add(Json.value(str));
        return this;
    }

    public JsonArray add(JsonValue jsonValue) {
        if (jsonValue == null) {
            throw new NullPointerException("value is null");
        }
        this.values.add(jsonValue);
        return this;
    }

    public JsonArray set(int i, int i2) {
        this.values.set(i, Json.value(i2));
        return this;
    }

    public JsonArray set(int i, long j) {
        this.values.set(i, Json.value(j));
        return this;
    }

    public JsonArray set(int i, float f) {
        this.values.set(i, Json.value(f));
        return this;
    }

    public JsonArray set(int i, double d) {
        this.values.set(i, Json.value(d));
        return this;
    }

    public JsonArray set(int i, boolean z) {
        this.values.set(i, Json.value(z));
        return this;
    }

    public JsonArray set(int i, String str) {
        this.values.set(i, Json.value(str));
        return this;
    }

    public JsonArray set(int i, JsonValue jsonValue) {
        if (jsonValue == null) {
            throw new NullPointerException("value is null");
        }
        this.values.set(i, jsonValue);
        return this;
    }

    public JsonArray remove(int i) {
        this.values.remove(i);
        return this;
    }

    public int size() {
        return this.values.size();
    }

    public boolean isEmpty() {
        return this.values.isEmpty();
    }

    public JsonValue get(int i) {
        return this.values.get(i);
    }

    public List<JsonValue> values() {
        return Collections.unmodifiableList(this.values);
    }

    @Override // java.lang.Iterable
    public Iterator<JsonValue> iterator() {
        final Iterator<JsonValue> it = this.values.iterator();
        return new Iterator<JsonValue>() { // from class: com.eclipsesource.json.JsonArray.1
            @Override // java.util.Iterator
            public boolean hasNext() {
                return it.hasNext();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.Iterator
            public JsonValue next() {
                return (JsonValue) it.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // com.eclipsesource.json.JsonValue
    void write(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeArrayOpen();
        Iterator<JsonValue> it = iterator();
        if (it.hasNext()) {
            it.next().write(jsonWriter);
            while (it.hasNext()) {
                jsonWriter.writeArraySeparator();
                it.next().write(jsonWriter);
            }
        }
        jsonWriter.writeArrayClose();
    }

    @Override // com.eclipsesource.json.JsonValue
    public int hashCode() {
        return this.values.hashCode();
    }

    @Override // com.eclipsesource.json.JsonValue
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return this.values.equals(((JsonArray) obj).values);
        }
        return false;
    }
}
