package com.apollographql.apollo3.api.internal;

import androidx.exifinterface.media.ExifInterface;
import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.Adapters;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.CustomTypeAdapter;
import com.apollographql.apollo3.api.CustomTypeValue;
import com.apollographql.apollo3.api.json.JsonReader;
import com.apollographql.apollo3.api.json.JsonWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Version2CustomTypeAdapterToAdapter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u001d\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000bJ%\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/apollographql/apollo3/api/internal/Version2CustomTypeAdapterToAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/apollographql/apollo3/api/Adapter;", "v2CustomTypeAdapter", "Lcom/apollographql/apollo3/api/CustomTypeAdapter;", "(Lcom/apollographql/apollo3/api/CustomTypeAdapter;)V", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "(Lcom/apollographql/apollo3/api/json/JsonReader;Lcom/apollographql/apollo3/api/CustomScalarAdapters;)Ljava/lang/Object;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "(Lcom/apollographql/apollo3/api/json/JsonWriter;Lcom/apollographql/apollo3/api/CustomScalarAdapters;Ljava/lang/Object;)V", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class Version2CustomTypeAdapterToAdapter<T> implements Adapter<T> {
    private final CustomTypeAdapter<T> v2CustomTypeAdapter;

    public Version2CustomTypeAdapterToAdapter(CustomTypeAdapter<T> v2CustomTypeAdapter) {
        Intrinsics.checkNotNullParameter(v2CustomTypeAdapter, "v2CustomTypeAdapter");
        this.v2CustomTypeAdapter = v2CustomTypeAdapter;
    }

    @Override // com.apollographql.apollo3.api.Adapter
    public T fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
        return this.v2CustomTypeAdapter.decode(CustomTypeValue.INSTANCE.fromRawValue(Adapters.NullableAnyAdapter.fromJson(reader, customScalarAdapters)));
    }

    @Override // com.apollographql.apollo3.api.Adapter
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, T value) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
        Adapters.NullableAnyAdapter.toJson(writer, customScalarAdapters, this.v2CustomTypeAdapter.encode(value).value);
    }
}
