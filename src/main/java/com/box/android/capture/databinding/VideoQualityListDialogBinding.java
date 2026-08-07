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
public final class VideoQualityListDialogBinding implements ViewBinding {
    public final RadioButton quality1080p;
    public final RadioButton quality4k;
    public final RadioButton quality720p;
    public final RadioGroup qualityGroup;
    private final RadioGroup rootView;

    private VideoQualityListDialogBinding(RadioGroup radioGroup, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioGroup radioGroup2) {
        this.rootView = radioGroup;
        this.quality1080p = radioButton;
        this.quality4k = radioButton2;
        this.quality720p = radioButton3;
        this.qualityGroup = radioGroup2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RadioGroup getRoot() {
        return this.rootView;
    }

    public static VideoQualityListDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VideoQualityListDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.video_quality_list_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static VideoQualityListDialogBinding bind(View view) {
        int i = R.id.quality_1080p;
        RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, i);
        if (radioButton != null) {
            i = R.id.quality_4k;
            RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, i);
            if (radioButton2 != null) {
                i = R.id.quality_720p;
                RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(view, i);
                if (radioButton3 != null) {
                    RadioGroup radioGroup = (RadioGroup) view;
                    return new VideoQualityListDialogBinding(radioGroup, radioButton, radioButton2, radioButton3, radioGroup);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
