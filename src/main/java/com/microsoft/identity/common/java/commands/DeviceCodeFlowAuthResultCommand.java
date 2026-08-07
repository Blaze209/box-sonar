package com.microsoft.identity.common.java.commands;

import com.microsoft.identity.common.java.authorities.Authority;
import com.microsoft.identity.common.java.commands.parameters.DeviceCodeFlowCommandParameters;
import com.microsoft.identity.common.java.controllers.BaseController;
import com.microsoft.identity.common.java.controllers.ExceptionAdapter;
import com.microsoft.identity.common.java.controllers.IControllerFactory;
import com.microsoft.identity.common.java.exception.BaseException;
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
public class DeviceCodeFlowAuthResultCommand extends BaseCommand<AuthorizationResult> {
    public static final String DEVICE_ID_CLAIM = "deviceid";
    private static final String TAG = "DeviceCodeFlowAuthResultCommand";

    @Override // com.microsoft.identity.common.java.commands.ICommand
    public boolean isEligibleForEstsTelemetry() {
        return true;
    }

    public DeviceCodeFlowAuthResultCommand(DeviceCodeFlowCommandParameters deviceCodeFlowCommandParameters, IControllerFactory iControllerFactory, CommandCallback commandCallback, String str) {
        super(deviceCodeFlowCommandParameters, iControllerFactory, commandCallback, str);
        if (deviceCodeFlowCommandParameters == null) {
            throw new NullPointerException("parameters is marked non-null but is null");
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
    }

    @Override // com.microsoft.identity.common.java.commands.BaseCommand, com.microsoft.identity.common.java.commands.ICommand
    public AuthorizationResult execute() throws Exception {
        Logger.verbose(TAG + ":execute", "Device Code Flow command initiating...");
        Span spanCreateSpanFromParent = OTelUtility.createSpanFromParent(SpanName.AcquireTokenDcfAuthRequest.name(), getParameters().getSpanContext());
        spanCreateSpanFromParent.setAttribute(AttributeName.application_name.name(), getParameters().getApplicationName());
        spanCreateSpanFromParent.setAttribute(AttributeName.public_api_id.name(), getPublicApiId());
        try {
            Scope scopeMakeCurrentSpan = SpanExtension.makeCurrentSpan(spanCreateSpanFromParent);
            try {
                BaseController defaultController = getControllerFactory().getDefaultController();
                spanCreateSpanFromParent.setAttribute(AttributeName.controller_name.name(), defaultController.getClass().getSimpleName());
                DeviceCodeFlowCommandParameters deviceCodeFlowCommandParameters = (DeviceCodeFlowCommandParameters) getParameters();
                spanCreateSpanFromParent.setAttribute(AttributeName.is_device_id_claims_requested.name(), deviceCodeFlowCommandParameters.getClaimsRequestJson() != null && deviceCodeFlowCommandParameters.getClaimsRequestJson().contains(DEVICE_ID_CLAIM));
                Authority.KnownAuthorityResult knownAuthorityResult = Authority.getKnownAuthorityResult(deviceCodeFlowCommandParameters.getAuthority());
                if (!knownAuthorityResult.getKnown()) {
                    throw knownAuthorityResult.getClientException();
                }
                AuthorizationResult authorizationResultDeviceCodeFlowAuthRequest = defaultController.deviceCodeFlowAuthRequest(deviceCodeFlowCommandParameters);
                if (authorizationResultDeviceCodeFlowAuthRequest == null) {
                    spanCreateSpanFromParent.setStatus(StatusCode.ERROR, "empty result");
                } else if (authorizationResultDeviceCodeFlowAuthRequest.getSuccess()) {
                    spanCreateSpanFromParent.setStatus(StatusCode.OK);
                } else {
                    AcquireTokenResult acquireTokenResult = new AcquireTokenResult();
                    acquireTokenResult.setAuthorizationResult(authorizationResultDeviceCodeFlowAuthRequest);
                    BaseException baseExceptionExceptionFromAcquireTokenResult = ExceptionAdapter.exceptionFromAcquireTokenResult(acquireTokenResult, getParameters());
                    if (baseExceptionExceptionFromAcquireTokenResult != null) {
                        spanCreateSpanFromParent.recordException(baseExceptionExceptionFromAcquireTokenResult);
                        spanCreateSpanFromParent.setStatus(StatusCode.ERROR);
                    } else {
                        spanCreateSpanFromParent.setStatus(StatusCode.ERROR, "empty exception");
                    }
                }
                if (scopeMakeCurrentSpan != null) {
                    scopeMakeCurrentSpan.close();
                }
                spanCreateSpanFromParent.end();
                return authorizationResultDeviceCodeFlowAuthRequest;
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
