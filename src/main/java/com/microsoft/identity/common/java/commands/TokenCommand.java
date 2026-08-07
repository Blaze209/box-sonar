package com.microsoft.identity.common.java.commands;

import com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters;
import com.microsoft.identity.common.java.controllers.IControllerFactory;
import com.microsoft.identity.common.java.result.AcquireTokenResult;

/* JADX INFO: loaded from: classes14.dex */
public abstract class TokenCommand extends BaseCommand<AcquireTokenResult> {
    @Override // com.microsoft.identity.common.java.commands.BaseCommand, com.microsoft.identity.common.java.commands.ICommand
    public boolean willReachTokenEndpoint() {
        return true;
    }

    @Override // com.microsoft.identity.common.java.commands.BaseCommand
    protected boolean canEqual(Object obj) {
        return obj instanceof TokenCommand;
    }

    @Override // com.microsoft.identity.common.java.commands.BaseCommand
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof TokenCommand) && ((TokenCommand) obj).canEqual(this) && super.equals(obj);
    }

    @Override // com.microsoft.identity.common.java.commands.BaseCommand
    public int hashCode() {
        return super.hashCode();
    }

    public TokenCommand(TokenCommandParameters tokenCommandParameters, IControllerFactory iControllerFactory, CommandCallback commandCallback, String str) {
        super(tokenCommandParameters, iControllerFactory, commandCallback, str);
        if (tokenCommandParameters == null) {
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
}
