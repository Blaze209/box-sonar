package com.box.android.di;

import android.content.Context;
import com.box.android.domain.identity.IUserContextManager;
import com.box.androidsdk.content.BoxExtendedApiPreview;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DefaultModule_Companion_ProvideBoxExtendedApiPreviewFactory implements Factory<BoxExtendedApiPreview> {
    private final Provider<Context> contextProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private DefaultModule_Companion_ProvideBoxExtendedApiPreviewFactory(Provider<IUserContextManager> provider, Provider<Context> provider2) {
        this.userContextManagerProvider = provider;
        this.contextProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxExtendedApiPreview get() {
        return provideBoxExtendedApiPreview(this.userContextManagerProvider.get(), this.contextProvider.get());
    }

    public static DefaultModule_Companion_ProvideBoxExtendedApiPreviewFactory create(Provider<IUserContextManager> provider, Provider<Context> provider2) {
        return new DefaultModule_Companion_ProvideBoxExtendedApiPreviewFactory(provider, provider2);
    }

    public static BoxExtendedApiPreview provideBoxExtendedApiPreview(IUserContextManager iUserContextManager, Context context) {
        return (BoxExtendedApiPreview) Preconditions.checkNotNullFromProvides(DefaultModule.INSTANCE.provideBoxExtendedApiPreview(iUserContextManager, context));
    }
}
