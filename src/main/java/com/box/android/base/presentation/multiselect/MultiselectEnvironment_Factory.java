package com.box.android.base.presentation.multiselect;

import com.box.android.coreservices.utilities.BoxAccountManagerHelper;
import com.box.android.domain.identity.IUserContextManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class MultiselectEnvironment_Factory implements Factory<MultiselectEnvironment> {
    private final Provider<BoxAccountManagerHelper> boxAccountManagerHelperProvider;
    private final Provider<SelectionManager> selectionManagerProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private MultiselectEnvironment_Factory(Provider<IUserContextManager> provider, Provider<BoxAccountManagerHelper> provider2, Provider<SelectionManager> provider3) {
        this.userContextManagerProvider = provider;
        this.boxAccountManagerHelperProvider = provider2;
        this.selectionManagerProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public MultiselectEnvironment get() {
        return newInstance(this.userContextManagerProvider.get(), this.boxAccountManagerHelperProvider.get(), this.selectionManagerProvider.get());
    }

    public static MultiselectEnvironment_Factory create(Provider<IUserContextManager> provider, Provider<BoxAccountManagerHelper> provider2, Provider<SelectionManager> provider3) {
        return new MultiselectEnvironment_Factory(provider, provider2, provider3);
    }

    public static MultiselectEnvironment newInstance(IUserContextManager iUserContextManager, BoxAccountManagerHelper boxAccountManagerHelper, SelectionManager selectionManager) {
        return new MultiselectEnvironment(iUserContextManager, boxAccountManagerHelper, selectionManager);
    }
}
