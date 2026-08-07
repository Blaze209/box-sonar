package com.box.android.data.controller.impl;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.box.android.domain.controller.BoxResponseIntent;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.androidsdk.content.utils.BoxLogUtils;

/* JADX INFO: loaded from: classes11.dex */
public class CompletionListener implements BoxFutureTask.OnCompletedListener {
    private static final String TAG = "com.box.android.data.controller.impl.CompletionListener";
    private final LocalBroadcastManager mBroadcastManager;

    public CompletionListener(LocalBroadcastManager broadcastManager) {
        this.mBroadcastManager = broadcastManager;
    }

    @Override // com.box.androidsdk.content.BoxFutureTask.OnCompletedListener
    public void onCompleted(BoxResponse response) {
        BoxResponseIntent boxResponseIntent = new BoxResponseIntent(response);
        if (!response.isSuccess()) {
            BoxLogUtils.e(TAG, response.getException());
        }
        this.mBroadcastManager.sendBroadcast(boxResponseIntent);
    }
}
