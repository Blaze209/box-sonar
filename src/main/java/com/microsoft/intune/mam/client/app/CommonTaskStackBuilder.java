package com.microsoft.intune.mam.client.app;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public interface CommonTaskStackBuilder {
    void addNextIntent(Intent intent);

    void addNextIntentWithParentStack(Intent intent);

    void addParentStack(Activity activity);

    void addParentStack(ComponentName componentName);

    void addParentStack(Class<?> cls);

    void attachContext(Context context);

    Intent editIntentAt(int i);

    int getIntentCount();

    Intent[] getIntents();

    PendingIntent getPendingIntent(int i, int i2);

    PendingIntent getPendingIntent(int i, int i2, Bundle bundle);

    @Deprecated
    Iterator<Intent> iterator();

    void startActivities();

    void startActivities(Bundle bundle);
}
