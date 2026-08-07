package com.microsoft.identity.common.internal.ui.webview.certbasedauth;

import android.webkit.ClientCertRequest;
import com.microsoft.identity.common.internal.ui.webview.challengehandlers.IChallengeHandler;
import com.microsoft.identity.common.java.exception.BaseException;
import com.microsoft.identity.common.java.opentelemetry.ICertBasedAuthTelemetryHelper;
import com.microsoft.identity.common.java.providers.RawAuthorizationResult;

/* JADX INFO: loaded from: classes14.dex */
public abstract class AbstractCertBasedAuthChallengeHandler implements IChallengeHandler<ClientCertRequest, Void> {
    protected boolean mIsCertBasedAuthProceeding;
    protected ICertBasedAuthTelemetryHelper mTelemetryHelper;

    public abstract void cleanUp();

    public void emitTelemetryForCertBasedAuthResults(RawAuthorizationResult rawAuthorizationResult) {
        if (this.mIsCertBasedAuthProceeding) {
            RawAuthorizationResult.ResultCode resultCode = rawAuthorizationResult.getResultCode();
            if (resultCode == RawAuthorizationResult.ResultCode.NON_OAUTH_ERROR || resultCode == RawAuthorizationResult.ResultCode.SDK_CANCELLED || resultCode == RawAuthorizationResult.ResultCode.CANCELLED) {
                BaseException exception = rawAuthorizationResult.getException();
                if (exception != null) {
                    this.mTelemetryHelper.setResultFailure(exception);
                    return;
                } else {
                    this.mTelemetryHelper.setResultFailure(resultCode.toString());
                    return;
                }
            }
            this.mTelemetryHelper.setResultSuccess();
        }
    }
}
