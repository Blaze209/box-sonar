package com.box.android.browse.utilities;

import com.box.android.base.analytics.NavigationAnalyticsUtils;
import com.box.android.browse.R;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.mappers.ItemModelMapper;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.androidsdk.content.models.BoxItem;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import com.facebook.react.modules.dialog.AlertFragment;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: BrowseAnalytics.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0014\u0010\u000e\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0014\u0010\u0013\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0014\u0010\u0015\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010J\u000e\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u000bJ\u0006\u0010\u001a\u001a\u00020\u000bJ\u0006\u0010\u001b\u001a\u00020\u000bJ\u0006\u0010\u001c\u001a\u00020\u000bJ\u0006\u0010\u001d\u001a\u00020\u000bJ\u0006\u0010\u001e\u001a\u00020\u000bJ\u0006\u0010\u001f\u001a\u00020\u000bJ\u0006\u0010 \u001a\u00020\u000bJ\u0006\u0010!\u001a\u00020\u000bJ\u0006\u0010\"\u001a\u00020\u000bJ\u0006\u0010#\u001a\u00020\u000bJ\u0006\u0010$\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/box/android/browse/utilities/BrowseAnalytics;", "", "baseModelController", "Lcom/box/android/coreservices/modelcontroller/IBaseModelController;", "boxExtendedApiFolder", "Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiFolder;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "<init>", "(Lcom/box/android/coreservices/modelcontroller/IBaseModelController;Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiFolder;Lcom/box/android/domain/identity/IUserContextManager;)V", "sendBatchSaveOfflineErrorEvent", "", "errorMessage", "", "sendBatchSaveOfflineEventFor", AlertFragment.ARG_ITEMS, "", "Lcom/box/android/domain/models/item/ItemModel;", "item", "sendBatchRemoveFromOfflineEventFor", "sendRemoveFromOfflineEventFor", "sendEventOnRefreshOfflinedItems", "sendSelectFolderTriggered", "folder", "Lcom/box/android/domain/models/item/FolderModel;", "browseScreenViewed", "allTabChanged", "allTabScreenViewed", "recentsTabChanged", "recentsTabScreenViewed", "offlineTabChanged", "offlineTabScreenViewed", "settingsClicked", "searchClicked", "transferClicked", "sortingClicked", "filteringClicked", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BrowseAnalytics {
    public static final int $stable = 8;
    private final IBaseModelController baseModelController;
    private final BoxExtendedApiFolder boxExtendedApiFolder;
    private final IUserContextManager userContextManager;

    @Inject
    public BrowseAnalytics(IBaseModelController baseModelController, BoxExtendedApiFolder boxExtendedApiFolder, IUserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(baseModelController, "baseModelController");
        Intrinsics.checkNotNullParameter(boxExtendedApiFolder, "boxExtendedApiFolder");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        this.baseModelController = baseModelController;
        this.boxExtendedApiFolder = boxExtendedApiFolder;
        this.userContextManager = userContextManager;
    }

    public final void sendBatchSaveOfflineErrorEvent(String errorMessage) {
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        BoxAmplitudeAnalytics.createEventBuilder().setTimeOnPage().setFlow(BoxAnalyticsParams.FLOW_FILE_NAVIGATION).setCtaPageLocation(BoxAnalyticsParams.CTA_LOCATION_HEADER).setCtaTarget(CommonBoxUtil.getUSLocaleString(R.string.Make_available_offline)).setPageExperience(BoxAnalyticsParams.PAGE_EXPERIENCE_POPULATED).setError("other", errorMessage, (String) null).logEvent(BoxAnalyticsParams.EVENT_ITEM_OFFLINE_CTA_TRIGGERED);
    }

    public final void sendBatchSaveOfflineEventFor(List<? extends ItemModel> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        Iterator<? extends ItemModel> it = items.iterator();
        while (it.hasNext()) {
            sendBatchSaveOfflineEventFor(it.next());
        }
    }

    private final void sendBatchSaveOfflineEventFor(ItemModel item) {
        BoxAmplitudeAnalytics.createEventBuilder().setTimeOnPage().setFlow(BoxAnalyticsParams.FLOW_FILE_NAVIGATION).setCtaPageLocation(BoxAnalyticsParams.CTA_LOCATION_HEADER).setCtaTarget(CommonBoxUtil.getUSLocaleString(R.string.Make_available_offline)).setPageExperience(BoxAnalyticsParams.PAGE_EXPERIENCE_POPULATED).setBoxItem(ItemModelMapper.toBoxItem$default(ItemModelMapper.INSTANCE, item, false, 1, null)).logEvent(BoxAnalyticsParams.EVENT_ITEM_OFFLINE_CTA_TRIGGERED);
    }

    public final void sendBatchRemoveFromOfflineEventFor(List<? extends ItemModel> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        Iterator<? extends ItemModel> it = items.iterator();
        while (it.hasNext()) {
            sendRemoveFromOfflineEventFor(it.next());
        }
    }

    private final void sendRemoveFromOfflineEventFor(ItemModel item) {
        BoxAmplitudeAnalytics.createEventBuilder().setTimeOnPage().setFlow(BoxAnalyticsParams.FLOW_FILE_NAVIGATION).setCtaPageLocation(BoxAnalyticsParams.CTA_LOCATION_HEADER).setCtaTarget(CommonBoxUtil.getUSLocaleString(R.string.Remove_offline)).setPageExperience(BoxAnalyticsParams.PAGE_EXPERIENCE_POPULATED).setBoxItem(ItemModelMapper.toBoxItem$default(ItemModelMapper.INSTANCE, item, false, 1, null)).logEvent(BoxAnalyticsParams.EVENT_REMOVE_OFFLINE_CTA_TRIGGERED);
    }

    public final void sendEventOnRefreshOfflinedItems(List<? extends ItemModel> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        BoxAmplitudeAnalytics.EventPropertyBuilder ctaPageLocation = BoxAmplitudeAnalytics.createEventBuilder().setTimeOnPage().setPageExperience(BoxAnalyticsParams.PAGE_EXPERIENCE_OVERLAY).setFlow(BoxAnalyticsParams.FLOW_FILE_NAVIGATION).setCtaPageLocation(BoxAnalyticsParams.CTA_PAGE_LOCATION_BOTTOM);
        Iterator<T> it = items.iterator();
        while (it.hasNext()) {
            BoxItem boxItem$default = ItemModelMapper.toBoxItem$default(ItemModelMapper.INSTANCE, (ItemModel) it.next(), false, 1, null);
            ctaPageLocation.setBoxItem(boxItem$default).setContentOwnershipType(NavigationAnalyticsUtils.calculateContentOwnership(boxItem$default, this.baseModelController, this.boxExtendedApiFolder, this.userContextManager)).logEvent(BoxAnalyticsParams.EVENT_ITEM_OFFLINE_CTA_TRIGGERED);
        }
    }

    public final void sendSelectFolderTriggered(FolderModel folder) {
        Intrinsics.checkNotNullParameter(folder, "folder");
        BoxItem boxItem$default = ItemModelMapper.toBoxItem$default(ItemModelMapper.INSTANCE, folder, false, 1, null);
        BoxAmplitudeAnalytics.createEventBuilder().setBoxItem(boxItem$default).setFlow(BoxAnalyticsParams.FLOW_FILE_NAVIGATION).setCtaTarget(BoxAnalyticsParams.PAGE_NAME_FOLDER).setCtaPageLocation("body").setContentOwnershipType(NavigationAnalyticsUtils.calculateContentOwnership(boxItem$default, this.baseModelController, this.boxExtendedApiFolder, this.userContextManager)).setPageExperience(BoxAnalyticsParams.PAGE_EXPERIENCE_POPULATED).setTimeOnPage().logEvent(BoxAnalyticsParams.EVENT_SELECT_FOLDER_CTA_TRIGGERED);
    }

    public final void browseScreenViewed() {
        BoxAmplitudeAnalytics.createEventBuilder().logEvent(BoxAnalyticsParams.EVENT_FILES_SCREEN_VIEWED);
    }

    public final void allTabChanged() {
        BoxAmplitudeAnalytics.createEventBuilder().setFlow(BoxAnalyticsParams.FLOW_FILE_NAVIGATION).setCtaPageLocation(BoxAnalyticsParams.CTA_PAGE_LOCATION_TOP).setCtaTarget(BoxAnalyticsParams.PAGE_NAME_ALL_FILES).logEvent(BoxAnalyticsParams.EVENT_ALL_FILES_TAB_TRIGGERED);
    }

    public final void allTabScreenViewed() {
        if (BoxAmplitudeAnalytics.getInstance().setCurrentPage(BoxAnalyticsParams.PAGE_NAME_ALL_FILES)) {
            BoxAmplitudeAnalytics.EventPropertyBuilder flow = BoxAmplitudeAnalytics.createEventBuilder().setFlow(BoxAnalyticsParams.FLOW_FILE_NAVIGATION);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format(BoxAnalyticsParams.EVENT_PAGE_VIEWED_TEMPLATE, Arrays.copyOf(new Object[]{BoxAnalyticsParams.PAGE_NAME_ALL_FILES}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            flow.logEvent(str);
        }
    }

    public final void recentsTabChanged() {
        BoxAmplitudeAnalytics.createEventBuilder().setFlow(BoxAnalyticsParams.FLOW_FILE_NAVIGATION).setCtaPageLocation(BoxAnalyticsParams.CTA_PAGE_LOCATION_TOP).setCtaTarget(BoxAnalyticsParams.PAGE_NAME_RECENT).logEvent(BoxAnalyticsParams.EVENT_RECENTS_TAB_TRIGGERED);
    }

    public final void recentsTabScreenViewed() {
        if (BoxAmplitudeAnalytics.getInstance().setCurrentPage(BoxAnalyticsParams.PAGE_NAME_RECENT)) {
            BoxAmplitudeAnalytics.EventPropertyBuilder flow = BoxAmplitudeAnalytics.createEventBuilder().setFlow(BoxAnalyticsParams.FLOW_FILE_NAVIGATION);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format(BoxAnalyticsParams.EVENT_PAGE_VIEWED_TEMPLATE, Arrays.copyOf(new Object[]{BoxAnalyticsParams.PAGE_NAME_RECENT}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            flow.logEvent(str);
        }
    }

    public final void offlineTabChanged() {
        BoxAmplitudeAnalytics.createEventBuilder().setFlow(BoxAnalyticsParams.FLOW_FILE_NAVIGATION).setCtaPageLocation(BoxAnalyticsParams.CTA_PAGE_LOCATION_TOP).setCtaTarget(BoxAnalyticsParams.PAGE_NAME_OFFLINE).logEvent(BoxAnalyticsParams.EVENT_OFFLINE_TAB_TRIGGERED);
    }

    public final void offlineTabScreenViewed() {
        if (BoxAmplitudeAnalytics.getInstance().setCurrentPage(BoxAnalyticsParams.PAGE_NAME_OFFLINE)) {
            BoxAmplitudeAnalytics.EventPropertyBuilder flow = BoxAmplitudeAnalytics.createEventBuilder().setFlow(BoxAnalyticsParams.FLOW_FILE_NAVIGATION);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format(BoxAnalyticsParams.EVENT_PAGE_VIEWED_TEMPLATE, Arrays.copyOf(new Object[]{BoxAnalyticsParams.PAGE_NAME_OFFLINE}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            flow.logEvent(str);
        }
    }

    public final void settingsClicked() {
        BoxAmplitudeAnalytics.createEventBuilder().setFlow(BoxAnalyticsParams.FLOW_FILE_NAVIGATION).setCtaPageLocation(BoxAnalyticsParams.CTA_PAGE_LOCATION_TOP).setCtaTarget(BoxAnalyticsParams.PAGE_NAME_SETTINGS).logEvent(BoxAnalyticsParams.EVENT_SETTINGS_CLICKED);
    }

    public final void searchClicked() {
        BoxAmplitudeAnalytics.createEventBuilder().setFlow(BoxAnalyticsParams.FLOW_FILE_NAVIGATION).setCtaPageLocation(BoxAnalyticsParams.SEARCH_OPENED_LOCATION_HOME).setCtaTarget(BoxAnalyticsParams.PAGE_NAME_SEARCH).logEvent(BoxAnalyticsParams.EVENT_BROWSE_SEARCH_OPENED);
    }

    public final void transferClicked() {
        BoxAmplitudeAnalytics.createEventBuilder().setFlow(BoxAnalyticsParams.FLOW_FILE_NAVIGATION).setCtaPageLocation(BoxAnalyticsParams.CTA_PAGE_LOCATION_TOP).setCtaTarget(BoxAnalyticsParams.PAGE_NAME_TRANSFERS).logEvent(BoxAnalyticsParams.EVENT_TRANSFER_CLICKED);
    }

    public final void sortingClicked() {
        BoxAmplitudeAnalytics.createEventBuilder().logEvent(BoxAnalyticsParams.EVENT_COMMON_SORTING_CLICKED);
    }

    public final void filteringClicked() {
        BoxAmplitudeAnalytics.createEventBuilder().logEvent(BoxAnalyticsParams.EVENT_COMMON_FILTERING_CLICKED);
    }
}
