package com.microsoft.intune.mam.client.app.startup;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.window.OnBackInvokedCallback;
import com.microsoft.intune.mam.client.app.MAMComponents;

/* JADX INFO: loaded from: classes3.dex */
public final class MAMStartupActivity extends Activity {
    private OnBackInvokedCallback mOnBackInvokedCallback;
    private final MAMStartupUIBehavior mStartupUIBehavior = (MAMStartupUIBehavior) MAMComponents.get(MAMStartupUIBehavior.class);

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        MAMStartupUIBehavior mAMStartupUIBehavior = this.mStartupUIBehavior;
        if (mAMStartupUIBehavior == null) {
            super.onCreate(null);
            finish();
        } else {
            mAMStartupUIBehavior.onBeforeActivityCreate(this, bundle);
            super.onCreate(bundle);
            this.mStartupUIBehavior.onAfterActivityCreate(this, bundle);
        }
        if (Build.VERSION.SDK_INT >= 33) {
            this.mOnBackInvokedCallback = new OnBackInvokedCallback() { // from class: com.microsoft.intune.mam.client.app.startup.MAMStartupActivity$$ExternalSyntheticLambda0
                @Override // android.window.OnBackInvokedCallback
                public final void onBackInvoked() {
                    this.f$0.m13873x3306d138();
                }
            };
            getOnBackInvokedDispatcher().registerOnBackInvokedCallback(0, this.mOnBackInvokedCallback);
        }
    }

    /* JADX INFO: renamed from: lambda$onCreate$0$com-microsoft-intune-mam-client-app-startup-MAMStartupActivity, reason: not valid java name */
    /* synthetic */ void m13873x3306d138() {
        this.mStartupUIBehavior.onBackPressed(this);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (Build.VERSION.SDK_INT >= 33) {
            getOnBackInvokedDispatcher().unregisterOnBackInvokedCallback(this.mOnBackInvokedCallback);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.mStartupUIBehavior.onBackPressed(this);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.mStartupUIBehavior.onActivityResult(this, i, i2, intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ClassLoader getClassLoader() {
        MAMStartupUIBehavior mAMStartupUIBehavior = this.mStartupUIBehavior;
        if (mAMStartupUIBehavior == null) {
            return super.getClassLoader();
        }
        return mAMStartupUIBehavior.getClassLoader();
    }
}
