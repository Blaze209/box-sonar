package com.microsoft.identity.common.java.ui.webview.authorization;

import com.microsoft.identity.common.java.providers.RawAuthorizationResult;

/* JADX INFO: loaded from: classes14.dex */
public interface IAuthorizationCompletionCallback {
    void onChallengeResponseReceived(RawAuthorizationResult rawAuthorizationResult);

    void setPKeyAuthStatus(boolean z);
}
