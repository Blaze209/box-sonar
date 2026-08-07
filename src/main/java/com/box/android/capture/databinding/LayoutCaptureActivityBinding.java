package com.box.android.capture.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.compose.ui.platform.ComposeView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.base.databinding.ToolbarBinding;
import com.box.android.capture.R;

/* JADX INFO: loaded from: classes10.dex */
public final class LayoutCaptureActivityBinding implements ViewBinding {
    public final AppCompatImageButton captureCloseButton;
    public final AppCompatImageButton captureFlashButton;
    public final FragmentContainerView captureFragmentContainer;
    public final AppCompatImageButton captureSettingsButton;
    public final ToolbarBinding captureToolbar;
    public final ConstraintLayout captureTopBar;
    public final LinearLayout changeUploadFolderButton;
    public final TextView elapsedTime;
    public final ImageView folderIcon;
    public final TextView folderLabel;
    public final ProgressBar folderProgressBar;
    public final ComposeView modeSwitcherCompose;
    private final ConstraintLayout rootView;

    private LayoutCaptureActivityBinding(ConstraintLayout constraintLayout, AppCompatImageButton appCompatImageButton, AppCompatImageButton appCompatImageButton2, FragmentContainerView fragmentContainerView, AppCompatImageButton appCompatImageButton3, ToolbarBinding toolbarBinding, ConstraintLayout constraintLayout2, LinearLayout linearLayout, TextView textView, ImageView imageView, TextView textView2, ProgressBar progressBar, ComposeView composeView) {
        this.rootView = constraintLayout;
        this.captureCloseButton = appCompatImageButton;
        this.captureFlashButton = appCompatImageButton2;
        this.captureFragmentContainer = fragmentContainerView;
        this.captureSettingsButton = appCompatImageButton3;
        this.captureToolbar = toolbarBinding;
        this.captureTopBar = constraintLayout2;
        this.changeUploadFolderButton = linearLayout;
        this.elapsedTime = textView;
        this.folderIcon = imageView;
        this.folderLabel = textView2;
        this.folderProgressBar = progressBar;
        this.modeSwitcherCompose = composeView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutCaptureActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutCaptureActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_capture_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutCaptureActivityBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.capture_close_button;
        AppCompatImageButton appCompatImageButton = (AppCompatImageButton) ViewBindings.findChildViewById(view, i);
        if (appCompatImageButton != null) {
            i = R.id.capture_flash_button;
            AppCompatImageButton appCompatImageButton2 = (AppCompatImageButton) ViewBindings.findChildViewById(view, i);
            if (appCompatImageButton2 != null) {
                i = R.id.capture_fragment_container;
                FragmentContainerView fragmentContainerView = (FragmentContainerView) ViewBindings.findChildViewById(view, i);
                if (fragmentContainerView != null) {
                    i = R.id.capture_settings_button;
                    AppCompatImageButton appCompatImageButton3 = (AppCompatImageButton) ViewBindings.findChildViewById(view, i);
                    if (appCompatImageButton3 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.captureToolbar))) != null) {
                        ToolbarBinding toolbarBindingBind = ToolbarBinding.bind(viewFindChildViewById);
                        i = R.id.capture_top_bar;
                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout != null) {
                            i = R.id.change_upload_folder_button;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout != null) {
                                i = R.id.elapsed_time;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView != null) {
                                    i = R.id.folder_icon;
                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView != null) {
                                        i = R.id.folder_label;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView2 != null) {
                                            i = R.id.folder_progress_bar;
                                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                            if (progressBar != null) {
                                                i = R.id.mode_switcher_compose;
                                                ComposeView composeView = (ComposeView) ViewBindings.findChildViewById(view, i);
                                                if (composeView != null) {
                                                    return new LayoutCaptureActivityBinding((ConstraintLayout) view, appCompatImageButton, appCompatImageButton2, fragmentContainerView, appCompatImageButton3, toolbarBindingBind, constraintLayout, linearLayout, textView, imageView, textView2, progressBar, composeView);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
