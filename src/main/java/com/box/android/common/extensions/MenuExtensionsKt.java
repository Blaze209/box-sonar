package com.box.android.common.extensions;

import android.view.Menu;
import android.view.MenuItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MenuExtensions.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0012\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\b"}, d2 = {"enableMenuItem", "", "Landroid/view/Menu;", "itemId", "", "enabled", "", "disableMenuItem", "common_prodRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class MenuExtensionsKt {
    public static final void enableMenuItem(Menu menu, int i, boolean z) {
        Intrinsics.checkNotNullParameter(menu, "<this>");
        MenuItem menuItemFindItem = menu.findItem(i);
        if (menuItemFindItem != null) {
            menuItemFindItem.setEnabled(z);
            menuItemFindItem.setVisible(z);
        }
    }

    public static final void disableMenuItem(Menu menu, int i) {
        Intrinsics.checkNotNullParameter(menu, "<this>");
        enableMenuItem(menu, i, false);
    }
}
