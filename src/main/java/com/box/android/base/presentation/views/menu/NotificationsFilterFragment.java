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
public class NotificationsFilterFragment extends Hilt_NotificationsFilterFragment {
    public static NotificationsFilterFragment newInstance(Activity activity) {
        NotificationsFilterFragment notificationsFilterFragment = new NotificationsFilterFragment();
        notificationsFilterFragment.setArguments(getBundle(activity, R.menu.notifications_filter_menu, true));
        return notificationsFilterFragment;
    }

    @Override // com.box.android.base.presentation.fragments.BottomSheetMenuFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public void setupDialog(Dialog dialog, int i) {
        super.setupDialog(dialog, i);
        ((LinearLayout) this.mContentView).addView(View.inflate(getContext(), R.layout.filter_by_menu_header, null), 0);
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
