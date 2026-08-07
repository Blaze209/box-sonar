package com.box.android.base.presentation.views.menu;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.box.android.base.R;
import com.box.android.base.models.BottomSheetMenuItem;
import com.box.android.base.presentation.fragments.BottomSheetMenuFragment;
import com.box.android.common.utilities.ApplicationProvider;

/* JADX INFO: loaded from: classes9.dex */
public class RecentItemsFilterFragment extends Hilt_RecentItemsFilterFragment {
    private static final String ACTIVE_FILTER_MENU_ID = "ACTIVE_FILTER_MENU_ID";

    public static RecentItemsFilterFragment newInstance(Activity activity) {
        RecentItemsFilterFragment recentItemsFilterFragment = new RecentItemsFilterFragment();
        recentItemsFilterFragment.setArguments(getBundle(activity, R.menu.recent_items_filter_menu_v2, true));
        return recentItemsFilterFragment;
    }

    public static RecentItemsFilterFragment newInstance(Activity activity, Integer num) {
        RecentItemsFilterFragment recentItemsFilterFragmentNewInstance = newInstance(activity);
        if (num != null) {
            recentItemsFilterFragmentNewInstance.getArguments().putInt(ACTIVE_FILTER_MENU_ID, num.intValue());
        }
        return recentItemsFilterFragmentNewInstance;
    }

    @Override // com.box.android.base.presentation.fragments.BottomSheetMenuFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public void setupDialog(Dialog dialog, int i) {
        super.setupDialog(dialog, i);
        ((LinearLayout) this.mContentView).addView(View.inflate(getContext(), R.layout.filter_by_menu_header, null), 0);
        if (getArguments() == null || !getArguments().containsKey(ACTIVE_FILTER_MENU_ID)) {
            return;
        }
        updateMenuItemIcon(getArguments().getInt(ACTIVE_FILTER_MENU_ID), R.drawable.ic_done_24px);
    }

    @Override // com.box.android.base.presentation.fragments.BottomSheetMenuFragment
    protected void onMenuItemClicked(BottomSheetMenuItem bottomSheetMenuItem) {
        super.onMenuItemClicked(bottomSheetMenuItem);
        Intent intent = new Intent();
        intent.setAction(BottomSheetMenuFragment.EXTRA_ACTION_BOX_MENU_ITEM_SET);
        intent.putExtra(BottomSheetMenuFragment.EXTRA_BOX_MENU_ITEM_ID, bottomSheetMenuItem.getId());
        LocalBroadcastManager.getInstance(ApplicationProvider.application).sendBroadcast(intent);
    }
}
