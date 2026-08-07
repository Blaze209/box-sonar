package com.box.android.activities.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.lifecycle.Observer;
import com.box.android.R;
import com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings;
import com.box.android.coreservices.models.ui.pushnotifications.PushNotificationCategoriesUIModel;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.models.pushnotifications.NotificationCategory;
import com.box.android.vm.PushNotificationSettingsVM;
import com.box.android.vm.PushNotificationSettingsViewModelFactory;
import java.util.HashMap;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes9.dex */
public class SettingsNotificationsFragment extends Hilt_SettingsNotificationsFragment {
    private Boolean mCollabsNotificationEnabled;
    private Boolean mCommentsNotificationEnabled;

    @Inject
    FeatureFlips mFeatureFlips;
    private View mFragmentView;

    @Inject
    protected IMoCoBoxGlobalSettings mGlobalSettings;
    private PushNotificationSettingsVM mPushNotificationSettingsVM;

    @Inject
    PushNotificationSettingsViewModelFactory mPushNotificationSettingsViewModelFactory;
    private Boolean mTasksNotificationEnabled;
    private Boolean mUpdatesNotificationEnabled;

    @Inject
    IUserContextManager userContextManager;
    private final int[] optionsIdArray = {R.id.allowCommentsPushNotificationContainer, R.id.allowCollabsPushNotificationContainer, R.id.allowTasksPushNotificationContainer, R.id.allowUpdatesPushNotificationContainer};
    private final int[] notifTypeCheckboxesIdArray = {R.id.allowCommentsPushNotificationCheckBox, R.id.allowCollabsPushNotificationCheckBox, R.id.allowTasksPushNotificationCheckBox, R.id.allowUpdatesPushNotificationCheckBox};

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        if (this.mFeatureFlips.getViewAnnotations().getEnabled()) {
            PushNotificationSettingsVM pushNotificationSettingsVM = (PushNotificationSettingsVM) this.mPushNotificationSettingsViewModelFactory.create(PushNotificationSettingsVM.class);
            this.mPushNotificationSettingsVM = pushNotificationSettingsVM;
            pushNotificationSettingsVM.getCategories().observe(this, new Observer<PushNotificationCategoriesUIModel>() { // from class: com.box.android.activities.settings.SettingsNotificationsFragment.1
                @Override // androidx.lifecycle.Observer
                public void onChanged(PushNotificationCategoriesUIModel pushNotificationCategoriesUIModel) {
                    SettingsNotificationsFragment.this.mCollabsNotificationEnabled = Boolean.valueOf(pushNotificationCategoriesUIModel.getCollabInvite());
                    SettingsNotificationsFragment.this.mCommentsNotificationEnabled = Boolean.valueOf(pushNotificationCategoriesUIModel.getComments());
                    SettingsNotificationsFragment.this.mUpdatesNotificationEnabled = Boolean.valueOf(pushNotificationCategoriesUIModel.getEdit() && pushNotificationCategoriesUIModel.getUpload());
                    SettingsNotificationsFragment settingsNotificationsFragment = SettingsNotificationsFragment.this;
                    settingsNotificationsFragment.setOptionsSettingsIntoView(settingsNotificationsFragment.mFragmentView);
                }
            });
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mFeatureFlips.getViewAnnotations().getEnabled()) {
            this.mFragmentView = layoutInflater.inflate(R.layout.settings_notifications_fragment_v2, viewGroup);
        } else {
            this.mFragmentView = layoutInflater.inflate(R.layout.settings_notifications_fragment, viewGroup);
        }
        hideDisabledItems(this.mFragmentView);
        updateFragment(this.mFragmentView);
        if (this.mFeatureFlips.getViewAnnotations().getEnabled()) {
            this.mPushNotificationSettingsVM.fetchCategoriesFromRemote();
        }
        setLocalOptionsSettingsIntoView(this.mFragmentView);
        return this.mFragmentView;
    }

    private void hideDisabledItems(View view) {
        if (this.userContextManager.getUserType() == 0) {
            view.findViewById(R.id.allowUpdatesPushNotificationContainer).setVisibility(8);
        }
        view.findViewById(R.id.enableDeviceNotificationsContainer).setVisibility(8);
        view.findViewById(R.id.allowTasksPushNotificationContainer).setVisibility(8);
    }

    public void updateFragment(View view) {
        setCheckBoxListeners(view);
        for (int i : this.optionsIdArray) {
            view.findViewById(i).setOnClickListener(new View.OnClickListener() { // from class: com.box.android.activities.settings.SettingsNotificationsFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    SettingsNotificationsFragment.this.clickOnOption(view2);
                }
            });
        }
        for (int i2 : this.notifTypeCheckboxesIdArray) {
            view.findViewById(i2).setClickable(false);
        }
    }

    private void setLocalOptionsSettingsIntoView(View view) {
        this.mCommentsNotificationEnabled = Boolean.valueOf(this.mGlobalSettings.shouldAllowCommentsPushNotification());
        this.mCollabsNotificationEnabled = Boolean.valueOf(this.mGlobalSettings.shouldAllowCollabsPushNotification());
        this.mUpdatesNotificationEnabled = Boolean.valueOf(this.mGlobalSettings.shouldAllowUpdatesPushNotification());
        this.mTasksNotificationEnabled = Boolean.valueOf(this.mGlobalSettings.shouldAllowTasksPushNotification());
        ((AppCompatCheckBox) view.findViewById(R.id.allowCommentsPushNotificationCheckBox)).setChecked(this.mCommentsNotificationEnabled.booleanValue());
        ((AppCompatCheckBox) view.findViewById(R.id.allowCollabsPushNotificationCheckBox)).setChecked(this.mCollabsNotificationEnabled.booleanValue());
        ((AppCompatCheckBox) view.findViewById(R.id.allowUpdatesPushNotificationCheckBox)).setChecked(this.mUpdatesNotificationEnabled.booleanValue());
        ((AppCompatCheckBox) view.findViewById(R.id.allowTasksPushNotificationCheckBox)).setChecked(this.mTasksNotificationEnabled.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOptionsSettingsIntoView(View view) {
        if (this.mCollabsNotificationEnabled == null || this.mCommentsNotificationEnabled == null || this.mTasksNotificationEnabled == null || this.mUpdatesNotificationEnabled == null) {
            return;
        }
        view.findViewById(R.id.allowCollabsPushNotificationContainer).setVisibility(0);
        view.findViewById(R.id.allowCommentsPushNotificationContainer).setVisibility(0);
        view.findViewById(R.id.allowUpdatesPushNotificationContainer).setVisibility(0);
        view.findViewById(R.id.customDivider).setVisibility(0);
        ((AppCompatCheckBox) view.findViewById(R.id.allowCollabsPushNotificationCheckBox)).setChecked(this.mCollabsNotificationEnabled.booleanValue());
        ((AppCompatCheckBox) view.findViewById(R.id.allowCommentsPushNotificationCheckBox)).setChecked(this.mCommentsNotificationEnabled.booleanValue());
        ((AppCompatCheckBox) view.findViewById(R.id.allowTasksPushNotificationCheckBox)).setChecked(this.mTasksNotificationEnabled.booleanValue());
        ((AppCompatCheckBox) view.findViewById(R.id.allowUpdatesPushNotificationCheckBox)).setChecked(this.mUpdatesNotificationEnabled.booleanValue());
    }

    private void setCheckBoxListeners(View view) {
        ((AppCompatCheckBox) view.findViewById(R.id.allowCollabsPushNotificationCheckBox)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.box.android.activities.settings.SettingsNotificationsFragment.3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (SettingsNotificationsFragment.this.mCollabsNotificationEnabled == null || SettingsNotificationsFragment.this.mCollabsNotificationEnabled.booleanValue() == z) {
                    return;
                }
                SettingsNotificationsFragment.this.mCollabsNotificationEnabled = Boolean.valueOf(z);
                if (SettingsNotificationsFragment.this.mFeatureFlips.getViewAnnotations().getEnabled()) {
                    SettingsNotificationsFragment.this.mPushNotificationSettingsVM.updateNotificationCategory(NotificationCategory.COLLABORATION_INVITE, z);
                } else {
                    SettingsNotificationsFragment.this.updateNotificationGlobalSettings();
                }
                BoxAnalytics.INSTANCE.trackEvent(BoxAnalyticsParams.CATEGORY_SETTINGS, BoxAnalyticsParams.ACTION_ALLOW_COLLAB_PUSH_NOTIF_CHECKBOX, "checkState", Integer.valueOf(z ? 1 : 0));
            }
        });
        ((AppCompatCheckBox) view.findViewById(R.id.allowCommentsPushNotificationCheckBox)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.box.android.activities.settings.SettingsNotificationsFragment.4
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (SettingsNotificationsFragment.this.mCommentsNotificationEnabled == null || SettingsNotificationsFragment.this.mCommentsNotificationEnabled.booleanValue() == z) {
                    return;
                }
                SettingsNotificationsFragment.this.mCommentsNotificationEnabled = Boolean.valueOf(z);
                if (SettingsNotificationsFragment.this.mFeatureFlips.getViewAnnotations().getEnabled()) {
                    SettingsNotificationsFragment.this.mPushNotificationSettingsVM.updateNotificationCategory(NotificationCategory.COMMENT, z);
                } else {
                    SettingsNotificationsFragment.this.updateNotificationGlobalSettings();
                }
                BoxAnalytics.INSTANCE.trackEvent(BoxAnalyticsParams.CATEGORY_SETTINGS, BoxAnalyticsParams.ACTION_ALLOW_COMMENTS_PUSH_NOTIF_CHECKBOX, "checkState", Integer.valueOf(z ? 1 : 0));
            }
        });
        ((AppCompatCheckBox) view.findViewById(R.id.allowUpdatesPushNotificationCheckBox)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.box.android.activities.settings.SettingsNotificationsFragment.5
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (SettingsNotificationsFragment.this.mUpdatesNotificationEnabled == null || SettingsNotificationsFragment.this.mUpdatesNotificationEnabled.booleanValue() == z) {
                    return;
                }
                SettingsNotificationsFragment.this.mUpdatesNotificationEnabled = Boolean.valueOf(z);
                if (SettingsNotificationsFragment.this.mFeatureFlips.getViewAnnotations().getEnabled()) {
                    HashMap map = new HashMap();
                    map.put(NotificationCategory.EDIT, Boolean.valueOf(z));
                    map.put(NotificationCategory.UPLOAD, Boolean.valueOf(z));
                    SettingsNotificationsFragment.this.mPushNotificationSettingsVM.updateNotificationCategory(map);
                } else {
                    SettingsNotificationsFragment.this.updateNotificationGlobalSettings();
                }
                BoxAnalytics.INSTANCE.trackEvent(BoxAnalyticsParams.CATEGORY_SETTINGS, BoxAnalyticsParams.ACTION_ALLOW_UPDATES_PUSH_NOTIF_CHECKBOX, "checkState", Integer.valueOf(z ? 1 : 0));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clickOnOption(View view) {
        AppCompatCheckBox appCompatCheckBox;
        String str;
        int id = view.getId();
        if (id == R.id.allowCommentsPushNotificationContainer) {
            appCompatCheckBox = (AppCompatCheckBox) view.findViewById(R.id.allowCommentsPushNotificationCheckBox);
            str = BoxAmplitudeAnalytics.PushNotifEventPropertyBuilder.NOTIF_TYPE_COMMENTS;
        } else if (id == R.id.allowCollabsPushNotificationContainer) {
            appCompatCheckBox = (AppCompatCheckBox) view.findViewById(R.id.allowCollabsPushNotificationCheckBox);
            str = BoxAmplitudeAnalytics.PushNotifEventPropertyBuilder.NOTIF_TYPE_SHARING;
        } else if (id == R.id.allowUpdatesPushNotificationContainer) {
            appCompatCheckBox = (AppCompatCheckBox) view.findViewById(R.id.allowUpdatesPushNotificationCheckBox);
            str = BoxAmplitudeAnalytics.PushNotifEventPropertyBuilder.NOTIF_TYPE_RELEVANT_UPDATES;
        } else if (id == R.id.allowTasksPushNotificationContainer) {
            appCompatCheckBox = (AppCompatCheckBox) view.findViewById(R.id.allowTasksPushNotificationCheckBox);
            str = BoxAmplitudeAnalytics.PushNotifEventPropertyBuilder.NOTIF_TYPE_TASKS;
        } else {
            appCompatCheckBox = null;
            str = null;
        }
        if (appCompatCheckBox != null) {
            boolean z = !appCompatCheckBox.isChecked();
            appCompatCheckBox.setChecked(z);
            BoxAmplitudeAnalytics.createPushNotifEventPropertyBuilder().logSettingToggled(str, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateNotificationGlobalSettings() {
        this.mGlobalSettings.setShouldAllowCollabsPushNotification(this.mCollabsNotificationEnabled.booleanValue());
        this.mGlobalSettings.setShouldAllowCommentsPushNotification(this.mCommentsNotificationEnabled.booleanValue());
        this.mGlobalSettings.setShouldAllowTasksPushNotification(this.mTasksNotificationEnabled.booleanValue());
        this.mGlobalSettings.setShouldAllowUpdatesPushNotification(this.mUpdatesNotificationEnabled.booleanValue());
    }
}
