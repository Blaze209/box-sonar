package com.box.android.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.box.android.R;
import com.box.android.application.BoxBaseApplication;
import com.box.android.base.presentation.BoxFragmentInterface;
import com.box.android.browse.utilities.BrowseFragmentFactory;

/* JADX INFO: loaded from: classes9.dex */
public class NavigationTabAdapter extends FragmentStatePagerAdapter {
    protected BrowseFragmentFactory browseFragmentFactory;
    private final String browseStoreKey;
    private final String offlinedStoreKey;
    private final String recentsStoreKey;

    public enum TabOrder {
        ALL_FILES,
        RECENT,
        OFFLINE
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return 3;
    }

    public NavigationTabAdapter(FragmentManager fragmentManager, String str, String str2, String str3, BrowseFragmentFactory browseFragmentFactory) {
        super(fragmentManager);
        this.browseFragmentFactory = browseFragmentFactory;
        this.browseStoreKey = str;
        this.recentsStoreKey = str2;
        this.offlinedStoreKey = str3;
        fragmentManager.setFragmentFactory(browseFragmentFactory);
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        if (i >= TabOrder.values().length) {
            return null;
        }
        int i2 = AnonymousClass1.$SwitchMap$com$box$android$adapters$NavigationTabAdapter$TabOrder[TabOrder.values()[i].ordinal()];
        if (i2 == 1) {
            return this.browseFragmentFactory.createRecentsFragment(this.recentsStoreKey);
        }
        if (i2 == 2) {
            return this.browseFragmentFactory.createBrowseFragment(this.browseStoreKey);
        }
        if (i2 != 3) {
            return null;
        }
        return this.browseFragmentFactory.createOfflinedFragment(this.offlinedStoreKey);
    }

    /* JADX INFO: renamed from: com.box.android.adapters.NavigationTabAdapter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$box$android$adapters$NavigationTabAdapter$TabOrder;

        static {
            int[] iArr = new int[TabOrder.values().length];
            $SwitchMap$com$box$android$adapters$NavigationTabAdapter$TabOrder = iArr;
            try {
                iArr[TabOrder.RECENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$box$android$adapters$NavigationTabAdapter$TabOrder[TabOrder.ALL_FILES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$box$android$adapters$NavigationTabAdapter$TabOrder[TabOrder.OFFLINE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        if (i == 0) {
            return BoxBaseApplication.getInstance().getString(R.string.files);
        }
        return ((BoxFragmentInterface) getItem(i)).getTitle(BoxBaseApplication.getInstance());
    }
}
