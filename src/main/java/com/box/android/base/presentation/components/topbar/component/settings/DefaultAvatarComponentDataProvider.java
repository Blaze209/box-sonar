package com.box.android.base.presentation.components.topbar.component.settings;

import android.app.Activity;
import com.box.android.domain.identity.IUserContextManager;
import com.box.androidsdk.content.models.BoxUser;
import com.box.androidsdk.content.views.DefaultAvatarController;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AvatarComponentDataProvider.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/box/android/base/presentation/components/topbar/component/settings/DefaultAvatarComponentDataProvider;", "Lcom/box/android/base/presentation/components/topbar/component/settings/AvatarComponentDataProvider;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "<init>", "(Lcom/box/android/domain/identity/IUserContextManager;)V", "getAvatarController", "Lcom/box/androidsdk/content/views/DefaultAvatarController;", "activity", "Landroid/app/Activity;", "getUserId", "", "getUserName", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DefaultAvatarComponentDataProvider implements AvatarComponentDataProvider {
    public static final int $stable = 8;
    private final IUserContextManager userContextManager;

    @Inject
    public DefaultAvatarComponentDataProvider(IUserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        this.userContextManager = userContextManager;
    }

    @Override // com.box.android.base.presentation.components.topbar.component.settings.AvatarComponentDataProvider
    public DefaultAvatarController getAvatarController(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return new DefaultAvatarController(this.userContextManager.getBoxSession(activity));
    }

    @Override // com.box.android.base.presentation.components.topbar.component.settings.AvatarComponentDataProvider
    public String getUserId(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        String userId = this.userContextManager.getBoxSession(activity).getUserId();
        Intrinsics.checkNotNullExpressionValue(userId, "getUserId(...)");
        return userId;
    }

    @Override // com.box.android.base.presentation.components.topbar.component.settings.AvatarComponentDataProvider
    public String getUserName(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        BoxUser user = this.userContextManager.getBoxSession(activity).getUser();
        if (user != null) {
            return user.getUserName();
        }
        return null;
    }
}
