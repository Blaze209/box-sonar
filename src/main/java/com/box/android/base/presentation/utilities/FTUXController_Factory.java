package com.box.android.base.presentation.utilities;

import com.box.android.base.presentation.fragments.BaseFTUX;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class FTUXController_Factory implements Factory<FTUXController> {
    private final Provider<BaseFTUX.FTUXFactory> ftuxFactoryProvider;

    private FTUXController_Factory(Provider<BaseFTUX.FTUXFactory> provider) {
        this.ftuxFactoryProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FTUXController get() {
        return newInstance(this.ftuxFactoryProvider.get());
    }

    public static FTUXController_Factory create(Provider<BaseFTUX.FTUXFactory> provider) {
        return new FTUXController_Factory(provider);
    }

    public static FTUXController newInstance(BaseFTUX.FTUXFactory fTUXFactory) {
        return new FTUXController(fTUXFactory);
    }
}
