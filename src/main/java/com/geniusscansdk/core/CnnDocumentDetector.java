package com.geniusscansdk.core;

import android.content.Context;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;

/* JADX INFO: loaded from: classes13.dex */
class CnnDocumentDetector extends DocumentDetector {
    private ByteBuffer backboneModelBuffer;
    private ByteBuffer headModelBuffer;
    private ByteBuffer refineModelBuffer;

    private static native long createCnnDetector(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i);

    private static native void deleteCnnDetector(long j);

    CnnDocumentDetector(Context context, DocumentDetector.Mode mode) throws IOException {
        this.backboneModelBuffer = ModelLoader.load(context, "backbone.png");
        this.headModelBuffer = ModelLoader.load(context, "head_classif.png");
        MappedByteBuffer mappedByteBufferLoad = ModelLoader.load(context, "refineBorder.png");
        this.refineModelBuffer = mappedByteBufferLoad;
        this.nativeHandle = createCnnDetector(this.backboneModelBuffer, this.headModelBuffer, mappedByteBufferLoad, mode.ordinal());
    }

    @Override // com.geniusscansdk.core.DocumentDetector
    protected void finalize() {
        super.finalize();
        deleteCnnDetector(this.nativeHandle);
        this.backboneModelBuffer = null;
        this.headModelBuffer = null;
        this.refineModelBuffer = null;
    }
}
