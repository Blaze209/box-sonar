package com.pspdfkit.document;

/* JADX INFO: loaded from: classes3.dex */
public enum PdfVersion {
    PDF_1_0(1, 0),
    PDF_1_1(1, 1),
    PDF_1_2(1, 2),
    PDF_1_3(1, 3),
    PDF_1_4(1, 4),
    PDF_1_5(1, 5),
    PDF_1_6(1, 6),
    PDF_1_7(1, 7);

    final int majorVersion;
    final int minorVersion;

    PdfVersion(int i, int i2) {
        this.majorVersion = i;
        this.minorVersion = i2;
    }

    public int getMajorVersion() {
        return this.majorVersion;
    }

    public int getMaxEncryptionKeyLength() {
        int i = this.minorVersion;
        if (i != 0) {
            return (i == 1 || i == 2 || i == 3) ? 40 : 128;
        }
        return 0;
    }

    public int getMinorVersion() {
        return this.minorVersion;
    }
}
