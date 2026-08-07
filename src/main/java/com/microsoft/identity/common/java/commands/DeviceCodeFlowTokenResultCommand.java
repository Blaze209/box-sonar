package com.microsoft.identity.common.java.commands;

import com.microsoft.identity.common.java.commands.parameters.DeviceCodeFlowCommandParameters;
import com.microsoft.identity.common.java.controllers.ExceptionAdapter;
import com.microsoft.identity.common.java.controllers.IControllerFactory;
import com.microsoft.identity.common.java.exception.BaseException;
import com.microsoft.identity.common.java.exception.ErrorStrings;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.opentelemetry.AttributeName;
import com.microsoft.identity.common.java.opentelemetry.OTelUtility;
import com.microsoft.identity.common.java.opentelemetry.SpanExtension;
import com.microsoft.identity.common.java.opentelemetry.SpanName;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationResult;
import com.microsoft.identity.common.java.result.AcquireTokenResult;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.context.Scope;

/* JADX INFO: loaded from: classes14.dex */
public class DeviceCodeFlowTokenResultCommand extends TokenCommand {
    private static final String TAG = "DeviceCodeFlowTokenResultCommand";
    private final AuthorizationResult mAuthorizationResult;

    @Override // com.microsoft.identity.common.java.commands.ICommand
    public boolean isEligibleForEstsTelemetry() {
        return true;
    }

    public DeviceCodeFlowTokenResultCommand(DeviceCodeFlowCommandParameters deviceCodeFlowCommandParameters, AuthorizationResult authorizationResult, IControllerFactory iControllerFactory, CommandCallback commandCallback, String str) {
        super(deviceCodeFlowCommandParameters, iControllerFactory, commandCallback, str);
        if (deviceCodeFlowCommandParameters == null) {
            throw new NullPointerException("parameters is marked non-null but is null");
        }
        if (authorizationResult == null) {
            throw new NullPointerException("authorizationResult is marked non-null but is null");
        }
        if (iControllerFactory == null) {
            throw new NullPointerException("controllerFactory is marked non-null but is null");
        }
        if (commandCallback == null) {
            throw new NullPointerException("callback is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("publicApiId is marked non-null but is null");
        }
        this.mAuthorizationResult = authorizationResult;
    }

    @Override // com.microsoft.identity.common.java.commands.BaseCommand, com.microsoft.identity.common.java.commands.ICommand
    public AcquireTokenResult execute() throws Exception {
        String str = TAG + ":execute";
        Logger.verbose(str, "DeviceCodeFlowTokenResultCommand initiating...");
        Span spanCreateSpanFromParent = OTelUtility.createSpanFromParent(SpanName.AcquireTokenDcfFetchToken.name(), getParameters().getSpanContext());
        spanCreateSpanFromParent.setAttribute(AttributeName.application_name.name(), getParameters().getApplicationName());
        spanCreateSpanFromParent.setAttribute(AttributeName.public_api_id.name(), getPublicApiId());
        try {
            Scope scopeMakeCurrentSpan = SpanExtension.makeCurrentSpan(spanCreateSpanFromParent);
            try {
                AcquireTokenResult acquireTokenResultAcquireDeviceCodeFlowToken = getControllerFactory().getDefaultController().acquireDeviceCodeFlowToken(this.mAuthorizationResult, (DeviceCodeFlowCommandParameters) getParameters());
                if (acquireTokenResultAcquireDeviceCodeFlowToken == null) {
                    spanCreateSpanFromParent.setStatus(StatusCode.ERROR, "empty result");
                } else if (acquireTokenResultAcquireDeviceCodeFlowToken.getSucceeded().booleanValue()) {
                    spanCreateSpanFromParent.setStatus(StatusCode.OK);
                } else {
                    BaseException baseExceptionExceptionFromAcquireTokenResult = ExceptionAdapter.exceptionFromAcquireTokenResult(acquireTokenResultAcquireDeviceCodeFlowToken, getParameters());
                    if (baseExceptionExceptionFromAcquireTokenResult != null && !baseExceptionExceptionFromAcquireTokenResult.getErrorCode().equals(ErrorStrings.DEVICE_CODE_FLOW_AUTHORIZATION_PENDING_ERROR_CODE)) {
                        spanCreateSpanFromParent.recordException(baseExceptionExceptionFromAcquireTokenResult);
                        spanCreateSpanFromParent.setStatus(StatusCode.ERROR);
                    } else {
                        spanCreateSpanFromParent.setStatus(StatusCode.ERROR, "empty exception");
                    }
                }
                Logger.verbose(str, "DeviceCodeFlowTokenResultCommand exiting with token...");
                if (scopeMakeCurrentSpan != null) {
                    scopeMakeCurrentSpan.close();
                }
                spanCreateSpanFromParent.end();
                return acquireTokenResultAcquireDeviceCodeFlowToken;
            } catch (Throwable th) {
                if (scopeMakeCurrentSpan != null) {
                    try {
                        scopeMakeCurrentSpan.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            try {
                spanCreateSpanFromParent.setStatus(StatusCode.ERROR);
                spanCreateSpanFromParent.recordException(th3);
                throw th3;
            } catch (Throwable th4) {
                spanCreateSpanFromParent.end();
                throw th4;
            }
        }
    }
}
