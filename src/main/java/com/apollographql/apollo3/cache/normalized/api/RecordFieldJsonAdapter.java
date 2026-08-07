package com.apollographql.apollo3.cache.normalized.api;

import com.apollographql.apollo3.cache.normalized.api.internal.JsonRecordSerializer;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RecordFieldJsonAdapter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Deprecated(message = "Use JsonRecordSerializer instead")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u001e\u0010\u0007\u001a\u00020\u00052\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004H\u0007¨\u0006\t"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/api/RecordFieldJsonAdapter;", "", "()V", "fromJson", "", "", "jsonFieldSource", "toJson", "fields", "apollo-normalized-cache-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class RecordFieldJsonAdapter {
    public static final RecordFieldJsonAdapter INSTANCE = new RecordFieldJsonAdapter();

    private RecordFieldJsonAdapter() {
    }

    @Deprecated(message = "Use JsonRecordSerializer instead", replaceWith = @ReplaceWith(expression = "JsonRecordSerializer.deserialize(json)", imports = {}))
    public final Map<String, Object> fromJson(String jsonFieldSource) {
        Intrinsics.checkNotNullParameter(jsonFieldSource, "jsonFieldSource");
        return JsonRecordSerializer.INSTANCE.deserialize("", jsonFieldSource).getFields();
    }

    @Deprecated(message = "Use JsonRecordSerializer instead", replaceWith = @ReplaceWith(expression = "JsonRecordSerializer.serialize(fields)", imports = {}))
    public final String toJson(Map<String, ? extends Object> fields) {
        Intrinsics.checkNotNullParameter(fields, "fields");
        return JsonRecordSerializer.INSTANCE.serialize(new Record("", fields, null, 4, null));
    }
}
