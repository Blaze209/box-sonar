package com.box.android.data.adapter;

import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.Adapters;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.json.JsonReader;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.box.android.data.GetHubsQuery;
import com.box.android.data.type.DateTime;
import com.box.android.data.type.NonNegativeInt;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GetHubsQuery_ResponseAdapter.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u0007\u0004\u0005\u0006\u0007\b\t\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u000b"}, d2 = {"Lcom/box/android/data/adapter/GetHubsQuery_ResponseAdapter;", "", "<init>", "()V", "Data", "Hubs", "Edge", "Node", "BannerImage", "IconImage", "PageInfo", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GetHubsQuery_ResponseAdapter {
    public static final GetHubsQuery_ResponseAdapter INSTANCE = new GetHubsQuery_ResponseAdapter();

    /* JADX INFO: compiled from: GetHubsQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetHubsQuery_ResponseAdapter$Data;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetHubsQuery$Data;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Data implements Adapter<GetHubsQuery.Data> {
        public static final Data INSTANCE = new Data();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf("hubs");

        private Data() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetHubsQuery.Data fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            GetHubsQuery.Hubs hubs = null;
            while (reader.selectName(RESPONSE_NAMES) == 0) {
                hubs = (GetHubsQuery.Hubs) Adapters.m11185nullable(Adapters.m11187obj$default(Hubs.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
            }
            return new GetHubsQuery.Data(hubs);
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetHubsQuery.Data value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("hubs");
            Adapters.m11185nullable(Adapters.m11187obj$default(Hubs.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, value.getHubs());
        }
    }

    private GetHubsQuery_ResponseAdapter() {
    }

    /* JADX INFO: compiled from: GetHubsQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetHubsQuery_ResponseAdapter$Hubs;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetHubsQuery$Hubs;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Hubs implements Adapter<GetHubsQuery.Hubs> {
        public static final Hubs INSTANCE = new Hubs();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"edges", "pageInfo", "totalCount"});

        private Hubs() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetHubsQuery.Hubs fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            List listFromJson = null;
            GetHubsQuery.PageInfo pageInfo = null;
            Integer numFromJson = null;
            while (true) {
                int iSelectName = reader.selectName(RESPONSE_NAMES);
                if (iSelectName == 0) {
                    listFromJson = Adapters.m11184list(Adapters.m11187obj$default(Edge.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
                } else if (iSelectName == 1) {
                    pageInfo = (GetHubsQuery.PageInfo) Adapters.m11187obj$default(PageInfo.INSTANCE, false, 1, null).fromJson(reader, customScalarAdapters);
                } else if (iSelectName == 2) {
                    numFromJson = Adapters.NullableIntAdapter.fromJson(reader, customScalarAdapters);
                } else {
                    Intrinsics.checkNotNull(listFromJson);
                    Intrinsics.checkNotNull(pageInfo);
                    return new GetHubsQuery.Hubs(listFromJson, pageInfo, numFromJson);
                }
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetHubsQuery.Hubs value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("edges");
            Adapters.m11184list(Adapters.m11187obj$default(Edge.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, (List) value.getEdges());
            writer.name("pageInfo");
            Adapters.m11187obj$default(PageInfo.INSTANCE, false, 1, null).toJson(writer, customScalarAdapters, value.getPageInfo());
            writer.name("totalCount");
            Adapters.NullableIntAdapter.toJson(writer, customScalarAdapters, value.getTotalCount());
        }
    }

    /* JADX INFO: compiled from: GetHubsQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetHubsQuery_ResponseAdapter$Edge;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetHubsQuery$Edge;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Edge implements Adapter<GetHubsQuery.Edge> {
        public static final Edge INSTANCE = new Edge();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf("node");

        private Edge() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetHubsQuery.Edge fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            GetHubsQuery.Node node = null;
            while (reader.selectName(RESPONSE_NAMES) == 0) {
                node = (GetHubsQuery.Node) Adapters.m11187obj$default(Node.INSTANCE, false, 1, null).fromJson(reader, customScalarAdapters);
            }
            Intrinsics.checkNotNull(node);
            return new GetHubsQuery.Edge(node);
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetHubsQuery.Edge value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("node");
            Adapters.m11187obj$default(Node.INSTANCE, false, 1, null).toJson(writer, customScalarAdapters, value.getNode());
        }
    }

    /* JADX INFO: compiled from: GetHubsQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetHubsQuery_ResponseAdapter$Node;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetHubsQuery$Node;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Node implements Adapter<GetHubsQuery.Node> {
        public static final Node INSTANCE = new Node();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"id", "bannerImage", "iconImage", "updatedAt", "accessCount", "title", "descriptionPreview"});

        private Node() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetHubsQuery.Node fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            String strFromJson = null;
            GetHubsQuery.BannerImage bannerImage = null;
            GetHubsQuery.IconImage iconImage = null;
            Date date = null;
            Integer num = null;
            String strFromJson2 = null;
            String strFromJson3 = null;
            while (true) {
                switch (reader.selectName(RESPONSE_NAMES)) {
                    case 0:
                        strFromJson = Adapters.StringAdapter.fromJson(reader, customScalarAdapters);
                        break;
                    case 1:
                        bannerImage = (GetHubsQuery.BannerImage) Adapters.m11187obj$default(BannerImage.INSTANCE, false, 1, null).fromJson(reader, customScalarAdapters);
                        break;
                    case 2:
                        iconImage = (GetHubsQuery.IconImage) Adapters.m11187obj$default(IconImage.INSTANCE, false, 1, null).fromJson(reader, customScalarAdapters);
                        break;
                    case 3:
                        date = (Date) Adapters.m11185nullable(customScalarAdapters.responseAdapterFor(DateTime.INSTANCE.getType())).fromJson(reader, customScalarAdapters);
                        break;
                    case 4:
                        num = (Integer) Adapters.m11185nullable(customScalarAdapters.responseAdapterFor(NonNegativeInt.INSTANCE.getType())).fromJson(reader, customScalarAdapters);
                        break;
                    case 5:
                        strFromJson2 = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters);
                        break;
                    case 6:
                        strFromJson3 = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters);
                        break;
                    default:
                        Intrinsics.checkNotNull(strFromJson);
                        Intrinsics.checkNotNull(bannerImage);
                        Intrinsics.checkNotNull(iconImage);
                        return new GetHubsQuery.Node(strFromJson, bannerImage, iconImage, date, num, strFromJson2, strFromJson3);
                }
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetHubsQuery.Node value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("id");
            Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.getId());
            writer.name("bannerImage");
            Adapters.m11187obj$default(BannerImage.INSTANCE, false, 1, null).toJson(writer, customScalarAdapters, value.getBannerImage());
            writer.name("iconImage");
            Adapters.m11187obj$default(IconImage.INSTANCE, false, 1, null).toJson(writer, customScalarAdapters, value.getIconImage());
            writer.name("updatedAt");
            Adapters.m11185nullable(customScalarAdapters.responseAdapterFor(DateTime.INSTANCE.getType())).toJson(writer, customScalarAdapters, value.getUpdatedAt());
            writer.name("accessCount");
            Adapters.m11185nullable(customScalarAdapters.responseAdapterFor(NonNegativeInt.INSTANCE.getType())).toJson(writer, customScalarAdapters, value.getAccessCount());
            writer.name("title");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getTitle());
            writer.name("descriptionPreview");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getDescriptionPreview());
        }
    }

    /* JADX INFO: compiled from: GetHubsQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetHubsQuery_ResponseAdapter$BannerImage;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetHubsQuery$BannerImage;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class BannerImage implements Adapter<GetHubsQuery.BannerImage> {
        public static final BannerImage INSTANCE = new BannerImage();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf("signedURL");

        private BannerImage() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetHubsQuery.BannerImage fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            String strFromJson = null;
            while (reader.selectName(RESPONSE_NAMES) == 0) {
                strFromJson = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters);
            }
            return new GetHubsQuery.BannerImage(strFromJson);
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetHubsQuery.BannerImage value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("signedURL");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getSignedURL());
        }
    }

    /* JADX INFO: compiled from: GetHubsQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetHubsQuery_ResponseAdapter$IconImage;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetHubsQuery$IconImage;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class IconImage implements Adapter<GetHubsQuery.IconImage> {
        public static final IconImage INSTANCE = new IconImage();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf("signedURL");

        private IconImage() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetHubsQuery.IconImage fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            String strFromJson = null;
            while (reader.selectName(RESPONSE_NAMES) == 0) {
                strFromJson = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters);
            }
            return new GetHubsQuery.IconImage(strFromJson);
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetHubsQuery.IconImage value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("signedURL");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getSignedURL());
        }
    }

    /* JADX INFO: compiled from: GetHubsQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetHubsQuery_ResponseAdapter$PageInfo;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetHubsQuery$PageInfo;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class PageInfo implements Adapter<GetHubsQuery.PageInfo> {
        public static final PageInfo INSTANCE = new PageInfo();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"endCursor", "hasNextPage"});

        private PageInfo() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetHubsQuery.PageInfo fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            String strFromJson = null;
            Boolean boolFromJson = null;
            while (true) {
                int iSelectName = reader.selectName(RESPONSE_NAMES);
                if (iSelectName == 0) {
                    strFromJson = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters);
                } else if (iSelectName == 1) {
                    boolFromJson = Adapters.BooleanAdapter.fromJson(reader, customScalarAdapters);
                } else {
                    Intrinsics.checkNotNull(boolFromJson);
                    return new GetHubsQuery.PageInfo(strFromJson, boolFromJson.booleanValue());
                }
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetHubsQuery.PageInfo value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("endCursor");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getEndCursor());
            writer.name("hasNextPage");
            Adapters.BooleanAdapter.toJson(writer, customScalarAdapters, Boolean.valueOf(value.getHasNextPage()));
        }
    }
}
