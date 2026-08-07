package com.box.android.di;

import android.content.Context;
import com.box.android.domain.identity.IUserContextManager;
import com.box.androidsdk.content.BoxApiMetadata;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DefaultModule_Companion_ProvideBoxApiMetadataFactory implements Factory<BoxApiMetadata> {
    private final Provider<Context> contextProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private DefaultModule_Companion_ProvideBoxApiMetadataFactory(Provider<IUserContextManager> provider, Provider<Context> provider2) {
        this.userContextManagerProvider = provider;
        this.contextProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxApiMetadata get() {
        return provideBoxApiMetadata(this.userContextManagerProvider.get(), this.contextProvider.get());
    }

    public static DefaultModule_Companion_ProvideBoxApiMetadataFactory create(Provider<IUserContextManager> provider, Provider<Context> provider2) {
        return new DefaultModule_Companion_ProvideBoxApiMetadataFactory(provider, provider2);
    }

    public static BoxApiMetadata provideBoxApiMetadata(IUserContextManager iUserContextManager, Context context) {
        return (BoxApiMetadata) Preconditions.checkNotNullFromProvides(DefaultModule.INSTANCE.provideBoxApiMetadata(iUserContextManager, context));
    }
}
