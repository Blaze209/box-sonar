package com.geniusscansdk.camera.realtime;

import com.geniusscansdk.core.DocumentDetector;
import com.geniusscansdk.core.QuadStreamAnalyzer;

/* JADX INFO: loaded from: classes13.dex */
public class BorderDetector implements BorderDetectionThreadManager.BorderDetectionCallback {
    private DocumentDetector documentDetector;
    private boolean enabled = false;
    private BorderDetectorListener listener;

    public interface BorderDetectorListener {
        void onBorderDetectionFailure(Exception exc);

        void onBorderDetectionResult(QuadStreamAnalyzer.Result result);
    }

    public BorderDetector(DocumentDetector documentDetector) {
        this.documentDetector = documentDetector;
    }

    public void setEnabled(boolean z) {
        if (this.enabled == z) {
            return;
        }
        this.enabled = z;
        if (z) {
            QuadStreamAnalyzer.initQuadrangleAnalyzer();
        }
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setDocumentDetector(DocumentDetector documentDetector) {
        this.documentDetector = documentDetector;
    }

    public void reset() {
        QuadStreamAnalyzer.initQuadrangleAnalyzer();
    }

    public void setAutoTriggerListener(BorderDetectorListener borderDetectorListener) {
        this.listener = borderDetectorListener;
    }

    public void removeListener() {
        this.listener = null;
        BorderDetectionThreadManager.getInstance().setCallback(null);
    }

    public void onPreviewFrame(byte[] bArr, int i, int i2, int i3, int i4) {
        if (this.enabled) {
            if (i4 != 17) {
                throw new RuntimeException("Incorrect preview format: " + i4);
            }
            BorderDetectionThreadManager.getInstance().setCallback(this);
            BorderDetectionThreadManager.processPicture(bArr, i, i2, i3, this.documentDetector);
        }
    }

    @Override // com.geniusscansdk.camera.realtime.BorderDetectionThreadManager.BorderDetectionCallback
    public void onBorderDetectionFinished(QuadStreamAnalyzer.Result result) {
        BorderDetectorListener borderDetectorListener = this.listener;
        if (borderDetectorListener != null) {
            borderDetectorListener.onBorderDetectionResult(result);
        }
    }

    @Override // com.geniusscansdk.camera.realtime.BorderDetectionThreadManager.BorderDetectionCallback
    public void onBorderDetectionFailed(Exception exc) {
        BorderDetectorListener borderDetectorListener = this.listener;
        if (borderDetectorListener != null) {
            borderDetectorListener.onBorderDetectionFailure(exc);
        }
    }
}
