package com.microsoft.intune.mam.client.app.startup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/* JADX INFO: loaded from: classes3.dex */
public interface MAMStartupUIBehavior {
    ClassLoader getClassLoader();

    void onActivityResult(Activity activity, int i, int i2, Intent intent);

    void onAfterActivityCreate(Activity activity, Bundle bundle);

    void onBackPressed(Activity activity);

    void onBeforeActivityCreate(Activity activity, Bundle bundle);
}
