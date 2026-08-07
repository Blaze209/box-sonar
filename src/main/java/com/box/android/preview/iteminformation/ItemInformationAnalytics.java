package com.box.android.preview.iteminformation;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.mappers.ItemModelMapper;
import com.box.android.domain.models.item.ItemModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemInformationAnalytics.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0018\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\r"}, d2 = {"Lcom/box/android/preview/iteminformation/ItemInformationAnalytics;", "", "<init>", "()V", "collaboratorsTriggered", "", "itemModel", "Lcom/box/android/domain/models/item/ItemModel;", "renameTriggered", "descriptionUpdateTriggered", "itemInformationEventBuilder", "Lcom/box/android/domain/analytics/BoxAmplitudeAnalytics$EventPropertyBuilder;", "kotlin.jvm.PlatformType", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ItemInformationAnalytics {
    public static final int $stable = 0;

    @Inject
    public ItemInformationAnalytics() {
    }

    public final void collaboratorsTriggered(ItemModel itemModel) {
        Intrinsics.checkNotNullParameter(itemModel, "itemModel");
        itemInformationEventBuilder(itemModel).logEvent(BoxAnalyticsParams.EVENT_ITEM_INFO_COLLABORATORS_TRIGGERED);
    }

    public final void renameTriggered(ItemModel itemModel) {
        Intrinsics.checkNotNullParameter(itemModel, "itemModel");
        itemInformationEventBuilder(itemModel).logEvent(BoxAnalyticsParams.EVENT_ITEM_INFO_RENAME_TRIGGERED);
    }

    public final void descriptionUpdateTriggered(ItemModel itemModel) {
        Intrinsics.checkNotNullParameter(itemModel, "itemModel");
        itemInformationEventBuilder(itemModel).logEvent(BoxAnalyticsParams.EVENT_ITEM_INFO_DESCRIPTION_UPDATE_TRIGGERED);
    }

    private final BoxAmplitudeAnalytics.EventPropertyBuilder itemInformationEventBuilder(ItemModel itemModel) {
        return BoxAmplitudeAnalytics.createEventBuilder().setFlow(BoxAnalyticsParams.FLOW_FILE_NAVIGATION).setBoxItem(ItemModelMapper.toBoxItem$default(ItemModelMapper.INSTANCE, itemModel, false, 1, null));
    }
}
