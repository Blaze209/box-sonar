package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeTextParserResult {
    final NativeTextParserError mError;
    final NativeTextParser mTextParser;

    public NativeTextParserResult(NativeTextParser nativeTextParser, NativeTextParserError nativeTextParserError) {
        this.mTextParser = nativeTextParser;
        this.mError = nativeTextParserError;
    }

    public NativeTextParserError getError() {
        return this.mError;
    }

    public NativeTextParser getTextParser() {
        return this.mTextParser;
    }

    public String toString() {
        return "NativeTextParserResult{mTextParser=" + this.mTextParser + ",mError=" + this.mError + "}";
    }
}
