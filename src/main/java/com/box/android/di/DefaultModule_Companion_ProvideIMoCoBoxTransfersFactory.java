package com.box.android.di;

import com.box.android.coreservices.modelcontroller.IMoCoBoxTransfers;
import com.box.android.modelcontroller.MoCoBoxTransfers;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DefaultModule_Companion_ProvideIMoCoBoxTransfersFactory implements Factory<IMoCoBoxTransfers> {
    private final Provider<MoCoBoxTransfers> mocoProvider;

    private DefaultModule_Companion_ProvideIMoCoBoxTransfersFactory(Provider<MoCoBoxTransfers> provider) {
        this.mocoProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public IMoCoBoxTransfers get() {
        return provideIMoCoBoxTransfers(this.mocoProvider.get());
    }

    public static DefaultModule_Companion_ProvideIMoCoBoxTransfersFactory create(Provider<MoCoBoxTransfers> provider) {
        return new DefaultModule_Companion_ProvideIMoCoBoxTransfersFactory(provider);
    }

    public static IMoCoBoxTransfers provideIMoCoBoxTransfers(MoCoBoxTransfers moCoBoxTransfers) {
        return (IMoCoBoxTransfers) Preconditions.checkNotNullFromProvides(DefaultModule.INSTANCE.provideIMoCoBoxTransfers(moCoBoxTransfers));
    }
}
