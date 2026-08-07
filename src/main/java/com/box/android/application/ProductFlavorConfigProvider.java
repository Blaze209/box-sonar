package com.box.android.application;

import com.box.android.domain.configuration.BoxConfigConstants;
import com.box.android.domain.configuration.IProductFlavorConfig;
import com.box.android.utilities.BoxConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: compiled from: ProductFlavorConfigProvider.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\f"}, d2 = {"Lcom/box/android/application/ProductFlavorConfigProvider;", "Lcom/box/android/domain/configuration/IProductFlavorConfig;", "<init>", "()V", "provideClientId", "Lkotlin/Pair;", "", "provideClientSecret", "provideAppName", "isAccountSwitchingEnabled", "", "shouldKillAppOnLogout", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ProductFlavorConfigProvider implements IProductFlavorConfig {
    public static final int $stable = 0;

    @Override // com.box.android.domain.configuration.IProductFlavorConfig
    public boolean isAccountSwitchingEnabled() {
        return true;
    }

    @Override // com.box.android.domain.configuration.IProductFlavorConfig
    public boolean shouldKillAppOnLogout() {
        return false;
    }

    @Inject
    public ProductFlavorConfigProvider() {
    }

    @Override // com.box.android.domain.configuration.IProductFlavorConfig
    public Pair<String, String> provideClientId() {
        return new Pair<>(BoxConfigConstants.CONFIG_SDK_DEFAULT_CLIENT_ID, BoxConfigConstants.CONFIG_SDK_DEFAULT_TABLET_CLIENT_ID);
    }

    @Override // com.box.android.domain.configuration.IProductFlavorConfig
    public Pair<String, String> provideClientSecret() {
        return new Pair<>(BoxConfigConstants.CONFIG_SDK_DEFAULT_CLIENT_SECRET, BoxConfigConstants.CONFIG_SDK_DEFAULT_TABLET_CLIENT_SECRET);
    }

    @Override // com.box.android.domain.configuration.IProductFlavorConfig
    public String provideAppName() {
        return BoxConstants.TAG;
    }
}
