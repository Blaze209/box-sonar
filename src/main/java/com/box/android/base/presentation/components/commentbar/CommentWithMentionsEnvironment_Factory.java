package com.box.android.base.presentation.components.commentbar;

import com.box.android.base.presentation.components.commentbar.mentions.CollaboratorsMentionsEnvironment;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class CommentWithMentionsEnvironment_Factory implements Factory<CommentWithMentionsEnvironment> {
    private final Provider<CollaboratorsMentionsEnvironment> collaboratorsEnvironmentProvider;

    private CommentWithMentionsEnvironment_Factory(Provider<CollaboratorsMentionsEnvironment> provider) {
        this.collaboratorsEnvironmentProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CommentWithMentionsEnvironment get() {
        return newInstance(this.collaboratorsEnvironmentProvider.get());
    }

    public static CommentWithMentionsEnvironment_Factory create(Provider<CollaboratorsMentionsEnvironment> provider) {
        return new CommentWithMentionsEnvironment_Factory(provider);
    }

    public static CommentWithMentionsEnvironment newInstance(CollaboratorsMentionsEnvironment collaboratorsMentionsEnvironment) {
        return new CommentWithMentionsEnvironment(collaboratorsMentionsEnvironment);
    }
}
