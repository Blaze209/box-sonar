package com.box.android.capture.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.capture.R;

/* JADX INFO: loaded from: classes10.dex */
public final class PhotoQualityListDialogBinding implements ViewBinding {
    public final RadioButton largeQuality;
    public final RadioButton mediumQuality;
    public final RadioButton originalQuality;
    public final RadioGroup qualityGroup;
    private final RadioGroup rootView;
    public final RadioButton smallQuality;

    private PhotoQualityListDialogBinding(RadioGroup radioGroup, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioGroup radioGroup2, RadioButton radioButton4) {
        this.rootView = radioGroup;
        this.largeQuality = radioButton;
        this.mediumQuality = radioButton2;
        this.originalQuality = radioButton3;
        this.qualityGroup = radioGroup2;
        this.smallQuality = radioButton4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RadioGroup getRoot() {
        return this.rootView;
    }

    public static PhotoQualityListDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PhotoQualityListDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.photo_quality_list_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static PhotoQualityListDialogBinding bind(View view) {
        int i = R.id.large_quality;
        RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, i);
        if (radioButton != null) {
            i = R.id.medium_quality;
            RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, i);
            if (radioButton2 != null) {
                i = R.id.original_quality;
                RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(view, i);
                if (radioButton3 != null) {
                    RadioGroup radioGroup = (RadioGroup) view;
                    i = R.id.small_quality;
                    RadioButton radioButton4 = (RadioButton) ViewBindings.findChildViewById(view, i);
                    if (radioButton4 != null) {
                        return new PhotoQualityListDialogBinding(radioGroup, radioButton, radioButton2, radioButton3, radioGroup, radioButton4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
