package com.box.android.data.mappers;

import com.box.android.data.CreateCollectionMutation;
import com.box.android.domain.models.CollectionModel;
import com.box.android.domain.models.CollectionType;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GQLCreateCollectionToCollectionModelMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/box/android/data/mappers/GQLCreateCollectionToCollectionModelMapper;", "Lcom/box/android/data/mappers/GraphQLMapper;", "Lcom/box/android/domain/models/CollectionModel;", "Lcom/box/android/data/CreateCollectionMutation$CreateCollection;", "<init>", "()V", "toGraphQL", "source", "options", "", "fromGraphQL", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLCreateCollectionToCollectionModelMapper implements GraphQLMapper<CollectionModel, CreateCollectionMutation.CreateCollection> {
    public static final GQLCreateCollectionToCollectionModelMapper INSTANCE = new GQLCreateCollectionToCollectionModelMapper();

    private GQLCreateCollectionToCollectionModelMapper() {
    }

    @Override // com.box.android.data.mappers.GraphQLMapper
    public CreateCollectionMutation.CreateCollection toGraphQL(CollectionModel source, Object options) {
        Intrinsics.checkNotNullParameter(source, "source");
        return new CreateCollectionMutation.CreateCollection(source.getId(), source.getName(), source.getType().name());
    }

    @Override // com.box.android.data.mappers.GraphQLMapper
    public CollectionModel fromGraphQL(CreateCollectionMutation.CreateCollection source, Object options) {
        Intrinsics.checkNotNullParameter(source, "source");
        String id = source.getId();
        String collectionType = source.getCollectionType();
        Intrinsics.checkNotNull(collectionType);
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String upperCase = collectionType.toUpperCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        CollectionType collectionTypeValueOf = CollectionType.valueOf(upperCase);
        String name = source.getName();
        Intrinsics.checkNotNull(name);
        return new CollectionModel(id, collectionTypeValueOf, name, null, null);
    }
}
