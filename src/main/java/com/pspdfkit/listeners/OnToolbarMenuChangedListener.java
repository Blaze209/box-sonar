package com.pspdfkit.listeners;

import android.view.Menu;
import android.view.MenuItem;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/pspdfkit/listeners/OnToolbarMenuChangedListener;", "", "onCreateToolbarMenu", "", "menu", "Landroid/view/Menu;", "onPrepareToolbarMenu", "onToolbarMenuItemClick", "", "item", "Landroid/view/MenuItem;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface OnToolbarMenuChangedListener {
    void onCreateToolbarMenu(Menu menu);

    void onPrepareToolbarMenu(Menu menu);

    boolean onToolbarMenuItemClick(MenuItem item);
}
