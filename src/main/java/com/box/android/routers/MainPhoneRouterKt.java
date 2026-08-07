package com.box.android.routers;

import android.os.Bundle;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import com.box.android.cpl.ScopesStore;
import com.box.android.cpl.Store;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MainPhoneRouter.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006"}, d2 = {"popBackStackToArgument", "", "Landroidx/navigation/NavController;", "key", "", "value", "box_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class MainPhoneRouterKt {
    public static final void popBackStackToArgument(NavController navController, String key, String value) {
        Intrinsics.checkNotNullParameter(navController, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        while (true) {
            NavBackStackEntry currentBackStackEntry = navController.getCurrentBackStackEntry();
            if (currentBackStackEntry == null) {
                return;
            }
            Bundle arguments = currentBackStackEntry.getArguments();
            String string = arguments != null ? arguments.getString(key) : null;
            if (Intrinsics.areEqual(string, value)) {
                return;
            }
            if (string != null) {
                Object obj = ScopesStore.INSTANCE.get(string);
                Store store = obj instanceof Store ? (Store) obj : null;
                if (store != null) {
                    store.close();
                }
            }
            navController.popBackStack();
        }
    }
}
