package com.box.android.data.datasource.gql;

import com.apollographql.apollo3.ApolloClient;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GQLApolloClientConfigurator.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class GQLApolloClientConfigurator$getApolloClient$result$1 extends FunctionReferenceImpl implements Function1<String, ApolloClient> {
    GQLApolloClientConfigurator$getApolloClient$result$1(Object obj) {
        super(1, obj, GQLApolloClientConfigurator.class, "createApolloClient", "createApolloClient$data_generalProdRelease(Ljava/lang/String;)Lcom/apollographql/apollo3/ApolloClient;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final ApolloClient invoke(String p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((GQLApolloClientConfigurator) this.receiver).createApolloClient$data_generalProdRelease(p0);
    }
}
