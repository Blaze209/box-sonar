package com.geniusscansdk.ocr;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes13.dex */
final class JNIOCREngineConfiguration {
    final ArrayList<String> languages;
    final String tessdataPath;

    public JNIOCREngineConfiguration(ArrayList<String> arrayList, String str) {
        this.languages = arrayList;
        this.tessdataPath = str;
    }

    public ArrayList<String> getLanguages() {
        return this.languages;
    }

    public String getTessdataPath() {
        return this.tessdataPath;
    }

    public String toString() {
        return "JNIOCREngineConfiguration{languages=" + this.languages + ",tessdataPath=" + this.tessdataPath + "}";
    }
}
