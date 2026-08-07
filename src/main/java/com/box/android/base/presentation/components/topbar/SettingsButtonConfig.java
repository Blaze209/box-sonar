package com.box.android.base.presentation.components.topbar;

import com.box.android.base.presentation.components.topbar.component.settings.UserAvatarViewModel;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxPrimaryTopBar.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/box/android/base/presentation/components/topbar/SettingsButtonConfig;", "", "viewModel", "Lcom/box/android/base/presentation/components/topbar/component/settings/UserAvatarViewModel;", ViewProps.ON_CLICK, "Lkotlin/Function0;", "", "<init>", "(Lcom/box/android/base/presentation/components/topbar/component/settings/UserAvatarViewModel;Lkotlin/jvm/functions/Function0;)V", "getViewModel", "()Lcom/box/android/base/presentation/components/topbar/component/settings/UserAvatarViewModel;", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SettingsButtonConfig {
    public static final int $stable = 8;
    private final Function0<Unit> onClick;
    private final UserAvatarViewModel viewModel;

    public SettingsButtonConfig(UserAvatarViewModel viewModel, Function0<Unit> onClick) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.viewModel = viewModel;
        this.onClick = onClick;
    }

    public final Function0<Unit> getOnClick() {
        return this.onClick;
    }

    public final UserAvatarViewModel getViewModel() {
        return this.viewModel;
    }
}
