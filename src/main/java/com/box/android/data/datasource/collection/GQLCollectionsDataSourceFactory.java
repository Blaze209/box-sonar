package com.box.android.data.datasource.collection;

import androidx.paging.DataSource;
import com.box.android.data.datasource.gql.BoxGraphQL;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.models.CollectionModel;
import com.box.android.domain.models.CollectionType;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import java.util.Comparator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GQLCollectionsDataSourceFactory.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B7\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u0014\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/box/android/data/datasource/collection/GQLCollectionsDataSourceFactory;", "Landroidx/paging/DataSource$Factory;", "", "Lcom/box/android/domain/models/CollectionModel;", "graphQL", "Lcom/box/android/data/datasource/gql/BoxGraphQL;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "collectionTypes", "", "Lcom/box/android/domain/models/CollectionType;", "comparator", "Ljava/util/Comparator;", "<init>", "(Lcom/box/android/data/datasource/gql/BoxGraphQL;Lcom/box/android/domain/identity/IUserContextManager;Ljava/util/List;Ljava/util/Comparator;)V", PasskeyWebListener.CREATE_UNIQUE_KEY, "Landroidx/paging/DataSource;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLCollectionsDataSourceFactory extends DataSource.Factory<Integer, CollectionModel> {
    private final List<CollectionType> collectionTypes;
    private final Comparator<CollectionModel> comparator;
    private final BoxGraphQL graphQL;
    private final IUserContextManager userContextManager;

    /* JADX WARN: Multi-variable type inference failed */
    @Inject
    public GQLCollectionsDataSourceFactory(BoxGraphQL graphQL, IUserContextManager userContextManager, List<? extends CollectionType> collectionTypes, Comparator<CollectionModel> comparator) {
        Intrinsics.checkNotNullParameter(graphQL, "graphQL");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(collectionTypes, "collectionTypes");
        this.graphQL = graphQL;
        this.userContextManager = userContextManager;
        this.collectionTypes = collectionTypes;
        this.comparator = comparator;
    }

    @Override // androidx.paging.DataSource.Factory
    public DataSource<Integer, CollectionModel> create() {
        return new GQLCollectionsDataSource(this.graphQL, this.collectionTypes, this.comparator);
    }
}
