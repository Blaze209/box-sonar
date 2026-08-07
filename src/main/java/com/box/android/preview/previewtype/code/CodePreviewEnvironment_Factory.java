package com.box.android.preview.previewtype.code;

import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class CodePreviewEnvironment_Factory implements Factory<CodePreviewEnvironment> {
    private final Provider<CodeFileReader> codeFileReaderProvider;

    private CodePreviewEnvironment_Factory(Provider<CodeFileReader> provider) {
        this.codeFileReaderProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CodePreviewEnvironment get() {
        return newInstance(this.codeFileReaderProvider.get());
    }

    public static CodePreviewEnvironment_Factory create(Provider<CodeFileReader> provider) {
        return new CodePreviewEnvironment_Factory(provider);
    }

    public static CodePreviewEnvironment newInstance(CodeFileReader codeFileReader) {
        return new CodePreviewEnvironment(codeFileReader);
    }
}
