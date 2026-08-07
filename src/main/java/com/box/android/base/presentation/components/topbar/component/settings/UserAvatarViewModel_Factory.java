package com.box.android.base.presentation.components.topbar.component.settings;

import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class UserAvatarViewModel_Factory implements Factory<UserAvatarViewModel> {
    private final Provider<AvatarComponentDataProvider> avatarComponentDataProvider;

    private UserAvatarViewModel_Factory(Provider<AvatarComponentDataProvider> provider) {
        this.avatarComponentDataProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public UserAvatarViewModel get() {
        return newInstance(this.avatarComponentDataProvider.get());
    }

    public static UserAvatarViewModel_Factory create(Provider<AvatarComponentDataProvider> provider) {
        return new UserAvatarViewModel_Factory(provider);
    }

    public static UserAvatarViewModel newInstance(AvatarComponentDataProvider avatarComponentDataProvider) {
        return new UserAvatarViewModel(avatarComponentDataProvider);
    }
}
