package com.box.android.activities;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import com.box.android.base.presentation.activities.BoxEntrypointActivity;
import dagger.hilt.internal.GeneratedComponentManagerHolder;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: classes9.dex */
abstract class Hilt_NotificationInterceptorActivity extends BoxEntrypointActivity {
    private boolean injected = false;

    Hilt_NotificationInterceptorActivity() {
        _initHiltInternal();
    }

    private void _initHiltInternal() {
        addOnContextAvailableListener(new OnContextAvailableListener() { // from class: com.box.android.activities.Hilt_NotificationInterceptorActivity.1
            @Override // androidx.activity.contextaware.OnContextAvailableListener
            public void onContextAvailable(Context context) {
                Hilt_NotificationInterceptorActivity.this.inject();
            }
        });
    }

    @Override // com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity
    protected void inject() {
        if (this.injected) {
            return;
        }
        this.injected = true;
        ((NotificationInterceptorActivity_GeneratedInjector) ((GeneratedComponentManagerHolder) UnsafeCasts.unsafeCast(this)).generatedComponent()).injectNotificationInterceptorActivity((NotificationInterceptorActivity) UnsafeCasts.unsafeCast(this));
    }
}
