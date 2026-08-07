package com.microsoft.intune.mam.client.app;

import android.app.Activity;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/* JADX INFO: loaded from: classes3.dex */
public final class MAMTaskStackBuilder {
    private static TaskStackBuilderTracker sTracker = (TaskStackBuilderTracker) MAMComponents.get(TaskStackBuilderTracker.class);
    private final CommonTaskStackBuilder mBuilder;
    private final TaskStackBuilder mOfflineBuilder;

    private MAMTaskStackBuilder(Context context) {
        CommonTaskStackBuilder commonTaskStackBuilder = (CommonTaskStackBuilder) MAMComponents.get(CommonTaskStackBuilder.class);
        this.mBuilder = commonTaskStackBuilder;
        if (commonTaskStackBuilder == null) {
            this.mOfflineBuilder = TaskStackBuilder.create(context);
        } else {
            commonTaskStackBuilder.attachContext(context);
            this.mOfflineBuilder = null;
        }
    }

    public MAMTaskStackBuilder addNextIntent(Intent intent) {
        CommonTaskStackBuilder commonTaskStackBuilder = this.mBuilder;
        if (commonTaskStackBuilder == null) {
            this.mOfflineBuilder.addNextIntent(intent);
            return this;
        }
        commonTaskStackBuilder.addNextIntent(intent);
        return this;
    }

    public MAMTaskStackBuilder addNextIntentWithParentStack(Intent intent) {
        CommonTaskStackBuilder commonTaskStackBuilder = this.mBuilder;
        if (commonTaskStackBuilder == null) {
            this.mOfflineBuilder.addNextIntentWithParentStack(intent);
            return this;
        }
        commonTaskStackBuilder.addNextIntentWithParentStack(intent);
        return this;
    }

    public MAMTaskStackBuilder addParentStack(Activity activity) {
        CommonTaskStackBuilder commonTaskStackBuilder = this.mBuilder;
        if (commonTaskStackBuilder == null) {
            this.mOfflineBuilder.addParentStack(activity);
            return this;
        }
        commonTaskStackBuilder.addParentStack(activity);
        return this;
    }

    public MAMTaskStackBuilder addParentStack(ComponentName componentName) {
        CommonTaskStackBuilder commonTaskStackBuilder = this.mBuilder;
        if (commonTaskStackBuilder == null) {
            this.mOfflineBuilder.addParentStack(componentName);
            return this;
        }
        commonTaskStackBuilder.addParentStack(componentName);
        return this;
    }

    public MAMTaskStackBuilder addParentStack(Class<?> cls) {
        CommonTaskStackBuilder commonTaskStackBuilder = this.mBuilder;
        if (commonTaskStackBuilder == null) {
            this.mOfflineBuilder.addParentStack(cls);
            return this;
        }
        commonTaskStackBuilder.addParentStack(cls);
        return this;
    }

    public static MAMTaskStackBuilder create(Context context) {
        return new MAMTaskStackBuilder(context);
    }

    public Intent editIntentAt(int i) {
        CommonTaskStackBuilder commonTaskStackBuilder = this.mBuilder;
        if (commonTaskStackBuilder == null) {
            return this.mOfflineBuilder.editIntentAt(i);
        }
        return commonTaskStackBuilder.editIntentAt(i);
    }

    public int getIntentCount() {
        CommonTaskStackBuilder commonTaskStackBuilder = this.mBuilder;
        if (commonTaskStackBuilder == null) {
            return this.mOfflineBuilder.getIntentCount();
        }
        return commonTaskStackBuilder.getIntentCount();
    }

    public Intent[] getIntents() {
        CommonTaskStackBuilder commonTaskStackBuilder = this.mBuilder;
        if (commonTaskStackBuilder == null) {
            return this.mOfflineBuilder.getIntents();
        }
        return commonTaskStackBuilder.getIntents();
    }

    public PendingIntent getPendingIntent(int i, int i2) {
        CommonTaskStackBuilder commonTaskStackBuilder = this.mBuilder;
        if (commonTaskStackBuilder == null) {
            return this.mOfflineBuilder.getPendingIntent(i, i2);
        }
        return commonTaskStackBuilder.getPendingIntent(i, i2);
    }

    public PendingIntent getPendingIntent(int i, int i2, Bundle bundle) {
        CommonTaskStackBuilder commonTaskStackBuilder = this.mBuilder;
        if (commonTaskStackBuilder == null) {
            return this.mOfflineBuilder.getPendingIntent(i, i2, bundle);
        }
        return commonTaskStackBuilder.getPendingIntent(i, i2, bundle);
    }

    public void startActivities(Bundle bundle) {
        CommonTaskStackBuilder commonTaskStackBuilder = this.mBuilder;
        if (commonTaskStackBuilder == null) {
            this.mOfflineBuilder.startActivities(bundle);
        } else {
            commonTaskStackBuilder.startActivities(bundle);
        }
    }

    public void startActivities() {
        CommonTaskStackBuilder commonTaskStackBuilder = this.mBuilder;
        if (commonTaskStackBuilder == null) {
            this.mOfflineBuilder.startActivities();
        } else {
            commonTaskStackBuilder.startActivities();
        }
    }

    public static TaskStackBuilder createTaskStackBuilder(Context context) {
        TaskStackBuilder taskStackBuilderCreate = TaskStackBuilder.create(context);
        TaskStackBuilderTracker taskStackBuilderTracker = sTracker;
        if (taskStackBuilderTracker != null) {
            taskStackBuilderTracker.registerTaskStackBuilderContext(taskStackBuilderCreate, context);
        }
        return taskStackBuilderCreate;
    }

    public static PendingIntent getPendingIntent(TaskStackBuilder taskStackBuilder, int i, int i2) {
        return getPendingIntent(taskStackBuilder, i, i2, null);
    }

    public static PendingIntent getPendingIntent(TaskStackBuilder taskStackBuilder, int i, int i2, Bundle bundle) {
        TaskStackBuilderTracker taskStackBuilderTracker = sTracker;
        if (taskStackBuilderTracker == null) {
            return taskStackBuilder.getPendingIntent(i, i2, bundle);
        }
        Context taskStackBuilderContext = taskStackBuilderTracker.getTaskStackBuilderContext(taskStackBuilder);
        if (taskStackBuilderContext == null) {
            return taskStackBuilder.getPendingIntent(i, i2, bundle);
        }
        return MAMPendingIntent.getActivities(taskStackBuilderContext, i, taskStackBuilder.getIntents(), i2, bundle);
    }
}
