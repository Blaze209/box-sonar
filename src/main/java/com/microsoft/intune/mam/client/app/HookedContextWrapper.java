package com.microsoft.intune.mam.client.app;

import android.content.Context;
import com.microsoft.intune.mam.client.identity.MAMIdentity;

/* JADX INFO: loaded from: classes3.dex */
public interface HookedContextWrapper {
    void attachBaseContextReal(Context context);

    MAMIdentity getMAMOfflineIdentity();

    void setMAMOfflineIdentity(MAMIdentity mAMIdentity);
}
