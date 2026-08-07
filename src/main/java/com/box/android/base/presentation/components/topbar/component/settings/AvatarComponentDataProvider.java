package com.box.android.base.presentation.components.topbar.component.settings;

import android.app.Activity;
import com.box.androidsdk.content.views.DefaultAvatarController;
import kotlin.Metadata;

/* JADX INFO: compiled from: AvatarComponentDataProvider.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/box/android/base/presentation/components/topbar/component/settings/AvatarComponentDataProvider;", "", "getAvatarController", "Lcom/box/androidsdk/content/views/DefaultAvatarController;", "activity", "Landroid/app/Activity;", "getUserId", "", "getUserName", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface AvatarComponentDataProvider {
    DefaultAvatarController getAvatarController(Activity activity);

    String getUserId(Activity activity);

    String getUserName(Activity activity);
}
