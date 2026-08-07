package com.box.android.data;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.Adapters;
import com.apollographql.apollo3.api.CompiledField;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.Optional;
import com.apollographql.apollo3.api.Query;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.box.android.data.adapter.GetHubsQuery_ResponseAdapter;
import com.box.android.data.adapter.GetHubsQuery_VariablesAdapter;
import com.box.android.data.selections.GetHubsQuerySelections;
import com.box.android.data.type.HubsDirectionEnum;
import com.box.android.data.type.HubsSortEnum;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GetHubsQuery.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0086\b\u0018\u0000 82\b\u0012\u0004\u0012\u00020\u00020\u0001:\b12345678BC\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0018\u001a\u00020\u0007H\u0016J\b\u0010\u0019\u001a\u00020\u0007H\u0016J\b\u0010\u001a\u001a\u00020\u0007H\u0016J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\"H\u0016J\b\u0010#\u001a\u00020$H\u0016J\t\u0010%\u001a\u00020\u0004HÆ\u0003J\u0011\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006HÆ\u0003J\t\u0010'\u001a\u00020\tHÆ\u0003J\t\u0010(\u001a\u00020\u000bHÆ\u0003J\u0011\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006HÆ\u0003JK\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006HÆ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020\u0004HÖ\u0001J\t\u00100\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012¨\u00069"}, d2 = {"Lcom/box/android/data/GetHubsQuery;", "Lcom/apollographql/apollo3/api/Query;", "Lcom/box/android/data/GetHubsQuery$Data;", "first", "", TtmlNode.ANNOTATION_POSITION_AFTER, "Lcom/apollographql/apollo3/api/Optional;", "", "sort", "Lcom/box/android/data/type/HubsSortEnum;", "direction", "Lcom/box/android/data/type/HubsDirectionEnum;", "query", "<init>", "(ILcom/apollographql/apollo3/api/Optional;Lcom/box/android/data/type/HubsSortEnum;Lcom/box/android/data/type/HubsDirectionEnum;Lcom/apollographql/apollo3/api/Optional;)V", "getFirst", "()I", "getAfter", "()Lcom/apollographql/apollo3/api/Optional;", "getSort", "()Lcom/box/android/data/type/HubsSortEnum;", "getDirection", "()Lcom/box/android/data/type/HubsDirectionEnum;", "getQuery", "id", "document", "name", "serializeVariables", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "adapter", "Lcom/apollographql/apollo3/api/Adapter;", "rootField", "Lcom/apollographql/apollo3/api/CompiledField;", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "Data", "Hubs", "Edge", "Node", "BannerImage", "IconImage", "PageInfo", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class GetHubsQuery implements Query<Data> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String OPERATION_ID = "14ae39074115f74d6faa86a22404e01fa4bc755208fb4f2e8ee9887cc42b19c7";
    public static final String OPERATION_NAME = "GetHubs";
    private final Optional<String> after;
    private final HubsDirectionEnum direction;
    private final int first;
    private final Optional<String> query;
    private final HubsSortEnum sort;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GetHubsQuery copy$default(GetHubsQuery getHubsQuery, int i, Optional optional, HubsSortEnum hubsSortEnum, HubsDirectionEnum hubsDirectionEnum, Optional optional2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = getHubsQuery.first;
        }
        if ((i2 & 2) != 0) {
            optional = getHubsQuery.after;
        }
        if ((i2 & 4) != 0) {
            hubsSortEnum = getHubsQuery.sort;
        }
        if ((i2 & 8) != 0) {
            hubsDirectionEnum = getHubsQuery.direction;
        }
        if ((i2 & 16) != 0) {
            optional2 = getHubsQuery.query;
        }
        Optional optional3 = optional2;
        HubsSortEnum hubsSortEnum2 = hubsSortEnum;
        return getHubsQuery.copy(i, optional, hubsSortEnum2, hubsDirectionEnum, optional3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getFirst() {
        return this.first;
    }

    public final Optional<String> component2() {
        return this.after;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final HubsSortEnum getSort() {
        return this.sort;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final HubsDirectionEnum getDirection() {
        return this.direction;
    }

    public final Optional<String> component5() {
        return this.query;
    }

    public final GetHubsQuery copy(int first, Optional<String> after, HubsSortEnum sort, HubsDirectionEnum direction, Optional<String> query) {
        Intrinsics.checkNotNullParameter(after, "after");
        Intrinsics.checkNotNullParameter(sort, "sort");
        Intrinsics.checkNotNullParameter(direction, "direction");
        Intrinsics.checkNotNullParameter(query, "query");
        return new GetHubsQuery(first, after, sort, direction, query);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GetHubsQuery)) {
            return false;
        }
        GetHubsQuery getHubsQuery = (GetHubsQuery) other;
        return this.first == getHubsQuery.first && Intrinsics.areEqual(this.after, getHubsQuery.after) && this.sort == getHubsQuery.sort && this.direction == getHubsQuery.direction && Intrinsics.areEqual(this.query, getHubsQuery.query);
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.first) * 31) + this.after.hashCode()) * 31) + this.sort.hashCode()) * 31) + this.direction.hashCode()) * 31) + this.query.hashCode();
    }

    public String toString() {
        return "GetHubsQuery(first=" + this.first + ", after=" + this.after + ", sort=" + this.sort + ", direction=" + this.direction + ", query=" + this.query + ")";
    }

    public GetHubsQuery(int i, Optional<String> after, HubsSortEnum sort, HubsDirectionEnum direction, Optional<String> query) {
        Intrinsics.checkNotNullParameter(after, "after");
        Intrinsics.checkNotNullParameter(sort, "sort");
        Intrinsics.checkNotNullParameter(direction, "direction");
        Intrinsics.checkNotNullParameter(query, "query");
        this.first = i;
        this.after = after;
        this.sort = sort;
        this.direction = direction;
        this.query = query;
    }

    public final int getFirst() {
        return this.first;
    }

    public /* synthetic */ GetHubsQuery(int i, Optional.Absent absent, HubsSortEnum hubsSortEnum, HubsDirectionEnum hubsDirectionEnum, Optional.Absent absent2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? Optional.Absent.INSTANCE : absent, hubsSortEnum, hubsDirectionEnum, (i2 & 16) != 0 ? Optional.Absent.INSTANCE : absent2);
    }

    public final Optional<String> getAfter() {
        return this.after;
    }

    public final HubsSortEnum getSort() {
        return this.sort;
    }

    public final HubsDirectionEnum getDirection() {
        return this.direction;
    }

    public final Optional<String> getQuery() {
        return this.query;
    }

    @Override // com.apollographql.apollo3.api.Operation
    public String id() {
        return OPERATION_ID;
    }

    @Override // com.apollographql.apollo3.api.Operation
    public String document() {
        return INSTANCE.getOPERATION_DOCUMENT();
    }

    @Override // com.apollographql.apollo3.api.Operation
    public String name() {
        return OPERATION_NAME;
    }

    @Override // com.apollographql.apollo3.api.Operation, com.apollographql.apollo3.api.Executable
    public void serializeVariables(JsonWriter writer, CustomScalarAdapters customScalarAdapters) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
        GetHubsQuery_VariablesAdapter.INSTANCE.toJson(writer, customScalarAdapters, this);
    }

    @Override // com.apollographql.apollo3.api.Operation, com.apollographql.apollo3.api.Executable
    public Adapter<Data> adapter() {
        return Adapters.m11187obj$default(GetHubsQuery_ResponseAdapter.Data.INSTANCE, false, 1, null);
    }

    @Override // com.apollographql.apollo3.api.Operation, com.apollographql.apollo3.api.Executable
    public CompiledField rootField() {
        return new CompiledField.Builder("data", com.box.android.data.type.Query.INSTANCE.getType()).selections(GetHubsQuerySelections.INSTANCE.get__root()).build();
    }

    /* JADX INFO: compiled from: GetHubsQuery.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/data/GetHubsQuery$Data;", "Lcom/apollographql/apollo3/api/Query$Data;", "hubs", "Lcom/box/android/data/GetHubsQuery$Hubs;", "<init>", "(Lcom/box/android/data/GetHubsQuery$Hubs;)V", "getHubs", "()Lcom/box/android/data/GetHubsQuery$Hubs;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Data implements Query.Data {
        private final Hubs hubs;

        public static /* synthetic */ Data copy$default(Data data, Hubs hubs, int i, Object obj) {
            if ((i & 1) != 0) {
                hubs = data.hubs;
            }
            return data.copy(hubs);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Hubs getHubs() {
            return this.hubs;
        }

        public final Data copy(Hubs hubs) {
            return new Data(hubs);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Data) && Intrinsics.areEqual(this.hubs, ((Data) other).hubs);
        }

        public int hashCode() {
            Hubs hubs = this.hubs;
            if (hubs == null) {
                return 0;
            }
            return hubs.hashCode();
        }

        public String toString() {
            return "Data(hubs=" + this.hubs + ")";
        }

        public Data(Hubs hubs) {
            this.hubs = hubs;
        }

        public final Hubs getHubs() {
            return this.hubs;
        }
    }

    /* JADX INFO: compiled from: GetHubsQuery.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0010J4\u0010\u0015\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\bHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/box/android/data/GetHubsQuery$Hubs;", "", "edges", "", "Lcom/box/android/data/GetHubsQuery$Edge;", "pageInfo", "Lcom/box/android/data/GetHubsQuery$PageInfo;", "totalCount", "", "<init>", "(Ljava/util/List;Lcom/box/android/data/GetHubsQuery$PageInfo;Ljava/lang/Integer;)V", "getEdges", "()Ljava/util/List;", "getPageInfo", "()Lcom/box/android/data/GetHubsQuery$PageInfo;", "getTotalCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/util/List;Lcom/box/android/data/GetHubsQuery$PageInfo;Ljava/lang/Integer;)Lcom/box/android/data/GetHubsQuery$Hubs;", "equals", "", "other", "hashCode", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Hubs {
        private final List<Edge> edges;
        private final PageInfo pageInfo;
        private final Integer totalCount;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Hubs copy$default(Hubs hubs, List list, PageInfo pageInfo, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                list = hubs.edges;
            }
            if ((i & 2) != 0) {
                pageInfo = hubs.pageInfo;
            }
            if ((i & 4) != 0) {
                num = hubs.totalCount;
            }
            return hubs.copy(list, pageInfo, num);
        }

        public final List<Edge> component1() {
            return this.edges;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final PageInfo getPageInfo() {
            return this.pageInfo;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getTotalCount() {
            return this.totalCount;
        }

        public final Hubs copy(List<Edge> edges, PageInfo pageInfo, Integer totalCount) {
            Intrinsics.checkNotNullParameter(edges, "edges");
            Intrinsics.checkNotNullParameter(pageInfo, "pageInfo");
            return new Hubs(edges, pageInfo, totalCount);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Hubs)) {
                return false;
            }
            Hubs hubs = (Hubs) other;
            return Intrinsics.areEqual(this.edges, hubs.edges) && Intrinsics.areEqual(this.pageInfo, hubs.pageInfo) && Intrinsics.areEqual(this.totalCount, hubs.totalCount);
        }

        public int hashCode() {
            int iHashCode = ((this.edges.hashCode() * 31) + this.pageInfo.hashCode()) * 31;
            Integer num = this.totalCount;
            return iHashCode + (num == null ? 0 : num.hashCode());
        }

        public String toString() {
            return "Hubs(edges=" + this.edges + ", pageInfo=" + this.pageInfo + ", totalCount=" + this.totalCount + ")";
        }

        public Hubs(List<Edge> edges, PageInfo pageInfo, Integer num) {
            Intrinsics.checkNotNullParameter(edges, "edges");
            Intrinsics.checkNotNullParameter(pageInfo, "pageInfo");
            this.edges = edges;
            this.pageInfo = pageInfo;
            this.totalCount = num;
        }

        public final List<Edge> getEdges() {
            return this.edges;
        }

        public final PageInfo getPageInfo() {
            return this.pageInfo;
        }

        public final Integer getTotalCount() {
            return this.totalCount;
        }
    }

    /* JADX INFO: compiled from: GetHubsQuery.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/data/GetHubsQuery$Edge;", "", "node", "Lcom/box/android/data/GetHubsQuery$Node;", "<init>", "(Lcom/box/android/data/GetHubsQuery$Node;)V", "getNode", "()Lcom/box/android/data/GetHubsQuery$Node;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Edge {
        private final Node node;

        public static /* synthetic */ Edge copy$default(Edge edge, Node node, int i, Object obj) {
            if ((i & 1) != 0) {
                node = edge.node;
            }
            return edge.copy(node);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Node getNode() {
            return this.node;
        }

        public final Edge copy(Node node) {
            Intrinsics.checkNotNullParameter(node, "node");
            return new Edge(node);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Edge) && Intrinsics.areEqual(this.node, ((Edge) other).node);
        }

        public int hashCode() {
            return this.node.hashCode();
        }

        public String toString() {
            return "Edge(node=" + this.node + ")";
        }

        public Edge(Node node) {
            Intrinsics.checkNotNullParameter(node, "node");
            this.node = node;
        }

        public final Node getNode() {
            return this.node;
        }
    }

    /* JADX INFO: compiled from: GetHubsQuery.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\\\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u000bHÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011¨\u0006+"}, d2 = {"Lcom/box/android/data/GetHubsQuery$Node;", "", "id", "", "bannerImage", "Lcom/box/android/data/GetHubsQuery$BannerImage;", "iconImage", "Lcom/box/android/data/GetHubsQuery$IconImage;", "updatedAt", "Ljava/util/Date;", "accessCount", "", "title", "descriptionPreview", "<init>", "(Ljava/lang/String;Lcom/box/android/data/GetHubsQuery$BannerImage;Lcom/box/android/data/GetHubsQuery$IconImage;Ljava/util/Date;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getBannerImage", "()Lcom/box/android/data/GetHubsQuery$BannerImage;", "getIconImage", "()Lcom/box/android/data/GetHubsQuery$IconImage;", "getUpdatedAt", "()Ljava/util/Date;", "getAccessCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTitle", "getDescriptionPreview", "component1", "component2", "component3", "component4", "component5", "component6", "component7", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Lcom/box/android/data/GetHubsQuery$BannerImage;Lcom/box/android/data/GetHubsQuery$IconImage;Ljava/util/Date;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/box/android/data/GetHubsQuery$Node;", "equals", "", "other", "hashCode", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Node {
        private final Integer accessCount;
        private final BannerImage bannerImage;
        private final String descriptionPreview;
        private final IconImage iconImage;
        private final String id;
        private final String title;
        private final Date updatedAt;

        public static /* synthetic */ Node copy$default(Node node, String str, BannerImage bannerImage, IconImage iconImage, Date date, Integer num, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = node.id;
            }
            if ((i & 2) != 0) {
                bannerImage = node.bannerImage;
            }
            if ((i & 4) != 0) {
                iconImage = node.iconImage;
            }
            if ((i & 8) != 0) {
                date = node.updatedAt;
            }
            if ((i & 16) != 0) {
                num = node.accessCount;
            }
            if ((i & 32) != 0) {
                str2 = node.title;
            }
            if ((i & 64) != 0) {
                str3 = node.descriptionPreview;
            }
            String str4 = str2;
            String str5 = str3;
            Integer num2 = num;
            IconImage iconImage2 = iconImage;
            return node.copy(str, bannerImage, iconImage2, date, num2, str4, str5);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final BannerImage getBannerImage() {
            return this.bannerImage;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final IconImage getIconImage() {
            return this.iconImage;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Date getUpdatedAt() {
            return this.updatedAt;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Integer getAccessCount() {
            return this.accessCount;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getDescriptionPreview() {
            return this.descriptionPreview;
        }

        public final Node copy(String id, BannerImage bannerImage, IconImage iconImage, Date updatedAt, Integer accessCount, String title, String descriptionPreview) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(bannerImage, "bannerImage");
            Intrinsics.checkNotNullParameter(iconImage, "iconImage");
            return new Node(id, bannerImage, iconImage, updatedAt, accessCount, title, descriptionPreview);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Node)) {
                return false;
            }
            Node node = (Node) other;
            return Intrinsics.areEqual(this.id, node.id) && Intrinsics.areEqual(this.bannerImage, node.bannerImage) && Intrinsics.areEqual(this.iconImage, node.iconImage) && Intrinsics.areEqual(this.updatedAt, node.updatedAt) && Intrinsics.areEqual(this.accessCount, node.accessCount) && Intrinsics.areEqual(this.title, node.title) && Intrinsics.areEqual(this.descriptionPreview, node.descriptionPreview);
        }

        public int hashCode() {
            int iHashCode = ((((this.id.hashCode() * 31) + this.bannerImage.hashCode()) * 31) + this.iconImage.hashCode()) * 31;
            Date date = this.updatedAt;
            int iHashCode2 = (iHashCode + (date == null ? 0 : date.hashCode())) * 31;
            Integer num = this.accessCount;
            int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
            String str = this.title;
            int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.descriptionPreview;
            return iHashCode4 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "Node(id=" + this.id + ", bannerImage=" + this.bannerImage + ", iconImage=" + this.iconImage + ", updatedAt=" + this.updatedAt + ", accessCount=" + this.accessCount + ", title=" + this.title + ", descriptionPreview=" + this.descriptionPreview + ")";
        }

        public Node(String id, BannerImage bannerImage, IconImage iconImage, Date date, Integer num, String str, String str2) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(bannerImage, "bannerImage");
            Intrinsics.checkNotNullParameter(iconImage, "iconImage");
            this.id = id;
            this.bannerImage = bannerImage;
            this.iconImage = iconImage;
            this.updatedAt = date;
            this.accessCount = num;
            this.title = str;
            this.descriptionPreview = str2;
        }

        public final String getId() {
            return this.id;
        }

        public final BannerImage getBannerImage() {
            return this.bannerImage;
        }

        public final IconImage getIconImage() {
            return this.iconImage;
        }

        public final Date getUpdatedAt() {
            return this.updatedAt;
        }

        public final Integer getAccessCount() {
            return this.accessCount;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getDescriptionPreview() {
            return this.descriptionPreview;
        }
    }

    /* JADX INFO: compiled from: GetHubsQuery.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/box/android/data/GetHubsQuery$BannerImage;", "", "signedURL", "", "<init>", "(Ljava/lang/String;)V", "getSignedURL", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class BannerImage {
        private final String signedURL;

        public static /* synthetic */ BannerImage copy$default(BannerImage bannerImage, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = bannerImage.signedURL;
            }
            return bannerImage.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getSignedURL() {
            return this.signedURL;
        }

        public final BannerImage copy(String signedURL) {
            return new BannerImage(signedURL);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof BannerImage) && Intrinsics.areEqual(this.signedURL, ((BannerImage) other).signedURL);
        }

        public int hashCode() {
            String str = this.signedURL;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "BannerImage(signedURL=" + this.signedURL + ")";
        }

        public BannerImage(String str) {
            this.signedURL = str;
        }

        public final String getSignedURL() {
            return this.signedURL;
        }
    }

    /* JADX INFO: compiled from: GetHubsQuery.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/box/android/data/GetHubsQuery$IconImage;", "", "signedURL", "", "<init>", "(Ljava/lang/String;)V", "getSignedURL", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class IconImage {
        private final String signedURL;

        public static /* synthetic */ IconImage copy$default(IconImage iconImage, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = iconImage.signedURL;
            }
            return iconImage.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getSignedURL() {
            return this.signedURL;
        }

        public final IconImage copy(String signedURL) {
            return new IconImage(signedURL);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof IconImage) && Intrinsics.areEqual(this.signedURL, ((IconImage) other).signedURL);
        }

        public int hashCode() {
            String str = this.signedURL;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "IconImage(signedURL=" + this.signedURL + ")";
        }

        public IconImage(String str) {
            this.signedURL = str;
        }

        public final String getSignedURL() {
            return this.signedURL;
        }
    }

    /* JADX INFO: compiled from: GetHubsQuery.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/GetHubsQuery$PageInfo;", "", "endCursor", "", "hasNextPage", "", "<init>", "(Ljava/lang/String;Z)V", "getEndCursor", "()Ljava/lang/String;", "getHasNextPage", "()Z", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class PageInfo {
        private final String endCursor;
        private final boolean hasNextPage;

        public static /* synthetic */ PageInfo copy$default(PageInfo pageInfo, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = pageInfo.endCursor;
            }
            if ((i & 2) != 0) {
                z = pageInfo.hasNextPage;
            }
            return pageInfo.copy(str, z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getEndCursor() {
            return this.endCursor;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getHasNextPage() {
            return this.hasNextPage;
        }

        public final PageInfo copy(String endCursor, boolean hasNextPage) {
            return new PageInfo(endCursor, hasNextPage);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PageInfo)) {
                return false;
            }
            PageInfo pageInfo = (PageInfo) other;
            return Intrinsics.areEqual(this.endCursor, pageInfo.endCursor) && this.hasNextPage == pageInfo.hasNextPage;
        }

        public int hashCode() {
            String str = this.endCursor;
            return ((str == null ? 0 : str.hashCode()) * 31) + Boolean.hashCode(this.hasNextPage);
        }

        public String toString() {
            return "PageInfo(endCursor=" + this.endCursor + ", hasNextPage=" + this.hasNextPage + ")";
        }

        public PageInfo(String str, boolean z) {
            this.endCursor = str;
            this.hasNextPage = z;
        }

        public final String getEndCursor() {
            return this.endCursor;
        }

        public final boolean getHasNextPage() {
            return this.hasNextPage;
        }
    }

    /* JADX INFO: compiled from: GetHubsQuery.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/box/android/data/GetHubsQuery$Companion;", "", "<init>", "()V", "OPERATION_ID", "", "OPERATION_DOCUMENT", "getOPERATION_DOCUMENT", "()Ljava/lang/String;", "OPERATION_NAME", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getOPERATION_DOCUMENT() {
            return "query GetHubs($first: NonNegativeInt!, $after: String, $sort: HubsSortEnum!, $direction: HubsDirectionEnum!, $query: String) { hubs(first: $first, after: $after, sort: $sort, direction: $direction, query: $query) { edges { node { id bannerImage { signedURL } iconImage { signedURL } updatedAt accessCount title descriptionPreview } } pageInfo { endCursor hasNextPage } totalCount } }";
        }
    }
}
