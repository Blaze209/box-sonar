package com.microsoft.identity.common.internal.platform;

import android.content.Context;
import android.content.Intent;
import com.microsoft.identity.common.java.util.IBroadcaster;
import com.microsoft.identity.common.java.util.ported.PropertyBag;
import com.microsoft.identity.common.logging.Logger;

/* JADX INFO: loaded from: classes14.dex */
public class AndroidBroadcaster implements IBroadcaster {
    private static final String TAG = "AndroidBroadcaster";
    private final Context mContext;

    public AndroidBroadcaster(Context context) {
        if (context == null) {
            throw new NullPointerException("mContext is marked non-null but is null");
        }
        this.mContext = context;
    }

    @Override // com.microsoft.identity.common.java.util.IBroadcaster
    public void sendBroadcast(String str, PropertyBag propertyBag) {
        if (str == null) {
            throw new NullPointerException("broadcastId is marked non-null but is null");
        }
        Logger.info(TAG + ":sendBroadcast", "Sending broadcast with broadcastId: " + str);
        Intent intent = new Intent();
        intent.setAction(str);
        if (propertyBag != null) {
            for (String str2 : propertyBag.keySet()) {
                intent.putExtra(str2, (String) propertyBag.get(str2));
            }
        }
        this.mContext.sendBroadcast(intent);
    }
}
