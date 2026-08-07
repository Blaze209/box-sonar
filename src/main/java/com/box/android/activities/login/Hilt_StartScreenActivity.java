package com.box.android.activities.login;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import com.box.android.activities.analytics.AnalyticsStartScreenActivity;
import dagger.hilt.internal.GeneratedComponentManagerHolder;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: classes9.dex */
abstract class Hilt_StartScreenActivity extends AnalyticsStartScreenActivity {
    private boolean injected = false;

    Hilt_StartScreenActivity() {
        _initHiltInternal();
    }

    private void _initHiltInternal() {
        addOnContextAvailableListener(new OnContextAvailableListener() { // from class: com.box.android.activities.login.Hilt_StartScreenActivity.1
            @Override // androidx.activity.contextaware.OnContextAvailableListener
            public void onContextAvailable(Context context) {
                Hilt_StartScreenActivity.this.inject();
            }
        });
    }

    @Override // com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity
    protected void inject() {
        if (this.injected) {
            return;
        }
        this.injected = true;
        ((StartScreenActivity_GeneratedInjector) ((GeneratedComponentManagerHolder) UnsafeCasts.unsafeCast(this)).generatedComponent()).injectStartScreenActivity((StartScreenActivity) UnsafeCasts.unsafeCast(this));
    }
}
