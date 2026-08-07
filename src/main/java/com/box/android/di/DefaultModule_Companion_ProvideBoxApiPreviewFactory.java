package com.box.android.di;

import android.content.Context;
import com.box.android.domain.identity.IUserContextManager;
import com.box.androidsdk.content.BoxApiPreview;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DefaultModule_Companion_ProvideBoxApiPreviewFactory implements Factory<BoxApiPreview> {
    private final Provider<Context> contextProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private DefaultModule_Companion_ProvideBoxApiPreviewFactory(Provider<IUserContextManager> provider, Provider<Context> provider2) {
        this.userContextManagerProvider = provider;
        this.contextProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxApiPreview get() {
        return provideBoxApiPreview(this.userContextManagerProvider.get(), this.contextProvider.get());
    }

    public static DefaultModule_Companion_ProvideBoxApiPreviewFactory create(Provider<IUserContextManager> provider, Provider<Context> provider2) {
        return new DefaultModule_Companion_ProvideBoxApiPreviewFactory(provider, provider2);
    }

    public static BoxApiPreview provideBoxApiPreview(IUserContextManager iUserContextManager, Context context) {
        return (BoxApiPreview) Preconditions.checkNotNullFromProvides(DefaultModule.INSTANCE.provideBoxApiPreview(iUserContextManager, context));
    }
}
