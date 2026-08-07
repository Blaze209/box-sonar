package com.box.android.activities.filepicker;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import com.box.android.activities.MainPhone;
import dagger.hilt.internal.GeneratedComponentManagerHolder;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: classes9.dex */
abstract class Hilt_MainFilePicker extends MainPhone {
    private boolean injected = false;

    Hilt_MainFilePicker() {
        _initHiltInternal();
    }

    private void _initHiltInternal() {
        addOnContextAvailableListener(new OnContextAvailableListener() { // from class: com.box.android.activities.filepicker.Hilt_MainFilePicker.1
            @Override // androidx.activity.contextaware.OnContextAvailableListener
            public void onContextAvailable(Context context) {
                Hilt_MainFilePicker.this.inject();
            }
        });
    }

    @Override // com.box.android.activities.Hilt_MainPhone, com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity
    protected void inject() {
        if (this.injected) {
            return;
        }
        this.injected = true;
        ((MainFilePicker_GeneratedInjector) ((GeneratedComponentManagerHolder) UnsafeCasts.unsafeCast(this)).generatedComponent()).injectMainFilePicker((MainFilePicker) UnsafeCasts.unsafeCast(this));
    }
}
