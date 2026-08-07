package com.box.android.collections.presentation.adapter;

import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.box.android.base.presentation.BoxFragmentInterface;
import com.box.android.collections.presentation.fragments.FavoritesCollectionItemsFragment;
import com.box.android.collections.presentation.fragments.MyCollectionsFragment;
import com.box.android.common.utilities.ApplicationProvider;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollectionsTabAdapter.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0011"}, d2 = {"Lcom/box/android/collections/presentation/adapter/CollectionsTabAdapter;", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "manager", "Landroidx/fragment/app/FragmentManager;", "<init>", "(Landroidx/fragment/app/FragmentManager;)V", "getManager", "()Landroidx/fragment/app/FragmentManager;", "setManager", "getItem", "Landroidx/fragment/app/Fragment;", ViewProps.POSITION, "", "getCount", "getPageTitle", "", "TabOrder", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CollectionsTabAdapter extends FragmentStatePagerAdapter {
    public static final int $stable = 8;
    private FragmentManager manager;

    /* JADX INFO: compiled from: CollectionsTabAdapter.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/box/android/collections/presentation/adapter/CollectionsTabAdapter$TabOrder;", "", "<init>", "(Ljava/lang/String;I)V", "FAVORITES", "MY_COLLECTIONS", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum TabOrder {
        FAVORITES,
        MY_COLLECTIONS;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<TabOrder> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: compiled from: CollectionsTabAdapter.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TabOrder.values().length];
            try {
                iArr[TabOrder.FAVORITES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TabOrder.MY_COLLECTIONS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return 2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CollectionsTabAdapter(FragmentManager manager) {
        super(manager);
        Intrinsics.checkNotNullParameter(manager, "manager");
        this.manager = manager;
    }

    public final FragmentManager getManager() {
        return this.manager;
    }

    public final void setManager(FragmentManager fragmentManager) {
        Intrinsics.checkNotNullParameter(fragmentManager, "<set-?>");
        this.manager = fragmentManager;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int position) {
        Fragment favoritesCollectionItemsFragment;
        int i = WhenMappings.$EnumSwitchMapping$0[TabOrder.values()[position].ordinal()];
        if (i == 1) {
            favoritesCollectionItemsFragment = new FavoritesCollectionItemsFragment();
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            favoritesCollectionItemsFragment = new MyCollectionsFragment();
        }
        return favoritesCollectionItemsFragment;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int position) {
        ActivityResultCaller item = getItem(position);
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.box.android.base.presentation.BoxFragmentInterface");
        return ((BoxFragmentInterface) item).getTitle(ApplicationProvider.getApplication());
    }
}
