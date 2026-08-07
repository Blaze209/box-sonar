package com.box.android.base.presentation.activities;

import android.content.Intent;
import android.os.Bundle;
import com.box.android.coreservices.modelcontroller.messages.BoxUserAuthenticationMessage;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.androidsdk.content.utils.BoxLogUtils;

/* JADX INFO: loaded from: classes9.dex */
public abstract class BoxEntrypointActivity extends BoxFragmentActivity {
    protected Long entryTime;

    protected boolean authenticateOnResume() {
        return true;
    }

    protected boolean cancelsLaunchIntoCapture() {
        return true;
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected Integer getActivityLayoutId() {
        return null;
    }

    protected abstract void onAuthenticated(BoxUserAuthenticationMessage boxUserAuthenticationMessage);

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected final boolean requiresAuthToken() {
        return false;
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected final boolean requiresPinCode() {
        return false;
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        this.entryTime = Long.valueOf(System.currentTimeMillis());
        super.onMAMCreate(bundle);
        if (cancelsLaunchIntoCapture()) {
            this.mLaunchIntoCapture.clearPending();
        }
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    public void onBoxCreate(Bundle bundle) {
        super.onBoxCreate(bundle);
        validateAppRestrictions();
        try {
            BoxAmplitudeAnalytics.getInstance().setReferrer("direct");
        } catch (Exception e) {
            BoxLogUtils.logException(e);
        }
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected void handleOnNewIntent(Intent intent) {
        super.handleOnNewIntent(intent);
        if (authenticateOnResume()) {
            authenticate();
        }
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    public void onBoxResume() {
        super.onBoxResume();
        if (authenticateOnResume()) {
            authenticate();
        }
    }
}
