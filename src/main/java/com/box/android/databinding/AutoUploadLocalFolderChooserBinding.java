package com.box.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.R;
import com.box.android.browse.databinding.PickerToolbarBinding;

/* JADX INFO: loaded from: classes11.dex */
public final class AutoUploadLocalFolderChooserBinding implements ViewBinding {
    public final Button cancelButton;
    public final RelativeLayout cancelSelectBarBackground;
    public final ImageView emptyFolderImage;
    public final TextView emptyFolderText;
    public final Group emptyView;
    public final View emptyViewBackground;
    public final ListView list;
    public final ConstraintLayout parentContainer;
    public final PickerToolbarBinding pickerToolbar;
    public final ProgressBar progressBar;
    private final ConstraintLayout rootView;
    public final Button selectButton;

    private AutoUploadLocalFolderChooserBinding(ConstraintLayout constraintLayout, Button button, RelativeLayout relativeLayout, ImageView imageView, TextView textView, Group group, View view, ListView listView, ConstraintLayout constraintLayout2, PickerToolbarBinding pickerToolbarBinding, ProgressBar progressBar, Button button2) {
        this.rootView = constraintLayout;
        this.cancelButton = button;
        this.cancelSelectBarBackground = relativeLayout;
        this.emptyFolderImage = imageView;
        this.emptyFolderText = textView;
        this.emptyView = group;
        this.emptyViewBackground = view;
        this.list = listView;
        this.parentContainer = constraintLayout2;
        this.pickerToolbar = pickerToolbarBinding;
        this.progressBar = progressBar;
        this.selectButton = button2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AutoUploadLocalFolderChooserBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AutoUploadLocalFolderChooserBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.auto_upload_local_folder_chooser, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AutoUploadLocalFolderChooserBinding bind(View view) {
        int i = R.id.cancel_button;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancel_button);
        if (button != null) {
            i = R.id.cancel_select_bar_background;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.cancel_select_bar_background);
            if (relativeLayout != null) {
                i = R.id.empty_folder_image;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.empty_folder_image);
                if (imageView != null) {
                    i = R.id.empty_folder_text;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.empty_folder_text);
                    if (textView != null) {
                        i = R.id.emptyView;
                        Group group = (Group) ViewBindings.findChildViewById(view, R.id.emptyView);
                        if (group != null) {
                            i = R.id.emptyViewBackground;
                            View viewFindChildViewById = ViewBindings.findChildViewById(view, R.id.emptyViewBackground);
                            if (viewFindChildViewById != null) {
                                i = android.R.id.list;
                                ListView listView = (ListView) ViewBindings.findChildViewById(view, android.R.id.list);
                                if (listView != null) {
                                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                    i = R.id.picker_toolbar;
                                    View viewFindChildViewById2 = ViewBindings.findChildViewById(view, R.id.picker_toolbar);
                                    if (viewFindChildViewById2 != null) {
                                        PickerToolbarBinding pickerToolbarBindingBind = PickerToolbarBinding.bind(viewFindChildViewById2);
                                        i = R.id.progress_bar;
                                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.progress_bar);
                                        if (progressBar != null) {
                                            i = R.id.select_button;
                                            Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.select_button);
                                            if (button2 != null) {
                                                return new AutoUploadLocalFolderChooserBinding(constraintLayout, button, relativeLayout, imageView, textView, group, viewFindChildViewById, listView, constraintLayout, pickerToolbarBindingBind, progressBar, button2);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
