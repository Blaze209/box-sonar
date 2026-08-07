package com.box.android.preview.previewtype.boxnote;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes12.dex */
public final class BoxNoteRequestBuilder_Factory implements Factory<BoxNoteRequestBuilder> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxNoteRequestBuilder get() {
        return newInstance();
    }

    public static BoxNoteRequestBuilder_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static BoxNoteRequestBuilder newInstance() {
        return new BoxNoteRequestBuilder();
    }

    private static final class InstanceHolder {
        static final BoxNoteRequestBuilder_Factory INSTANCE = new BoxNoteRequestBuilder_Factory();

        private InstanceHolder() {
        }
    }
}
