package com.box.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.SwitchCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.R;

/* JADX INFO: loaded from: classes11.dex */
public final class FragmentAutoContentUploadBinding implements ViewBinding {
    public final RelativeLayout autoContentUploadContainer;
    public final LinearLayout autoContentUploadOptions;
    public final TextView autoUploadMainDescription;
    public final SwitchCompat autoUploadMainSwitch;
    public final TextView autoUploadMainText;
    public final AppCompatCheckBox autoUploadMeteredSwitch;
    public final RelativeLayout autoUploadMeteredSwitchContainer;
    public final TextView collabFolderWarning;
    public final TextView localFolderToMonitor;
    public final TextView localFolderToMonitorPath;
    public final LinearLayout localFolderToMonitorPathContainer;
    public final TextView meteredUploadMainDescription;
    public final TextView meteredUploadMainText;
    public final TextView notifyUploadDescription;
    public final AppCompatCheckBox notifyUploadSwitch;
    public final RelativeLayout notifyUploadSwitchContainer;
    public final TextView remoteFolderToMonitor;
    public final TextView remoteFolderToMonitorPath;
    public final LinearLayout remoteFolderToMonitorPathContainer;
    private final LinearLayout rootView;

    private FragmentAutoContentUploadBinding(LinearLayout linearLayout, RelativeLayout relativeLayout, LinearLayout linearLayout2, TextView textView, SwitchCompat switchCompat, TextView textView2, AppCompatCheckBox appCompatCheckBox, RelativeLayout relativeLayout2, TextView textView3, TextView textView4, TextView textView5, LinearLayout linearLayout3, TextView textView6, TextView textView7, TextView textView8, AppCompatCheckBox appCompatCheckBox2, RelativeLayout relativeLayout3, TextView textView9, TextView textView10, LinearLayout linearLayout4) {
        this.rootView = linearLayout;
        this.autoContentUploadContainer = relativeLayout;
        this.autoContentUploadOptions = linearLayout2;
        this.autoUploadMainDescription = textView;
        this.autoUploadMainSwitch = switchCompat;
        this.autoUploadMainText = textView2;
        this.autoUploadMeteredSwitch = appCompatCheckBox;
        this.autoUploadMeteredSwitchContainer = relativeLayout2;
        this.collabFolderWarning = textView3;
        this.localFolderToMonitor = textView4;
        this.localFolderToMonitorPath = textView5;
        this.localFolderToMonitorPathContainer = linearLayout3;
        this.meteredUploadMainDescription = textView6;
        this.meteredUploadMainText = textView7;
        this.notifyUploadDescription = textView8;
        this.notifyUploadSwitch = appCompatCheckBox2;
        this.notifyUploadSwitchContainer = relativeLayout3;
        this.remoteFolderToMonitor = textView9;
        this.remoteFolderToMonitorPath = textView10;
        this.remoteFolderToMonitorPathContainer = linearLayout4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentAutoContentUploadBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentAutoContentUploadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_auto_content_upload, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentAutoContentUploadBinding bind(View view) {
        int i = R.id.autoContentUploadContainer;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.autoContentUploadContainer);
        if (relativeLayout != null) {
            i = R.id.autoContentUploadOptions;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.autoContentUploadOptions);
            if (linearLayout != null) {
                i = R.id.autoUploadMainDescription;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.autoUploadMainDescription);
                if (textView != null) {
                    i = R.id.autoUploadMainSwitch;
                    SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(view, R.id.autoUploadMainSwitch);
                    if (switchCompat != null) {
                        i = R.id.autoUploadMainText;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.autoUploadMainText);
                        if (textView2 != null) {
                            i = R.id.autoUploadMeteredSwitch;
                            AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) ViewBindings.findChildViewById(view, R.id.autoUploadMeteredSwitch);
                            if (appCompatCheckBox != null) {
                                i = R.id.autoUploadMeteredSwitchContainer;
                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.autoUploadMeteredSwitchContainer);
                                if (relativeLayout2 != null) {
                                    i = R.id.collabFolderWarning;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.collabFolderWarning);
                                    if (textView3 != null) {
                                        i = R.id.localFolderToMonitor;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.localFolderToMonitor);
                                        if (textView4 != null) {
                                            i = R.id.localFolderToMonitorPath;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.localFolderToMonitorPath);
                                            if (textView5 != null) {
                                                i = R.id.localFolderToMonitorPathContainer;
                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.localFolderToMonitorPathContainer);
                                                if (linearLayout2 != null) {
                                                    i = R.id.meteredUploadMainDescription;
                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.meteredUploadMainDescription);
                                                    if (textView6 != null) {
                                                        i = R.id.meteredUploadMainText;
                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, R.id.meteredUploadMainText);
                                                        if (textView7 != null) {
                                                            i = R.id.notifyUploadDescription;
                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view, R.id.notifyUploadDescription);
                                                            if (textView8 != null) {
                                                                i = R.id.notifyUploadSwitch;
                                                                AppCompatCheckBox appCompatCheckBox2 = (AppCompatCheckBox) ViewBindings.findChildViewById(view, R.id.notifyUploadSwitch);
                                                                if (appCompatCheckBox2 != null) {
                                                                    i = R.id.notifyUploadSwitchContainer;
                                                                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.notifyUploadSwitchContainer);
                                                                    if (relativeLayout3 != null) {
                                                                        i = R.id.remoteFolderToMonitor;
                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(view, R.id.remoteFolderToMonitor);
                                                                        if (textView9 != null) {
                                                                            i = R.id.remoteFolderToMonitorPath;
                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(view, R.id.remoteFolderToMonitorPath);
                                                                            if (textView10 != null) {
                                                                                i = R.id.remoteFolderToMonitorPathContainer;
                                                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.remoteFolderToMonitorPathContainer);
                                                                                if (linearLayout3 != null) {
                                                                                    return new FragmentAutoContentUploadBinding((LinearLayout) view, relativeLayout, linearLayout, textView, switchCompat, textView2, appCompatCheckBox, relativeLayout2, textView3, textView4, textView5, linearLayout2, textView6, textView7, textView8, appCompatCheckBox2, relativeLayout3, textView9, textView10, linearLayout3);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
