package com.microsoft.identity.common.internal.commands;

import com.microsoft.identity.common.java.commands.CommandCallback;
import com.microsoft.identity.common.java.exception.BaseException;
import com.microsoft.identity.common.java.result.AcquireTokenResult;
import com.microsoft.identity.common.logging.Logger;

/* JADX INFO: loaded from: classes14.dex */
public class RefreshOnCallback implements CommandCallback<AcquireTokenResult, BaseException> {
    private static final String TAG = "RefreshOnCallback";

    @Override // com.microsoft.identity.common.java.commands.CommandCallback
    public void onCancel() {
    }

    @Override // com.microsoft.identity.common.java.util.TaskCompletedCallback
    public void onTaskCompleted(AcquireTokenResult acquireTokenResult) {
        Logger.verbose(TAG + ":onTaskCompleted", "Task succeeded: " + acquireTokenResult.getSucceeded() + " . CorrelationId: " + acquireTokenResult.getLocalAuthenticationResult().getCorrelationId());
    }

    @Override // com.microsoft.identity.common.java.util.TaskCompletedCallbackWithError
    public void onError(BaseException baseException) {
        Logger.verbose(TAG + ":onError", baseException.getMessage());
    }
}
