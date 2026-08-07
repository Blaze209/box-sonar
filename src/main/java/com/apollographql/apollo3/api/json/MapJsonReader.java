package com.apollographql.apollo3.api.json;

import com.apollographql.apollo3.api.json.internal.UtilsKt;
import com.apollographql.apollo3.exception.JsonDataException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.hc.core5.http.HeaderElements;

/* JADX INFO: compiled from: MapJsonReader.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 <2\u00020\u0001:\u0001<B-\b\u0007\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u0012\u0010\u001c\u001a\u00020\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\u001e\u001a\u00020\u0000H\u0016J\b\u0010\u001f\u001a\u00020\u0000H\u0016J\b\u0010 \u001a\u00020\u001bH\u0016J\b\u0010!\u001a\u00020\u0000H\u0016J\b\u0010\"\u001a\u00020\u0000H\u0016J\u001e\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u00042\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0002J\u000e\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0016J\b\u0010'\u001a\u00020\u0004H\u0002J\b\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020)H\u0016J\b\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020\u0019H\u0016J\b\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020\u0004H\u0016J\n\u00101\u001a\u0004\u0018\u000102H\u0016J\b\u00103\u001a\u000204H\u0016J\n\u00105\u001a\u0004\u0018\u00010\u0004H\u0016J\u0006\u00106\u001a\u00020\u0005J\b\u00107\u001a\u00020\u0015H\u0016J\b\u00108\u001a\u00020\u001bH\u0016J\u0016\u00109\u001a\u00020\u00192\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0016J\b\u0010;\u001a\u00020\u001bH\u0016R&\u0010\t\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00030\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u001c\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\r0\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/apollographql/apollo3/api/json/MapJsonReader;", "Lcom/apollographql/apollo3/api/json/JsonReader;", "root", "", "", "", "pathRoot", "", "(Ljava/util/Map;Ljava/util/List;)V", "containerStack", "", "[Ljava/util/Map;", "iteratorStack", "", "[Ljava/util/Iterator;", "nameIndexStack", "", "path", "[Ljava/lang/Object;", "peekedData", "peekedToken", "Lcom/apollographql/apollo3/api/json/JsonReader$Token;", "getRoot", "()Ljava/util/Map;", "stackSize", "", "advanceIterator", "", "anyToToken", "any", "beginArray", "beginObject", HeaderElements.CLOSE, "endArray", "endObject", "findName", "needle", "haystack", "getPath", "getPathAsString", "hasNext", "", "nextBoolean", "nextDouble", "", "nextInt", "nextLong", "", "nextName", "nextNull", "", "nextNumber", "Lcom/apollographql/apollo3/api/json/JsonNumber;", "nextString", "nextValue", "peek", "rewind", "selectName", "names", "skipValue", "Companion", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class MapJsonReader implements JsonReader {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Map<String, Object>[] containerStack;
    private final Iterator<?>[] iteratorStack;
    private final int[] nameIndexStack;
    private final Object[] path;
    private final List<Object> pathRoot;
    private Object peekedData;
    private JsonReader.Token peekedToken;
    private final Map<String, Object> root;
    private int stackSize;

    /* JADX INFO: compiled from: MapJsonReader.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[JsonReader.Token.values().length];
            try {
                iArr[JsonReader.Token.END_OBJECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[JsonReader.Token.END_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[JsonReader.Token.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[JsonReader.Token.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[JsonReader.Token.LONG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MapJsonReader(Map<String, ? extends Object> root) {
        this(root, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(root, "root");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public MapJsonReader(Map<String, ? extends Object> root, List<? extends Object> pathRoot) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(pathRoot, "pathRoot");
        this.root = root;
        this.pathRoot = pathRoot;
        this.path = new Object[256];
        this.containerStack = new Map[256];
        this.iteratorStack = new Iterator[256];
        this.nameIndexStack = new int[256];
        this.peekedToken = JsonReader.Token.BEGIN_OBJECT;
        this.peekedData = root;
    }

    public final Map<String, Object> getRoot() {
        return this.root;
    }

    public /* synthetic */ MapJsonReader(Map map, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(map, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    private final JsonReader.Token anyToToken(Object any) {
        if (any == null) {
            return JsonReader.Token.NULL;
        }
        if (any instanceof List) {
            return JsonReader.Token.BEGIN_ARRAY;
        }
        if (any instanceof Map) {
            return JsonReader.Token.BEGIN_OBJECT;
        }
        if (any instanceof Integer) {
            return JsonReader.Token.NUMBER;
        }
        if (any instanceof Long) {
            return JsonReader.Token.LONG;
        }
        if (!(any instanceof Double) && !(any instanceof JsonNumber)) {
            if (any instanceof String) {
                return JsonReader.Token.STRING;
            }
            return any instanceof Boolean ? JsonReader.Token.BOOLEAN : JsonReader.Token.ANY;
        }
        return JsonReader.Token.NUMBER;
    }

    private final void advanceIterator() {
        JsonReader.Token token;
        int i = this.stackSize;
        if (i == 0) {
            this.peekedToken = JsonReader.Token.END_DOCUMENT;
            return;
        }
        Iterator<?> it = this.iteratorStack[i - 1];
        Intrinsics.checkNotNull(it);
        Object[] objArr = this.path;
        int i2 = this.stackSize;
        if (objArr[i2 - 1] instanceof Integer) {
            int i3 = i2 - 1;
            Object obj = objArr[i2 - 1];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            objArr[i3] = Integer.valueOf(((Integer) obj).intValue() + 1);
        }
        if (it.hasNext()) {
            Object next = it.next();
            this.peekedData = next;
            this.peekedToken = next instanceof Map.Entry ? JsonReader.Token.NAME : anyToToken(next);
        } else {
            if (this.path[this.stackSize - 1] instanceof Integer) {
                token = JsonReader.Token.END_ARRAY;
            } else {
                token = JsonReader.Token.END_OBJECT;
            }
            this.peekedToken = token;
        }
    }

    @Override // com.apollographql.apollo3.api.json.JsonReader
    public MapJsonReader beginArray() {
        if (getPeekedToken() != JsonReader.Token.BEGIN_ARRAY) {
            throw new JsonDataException("Expected BEGIN_ARRAY but was " + getPeekedToken() + " at path " + getPathAsString());
        }
        Object obj = this.peekedData;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
        List list = (List) obj;
        int i = this.stackSize;
        if (i >= 256) {
            throw new IllegalStateException("Nesting too deep".toString());
        }
        this.stackSize = i + 1;
        this.path[i] = -1;
        this.iteratorStack[this.stackSize - 1] = list.iterator();
        advanceIterator();
        return this;
    }

    @Override // com.apollographql.apollo3.api.json.JsonReader
    public MapJsonReader endArray() {
        if (getPeekedToken() != JsonReader.Token.END_ARRAY) {
            throw new JsonDataException("Expected END_ARRAY but was " + getPeekedToken() + " at path " + getPathAsString());
        }
        int i = this.stackSize - 1;
        this.stackSize = i;
        this.iteratorStack[i] = null;
        this.path[i] = null;
        advanceIterator();
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.apollographql.apollo3.api.json.JsonReader
    public MapJsonReader beginObject() {
        if (getPeekedToken() != JsonReader.Token.BEGIN_OBJECT) {
            throw new JsonDataException("Expected BEGIN_OBJECT but was " + getPeekedToken() + " at path " + getPathAsString());
        }
        int i = this.stackSize;
        if (i >= 256) {
            throw new IllegalStateException("Nesting too deep".toString());
        }
        this.stackSize = i + 1;
        Map<String, Object>[] mapArr = this.containerStack;
        Object obj = this.peekedData;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
        mapArr[i] = obj;
        rewind();
        return this;
    }

    @Override // com.apollographql.apollo3.api.json.JsonReader
    public MapJsonReader endObject() {
        int i = this.stackSize - 1;
        this.stackSize = i;
        this.iteratorStack[i] = null;
        this.path[i] = null;
        this.containerStack[i] = null;
        advanceIterator();
        return this;
    }

    @Override // com.apollographql.apollo3.api.json.JsonReader
    public boolean hasNext() {
        int i = WhenMappings.$EnumSwitchMapping$0[getPeekedToken().ordinal()];
        return (i == 1 || i == 2) ? false : true;
    }

    @Override // com.apollographql.apollo3.api.json.JsonReader
    /* JADX INFO: renamed from: peek, reason: from getter */
    public JsonReader.Token getPeekedToken() {
        return this.peekedToken;
    }

    @Override // com.apollographql.apollo3.api.json.JsonReader
    public String nextName() {
        if (getPeekedToken() != JsonReader.Token.NAME) {
            throw new JsonDataException("Expected NAME but was " + getPeekedToken() + " at path " + getPathAsString());
        }
        Object obj = this.peekedData;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.Map.Entry<kotlin.String, kotlin.Any?>");
        Map.Entry entry = (Map.Entry) obj;
        this.path[this.stackSize - 1] = entry.getKey();
        this.peekedData = entry.getValue();
        this.peekedToken = anyToToken(entry.getValue());
        return (String) entry.getKey();
    }

    @Override // com.apollographql.apollo3.api.json.JsonReader
    public String nextString() {
        int i = WhenMappings.$EnumSwitchMapping$0[getPeekedToken().ordinal()];
        if (i != 3 && i != 4 && i != 5) {
            throw new JsonDataException("Expected a String but was " + getPeekedToken() + " at path " + getPathAsString());
        }
        Object obj = this.peekedData;
        Intrinsics.checkNotNull(obj);
        String string = obj.toString();
        advanceIterator();
        return string;
    }

    @Override // com.apollographql.apollo3.api.json.JsonReader
    public boolean nextBoolean() {
        if (getPeekedToken() != JsonReader.Token.BOOLEAN) {
            throw new JsonDataException("Expected BOOLEAN but was " + getPeekedToken() + " at path " + getPathAsString());
        }
        Object obj = this.peekedData;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
        Boolean bool = (Boolean) obj;
        bool.booleanValue();
        advanceIterator();
        return bool.booleanValue();
    }

    @Override // com.apollographql.apollo3.api.json.JsonReader
    public Void nextNull() {
        if (getPeekedToken() != JsonReader.Token.NULL) {
            throw new JsonDataException("Expected NULL but was " + getPeekedToken() + " at path " + getPathAsString());
        }
        advanceIterator();
        return null;
    }

    @Override // com.apollographql.apollo3.api.json.JsonReader
    public double nextDouble() {
        double dDoubleValue;
        int i = WhenMappings.$EnumSwitchMapping$0[getPeekedToken().ordinal()];
        if (i != 3 && i != 4 && i != 5) {
            throw new JsonDataException("Expected a Double but was " + getPeekedToken() + " at path " + getPathAsString());
        }
        Object obj = this.peekedData;
        if (obj instanceof Integer) {
            dDoubleValue = ((Number) obj).intValue();
        } else if (obj instanceof Long) {
            dDoubleValue = UtilsKt.m11200LongToDoubleExact(((Number) obj).longValue());
        } else if (obj instanceof Double) {
            dDoubleValue = ((Number) obj).doubleValue();
        } else if (obj instanceof String) {
            dDoubleValue = Double.parseDouble((String) obj);
        } else {
            if (!(obj instanceof JsonNumber)) {
                throw new IllegalStateException(("Expected a Double but got " + obj + " instead").toString());
            }
            dDoubleValue = Double.parseDouble(((JsonNumber) obj).getValue());
        }
        advanceIterator();
        return dDoubleValue;
    }

    @Override // com.apollographql.apollo3.api.json.JsonReader
    public int nextInt() {
        int iM11198DoubleToIntExact;
        int i = WhenMappings.$EnumSwitchMapping$0[getPeekedToken().ordinal()];
        if (i != 3 && i != 4 && i != 5) {
            throw new JsonDataException("Expected an Int but was " + getPeekedToken() + " at path " + getPathAsString());
        }
        Object obj = this.peekedData;
        if (obj instanceof Integer) {
            iM11198DoubleToIntExact = ((Number) obj).intValue();
        } else if (obj instanceof Long) {
            iM11198DoubleToIntExact = UtilsKt.m11201LongToIntExact(((Number) obj).longValue());
        } else if (obj instanceof Double) {
            iM11198DoubleToIntExact = UtilsKt.m11198DoubleToIntExact(((Number) obj).doubleValue());
        } else if (obj instanceof String) {
            iM11198DoubleToIntExact = Integer.parseInt((String) obj);
        } else {
            if (!(obj instanceof JsonNumber)) {
                throw new IllegalStateException(("Expected an Int but got " + obj + " instead").toString());
            }
            iM11198DoubleToIntExact = Integer.parseInt(((JsonNumber) obj).getValue());
        }
        advanceIterator();
        return iM11198DoubleToIntExact;
    }

    @Override // com.apollographql.apollo3.api.json.JsonReader
    public long nextLong() {
        long jM11199DoubleToLongExact;
        int i = WhenMappings.$EnumSwitchMapping$0[getPeekedToken().ordinal()];
        if (i != 3 && i != 4 && i != 5) {
            throw new JsonDataException("Expected a Long but was " + getPeekedToken() + " at path " + getPathAsString());
        }
        Object obj = this.peekedData;
        if (obj instanceof Integer) {
            jM11199DoubleToLongExact = ((Number) obj).intValue();
        } else if (obj instanceof Long) {
            jM11199DoubleToLongExact = ((Number) obj).longValue();
        } else if (obj instanceof Double) {
            jM11199DoubleToLongExact = UtilsKt.m11199DoubleToLongExact(((Number) obj).doubleValue());
        } else if (obj instanceof String) {
            jM11199DoubleToLongExact = Long.parseLong((String) obj);
        } else {
            if (!(obj instanceof JsonNumber)) {
                throw new IllegalStateException(("Expected Int but got " + obj + " instead").toString());
            }
            jM11199DoubleToLongExact = Long.parseLong(((JsonNumber) obj).getValue());
        }
        advanceIterator();
        return jM11199DoubleToLongExact;
    }

    @Override // com.apollographql.apollo3.api.json.JsonReader
    public JsonNumber nextNumber() {
        JsonNumber jsonNumber;
        int i = WhenMappings.$EnumSwitchMapping$0[getPeekedToken().ordinal()];
        if (i != 3 && i != 4 && i != 5) {
            throw new JsonDataException("Expected a Number but was " + getPeekedToken() + " at path " + getPathAsString());
        }
        Object obj = this.peekedData;
        if (obj instanceof Integer ? true : obj instanceof Long ? true : obj instanceof Double) {
            jsonNumber = new JsonNumber(obj.toString());
        } else if (obj instanceof String) {
            jsonNumber = new JsonNumber((String) obj);
        } else {
            if (!(obj instanceof JsonNumber)) {
                throw new IllegalStateException(("Expected JsonNumber but got " + obj + " instead").toString());
            }
            jsonNumber = (JsonNumber) obj;
        }
        advanceIterator();
        return jsonNumber;
    }

    public final Object nextValue() {
        Object obj = this.peekedData;
        if (obj == null) {
            throw new JsonDataException("Expected a non-null value at path " + getPathAsString());
        }
        advanceIterator();
        return obj;
    }

    @Override // com.apollographql.apollo3.api.json.JsonReader
    public void skipValue() {
        advanceIterator();
    }

    private final int findName(String needle, List<String> haystack) {
        int i = this.nameIndexStack[this.stackSize - 1];
        if (i < haystack.size() && Intrinsics.areEqual(haystack.get(i), needle)) {
            int[] iArr = this.nameIndexStack;
            int i2 = this.stackSize;
            iArr[i2 - 1] = iArr[i2 - 1] + 1;
            return i;
        }
        int iIndexOf = haystack.indexOf(needle);
        if (iIndexOf != -1) {
            this.nameIndexStack[this.stackSize - 1] = iIndexOf + 1;
        }
        return iIndexOf;
    }

    @Override // com.apollographql.apollo3.api.json.JsonReader
    public int selectName(List<String> names) {
        Intrinsics.checkNotNullParameter(names, "names");
        while (hasNext()) {
            int iFindName = findName(nextName(), names);
            if (iFindName != -1) {
                return iFindName;
            }
            skipValue();
        }
        return -1;
    }

    @Override // com.apollographql.apollo3.api.json.JsonReader
    public void rewind() {
        Map<String, Object>[] mapArr = this.containerStack;
        int i = this.stackSize;
        Map<String, Object> map = mapArr[i - 1];
        this.path[i - 1] = null;
        Intrinsics.checkNotNull(map);
        this.iteratorStack[i - 1] = map.entrySet().iterator();
        this.nameIndexStack[this.stackSize - 1] = 0;
        advanceIterator();
    }

    @Override // com.apollographql.apollo3.api.json.JsonReader
    public List<Object> getPath() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.pathRoot);
        int i = this.stackSize;
        for (int i2 = 0; i2 < i; i2++) {
            Object obj = this.path[i2];
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final String getPathAsString() {
        return CollectionsKt.joinToString$default(getPath(), ".", null, null, 0, null, null, 62, null);
    }

    /* JADX INFO: compiled from: MapJsonReader.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/apollographql/apollo3/api/json/MapJsonReader$Companion;", "", "()V", "buffer", "Lcom/apollographql/apollo3/api/json/MapJsonReader;", "Lcom/apollographql/apollo3/api/json/JsonReader;", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MapJsonReader buffer(JsonReader jsonReader) {
            Intrinsics.checkNotNullParameter(jsonReader, "<this>");
            if (jsonReader instanceof MapJsonReader) {
                return (MapJsonReader) jsonReader;
            }
            JsonReader.Token peekedToken = jsonReader.getPeekedToken();
            if (peekedToken != JsonReader.Token.BEGIN_OBJECT) {
                throw new IllegalStateException(("Failed to buffer json reader, expected `BEGIN_OBJECT` but found `" + peekedToken + "` json token").toString());
            }
            List<Object> path = jsonReader.getPath();
            Object any = JsonReaders.readAny(jsonReader);
            Intrinsics.checkNotNull(any, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
            return new MapJsonReader((Map) any, path);
        }
    }
}
