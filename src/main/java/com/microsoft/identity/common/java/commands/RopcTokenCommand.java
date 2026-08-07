package com.microsoft.identity.common.java.commands;

import com.microsoft.identity.common.java.commands.parameters.RopcTokenCommandParameters;
import com.microsoft.identity.common.java.controllers.IControllerFactory;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.result.AcquireTokenResult;

/* JADX INFO: loaded from: classes14.dex */
public class RopcTokenCommand extends TokenCommand {
    private static final String TAG = "RopcTokenCommand";

    @Override // com.microsoft.identity.common.java.commands.BaseCommand, com.microsoft.identity.common.java.commands.ICommand
    public boolean isEligibleForCaching() {
        return true;
    }

    @Override // com.microsoft.identity.common.java.commands.ICommand
    public boolean isEligibleForEstsTelemetry() {
        return false;
    }

    public RopcTokenCommand(RopcTokenCommandParameters ropcTokenCommandParameters, IControllerFactory iControllerFactory, CommandCallback commandCallback, String str) {
        super(ropcTokenCommandParameters, iControllerFactory, commandCallback, str);
        if (ropcTokenCommandParameters == null) {
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
        if (getParameters() instanceof RopcTokenCommandParameters) {
            Logger.info(TAG + ":execute", "Executing ROPC token command...");
            return getControllerFactory().getDefaultController().acquireTokenWithPassword((RopcTokenCommandParameters) getParameters());
        }
        throw new IllegalArgumentException("Invalid operation parameters");
    }
}
