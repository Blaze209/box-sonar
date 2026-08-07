package org.tinylog.path;

import java.io.File;
import org.tinylog.runtime.Timestamp;

/* JADX INFO: loaded from: classes5.dex */
final class CountSegment implements Segment {
    @Override // org.tinylog.path.Segment
    public String getStaticText() {
        return null;
    }

    CountSegment() {
    }

    @Override // org.tinylog.path.Segment
    public String createToken(String str, Timestamp timestamp) {
        File absoluteFile;
        String[] list;
        Long digits;
        int iMax = Math.max(str.lastIndexOf(File.separatorChar), str.lastIndexOf(47));
        if (iMax == -1) {
            absoluteFile = new File("").getAbsoluteFile();
        } else {
            File file = new File(str.substring(0, iMax));
            str = iMax == str.length() + (-1) ? "" : str.substring(iMax + 1);
            absoluteFile = file;
        }
        long jLongValue = 0;
        if (absoluteFile.isDirectory() && (list = absoluteFile.list()) != null) {
            for (String str2 : list) {
                if (str2.startsWith(str) && (digits = parseDigits(str2, str.length())) != null && digits.longValue() + 1 > jLongValue) {
                    jLongValue = digits.longValue() + 1;
                }
            }
        }
        return Long.toString(jLongValue);
    }

    @Override // org.tinylog.path.Segment
    public boolean validateToken(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    private static Long parseDigits(String str, int i) {
        for (int i2 = i; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt < '0' || cCharAt > '9') {
                return parseLong(str.substring(i, i2));
            }
        }
        return parseLong(str.substring(i));
    }

    private static Long parseLong(String str) {
        if (str.length() == 0) {
            return null;
        }
        try {
            return Long.valueOf(Long.parseLong(str));
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}
