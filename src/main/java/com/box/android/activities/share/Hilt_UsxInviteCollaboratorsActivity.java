package com.box.android.activities.share;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.internal.GeneratedComponentManagerHolder;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: classes9.dex */
abstract class Hilt_UsxInviteCollaboratorsActivity extends UsxShareBaseActivity {
    private boolean injected = false;

    Hilt_UsxInviteCollaboratorsActivity() {
        _initHiltInternal();
    }

    private void _initHiltInternal() {
        addOnContextAvailableListener(new OnContextAvailableListener() { // from class: com.box.android.activities.share.Hilt_UsxInviteCollaboratorsActivity.1
            @Override // androidx.activity.contextaware.OnContextAvailableListener
            public void onContextAvailable(Context context) {
                Hilt_UsxInviteCollaboratorsActivity.this.inject();
            }
        });
    }

    @Override // com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity
    protected void inject() {
        if (this.injected) {
            return;
        }
        this.injected = true;
        ((UsxInviteCollaboratorsActivity_GeneratedInjector) ((GeneratedComponentManagerHolder) UnsafeCasts.unsafeCast(this)).generatedComponent()).injectUsxInviteCollaboratorsActivity((UsxInviteCollaboratorsActivity) UnsafeCasts.unsafeCast(this));
    }
}
