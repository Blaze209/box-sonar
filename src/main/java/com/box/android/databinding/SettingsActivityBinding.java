package com.box.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.R;
import com.box.android.base.databinding.ToolbarBinding;

/* JADX INFO: loaded from: classes11.dex */
public final class SettingsActivityBinding implements ViewBinding {
    public final LinearLayout OptionsPasscodeOptions;
    public final LinearLayout allowBiometricsContainer;
    public final SwitchCompat allowBiometricsSwitch;
    public final RelativeLayout bottomOptionalsContainer;
    public final LinearLayout btnClearDownloads;
    public final LinearLayout btnHelpCenter;
    public final LinearLayout btnLogout;
    public final LinearLayout btnPrivacyPolicy;
    public final RelativeLayout btnSwitchAccounts;
    public final LinearLayout btnTermsOfService;
    public final LinearLayout btnUploadLogs;
    public final LinearLayout changePassCode;
    public final LinearLayout changePassCodeTimeout;
    public final LinearLayout continousCaptureContainer;
    public final TextView continousCaptureHeader;
    public final TextView continousCaptureManageSettings;
    public final CoordinatorLayout coordinatorLayout;
    public final TextView currentPasscodeInterval;
    public final LinearLayout debugGroup;
    public final LinearLayout featureFlips;
    public final LinearLayout filesAndFoldersContainer;
    public final TextView filesAndFoldersHeader;
    public final TextView filesAndFoldersManageSettings;
    public final View lastItem;
    public final ConstraintLayout mainSettingsLayout;
    public final ScrollView optionMain;
    public final LinearLayout requirePasscodeContainer;
    public final TextView requirePasscodeSubtext;
    public final SwitchCompat requirePasscodeSwitch;
    private final CoordinatorLayout rootView;
    public final FrameLayout settingsFragmentContainer;
    public final ToolbarBinding settingsToolbar;
    public final CoordinatorLayout snackbarContainer;
    public final LinearLayout splitEnvironment;
    public final TextView storageInfo;
    public final TextView switchAccountsDescription;
    public final TextView switchAccountsLabel;
    public final TextView txtLogout;
    public final TextView txtcleardownloads;
    public final TextView version;

