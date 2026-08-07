package com.box.android.data.di;

import android.content.Context;
import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.domain.controller.ICommentsController;
import com.box.android.domain.identity.IUserContextManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DataProvidesModule_ProvideCommentsControllerFactory implements Factory<ICommentsController> {
    private final Provider<IBaseModelController> baseModelControllerProvider;
    private final Provider<IUserContextManager> contextManagerProvider;
    private final Provider<Context> contextProvider;
    private final DataProvidesModule module;

    private DataProvidesModule_ProvideCommentsControllerFactory(DataProvidesModule module, Provider<IUserContextManager> contextManagerProvider, Provider<Context> contextProvider, Provider<IBaseModelController> baseModelControllerProvider) {
        this.module = module;
        this.contextManagerProvider = contextManagerProvider;
        this.contextProvider = contextProvider;
        this.baseModelControllerProvider = baseModelControllerProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ICommentsController get() {
        return provideCommentsController(this.module, this.contextManagerProvider.get(), this.contextProvider.get(), this.baseModelControllerProvider.get());
    }

    public static DataProvidesModule_ProvideCommentsControllerFactory create(DataProvidesModule module, Provider<IUserContextManager> contextManagerProvider, Provider<Context> contextProvider, Provider<IBaseModelController> baseModelControllerProvider) {
        return new DataProvidesModule_ProvideCommentsControllerFactory(module, contextManagerProvider, contextProvider, baseModelControllerProvider);
    }

    public static ICommentsController provideCommentsController(DataProvidesModule instance, IUserContextManager contextManager, Context context, IBaseModelController baseModelController) {
        return (ICommentsController) Preconditions.checkNotNullFromProvides(instance.provideCommentsController(contextManager, context, baseModelController));
    }
}
