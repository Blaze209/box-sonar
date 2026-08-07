package com.box.android.data.datasource.collection;

import androidx.paging.DataSource;
import com.box.android.coreservices.jobmanager.jobs.BoxItemJob;
import com.box.android.data.GetCollectionItemsQuery;
import com.box.android.data.datasource.gql.BoxGraphQL;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GQLCollectionItemsDataSourceFactory.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/box/android/data/datasource/collection/GQLCollectionItemsDataSourceFactory;", "Landroidx/paging/DataSource$Factory;", "", "Lcom/box/android/data/GetCollectionItemsQuery$Node;", "graphQL", "Lcom/box/android/data/datasource/gql/BoxGraphQL;", BoxItemJob.COLLECTION_ID, "<init>", "(Lcom/box/android/data/datasource/gql/BoxGraphQL;Ljava/lang/String;)V", PasskeyWebListener.CREATE_UNIQUE_KEY, "Landroidx/paging/DataSource;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLCollectionItemsDataSourceFactory extends DataSource.Factory<String, GetCollectionItemsQuery.Node> {
    private final String collectionId;
    private final BoxGraphQL graphQL;

    @Inject
    public GQLCollectionItemsDataSourceFactory(BoxGraphQL graphQL, String collectionId) {
        Intrinsics.checkNotNullParameter(graphQL, "graphQL");
        Intrinsics.checkNotNullParameter(collectionId, "collectionId");
        this.graphQL = graphQL;
        this.collectionId = collectionId;
    }

    @Override // androidx.paging.DataSource.Factory
    public DataSource<String, GetCollectionItemsQuery.Node> create() {
        return new GQLCollectionItemsDataSource(this.graphQL, this.collectionId);
    }
}
