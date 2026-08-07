package com.microsoft.intune.mam.client.app;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public interface TaskStackBuilderTracker {
    Context getTaskStackBuilderContext(Object obj);

    void registerTaskStackBuilderContext(Object obj, Context context);
}
