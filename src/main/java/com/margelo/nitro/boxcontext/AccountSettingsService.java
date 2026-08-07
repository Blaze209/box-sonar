package com.margelo.nitro.boxcontext;

import com.margelo.nitro.boxcontext.providers.AccountSettingsProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AccountSettingsService.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"Lcom/margelo/nitro/boxcontext/AccountSettingsService;", "Lcom/margelo/nitro/boxcontext/HybridAccountSettingsServiceSpec;", "<init>", "()V", "isCopyPasteEnabled", "", "isHubsAiEnabled", "isAiStudioEnabled", "cirrus_box-context_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AccountSettingsService extends HybridAccountSettingsServiceSpec {
    /* JADX INFO: Access modifiers changed from: private */
    public static final AccountSettingsProvider isCopyPasteEnabled$lambda$0(BoxContext.Dependencies require) {
        Intrinsics.checkNotNullParameter(require, "$this$require");
        return require.getAccountSettingsProvider();
    }

    @Override // com.margelo.nitro.boxcontext.HybridAccountSettingsServiceSpec
    public boolean isCopyPasteEnabled() {
        return ((AccountSettingsProvider) BoxContext.INSTANCE.require(new Function1() { // from class: com.margelo.nitro.boxcontext.AccountSettingsService$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AccountSettingsService.isCopyPasteEnabled$lambda$0((BoxContext.Dependencies) obj);
            }
        })).isCopyPasteEnabled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AccountSettingsProvider isHubsAiEnabled$lambda$1(BoxContext.Dependencies require) {
        Intrinsics.checkNotNullParameter(require, "$this$require");
        return require.getAccountSettingsProvider();
    }

    @Override // com.margelo.nitro.boxcontext.HybridAccountSettingsServiceSpec
    public boolean isHubsAiEnabled() {
        return ((AccountSettingsProvider) BoxContext.INSTANCE.require(new Function1() { // from class: com.margelo.nitro.boxcontext.AccountSettingsService$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AccountSettingsService.isHubsAiEnabled$lambda$1((BoxContext.Dependencies) obj);
            }
        })).isHubsAiEnabled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AccountSettingsProvider isAiStudioEnabled$lambda$2(BoxContext.Dependencies require) {
        Intrinsics.checkNotNullParameter(require, "$this$require");
        return require.getAccountSettingsProvider();
    }

    @Override // com.margelo.nitro.boxcontext.HybridAccountSettingsServiceSpec
    public boolean isAiStudioEnabled() {
        return ((AccountSettingsProvider) BoxContext.INSTANCE.require(new Function1() { // from class: com.margelo.nitro.boxcontext.AccountSettingsService$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AccountSettingsService.isAiStudioEnabled$lambda$2((BoxContext.Dependencies) obj);
            }
        })).isAiStudioEnabled();
    }
}
