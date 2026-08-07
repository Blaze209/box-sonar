package com.box.android.data.datasource.gql;

import com.apollographql.apollo3.api.Error;
import com.squareup.moshi.FromJson;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.ToJson;
import java.io.IOException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GQLOperationDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0017J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0017¨\u0006\r"}, d2 = {"Lcom/box/android/data/datasource/gql/GQLErrorAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/apollographql/apollo3/api/Error;", "<init>", "()V", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLErrorAdapter extends JsonAdapter<Error> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    @FromJson
    public Error fromJson(JsonReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.squareup.moshi.JsonAdapter
    @ToJson
    public void toJson(JsonWriter writer, Error value) throws IOException {
        Object obj;
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value != null) {
            writer.beginObject();
            writer.name("message").value(value.getMessage());
            Map<String, Object> nonStandardFields = value.getNonStandardFields();
            if (nonStandardFields != null && (obj = nonStandardFields.get(CustomAttributeKeys.REMOTE_ERROR)) != null) {
                JsonWriter jsonWriterName = writer.name(CustomAttributeKeys.REMOTE_ERROR);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                jsonWriterName.value((String) obj);
            }
            writer.endObject();
        }
    }
}
