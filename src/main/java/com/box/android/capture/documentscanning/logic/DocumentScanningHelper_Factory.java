package com.box.android.capture.documentscanning.logic;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes10.dex */
public final class DocumentScanningHelper_Factory implements Factory<DocumentScanningHelper> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public DocumentScanningHelper get() {
        return newInstance();
    }

    public static DocumentScanningHelper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DocumentScanningHelper newInstance() {
        return new DocumentScanningHelper();
    }

    private static final class InstanceHolder {
        static final DocumentScanningHelper_Factory INSTANCE = new DocumentScanningHelper_Factory();

        private InstanceHolder() {
        }
    }
}
