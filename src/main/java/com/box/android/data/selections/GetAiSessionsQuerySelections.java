package com.box.android.data.selections;

import com.apollographql.apollo3.api.CompiledArgument;
import com.apollographql.apollo3.api.CompiledField;
import com.apollographql.apollo3.api.CompiledFragment;
import com.apollographql.apollo3.api.CompiledGraphQL;
import com.apollographql.apollo3.api.CompiledSelection;
import com.apollographql.apollo3.api.CompiledVariable;
import com.box.android.data.datasource.gql.cache.GQLCacheConstants;
import com.box.android.data.type.AiAgentSession;
import com.box.android.data.type.GraphQLID;
import com.box.android.data.type.GraphQLString;
import com.box.android.data.type.ItemV2;
import com.box.android.data.type.ItemV2Connection;
import com.box.android.data.type.ItemV2Data;
import com.box.android.data.type.ItemV2Edge;
import com.box.androidsdk.content.models.BoxIterator;
import com.box.androidsdk.content.models.BoxOrder;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: compiled from: GetAiSessionsQuerySelections.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/box/android/data/selections/GetAiSessionsQuerySelections;", "", "<init>", "()V", "__aiAgentSession", "", "Lcom/apollographql/apollo3/api/CompiledSelection;", "__onAiSessionData", "__data", "__node", "__edges", "__itemV2s", "__root", "get__root", "()Ljava/util/List;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GetAiSessionsQuerySelections {
    public static final GetAiSessionsQuerySelections INSTANCE = new GetAiSessionsQuerySelections();
    private static final List<CompiledSelection> __aiAgentSession;
    private static final List<CompiledSelection> __data;
    private static final List<CompiledSelection> __edges;
    private static final List<CompiledSelection> __itemV2s;
    private static final List<CompiledSelection> __node;
    private static final List<CompiledSelection> __onAiSessionData;
    private static final List<CompiledSelection> __root;

    private GetAiSessionsQuerySelections() {
    }

    static {
        List<CompiledSelection> listListOf = CollectionsKt.listOf(new CompiledField.Builder("name", GraphQLString.INSTANCE.getType()).build());
        __aiAgentSession = listListOf;
        List<CompiledSelection> listListOf2 = CollectionsKt.listOf(new CompiledField.Builder("aiAgentSession", AiAgentSession.INSTANCE.getType()).selections(listListOf).build());
        __onAiSessionData = listListOf2;
        List<CompiledSelection> listListOf3 = CollectionsKt.listOf((Object[]) new CompiledSelection[]{new CompiledField.Builder(GQLCacheConstants.TYPENAME_KEY, CompiledGraphQL.m11195notNull(GraphQLString.INSTANCE.getType())).build(), new CompiledFragment.Builder("AiSessionData", CollectionsKt.listOf("AiSessionData")).selections(listListOf2).build()});
        __data = listListOf3;
        List<CompiledSelection> listListOf4 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("id", CompiledGraphQL.m11195notNull(GraphQLID.INSTANCE.getType())).build(), new CompiledField.Builder("name", GraphQLString.INSTANCE.getType()).build(), new CompiledField.Builder("data", ItemV2Data.INSTANCE.getType()).selections(listListOf3).build()});
        __node = listListOf4;
        List<CompiledSelection> listListOf5 = CollectionsKt.listOf(new CompiledField.Builder("node", ItemV2.INSTANCE.getType()).selections(listListOf4).build());
        __edges = listListOf5;
        List<CompiledSelection> listListOf6 = CollectionsKt.listOf(new CompiledField.Builder("edges", CompiledGraphQL.m11195notNull(CompiledGraphQL.m11194list(CompiledGraphQL.m11195notNull(ItemV2Edge.INSTANCE.getType())))).selections(listListOf5).build());
        __itemV2s = listListOf6;
        __root = CollectionsKt.listOf(new CompiledField.Builder("itemV2s", CompiledGraphQL.m11195notNull(ItemV2Connection.INSTANCE.getType())).arguments(CollectionsKt.listOf(new CompiledArgument.Builder("request", MapsKt.mapOf(TuplesKt.to("query", MapsKt.mapOf(TuplesKt.to("itemFilter", MapsKt.mapOf(TuplesKt.to("type", "ai_session"))))), TuplesKt.to("orderBy", CollectionsKt.listOf(MapsKt.mapOf(TuplesKt.to("field", "CREATED_AT"), TuplesKt.to("direction", BoxOrder.DIRECTION_DESCENDING)))), TuplesKt.to(BoxIterator.FIELD_LIMIT, new CompiledVariable(BoxIterator.FIELD_LIMIT)), TuplesKt.to("includeTotalCount", false))).build())).selections(listListOf6).build());
    }

    public final List<CompiledSelection> get__root() {
        return __root;
    }
}
