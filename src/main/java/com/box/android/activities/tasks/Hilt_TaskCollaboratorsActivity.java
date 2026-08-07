package com.box.android.activities.tasks;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import com.box.android.base.presentation.activities.BoxFragmentActivity;
import dagger.hilt.internal.GeneratedComponentManagerHolder;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: classes9.dex */
abstract class Hilt_TaskCollaboratorsActivity extends BoxFragmentActivity {
    private boolean injected = false;

    Hilt_TaskCollaboratorsActivity() {
        _initHiltInternal();
    }

    private void _initHiltInternal() {
        addOnContextAvailableListener(new OnContextAvailableListener() { // from class: com.box.android.activities.tasks.Hilt_TaskCollaboratorsActivity.1
            @Override // androidx.activity.contextaware.OnContextAvailableListener
            public void onContextAvailable(Context context) {
                Hilt_TaskCollaboratorsActivity.this.inject();
            }
        });
    }

    @Override // com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity
    protected void inject() {
        if (this.injected) {
            return;
        }
        this.injected = true;
        ((TaskCollaboratorsActivity_GeneratedInjector) ((GeneratedComponentManagerHolder) UnsafeCasts.unsafeCast(this)).generatedComponent()).injectTaskCollaboratorsActivity((TaskCollaboratorsActivity) UnsafeCasts.unsafeCast(this));
    }
}
