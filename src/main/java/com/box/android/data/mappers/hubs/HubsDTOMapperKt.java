package com.box.android.data.mappers.hubs;

import com.box.android.data.GetHubsQuery;
import com.box.android.data.type.HubsDirectionEnum;
import com.box.android.data.type.HubsSortEnum;
import com.box.android.domain.models.hubs.HubAssetModel;
import com.box.android.domain.models.hubs.HubAssetType;
import com.box.android.domain.models.hubs.HubModel;
import com.box.android.domain.models.hubs.HubsDirection;
import com.box.android.domain.models.hubs.HubsSort;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HubsDTOMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0000\u001a\u00020\u0003*\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0007¨\u0006\b"}, d2 = {"toGQL", "Lcom/box/android/data/type/HubsSortEnum;", "Lcom/box/android/domain/models/hubs/HubsSort;", "Lcom/box/android/data/type/HubsDirectionEnum;", "Lcom/box/android/domain/models/hubs/HubsDirection;", "toHubModel", "Lcom/box/android/domain/models/hubs/HubModel;", "Lcom/box/android/data/GetHubsQuery$Edge;", "data_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class HubsDTOMapperKt {

    /* JADX INFO: compiled from: HubsDTOMapper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[HubsSort.values().length];
            try {
                iArr[HubsSort.Name.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HubsSort.Views.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[HubsSort.DateUpdated.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[HubsDirection.values().length];
            try {
                iArr2[HubsDirection.ASC.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[HubsDirection.DESC.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static final HubsSortEnum toGQL(HubsSort hubsSort) {
        Intrinsics.checkNotNullParameter(hubsSort, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[hubsSort.ordinal()];
        if (i == 1) {
            return HubsSortEnum.name_;
        }
        if (i == 2) {
            return HubsSortEnum.view_count;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return HubsSortEnum.modified_at;
    }

    public static final HubsDirectionEnum toGQL(HubsDirection hubsDirection) {
        Intrinsics.checkNotNullParameter(hubsDirection, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$1[hubsDirection.ordinal()];
        if (i == 1) {
            return HubsDirectionEnum.ASC;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return HubsDirectionEnum.DESC;
    }

    public static final HubModel toHubModel(GetHubsQuery.Edge edge) {
        Intrinsics.checkNotNullParameter(edge, "<this>");
        return new HubModel(edge.getNode().getId(), new HubAssetModel(HubAssetType.BANNER, edge.getNode().getBannerImage().getSignedURL(), edge.getNode().getUpdatedAt()), new HubAssetModel(HubAssetType.ICON, edge.getNode().getIconImage().getSignedURL(), edge.getNode().getUpdatedAt()), edge.getNode().getUpdatedAt(), edge.getNode().getAccessCount(), edge.getNode().getTitle(), edge.getNode().getDescriptionPreview());
    }
}
