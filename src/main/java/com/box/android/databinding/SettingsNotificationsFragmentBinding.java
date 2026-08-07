package com.box.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.SwitchCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.R;

/* JADX INFO: loaded from: classes11.dex */
public final class SettingsNotificationsFragmentBinding implements ViewBinding {
    public final AppCompatCheckBox allowCollabsPushNotificationCheckBox;
    public final RelativeLayout allowCollabsPushNotificationContainer;
    public final TextView allowCollabsPushNotificationLabel;
    public final AppCompatCheckBox allowCommentsPushNotificationCheckBox;
    public final RelativeLayout allowCommentsPushNotificationContainer;
    public final TextView allowCommentsPushNotificationLabel;
    public final AppCompatCheckBox allowTasksPushNotificationCheckBox;
    public final RelativeLayout allowTasksPushNotificationContainer;
    public final TextView allowTasksPushNotificationLabel;
    public final AppCompatCheckBox allowUpdatesPushNotificationCheckBox;
    public final RelativeLayout allowUpdatesPushNotificationContainer;
    public final TextView allowUpdatesPushNotificationLabel;
    public final ImageView customDivider;
    public final LinearLayout enableDeviceNotificationsContainer;
    public final SwitchCompat enableDeviceNotificationsSwitch;
    private final LinearLayout rootView;

    private SettingsNotificationsFragmentBinding(LinearLayout linearLayout, AppCompatCheckBox appCompatCheckBox, RelativeLayout relativeLayout, TextView textView, AppCompatCheckBox appCompatCheckBox2, RelativeLayout relativeLayout2, TextView textView2, AppCompatCheckBox appCompatCheckBox3, RelativeLayout relativeLayout3, TextView textView3, AppCompatCheckBox appCompatCheckBox4, RelativeLayout relativeLayout4, TextView textView4, ImageView imageView, LinearLayout linearLayout2, SwitchCompat switchCompat) {
        this.rootView = linearLayout;
        this.allowCollabsPushNotificationCheckBox = appCompatCheckBox;
        this.allowCollabsPushNotificationContainer = relativeLayout;
        this.allowCollabsPushNotificationLabel = textView;
        this.allowCommentsPushNotificationCheckBox = appCompatCheckBox2;
        this.allowCommentsPushNotificationContainer = relativeLayout2;
        this.allowCommentsPushNotificationLabel = textView2;
        this.allowTasksPushNotificationCheckBox = appCompatCheckBox3;
        this.allowTasksPushNotificationContainer = relativeLayout3;
        this.allowTasksPushNotificationLabel = textView3;
        this.allowUpdatesPushNotificationCheckBox = appCompatCheckBox4;
        this.allowUpdatesPushNotificationContainer = relativeLayout4;
        this.allowUpdatesPushNotificationLabel = textView4;
        this.customDivider = imageView;
        this.enableDeviceNotificationsContainer = linearLayout2;
        this.enableDeviceNotificationsSwitch = switchCompat;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SettingsNotificationsFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static SettingsNotificationsFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.settings_notifications_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static SettingsNotificationsFragmentBinding bind(View view) {
        int i = R.id.allowCollabsPushNotificationCheckBox;
        AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) ViewBindings.findChildViewById(view, R.id.allowCollabsPushNotificationCheckBox);
        if (appCompatCheckBox != null) {
            i = R.id.allowCollabsPushNotificationContainer;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.allowCollabsPushNotificationContainer);
            if (relativeLayout != null) {
                i = R.id.allowCollabsPushNotificationLabel;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.allowCollabsPushNotificationLabel);
                if (textView != null) {
                    i = R.id.allowCommentsPushNotificationCheckBox;
                    AppCompatCheckBox appCompatCheckBox2 = (AppCompatCheckBox) ViewBindings.findChildViewById(view, R.id.allowCommentsPushNotificationCheckBox);
                    if (appCompatCheckBox2 != null) {
                        i = R.id.allowCommentsPushNotificationContainer;
                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.allowCommentsPushNotificationContainer);
                        if (relativeLayout2 != null) {
                            i = R.id.allowCommentsPushNotificationLabel;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.allowCommentsPushNotificationLabel);
                            if (textView2 != null) {
                                i = R.id.allowTasksPushNotificationCheckBox;
                                AppCompatCheckBox appCompatCheckBox3 = (AppCompatCheckBox) ViewBindings.findChildViewById(view, R.id.allowTasksPushNotificationCheckBox);
                                if (appCompatCheckBox3 != null) {
                                    i = R.id.allowTasksPushNotificationContainer;
                                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.allowTasksPushNotificationContainer);
                                    if (relativeLayout3 != null) {
                                        i = R.id.allowTasksPushNotificationLabel;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.allowTasksPushNotificationLabel);
                                        if (textView3 != null) {
                                            i = R.id.allowUpdatesPushNotificationCheckBox;
                                            AppCompatCheckBox appCompatCheckBox4 = (AppCompatCheckBox) ViewBindings.findChildViewById(view, R.id.allowUpdatesPushNotificationCheckBox);
                                            if (appCompatCheckBox4 != null) {
                                                i = R.id.allowUpdatesPushNotificationContainer;
                                                RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.allowUpdatesPushNotificationContainer);
                                                if (relativeLayout4 != null) {
                                                    i = R.id.allowUpdatesPushNotificationLabel;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.allowUpdatesPushNotificationLabel);
                                                    if (textView4 != null) {
                                                        i = R.id.customDivider;
                                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.customDivider);
                                                        if (imageView != null) {
                                                            i = R.id.enableDeviceNotificationsContainer;
                                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.enableDeviceNotificationsContainer);
                                                            if (linearLayout != null) {
                                                                i = R.id.enableDeviceNotificationsSwitch;
                                                                SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(view, R.id.enableDeviceNotificationsSwitch);
                                                                if (switchCompat != null) {
                                                                    return new SettingsNotificationsFragmentBinding((LinearLayout) view, appCompatCheckBox, relativeLayout, textView, appCompatCheckBox2, relativeLayout2, textView2, appCompatCheckBox3, relativeLayout3, textView3, appCompatCheckBox4, relativeLayout4, textView4, imageView, linearLayout, switchCompat);
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
