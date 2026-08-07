package com.box.android.coreservices.models;

import com.box.android.domain.configuration.IBoxAccountSettings;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.services.IAppRestrictionsManager;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxAccountSettings.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\b\u0010\u0010\u001a\u00020\tH\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/box/android/coreservices/models/BoxAccountSettings;", "Lcom/box/android/domain/configuration/IBoxAccountSettings;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "restrictionManager", "Lcom/box/android/domain/services/IAppRestrictionsManager;", "<init>", "(Lcom/box/android/domain/identity/IUserContextManager;Lcom/box/android/domain/services/IAppRestrictionsManager;)V", "isAnnotationsViewingEnabled", "", "isAnnotationsCreationEnabled", "isBoxAiEnabled", "isBoxAiStudioEnabled", "isBoxAiNotesEnabled", "isBoxAiMultidocEnabled", "isIntuneManaged", "isHubsGalleryEnabled", "isAxCenterEnabled", "isEMMMode", "coreservices_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxAccountSettings implements IBoxAccountSettings {
    private final IAppRestrictionsManager restrictionManager;
    private final IUserContextManager userContextManager;

    @Inject
    public BoxAccountSettings(IUserContextManager userContextManager, IAppRestrictionsManager restrictionManager) {
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(restrictionManager, "restrictionManager");
        this.userContextManager = userContextManager;
        this.restrictionManager = restrictionManager;
    }

    @Override // com.box.android.domain.configuration.IBoxAccountSettings
    public boolean isAnnotationsViewingEnabled() {
        return BoxAccountManager.isAnnotationsEnabled(this.userContextManager.getUserSharedPrefs());
    }

    @Override // com.box.android.domain.configuration.IBoxAccountSettings
    public boolean isAnnotationsCreationEnabled() {
        return BoxAccountManager.isAnnotationCreationEnabled(this.userContextManager.getUserSharedPrefs());
    }

    @Override // com.box.android.domain.configuration.IBoxAccountSettings
    public boolean isBoxAiEnabled() {
        return BoxAccountManager.isBoxAiPreviewEnabled(this.userContextManager.getUserSharedPrefs());
    }

    @Override // com.box.android.domain.configuration.IBoxAccountSettings
    public boolean isBoxAiStudioEnabled() {
        return BoxAccountManager.isBoxAiStudioEnabled(this.userContextManager.getUserSharedPrefs());
    }

    @Override // com.box.android.domain.configuration.IBoxAccountSettings
    public boolean isBoxAiNotesEnabled() {
        return BoxAccountManager.isBoxAiNotesEnabled(this.userContextManager.getUserSharedPrefs());
    }

    @Override // com.box.android.domain.configuration.IBoxAccountSettings
    public boolean isBoxAiMultidocEnabled() {
        return BoxAccountManager.isBoxAiMultidocEnabled(this.userContextManager.getUserSharedPrefs());
    }

    @Override // com.box.android.domain.configuration.IBoxAccountSettings
    public boolean isIntuneManaged() {
        return BoxAccountManager.isIntuneMAMEnabled(this.userContextManager.getUserSharedPrefs());
    }

    @Override // com.box.android.domain.configuration.IBoxAccountSettings
    public boolean isHubsGalleryEnabled() {
        return BoxAccountManager.isHubsGalleryEnabled(this.userContextManager.getUserSharedPrefs());
    }

    @Override // com.box.android.domain.configuration.IBoxAccountSettings
    public boolean isAxCenterEnabled() {
        return BoxAccountManager.isAxCenterInWebEnabled(this.userContextManager.getUserSharedPrefs());
    }

    @Override // com.box.android.domain.configuration.IBoxAccountSettings
    public boolean isEMMMode() {
        return !this.restrictionManager.getLatestAppRestrictions().isEmpty();
    }
}
