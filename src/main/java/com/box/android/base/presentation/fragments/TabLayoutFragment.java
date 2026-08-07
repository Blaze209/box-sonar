package com.box.android.base.presentation.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.activity.result.ActivityResultCaller;
import androidx.core.view.KeyEventDispatcher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.box.android.base.R;
import com.box.android.base.presentation.BoxFragmentInterface;
import com.box.android.base.presentation.views.TogglableViewPager;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.modelcontroller.messages.BoxMessage;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.identity.IUserContextManager;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.material.tabs.TabLayout;
import com.microsoft.intune.mam.client.widget.MAMTextView;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TabLayoutFragment.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0017J\b\u0010&\u001a\u00020'H$J\b\u0010(\u001a\u00020)H\u0002J\u0010\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020,H\u0002J\u0010\u0010-\u001a\u00020)2\u0006\u0010.\u001a\u00020/H\u0014J\u0018\u00100\u001a\u00020)2\u0006\u0010.\u001a\u00020/2\u0006\u00101\u001a\u00020\u0013H\u0002J\b\u00102\u001a\u00020\u0013H\u0014J\b\u00103\u001a\u000204H$J\b\u00105\u001a\u000204H$J\b\u00106\u001a\u000204H$J\b\u00107\u001a\u000204H$J\b\u00108\u001a\u000204H$J\b\u00109\u001a\u000204H\u0016J\u0014\u0010:\u001a\u0004\u0018\u0001042\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\b\u0010=\u001a\u00020,H\u0016J\b\u0010>\u001a\u000204H\u0016J\b\u0010?\u001a\u00020\u0013H\u0016J\b\u0010@\u001a\u00020)H\u0015J\u0010\u0010A\u001a\u00020)2\u0006\u0010B\u001a\u00020,H\u0016J\u0016\u0010C\u001a\u00020)2\f\u0010D\u001a\b\u0012\u0002\b\u0003\u0018\u00010EH\u0017J\u000e\u0010F\u001a\u00020)2\u0006\u0010G\u001a\u00020\u0013J\b\u0010H\u001a\u00020)H\u0016J\u0014\u0010I\u001a\u00020\u00132\n\u0010D\u001a\u0006\u0012\u0002\b\u00030EH\u0017J\u0010\u0010J\u001a\u00020\u00022\u0006\u0010K\u001a\u00020,H\u0004J\u0006\u0010L\u001a\u00020\u0002J\u0010\u0010M\u001a\u00020)2\u0006\u0010N\u001a\u00020,H\u0002J\n\u0010O\u001a\u0004\u0018\u00010PH\u0014J\b\u0010Q\u001a\u00020RH\u0014J\b\u0010S\u001a\u00020)H\u0016R$\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.¢\u0006\u0014\n\u0000\u0012\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006T"}, d2 = {"Lcom/box/android/base/presentation/fragments/TabLayoutFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/box/android/base/presentation/BoxFragmentInterface;", "<init>", "()V", "mTabLayout", "Lcom/google/android/material/tabs/TabLayout;", "getMTabLayout$annotations", "getMTabLayout", "()Lcom/google/android/material/tabs/TabLayout;", "setMTabLayout", "(Lcom/google/android/material/tabs/TabLayout;)V", "mTabViewPager", "Lcom/box/android/base/presentation/views/TogglableViewPager;", "getMTabViewPager", "()Lcom/box/android/base/presentation/views/TogglableViewPager;", "setMTabViewPager", "(Lcom/box/android/base/presentation/views/TogglableViewPager;)V", "mIsSelectFromCode", "", "getMIsSelectFromCode", "()Z", "setMIsSelectFromCode", "(Z)V", "mUserContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "getMUserContextManager", "()Lcom/box/android/domain/identity/IUserContextManager;", "setMUserContextManager", "(Lcom/box/android/domain/identity/IUserContextManager;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "createAdapter", "Landroidx/viewpager/widget/PagerAdapter;", "setUpTabs", "", "setTabLayoutView", "selectedPosition", "", "updateTabWithCustomView", "tab", "Lcom/google/android/material/tabs/TabLayout$Tab;", "updateTabAppearance", "selected", "canBeLogged", "getCurrentPageName", "", "getCurrentEventName", "getCtaLocationString", "getLastTabPositionKey", "getClickKey", "getAmplitudePageName", "getTitle", "context", "Landroid/content/Context;", "getType", "getGenericId", "onBackPressed", "logTabSelected", "changeTabPosition", "navigationTabPosition", "updateFragment", "message", "Lcom/box/android/coreservices/modelcontroller/messages/BoxMessage;", "togglePaging", "enabled", "updateFromRemote", "shouldUpdateFragment", "getTabFragment", ViewProps.POSITION, "getCurrentFragment", "storeLastTabPosition", "navigationTabAdapterPos", "getChildTabSelectedListener", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "onPageChangeListener", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "onDestroyView", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class TabLayoutFragment extends Fragment implements BoxFragmentInterface {
    public static final int $stable = 8;
    private boolean mIsSelectFromCode;
    public TabLayout mTabLayout;
    protected TogglableViewPager mTabViewPager;

    @Inject
    public IUserContextManager mUserContextManager;

    public static /* synthetic */ void getMTabLayout$annotations() {
    }

    protected boolean canBeLogged() {
        return true;
    }

    protected abstract PagerAdapter createAdapter();

    protected TabLayout.OnTabSelectedListener getChildTabSelectedListener() {
        return null;
    }

    protected abstract String getClickKey();

    protected abstract String getCtaLocationString();

    protected abstract String getCurrentEventName();

    protected abstract String getCurrentPageName();

    protected abstract String getLastTabPositionKey();

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public boolean onBackPressed() {
        return false;
    }

    public final TabLayout getMTabLayout() {
        TabLayout tabLayout = this.mTabLayout;
        if (tabLayout != null) {
            return tabLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        return null;
    }

    public final void setMTabLayout(TabLayout tabLayout) {
        Intrinsics.checkNotNullParameter(tabLayout, "<set-?>");
        this.mTabLayout = tabLayout;
    }

    protected final TogglableViewPager getMTabViewPager() {
        TogglableViewPager togglableViewPager = this.mTabViewPager;
        if (togglableViewPager != null) {
            return togglableViewPager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mTabViewPager");
        return null;
    }

    protected final void setMTabViewPager(TogglableViewPager togglableViewPager) {
        Intrinsics.checkNotNullParameter(togglableViewPager, "<set-?>");
        this.mTabViewPager = togglableViewPager;
    }

    protected final boolean getMIsSelectFromCode() {
        return this.mIsSelectFromCode;
    }

    protected final void setMIsSelectFromCode(boolean z) {
        this.mIsSelectFromCode = z;
    }

    public final IUserContextManager getMUserContextManager() {
        IUserContextManager iUserContextManager = this.mUserContextManager;
        if (iUserContextManager != null) {
            return iUserContextManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mUserContextManager");
        return null;
    }

    public final void setMUserContextManager(IUserContextManager iUserContextManager) {
        Intrinsics.checkNotNullParameter(iUserContextManager, "<set-?>");
        this.mUserContextManager = iUserContextManager;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.layout_navigation, container, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        View viewFindViewById = viewInflate.findViewById(R.id.navigation_tab_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        setMTabLayout((TabLayout) viewFindViewById);
        View viewFindViewById2 = viewInflate.findViewById(R.id.navigation_tab_view_pager);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        setMTabViewPager((TogglableViewPager) viewFindViewById2);
        getMTabViewPager().addOnPageChangeListener(onPageChangeListener());
        getMTabLayout().addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.box.android.base.presentation.fragments.TabLayoutFragment.onCreateView.1
            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                Intrinsics.checkNotNullParameter(tab, "tab");
                BoxFragmentInterface tabFragment = TabLayoutFragment.this.getTabFragment(tab.getPosition());
                tabFragment.updateFromRemote();
                TabLayoutFragment.this.updateTabAppearance(tab, true);
                if (!TabLayoutFragment.this.getMIsSelectFromCode()) {
                    TabLayoutFragment.this.logTabSelected();
                }
                TabLayoutFragment.this.setMIsSelectFromCode(false);
                KeyEventDispatcher.Component activity = TabLayoutFragment.this.getActivity();
                IBoxFragmentActivity iBoxFragmentActivity = activity instanceof IBoxFragmentActivity ? (IBoxFragmentActivity) activity : null;
                if (iBoxFragmentActivity != null) {
                    iBoxFragmentActivity.dismissOutdatedSnackbar(tabFragment);
                    iBoxFragmentActivity.logAnalyticsCurrentPage();
                    iBoxFragmentActivity.setupAddFab();
                }
                TabLayoutFragment.this.storeLastTabPosition(tab.getPosition());
                TabLayout.OnTabSelectedListener childTabSelectedListener = TabLayoutFragment.this.getChildTabSelectedListener();
                if (childTabSelectedListener != null) {
                    childTabSelectedListener.onTabSelected(tab);
                }
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                Intrinsics.checkNotNullParameter(tab, "tab");
                TabLayoutFragment.this.updateTabAppearance(tab, false);
                TabLayout.OnTabSelectedListener childTabSelectedListener = TabLayoutFragment.this.getChildTabSelectedListener();
                if (childTabSelectedListener != null) {
                    childTabSelectedListener.onTabUnselected(tab);
                }
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabReselected(TabLayout.Tab tab) {
                Intrinsics.checkNotNullParameter(tab, "tab");
                TabLayout.OnTabSelectedListener childTabSelectedListener = TabLayoutFragment.this.getChildTabSelectedListener();
                if (childTabSelectedListener != null) {
                    childTabSelectedListener.onTabReselected(tab);
                }
            }
        });
        setUpTabs();
        return viewInflate;
    }

    private final void setUpTabs() {
        getMTabViewPager().setAdapter(createAdapter());
        int i = getMUserContextManager().getUserSharedPrefs().getInt(getLastTabPositionKey(), 0);
        this.mIsSelectFromCode = true;
        getMTabViewPager().setCurrentItem(i, true);
        getMTabLayout().setupWithViewPager(getMTabViewPager());
        setTabLayoutView(i);
    }

    private final void setTabLayoutView(int selectedPosition) {
        int tabCount = getMTabLayout().getTabCount();
        int i = 0;
        while (i < tabCount) {
            TabLayout.Tab tabAt = getMTabLayout().getTabAt(i);
            if (tabAt != null) {
                updateTabWithCustomView(tabAt);
                updateTabAppearance(tabAt, i == selectedPosition);
            }
            i++;
        }
    }

    protected void updateTabWithCustomView(TabLayout.Tab tab) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        MAMTextView mAMTextView = new MAMTextView(getContext());
        mAMTextView.setText(tab.getText());
        mAMTextView.setTextAppearance(R.style.TextAppearance_Box_Normal_14sp_TopBarInactive_LetterSpacing07);
        mAMTextView.setGravity(17);
        tab.setCustomView(mAMTextView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateTabAppearance(TabLayout.Tab tab, boolean selected) {
        View customView = tab.getCustomView();
        TextView textView = customView instanceof TextView ? (TextView) customView : null;
        if (textView == null) {
            View customView2 = tab.getCustomView();
            textView = customView2 != null ? (TextView) customView2.findViewById(android.R.id.text1) : null;
        }
        if (textView != null) {
            if (selected) {
                textView.setTypeface(null, 1);
                Context contextRequireContext = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                textView.setTextColor(CommonBoxUtil.getColorFromAttribute(contextRequireContext, R.attr.topBarControl));
                return;
            }
            textView.setTypeface(null, 0);
            Context contextRequireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
            textView.setTextColor(CommonBoxUtil.getColorFromAttribute(contextRequireContext2, R.attr.topBarInactive));
        }
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public String getAmplitudePageName() {
        return getCurrentPageName();
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public String getTitle(Context context) {
        return getCurrentFragment().getTitle(context);
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public int getType() {
        return getCurrentFragment().getType();
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public String getGenericId() {
        String genericId = getCurrentFragment().getGenericId();
        Intrinsics.checkNotNullExpressionValue(genericId, "getGenericId(...)");
        return genericId;
    }

    protected void logTabSelected() {
        if (canBeLogged()) {
            BoxAmplitudeAnalytics.EventPropertyBuilder eventPropertyBuilderCreateEventBuilder = BoxAmplitudeAnalytics.createEventBuilder();
            eventPropertyBuilderCreateEventBuilder.setFlow(BoxAnalyticsParams.FLOW_FILE_NAVIGATION);
            eventPropertyBuilderCreateEventBuilder.setCtaTarget(getCurrentPageName());
            eventPropertyBuilderCreateEventBuilder.setCtaPageLocation(getCtaLocationString());
            eventPropertyBuilderCreateEventBuilder.logEvent(getCurrentEventName());
            if (getArguments() == null || !requireArguments().getBoolean(getClickKey(), false)) {
                return;
            }
            requireArguments().putBoolean(getClickKey(), false);
        }
    }

    public void changeTabPosition(int navigationTabPosition) {
        storeLastTabPosition(navigationTabPosition);
        if (this.mTabViewPager == null || getMTabViewPager().getAdapter() == null) {
            return;
        }
        getMTabViewPager().setCurrentItem(navigationTabPosition);
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    @Deprecated(message = "Deprecated in Java")
    public void updateFragment(BoxMessage<?> message) {
        List<Fragment> fragments = getChildFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "getFragments(...)");
        for (ActivityResultCaller activityResultCaller : fragments) {
            BoxFragmentInterface boxFragmentInterface = activityResultCaller instanceof BoxFragmentInterface ? (BoxFragmentInterface) activityResultCaller : null;
            if (boxFragmentInterface != null && boxFragmentInterface.shouldUpdateFragment(message)) {
                boxFragmentInterface.updateFragment(message);
            }
        }
    }

    public final void togglePaging(boolean enabled) {
        getMTabViewPager().setPagingEnabled(enabled);
        if (enabled) {
            getMTabLayout().setVisibility(0);
        } else {
            getMTabLayout().setVisibility(8);
        }
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public void updateFromRemote() {
        getCurrentFragment().updateFromRemote();
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    @Deprecated(message = "Deprecated in Java")
    public boolean shouldUpdateFragment(BoxMessage<?> message) {
        Intrinsics.checkNotNullParameter(message, "message");
        List<Fragment> fragments = getChildFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "getFragments(...)");
        List<Fragment> list = fragments;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        for (ActivityResultCaller activityResultCaller : list) {
            BoxFragmentInterface boxFragmentInterface = activityResultCaller instanceof BoxFragmentInterface ? (BoxFragmentInterface) activityResultCaller : null;
            if (boxFragmentInterface != null && boxFragmentInterface.shouldUpdateFragment(message)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final BoxFragmentInterface getTabFragment(int position) {
        PagerAdapter adapter = getMTabViewPager().getAdapter();
        Intrinsics.checkNotNull(adapter);
        Object objInstantiateItem = adapter.instantiateItem((ViewGroup) getMTabViewPager(), position);
        Intrinsics.checkNotNull(objInstantiateItem, "null cannot be cast to non-null type com.box.android.base.presentation.BoxFragmentInterface");
        return (BoxFragmentInterface) objInstantiateItem;
    }

    public final BoxFragmentInterface getCurrentFragment() {
        return getTabFragment(getMTabViewPager().getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void storeLastTabPosition(int navigationTabAdapterPos) {
        getMUserContextManager().getUserSharedPrefs().edit().putInt(getLastTabPositionKey(), navigationTabAdapterPos).commit();
    }

    protected ViewPager.OnPageChangeListener onPageChangeListener() {
        return new ViewPager.OnPageChangeListener() { // from class: com.box.android.base.presentation.fragments.TabLayoutFragment.onPageChangeListener.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int state) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int position) {
            }
        };
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        FragmentTransaction fragmentTransactionBeginTransaction = childFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "beginTransaction(...)");
        for (Fragment fragment : childFragmentManager.getFragments()) {
            Intrinsics.checkNotNull(fragment);
            fragmentTransactionBeginTransaction.remove(fragment);
        }
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        super.onDestroyView();
    }
}
