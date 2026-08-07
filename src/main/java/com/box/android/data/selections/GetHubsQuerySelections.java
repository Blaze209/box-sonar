package com.box.android.data.selections;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.apollographql.apollo3.api.CompiledArgument;
import com.apollographql.apollo3.api.CompiledField;
import com.apollographql.apollo3.api.CompiledGraphQL;
import com.apollographql.apollo3.api.CompiledSelection;
import com.apollographql.apollo3.api.CompiledVariable;
import com.box.android.data.type.DateTime;
import com.box.android.data.type.GraphQLBoolean;
import com.box.android.data.type.GraphQLID;
import com.box.android.data.type.GraphQLInt;
import com.box.android.data.type.GraphQLString;
import com.box.android.data.type.HubConnectionEdge;
import com.box.android.data.type.HubMini;
import com.box.android.data.type.HubsAsset;
import com.box.android.data.type.HubsConnection;
import com.box.android.data.type.NonNegativeInt;
import com.box.android.data.type.PageInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: GetHubsQuerySelections.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/box/android/data/selections/GetHubsQuerySelections;", "", "<init>", "()V", "__bannerImage", "", "Lcom/apollographql/apollo3/api/CompiledSelection;", "__iconImage", "__node", "__edges", "__pageInfo", "__hubs", "__root", "get__root", "()Ljava/util/List;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GetHubsQuerySelections {
    public static final GetHubsQuerySelections INSTANCE = new GetHubsQuerySelections();
    private static final List<CompiledSelection> __bannerImage;
    private static final List<CompiledSelection> __edges;
    private static final List<CompiledSelection> __hubs;
    private static final List<CompiledSelection> __iconImage;
    private static final List<CompiledSelection> __node;
    private static final List<CompiledSelection> __pageInfo;
    private static final List<CompiledSelection> __root;

    private GetHubsQuerySelections() {
    }

    static {
        List<CompiledSelection> listListOf = CollectionsKt.listOf(new CompiledField.Builder("signedURL", GraphQLString.INSTANCE.getType()).build());
        __bannerImage = listListOf;
        List<CompiledSelection> listListOf2 = CollectionsKt.listOf(new CompiledField.Builder("signedURL", GraphQLString.INSTANCE.getType()).build());
        __iconImage = listListOf2;
        List<CompiledSelection> listListOf3 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("id", CompiledGraphQL.m11195notNull(GraphQLID.INSTANCE.getType())).build(), new CompiledField.Builder("bannerImage", CompiledGraphQL.m11195notNull(HubsAsset.INSTANCE.getType())).selections(listListOf).build(), new CompiledField.Builder("iconImage", CompiledGraphQL.m11195notNull(HubsAsset.INSTANCE.getType())).selections(listListOf2).build(), new CompiledField.Builder("updatedAt", DateTime.INSTANCE.getType()).build(), new CompiledField.Builder("accessCount", NonNegativeInt.INSTANCE.getType()).build(), new CompiledField.Builder("title", GraphQLString.INSTANCE.getType()).build(), new CompiledField.Builder("descriptionPreview", GraphQLString.INSTANCE.getType()).build()});
        __node = listListOf3;
        List<CompiledSelection> listListOf4 = CollectionsKt.listOf(new CompiledField.Builder("node", CompiledGraphQL.m11195notNull(HubMini.INSTANCE.getType())).selections(listListOf3).build());
        __edges = listListOf4;
        List<CompiledSelection> listListOf5 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("endCursor", GraphQLString.INSTANCE.getType()).build(), new CompiledField.Builder("hasNextPage", CompiledGraphQL.m11195notNull(GraphQLBoolean.INSTANCE.getType())).build()});
        __pageInfo = listListOf5;
        List<CompiledSelection> listListOf6 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("edges", CompiledGraphQL.m11195notNull(CompiledGraphQL.m11194list(CompiledGraphQL.m11195notNull(HubConnectionEdge.INSTANCE.getType())))).selections(listListOf4).build(), new CompiledField.Builder("pageInfo", CompiledGraphQL.m11195notNull(PageInfo.INSTANCE.getType())).selections(listListOf5).build(), new CompiledField.Builder("totalCount", GraphQLInt.INSTANCE.getType()).build()});
        __hubs = listListOf6;
        __root = CollectionsKt.listOf(new CompiledField.Builder("hubs", HubsConnection.INSTANCE.getType()).arguments(CollectionsKt.listOf((Object[]) new CompiledArgument[]{new CompiledArgument.Builder(TtmlNode.ANNOTATION_POSITION_AFTER, new CompiledVariable(TtmlNode.ANNOTATION_POSITION_AFTER)).build(), new CompiledArgument.Builder("direction", new CompiledVariable("direction")).build(), new CompiledArgument.Builder("first", new CompiledVariable("first")).build(), new CompiledArgument.Builder("query", new CompiledVariable("query")).build(), new CompiledArgument.Builder("sort", new CompiledVariable("sort")).build()})).selections(listListOf6).build());
    }

    public final List<CompiledSelection> get__root() {
        return __root;
    }
}
