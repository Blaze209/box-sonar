package com.box.android.base.presentation.fragments;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.box.android.base.R;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.androidsdk.content.models.BoxFolder;

/* JADX INFO: loaded from: classes9.dex */
public class LibraryFragment extends Hilt_LibraryFragment {
    private BoxFolder mFolder;

    @Override // com.box.android.base.presentation.fragments.BottomSheetMenuFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public void setupDialog(Dialog dialog, int i) {
        super.setupDialog(dialog, i);
        TextView textView = (TextView) View.inflate(getContext(), R.layout.sort_order_menu_header, null);
        textView.setText(R.string.add_from_library);
        ((LinearLayout) this.mContentView).addView(textView, 0);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        this.mFolder = (BoxFolder) getArguments().getSerializable(BottomSheetMenuFragment.EXTRA_BOX_ITEM);
        return super.onCreateDialog(bundle);
    }

    @Override // com.box.android.base.presentation.fragments.BottomSheetMenuFragment
    protected void broadcastClick(Intent intent) {
        intent.putExtra(BottomSheetMenuFragment.EXTRA_BOX_ITEM, this.mFolder);
        super.broadcastClick(intent);
    }

    @Override // com.box.android.base.presentation.fragments.BottomSheetMenuFragment
    public String getAmplitudePageName() {
        return BoxAnalyticsParams.PAGE_NAME_UPLOAD_CONTENT;
    }

    @Override // com.box.android.base.presentation.fragments.BottomSheetMenuFragment
    public String getAmplitudeFlow() {
        return BoxAnalyticsParams.FLOW_UPLOAD;
    }
}
