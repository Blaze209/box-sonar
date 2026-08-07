package com.box.android.browse.utilities;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import com.box.android.browse.cpl.browse.BrowseFragment;
import com.box.android.browse.cpl.offlined.OfflinedFragment;
import com.box.android.browse.cpl.recents.RecentsFragment;
import com.box.android.common.utilities.BoxCommonConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BrowseFragmentFactory.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\t\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007H\u0016¨\u0006\u000e"}, d2 = {"Lcom/box/android/browse/utilities/BrowseFragmentFactory;", "Landroidx/fragment/app/FragmentFactory;", "<init>", "()V", "createBrowseFragment", "Landroidx/fragment/app/Fragment;", BoxCommonConstants.STORE_KEY, "", "createRecentsFragment", "createOfflinedFragment", "instantiate", "classLoader", "Ljava/lang/ClassLoader;", "className", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BrowseFragmentFactory extends FragmentFactory {
    public static final int $stable = 8;

    @Inject
    public BrowseFragmentFactory() {
    }

    public final Fragment createBrowseFragment(String storeKey) {
        BrowseFragment.Companion companion = BrowseFragment.INSTANCE;
        Intrinsics.checkNotNull(storeKey);
        return companion.getInstance(storeKey);
    }

    public final Fragment createRecentsFragment(String storeKey) {
        RecentsFragment.Companion companion = RecentsFragment.INSTANCE;
        Intrinsics.checkNotNull(storeKey);
        return companion.getInstance(storeKey);
    }

    public final Fragment createOfflinedFragment(String storeKey) {
        OfflinedFragment.Companion companion = OfflinedFragment.INSTANCE;
        Intrinsics.checkNotNull(storeKey);
        return companion.getInstance(storeKey);
    }

    @Override // androidx.fragment.app.FragmentFactory
    public Fragment instantiate(ClassLoader classLoader, String className) {
        Intrinsics.checkNotNullParameter(classLoader, "classLoader");
        Intrinsics.checkNotNullParameter(className, "className");
        if (Intrinsics.areEqual(className, BrowseFragment.class.getName())) {
            return new BrowseFragment();
        }
        if (Intrinsics.areEqual(className, RecentsFragment.class.getName())) {
            return new RecentsFragment();
        }
        if (Intrinsics.areEqual(className, OfflinedFragment.class.getName())) {
            return new OfflinedFragment();
        }
        Fragment fragmentInstantiate = super.instantiate(classLoader, className);
        Intrinsics.checkNotNullExpressionValue(fragmentInstantiate, "instantiate(...)");
        return fragmentInstantiate;
    }
}
