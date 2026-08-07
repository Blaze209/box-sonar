package com.geniusscansdk.core;

/* JADX INFO: loaded from: classes13.dex */
class LegacyDocumentDetector extends DocumentDetector {
    private static native long createLegacyDetector();

    private static native void deleteLegacyDetector(long j);

    public LegacyDocumentDetector() {
        this.nativeHandle = createLegacyDetector();
    }

    @Override // com.geniusscansdk.core.DocumentDetector
    protected void finalize() {
        super.finalize();
        deleteLegacyDetector(this.nativeHandle);
    }
}
