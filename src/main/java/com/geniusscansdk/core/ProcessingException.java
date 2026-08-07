package com.geniusscansdk.core;

/* JADX INFO: loaded from: classes13.dex */
public class ProcessingException extends Exception {
    public ProcessingException() {
        this("Error during processing. See logs for more details.");
    }

    public ProcessingException(String str) {
        super(str);
    }
}
