package com.box.android.navigation;

import androidx.fragment.app.Fragment;
import com.box.android.R;
import com.box.android.adapters.NavigationTabAdapter;
import com.box.android.adapters.NotificationsTasksTabAdapter;
import com.box.android.base.presentation.BoxFragmentInterface;
import com.box.android.browse.fragments.SearchFragment;
import com.box.android.collections.presentation.adapter.CollectionsTabAdapter;
import com.box.android.collections.presentation.fragments.CollectionsTabFragment;
import com.box.android.fragments.NavigationTabFragment;
import com.box.android.fragments.NotificationsTasksTabFragment;
import com.box.android.fragments.boxitem.PushNotificationsFragment;
import com.box.android.hubs.presentation.HubsFragment;
import com.box.androidsdk.content.utils.BoxLogUtils;

/* JADX INFO: loaded from: classes12.dex */
public enum NavigationTarget {
    RECENT(null, NavigationTabAdapter.TabOrder.RECENT.ordinal()),
    ALL_FILES(NavigationTabFragment.class, NavigationTabAdapter.TabOrder.ALL_FILES.ordinal()),
    OFFLINE(null, NavigationTabAdapter.TabOrder.OFFLINE.ordinal()),
    FAVORITES(null, CollectionsTabAdapter.TabOrder.FAVORITES.ordinal()),
    SEARCH(SearchFragment.class, -1),
    HUBS(HubsFragment.class, -1),
    NOTIFICATIONS(PushNotificationsFragment.class, -1),
    INBOX(NotificationsTasksTabFragment.class, NotificationsTasksTabAdapter.TabOrder.NOTIFICATION.ordinal()),
    MY_TASKS(null, NotificationsTasksTabAdapter.TabOrder.MY_TASKS.ordinal()),
    SENT_TASKS(null, NotificationsTasksTabAdapter.TabOrder.SENT_TASKS.ordinal()),
    COLLECTIONS(CollectionsTabFragment.class, CollectionsTabAdapter.TabOrder.FAVORITES.ordinal()),
    MY_COLLECTIONS(null, CollectionsTabAdapter.TabOrder.MY_COLLECTIONS.ordinal());

    private Class mAssociatedFragment;
    private int mNavigationTabPosition;

    NavigationTarget(Class cls, int i) {
        this.mAssociatedFragment = cls;
        this.mNavigationTabPosition = i;
    }

    static int getBottomBarMenuIdByFragment(BoxFragmentInterface boxFragmentInterface) {
        if (boxFragmentInterface == null) {
            return R.id.action_browse;
        }
        for (NavigationTarget navigationTarget : values()) {
            Class cls = navigationTarget.mAssociatedFragment;
            if (cls != null && cls.equals(boxFragmentInterface.getClass())) {
                return getBottomBarMenuId(navigationTarget);
            }
        }
        return R.id.action_browse;
    }

    int getNavigationTabPosition() {
        return this.mNavigationTabPosition;
    }

    public boolean isFromBrowse() {
        int i = AnonymousClass1.$SwitchMap$com$box$android$navigation$NavigationTarget[ordinal()];
        return i == 1 || i == 2 || i == 3;
    }

    public boolean isFromInbox() {
        int i = AnonymousClass1.$SwitchMap$com$box$android$navigation$NavigationTarget[ordinal()];
        return i == 4 || i == 5 || i == 6;
    }

    public boolean isFromCollections() {
        int i = AnonymousClass1.$SwitchMap$com$box$android$navigation$NavigationTarget[ordinal()];
        return i == 7 || i == 8 || i == 9;
    }

    public <T extends Fragment & BoxFragmentInterface> T getNewFragmentInstance() {
        if ((isFromBrowse() && this != ALL_FILES) || ((isFromInbox() && this != INBOX) || (isFromCollections() && this != COLLECTIONS))) {
            return null;
        }
        try {
            return (T) ((Fragment) this.mAssociatedFragment.newInstance());
        } catch (IllegalAccessException | InstantiationException e) {
            BoxLogUtils.e("Navigation", "Could not instantiate fragment:" + name(), e);
            return null;
        }
    }

    public boolean isInstanceOfFragment(BoxFragmentInterface boxFragmentInterface) {
        return this.mAssociatedFragment.isInstance(boxFragmentInterface);
    }

    public static int getNavigationTabAdapterPos(NavigationTarget navigationTarget) {
        return navigationTarget.getNavigationTabPosition();
    }

    public static int getBottomBarMenuId(NavigationTarget navigationTarget) {
        switch (navigationTarget) {
            case INBOX:
            case MY_TASKS:
            case SENT_TASKS:
                return R.id.action_inbox;
            case COLLECTIONS:
            case FAVORITES:
            case MY_COLLECTIONS:
                return R.id.action_collections;
            case SEARCH:
                return R.id.action_search;
            case HUBS:
                return R.id.action_hubs;
            default:
                return R.id.action_browse;
        }
    }
}
