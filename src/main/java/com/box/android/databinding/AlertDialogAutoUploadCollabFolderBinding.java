package com.box.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.R;

/* JADX INFO: loaded from: classes11.dex */
public final class AlertDialogAutoUploadCollabFolderBinding implements ViewBinding {
    public final AppCompatCheckBox notifyAutoContentUploadCheckBox;
    private final LinearLayout rootView;
    public final TextView warningMessageText;
    public final TextView warningMessageTitle;

    private AlertDialogAutoUploadCollabFolderBinding(LinearLayout linearLayout, AppCompatCheckBox appCompatCheckBox, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.notifyAutoContentUploadCheckBox = appCompatCheckBox;
        this.warningMessageText = textView;
        this.warningMessageTitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static AlertDialogAutoUploadCollabFolderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AlertDialogAutoUploadCollabFolderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.alert_dialog_auto_upload_collab_folder, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AlertDialogAutoUploadCollabFolderBinding bind(View view) {
        int i = R.id.notify_auto_content_upload_check_box;
        AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) ViewBindings.findChildViewById(view, R.id.notify_auto_content_upload_check_box);
        if (appCompatCheckBox != null) {
            i = R.id.warningMessageText;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.warningMessageText);
            if (textView != null) {
                i = R.id.warningMessageTitle;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.warningMessageTitle);
                if (textView2 != null) {
                    return new AlertDialogAutoUploadCollabFolderBinding((LinearLayout) view, appCompatCheckBox, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
