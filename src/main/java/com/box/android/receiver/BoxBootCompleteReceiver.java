package com.box.android.receiver;

import android.content.Context;
import android.content.Intent;
import com.box.android.domain.identity.IUserContext;
import com.box.android.domain.identity.IUserContextComponent;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.services.ILocalItemService;
import com.box.android.localrepo.LocalAutoContentUploadInformation;
import com.box.android.workers.AutoUploadWorkerDispatcher;
import com.box.androidsdk.content.auth.BoxAuthentication;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.androidsdk.content.utils.SdkUtils;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import com.microsoft.intune.mam.client.content.MAMBroadcastReceiver;
import dagger.hilt.android.EntryPointAccessors;

/* JADX INFO: loaded from: classes12.dex */
public class BoxBootCompleteReceiver extends MAMBroadcastReceiver {
    private static final String TAG = "BoxBootCompleteReceiver";
    protected BoxApiPrivate mBoxApiPrivate;
    protected ILocalItemService mLocalItemService;
    protected IUserContextManager mUserContextManager;

    @Override // com.microsoft.intune.mam.client.content.HookedBroadcastReceiver
    public void onMAMReceive(Context context, Intent intent) {
        try {
            if (this.mUserContextManager == null || this.mBoxApiPrivate == null) {
                inject(context);
            }
            if (initUser(context)) {
                AutoUploadWorkerDispatcher.INSTANCE.setupAutoUpload((LocalAutoContentUploadInformation) this.mUserContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.LOCAL_AUTO_CONTENT_UPLOAD_INFORMATION), this.mLocalItemService);
            }
        } catch (IllegalStateException e) {
            BoxLogUtils.e(TAG, "Error during BoxBootCompleteReceiver onReceive", e);
        }
    }

    private void inject(Context context) {
        BoxBootReceiverEntryPoint boxBootReceiverEntryPoint = (BoxBootReceiverEntryPoint) EntryPointAccessors.fromApplication(context.getApplicationContext(), BoxBootReceiverEntryPoint.class);
        this.mUserContextManager = boxBootReceiverEntryPoint.userContextManager();
        this.mBoxApiPrivate = boxBootReceiverEntryPoint.boxApiPrivate();
        this.mLocalItemService = boxBootReceiverEntryPoint.localItemService();
    }

    private boolean initUser(Context context) {
        String lastAuthenticatedUserId = BoxAuthentication.getInstance().getLastAuthenticatedUserId(context.getApplicationContext());
        if (SdkUtils.isBlank(lastAuthenticatedUserId) || this.mUserContextManager.hasValidUserId() || this.mUserContextManager.isSwitchingOrDestroyingUser()) {
            return false;
        }
        try {
            this.mUserContextManager.createUser(lastAuthenticatedUserId, this.mBoxApiPrivate);
            return true;
        } catch (IUserContextComponent.UserContextComponentCreationException e) {
            BoxLogUtils.e(TAG, e);
            return false;
        }
    }
}
