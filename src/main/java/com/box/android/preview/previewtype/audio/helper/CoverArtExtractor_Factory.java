package com.box.android.preview.previewtype.audio.helper;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes12.dex */
public final class CoverArtExtractor_Factory implements Factory<CoverArtExtractor> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CoverArtExtractor get() {
        return newInstance();
    }

    public static CoverArtExtractor_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static CoverArtExtractor newInstance() {
        return new CoverArtExtractor();
    }

    private static final class InstanceHolder {
        static final CoverArtExtractor_Factory INSTANCE = new CoverArtExtractor_Factory();

        private InstanceHolder() {
        }
    }
}
