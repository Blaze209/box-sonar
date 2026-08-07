package com.box.android.data.mappers;

import com.box.android.data.GetItemQuery;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.ItemType;
import com.box.android.domain.models.item.WebLinkModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GQLGetItemQueryDataToItemModelMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/box/android/data/mappers/GQLGetItemQueryDataToItemModelMapper;", "Lcom/box/android/data/mappers/GraphQLMapper;", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/data/GetItemQuery$Data;", "<init>", "()V", "toGraphQL", "source", "options", "", "fromGraphQL", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLGetItemQueryDataToItemModelMapper implements GraphQLMapper<ItemModel, GetItemQuery.Data> {
    public static final GQLGetItemQueryDataToItemModelMapper INSTANCE = new GQLGetItemQueryDataToItemModelMapper();

    private GQLGetItemQueryDataToItemModelMapper() {
    }

    @Override // com.box.android.data.mappers.GraphQLMapper
    public GetItemQuery.Data toGraphQL(ItemModel source, Object options) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (source instanceof FileModel) {
            return new GetItemQuery.Data(new GetItemQuery.Item(TypenameMapperKt.toGQLTypename(ItemType.FILE), (GetItemQuery.OnFile) GraphQLMapper.toGraphQL$default(GQLGetFileByIDFileToFileModelMapper.INSTANCE, source, null, 2, null), null, null));
        }
        if (source instanceof FolderModel) {
            return new GetItemQuery.Data(new GetItemQuery.Item(TypenameMapperKt.toGQLTypename(ItemType.FOLDER), null, (GetItemQuery.OnFolder) GraphQLMapper.toGraphQL$default(GQLGetFolderByIDFolderToFolderModelMapper.INSTANCE, source, null, 2, null), null));
        }
        if (source instanceof WebLinkModel) {
            return new GetItemQuery.Data(new GetItemQuery.Item(TypenameMapperKt.toGQLTypename(ItemType.WEBLINK), null, null, (GetItemQuery.OnWeblink) GraphQLMapper.toGraphQL$default(GQLGetWeblinkByIDWeblinkToWeblinkModelMapper.INSTANCE, source, null, 2, null)));
        }
        return null;
    }

    @Override // com.box.android.data.mappers.GraphQLMapper
    public ItemModel fromGraphQL(GetItemQuery.Data source, Object options) throws Exception {
        GetItemQuery.OnWeblink onWeblink;
        GetItemQuery.OnFolder onFolder;
        GetItemQuery.OnFile onFile;
        FileModel fileModel;
        Intrinsics.checkNotNullParameter(source, "source");
        GetItemQuery.Item item = source.getItem();
        WebLinkModel webLinkModel = null;
        if (item != null && (onFile = item.getOnFile()) != null && (fileModel = (FileModel) GraphQLMapper.fromGraphQL$default(GQLGetFileByIDFileToFileModelMapper.INSTANCE, onFile, null, 2, null)) != null) {
            return fileModel;
        }
        GetItemQuery.Item item2 = source.getItem();
        if (item2 != null && (onFolder = item2.getOnFolder()) != null) {
            return (FolderModel) GraphQLMapper.fromGraphQL$default(GQLGetFolderByIDFolderToFolderModelMapper.INSTANCE, onFolder, null, 2, null);
        }
        GetItemQuery.Item item3 = source.getItem();
        if (item3 != null && (onWeblink = item3.getOnWeblink()) != null) {
            webLinkModel = (WebLinkModel) GraphQLMapper.fromGraphQL$default(GQLGetWeblinkByIDWeblinkToWeblinkModelMapper.INSTANCE, onWeblink, null, 2, null);
        }
        if (webLinkModel != null) {
            return webLinkModel;
        }
        throw new Exception("Unexpected node: " + source.getItem());
    }
}
