package com.box.android.preview.previewtype.document;

import com.box.android.preview.previewtype.document.search.TextSearchManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class CitationHighlightEnvironment_Factory implements Factory<CitationHighlightEnvironment> {
    private final Provider<TextSearchManager> textSearchManagerProvider;

    private CitationHighlightEnvironment_Factory(Provider<TextSearchManager> provider) {
        this.textSearchManagerProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CitationHighlightEnvironment get() {
        return newInstance(this.textSearchManagerProvider.get());
    }

    public static CitationHighlightEnvironment_Factory create(Provider<TextSearchManager> provider) {
        return new CitationHighlightEnvironment_Factory(provider);
    }

    public static CitationHighlightEnvironment newInstance(TextSearchManager textSearchManager) {
        return new CitationHighlightEnvironment(textSearchManager);
    }
}
