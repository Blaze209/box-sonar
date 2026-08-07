package com.box.cirrus.providers;

import com.box.android.domain.models.ClientSettingsModel;
import com.box.android.domain.services.IClientSettingsService;
import com.box.android.domain.utils.result.ResultKt;
import com.margelo.nitro.boxcontext.providers.AccountSettingsProvider;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxAccountSettingsProvider.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/box/cirrus/providers/BoxAccountSettingsProvider;", "Lcom/margelo/nitro/boxcontext/providers/AccountSettingsProvider;", "clientSettingsService", "Lcom/box/android/domain/services/IClientSettingsService;", "<init>", "(Lcom/box/android/domain/services/IClientSettingsService;)V", "isCopyPasteEnabled", "", "isHubsAiEnabled", "isAiStudioEnabled", "cirrus_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxAccountSettingsProvider implements AccountSettingsProvider {
    private final IClientSettingsService clientSettingsService;

    @Inject
    public BoxAccountSettingsProvider(IClientSettingsService clientSettingsService) {
        Intrinsics.checkNotNullParameter(clientSettingsService, "clientSettingsService");
        this.clientSettingsService = clientSettingsService;
    }

    @Override // com.margelo.nitro.boxcontext.providers.AccountSettingsProvider
    public boolean isCopyPasteEnabled() {
        Boolean boolIsCopyPasteAllowed;
        ClientSettingsModel clientSettingsModel = (ClientSettingsModel) ResultKt.getOrNull(this.clientSettingsService.getClientSettingsLocal());
        if (clientSettingsModel == null || (boolIsCopyPasteAllowed = clientSettingsModel.isCopyPasteAllowed()) == null) {
            return true;
        }
        return boolIsCopyPasteAllowed.booleanValue();
    }

    @Override // com.margelo.nitro.boxcontext.providers.AccountSettingsProvider
    public boolean isHubsAiEnabled() {
        ClientSettingsModel clientSettingsModel = (ClientSettingsModel) ResultKt.getOrNull(this.clientSettingsService.getClientSettingsLocal());
        if (clientSettingsModel != null) {
            return Intrinsics.areEqual((Object) clientSettingsModel.isHubsAIEnabled(), (Object) true);
        }
        return false;
    }

    @Override // com.margelo.nitro.boxcontext.providers.AccountSettingsProvider
    public boolean isAiStudioEnabled() {
        ClientSettingsModel clientSettingsModel = (ClientSettingsModel) ResultKt.getOrNull(this.clientSettingsService.getClientSettingsLocal());
        if (clientSettingsModel != null) {
            return Intrinsics.areEqual((Object) clientSettingsModel.isBoxAiStudioEnabled(), (Object) true);
        }
        return false;
    }
}
