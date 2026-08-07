package com.box.android.services;

import com.google.firebase.messaging.RemoteMessage;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes13.dex */
public class FirebaseMessagingListenerService extends Hilt_FirebaseMessagingListenerService {

    @Inject
    protected FirebaseMessagingListenerServiceHelper helper;

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        this.helper.onMessageReceived(this, remoteMessage);
    }
}
