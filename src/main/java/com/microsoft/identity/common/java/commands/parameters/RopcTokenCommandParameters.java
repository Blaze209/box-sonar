package com.microsoft.identity.common.java.commands.parameters;

import com.microsoft.identity.common.java.exception.ArgumentException;
import com.microsoft.identity.common.java.util.StringUtil;

/* JADX INFO: loaded from: classes14.dex */
public class RopcTokenCommandParameters extends TokenCommandParameters {
    private final String mPassword;
    private final String mUsername;

    public static abstract class RopcTokenCommandParametersBuilder<C extends RopcTokenCommandParameters, B extends RopcTokenCommandParametersBuilder<C, B>> extends TokenCommandParameters.TokenCommandParametersBuilder<C, B> {
        private String password;
        private String username;

        @Override // com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract C build();

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract B self();

        private static void $fillValuesFromInstanceIntoBuilder(RopcTokenCommandParameters ropcTokenCommandParameters, RopcTokenCommandParametersBuilder<?, ?> ropcTokenCommandParametersBuilder) {
            ropcTokenCommandParametersBuilder.username(ropcTokenCommandParameters.mUsername);
            ropcTokenCommandParametersBuilder.password(ropcTokenCommandParameters.mPassword);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((RopcTokenCommandParameters) c, (RopcTokenCommandParametersBuilder<?, ?>) this);
            return (B) self();
        }

        public B password(String str) {
            this.password = str;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public String toString() {
            return "RopcTokenCommandParameters.RopcTokenCommandParametersBuilder(super=" + super.toString() + ", username=" + this.username + ", password=" + this.password + ")";
        }

        public B username(String str) {
            this.username = str;
            return (B) self();
        }
    }

    private static final class RopcTokenCommandParametersBuilderImpl extends RopcTokenCommandParametersBuilder<RopcTokenCommandParameters, RopcTokenCommandParametersBuilderImpl> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.commands.parameters.RopcTokenCommandParameters.RopcTokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public RopcTokenCommandParametersBuilderImpl self() {
            return this;
        }

        private RopcTokenCommandParametersBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.RopcTokenCommandParameters.RopcTokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public RopcTokenCommandParameters build() {
            return new RopcTokenCommandParameters(this);
        }
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    protected boolean canEqual(Object obj) {
        return obj instanceof RopcTokenCommandParameters;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RopcTokenCommandParameters)) {
            return false;
        }
        RopcTokenCommandParameters ropcTokenCommandParameters = (RopcTokenCommandParameters) obj;
        if (!ropcTokenCommandParameters.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        String username = getUsername();
        String username2 = ropcTokenCommandParameters.getUsername();
        if (username != null ? !username.equals(username2) : username2 != null) {
            return false;
        }
        String password = getPassword();
        String password2 = ropcTokenCommandParameters.getPassword();
        return password != null ? password.equals(password2) : password2 == null;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public int hashCode() {
        int iHashCode = super.hashCode();
        String username = getUsername();
        int i = iHashCode * 59;
        int iHashCode2 = username == null ? 43 : username.hashCode();
        String password = getPassword();
        return ((i + iHashCode2) * 59) + (password != null ? password.hashCode() : 43);
    }

    protected RopcTokenCommandParameters(RopcTokenCommandParametersBuilder<?, ?> ropcTokenCommandParametersBuilder) {
        super(ropcTokenCommandParametersBuilder);
        this.mUsername = ((RopcTokenCommandParametersBuilder) ropcTokenCommandParametersBuilder).username;
        this.mPassword = ((RopcTokenCommandParametersBuilder) ropcTokenCommandParametersBuilder).password;
    }

    public static RopcTokenCommandParametersBuilder<?, ?> builder() {
        return new RopcTokenCommandParametersBuilderImpl();
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public RopcTokenCommandParametersBuilder<?, ?> toBuilder() {
        return new RopcTokenCommandParametersBuilderImpl().$fillValuesFrom(this);
    }

    public String getUsername() {
        return this.mUsername;
    }

    public String getPassword() {
        return this.mPassword;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters
    public void validate() throws ArgumentException {
        if (StringUtil.isNullOrEmpty(this.mUsername)) {
            throw new ArgumentException(ArgumentException.ACQUIRE_TOKEN_WITH_PASSWORD_OPERATION_NAME, "mUsername", "Username is not set");
        }
        if (StringUtil.isNullOrEmpty(this.mPassword)) {
            throw new ArgumentException(ArgumentException.ACQUIRE_TOKEN_WITH_PASSWORD_OPERATION_NAME, "mPassword", "Password is not set");
        }
        super.validate();
    }
}
