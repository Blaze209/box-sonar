package com.apollographql.apollo3.api;

import androidx.exifinterface.media.ExifInterface;
import com.apollographql.apollo3.api.json.JsonReader;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.apollographql.apollo3.api.json.MapJsonReader;
import com.apollographql.apollo3.api.json.MapJsonWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Adapters.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¢\u0006\u0002\u0010\tJ%\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/apollographql/apollo3/api/PassThroughAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/apollographql/apollo3/api/Adapter;", "()V", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "(Lcom/apollographql/apollo3/api/json/JsonReader;Lcom/apollographql/apollo3/api/CustomScalarAdapters;)Ljava/lang/Object;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "(Lcom/apollographql/apollo3/api/json/JsonWriter;Lcom/apollographql/apollo3/api/CustomScalarAdapters;Ljava/lang/Object;)V", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class PassThroughAdapter<T> implements Adapter<T> {
    @Override // com.apollographql.apollo3.api.Adapter
    public T fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
        if (!(reader instanceof MapJsonReader)) {
            throw new IllegalStateException("UnsafeAdapter only supports MapJsonReader".toString());
        }
        return (T) ((MapJsonReader) reader).nextValue();
    }

    @Override // com.apollographql.apollo3.api.Adapter
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, T value) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
        if (!(writer instanceof MapJsonWriter)) {
            throw new IllegalStateException("UnsafeAdapter only supports MapJsonWriter".toString());
        }
        ((MapJsonWriter) writer).value(value);
    }
}
