package com.box.android.preview.previewtype.boxnote;

import com.box.android.base.cpl.IClipboardService;
import com.box.android.domain.identity.IUserContextManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class BoxNoteEditModeEnvironment_Factory implements Factory<BoxNoteEditModeEnvironment> {
    private final Provider<IClipboardService> clipboardServiceProvider;
    private final Provider<BoxNoteRequestBuilder> requestBuilderProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private BoxNoteEditModeEnvironment_Factory(Provider<BoxNoteRequestBuilder> provider, Provider<IClipboardService> provider2, Provider<IUserContextManager> provider3) {
        this.requestBuilderProvider = provider;
        this.clipboardServiceProvider = provider2;
        this.userContextManagerProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxNoteEditModeEnvironment get() {
        return newInstance(this.requestBuilderProvider.get(), this.clipboardServiceProvider.get(), this.userContextManagerProvider.get());
    }

    public static BoxNoteEditModeEnvironment_Factory create(Provider<BoxNoteRequestBuilder> provider, Provider<IClipboardService> provider2, Provider<IUserContextManager> provider3) {
        return new BoxNoteEditModeEnvironment_Factory(provider, provider2, provider3);
    }

    public static BoxNoteEditModeEnvironment newInstance(BoxNoteRequestBuilder boxNoteRequestBuilder, IClipboardService iClipboardService, IUserContextManager iUserContextManager) {
        return new BoxNoteEditModeEnvironment(boxNoteRequestBuilder, iClipboardService, iUserContextManager);
    }
}
