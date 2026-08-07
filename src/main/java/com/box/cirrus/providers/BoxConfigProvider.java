package com.box.cirrus.providers;

import com.box.android.domain.services.IBVEManager;
import com.margelo.nitro.boxcontext.providers.ConfigProvider;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxConfigProvider.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/box/cirrus/providers/BoxConfigProvider;", "Lcom/margelo/nitro/boxcontext/providers/ConfigProvider;", "bveManager", "Lcom/box/android/domain/services/IBVEManager;", "<init>", "(Lcom/box/android/domain/services/IBVEManager;)V", "getBaseHostDomain", "", "cirrus_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxConfigProvider implements ConfigProvider {
    private final IBVEManager bveManager;

    @Inject
    public BoxConfigProvider(IBVEManager bveManager) {
        Intrinsics.checkNotNullParameter(bveManager, "bveManager");
        this.bveManager = bveManager;
    }

    @Override // com.margelo.nitro.boxcontext.providers.ConfigProvider
    public String getBaseHostDomain() {
        return this.bveManager.getBaseUri();
    }
}
