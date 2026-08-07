package com.box.android.navigationmodernization.homescreen;

import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class HomeScreenViewModel_Factory implements Factory<HomeScreenViewModel> {
    private final Provider<HomeScreenEnvironment> environmentProvider;

    private HomeScreenViewModel_Factory(Provider<HomeScreenEnvironment> provider) {
        this.environmentProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public HomeScreenViewModel get() {
        return newInstance(this.environmentProvider.get());
    }

    public static HomeScreenViewModel_Factory create(Provider<HomeScreenEnvironment> provider) {
        return new HomeScreenViewModel_Factory(provider);
    }

    public static HomeScreenViewModel newInstance(HomeScreenEnvironment homeScreenEnvironment) {
        return new HomeScreenViewModel(homeScreenEnvironment);
    }
}
