package com.box.android.data.selections;

import com.apollographql.apollo3.api.CompiledField;
import com.apollographql.apollo3.api.CompiledGraphQL;
import com.apollographql.apollo3.api.CompiledSelection;
import com.box.android.data.CreateUnpublishedHubMutation;
import com.box.android.data.type.CreateUnpublishedHubResponse;
import com.box.android.data.type.Error;
import com.box.android.data.type.GraphQLID;
import com.box.android.data.type.GraphQLString;
import com.box.android.data.type.HubReference;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: CreateUnpublishedHubMutationSelections.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/data/selections/CreateUnpublishedHubMutationSelections;", "", "<init>", "()V", "__value", "", "Lcom/apollographql/apollo3/api/CompiledSelection;", "__errors", "__createUnpublishedHub", "__root", "get__root", "()Ljava/util/List;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CreateUnpublishedHubMutationSelections {
    public static final CreateUnpublishedHubMutationSelections INSTANCE = new CreateUnpublishedHubMutationSelections();
    private static final List<CompiledSelection> __createUnpublishedHub;
    private static final List<CompiledSelection> __errors;
    private static final List<CompiledSelection> __root;
    private static final List<CompiledSelection> __value;

    private CreateUnpublishedHubMutationSelections() {
    }

    static {
        List<CompiledSelection> listListOf = CollectionsKt.listOf(new CompiledField.Builder("id", CompiledGraphQL.m11195notNull(GraphQLID.INSTANCE.getType())).build());
        __value = listListOf;
        List<CompiledSelection> listListOf2 = CollectionsKt.listOf(new CompiledField.Builder("message", CompiledGraphQL.m11195notNull(GraphQLString.INSTANCE.getType())).build());
        __errors = listListOf2;
        List<CompiledSelection> listListOf3 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("value", HubReference.INSTANCE.getType()).selections(listListOf).build(), new CompiledField.Builder(BoxAnalyticsParams.CATEGORY_ERRORS, CompiledGraphQL.m11195notNull(CompiledGraphQL.m11194list(CompiledGraphQL.m11195notNull(Error.INSTANCE.getType())))).selections(listListOf2).build()});
        __createUnpublishedHub = listListOf3;
        __root = CollectionsKt.listOf(new CompiledField.Builder(CreateUnpublishedHubMutation.OPERATION_NAME, CompiledGraphQL.m11195notNull(CreateUnpublishedHubResponse.INSTANCE.getType())).selections(listListOf3).build());
    }

    public final List<CompiledSelection> get__root() {
        return __root;
    }
}
