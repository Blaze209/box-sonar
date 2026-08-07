package com.microsoft.identity.common.java.commands;

import com.microsoft.identity.common.java.commands.parameters.DeviceCodeFlowCommandParameters;
import com.microsoft.identity.common.java.controllers.BaseController;
import com.microsoft.identity.common.java.controllers.ExceptionAdapter;
import com.microsoft.identity.common.java.controllers.IControllerFactory;
import com.microsoft.identity.common.java.exception.BaseException;
import com.microsoft.identity.common.java.exception.ErrorStrings;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.opentelemetry.AttributeName;
import com.microsoft.identity.common.java.opentelemetry.OTelUtility;
import com.microsoft.identity.common.java.opentelemetry.SpanExtension;
import com.microsoft.identity.common.java.opentelemetry.SpanName;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsAuthorizationResponse;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationResult;
import com.microsoft.identity.common.java.result.AcquireTokenResult;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.context.Scope;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes14.dex */
public class DeviceCodeFlowCommand extends TokenCommand {
    private static final String TAG = "DeviceCodeFlowCommand";

    @Override // com.microsoft.identity.common.java.commands.ICommand
    public boolean isEligibleForEstsTelemetry() {
        return true;
    }

    public DeviceCodeFlowCommand(DeviceCodeFlowCommandParameters deviceCodeFlowCommandParameters, IControllerFactory iControllerFactory, DeviceCodeFlowCommandCallback deviceCodeFlowCommandCallback, String str) {
        super(deviceCodeFlowCommandParameters, iControllerFactory, deviceCodeFlowCommandCallback, str);
        if (deviceCodeFlowCommandParameters == null) {
            throw new NullPointerException("parameters is marked non-null but is null");
        }
        if (iControllerFactory == null) {
            throw new NullPointerException("controllerFactory is marked non-null but is null");
        }
        if (deviceCodeFlowCommandCallback == null) {
            throw new NullPointerException("callback is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("publicApiId is marked non-null but is null");
        }
    }

    @Override // com.microsoft.identity.common.java.commands.BaseCommand, com.microsoft.identity.common.java.commands.ICommand
    public AcquireTokenResult execute() throws Exception {
        String str = TAG + ":execute";
        Logger.verbose(str, "Device Code Flow command initiating...");
        Span spanCreateSpanFromParent = OTelUtility.createSpanFromParent(SpanName.AcquireTokenDcf.name(), getParameters().getSpanContext());
        spanCreateSpanFromParent.setAttribute(AttributeName.correlation_id.name(), getParameters().getCorrelationId());
        spanCreateSpanFromParent.setAttribute(AttributeName.application_name.name(), getParameters().getApplicationName());
        spanCreateSpanFromParent.setAttribute(AttributeName.public_api_id.name(), getPublicApiId());
        try {
            Scope scopeMakeCurrentSpan = SpanExtension.makeCurrentSpan(spanCreateSpanFromParent);
            try {
                BaseController defaultController = getControllerFactory().getDefaultController();
                spanCreateSpanFromParent.setAttribute(AttributeName.controller_name.name(), defaultController.getClass().getSimpleName());
                DeviceCodeFlowCommandParameters deviceCodeFlowCommandParameters = (DeviceCodeFlowCommandParameters) getParameters();
                AuthorizationResult authorizationResultDeviceCodeFlowAuthRequest = defaultController.deviceCodeFlowAuthRequest(deviceCodeFlowCommandParameters);
                MicrosoftStsAuthorizationResponse microsoftStsAuthorizationResponse = (MicrosoftStsAuthorizationResponse) authorizationResultDeviceCodeFlowAuthRequest.getAuthorizationResponse();
                Date date = new Date();
                try {
                    date.setTime(date.getTime() + TimeUnit.SECONDS.toMillis(Long.parseLong(microsoftStsAuthorizationResponse.getExpiresIn())));
                } catch (NumberFormatException e) {
                    Logger.error(str, "Failed to parse authorizationResponse.getExpiresIn()", e);
                }
                ((DeviceCodeFlowCommandCallback) getCallback()).onUserCodeReceived(microsoftStsAuthorizationResponse.getVerificationUri(), microsoftStsAuthorizationResponse.getUserCode(), microsoftStsAuthorizationResponse.getMessage(), date);
                AcquireTokenResult acquireTokenResultAcquireDeviceCodeFlowToken = defaultController.acquireDeviceCodeFlowToken(authorizationResultDeviceCodeFlowAuthRequest, deviceCodeFlowCommandParameters);
                Logger.verbose(str, "Device Code Flow command exiting with token...");
                if (acquireTokenResultAcquireDeviceCodeFlowToken == null) {
                    spanCreateSpanFromParent.setStatus(StatusCode.ERROR, "empty result");
                } else if (acquireTokenResultAcquireDeviceCodeFlowToken.getSucceeded().booleanValue()) {
                    spanCreateSpanFromParent.setStatus(StatusCode.OK);
                } else {
                    BaseException baseExceptionExceptionFromAcquireTokenResult = ExceptionAdapter.exceptionFromAcquireTokenResult(acquireTokenResultAcquireDeviceCodeFlowToken, getParameters());
                    if (!baseExceptionExceptionFromAcquireTokenResult.getErrorCode().equals(ErrorStrings.DEVICE_CODE_FLOW_AUTHORIZATION_PENDING_ERROR_CODE)) {
                        if (baseExceptionExceptionFromAcquireTokenResult != null) {
                            spanCreateSpanFromParent.recordException(baseExceptionExceptionFromAcquireTokenResult);
                            spanCreateSpanFromParent.setStatus(StatusCode.ERROR);
                        } else {
                            spanCreateSpanFromParent.setStatus(StatusCode.ERROR, "empty exception");
                        }
                    }
                }
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
