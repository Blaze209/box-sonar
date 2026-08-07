package com.box.android.data.fragment.selections;

import com.apollographql.apollo3.api.CompiledField;
import com.apollographql.apollo3.api.CompiledGraphQL;
import com.apollographql.apollo3.api.CompiledSelection;
import com.box.android.data.type.GraphQLID;
import com.box.android.data.type.GraphQLString;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: collectionFragmentsSelections.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/box/android/data/fragment/selections/collectionFragmentsSelections;", "", "<init>", "()V", "__root", "", "Lcom/apollographql/apollo3/api/CompiledSelection;", "get__root", "()Ljava/util/List;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class collectionFragmentsSelections {
    public static final collectionFragmentsSelections INSTANCE = new collectionFragmentsSelections();
    private static final List<CompiledSelection> __root = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("id", CompiledGraphQL.m11195notNull(GraphQLID.INSTANCE.getType())).build(), new CompiledField.Builder("name", GraphQLString.INSTANCE.getType()).build(), new CompiledField.Builder("collectionType", GraphQLString.INSTANCE.getType()).build()});

    private collectionFragmentsSelections() {
    }

    public final List<CompiledSelection> get__root() {
        return __root;
    }
}
