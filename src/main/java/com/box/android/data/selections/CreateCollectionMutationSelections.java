package com.box.android.data.selections;

import com.apollographql.apollo3.api.CompiledArgument;
import com.apollographql.apollo3.api.CompiledField;
import com.apollographql.apollo3.api.CompiledGraphQL;
import com.apollographql.apollo3.api.CompiledSelection;
import com.apollographql.apollo3.api.CompiledVariable;
import com.box.android.data.type.Collection;
import com.box.android.data.type.GraphQLID;
import com.box.android.data.type.GraphQLString;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: compiled from: CreateCollectionMutationSelections.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/box/android/data/selections/CreateCollectionMutationSelections;", "", "<init>", "()V", "__createCollection", "", "Lcom/apollographql/apollo3/api/CompiledSelection;", "__root", "get__root", "()Ljava/util/List;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CreateCollectionMutationSelections {
    public static final CreateCollectionMutationSelections INSTANCE = new CreateCollectionMutationSelections();
    private static final List<CompiledSelection> __createCollection;
    private static final List<CompiledSelection> __root;

    private CreateCollectionMutationSelections() {
    }

    static {
        List<CompiledSelection> listListOf = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("id", CompiledGraphQL.m11195notNull(GraphQLID.INSTANCE.getType())).build(), new CompiledField.Builder("name", GraphQLString.INSTANCE.getType()).build(), new CompiledField.Builder("collectionType", GraphQLString.INSTANCE.getType()).build()});
        __createCollection = listListOf;
        __root = CollectionsKt.listOf(new CompiledField.Builder("createCollection", Collection.INSTANCE.getType()).arguments(CollectionsKt.listOf(new CompiledArgument.Builder("input", MapsKt.mapOf(TuplesKt.to("name", new CompiledVariable("name")))).build())).selections(listListOf).build());
    }

    public final List<CompiledSelection> get__root() {
        return __root;
    }
}
