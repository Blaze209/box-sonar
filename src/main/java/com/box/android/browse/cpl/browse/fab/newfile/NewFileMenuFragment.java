package com.box.android.browse.cpl.browse.fab.newfile;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.box.android.base.R;
import com.box.android.base.models.BottomSheetMenuItem;
import com.box.android.base.presentation.fragments.BottomSheetMenuFragment;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.utils.BoxItemUtility;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes10.dex */
public class NewFileMenuFragment extends Hilt_NewFileMenuFragment {

    @Inject
    protected IntentServices mIntentServices;
    private BoxFolder mParentFolder;
    private NewFileMenuUtils newFileMenuUtils;

    @Override // com.box.android.base.presentation.fragments.BottomSheetMenuFragment
    protected void broadcastClick(Intent intent) {
    }

    public static NewFileMenuFragment newInstance(Activity activity, BoxFolder boxFolder) {
        Bundle bundle = getBundle(activity, R.menu.new_file_menu);
        bundle.putSerializable(BottomSheetMenuFragment.EXTRA_BOX_ITEM, BoxItemUtility.copyFolderWithNoItems(boxFolder));
        NewFileMenuFragment newFileMenuFragment = new NewFileMenuFragment();
        newFileMenuFragment.setArguments(bundle);
        return newFileMenuFragment;
    }

    @Override // com.box.android.base.presentation.fragments.BottomSheetMenuFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public void setupDialog(Dialog dialog, int i) {
        super.setupDialog(dialog, i);
        TextView textView = (TextView) View.inflate(getContext(), R.layout.sort_order_menu_header, null);
        textView.setText(R.string.LS_New_Document);
        ((LinearLayout) this.mContentView).addView(textView, 0);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        this.newFileMenuUtils = new NewFileMenuUtils(getContext());
        this.mParentFolder = (BoxFolder) getArguments().getSerializable(BottomSheetMenuFragment.EXTRA_BOX_ITEM);
        return super.onCreateDialog(bundle);
    }

    @Override // com.box.android.base.presentation.fragments.BottomSheetMenuFragment
    protected List<MenuItem> filterItems(Menu menu) {
        ArrayList arrayList = new ArrayList();
        Iterator<NewFileType> it = this.newFileMenuUtils.getAvailableCreateNewFileOptions().iterator();
        while (it.hasNext()) {
            arrayList.add(menu.findItem(it.next().getMenuId()));
        }
        return arrayList;
    }

    @Override // com.box.android.base.presentation.fragments.BottomSheetMenuFragment
    protected void onMenuItemClicked(BottomSheetMenuItem bottomSheetMenuItem) {
        for (NewFileType newFileType : NewFileType.getEntries()) {
            if (newFileType.getMenuId() == bottomSheetMenuItem.getId()) {
                getActivity().startActivity(this.mIntentServices.createDocumentTaskIntent(requireContext(), this.mParentFolder.getUserId(), newFileType.getAssetName()));
                dismissAllowingStateLoss();
                return;
            }
        }
    }

    @Override // com.box.android.base.presentation.fragments.BottomSheetMenuFragment
    public String getAmplitudePageName() {
        return BoxAnalyticsParams.PAGE_NAME_NEW_DOCUMENT;
    }

    @Override // com.box.android.base.presentation.fragments.BottomSheetMenuFragment
    public String getAmplitudeFlow() {
        return BoxAnalyticsParams.FLOW_UPLOAD;
    }
}
