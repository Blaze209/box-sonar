package com.microsoft.identity.common.java.commands;

import com.microsoft.identity.common.java.commands.parameters.CommandParameters;
import com.microsoft.identity.common.java.controllers.IControllerFactory;

/* JADX INFO: loaded from: classes14.dex */
public abstract class BaseCommand<T> implements ICommand<T> {
    private final CommandCallback callback;
    private final IControllerFactory controllerFactory;
    private final CommandParameters parameters;
    private final String publicApiId;

    @Override // com.microsoft.identity.common.java.commands.ICommand
    public abstract T execute() throws Exception;

    @Override // com.microsoft.identity.common.java.commands.ICommand
    public boolean isEligibleForCaching() {
        return false;
    }

    @Override // com.microsoft.identity.common.java.commands.ICommand
    public boolean willReachTokenEndpoint() {
        return false;
    }

    public static abstract class BaseCommandBuilder<T, C extends BaseCommand<T>, B extends BaseCommandBuilder<T, C, B>> {
        private CommandCallback callback;
        private IControllerFactory controllerFactory;
        private CommandParameters parameters;
        private String publicApiId;

        public abstract C build();

        protected abstract B self();

        private static <T> void $fillValuesFromInstanceIntoBuilder(BaseCommand<T> baseCommand, BaseCommandBuilder<T, ?, ?> baseCommandBuilder) {
            baseCommandBuilder.parameters(((BaseCommand) baseCommand).parameters);
            baseCommandBuilder.callback(((BaseCommand) baseCommand).callback);
            baseCommandBuilder.publicApiId(((BaseCommand) baseCommand).publicApiId);
            baseCommandBuilder.controllerFactory(((BaseCommand) baseCommand).controllerFactory);
        }

        protected B $fillValuesFrom(C c) {
            $fillValuesFromInstanceIntoBuilder(c, this);
            return (B) self();
        }

        public B callback(CommandCallback commandCallback) {
            if (commandCallback == null) {
                throw new NullPointerException("callback is marked non-null but is null");
            }
            this.callback = commandCallback;
            return (B) self();
        }

        public B controllerFactory(IControllerFactory iControllerFactory) {
            if (iControllerFactory == null) {
                throw new NullPointerException("controllerFactory is marked non-null but is null");
            }
            this.controllerFactory = iControllerFactory;
            return (B) self();
        }

        public B parameters(CommandParameters commandParameters) {
            if (commandParameters == null) {
                throw new NullPointerException("parameters is marked non-null but is null");
            }
            this.parameters = commandParameters;
            return (B) self();
        }

        public B publicApiId(String str) {
            if (str == null) {
                throw new NullPointerException("publicApiId is marked non-null but is null");
            }
            this.publicApiId = str;
            return (B) self();
        }

        public String toString() {
            return "BaseCommand.BaseCommandBuilder(parameters=" + this.parameters + ", callback=" + this.callback + ", publicApiId=" + this.publicApiId + ", controllerFactory=" + this.controllerFactory + ")";
        }
    }

    protected boolean canEqual(Object obj) {
        return obj instanceof BaseCommand;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BaseCommand)) {
            return false;
        }
        BaseCommand baseCommand = (BaseCommand) obj;
        if (!baseCommand.canEqual(this)) {
            return false;
        }
        CommandParameters parameters = getParameters();
        CommandParameters parameters2 = baseCommand.getParameters();
        return parameters != null ? parameters.equals(parameters2) : parameters2 == null;
    }

    public int hashCode() {
        CommandParameters parameters = getParameters();
        return 59 + (parameters == null ? 43 : parameters.hashCode());
    }

    protected BaseCommand(BaseCommandBuilder<T, ?, ?> baseCommandBuilder) {
        CommandParameters commandParameters = ((BaseCommandBuilder) baseCommandBuilder).parameters;
        this.parameters = commandParameters;
        if (commandParameters == null) {
            throw new NullPointerException("parameters is marked non-null but is null");
        }
        CommandCallback commandCallback = ((BaseCommandBuilder) baseCommandBuilder).callback;
        this.callback = commandCallback;
        if (commandCallback == null) {
            throw new NullPointerException("callback is marked non-null but is null");
        }
        String str = ((BaseCommandBuilder) baseCommandBuilder).publicApiId;
        this.publicApiId = str;
        if (str == null) {
            throw new NullPointerException("publicApiId is marked non-null but is null");
        }
        IControllerFactory iControllerFactory = ((BaseCommandBuilder) baseCommandBuilder).controllerFactory;
        this.controllerFactory = iControllerFactory;
        if (iControllerFactory == null) {
            throw new NullPointerException("controllerFactory is marked non-null but is null");
        }
    }

    public CommandParameters getParameters() {
        return this.parameters;
    }

    public CommandCallback getCallback() {
        return this.callback;
    }

    public String getPublicApiId() {
        return this.publicApiId;
    }

    public IControllerFactory getControllerFactory() {
        return this.controllerFactory;
    }

    public BaseCommand(CommandParameters commandParameters, IControllerFactory iControllerFactory, CommandCallback commandCallback, String str) {
        if (commandParameters == null) {
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
        this.parameters = commandParameters;
        this.callback = commandCallback;
        this.controllerFactory = iControllerFactory;
        this.publicApiId = str;
    }

    @Override // com.microsoft.identity.common.java.commands.ICommand
    public String getCorrelationId() {
        return getParameters().getCorrelationId();
    }
}
