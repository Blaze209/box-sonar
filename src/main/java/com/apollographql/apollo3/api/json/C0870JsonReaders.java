package com.apollographql.apollo3.api.json;

import com.box.android.data.datasource.gql.cache.GQLCacheConstants;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.apollographql.apollo3.api.json.JsonReaders, reason: case insensitive filesystem */
/* JADX INFO: compiled from: JsonReaders2.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"readTypename", "", "Lcom/apollographql/apollo3/api/json/JsonReader;", "apollo-api"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class C0870JsonReaders {
    public static final String readTypename(JsonReader jsonReader) throws IOException {
        Intrinsics.checkNotNullParameter(jsonReader, "<this>");
        if (jsonReader.selectName(CollectionsKt.listOf(GQLCacheConstants.TYPENAME_KEY)) != 0) {
            throw new IllegalStateException("__typename not found".toString());
        }
        String strNextString = jsonReader.nextString();
        if (strNextString != null) {
            return strNextString;
        }
        throw new IllegalStateException("__typename is null".toString());
    }
}
