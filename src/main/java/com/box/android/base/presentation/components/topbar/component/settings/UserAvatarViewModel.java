package com.box.android.base.presentation.components.topbar.component.settings;

import androidx.lifecycle.ViewModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UserAvatarViewModel.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/base/presentation/components/topbar/component/settings/UserAvatarViewModel;", "Landroidx/lifecycle/ViewModel;", "avatarComponentDataProvider", "Lcom/box/android/base/presentation/components/topbar/component/settings/AvatarComponentDataProvider;", "<init>", "(Lcom/box/android/base/presentation/components/topbar/component/settings/AvatarComponentDataProvider;)V", "getAvatarComponentDataProvider", "()Lcom/box/android/base/presentation/components/topbar/component/settings/AvatarComponentDataProvider;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UserAvatarViewModel extends ViewModel {
    public static final int $stable = 8;
    private final AvatarComponentDataProvider avatarComponentDataProvider;

    @Inject
    public UserAvatarViewModel(AvatarComponentDataProvider avatarComponentDataProvider) {
        Intrinsics.checkNotNullParameter(avatarComponentDataProvider, "avatarComponentDataProvider");
        this.avatarComponentDataProvider = avatarComponentDataProvider;
    }

    public final AvatarComponentDataProvider getAvatarComponentDataProvider() {
        return this.avatarComponentDataProvider;
    }
}
