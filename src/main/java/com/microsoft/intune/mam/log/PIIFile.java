package com.microsoft.intune.mam.log;

import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public class PIIFile implements PIIObj {
    public static final String NULL_FILE = "<null file>";
    private String mStringNoPII;
    private String mStringWithPII;

    public PIIFile(String str) {
        if (str == null) {
            this.mStringWithPII = NULL_FILE;
            this.mStringNoPII = NULL_FILE;
        } else {
            this.mStringWithPII = str;
            this.mStringNoPII = "" + this.mStringWithPII.hashCode();
        }
    }

    public PIIFile(File file) {
        this(file.getAbsolutePath());
    }

    public PIIFile(File file, String str) {
        this(file.getAbsolutePath(), str);
    }

    public PIIFile(String str, String str2) {
        if (str == null) {
            this.mStringWithPII = NULL_FILE;
            this.mStringNoPII = NULL_FILE;
        } else {
            this.mStringWithPII = str;
            this.mStringNoPII = str2;
        }
    }

    @Override // com.microsoft.intune.mam.log.PIIObj
    public String toString() {
        return this.mStringNoPII;
    }

    @Override // com.microsoft.intune.mam.log.PIIObj
    public String toStringPIIfull() {
        return this.mStringWithPII;
    }
}
