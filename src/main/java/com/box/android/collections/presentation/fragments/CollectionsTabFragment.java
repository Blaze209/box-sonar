package com.box.android.collections.presentation.fragments;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import com.box.android.base.presentation.BoxFragmentInterface;
import com.box.android.base.presentation.fragments.TabLayoutFragment;
import com.box.android.collections.presentation.adapter.CollectionsTabAdapter;
import com.box.android.coreservices.modelcontroller.messages.BoxMessage;
import com.box.android.coreservices.modelcontroller.messages.BoxSwitchUserMessage;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import dagger.hilt.android.AndroidEntryPoint;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollectionsTabFragment.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0001\u0018B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0014J\b\u0010\f\u001a\u00020\u000bH\u0014J\b\u0010\r\u001a\u00020\u000bH\u0014J\b\u0010\u000e\u001a\u00020\u000bH\u0014J\b\u0010\u000f\u001a\u00020\u000bH\u0014J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\u0016\u0010\u0012\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0014H\u0017J\u0014\u0010\u0015\u001a\u00020\u00162\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0014H\u0017J\b\u0010\u0017\u001a\u00020\u0016H\u0016¨\u0006\u0019"}, d2 = {"Lcom/box/android/collections/presentation/fragments/CollectionsTabFragment;", "Lcom/box/android/base/presentation/fragments/TabLayoutFragment;", "Lcom/box/android/base/presentation/BoxFragmentInterface;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "getCurrentPageName", "", "getCtaLocationString", "getLastTabPositionKey", "getCurrentEventName", "getClickKey", "createAdapter", "Landroidx/viewpager/widget/PagerAdapter;", "updateFragment", "message", "Lcom/box/android/coreservices/modelcontroller/messages/BoxMessage;", "shouldUpdateFragment", "", "isFloatingMenuAvailable", "Companion", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class CollectionsTabFragment extends Hilt_CollectionsTabFragment implements BoxFragmentInterface {
    public static final String EXTRA_CLICK_FROM_COLLECTIONS = "click_from_collection";
    private static final String EXTRA_LAST_TAB_POSITION = "extraLastCollectionsTabPosition";
    public static final int $stable = TabLayoutFragment.$stable;

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public boolean isFloatingMenuAvailable() {
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        updateFromRemote();
    }

    @Override // com.box.android.base.presentation.fragments.TabLayoutFragment
    protected String getCurrentPageName() {
        if (getCurrentFragment() instanceof FavoritesCollectionItemsFragment) {
            return BoxAnalyticsParams.PAGE_NAME_FAVORITES;
        }
        return BoxAnalyticsParams.PAGE_NAME_COLLECTIONS;
    }

    @Override // com.box.android.base.presentation.fragments.TabLayoutFragment
    protected String getCtaLocationString() {
        if (getArguments() != null && requireArguments().getBoolean(EXTRA_CLICK_FROM_COLLECTIONS, false)) {
            return BoxAnalyticsParams.CTA_PAGE_LOCATION_BOTTOM;
        }
        return BoxAnalyticsParams.CTA_PAGE_LOCATION_TOP;
    }

    @Override // com.box.android.base.presentation.fragments.TabLayoutFragment
    protected String getLastTabPositionKey() {
        return EXTRA_LAST_TAB_POSITION;
    }

    @Override // com.box.android.base.presentation.fragments.TabLayoutFragment
    protected String getCurrentEventName() {
        if (getArguments() != null && requireArguments().getBoolean(EXTRA_CLICK_FROM_COLLECTIONS, false)) {
            return BoxAnalyticsParams.EVENT_COLLECTIONS_TAB_TRIGGERED;
        }
        if (getCurrentFragment() instanceof MyCollectionsFragment) {
            return BoxAnalyticsParams.EVENT_MY_COLLECTIONS_TAB_TRIGGERED;
        }
        return BoxAnalyticsParams.EVENT_FAVORITE_TAB_TRIGGERED;
    }

    @Override // com.box.android.base.presentation.fragments.TabLayoutFragment
    protected String getClickKey() {
        return EXTRA_CLICK_FROM_COLLECTIONS;
    }

    @Override // com.box.android.base.presentation.fragments.TabLayoutFragment
    protected PagerAdapter createAdapter() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        return new CollectionsTabAdapter(childFragmentManager);
    }

    @Override // com.box.android.base.presentation.fragments.TabLayoutFragment, com.box.android.base.presentation.BoxFragmentInterface
    @Deprecated(message = "Deprecated in Java")
    public void updateFragment(BoxMessage<?> message) {
        PagerAdapter adapter;
        if ((message instanceof BoxSwitchUserMessage) && (adapter = getMTabViewPager().getAdapter()) != null) {
            adapter.notifyDataSetChanged();
        }
        super.updateFragment(message);
    }

    @Override // com.box.android.base.presentation.fragments.TabLayoutFragment, com.box.android.base.presentation.BoxFragmentInterface
    @Deprecated(message = "Deprecated in Java")
    public boolean shouldUpdateFragment(BoxMessage<?> message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (message instanceof BoxSwitchUserMessage) {
            return true;
        }
        return super.shouldUpdateFragment(message);
    }
}
