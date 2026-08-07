package com.box.android.preview.previewtype.document.search;

import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class DocumentSearchEnvironment_Factory implements Factory<DocumentSearchEnvironment> {
    private final Provider<TextSearchManager> textSearchManagerProvider;

    private DocumentSearchEnvironment_Factory(Provider<TextSearchManager> provider) {
        this.textSearchManagerProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public DocumentSearchEnvironment get() {
        return newInstance(this.textSearchManagerProvider.get());
    }

    public static DocumentSearchEnvironment_Factory create(Provider<TextSearchManager> provider) {
        return new DocumentSearchEnvironment_Factory(provider);
    }

    public static DocumentSearchEnvironment newInstance(TextSearchManager textSearchManager) {
        return new DocumentSearchEnvironment(textSearchManager);
    }
}
