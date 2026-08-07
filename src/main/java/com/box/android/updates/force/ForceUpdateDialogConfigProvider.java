package com.box.android.updates.force;

import com.box.android.domain.configuration.IBoxAccountSettings;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ForceUpdateDialogConfigProvider.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\b\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/box/android/updates/force/ForceUpdateDialogConfigProvider;", "", "accountSettings", "Lcom/box/android/domain/configuration/IBoxAccountSettings;", "<init>", "(Lcom/box/android/domain/configuration/IBoxAccountSettings;)V", "getDialogConfig", "Lcom/box/android/updates/force/ForceUpdateDialogConfig;", "requiresAdminForAppUpdates", "", "app-updates_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ForceUpdateDialogConfigProvider {
    public static final int $stable = 8;
    private final IBoxAccountSettings accountSettings;

    @Inject
    public ForceUpdateDialogConfigProvider(IBoxAccountSettings accountSettings) {
        Intrinsics.checkNotNullParameter(accountSettings, "accountSettings");
        this.accountSettings = accountSettings;
    }

    public final ForceUpdateDialogConfig getDialogConfig() {
        return new ForceUpdateDialogConfig(requiresAdminForAppUpdates());
    }

    private final boolean requiresAdminForAppUpdates() {
        return this.accountSettings.isEMMMode();
    }
}
