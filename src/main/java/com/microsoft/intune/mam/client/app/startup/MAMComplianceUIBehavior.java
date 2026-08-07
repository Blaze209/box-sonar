package com.microsoft.intune.mam.client.app.startup;

import android.app.Activity;
import android.os.Bundle;

/* JADX INFO: loaded from: classes3.dex */
public interface MAMComplianceUIBehavior {
    ClassLoader getClassLoader();

    void onAfterActivityCreate(Activity activity, Bundle bundle, Bundle bundle2);

    void onBackPressed(Activity activity);
}
