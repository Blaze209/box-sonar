package com.box.android.navigationmodernization.homescreen.helpers;

import com.box.android.base.presentation.fragments.BaseFTUX;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class FTUXMessageReceiverHelper_Factory implements Factory<FTUXMessageReceiverHelper> {
    private final Provider<BaseFTUX.FTUXFactory> ftuxFactoryProvider;

    private FTUXMessageReceiverHelper_Factory(Provider<BaseFTUX.FTUXFactory> provider) {
        this.ftuxFactoryProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FTUXMessageReceiverHelper get() {
        return newInstance(this.ftuxFactoryProvider.get());
    }

    public static FTUXMessageReceiverHelper_Factory create(Provider<BaseFTUX.FTUXFactory> provider) {
        return new FTUXMessageReceiverHelper_Factory(provider);
    }

    public static FTUXMessageReceiverHelper newInstance(BaseFTUX.FTUXFactory fTUXFactory) {
        return new FTUXMessageReceiverHelper(fTUXFactory);
    }
}
