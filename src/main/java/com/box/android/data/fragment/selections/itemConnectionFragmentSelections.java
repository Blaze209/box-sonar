package com.box.android.data.fragment.selections;

import com.apollographql.apollo3.api.CompiledField;
import com.apollographql.apollo3.api.CompiledFragment;
import com.apollographql.apollo3.api.CompiledGraphQL;
import com.apollographql.apollo3.api.CompiledSelection;
import com.box.android.data.datasource.gql.cache.GQLCacheConstants;
import com.box.android.data.type.FolderItemConnectionEdge;
import com.box.android.data.type.GraphQLInt;
import com.box.android.data.type.GraphQLString;
import com.box.android.data.type.Item;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: itemConnectionFragmentSelections.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/box/android/data/fragment/selections/itemConnectionFragmentSelections;", "", "<init>", "()V", "__node", "", "Lcom/apollographql/apollo3/api/CompiledSelection;", "__edges", "__root", "get__root", "()Ljava/util/List;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class itemConnectionFragmentSelections {
    public static final itemConnectionFragmentSelections INSTANCE = new itemConnectionFragmentSelections();
    private static final List<CompiledSelection> __edges;
    private static final List<CompiledSelection> __node;
    private static final List<CompiledSelection> __root;

    private itemConnectionFragmentSelections() {
    }

    static {
        List<CompiledSelection> listListOf = CollectionsKt.listOf((Object[]) new CompiledSelection[]{new CompiledField.Builder(GQLCacheConstants.TYPENAME_KEY, CompiledGraphQL.m11195notNull(GraphQLString.INSTANCE.getType())).build(), new CompiledFragment.Builder("File", CollectionsKt.listOf("File")).selections(fileFieldsSelections.INSTANCE.get__root()).build(), new CompiledFragment.Builder("Folder", CollectionsKt.listOf("Folder")).selections(folderFieldsSelections.INSTANCE.get__root()).build(), new CompiledFragment.Builder("Weblink", CollectionsKt.listOf("Weblink")).selections(weblinkFieldsSelections.INSTANCE.get__root()).build()});
        __node = listListOf;
        List<CompiledSelection> listListOf2 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("cursor", GraphQLString.INSTANCE.getType()).alias("id").build(), new CompiledField.Builder("node", CompiledGraphQL.m11195notNull(Item.INSTANCE.getType())).selections(listListOf).build()});
        __edges = listListOf2;
        __root = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("totalCount", CompiledGraphQL.m11195notNull(GraphQLInt.INSTANCE.getType())).build(), new CompiledField.Builder("edges", CompiledGraphQL.m11195notNull(CompiledGraphQL.m11194list(CompiledGraphQL.m11195notNull(FolderItemConnectionEdge.INSTANCE.getType())))).selections(listListOf2).build()});
    }

    public final List<CompiledSelection> get__root() {
        return __root;
    }
}
