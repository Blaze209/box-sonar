package com.box.android.domain.localrepo;

import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.models.ItemsScreenMode;
import com.box.android.domain.models.hubs.HubsDirection;
import com.box.android.domain.models.hubs.HubsSort;
import com.box.android.domain.utils.UserSharedPreferencesUtilities;
import com.box.androidsdk.content.models.BoxOrder;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: HubsScreenPreferences.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\fJ\u0006\u0010\u0011\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/box/android/domain/localrepo/HubsScreenPreferences;", "", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "<init>", "(Lcom/box/android/domain/identity/IUserContextManager;)V", "saveScreenModePreference", "", "screenMode", "Lcom/box/android/domain/models/ItemsScreenMode;", "saveSortByPreference", "sort", "Lcom/box/android/domain/models/hubs/HubsSort;", "saveSortDirectionPreference", "direction", "Lcom/box/android/domain/models/hubs/HubsDirection;", "getSortBy", "getSortDirection", "getScreenModePreference", "Companion", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class HubsScreenPreferences {
    public static final String HUBS_SCREEN_MODE_PREF_KEY = "hubsScreenModePrefKey";
    public static final String HUBS_SORT_BY_PREF_KEY = "hubsSortPrefKey";
    public static final String HUBS_SORT_DIRECTION_PREF_KEY = "hubsSortDirectionKey";
    private final IUserContextManager userContextManager;

    @Inject
    public HubsScreenPreferences(IUserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        this.userContextManager = userContextManager;
    }

    public final void saveScreenModePreference(ItemsScreenMode screenMode) {
        Intrinsics.checkNotNullParameter(screenMode, "screenMode");
        UserSharedPreferencesUtilities.INSTANCE.savePreference(this.userContextManager, HUBS_SCREEN_MODE_PREF_KEY, screenMode.name());
    }

    public final void saveSortByPreference(HubsSort sort) {
        Intrinsics.checkNotNullParameter(sort, "sort");
        UserSharedPreferencesUtilities.INSTANCE.savePreference(this.userContextManager, HUBS_SORT_BY_PREF_KEY, sort.name());
    }

    public final void saveSortDirectionPreference(HubsDirection direction) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        UserSharedPreferencesUtilities.INSTANCE.savePreference(this.userContextManager, HUBS_SORT_DIRECTION_PREF_KEY, direction.name());
    }

    public final HubsSort getSortBy() {
        HubsSort hubsSort;
        String preference = UserSharedPreferencesUtilities.INSTANCE.getPreference(this.userContextManager, HUBS_SORT_BY_PREF_KEY, "DateUpdated");
        HubsSort hubsSort2 = HubsSort.DateUpdated;
        HubsSort[] hubsSortArrValues = HubsSort.values();
        int length = hubsSortArrValues.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                hubsSort = null;
                break;
            }
            hubsSort = hubsSortArrValues[i];
            if (StringsKt.equals(hubsSort.name(), preference, true)) {
                break;
            }
            i++;
        }
        HubsSort hubsSort3 = hubsSort;
        if (hubsSort3 != null) {
            hubsSort2 = hubsSort3;
        }
        return hubsSort2;
    }

    public final HubsDirection getSortDirection() {
        HubsDirection hubsDirection;
        String preference = UserSharedPreferencesUtilities.INSTANCE.getPreference(this.userContextManager, HUBS_SORT_DIRECTION_PREF_KEY, BoxOrder.DIRECTION_DESCENDING);
        HubsDirection hubsDirection2 = HubsDirection.DESC;
        HubsDirection[] hubsDirectionArrValues = HubsDirection.values();
        int length = hubsDirectionArrValues.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                hubsDirection = null;
                break;
            }
            hubsDirection = hubsDirectionArrValues[i];
            if (StringsKt.equals(hubsDirection.name(), preference, true)) {
                break;
            }
            i++;
        }
        HubsDirection hubsDirection3 = hubsDirection;
        if (hubsDirection3 != null) {
            hubsDirection2 = hubsDirection3;
        }
        return hubsDirection2;
    }

    public final ItemsScreenMode getScreenModePreference() {
        ItemsScreenMode itemsScreenMode;
        String preference = UserSharedPreferencesUtilities.INSTANCE.getPreference(this.userContextManager, HUBS_SCREEN_MODE_PREF_KEY, "GRID");
        ItemsScreenMode itemsScreenMode2 = ItemsScreenMode.GRID;
        ItemsScreenMode[] itemsScreenModeArrValues = ItemsScreenMode.values();
        int length = itemsScreenModeArrValues.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                itemsScreenMode = null;
                break;
            }
            itemsScreenMode = itemsScreenModeArrValues[i];
            if (StringsKt.equals(itemsScreenMode.name(), preference, true)) {
                break;
            }
            i++;
        }
        ItemsScreenMode itemsScreenMode3 = itemsScreenMode;
        if (itemsScreenMode3 != null) {
            itemsScreenMode2 = itemsScreenMode3;
        }
        return itemsScreenMode2;
    }
}
