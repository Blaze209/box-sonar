package com.box.android.data.datasource.gql.cache;

import com.box.android.data.api.models.items.IItemDTO;
import com.box.android.data.fragment.ItemConnectionEdgesOnlyFragment;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.ItemModelKt;
import com.box.android.domain.models.item.ItemType;
import com.box.androidsdk.content.utils.BoxLogUtils;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: GQLEdgeHelper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005J\u0010\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005¨\u0006\u0013"}, d2 = {"Lcom/box/android/data/datasource/gql/cache/GQLEdgeHelper;", "", "<init>", "()V", "constructEdgeId", "", "itemDTO", "Lcom/box/android/data/api/models/items/IItemDTO;", "itemModel", "Lcom/box/android/domain/models/item/ItemModel;", "typename", "itemId", "convertEdgeIdToItemIdRemoteId", "Lcom/box/android/domain/models/ItemId$Remote;", SemanticAttributes.NetHostConnectionSubtypeValues.EDGE, "Lcom/box/android/data/fragment/ItemConnectionEdgesOnlyFragment$Edge;", "isCorrectEdgeIdFormat", "", "edgeId", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLEdgeHelper {
    public static final GQLEdgeHelper INSTANCE = new GQLEdgeHelper();

    private GQLEdgeHelper() {
    }

    public final String constructEdgeId(IItemDTO itemDTO) {
        Intrinsics.checkNotNullParameter(itemDTO, "itemDTO");
        return constructEdgeId(itemDTO.getId(), itemDTO.getType());
    }

    public final String constructEdgeId(ItemModel itemModel, String typename) {
        Intrinsics.checkNotNullParameter(itemModel, "itemModel");
        Intrinsics.checkNotNullParameter(typename, "typename");
        return constructEdgeId(ItemModelKt.toItemIdRemoteId(itemModel).getBoxId(), typename);
    }

    public final String constructEdgeId(String itemId, String typename) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(typename, "typename");
        return GQLCacheKeyUtils.constructCacheKeyString$default(GQLCacheKeyUtils.INSTANCE, itemId, typename, null, 4, null);
    }

    public final ItemId.Remote convertEdgeIdToItemIdRemoteId(ItemConnectionEdgesOnlyFragment.Edge edge) {
        Intrinsics.checkNotNullParameter(edge, "edge");
        Matcher matcher = Pattern.compile("(.*):(.*)").matcher(edge.getId());
        String strGroup = null;
        String strGroup2 = null;
        while (matcher.find()) {
            strGroup2 = matcher.group(1);
            strGroup = matcher.group(2);
        }
        if (strGroup == null || strGroup2 == null) {
            return null;
        }
        try {
            return new ItemId.Remote(strGroup, ItemType.INSTANCE.valueOfWithTransform(strGroup2, new Function1() { // from class: com.box.android.data.datasource.gql.cache.GQLEdgeHelper$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GQLEdgeHelper.convertEdgeIdToItemIdRemoteId$lambda$0((String) obj);
                }
            }));
        } catch (Exception unused) {
            BoxLogUtils.e("Can't convert edge id to item id model");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String convertEdgeIdToItemIdRemoteId$lambda$0(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return StringsKt.replace$default(value, "_", "", false, 4, (Object) null);
    }

    public final boolean isCorrectEdgeIdFormat(String edgeId) {
        if (edgeId != null) {
            return StringsKt.contains$default((CharSequence) edgeId, (CharSequence) ":", false, 2, (Object) null);
        }
        return false;
    }
}
