package com.box.android.fragments.boxitem;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.box.android.R;
import com.box.android.activities.MainParent;
import com.box.android.adapters.PushNotificationsListAdapter;
import com.box.android.base.presentation.fragments.BottomSheetMenuFragment;
import com.box.android.base.presentation.views.menu.NotificationsFilterFragment;
import com.box.android.browse.adapters.BoxItemAdapter;
import com.box.android.browse.filters.BoxItemFilter;
import com.box.android.browse.fragments.BoxBrowseFragment;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.coreservices.modelcontroller.messages.BoxMessage;
import com.box.android.coreservices.modelcontroller.messages.BoxResponseMessage;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.fragments.NotificationsTasksTabFragment;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.boxandroidlibv2private.model.BoxIteratorBoxPushNotification;
import com.box.boxandroidlibv2private.model.BoxPushNotification;
import com.box.boxandroidlibv2private.requests.BoxFileNotificationMute;
import com.box.boxandroidlibv2private.requests.BoxRequestGetPushNotifications;
import com.box.boxandroidlibv2private.requests.BoxRequestStorePushNotification;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import java.util.Iterator;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes11.dex */
public class PushNotificationsFragment extends Hilt_PushNotificationsFragment implements BoxItemAdapter.OnInteractionListener, NotificationsTasksTabFragment.TabVisibility {
    private static final String EXTRA_EVENT_TYPE_FILTER = "eventType";
    private static final String NOTIFICATIONS = "notifications";
    private PushNotificationsListAdapter mAdapter;

    @Inject
    protected IBaseModelController mBaseMoco;

    @Inject
    protected BoxApiPrivate mBoxApiPrivate;
    private String mEventTypeFilter;

    @Inject
    protected IUserContextManager mUserContextManager;
    private SecondaryActionListener mSecondaryActionListener = new SecondaryActionListener();
    private boolean shouldLoadItemsOnStart = false;

    @Override // com.box.android.browse.adapters.BoxItemAdapter.OnInteractionListener
    public BoxItemFilter getItemFilter() {
        return null;
    }

