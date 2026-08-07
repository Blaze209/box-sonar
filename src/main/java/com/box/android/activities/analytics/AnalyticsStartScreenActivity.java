package com.box.android.activities.analytics;

import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import com.box.android.base.presentation.activities.BoxFragmentActivity;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.domain.analytics.BoxAnalytics;

/* JADX INFO: loaded from: classes9.dex */
public abstract class AnalyticsStartScreenActivity extends BoxFragmentActivity {
    private static final String ANALYTICS_CATEGORY = "android";
    private static final String ANALYTICS_EVENT_TYPE = "first_launch";

    @Override // com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, androidx.activity.ComponentActivity, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public /* bridge */ /* synthetic */ ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return super.getDefaultViewModelProviderFactory();
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected void onBoxCreate(Bundle bundle) {
        super.onBoxCreate(bundle);
        updateFirstRunAnalytics();
    }

    private void updateFirstRunAnalytics() {
        if (this.mGlobalSettings.isFirstLaunch()) {
            BoxAnalytics.INSTANCE.trackEvent("android", ANALYTICS_EVENT_TYPE, CommonBoxUtil.getDeviceName());
            this.mGlobalSettings.setFirstLaunch(false);
        }
    }
}
