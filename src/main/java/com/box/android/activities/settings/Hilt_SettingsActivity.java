package com.box.android.activities.settings;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import com.box.android.base.presentation.activities.BoxFragmentActivity;
import dagger.hilt.internal.GeneratedComponentManagerHolder;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: classes9.dex */
abstract class Hilt_SettingsActivity extends BoxFragmentActivity {
    private boolean injected = false;

    Hilt_SettingsActivity() {
        _initHiltInternal();
    }

    private void _initHiltInternal() {
        addOnContextAvailableListener(new OnContextAvailableListener() { // from class: com.box.android.activities.settings.Hilt_SettingsActivity.1
            @Override // androidx.activity.contextaware.OnContextAvailableListener
            public void onContextAvailable(Context context) {
                Hilt_SettingsActivity.this.inject();
            }
        });
    }

    @Override // com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity
    protected void inject() {
        if (this.injected) {
            return;
        }
        this.injected = true;
        ((SettingsActivity_GeneratedInjector) ((GeneratedComponentManagerHolder) UnsafeCasts.unsafeCast(this)).generatedComponent()).injectSettingsActivity((SettingsActivity) UnsafeCasts.unsafeCast(this));
    }
}
