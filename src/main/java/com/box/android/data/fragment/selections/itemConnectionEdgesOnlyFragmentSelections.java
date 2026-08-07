package com.box.android.data.fragment.selections;

import com.apollographql.apollo3.api.CompiledField;
import com.apollographql.apollo3.api.CompiledGraphQL;
import com.apollographql.apollo3.api.CompiledSelection;
import com.box.android.data.type.FolderItemConnectionEdge;
import com.box.android.data.type.GraphQLInt;
import com.box.android.data.type.GraphQLString;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: itemConnectionEdgesOnlyFragmentSelections.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/box/android/data/fragment/selections/itemConnectionEdgesOnlyFragmentSelections;", "", "<init>", "()V", "__edges", "", "Lcom/apollographql/apollo3/api/CompiledSelection;", "__root", "get__root", "()Ljava/util/List;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class itemConnectionEdgesOnlyFragmentSelections {
    public static final itemConnectionEdgesOnlyFragmentSelections INSTANCE = new itemConnectionEdgesOnlyFragmentSelections();
    private static final List<CompiledSelection> __edges;
    private static final List<CompiledSelection> __root;

    private itemConnectionEdgesOnlyFragmentSelections() {
    }

    static {
        List<CompiledSelection> listListOf = CollectionsKt.listOf(new CompiledField.Builder("cursor", GraphQLString.INSTANCE.getType()).alias("id").build());
        __edges = listListOf;
        __root = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("totalCount", CompiledGraphQL.m11195notNull(GraphQLInt.INSTANCE.getType())).build(), new CompiledField.Builder("edges", CompiledGraphQL.m11195notNull(CompiledGraphQL.m11194list(CompiledGraphQL.m11195notNull(FolderItemConnectionEdge.INSTANCE.getType())))).selections(listListOf).build()});
    }

    public final List<CompiledSelection> get__root() {
        return __root;
    }
}
