package com.microsoft.identity.common.nativeauth.internal.commands;

import com.microsoft.identity.common.java.logging.LogSession;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInSubmitCodeCommandParameters;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignInSubmitCodeCommandResult;
import com.microsoft.identity.common.nativeauth.internal.controllers.NativeAuthMsalController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SignInSubmitCodeCommand.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/microsoft/identity/common/nativeauth/internal/commands/SignInSubmitCodeCommand;", "Lcom/microsoft/identity/common/nativeauth/internal/commands/BaseNativeAuthCommand;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInSubmitCodeCommandResult;", "parameters", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignInSubmitCodeCommandParameters;", "controller", "Lcom/microsoft/identity/common/nativeauth/internal/controllers/NativeAuthMsalController;", "publicApiId", "", "(Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignInSubmitCodeCommandParameters;Lcom/microsoft/identity/common/nativeauth/internal/controllers/NativeAuthMsalController;Ljava/lang/String;)V", "execute", "Companion", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SignInSubmitCodeCommand extends BaseNativeAuthCommand<SignInSubmitCodeCommandResult> {
    private static final String TAG = "SignInSubmitCodeCommand";
    private final NativeAuthMsalController controller;
    private final SignInSubmitCodeCommandParameters parameters;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SignInSubmitCodeCommand(SignInSubmitCodeCommandParameters parameters, NativeAuthMsalController controller, String publicApiId) {
        super(parameters, controller, publicApiId);
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.checkNotNullParameter(controller, "controller");
        Intrinsics.checkNotNullParameter(publicApiId, "publicApiId");
        this.parameters = parameters;
        this.controller = controller;
    }

    @Override // com.microsoft.identity.common.java.commands.BaseCommand, com.microsoft.identity.common.java.commands.ICommand
    public SignInSubmitCodeCommandResult execute() throws Exception {
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        companion.logMethodCall(TAG2, this.parameters.getCorrelationId(), TAG2 + ".execute");
        SignInSubmitCodeCommandResult signInSubmitCodeCommandResultSignInSubmitCode = this.controller.signInSubmitCode(this.parameters);
        Logger.infoWithObject(TAG2, this.parameters.getCorrelationId(), "Returning result: ", signInSubmitCodeCommandResultSignInSubmitCode);
        return signInSubmitCodeCommandResultSignInSubmitCode;
    }
}
