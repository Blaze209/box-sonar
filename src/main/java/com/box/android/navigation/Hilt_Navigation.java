package com.box.android.navigation;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import com.box.android.activities.MainParent;
import dagger.hilt.internal.GeneratedComponentManagerHolder;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: classes12.dex */
abstract class Hilt_Navigation extends MainParent {
    private boolean injected = false;

    Hilt_Navigation() {
        _initHiltInternal();
    }

    private void _initHiltInternal() {
        addOnContextAvailableListener(new OnContextAvailableListener() { // from class: com.box.android.navigation.Hilt_Navigation.1
            @Override // androidx.activity.contextaware.OnContextAvailableListener
            public void onContextAvailable(Context context) {
                Hilt_Navigation.this.inject();
            }
        });
    }

    @Override // com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity
    protected void inject() {
        if (this.injected) {
            return;
        }
        this.injected = true;
        ((Navigation_GeneratedInjector) ((GeneratedComponentManagerHolder) UnsafeCasts.unsafeCast(this)).generatedComponent()).injectNavigation((Navigation) UnsafeCasts.unsafeCast(this));
    }
}
