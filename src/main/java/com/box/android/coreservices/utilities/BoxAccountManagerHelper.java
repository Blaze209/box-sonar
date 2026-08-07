package com.box.android.coreservices.utilities;

import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.R;
import com.box.android.coreservices.models.BoxAccountManager;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.mappers.UserModelMapper;
import com.box.android.domain.models.item.UserModel;
import com.box.androidsdk.content.models.BoxUser;
import com.microsoft.intune.mam.policy.SaveLocation;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxAccountManagerHelper.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010\u0015\u001a\u00020\rJ\u0006\u0010\u0016\u001a\u00020\rJ\u0006\u0010\u0017\u001a\u00020\rJ\u0006\u0010\u0018\u001a\u00020\rJ\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/box/android/coreservices/utilities/BoxAccountManagerHelper;", "", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "<init>", "(Lcom/box/android/domain/identity/IUserContextManager;Lcom/box/android/domain/configuration/FeatureFlips;)V", "getUserContextManager", "()Lcom/box/android/domain/identity/IUserContextManager;", "getFeatureFlips", "()Lcom/box/android/domain/configuration/FeatureFlips;", "doesSaveOnDeviceRequireEncryptedDevice", "", "getFeatureDisabledMessage", "", "getEncryptedDeviceRequiredMessage", "isSaveToLocationAllowed", "saveLocation", "Lcom/microsoft/intune/mam/policy/SaveLocation;", "s", "isMobileOpenInEnabled", "isMobilePreviewOnlyOffliningEnabled", "isMobilePrintEnabled", "isMobileSaveOnDeviceEnabled", "getCurrentUser", "Lcom/box/android/domain/models/item/UserModel;", "isMobileCopyPasteEnabled", "coreservices_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxAccountManagerHelper {
    private final FeatureFlips featureFlips;
    private final IUserContextManager userContextManager;

    @Inject
    public BoxAccountManagerHelper(IUserContextManager userContextManager, FeatureFlips featureFlips) {
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(featureFlips, "featureFlips");
        this.userContextManager = userContextManager;
        this.featureFlips = featureFlips;
    }

    public final FeatureFlips getFeatureFlips() {
        return this.featureFlips;
    }

    public final IUserContextManager getUserContextManager() {
        return this.userContextManager;
    }

    public final boolean doesSaveOnDeviceRequireEncryptedDevice() {
        return BoxAccountManager.doesSaveOnDeviceRequireEncryptedDevice(this.userContextManager.getUserSharedPrefs());
    }

    public final String getFeatureDisabledMessage() {
        return CommonBoxUtil.getUSLocaleString(R.string.This_feature_has_been_disabled_by_your_or_your_administrator);
    }

    public final String getEncryptedDeviceRequiredMessage() {
        return CommonBoxUtil.getUSLocaleString(R.string.Encrypted_device_requird_for_this_feature);
    }

    public final boolean isSaveToLocationAllowed(SaveLocation saveLocation, String s) {
        Intrinsics.checkNotNullParameter(saveLocation, "saveLocation");
        return CoreServiceUtils.getIsSaveToLocationAllowed(saveLocation, s);
    }

    public final boolean isMobileOpenInEnabled() {
        return BoxAccountManager.isMobileOpenInEnabled(this.userContextManager);
    }

    public final boolean isMobilePreviewOnlyOffliningEnabled() {
        return BoxAccountManager.isMobilePreviewOnlyOffliningEnabled(this.userContextManager.getUserSharedPrefs());
    }

    public final boolean isMobilePrintEnabled() {
        return BoxAccountManager.isMobilePrintEnabled(this.userContextManager);
    }

    public final boolean isMobileSaveOnDeviceEnabled() {
        return BoxAccountManager.isMobileSaveOnDeviceEnabled(this.userContextManager);
    }

    public final UserModel getCurrentUser() {
        UserModelMapper userModelMapper = UserModelMapper.INSTANCE;
        BoxUser userInfo = this.userContextManager.getUserInfo();
        Intrinsics.checkNotNullExpressionValue(userInfo, "getUserInfo(...)");
        return userModelMapper.toUserModel(userInfo);
    }

    public final boolean isMobileCopyPasteEnabled() {
        return BoxAccountManager.isMobileCopyPasteEnabled(this.userContextManager);
    }
}
