package com.box.android.preview.fileactions.copylink;

import com.box.android.base.cpl.IClipboardService;
import com.box.android.domain.services.ISharedLinkService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class CopyLinkEnvironment_Factory implements Factory<CopyLinkEnvironment> {
    private final Provider<IClipboardService> clipboardServiceProvider;
    private final Provider<ISharedLinkService> sharedLinkServiceProvider;

    private CopyLinkEnvironment_Factory(Provider<IClipboardService> provider, Provider<ISharedLinkService> provider2) {
        this.clipboardServiceProvider = provider;
        this.sharedLinkServiceProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CopyLinkEnvironment get() {
        return newInstance(this.clipboardServiceProvider.get(), this.sharedLinkServiceProvider.get());
    }

    public static CopyLinkEnvironment_Factory create(Provider<IClipboardService> provider, Provider<ISharedLinkService> provider2) {
        return new CopyLinkEnvironment_Factory(provider, provider2);
    }

    public static CopyLinkEnvironment newInstance(IClipboardService iClipboardService, ISharedLinkService iSharedLinkService) {
        return new CopyLinkEnvironment(iClipboardService, iSharedLinkService);
    }
}
