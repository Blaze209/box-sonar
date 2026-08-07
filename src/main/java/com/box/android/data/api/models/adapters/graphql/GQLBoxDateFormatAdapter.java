package com.box.android.data.api.models.adapters.graphql;

import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.json.JsonReader;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.androidsdk.content.utils.BoxDateFormat;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.androidsdk.content.utils.GQLEndpointDateFormat;
import java.io.IOException;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GQLBoxDateFormatAdapter.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0002J\"\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0013"}, d2 = {"Lcom/box/android/data/api/models/adapters/graphql/GQLBoxDateFormatAdapter;", "Lcom/apollographql/apollo3/api/Adapter;", "Ljava/util/Date;", "<init>", "()V", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "parseGQLEndpointDateFormat", "dateString", "", "parseV2ApiDateFormat", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLBoxDateFormatAdapter implements Adapter<Date> {
    public static final GQLBoxDateFormatAdapter INSTANCE = new GQLBoxDateFormatAdapter();

    private GQLBoxDateFormatAdapter() {
    }

    @Override // com.apollographql.apollo3.api.Adapter
    public Date fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
        Intrinsics.checkNotNullParameter(reader, "reader");
        Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
        String strNextString = reader.nextString();
        if (strNextString == null) {
            return null;
        }
        GQLBoxDateFormatAdapter gQLBoxDateFormatAdapter = INSTANCE;
        Date gQLEndpointDateFormat = gQLBoxDateFormatAdapter.parseGQLEndpointDateFormat(strNextString);
        return gQLEndpointDateFormat == null ? gQLBoxDateFormatAdapter.parseV2ApiDateFormat(strNextString) : gQLEndpointDateFormat;
    }

    private final Date parseGQLEndpointDateFormat(String dateString) {
        return GQLEndpointDateFormat.INSTANCE.parse(dateString);
    }

    private final Date parseV2ApiDateFormat(String dateString) {
        try {
            return BoxDateFormat.parse(dateString);
        } catch (Exception e) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Could not parse " + dateString + " in V2 API date format. Exception: " + e);
            return null;
        }
    }

    @Override // com.apollographql.apollo3.api.Adapter
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, Date value) throws IOException {
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
        if (value != null) {
            writer.value(GQLEndpointDateFormat.INSTANCE.format(value));
        }
    }
}
