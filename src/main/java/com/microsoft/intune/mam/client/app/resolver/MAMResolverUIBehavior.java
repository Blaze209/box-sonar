package com.microsoft.intune.mam.client.app.resolver;

import android.app.Activity;
import android.os.Bundle;

/* JADX INFO: loaded from: classes3.dex */
public interface MAMResolverUIBehavior {
    ClassLoader getClassLoader();

    void onAfterActivityCreate(Activity activity, Bundle bundle);

    void onAfterActivityResume(Activity activity);

    void onBeforeActivityCreate(Activity activity, Bundle bundle);

    void onBeforeActivityResume(Activity activity);
}