    private SettingsActivityBinding(CoordinatorLayout coordinatorLayout, LinearLayout linearLayout, LinearLayout linearLayout2, SwitchCompat switchCompat, RelativeLayout relativeLayout, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, RelativeLayout relativeLayout2, LinearLayout linearLayout7, LinearLayout linearLayout8, LinearLayout linearLayout9, LinearLayout linearLayout10, LinearLayout linearLayout11, TextView textView, TextView textView2, CoordinatorLayout coordinatorLayout2, TextView textView3, LinearLayout linearLayout12, LinearLayout linearLayout13, LinearLayout linearLayout14, TextView textView4, TextView textView5, View view, ConstraintLayout constraintLayout, ScrollView scrollView, LinearLayout linearLayout15, TextView textView6, SwitchCompat switchCompat2, FrameLayout frameLayout, ToolbarBinding toolbarBinding, CoordinatorLayout coordinatorLayout3, LinearLayout linearLayout16, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12) {
        this.rootView = coordinatorLayout;
        this.OptionsPasscodeOptions = linearLayout;
        this.allowBiometricsContainer = linearLayout2;
        this.allowBiometricsSwitch = switchCompat;
        this.bottomOptionalsContainer = relativeLayout;
        this.btnClearDownloads = linearLayout3;
        this.btnHelpCenter = linearLayout4;
        this.btnLogout = linearLayout5;
        this.btnPrivacyPolicy = linearLayout6;
        this.btnSwitchAccounts = relativeLayout2;
        this.btnTermsOfService = linearLayout7;
        this.btnUploadLogs = linearLayout8;
        this.changePassCode = linearLayout9;
        this.changePassCodeTimeout = linearLayout10;
        this.continousCaptureContainer = linearLayout11;
        this.continousCaptureHeader = textView;
        this.continousCaptureManageSettings = textView2;
        this.coordinatorLayout = coordinatorLayout2;
        this.currentPasscodeInterval = textView3;
        this.debugGroup = linearLayout12;
        this.featureFlips = linearLayout13;
        this.filesAndFoldersContainer = linearLayout14;
        this.filesAndFoldersHeader = textView4;
        this.filesAndFoldersManageSettings = textView5;
        this.lastItem = view;
        this.mainSettingsLayout = constraintLayout;
        this.optionMain = scrollView;
        this.requirePasscodeContainer = linearLayout15;
        this.requirePasscodeSubtext = textView6;
        this.requirePasscodeSwitch = switchCompat2;
        this.settingsFragmentContainer = frameLayout;
        this.settingsToolbar = toolbarBinding;
        this.snackbarContainer = coordinatorLayout3;
        this.splitEnvironment = linearLayout16;
        this.storageInfo = textView7;
        this.switchAccountsDescription = textView8;
        this.switchAccountsLabel = textView9;
        this.txtLogout = textView10;
        this.txtcleardownloads = textView11;
        this.version = textView12;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CoordinatorLayout getRoot() {
        return this.rootView;
    }

    public static SettingsActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static SettingsActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.settings_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static SettingsActivityBinding bind(View view) {
        int i = R.id.Options_PasscodeOptions;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.Options_PasscodeOptions);
        if (linearLayout != null) {
            i = R.id.allowBiometricsContainer;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.allowBiometricsContainer);
            if (linearLayout2 != null) {
                i = R.id.allowBiometricsSwitch;
                SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(view, R.id.allowBiometricsSwitch);
                if (switchCompat != null) {
                    i = R.id.bottom_optionals_container;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.bottom_optionals_container);
                    if (relativeLayout != null) {
                        i = R.id.btnClearDownloads;
                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.btnClearDownloads);
                        if (linearLayout3 != null) {
                            i = R.id.btnHelpCenter;
                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.btnHelpCenter);
                            if (linearLayout4 != null) {
                                i = R.id.btnLogout;
                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.btnLogout);
                                if (linearLayout5 != null) {
                                    i = R.id.btnPrivacyPolicy;
                                    LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.btnPrivacyPolicy);
                                    if (linearLayout6 != null) {
                                        i = R.id.btnSwitchAccounts;
                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.btnSwitchAccounts);
                                        if (relativeLayout2 != null) {
                                            i = R.id.btnTermsOfService;
                                            LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.btnTermsOfService);
                                            if (linearLayout7 != null) {
                                                i = R.id.btnUploadLogs;
                                                LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.btnUploadLogs);
                                                if (linearLayout8 != null) {
                                                    i = R.id.changePassCode;
                                                    LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.changePassCode);
                                                    if (linearLayout9 != null) {
                                                        i = R.id.changePassCodeTimeout;
                                                        LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.changePassCodeTimeout);
                                                        if (linearLayout10 != null) {
                                                            i = R.id.continous_capture_container;
                                                            LinearLayout linearLayout11 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.continous_capture_container);
                                                            if (linearLayout11 != null) {
                                                                i = R.id.continous_capture_header;
                                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.continous_capture_header);
                                                                if (textView != null) {
                                                                    i = R.id.continous_capture_manage_settings;
                                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.continous_capture_manage_settings);
                                                                    if (textView2 != null) {
                                                                        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) view;
                                                                        i = R.id.currentPasscodeInterval;
                                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.currentPasscodeInterval);
                                                                        if (textView3 != null) {
                                                                            i = R.id.debugGroup;
                                                                            LinearLayout linearLayout12 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.debugGroup);
                                                                            if (linearLayout12 != null) {
                                                                                i = R.id.feature_flips;
                                                                                LinearLayout linearLayout13 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.feature_flips);
                                                                                if (linearLayout13 != null) {
                                                                                    i = R.id.files_and_folders_container;
                                                                                    LinearLayout linearLayout14 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.files_and_folders_container);
                                                                                    if (linearLayout14 != null) {
                                                                                        i = R.id.files_and_folders_header;
                                                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.files_and_folders_header);
                                                                                        if (textView4 != null) {
                                                                                            i = R.id.files_and_folders_manage_settings;
                                                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.files_and_folders_manage_settings);
                                                                                            if (textView5 != null) {
                                                                                                i = R.id.last_item;
                                                                                                View viewFindChildViewById = ViewBindings.findChildViewById(view, R.id.last_item);
                                                                                                if (viewFindChildViewById != null) {
                                                                                                    i = R.id.mainSettingsLayout;
                                                                                                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.mainSettingsLayout);
                                                                                                    if (constraintLayout != null) {
                                                                                                        i = R.id.option_main;
                                                                                                        ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, R.id.option_main);
                                                                                                        if (scrollView != null) {
                                                                                                            i = R.id.requirePasscodeContainer;
                                                                                                            LinearLayout linearLayout15 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.requirePasscodeContainer);
                                                                                                            if (linearLayout15 != null) {
                                                                                                                i = R.id.requirePasscodeSubtext;
                                                                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.requirePasscodeSubtext);
                                                                                                                if (textView6 != null) {
                                                                                                                    i = R.id.requirePasscodeSwitch;
                                                                                                                    SwitchCompat switchCompat2 = (SwitchCompat) ViewBindings.findChildViewById(view, R.id.requirePasscodeSwitch);
                                                                                                                    if (switchCompat2 != null) {
                                                                                                                        i = R.id.settings_fragment_container;
                                                                                                                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.settings_fragment_container);
                                                                                                                        if (frameLayout != null) {
                                                                                                                            i = R.id.settingsToolbar;
                                                                                                                            View viewFindChildViewById2 = ViewBindings.findChildViewById(view, R.id.settingsToolbar);
                                                                                                                            if (viewFindChildViewById2 != null) {
                                                                                                                                ToolbarBinding toolbarBindingBind = ToolbarBinding.bind(viewFindChildViewById2);
                                                                                                                                i = R.id.snackbar_container;
                                                                                                                                CoordinatorLayout coordinatorLayout2 = (CoordinatorLayout) ViewBindings.findChildViewById(view, R.id.snackbar_container);
                                                                                                                                if (coordinatorLayout2 != null) {
                                                                                                                                    i = R.id.split_environment;
                                                                                                                                    LinearLayout linearLayout16 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.split_environment);
                                                                                                                                    if (linearLayout16 != null) {
                                                                                                                                        i = R.id.storageInfo;
                                                                                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, R.id.storageInfo);
                                                                                                                                        if (textView7 != null) {
                                                                                                                                            i = R.id.switchAccountsDescription;
                                                                                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view, R.id.switchAccountsDescription);
                                                                                                                                            if (textView8 != null) {
                                                                                                                                                i = R.id.switchAccountsLabel;
                                                                                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(view, R.id.switchAccountsLabel);
                                                                                                                                                if (textView9 != null) {
                                                                                                                                                    i = R.id.txtLogout;
                                                                                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(view, R.id.txtLogout);
                                                                                                                                                    if (textView10 != null) {
                                                                                                                                                        i = R.id.txtcleardownloads;
                                                                                                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(view, R.id.txtcleardownloads);
                                                                                                                                                        if (textView11 != null) {
                                                                                                                                                            i = R.id.version;
                                                                                                                                                            TextView textView12 = (TextView) ViewBindings.findChildViewById(view, R.id.version);
                                                                                                                                                            if (textView12 != null) {
                                                                                                                                                                return new SettingsActivityBinding(coordinatorLayout, linearLayout, linearLayout2, switchCompat, relativeLayout, linearLayout3, linearLayout4, linearLayout5, linearLayout6, relativeLayout2, linearLayout7, linearLayout8, linearLayout9, linearLayout10, linearLayout11, textView, textView2, coordinatorLayout, textView3, linearLayout12, linearLayout13, linearLayout14, textView4, textView5, viewFindChildViewById, constraintLayout, scrollView, linearLayout15, textView6, switchCompat2, frameLayout, toolbarBindingBind, coordinatorLayout2, linearLayout16, textView7, textView8, textView9, textView10, textView11, textView12);
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
