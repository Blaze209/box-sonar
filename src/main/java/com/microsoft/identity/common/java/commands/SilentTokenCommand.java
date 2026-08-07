package com.microsoft.identity.common.java.commands;

import com.microsoft.identity.common.java.commands.parameters.SilentTokenCommandParameters;
import com.microsoft.identity.common.java.controllers.BaseController;
import com.microsoft.identity.common.java.controllers.ExceptionAdapter;
import com.microsoft.identity.common.java.controllers.IControllerFactory;
import com.microsoft.identity.common.java.exception.BaseException;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.exception.UiRequiredException;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.opentelemetry.AttributeName;
import com.microsoft.identity.common.java.opentelemetry.SpanExtension;
import com.microsoft.identity.common.java.result.AcquireTokenResult;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.context.Scope;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public class SilentTokenCommand extends TokenCommand {
    public static final int ACQUIRE_TOKEN_SILENT_DEFAULT_TIMEOUT_MILLISECONDS = 30000;
    private static final String TAG = "SilentTokenCommand";

    @Override // com.microsoft.identity.common.java.commands.BaseCommand, com.microsoft.identity.common.java.commands.ICommand
    public boolean isEligibleForCaching() {
        return true;
    }

    @Override // com.microsoft.identity.common.java.commands.ICommand
    public boolean isEligibleForEstsTelemetry() {
        return true;
    }

    @Override // com.microsoft.identity.common.java.commands.TokenCommand, com.microsoft.identity.common.java.commands.BaseCommand
    protected boolean canEqual(Object obj) {
        return obj instanceof SilentTokenCommand;
    }

    @Override // com.microsoft.identity.common.java.commands.TokenCommand, com.microsoft.identity.common.java.commands.BaseCommand
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof SilentTokenCommand) && ((SilentTokenCommand) obj).canEqual(this) && super.equals(obj);
    }

    @Override // com.microsoft.identity.common.java.commands.TokenCommand, com.microsoft.identity.common.java.commands.BaseCommand
    public int hashCode() {
        return super.hashCode();
    }

    public SilentTokenCommand(SilentTokenCommandParameters silentTokenCommandParameters, IControllerFactory iControllerFactory, CommandCallback commandCallback, String str) {
        super(silentTokenCommandParameters, iControllerFactory, commandCallback, str);
        if (silentTokenCommandParameters == null) {
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
        List<BaseController> allControllers = getControllerFactory().getAllControllers();
        try {
            Scope scopeMakeCurrentSpan = SpanExtension.makeCurrentSpan(spanCurrent);
            AcquireTokenResult acquireTokenResultAcquireTokenSilent = null;
            BaseException baseException = null;
            for (int i = 0; i < allControllers.size(); i++) {
                try {
                    BaseController baseController = allControllers.get(i);
                    spanCurrent.setAttribute(AttributeName.controller_name.name(), baseController.getClass().getSimpleName());
                    try {
                        StringBuilder sb = new StringBuilder();
                        String str = TAG;
                        Logger.verbose(sb.append(str).append(":execute").toString(), "Executing with controller: " + baseController.getClass().getSimpleName());
                        acquireTokenResultAcquireTokenSilent = baseController.acquireTokenSilent((SilentTokenCommandParameters) getParameters());
                        if (acquireTokenResultAcquireTokenSilent.getSucceeded().booleanValue()) {
                            Logger.verbose(str + ":execute", "Executing with controller: " + baseController.getClass().getSimpleName() + ": Succeeded");
                            spanCurrent.setAttribute(AttributeName.is_serviced_from_cache.name(), acquireTokenResultAcquireTokenSilent.getLocalAuthenticationResult().isServicedFromCache());
                            spanCurrent.setStatus(StatusCode.OK);
                            if (scopeMakeCurrentSpan != null) {
                                scopeMakeCurrentSpan.close();
                            }
                            return acquireTokenResultAcquireTokenSilent;
                        }
                        continue;
                    } catch (ClientException | UiRequiredException e) {
                        if (i == 0) {
                            baseException = e;
                        }
                        if (i + 1 < allControllers.size()) {
                            if ("invalid_grant".equals(e.getErrorCode()) || "no_tokens_found".equals(e.getErrorCode())) {
                                continue;
                            } else if (!"no_account_found".equals(e.getErrorCode())) {
                                throw baseException;
                            }
                        } else {
                            throw baseException;
                        }
                    } catch (Throwable th) {
                        if (baseException != null) {
                            throw baseException;
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    if (scopeMakeCurrentSpan != null) {
                        try {
                            scopeMakeCurrentSpan.close();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
            if (acquireTokenResultAcquireTokenSilent == null) {
                spanCurrent.setStatus(StatusCode.ERROR, "empty result");
            } else if (acquireTokenResultAcquireTokenSilent.getSucceeded().booleanValue()) {
                spanCurrent.setStatus(StatusCode.OK);
            } else {
                BaseException baseExceptionExceptionFromAcquireTokenResult = ExceptionAdapter.exceptionFromAcquireTokenResult(acquireTokenResultAcquireTokenSilent, getParameters());
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
            return acquireTokenResultAcquireTokenSilent;
        } catch (Throwable th4) {
            spanCurrent.setStatus(StatusCode.ERROR);
            spanCurrent.recordException(th4);
            throw th4;
        }
    }
}
