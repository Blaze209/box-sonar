package com.microsoft.identity.common.internal.commands;

import com.microsoft.identity.common.java.commands.BaseCommand;
import com.microsoft.identity.common.java.commands.CommandCallback;
import com.microsoft.identity.common.java.commands.parameters.RemoveAccountCommandParameters;
import com.microsoft.identity.common.java.controllers.BaseController;
import com.microsoft.identity.common.java.controllers.IControllerFactory;
import com.microsoft.identity.common.logging.Logger;

/* JADX INFO: loaded from: classes14.dex */
public class RemoveCurrentAccountCommand extends BaseCommand<Boolean> {
    private static final String TAG = "RemoveCurrentAccountCommand";

    @Override // com.microsoft.identity.common.java.commands.ICommand
    public boolean isEligibleForEstsTelemetry() {
        return true;
    }

    @Override // com.microsoft.identity.common.java.commands.BaseCommand
    protected boolean canEqual(Object obj) {
        return obj instanceof RemoveCurrentAccountCommand;
    }

    @Override // com.microsoft.identity.common.java.commands.BaseCommand
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof RemoveCurrentAccountCommand) && ((RemoveCurrentAccountCommand) obj).canEqual(this) && super.equals(obj);
    }

    @Override // com.microsoft.identity.common.java.commands.BaseCommand
    public int hashCode() {
        return super.hashCode();
    }

    public RemoveCurrentAccountCommand(RemoveAccountCommandParameters removeAccountCommandParameters, IControllerFactory iControllerFactory, CommandCallback commandCallback, String str) {
        super(removeAccountCommandParameters, iControllerFactory, commandCallback, str);
    }

    @Override // com.microsoft.identity.common.java.commands.BaseCommand, com.microsoft.identity.common.java.commands.ICommand
    public Boolean execute() throws Exception {
        String str = TAG + ":execute";
        for (BaseController baseController : getControllerFactory().getAllControllers()) {
            Logger.verbose(str, "Executing with controller: " + baseController.getClass().getSimpleName());
            if (baseController.removeCurrentAccount((RemoveAccountCommandParameters) getParameters())) {
                return true;
            }
        }
        return false;
    }
}
