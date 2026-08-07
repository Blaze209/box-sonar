package com.microsoft.identity.common.java.commands;

import com.microsoft.identity.common.java.commands.parameters.InteractiveTokenCommandParameters;
import com.microsoft.identity.common.java.controllers.BaseController;
import com.microsoft.identity.common.java.controllers.ExceptionAdapter;
import com.microsoft.identity.common.java.controllers.IControllerFactory;
import com.microsoft.identity.common.java.exception.BaseException;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.opentelemetry.AttributeName;
import com.microsoft.identity.common.java.opentelemetry.SpanExtension;
import com.microsoft.identity.common.java.result.AcquireTokenResult;
import com.microsoft.identity.common.java.util.ported.PropertyBag;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.context.Scope;

/* JADX INFO: loaded from: classes14.dex */
public class InteractiveTokenCommand extends TokenCommand {
    private static final String TAG = "InteractiveTokenCommand";
    private BaseController mController;

    @Override // com.microsoft.identity.common.java.commands.ICommand
    public boolean isEligibleForEstsTelemetry() {
        return true;
    }

    @Override // com.microsoft.identity.common.java.commands.TokenCommand, com.microsoft.identity.common.java.commands.BaseCommand
    protected boolean canEqual(Object obj) {
        return obj instanceof InteractiveTokenCommand;
    }

    @Override // com.microsoft.identity.common.java.commands.TokenCommand, com.microsoft.identity.common.java.commands.BaseCommand
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InteractiveTokenCommand)) {
            return false;
        }
        InteractiveTokenCommand interactiveTokenCommand = (InteractiveTokenCommand) obj;
        if (!interactiveTokenCommand.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        BaseController baseController = this.mController;
        BaseController baseController2 = interactiveTokenCommand.mController;
        return baseController != null ? baseController.equals(baseController2) : baseController2 == null;
    }

    @Override // com.microsoft.identity.common.java.commands.TokenCommand, com.microsoft.identity.common.java.commands.BaseCommand
    public int hashCode() {
        int iHashCode = super.hashCode();
        BaseController baseController = this.mController;
        return (iHashCode * 59) + (baseController == null ? 43 : baseController.hashCode());
    }

    public InteractiveTokenCommand(InteractiveTokenCommandParameters interactiveTokenCommandParameters, IControllerFactory iControllerFactory, CommandCallback commandCallback, String str) {
        super(interactiveTokenCommandParameters, iControllerFactory, commandCallback, str);
        if (interactiveTokenCommandParameters == null) {
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
    public AcquireTokenResult execute() throws Exception {
        Span spanCurrent = SpanExtension.current();
        spanCurrent.setAttribute(AttributeName.application_name.name(), getParameters().getApplicationName());
        spanCurrent.setAttribute(AttributeName.public_api_id.name(), getPublicApiId());
        try {
            Scope scopeMakeCurrentSpan = SpanExtension.makeCurrentSpan(spanCurrent);
            try {
                if (getParameters() instanceof InteractiveTokenCommandParameters) {
                    Logger.info(TAG + ":execute", "Executing interactive token command...");
                    this.mController = getControllerFactory().getDefaultController();
                    spanCurrent.setAttribute(AttributeName.controller_name.name(), this.mController.getClass().getSimpleName());
                    AcquireTokenResult acquireTokenResultAcquireToken = this.mController.acquireToken((InteractiveTokenCommandParameters) getParameters());
                    if (acquireTokenResultAcquireToken == null) {
                        spanCurrent.setStatus(StatusCode.ERROR, "empty result");
                    } else if (acquireTokenResultAcquireToken.getSucceeded().booleanValue()) {
                        spanCurrent.setStatus(StatusCode.OK);
                    } else {
                        BaseException baseExceptionExceptionFromAcquireTokenResult = ExceptionAdapter.exceptionFromAcquireTokenResult(acquireTokenResultAcquireToken, getParameters());
                        if (baseExceptionExceptionFromAcquireTokenResult != null) {
                            spanCurrent.recordException(baseExceptionExceptionFromAcquireTokenResult);
                            spanCurrent.setStatus(StatusCode.ERROR);
                        } else {
                            spanCurrent.setStatus(StatusCode.ERROR, "empty exception");
                        }
                    }
                    if (scopeMakeCurrentSpan != null) {
                        scopeMakeCurrentSpan.close();
                    }
                    return acquireTokenResultAcquireToken;
                }
                throw new IllegalArgumentException("Invalid operation parameters");
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
            spanCurrent.setStatus(StatusCode.ERROR);
            spanCurrent.recordException(th3);
            throw th3;
        }
    }

    public void onFinishAuthorizationSession(int i, int i2, PropertyBag propertyBag) {
        if (propertyBag == null) {
            throw new NullPointerException("data is marked non-null but is null");
        }
        this.mController.onFinishAuthorizationSession(i, i2, propertyBag);
    }
}
