package com.microsoft.identity.common.internal.commands;

import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.java.commands.BaseCommand;
import com.microsoft.identity.common.java.commands.CommandCallback;
import com.microsoft.identity.common.java.commands.parameters.GenerateShrCommandParameters;
import com.microsoft.identity.common.java.controllers.BaseController;
import com.microsoft.identity.common.java.controllers.IControllerFactory;
import com.microsoft.identity.common.java.exception.BaseException;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.exception.UiRequiredException;
import com.microsoft.identity.common.java.result.GenerateShrResult;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public class GenerateShrCommand extends BaseCommand<GenerateShrResult> {
    private static final String TAG = "GenerateShrCommand";

    @Override // com.microsoft.identity.common.java.commands.ICommand
    public boolean isEligibleForEstsTelemetry() {
        return false;
    }

    public static abstract class GenerateShrCommandBuilder<C extends GenerateShrCommand, B extends GenerateShrCommandBuilder<C, B>> extends BaseCommand.BaseCommandBuilder<GenerateShrResult, C, B> {
        @Override // com.microsoft.identity.common.java.commands.BaseCommand.BaseCommandBuilder
        public abstract C build();

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.commands.BaseCommand.BaseCommandBuilder
        public abstract B self();

        @Override // com.microsoft.identity.common.java.commands.BaseCommand.BaseCommandBuilder
        public String toString() {
            return "GenerateShrCommand.GenerateShrCommandBuilder(super=" + super.toString() + ")";
        }
    }

    private static final class GenerateShrCommandBuilderImpl extends GenerateShrCommandBuilder<GenerateShrCommand, GenerateShrCommandBuilderImpl> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.internal.commands.GenerateShrCommand.GenerateShrCommandBuilder, com.microsoft.identity.common.java.commands.BaseCommand.BaseCommandBuilder
        public GenerateShrCommandBuilderImpl self() {
            return this;
        }

        private GenerateShrCommandBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.internal.commands.GenerateShrCommand.GenerateShrCommandBuilder, com.microsoft.identity.common.java.commands.BaseCommand.BaseCommandBuilder
        public GenerateShrCommand build() {
            return new GenerateShrCommand(this);
        }
    }

    protected GenerateShrCommand(GenerateShrCommandBuilder<?, ?> generateShrCommandBuilder) {
        super(generateShrCommandBuilder);
    }

    public static GenerateShrCommandBuilder<?, ?> builder() {
        return new GenerateShrCommandBuilderImpl();
    }

    @Override // com.microsoft.identity.common.java.commands.BaseCommand
    protected boolean canEqual(Object obj) {
        return obj instanceof GenerateShrCommand;
    }

    @Override // com.microsoft.identity.common.java.commands.BaseCommand
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof GenerateShrCommand) && ((GenerateShrCommand) obj).canEqual(this) && super.equals(obj);
    }

    @Override // com.microsoft.identity.common.java.commands.BaseCommand
    public int hashCode() {
        return super.hashCode();
    }

    public GenerateShrCommand(GenerateShrCommandParameters generateShrCommandParameters, IControllerFactory iControllerFactory, CommandCallback<GenerateShrResult, BaseException> commandCallback, String str) {
        super(generateShrCommandParameters, iControllerFactory, commandCallback, str);
    }

    @Override // com.microsoft.identity.common.java.commands.BaseCommand, com.microsoft.identity.common.java.commands.ICommand
    public GenerateShrResult execute() throws Exception {
        String str = TAG + ":execute";
        GenerateShrCommandParameters generateShrCommandParameters = (GenerateShrCommandParameters) getParameters();
        List<BaseController> allControllers = getControllerFactory().getAllControllers();
        GenerateShrResult generateShrResult = null;
        int i = 0;
        while (i < allControllers.size()) {
            BaseController baseController = allControllers.get(i);
            Logger.verbose(str, "Executing with controller: " + baseController.getClass().getSimpleName());
            GenerateShrResult generateShrResultGenerateSignedHttpRequest = baseController.generateSignedHttpRequest(generateShrCommandParameters);
            if (generateShrResultGenerateSignedHttpRequest.getErrorCode() != null) {
                String errorCode = generateShrResultGenerateSignedHttpRequest.getErrorCode();
                String errorMessage = generateShrResultGenerateSignedHttpRequest.getErrorMessage();
                if ("no_account_found".equalsIgnoreCase(errorCode)) {
                    i++;
                    if (allControllers.size() <= i) {
                        throw new UiRequiredException(errorCode, errorMessage);
                    }
                    generateShrResult = generateShrResultGenerateSignedHttpRequest;
                } else {
                    throw new ClientException(errorCode, errorMessage);
                }
            } else {
                com.microsoft.identity.common.java.logging.Logger.verbose(str, "Executing with controller: " + baseController.getClass().getSimpleName() + ": Succeeded");
                return generateShrResultGenerateSignedHttpRequest;
            }
        }
        return generateShrResult;
    }
}
