package com.box.android.data.mappers;

import com.box.android.data.GetItemWithWatermarkDataQuery;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.ItemType;
import com.box.android.domain.models.item.WebLinkModel;
import com.box.androidsdk.content.utils.BoxLogUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GQLGetItemWithWatermarkDataQueryDataToItemModelMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/box/android/data/mappers/GQLGetItemWithWatermarkDataQueryDataToItemModelMapper;", "Lcom/box/android/data/mappers/GraphQLMapper;", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$Data;", "<init>", "()V", "toGraphQL", "source", "options", "", "fromGraphQL", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLGetItemWithWatermarkDataQueryDataToItemModelMapper implements GraphQLMapper<ItemModel, GetItemWithWatermarkDataQuery.Data> {
    public static final GQLGetItemWithWatermarkDataQueryDataToItemModelMapper INSTANCE = new GQLGetItemWithWatermarkDataQueryDataToItemModelMapper();

    private GQLGetItemWithWatermarkDataQueryDataToItemModelMapper() {
    }

    @Override // com.box.android.data.mappers.GraphQLMapper
    public GetItemWithWatermarkDataQuery.Data toGraphQL(ItemModel source, Object options) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (source instanceof FileModel) {
            return new GetItemWithWatermarkDataQuery.Data(new GetItemWithWatermarkDataQuery.Item(TypenameMapperKt.toGQLTypename(ItemType.FILE), (GetItemWithWatermarkDataQuery.OnFile) GraphQLMapper.toGraphQL$default(GQLGetItemWithWatermarkDataQueryOnFileToFileModelMapper.INSTANCE, source, null, 2, null), null, null));
        }
        if (source instanceof FolderModel) {
            return new GetItemWithWatermarkDataQuery.Data(new GetItemWithWatermarkDataQuery.Item(TypenameMapperKt.toGQLTypename(ItemType.FOLDER), null, (GetItemWithWatermarkDataQuery.OnFolder) GraphQLMapper.toGraphQL$default(GQLGetItemWithWatermarkDataQueryOnFolderToFolderModelMapper.INSTANCE, source, null, 2, null), null));
        }
        if (source instanceof WebLinkModel) {
            BoxLogUtils.w("Weblink is not supported in GetItemWithWatermarkDataQuery");
        }
        return null;
    }

    @Override // com.box.android.data.mappers.GraphQLMapper
    public ItemModel fromGraphQL(GetItemWithWatermarkDataQuery.Data source, Object options) throws Exception {
        GetItemWithWatermarkDataQuery.OnFolder onFolder;
        GetItemWithWatermarkDataQuery.OnFile onFile;
        FileModel fileModel;
        Intrinsics.checkNotNullParameter(source, "source");
        GetItemWithWatermarkDataQuery.Item item = source.getItem();
        if (item != null && (onFile = item.getOnFile()) != null && (fileModel = (FileModel) GraphQLMapper.fromGraphQL$default(GQLGetItemWithWatermarkDataQueryOnFileToFileModelMapper.INSTANCE, onFile, null, 2, null)) != null) {
            return fileModel;
        }
        GetItemWithWatermarkDataQuery.Item item2 = source.getItem();
        if (item2 != null && (onFolder = item2.getOnFolder()) != null) {
            return (FolderModel) GraphQLMapper.fromGraphQL$default(GQLGetItemWithWatermarkDataQueryOnFolderToFolderModelMapper.INSTANCE, onFolder, null, 2, null);
        }
        throw new Exception("Unexpected node: " + source.getItem() + ". Weblink is not supported in GetItemWithWatermarkDataQuery");
    }
}
