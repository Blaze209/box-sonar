package com.box.android.fragments;

import android.content.SharedPreferences;
import com.box.android.coreservices.models.BoxAccountManager;
import com.box.android.domain.identity.IUserContext;
import com.box.android.domain.identity.IUserContextComponent;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.localrepo.LocalAutoContentUploadInformation;
import com.box.androidsdk.content.models.BoxUser;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AutoUploadUtils.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u001a\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u000f\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/box/android/fragments/AutoUploadUtils;", "", "<init>", "()V", "setAutoContentUploadFeatureAvailable", "", "isAvailable", "", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "isSyncEnabled", "isAutoContentUploadEnabledByAdmin", "userInfo", "Lcom/box/androidsdk/content/models/BoxUser;", "isAutoContentUploadFeatureAvailable", "SHARED_PREF_KEY_IS_AUTO_UPLOAD_FEATURE_AVAILABLE", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AutoUploadUtils {
    public static final int $stable = 0;
    public static final AutoUploadUtils INSTANCE = new AutoUploadUtils();
    public static final String SHARED_PREF_KEY_IS_AUTO_UPLOAD_FEATURE_AVAILABLE = "isAutoUploadFeatureAvailable";

    private AutoUploadUtils() {
    }

    @JvmStatic
    public static final void setAutoContentUploadFeatureAvailable(boolean isAvailable, IUserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        SharedPreferences userSharedPrefs = userContextManager.getUserSharedPrefs();
        Intrinsics.checkNotNullExpressionValue(userSharedPrefs, "getUserSharedPrefs(...)");
        SharedPreferences.Editor editorEdit = userSharedPrefs.edit();
        editorEdit.putBoolean(SHARED_PREF_KEY_IS_AUTO_UPLOAD_FEATURE_AVAILABLE, isAvailable);
        editorEdit.commit();
    }

    @JvmStatic
    public static final boolean isSyncEnabled(IUserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        IUserContextComponent userContextComponent = userContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.LOCAL_AUTO_CONTENT_UPLOAD_INFORMATION);
        Intrinsics.checkNotNull(userContextComponent, "null cannot be cast to non-null type com.box.android.localrepo.LocalAutoContentUploadInformation");
        return ((LocalAutoContentUploadInformation) userContextComponent).isSyncEnabled();
    }

    public final boolean isAutoContentUploadEnabledByAdmin(BoxUser userInfo, IUserContextManager userContextManager) {
        if (userInfo == null) {
            return false;
        }
        if (userInfo.getEnterprise() != null) {
            return BoxAccountManager.isMobileAutoPhotoUploadEnabled(userContextManager);
        }
        return true;
    }

    public final boolean isAutoContentUploadFeatureAvailable(IUserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        return userContextManager.getUserSharedPrefs().getBoolean(SHARED_PREF_KEY_IS_AUTO_UPLOAD_FEATURE_AVAILABLE, false);
    }
}
