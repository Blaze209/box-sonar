package com.box.android.data.selections;

import com.apollographql.apollo3.api.CompiledField;
import com.apollographql.apollo3.api.CompiledGraphQL;
import com.apollographql.apollo3.api.CompiledSelection;
import com.box.android.data.type.Collection;
import com.box.android.data.type.CollectionConnectionEdge;
import com.box.android.data.type.CollectionsConnection;
import com.box.android.data.type.GraphQLID;
import com.box.android.data.type.GraphQLString;
import com.box.androidsdk.content.models.BoxItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: GetAllCollectionsQuerySelections.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/data/selections/GetAllCollectionsQuerySelections;", "", "<init>", "()V", "__node", "", "Lcom/apollographql/apollo3/api/CompiledSelection;", "__edges", "__collections", "__root", "get__root", "()Ljava/util/List;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GetAllCollectionsQuerySelections {
    public static final GetAllCollectionsQuerySelections INSTANCE = new GetAllCollectionsQuerySelections();
    private static final List<CompiledSelection> __collections;
    private static final List<CompiledSelection> __edges;
    private static final List<CompiledSelection> __node;
    private static final List<CompiledSelection> __root;

    private GetAllCollectionsQuerySelections() {
    }

    static {
        List<CompiledSelection> listListOf = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("id", CompiledGraphQL.m11195notNull(GraphQLID.INSTANCE.getType())).build(), new CompiledField.Builder("collectionType", GraphQLString.INSTANCE.getType()).build(), new CompiledField.Builder("name", GraphQLString.INSTANCE.getType()).build()});
        __node = listListOf;
        List<CompiledSelection> listListOf2 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("cursor", GraphQLString.INSTANCE.getType()).alias("id").build(), new CompiledField.Builder("node", CompiledGraphQL.m11195notNull(Collection.INSTANCE.getType())).selections(listListOf).build()});
        __edges = listListOf2;
        List<CompiledSelection> listListOf3 = CollectionsKt.listOf(new CompiledField.Builder("edges", CompiledGraphQL.m11195notNull(CompiledGraphQL.m11194list(CollectionConnectionEdge.INSTANCE.getType()))).selections(listListOf2).build());
        __collections = listListOf3;
        __root = CollectionsKt.listOf(new CompiledField.Builder(BoxItem.FIELD_COLLECTIONS, CollectionsConnection.INSTANCE.getType()).selections(listListOf3).build());
    }

    public final List<CompiledSelection> get__root() {
        return __root;
    }
}
