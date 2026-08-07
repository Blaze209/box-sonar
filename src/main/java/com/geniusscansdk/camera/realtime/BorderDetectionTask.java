package com.geniusscansdk.camera.realtime;

import com.geniusscansdk.core.DocumentDetector;
import com.geniusscansdk.core.LicenseException;
import com.geniusscansdk.core.ProcessingException;
import com.geniusscansdk.core.QuadStreamAnalyzer;

/* JADX INFO: loaded from: classes13.dex */
class BorderDetectionTask implements Runnable {
    private static final String TAG = "BorderDetectionTask";
    private DocumentDetector documentDetector;
    private byte[] imageBuffer;
    private int imageHeight;
    private int imageStride;
    private int imageWidth;
    private QuadStreamAnalyzer.Result analyzeResult = null;
    private Exception error = null;

    public BorderDetectionTask(byte[] bArr, int i, int i2, int i3, DocumentDetector documentDetector) {
        this.imageBuffer = bArr;
        this.imageWidth = i;
        this.imageHeight = i2;
        this.imageStride = i3;
        this.documentDetector = documentDetector;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.analyzeResult = QuadStreamAnalyzer.analyzeQuadStream(this.documentDetector.detectDocument(this.imageBuffer, this.imageWidth, this.imageHeight, this.imageStride));
        } catch (LicenseException | ProcessingException e) {
            this.error = e;
        }
        BorderDetectionThreadManager.getInstance().endTask(this);
    }

    QuadStreamAnalyzer.Result getResult() {
        return this.analyzeResult;
    }

    public Exception getError() {
        return this.error;
    }
}
