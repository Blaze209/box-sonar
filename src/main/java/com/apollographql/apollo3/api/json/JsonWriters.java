package com.apollographql.apollo3.api.json;

import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ByteString;

/* JADX INFO: renamed from: com.apollographql.apollo3.api.json.-JsonWriters, reason: invalid class name */
/* JADX INFO: compiled from: JsonWriters.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\u001a@\u0010\u0000\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0019\b\u0004\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001a6\u0010\t\u001a\u0004\u0018\u00010\n2\u0019\b\u0004\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a@\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0019\b\u0004\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001a\u0014\u0010\f\u001a\u00020\u0007*\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\n\u001a8\u0010\u000e\u001a\u00020\u0007*\u00020\u00062\u0019\b\u0004\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a8\u0010\u000f\u001a\u00020\u0007*\u00020\u00062\u0019\b\u0004\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0010"}, d2 = {"buildJsonByteString", "Lokio/ByteString;", BoxNoteConstants.BOX_NOTE_STYLE_TYPE_INDENT, "", "block", "Lkotlin/Function1;", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "", "Lkotlin/ExtensionFunctionType;", "buildJsonMap", "", "buildJsonString", "writeAny", "value", "writeArray", "writeObject", "apollo-api"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class JsonWriters {
    public static final void writeAny(JsonWriter jsonWriter, Object obj) {
        Intrinsics.checkNotNullParameter(jsonWriter, "<this>");
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        if (!(obj instanceof Map)) {
            if (!(obj instanceof List)) {
                if (obj instanceof Boolean) {
                    jsonWriter.value(((Boolean) obj).booleanValue());
                    return;
                }
                if (obj instanceof Integer) {
                    jsonWriter.value(((Number) obj).intValue());
                    return;
                }
                if (obj instanceof Long) {
                    jsonWriter.value(((Number) obj).longValue());
                    return;
                }
                if (obj instanceof Double) {
                    jsonWriter.value(((Number) obj).doubleValue());
                    return;
                } else if (obj instanceof JsonNumber) {
                    jsonWriter.value((JsonNumber) obj);
                    return;
                } else {
                    if (!(obj instanceof String)) {
                        throw new IllegalStateException(("Cannot write " + obj + " to Json").toString());
                    }
                    jsonWriter.value((String) obj);
                    return;
                }
            }
            jsonWriter.beginArray();
            Iterator it = ((Iterable) obj).iterator();
            while (it.hasNext()) {
                writeAny(jsonWriter, it.next());
            }
            jsonWriter.endArray();
            return;
        }
        jsonWriter.beginObject();
        for (Map.Entry entry : ((Map) obj).entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            jsonWriter.name(String.valueOf(key));
            writeAny(jsonWriter, value);
        }
        jsonWriter.endObject();
    }

    public static final void writeObject(JsonWriter jsonWriter, Function1<? super JsonWriter, Unit> block) throws IOException {
        Intrinsics.checkNotNullParameter(jsonWriter, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        jsonWriter.beginObject();
        block.invoke(jsonWriter);
        jsonWriter.endObject();
    }

    public static final void writeArray(JsonWriter jsonWriter, Function1<? super JsonWriter, Unit> block) throws IOException {
        Intrinsics.checkNotNullParameter(jsonWriter, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        jsonWriter.beginArray();
        block.invoke(jsonWriter);
        jsonWriter.endArray();
    }

    public static /* synthetic */ String buildJsonString$default(String str, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        Intrinsics.checkNotNullParameter(block, "block");
        Buffer buffer = new Buffer();
        block.invoke(new BufferedSinkJsonWriter(buffer, str));
        return buffer.readUtf8();
    }

    public static final String buildJsonString(String str, Function1<? super JsonWriter, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Buffer buffer = new Buffer();
        block.invoke(new BufferedSinkJsonWriter(buffer, str));
        return buffer.readUtf8();
    }

    public static /* synthetic */ ByteString buildJsonByteString$default(String str, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        Intrinsics.checkNotNullParameter(block, "block");
        Buffer buffer = new Buffer();
        block.invoke(new BufferedSinkJsonWriter(buffer, str));
        return buffer.readByteString();
    }

    public static final ByteString buildJsonByteString(String str, Function1<? super JsonWriter, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Buffer buffer = new Buffer();
        block.invoke(new BufferedSinkJsonWriter(buffer, str));
        return buffer.readByteString();
    }

    public static final Object buildJsonMap(Function1<? super JsonWriter, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        MapJsonWriter mapJsonWriter = new MapJsonWriter();
        block.invoke(mapJsonWriter);
        return mapJsonWriter.root();
    }
}
