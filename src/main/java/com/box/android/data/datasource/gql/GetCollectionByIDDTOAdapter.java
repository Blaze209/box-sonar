package com.box.android.data.datasource.gql;

import com.apollographql.apollo3.api.Error;
import com.apollographql.apollo3.api.Operation;
import com.apollographql.apollo3.api._DataKt;
import com.apollographql.apollo3.api.json.MapJsonWriter;
import com.box.android.data.api.models.adapters.graphql.GQLCustomScalarAdapters;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import com.squareup.moshi.FromJson;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.ToJson;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okio.BufferedSink;

/* JADX INFO: compiled from: GQLOperationDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0017J \u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J&\u0010\u000f\u001a\u00020\t2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00112\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u001a\u0010\u0013\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0017¨\u0006\u0015"}, d2 = {"Lcom/box/android/data/datasource/gql/GetCollectionByIDDTOAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/box/android/data/datasource/gql/GQLOperationDTO;", "<init>", "()V", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "writeList", "", BoxNoteConstants.BOX_NOTE_STYLE_TYPE_LIST, "", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "writeMap", "map", "", "", "toJson", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GetCollectionByIDDTOAdapter extends JsonAdapter<GQLOperationDTO> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    @FromJson
    public GQLOperationDTO fromJson(JsonReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    private final void writeList(List<? extends Object> list, JsonWriter writer) throws IOException {
        for (Object obj : list) {
            if (obj instanceof Map) {
                writer.beginObject();
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
                writeMap((Map) obj, writer);
                writer.endObject();
            } else if (obj instanceof List) {
                writer.beginArray();
                writeList((List) obj, writer);
                writer.endArray();
            } else if (obj instanceof Boolean) {
                writer.value(((Boolean) obj).booleanValue());
            } else if (obj instanceof Long) {
                writer.value(((Number) obj).longValue());
            } else if (obj instanceof Integer) {
                writer.value((Number) obj);
            } else if (obj instanceof Double) {
                writer.value(((Number) obj).doubleValue());
            } else if (obj instanceof String) {
                writer.value((String) obj);
            } else if (obj instanceof Number) {
                writer.value((Number) obj);
            } else if (obj == null) {
                writer.nullValue();
            }
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    @ToJson
    public void toJson(JsonWriter writer, GQLOperationDTO value) throws IOException {
        List<Error> errors;
        Operation.Data data;
        Intrinsics.checkNotNullParameter(writer, "writer");
        MapJsonWriter mapJsonWriter = new MapJsonWriter();
        if (value != null && (data = value.getData()) != null) {
            _DataKt.toJson(data, mapJsonWriter, GQLCustomScalarAdapters.INSTANCE.getCustomScalars());
        }
        Object objRoot = mapJsonWriter.root();
        writer.beginObject();
        writer.name("data").beginObject();
        if (objRoot instanceof Map) {
            writeMap((Map) objRoot, writer);
        }
        writer.endObject();
        writer.name(BoxAnalyticsParams.CATEGORY_ERRORS).beginArray();
        GQLErrorAdapter gQLErrorAdapter = new GQLErrorAdapter();
        if (value != null && (errors = value.getErrors()) != null) {
            for (Error error : errors) {
                BufferedSink bufferedSinkValueSink = writer.valueSink();
                Intrinsics.checkNotNullExpressionValue(bufferedSinkValueSink, "valueSink(...)");
                String json = gQLErrorAdapter.toJson(error);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
                byte[] bytes = json.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                bufferedSinkValueSink.write(bytes);
                bufferedSinkValueSink.close();
            }
        }
        writer.endArray();
        writer.endObject();
    }

    private final void writeMap(Map<String, ? extends Object> map, JsonWriter writer) throws IOException {
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Map) {
                writer.name(key);
                writer.beginObject();
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
                writeMap((Map) value, writer);
                writer.endObject();
            } else if (value instanceof List) {
                writer.name(key).beginArray();
                writeList((List) value, writer);
                writer.endArray();
            } else if (value instanceof Boolean) {
                writer.name(key).value(((Boolean) value).booleanValue());
            } else if (value instanceof Long) {
                writer.name(key).value(((Number) value).longValue());
            } else if (value instanceof Integer) {
                writer.name(key).value((Number) value);
            } else if (value instanceof Double) {
                writer.name(key).value(((Number) value).doubleValue());
            } else if (value instanceof String) {
                writer.name(key).value((String) value);
            } else if (value instanceof Number) {
                writer.name(key).value((Number) value);
            } else if (value == null) {
                writer.name(key).nullValue();
            }
        }
    }
}
