package com.box.android.base.presentation.components.commentbar.mentions;

import com.box.android.domain.controller.ICommentControllerBridge;
import com.box.android.domain.metrics.Gen204FileActivityEventLogger;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class CollaboratorsMentionsEnvironment_Factory implements Factory<CollaboratorsMentionsEnvironment> {
    private final Provider<ICommentControllerBridge> commentControllerBridgeProvider;
    private final Provider<Gen204FileActivityEventLogger> fileActivityEventLoggerProvider;

    private CollaboratorsMentionsEnvironment_Factory(Provider<Gen204FileActivityEventLogger> provider, Provider<ICommentControllerBridge> provider2) {
        this.fileActivityEventLoggerProvider = provider;
        this.commentControllerBridgeProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CollaboratorsMentionsEnvironment get() {
        return newInstance(this.fileActivityEventLoggerProvider.get(), this.commentControllerBridgeProvider.get());
    }

    public static CollaboratorsMentionsEnvironment_Factory create(Provider<Gen204FileActivityEventLogger> provider, Provider<ICommentControllerBridge> provider2) {
        return new CollaboratorsMentionsEnvironment_Factory(provider, provider2);
    }

    public static CollaboratorsMentionsEnvironment newInstance(Gen204FileActivityEventLogger gen204FileActivityEventLogger, ICommentControllerBridge iCommentControllerBridge) {
        return new CollaboratorsMentionsEnvironment(gen204FileActivityEventLogger, iCommentControllerBridge);
    }
}
