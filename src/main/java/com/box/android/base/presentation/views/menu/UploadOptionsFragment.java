package com.box.android.base.presentation.views.menu;

import android.app.Activity;
import android.os.Bundle;
import com.box.android.base.R;
import com.box.android.base.presentation.fragments.BottomSheetMenuFragment;
import com.box.androidsdk.content.models.BoxFolder;

/* JADX INFO: loaded from: classes9.dex */
public class UploadOptionsFragment extends Hilt_UploadOptionsFragment {
    public static UploadOptionsFragment newInstance(Activity activity, BoxFolder boxFolder) {
        Bundle bundle = BottomSheetMenuFragment.getBundle(activity, R.menu.file_or_folder_menu);
        bundle.putSerializable(BottomSheetMenuFragment.EXTRA_BOX_ITEM, boxFolder);
        UploadOptionsFragment uploadOptionsFragment = new UploadOptionsFragment();
        uploadOptionsFragment.setArguments(bundle);
        return uploadOptionsFragment;
    }
}
