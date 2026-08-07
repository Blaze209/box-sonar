package com.box.android.data.controller.impl;

import com.box.android.domain.services.IdMappingService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class CommentControllerBridge_Factory implements Factory<CommentControllerBridge> {
    private final Provider<IdMappingService> idMappingServiceProvider;
    private final Provider<LegacyCommentsController> legacyCommentsControllerProvider;

    private CommentControllerBridge_Factory(Provider<LegacyCommentsController> legacyCommentsControllerProvider, Provider<IdMappingService> idMappingServiceProvider) {
        this.legacyCommentsControllerProvider = legacyCommentsControllerProvider;
        this.idMappingServiceProvider = idMappingServiceProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CommentControllerBridge get() {
        return newInstance(this.legacyCommentsControllerProvider.get(), this.idMappingServiceProvider.get());
    }

    public static CommentControllerBridge_Factory create(Provider<LegacyCommentsController> legacyCommentsControllerProvider, Provider<IdMappingService> idMappingServiceProvider) {
        return new CommentControllerBridge_Factory(legacyCommentsControllerProvider, idMappingServiceProvider);
    }

    public static CommentControllerBridge newInstance(LegacyCommentsController legacyCommentsController, IdMappingService idMappingService) {
        return new CommentControllerBridge(legacyCommentsController, idMappingService);
    }
}
