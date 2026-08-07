package com.box.android.base.presentation.views.menu;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.box.android.base.R;
import com.box.android.base.presentation.fragments.BottomSheetMenuFragment;
import com.box.android.base.presentation.fragments.models.BottomSheetAttributes;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.androidsdk.content.models.BoxBookmark;
import com.box.androidsdk.content.models.BoxItem;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class BookmarkSheetFragment extends Hilt_BookmarkSheetFragment {
    private BoxBookmark mBoxBookmark;

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        this.mBoxBookmark = (BoxBookmark) getArguments().getSerializable(BottomSheetMenuFragment.EXTRA_BOX_ITEM);
        return super.onCreateDialog(bundle);
    }

    @Override // com.box.android.base.presentation.fragments.BottomSheetMenuFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public void setupDialog(Dialog dialog, int i) {
        super.setupDialog(dialog, i);
        View upHeader = setUpHeader();
        ((TextView) upHeader.findViewById(R.id.title)).setText(this.mBoxBookmark.getName());
        ((ImageView) upHeader.findViewById(R.id.icon)).setImageResource(R.drawable.ic_box_browsesdk_web_link);
        this.mRecyclerView.setHasFixedSize(true);
    }

    @Override // com.box.android.base.presentation.fragments.BottomSheetMenuFragment
    protected String getAction() {
        return BottomSheetMenuFragment.EXTRA_ACTION_BOX_ITEM_OVERFLOW_MENU_ITEM_SET;
    }

    @Override // com.box.android.base.presentation.fragments.BottomSheetMenuFragment
    protected void broadcastClick(Intent intent) {
        intent.putExtra(BottomSheetMenuFragment.EXTRA_BOX_ITEM, this.mBoxBookmark);
        super.broadcastClick(intent);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0049  */
    @Override // com.box.android.base.presentation.fragments.BottomSheetMenuFragment
    protected List<MenuItem> filterItems(Menu menu) {
        ArrayList arrayList = new ArrayList();
        EnumSet<BoxItem.Permission> permissions = this.mBoxBookmark.getPermissions();
        for (int i = 0; i < menu.size(); i++) {
            MenuItem item = menu.getItem(i);
            int itemId = item.getItemId();
            if (itemId == R.id.menu_rename) {
                if (permissions.contains(BoxItem.Permission.CAN_RENAME)) {
                    arrayList.add(item);
                }
            } else if (itemId == R.id.menu_delete) {
                if (permissions.contains(BoxItem.Permission.CAN_DELETE)) {
                    arrayList.add(item);
                }
            } else if (itemId != R.id.menu_share || permissions.contains(BoxItem.Permission.CAN_INVITE_COLLABORATOR) || permissions.contains(BoxItem.Permission.CAN_SHARE)) {
                arrayList.add(item);
            }
        }
        return arrayList;
    }

    public static BookmarkSheetFragment newInstance(Activity activity, BoxBookmark boxBookmark, BottomSheetAttributes.BottomSheetMenuType bottomSheetMenuType, BottomSheetAttributes.LaunchContext launchContext, boolean z) {
        int i;
        if (z) {
            i = R.menu.bookmark_redesigned;
        } else {
            i = R.menu.bookmark;
        }
        Bundle bundle = getBundle(activity, i);
        bundle.putSerializable(BottomSheetMenuFragment.EXTRA_BOX_ITEM, boxBookmark);
        bundle.putSerializable(BottomSheetMenuFragment.EXTRA_BOTTOM_SHEET_MENU_TYPE, bottomSheetMenuType);
        bundle.putSerializable(BottomSheetMenuFragment.EXTRA_LAUNCH_CONTEXT, launchContext);
        BookmarkSheetFragment bookmarkSheetFragment = new BookmarkSheetFragment();
        bookmarkSheetFragment.setArguments(bundle);
        return bookmarkSheetFragment;
    }

    @Override // com.box.android.base.presentation.fragments.BottomSheetMenuFragment
    public String getAmplitudePageName() {
        return BoxAnalyticsParams.PAGE_NAME_MORE_OPTIONS_BOOKMARK;
    }

    @Override // com.box.android.base.presentation.fragments.BottomSheetMenuFragment
    protected boolean isRedesignedStyle() {
        return this.mFeatureFlips.getMainScreenRedesign().getEnabled();
    }
}
