package com.microsoft.intune.mam.client.app.startup;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.window.OnBackInvokedCallback;
import com.microsoft.intune.mam.client.app.MAMComponents;

/* JADX INFO: loaded from: classes3.dex */
public class MAMComplianceBlockActivity extends Activity {
    private final MAMComplianceUIBehavior mComplianceUIBehavior = (MAMComplianceUIBehavior) MAMComponents.get(MAMComplianceUIBehavior.class);
    private OnBackInvokedCallback mOnBackInvokedCallback;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        if (this.mComplianceUIBehavior == null) {
            super.onCreate(null);
            finish();
        } else {
            super.onCreate(bundle);
            this.mComplianceUIBehavior.onAfterActivityCreate(this, bundle, getIntent().getExtras());
        }
        if (Build.VERSION.SDK_INT < 33 || this.mComplianceUIBehavior == null) {
            return;
        }
        this.mOnBackInvokedCallback = new OnBackInvokedCallback() { // from class: com.microsoft.intune.mam.client.app.startup.MAMComplianceBlockActivity$$ExternalSyntheticLambda0
            @Override // android.window.OnBackInvokedCallback
            public final void onBackInvoked() {
                this.f$0.m13872xd254baed();
            }
        };
        getOnBackInvokedDispatcher().registerOnBackInvokedCallback(0, this.mOnBackInvokedCallback);
    }

    /* JADX INFO: renamed from: lambda$onCreate$0$com-microsoft-intune-mam-client-app-startup-MAMComplianceBlockActivity, reason: not valid java name */
    /* synthetic */ void m13872xd254baed() {
        this.mComplianceUIBehavior.onBackPressed(this);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (Build.VERSION.SDK_INT < 33 || this.mOnBackInvokedCallback == null) {
            return;
        }
        getOnBackInvokedDispatcher().unregisterOnBackInvokedCallback(this.mOnBackInvokedCallback);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        MAMComplianceUIBehavior mAMComplianceUIBehavior = this.mComplianceUIBehavior;
        if (mAMComplianceUIBehavior == null) {
            super.onBackPressed();
        } else {
            mAMComplianceUIBehavior.onBackPressed(this);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ClassLoader getClassLoader() {
        MAMComplianceUIBehavior mAMComplianceUIBehavior = this.mComplianceUIBehavior;
        if (mAMComplianceUIBehavior == null) {
            return super.getClassLoader();
        }
        return mAMComplianceUIBehavior.getClassLoader();
    }
}
