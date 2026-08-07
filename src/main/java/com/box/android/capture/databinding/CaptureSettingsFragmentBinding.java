package com.box.android.capture.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.base.databinding.ToolbarBinding;
import com.box.android.capture.R;

/* JADX INFO: loaded from: classes10.dex */
public final class CaptureSettingsFragmentBinding implements ViewBinding {
    public final TextView cameraSettingsHeader;
    public final TextView continousCaptureHeader;
    public final RelativeLayout gpsLocationContainer;
    public final TextView gpsLocationLabel;
    public final SwitchCompat gpsLocationSetting;
    public final SwitchCompat launchIntoCapture;
    public final RelativeLayout launchIntoCaptureContainer;
    public final TextView launchIntoCaptureLabel;
    public final TextView launchIntoCaptureLearnMore;
    public final ConstraintLayout photoQualityContainer;
    public final TextView photoQualityLabel;
    public final TextView photoQualitySelected;
    public final ConstraintLayout reviewAfterCaptureContainer;
    public final TextView reviewAfterCaptureLabel;
    public final SwitchCompat reviewAfterCaptureSettings;
    private final ConstraintLayout rootView;
    public final ToolbarBinding settingsToolbar;
    public final ConstraintLayout videoQualityContainer;
    public final TextView videoQualityLabel;
    public final TextView videoQualitySelected;

    private CaptureSettingsFragmentBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, RelativeLayout relativeLayout, TextView textView3, SwitchCompat switchCompat, SwitchCompat switchCompat2, RelativeLayout relativeLayout2, TextView textView4, TextView textView5, ConstraintLayout constraintLayout2, TextView textView6, TextView textView7, ConstraintLayout constraintLayout3, TextView textView8, SwitchCompat switchCompat3, ToolbarBinding toolbarBinding, ConstraintLayout constraintLayout4, TextView textView9, TextView textView10) {
        this.rootView = constraintLayout;
        this.cameraSettingsHeader = textView;
        this.continousCaptureHeader = textView2;
        this.gpsLocationContainer = relativeLayout;
        this.gpsLocationLabel = textView3;
        this.gpsLocationSetting = switchCompat;
        this.launchIntoCapture = switchCompat2;
        this.launchIntoCaptureContainer = relativeLayout2;
        this.launchIntoCaptureLabel = textView4;
        this.launchIntoCaptureLearnMore = textView5;
        this.photoQualityContainer = constraintLayout2;
        this.photoQualityLabel = textView6;
        this.photoQualitySelected = textView7;
        this.reviewAfterCaptureContainer = constraintLayout3;
        this.reviewAfterCaptureLabel = textView8;
        this.reviewAfterCaptureSettings = switchCompat3;
        this.settingsToolbar = toolbarBinding;
        this.videoQualityContainer = constraintLayout4;
        this.videoQualityLabel = textView9;
        this.videoQualitySelected = textView10;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static CaptureSettingsFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static CaptureSettingsFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.capture_settings_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CaptureSettingsFragmentBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.camera_settings_header;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.continous_capture_header;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.gps_location_container;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                if (relativeLayout != null) {
                    i = R.id.gps_location_label;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        i = R.id.gps_location_setting;
                        SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(view, i);
                        if (switchCompat != null) {
                            i = R.id.launchIntoCapture;
                            SwitchCompat switchCompat2 = (SwitchCompat) ViewBindings.findChildViewById(view, i);
                            if (switchCompat2 != null) {
                                i = R.id.launchIntoCaptureContainer;
                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                if (relativeLayout2 != null) {
                                    i = R.id.launchIntoCaptureLabel;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView4 != null) {
                                        i = R.id.launchIntoCaptureLearnMore;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView5 != null) {
                                            i = R.id.photo_quality_container;
                                            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                            if (constraintLayout != null) {
                                                i = R.id.photo_quality_label;
                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView6 != null) {
                                                    i = R.id.photo_quality_selected;
                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView7 != null) {
                                                        i = R.id.review_after_capture_container;
                                                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                        if (constraintLayout2 != null) {
                                                            i = R.id.review_after_capture_label;
                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView8 != null) {
                                                                i = R.id.review_after_capture_settings;
                                                                SwitchCompat switchCompat3 = (SwitchCompat) ViewBindings.findChildViewById(view, i);
                                                                if (switchCompat3 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.settingsToolbar))) != null) {
                                                                    ToolbarBinding toolbarBindingBind = ToolbarBinding.bind(viewFindChildViewById);
                                                                    i = R.id.video_quality_container;
                                                                    ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (constraintLayout3 != null) {
                                                                        i = R.id.video_quality_label;
                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView9 != null) {
                                                                            i = R.id.video_quality_selected;
                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView10 != null) {
                                                                                return new CaptureSettingsFragmentBinding((ConstraintLayout) view, textView, textView2, relativeLayout, textView3, switchCompat, switchCompat2, relativeLayout2, textView4, textView5, constraintLayout, textView6, textView7, constraintLayout2, textView8, switchCompat3, toolbarBindingBind, constraintLayout3, textView9, textView10);
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
