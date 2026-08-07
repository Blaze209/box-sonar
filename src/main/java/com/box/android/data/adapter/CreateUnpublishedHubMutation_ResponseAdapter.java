package com.box.android.data.adapter;

import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.Adapters;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.json.JsonReader;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.box.android.data.CreateUnpublishedHubMutation;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CreateUnpublishedHubMutation_ResponseAdapter.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\b"}, d2 = {"Lcom/box/android/data/adapter/CreateUnpublishedHubMutation_ResponseAdapter;", "", "<init>", "()V", "Data", "CreateUnpublishedHub", "Value", "Error", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CreateUnpublishedHubMutation_ResponseAdapter {
    public static final CreateUnpublishedHubMutation_ResponseAdapter INSTANCE = new CreateUnpublishedHubMutation_ResponseAdapter();

    /* JADX INFO: compiled from: CreateUnpublishedHubMutation_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/CreateUnpublishedHubMutation_ResponseAdapter$Data;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/CreateUnpublishedHubMutation$Data;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Data implements Adapter<CreateUnpublishedHubMutation.Data> {
        public static final Data INSTANCE = new Data();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf(CreateUnpublishedHubMutation.OPERATION_NAME);

        private Data() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public CreateUnpublishedHubMutation.Data fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            CreateUnpublishedHubMutation.CreateUnpublishedHub createUnpublishedHub = null;
            while (reader.selectName(RESPONSE_NAMES) == 0) {
                createUnpublishedHub = (CreateUnpublishedHubMutation.CreateUnpublishedHub) Adapters.m11187obj$default(CreateUnpublishedHub.INSTANCE, false, 1, null).fromJson(reader, customScalarAdapters);
            }
            Intrinsics.checkNotNull(createUnpublishedHub);
            return new CreateUnpublishedHubMutation.Data(createUnpublishedHub);
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, CreateUnpublishedHubMutation.Data value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name(CreateUnpublishedHubMutation.OPERATION_NAME);
            Adapters.m11187obj$default(CreateUnpublishedHub.INSTANCE, false, 1, null).toJson(writer, customScalarAdapters, value.getCreateUnpublishedHub());
        }
    }

    private CreateUnpublishedHubMutation_ResponseAdapter() {
    }

    /* JADX INFO: compiled from: CreateUnpublishedHubMutation_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/CreateUnpublishedHubMutation_ResponseAdapter$CreateUnpublishedHub;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/CreateUnpublishedHubMutation$CreateUnpublishedHub;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class CreateUnpublishedHub implements Adapter<CreateUnpublishedHubMutation.CreateUnpublishedHub> {
        public static final CreateUnpublishedHub INSTANCE = new CreateUnpublishedHub();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"value", BoxAnalyticsParams.CATEGORY_ERRORS});

        private CreateUnpublishedHub() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public CreateUnpublishedHubMutation.CreateUnpublishedHub fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            CreateUnpublishedHubMutation.Value value = null;
            List listFromJson = null;
            while (true) {
                int iSelectName = reader.selectName(RESPONSE_NAMES);
                if (iSelectName == 0) {
                    value = (CreateUnpublishedHubMutation.Value) Adapters.m11185nullable(Adapters.m11187obj$default(Value.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
                } else if (iSelectName == 1) {
                    listFromJson = Adapters.m11184list(Adapters.m11187obj$default(Error.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
                } else {
                    Intrinsics.checkNotNull(listFromJson);
                    return new CreateUnpublishedHubMutation.CreateUnpublishedHub(value, listFromJson);
                }
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, CreateUnpublishedHubMutation.CreateUnpublishedHub value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("value");
            Adapters.m11185nullable(Adapters.m11187obj$default(Value.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, value.getValue());
            writer.name(BoxAnalyticsParams.CATEGORY_ERRORS);
            Adapters.m11184list(Adapters.m11187obj$default(Error.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, (List) value.getErrors());
        }
    }

    /* JADX INFO: compiled from: CreateUnpublishedHubMutation_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/CreateUnpublishedHubMutation_ResponseAdapter$Value;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/CreateUnpublishedHubMutation$Value;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Value implements Adapter<CreateUnpublishedHubMutation.Value> {
        public static final Value INSTANCE = new Value();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf("id");

        private Value() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public CreateUnpublishedHubMutation.Value fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            String strFromJson = null;
            while (reader.selectName(RESPONSE_NAMES) == 0) {
                strFromJson = Adapters.StringAdapter.fromJson(reader, customScalarAdapters);
            }
            Intrinsics.checkNotNull(strFromJson);
            return new CreateUnpublishedHubMutation.Value(strFromJson);
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, CreateUnpublishedHubMutation.Value value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("id");
            Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.getId());
        }
    }

    /* JADX INFO: compiled from: CreateUnpublishedHubMutation_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/CreateUnpublishedHubMutation_ResponseAdapter$Error;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/CreateUnpublishedHubMutation$Error;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Error implements Adapter<CreateUnpublishedHubMutation.Error> {
        public static final Error INSTANCE = new Error();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf("message");

        private Error() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public CreateUnpublishedHubMutation.Error fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            String strFromJson = null;
            while (reader.selectName(RESPONSE_NAMES) == 0) {
                strFromJson = Adapters.StringAdapter.fromJson(reader, customScalarAdapters);
            }
            Intrinsics.checkNotNull(strFromJson);
            return new CreateUnpublishedHubMutation.Error(strFromJson);
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, CreateUnpublishedHubMutation.Error value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("message");
            Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.getMessage());
        }
    }
}
