package com.box.android.navigationmodernization.utils;

import android.content.res.Configuration;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.box.android.base.presentation.BoxFragmentInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: XmlFragmentDarkModeRecreator.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/box/android/navigationmodernization/utils/XmlFragmentDarkModeRecreator;", "", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "initialNightMode", "", "<init>", "(Landroidx/fragment/app/FragmentManager;I)V", "currentNightMode", "onConfigurationChanged", "", "newConfig", "Landroid/content/res/Configuration;", "recreateXmlFragmentViews", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class XmlFragmentDarkModeRecreator {
    public static final int $stable = 8;
    private int currentNightMode;
    private final FragmentManager fragmentManager;

    public XmlFragmentDarkModeRecreator(FragmentManager fragmentManager, int i) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        this.fragmentManager = fragmentManager;
        this.currentNightMode = i;
    }

    public /* synthetic */ XmlFragmentDarkModeRecreator(FragmentManager fragmentManager, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragmentManager, (i2 & 2) != 0 ? 0 : i);
    }

    public final boolean onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        int i = newConfig.uiMode & 48;
        if (this.currentNightMode == i) {
            return false;
        }
        this.currentNightMode = i;
        recreateXmlFragmentViews();
        return true;
    }

    private final void recreateXmlFragmentViews() {
        List<Fragment> fragments = this.fragmentManager.getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "getFragments(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : fragments) {
            if (obj instanceof BoxFragmentInterface) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (obj2 instanceof Fragment) {
                arrayList2.add(obj2);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj3 : arrayList2) {
            Fragment fragment = (Fragment) obj3;
            if (fragment.isAdded() && !fragment.isDetached()) {
                arrayList3.add(obj3);
            }
        }
        ArrayList arrayList4 = arrayList3;
        if (arrayList4.isEmpty()) {
            return;
        }
        FragmentTransaction fragmentTransactionBeginTransaction = this.fragmentManager.beginTransaction();
        ArrayList arrayList5 = arrayList4;
        Iterator it = arrayList5.iterator();
        while (it.hasNext()) {
            fragmentTransactionBeginTransaction.detach((Fragment) it.next());
        }
        fragmentTransactionBeginTransaction.commitNow();
        FragmentTransaction fragmentTransactionBeginTransaction2 = this.fragmentManager.beginTransaction();
        Iterator it2 = arrayList5.iterator();
        while (it2.hasNext()) {
            fragmentTransactionBeginTransaction2.attach((Fragment) it2.next());
        }
        fragmentTransactionBeginTransaction2.commitNow();
    }
}
