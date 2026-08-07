package com.box.android.pushnotification;

import android.content.SharedPreferences;
import com.box.androidsdk.content.utils.SdkUtils;
import com.box.boxandroidlibv2private.model.BoxPushNotification;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes12.dex */
public class BoxPushNotifContainer {
    private static final long PERSIST_INTERVAL_IN_MS = 2000;
    public static final String PREF_NOTIFS = BoxPushNotifContainer.class.getName() + "_notifs";
    private AtomicBoolean isStale;
    private SharedPreferences preferences;
    BoxPushNotifObjHolder pushNotifObjectContainer;

    public BoxPushNotifContainer(SharedPreferences sharedPreferences) {
        this.preferences = sharedPreferences;
        initPersistingThread();
        loadPersistedMap();
    }

    private void initPersistingThread() {
        this.isStale = new AtomicBoolean(false);
        new Thread() { // from class: com.box.android.pushnotification.BoxPushNotifContainer.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    if (BoxPushNotifContainer.this.isStale.getAndSet(false)) {
                        BoxPushNotifContainer.this.persistIdObjectsMap();
                    }
                    Thread.sleep(2000L);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void persistIdObjectsMap() {
        this.preferences.edit().putString(PREF_NOTIFS, this.pushNotifObjectContainer.toJson()).apply();
    }

    private void loadPersistedMap() {
        BoxPushNotifObjHolder boxPushNotifObjHolder = new BoxPushNotifObjHolder();
        String string = this.preferences.getString(PREF_NOTIFS, "");
        if (!SdkUtils.isBlank(string)) {
            boxPushNotifObjHolder.createFromJson(string);
        }
        this.pushNotifObjectContainer = boxPushNotifObjHolder;
    }

    public BoxPushNotification get(String str) {
        return this.pushNotifObjectContainer.getValue(str);
    }
}
