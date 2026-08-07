package com.box.android.collections.presentation.navigationmodernization;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.models.CollectionType;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollectionsAnalytics.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/CollectionsAnalytics;", "", "<init>", "()V", "collectionsScreenViewed", "", "createCollectionClicked", "settingsClicked", "collectionItemsListScreenViewed", "collectionType", "Lcom/box/android/domain/models/CollectionType;", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CollectionsAnalytics {
    public static final int $stable = 0;

    @Inject
    public CollectionsAnalytics() {
    }

    public final void collectionsScreenViewed() {
        BoxAmplitudeAnalytics.createEventBuilder().logEvent(BoxAnalyticsParams.EVENT_COLLECTIONS_SCREEN_VIEWED);
    }

    public final void createCollectionClicked() {
        BoxAmplitudeAnalytics.createEventBuilder().logEvent(BoxAnalyticsParams.EVENT_CREATE_COLLECTION_CTA_TRIGGERED);
    }

    public final void settingsClicked() {
        BoxAmplitudeAnalytics.createEventBuilder().setFlow(BoxAnalyticsParams.FLOW_FILE_NAVIGATION).setCtaPageLocation(BoxAnalyticsParams.CTA_PAGE_LOCATION_TOP).setCtaTarget(BoxAnalyticsParams.PAGE_NAME_SETTINGS).logEvent(BoxAnalyticsParams.EVENT_SETTINGS_CLICKED);
    }

    public final void collectionItemsListScreenViewed(CollectionType collectionType) {
        String str;
        Intrinsics.checkNotNullParameter(collectionType, "collectionType");
        if (collectionType == CollectionType.FAVORITES) {
            str = BoxAnalyticsParams.EVENT_COLLECTIONS_LIST_FAVORITES_VIEWED;
        } else {
            str = BoxAnalyticsParams.EVENT_COLLECTIONS_LIST_PERSONAL_VIEWED;
        }
        BoxAmplitudeAnalytics.createEventBuilder().logEvent(str);
    }
}
