package com.box.android.base.presentation.components.topbar.component.settings;

import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;

/* JADX INFO: compiled from: AvatarComponentDataProviderModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'¨\u0006\b"}, d2 = {"Lcom/box/android/base/presentation/components/topbar/component/settings/AvatarComponentDataProviderModule;", "", "<init>", "()V", "bind", "Lcom/box/android/base/presentation/components/topbar/component/settings/AvatarComponentDataProvider;", "impl", "Lcom/box/android/base/presentation/components/topbar/component/settings/DefaultAvatarComponentDataProvider;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module
public abstract class AvatarComponentDataProviderModule {
    public static final int $stable = 0;

    @Binds
    public abstract AvatarComponentDataProvider bind(DefaultAvatarComponentDataProvider impl);
}
