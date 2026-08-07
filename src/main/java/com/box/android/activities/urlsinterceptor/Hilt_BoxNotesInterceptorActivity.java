package com.box.android.activities.urlsinterceptor;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.internal.GeneratedComponentManagerHolder;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: classes9.dex */
abstract class Hilt_BoxNotesInterceptorActivity extends SharedLinkInterceptorActivity {
    private boolean injected = false;

    Hilt_BoxNotesInterceptorActivity() {
        _initHiltInternal();
    }

    private void _initHiltInternal() {
        addOnContextAvailableListener(new OnContextAvailableListener() { // from class: com.box.android.activities.urlsinterceptor.Hilt_BoxNotesInterceptorActivity.1
            @Override // androidx.activity.contextaware.OnContextAvailableListener
            public void onContextAvailable(Context context) {
                Hilt_BoxNotesInterceptorActivity.this.inject();
            }
        });
    }

    @Override // com.box.android.activities.urlsinterceptor.Hilt_SharedLinkInterceptorActivity, com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity
    protected void inject() {
        if (this.injected) {
            return;
        }
        this.injected = true;
        ((BoxNotesInterceptorActivity_GeneratedInjector) ((GeneratedComponentManagerHolder) UnsafeCasts.unsafeCast(this)).generatedComponent()).injectBoxNotesInterceptorActivity((BoxNotesInterceptorActivity) UnsafeCasts.unsafeCast(this));
    }
}