    @Override // com.box.android.browse.adapters.BoxItemAdapter.OnInteractionListener
    public BoxBrowseFragment.MultiSelectHandler getMultiSelectHandler() {
        return null;
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public int getType() {
        return 6;
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public boolean isFloatingMenuAvailable() {
        return false;
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public boolean onBackPressed() {
        return false;
    }

    @Override // com.box.android.fragments.NotificationsTasksTabFragment.TabVisibility
    public void setTabVisibility(boolean z) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        if (this.shouldLoadItemsOnStart) {
            itemLoad();
            this.shouldLoadItemsOnStart = false;
        }
    }

    @Override // com.box.android.base.presentation.fragments.BaseListingFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        ((ImageView) viewOnCreateView.findViewById(R.id.empty_folder_image)).setImageResource(R.drawable.ic_bell140);
        ((TextView) viewOnCreateView.findViewById(R.id.empty_folder_text)).setText(R.string.empty_notifications_text);
        ((TextView) viewOnCreateView.findViewById(R.id.empty_folder_subtext)).setText(R.string.empty_notifications_subtext);
        return viewOnCreateView;
    }

    @Override // com.box.android.base.presentation.fragments.BaseListingFragment
    protected void loadItems() {
        if (isVisible()) {
            itemLoad();
        } else {
            this.shouldLoadItemsOnStart = true;
        }
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public void updateFromRemote() {
        loadItems();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        if (menu.findItem(R.id.notificationsFilter) == null) {
            menuInflater.inflate(R.menu.notification_menu, menu);
        }
        disableMenuItem(menu, R.id.notificationsFilter);
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (getActivity() == null) {
            return false;
        }
        if (menuItem.getItemId() == R.id.notificationsFilter) {
            NotificationsFilterFragment.newInstance(getActivity()).show(getFragmentManager(), BottomSheetMenuFragment.TAG);
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public static PushNotificationsFragment newInstance() {
        PushNotificationsFragment pushNotificationsFragment = new PushNotificationsFragment();
        pushNotificationsFragment.setArguments(new Bundle());
        return pushNotificationsFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("eventType", this.mEventTypeFilter);
        super.onSaveInstanceState(bundle);
    }

    @Override // com.box.android.base.presentation.fragments.BaseListingFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        loadItems();
    }

    @Override // com.box.android.browse.adapters.BoxItemAdapter.OnInteractionListener
    public BoxBrowseFragment.OnSecondaryActionListener getOnSecondaryActionListener() {
        return this.mSecondaryActionListener;
    }

    private class SecondaryActionListener implements BoxBrowseFragment.OnSecondaryActionListener {
        private SecondaryActionListener() {
        }

        @Override // com.box.android.browse.fragments.BoxBrowseFragment.OnSecondaryActionListener
        public boolean onSecondaryAction(BoxItem boxItem) {
            if (!(PushNotificationsFragment.this.getActivity() instanceof MainParent)) {
                return false;
            }
            ((MainParent) PushNotificationsFragment.this.getActivity()).showBottomSheet(boxItem);
            return false;
        }
    }

    @Override // com.box.android.browse.adapters.BoxItemAdapter.OnInteractionListener
    public BoxBrowseFragment.OnItemClickListener getOnItemClickListener() {
        if (getActivity() instanceof MainParent) {
            return (MainParent) getActivity();
        }
        return null;
    }

    @Override // com.box.android.base.presentation.fragments.BaseListingFragment
    protected boolean isContentAvailable() {
        PushNotificationsListAdapter pushNotificationsListAdapter = this.mAdapter;
        return (pushNotificationsListAdapter == null || pushNotificationsListAdapter.getItems() == null) ? false : true;
    }

    @Override // com.box.android.base.presentation.fragments.BaseListingFragment
    protected RecyclerView.Adapter createAdapter() {
        PushNotificationsListAdapter pushNotificationsListAdapter = new PushNotificationsListAdapter(getContext(), null, this.mUserContextManager, this);
        this.mAdapter = pushNotificationsListAdapter;
        return pushNotificationsListAdapter;
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public String getGenericId() {
        return NOTIFICATIONS;
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public boolean shouldUpdateFragment(BoxMessage<?> boxMessage) {
        if (!boxMessage.wasSuccessful() || !(boxMessage instanceof BoxResponseMessage)) {
            return false;
        }
        BoxRequest request = ((BoxResponseMessage) boxMessage).getRequest();
        if (request instanceof BoxRequestGetPushNotifications) {
            return true;
        }
        if (request instanceof BoxRequestStorePushNotification) {
            loadItems();
        }
        if (!(request instanceof BoxFileNotificationMute.RemoveFileMute)) {
            return false;
        }
        loadItems();
        return false;
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public void updateFragment(BoxMessage<?> boxMessage) {
        if (boxMessage instanceof BoxResponseMessage) {
            BoxResponseMessage boxResponseMessage = (BoxResponseMessage) boxMessage;
            BoxRequest request = boxResponseMessage.getRequest();
            if (request instanceof BoxRequestGetPushNotifications) {
                String filterEventType = ((BoxRequestGetPushNotifications) request).getFilterEventType();
                String str = this.mEventTypeFilter;
                if (str == null || str.equals(filterEventType)) {
                    if (this.mEventTypeFilter != null || filterEventType == null) {
                        updateItems((BoxIteratorBoxPushNotification) boxResponseMessage.getResponse().getResult());
                    }
                }
            }
        }
    }

    protected void updateItems(BoxIteratorBoxPushNotification boxIteratorBoxPushNotification) {
        PushNotificationsListAdapter pushNotificationsListAdapter;
        Iterator<BoxPushNotification> it = boxIteratorBoxPushNotification.iterator();
        while (it.hasNext()) {
            if (!it.next().isProcessed()) {
                it.remove();
            }
        }
        if (getActivity() == null || (pushNotificationsListAdapter = this.mAdapter) == null) {
            return;
        }
        pushNotificationsListAdapter.getItemCount();
        this.mAdapter.updateItems(boxIteratorBoxPushNotification);
        updateUI();
        super.updateItems();
    }

    public void setEventFilterType(String str) {
        String str2 = this.mEventTypeFilter;
        this.mEventTypeFilter = str;
        if (str2 == null && str == null) {
            return;
        }
        if (str2 == null && str != null) {
            loadItems();
            return;
        }
        if (str2 != null && str == null) {
            loadItems();
        } else {
            if (str2.equals(str)) {
                return;
            }
            loadItems();
        }
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public String getTitle(Context context) {
        return CommonBoxUtil.LS(R.string.notifications);
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public String getAmplitudePageName() {
        return BoxAnalyticsParams.PAGE_NAME_NOTIFICATIONS;
    }

    private void itemLoad() {
        BoxRequestGetPushNotifications pushNotificationsRequest = this.mBoxApiPrivate.getPushNotificationsRequest();
        String str = this.mEventTypeFilter;
        if (str != null) {
            pushNotificationsRequest.setFilterEventType(str);
        }
        this.mBaseMoco.performLocal(pushNotificationsRequest);
    }
}
