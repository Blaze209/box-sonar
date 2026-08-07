package com.geniusscansdk.pdf;

/* JADX INFO: loaded from: classes13.dex */
final class JNIPDFGeneratorConfiguration {
    final boolean debug;
    final String fontPath;
    final String iccProfilePath;

    public JNIPDFGeneratorConfiguration(String str, String str2, boolean z) {
        this.fontPath = str;
        this.iccProfilePath = str2;
        this.debug = z;
    }

    public String getFontPath() {
        return this.fontPath;
    }

    public String getIccProfilePath() {
        return this.iccProfilePath;
    }

    public boolean getDebug() {
        return this.debug;
    }

    public String toString() {
        return "JNIPDFGeneratorConfiguration{fontPath=" + this.fontPath + ",iccProfilePath=" + this.iccProfilePath + ",debug=" + this.debug + "}";
    }
}
