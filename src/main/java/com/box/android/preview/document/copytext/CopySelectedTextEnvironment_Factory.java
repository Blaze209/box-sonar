package com.box.android.preview.document.copytext;

import com.box.android.base.cpl.IClipboardService;
import com.box.android.preview.previewtype.document.copytext.TextSelectionManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class CopySelectedTextEnvironment_Factory implements Factory<CopySelectedTextEnvironment> {
    private final Provider<IClipboardService> clipboardServiceProvider;
    private final Provider<TextSelectionManager> textSelectionManagerProvider;

    private CopySelectedTextEnvironment_Factory(Provider<IClipboardService> provider, Provider<TextSelectionManager> provider2) {
        this.clipboardServiceProvider = provider;
        this.textSelectionManagerProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CopySelectedTextEnvironment get() {
        return newInstance(this.clipboardServiceProvider.get(), this.textSelectionManagerProvider.get());
    }

    public static CopySelectedTextEnvironment_Factory create(Provider<IClipboardService> provider, Provider<TextSelectionManager> provider2) {
        return new CopySelectedTextEnvironment_Factory(provider, provider2);
    }

    public static CopySelectedTextEnvironment newInstance(IClipboardService iClipboardService, TextSelectionManager textSelectionManager) {
        return new CopySelectedTextEnvironment(iClipboardService, textSelectionManager);
    }
}
