package com.box.android.fragments;

import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.box.android.adapters.NavigationTabAdapter;
import com.box.android.base.presentation.BoxFragmentInterface;
import com.box.android.base.presentation.fragments.IBoxFragmentActivity;
import com.box.android.browse.cpl.offlined.OfflinedFragment;
import com.box.android.browse.cpl.recents.RecentsFragment;
import com.box.android.browse.utilities.BrowseFragmentFactory;
import com.box.android.cpl.navigation.NavigationReducer;
import com.box.android.cpl.navigation.NavigationViewModel;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.configuration.FeatureFlips;
import com.google.android.material.tabs.TabLayout;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes11.dex */
public class NavigationTabFragment extends Hilt_NavigationTabFragment implements BoxFragmentInterface {
    public static final String EXTRA_CLICK_FROM_BROWSE = "click_from_browse";
    public static final String EXTRA_LAST_TAB_POSITION = "extraLastTabPostion";

    @Inject
    protected BrowseFragmentFactory browseFragmentFactory;

    @Inject
    protected FeatureFlips mFeatureFlips;
    private NavigationViewModel navigationViewModel;
    private final TabLayout.OnTabSelectedListener tabListener = new TabLayout.OnTabSelectedListener() { // from class: com.box.android.fragments.NavigationTabFragment.1
        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            BoxFragmentInterface tabFragment = NavigationTabFragment.this.getTabFragment(tab.getPosition());
            if (NavigationTabFragment.this.getActivity() instanceof IBoxFragmentActivity) {
                ((IBoxFragmentActivity) NavigationTabFragment.this.getActivity()).setupFab();
            }
            if (NavigationTabFragment.this.navigationViewModel != null) {
                NavigationTabFragment.this.navigationViewModel.getStore().send(new NavigationReducer.Action.TabChanged(tabFragment.getType()));
            }
        }
    };
    private final ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.box.android.fragments.NavigationTabFragment.2
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (NavigationTabFragment.this.getActivity() instanceof IBoxFragmentActivity) {
                if (i == 1) {
                    ((IBoxFragmentActivity) NavigationTabFragment.this.getActivity()).toggleFab(false);
                } else if (i == 0) {
                    ((IBoxFragmentActivity) NavigationTabFragment.this.getActivity()).setupFab();
                }
            }
        }
    };

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public boolean isFloatingMenuAvailable() {
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.navigationViewModel = (NavigationViewModel) new ViewModelProvider(requireActivity()).get(NavigationViewModel.class);
    }

    @Override // com.box.android.base.presentation.fragments.TabLayoutFragment
    protected PagerAdapter createAdapter() {
        if (this.navigationViewModel != null) {
            return new NavigationTabAdapter(getChildFragmentManager(), this.navigationViewModel.getBrowseStore().getKey(), this.navigationViewModel.getRecentsStore().getKey(), this.navigationViewModel.getOfflinedStore().getKey(), this.browseFragmentFactory);
        }
        return new NavigationTabAdapter(getChildFragmentManager(), null, null, null, this.browseFragmentFactory);
    }

    @Override // com.box.android.base.presentation.fragments.TabLayoutFragment
    protected TabLayout.OnTabSelectedListener getChildTabSelectedListener() {
        return this.tabListener;
    }

    @Override // com.box.android.base.presentation.fragments.TabLayoutFragment
    protected ViewPager.OnPageChangeListener onPageChangeListener() {
        return this.onPageChangeListener;
    }

    @Override // com.box.android.base.presentation.fragments.TabLayoutFragment
    protected String getCurrentPageName() {
        if (getCurrentFragment() instanceof OfflinedFragment) {
            return BoxAnalyticsParams.PAGE_NAME_OFFLINE;
        }
        if (getCurrentFragment() instanceof RecentsFragment) {
            return BoxAnalyticsParams.PAGE_NAME_RECENT;
        }
        return BoxAnalyticsParams.PAGE_NAME_ALL_FILES;
    }

    @Override // com.box.android.base.presentation.fragments.TabLayoutFragment
    protected String getCtaLocationString() {
        if (getArguments() != null && getArguments().getBoolean("click_from_browse", false)) {
            return BoxAnalyticsParams.CTA_PAGE_LOCATION_BOTTOM;
        }
        return BoxAnalyticsParams.CTA_PAGE_LOCATION_TOP;
    }

    @Override // com.box.android.base.presentation.fragments.TabLayoutFragment
    protected String getCurrentEventName() {
        if (getCurrentFragment() instanceof OfflinedFragment) {
            return BoxAnalyticsParams.EVENT_OFFLINE_TAB_TRIGGERED;
        }
        if (getCurrentFragment() instanceof RecentsFragment) {
            return BoxAnalyticsParams.EVENT_RECENTS_TAB_TRIGGERED;
        }
        return BoxAnalyticsParams.EVENT_ALL_FILES_TAB_TRIGGERED;
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
