package com.box.android.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.PagerAdapter;
import com.box.android.R;
import com.box.android.adapters.NotificationsTasksTabAdapter;
import com.box.android.base.presentation.BoxFragmentInterface;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.utils.InboxBadgeTextFormatter;
import com.box.android.vm.InboxBadgeVM;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.boxandroidlibv2private.model.BoxTaskBadge;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: loaded from: classes11.dex */
public class NotificationsTasksTabFragment extends Hilt_NotificationsTasksTabFragment implements BoxFragmentInterface {
    public static final String EXTRA_CLICK_FROM_BROWSE = "click_from_browse";
    private static final String EXTRA_LAST_TAB_POSITION = "extraLastNotificationsTasksTabPostion";
    private static final int MY_TASK_BADGE_TAB_POS = 1;
    private static final int NOTIFICATIONS_BADGE_TAB_POS = 0;
    InboxBadgeVM mInboxBadgeVM;
    private final TabLayout.OnTabSelectedListener tabListener = new TabLayout.OnTabSelectedListener() { // from class: com.box.android.fragments.NotificationsTasksTabFragment.1
        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            BoxFragmentInterface tabFragment = NotificationsTasksTabFragment.this.getTabFragment(tab.getPosition());
            if (tabFragment instanceof TabVisibility) {
                ((TabVisibility) tabFragment).setTabVisibility(true);
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
            BoxFragmentInterface tabFragment = NotificationsTasksTabFragment.this.getTabFragment(tab.getPosition());
            if (tabFragment instanceof TabVisibility) {
                ((TabVisibility) tabFragment).setTabVisibility(false);
            }
        }
    };

    public interface TabVisibility {
        void setTabVisibility(boolean z);
    }

    @Override // com.box.android.base.presentation.fragments.TabLayoutFragment
    protected boolean canBeLogged() {
        return false;
    }

    @Override // com.box.android.base.presentation.fragments.TabLayoutFragment
    protected String getCurrentEventName() {
        return null;
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public boolean isFloatingMenuAvailable() {
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mInboxBadgeVM = (InboxBadgeVM) new ViewModelProvider(requireActivity()).get(InboxBadgeVM.class);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mInboxBadgeVM.getTaskBadgeLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.box.android.fragments.NotificationsTasksTabFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$onViewCreated$0((BoxResponse) obj);
            }
        });
        this.mInboxBadgeVM.getNotificationCountLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.box.android.fragments.NotificationsTasksTabFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$onViewCreated$1((Integer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$0(BoxResponse boxResponse) {
        if (boxResponse != null) {
            updateMyTasksBadge((BoxTaskBadge) boxResponse.getResult());
        } else {
            updateMyTasksBadge(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$1(Integer num) {
        updateNotificationsBadge(num != null ? num.intValue() : 0);
    }

    @Override // com.box.android.base.presentation.fragments.TabLayoutFragment
    protected TabLayout.OnTabSelectedListener getChildTabSelectedListener() {
        return this.tabListener;
    }

    @Override // com.box.android.base.presentation.fragments.TabLayoutFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        setupBadges();
        return viewOnCreateView;
    }

    private void setupBadges() {
        for (int i = 0; i < this.mTabLayout.getTabCount(); i++) {
            TabLayout.Tab tabAt = this.mTabLayout.getTabAt(i);
            if (tabAt != null) {
                if (i == 0 && tabAt.getCustomView() != null) {
                    updateNotificationsBadge(0);
                } else if (i == 1 && tabAt.getCustomView() != null) {
                    updateMyTasksBadge(null);
                }
            }
        }
    }

    void updateMyTasksBadge(BoxTaskBadge boxTaskBadge) {
        TextView textView;
        String badgeText;
        TabLayout.Tab tabAt = this.mTabLayout.getTabAt(1);
        if (tabAt == null || tabAt.getCustomView() == null || (textView = (TextView) tabAt.getCustomView().findViewById(R.id.badge)) == null) {
            return;
        }
        textView.setTag("TasksBadge");
        if (boxTaskBadge != null) {
            badgeText = InboxBadgeTextFormatter.formatBadgeText(boxTaskBadge.getCount().intValue(), boxTaskBadge.hasMore() != null && boxTaskBadge.hasMore().booleanValue());
        } else {
            badgeText = null;
        }
        if (badgeText == null) {
            textView.setVisibility(8);
        } else {
            textView.setText(badgeText);
            textView.setVisibility(0);
        }
    }

    void updateNotificationsBadge(int i) {
        TextView textView;
        TabLayout.Tab tabAt = this.mTabLayout.getTabAt(0);
        if (tabAt == null || tabAt.getCustomView() == null || (textView = (TextView) tabAt.getCustomView().findViewById(R.id.badge)) == null) {
            return;
        }
        textView.setTag("NotificationsBadge");
        String badgeText = this.mInboxBadgeVM == null ? null : InboxBadgeTextFormatter.formatBadgeText(i, false);
        if (badgeText == null) {
            textView.setVisibility(8);
        } else {
            textView.setText(badgeText);
            textView.setVisibility(0);
        }
    }

    @Override // com.box.android.base.presentation.fragments.TabLayoutFragment
    protected String getCurrentPageName() {
        return BoxAnalyticsParams.PAGE_NAME_NOTIFICATIONS;
    }

    @Override // com.box.android.base.presentation.fragments.TabLayoutFragment
    protected void updateTabWithCustomView(TabLayout.Tab tab) {
        tab.setCustomView(R.layout.badged_tab);
    }

    @Override // com.box.android.base.presentation.fragments.TabLayoutFragment
    protected String getCtaLocationString() {
        if (getArguments() != null && getArguments().getBoolean("click_from_browse", false)) {
            return BoxAnalyticsParams.CTA_PAGE_LOCATION_BOTTOM;
        }
        return BoxAnalyticsParams.CTA_PAGE_LOCATION_TOP;
    }

    @Override // com.box.android.base.presentation.fragments.TabLayoutFragment
    protected PagerAdapter createAdapter() {
        return new NotificationsTasksTabAdapter(getChildFragmentManager());
    }

    @Override // com.box.android.base.presentation.fragments.TabLayoutFragment
    protected String getLastTabPositionKey() {
        return EXTRA_LAST_TAB_POSITION;
    }

    @Override // com.box.android.base.presentation.fragments.TabLayoutFragment
    protected String getClickKey() {
        return "click_from_browse";
    }
}
