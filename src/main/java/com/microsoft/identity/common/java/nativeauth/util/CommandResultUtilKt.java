package com.microsoft.identity.common.java.nativeauth.util;

import com.microsoft.identity.common.java.commands.ICommandResult;
import com.microsoft.identity.common.java.controllers.CommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: CommandResultUtil.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a$\u0010\u0002\u001a\u0002H\u0003\"\n\b\u0000\u0010\u0003\u0018\u0001*\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0086\b¢\u0006\u0002\u0010\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"UNSUCCESSFUL_COMMAND_ERROR", "", "checkAndWrapCommandResultType", "ExpectedType", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/INativeAuthCommandResult;", "Lcom/microsoft/identity/common/java/controllers/CommandResult;", "", "(Lcom/microsoft/identity/common/java/controllers/CommandResult;)Lcom/microsoft/identity/common/java/nativeauth/controllers/results/INativeAuthCommandResult;", "common4j"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CommandResultUtilKt {
    public static final String UNSUCCESSFUL_COMMAND_ERROR = "unsuccessful_command";

    public static final /* synthetic */ <ExpectedType extends INativeAuthCommandResult> ExpectedType checkAndWrapCommandResultType(CommandResult<Object> commandResult) {
        INativeAuthCommandResult.APIError aPIError;
        Exception exc;
        String message;
        Intrinsics.checkNotNullParameter(commandResult, "<this>");
        if (commandResult.getStatus() != ICommandResult.ResultStatus.COMPLETED) {
            if (!(commandResult.getResult() instanceof Exception)) {
                exc = null;
                message = "";
            } else {
                Object result = commandResult.getResult();
                Intrinsics.checkNotNull(result, "null cannot be cast to non-null type java.lang.Exception{ kotlin.TypeAliasesKt.Exception }");
                exc = (Exception) result;
                message = exc.getMessage();
            }
            String correlationId = commandResult.getCorrelationId();
            Intrinsics.checkNotNullExpressionValue(correlationId, "correlationId");
            INativeAuthCommandResult.APIError aPIError2 = new INativeAuthCommandResult.APIError(UNSUCCESSFUL_COMMAND_ERROR, message, null, correlationId, null, exc, 20, null);
            Intrinsics.reifiedOperationMarker(1, "ExpectedType");
            return aPIError2;
        }
        Object result2 = commandResult.getResult();
        if (result2 instanceof Exception) {
            String correlationId2 = commandResult.getCorrelationId();
            Intrinsics.checkNotNullExpressionValue(correlationId2, "this.correlationId");
            INativeAuthCommandResult.APIError aPIError3 = new INativeAuthCommandResult.APIError(UNSUCCESSFUL_COMMAND_ERROR, "Type casting error: result of " + commandResult + " is of type Exception, even though the command was marked as COMPLETED", null, correlationId2, null, null, 52, null);
            Intrinsics.reifiedOperationMarker(1, "ExpectedType");
            aPIError = aPIError3;
        } else {
            try {
                Intrinsics.reifiedOperationMarker(1, "ExpectedType");
                INativeAuthCommandResult iNativeAuthCommandResult = (INativeAuthCommandResult) result2;
                aPIError = (ExpectedType) iNativeAuthCommandResult;
            } catch (ClassCastException unused) {
                StringBuilder sbAppend = new StringBuilder("Type casting error: result of ").append(commandResult).append(" is not of type ");
                Intrinsics.reifiedOperationMarker(4, "ExpectedType");
                String string = sbAppend.append(Reflection.getOrCreateKotlinClass(INativeAuthCommandResult.class)).append(", but of type ").append(Reflection.getOrCreateKotlinClass(result2.getClass())).append(", even though the command was marked as COMPLETED").toString();
                String correlationId3 = commandResult.getCorrelationId();
                Intrinsics.checkNotNullExpressionValue(correlationId3, "this.correlationId");
                INativeAuthCommandResult.APIError aPIError4 = new INativeAuthCommandResult.APIError(UNSUCCESSFUL_COMMAND_ERROR, string, null, correlationId3, null, null, 52, null);
                Intrinsics.reifiedOperationMarker(1, "ExpectedType");
                aPIError = aPIError4;
            }
        }
        ExpectedType expectedtype = aPIError;
        return aPIError;
    }
}
