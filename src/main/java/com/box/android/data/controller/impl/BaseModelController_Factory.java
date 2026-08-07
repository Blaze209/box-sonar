package com.box.android.data.controller.impl;

import android.content.Context;
import com.box.android.domain.identity.IUserContextManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class BaseModelController_Factory implements Factory<BaseModelController> {
    private final Provider<Context> contextProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private BaseModelController_Factory(Provider<IUserContextManager> userContextManagerProvider, Provider<Context> contextProvider) {
        this.userContextManagerProvider = userContextManagerProvider;
        this.contextProvider = contextProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BaseModelController get() {
        return newInstance(this.userContextManagerProvider.get(), this.contextProvider.get());
    }

    public static BaseModelController_Factory create(Provider<IUserContextManager> userContextManagerProvider, Provider<Context> contextProvider) {
        return new BaseModelController_Factory(userContextManagerProvider, contextProvider);
    }

    public static BaseModelController newInstance(IUserContextManager userContextManager, Context context) {
        return new BaseModelController(userContextManager, context);
    }
}
