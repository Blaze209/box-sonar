package com.box.android.data.mappers;

import com.box.android.data.GetAllCollectionsQuery;
import com.box.android.domain.models.CollectionModel;
import com.box.android.domain.models.CollectionType;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollectionsQueryDomainMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/box/android/data/mappers/CollectionsQueryDomainMapper;", "Lcom/box/android/data/mappers/DomainMapper;", "Lcom/box/android/domain/models/CollectionModel;", "Lcom/box/android/data/GetAllCollectionsQuery$Node;", "<init>", "()V", "toDomain", "dataModel", "fromDomain", "domainModel", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CollectionsQueryDomainMapper implements DomainMapper<CollectionModel, GetAllCollectionsQuery.Node> {
    public static final CollectionsQueryDomainMapper INSTANCE = new CollectionsQueryDomainMapper();

    private CollectionsQueryDomainMapper() {
    }

    @Override // com.box.android.data.mappers.DomainMapper
    public CollectionModel toDomain(GetAllCollectionsQuery.Node dataModel) {
        String collectionType;
        if (dataModel == null || (collectionType = dataModel.getCollectionType()) == null) {
            return null;
        }
        BoxLogUtils.v(ExtensionsKt.getTAG(INSTANCE), "converting to CollectionModel (" + dataModel.getName() + ")");
        String id = dataModel.getId();
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String upperCase = collectionType.toUpperCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        CollectionType collectionTypeValueOf = CollectionType.valueOf(upperCase);
        String name = dataModel.getName();
        if (name == null) {
            name = "";
        }
        return new CollectionModel(id, collectionTypeValueOf, name, null, null);
    }

    @Override // com.box.android.data.mappers.DomainMapper
    public GetAllCollectionsQuery.Node fromDomain(CollectionModel domainModel) {
        Intrinsics.checkNotNullParameter(domainModel, "domainModel");
        String id = domainModel.getId();
        String strName = domainModel.getType().name();
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String lowerCase = strName.toLowerCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return new GetAllCollectionsQuery.Node(id, lowerCase, domainModel.getName());
    }
}
