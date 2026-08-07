package com.swmansion.rnscreens.gamma.helpers;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FragmentManagerHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"createTransactionWithReordering", "Landroidx/fragment/app/FragmentTransaction;", "Landroidx/fragment/app/FragmentManager;", "react-native-screens_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class FragmentManagerHelperKt {
    public static final FragmentTransaction createTransactionWithReordering(FragmentManager fragmentManager) {
        Intrinsics.checkNotNullParameter(fragmentManager, "<this>");
        FragmentTransaction reorderingAllowed = fragmentManager.beginTransaction().setReorderingAllowed(true);
        Intrinsics.checkNotNullExpressionValue(reorderingAllowed, "setReorderingAllowed(...)");
        return reorderingAllowed;
    }
}
