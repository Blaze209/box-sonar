package com.box.android.domain.localrepo;

import android.content.Intent;
import com.box.android.domain.identity.IUserContextComponent;
import com.box.androidsdk.content.models.BoxMDMData;

/* JADX INFO: loaded from: classes11.dex */
public interface IEmmPreferences extends IUserContextComponent, ILocalSharedPreferences {
    boolean checkEmmApplicationInstalled(String str);

    String getIdentifyingSha256(BoxMDMData boxMDMData);

    String getPackageName();

    boolean isAgentRemoved();

    boolean isDeviceSuspended();

    boolean isEmmApplicationInstalled();

    boolean isSignatureValid(String str, String str2);

    @Override // com.box.android.domain.identity.IUserContextComponent
    void onHardDestroy();

    void setAgentRemoved(boolean z);

    void setDeviceSuspended(boolean z);

    boolean setEmmApplication(String str, String str2);

    boolean verifyAgent(Intent intent);
}
