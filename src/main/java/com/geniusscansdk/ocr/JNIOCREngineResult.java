package com.geniusscansdk.ocr;

import com.geniusscansdk.core.JNITextLayout;

/* JADX INFO: loaded from: classes13.dex */
final class JNIOCREngineResult {
    final JNIOCREngineError status;
    final String text;
    final JNITextLayout textLayout;

    public JNIOCREngineResult(JNIOCREngineError jNIOCREngineError, String str, JNITextLayout jNITextLayout) {
        this.status = jNIOCREngineError;
        this.text = str;
        this.textLayout = jNITextLayout;
    }

    public JNIOCREngineError getStatus() {
        return this.status;
    }

    public String getText() {
        return this.text;
    }

    public JNITextLayout getTextLayout() {
        return this.textLayout;
    }

    public String toString() {
        return "JNIOCREngineResult{status=" + this.status + ",text=" + this.text + ",textLayout=" + this.textLayout + "}";
    }
}
