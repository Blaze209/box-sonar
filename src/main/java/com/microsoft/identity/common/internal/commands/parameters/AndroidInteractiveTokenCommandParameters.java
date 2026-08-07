package com.microsoft.identity.common.internal.commands.parameters;

import android.app.Activity;
import com.microsoft.identity.common.internal.msafederation.google.SignInWithGoogleCredential;
import com.microsoft.identity.common.java.commands.parameters.InteractiveTokenCommandParameters;

/* JADX INFO: loaded from: classes14.dex */
public class AndroidInteractiveTokenCommandParameters extends InteractiveTokenCommandParameters {
    private final transient Activity activity;
    private final SignInWithGoogleCredential signInWithGoogleCredential;

    public static abstract class AndroidInteractiveTokenCommandParametersBuilder<C extends AndroidInteractiveTokenCommandParameters, B extends AndroidInteractiveTokenCommandParametersBuilder<C, B>> extends InteractiveTokenCommandParameters.InteractiveTokenCommandParametersBuilder<C, B> {
        private Activity activity;
        private SignInWithGoogleCredential signInWithGoogleCredential;

        @Override // com.microsoft.identity.common.java.commands.parameters.InteractiveTokenCommandParameters.InteractiveTokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract C build();

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.commands.parameters.InteractiveTokenCommandParameters.InteractiveTokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract B self();

        private static void $fillValuesFromInstanceIntoBuilder(AndroidInteractiveTokenCommandParameters androidInteractiveTokenCommandParameters, AndroidInteractiveTokenCommandParametersBuilder<?, ?> androidInteractiveTokenCommandParametersBuilder) {
            androidInteractiveTokenCommandParametersBuilder.activity(androidInteractiveTokenCommandParameters.activity);
            androidInteractiveTokenCommandParametersBuilder.signInWithGoogleCredential(androidInteractiveTokenCommandParameters.signInWithGoogleCredential);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.commands.parameters.InteractiveTokenCommandParameters.InteractiveTokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((AndroidInteractiveTokenCommandParameters) c, (AndroidInteractiveTokenCommandParametersBuilder<?, ?>) this);
            return (B) self();
        }

        public B activity(Activity activity) {
            this.activity = activity;
            return (B) self();
        }

        public B signInWithGoogleCredential(SignInWithGoogleCredential signInWithGoogleCredential) {
            this.signInWithGoogleCredential = signInWithGoogleCredential;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.InteractiveTokenCommandParameters.InteractiveTokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public String toString() {
            return "AndroidInteractiveTokenCommandParameters.AndroidInteractiveTokenCommandParametersBuilder(super=" + super.toString() + ", activity=" + this.activity + ", signInWithGoogleCredential=" + this.signInWithGoogleCredential + ")";
        }
    }

    private static final class AndroidInteractiveTokenCommandParametersBuilderImpl extends AndroidInteractiveTokenCommandParametersBuilder<AndroidInteractiveTokenCommandParameters, AndroidInteractiveTokenCommandParametersBuilderImpl> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.internal.commands.parameters.AndroidInteractiveTokenCommandParameters.AndroidInteractiveTokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.InteractiveTokenCommandParameters.InteractiveTokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public AndroidInteractiveTokenCommandParametersBuilderImpl self() {
            return this;
        }

        private AndroidInteractiveTokenCommandParametersBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.internal.commands.parameters.AndroidInteractiveTokenCommandParameters.AndroidInteractiveTokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.InteractiveTokenCommandParameters.InteractiveTokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public AndroidInteractiveTokenCommandParameters build() {
            return new AndroidInteractiveTokenCommandParameters(this);
        }
    }

    protected AndroidInteractiveTokenCommandParameters(AndroidInteractiveTokenCommandParametersBuilder<?, ?> androidInteractiveTokenCommandParametersBuilder) {
        super(androidInteractiveTokenCommandParametersBuilder);
        this.activity = ((AndroidInteractiveTokenCommandParametersBuilder) androidInteractiveTokenCommandParametersBuilder).activity;
        this.signInWithGoogleCredential = ((AndroidInteractiveTokenCommandParametersBuilder) androidInteractiveTokenCommandParametersBuilder).signInWithGoogleCredential;
    }

    public static AndroidInteractiveTokenCommandParametersBuilder<?, ?> builder() {
        return new AndroidInteractiveTokenCommandParametersBuilderImpl();
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.InteractiveTokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public AndroidInteractiveTokenCommandParametersBuilder<?, ?> toBuilder() {
        return new AndroidInteractiveTokenCommandParametersBuilderImpl().$fillValuesFrom(this);
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.InteractiveTokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    protected boolean canEqual(Object obj) {
        return obj instanceof AndroidInteractiveTokenCommandParameters;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.InteractiveTokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AndroidInteractiveTokenCommandParameters)) {
            return false;
        }
        AndroidInteractiveTokenCommandParameters androidInteractiveTokenCommandParameters = (AndroidInteractiveTokenCommandParameters) obj;
        if (!androidInteractiveTokenCommandParameters.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        SignInWithGoogleCredential signInWithGoogleCredential = getSignInWithGoogleCredential();
        SignInWithGoogleCredential signInWithGoogleCredential2 = androidInteractiveTokenCommandParameters.getSignInWithGoogleCredential();
        return signInWithGoogleCredential != null ? signInWithGoogleCredential.equals(signInWithGoogleCredential2) : signInWithGoogleCredential2 == null;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.InteractiveTokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public int hashCode() {
        int iHashCode = super.hashCode();
        SignInWithGoogleCredential signInWithGoogleCredential = getSignInWithGoogleCredential();
        return (iHashCode * 59) + (signInWithGoogleCredential == null ? 43 : signInWithGoogleCredential.hashCode());
    }

    public Activity getActivity() {
        return this.activity;
    }

    public SignInWithGoogleCredential getSignInWithGoogleCredential() {
        return this.signInWithGoogleCredential;
    }
}
