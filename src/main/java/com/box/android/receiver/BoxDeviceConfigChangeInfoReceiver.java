package com.box.android.receiver;

import android.content.Context;
import android.content.Intent;
import com.box.android.domain.identity.IUserContextManager;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes12.dex */
public class BoxDeviceConfigChangeInfoReceiver extends Hilt_BoxDeviceConfigChangeInfoReceiver {

    @Inject
    BoxApiPrivate mPrivateApi;

    @Inject
    IUserContextManager mUserContextManager;

    @Override // com.box.android.receiver.Hilt_BoxDeviceConfigChangeInfoReceiver, com.microsoft.intune.mam.client.content.HookedBroadcastReceiver
    public void onMAMReceive(Context context, Intent intent) {
        IUserContextManager iUserContextManager;
        super.onMAMReceive(context, intent);
        if (!"android.intent.action.LOCALE_CHANGED".equals(intent.getAction()) || (iUserContextManager = this.mUserContextManager) == null) {
            return;
        }
        iUserContextManager.updatePushNotificationsLocale(this.mPrivateApi);
    }
}
