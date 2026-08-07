package com.box.android.preview.preview.previewbar.topbar;

import com.box.android.coreservices.utilities.BoxAccountManagerHelper;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class TopBarEnvironment_Factory implements Factory<TopBarEnvironment> {
    private final Provider<BoxAccountManagerHelper> boxAccountManagerHelperProvider;

    private TopBarEnvironment_Factory(Provider<BoxAccountManagerHelper> provider) {
        this.boxAccountManagerHelperProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public TopBarEnvironment get() {
        return newInstance(this.boxAccountManagerHelperProvider.get());
    }

    public static TopBarEnvironment_Factory create(Provider<BoxAccountManagerHelper> provider) {
        return new TopBarEnvironment_Factory(provider);
    }

    public static TopBarEnvironment newInstance(BoxAccountManagerHelper boxAccountManagerHelper) {
        return new TopBarEnvironment(boxAccountManagerHelper);
    }
}
