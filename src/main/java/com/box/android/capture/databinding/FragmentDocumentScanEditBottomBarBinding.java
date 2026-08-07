package com.box.android.capture.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.capture.R;

/* JADX INFO: loaded from: classes10.dex */
public final class FragmentDocumentScanEditBottomBarBinding implements ViewBinding {
    public final ConstraintLayout bottomBar;
    public final Button cancelButton;
    public final AppCompatImageButton colorFilter;
    public final ConstraintLayout cropBar;
    public final AppCompatImageButton cropImage;
    public final Button cropImageDoneButton;
    public final AppCompatImageButton deleteImage;
    public final Group editButtons;
    public final Button editDoneBtn;
    public final Guideline middleGuideline;
    private final ConstraintLayout rootView;
    public final AppCompatImageButton rotateImage;

    private FragmentDocumentScanEditBottomBarBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, Button button, AppCompatImageButton appCompatImageButton, ConstraintLayout constraintLayout3, AppCompatImageButton appCompatImageButton2, Button button2, AppCompatImageButton appCompatImageButton3, Group group, Button button3, Guideline guideline, AppCompatImageButton appCompatImageButton4) {
        this.rootView = constraintLayout;
        this.bottomBar = constraintLayout2;
        this.cancelButton = button;
        this.colorFilter = appCompatImageButton;
        this.cropBar = constraintLayout3;
        this.cropImage = appCompatImageButton2;
        this.cropImageDoneButton = button2;
        this.deleteImage = appCompatImageButton3;
        this.editButtons = group;
        this.editDoneBtn = button3;
        this.middleGuideline = guideline;
        this.rotateImage = appCompatImageButton4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentDocumentScanEditBottomBarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDocumentScanEditBottomBarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_document_scan_edit_bottom_bar, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentDocumentScanEditBottomBarBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.cancel_button;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.color_filter;
            AppCompatImageButton appCompatImageButton = (AppCompatImageButton) ViewBindings.findChildViewById(view, i);
            if (appCompatImageButton != null) {
                i = R.id.crop_bar;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout2 != null) {
                    i = R.id.crop_image;
                    AppCompatImageButton appCompatImageButton2 = (AppCompatImageButton) ViewBindings.findChildViewById(view, i);
                    if (appCompatImageButton2 != null) {
                        i = R.id.crop_image_done_button;
                        Button button2 = (Button) ViewBindings.findChildViewById(view, i);
                        if (button2 != null) {
                            i = R.id.delete_image;
                            AppCompatImageButton appCompatImageButton3 = (AppCompatImageButton) ViewBindings.findChildViewById(view, i);
                            if (appCompatImageButton3 != null) {
                                i = R.id.edit_buttons;
                                Group group = (Group) ViewBindings.findChildViewById(view, i);
                                if (group != null) {
                                    i = R.id.edit_done_btn;
                                    Button button3 = (Button) ViewBindings.findChildViewById(view, i);
                                    if (button3 != null) {
                                        i = R.id.middle_guideline;
                                        Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
                                        if (guideline != null) {
                                            i = R.id.rotate_image;
                                            AppCompatImageButton appCompatImageButton4 = (AppCompatImageButton) ViewBindings.findChildViewById(view, i);
                                            if (appCompatImageButton4 != null) {
                                                return new FragmentDocumentScanEditBottomBarBinding(constraintLayout, constraintLayout, button, appCompatImageButton, constraintLayout2, appCompatImageButton2, button2, appCompatImageButton3, group, button3, guideline, appCompatImageButton4);
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
