package com.box.android.activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import java.util.concurrent.ExecutionException;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes9.dex */
public class RefreshDialogActivity extends Hilt_RefreshDialogActivity {
    public static final String EXTRA_ACCESS_TOKEN = "extarAccessToken";

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected Integer getActivityLayoutId() {
        return null;
    }

    @Override // com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, androidx.activity.ComponentActivity, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public /* bridge */ /* synthetic */ ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return super.getDefaultViewModelProviderFactory();
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    public void onBoxCreate(Bundle bundle) {
        super.onBoxCreate(bundle);
        showSpinner();
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    public void onBoxResume() {
        super.onBoxResume();
        new Thread(new Runnable() { // from class: com.box.android.activities.RefreshDialogActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onBoxResume$0();
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBoxResume$0() {
        try {
            this.mBoxSession.refresh().get();
            finishWithAccessToken(this.mBoxSession.getAuthInfo().accessToken());
        } catch (InterruptedException | ExecutionException e) {
            if (e instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
            finishWithAccessToken(null);
        } finally {
            broadcastDismissSpinner();
        }
    }

    public void finishWithAccessToken(String str) {
        if (StringUtils.isNotBlank(str)) {
            Intent intent = new Intent();
            intent.putExtra(EXTRA_ACCESS_TOKEN, str);
            setResult(-1, intent);
        } else {
            setResult(0);
        }
        finish();
    }
}
