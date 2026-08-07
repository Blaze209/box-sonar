package com.eclipsesource.json;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public class JsonObject extends JsonValue implements Iterable<Member> {
    private final List<String> names;
    private transient HashIndexTable table;
    private final List<JsonValue> values;

    @Override // com.eclipsesource.json.JsonValue
    public JsonObject asObject() {
        return this;
    }

    @Override // com.eclipsesource.json.JsonValue
    public boolean isObject() {
        return true;
    }

    public JsonObject() {
        this.names = new ArrayList();
        this.values = new ArrayList();
        this.table = new HashIndexTable();
    }

    public JsonObject(JsonObject jsonObject) {
        this(jsonObject, false);
    }

    private JsonObject(JsonObject jsonObject, boolean z) {
        if (jsonObject == null) {
            throw new NullPointerException("object is null");
        }
        if (z) {
            this.names = Collections.unmodifiableList(jsonObject.names);
            this.values = Collections.unmodifiableList(jsonObject.values);
        } else {
            this.names = new ArrayList(jsonObject.names);
            this.values = new ArrayList(jsonObject.values);
        }
        this.table = new HashIndexTable();
        updateHashIndex();
    }

    @Deprecated
    public static JsonObject readFrom(Reader reader) throws IOException {
        return JsonValue.readFrom(reader).asObject();
    }

    @Deprecated
    public static JsonObject readFrom(String str) {
        return JsonValue.readFrom(str).asObject();
    }

    public static JsonObject unmodifiableObject(JsonObject jsonObject) {
        return new JsonObject(jsonObject, true);
    }

    public JsonObject add(String str, int i) {
        add(str, Json.value(i));
        return this;
    }

    public JsonObject add(String str, long j) {
        add(str, Json.value(j));
        return this;
    }

    public JsonObject add(String str, float f) {
        add(str, Json.value(f));
        return this;
    }

    public JsonObject add(String str, double d) {
        add(str, Json.value(d));
        return this;
    }

    public JsonObject add(String str, boolean z) {
        add(str, Json.value(z));
        return this;
    }

    public JsonObject add(String str, String str2) {
        add(str, Json.value(str2));
        return this;
    }

    public JsonObject add(String str, JsonValue jsonValue) {
        if (str == null) {
            throw new NullPointerException("name is null");
        }
        if (jsonValue == null) {
            throw new NullPointerException("value is null");
        }
        this.table.add(str, this.names.size());
        this.names.add(str);
        this.values.add(jsonValue);
        return this;
    }

    public JsonObject set(String str, int i) {
        set(str, Json.value(i));
        return this;
    }

    public JsonObject set(String str, long j) {
        set(str, Json.value(j));
        return this;
    }

    public JsonObject set(String str, float f) {
        set(str, Json.value(f));
        return this;
    }

    public JsonObject set(String str, double d) {
        set(str, Json.value(d));
        return this;
    }

    public JsonObject set(String str, boolean z) {
        set(str, Json.value(z));
        return this;
    }

    public JsonObject set(String str, String str2) {
        set(str, Json.value(str2));
        return this;
    }

    public JsonObject set(String str, JsonValue jsonValue) {
        if (str == null) {
            throw new NullPointerException("name is null");
        }
        if (jsonValue == null) {
            throw new NullPointerException("value is null");
        }
        int iIndexOf = indexOf(str);
        if (iIndexOf != -1) {
            this.values.set(iIndexOf, jsonValue);
            return this;
        }
        this.table.add(str, this.names.size());
        this.names.add(str);
        this.values.add(jsonValue);
        return this;
    }

    public JsonObject remove(String str) {
        if (str == null) {
            throw new NullPointerException("name is null");
        }
        int iIndexOf = indexOf(str);
        if (iIndexOf != -1) {
            this.table.remove(iIndexOf);
            this.names.remove(iIndexOf);
            this.values.remove(iIndexOf);
        }
        return this;
    }

    public JsonObject merge(JsonObject jsonObject) {
        if (jsonObject == null) {
            throw new NullPointerException("object is null");
        }
        for (Member member : jsonObject) {
            set(member.name, member.value);
        }
        return this;
    }

    public JsonValue get(String str) {
        if (str == null) {
            throw new NullPointerException("name is null");
        }
        int iIndexOf = indexOf(str);
        if (iIndexOf != -1) {
            return this.values.get(iIndexOf);
        }
        return null;
    }

    public int getInt(String str, int i) {
        JsonValue jsonValue = get(str);
        return jsonValue != null ? jsonValue.asInt() : i;
    }

    public long getLong(String str, long j) {
        JsonValue jsonValue = get(str);
        return jsonValue != null ? jsonValue.asLong() : j;
    }

    public float getFloat(String str, float f) {
        JsonValue jsonValue = get(str);
        return jsonValue != null ? jsonValue.asFloat() : f;
    }

    public double getDouble(String str, double d) {
        JsonValue jsonValue = get(str);
        return jsonValue != null ? jsonValue.asDouble() : d;
    }

    public boolean getBoolean(String str, boolean z) {
        JsonValue jsonValue = get(str);
        return jsonValue != null ? jsonValue.asBoolean() : z;
    }

    public String getString(String str, String str2) {
        JsonValue jsonValue = get(str);
        return jsonValue != null ? jsonValue.asString() : str2;
    }

    public int size() {
        return this.names.size();
    }

    public boolean isEmpty() {
        return this.names.isEmpty();
    }

    public List<String> names() {
        return Collections.unmodifiableList(this.names);
    }

    @Override // java.lang.Iterable
    public Iterator<Member> iterator() {
        final Iterator<String> it = this.names.iterator();
        final Iterator<JsonValue> it2 = this.values.iterator();
        return new Iterator<Member>() { // from class: com.eclipsesource.json.JsonObject.1
            @Override // java.util.Iterator
            public boolean hasNext() {
                return it.hasNext();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.Iterator
            public Member next() {
                return new Member((String) it.next(), (JsonValue) it2.next());
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // com.eclipsesource.json.JsonValue
    void write(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeObjectOpen();
        Iterator<String> it = this.names.iterator();
        Iterator<JsonValue> it2 = this.values.iterator();
        if (it.hasNext()) {
            jsonWriter.writeMemberName(it.next());
            jsonWriter.writeMemberSeparator();
            it2.next().write(jsonWriter);
            while (it.hasNext()) {
                jsonWriter.writeObjectSeparator();
                jsonWriter.writeMemberName(it.next());
                jsonWriter.writeMemberSeparator();
                it2.next().write(jsonWriter);
            }
        }
        jsonWriter.writeObjectClose();
    }

    @Override // com.eclipsesource.json.JsonValue
    public int hashCode() {
        return ((this.names.hashCode() + 31) * 31) + this.values.hashCode();
    }

    @Override // com.eclipsesource.json.JsonValue
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        JsonObject jsonObject = (JsonObject) obj;
        return this.names.equals(jsonObject.names) && this.values.equals(jsonObject.values);
    }

    int indexOf(String str) {
        int i = this.table.get(str);
        return (i == -1 || !str.equals(this.names.get(i))) ? this.names.lastIndexOf(str) : i;
    }

    private synchronized void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.table = new HashIndexTable();
        updateHashIndex();
    }

    private void updateHashIndex() {
        int size = this.names.size();
        for (int i = 0; i < size; i++) {
            this.table.add(this.names.get(i), i);
        }
    }

    public static class Member {
        private final String name;
        private final JsonValue value;

        Member(String str, JsonValue jsonValue) {
            this.name = str;
            this.value = jsonValue;
        }

        public String getName() {
            return this.name;
        }

        public JsonValue getValue() {
            return this.value;
        }

        public int hashCode() {
            return ((this.name.hashCode() + 31) * 31) + this.value.hashCode();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Member member = (Member) obj;
            return this.name.equals(member.name) && this.value.equals(member.value);
        }
    }

    static class HashIndexTable {
        private final byte[] hashTable;

        public HashIndexTable() {
            this.hashTable = new byte[32];
        }

        public HashIndexTable(HashIndexTable hashIndexTable) {
            byte[] bArr = new byte[32];
            this.hashTable = bArr;
            System.arraycopy(hashIndexTable.hashTable, 0, bArr, 0, bArr.length);
        }

        void add(String str, int i) {
            int iHashSlotFor = hashSlotFor(str);
            if (i < 255) {
                this.hashTable[iHashSlotFor] = (byte) (i + 1);
            } else {
                this.hashTable[iHashSlotFor] = 0;
            }
        }

        void remove(int i) {
            int i2 = 0;
            while (true) {
                byte[] bArr = this.hashTable;
                if (i2 >= bArr.length) {
                    return;
                }
                byte b = bArr[i2];
                int i3 = i + 1;
                if (b == i3) {
                    bArr[i2] = 0;
                } else if (b > i3) {
                    bArr[i2] = (byte) (b - 1);
                }
                i2++;
            }
        }

        int get(Object obj) {
            return (this.hashTable[hashSlotFor(obj)] & 255) - 1;
        }

        private int hashSlotFor(Object obj) {
            return (this.hashTable.length - 1) & obj.hashCode();
        }
    }
}
