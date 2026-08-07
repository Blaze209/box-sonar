package com.microsoft.intune.mam.client.app;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/* JADX INFO: loaded from: classes3.dex */
public interface HookedService extends HookedContextWrapper, MAMIdentityRequirementListener {
    Service asService();

    IBinder onMAMBind(Intent intent);

    @Deprecated
    void onMAMStart(Intent intent, int i);

    int onMAMStartCommand(Intent intent, int i, int i2);

    int onStartCommandReal(Intent intent, int i, int i2);

    void onStartReal(Intent intent, int i);
}
