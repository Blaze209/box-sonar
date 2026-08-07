package com.box.android.browse.activities;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.lifecycle.ViewModelProvider;
import com.box.android.base.presentation.activities.BoxFragmentActivity;
import dagger.hilt.internal.GeneratedComponentManagerHolder;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: classes10.dex */
public abstract class Hilt_UploadToFolderActivity extends BoxFragmentActivity {
    private boolean injected = false;

    @Override // com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, androidx.activity.ComponentActivity, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public /* bridge */ /* synthetic */ ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return super.getDefaultViewModelProviderFactory();
    }

    Hilt_UploadToFolderActivity() {
        _initHiltInternal();
    }

    private void _initHiltInternal() {
        addOnContextAvailableListener(new OnContextAvailableListener() { // from class: com.box.android.browse.activities.Hilt_UploadToFolderActivity.1
            @Override // androidx.activity.contextaware.OnContextAvailableListener
            public void onContextAvailable(Context context) {
                Hilt_UploadToFolderActivity.this.inject();
            }
        });
    }

    @Override // com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity
    protected void inject() {
        if (this.injected) {
            return;
        }
        this.injected = true;
        ((UploadToFolderActivity_GeneratedInjector) ((GeneratedComponentManagerHolder) UnsafeCasts.unsafeCast(this)).generatedComponent()).injectUploadToFolderActivity((UploadToFolderActivity) UnsafeCasts.unsafeCast(this));
    }
}
