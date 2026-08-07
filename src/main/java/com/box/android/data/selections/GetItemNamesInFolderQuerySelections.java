package com.box.android.data.selections;

import com.apollographql.apollo3.api.CompiledArgument;
import com.apollographql.apollo3.api.CompiledField;
import com.apollographql.apollo3.api.CompiledFragment;
import com.apollographql.apollo3.api.CompiledGraphQL;
import com.apollographql.apollo3.api.CompiledSelection;
import com.apollographql.apollo3.api.CompiledVariable;
import com.box.android.data.datasource.gql.cache.GQLCacheConstants;
import com.box.android.data.type.Folder;
import com.box.android.data.type.FolderItemConnection;
import com.box.android.data.type.FolderItemConnectionEdge;
import com.box.android.data.type.GraphQLID;
import com.box.android.data.type.GraphQLString;
import com.box.android.data.type.Item;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: GetItemNamesInFolderQuerySelections.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/box/android/data/selections/GetItemNamesInFolderQuerySelections;", "", "<init>", "()V", "__onCoreItem", "", "Lcom/apollographql/apollo3/api/CompiledSelection;", "__node", "__edges", "__itemConnection", "__folder", "__root", "get__root", "()Ljava/util/List;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GetItemNamesInFolderQuerySelections {
    public static final GetItemNamesInFolderQuerySelections INSTANCE = new GetItemNamesInFolderQuerySelections();
    private static final List<CompiledSelection> __edges;
    private static final List<CompiledSelection> __folder;
    private static final List<CompiledSelection> __itemConnection;
    private static final List<CompiledSelection> __node;
    private static final List<CompiledSelection> __onCoreItem;
    private static final List<CompiledSelection> __root;

    private GetItemNamesInFolderQuerySelections() {
    }

    static {
        List<CompiledSelection> listListOf = CollectionsKt.listOf(new CompiledField.Builder("name", GraphQLString.INSTANCE.getType()).build());
        __onCoreItem = listListOf;
        List<CompiledSelection> listListOf2 = CollectionsKt.listOf((Object[]) new CompiledSelection[]{new CompiledField.Builder(GQLCacheConstants.TYPENAME_KEY, CompiledGraphQL.m11195notNull(GraphQLString.INSTANCE.getType())).build(), new CompiledFragment.Builder("CoreItem", CollectionsKt.listOf((Object[]) new String[]{"File", "Folder", "Weblink"})).selections(listListOf).build()});
        __node = listListOf2;
        List<CompiledSelection> listListOf3 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("cursor", GraphQLString.INSTANCE.getType()).alias("id").build(), new CompiledField.Builder("node", CompiledGraphQL.m11195notNull(Item.INSTANCE.getType())).selections(listListOf2).build()});
        __edges = listListOf3;
        List<CompiledSelection> listListOf4 = CollectionsKt.listOf(new CompiledField.Builder("edges", CompiledGraphQL.m11195notNull(CompiledGraphQL.m11194list(CompiledGraphQL.m11195notNull(FolderItemConnectionEdge.INSTANCE.getType())))).selections(listListOf3).build());
        __itemConnection = listListOf4;
        List<CompiledSelection> listListOf5 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("id", CompiledGraphQL.m11195notNull(GraphQLID.INSTANCE.getType())).build(), new CompiledField.Builder("itemConnection", FolderItemConnection.INSTANCE.getType()).selections(listListOf4).build()});
        __folder = listListOf5;
        __root = CollectionsKt.listOf(new CompiledField.Builder("folder", Folder.INSTANCE.getType()).arguments(CollectionsKt.listOf(new CompiledArgument.Builder("id", new CompiledVariable("folderID")).build())).selections(listListOf5).build());
    }

    public final List<CompiledSelection> get__root() {
        return __root;
    }
}
